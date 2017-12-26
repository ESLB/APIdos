package strauss.sebastian.eduardo.apidos.POSTTodo;

public class Todo {

    private String text;
    private String _id;
    private Integer completedAt;
    private boolean completed;


    public Todo(String mtext, String _id, Integer completedAt, boolean completed) {
        this.text = mtext;
        this._id= _id;
        this.completedAt = completedAt;
        this.completed = completed;
    }

    public String getId() {
        return _id;
    }

    public void setId(Integer id) {
        id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(Integer completedAt) {
        this.completedAt = completedAt;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
