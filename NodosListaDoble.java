

// Clase NodosListaD
class NodosListaDoble {
 // datos amigables para que la Clase Lista Tenga un acceso directo
     Boolean check;
     String regla;
     NodosListaDoble siguiente;
     NodosListaDoble anterior;

//Construtor 
 NodosListaDoble (String reg)
  {  regla = reg;
  	 check = false;
     siguiente = null; 
     anterior = null;
  }

// Constructor Crea un nodo del Tipo Object y al siguiente nodo de la lista
NodosListaDoble (String reg, NodosListaDoble signodo)
{   regla = reg;
  	check = false;
    siguiente = signodo; //siguiente se refiere al siguiente nodo
}


//Retorna el dato que se encuentra en este nodo
Object getObject() {return regla; }

//Retorna el siguiente nodo
NodosListaDoble getnext() {return siguiente; }

}//Final de la Clase NodosLista
