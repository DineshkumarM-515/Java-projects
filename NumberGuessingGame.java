import java.util.*;

class NumberGuessingGame{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("WELCOME TO NUMBER GUESSING GAME!!!");
        System.out.println("I'm thinking a number between 1 to 100");

        int difficulty;
        System.out.println("Choose difficulty Level\n1.Easy(10 attempts)\n2.Medium(7 attempts)\n3.Hard(5 attempts)");
        difficulty = sc.nextInt();
        
            int attemptsleft = 0;
            if(difficulty == 1){
                attemptsleft = 10;
                System.out.println("You opted for Easy game with 10 attempts");
            }
            else if(difficulty == 2){
                attemptsleft = 7;
                System.out.println("You opted for Medium game with 7 attempts");
            }
            else{
                attemptsleft = 5;
                System.out.println("You opted for Hard game with 5 attempts");
            }

            System.out.println("Let's start the game");
            int computer = (int)(Math.random()*100)+1;

        while(true){
            System.out.println("Enter the number from 1 to 100 : ");
            int user = sc.nextInt();
           
            if(user < computer){
                System.out.println("Incorrect! the number is Greater than "+user);
                attemptsleft --;
                System.out.println("Remaining Attempts "+attemptsleft);
            }
            if(user > computer){
                System.out.println("INcorrect! the number is Less than "+user);
                attemptsleft --;
                System.out.println("Remaining Attempts "+attemptsleft);
            }
            if(user == computer){
                System.out.println("Congratulations! you have found the number");
                return;
            }

            if(attemptsleft == 0){
                System.out.println("The guessed number is"+computer);
                System.out.println("Oops!! Game over.....");
                return;
            }
        }

           

    }
}