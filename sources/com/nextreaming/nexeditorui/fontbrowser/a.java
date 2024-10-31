package com.nextreaming.nexeditorui.fontbrowser;

import android.graphics.Bitmap;
import android.support.v4.graphics.BitmapCompat;
import android.util.LruCache;

/* compiled from: FontBrowserActivity.java */
/* loaded from: classes2.dex */
class a extends LruCache<String, Bitmap> {
    public a(int i) {
        super(i);
    }

    @Override // android.util.LruCache
    /* renamed from: a */
    public int sizeOf(String str, Bitmap bitmap) {
        return BitmapCompat.getAllocationByteCount(bitmap) / 1024;
    }
}
