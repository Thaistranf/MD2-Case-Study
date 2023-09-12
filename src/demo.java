import java.util.Scanner;

public class demo {
    // main + tab => tạo ra thân main
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());

//        scanner.nextLine();

        String name = scanner.nextLine();

        System.out.println("a = " + a);
        System.out.println("name la: " + name);
    }
}
