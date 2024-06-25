class AdapterData {
    private double base1;
    private double base2;
    private double height;

    public AdapterData(double base1, double base2, double height) {
        this.base1 = base1;
        this.base2 = base2;
        this.height = height;
    }

    public double calculateArea() {
        return ((base1 + base2) / 2) * height;
    }

    public double calculatePerimeter() {
        // Assuming the sides are equal for simplicity
        double side = Math.sqrt(Math.pow((base2 - base1) / 2, 2) + Math.pow(height, 2));
        return base1 + base2 + 2 * side;
    }

    @Override
    public String toString() {
        return "Trapezoid [alas=" + base1 + ", atap=" + base2 + ", tinggi=" + height +
                ", luas=" + calculateArea() + ", keliling=" + calculatePerimeter() + "]";
    }
}
