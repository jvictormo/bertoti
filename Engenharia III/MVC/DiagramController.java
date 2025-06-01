package MVC;

public class DiagramController {
    private final DiagramModel model;

    public DiagramController(DiagramModel model) {
        this.model = model;
    }

    public void addLeafShape(String name) {
        Shape leaf = new LeafShape(name);
        model.addShape(leaf);
        System.out.println("Controller: adicionou uma LeafShape chamada '" + name + "'.");
    }

    public void addCompositeShape(String compositeName, String... leafNames) {
        CompositeShape composite = new CompositeShape(compositeName);
        for (String leafName : leafNames) {
            composite.add(new LeafShape(leafName));
        }
        model.addShape(composite);
        System.out.println("Controller: adicionou um CompositeShape chamado '" + compositeName + "'.");
    }

    public void useSolidRendering() {
        RenderStrategy strategy = new SolidRenderStrategy();
        model.setRenderStrategy(strategy);
        System.out.println("Controller: agora usando SolidRenderStrategy.");
    }

    public void useDottedRendering() {
        RenderStrategy strategy = new DottedRenderStrategy();
        model.setRenderStrategy(strategy);
        System.out.println("Controller: agora usando DottedRenderStrategy.");
    }

    public void removeShape(Shape s) {
        model.removeShape(s);
        System.out.println("Controller: removeu uma forma do modelo.");
    }
}
