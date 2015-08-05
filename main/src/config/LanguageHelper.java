package src.config;

import src.config.languages.EnglishTexts;
import src.config.languages.LanguageId;
import src.config.languages.LanguageTexts;
import src.config.languages.SpanishTexts;

/**
 * Language helper.
 */
public class LanguageHelper {

    private LanguageTexts mTexts;
    private LanguageId mLanguageId;

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

        mLanguageId = LanguageId.getLanguageId(id);

        switch (mLanguageId) {
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
