package junia.web.controller;

import junia.web.dto.Slide;
import junia.web.transformation.SlideDecoder;
import junia.web.transformation.SlideEncoder;
import junia.web.utils.CurrentSlideHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@ServerEndpoint(
        value = "/control",
        decoders = { SlideDecoder.class },
        encoders = { SlideEncoder.class })
public class RevealController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RevealController.class);


    @OnOpen
    public void open(Session s) throws IOException, EncodeException {
        junia.lab.web.utils.SessionManager.getInstance().addSession(s);
        junia.lab.web.utils.SessionManager.getInstance().sendToSession(s, CurrentSlideHolder.getInstance().getCurrentSlide());
    }

    @OnClose
    public void close(Session s){
        junia.lab.web.utils.SessionManager.getInstance().removeSession(s);
    }


    @OnMessage
    public void onSlide(Slide slide, Session session) {
        CurrentSlideHolder.getInstance().setSlide(slide);
        junia.lab.web.utils.SessionManager.getInstance().broadcast(slide);

    }



}
