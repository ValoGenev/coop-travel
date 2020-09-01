package processor;

public class BotProcessingService {



    public BotProcessingService() {

    }

    public void processFurther(String linkToProfile,String userName,String status,String timePosted){

        System.out.println("Username : " + userName);
        System.out.println("Link to profile : "+ linkToProfile);
        System.out.println("Posted : "+ timePosted);
        System.out.println(status);

        System.out.println("------------------------------------");

    }
}
