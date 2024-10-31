package com.nexstreaming.kinemaster.mediainfo;

import android.graphics.Bitmap;
import android.os.Handler;
import android.util.LruCache;
import com.nexstreaming.app.general.task.ResultTask;

/* compiled from: MediaInfo.java */
/* renamed from: com.nexstreaming.kinemaster.mediainfo.s */
/* loaded from: classes.dex */
public class C1800s implements N {

    /* renamed from: a */
    boolean f20749a = false;

    /* renamed from: b */
    Handler f20750b = new Handler();

    /* renamed from: c */
    final /* synthetic */ String f20751c;

    /* renamed from: d */
    final /* synthetic */ ResultTask f20752d;

    /* renamed from: e */
    final /* synthetic */ MediaInfo f20753e;

    public C1800s(MediaInfo mediaInfo, String str, ResultTask resultTask) {
        this.f20753e = mediaInfo;
        this.f20751c = str;
        this.f20752d = resultTask;
    }

    @Override // com.nexstreaming.kinemaster.mediainfo.N
    public void a(Bitmap bitmap, int i, int i2, int i3, int i4, int i5) {
        LruCache lruCache;
        if (bitmap == null || this.f20749a) {
            return;
        }
        this.f20749a = true;
        Bitmap createBitmap = Bitmap.createBitmap(bitmap);
        lruCache = MediaInfo.f20676f;
        lruCache.put(this.f20751c, createBitmap);
        this.f20750b.post(new r(this, createBitmap));
    }
}
