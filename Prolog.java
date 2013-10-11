
//Librerias incluidas
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Console;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Prolog {
	public static ArrayList base = new ArrayList();
	
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
    public static void baseConocimiento() throws IOException{
    	try{
	    	System.out.println("|: ");
	    	InputStreamReader isr = new InputStreamReader(System.in);
	        BufferedReader br = new BufferedReader(isr);
	        String dato = br.readLine() + "\n";
	        String dato1 = "[exit]."+ "\n"; ;
	        if(dato.equals(dato1.toString()))
	        	System.exit(0);
	        
		        FileWriter fichero = (new FileWriter("/home/vero/Escritorio/archivo"));
		        PrintWriter p = new PrintWriter(fichero);
		        fichero.write(dato);
		        p.print(dato);
		        fichero.append("hdowe");
		        fichero.write("");
		        fichero.close();
		        
		        Analex a = new Analex();
		        int numero = a.main(dato);
		        System.out.println(numero);
		        
		        if(numero == 1){
		        	System.out.println("ENCONTRO ERROR");
		        }
		        else{
		        	System.out.println("bien");
		        	base.add(dato);
		        }
		        baseConocimiento();
    	}
    	catch (IOException e){
    		System.exit(0);
    	}
        
    	
    }
    
    /*consulta
    Realiza la consulta, según el dato ingresado por el usuario anteriormente
    */
    private static void consulta(String dato){
    	
    }
}
