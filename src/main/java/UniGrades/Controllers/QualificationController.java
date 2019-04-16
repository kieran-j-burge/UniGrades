package UniGrades.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class QualificationController {

    @RequestMapping(value = "/qualification/uni_gb", method = RequestMethod.GET)
    public String getHomePage(Model model, HttpSession session){

//        model.addAttribute("test","hello");

        return "webpage/uni_gb";
    }

}
