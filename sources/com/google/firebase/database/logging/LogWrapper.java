package com.google.firebase.database.logging;

import com.google.firebase.database.logging.Logger;
import java.io.PrintWriter;
import java.io.StringWriter;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class LogWrapper {

    /* renamed from: a */
    private final Logger f17173a;

    /* renamed from: b */
    private final String f17174b;

    /* renamed from: c */
    private final String f17175c;

    public LogWrapper(Logger logger, String str) {
        this(logger, str, null);
    }

    private static String a(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public void b(String str) {
        b(str, (Throwable) null);
    }

    public LogWrapper(Logger logger, String str, String str2) {
        this.f17173a = logger;
        this.f17174b = str;
        this.f17175c = str2;
    }

    public void b(String str, Throwable th) {
        String b2 = b(str, new Object[0]);
        if (th != null) {
            b2 = b2 + "\n" + a(th);
        }
        this.f17173a.a(Logger.Level.WARN, this.f17174b, b2, b());
    }

    private long b() {
        return System.currentTimeMillis();
    }

    public void a(String str, Throwable th) {
        this.f17173a.a(Logger.Level.ERROR, this.f17174b, b(str, new Object[0]) + "\n" + a(th), b());
    }

    private String b(String str, Object... objArr) {
        if (objArr.length > 0) {
            str = String.format(str, objArr);
        }
        if (this.f17175c == null) {
            return str;
        }
        return this.f17175c + " - " + str;
    }

    public void a(String str) {
        this.f17173a.a(Logger.Level.INFO, this.f17174b, b(str, new Object[0]), b());
    }

    public void a(String str, Object... objArr) {
        a(str, null, objArr);
    }

    public boolean a() {
        return this.f17173a.a().ordinal() <= Logger.Level.DEBUG.ordinal();
    }

    public void a(String str, Throwable th, Object... objArr) {
        if (a()) {
            String b2 = b(str, objArr);
            if (th != null) {
                b2 = b2 + "\n" + a(th);
            }
            this.f17173a.a(Logger.Level.DEBUG, this.f17174b, b2, b());
        }
    }
}
