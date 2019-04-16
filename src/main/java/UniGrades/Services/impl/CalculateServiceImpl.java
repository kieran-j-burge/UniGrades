package UniGrades.Services.impl;

import UniGrades.DTO.*;
import UniGrades.Services.CalculateService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.regex.Pattern;

@Service
public class CalculateServiceImpl implements CalculateService {


    @Override
    public GbResult getCurrentYearMark(String[] modDone,String[] modCurrent,String[] modFut) {
        GbResult result = modScores(modDone,modCurrent,modFut);
        return result;
    }

    @Override
    public ModDoneCurrFutPasser getModuleBreakdown(String[] modDone, String[] modCurrent, String[] modFut) {
        List<ModuleBreakdown> doneList = new ArrayList<>();
        List<ModuleBreakdown> currList = new ArrayList<>();
        List<ModuleBreakdown> futList = new ArrayList<>();

        for(String mod : modDone){
            try {
                List<Exam> doneExams = new ArrayList<>();
                String[] split = mod.split(Pattern.quote("&"));
                String name = split[0];
                double score = Double.parseDouble(split[1]);
                double weight = Double.parseDouble(split[2]);
                doneList.add(new ModuleBreakdown(name,score,100,weight,doneExams));
            }catch (IndexOutOfBoundsException e){

            }
        }

        for(String mod : modCurrent){
            List<Exam> currExam = new ArrayList<>();
            try {
                String[] split = mod.split(Pattern.quote("%"));
                String[] info = split[0].split(Pattern.quote("&"));
                String name = info[0];
                double weight = Double.parseDouble(info[1]);
                String[] exams = split[1].split(Pattern.quote("|"));
                double examScores = 0;
                double weightCompleted=0;
                for (String exam : exams){
                    String exName;
                    double exScore;
                    double exWeight;
                    double contribution;

                    String[] examData = exam.split(Pattern.quote("&"));
                    String taken = examData[2];
                    exName = examData[0];
                    exWeight = Double.parseDouble(examData[1]);
                    contribution = (exWeight * weight)/100;

                    if (taken.matches("Yes")){
                        exScore = Double.parseDouble(examData[3]);
                        System.out.println("In Yes");
                        examScores = examScores + (exScore * exWeight/100);
                        weightCompleted = weightCompleted +exWeight;
                        currExam.add(new Exam(exName,taken,exScore,exWeight,contribution));
                    }else if(taken.matches("No")){
                        System.out.println("In No");
                        currExam.add(new Exam(exName,taken,0,exWeight,contribution));
                    }
                }

                currList.add(new ModuleBreakdown(name,examScores, weightCompleted,weight,currExam));

            }catch (IndexOutOfBoundsException e){

            }

        }

        for(String mod : modFut){
            String[] modSplit = mod.split(Pattern.quote("&"));
            try {
                List<Exam> futExam = new ArrayList<>();
                futList.add(new ModuleBreakdown(modSplit[0],0,0,Double.parseDouble(modSplit[1]),futExam));
            }catch (ArrayIndexOutOfBoundsException e){

            }
        }
        ModDoneCurrFutPasser modList = new ModDoneCurrFutPasser(doneList,currList,futList);


        return modList;
    }

    @Override
    public List<YearScores> getYearScores(String yearScores) {
        List<YearScores> scores = new ArrayList<>();

        String[] years = yearScores.split(Pattern.quote("$"));
        for (String year: years){
            String[] data = year.split(Pattern.quote("&"));
            try {
                if (data[2].matches("undefined")){
                    scores.add(new YearScores(data[0],Double.parseDouble(data[1]),0));
                }
                else{
                    scores.add(new YearScores(data[0],Double.parseDouble(data[1]),Double.parseDouble(data[2])));
                }
            }catch (ArrayIndexOutOfBoundsException e){

            }catch (NumberFormatException e){

            }

        }
        return scores;
    }

    @Override
    public double getGradePercent(String grade) {
        if (grade.matches("1st")){
            return 70;
        }
        else if(grade.matches("2:1")){
            return 60;
        }
        else if(grade.matches("2:2")){
            return 50;
        }
        else if(grade.matches("3rd")){
            return 40;
        }
        else{
            return 0;
        }
    }

    @Override
    public double getAvMarkNeeded(String grade, String[] modDone, String[] modCurrent, String[] modFut) {
        double contributionLeft=0;
        double percentageGained=0;

        for(String mod : modDone){
            try {
                String[] split = mod.split(Pattern.quote("&"));
                double score = Double.parseDouble(split[1]);
                double weight = Double.parseDouble(split[2]);
                percentageGained = percentageGained + (score*weight)/100;
            }catch (IndexOutOfBoundsException e){

            }
        }

        for(String mod : modCurrent){
            try {
                String[] split = mod.split(Pattern.quote("%"));
                String[] info = split[0].split(Pattern.quote("&"));
                String name = info[0];
                double weight = Double.parseDouble(info[1]);

                String[] exams = split[1].split(Pattern.quote("|"));

                double examScores = 0;
                double weightCompleted=0;

                for (String exam : exams){
                    String[] examData = exam.split(Pattern.quote("&"));
                    double exScore;
                    double exWeight;
                    String taken = examData[2];
                    if (taken.matches("Yes")){

                        exScore = Double.parseDouble(examData[3]);
                        exWeight = Double.parseDouble(examData[1]);
                        percentageGained = percentageGained + (((exWeight * weight)/100) * exScore/100);
                    }
                    else {
                        exWeight = Double.parseDouble(examData[1]);
                        contributionLeft = contributionLeft + ((exWeight*weight)/100);
                    }
                }

            }catch (IndexOutOfBoundsException e){

            }
        }

        for(String mod : modFut){
            String[] modSplit = mod.split(Pattern.quote("&"));

            try {
                double weight = Double.parseDouble(modSplit[1]);
                contributionLeft = contributionLeft + weight;
            }catch (ArrayIndexOutOfBoundsException e){

            }
        }


        try {
            double target = getGradePercent(grade);
            double needed = (target - percentageGained)/contributionLeft;
            return Math.round(needed * 100);
        }catch (ArithmeticException e){
            return 0;

        }
    }

    private GbResult modScores(String[] modDone, String[] modCurrent, String[] modFut) {
        double totalScore=0;
        double weightProvided=0;
        double marksLost = 0;
        double marksAvailable=0;

        for(String mod : modDone){

            try {
                String[] split = mod.split(Pattern.quote("&"));
                double score = Double.parseDouble(split[1]);
                double weight = Double.parseDouble(split[2]);
                weightProvided = weightProvided + weight;
                totalScore = totalScore + (score * (weight/100));
                marksLost = marksLost + ((100 - score) * (weight/100));
            }catch (IndexOutOfBoundsException e){

            }catch (NumberFormatException e){

            }

        }



        for(String mod : modCurrent){
            try {
                String[] split = mod.split(Pattern.quote("%"));
                String[] info = split[0].split(Pattern.quote("&"));
                double weight = Double.parseDouble(info[1]);
                String[] exams = split[1].split(Pattern.quote("|"));

                double examScores = 0;
                double examScoresLost=0;
                double examScoresAvailable=0;
                for (String exam : exams){
                    String[] examData = exam.split(Pattern.quote("&"));
                    double exScore;
                    double exWeight;
                    String taken = examData[2];
                    if (taken.matches("Yes")){
                        exScore = Double.parseDouble(examData[3]);
                        exWeight = Double.parseDouble(examData[1]);
                        examScores = examScores + (exScore * exWeight/100);
                        examScoresLost = examScoresLost + ((100 - exScore) * exWeight/100);
                    }
                    else {
                        exWeight = Double.parseDouble(examData[1]);
                        examScoresAvailable = examScoresAvailable + (100 * (exWeight/100));
                    }
                }
                weightProvided = weightProvided + weight;
                totalScore = totalScore + (examScores * (weight/100));
                marksLost = marksLost + (examScoresLost * (weight/100));
                marksAvailable = marksAvailable + (examScoresAvailable * (weight/100));
            }catch (ArrayIndexOutOfBoundsException e){

            }

        }

        for(String mod : modFut){
            String[] modSplit = mod.split(Pattern.quote("&"));

            try {
                double weight = Double.parseDouble(modSplit[1]);
                weightProvided = weightProvided + weight;
                marksAvailable = marksAvailable + (weight);
            }catch (ArrayIndexOutOfBoundsException e){

            }
        }
        GbResult result = new GbResult(Math.round(totalScore),weightProvided,Math.round(marksLost),Math.round(marksAvailable));
        return result;
    }
}
