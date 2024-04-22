package todo06_semantic_process_input;

import todo00_obfuscation.Bottle;
import todo05_syntax_process_input.SplitInput;

import java.time.ZoneId;
import java.util.List;

import static todo05_syntax_process_input.BasicProcessInput.normaliseCategory;

public class ProcessConfigCategory {
    // NOTE: Utility class, so do not instantiate

    /* TODO Note the call to normaliseCategory is imported from another todo task.
            Doing this is computationally less efficient than normalising the
            Strings manually but it guarantees compliance with the normalisation
            standard.
     */
    public static final String NAME_OUTPUT   = normaliseCategory("output");
    public static final String NAME_LOADING  = normaliseCategory("loading");
    public static final String NAME_TIMEZONE = normaliseCategory("timezone");


    // TODO Add more constants as you add more categories

    public static OutputConfig outputStyle;
    public static SplashConfig splashStyle;
    public static ZoneId timeZone;

    private ProcessConfigCategory() {} // Utility class: do not instantiate


    public static Configuration processCategories(List<SplitInput> splitLines) {
    // Note this uses the SplitInput class from the syntax processing tasks

        for ( SplitInput splitLine : splitLines ) {
            /* TODO Even if you have already removed blank lines,
                    consider having robustness against them in this method
                    just in case the input has been created unofficially.
             */

            // Note: Saving a repeated method call can be faster
            String category = splitLine.category();

            /* TODO There is no semantic checking of the data but
                    there should be. The requirements vary for each category.
                    Ensure this processCategories method does not become
                    unduly long.
             */
            /* TODO This technique of acting on the input is basic but works.
                    See if you can find a neater way.
             */
            if ( category.equals(NAME_LOADING) ) {
                /* TODO You should probably ensure the loading screen
                        is the first thing the program prints
                 */
                if (splitLine.data().toLowerCase().equals("show")) {
                    splashStyle = SplashConfig.SHOW;                    
                }
                else if (splitLine.data().toLowerCase().equals("on")) {
                    splashStyle = SplashConfig.ON;
                }
                else if (splitLine.data().toLowerCase().equals("yes"))
                {
                    splashStyle = SplashConfig.YES;
                }
                else
                {
                    continue;
                }
                System.out.print(Bottle.MESSAGE);
            } else if ( category.equals(NAME_OUTPUT) ) {
                /* TODO Actually set the output style option.
                        You'll have to create the required variable.
                 */
                if (splitLine.data().toLowerCase().equals("summary"))
                {
                    outputStyle = OutputConfig.SUMMARY;
                }
                else if (splitLine.data().toLowerCase().equals("daily"))
                {
                    outputStyle = OutputConfig.DAILY;
                }
                else
                {
                    continue;
                }
                System.err.printf("Set output style to >%s<%n",
                                  splitLine.data());
            } else if ( category.equals(NAME_TIMEZONE) ) {
                /* TODO Actually set the application's timezone.
                        You'll have to create the required variable
                 */
                try {
                    timeZone = ZoneId.of(splitLine.data());
                } catch (Exception e) {
                    System.err.println("BLAH");
                }
                System.err.printf("Process timezone to be >%s<%n",
                                  splitLine.data());
            } else {
                /* TODO You need to do better than this for unrecognised categories
                        Do not use Exceptions.
                 */
                System.err.printf("Config category >%s< unrecognised (data >%s<)%n",
                                  category, splitLine.data());
            }
        }
        if (outputStyle == null) {
            outputStyle = OutputConfig.SUMMARY;
        }
        if (splashStyle == null)
        {
            splashStyle = SplashConfig.SHOW;
        }
        if (timeZone == null)
        {
            timeZone = ZoneId.of("Europe/London");
        }
        Configuration instance = Configuration.getInstanceConfiguration(outputStyle, splashStyle, timeZone);
        return instance;
    }
}
