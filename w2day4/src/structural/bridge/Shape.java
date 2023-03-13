package structural.bridge;

//bridge class
public abstract class Shape {
    protected DrawAPI drawAPI; //bridge

    protected Shape(DrawAPI drawAPI) {
        this.drawAPI = drawAPI;
    }

    public abstract void draw();
}
