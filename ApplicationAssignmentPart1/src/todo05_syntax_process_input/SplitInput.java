package todo05_syntax_process_input;

/* TODO When you finished this class, IntelliJ can probably turn it
        into a record. Before you do that, duplicate the entire contents and
        put the duplicate contents into a block comment. After you have asked
        IntelliJ to convert the class into a record, you can compare the
        difference in source code between the record and the original class.
 */
public final class SplitInput {
    private final String category;
    private final String data;

    /**
     * @param category The name of the line from the input
     * @param data     The String that accompanied the command in the input
     */
    public SplitInput(String category, String data) {
        this.category = BasicProcessInput.normaliseCategory(category);
        this.data     = data;
    }

    public String category() {return category;}

    public String data() {return data;}
}

