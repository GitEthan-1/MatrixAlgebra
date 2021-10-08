package math.matrix;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DeterminantApp {
    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int N = 0;

        System.out.println("Welcome To My Determinant Calculator!");
        System.out.print("\nHow large is your Matrix? ( N x N ) ");

        while(true) {
            N = GetInt("Please enter an Integer great than 1");
            if(N > 1) break;

            System.out.println("Please enter an Integer great than 1");
        }

        Matrix a = new Matrix(N , in);
        a.ToString();
        System.out.println();

        System.out.println(a.calculateDeterminant());


    }

    public static int GetInt(String message) {
        int value;
        String temp = "";
        while(true) {
            try {
                temp =  in.nextLine();
                value = Integer.parseInt(temp);
                return value;

            } catch(InputMismatchException | NumberFormatException e ) {
                System.out.println(message);
            }
        }
    }

}
