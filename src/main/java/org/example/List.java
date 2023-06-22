package org.example;

public class List {
    private Node head;
    private Node tail;

    public Node find(int value) {
        Node currentNode = head;
        while(currentNode != null) {
            if(currentNode.getValue()==value) {
                return currentNode;
            }
            currentNode = currentNode.getNext();
        }
        return null;
    }
    public void addLast(int value) {
        Node node = new Node(value);
        if(head == null) {
            head = node;
            tail = node;
        } else {
            tail.setNext(node);
            node.setPrevious(tail);
            tail = node;
        }
    }

    public void addFirst(int value) {
        Node node = new Node(value);
        if(head == null) {
            head = node;
            tail = node;
        } else {
            head.setPrevious(node);
            node.setNext(head);
            head = node;
        }
    }

    public void addAfter(int value, Node node) {
        Node next = node.getNext();
        Node newNode = new Node(value);
        node.setNext(newNode);
        newNode.setPrevious(node);
        if(next == null) {
            tail = newNode;
        } else {
            next.setPrevious(newNode);
            newNode.setNext(next);
        }
    }

    public void delete(Node node) {
        if(node != null) {
            Node previous = node.getPrevious();
            Node next = node.getNext();
            if(previous == null && next == null) {
                head = null;
                tail = null;
            } else if(previous == null) {
                next.setPrevious(null);
                head = next;
            } else if(next == null) {
                previous.setNext(null);
                tail = previous;
            } else {
                previous.setNext(next);
                next.setPrevious(previous);
            }
        }
    }


    public void revert() {
        Node currentNode = head;
        if(head != null && head.getNext() != null) {
            while(currentNode != null) {
                Node next = currentNode.getNext();
                Node previous = currentNode.getPrevious();
                currentNode.setNext(previous);
                currentNode.setPrevious(next);
                if(previous == null) {
                    tail = currentNode;
                }
                if(next == null) {
                    head = currentNode;
                }
                currentNode = next;
            }
        }
    }

    public void print() {
        if(head != null) {
            Node currentNode = head;
            Node next = currentNode.getNext();
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            while(currentNode != null) {
                sb.append(currentNode.getValue() + ", ");
                //System.out.println(currentNode.value);
                next = currentNode.getNext();
                currentNode = next;
            }
            sb.delete(sb.length() -2, sb.length());
            sb.append("]");
            System.out.println(sb.toString());
        }
    }
}
