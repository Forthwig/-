package junia.web.data;

import javax.websocket.EncodeException;
import javax.websocket.Session;
import java.io.IOException;

public class SlideSession {

    private Session session;

    public SlideSession(Session session) {
        this.session = session;
    }

    public void send(Object object){
        if(session != null && object != null && session.isOpen()) {
            try {
                session.getBasicRemote().sendObject(object);
            } catch (IOException | EncodeException e) {
                e.printStackTrace();
            }
        }
    }

}
