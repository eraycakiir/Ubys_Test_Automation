package utilities;

import com.microsoft.playwright.*;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import pages.Screens;
import utilities.HelperFunctions.WaitMethods;

import java.awt.*;
import java.io.File;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Hooks extends TestListenerAdapter {
    private Playwright playwright;
    private Browser browser;
    public static Page page;
    public static Screens screens;  // Screens nesnesini statik olarak tanımladık
    private BrowserContext context;


    // Test başlamadan önce tarayıcıyı başlatır, sayfayı açar ve test için hazırlar
    @Override
    public void onTestStart(ITestResult result) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) dimension.getWidth();
        int height = (int) dimension.getHeight();

        BrowserFactory bf = new BrowserFactory();
        String browserName = PropertyUtils.getProperty("browser");
        this.browser = bf.getBrowser(browserName);
        this.context = bf.createPageAndGetContext(this.browser, result);
        this.page = context.newPage();

        // Screens nesnesini burada initialize ediyoruz
        screens = new Screens(page);

        page.setViewportSize(width, height);
        page.navigate(PropertyUtils.getProperty("url"));
    }


    // Test başarılı olursa cleanup işlemi
    @Override
    public void onTestSuccess(ITestResult result) {
        cleanupOldTraces();
        if (context != null) {
            context.tracing().stop();
        }
        cleanup();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String tracePath = getTraceFilePath(result);
        context.tracing().stop(new Tracing.StopOptions().setPath(Paths.get(tracePath)));
        cleanup();
    }

    public String getTraceFilePath(ITestResult result) {
        String baseDir = "src/test/java/utilities/traceViewer/";
        String methodName = result.getMethod().getMethodName();
        String date = new SimpleDateFormat("hh_mm_ss_ddMMyyyy").format(new Date());
        return baseDir + methodName + date + "-trace.zip";
    }

    private void cleanup() {
        if (context != null) context.close();
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
    }

    private void cleanupOldTraces() {
        final long EXPIRATION_TIME = 86400000;
        File dir = new File("src/test/java/utilities/traceViewer/");
        File[] files = dir.listFiles();
        if (files != null) {
            long now = System.currentTimeMillis();
            for (File file : files) {
                if (now - file.lastModified() > EXPIRATION_TIME) {
                    if (!file.delete()) {
                        System.err.println("Failed to delete old trace file: " + file.getPath());
                    }
                }
            }
        }
    }
}
