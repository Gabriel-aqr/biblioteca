package controller;

import java.util.ArrayList;
import model.Livro;

public class Biblioteca {
	static ArrayList<Livro> livros = new ArrayList<>();
	static ArrayList<Emprestimo> emprestimos = new ArrayList<>();

	public static void cadastrarLivro(String titulo, String autor, String isbn, String edicao, String status) {
		livros.add(new Livro(titulo, autor, isbn, edicao, status.toLowerCase()));
		System.out.println("Livro cadastrado com sucesso!");
	}

		public static void listarLivros() {
			System.out.println("Lista de livros disponíveis:");
			for (int i = 0; i < livros.size(); i++) {
				System.out.println(i + " - " + livros.get(i).getTitulo() + " | Autor: "
						+ livros.get(i).getAutor() + " | ISBN: " + livros.get(i).getIsbn() + " | Edição: " + livros.get(i).getEdicao());
				}
		}

		public static void emprestarLivro(int indiceLivro, String aluno) {
			// NÃO verifica duplicidade ou regras de negócio
			if (livros.get(indiceLivro).getStatus() == "livre") {
				emprestimos.add(new Emprestimo(indiceLivro, aluno));
				System.out.println("Livro " + livros.get(indiceLivro).getTitulo() +
						" emprestado para " + aluno);
			} else {
				System.out.println("Este livro já está sendo usado.");
			}
		}

		public static void listarEmprestimos() {
			System.out.println("Empréstimos realizados:");
			for (Emprestimo e : emprestimos) {
				System.out.println("Aluno: " + e.getAluno() + " | Livro: " +
						livros.get(e.getIndiceLivro()).getTitulo());
			}
		}
}
