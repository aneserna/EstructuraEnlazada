import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CircularLinkedListTest {
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
	public void testCircularLinkedList() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetDescr() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetDescr() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveFirst() {
		/*Casos de prueba: Lista de un elemento-> Lista vacía.
		 * 				   Lista de dos elementos -> Lista de un elemento.
		 * 				   Lista de varios elementos-> Lista sin el primer elemento.
		 */
		l1.removeFirst();
		assertEquals(l1.size(),0);
		
		l2.removeFirst();
		assertEquals(l2.size(),1);
		assertFalse(l2.contains(3));
		
		l3.removeFirst();
		assertEquals(l3.size(),3);
		assertFalse(l2.contains(3));
	}

	@Test
	public void testRemoveLast() {
		l1.removeLast();
		assertEquals(l1.size(),0);
		
		l2.removeLast();
		assertEquals(l2.size(),1);
		assertFalse(l2.contains(3));
		
		l3.removeLast();
		assertEquals(l3.size(),3);
		assertFalse(l2.contains(6));
	}

	@Test
	public void testRemove() {
		/*Casos de prueba: Lista de un elemento-> El elemento está:Lista vacía.
		 * 										-> El elemento no está: no cambia la lista.
		 * 				   Lista de dos elementos -> El elemento está:Lista de un elemento.
		 * 										  -> El elemento no está: no cambia la lista.
		 * 				   Lista de varios elementos->El elemento está:Lista sin el elemento.
		 * 										  -> El elemento no está: no cambia la lista.
		 */
		
		assertNull(l1.remove(2));
		assertSame(l1.remove(1),1);
		assertEquals(l1.size(),0);
		
		assertNull(l2.remove(2));
		assertSame(l2.remove(3),3);
		assertFalse(l2.contains(3));
		assertEquals(l2.size(),1);
		
		assertNull(l3.remove(2));
		assertSame(l3.remove(4),4);
		assertFalse(l3.contains(4));
		assertTrue(l3.contains(5));
		assertTrue(l3.contains(6));
		assertTrue(l3.contains(3));
		assertEquals(l3.size(),3);
		assertSame(l3.remove(3),3);
		assertTrue(l3.contains(5));
		assertTrue(l3.contains(6));
		assertFalse(l3.contains(3));
		assertEquals(l3.size(),2);
		assertSame(l3.remove(5),5);
		assertFalse(l3.contains(5));
		assertTrue(l3.contains(6));
		assertEquals(l3.size(),1);
		assertSame(l3.remove(6),6);
		assertFalse(l3.contains(5));
		assertEquals(l3.size(),0);
	}

	@Test
	public void testFirst() {
		assertTrue(l0.first()==null);
		assertSame(l1.first(),1);
		assertSame(l2.first(),3);
		assertSame(l3.first(),3);
	}

	@Test
	public void testLast() {
		assertTrue(l0.last()==null);
		assertSame(l1.last(),1);
		assertSame(l2.last(),4);
		assertSame(l3.last(),6);
	}

	@Test
	public void testContains() {
		/*Casos de prueba: Lista vacía.
		 * 					Lista de un elemento-> El elemento está:True.
		 * 										-> El elemento no está: False.
		 * 				   Lista de dos elementos -> El elemento está:True.
		 * 										  -> El elemento no está: False.
		 * 				   Lista de varios elementos->El elemento está: True.
		 * 										  -> El elemento no está: False.
		 */
		assertFalse(l0.contains(3));
		
		assertTrue(l1.contains(1));
		assertFalse(l1.contains(3));
		
		assertFalse(l2.contains(5));
		assertTrue(l2.contains(3));
		assertTrue(l2.contains(4));
		
		assertFalse(l3.contains(7));
		assertTrue(l3.contains(3));
		assertTrue(l3.contains(4));
		assertTrue(l3.contains(5));
		assertTrue(l3.contains(6));
		
		
		
		
	}

	@Test
	public void testFind() {
		assertSame(l3.find(3),3);
		assertSame(l3.find(4),4);
		assertSame(l3.find(5),5);
		assertSame(l3.find(6),6);
	}

	@Test
	public void testIsEmpty() {
		assertTrue(l0.isEmpty());
		assertFalse(l2.isEmpty());
		l2.visualizarNodos();
	}

	@Test
	public void testSize() {
		fail("Not yet implemented");
	}

	@Test
	public void testIterator() {
		fail("Not yet implemented");
	}

	@Test
	public void testVisualizarNodos() {
		fail("Not yet implemented");
	}

	@Test
	public void testGet() {
		l3.visualizarNodos();
		assertSame(l3.get(0),3);
		assertSame(l3.get(1),4);
		assertSame(l3.get(2),5);
		assertSame(l3.get(3),6);
		assertNull(l3.get(8));
		l3.visualizarNodos();
		
		assertSame(l1.get(0), 1);
		assertNull(l1.get(2));
		l1.visualizarNodos();
		
		assertSame(l2.get(1),4);
		assertSame(l2.get(0),3);
		assertNull(l2.get(2));
		}

	@Test
	public void testSet(){
		l3.visualizarNodos();
		l3.set(3, 4);
		assertTrue(l3.contains(4));
		l3.set(2,3);
		l3.set(0, 1);
		l3.set(1, 2);
		assertTrue(l3.contains(1));
		assertTrue(l3.contains(2));
		assertTrue(l3.contains(3));
		l3.visualizarNodos();
		
		l1.visualizarNodos();
		l1.set(3, 4);
		assertFalse(l1.contains(4));
		l1.set(0, 4);
		assertTrue(l1.contains(4));
		assertFalse(l1.contains(1));
		l1.visualizarNodos();
		
		l2.visualizarNodos();
		l2.set(3, 5);
		assertFalse(l2.contains(5));
		l2.set(1, 5);
		assertTrue(l2.contains(5));
		l2.set(0, 8);
		assertTrue(l2.contains(8));
		assertTrue(l2.size()==2);
		l2.visualizarNodos();
	}
	
	@Test
	public void testAdd(){
		l3.visualizarNodos();
		l3.add(0, 9);
		assertSame(l3.get(0),9);
		assertSame(l3.size(),5);
		l3.visualizarNodos();
		l3.add(5, 10);
		assertSame(l3.get(5),10);
		assertSame(l3.size(),6);
		l3.visualizarNodos();
		l3.add(2, 11);
		assertSame(l3.get(2),11);
		assertSame(l3.size(),7);		
		l3.visualizarNodos();
		
		l1.add(1, 3);
		assertSame(l1.get(1),3);
		assertSame(l1.size(),2);
		l1.add(0, 4);
		assertSame(l1.get(0),4);
		assertSame(l1.size(),3);
		
		l2.add(1, 7);
		assertSame(l2.get(1),7);
		assertSame(l2.size(),3);
		l2.add(2, 8);
		assertSame(l2.get(2),8);
		assertSame(l2.size(),4);
		
		
		
		
	}
}
