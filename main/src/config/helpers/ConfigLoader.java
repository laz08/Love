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

        //TODO: Beautify this. Really. It sucks.
        try {

            Scanner file = new Scanner(new File("config.txt"));

            String readLine;

            //Language
            boolean stop = false;
            while (file.hasNextLine() && !stop) {

                readLine = file.nextLine();
                if (isLineValid(readLine)) {

                    stop = true;
                    System.out.println(readLine);
                    mLanguageHelper.setLanguage(readLine);
                }
            }

            stop = false;
            //Hostname
            while (file.hasNextLine() && !stop) {

                readLine = file.nextLine();
                if (isLineValid(readLine)) {

                    stop = true;
                    Settings.setHostname(readLine);
                    System.out.println(readLine);
                }
            }

            stop = false;
            //Channel
            while (file.hasNextLine() && !stop) {

                readLine = file.nextLine();
                if (isLineValid(readLine)) {

                    stop = true;
                    Settings.setAutoJoinChannel(readLine);
                    System.out.println(readLine);
                }
            }

            stop = false;
            //Bot name
            while (file.hasNextLine() && !stop) {

                readLine = file.nextLine();
                if (isLineValid(readLine)) {

                    stop = true;
                    Settings.setBotUsername(readLine);
                    System.out.println(readLine);
                }

            }

        } catch (FileNotFoundException e) {

            throw new FileNotFoundException("Unable to read from file");

        }

    }

    /**
     * Determines if line is valid.
     *
     * @param line Line.
     * @return Returns true if line is valid, false otherwise.
     */
    private boolean isLineValid(String line) {

        return !line.startsWith("#") && !isLineEmpty(line);
    }

    /**
     * Determines if line is empty.
     *
     * @param line Line.
     * @return True if line is empty, false otherwise.
     */
    private boolean isLineEmpty(String line) {

        //boolean empty = line.isEmpty() || line.trim().equals("") || line.trim().equals("\n");
        //System.out.println("Line with content: '" + line + "' is empty: " + empty);
        return line.isEmpty() || line.trim().equals("") || line.trim().equals("\n");
    }
}
