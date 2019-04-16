package UniGrades.Controllers;

import UniGrades.Services.TwitterService;
import UniGrades.tools.uriShortener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {


    private TwitterService twitterService;

    @Autowired
    public HomeController(TwitterService twitterService) {
        this.twitterService = twitterService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getHomePage(Model model, HttpSession session){

        try {
            String test= twitterService.getURI();
            System.out.println(test);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "webpage/home";
    }


}
