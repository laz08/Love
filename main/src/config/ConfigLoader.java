package src.config;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Configuration loader.
 * Reads from the config.txt file located at ~/LoveFuets/src/config/ directory.
 */
public class ConfigLoader {

    private LanguageHelper mLanguageHelper;

    /**
     * Constructor.
     */
    public ConfigLoader() {

        mLanguageHelper = new LanguageHelper();
    }

    /**
     * Reads the configuration file.
     *
     * @throws FileNotFoundException Exception.
     */
    public void readConfig() throws FileNotFoundException {

        try {

            Scanner file = new Scanner(new File("main/src/config/config.txt"));

            String configLine = file.nextLine();
            mLanguageHelper.setLanguage(configLine);


        } catch (FileNotFoundException e) {

            throw new FileNotFoundException("Unable to read from file");
        }
    }
}
