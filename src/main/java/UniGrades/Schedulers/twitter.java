//package UniGrades.Schedulers;
//
//import UniGrades.Services.TwitterService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//import twitter4j.Status;
//import twitter4j.Twitter;
//import twitter4j.TwitterException;
//import twitter4j.TwitterFactory;
//import twitter4j.auth.AccessToken;
//import twitter4j.auth.OAuthAuthorization;
//import twitter4j.conf.ConfigurationBuilder;
//import twitter4j.conf.ConfigurationContext;
//
//@Component
//public class twitter {
//    private TwitterService twitterService;
//
//    @Autowired
//    public twitter(TwitterService twitterService) {
//        this.twitterService = twitterService;
//    }
//
//
//    @Scheduled(cron="10 * * * * *")
//    public void tweetAd() {
//        try {
//
////            String tweet = twitterService.getTweet();
////            twitterService.performTweet(tweet);
//        } catch (Exception e){
//
//        }
//    }
//
//
//}