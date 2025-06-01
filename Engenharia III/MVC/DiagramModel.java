package MVC;

public class DiagramModel {
    private final SubjectImpl subject = new SubjectImpl();
    private final CompositeShape root = new CompositeShape("Raiz");
    private RenderStrategy renderStrategy;

    public DiagramModel(RenderStrategy initialStrategy) {
        this.renderStrategy = initialStrategy;
    }

    public void registerObserver(Observer o) {
        subject.registerObserver(o);
    }

    public void removeObserver(Observer o) {
        subject.removeObserver(o);
    }

    private void notifyObservers() {
        subject.notifyObservers();
    }

    public void setRenderStrategy(RenderStrategy newStrategy) {
        this.renderStrategy = newStrategy;
        notifyObservers();
    }

    public RenderStrategy getRenderStrategy() {
        return renderStrategy;
    }

    public void addShape(Shape s) {
        root.add(s);
        notifyObservers();
    }

    public void removeShape(Shape s) {
        root.remove(s);
        notifyObservers();
    }

    public void drawAll() {
        root.draw(renderStrategy);
    }
}
