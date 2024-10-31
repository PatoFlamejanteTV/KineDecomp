package com.android.volley;

import com.google.protos.datapol.SemanticAnnotations;

/* compiled from: DefaultRetryPolicy.java */
/* loaded from: classes.dex */
public class d implements o {

    /* renamed from: a */
    private int f8052a;

    /* renamed from: b */
    private int f8053b;

    /* renamed from: c */
    private final int f8054c;

    /* renamed from: d */
    private final float f8055d;

    public d() {
        this(SemanticAnnotations.SemanticType.ST_AVOCADO_ID_VALUE, 1, 1.0f);
    }

    @Override // com.android.volley.o
    public int a() {
        return this.f8053b;
    }

    @Override // com.android.volley.o
    public int b() {
        return this.f8052a;
    }

    protected boolean c() {
        return this.f8053b <= this.f8054c;
    }

    public d(int i, int i2, float f2) {
        this.f8052a = i;
        this.f8054c = i2;
        this.f8055d = f2;
    }

    @Override // com.android.volley.o
    public void a(VolleyError volleyError) throws VolleyError {
        this.f8053b++;
        int i = this.f8052a;
        this.f8052a = (int) (i + (i * this.f8055d));
        if (!c()) {
            throw volleyError;
        }
    }
}
