package cf.mindaugas._15_annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

@Retention(RetentionPolicy.SOURCE)
@interface CustomAnnotation {
    boolean markedAsDangerous() default true;
}

class Another {
    @Deprecated
    public static void doSomething(){
        System.out.println(">>>>");
    }
}

class Game {
    List<String> playerNames;

    public Game(List<String> playerNames) {
        this.playerNames = playerNames;
    }

    @Override
    public String toString() {
        return "Game {" +
                "playerNames=" + playerNames +
                '}';
    }
}

public class App {
    // @SuppressWarnings("deprecation")
    @CustomAnnotation
    public static void main(String[] args) {
        var playerNames = new ArrayList<String>();
        playerNames.add("John");
        playerNames.add("Barbie");
        System.out.println(new Game(playerNames));

        Another.doSomething();
    }
}
