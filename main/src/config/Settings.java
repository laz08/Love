package src.config;

import src.config.languages.LanguageId;

/**
 * LoveLetter settings.
 */
public class Settings {

    private static String mHostname;
    private static String mUsername;
    private static String mChannel;
    private static LanguageId mLanguage;

    /**
     * Sets bot username.
     *
     * @param username Username.
     */
    public static void setBotUsername(String username) {

        mUsername = username;
    }

    /**
     * Returns autojoin channel.
     *
     * @return Channel.
     */
    public static String getAutoJoinChannel() {

        return mChannel;
    }

    /**
     * Sets autojoin channel.
     *
     * @param channel Channel.
     */
    public static void setAutoJoinChannel(String channel) {

        mChannel = channel;
    }

    /**
     * Gets hostname.
     *
     * @return Hostname.
     */
    public static String getHostname() {

        return mHostname;
    }

    /**
     * Sets hostname.
     *
     * @param hostname Hostname.
     */
    public static void setHostname(String hostname) {

        mHostname = hostname;
    }

    /**
     * Gets username.
     *
     * @return Username.
     */
    public static String getUsername() {

        return mUsername;
    }

    /**
     * Gets system language.
     *
     * @return System language.
     */
    public static LanguageId getLanguage() {

        return mLanguage;
    }

    /**
     * Sets system language.
     */
    public static void setLanguage(LanguageId language) {

        mLanguage = language;
    }
}
