
public class RealizaDTO {

	private int tebeo;
	private int autor;
	
	public RealizaDTO () {
		this.tebeo = 0;
		this.autor = 0;
	}
	
	public RealizaDTO (int tebeo, int autor) {
		this.tebeo=tebeo;
		this.autor=autor;
	}
	
	public int getTebeo() {
		return tebeo;
	}
	public void setTebeo(int tebeo) {
		this.tebeo = tebeo;
	}
	public int getAutor() {
		return autor;
	}
	public void setAutor(int autor) {
		this.autor = autor;
	}
	
	
	
}
