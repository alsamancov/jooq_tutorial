package org.first.jooq;

import org.first.jooq.tables.Users;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        System.out.println( "Hello World!" );


        String user = "root";
        String pas = "postgres";
        String url = "jdbc:postgresql://localhost:5432/first_jooq";

        try {
            Connection connection = DriverManager.getConnection(url, user, pas);
            DSLContext dslContext = DSL.using(connection, SQLDialect.POSTGRES);

            Users u = new Users();

            System.out.println("First select");
            for (Record us : dslContext.selectFrom(u.USERS).orderBy(u.USERS.ID))
            System.out.println("ID: " + us.get("id") + " NAME: " + us.get("name") + " AGE: " + us.get("age"));


            System.out.println("\nAfter insert!");
            dslContext.insertInto(u.USERS).columns(u.NAME, u.AGE).values("Anie", 32).execute();

            for (Record us : dslContext.selectFrom(u.USERS).orderBy(u.USERS.ID))
                System.out.println("ID: " + us.get("id") + " NAME: " + us.get("name") + " AGE: " + us.get("age"));

            System.out.println("\nAfter update!");
            dslContext.update(u.USERS).set(u.NAME, "Mara").set(u.AGE, 21).where(u.ID.eq(1)).execute();
            dslContext.update(u.USERS).set(u.NAME, "Mary").where(u.ID.eq(4)).execute();
            for (Record us : dslContext.selectFrom(u.USERS).orderBy(u.USERS.ID))
                System.out.println("ID: " + us.get("id") + " NAME: " + us.get("name") + " AGE: " + us.get("age"));


            System.out.println("\nAfter delete!");
            dslContext.delete(u.USERS).where(u.ID.eq(2)).execute();
            for (Record us : dslContext.selectFrom(u.USERS).orderBy(u.USERS.ID))
                System.out.println("ID: " + us.get("id") + " NAME: " + us.get("name") + " AGE: " + us.get("age"));


        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
