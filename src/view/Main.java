package view;

import java.util.Scanner;
import controller.Biblioteca;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("");
		Biblioteca.cadastrarLivro("Dom Quixote", "Miguel de Cervantes", "9781589770034", "Primeira edição", "livre");
		Biblioteca.cadastrarLivro("O Pequeno Príncipe", "Antoine de Saint-Exupéry", "9781529530034", "Primeira edição", "livre");
		Biblioteca.listarLivros();
		Biblioteca.emprestarLivro(0, "João");
		Biblioteca.listarEmprestimos();
		sc.close();
	}

}