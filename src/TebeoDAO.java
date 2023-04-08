import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TebeoDAO {

	private ArrayList<TebeoDTO> coleccion = new ArrayList<TebeoDTO>();
	private TebeoDTO tebeo;

	public void verBBDD() throws Exception {
		
		ResultSet resultSet = null;
		
		Conexion conector = new Conexion();
		
		try {

			resultSet = conector.getStatement().executeQuery("select * from tebeo");
			
			while(resultSet.next()) {
				
				for(int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
					System.out.print(resultSet.getString(i) + " | ");
				}
				System.out.println("");
			}
			
			conector.getStatement().close();
			conector.getConnect().close();
			
		}catch (Exception e) {
			System.out.println("Error al realizar la consulta " + e.getLocalizedMessage());
		}finally {
			try {
				conector.cerrarConexion(resultSet, conector.getConnect(), conector.getStatement());
			}catch (Exception e) {
				System.out.println("Error al cerrar las conexiones " + e.getLocalizedMessage());
			}
		}
		
	}
	
	public void crearTebeo (TebeoDTO dto) throws SQLException {
		
		try {
			
			Conexion conectar = new Conexion(); 
		
			PreparedStatement preparedStatement = conectar.getConnect().prepareStatement("INSERT INTO tebeo (ISBN, titulo, numero, coleccion) VALUES (?, ?, ?, ?)");
			
			preparedStatement.setInt(1, dto.getIsbn());
			preparedStatement.setString(2, dto.getTitulo());
			preparedStatement.setInt(3, dto.getNumero());
			preparedStatement.setString(4, dto.getColeccion());
			
			preparedStatement.addBatch();
			preparedStatement.executeBatch();
			
			conectar.getStatement().close();
			conectar.getConnect().close();
			
			System.out.println("El nuevo tebeo se ha creado correctamente");
			
		}catch (Exception e) {
			
			System.out.println("El nuevo tebeo no se ha podido incluir");	
		}
		
	}
	
	/**
	 * 
	 *
	 * @param isbn
	 * @return: 0 ->
	 * 			1 ->
	 */
	public int buscarTebeoIsbn (Integer isbn) {
		ResultSet resultSet = null;
		
		Conexion conector = new Conexion();
		
		try {
			resultSet = conector.getStatement().executeQuery("select isbn from tebeo");
			
			while(resultSet.next()) {
				
				for(int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
					if(resultSet.getInt(i) == isbn) {
						return 0;
					}		
				}
				System.out.println("");
			}
			
			conector.getStatement().close();
			conector.getConnect().close();
			
			return 1;
			
		}catch (Exception e) {
			System.out.println("Error al realizar la consulta " + e.getLocalizedMessage());
			return 2;
		}finally {
			try {
				conector.cerrarConexion(resultSet, conector.getConnect(), conector.getStatement());
			}catch (Exception e) {
				System.out.println("Error al cerrar las conexiones " + e.getLocalizedMessage());
				return 3;
			}
		}
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
