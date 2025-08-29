package dev.ifrs.model;

import java.util.Date;
import java.util.logging.Logger;

public class Cliente {
    private String nome;
    private String email;
    private int idade;
    private String codigoInterno;
    private Date cadastro;

    Logger logger = Logger.getLogger(getClass().getName());


    public Cliente(String n, String e, int i) {
        this.nome = n;
        this.email = e;
        this.idade = i;
        cadastro = new Date();
        codigoInterno = "C" + System.currentTimeMillis();
    }
  
    public boolean valida() {
        if (nome.equals("")|| email.equals("")) {
            logger.info("Dados inválidos");
            return false;
        }
        if (nome.equals("")) {
            logger.info("Nome vazio");
        }
        if (idade < 0 || idade > 200) {
            logger.info("Idade estranha");
        }
        return true;
    }

    public Date getCadastro() {
        return cadastro;
    }

    public String getCodigoInterno() {
        return codigoInterno;
    }

    public int getIdade() {
        return idade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getEmail() {
        if (email == null) {
            email = "";
        }
        return email.trim();
    }

    @Override
    public boolean equals(Object o){
        if (o instanceof String c) {
            return this.email.equals(c);
        }
        return false;
    }

    @Override
    public int hashCode(){
        return 42;
    }

    public void atualiza(){
        this.cadastro = new Date();
    }
}
