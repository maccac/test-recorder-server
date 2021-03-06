/**
 * This class is generated by jOOQ
 */
package jooq;


import javax.annotation.Generated;

import jooq.tables.Idetestresults;
import jooq.tables.records.IdetestresultsRecord;

import org.jooq.Identity;
import org.jooq.UniqueKey;
import org.jooq.impl.AbstractKeys;


/**
 * A class modelling foreign key relationships between tables of the <code>PUBLIC</code> 
 * schema
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.8.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------

    public static final Identity<IdetestresultsRecord, Long> IDENTITY_IDETESTRESULTS = Identities0.IDENTITY_IDETESTRESULTS;

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<IdetestresultsRecord> CONSTRAINT_1 = UniqueKeys0.CONSTRAINT_1;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------


    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Identities0 extends AbstractKeys {
        public static Identity<IdetestresultsRecord, Long> IDENTITY_IDETESTRESULTS = createIdentity(Idetestresults.IDETESTRESULTS, Idetestresults.IDETESTRESULTS.ID);
    }

    private static class UniqueKeys0 extends AbstractKeys {
        public static final UniqueKey<IdetestresultsRecord> CONSTRAINT_1 = createUniqueKey(Idetestresults.IDETESTRESULTS, "CONSTRAINT_1", Idetestresults.IDETESTRESULTS.ID);
    }
}
