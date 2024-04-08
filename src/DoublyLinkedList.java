import java.beans.VetoableChangeListenerProxy;

public class DoublyLinkedList {

    private class Node{
        private String value;
        private Node previous;
        private Node next;

        public Node()
        {
            value=null;
            previous =null;
            next =null;
        }

        public Node(String item,Node prev,Node next)
        {
            this.value=new String(item);
            this.previous =prev;
            this.next =next;
        }

    }
    private Node head;
    private Node tail;
    private int size;

    public DoublyLinkedList()
    {
        head=null;
        tail =null;
        size=0;
    }

    public void addAtHead(String newVocab)
    {
        if(size==0)
        {
            head = new Node(newVocab,null,null);
            tail=head;
        }
        else
        {
            Node oldHead = head;
            this.head = new Node(newVocab,null,head);
            oldHead.previous = head;
        }
        size++;
    }

    public void addAtTail(String newVocab)
    {
        if (size==0)
        {
            addAtHead(newVocab);
        }
        else
        {
            Node oldTail = tail;
            this.tail = new Node(newVocab,tail,null);

            oldTail.next = this.tail;
        }
        size++;
    }

    public void addAfter(String vocab,String newVocab)
    {
        boolean found = false;
        if(size==0)
        {
            return;
        }
        else
        {
            Node position = head;
            while (position.next!=null)
            {
                if(position.value.equals(vocab))
                {
                    Node oldNode = position.next;
                    position.next=new Node(newVocab,position,position.next);
                    oldNode.previous = position.next;
                    size++;
                    found = true;
                    break;
                }
                position = position.next;
            }

            if (found==false)
            {
                addAtTail(newVocab);
            }
        }
    }

    public void addBefore(String vocab,String newVocab)
    {
        boolean found = false;
        if (size==0)
        {
            return;
        }
        else if (head.value.equals(vocab))
        {
            addAtHead(newVocab);
        }
        else
        {
            Node position = head;
            while (position.next!=null)
            {
                if (position.next.value.equals(vocab))
                {
                    Node oldPrev = position;
                    Node oldNode = position.next;
                    position.next = new Node(newVocab,position,position.next);
                    oldNode.previous = position.next;
                    oldPrev.next = position.next;
                    size++;
                    found = true;
                    break;

                }
                position = position.next;
            }
        }

    }

    public String removeHead()
    {
        if (size==0)
        {
            return null;
        }
        else if (size==1)
        {
            String value = head.value;
            head=null;
            tail=null;
            size--;
            return value;
        }
        else
        {
            String value = head.value;
            head = head.next;
            head.previous=null;
            size--;
            return value;
        }
    }

    public String removeTail()
    {
        if (size==0)
        {
            return null;
        }
        else if (size==1)
        {
            return removeHead();
        }
        else
        {
            String value = tail.value;
            tail = tail.previous;
            tail.next =null;
            size--;
            return value;
        }
    }


    public String removeValue(String vocab)
    {
        String value="";
        if (size==0)
        {
            value = null;
        }
        else {

            Node position = head;
            while (position!=null)
            {
                if (position.value.equals(vocab))
                {
                    if (position.previous==null)
                    {
                        value = head.value;
                        removeHead();
                    }
                    else if (position.next==null)
                    {
                        value=tail.value;
                        removeTail();
                    }
                    else {
                        value = position.value;
                        position.previous.next = position.next;
                        position.next.previous = position.previous;
                        size--;
                        break;
                    }
                }
                position = position.next;
            }
        }
        return value;
    }

    public int getSize()
    {
        return this.size;
    }

    public String removeAfter(String vocab)
    {
        String value = null;
        if (size<2)
        {
            return value;
        }
        else
        {
            return value;
        }
    }


    public void displayForward() {
        if (size == 0) {
            System.out.println("The list is empty");
        } else {
            System.out.println("The list has " + size + " element(s):");
            Node position = head;
            while (position != null) {
                System.out.println(position.value);
                position = position.next;
            }
        }
    }

}
