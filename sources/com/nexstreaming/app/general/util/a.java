package com.nexstreaming.app.general.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: CSVHeaderReader.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private b f3224a;
    private List<String> b;
    private List<String> c;
    private Map<String, Integer> d;
    private String[] e;
    private int f;

    public a(InputStream inputStream) throws IOException {
        this.f3224a = new b(inputStream);
        d();
    }

    private void d() throws IOException {
        this.b = this.f3224a.a();
        if (this.b == null) {
            throw new IOException("CSV header row missing");
        }
        this.d = new HashMap();
        for (int i = 0; i < this.b.size(); i++) {
            this.d.put(this.b.get(i), Integer.valueOf(i));
        }
        this.f = 0;
    }

    public boolean a() throws IOException {
        this.c = this.f3224a.a();
        if (this.c != null) {
            this.f++;
        }
        return this.c != null;
    }

    public int b() {
        return this.f;
    }

    public String a(String str, String str2) {
        Integer num = this.d.get(str);
        if (num != null && num.intValue() < this.c.size()) {
            String trim = this.c.get(num.intValue()).trim();
            if (this.e != null) {
                for (String str3 : this.e) {
                    if (trim.equals(str3)) {
                        return str2;
                    }
                }
            }
            return trim;
        }
        return str2;
    }

    public int a(String str, int i) {
        Integer num = this.d.get(str);
        if (num != null && num.intValue() < this.c.size()) {
            String trim = this.c.get(num.intValue()).trim();
            if (this.e != null) {
                for (String str2 : this.e) {
                    if (trim.equals(str2)) {
                        return i;
                    }
                }
            }
            try {
                return Integer.parseInt(trim);
            } catch (NumberFormatException e) {
                return i;
            }
        }
        return i;
    }

    public void c() throws IOException {
        this.f3224a.b();
    }
}
