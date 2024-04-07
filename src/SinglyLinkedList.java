public class SinglyLinkedList<T> {

    private class Node <T>{
        private T value;
        private Node next;

        public Node() {
            value = null;
            next = null;
        }

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node head;
    private  int size;

    public SinglyLinkedList()
    {
        this.head = null;
        this.size=0;
    }


    public boolean isEmpty()
    {
        return size==0;
    }

    public void addAtHead(String newValue)
    {
        this.head = new Node(newValue,head);
        size++;
    }

    public void addAtEnd(String newValue)
    {
        if(head==null)
        {
            addAtHead(newValue);
        }
        else {

            Node position = head;
            while (position.next != null) {
                position = position.next;
            }
            position.next = new Node(newValue,null);
        }
        size++;
    }

    public void addAfter(String str,String newStr)
    {
        boolean found = false;
            Node position = head;

            while (position.next!=null) {

                if (position.value.equals(str)) {
                    position.next = new Node(newStr, position.next);
                    size++;
                    found=true;
                    break;
                }
                position = position.next;
            }
            if (found==false)
            {
                addAtEnd(newStr);
            }
    }

    public void addBefore(String str,String newStr)
    {
       Node position = head;
       Node before = null;

       while (position.next!=null)
       {
           if (position.value.equals(str))
           {
               Node newNode = new Node(newStr,position);
               if (before!=null)
               {
                  before.next = newNode;
               }
               else
               {
                   addAtHead(newStr);
               }
               size++;
               break;
           }
           before =position;
           position = position.next;
       }
    }

    public T removeHead()
    {
        if (head!=null)
        {
            Node <T>temp = head;

            head = head.next;

            size--;
            return (T) temp.value;
        }
        else
        {
            return null;
        }
    }

    public T removeEnd()
    {
        if (head==null)
        {
            return null;
        }
        else if (size==1)
        {
            T value = (T)head.value;
            head =null;
            return value;
        }
        else
        {
            Node <T>position = head;
            while (position.next.next!=null)
            {
                position = position.next;
            }
            T value = (T)position.next.value;
            position.next=null;
            size--;
            return value;
        }
    }

    public T removeValue(String str)
    {
        T value=null;
        if (head.value.equals(str))
        {
            value = (T)head.value;
            removeHead();
        }
        else {
            Node <T> position = head;
            while (position.next != null) {
                if (position.next.value.equals(str)) {

                    value = (T)position.next.value;
                    position.next = position.next.next;
                    size--;
                    break;
                }
                position = position.next;
            }
        }
        return value;
    }

    public T removeAfter(String str)
    {
        boolean found = false;
        T value=null;
        if(size<2)
        {
            value =null;
        }
        //good case
        else {
            Node <T> position = head;
            while (position.next != null) {
                if (position.value.equals(str)) {

                    value = (T)position.next.value;
                    position.next = position.next.next;
                    size--;
                    found= true;
                    break;
                }
                position = position.next;
            }
            if (position.next==null&&found==false)
            {
                value=null;
            }
        }
        return value;
    }

    public int getSize()
    {
        return this.size;
    }

    public void displayList()
    {
        if (head==null)
        {
            System.out.println("There are no items");
        }
        else {
            System.out.println("Your list has " + size + " element(s): ");
            Node <T>position = head;
            while (position != null) {
                System.out.println(position.value);
                position = position.next;
            }
        }
    }










}
