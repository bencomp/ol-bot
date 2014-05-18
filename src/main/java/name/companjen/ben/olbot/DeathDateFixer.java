package name.companjen.ben.olbot;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Processor for author death dates
 * @author Ben Companjen
 * @since 18-5-2014
 */
@Path("olbot")
public class DeathDateFixer implements Processor<Author> {

    private Pattern deathDatePattern;

    public DeathDateFixer() {
        deathDatePattern = Pattern.compile("^\\s*(\\d{4})\\s*\\.?$");
    }

    @Override
    @Path("deathdate")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Author process(Author author) {
        if (author.getDeathDate() != null) {
            author.setDeathDate(fixDeathDate(author.getDeathDate()));
        }

        return author;
    }

    /**
     * Get a cleaned ("fixed") version of the death date
     * @param deathDate date of death to be fixed
     * @return a fixed version of the death date, or the supplied
     * string if nothing can be done to improve the value.
     */
    public String fixDeathDate(String deathDate) {
        Matcher matcher = deathDatePattern.matcher(deathDate);
        if (matcher.matches()) {
            deathDate = matcher.group(1);
        }
        return deathDate;
    }
}
