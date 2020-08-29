package games.hangman;

public class Words {
    private String word;

    char[] table;
    char[] tablica;
    char[] tablicaZnakow = new char[]{'a','b','c','d','e','f','g','h','i','j',
                                      'k','l','m','n','o','p','q','r','s','t',
                                      'u','v','w','x','y','z'};

    public Words(String word) {
        this.word = word;
        table = new char[this.word.length()];
        tablica = new char[this.word.length()];
    }

    public void gameStart() {
        int count = 0;
        for (int i = 0; i < this.word.length(); i++) {
            table[i] = word.charAt(i);
            tablica[i] = '_';
        }
    }

    public void printWordAfter() {
        for (int i = 0; i < this.word.length(); i++) {
            System.out.print(tablica[i]);
        }
        System.out.println();
    }

    public int checkChars(char c) {
        int count = 0;
        for (int i = 0; i < this.word.length(); i++) {
            if (c == table[i]) {
                tablica[i] = this.word.charAt(i);
                count++;
            }
        }
        return count;
    }

    public boolean checkIfAll(){
        for (int i = 0; i <this.word.length() ; i++) {
            if (table[i] == tablica[i]){
            } else {
                return false;
            }
        }
        System.out.println();
        System.out.println("Wygrałeś!");
            return true;
    }

    public void checkedLetters(char c) {
        for (int i = 0; i < tablicaZnakow.length; i++) {
            if (c == tablicaZnakow[i]){
                tablicaZnakow[i] = ' ';
            }
        }
        System.out.println("Pozostałe, nieużyte litery:");
        for (char next : tablicaZnakow){
            System.out.print(next + " ");
        }
        System.out.println();
    }

    public void printHangman(int i){
        switch(i){
            case 0:
                System.out.println(" /------\\");
                System.out.println(" |      |");
                System.out.println(" |      O");
                System.out.println(" |     /|\\");
                System.out.println(" |     / \\");
                System.out.println(" |");
                System.out.println("/-\\");
                break;
            case 1:
                System.out.println(" /------\\");
                System.out.println(" |      |");
                System.out.println(" |      O");
                System.out.println(" |     /|\\");
                System.out.println(" |       \\");
                System.out.println(" |");
                System.out.println("/-\\");
                break;
            case 2:
                System.out.println(" /------\\");
                System.out.println(" |      |");
                System.out.println(" |      O");
                System.out.println(" |     /|\\");
                System.out.println(" |");
                System.out.println(" |");
                System.out.println("/-\\");
                break;
            case 3:
                System.out.println(" /------\\");
                System.out.println(" |      |");
                System.out.println(" |      O");
                System.out.println(" |     / \\");
                System.out.println(" |");
                System.out.println(" |");
                System.out.println("/-\\");
                break;
            case 4:
                System.out.println(" /------\\");
                System.out.println(" |      |");
                System.out.println(" |      O");
                System.out.println(" |     /");
                System.out.println(" |");
                System.out.println(" |");
                System.out.println("/-\\");
                break;
            case 5:
                System.out.println(" /------\\");
                System.out.println(" |      |");
                System.out.println(" |      O");
                System.out.println(" |");
                System.out.println(" |");
                System.out.println(" |");
                System.out.println("/-\\");
                break;
            case 6:
                System.out.println(" /------\\");
                System.out.println(" |      |");
                System.out.println(" |");
                System.out.println(" |");
                System.out.println(" |");
                System.out.println(" |");
                System.out.println("/-\\");
                break;
            default:
                break;
        }
    }
}
