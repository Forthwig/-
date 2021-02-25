package junia.lab.web.utils;

import junia.web.data.SlideSession;
import junia.web.dto.Slide;

import java.util.Map;
import javax.websocket.Session;
import java.util.concurrent.ConcurrentHashMap;

public class SessionManager {

    private static SessionManager instance;

    private Map<String, SlideSession> sessions;

    private SessionManager() {
        sessions = new ConcurrentHashMap<>();
    }


    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }


    public void addSession(Session s) {
        sessions.put(s.getId(), new SlideSession(s));
    }


    public void removeSession(Session s) {
        sessions.remove(s.getId());
    }


    public void broadcast(Slide slide) {
        if (slide != null) {
            sessions.values().forEach(s-> s.send(slide));
        }
    }


    public void sendToSession(final Session s, final Slide currentSlide) {
        sessions.get(s.getId()).send(currentSlide);
    }
}
