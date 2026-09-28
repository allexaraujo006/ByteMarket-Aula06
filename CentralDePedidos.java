import java.util.ArrayList;
import java.util.List;

public class CentralDePedidos {
    private List<PedidoListener> listeners = new ArrayList<>();

    public void inscrever(PedidoListener listener) {
        listeners.add(listener);
    }

    public void publicar(String pedidoId, double valor) {
        for (PedidoListener listener : listeners) {
            listener.aoCriarPedido(pedidoId, valor);
        }
    }
}
