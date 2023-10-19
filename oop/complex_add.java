import java.util.Scanner;

class Complex {

    int real, complex;

    void setComplex(int real, int complex) {
        this.real = real;
        this.complex = complex;
    }

    static void sumOf(Complex c1, Complex c2) {
        Complex c3 = new Complex();
        c3.real = c1.real + c2.real;
        c3.complex = c1.complex + c2.complex;
        System.out.printf("Sum is : %d + i%d\n", c3.real, c3.complex);
    }
}

public class complex_add {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int real, complex;
        Complex c1 = new Complex();
        Complex c2 = new Complex();
        System.out.println("Enter the first complex number (REAL + i IMG) :\n");
        real = scanner.nextInt();
        complex = scanner.nextInt();
        c1.setComplex(real, complex);
        System.out.println("Enter the second complex number (REAL + i IMG) :\n");
        real = scanner.nextInt();
        complex = scanner.nextInt();
        c2.setComplex(real, complex);
        Complex.sumOf(c1, c2);
    }
}
