package UniGrades.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class TemplateController {

    @RequestMapping(value = "/template/add-module-done", method = RequestMethod.GET)
    public String getAddModuleDone(Model model, HttpSession session){


        return "fragments :: add-module-done";
    }

    @RequestMapping(value = "/template/add-module-current", method = RequestMethod.GET)
    public String getAddModuleCurrent(Model model, HttpSession session){


        return "fragments :: add-module-current";
    }

    @RequestMapping(value = "/template/add-module-future", method = RequestMethod.GET)
    public String getAddModuleFuture(Model model, HttpSession session){


        return "fragments :: add-module-future";
    }

    @RequestMapping(value = "/template/add-exam", method = RequestMethod.GET)
    public String getAddExam(Model model, HttpSession session){


        return "fragments :: add-exam";
    }

}
