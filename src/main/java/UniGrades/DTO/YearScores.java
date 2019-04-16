package UniGrades.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class YearScores {
    private String year;
    private double weight;
    private double score;
}
