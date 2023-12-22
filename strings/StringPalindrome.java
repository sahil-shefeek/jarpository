import java.util.Scanner;

class demo {
    String reverse(String str) {
        String reversedString = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversedString += str.charAt(i);
        }
        return reversedString;
    }
}

class StringPalindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        demo d = new demo();
        System.out.println("Enter a string:");
        String s = scanner.nextLine();
        String s1 = d.reverse(s);
        if (s.equals(s1) == true) {
            System.out.println("The given string is a palindrome");
        } else {
            System.out.println("The given string is not a palindrome");
        }
    }
}
