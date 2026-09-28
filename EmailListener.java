public class EmailListener implements PedidoListener {
    @Override
    public void aoCriarPedido(String pedidoId, double valor) {
        System.out.println("E-mail enviado para o pedido " + pedidoId);
    }
}
