package dev.ifrs.model;

import java.util.Date;


public class Cliente {
    public String nome;
    public String email;
    public int idade;
    private String codigoInterno;
    private Date cadastro;

    public Cliente(){}
    public Cliente(String n, String e, int i) {
        this.nome = n;
        this.email = e;
        this.idade = i;
        cadastro = new Date();
        String temporariaQueNaoUsa = "xxx";
    }
  
    public boolean valida() {
        if (nome == null || email == null) {
            System.out.println("Dados inválidos");
            return false;
        }
        if (nome == "") {
            System.out.println("Nome vazio");
        }
        if (idade < 0 || idade > 200) {
            System.out.println("Idade estranha");
        }
        return true;
    }

    public String getEmail() {
        if (email == null) {
            email = "";
        }
        return email.trim();
    }

    @Override
    public boolean equals(Object o){
        if (o instanceof Cliente) {
            Cliente c = (Cliente) o;
            return this.email == c.email;
        }
        return false;
    }

    @Override
    public int hashCode(){
        return 42;
    }

    public void Atualiza(){ }
}
