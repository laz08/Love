package src.config;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ConfigLoader {

    public ConfigLoader() {
    }

    public void readConfig() throws FileNotFoundException {

        try {
            Scanner file = new Scanner(new File("LoveFuets/src/config/config.txt"));
            while(file.hasNextLine()){

                System.out.println(file.nextLine());
                
            }
        } catch (FileNotFoundException e) {

            throw new FileNotFoundException("Unable to read from file");
        }
    }
}
