import java.util.ArrayList;

public class AutorDAO {

	private ArrayList<AutorDTO> autores = new ArrayList<AutorDTO>();

	
	public void crearAutor (AutorDTO dto) {
		autores.add(dto);
	}
	
	
	public ArrayList<AutorDTO> getAutores() {
		return autores;
	}

	public void setAutores(ArrayList<AutorDTO> autores) {
		this.autores = autores;
	}
	
}
