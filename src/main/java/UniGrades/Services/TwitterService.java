package UniGrades.Services;

import java.io.IOException;

public interface TwitterService {
    String getTweet();
    void performTweet(String tweet);
    String getURI();
}
