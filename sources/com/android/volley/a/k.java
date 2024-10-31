package com.android.volley.a;

import com.android.volley.VolleyError;
import com.android.volley.m;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ImageLoader.java */
/* loaded from: classes.dex */
public class k implements m.a {

    /* renamed from: a */
    final /* synthetic */ String f8020a;

    /* renamed from: b */
    final /* synthetic */ m f8021b;

    public k(m mVar, String str) {
        this.f8021b = mVar;
        this.f8020a = str;
    }

    @Override // com.android.volley.m.a
    public void a(VolleyError volleyError) {
        this.f8021b.a(this.f8020a, volleyError);
    }
}
