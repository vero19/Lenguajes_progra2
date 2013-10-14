

// Clase NodosListaD
class NodosListaDoble {
 // datos amigables para que la Clase Lista Tenga un acceso directo
     Boolean check;
     String regla;
     String argumento;
     NodosListaDoble siguiente;
     NodosListaDoble anterior;
     ListaDoble lista;

//Construtor 
 NodosListaDoble (String reg, String arg)
  {  regla = reg;
  	 argumento = arg;
  	 check = false;
     siguiente = null; 
     anterior = null;
  }

// Constructor Crea un nodo del Tipo Object y al siguiente nodo de la lista
NodosListaDoble (String reg, String arg, NodosListaDoble signodo)
{   regla = reg;
	argumento = arg;
  	check = false;
    siguiente = signodo; //siguiente se refiere al siguiente nodo
}

NodosListaDoble (String x){
	argumento = x;
	siguiente = null; 
    anterior = null;
}

NodosListaDoble (ListaDoble list){
	lista = list;
	siguiente = null; 
    anterior = null;
}

NodosListaDoble (String x, NodosListaDoble signodo){
	argumento = x; 
    anterior = null;
    siguiente = signodo; 
}

NodosListaDoble (ListaDoble list, NodosListaDoble signodo){
	lista = list;
    anterior = null;
    siguiente = signodo; 
}

//Retorna el dato que se encuentra en este nodo
Object getObject() {return regla; }

//Retorna el siguiente nodo
NodosListaDoble getnext() {return siguiente; }

}//Final de la Clase NodosLista

