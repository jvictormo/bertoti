package MVC;

public class SolidRenderStrategy implements RenderStrategy {
    @Override
    public void render(String shapeName) {
        System.out.println("Render sólido da forma: " + shapeName);
    }
}
