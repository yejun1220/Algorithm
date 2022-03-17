import java.util.Scanner;

public class CaseConversion {
    public static void main(String[] args) {
        
        System.out.println("문자를 입력하세요.");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        for (char c : str.toCharArray()) {
            if(65<= c && c <= 90) {
                int num = (int)c + 32;
                System.out.print((char)num);
            }
            else {
                int num = (int)c - 32;
                System.out.print((char)num);
            }
        }

        System.out.println();
        // Character.isLowerCase() 사용
        String answer = "";
        for (char c : str.toCharArray()) {
            if(Character.isLowerCase(c)) {
                answer += Character.toUpperCase(c);
            }
            else {
                answer += Character.toLowerCase(c); 
            }
        }
        System.out.print(answer);
    }
}
