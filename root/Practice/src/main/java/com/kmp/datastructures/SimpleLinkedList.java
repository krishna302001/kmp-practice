package com.kmp.datastructures;

class Node<T> {
    private T value;
    private Node<T> next;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}

public class SimpleLinkedList<T> {
    private Node<T> head = null, tail = null;

    public static void main(String args[]) {
        SimpleLinkedList<String> simpleLinkedList = new SimpleLinkedList();
        simpleLinkedList.add("AB");
        simpleLinkedList.add("CD");
        simpleLinkedList.add("EF");
        simpleLinkedList.add("GH");
        simpleLinkedList.add("IJ");

        simpleLinkedList.remove("CD");
        simpleLinkedList.traverse();
    }

    protected void add(T item) {
        Node<T> node = new Node<T>();
        node.setValue(item);
        if (head == null) {
            tail = head = node;
        } else {
            tail.setNext(node);
            tail = node;
        }
    }

    protected void traverse() {
        if (head == null) {
            System.out.println("LinkedList is empty");
        }
        Node<T> temp = head;
        for (; ; ) {
            if (temp == null) break;
            System.out.println(temp.getValue());
            temp = temp.getNext();
        }
    }

    protected void remove(T item) {
        Node<T> temp = head, prevNode = null;

        if (head != null) {
            if (head.getValue() == item) {
                head = head.getNext();
            }
        }

        while (temp.getNext() != tail) {
            prevNode = temp;
            if (temp.getNext().getValue() == item) {
                break;
            } else {
                temp = temp.getNext();
            }
        }
        if(temp.getNext() == tail){
            if(tail.getValue() == item){
                tail = temp;
            }
        }else{
            prevNode = temp.getNext();
        }
    }
}
