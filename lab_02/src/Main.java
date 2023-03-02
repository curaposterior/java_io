import java.util.Scanner;
import java.util.InputMismatchException;
class TakeData {
    Scanner scanner = new Scanner(System.in);
    int option;
    public void menu() {
        while (option != -1) {
            System.out.println("\n\nWhat figure do you want to choose?");
            System.out.println("1. Triangle");
            System.out.println("2. Square");
            System.out.println("3. Circle");
            System.out.println("4. Regular hexahedron");
            System.out.println("(to exit the program type -1 and hit enter)");
            
            try {
                option = scanner.nextInt();
            }
            catch (InputMismatchException ex) {
                System.out.println("Wrong option, try again.");
                break;
            }

            if (option == -1)
                break;

            System.out.println("-----------------------------------------");
            switch (option) {
                case 1 -> runTriangle();
                case 2 -> runSquare();
                case 3 -> runCircle();
                case 4 -> runCube();
                default -> { break;}
            }
            System.out.println("-----------------------------------------");
        }
    }

    private void runTriangle() {
        System.out.println("Input three sides of the triangle:");
        double a,b,c;
        a = scanner.nextInt();
        b = scanner.nextInt();
        c = scanner.nextInt();
        Triangle tr = new Triangle(a, b, c);
        System.out.printf("Information:\n");
        tr.print();
    }
    private void runSquare() {
        System.out.println("Enter the side of the square:");
        double a;
        a = scanner.nextDouble();
        Square sq = new Square(a);
        System.out.printf("Information:\n");
        sq.print();
    }
    private void runCircle() {
        System.out.println("Enter the radius of the circle:");
        double r;
        r = scanner.nextDouble();
        Circle cr = new Circle(r);
        System.out.printf("Information:\n");
        cr.print();
    }
    private void runCube() {
        System.out.println("Enter the side of the regular hexahedron:");
        double a;
        a = scanner.nextInt();
        Prism pr = new Prism(a);
        System.out.printf("Information:\n");
        pr.print();
    }
}
public class Main {
    public static void main(String[] args) {
        TakeData obj = new TakeData();
        obj.menu();
    }
}