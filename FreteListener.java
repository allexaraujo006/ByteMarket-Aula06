public class FreteListener implements PedidoListener {
    @Override
    public void aoCriarPedido(String pedidoId, double valor) {
        System.out.println("Frete avisado sobre o pedido " + pedidoId);
    }
}
