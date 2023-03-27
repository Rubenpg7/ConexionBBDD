import java.sql.ResultSet;

public class Main {

	public static void main(String[] args) throws Exception {
		
		//realizarEjemplo();
		TebeoDTO t = new TebeoDTO(1,"Titulo", 1, "Coleccion");
		TebeoDAO tdao = new TebeoDAO();
		tdao.crearTebeo(t);
	}
	
	public static void realizarEjemplo() throws Exception {
		
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

}
