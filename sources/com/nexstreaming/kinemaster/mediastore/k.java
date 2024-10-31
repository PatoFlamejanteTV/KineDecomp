package com.nexstreaming.kinemaster.mediastore;

import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.util.Log;
import com.nexstreaming.kinemaster.mediainfo.N;

/* compiled from: ThumbnailHelper.kt */
/* loaded from: classes.dex */
public final class k implements N {

    /* renamed from: a */
    final /* synthetic */ String f20920a;

    /* renamed from: b */
    final /* synthetic */ Bitmap[] f20921b;

    /* renamed from: c */
    final /* synthetic */ Object f20922c;

    public k(String str, Bitmap[] bitmapArr, Object obj) {
        this.f20920a = str;
        this.f20921b = bitmapArr;
        this.f20922c = obj;
    }

    @Override // com.nexstreaming.kinemaster.mediainfo.N
    public void a(Bitmap bitmap, int i, int i2, int i3, int i4, int i5) {
        String str;
        kotlin.jvm.internal.h.b(bitmap, "bitmap");
        try {
            m mVar = m.f20926b;
            str = m.f20925a;
            Log.d(str, "[makeSingleThumbnail][onResultAvailable] path: " + this.f20920a + ", bitmap: " + bitmap + ", timestamp: " + i5);
            Bitmap extractThumbnail = ThumbnailUtils.extractThumbnail(bitmap, i, i2, 2);
            kotlin.jvm.internal.h.a((Object) extractThumbnail, "ThumbnailUtils.extractTh…ls.OPTIONS_RECYCLE_INPUT)");
            this.f20921b[0] = extractThumbnail;
            synchronized (this.f20922c) {
                this.f20922c.notify();
                kotlin.k kVar = kotlin.k.f28545a;
            }
        } catch (Throwable th) {
            synchronized (this.f20922c) {
                this.f20922c.notify();
                kotlin.k kVar2 = kotlin.k.f28545a;
                throw th;
            }
        }
    }
}
