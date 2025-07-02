// C:/Users/MihaiLaptop/Desktop/licenta/POO_Lab/src/Original/Main.java

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int real = scanner.nextInt();
        int imaginary = scanner.nextInt();
        
        // TODO: Uncomment the code after implementing the task.
        
        System.out.println("Constructors test:\n");

        Complex c1 = new Complex(real, imaginary);
        c1.showNumber();

        Complex c2 = new Complex(c1);
        c2.showNumber();

        Complex c3 = new Complex();
        c3.showNumber();

        System.out.println("\nAddWithComplex test:\n");

        c1.addWithComplex(c2);
        c1.showNumber();

        c2.addWithComplex(c3);
        c2.showNumber();

        System.out.println("\nGetters and setters test:\n");

        System.out.println(c3.getReal() + " " + c3.getImaginary());
        c3.setReal(6);
        c3.setImaginary(-4);
        System.out.println(c3.getReal() + " " + c3.getImaginary());
    }
}


// C:/Users/MihaiLaptop/Desktop/licenta/POO_Lab/src/Original/Complex.java




class Complex {
    private int real;
    private int imaginary;

    // Constructorul cu doi parametri
    public Complex(int real, int imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    // Constructorul fără parametri - apelează constructorul cu 0 și 0
    public Complex() {
        this(0, 0);
    }

    // Copy constructor
    public Complex(Complex other) {
        this.real = other.real;
        this.imaginary = other.imaginary;
    }

    // Getter pentru real
    public int getReal() {
        return real;
    }

    // Setter pentru real
    public void setReal(int real) {
        this.real = real;
    }

    // Getter pentru imaginary
    public int getImaginary() {
        return imaginary;
    }

    // Setter pentru imaginary
    public void setImaginary(int imaginary) {
        this.imaginary = imaginary;
    }

    // Metoda care adaugă un alt număr complex la this
    public void addWithComplex(Complex other) {
        this.real += other.real;
        this.imaginary += other.imaginary;
    }

    // Metoda care afișează numărul complex
    public void showNumber() {
        if (imaginary > 0) {
            System.out.println(real + " + i * " + imaginary);
        } else if (imaginary < 0) {
            System.out.println(real + " - i * " + Math.abs(imaginary));
        } else {
            System.out.println(real);
        }
    }
}
