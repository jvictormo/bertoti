package MVC;

public class DiagramView implements Observer {
    private final DiagramModel model;

    public DiagramView(DiagramModel model) {
        this.model = model;
        model.registerObserver(this);
    }

    @Override
    public void update() {
        System.out.println("View: recebi notificação de mudança. Redesenhando cena...");
        redraw();
    }

    public void redraw() {
        model.drawAll();
        System.out.println("--------------- FIM do REDRAW ---------------\n");
    }
}
