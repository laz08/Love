package src.config.languages;

/**
 * Language id.
 */
public enum LanguageId {

    SPANISH("spanish"),
    ENGLISH("english");

    private String mId;

    LanguageId(String id){

        mId = id;
    }

    String getId(){

        return mId;
    }


    public static LanguageId getLanguageId(String id){

        for(LanguageId languageId : values()){

            if(languageId.getId().equals(id)){

                return languageId;
            }
        }
        return null;
    }
}
