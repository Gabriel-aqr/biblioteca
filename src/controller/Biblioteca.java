package controller;

import java.util.ArrayList;
import java.util.Scanner;
import model.Livro;

public class Biblioteca {
    static Scanner scc = new Scanner(System.in);
    static ArrayList<Livro> livros = new ArrayList<>();
    static ArrayList<Emprestimo> emprestimos = new ArrayList<>();

    public static void cadastrarLivro(String titulo, String autor, String isbn, String edicao, String status) {
        boolean jaCadastrado = false;

        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo) || livro.getIsbn().equalsIgnoreCase(isbn)) {
                jaCadastrado = true;
                break;
            }
        }

        while (jaCadastrado) {
            System.out.println("Este livro já foi cadastrado. Digite 'continuar' para tentar novamente ou 'sair' para terminar o programa:");
            String resposta = scc.next();

            if (resposta.equalsIgnoreCase("sair")) {
                return; 
            } else if (resposta.equalsIgnoreCase("continuar")) {
                System.out.println("Digite o título:");
                titulo = scc.next();
                System.out.println("Digite o autor:");
                autor = scc.next();
                System.out.println("Digite o ISBN:");
                isbn = scc.next();
                System.out.println("Digite a edição:");
                edicao = scc.next();
                System.out.println("Digite o status (livre/emprestado):");
                status = scc.next();

                jaCadastrado = false;
                for (Livro livro : livros) {
                    if (livro.getTitulo().equalsIgnoreCase(titulo) || livro.getIsbn().equalsIgnoreCase(isbn)) {
                        jaCadastrado = true;
                        break;
                    }
                }
            } else {
                System.out.println("Comando inválido.");
            }
        }

        livros.add(new Livro(titulo, autor, isbn, edicao, status.toLowerCase()));
        System.out.println("Livro cadastrado com sucesso!");
    }

    public static void listarLivros() {
        System.out.println("Lista de livros disponíveis:");
        for (int i = 0; i < livros.size(); i++) {
            Livro l = livros.get(i);
            System.out.println(i + " - " + l.getTitulo() + " | Autor: " + l.getAutor()
                    + " | ISBN: " + l.getIsbn() + " | Edição: " + l.getEdicao()
                    + " | Status: " + l.getStatus());
        }
    }

    public static void emprestarLivro(int indiceLivro, String aluno) {
        if (livros.isEmpty()) {
            System.out.println("Ainda não há livros cadastrados.");
            return;
        }

        if (indiceLivro < 0 || indiceLivro >= livros.size()) {
            System.out.println("Índice de livro inválido.");
            return;
        }

        Livro livro = livros.get(indiceLivro);

        if (livro.getStatus().equalsIgnoreCase("livre")) {
            emprestimos.add(new Emprestimo(indiceLivro, aluno));
            livro.setStatus("emprestado");
            System.out.println("Livro '" + livro.getTitulo() + "' emprestado para " + aluno + ".");
        } else {
            System.out.println("Este livro já está emprestado.");
        }
    }

    public static void listarEmprestimos() {
        System.out.println("Empréstimos realizados:");
        for (Emprestimo e : emprestimos) {
            Livro livro = livros.get(e.getIndiceLivro());
            System.out.println("Aluno: " + e.getAluno() + " | Livro: " + livro.getTitulo());
        }
    }

    public static ArrayList<Livro> getLivros() {
        return livros;
    }

    public static void setLivros(ArrayList<Livro> livros) {
        Biblioteca.livros = livros;
    }

    public static ArrayList<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public static void setEmprestimos(ArrayList<Emprestimo> emprestimos) {
        Biblioteca.emprestimos = emprestimos;
    }
}
