package application.base;

/* TODO This class has been implemented as a "record" which is basically a
        special shortened syntax for some forms of class.
        JDK 17 is the first LTS version of Java to have records.
 */

public record ConfigFileHandler(String[] filenames) {
    public ConfigFileHandler(String[] filenames) {
        this.filenames = filenames;
        processFilenames();
    }

    private void processFilenames() {
        for ( String filename : filenames ) {
            System.out.printf("TODO Processing file \"%s\"%n", filename);
        }
    }

    @Override
    public String[] filenames() {return filenames.clone();}
}

/*
// The same code as above but as a regular class

public class ConfigFileHandler {
    private final String[] filenames;

    public ConfigFileHandler(String[] filenames) {
        this.filenames = filenames;
        processFilenames();
    }

    private void processFilenames() {
        for ( String filename : filenames ) {
            System.out.printf("Processing file \"%s\"%n", filename);
        }
    }

    public String[] getFilenames() {return filenames.clone();}
}
*/
