public interface MoviesProject {
    /**
     * Search.  Note that this will be necessarily case-sensitive.
     * @param movie The name of the movie
     * @return The full entry associated with this movie.
     */
    String find(String movie);
    /**
     * Add a new entry.  The values are passed as a String, but they should then
     be collected into
     *  a Record or some other type of list that can be added to your hash
     table.
     * @param movie The name will be the table key.
     * @param entry The values that will be inserted.
     * @return true if insertion was successful
     */
    boolean add(String movie, String[] entry);
    /**
     * Remove an entry.
     * @param movie  The key for the entry to remove.
     * @return true if this entry was deleted.
     */
    boolean delete(String movie);
    /**
     * Print the entire table in the format below:
     *  INDEX : KEY : ENTRY
     */
    void printHT();
    /**
     * How full is this table?  Count how many entries you have and divide by the
     size of the table.
     * @return
     */
    Double getLoadFactor();
    /**
     * How full can this table be?
     * @return maximum load factor
     */
    double getMaxLoadFactor();
    /**
     * The number of items in this table.
     * @return n
     */
    int count();
    /**
     * The author of this particular Project.
     */
    void who();
    /**
     * Print all the instructions along with any helpful information.
     */
    void help();
    /**
     * Print an exit message and close the program.
     */
    void exit();
}
