package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import java.io.ByteArrayOutputStream;

/* renamed from: com.google.android.gms.internal.ads.gd, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class RunnableC0913gd implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Bitmap f12175a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzawg f12176b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0913gd(zzawg zzawgVar, Bitmap bitmap) {
        this.f12176b = zzawgVar;
        this.f12175a = bitmap;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        zzbvn zzbvnVar;
        zzbvn zzbvnVar2;
        zzbvn zzbvnVar3;
        zzbvn zzbvnVar4;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.f12175a.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream);
        obj = this.f12176b.mLock;
        synchronized (obj) {
            zzbvnVar = this.f12176b.zzefr;
            zzbvnVar.zzgay = new zzbvs();
            zzbvnVar2 = this.f12176b.zzefr;
            zzbvnVar2.zzgay.zzgbs = byteArrayOutputStream.toByteArray();
            zzbvnVar3 = this.f12176b.zzefr;
            zzbvnVar3.zzgay.mimeType = "image/png";
            zzbvnVar4 = this.f12176b.zzefr;
            zzbvnVar4.zzgay.zzgar = 1;
        }
    }
}
