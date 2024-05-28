import java.util.Stack;

class TextEditor {
    private StringBuilder text;
    private Stack<Action> history;
    private Stack<Action> redoHistory;

    public TextEditor() {
        text = new StringBuilder();
        history = new Stack<>();
        redoHistory = new Stack<>();
    }

    public void insertText(String text, int position) {
        this.text.insert(position, text);
        history.push(new Action(ActionType.INSERT, position, text));
        redoHistory.clear(); // Clear redo history after a new action
    }

    public void deleteText(int start, int end) {
        String deletedText = this.text.substring(start, end);
        this.text.delete(start, end);
        history.push(new Action(ActionType.DELETE, start, deletedText));
        redoHistory.clear(); // Clear redo history after a new action
    }

    public void undo() {
        if (!history.isEmpty()) {
            Action lastAction = history.pop();
            redoHistory.push(lastAction);
            if (lastAction.type == ActionType.INSERT) {
                text.delete(lastAction.position, lastAction.position + lastAction.text.length());
            } else if (lastAction.type == ActionType.DELETE) {
                text.insert(lastAction.position, lastAction.text);
            }
        } else {
            System.out.println("Nothing to undo");
        }
    }

    public void redo() {
        if (!redoHistory.isEmpty()) {
            Action lastRedoAction = redoHistory.pop();
            history.push(lastRedoAction);
            if (lastRedoAction.type == ActionType.INSERT) {
                text.insert(lastRedoAction.position, lastRedoAction.text);
            } else if (lastRedoAction.type == ActionType.DELETE) {
                text.delete(lastRedoAction.position, lastRedoAction.position + lastRedoAction.text.length());
            }
        } else {
            System.out.println("Nothing to redo");
        }
    }

    public String getText() {
        return text.toString();
    }

    private enum ActionType {
        INSERT, DELETE
    }

    private static class Action {
        ActionType type;
        int position;
        String text;

        Action(ActionType type, int position, String text) {
            this.type = type;
            this.position = position;
            this.text = text;
        }
    }

    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        editor.insertText("Hello, ", 0);
        editor.insertText("world!", editor.getText().length());
        System.out.println("Current Text: " + editor.getText()); // Output: Current Text: Hello, world!
        editor.undo();
        System.out.println("Current Text: " + editor.getText()); // Output: Current Text: Hello, 
        editor.redo();
        System.out.println("Current Text: " + editor.getText()); // Output: Current Text: Hello, world!
    }
}
