package com.android.volley.a;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* compiled from: HttpResponse.java */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a */
    private final int f8012a;

    /* renamed from: b */
    private final List<com.android.volley.g> f8013b;

    /* renamed from: c */
    private final int f8014c;

    /* renamed from: d */
    private final InputStream f8015d;

    public g(int i, List<com.android.volley.g> list) {
        this(i, list, -1, null);
    }

    public final InputStream a() {
        return this.f8015d;
    }

    public final int b() {
        return this.f8014c;
    }

    public final List<com.android.volley.g> c() {
        return Collections.unmodifiableList(this.f8013b);
    }

    public final int d() {
        return this.f8012a;
    }

    public g(int i, List<com.android.volley.g> list, int i2, InputStream inputStream) {
        this.f8012a = i;
        this.f8013b = list;
        this.f8014c = i2;
        this.f8015d = inputStream;
    }
}
