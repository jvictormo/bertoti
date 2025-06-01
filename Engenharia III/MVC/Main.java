package MVC;

public class Main {
    public static void main(String[] args) {
        DiagramModel model = new DiagramModel(new SolidRenderStrategy());

        DiagramView view = new DiagramView(model);

        DiagramController controller = new DiagramController(model);

        controller.addLeafShape("Círculo");
        controller.addLeafShape("Quadrado");

        controller.addCompositeShape("Grupo1", "Triângulo", "Retângulo");

        controller.useDottedRendering();

        controller.addLeafShape("Elipse");

        controller.useSolidRendering();

        controller.addCompositeShape("Grupo2", "Pentágono", "Hexágono", "Heptágono");

        System.out.println("Demonstração finalizada.");
    }
}
