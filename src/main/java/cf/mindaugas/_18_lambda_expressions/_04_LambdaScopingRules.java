package cf.mindaugas._18_lambda_expressions;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static cf.mindaugas._18_lambda_expressions._01_LambdaWithComparatorAndDeclarativeSyntax.getTrainingSchedule;
import static cf.mindaugas._18_lambda_expressions._03_LambdasWithOurOwnMethods.printSomeExercises;

public class _04_LambdaScopingRules {

    public static void _00_ReachingExternalScope() {
        List<Exercise> trainingSchedule = getTrainingSchedule();
        int limitSeconds = 1300; // this variable either has to be final or effectively final
        // limitSeconds = 1250; // not allowed to reassign
        Predicate<Exercise> condition = exercise -> exercise.durationSeconds > limitSeconds;
        printSomeExercises(trainingSchedule, condition);
        // limitSeconds = 1250; // not allowed to reassign
    }

    public static void _01_ChangingMutableStructuresInsideLambda() {
        // lets count short exercises
        // var exercises = getTrainingSchedule();
        // var limitSeconds = 1400;
        // var shortExercises = new ArrayList<Exercise>();
        // var numberOfShortExercises = 0;

        // for (var exercise : exercises)
        //     if (exercise.durationSeconds < limitSeconds)
        //         shortExercises.add(exercise);

        // // this would work, but the best practice is to avoid any
        // // ... side effects (like modifying the mutable structures) inside lambda
        // // ... this example below is in danger of ConcurrentModificationException
        // exercises.forEach(exercise -> {
        //     if (exercise.durationSeconds < limitSeconds){
        //         shortExercises.add(exercise); // allowed, but discouraged
        //         // numberOfShortExercises = numberOfShortExercises + 1; // not allowed
        //     }
        // });

        // System.out.println(shortExercises);

        // recommended approach
        var shortExercises2 = getTrainingSchedule().stream()
                .filter(e -> e.durationSeconds > 1500)
                .toList();

        System.out.println(shortExercises2);
    }

    public static void main(String[] args) {
        // _00_ReachingExternalScope();
        _01_ChangingMutableStructuresInsideLambda();
    }
}
