package name.companjen.ben.olbot;

/**
 * Created by Ben on 17-5-2014.
 */
public interface Processor<T> {

    /**
     * Process a record
     * @param record
     * @return the processed record
     */
    public T process(T record);
}
