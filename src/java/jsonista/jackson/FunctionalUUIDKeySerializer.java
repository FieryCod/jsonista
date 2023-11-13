package jsonista.jackson;

import clojure.lang.IFn;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.util.UUID;

import java.io.IOException;

public class FunctionalUUIDKeySerializer extends StdSerializer<UUID> {
  private final IFn encoder;

  public FunctionalUUIDKeySerializer(IFn encoder) {
    super(FunctionalUUIDKeySerializer.class, true);
    this.encoder = encoder;
  }

  @Override
  public void serialize(UUID value, JsonGenerator gen, SerializerProvider provider) throws IOException {
    gen.writeFieldName(String.valueOf(encoder.invoke(value)));
  }
}
