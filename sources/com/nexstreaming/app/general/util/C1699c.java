package com.nexstreaming.app.general.util;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;

/* compiled from: CSVHeaderReaderV2.java */
/* renamed from: com.nexstreaming.app.general.util.c */
/* loaded from: classes2.dex */
public class C1699c implements Closeable {

    /* renamed from: a */
    private C1701e f19857a;

    /* renamed from: b */
    private Map<String, String> f19858b;

    public C1699c(InputStream inputStream) throws IOException {
        this.f19857a = new C1701e(inputStream);
        b();
    }

    private void b() throws IOException {
        this.f19858b = this.f19857a.b();
        if (this.f19858b == null) {
            throw new IOException("CSV header row missing");
        }
    }

    public Iterator<String> a() {
        Map<String, String> map = this.f19858b;
        if (map == null || map.keySet() == null) {
            return null;
        }
        return this.f19858b.keySet().iterator();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f19857a.a();
    }

    public String e(String str) {
        if (this.f19858b.size() <= 0 || str == null) {
            return null;
        }
        return this.f19858b.get(str);
    }
}
