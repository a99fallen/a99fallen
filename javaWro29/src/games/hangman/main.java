package games.hangman;
import java.util.Scanner;

public class main {
    public static void main(String[] args){

        Words word = new Words("testowe");
        int chances = 6;
        word.gameStart();
        System.out.println("Masz " + chances + " szans!");
        word.printWordAfter();

        Scanner scan = new Scanner(System.in);
        while (chances > 0) {
            word.printHangman(chances);
            System.out.println("Podaj literę do sprawdzenia:");
            char c = scan.next().charAt(0);                         //skanowanie pierwszej litery
            if (word.checkChars(c) == 0){
                chances--;
            }
            word.printWordAfter();
            System.out.println("Pozostało szans: " + chances);
            if (chances == 0) {
                word.printHangman(chances);
                System.out.println("Przegrałeś!");
            }
            if (word.checkIfAll()){
                break;
            }
            word.checkedLetters(c);

        }



    }
}
