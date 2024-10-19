package com.klu;
import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class JNDIDemo {
  public static void main(String[] args) {
    try {
      // Set up environment for creating the initial context
      Hashtable<String, String> env = new Hashtable<>();
      env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.fscontext.RefFSContextFactory");
      env.put(Context.PROVIDER_URL, "file:///C:/temp/jndi");

      // Create an initial context
      Context ctx = new InitialContext(env);

      // Look up a resource (e.g., a database)
      String dbName = "myDatabase";
      Context dbCtx = (Context) ctx.lookup(dbName);

      // Print the database context
      System.out.println("Database Context: " + dbCtx);

    } catch (NamingException e) {
      System.out.println("JNDI Error: " + e.getMessage());
    }
  }
}
