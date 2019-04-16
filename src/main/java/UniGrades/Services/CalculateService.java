package UniGrades.Services;

import UniGrades.DTO.GbResult;
import UniGrades.DTO.ModDoneCurrFutPasser;
import UniGrades.DTO.ModuleBreakdown;
import UniGrades.DTO.YearScores;

import java.util.List;

public interface CalculateService {
     GbResult getCurrentYearMark(String[] modDone, String[] modCurrent, String[] modFut);
     ModDoneCurrFutPasser getModuleBreakdown(String[] modDone, String[] modCurrent, String[] modFut);
     List<YearScores> getYearScores(String yearScores);
     double getGradePercent(String grade);
     double getAvMarkNeeded(String grade, String[] modDone, String[] modCurrent, String[] modFut);
}
