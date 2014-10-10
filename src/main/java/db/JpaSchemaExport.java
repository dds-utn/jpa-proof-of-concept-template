package db;

import java.io.IOException;
import java.util.Properties;

import org.hibernate.cfg.Configuration;
import org.hibernate.ejb.Ejb3Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 * Run with args: <code>db schema.sql true true</code>
 * 
 * @author internet
 *
 */
@SuppressWarnings("deprecation")
public class JpaSchemaExport {

   public static void main(String[] args) throws IOException {
      execute(args[0], args[1], Boolean.parseBoolean(args[2]), Boolean.parseBoolean(args[3]));
   }

   public static void execute(String persistenceUnitName, String destination, boolean create,
         boolean format) {
      System.out.println("Starting schema export");
      Ejb3Configuration cfg = new Ejb3Configuration().configure(persistenceUnitName,
            new Properties());
      Configuration hbmcfg = cfg.getHibernateConfiguration();
      SchemaExport schemaExport = new SchemaExport(hbmcfg);
      schemaExport.setOutputFile(destination);
      schemaExport.setFormat(format);
      schemaExport.execute(true, false, false, create);
      System.out.println("Schema exported to " + destination);
   }
}