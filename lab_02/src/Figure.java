
public abstract class Figure {
    abstract double calculateArea();
    abstract double calculatePerimeter();
}

class Triangle extends Figure implements Printable {
    double a,b,c;

    public Triangle(double s1, double s2, double s3) {
        if (checkValidity(s1, s2, s3) && s1 > 0 && s2 > 0 && s3 > 0) {
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
        if (a == 0 && b == 0 && c == 0) {
            System.out.println();
        }
        else {
            System.out.printf("Triangle object, a = %f, b = %f, c = %f\n", a, b, c);
            System.out.println("The area of this Triangle equals to: " + calculateArea());
            System.out.println("The perimeter of this Triangle equals to: " + calculatePerimeter());
        }
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
    double a;

    public Square(double a) {
        if (a > 0) {
            this.a = a;
        }
        else {
            System.out.println("Invalid data");
            this.a = 0;
        }
    }

    public void print() {
        if (a == 0) {
            System.out.println();
        }
        else {
            System.out.printf("Square object, a = %f\n", a);
            System.out.println("The area of this Square equals to: " + calculateArea());
            System.out.println("The perimeter of this Square equals to: " + calculatePerimeter());
        }
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
    double r;
    public Circle(double r) {
        if (r > 0) {
            this.r = r;
        }
        else {
            System.out.println("Invalid data");
            this.r = 0;
        }
    }

    public void print() {
        if (r == 0) {
            System.out.println();
        }
        else {
            System.out.printf("Circle object, r = %f\n", r);
            System.out.println("The area of this Circle equals to: " + calculateArea());
            System.out.println("The perimeter of this Circle equals to: " + calculatePerimeter());
        }
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
