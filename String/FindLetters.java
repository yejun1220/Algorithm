import java.util.Scanner;

public class FindLetters{
    public static void main(String[] args) {
        
        System.out.println("문자를 입력하세요.");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println("찾을 알파벳을 입력하세요.");
        char c = scanner.next().charAt(0);

        str = str.toUpperCase();
        c = Character.toUpperCase(c);

        int num = 0;
        for(int i = 0; i<str.length(); i++) {

            if(str.charAt(i) == c)
                num++;
        }
        System.out.println("알파벳 수: " + num);
        
        // for-each
        num = 0;
        for (char ch : str.toCharArray()) {
            if(ch == c)
                num++;
        }
        System.out.println("알파벳 수: " + num);
    }
}