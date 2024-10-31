package com.google.firebase.database.logging;

import com.google.firebase.database.logging.Logger;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class DefaultLogger implements Logger {

    /* renamed from: a */
    private final Set<String> f17171a;

    /* renamed from: b */
    private final Logger.Level f17172b;

    public DefaultLogger(Logger.Level level, List<String> list) {
        if (list != null) {
            this.f17171a = new HashSet(list);
        } else {
            this.f17171a = null;
        }
        this.f17172b = level;
    }

    @Override // com.google.firebase.database.logging.Logger
    public Logger.Level a() {
        return this.f17172b;
    }

    protected String b(Logger.Level level, String str, String str2, long j) {
        return new Date(j).toString() + " [" + level + "] " + str + ": " + str2;
    }

    protected void c(String str, String str2) {
        System.out.println(str2);
    }

    protected void d(String str, String str2) {
        System.out.println(str2);
    }

    @Override // com.google.firebase.database.logging.Logger
    public void a(Logger.Level level, String str, String str2, long j) {
        if (a(level, str)) {
            String b2 = b(level, str, str2, j);
            int i = a.f17176a[level.ordinal()];
            if (i == 1) {
                b(str, b2);
                return;
            }
            if (i == 2) {
                d(str, b2);
            } else if (i == 3) {
                c(str, b2);
            } else {
                if (i == 4) {
                    a(str, b2);
                    return;
                }
                throw new RuntimeException("Should not reach here!");
            }
        }
    }

    protected void b(String str, String str2) {
        System.err.println(str2);
    }

    protected void a(String str, String str2) {
        System.out.println(str2);
    }

    protected boolean a(Logger.Level level, String str) {
        return level.ordinal() >= this.f17172b.ordinal() && (this.f17171a == null || level.ordinal() > Logger.Level.DEBUG.ordinal() || this.f17171a.contains(str));
    }
}
