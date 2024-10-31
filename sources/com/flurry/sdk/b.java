package com.flurry.sdk;

import android.content.Context;
import java.io.File;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class b {
    private static final String b = b.class.getSimpleName();

    /* renamed from: a, reason: collision with root package name */
    boolean f473a;
    private final c c;
    private final File d;
    private String e;

    public b() {
        this(ad.a().b());
    }

    public b(Context context) {
        this.c = new c();
        this.d = context.getFileStreamPath(".flurryinstallreceiver.");
        as.a(3, b, "Referrer file name if it exists:  " + this.d);
    }

    public synchronized void a() {
        this.d.delete();
        this.e = null;
        this.f473a = true;
    }

    public synchronized Map<String, List<String>> a(boolean z) {
        Map<String, List<String>> a2;
        b();
        a2 = this.c.a(this.e);
        if (z) {
            a();
        }
        return a2;
    }

    private void a(String str) {
        if (str != null) {
            this.e = str;
        }
    }

    private void b() {
        if (!this.f473a) {
            this.f473a = true;
            as.a(4, b, "Loading referrer info from file: " + this.d.getAbsolutePath());
            String b2 = ao.b(this.d);
            as.a(b, "Referrer file contents: " + b2);
            a(b2);
        }
    }
}
