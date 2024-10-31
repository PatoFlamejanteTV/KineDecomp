package com.facebook.stetho.dumpapp;

import com.facebook.stetho.common.Util;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import javax.annotation.concurrent.Immutable;
import org.apache.commons.cli.a;

@Immutable
/* loaded from: classes.dex */
public class DumperContext {
    private final List<String> mArgs;
    private final a mParser;
    private final PrintStream mStderr;
    private final InputStream mStdin;
    private final PrintStream mStdout;

    protected DumperContext(DumperContext dumperContext, List<String> list) {
        this(dumperContext.getStdin(), dumperContext.getStdout(), dumperContext.getStderr(), dumperContext.getParser(), list);
    }

    public List<String> getArgsAsList() {
        return this.mArgs;
    }

    public a getParser() {
        return this.mParser;
    }

    public PrintStream getStderr() {
        return this.mStderr;
    }

    public InputStream getStdin() {
        return this.mStdin;
    }

    public PrintStream getStdout() {
        return this.mStdout;
    }

    public DumperContext(InputStream inputStream, PrintStream printStream, PrintStream printStream2, a aVar, List<String> list) {
        Util.throwIfNull(inputStream);
        this.mStdin = inputStream;
        Util.throwIfNull(printStream);
        this.mStdout = printStream;
        Util.throwIfNull(printStream2);
        this.mStderr = printStream2;
        Util.throwIfNull(aVar);
        this.mParser = aVar;
        Util.throwIfNull(list);
        this.mArgs = list;
    }
}
