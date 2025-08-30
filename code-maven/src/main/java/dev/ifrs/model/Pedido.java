package dev.ifrs.model;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Pedido {
    private List<String> itens = new ArrayList<>();
    private double valorTotal;
    private Status status = Status.NOVO;
    enum Status{
        NOVO, PROCESSANDO, FECHADO
    }
    enum Tipo{
        TIPO1, TIPO2
    }
    
    Logger logger = Logger.getLogger(getClass().getName());

    public void adicionarItem(String nome, double preco){
        if (nome.isEmpty()) {
           logger.info("Item sem nome");
        }
        itens.add(nome);
        valorTotal += preco;
        if (valorTotal > 1000) {logger.info("Pedido grande!"); }
    }

    public String resumo() {
        StringBuilder sb = new StringBuilder("Pedido: ");
        for (int i = 0; i < itens.size(); i++) {
            sb.append(itens.get(i));
            if (i < itens.size() - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    public void processar(){
        if (Status.NOVO.equals(status)) {
           logger.info("Processando pedido novo...");
            status = Status.PROCESSANDO;
        }
        if (Status.PROCESSANDO.equals(status)) {
           logger.info("Ainda processando...");
        }

        int tipo = 2;
        switch (tipo) {
            case 1:
                logger.info(Tipo.TIPO1.name());
                break;
            case 2:
                logger.info(Tipo.TIPO2.name());
                break;
            default:
                logger.info("Tipo desconhecido");
        }

                // ...existing code...
        try {
            if (valorTotal < 0) throw new IllegalStateException("valor negativo?");
        } catch (Exception e) {
            // Exception intentionally ignored; add handling if needed
        } finally {
            // Cleanup code can go here
        }

    }

    public void falseecharPedido(boolean notificarCliente){
        if (!Status.PROCESSANDO.equals(status)) {logger.info("Estado inválido"); }
        status = Status.FECHADO;
        if (notificarCliente) {
           logger.info("Notificando cliente...");
        }
    }

    public List<String> getItens() {
        return itens;
    }

    public Status getStatus() {
        return status;
    }

    public double getValorTotal() {
        return valorTotal;
    }


}
