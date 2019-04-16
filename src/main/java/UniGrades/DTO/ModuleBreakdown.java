package UniGrades.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModuleBreakdown {

    private String name;
    private double currentScore;
    private double weightCompleted;
    private double weight;
    private List<Exam> examList;
}
