public class TebeoDTO {

	private int isbn;
	private String titulo;
	private int numero;
	private String coleccion;
	
	
	public TebeoDTO () {
		this.isbn = 0;
		this.titulo = "";
		this.numero = 0;
		this.coleccion = "";
	}
	
	public TebeoDTO (int isbn, String titulo, int numero, String coleccion) {
		this.isbn=isbn;
		this.titulo=titulo;
		this.numero=numero;
		this.coleccion=coleccion;
	}

	

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getColeccion() {
		return coleccion;
	}

	public void setColeccion(String coleccion) {
		this.coleccion = coleccion;
	}
		
}
