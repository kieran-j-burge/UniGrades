package UniGrades.Services.impl;

import UniGrades.DAO.TwitterDAO;
import UniGrades.Services.TwitterService;
import fr.plaisance.bitly.Bit;
import fr.plaisance.bitly.Bitly;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;




@Service
public class TwitterServiceImpl implements TwitterService {

    private TwitterDAO twitterDAO;
    private int bgnI=1;
    private int midI=1;
    private int endI=1;
    private String consumerKey = "YNLM7as0WQRNWHWZv2si77brY";
    private String consumerSecret = "YASpxAMnNvgBmdUwu1sh3jr2T2yLgl8YAoRwGUP7g4CQGZtXSO";
    private String accessToken = "1021015731729829889-rLzBXBuGUVJd98RMsIVDMCX9R6Di2f";
    private String accessSecret = "pbXFHy0iWdg7magldsE9spuxknGZA9h252u6cTPmbntam";

    private final String USER_AGENT = "Mozilla/5.0";

    @Autowired
    public TwitterServiceImpl(TwitterDAO twitterDAO) {
        this.twitterDAO= twitterDAO;
    }

    @Override
    public String getTweet() {
        String tweet="";

        tweet = ""+twitterDAO.getTweetBgn(bgnI)+""+twitterDAO.getTweetMid(midI)+""+twitterDAO.getTweetEnd(endI)+" ";

        if (endI >= 5){
            endI = 1;
            if (midI >= 7){
                midI = 1;
                if (bgnI>=12){
                    bgnI = 1;
                }
                else {
                    bgnI++;
                }
            }
            else{
                midI++;
            }
        }
        else{
            endI++;
        }
        System.out.println(tweet);
        return tweet;
    }

    @Override
    public void performTweet(String tweet) {

        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(consumerKey)
                .setOAuthConsumerSecret(consumerSecret)
                .setOAuthAccessToken(accessToken)
                .setOAuthAccessTokenSecret(accessSecret);
        try
        {
            TwitterFactory factory = new TwitterFactory(cb.build());
            Twitter twitter = factory.getInstance();
            twitter.updateStatus(tweet);
        }catch (TwitterException te) {
            te.printStackTrace();
            System.exit(-1);
        }
    }

    @Override
    public String getURI (){

        String access_token = "a455b8474e3ecd3619e9f1cf132dd67201b1e959";
        Bitly bitly = Bit.ly(access_token);
        String shortUrl = Bit.ly(access_token)
                .shorten("http://www.gradescalculator.co.uk/");
        System.out.println(shortUrl);
        return shortUrl;
    }



}
