package day14;

import java.util.ArrayList;
import java.util.List;

public class Library <E> {
	private List<E> elementInLibrary;
	
	public void deleteElementInLibrary( int numberInArray){
		elementInLibrary.remove(numberInArray-1);
		printElementInLibrary();
	}
	
	public void addElementInLibrary(E nameObject){
		if (elementInLibrary == null) {
			elementInLibrary = new ArrayList<E>();
		}
		elementInLibrary.add(nameObject);
		System.out.println("Add successed a book. It name is "+nameObject.toString());
	}
	
	public void printElementInLibrary() {
		if (elementInLibrary != null && !elementInLibrary.isEmpty()) {
			for (int i = 0; i < elementInLibrary.size(); i++) {
				System.out.println((i+1) + ":\t "+elementInLibrary.get(i).toString());
			}
		}
	}
	
	
	public List<E> getElementInLibrary() {
		if (elementInLibrary == null) {
			elementInLibrary = new ArrayList<E>();
		}
		return elementInLibrary;
	}
	public void setElementInLibrary(List<E> elementInLibrary) {
		this.elementInLibrary = elementInLibrary;
	}
	
}
