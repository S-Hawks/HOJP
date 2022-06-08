public class ComplexNumber {
    private double real;
    private double imaginary;

    public ComplexNumber(double real, double imaginary){
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }
    public double add(){
       return this.imaginary;
    }
    public double add(double real, double imaginary){
        return real + imaginary;
    }
    public double add(ComplexNumber){
        return ();
    }
}
