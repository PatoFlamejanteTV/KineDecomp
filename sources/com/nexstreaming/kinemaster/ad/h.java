package com.nexstreaming.kinemaster.ad;

import android.graphics.Bitmap;
import com.nexstreaming.kinemaster.ad.f;

/* compiled from: ImageBanner.java */
/* loaded from: classes.dex */
class h extends com.bumptech.glide.request.a.g<Bitmap> {

    /* renamed from: d */
    final /* synthetic */ f.a f19956d;

    /* renamed from: e */
    final /* synthetic */ i f19957e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(i iVar, int i, int i2, f.a aVar) {
        super(i, i2);
        this.f19957e = iVar;
        this.f19956d = aVar;
    }

    @Override // com.bumptech.glide.request.a.i
    public /* bridge */ /* synthetic */ void a(Object obj, com.bumptech.glide.request.b.f fVar) {
        a((Bitmap) obj, (com.bumptech.glide.request.b.f<? super Bitmap>) fVar);
    }

    public void a(Bitmap bitmap, com.bumptech.glide.request.b.f<? super Bitmap> fVar) {
        this.f19957e.a(bitmap);
        f.a aVar = this.f19956d;
        if (aVar != null) {
            aVar.a(this.f19957e);
        }
    }
}
