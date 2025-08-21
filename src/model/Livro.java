package model;

public class Livro {

	private String titulo;
	private String autor;
	private String isbn;
	private String edicao;
	private String status;
	
	public Livro(String titulo, String autor, String isbn, String edicao, String status) {
		this.titulo = titulo;
		this.autor = autor;
		this.isbn = isbn;
		this.edicao = edicao;
		this.status = status;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getEdicao() {
		return edicao;
	}

	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}
}

