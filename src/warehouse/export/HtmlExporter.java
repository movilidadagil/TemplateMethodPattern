package warehouse.export;

import warehouse.Report;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class HtmlExporter extends AbstractExporter {


    public HtmlExporter(Report report, PrintStream out) {
        super(report, out);
    }
    @Override
    protected void beforeLabels(PrintStream out) {
        out.println("<table>");
        out.println("\t<thead>");
    }
    @Override
    protected void handleLabels(PrintStream out, List<String> labels) {
        out.println("\t\t<tr>");
        for (String label : labels) {
            out.printf("\t\t\t<td>%s</td>%n", label);
        }
        out.println("\t\t</tr>");
    }
    @Override
    protected void afterLabels(PrintStream out) {
        out.println("\t</thead>");
    }

    @Override
    protected void beforeRecords(PrintStream out) {
        out.println("\t<tbody>");
    }

    @Override
    protected void handleRecord(PrintStream out, List<String> record, boolean first, boolean last) {
        out.println("\t\t<tr>");
        for (String field : record) {
            out.printf("\t\t\t<td>%s</td>%n", field);
        }
        out.println("\t\t</tr>");
    }
    @Override
    protected void afterRecords(PrintStream out) {
        out.println("\t</tbody>");
        out.println("</table>");
    }

    /*private static final String BORDER = "*";
    private static final String LEFT_BORDER = BORDER + " ";
    private static final String RIGHT_BORDER = " " + BORDER;
    private static final String SEPARATOR = " | ";

    private final Report report;
    private final PrintStream out;
    private final List<Integer> widths;

    private final int totalWidth;

    public HtmlExporter(Report report, PrintStream out) {
        this.report = report;
        this.out = out;
        this.widths = calcWidths();

        totalWidth = widths.stream().mapToInt(Integer::intValue).sum()
            + LEFT_BORDER.length()
            + SEPARATOR.length() * (report.getLabels().size() - 1)
            + RIGHT_BORDER.length();
    }



    public void export() {
        printBorder();
        printStrings(report.getLabels());
        printBorder();
        report.getRecords().forEach(this::printStrings);
        printBorder();
    }

    private List<Integer> calcWidths() {
        List<Integer> widths = new ArrayList<>();
        report.getLabels().forEach(l -> widths.add(l.length()));
        for (List<String> record : report.getRecords()) {
            for (int i = 0; i < widths.size(); i++) {
                int maxWidth = widths.get(i);
                int width = record.get(i).length();
                if (width > maxWidth) {
                    widths.set(i, width);
                }
            }
        }
        return widths;
    }

    private void printBorder() {
        for (int i = 0; i < totalWidth; i++) {
            out.print(BORDER);
        }
        out.println();
    }

    private void printStrings(List<String> strings) {
        out.print(LEFT_BORDER);
        out.print(IntStream.range(0, strings.size())
            .mapToObj(i -> {
                String fmt = String.format("%%%ss", widths.get(i));
                return String.format(fmt, strings.get(i));
            })
            .collect(Collectors.joining(SEPARATOR)));
        out.print(RIGHT_BORDER);
        out.println();
    }*/
}
