package structural.adaptor;

public class FancyUIAdaptor implements IMultiRestoApp{
    private FancyUI fancyUI;

    public FancyUIAdaptor() {
        fancyUI = new FancyUI();
    }

    @Override
    public void displayMenu(XmlData xmlData) {
        fancyUI.displayMenu(convertXmlDataToJsonData(xmlData));
    }

    @Override
    public void displayRecommendations(XmlData xmlData) {
        fancyUI.displayRecommendations(convertXmlDataToJsonData(xmlData));
    }

    private JsonData convertXmlDataToJsonData(XmlData xmlData){
        return new JsonData();
    }
}
