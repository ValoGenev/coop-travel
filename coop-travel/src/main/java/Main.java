
import org.openqa.selenium.chrome.ChromeDriver;
import processor.BotNavigationService;
import config.CustomChromeDriver;
import config.ExecutorConfiguration;

import static utils.Constants.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        CustomChromeDriver customChromeDriver = new CustomChromeDriver();

        ChromeDriver chromeDriver = customChromeDriver.getChromeDriver();

        ExecutorConfiguration configuration = new ExecutorConfiguration(GROUPS);

        BotNavigationService navigation = new BotNavigationService(chromeDriver);

        navigation.openFaceBook();
        navigation.loginToFacebook();

        navigation.prepareExecutor(new ExecutorConfiguration(GROUPS)).startScanning();











    }
}

//        Runnable myRunnable = () -> {
//            CustomChromeDriver customChromeDriver1 = new CustomChromeDriver();
//
//            ChromeDriver chromeDriver1 = customChromeDriver1.getChromeDriver();
//
//            BotExecutorService executor1 = new BotExecutorService(chromeDriver1,GROUP_2_URL,GROUP_2_NAME);
//
//            executor1.openFaceBook();
//            try {
//                executor1.loginToFacebook();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            executor1.navigateToGroup();
//            try {
//                executor1.startScanning();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        };
//
//
//        Thread myThread = new Thread(myRunnable);
//        myThread.start();