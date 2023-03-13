package structural.adaptor;

public class MultiRestoApp implements IMultiRestoApp{
    @Override
    public void displayMenu(XmlData xmlData) {
        System.out.println("XmlData Menu");
    }

    @Override
    public void displayRecommendations(XmlData xmlData) {
        System.out.println("XmlData Recommendations");
    }
}
