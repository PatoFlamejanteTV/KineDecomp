package com.nexstreaming.kinemaster.mediastore.v2;

import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.util.Log;
import com.nexstreaming.kinemaster.mediainfo.al;

/* compiled from: ThumbnailHelper.java */
/* loaded from: classes.dex */
final class r implements al {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f3601a;
    final /* synthetic */ int b;
    final /* synthetic */ int c;
    final /* synthetic */ Bitmap[] d;
    final /* synthetic */ Object e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(String str, int i, int i2, Bitmap[] bitmapArr, Object obj) {
        this.f3601a = str;
        this.b = i;
        this.c = i2;
        this.d = bitmapArr;
        this.e = obj;
    }

    @Override // com.nexstreaming.kinemaster.mediainfo.al
    public void a(Bitmap bitmap, int i, int i2, int i3) {
        Log.d("ThumbnailHelper", "[makeSingleThumbnail][onResultAvailable] path: " + this.f3601a + ", bitmap: " + bitmap + ", timestamp: " + i3);
        if (bitmap != null) {
            bitmap = ThumbnailUtils.extractThumbnail(bitmap, this.b, this.c, 2);
        }
        this.d[0] = bitmap;
        synchronized (this.e) {
            this.e.notify();
        }
    }
}
