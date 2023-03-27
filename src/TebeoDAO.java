import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class TebeoDAO {

	private ArrayList<TebeoDTO> coleccion = new ArrayList<TebeoDTO>();
	private TebeoDTO tebeo;

	
	public void crearTebeo (TebeoDTO dto) throws SQLException {
		
		Conexion conectar = new Conexion();
		
		PreparedStatement preparedStatement = conectar.getConnect().prepareStatement("INSERT INTO tebeo (ISBN, titulo, numero, coleccion) VALUES (?, ?, ?, ?)");
		
		try {
			
			preparedStatement.setString(1, "78542");
			preparedStatement.setString(2, "titulo");
			preparedStatement.setString(3, "1");
			preparedStatement.setString(4, "coleccion");
			
			conectar.getStatement().close();
			conectar.getConnect().close();
			
			System.out.println("El nuevo tebeo se ha creado correctamente");
			
		}catch (Exception e) {
			
			System.out.println("El nuevo tebeo no se ha podido incluir");	
		}
		
	}
	
	public void buscarTebeo (TebeoDTO dto) {
		
	}
	
	public void modificarTebeo (TebeoDTO dto) {
		
	}
	
	public void eliminarTebeo (TebeoDTO dto) {
		
	}
	
	public ArrayList<TebeoDTO> getColeccion() {
		return coleccion;
	}

	public void setColeccion(ArrayList<TebeoDTO> coleccion) {
		this.coleccion = coleccion;
	}

	public TebeoDTO getTebeo() {
		return tebeo;
	}

	public void setTebeo(TebeoDTO tebeo) {
		this.tebeo = tebeo;
	}
	
}
