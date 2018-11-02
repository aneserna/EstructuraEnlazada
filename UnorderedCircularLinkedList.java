
public class UnorderedCircularLinkedList<T> extends CircularLinkedList<T> implements UnorderedListADT<T> {
	
	public void addToFront(T elem) {
	// añade un elemento al comienzo
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		Node<T> nuevo=new Node(elem);
		if(this.last==null){
			this.last=nuevo;
			nuevo.next=nuevo;
			this.count++;
		}
		else{
		nuevo.next=last.next;
		last.next=nuevo;
		this.count++;
		}
	}

	public void addToRear(T elem) {
	// añade un elemento al final 
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		Node<T> nuevo=new Node<T>(elem);
		
		if (isEmpty()) {
			last=nuevo;
			nuevo.next=last;
		}
		else {
			nuevo.next=last.next;
			last.next=nuevo;
			last=nuevo;	
		}
		count=count+1;
	}
	
	public void addAfter(T elem, T target) {
	// Añade elem detrás de otro elemento concreto, target,  que ya se encuentra en la lista
		/* Pre: 
		 * 
		 * Post: añade elem detrás de otro elemento concreto de la lista, target. En caso de que target no se
		 * encuentre en la lista, no se añade elem.
		 * 
		 * Casos de prueba:
		 * 					Lista vacía: el elemento no se añade.
		 * 					Lista 1 elemento:
		 * 							El elemento que contiene es el target: se añade.
		 * 							El elemento que contiene no es el target: no se añade
		 * 					Lista de varios elementos:
		 * 							Target no está: no se añade
		 * 							Target está:
		 * 									Al principio
		 * 									En el centro
		 * 									Al final
		 */
		
		Node<T> nuevo=new Node(elem);
		if(isEmpty()){
			
		}
		else{
			
		Node<T> act= this.last;
		boolean esta=false;
		int cont=0;
	
		while(cont<this.count&& !esta){
			if (act.data.equals(target)){
				
				nuevo.next=act.next;
				act.next=nuevo;
				count++;
				if(act==this.last){
					this.last=nuevo;
				}
				esta=true;
			}
			else{	
				act=act.next;
				cont=cont+1;				
			}
				
			}
		
		}
		
	}

	public void add(int posicion, T dato){
		Node<T> elemento=new Node<T>(dato);
		
		if(this.last!=null && posicion<=(this.count)&&posicion>=0){
				if (posicion==0){
					elemento.next=this.last.next;
					this.last.next=elemento;
					count++;
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
				
				elemento.next=act;
				ant.next=elemento;
				count++;
				if(posicion==(this.count-1)){
					this.last=elemento;
				}
				
			}
		}
//		else{
//			this.last=elemento;
//			elemento.next=elemento;
//			count++;
//		}
		
	}

}
