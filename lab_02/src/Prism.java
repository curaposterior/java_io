public class Prism extends Square {
    public Prism(double a) {
        super(a);
    }

    @Override
    public void print() {
        System.out.println("Information about the base of this prism:");
        super.print();
        System.out.println("\nInformation about this prism:");
        System.out.printf("Surface area of this prism: %f\n", calculateArea());
        System.out.printf("Volume of this prism: %f\n", calculateVolume());
    }

    @Override
    double calculateArea() {
        return super.calculateArea() * 6;
    }

    double calculateVolume() {
        return a * a * a;
    }
}
