package strauss.sebastian.eduardo.apidos.POSTTodo;

public class Todo {

    private String text;
    private String _id;
    private Integer __v;
    private String completedAt;
    private boolean completed;


    public Todo(String _id, String text, Integer __v, String completedAt, boolean completed) {
        this.text = text;
        this._id= _id;
        this.__v = __v;
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

    public String getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(String completedAt) {
        this.completedAt = completedAt;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
