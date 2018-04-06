

import java.util.ArrayList;

import kar.ds.linkedlist.DoubleLinkedList;

public class DoubleLinkedListMain {
	
	public static void main(String args[]) {
		DoubleLinkedList list1 = new DoubleLinkedList();
		System.out.println("List1: "+list1);
		
		Integer[] arr1 = {0,1,2,3,4};
		DoubleLinkedList list2 = new DoubleLinkedList(arr1);
		System.out.println("List2: "+list2);
		
		Integer[] arr2 = {5,6,7,8,9};
		DoubleLinkedList list3 = new DoubleLinkedList(arr2);
		System.out.println("List3: "+list3);
		
		list1.insert("One");
		list1.insert("Two");
		list1.insert("Three");
		System.out.println("1. After inserting three items in List1: "+list1);
		
		list2.insertAt(-1, -1);
		System.out.println("2. After inserting -1 at index -1: "+list2);
		
		list2.insertAt(5, 5);
		System.out.println("3. After inserting 5 at index 5: "+list2);
		
		list2.insertAt(10, 5);
		System.out.println("4. After inserting 5 at index 10: "+list2);
		
		list2.insertAt(0, -1);
		System.out.println("5. After inserting -1 at index 0: "+list2);
		
		list2.insertAt(2, "2x");
		System.out.println("6. After inserting 2x at index 2: "+list2);
		
		list1.update("Zero", -1);
		System.out.println("9. Upading data at index -1 in List1: "+list1);
		
		list1.update("XXX", 3);
		System.out.println("10. Upading data at index 3 in List1: "+list1);
		
		list1.update("Zero", 0);
		System.out.println("11. Upading data at index 0 in List1: "+list1);
		
		list1.update("XXX", 5);
		System.out.println("12. Upading data at index 5 in List1: "+list1);
		
		list1.update("XXX", 3);
		System.out.println("13. Upading data at index 3 in List1: "+list1);
		
		list2.delete("2X");
		System.out.println("14. Deleting 2X in List2: "+list2);
		
		list2.delete("2x");
		System.out.println("15. Deleting 2x in List2: "+list2);
		
		list2.deleteAt(-1);
		System.out.println("16. Deleting at index -1 in List2: "+list2);
		
		list2.deleteAt(50);
		System.out.println("17. Deleting at index 50 in List2: "+list2);
		
		list2.deleteAt(0);
		System.out.println("18. Deleting at index 0 in List2: "+list2);
		
		int size = list2.getSize();
		list2.deleteAt(size);
		System.out.println("19. Deleting at index "+size+" in List2: "+list2);
		
		size = list2.getSize();
		list2.deleteAt(size-1);
		System.out.println("20. Deleting at index "+(size - 1)+" in List2: "+list2);
		
		System.out.println("21. Data at index -1 in List2: "+list2.getDataAt(-1));
		System.out.println("22. Data at index 0 in List2: "+list2.getDataAt(0));
		System.out.println("23. Data at index 50 in List2: "+list2.getDataAt(50));
		size = list2.getSize();
		System.out.println("24. Data at index "+size+" in List2: "+list2.getDataAt(size));
		size = list2.getSize();
		System.out.println("25. Data at index "+(size - 1)+" in List2: "+list2.getDataAt(size - 1));
		System.out.println("26. Data at index 5 in List2: "+list2.getDataAt(5));
	}
}
