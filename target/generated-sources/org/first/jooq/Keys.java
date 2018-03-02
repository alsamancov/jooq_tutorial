/*
 * This file is generated by jOOQ.
*/
package org.first.jooq;


import javax.annotation.Generated;

import org.first.jooq.tables.Users;
import org.first.jooq.tables.records.UsersRecord;
import org.jooq.Identity;
import org.jooq.UniqueKey;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables of 
 * the <code>public</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.5"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------

    public static final Identity<UsersRecord, Integer> IDENTITY_USERS = Identities0.IDENTITY_USERS;

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<UsersRecord> USERS_PKEY = UniqueKeys0.USERS_PKEY;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------


    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Identities0 {
        public static Identity<UsersRecord, Integer> IDENTITY_USERS = Internal.createIdentity(Users.USERS, Users.USERS.ID);
    }

    private static class UniqueKeys0 {
        public static final UniqueKey<UsersRecord> USERS_PKEY = Internal.createUniqueKey(Users.USERS, "users_pkey", Users.USERS.ID);
    }
}