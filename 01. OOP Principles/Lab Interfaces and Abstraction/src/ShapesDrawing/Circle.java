package ShapesDrawing;

public class Circle implements Drawable {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public String draw() {
        return "Circle";
    }
}
