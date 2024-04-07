import java.beans.VetoableChangeListenerProxy;

public class DoublyLinkedList {

    private class Node{
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
            this.value=new Vocab(item);
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

    public void addAtHead(Vocab newVocab)
    {
        if(size==0)
        {
            head = new Node(new Vocab(newVocab),null,null);
            tail=head;
        }
        else
        {
            Node oldHead = head;
            this.head = new Node(new Vocab(newVocab),null,head);
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
            this.tail = new Node(new Vocab(newVocab),tail,null);

            oldTail.next = this.tail;
        }
        size++;
    }

    public void addAfter(Vocab vocab,Vocab newVocab)
    {
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
                    position.next=new Node(new Vocab(newVocab),position,position.next.next);
                    position.next.next.previous=position.next;
                    break;
                }
            }
        }
    }

}
