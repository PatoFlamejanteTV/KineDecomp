package com.nexstreaming.app.general.util;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: CSVHeaderReader.java */
/* renamed from: com.nexstreaming.app.general.util.b */
/* loaded from: classes2.dex */
public class C1698b implements Closeable {

    /* renamed from: a */
    private C1700d f19851a;

    /* renamed from: b */
    private List<String> f19852b;

    /* renamed from: c */
    private List<String> f19853c;

    /* renamed from: d */
    private Map<String, Integer> f19854d;

    /* renamed from: e */
    private String[] f19855e;

    /* renamed from: f */
    private int f19856f;

    public C1698b(InputStream inputStream) throws IOException {
        this.f19851a = new C1700d(inputStream);
        c();
    }

    private void c() throws IOException {
        this.f19852b = this.f19851a.b();
        if (this.f19852b != null) {
            this.f19854d = new HashMap();
            for (int i = 0; i < this.f19852b.size(); i++) {
                this.f19854d.put(this.f19852b.get(i), Integer.valueOf(i));
            }
            this.f19856f = 0;
            return;
        }
        throw new IOException("CSV header row missing");
    }

    public int a() {
        return this.f19856f;
    }

    public boolean b() throws IOException {
        this.f19853c = this.f19851a.b();
        if (this.f19853c != null) {
            this.f19856f++;
        }
        return this.f19853c != null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f19851a.a();
    }

    public String a(String str, String str2) {
        Integer num = this.f19854d.get(str);
        if (num == null || num.intValue() >= this.f19853c.size()) {
            return str2;
        }
        String trim = this.f19853c.get(num.intValue()).trim();
        String[] strArr = this.f19855e;
        if (strArr != null) {
            for (String str3 : strArr) {
                if (trim.equals(str3)) {
                    return str2;
                }
            }
        }
        return trim;
    }

    public int a(String str, int i) {
        Integer num = this.f19854d.get(str);
        if (num == null || num.intValue() >= this.f19853c.size()) {
            return i;
        }
        String trim = this.f19853c.get(num.intValue()).trim();
        String[] strArr = this.f19855e;
        if (strArr != null) {
            for (String str2 : strArr) {
                if (trim.equals(str2)) {
                    return i;
                }
            }
        }
        try {
            return Integer.parseInt(trim);
        } catch (NumberFormatException unused) {
            return i;
        }
    }
}
