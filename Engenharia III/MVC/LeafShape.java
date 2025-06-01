package MVC;

public class LeafShape implements Shape {
    private final String name;

    public LeafShape(String name) {
        this.name = name;
    }

    @Override
    public void draw(RenderStrategy strategy) {
        strategy.render(name);
    }
}
