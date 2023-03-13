package behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class Channel {
    private String name;
    private List<User> subscribers = new ArrayList<>();
    private String videoName;

    public Channel(String name) {
        this.name = name;
    }

    public void subscribe(User user) {
        subscribers.add(user);
    }

    public void unsubscribe(User user) {
        subscribers.remove(user);
    }

    private void notifySubscribers() {
        for (User subscriber : subscribers) {
            subscriber.update();
        }
    }

    public void uploadNewVideo(String videoName) {
        this.videoName = videoName;
        this.notifySubscribers();
    }

    public String getName() {
        return name;
    }

    public String getVideoName() {
        return videoName;
    }
}
