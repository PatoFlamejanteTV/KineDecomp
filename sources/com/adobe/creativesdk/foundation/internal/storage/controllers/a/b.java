package com.adobe.creativesdk.foundation.internal.storage.controllers.a;

import android.graphics.drawable.BitmapDrawable;
import android.support.v4.util.LruCache;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ReusableImageBitmapCache.java */
/* loaded from: classes.dex */
public class b extends LruCache<String, BitmapDrawable> {

    /* renamed from: a */
    final /* synthetic */ c f5908a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(c cVar, int i) {
        super(i);
        this.f5908a = cVar;
    }

    @Override // android.support.v4.util.LruCache
    /* renamed from: a */
    public void entryRemoved(boolean z, String str, BitmapDrawable bitmapDrawable, BitmapDrawable bitmapDrawable2) {
        a.a();
    }

    @Override // android.support.v4.util.LruCache
    /* renamed from: a */
    public int sizeOf(String str, BitmapDrawable bitmapDrawable) {
        int a2 = c.a(bitmapDrawable) / 1024;
        if (a2 == 0) {
            return 1;
        }
        return a2;
    }
}
