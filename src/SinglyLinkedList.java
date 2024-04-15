import java.util.ArrayList;

public class SinglyLinkedList {

    public class Node {
        private String  value;
        private Node next;

        public Node() {
            value = null;
            next = null;
        }

        public Node(String value, Node next) {
            this.value = value;
            this.next = next;
        }

        public void setValue(String value)
        {
            this.value = value;
        }

        public String getValue()
        {
            return this.value;
        }

        public Node getNext() {
            return this.next;
        }
    }

    private Node head;
    private  int size;

    public SinglyLinkedList()
    {
        this.head = null;
        this.size=0;
    }
    public Node getHead()
    {
        return this.head;
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
            size++;
        }
    }

    public void modifyValue(String valueBefore,String valueAfter)
    {
        String value=null;
        if (head.value.equals(valueBefore))
        {
            head.value = valueAfter;
        }
        else {
            Node position = head;
            while (position.next != null) {
                if (position.next.value.equals(valueBefore)) {

                    position.next.value = valueAfter;
                    break;
                }
                position = position.next;
            }
        }
    }

    public ArrayList<String> startsWith(char letter)
    {
        ArrayList<String> list = new ArrayList<String>();
        String value=null;
        if (head.value.charAt(0)==letter)
        {
            list.add(head.value);
        }
            Node  position = head;
            while (position.next != null) {
                if (position.next.value.charAt(0)==letter) {

                    list.add(position.next.value);
                }
                position = position.next;
            }
            return list;
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
            if (found==false&&position.value.equals(str))
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

    public String removeHead()
    {
        if (head!=null)
        {
            Node temp = head;

            head = head.next;

            size--;
            return  temp.value;
        }
        else
        {
            return null;
        }
    }

    public String removeEnd()
    {
        if (head==null)
        {
            return null;
        }
        else if (size==1)
        {
            String  value = head.value;
            head =null;
            size--;
            return value;
        }
        else
        {
            Node position = head;
            while (position.next.next!=null)
            {
                position = position.next;
            }
            String  value = position.next.value;
            position.next=null;
            size--;
            return value;
        }
    }

    public String removeValue(String str)
    {
        String  value=null;
        if (head.value.equals(str))
        {
            value = head.value;
            removeHead();
        }
        else {
            Node  position = head;
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

    public boolean contains(String str)
    {
        boolean found =false;
        String  value=null;
        if (head.value.equals(str))
        {
            found =true;
        }
        else {
            Node  position = head;
            while (position.next != null) {
                if (position.next.value.equals(str)) {
                    found = true;
                    break;
                }
                position = position.next;
            }
        }
        return found;
    }

    public String removeAfter(String str)
    {
        boolean found = false;
        String  value=null;
        if(size<2)
        {
            value =null;
        }
        //good case
        else {
            Node  position = head;
            while (position.next != null) {
                if (position.value.equals(str)) {

                    value = position.next.value;
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

    public String displayList()
    {    StringBuilder str = new StringBuilder();
        int count=1;
        if (head==null)
        {
            str.append("There are no items");
        }
        else {
            //System.out.println("Your list has " + size + " element(s): ");
            Node position = head;
            while (position != null) {
                str.append(String.format("%-30s",count+": "+ position.value));
               //str += count+": "+position.value.toString()+"\t\t\t";
               if (count%4==0)
               {
                   //str+="\n";
                   str.append("\n");
               }
                position = position.next;
                count++;
            }
        }
        return str.toString();
    }



    public void emptyList()
    {
        head = null;
    }

    public SinglyLinkedList clone() {
        SinglyLinkedList clonedList = new SinglyLinkedList();

        // Traverse the original list
        Node current = this.head;
        while (current != null) {
            // Add each element to the cloned list
            clonedList.addAtEnd(current.value);
            current = current.next;
        }

        return clonedList;
    }



    //contains

    //modify












}
