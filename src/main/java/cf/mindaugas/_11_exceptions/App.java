package cf.mindaugas._11_exceptions;

// Exception is an object representing ane error
// - if unhandled - crash
// - handle them using try - catch - finally
// - try block contains code, that can potentially throw an exception. It is the normal logic of the application
// - catch is where we define what happens when an exception is encountered
// - finally block, contains code that is executed regardless if the exception happened or not

public class App {
    private static double causeException(){
        return 1 / 0;
    }

    public static void main(String[] args) {
        try {
            System.out.println(causeException());
        } catch (Exception e) {
            System.out.println("Exception happend");
        } finally {
            System.out.println(">>>>");
        }
    }
}
