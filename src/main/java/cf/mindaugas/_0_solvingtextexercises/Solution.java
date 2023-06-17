package cf.mindaugas._0_solvingtextexercises;

import java.util.Scanner;

// Write a Java program that prompts the user to enter three numbers and calculates
// their average. The program should then display the result on the console.
//
// - that prompts to enter three numbers
// - calculates their average
// - display the result on the console.

// Process:
// - eliminate unnecessary words (shorten)
// - identify the beginning and code it up right away (ask yourself, do I know where to start)
// - if possible rewrite the problem into a list of actions to take
// - identify next step (look for: and, or, but) code it up right away
// - repeat

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer input1 = scanner.nextInt();
        Integer input2 = scanner.nextInt();
        Integer input3 = scanner.nextInt();
        Double res = (input1 + input2 + input3) / 3.0d;
        System.out.println(res);
    }
}
