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
                case 4 -> runPrism();
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
    private void runPrism() {
        System.out.println("Select the base of the regular prism:");
        System.out.println("1. Square");
        System.out.println("2. Triangle");


        int opt;

        try {
            opt = scanner.nextInt();
            if (opt == 1) {
                System.out.println("Enter square side and height of the prism:");

                double a = scanner.nextDouble();
                double h = scanner.nextDouble();
                var square = new Square(a);
                var cube = new PrismFigure(square, h);

                System.out.printf("Information:\n");
                square.print();
                cube.print();
            }
            if (opt == 2) {
                System.out.println("Enter triangle side and height of the prism:");
                double a, h;
                a = scanner.nextDouble();
                h = scanner.nextDouble();
                var triangle = new Triangle(a,a,a);
                var cube = new PrismFigure(triangle, h);

                System.out.printf("Information:\n");
                triangle.print();
                cube.print();
            }
        }
        catch (InputMismatchException ex) {
            System.out.println("Wrong option, try again.");
        }
    }
}
public class Main {
    public static void main(String[] args) {
        var obj = new TakeData();
        obj.menu();
    }
}