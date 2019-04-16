package UniGrades.Controllers;

import UniGrades.Services.CalculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.regex.Pattern;

@Controller
public class ResultController {

    private CalculateService calculateService;
    @Autowired
    public ResultController(CalculateService calculateService) {
        this.calculateService = calculateService;
    }

    @RequestMapping(value = "/qualification/uni_gb/{grade}/{length}/{currentYear}/{yearScores}/{moduleCurrent}/{moduleDone}/{moduleFut:.+}", method = RequestMethod.GET)
    public String getAddModuleDone(Model model, HttpSession session, @PathVariable("grade") String grade, @PathVariable("length") String length
            , @PathVariable("currentYear") String currentYear, @PathVariable("yearScores") String yearScores ,  @PathVariable("moduleCurrent") String moduleCurrent,  @PathVariable("moduleDone") String moduleDone,  @PathVariable("moduleFut") String moduleFut){

        System.out.println(grade);
        System.out.println(length);
        System.out.println(currentYear);
        System.out.println(yearScores);
        System.out.println(moduleCurrent);
        System.out.println(moduleDone);
        System.out.println(moduleFut);

        String[] modDone = moduleDone.split(Pattern.quote("$"));
        String[] modCurrent = moduleCurrent.split(Pattern.quote("$"));
        String[] modFut = moduleFut.split(Pattern.quote("$"));

        for (String mod : modDone){
            System.out.println(mod);
        }
        for (String mod : modCurrent){
            System.out.println(mod);
        }
        for (String mod : modFut){
            System.out.println(mod);
        }
        model.addAttribute("gradeDesired",calculateService.getGradePercent(grade));
        model.addAttribute("gradeString",grade);
        model.addAttribute("length",length);
        model.addAttribute("yearScores",calculateService.getYearScores(yearScores));
        model.addAttribute("currentYear",currentYear);
        model.addAttribute("scores",calculateService.getCurrentYearMark(modDone,modCurrent,modFut));
        model.addAttribute("modules",calculateService.getModuleBreakdown(modDone,modCurrent,modFut));
        model.addAttribute("avMark",calculateService.getAvMarkNeeded(grade,modDone,modCurrent,modFut));

        return "webpage/gb_result";
    }


}
