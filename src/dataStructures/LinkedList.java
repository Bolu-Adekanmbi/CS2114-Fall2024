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
    
    public Node<T> getHead() {
        return this.head;
    }
    
    public void clear() {
        this.head = null;
        this.size = 0;
    }
    
    /**
     * This method will be responsible for removing specific items from the
     * linked list based on index. It throws an index out of bounds exception
     * when the index we are looking for is outside the length of the linked
     * list.
     * 
     * @param index This is the index that we want to remove from 
     *              the linked list
     * @throws IndexOutOfBoundsException
     */
    public void remove(int index) {
        if (index < 0 || index > this.size - 1) {
            throw new IndexOutOfBoundsException();
        }
        
        if (index == 0) {
            head = head.getNext();
        }
        
        Node<T> previousNode = head;
        Node<T> currentNode = head.getNext();
        
        for (int i = 0; i < index; i++) {
            previousNode = previousNode.getNext();
            currentNode = currentNode.getNext();
        }
        
        /*
         * Need to work on this part to make sure it is working properly
         * Need to create some assertion tests for this as well to make sure
         * everything works as expected
         */
        
    }
    
    /**
     * This is a private helper method that will help us locate a node within
     * a linked list
     * @param index This is the position of the linked list that we want to
     *              locate
     */
    private Node<T> findNode(int index) {
        if (index < 0 || index > size - 1) {
            return null;
        }
        
        Node<T> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        
        return currentNode;
    }
    
    public boolean add(T anEntry, int index) {
        
        if (size == 0) {
            head = new Node<>(anEntry);
            this.size++;
            return true;
        }
        
        Node<T> insertionNode = findNode(index - 1);
        if (insertionNode == null) {
            return false;
        }
        
        Node<T> newNode = new Node<T>(anEntry, insertionNode.getNext());
        insertionNode.setNext(newNode);
        
        this.size++;
        return true;
    }
    
    public boolean add(T anEntry) {
        return this.add(anEntry, this.size);
    }
    
    
    
    public boolean equals(LinkedList<T> otherList) {
        if (this.getSize() != otherList.getSize()) {
            return false;
        }
        
        Node<T> listCursor = head;
        Node<T> otherCursor = otherList.getHead();
        
        for (int i = 0; i < this.getSize(); i++) {
            if (!listCursor.equals(otherCursor)) {
                return false;
            }
        }
        return true;
    }
    
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        
        StringBuilder sb = new StringBuilder("[");
        Node<T> currentNode = head;
        
        while (currentNode.getNext() != null) {
            sb.append(currentNode.getData());
            sb.append(", ");
        }
        
        sb.append(currentNode.getData());
        sb.append("]");
        
        
        return sb.toString();
    }
    
    /**
     *  This is the nested private Node class that is responsible for storing
     *  the data in the linked list data structure
     *  @param <T> This is the type of object that will be stored by a Node
     * 
     *  @author Mobolurin Adekanmbi
     *  @version Dec 22, 2024
     */
    public class Node<T> {
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
        
        public boolean equals(Node<T> otherNode) {
            return this.data.equals(otherNode.getData());
        }
        
    }
}
