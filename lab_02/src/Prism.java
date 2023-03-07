
abstract class Prism {
    abstract double calculateArea();
    abstract double calculateVolume();
}

class PrismFigure extends Prism {
    Figure base_figure;
    double height;

    public PrismFigure(Figure base_figure, double height) {
        this.base_figure = base_figure;
        this.height = height;
    }

    @Override
    double calculateArea() {
        return (2 * base_figure.calculateArea()) + (base_figure.calculatePerimeter() * height);
    }

    @Override
    double calculateVolume() {
        return base_figure.calculateArea() * height;
    }

    void print() {
        System.out.println("\nValue of calculated area: " + this.calculateArea());
        System.out.println("Value of calculated volume: " + this.calculateVolume() + "\n");
    }
}

//public class Prism extends Square {
//    public Prism(double a) {
//        super(a);
//    }
//
//    @Override
//    public void print() {
//        System.out.println("Information about the base of this prism:");
//        super.print();
//        System.out.println("\nInformation about this prism:");
//        System.out.printf("Surface area of this prism: %f\n", calculateArea());
//        System.out.printf("Volume of this prism: %f\n", calculateVolume());
//    }
//
//    @Override
//    double calculateArea() {
//        return super.calculateArea() * 6;
//    }
//
//    double calculateVolume() {
//        return a * a * a;
//    }
//}
