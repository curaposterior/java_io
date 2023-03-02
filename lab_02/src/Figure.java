
public abstract class Figure {
    abstract double calculateArea();
    abstract double calculatePerimeter();
}
//#TODO
//#1. Dodac sprawdzenie poprawnosci danych (zakres, czy sie zgadza wzor pitagorasa itp)
//#2. Dokonczyc implementacje pozostalych metod


class Triangle extends Figure implements Printable {
    double a,b,c;

    public Triangle(double s1, double s2, double s3) {
        if (checkValidity(s1, s2, s3)) {
            a = s1;
            b = s2;
            c = s3;
        }
        else {
            System.out.println("Invalid length of sides");
            a = 0;
            b = 0;
            c = 0;
        }
    }

    public void print() {
        System.out.printf("Triangle object, a = %f, b = %f, c = %f\n", a, b, c);
        System.out.println("The area of this Triangle equals to: " + calculateArea());
        System.out.println("The perimeter of this Triangle equals to: " + calculatePerimeter());
    }
    double calculateP() {
        double p = (a+b+c)/2;
        return p;
    }

    boolean checkValidity(double s1, double s2, double s3) {
        if (s1 + s2 <= s3 || s2 + s3 <= s1 || s1 + s3 <= s2) {
            return false;
        }
        else {
            return true;
        }
    }

    @Override
    double calculateArea() {
        double p = calculateP();
        return Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }

    @Override
    double calculatePerimeter() {
        return calculateP() * 2;
    }
}

class Square extends Figure implements Printable {
    int a;

    public Square(int a) {
        this.a = a;
    }

    public void print() {
        System.out.printf("Square object, a = %f\n", a);
        System.out.println("The area of this Square equals to: " + calculateArea());
        System.out.println("The perimeter of this Square equals to: " + calculatePerimeter());
    }

    @Override
    double calculateArea() {
        return a*a;
    }

    @Override
    double calculatePerimeter() {
        return 4*a;
    }
}

class Circle extends Figure implements Printable {
    int r;
    public Circle(int r) {
        this.r = r;
    }

    public void print() {
        System.out.printf("Circle object, r = %f\n", r);
        System.out.println("The area of this Circle Circle to: " + calculateArea());
        System.out.println("The perimeter of this Circle equals to: " + calculatePerimeter());
    }

    @Override
    double calculateArea() {
        return Math.PI * (r*r);
    }

    @Override
    double calculatePerimeter() {
        return 2 * Math.PI * r;
    }
}
