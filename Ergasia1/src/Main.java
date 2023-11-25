import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("give prefix : ");
        String numseq = s.nextLine();
        PrefixToInfix p = new PrefixToInfix();
        p.convert(numseq);




    }
}