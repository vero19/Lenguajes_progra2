
//Librerias incluidas
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Console;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Prolog {
	public static ListaDoble ListaBase = new ListaDoble(); // lista que guardara la base de conocimiento
	
    public static void main(String args[]) throws Exception {
    	menu();
    }
    
    /*menu()
    Inicia el programa, permite al usuario ingresar los datos que desea
    Si el usuario desea modificar la base de conocimientos, debe ingresar "[user]."
    Y si desea realizar una consulta, debe escribirla según corresponda
    */
    public static void menu() throws Exception {
		try {
			String dato = "";
	    	String base = "[user].";
	    	String salir = "halt.";
	    	BufferedReader lectura = new BufferedReader(new InputStreamReader (System.in));
			System.out.println("\n ?- ");
			dato = lectura.readLine();
			if(dato.equals(base)){
				baseConocimiento();
			}
			else if(dato.equals(salir))
				System.exit(0);
			else
				consulta(dato);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    /* baseConocimiento()
    Permite que el usuario ingresa reglas o hechos a la base de conocimientos
    */
    public static void baseConocimiento() throws Exception{
    	try{
	    	System.out.println("|:");
	    	InputStreamReader isr = new InputStreamReader(System.in);
	        BufferedReader br = new BufferedReader(isr);
	        String dat = br.readLine();
	        String dato = dat + "\n";
	        String dato1 = "[exit]."+ "\n";
	        if(dato.equals(dato1.toString()))
	        	menu();
	        
	        else{
		        FileWriter fichero = (new FileWriter("nuevo"));
		        PrintWriter p = new PrintWriter(fichero);
		        p.print(dato+"\n");
		        fichero.close();
		        
		        Analex a = new Analex();
		        
		        int numero = a.main(dato);
		        if(numero == 1){;}
		        else{sintactico(dat);}
		        
		        baseConocimiento();
	        }
    	}
    	catch (IOException e){
    		System.exit(0);
    	}
        
    	
    }
    
    /*Funcion: ingresarReglas()
     * Esta funcion se encarga de agregar la regla ingresada por el usuario
     * a la base de conocimientos
     * El dato se encuentra en el archivo "nuevo", y lo guarda en una listaDoble
     * llamada BaseDeConocimiento*/
    public static void ingresarReglas(String dato){
    	ListaDoble ListaPredicado= new ListaDoble();
		ListaBase.InsertaLista(ListaPredicado.separarPredicados(dato));
    }
    
    /*Funcion: ingresarHechos()
     * Esta funcion se encarga de agregar los hechos ingresada por el usuario
     * a la base de conocimientos
     * El dato se encuentra en el archivo "nuevo", y lo guarda en una listaDoble
     * llamada BaseDeConocimiento*/
    public static void ingresarHechos(String dato){
    	ListaDoble ListaPredicado= new ListaDoble();
    	//ListaBase.Inserta(dato);
    	
		ListaBase.InsertaLista(ListaPredicado.separarHechos(dato));
		ListaBase.Imprimir();
		
    }
    
    public static void sintactico(String dato) throws Exception{
    	parser p = new parser();
		p.main("");
    	
		FileReader fichero = (new FileReader("reglas.txt"));
		if(fichero.read()<0)
			ingresarReglas(dato);
		else{
			sintactico s = new sintactico();
			s.main("");
			
			FileReader fr = (new FileReader("hechos.txt"));
			if(fr.read()<0){
				FileWriter fichero1 = (new FileWriter("reglas.txt"));
				fichero1.write("");
				ingresarHechos(dato);
			}
			else{
				BufferedReader lectura = new BufferedReader(fichero);
				while(lectura.ready()){
					String linea;
					if(!(linea=lectura.readLine()).equals("\000"))
						System.err.println("Err"+linea);
				}
				FileWriter fichero1 = (new FileWriter("reglas.txt"));
				fichero1.write("");
				FileWriter fichero2 = (new FileWriter("hechos.txt"));
				fichero2.write("");
			}
		}
    }
    
    /*consulta
    Realiza la consulta, según el dato ingresado por el usuario anteriormente
    */
    private static void consulta(String dato) throws Exception{
    	String consulta = "";
    	BufferedReader lec = new BufferedReader(new InputStreamReader (System.in));
		
		menu();
    	
    }
    
    
}
