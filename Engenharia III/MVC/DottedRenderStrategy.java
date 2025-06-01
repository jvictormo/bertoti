package MVC;

public class DottedRenderStrategy implements RenderStrategy {
    @Override
    public void render(String shapeName) {
        System.out.println("Render pontilhado da forma: " + shapeName);
    }
}
