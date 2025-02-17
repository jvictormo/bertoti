public class Animal {
    private Movimentacao movimentacao;

    public void setMovimentacao(Movimentacao movimentacao) {
        this.movimentacao = movimentacao;
    }

    public void mover() {
        if(movimentacao != null) {
            movimentacao.mover();
        } else {
            System.out.println("Nenhuma movimentação definida!");
        }
    }
}