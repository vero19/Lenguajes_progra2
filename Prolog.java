
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
			String dato = ""; // Variable que guardará el valor que el usuario ingreso
	    	String base = "[user].";
	    	String salir = "halt.";
	    	BufferedReader lectura = new BufferedReader(new InputStreamReader (System.in));
			System.out.print("\n ?- ");
			dato = lectura.readLine();
			if(dato.equals(base)){ // Si el usuario ingreso [user]. ingresa al modo de base de conocimientos
				baseConocimiento();
			}
			else if(dato.equals(salir)) // Si el usuario ingreso halt. sale del programa
				System.exit(0);
			else
				consulta(dato); // Los demás que ingreso el usuario se va a la funcion de consulta
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    /* baseConocimiento()
    Permite que el usuario ingresa reglas o hechos a la base de conocimientos
    */
    public static void baseConocimiento() throws Exception{
    	try{
	    	System.out.print("|:");
	    	//lee lo que ingreso el usuario
	    	InputStreamReader isr = new InputStreamReader(System.in);
	        BufferedReader br = new BufferedReader(isr);
	        String dat = br.readLine(); // lo que ingreso el usuario lo guarda en dat
	        String dato = dat + "\n"; 
	        String dato1 = "[exit]."+ "\n";
	        // Si el usuario ingreso [exit]. envia true y se sale del modo de base de conocimiento
	        if(dato.equals(dato1.toString())){  
	        	System.out.println("true.");
	        	menu();
	        }	       
	        else{
		        FileWriter fichero = (new FileWriter("nuevo"));
		        PrintWriter p = new PrintWriter(fichero);
		        p.print(dato+"\n"); // Guardo el dato que ingreso el usuario en el archivo nuevo
		        fichero.close();
		        
		        Analex a = new Analex();
		        
		        int numero = a.main(dato); // Realiza el analisis lexico
		        if(numero == 1){;} // Si el numero es igual a 1, indica que hubo error lexico
		        else{sintactico(dat);} // Sino realiza el analisis sintactico
		        
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
    	ListaBase.InsertaLista(ListaPredicado.separarHechos(dato));	
    }
    
    /*Funcion sintactico()
     * Esta funcion se encarga de analizar si existe algun error sintactico en el hecho/recla ingresado
     */
    public static void sintactico(String dato) throws Exception{
    	//Analisis sintactico en caso que sea una regla
    	parser p = new parser();
		p.main("");
    	
		// Si el archivo reglas.txt esta vacio la regla ingresa esta sintacticamente correcta
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
    
    /*Funcion sintactico()
     * Esta funcion se encarga de analizar si existe algun error sintactico en el hecho/recla ingresado
     */
    public static int analisisSintactico(String dato) throws Exception{
    	//Analisis sintactico en caso que sea una regla
    	parser p = new parser();
		p.main("");
    	
		// Si el archivo reglas.txt esta vacio la regla ingresa esta sintacticamente correcta
		FileReader fichero = (new FileReader("reglas.txt"));
		if(fichero.read()<0) {
			System.out.println("ERROR: Undefined procedure: (:-)/2 \n ERROR:   Rules must be loaded from a file");
			return 3;
		}
		else{
			sintactico s = new sintactico();
			s.main("");
			
			FileReader fr = (new FileReader("hechos.txt"));
			if(fr.read()<0){
				FileWriter fichero1 = (new FileWriter("reglas.txt"));
				fichero1.write("");
				return 2;
			}
			else{
				FileWriter fichero1 = (new FileWriter("reglas.txt"));
				fichero1.write("");
				FileWriter fichero2 = (new FileWriter("hechos.txt"));
				fichero2.write("");
				return 1;
			}
		}
		
    }
    
    /*consulta
    Realiza la consulta, según el dato ingresado por el usuario anteriormente
    */
    private static void consulta(String dato) throws Exception{
    	FileWriter fichero = (new FileWriter("nuevo"));
        PrintWriter p = new PrintWriter(fichero);
        p.print(dato+"\n");
        fichero.close();
        
    	//ver si es un hecho??
        int numAna = analisisSintactico(dato);
		if (numAna == 2)
			unificacion(dato);
		else if (numAna == 3)
			;
		else
			consultaHechos(dato);
		menu();
    }
    
    static void consultaHechos(String dato)throws Exception{      
        FileReader fichero1 = (new FileReader("nuevo"));
        StringBuffer str = new StringBuffer();
        ListaDoble consulta = new ListaDoble();
        try{
        	int c;
        	while ((c=fichero1.read())!=-1){
        		if((char)c == '('){
        			String a = String.valueOf((char)c);
        			str.append(a);
        			while ((c=fichero1.read())!=-1){
        				if ((char)c == ')'){
        					a = String.valueOf((char)c);
                			str.append(a);
                			consulta.Inserta(str.toString()+ ".");
                			str.delete(0, str.length());
                			break;
                		}
        				else 
        					str.append(String.valueOf((char)c));
        			}
        		}
	        	else if  ((char)c == ','){
	        		if(str.length() == 0)
	        			;
	        		else {
	        			//str.append(String.valueOf((char)c));
	        			consulta.Inserta(str.toString()+ ".");
	        			str.delete(0, str.length());
	        		}	
	        	}
	        	else
	        		str.append(String.valueOf((char)c));
        	}
        	realizarConsulta(consulta);
        	menu();
        	
        }
        catch(IOException ex){}
    	//BufferedReader lec = new BufferedReader(new InputStreamReader (System.in));
    	//String consulta = lec.readLine();
    }
    
    static void realizarConsulta(ListaDoble lista)throws Exception{
    	NodosListaDoble aux1 = lista.PrimeroDoble;
    	ListaDoble datosImprimir = new ListaDoble();
    	while(aux1!=null){
    		String texto = aux1.argumento.toString();
    		
    		// Datos que ingreso el usuario en la consulta
        	StringTokenizer consulta=new StringTokenizer(texto,"(");
        	String regla = consulta.nextToken();
        	String demas = consulta.nextToken();
        	
        	StringTokenizer args =new StringTokenizer(demas,")");
        	String argumentos = args.nextToken(); //valores antes del )
        	      	
        	NodosListaDoble aux= ListaBase.PrimeroDoble;
        	String datoBase = aux.lista.PrimeroDoble.argumento;
        	
        	//Datos que estan en la base de conocimientos
        	StringTokenizer base=new StringTokenizer(datoBase,"(");
        	String predicado = base.nextToken();
        	String antecedentes =  base.nextToken() + ".";

        	//boolean imprimio=false;
        	int valores=0;
        	if(!(ListaBase.VaciaLista())){
        		while(aux!=null){
        			base = new StringTokenizer(aux.lista.PrimeroDoble.argumento,"(");
	    			predicado = base.nextToken();
	    			antecedentes = base.nextToken() + ".";
	    			if(regla.equals("write")){
	    				datosImprimir.Inserta(argumentos);
	    				break;
	    			}
	    			else if(UpperCase(demas)){
    	    			if(regla.equals(predicado)){
    	    				StringTokenizer fin =new StringTokenizer(antecedentes,")");
    	    		    	String ant = fin.nextToken();
    	    		    	String [] datBase, datoConsulta;
    	    		    	datoConsulta = ant.split(",");
    	    		    	datBase = argumentos.split(",");
    	    		    	if(datBase.length == datoConsulta.length){
    	    		    		int posicion = 0;
    	    		    		while(posicion != datBase.length){
    	    		    			String dats = datBase[posicion] + " = " + datoConsulta[posicion]+ " ";
    	    		    			datosImprimir.Inserta(dats);
    	    		    			posicion++;
    	    		    			valores++;
    	    		    		}
    	    		    		aux = aux.siguiente;
    	    		    	}	
    	    		    	else aux = aux.siguiente; 
    	    		    }
    	    			else aux = aux.siguiente;
    	    		}
    	    		else if ((regla.equals(predicado)) && (demas.equals(antecedentes))){//compara si la expresion ingresada esta en la base de conocimiento
    	    			valores++;
    					break;
    	    		}
    	    		aux = aux.siguiente;
    	    	}
        		if(aux == null){
	    			datosImprimir.Inserta("false");
        			imprimir(datosImprimir);
	    		}
        		aux1 = aux1.siguiente;
        	}
        	else System.out.println("No hay datos en la base de conocimientos");
        	
    	}
    	datosImprimir.Inserta("true");
		imprimir(datosImprimir);
    }
    
    public static void imprimir(ListaDoble datosImprimir)throws Exception{
    	NodosListaDoble aux = datosImprimir.PrimeroDoble;
    	while (aux != null){
    		System.out.println(aux.argumento.toString());
    		aux = aux.siguiente;
    	}
    	menu();
    }
    
    /*static ListaDoble revisarHecho(String texto, ListaDoble lista) throws Exception{
		// Datos que ingreso el usuario en la consulta
    	StringTokenizer consulta=new StringTokenizer(texto,"(");
    	String regla = consulta.nextToken();
    	String demas = consulta.nextToken();
    	
    	StringTokenizer args =new StringTokenizer(demas,")");
    	String argumentos = args.nextToken(); //valores antes del )
    	
    	NodosListaDoble aux= ListaBase.PrimeroDoble;
    	String datoBase = aux.lista.PrimeroDoble.argumento;
    	
    	//Datos que estan en la base de conocimientos
    	StringTokenizer base=new StringTokenizer(datoBase,"(");
    	String predicado = base.nextToken();
    	String antecedentes =  base.nextToken() + ".";
    	
    	//boolean imprimio=false;
    	int valores=0;
    	if(!(ListaBase.VaciaLista())){
    		while(aux!=null){
	    		if(UpperCase(demas)){
	    			base = new StringTokenizer(aux.lista.PrimeroDoble.argumento,"(");
	    			predicado = base.nextToken();
	    			antecedentes = base.nextToken() + ".";
	    			if(regla.equals(predicado)){
	    				StringTokenizer fin =new StringTokenizer(antecedentes,")");
	    		    	String ant = fin.nextToken();
	    		    	String [] datBase, datoConsulta;
	    		    	datoConsulta = ant.split(",");
	    		    	datBase = argumentos.split(",");
	    		    	valores++;
	    		    	if(datBase.length == datoConsulta.length){
	    		    		int posicion = 0;
	    		    		while(posicion != datBase.length){
	    		    			lista.Inserta(datBase[posicion] + " = " + datoConsulta[posicion]+ " ");
	    		    			valores++;
	    		    			posicion++;
	    		    			if(posicion == datBase.length);
	    		    			else ;}
	    		    		aux = aux.siguiente;
	    		    		if(aux != null){
	    		    			BufferedReader lectura = new BufferedReader(new InputStreamReader (System.in));
	    		    			System.out.print(" ");
	    		    			String cont = lectura.readLine();
	    		    			if(cont.equals(";"));
	    		    			else break; }
	    		    	}	else aux = aux.siguiente; }
	    					else{aux = aux.siguiente;} }}
    		if(valores==0)
    			lista.Inserta("false");}
    	else ; 
    		return lista;
    }*/
      
    static void unificacion(String texto) throws Exception{
		// Datos que ingreso el usuario en la consulta
    	StringTokenizer consulta=new StringTokenizer(texto,"(");
    	String regla = consulta.nextToken();
    	String demas = consulta.nextToken();
    	
    	StringTokenizer args =new StringTokenizer(demas,")");
    	String argumentos = args.nextToken(); //valores antes del )
    	
    	NodosListaDoble aux= ListaBase.PrimeroDoble;
    	String datoBase = aux.lista.PrimeroDoble.argumento;
    	
    	//Datos que estan en la base de conocimientos
    	StringTokenizer base=new StringTokenizer(datoBase,"(");
    	String predicado = base.nextToken();
    	String antecedentes =  base.nextToken() + ".";
    	
    	//boolean imprimio=false;
    	int valores=0;
    	if(!(ListaBase.VaciaLista())){
    		while(aux!=null){
	    		if(UpperCase(demas)){
	    			base = new StringTokenizer(aux.lista.PrimeroDoble.argumento,"(");
	    			predicado = base.nextToken();
	    			antecedentes = base.nextToken() + ".";
	    			if(regla.equals(predicado)){
	    				StringTokenizer fin =new StringTokenizer(antecedentes,")");
	    		    	String ant = fin.nextToken();
	    		    	String [] datBase, datoConsulta;
	    		    	datoConsulta = ant.split(",");
	    		    	datBase = argumentos.split(",");
	    		    	valores++;
	    		    	if(datBase.length == datoConsulta.length){
	    		    		int posicion = 0;
	    		    		while(posicion != datBase.length){
	    		    			System.out.print(datBase[posicion] + " = " + datoConsulta[posicion]+ " ");
	    		    			posicion++;
	    		    			if(posicion == datBase.length);
	    		    			else System.out.print("\n");}
	    		    		aux = aux.siguiente;
	    		    		if(aux != null){
	    		    			BufferedReader lectura = new BufferedReader(new InputStreamReader (System.in));
	    		    			System.out.print(" ");
	    		    			String cont = lectura.readLine();
	    		    			if(cont.equals(";"));
	    		    			else break; }
	    		    	}	else aux = aux.siguiente; }
	    					else{aux = aux.siguiente;} }
	    		else if ((regla.equals(predicado)) && (demas.equals(antecedentes))){//compara si la expresion ingresada esta en la base de conocimiento
	    			System.out.println("YES");
					break;
	    		}
	    		else{
	    			aux= aux.siguiente;//pasa al siguiente punto de la base de conocimiento
	    			if(aux!=null){
	    				String bas = aux.lista.PrimeroDoble.argumento;
	    				StringTokenizer ba =new StringTokenizer(bas,"(");
	    				predicado = ba.nextToken();
	    				antecedentes = ba.nextToken()+".";
	    				String sig = aux.lista.PrimeroDoble.siguiente.argumento;
	    				if(sig.equals(":-")){
	    					ListaDoble nueva = new ListaDoble();
	    					nueva.InsertaInicio(regla, argumentos);
	    					if(!(evaluar(aux.lista,nueva.PrimeroDoble))){
	    						aux = aux.siguiente;
	    						if(aux != null && aux.argumento!="."){
		    						String bas1 = aux.lista.PrimeroDoble.argumento;
		    	    				StringTokenizer ba1 =new StringTokenizer(bas1,"(");
		    	    				predicado = ba.nextToken();
		    	    				antecedentes = ba.nextToken()+".";}
	    	    				}
	    					else{
	    						System.out.println("YES");
	    						valores = -3;
	    						break;
	    					}	
	    				}
	    			}
	    			else{
	    				if(valores>0)
	    					System.out.println("true.");
	    				else if (valores == -3)
	    					;
	    				else if(valores <= 0)
	    					System.out.println("false.");
	    				}
	    			}	
    			}
    		}
			menu();
    }

		static boolean UpperCase(String str){
			for(int i=0; i<str.length(); i++){
				char c = str.charAt(i);
				if(c >= 97 && c <= 122) {
					return false;
				}
			}
			return true;
		}

		static int cantidadArgus(String arg){
			int cantidad = 1;
			for(int i=0; i<arg.length(); i++){
				char c = arg.charAt(i);
				if(c == 44)
					cantidad++;
			}
			return cantidad;
		}
    
  //Metodo que realiza la evaluacion de las premisas
  	public static boolean evaluar(ListaDoble lista, NodosListaDoble te) throws Exception{
  		NodosListaDoble pt = lista.PrimeroDoble.siguiente.siguiente;
  		while (pt!=null){
  			StringTokenizer arg = new StringTokenizer(pt.argumento,"(");
			String c1 = arg.nextToken();
  			if (c1.equals("write")){
  				String c2 = arg.nextToken();
  				System.out.println(c2);
  				pt.check = true;
  				if (pt.siguiente == null)
  					break;
  				pt = pt.siguiente;
  			}//Fin del if 1
  			else if(c1.equals("."))
  				break;
  			else {
  				if (c1.equals("nl")){
  					System.out.println('\n');
  					pt.check = true;
  					if (pt.siguiente == null)
  	  					break;
  					pt = pt.siguiente;
  				}//Fin del if 2
  				else{
  					if (c1.equals(":-")){
  						pt = pt.siguiente;
  					}//Fin del if
  					else {
  						if (c1.equals("fail")){
  							return false;
  						}//Fin del if
  						else{
  							String args = lista.PrimeroDoble.argumento;
  							StringTokenizer princ = new StringTokenizer(args,",");
  							String b1 = princ.nextToken();
  							String b2 = princ.nextToken();
  							//Tokenizer que separa los argumento
  							String ayuda = te.argumento;
  							StringTokenizer argun = new StringTokenizer(ayuda,",");
  							String a1 = argun.nextToken();
  							String a2 = argun.nextToken();
  							if (pt.argumento == b1){
  								String m = pt.argumento;
  								StringTokenizer regla1 = new StringTokenizer(m,"(");
  								String re = regla1.nextToken();
  								NodosListaDoble t = new NodosListaDoble (re, a1);
  								if (revisar(t)){
  									pt = pt.siguiente;
  								}//Fin del if 2
  								else{
  									return false;
  								}//Fin del else 2
  							}//fin del if
  							else{
  								String m = pt.argumento;
  								StringTokenizer regla1 = new StringTokenizer(m,"(");
  								String re = regla1.nextToken();
  								NodosListaDoble w = new NodosListaDoble (re, a2);
  								if (revisar(w)){
  									pt = pt.siguiente;
  								}//Fin del if
  								else{
  									return false;
  								}//Fin del else
  							}//fin del else
  						}//Fin del else2
  					}//Fin del else
  				}//Fin del else
  			}//Fin del else
  		}//Fin del while
  		return true;
  	}//Fin de evaluar
    
    //Revisa las consultas que requieren backtraking
    static boolean revisar(NodosListaDoble datoBuscar) throws Exception{
    	//Lo que me envian para buscar en la base
    	String hecho = datoBuscar.regla;
    	String argumento = datoBuscar.argumento;
    	//El primer noco de la lista
    	NodosListaDoble aux= ListaBase.PrimeroDoble;
    	//String datoBase = aux.lista.PrimeroDoble.argumento;
    	
    	if(!(ListaBase.VaciaLista())){
    		while(aux!=null){
    			String datoBase = aux.lista.PrimeroDoble.argumento;
    			StringTokenizer datoRegla = new StringTokenizer(datoBase,"(");
    			String regla = datoRegla.nextToken();  // Contiene el valor de la regla en la base
    			
    			String arg = datoRegla.nextToken();
    			StringTokenizer datoArgumentos = new StringTokenizer(arg,")");
    			String valorArg = datoArgumentos.nextToken(); // Contine el valor de los argumentos
    			
    			if(hecho.equals(regla) && argumento.equals(valorArg)){
    				return true;
    			}
    			else{
    				aux = aux.siguiente;
    				if(aux == null){
    					System.out.println("false");
    					return false;
    				}
    			}
    		}
    	}
    	else{
    		System.out.println("false");
    		return false;
    	}
		return false;
    }
}
    
   
    
