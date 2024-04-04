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

    public static void createFiles(){ //regler clothes qui na pas de contenu (tout shifted de un file)
        PrintWriter outputStreamWriterNewFiles = null;
        Scanner readerFilesTopics = null;
        Scanner readerInputFiles = null;
        try{
            readerFilesTopics = new Scanner(new File("input_topics_words.txt"));
            readerInputFiles = new Scanner(new File("A3_input_file.txt"));
            while (readerFilesTopics.hasNextLine()) {
                String topic = readerFilesTopics.nextLine();
                outputStreamWriterNewFiles = new PrintWriter(new FileOutputStream(topic + ".txt"));
                while (readerInputFiles.hasNextLine()) {
                    String topicContent = readerInputFiles.nextLine();
                    if (topicContent.equals("#" + topic)) {
                        break;
                    } else {
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

    }
}
