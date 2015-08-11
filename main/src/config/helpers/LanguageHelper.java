package src.config.helpers;

import src.config.Settings;
import src.config.languages.EnglishTexts;
import src.config.languages.LanguageId;
import src.config.languages.LanguageTexts;
import src.config.languages.SpanishTexts;

/**
 * Language helper.
 */
public class LanguageHelper {

    private LanguageTexts mTexts;

    /**
     * Constructor.
     */
    public LanguageHelper() {

    }

    /**
     * Sets language of the bot.
     *
     * @param id
     */
    public void setLanguage(String id) {

        System.out.println("Setting language...");

        LanguageId language = LanguageId.getLanguageId(id);
        Settings.setLanguage(language);

        switch (language) {

            case SPANISH:
                mTexts = new SpanishTexts();
                System.out.println("Language set to Spanish!");
                break;

            case ENGLISH:
                mTexts = new EnglishTexts();
                System.out.println("Language set to English!");
                break;
        }
    }


}
