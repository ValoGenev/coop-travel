package processor;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import config.ExecutorConfiguration;
import model.Group;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.*;
import static utils.Constants.*;

public class BotExecutorService {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    private final ChromeDriver chromeDriver;
    private final BotValidationService validationService;
    private final BotProcessingService processingService;
    private final ExecutorConfiguration config;


    public BotExecutorService(ChromeDriver chromeDriver, ExecutorConfiguration config) {
        this.chromeDriver = chromeDriver;
        validationService = new BotValidationService();
        processingService = new BotProcessingService();
        this.config = config;
    }


    public void navigateToGroup(String groupName,String groupUrl){
        LOGGER.info(format(OPEN_FACEBOOK_GROUP_MESSAGE,groupName));

        if(!groupUrl.endsWith(URL_EXTENSION_FOR_CHRONOLOGICAL)){
            groupUrl += URL_EXTENSION_FOR_CHRONOLOGICAL;
        }

        chromeDriver.navigate().to(groupUrl);
    }


    public void startScanning() throws InterruptedException {


        List<Group> fbGroups = config.getFbGroups();
        String groupsPerThread = config.getNumberOfGroupsPerThread();
        String refreshTime = config.getRefreshTime();
        String timeForSwitchingPages = config.getTimeForSwitchingPages();


        while (true) {


            for (Group fbGroup : fbGroups) {
                navigateToGroup(fbGroup.getName(),fbGroup.getUrl());
                Thread.sleep(2000);

                List<WebElement> userNames = getUserNames();
                List<WebElement> statusText = getStatusText();
                List<WebElement> statusPic = getStatusPic();
                List<String> userProfiles = getUsersProfile();
                List<WebElement> statuses = getStatuses();

                if(statuses.size()==0) continue;

                fbGroup.setLastStatusPic(process(fbGroup.getLastStatusPic(), statusPic.size()==0, userNames, statusPic, userProfiles, statuses));

                fbGroup.setLastStatusText(process(fbGroup.getLastStatusText(), statusText.size()==0, userNames, statusText, userProfiles, statuses));

            }


        }
    }

    private String process(String lastStatus, boolean skipStatus, List<WebElement> userNames, List<WebElement> statusTextOrPic, List<String> userProfiles, List<WebElement> statuses) {

        String currentUserName;
        String currentStatus;
        String currentUserProfile;

        if (!skipStatus) {

            currentUserName = userNames.get(0).getText();
            currentStatus = statusTextOrPic.get(0).getText();
            currentUserProfile = userProfiles.get(0);

            if(validationService.assertFirstStatusIsTextOrPicStatus(statuses.get(0).getText(),currentStatus)){

                if (lastStatus==null || !validationService.assertEqualNames(currentStatus,lastStatus)) {
                    lastStatus = currentStatus;
                    processingService.processFurther(currentUserProfile,currentUserName,currentStatus,getCurrentTime());
                }
            }
        }
        return lastStatus;
    }


    private List<String> getUsersProfile() {
        return chromeDriver
                .findElementsByXPath(XPATH_TO_USERNAMES)
                .stream()
                .map(name->name.getAttribute(HREF_ATTRIBUTE))
                .collect(Collectors.toList());
    }

    private List<WebElement> getUserNames(){
        return chromeDriver.findElementsByXPath(XPATH_TO_USERNAMES);
    }

    private  List<WebElement> getStatusText(){
        return chromeDriver.findElementsByXPath(XPATH_TO_STATUSES_TEXT);
    }

    private  List<WebElement> getStatusPic(){
        return chromeDriver.findElementsByXPath(XPATH_TO_STATUSES_PIC);
    }

    private List<WebElement> getStatuses(){
        return chromeDriver.findElementsByXPath(XPATH_TO_WHOLE_STATUS);
    }
}
