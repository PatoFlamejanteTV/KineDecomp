package com.nexstreaming.kinemaster.mediainfo;

import android.graphics.Bitmap;
import android.os.Handler;
import android.util.LruCache;
import com.nexstreaming.app.general.task.ResultTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaInfo.java */
/* loaded from: classes.dex */
public class p implements al {

    /* renamed from: a, reason: collision with root package name */
    boolean f3509a = false;
    Handler b = new Handler();
    final /* synthetic */ String c;
    final /* synthetic */ ResultTask d;
    final /* synthetic */ MediaInfo e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(MediaInfo mediaInfo, String str, ResultTask resultTask) {
        this.e = mediaInfo;
        this.c = str;
        this.d = resultTask;
    }

    @Override // com.nexstreaming.kinemaster.mediainfo.al
    public void a(Bitmap bitmap, int i, int i2, int i3) {
        LruCache lruCache;
        if (bitmap != null && !this.f3509a) {
            this.f3509a = true;
            Bitmap createBitmap = Bitmap.createBitmap(bitmap);
            lruCache = MediaInfo.w;
            lruCache.put(this.c, createBitmap);
            this.b.post(new q(this, createBitmap));
        }
    }
}
