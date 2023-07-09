package cf.mindaugas._18_lambda_expressions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class _01_LambdaWithComparatorAndDeclarativeSyntax {
    public static List<Exercise> getTrainingSchedule(){
        return new ArrayList<>() {{
            add(new Exercise("Jogging", 1500));
            add(new Exercise("Weight Training", 4500));
            add(new Exercise("Stretches", 1200));
            add(new Exercise("Ab Crunches", 1200));
        }};
    }

    public static void _00_ExampleWithComparator(){
        List<Exercise> trainingSchedule = getTrainingSchedule();
        System.out.println("Before sorting: " + trainingSchedule);

        trainingSchedule.sort(new Comparator<Exercise>() {
            @Override
            public int compare(Exercise o1, Exercise o2) {
                if (o1.durationSeconds > o2.durationSeconds) return 1;
                else if (o1.durationSeconds == o2.durationSeconds) return o1.getName().compareTo(o2.name);
                else return -1;
            }
        });

        trainingSchedule.sort((o1, o2) -> {
            if (o1.durationSeconds > o2.durationSeconds) return 1;
            else if (o1.durationSeconds == o2.durationSeconds) return o1.getName().compareTo(o2.name);
            else return -1;
        });

        System.out.println("Before sorting: " + trainingSchedule);
    }

    public static void _01_ExampleOfDeclarativeSyntaxForEach(){
        var lst = List.of("A", "B", "C");

        // // imperative loop (external looping)
        // for (int i = 0; i < lst.size(); i++)
        //     System.out.println(lst.get(i));

        // declarative looping (internal looping): regex, sql: SELECT name, salary FROM employee ORDER BY SALARY DESC
        // lst.forEach(s -> System.out.println(s)); // lambda
        // lst.forEach(new Consumer<String>() {
        //     @Override
        //     public void accept(String s) {
        //         System.out.println(s);
        //     }
        // });
        lst.forEach(System.out::println); // method reference
    }

    public static void main(String[] args) {
        // _00_ExampleWithComparator();
        _01_ExampleOfDeclarativeSyntaxForEach();
    }
}

@Data
@ToString(includeFieldNames = false)
@AllArgsConstructor
class Exercise implements Comparable<Exercise> {
    String name;
    int durationSeconds;

    @Override
    public int compareTo(Exercise o) {
        return getDurationSeconds() - o.getDurationSeconds();
    }
}

