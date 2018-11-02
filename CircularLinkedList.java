//package segundaFase;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CircularLinkedList<T> implements ListADT<T> {

	// Atributos
	protected Node<T> last; // apuntador al ultimo
	protected String descr;  // descripci�n
	protected int count;

	// Constructor
	public CircularLinkedList() {
	     last = null;
		descr = "";
		count = 0;
	}
	
	public void setDescr(String nom) {
	  descr = nom;
	}

	public String getDescr() {
	  return descr;
	}

	public T removeFirst() {
	// Elimina el primer elemento de la lista
        // Precondici�n: la lista tiene al menos un elemento
		//Postcondici�n: elimina el primer elemento de la lista devolviendo su valor.
		/*Casos de prueba: Lista de un elemento-> Lista vac�a.
		 * 				   Lista de dos elementos -> Lista de un elemento.
		 * 				   Lista de varios elementos-> Lista sin el primer elemento.
		 */
					
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		
		Node<T> primero=this.last.next;
		this.last.next=primero.next;
		this.count=this.count-1;
		return primero.data;
	}

	public T removeLast() {
	// Elimina el �ltimo elemento de la lista
        // Precondici�n: la lista tiene al menos un elemento
		//Postcondici�n: elimina el primer elemento de la lista devolviendo su valor.
				/*Casos de prueba: Lista de un elemento-> Lista vac�a.
				 * 				   Lista de dos elementos -> Lista de un elemento.
				 * 				   Lista de varios elementos-> Lista sin el �ltimo elemento.
				 */
			// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		
			Node<T> act= this.last;
			T data=last.data;
			int cont=0;
			while(cont<this.count-1){
				act=act.next;
				cont=cont+1;
			}
			if (act!=null){
				act.next=last.next;
				this.last=act;
				this.count=this.count-1;
				
			}
			else{
				this.last=null;
				this.count=this.count-1;
			}
			return data;
		   }


	public T remove(T elem) {
	//Elimina un elemento concreto de la lista
		// Precondici�n:La lista tiene al menos un elemento.
		//Postcondici�n: elimina la primera aparici�n del elemento T de la lista devolviendo su valor. Si no se ha podido borrar devuelve null.;
				/*Casos de prueba: Lista de un elemento-> El elemento est�:Lista vac�a.
				 * 										-> El elemento no est�: no cambia la lista.
				 * 				   Lista de dos elementos -> El elemento est�:Lista de un elemento.
				 * 										  -> El elemento no est�: no cambia la lista.
				 * 				   Lista de varios elementos->El elemento est�:Lista sin el elemento.
				 * 										  -> El elemento no est�: no cambia la lista.
				 */
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		if(this.count==1){
			if(this.last.data.equals(elem)){
				this.last=null;
				this.count=0;
				
			}
			else{
				elem=null;
			}
		}
		else{
		Node<T> ant=this.last;
		Node<T> act=this.last.next;
		int cont=1;
		boolean salir=false;
		while(cont<this.count && salir==false){
			if(act.data.equals(elem)){
				ant.next=act.next;
				this.count=this.count-1;
				salir=true;
				
			}
			else{				
				ant=act;
				act=act.next;
				cont++;
			}
		}
		if(!salir){
			elem=null;
		}
		}
		return elem;
		
		
	}
	public T first() {
	//Da acceso al primer elemento de la lista
	      if (isEmpty())
	          return null;
	      else return last.next.data;
	}

	public T last() {
	//Da acceso al �ltimo elemento de la lista
	      if (isEmpty())
	          return null;
	      else return last.data;
	}

	public boolean contains(T elem) {
		// Precondici�n:
		//Postcondici�n:devuelve True si el elemento se encuentra en la lista en caso contrario devuelve false.
						/*Casos de prueba: Lista de un elemento-> El elemento est�:True.
						 * 										-> El elemento no est�: False.
						 * 				   Lista de dos elementos -> El elemento est�:True.
						 * 										  -> El elemento no est�: False.
						 * 				   Lista de varios elementos->El elemento est�:True.
						 * 										  -> El elemento no est�: False.
						 */
		Node<T> act= this.last;
		boolean esta=false;
		int cont=0;
	
		while(cont<this.count&& !esta){
			if (act.data.equals(elem)){
				esta=true;
				
			}
			else{
				
				act=act.next;
				cont=cont+1;
				
			}
				
			}
		return esta;

		   }

	public T find(T elem) {
	//Determina si la lista contiene un elemento concreto, y develve su referencia, null en caso de que no est�
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		if(isEmpty()){
			return null;
		}
		else{
			
		
		Node<T> act= this.last;
		boolean esta=false;
		int cont=0;
	
		while(cont<this.count&& !esta){
			if (act.data.equals(elem)){
				esta=true;				
			}
			else{	
				act=act.next;
				cont=cont+1;				
			}
				
			}
		if(esta){
			return act.data;
		}
		else{
			return null;
		}
		
		}
	}

	public boolean isEmpty() 
	//
	/* Pre:
	 * Post:Determina si la lista est� vac�a
	 * Casos de prueba:
	 * 					Lista vac�a: True
	 * 					Lista varios elementos:False
	 * 
	 */
	{ return last == null;};
	
	public int size() 
	//Determina el n�mero de elementos de la lista
	{ return count;};
	
	/** Return an iterator to the stack that iterates through the items . */ 
	   public Iterator<T> iterator() 
	   /* Pre:
		 * Post:Devuelve un iterador de la lista*/

	   { return new ListIterator(); } 

	   // an iterator, doesn't implement remove() since it's optional 
	   private class ListIterator implements Iterator<T> { 

		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		  
		   private Node<T> actual;
		   private boolean primeraVuelta=false;
		  
		   public boolean hasNext(){
			  
			   
			   	if(!primeraVuelta ){
			   		if(last==null){
			   			return false;
			   		}
			   		actual=last.next;
			   		primeraVuelta=true;
			   		return true;
			   	}
			   	else{   return actual!=last.next;}
		   }
		   
		   public T next(){
			   T dato=null;
			   if(actual==last.next && count>=1){
				   	  dato=actual.data;
					  actual=actual.next;
					  
					 
			   }
			   else{
				   if(!hasNext()){throw new NoSuchElementException();}
				  	
					  dato=actual.data;
					  actual=actual.next;
			   }
			   
					  
					  return dato;
					   
		   }
		   



	   } // private class
		
		
         public void visualizarNodos() {
			System.out.println(this.toString());
		}

		@Override
		public String toString() {
			String result = new String();
			Iterator<T> it = iterator();
			while (it.hasNext()) {
				T elem = it.next();
				result = result + "[" + elem.toString() + "] \n";
			}	
			return "SimpleLinkedList " + result + "]";
		}
		
		public T get(int posicion){
			T data=null;
			if(this.last!=null && posicion<=(this.count-1)){
				if(posicion==(this.count-1)){
					data= last.data;
				}
				else{
					int cont=0;
					Node<T> act=this.last.next;
					while(posicion>cont){
						act=act.next;
						cont++;
					}
					data= act.data;
				}
			}
			return data;
		}
		public void set(int posicion, T dato){
			/*Pre: La lista contiene al menos un elemento
			 * Post: el dato ha sido colocado en la posicion int de la lista. En caso de que la posici�n no sea v�lisa no se hace nada
			 * */
			Node<T> elemento=new Node<T>(dato);
			
			if(this.last!=null && posicion<=(this.count-1)){
					if (posicion==0&&this.count>1){
						elemento.next=this.last.next.next;
						this.last.next=elemento;
					}
					else if(posicion==0&&this.count==1){
						this.last=elemento;
						elemento.next=elemento;
					}
					else{
					int cont=0;
					Node<T> act=this.last.next;
					Node<T> ant=this.last;
					while(cont<posicion){
						act=act.next;
						ant=ant.next;
						cont++;
					}
					
					elemento.next=act.next;
					ant.next=elemento;
					if(posicion==(this.count-1)){
						this.last=elemento;
					}
				}
			}
			
		}
}
