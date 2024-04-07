import java.io.*;
import java.util.Scanner;



public class driver{

    /** This function will create the file which contains all the Topics
     */
    public static void createTopicWordFile() {
        PrintWriter outputStreamWriterFiles = null;
        Scanner readerFiles = null;
        try{
            outputStreamWriterFiles = new PrintWriter(new FileOutputStream("input_topics_words.txt"));
            readerFiles = new Scanner(new FileInputStream("A3_input_file.txt"));
            while(readerFiles.hasNextLine()){
                String lineTopic = readerFiles.nextLine();
                if(lineTopic.startsWith("#")){
                    String topic = lineTopic.substring(1);
                    outputStreamWriterFiles.println(topic);
                }
            }
            outputStreamWriterFiles.close();
            readerFiles.close();
        } catch (IOException e) {
            System.out.println("The file couldn't be created properly.");
        }
    }



    public static void createFiles(){
        PrintWriter outputStreamWriterNewFiles = null;
        Scanner readerFilesTopics = null;
        Scanner readerInputFiles = null;
        try{
            readerFilesTopics = new Scanner(new File("input_topics_words.txt"));
            while (readerFilesTopics.hasNextLine()) {
                readerInputFiles = new Scanner(new File("A3_input_file.txt"));
                String topic = readerFilesTopics.nextLine();
                outputStreamWriterNewFiles = new PrintWriter(new FileOutputStream(topic + ".txt"));
                boolean isTopicFound = false;
                while (readerInputFiles.hasNextLine()) {
                    String topicContent = readerInputFiles.nextLine();
                    if (topicContent.equals("#" + topic)) {
                        isTopicFound = true;
                        continue;
                    }
                    if (isTopicFound && topicContent.startsWith("#")) {
                        break;
                    }
                    if (isTopicFound) {
                        outputStreamWriterNewFiles.println(topicContent);
                    }
                }
                outputStreamWriterNewFiles.close();

            }
            readerFilesTopics.close();
            readerInputFiles.close();
        }catch (FileNotFoundException e){
            System.out.println("The file couldn't be created.");
        }
    }

    public static void displayMenu(){
        System.out.println(
                "--------------------------------------------------\n" +
                "Vocabulary Control Center\n" +
                "--------------------------------------------------\n" +
                "1 browse a topic\n" +
                "2 insert a new topic before another one\n" +
                "3 insert a new topic after another one\n" +
                "4 remove a topic\n" +
                "5 modify a topic\n" +
                "6 search topics for a word\n" +
                "7 load from a file\n" +
                "8 show all words starting with a given letter\n" +
                "0 exit\n" +
                "--------------------------------------------------\n" +
                "Enter Your Choice:");
    }

    public static void getTopic(){

    }

    public static void main(String []args){
        createTopicWordFile();
        createFiles();


        //TESTING ZONE
        SinglyLinkedList <String>list  = new SinglyLinkedList<String>();
        list.addAtHead("allo");
        list.addAtEnd("bye");
        list.addAtHead("salut");
        list.addAfter("allo","aurevoir");
        list.addAfter("allo","souky");
        list.addBefore("aurevoir","dfg");
        list.addAfter("bye","cheh");
        list.addAfter("bye","c");
        Vocab v = new Vocab("color",list);

        SinglyLinkedList list2= new SinglyLinkedList<>();

        list2.addAtHead("a");
        list2.addAtEnd("b");
        list2.addAtHead("g");
        list2.addAfter("a","r");
        list2.addAfter("a","s");
        list2.addBefore("r","f");
        list2.addAfter("b","h");
        list2.addAfter("b","t");

        Vocab v1 = new Vocab("cars",list2);

        SinglyLinkedList list3= new SinglyLinkedList<>();

        list3.addAtHead("0");
        list3.addAtEnd("7");
        list3.addAtHead("5");
        list3.addAfter("0","4");
        list3.addAfter("0","3");
        list3.addBefore("4","89");
        list3.addAfter("7","65");
        list3.addAfter("7","56");

        Vocab v2 = new Vocab("house",list3);

        Vocab v3 = new Vocab("pool",list3);

        DoublyLinkedList dlist = new DoublyLinkedList();

        dlist.addAtHead(v2);
        dlist.addAtTail(v1);
        dlist.addAfter(v2,v3);
        dlist.addAtHead(v);





        //output : salut,allo,souky,aurevoir,bye

    }
}
