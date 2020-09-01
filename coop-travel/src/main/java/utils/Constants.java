package utils;

import model.Group;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Constants {

    public static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");


    public static final String URL_EXTENSION_FOR_CHRONOLOGICAL="?sorting_setting=CHRONOLOGICAL";

    public static final String CHROME_DRIVER = "webdriver.chrome.driver";
    public static final String PATH_TO_CHROME_DRIVER="C:\\Users\\valo_\\Desktop\\coop-travel\\chromedriver.exe";
    public static final String FACEBOOK_URL="http://facebook.com";
    public static final String EMAIL = "valo_genev@abv.bg";
    public static final String PASS = "jonatan1999";
    public static final String XPATH_TO_LOGIN_ELEMENT="//button[@name=\"login\"]";
    public static final String XPATH_TO_EMAIL_ELEMENT="email";
    public static final String XPATH_TO_PASS_ELEMENT ="pass";
    public static final String XPATH_TO_USERNAMES = "//a[@class=\"oajrlxb2 g5ia77u1 qu0x051f esr5mh6w e9989ue4 r7d6kgcz rq0escxv nhd2j8a9 nc684nl6 p7hjln8o kvgmc6g5 cxmmr5t8 oygrvhab hcukyx3x jb3vyjys rz4wbd8a qt6c0cv9 a8nywdso i1ao9s8h esuyzwwr f1sip0of lzcic4wl oo9gr5id gpro0wi8 lrazzd5p\"\n]";
    public static final String XPATH_TO_STATUSES_TEXT="//div[@class=\"kvgmc6g5 cxmmr5t8 oygrvhab hcukyx3x c1et5uql ii04i59q\"]";
    public static final String XPATH_TO_STATUSES_PIC="//div[@class=\"k4urcfbm kr520xx4 j9ispegn pmk7jnqg taijpn5t datstx6m cbu4d94t j83agx80 bp9cbjyn\"]";
    public static final String XPATH_TO_STATUSES_COMMENTS="//div[@class=\"tw6a2znq sj5x9vvc d1544ag0 cxgpxx05\"]";
    public static final String XPATH_TO_STATUSES_TIME_POSTED="//span[@class=\"oi732d6d ik7dh3pa d2edcug0 qv66sw1b c1et5uql a8c37x1j hop8lmos enqfppq2 e9vueds3 j5wam9gi knj5qynh m9osqain hzawbc8m\"]";
    public static final String XPATH_TO_WHOLE_STATUS="//div[@class=\"du4w35lb k4urcfbm l9j0dhe7 sjgh65i0\"]";
    public static final String XPATH_TO_FACEBOOK_GROUP_NAME="//span[@class=\"oi732d6d ik7dh3pa d2edcug0 hpfvmrgz qv66sw1b c1et5uql a8c37x1j irj2b8pg q9se6cdp m6dqt4wy h7mekvxk hnhda86s oo9gr5id hzawbc8m\"]";

    public static final String HREF_ATTRIBUTE="href";

    public static final String OPEN_FACEBOOK_MESSAGE="Opening www.facebook.com";
    public static final String OPEN_FACEBOOK_GROUP_MESSAGE="Opening facebook group with name %s";
    public static final String LOGIN_TO_FACEBOOK_MESSAGE="Logging to facebook with email: %s and password: %s";
    public static final String SCANNING_FACEBOOK_GROUP="Scanning facebook group with name %s";


    public static final String GROUP_1_NAME = "Пътуващи Бургас - София и обратно !";
    public static final String GROUP_1_URL = "https://www.facebook.com/groups/170166326408823";

    public static final String GROUP_2_NAME="Споделено пътуване";
    public static final String GROUP_2_URL="https://www.facebook.com/groups/spatuvane";

    public static final String GROUP_3_NAME="Споделено Пътуване-Бургас-София-Бургас";
    public static final String GROUP_3_URL="https://www.facebook.com/groups/289484305088193";

    public static final String GROUP_4_NAME="Пътуващи от Бургас до Пловдив и обратно";
    public static final String GROUP_4_URL="https://www.facebook.com/groups/1374789949448102";

    public static final String GROUP_5_NAME="ПЪТУВАЩИ СОФИЯ - БУРГАС";
    public static final String GROUP_5_URL="https://www.facebook.com/groups/2160170464204137";


    public static final List<Group> GROUPS = new ArrayList<>(Arrays.asList(
            new Group(GROUP_1_URL,GROUP_1_NAME),
            new Group(GROUP_2_URL,GROUP_2_NAME),
            new Group(GROUP_3_URL,GROUP_3_NAME),
            new Group(GROUP_4_URL,GROUP_4_NAME),
            new Group(GROUP_5_URL,GROUP_5_NAME)
    ));



    public static String getCurrentTime(){
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

}
