package com.facebook.stetho.dumpapp.plugins;

import android.os.Process;
import com.facebook.stetho.common.ExceptionUtil;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.dumpapp.ArgsHelper;
import com.facebook.stetho.dumpapp.DumpException;
import com.facebook.stetho.dumpapp.DumpUsageException;
import com.facebook.stetho.dumpapp.DumperContext;
import com.facebook.stetho.dumpapp.DumperPlugin;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public class CrashDumperPlugin implements DumperPlugin {
    private static final String NAME = "crash";
    private static final String OPTION_EXIT_DEFAULT = "0";
    private static final String OPTION_KILL_DEFAULT = "9";
    private static final String OPTION_THROW_DEFAULT = "java.lang.Error";

    /* loaded from: classes.dex */
    public static class ThrowRunnable implements Runnable {
        private final Throwable mThrowable;

        public ThrowRunnable(Throwable th) {
            this.mThrowable = th;
        }

        @Override // java.lang.Runnable
        public void run() {
            ExceptionUtil.sneakyThrow(this.mThrowable);
            throw null;
        }
    }

    private void doKill(DumperContext dumperContext, Iterator<String> it) throws DumpException {
        String nextOptionalArg = ArgsHelper.nextOptionalArg(it, OPTION_KILL_DEFAULT);
        try {
            Process start = new ProcessBuilder(new String[0]).command("/system/bin/kill", "-" + nextOptionalArg, String.valueOf(Process.myPid())).redirectErrorStream(true).start();
            try {
                Util.copy(start.getInputStream(), dumperContext.getStdout(), new byte[1024]);
            } finally {
                start.destroy();
            }
        } catch (IOException e2) {
            throw new DumpException("Failed to invoke kill: " + e2);
        }
    }

    private void doSystemExit(Iterator<String> it) {
        System.exit(Integer.parseInt(ArgsHelper.nextOptionalArg(it, "0")));
    }

    private void doUncaughtException(Iterator<String> it) throws DumpException {
        try {
            Class<?> cls = Class.forName(ArgsHelper.nextOptionalArg(it, OPTION_THROW_DEFAULT));
            Constructor tryGetDeclaredConstructor = tryGetDeclaredConstructor(cls, String.class);
            Thread thread = new Thread(new ThrowRunnable(tryGetDeclaredConstructor != null ? (Throwable) tryGetDeclaredConstructor.newInstance("Uncaught exception triggered by Stetho") : (Throwable) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0])));
            thread.start();
            Util.joinUninterruptibly(thread);
        } catch (ClassCastException e2) {
            e = e2;
            throw new DumpException("Invalid supplied Throwable class: " + e);
        } catch (ClassNotFoundException e3) {
            e = e3;
            throw new DumpException("Invalid supplied Throwable class: " + e);
        } catch (IllegalAccessException e4) {
            e = e4;
            throw new DumpException("Invalid supplied Throwable class: " + e);
        } catch (InstantiationException e5) {
            e = e5;
            throw new DumpException("Invalid supplied Throwable class: " + e);
        } catch (NoSuchMethodException e6) {
            e = e6;
            throw new DumpException("Invalid supplied Throwable class: " + e);
        } catch (InvocationTargetException e7) {
            ExceptionUtil.propagate(e7.getCause());
            throw null;
        }
    }

    private void doUsage(PrintStream printStream) {
        printStream.println("Usage: dumpapp crash <command> [command-options]");
        printStream.println("Usage: dumpapp crash throw");
        printStream.println("       dumpapp crash kill");
        printStream.println("       dumpapp crash exit");
        printStream.println();
        printStream.println("dumpapp crash throw: Throw an uncaught exception (simulates a program crash)");
        printStream.println("    <Throwable>: Throwable class to use (default: java.lang.Error)");
        printStream.println();
        printStream.println("dumpapp crash kill: Send a signal to this process (simulates the low memory killer)");
        printStream.println("    <SIGNAL>: Either signal name or number to send (default: 9)");
        printStream.println("              See `adb shell kill -l` for more information");
        printStream.println();
        printStream.println("dumpapp crash exit: Invoke System.exit (simulates an abnormal Android exit strategy)");
        printStream.println("    <code>: Exit code (default: 0)");
    }

    @Nullable
    private static <T> Constructor<? extends T> tryGetDeclaredConstructor(Class<T> cls, Class<?>... clsArr) {
        try {
            return cls.getDeclaredConstructor(clsArr);
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    @Override // com.facebook.stetho.dumpapp.DumperPlugin
    public void dump(DumperContext dumperContext) throws DumpException {
        Iterator<String> it = dumperContext.getArgsAsList().iterator();
        String nextOptionalArg = ArgsHelper.nextOptionalArg(it, null);
        if ("throw".equals(nextOptionalArg)) {
            doUncaughtException(it);
            return;
        }
        if ("kill".equals(nextOptionalArg)) {
            doKill(dumperContext, it);
            return;
        }
        if ("exit".equals(nextOptionalArg)) {
            doSystemExit(it);
            return;
        }
        doUsage(dumperContext.getStdout());
        if (nextOptionalArg == null) {
            return;
        }
        throw new DumpUsageException("Unsupported command: " + nextOptionalArg);
    }

    @Override // com.facebook.stetho.dumpapp.DumperPlugin
    public String getName() {
        return NAME;
    }
}
