package ru.job4j.inheritance;

/**
 * 4. Переопределение [#285776]
 */
public class ReportUsage {
    public static void main(String[] args) {
        String text = "";

        System.out.println("Testing Text report:");
        TextReport textReport = new TextReport();
        text = textReport.generate("Report's name", "Report's body");
        System.out.println(text);

        System.out.println("\nTesting HTML report:");
        HtmlReport htmlReport = new HtmlReport();
        text = htmlReport.generate("Report's name", "Report's body");
        System.out.println(text);

        System.out.println("\nTesting JSON report:");
        JsonReport jsonReport = new JsonReport();
        text = jsonReport.generate("Report's name", "Report's body");
        System.out.println(text);
    }
}
