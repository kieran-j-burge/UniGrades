package UniGrades.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModDoneCurrFutPasser {
    private List<ModuleBreakdown> doneList;
    private List<ModuleBreakdown> currList;
    private List<ModuleBreakdown> futList;
}
