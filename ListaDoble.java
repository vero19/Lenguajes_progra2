

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
      System.out.print (Actual.check.toString() + " ");
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

public void InsertaInicio (String r)
{ if (VaciaLista())
   PrimeroDoble = new NodosListaDoble (r);
  else
   PrimeroDoble = new NodosListaDoble (r, PrimeroDoble);
   PrimeroDoble.siguiente.anterior =PrimeroDoble;
}


//Inserta al Final de la Lista
//Si la lista se encuentra vac�a, el PrimerNodo y el UltimoNodo se refieren al nuevo nodo. Si no, la variable de siguiente de UltimoNodo se refiere al nuevo nodo.
public void InsertaFinal(String r)
{ if ( VaciaLista())
     PrimeroDoble = new NodosListaDoble (r);
  else
     {
      NodosListaDoble aux= PrimeroDoble;
      while (aux.siguiente != null)
         aux = aux.siguiente;
         //Primera Forma
         aux.siguiente = new NodosListaDoble (r);
         aux.siguiente.anterior =aux;
    }
}//Fin de InsertaFinal

//Inserta un Elemento en una posici�n dada
//Si esta vac�a PrimerNodo y UltimoNodo se refieren al nuevo nodo.
//Si no PrimerNodo se refiere al nuevo nodo.

public void InsertaMedio (String r,int Posicion)
{ if (VaciaLista())
      PrimeroDoble =  new NodosListaDoble (r);
  else
    { if (Posicion<=1)
      {
       /* Primera Forma 
        NodosListaD Nuevo = new NodosListaD(ElemInser);
        Nuevo.siguiente = PrimeroDoble;
        PrimeroDoble = Nuevo;
        PrimeroDoble.siguiente.anterior= PrimeroDoble;*/
        InsertaInicio (r);

 	  }
     else
      {
	 NodosListaDoble Aux = PrimeroDoble;
         int i = 2;
         while ( (i != Posicion) & (Aux.siguiente != null))
         {  i++;
            Aux = Aux.siguiente;
         }
         NodosListaDoble Nuevo = new NodosListaDoble(r);
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
}//Fin de la clase
