package UniGrades.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Exam {

    private String name;
    private String taken;
    private double score;
    private double exWeight;
    private double contribution;
}
