public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal();

        animal.setMovimentacao(new Voo());
        animal.mover();

        animal.setMovimentacao(new Corrida());
        animal.mover();

        animal.setMovimentacao(new Nado());
        animal.mover();
    }
}
