package name.companjen.ben.olbot;

/**
 * Abstraction for an OpenLibrary record, i.e. Author, Edition or Work.
 * Created by Ben on 17-5-2014.
 */
public interface Record {

    /**
     * Set the record's key
     * @param key
     */
    public void setKey(String key);

    public String getKey();

    public Integer getRevision();

}
