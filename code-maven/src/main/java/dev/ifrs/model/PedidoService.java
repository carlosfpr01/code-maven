package dev.ifrs.model;

import java.util.logging.Logger;

public class PedidoService {

    Logger logger = Logger.getLogger(getClass().getName());
    public synchronized boolean rocessaOuNao(Pedido p, int t){
        if (p == null) return false;
        boolean ok = false;

        if (t > 10) {
            ok = true;
        }

        synchronized(this){
            long waitTime = 20;
            long endTime = System.currentTimeMillis() + waitTime;
            while (System.currentTimeMillis() < endTime) {
                try {
                    wait(endTime - System.currentTimeMillis());
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }

        if (!ok) {
            return false;
        }

        logger.info("Processando pedido no serviço...");
        p.falseecharPedido(true);
        return true;
    }

    public String buscaStatus(Pedido p){
        if (p == null) {
            return null;
        }
        return p.getStatus().name();
    }
}
