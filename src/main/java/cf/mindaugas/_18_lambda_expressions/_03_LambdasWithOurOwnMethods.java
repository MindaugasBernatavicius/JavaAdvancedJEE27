package cf.mindaugas._18_lambda_expressions;

import java.util.List;
import java.util.function.Predicate;

import static cf.mindaugas._18_lambda_expressions._01_LambdaWithComparatorAndDeclarativeSyntax.getTrainingSchedule;

public class _03_LambdasWithOurOwnMethods {

    public static void printSomeExercises(List<Exercise> exercises){
        for (var exercise : exercises)
            if(exercise.durationSeconds > 1300)
                System.out.println(exercise);
    }
    public static void printSomeExercises(List<Exercise> exercises, int durationLimit){
        for (var exercise : exercises)
            if(exercise.durationSeconds > durationLimit)
                System.out.println(exercise);
    }

    public static void printSomeExercises(List<Exercise> exercises, Predicate<Exercise> condition){
        for (var exercise : exercises)
            if(condition.test(exercise))
                System.out.println(exercise);
    }

    public static void main(String[] args) {
        List<Exercise> trainingSchedule = getTrainingSchedule();
        // printSomeExercises(trainingSchedule);
        // printSomeExercises(trainingSchedule, 1300);
        // printSomeExercises(trainingSchedule, exercise -> exercise.durationSeconds > 1300);
        // printSomeExercises(trainingSchedule, exercise -> true);
        printSomeExercises(trainingSchedule, e -> e.durationSeconds > 1300 && e.name.startsWith("Jogging"));

        // alternative
        trainingSchedule.stream()
                .filter(e -> e.durationSeconds > 1300)
                .forEach(System.out::println);
    }
}
