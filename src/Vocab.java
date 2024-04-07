public class Vocab {
    private String topic;

    private SinglyLinkedList words;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setWords(SinglyLinkedList words) {
        this.words = words;
    }

    public Vocab(String topic, SinglyLinkedList words) {
        this.topic = topic;
        this.words = words;
    }
}
