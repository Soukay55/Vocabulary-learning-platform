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

    public SinglyLinkedList getWords()
    {
        return words;
    }
    public Vocab(String topic, SinglyLinkedList words) {
        this.topic = topic;
        this.words = words;
    }

    public Vocab(Vocab other) {
        this.topic = other.topic;
        this.words = other.words;
    }

    public boolean equals(Object other)
    {
        if (other ==null)
        {
            return false;
        }
        else if(getClass()!=other.getClass())
        {
            return false;
        }
        else
        {
            Vocab otherV = (Vocab) other;
            return this.topic.equals(otherV.topic);
        }
    }

    public String toString()
    {
        return "Topic: "+this.topic+"\nwords:\n"+words.displayList();
    }
}
