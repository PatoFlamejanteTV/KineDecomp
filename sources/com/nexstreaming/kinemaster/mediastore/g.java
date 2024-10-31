package com.nexstreaming.kinemaster.mediastore;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import c.e.a.a.f;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaStore.java */
/* loaded from: classes.dex */
public class g extends com.bumptech.glide.request.a.c<Bitmap> {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ f.e f20893d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ MediaStore f20894e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(MediaStore mediaStore, f.e eVar) {
        this.f20894e = mediaStore;
        this.f20893d = eVar;
    }

    @Override // com.bumptech.glide.request.a.i
    public /* bridge */ /* synthetic */ void a(Object obj, com.bumptech.glide.request.b.f fVar) {
        a((Bitmap) obj, (com.bumptech.glide.request.b.f<? super Bitmap>) fVar);
    }

    @Override // com.bumptech.glide.request.a.i
    public void b(Drawable drawable) {
    }

    public void a(Bitmap bitmap, com.bumptech.glide.request.b.f<? super Bitmap> fVar) {
        f.e eVar = this.f20893d;
        if (eVar != null) {
            eVar.a(bitmap);
        }
    }
}
