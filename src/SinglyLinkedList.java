public class SinglyLinkedList {

    private class Node {
        private String value;
        private Node next;

        public Node() {
            value = "";
            next = null;
        }

        public Node(String value, Node next) {
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

    public SinglyLinkedList(Node head,int size)
    {
        this.head = head;
        this.size=size;
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
            Node position = head;

            while (position.next!=null) {

                if (position.value.equals(str)) {
                    position.next = new Node(newStr, position.next);
                    size++;
                    break;
                }
                position = position.next;
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

    public String removeHead()
    {
        if (head!=null)
        {
            Node temp = head;

            head = head.next;

            size--;
            return head.value;
        }
        else
        {
            return "there is no items";
        }
    }

    public String removeEnd()
    {
        if (head==null)
        {
            return "There are no items";
        }
        else if (size==1)
        {
            String value = head.value;
            head =null;
            return value;
        }
        else
        {
            Node position = head;
            while (position.next.next!=null)
            {
                position = position.next;
            }
            String value = position.next.value;
            position.next=null;
            size--;
            return value;
        }
    }

    public String removeValue(String str)
    {
        String value="";
        if (head.value.equals(str))
        {
            value = head.value;
            removeHead();
        }
        else {
            Node position = head;
            while (position.next != null) {
                if (position.next.value.equals(str)) {

                    value = position.next.value;
                    position.next = position.next.next;
                    size--;
                    break;
                }
                position = position.next;
            }
        }
        return value;
    }

    public String removeAfter(String str)
    {
        String value="";
        if(size<2)
        {
            value = "there is nothing after";
        }
        //good case
        else {
            Node position = head;
            while (position.next != null) {
                if (position.value.equals(str)) {

                    value = position.next.value;
                    position.next = position.next.next;
                    size--;
                    break;
                }
                position = position.next;
            }
            if (position.next==null)
            {
                value="There are no items after "+position.value;
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
            Node position = head;
            while (position != null) {
                System.out.println(position.value);
                position = position.next;
            }
        }
    }










}
