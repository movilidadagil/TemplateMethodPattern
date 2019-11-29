package warehouse.export;

import warehouse.Report;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/* Created by JavaUnifiedTester   hasanaligul  2019-11-29  */
/* before IExporter interface is implemented from this abstract class
public abstract  class AbstractExporter  {
/*
version 1.3.1
    private final Report report;
    protected final PrintStream out;

    AbstractExporter(Report report, PrintStream out) {
        this.report = report;
        this.out = out;
    }

    public final void export(){
        beforeLabels();
        handleLabels(report.getLabels());
        afterLabels();
        beforeRecords();
        handleRecords();
        afterRecords();
    }

    protected void beforeLabels() {
    }

    protected abstract void handleLabels(List<String> labels);

    protected void afterLabels() {
    }

    protected void beforeRecords() {
    }

    private void handleRecords() {
        List<List<String>> records = report.getRecords();
        if (records.size() == 1) {
            handleRecord(records.get(0), true, true);
        } else if (records.size() >= 2) {
            handleRecord(records.get(0), true, false);
            for (List<String> record : records.subList(1, records.size() - 1)) {
                handleRecord(record, false, false);
            }
            handleRecord(records.get(records.size() - 1), false, true);
        }
    }

    protected abstract void handleRecord(List<String> records, boolean first, boolean last);

    protected void afterRecords() {
    }

    *//*
private final Report report;
    private final PrintStream out;

    AbstractExporter(Report report, PrintStream out) {
        this.report = report;
        this.out = out;
    }

    public final void export() {
        beforeLabels(out);
        handleLabels(out, report.getLabels());
        afterLabels(out);

        beforeRecords(out);
        handleRecords();
        afterRecords(out);
    }

    protected void beforeLabels(PrintStream out) {
    }

    protected abstract void handleLabels(PrintStream out, List<String> labels);

    protected void afterLabels(PrintStream out) {
    }

    protected void beforeRecords(PrintStream out) {
    }

    private void handleRecords() {
        List<List<String>> records = report.getRecords();
        if (records.size() == 1) {
            handleRecord(out, records.get(0), true, true);
        } else if (records.size() >= 2) {
            handleRecord(out, records.get(0), true, false);
            for (List<String> record : records.subList(1, records.size() - 1)) {
                handleRecord(out, record, false, false);
            }
            handleRecord(out, records.get(records.size() - 1), false, true);
        }
    }

    protected abstract void handleRecord(PrintStream out, List<String> records, boolean first, boolean last);

    protected void afterRecords(PrintStream out) {
    }

    protected List<Integer> calcWidths(Report report) {
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
}
*/
public abstract  class AbstractExporter implements IExporter  {
    private final Report report;
    private final PrintStream out;

    AbstractExporter(Report report, PrintStream out) {
        this.report = report;
        this.out = out;
    }

    @Override
    public final void export() {
        beforeLabels(out);
        handleLabels(out, report.getLabels());
        afterLabels(out);

        beforeRecords(out);
        handleRecords();
        afterRecords(out);
    }

    protected List<Integer> calcWidths(Report report) {
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

    protected void beforeLabels(PrintStream out) {
    }

    protected abstract void handleLabels(PrintStream out, List<String> labels);

    protected void afterLabels(PrintStream out) {
    }

    protected void beforeRecords(PrintStream out) {
    }

    private void handleRecords() {
        List<List<String>> records = report.getRecords();
        if (records.size() == 1) {
            handleRecord(out, records.get(0), true, true);
        } else if (records.size() >= 2) {
            handleRecord(out, records.get(0), true, false);
            for (List<String> record : records.subList(1, records.size() - 1)) {
                handleRecord(out, record, false, false);
            }
            handleRecord(out, records.get(records.size() - 1), false, true);
        }
    }

    protected abstract void handleRecord(PrintStream out, List<String> record, boolean first, boolean last);

    protected void afterRecords(PrintStream out) {
    }
}

