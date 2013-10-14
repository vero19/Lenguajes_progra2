

//Definici�n de la Clase Lista
 public class ListaDoble
{
  public NodosListaDoble PrimeroDoble;
  String Nombre;

//Constructor construye una lista vacia con un nombre s
 public ListaDoble (String s)
{ Nombre = s;
  PrimeroDoble = null;
}

//Retorna True si Lista Vac�a
 public boolean VaciaLista () {return PrimeroDoble == null;}

// Imprime el contenido de la lista
 public void Imprimir()
 { if (VaciaLista())
   {
     System.out.println( "vacia" +Nombre);
   }
   //fin del primer if
  else
  {
	  System.out.print( "La  " +  Nombre  +"  es:  ");
      NodosListaDoble Actual = PrimeroDoble;

     while (Actual != null)
	 {
      System.out.print (Actual.regla.toString() + " ");
      System.out.print (Actual.argumento.toString() + " ");
      Actual=Actual.siguiente;
     }

     System.out.println();
     System.out.println();
   }
 }


//Constructor construye una lista vacia con un nombre de List
public ListaDoble(){ this ("Lista");}

//Inserta un Elemento al Frente de la Lista
//Si esta vac�a PrimerNodo y UltimoNodo se refieren al nuevo nodo. Si no PrimerNodo se refiere al nuevo nodo.

public void InsertaInicio (String r, String a)
{ if (VaciaLista())
   PrimeroDoble = new NodosListaDoble (r,a);
  else
   PrimeroDoble = new NodosListaDoble (r, a, PrimeroDoble);
   PrimeroDoble.siguiente.anterior =PrimeroDoble;
}


//Inserta al Final de la Lista
//Si la lista se encuentra vac�a, el PrimerNodo y el UltimoNodo se refieren al nuevo nodo. Si no, la variable de siguiente de UltimoNodo se refiere al nuevo nodo.
public void InsertaFinal(String r, String a)
{ if ( VaciaLista())
     PrimeroDoble = new NodosListaDoble (r,a);
  else
     {
      NodosListaDoble aux= PrimeroDoble;
      while (aux.siguiente != null)
         aux = aux.siguiente;
         //Primera Forma
         aux.siguiente = new NodosListaDoble (r,a);
         aux.siguiente.anterior =aux;
    }
}//Fin de InsertaFinal

//Inserta un Elemento en una posici�n dada
//Si esta vac�a PrimerNodo y UltimoNodo se refieren al nuevo nodo.
//Si no PrimerNodo se refiere al nuevo nodo.

public void InsertaMedio (String r, String a,int Posicion)
{ if (VaciaLista())
      PrimeroDoble =  new NodosListaDoble (r,a);
  else
    { if (Posicion<=1)
      {
       /* Primera Forma 
        NodosListaD Nuevo = new NodosListaD(ElemInser);
        Nuevo.siguiente = PrimeroDoble;
        PrimeroDoble = Nuevo;
        PrimeroDoble.siguiente.anterior= PrimeroDoble;*/
        InsertaInicio (r,a);

 	  }
     else
      {
	 NodosListaDoble Aux = PrimeroDoble;
         int i = 2;
         while ( (i != Posicion) & (Aux.siguiente != null))
         {  i++;
            Aux = Aux.siguiente;
         }
         NodosListaDoble Nuevo = new NodosListaDoble(r,a);
         Nuevo.siguiente = Aux.siguiente;;
         Aux.siguiente =Nuevo;
         Nuevo.anterior=Aux;
         if (Aux.siguiente !=null)
            Nuevo.siguiente.anterior=Nuevo;
	 }
 }
}


//Eliminar al Inicio
//Debe tomar en cuenta si la lista se encuentra vac�a y producir una excepci�n, en caso contrario si PrimerNodo y UltimoNodo referencian al mismo nodo, ambos deben ser null y sino  primernodo ser� igual a PrimerNodo.siguiente

public void EliminaInicio()
{ 
  if  ( VaciaLista()) 
     System.out.println ("No hay elementos");  else 
    {
       // Restablecer  las referencias de PrimerNodo y UltimoNodo
       if (PrimeroDoble.siguiente== null)
          PrimeroDoble = null;
       else
          PrimeroDoble = PrimeroDoble.siguiente;
          PrimeroDoble.anterior=null;
      }
}

//Eliminar al Final
//Debe tomar en cuenta si la lista se encuentra vac�a y producir una excepci�n, en caso contrario si PrimerNodo y UltimoNodo referencian al mismo nodo, ambos deben ser null y sino  ultimonodo en el campo siguiente ser� nulo

public void EliminaFinal ()
{ 
  if  ( VaciaLista())
    System.out.println ("No hay elementos");
  else
   {
    // Restablecer  las referencias de PrimerNodo y UltimoNodo
     if (PrimeroDoble.siguiente== null)
        PrimeroDoble =  null;
      else
      { 
       // Primera Forma
        NodosListaDoble Actual =PrimeroDoble;
        
         while (Actual.siguiente.siguiente != null)
            Actual = Actual.siguiente;

          Actual.siguiente = null;
       
        /* Segunda Forma
        NodosListaD Actual =PrimerNodo;
        
         while (Actual.siguiente != null)
            Actual = Actual.siguiente;

       Actual.anterior.siguiente = null;
       */

      }
 }
}

//Elimina un Elemento en una posici�n dada
//Si esta vac�a PrimerNodo y UltimoNodo se refieren al nuevo nodo.
//Si no PrimerNodo se refiere al nuevo nodo.

public void EliminaMedio (int Posicion)
{   
    if  ( VaciaLista())
	System.out.println( "Nada");

    else
   {
    NodosListaDoble Aux = null;
     NodosListaDoble Actual = PrimeroDoble;
     int i =1;
     while (( i != Posicion) & (Actual.siguiente != null))
     { i++;
       Actual =Actual.siguiente;
     }
     if (Posicion ==1)
       EliminaInicio();
     else 
       {
         if( i ==Posicion)
	 {
   	    Actual.anterior.siguiente = Actual.siguiente;
            Actual.siguiente.anterior = Actual.anterior;
       }
   }

}
}

public void Invertir()// invierte las referencias
{
  NodosListaDoble sig = PrimeroDoble;
  NodosListaDoble anterior = null;
  while(!(VaciaLista()))
  {
    sig = PrimeroDoble.siguiente;
    PrimeroDoble.siguiente = anterior;
    anterior = PrimeroDoble;
    PrimeroDoble = sig;
  }
}

public boolean EstaElemento (String Elem)
{
	NodosListaDoble aux;
	
	if  (!( VaciaLista()))
	{
		aux= PrimeroDoble;
		while ((!aux.regla.equals(Elem))&&(aux.siguiente !=null)){
			aux=aux.siguiente;
	    }
	    if (aux.regla.equals(Elem))
	    {
	    	return true;
	    }
	    else
	    	return false;
	}
	else
	     return false;
}// Fin de EstaElemento	

//Metodo que realiza el backtraking
public void atras(ListaDoble lista){
	NodosListaDoble pt = lista.PrimeroDoble;
	//Ciclo que va revisa la ultima regla que fue exitosa
	while (pt.check != false){
		pt = pt.anterior;
	}//Fin del while
	
	//if que envia como parametro la ultima regla que fue exitosa
	if (pt.check == true){
		if (pt.regla == "write"){
			pt.check = false;
			pt = pt.anterior;
		}//Fin del if 1
		
		if (pt.regla == "nl"){
			pt.check = false;
			pt = pt.anterior;
		}//Fin del if 2
		
	}//Fin del if principal
	
}//Fin de atras

//Metodo que realiza la evaluacion de las premisas
public void evaluar(){
	NodosListaDoble pt = this.PrimeroDoble;
	while (pt!=null){
		if (pt.regla == "write"){
			System.out.println(pt.argumento);
			pt.check = true;
			pt = pt.siguiente;
		}//Fin del if 1
		
		else {
			if (pt.regla == "nl"){
				System.out.println('\n');
				pt.check = true;
				pt = pt.siguiente;
			}//Fin del if 2
			else
				pt = pt.siguiente;
		}//Fin del else
	}//Fin del while
}//Fin de evaluar

	public void Inserta(String x){
		if (VaciaLista())
			PrimeroDoble = new NodosListaDoble(x);
		else{
			NodosListaDoble aux= PrimeroDoble;
		    while (aux.siguiente != null)
		         aux = aux.siguiente;
		         //Primera Forma
		    aux.siguiente = new NodosListaDoble (x);
		}
	}

	public void InsertaLista(ListaDoble x){
		if (VaciaLista())
			PrimeroDoble = new NodosListaDoble(x);
		else{
			NodosListaDoble aux= PrimeroDoble;
		    while (aux.siguiente != null)
		         aux = aux.siguiente;
		         //Primera Forma
		    aux.siguiente = new NodosListaDoble (x);
		}
	}
	
	public String buscarUltimo(){
		NodosListaDoble aux = PrimeroDoble;
		while(aux.siguiente!=null)
			aux=aux.siguiente;
		return aux.argumento;
	}
	
public ListaDoble separarPredicados(String linea){
	ListaDoble List = new ListaDoble();
	StringTokenizer predicado=new StringTokenizer(linea,":- ");
	//Obtener el nombre del predicado en un nodo
	List.Inserta(predicado.nextToken());
	String nuevo=predicado.nextToken();
	while(predicado.hasMoreTokens()){
			nuevo=nuevo+" "+predicado.nextToken();
        }
	//Inserta como un solo nodo la sintaxis del predicado ":-"
	List.Inserta(":-");
	StringTokenizer antecedentes = new StringTokenizer(nuevo,",");
	//Saca cada antecedente y lo guarda en un nodo aparte, omite las comas
	//que separan cada antecedente
	while(antecedentes.hasMoreTokens()){
		String aux= antecedentes.nextToken();
		if (aux.equals("nl")|| aux.equals("fail")||aux.equals("nl.")|| aux.equals("fail."))
			List.Inserta(aux);
		else {
			if(aux.indexOf("write")>0){
				String y= antecedentes.nextToken();
				while(y.indexOf(")")<0){
					aux=aux+" "+y;
					y= antecedentes.nextToken();
				}
				aux=aux+" "+y;
				List.Inserta(aux);
			}
			else {
				if (aux.indexOf(")")>0)
					List.Inserta(aux);
				else{
					String unir = antecedentes.nextToken();
					while(unir.indexOf(")")<0){
					aux=aux+","+unir;
					unir= antecedentes.nextToken();}
				aux= aux+","+unir;
				List.Inserta(aux);}}}}
	//Obtiene el ultimo nodo añadido para separar el punto
	String ultimo = List.buscarUltimo();
	System.out.println(ultimo);
	List.EliminaFinal();
	StringTokenizer punto = new StringTokenizer(ultimo,".");
	//Regresa el ultimo antecedente, que se quito de la lista
	while(punto.hasMoreTokens()){
		String y =punto.nextToken();
		System.out.println(y);
		List.Inserta(y);}
	//Ingresa el punto como un nuevo nodo en la lista
	List.Inserta(".");
	List.Imprimir();
	return List;
}

public ListaDoble separarHechos(String linea){
	ListaDoble List = new ListaDoble();
	StringTokenizer hecho = new StringTokenizer(linea,".");
	List.Inserta(hecho.nextToken());
	List.Inserta(".");
	List.Imprimir();
	return List;
}

}//Fin de la clase
