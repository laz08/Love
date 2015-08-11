package src.config.helpers;

import src.config.Settings;

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

        //TODO: Beautify this.
        try {

            Scanner file = new Scanner(new File("config.txt"));

            String readLine;

            //Language
            if (file.hasNextLine()) {
                readLine = file.nextLine();
                if(!readLine.startsWith("#") && !readLine.isEmpty()){

                    System.out.println(readLine);
                    mLanguageHelper.setLanguage(readLine);
                }
            }

            //Hostname
            if (file.hasNextLine()) {

                readLine = file.nextLine();
                Settings.setHostname(readLine);
                System.out.println(readLine);
            }

            //Channel
            if (file.hasNextLine()) {

                readLine = file.nextLine();
                Settings.setAutoJoinChannel(readLine);
                System.out.println(readLine);

            }

            //Bot name
            if (file.hasNextLine()) {

                readLine = file.nextLine();
                Settings.setBotUsername(readLine);
                System.out.println(readLine);

            }

        } catch (FileNotFoundException e) {

            throw new FileNotFoundException("Unable to read from file");

        }

    }
}
