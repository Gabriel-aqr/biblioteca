package controller;

public class Emprestimo {
	
	private int indiceLivro;
	private String aluno;

	public Emprestimo(int indiceLivro, String aluno) {
		this.setIndiceLivro(indiceLivro);
		this.setAluno(aluno);
	}

	public int getIndiceLivro() {
		return indiceLivro;
	}

	public void setIndiceLivro(int indiceLivro) {
		this.indiceLivro = indiceLivro;
	}

	public String getAluno() {
		return aluno;
	}

	public void setAluno(String aluno) {
		this.aluno = aluno;
	}

}
