package com.google.android.gms.analytics;

import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Iterator;
import java.util.TreeSet;

@VisibleForTesting
/* loaded from: classes.dex */
public class StandardExceptionParser implements ExceptionParser {

    /* renamed from: a */
    private final TreeSet<String> f10335a;

    protected StackTraceElement a(Throwable th) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (stackTrace == null || stackTrace.length == 0) {
            return null;
        }
        for (StackTraceElement stackTraceElement : stackTrace) {
            String className = stackTraceElement.getClassName();
            Iterator<String> it = this.f10335a.iterator();
            while (it.hasNext()) {
                if (className.startsWith(it.next())) {
                    return stackTraceElement;
                }
            }
        }
        return stackTrace[0];
    }

    protected Throwable b(Throwable th) {
        while (th.getCause() != null) {
            th = th.getCause();
        }
        return th;
    }

    protected String a(Throwable th, StackTraceElement stackTraceElement, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(th.getClass().getSimpleName());
        if (stackTraceElement != null) {
            String[] split = stackTraceElement.getClassName().split("\\.");
            sb.append(String.format(" (@%s:%s:%s)", (split == null || split.length <= 0) ? "unknown" : split[split.length - 1], stackTraceElement.getMethodName(), Integer.valueOf(stackTraceElement.getLineNumber())));
        }
        if (str != null) {
            sb.append(String.format(" {%s}", str));
        }
        return sb.toString();
    }

    @Override // com.google.android.gms.analytics.ExceptionParser
    public String a(String str, Throwable th) {
        return a(b(th), a(b(th)), str);
    }
}
