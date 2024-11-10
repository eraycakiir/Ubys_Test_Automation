package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class ConversationPage {
    public Locator writeMessage;
    private Page page;
    public ConversationPage(Page page) {
        this.page = page;
        writeMessage = page.getByPlaceholder("Mesaj Yaz...");
    }


}
