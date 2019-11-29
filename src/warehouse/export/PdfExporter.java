package warehouse.export;

import warehouse.Report;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class PdfExporter extends AbstractExporter {


    PdfExporter(Report report, PrintStream out) {
        super(report, out);
    }

    @Override
    protected void handleLabels(PrintStream out, List<String> labels) {

    }

    @Override
    protected void handleRecord(PrintStream out, List<String> record, boolean first, boolean last) {

    }
}
