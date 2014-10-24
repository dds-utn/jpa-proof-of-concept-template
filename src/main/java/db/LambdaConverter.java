package db;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Sample of usage:
 * 
 * <pre>
 * &#064;Entity
 * public class Foo {
 * 
 *    &#064;Id
 *    &#064;GeneratedValue
 *    public Long id;
 * 
 *    &#064;Convert(converter = LambdaConverter.class)
 *    public Runnable r;
 * }
 * </pre>
 * 
 * 
 * @author flbulgarelli
 */
@Converter
public class LambdaConverter implements AttributeConverter<Object, byte[]> {

   @Override
   public byte[] convertToDatabaseColumn(Object lambda) {
      ByteArrayOutputStream out = new ByteArrayOutputStream();
      try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(out)) {
         objectOutputStream.writeObject(lambda.getClass());
         return out.toByteArray();
      } catch (IOException e) {
         throw new RuntimeException(e);
      }
   }

   @SuppressWarnings("unchecked")
   @Override
   public Object convertToEntityAttribute(byte[] lambdaClassBytes) {
      ByteArrayInputStream in = new ByteArrayInputStream(lambdaClassBytes);
      try (ObjectInputStream objectInputStream = new ObjectInputStream(in)) {
         return ((Class<Object>) objectInputStream.readObject()).newInstance();
      } catch (Exception e) {
         throw new RuntimeException(e);
      }
   }
}
