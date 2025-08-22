package view;

import java.util.Scanner;
import controller.Biblioteca;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Bem-vindo à Biblioteca!");

        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Cadastrar Livro");
            System.out.println("2 - Emprestar Livro");
            System.out.println("3 - Listar Livros");
            System.out.println("4 - Listar Empréstimos");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            String opcao = sc.next();

            switch (opcao) {
                case "1":
                    System.out.println("Digite o título do livro:");
                    sc.nextLine();
                    String titulo = sc.nextLine();

                    System.out.println("Digite o autor do livro:");
                    String autor = sc.nextLine();

                    System.out.println("Digite o ISBN do livro:");
                    String isbn = sc.nextLine();

                    System.out.println("Digite a edição do livro:");
                    String edicao = sc.nextLine();

                    System.out.println("Digite o status do livro (livre/emprestado):");
                    String status = sc.nextLine();

                    Biblioteca.cadastrarLivro(titulo, autor, isbn, edicao, status);
                    break;

                case "2":
                    Biblioteca.listarLivros();
                    System.out.println("Digite o índice do livro que deseja emprestar:");
                    int indice = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Digite o nome do aluno:");
                    String aluno = sc.nextLine();

                    Biblioteca.emprestarLivro(indice, aluno);
                    break;

                case "3":
                    Biblioteca.listarLivros();
                    System.out.println("\n");
                    break;

                case "4":
                    Biblioteca.listarEmprestimos();
                    System.out.println("\n");
                    break;

                case "0":
                    System.out.println("Programa encerrado.");
                    System.out.println("\n");
                    sc.close();
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
