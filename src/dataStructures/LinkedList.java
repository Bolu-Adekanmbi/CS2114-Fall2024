package dataStructures;

/**
 *  Singly LinkedList
 *  
 *  @param <T> This is the type of object that will be stored by the linked list
 * 
 *  @author Mobolurin Adekanmbi
 *  @version Dec 22, 2024
 */
public class LinkedList<T> {
    
    //~ Fields ................................................................
    private Node<T> head;
    private int size;
    
    //~ Constructors ..........................................................
    public LinkedList() {
        this.head = null;
        this.size = 0;
    }
    
    //~Public  Methods ........................................................
    public int getSize() {
        return this.size;
    }
    
    public void clear() {
        this.head = null;
        this.size = 0;
    }
    
    
    public String toString() {
        return "";
    }
    
    /**
     *  This is the nested private Node class that is responsible for storing
     *  the data in the linked list data structure
     *  @param <T> This is the type of object that will be stored by a Node
     * 
     *  @author Mobolurin Adekanmbi
     *  @version Dec 22, 2024
     */
    private class Node<T> {
        private T data;
        private Node<T> next;
        
        public Node(T anEntry, Node<T> nextNode) {
            this.data = anEntry;
            this.next = nextNode;
        }
        
        public Node(T anEntry) {
            this(anEntry, null);
        }
        
        public T getData() {
            return this.data;
        }
        
        public void setData(T newData) {
            this.data = newData;
        }
        
        public Node<T> getNext() {
            return this.next;
        }
        
        public void setNext(Node<T> nextNode) {
            this.next = nextNode;
        }
        
    }
}
