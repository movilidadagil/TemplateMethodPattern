package warehouse.export;


import warehouse.Report;

import java.io.PrintStream;
import java.util.List;

/*
//before decision to implement IExporter interface here
public class JsonExporter extends AbstractExporter {

    private List<String> labels;

    public JsonExporter(Report report, PrintStream out) {
        super(report, out);
    }

    @Override
    protected void handleLabels(PrintStream out, List<String> labels) {
        // Not actually used, just here to capture the labels so that handleRecord could access it.
        this.labels = labels;
    }

    @Override
    protected void beforeRecords(PrintStream out) {
        out.println("[");
    }

    @Override
    protected void handleRecord(PrintStream out, List<String> record, boolean first, boolean last) {
        out.println("\t{");
        for (int i = 0; i < labels.size(); i++) {
            String label = labels.get(i);
            String field = record.get(i);
            out.printf("\t\t\"%s\": ", label);
            if (i == 0) {
                // string field
                out.printf("\"%s\",%n", field);
            } else if (i == 1) {
                // number field
                out.printf("%s%n", field);
            }
        }
        out.print("\t}");
        if (!last) {
            out.print(",");
        }
        out.println();
    }

    @Override
    protected void afterRecords(PrintStream out) {
        out.println("]");
    }
}
*/

public class JsonExporter implements IExporter {
    private final Report report;
    private final PrintStream out;

    public JsonExporter(Report report, PrintStream out) {
        this.report = report;
        this.out = out;
    }

    @Override
    public void export() {
        out.println("[");
        List<List<String>> records = report.getRecords();
        for (int i = 0; i < records.size(); i++) {
            out.println("\t{");
            List<String> record = records.get(i);
            for (int j = 0; j < report.getLabels().size(); j++) {
                String label = report.getLabels().get(j);
                String field = record.get(j);
                out.printf("\t\t\"%s\": ", label);
                if (j == 0) {
                    // string field
                    out.printf("\"%s\",%n", field);
                } else if (j == 1) {
                    // number field
                    out.printf("%s%n", field);
                }
            }
            out.print("\t}");
            if (i != records.size() - 1) {
                out.print(",");
            }
            out.println();
        }
        out.println("]");
    }
}
