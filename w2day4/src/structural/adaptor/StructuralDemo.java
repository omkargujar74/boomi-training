package structural.adaptor;

public class StructuralDemo {
    public static void main(String[] args) {
        XmlData xmlData = new XmlData();
        MultiRestoApp multiRestoApp = new MultiRestoApp();
        multiRestoApp.displayMenu(xmlData);
        multiRestoApp.displayRecommendations(xmlData);

        FancyUIAdaptor fancyUIAdaptor = new FancyUIAdaptor();
        fancyUIAdaptor.displayMenu(xmlData);
        fancyUIAdaptor.displayRecommendations(xmlData);
    }
}
