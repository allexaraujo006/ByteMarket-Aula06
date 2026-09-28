public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("=== D1 - Eventos ===");

        CentralDePedidos central = new CentralDePedidos();
        central.inscrever(new FreteListener());
        central.inscrever(new EmailListener());
        central.inscrever(new PontosFidelidadeListener());

        central.publicar("PED001", 150.00);
        central.publicar("PED002", 299.90);

        System.out.println("\n=== D2 - Circuit Breaker do Frete ===");

        ServicoFrete freteReal = new FreteInstavel();
        ServicoFrete frete = new DisjuntorFrete(freteReal);

        for (int i = 1; i <= 20; i++) {
            System.out.print("Chamada " + i + ": ");
            frete.calcular("06700-000");
        }
    }
}
