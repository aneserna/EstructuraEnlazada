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
		l0.addToFront(22);
		assertEquals(l0.size(),1);
		assertTrue(l0.first()==22); 
		
		l1.addToFront(4);
		assertEquals(l1.size(),2);
		assertTrue(l1.first()==4);
		assertTrue(l1.contains(4));
		
		l2.addToFront(7);
		assertEquals(l2.size(),3);
		assertTrue(l2.contains(7));
		assertTrue(l2.first()==7);
		
		l3.addToFront(2);
		assertEquals(l3.size(),5);
		assertTrue(l3.contains(2));
		assertTrue(l3.first()==2);
	}

	@Test
	public void testAddToRear() {
		l0.addToRear(9);
		assertEquals(l0.size(),1);
		assertTrue(l0.contains(9));
		assertTrue(l0.last()==9);
		
		l1.addToRear(4); 
		assertEquals(l1.size(),2);
		assertTrue(l1.contains(4));
		assertTrue(l1.last()==4);
		
		l2.addToRear(7);
		assertEquals(l2.size(),3);
		assertTrue(l2.contains(7));
		
		l3.addToRear(2);
		assertEquals(l3.size(),5);
		assertTrue(l3.contains(2));
	}

	@Test
	public void testAddAfter() {
		/*Lista vacía: el elemento no se añade.
		Lista de un elemento:
		El elemento es el target: se añade.
		El elemento no es target: no se añade
		Lista de varios elementos:
		Target no está en la lista: no se añade
		Target está:
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
