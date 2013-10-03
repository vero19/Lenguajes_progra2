//Librerias incluidas
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prolog {

    public static void main(String args[]) throws Exception {
    	menu();
    }
    
    /*menu()
    Inicia el programa, permite al usuario ingresar los datos que desea
    Si el usuario desea modificar la base de conocimientos, debe ingresar "[user]."
    Y si desea realizar una consulta, debe escribirla según 
    */
    public static void menu() {
		try {
			String dato = "";
	    	String base = "[user].";
	    	BufferedReader lectura = new BufferedReader(new InputStreamReader (System.in));
			System.out.println("?- ");
			dato = lectura.readLine();
			if(dato.equals(base)){
				baseConocimiento();
			}
			else
				consulta(dato);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
    }
    
    /* baseConocimiento()
    Permite que el usuario ingresa reglas o hechos a la base de conocimientos
    */
    private static void baseConocimiento() throws IOException{
    	System.out.println("|: ");
    	InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        String line;
        while((line=br.readLine())!=null) { // readLine devuelve null al leer EOF
            System.out.println("|: "); // aqui procesas la linea de texto
        }

        System.out.println("Termino la base");
        System.out.println("hola");
        
    }
    
    /*consulta
    Realiza la consulta, según el dato ingresado por el usuario anteriormente
    */
    private static void consulta(String dato){
    	
    }
}
