import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UnorderedCircularLinkedListTest {
	Node<Integer> n1,n2,n3,n4,n5,n6,n7;
	UnorderedCircularLinkedList<Integer> l0,l1,l2,l3;
	@Before
	public void setUp() throws Exception {
		l0=new UnorderedCircularLinkedList<Integer>();
		l1=new UnorderedCircularLinkedList<Integer>();
		l1.addToRear(1);
		
		l2=new UnorderedCircularLinkedList<Integer>();
		l2.addToRear(3);
		l2.addToRear(4);
		
		l3=new UnorderedCircularLinkedList<Integer>();
		l3.addToRear(3);
		l3.addToRear(4);
		l3.addToRear(5);
		l3.addToRear(6);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddToFront() {
		
	}

	@Test
	public void testAddToRear() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddAfter() {
		/*Lista vac�a: el elemento no se a�ade.
		Lista de un elemento:
		El elemento es el target: se a�ade.
		El elemento no es target: no se a�ade
		Lista de varios elementos:
		Target no est� en la lista: no se a�ade
		Target est�:
		Al principio
		En el centro
		Al final
		*/
		l0.addAfter(5, 0);
		l0.visualizarNodos();
		assertFalse(l0.contains(5));
		
		l1.addAfter(2,5);
		l1.visualizarNodos();
		assertFalse(l1.contains(2));
		l1.addAfter(10, 1);
		assertTrue(l1.contains(10));
		l1.visualizarNodos();
		
		l3.addAfter(8,70);
		l3.visualizarNodos();
		assertFalse(l3.contains(8));
		l3.addAfter(10, 3);
		assertTrue(l3.contains(10));
		l3.visualizarNodos();
		l3.addAfter(20, 4);
		assertTrue(l3.contains(20));
		l3.visualizarNodos();
		l3.addAfter(30, 6);
		assertTrue(l3.contains(30));
		l3.visualizarNodos();
	}

	@Test
	public void testSet() {
		fail("Not yet implemented");
	}

	@Test
	public void testAdd() {
		fail("Not yet implemented");
	}

}
