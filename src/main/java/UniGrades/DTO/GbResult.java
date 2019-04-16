package UniGrades.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GbResult {

    private double score;
    private double weightProvided;
    private double marksLost;
    private double marksAvailable;
}
