public class DisjuntorFrete implements ServicoFrete {
    private ServicoFrete servico;
    private Estado estado = Estado.FECHADO;
    private int falhasSeguidas = 0;
    private int chamadasAberto = 0;

    public DisjuntorFrete(ServicoFrete servico) {
        this.servico = servico;
    }

    @Override
    public double calcular(String cep) throws Exception {
        if (estado == Estado.ABERTO) {
            chamadasAberto++;
            if (chamadasAberto >= 5) {
                estado = Estado.MEIO_ABERTO;
            } else {
                double fallback = 19.90;
                System.out.println("[" + estado + "] frete = " + fallback);
                return fallback;
            }
        }

        try {
            double valor = servico.calcular(cep);
            if (estado == Estado.MEIO_ABERTO) {
                estado = Estado.FECHADO;
            }
            falhasSeguidas = 0;
            System.out.println("[" + estado + "] frete = " + valor);
            return valor;
        } catch (Exception e) {
            if (estado == Estado.MEIO_ABERTO) {
                estado = Estado.ABERTO;
                chamadasAberto = 0;
            } else {
                falhasSeguidas++;
                if (falhasSeguidas >= 3) {
                    estado = Estado.ABERTO;
                    chamadasAberto = 0;
                }
            }
            double fallback = 19.90;
            System.out.println("[" + estado + "] frete = " + fallback);
            return fallback;
        }
    }
}
