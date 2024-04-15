import java.beans.VetoableChangeListenerProxy;

public class DoublyLinkedList {

    public class Node{
        private Vocab value;
        private Node previous;
        private Node next;

        public Node()
        {
            value=null;
            previous =null;
            next =null;
        }

        public Node(Vocab item,Node prev,Node next)
        {
            this.value=item;
            this.previous =prev;
            this.next =next;
        }

        public Vocab getValue()
        {
            return this.value;
        }

        public Node getNext() {
            return this.next;
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
    public Node getHead()
    {
        return this.head;
    }

    public void addAtHead(Vocab newVocab)
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

    public void addAtTail(Vocab newVocab)
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
            size++;
        }
    }

    public void addAfter(Vocab vocab,Vocab newVocab)
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

    public void addBefore(Vocab vocab,Vocab newVocab)
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

    public Vocab removeHead()
    {
        if (size==0)
        {
            return null;
        }
        else if (size==1)
        {
            Vocab value = head.value;
            head=null;
            tail=null;
            size--;
            return value;
        }
        else
        {
            Vocab value = head.value;
            head = head.next;
            head.previous=null;
            size--;
            return value;
        }
    }

    public Vocab removeTail()
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
            Vocab value = tail.value;
            tail = tail.previous;
            tail.next =null;
            size--;
            return value;
        }
    }


    public Vocab removeValue(Vocab vocab)
    {
        Vocab value=null;
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

    
    public Vocab removeAfter(Vocab vocab)
    {
        Vocab value = null;
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
            System.out.println("The list_vocab has " + size + " element(s):\n");
            Node position = head;
            while (position != null) {
                System.out.println(position.value);
                position = position.next;
            }
        }
    }

    public boolean hasNext(Node node) {
        return node != null ;
    }

}
