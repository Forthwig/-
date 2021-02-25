package junia.web.transformation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import junia.web.dto.Slide;

import javax.websocket.*;

public class SlideEncoder implements Encoder.Text<Slide> {

    private ObjectMapper objectMapper;

    @Override
    public String encode(Slide slide) throws EncodeException {
        try {
            return objectMapper.writeValueAsString(slide);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void init(EndpointConfig endpointConfig) {
        objectMapper = new ObjectMapper();
    }

    @Override
    public void destroy() {

    }
}
