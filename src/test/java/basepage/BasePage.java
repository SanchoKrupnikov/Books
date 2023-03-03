package basepage;

import elements.BaseElements;

public abstract class BasePage {

    private BaseElements uniqueElement;
    private String name;

    protected BasePage (BaseElements uniqueElement, String name) {
        this.uniqueElement = uniqueElement;
        this.name = name;
    }

    public boolean isDisplayedPage(){
        return uniqueElement.getListWebElement().size()>0;
    }

}
