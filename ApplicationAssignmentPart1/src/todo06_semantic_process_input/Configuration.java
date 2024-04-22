package todo06_semantic_process_input;

import static todo06_semantic_process_input.OutputConfig.*;

import java.time.ZoneId;

/* TODO Make this class hold the application's configuration.
        It's up to you what features it has, though they should
        reflect the categories in the configuration file(s).
        Before a configuration's value is set, it should ideally be checked
        to see if the value is sensible. Some values might only be checkable
        after other values are set.
        Ideally you should protect the configuration from unwanted access,
        as happened with in todo02.
        You might want to make this class a Singleton, meaning there can only
        be one instance of it during the lifetime of a single run of the
        application.
 */
public class Configuration {
    public OutputConfig outputStyle;
    public SplashConfig splashStyle;
    public ZoneId timeZone;
    private static Configuration instance;

    private Configuration(OutputConfig outputStyle, SplashConfig splashStyle, ZoneId timeZone) {
        this.outputStyle = outputStyle;
        this.splashStyle = splashStyle;
        this.timeZone = timeZone;
    }

    protected static Configuration getInstanceConfiguration(OutputConfig outputStyle, SplashConfig splashStyle, ZoneId timeZone)
    {
        if (instance == null)
        {
            instance = new Configuration(outputStyle, splashStyle, timeZone);
            return instance;
        }
        return instance;
    }


    public OutputConfig getOutputStyle() {
        return outputStyle;
    }

    public SplashConfig getSplashStyle() {
        return splashStyle;
    }

    public ZoneId getTimeZone() {
        return timeZone;
    }
}
