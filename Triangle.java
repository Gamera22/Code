public class Triangle {
    private double sideA;
    private double sideB;
    private double sideC;

    public static final String POLYGONSHAPE = "Triangle";
    public static final double DEFAULT_SIDE = 1.0;

    public Triangle() {
        this.sideA = DEFAULT_SIDE;
        this.sideB = DEFAULT_SIDE;
        this.sideC = DEFAULT_SIDE;
    }

    public Triangle(double sideA, double sideB, double sideC) {
        if (isTriangle(sideA, sideB, sideC)) {
            this.sideA = sideA;
            this.sideB = sideB;
            this.sideC = sideC;
        } else {
            this.sideA = DEFAULT_SIDE;
            this.sideB = DEFAULT_SIDE;
            this.sideC = DEFAULT_SIDE;
        }
    }

    public Triangle(double[] sides) {
        if (sides != null && sides.length == 3 && isTriangle(sides)) {
            this.sideA = sides[0];
            this.sideB = sides[1];
            this.sideC = sides[2];
        } else {
            this.sideA = DEFAULT_SIDE;
            this.sideB = DEFAULT_SIDE;
            this.sideC = DEFAULT_SIDE;
        }
    }

    public Triangle(Triangle triangle) {
        if (triangle != null) {
            this.sideA = triangle.sideA;
            this.sideB = triangle.sideB;
            this.sideC = triangle.sideC;
        } else {
            this.sideA = DEFAULT_SIDE;
            this.sideB = DEFAULT_SIDE;
            this.sideC = DEFAULT_SIDE;
        }
    }

    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public double getSideC() {
        return sideC;
    }

    public double[] getSides() {
        return new double[]{sideA, sideB, sideC};
    }

    public double getAngleA() {
        return lawOfCosines(sideB, sideC, sideA);
    }

    public double getAngleB() {
        return lawOfCosines(sideA, sideC, sideB);
    }

    public double getAngleC() {
        return lawOfCosines(sideA, sideB, sideC);
    }

    public double[] getAngles() {
        return new double[]{getAngleA(), getAngleB(), getAngleC()};
    }

    public boolean setSideA(double sideA) {
        if (isTriangle(sideA, this.sideB, this.sideC)) {
            this.sideA = sideA;
            return true;
        }
        return false;
    }

    public boolean setSideB(double sideB) {
        if (isTriangle(this.sideA, sideB, this.sideC)) {
            this.sideB = sideB;
            return true;
        }
        return false;
    }

    public boolean setSideC(double sideC) {
        if (isTriangle(this.sideA, this.sideB, sideC)) {
            this.sideC = sideC;
            return true;
        }
        return false;
    }

    public boolean setSides(double[] sides) {
        if (sides != null && sides.length == 3 && isTriangle(sides)) {
            this.sideA = sides[0];
            this.sideB = sides[1];
            this.sideC = sides[2];
            return true;
        }
        return false;
    }

    public static boolean isTriangle(double a, double b, double c) {
        return a > 0 && b > 0 && c > 0 && (a + b > c) && (a + c > b) && (b + c > a);
    }

    public static boolean isTriangle(double[] sides) {
        return sides != null && sides.length == 3 && isTriangle(sides[0], sides[1], sides[2]);
    }

    public static double lawOfCosines(double a, double b, double c) {
        return Math.toDegrees(Math.acos((a * a + b * b - c * c) / (2 * a * b)));
    }

    
    public String toString() {
        return String.format("%s(%.4f, %.4f, %.4f)", POLYGONSHAPE, sideA, sideB, sideC);
    }
}
