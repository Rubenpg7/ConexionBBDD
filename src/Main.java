import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		
		Scanner sc;
		
		Integer isbn = 0, numero = 0;
		String titulo = "", coleccion = "";
		
		TebeoDAO tdao = new TebeoDAO();
		
		tdao.verBBDD(null);
		for(TebeoDTO tb : tdao.getColeccion()) {
			System.out.println(tb.getTitulo());
			
		}
		
		try {
			sc = new Scanner(System.in);
			
			System.out.println("Introduce el isbn");
			isbn = sc.nextInt();
			sc.nextLine();
			
			if(tdao.buscarTebeoIsbn(isbn) == 1) {
				
				System.out.println("Introduce el titulo");
				titulo = sc.nextLine();
				
				System.out.println("Introduce el numero");
				numero = sc.nextInt();
				sc.nextLine();
				
				System.out.println("Introduce la coleccion");
				coleccion = sc.nextLine();
				
				TebeoDTO t = new TebeoDTO(isbn, titulo, numero, coleccion);
				tdao.crearTebeo(t);
				
				tdao.verBBDD(null);
			}
			else {
				System.out.println("El isbn ya existe");
			}
		}catch (Exception e){
			System.out.println("Error al meter los datos");
		}
	}
}
