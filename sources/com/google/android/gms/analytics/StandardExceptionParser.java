package com.google.android.gms.analytics;

import java.util.Iterator;
import java.util.TreeSet;

/* loaded from: classes.dex */
public class StandardExceptionParser implements ExceptionParser {

    /* renamed from: a, reason: collision with root package name */
    private final TreeSet<String> f686a;

    @Override // com.google.android.gms.analytics.ExceptionParser
    public String a(String str, Throwable th) {
        return a(a(th), b(a(th)), str);
    }

    protected String a(Throwable th, StackTraceElement stackTraceElement, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(th.getClass().getSimpleName());
        if (stackTraceElement != null) {
            String[] split = stackTraceElement.getClassName().split("\\.");
            String str2 = "unknown";
            if (split != null && split.length > 0) {
                str2 = split[split.length - 1];
            }
            sb.append(String.format(" (@%s:%s:%s)", str2, stackTraceElement.getMethodName(), Integer.valueOf(stackTraceElement.getLineNumber())));
        }
        if (str != null) {
            sb.append(String.format(" {%s}", str));
        }
        return sb.toString();
    }

    protected Throwable a(Throwable th) {
        while (th.getCause() != null) {
            th = th.getCause();
        }
        return th;
    }

    protected StackTraceElement b(Throwable th) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (stackTrace == null || stackTrace.length == 0) {
            return null;
        }
        for (StackTraceElement stackTraceElement : stackTrace) {
            String className = stackTraceElement.getClassName();
            Iterator<String> it = this.f686a.iterator();
            while (it.hasNext()) {
                if (className.startsWith(it.next())) {
                    return stackTraceElement;
                }
            }
        }
        return stackTrace[0];
    }
}
