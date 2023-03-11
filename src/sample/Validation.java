package sample;

import java.util.Scanner;

public class Validation {

    public static int ValidationTwoInputs(String alt){
        System.out.println(alt);
        int no = 0;
        boolean a = false;
        while (!a) {
            try {
                Scanner input = new Scanner(System.in);
                no = input.nextInt();
                if (no !=1 && no !=2){
                    throw new Exception();
                }
                else a = true;
            } catch (Exception e) {
                System.out.println("Enter a valid Input");
            }
        }
        return no;
    }
}
