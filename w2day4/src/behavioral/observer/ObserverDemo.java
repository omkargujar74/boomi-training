package behavioral.observer;

public class ObserverDemo {
    public static void main(String[] args) {
        Channel javaTech = new Channel("JavaTech");

        User omkar = new User("Omkar");
        User tushar = new User("Tushar");
        User ajit = new User("Ajit");
        User abhi = new User("Abhi");

        javaTech.subscribe(omkar);
        javaTech.subscribe(abhi);
        javaTech.subscribe(ajit);
        javaTech.subscribe(tushar);

        omkar.subscribedChannel(javaTech);
        abhi.subscribedChannel(javaTech);
        ajit.subscribedChannel(javaTech);
        tushar.subscribedChannel(javaTech);

        javaTech.uploadNewVideo("Introduction to Collections");

    }
}
