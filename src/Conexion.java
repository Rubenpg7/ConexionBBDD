import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Conexion {

	final private String driver = "com.mysql.cj.jdbc.Driver";
	final private String host = "localhost";
	final private String bbdd = "tebeoteca";
	final private String user = "root";
	final private String passwd = "Admin123"; //admin --> contraseña para clase
	
	private Statement statement;
	private Connection connect;
	
	public Conexion () {
		
		try {
			Class.forName(driver);
		//	"jdbc:mysql://localhost/tebeoteca?user=root&password=admin"
			connect = DriverManager.getConnection("jdbc:mysql:// " + host + "/"+bbdd+"?" + "user=" + user + "&password=" + passwd);
			//connect = DriverManager.getConnection("jdbc:mysql:// " + host + "/"+bbdd+"?serverTimezone=UTC", user, passwd);
			
			statement = connect.createStatement();
			
		}catch (Exception e) {
			System.out.println("Error al crear la conexion " + e.getLocalizedMessage());
		}
	}
	
	public void cerrarConexion (ResultSet resultSet, Connection connect, Statement statement) {
		
		try {
			if(resultSet != null) {
				resultSet.close();
			}
			if(statement != null) {
				statement.close();
			}
			if(connect != null) {
				connect.close();
			}
			
		}catch (Exception e) {
		}
	}

	public Statement getStatement() {
		return statement;
	}

	public void setStatement(Statement statement) {
		this.statement = statement;
	}

	public Connection getConnect() {
		return connect;
	}

	public void setConnect(Connection connect) {
		this.connect = connect;
	}
	
	

}
