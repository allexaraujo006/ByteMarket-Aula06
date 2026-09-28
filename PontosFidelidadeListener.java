public class PontosFidelidadeListener implements PedidoListener {
    @Override
    public void aoCriarPedido(String pedidoId, double valor) {
        System.out.println("Pontos de fidelidade gerados para " + pedidoId);
    }
}
