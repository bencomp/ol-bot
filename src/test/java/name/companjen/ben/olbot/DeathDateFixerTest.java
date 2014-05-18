package name.companjen.ben.olbot;

import org.junit.Test;

import static org.junit.Assert.*;

public class DeathDateFixerTest {

    @Test
    public void testFixDeathDate() throws Exception {
        DeathDateFixer deathDateFixer = new DeathDateFixer();

        assertEquals("1234", deathDateFixer.fixDeathDate("1234."));
        assertEquals("12 May 2014", deathDateFixer.fixDeathDate("12 May 2014"));
        assertEquals("1234", deathDateFixer.fixDeathDate("1234"));
        assertEquals("1234", deathDateFixer.fixDeathDate("  1234  ."));
    }
}