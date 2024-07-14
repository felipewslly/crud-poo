package CRUD;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Itens {
    protected List<Itens> lista = new ArrayList<>();
    protected int id;
    protected String nome;
    protected double preco;
    protected boolean sair;



    public Itens(int id, String nome, double preco) {
        this.id = id;
        this.nome= nome;
        this.preco = preco;
    }



    public void setId(int id) {
        this.id = id;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setLista(List<Itens> lista) {
        this.lista = lista;
    }

    public List<Itens> getLista() {
        return lista;
    }



    public int getId() {
        return id;
    }


    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString(){
        return "ID: " + id + ", NOME: " + nome + ", PREÇO: " + preco;
    }
}
