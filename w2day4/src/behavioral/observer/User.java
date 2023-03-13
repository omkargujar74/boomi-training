package behavioral.observer;

public class User implements Observer {
    private String name;
    private Channel channel;

    public User(String name) {
        this.name = name;
    }

    public void subscribedChannel(Channel channel) {
        this.channel = channel;
    }

    @Override
    public void update() {
        System.out.println("Hey " + name + " " + channel.getName() + " uploaded new video: " + channel.getVideoName());
    }
}
