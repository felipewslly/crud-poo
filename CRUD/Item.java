package CRUD;

import java.util.Scanner;
public class Item extends Itens {

    Scanner scan = new Scanner(System.in);

    public Item(int id, String nome, double preco) {
        super(id, nome, preco);
    }

    public boolean nomeSemNum(String nome) {
        for (int i = 0; i < nome.length(); i++) {
            if (Character.isDigit(nome.charAt(i))) {
                return true;
            }

        }
        return false;
    }

    public void adicionarItem() {
        id++;
        System.out.println("Digite o item a ser adicionado: ");
        String nome = scan.next();
        if (nomeSemNum(nome)) {
            System.out.println("O nome não pode conter números");
            id--;
            mostrarMenu();

        }
        System.out.println("Digite o preço do item: ");
        double preco = scan.nextDouble();



        Itens item = new Itens(id, nome, preco);
        lista.add(item);
        System.out.println(item);
    }

    public void deletarItem() {
        if (lista.isEmpty()) {
            System.out.println("Lista vazia! ");
        }
        for (Itens item : lista) {
            System.out.println(item);
        }
        System.out.println("Escolha pelo ID qual item deseja deletar: ");
        int id1 = scan.nextInt();
        lista.removeIf(item -> item.id == id1);
        System.out.println(lista);
        mostrarMenu();
    }

    public void lerLista() {
        if (lista.isEmpty()) {
            System.out.println("Lista vazia.");
        }
        for (Itens item : lista) {
            System.out.println(item);
        }
    }

    public void editarLista() {
        if (lista.isEmpty()) {
            System.out.println("Lista vazia");
            mostrarMenu();
            return;
        }
        for (Itens item : lista) {
            System.out.println(item);
        }
        System.out.println("Digite o id do item que deseja editar: ");
        int id1 = scan.nextInt();
        for (int i = 0; i < lista.size(); i++) {
            int var = lista.get(i).getId();
            if (var == id1) {
                System.out.println("Digite o novo nome do item: ");
                String novoNome = scan.next();
                    if (nomeSemNum(novoNome)){
                        System.out.println("O nome não pode conter números");
                        mostrarMenu();
                    }
                System.out.println("Digite o novo valor: ");
                double valor = scan.nextDouble();
                scan.nextLine();
                Itens item1 = new Itens(id, novoNome, valor);
                lista.set(i, item1);
                System.out.println("Item editado com sucesso! " + lista);
                return;
            }

        }
    }

    public void mostrarMenu() {
        Scanner scan = new Scanner(System.in);
        while (!sair) {
            System.out.println("--------------------");
            System.out.println("1. ADICIONAR ITEM");
            System.out.println("2. LER LISTA");
            System.out.println("3. EXCLUIR ITEM");
            System.out.println("4. EDITAR ITEM");
            System.out.println("5. SAIR");
            System.out.println("---------------------");
            int escolha = scan.nextInt();
            scan.nextLine();
            switch (escolha) {
                case 1:
                    adicionarItem();
                    break;

                case 2:
                    lerLista();
                    break;

                case 3:
                    deletarItem();
                    break;
                case 4:
                    editarLista();
                    break;
                case 5:
                    sair = true;
            }

        }
        scan.close();
    }


}

