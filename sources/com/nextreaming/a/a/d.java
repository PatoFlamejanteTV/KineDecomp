package com.nextreaming.a.a;

import android.graphics.Bitmap;
import android.util.LruCache;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ImageCache.java */
/* loaded from: classes.dex */
public class d extends LruCache<String, Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c f4455a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(c cVar, int i) {
        super(i);
        this.f4455a = cVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.util.LruCache
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int sizeOf(String str, Bitmap bitmap) {
        return c.a(bitmap);
    }
}
