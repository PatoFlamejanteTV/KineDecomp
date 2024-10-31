package com.adobe.creativesdk.foundation.internal.storage.controllers.a;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.util.LruCache;
import java.lang.ref.SoftReference;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: ReusableImageBitmapCache.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a */
    private static final Bitmap.CompressFormat f5909a = Bitmap.CompressFormat.JPEG;

    /* renamed from: b */
    private LruCache<String, BitmapDrawable> f5910b;

    /* renamed from: c */
    private a f5911c;

    /* renamed from: d */
    private final Object f5912d = new Object();

    /* renamed from: e */
    private boolean f5913e = true;

    /* renamed from: f */
    private Set<SoftReference<Bitmap>> f5914f;

    /* compiled from: ReusableImageBitmapCache.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a */
        public int f5915a = 5120;

        /* renamed from: b */
        public int f5916b = 10485760;

        /* renamed from: c */
        public Bitmap.CompressFormat f5917c = c.f5909a;

        /* renamed from: d */
        public int f5918d = 70;

        /* renamed from: e */
        public boolean f5919e = true;

        public void a(float f2) {
            if (f2 >= 0.01f && f2 <= 0.8f) {
                this.f5915a = Math.round((f2 * ((float) Runtime.getRuntime().maxMemory())) / 1024.0f);
                return;
            }
            throw new IllegalArgumentException("setMemCacheSizePercent - percent must be between 0.01 and 0.8 (inclusive)");
        }
    }

    /* compiled from: ReusableImageBitmapCache.java */
    /* loaded from: classes.dex */
    public static class b extends Fragment {

        /* renamed from: a */
        private Object f5920a;

        public void b(Object obj) {
            this.f5920a = obj;
        }

        @Override // android.support.v4.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
        }

        public Object z() {
            return this.f5920a;
        }
    }

    private c(a aVar) {
        a(aVar);
    }

    public void b() {
        LruCache<String, BitmapDrawable> lruCache = this.f5910b;
        if (lruCache != null) {
            lruCache.evictAll();
        }
    }

    public static c a(FragmentManager fragmentManager, a aVar) {
        b a2 = a(fragmentManager);
        c cVar = (c) a2.z();
        if (cVar != null) {
            return cVar;
        }
        c cVar2 = new c(aVar);
        a2.b(cVar2);
        return cVar2;
    }

    private void a(a aVar) {
        this.f5911c = aVar;
        if (this.f5911c.f5919e) {
            if (com.adobe.creativesdk.foundation.internal.storage.controllers.a.a.a()) {
                this.f5914f = Collections.synchronizedSet(new HashSet());
            }
            this.f5910b = new com.adobe.creativesdk.foundation.internal.storage.controllers.a.b(this, this.f5911c.f5915a);
        }
    }

    public void a(String str, BitmapDrawable bitmapDrawable) {
        LruCache<String, BitmapDrawable> lruCache;
        if (str == null || bitmapDrawable == null || (lruCache = this.f5910b) == null) {
            return;
        }
        lruCache.put(str, bitmapDrawable);
    }

    public BitmapDrawable a(String str) {
        LruCache<String, BitmapDrawable> lruCache = this.f5910b;
        if (lruCache != null) {
            return lruCache.get(str);
        }
        return null;
    }

    @TargetApi(19)
    public static int a(BitmapDrawable bitmapDrawable) {
        Bitmap bitmap = bitmapDrawable.getBitmap();
        if (com.adobe.creativesdk.foundation.internal.storage.controllers.a.a.c()) {
            return bitmap.getAllocationByteCount();
        }
        if (com.adobe.creativesdk.foundation.internal.storage.controllers.a.a.b()) {
            return bitmap.getByteCount();
        }
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    private static b a(FragmentManager fragmentManager) {
        b bVar = (b) fragmentManager.findFragmentByTag("ImageCache");
        if (bVar != null) {
            return bVar;
        }
        b bVar2 = new b();
        fragmentManager.beginTransaction().add(bVar2, "ImageCache").commitAllowingStateLoss();
        return bVar2;
    }
}
