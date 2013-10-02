


//Definición de la Clase Lista
 public class ListaDoble
{
  public NodosListaD PrimeroDoble;
  String Nombre;

//Constructor construye una lista vacia con un nombre s
 public ListaDoble (String s)
{ Nombre = s;
  PrimeroDoble =null;
}

//Retorna True si Lista Vacía
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
      NodosListaD Actual = PrimeroDoble;

     while (Actual != null)
	 {
      System.out.print (Actual.cod.toString() + " ");
      System.out.print (Actual.ban.toString() + " ");
      Actual=Actual.siguiente;
     }

     System.out.println();
     System.out.println();
   }
 }


//Constructor construye una lista vacia con un nombre de List
public ListaDoble(){ this ("Lista");}

//Inserta un Elemento al Frente de la Lista
//Si esta vacía PrimerNodo y UltimoNodo se refieren al nuevo nodo. Si no PrimerNodo se refiere al nuevo nodo.

public void InsertaInicio (String oba, String am, String ye, String ho)
{ if (VaciaLista())
   PrimeroDoble = new NodosListaD (oba, am, ye, ho);
  else
   PrimeroDoble = new NodosListaD (oba, am, ye, ho, PrimeroDoble);
   PrimeroDoble.siguiente.anterior =PrimeroDoble;
}


//Inserta al Final de la Lista
//Si la lista se encuentra vacía, el PrimerNodo y el UltimoNodo se refieren al nuevo nodo. Si no, la variable de siguiente de UltimoNodo se refiere al nuevo nodo.
public void InsertaFinal(String oba, String am, String ye, String ho)
{ if ( VaciaLista())
     PrimeroDoble = new NodosListaD (oba, am, ye, ho);
  else
     {
      NodosListaD aux= PrimeroDoble;
      while (aux.siguiente != null)
         aux = aux.siguiente;
         //Primera Forma
         aux.siguiente = new NodosListaD (oba, am, ye, ho);
         aux.siguiente.anterior =aux;
    }
}//Fin de InsertaFinal

public void InsertaFinal(String oba, String am)
{ if ( VaciaLista())
     PrimeroDoble = new NodosListaD (oba, am);
  else
     {
      NodosListaD aux= PrimeroDoble;
      while (aux.siguiente != null)
         aux = aux.siguiente;
         //Primera Forma
         aux.siguiente = new NodosListaD (oba, am);
         aux.siguiente.anterior =aux;
    }
}//Fin de InsertaFinal

public void InsertaFinal(String codBan, String nom,String tar, String mon, String tar1, String mon1, String tar2, String mon2)
{ if ( VaciaLista())
     PrimeroDoble = new NodosListaD (codBan,nom,tar, mon, tar1, mon1, tar2, mon2);
  else
     {
      NodosListaD aux= PrimeroDoble;
      while (aux.siguiente != null)
         aux = aux.siguiente;
         //Primera Forma
         aux.siguiente = new NodosListaD (codBan,nom,tar, mon, tar1, mon1, tar2, mon2);
         aux.siguiente.anterior =aux;
    }
}//Fin de InsertaFinal

//Inserta un Elemento en una posición dada
//Si esta vacía PrimerNodo y UltimoNodo se refieren al nuevo nodo.
//Si no PrimerNodo se refiere al nuevo nodo.

public void InsertaMedio (String oba, String am, String ye, String ho,int Posicion)
{ if (VaciaLista())
      PrimeroDoble =  new NodosListaD (oba, am, ye, ho);
  else
    { if (Posicion<=1)
      {
       /* Primera Forma 
        NodosListaD Nuevo = new NodosListaD(ElemInser);
        Nuevo.siguiente = PrimeroDoble;
        PrimeroDoble = Nuevo;
        PrimeroDoble.siguiente.anterior= PrimeroDoble;*/
        InsertaInicio (oba, am, ye, ho);
     

 	  }
     else
      {
	 NodosListaD Aux = PrimeroDoble;
         int i = 2;
         while ( (i != Posicion) & (Aux.siguiente != null))
         {  i++;
            Aux = Aux.siguiente;
         }
         NodosListaD Nuevo = new NodosListaD(oba, am, ye, ho);
         Nuevo.siguiente = Aux.siguiente;;
         Aux.siguiente =Nuevo;
         Nuevo.anterior=Aux;
         if (Aux.siguiente !=null)
            Nuevo.siguiente.anterior=Nuevo;
	 }
 }
}


//Eliminar al Inicio
//Debe tomar en cuenta si la lista se encuentra vacía y producir una excepción, en caso contrario si PrimerNodo y UltimoNodo referencian al mismo nodo, ambos deben ser null y sino  primernodo será igual a PrimerNodo.siguiente

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
//Debe tomar en cuenta si la lista se encuentra vacía y producir una excepción, en caso contrario si PrimerNodo y UltimoNodo referencian al mismo nodo, ambos deben ser null y sino  ultimonodo en el campo siguiente será nulo

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
        NodosListaD Actual =PrimeroDoble;
        
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

//Elimina un Elemento en una posición dada
//Si esta vacía PrimerNodo y UltimoNodo se refieren al nuevo nodo.
//Si no PrimerNodo se refiere al nuevo nodo.

public void EliminaMedio (int Posicion)
{   
    if  ( VaciaLista())
	System.out.println( "Nada");

    else
   {
    NodosListaD Aux =null;
     NodosListaD Actual = PrimeroDoble;
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
  NodosListaD sig = PrimeroDoble;
  NodosListaD anterior = null;
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
	NodosListaD aux;
	
	if  (!( VaciaLista()))
	{
		aux= PrimeroDoble;
		while ((!aux.cod.equals(Elem))&&(aux.siguiente !=null)){
			aux=aux.siguiente;
	    }
	    if (aux.cod.equals(Elem))
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