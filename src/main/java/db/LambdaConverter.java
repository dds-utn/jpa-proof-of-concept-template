package db;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

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
 *    public SerializableRunnable r;
 * }
 * </pre>
 * 
 * Where SampleRunnable is a {@link FunctionalInterface} that implements {@link Serializable}
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
         objectOutputStream.writeObject(lambda);
         return out.toByteArray();
      } catch (IOException e) {
         throw new RuntimeException(e);
      }
   }

   @Override
   public Object convertToEntityAttribute(byte[] lambdaClassBytes) {
      ByteArrayInputStream in = new ByteArrayInputStream(lambdaClassBytes);
      try (ObjectInputStream objectInputStream = new ObjectInputStream(in)) {
         return objectInputStream.readObject();
      } catch (Exception e) {
         throw new RuntimeException(e);
      }
   }
}
