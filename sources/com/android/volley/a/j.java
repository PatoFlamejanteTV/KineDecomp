package com.android.volley.a;

import android.graphics.Bitmap;
import com.android.volley.m;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ImageLoader.java */
/* loaded from: classes.dex */
public class j implements m.b<Bitmap> {

    /* renamed from: a */
    final /* synthetic */ String f8018a;

    /* renamed from: b */
    final /* synthetic */ m f8019b;

    public j(m mVar, String str) {
        this.f8019b = mVar;
        this.f8018a = str;
    }

    @Override // com.android.volley.m.b
    public void a(Bitmap bitmap) {
        this.f8019b.a(this.f8018a, bitmap);
    }
}
