package basepage;

import elements.BaseElements;
import org.apache.log4j.Logger;

public abstract class BasePage {

    private final static Logger logger = Logger.getLogger(BasePage.class);
    private BaseElements uniqueElement;
    private String name;

    protected BasePage(BaseElements uniqueElement, String name) {
        this.uniqueElement = uniqueElement;
        this.name = name;
    }

    public boolean isDisplayedPage() {
        logger.info("Page is displayed: " + name);
        return uniqueElement.getListWebElement().size() > 0;
    }
}
