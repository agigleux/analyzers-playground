package Regression511;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

public class StringBooleanSerialiser extends JsonSerializer<Boolean> {

  @Override
  public void serialize(Boolean bool, JsonGenerator generator, SerializerProvider provider) throws IOException {
    generator.writeString(bool ? "Y" : "N");
  }
}
