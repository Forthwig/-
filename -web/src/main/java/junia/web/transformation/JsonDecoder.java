package junia.web.transformation;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;

public class JsonDecoder<T> implements Decoder.Text<T> {

    private ObjectMapper mapper;

    private final Class<T> persistenceClass = (Class<T>) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    @Override
    public T decode(String s) throws DecodeException {
        try {
            return mapper.readValue(s, persistenceClass);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean willDecode(String s) {
        return false;
    }

    @Override
    public void init(EndpointConfig endpointConfig) {
        mapper = new ObjectMapper();
    }

    @Override
    public void destroy() {

    }
}
