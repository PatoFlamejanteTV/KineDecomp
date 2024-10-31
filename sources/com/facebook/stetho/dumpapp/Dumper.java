package com.facebook.stetho.dumpapp;

import java.io.InputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.a;
import org.apache.commons.cli.b;
import org.apache.commons.cli.c;

/* loaded from: classes.dex */
public class Dumper {
    private final Map<String, DumperPlugin> mDumperPlugins;
    private final GlobalOptions mGlobalOptions;
    private final a mParser;

    public Dumper(Iterable<DumperPlugin> iterable) {
        this(iterable, new b());
    }

    private int doDump(InputStream inputStream, PrintStream printStream, PrintStream printStream2, String[] strArr) throws ParseException, DumpException {
        CommandLine a2 = this.mParser.a(this.mGlobalOptions.options, strArr, true);
        if (a2.hasOption(this.mGlobalOptions.optionHelp.getOpt())) {
            dumpUsage(printStream);
            return 0;
        }
        if (a2.hasOption(this.mGlobalOptions.optionListPlugins.getOpt())) {
            dumpAvailablePlugins(printStream);
            return 0;
        }
        if (!a2.getArgList().isEmpty()) {
            dumpPluginOutput(inputStream, printStream, printStream2, a2);
            return 0;
        }
        dumpUsage(printStream2);
        return 1;
    }

    private void dumpAvailablePlugins(PrintStream printStream) {
        ArrayList arrayList = new ArrayList();
        Iterator<DumperPlugin> it = this.mDumperPlugins.values().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getName());
        }
        Collections.sort(arrayList);
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            printStream.println((String) it2.next());
        }
    }

    private void dumpPluginOutput(InputStream inputStream, PrintStream printStream, PrintStream printStream2, CommandLine commandLine) throws DumpException {
        ArrayList arrayList = new ArrayList(commandLine.getArgList());
        if (arrayList.size() >= 1) {
            String str = (String) arrayList.remove(0);
            DumperPlugin dumperPlugin = this.mDumperPlugins.get(str);
            if (dumperPlugin != null) {
                dumperPlugin.dump(new DumperContext(inputStream, printStream, printStream2, this.mParser, arrayList));
                return;
            }
            throw new DumpException("No plugin named '" + str + "'");
        }
        throw new DumpException("Expected plugin argument");
    }

    private void dumpUsage(PrintStream printStream) {
        c cVar = new c();
        printStream.println("Usage: dumpapp [options] <plugin> [plugin-options]");
        PrintWriter printWriter = new PrintWriter(printStream);
        try {
            cVar.a(printWriter, cVar.d(), this.mGlobalOptions.options, cVar.b(), cVar.a());
        } finally {
            printWriter.flush();
        }
    }

    private static Map<String, DumperPlugin> generatePluginMap(Iterable<DumperPlugin> iterable) {
        HashMap hashMap = new HashMap();
        for (DumperPlugin dumperPlugin : iterable) {
            hashMap.put(dumperPlugin.getName(), dumperPlugin);
        }
        return Collections.unmodifiableMap(hashMap);
    }

    public int dump(InputStream inputStream, PrintStream printStream, PrintStream printStream2, String[] strArr) {
        try {
            return doDump(inputStream, printStream, printStream2, strArr);
        } catch (DumpException e2) {
            printStream2.println(e2.getMessage());
            return 1;
        } catch (DumpappOutputBrokenException e3) {
            throw e3;
        } catch (RuntimeException e4) {
            e4.printStackTrace(printStream2);
            return 1;
        } catch (ParseException e5) {
            printStream2.println(e5.getMessage());
            dumpUsage(printStream2);
            return 1;
        }
    }

    public Dumper(Iterable<DumperPlugin> iterable, a aVar) {
        this.mDumperPlugins = generatePluginMap(iterable);
        this.mParser = aVar;
        this.mGlobalOptions = new GlobalOptions();
    }
}
