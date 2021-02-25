package junia.web.transformation;

import com.fasterxml.jackson.databind.ObjectMapper;
import junia.web.dto.Slide;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;
import java.io.IOException;

public class SlideDecoder implements Decoder.Text<Slide> {

    private ObjectMapper mapper;

    @Override
    public Slide decode(String jsonContent) throws DecodeException {
        try {
            return mapper.readValue(jsonContent,Slide.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean willDecode(String s) {
        return true;
    }

    @Override
    public void init(EndpointConfig endpointConfig) {
        mapper = new ObjectMapper();
    }

    @Override
    public void destroy() {

    }
}
