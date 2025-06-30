package Original;

import java.util.*;

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
