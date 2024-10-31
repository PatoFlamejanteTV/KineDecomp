package com.nexstreaming.kinemaster.mediainfo;

import android.graphics.Bitmap;
import android.util.LruCache;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* compiled from: CachedThumbnails.java */
/* renamed from: com.nexstreaming.kinemaster.mediainfo.b */
/* loaded from: classes.dex */
public class C1784b implements T {

    /* renamed from: a */
    private static WeakHashMap<T, C1784b> f20725a = new WeakHashMap<>();

    /* renamed from: b */
    private static final LruCache<Bitmap, Bitmap> f20726b = new LruCache<>(500);

    /* renamed from: c */
    private final WeakReference<T> f20727c;

    /* renamed from: d */
    private a[] f20728d = new a[100];

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: CachedThumbnails.java */
    /* renamed from: com.nexstreaming.kinemaster.mediainfo.b$a */
    /* loaded from: classes.dex */
    public class a {

        /* renamed from: a */
        public final int f20729a;

        /* renamed from: b */
        public final int f20730b;

        /* renamed from: c */
        public final int f20731c;

        /* renamed from: d */
        public final int f20732d;

        /* renamed from: e */
        public final boolean f20733e;

        /* renamed from: f */
        public final boolean f20734f;

        /* renamed from: g */
        public final WeakReference<Bitmap> f20735g;

        /* synthetic */ a(C1784b c1784b, int i, int i2, boolean z, boolean z2, Bitmap bitmap, C1783a c1783a) {
            this(i, i2, z, z2, bitmap);
        }

        private a(int i, int i2, boolean z, boolean z2, Bitmap bitmap) {
            this.f20729a = i;
            this.f20731c = bitmap.getWidth();
            this.f20732d = bitmap.getHeight();
            this.f20730b = i2;
            this.f20733e = z;
            this.f20734f = z2;
            this.f20735g = new WeakReference<>(bitmap);
        }
    }

    private C1784b(T t) {
        this.f20727c = new WeakReference<>(t);
    }

    public static T a(T t) {
        if (t instanceof C1784b) {
            return t;
        }
        C1784b c1784b = f20725a.get(t);
        if (c1784b != null) {
            return c1784b;
        }
        C1784b c1784b2 = new C1784b(t);
        f20725a.put(t, c1784b2);
        return c1784b2;
    }

    @Override // com.nexstreaming.kinemaster.mediainfo.T
    public int b(int i) {
        T t = this.f20727c.get();
        if (t == null) {
            return 0;
        }
        return t.b(i);
    }

    @Override // com.nexstreaming.kinemaster.mediainfo.T
    public int c(int i) {
        T t = this.f20727c.get();
        if (t == null) {
            return 0;
        }
        return t.c(i);
    }

    @Override // com.nexstreaming.kinemaster.mediainfo.T
    public Bitmap b(int i, int i2, boolean z, boolean z2) {
        Bitmap b2;
        Bitmap bitmap;
        int a2 = a(i2);
        for (a aVar : this.f20728d) {
            if (aVar != null && aVar.f20729a == i && aVar.f20730b == a2 && aVar.f20733e == z && aVar.f20734f == z2 && (bitmap = aVar.f20735g.get()) != null) {
                synchronized (f20726b) {
                    f20726b.get(bitmap);
                }
                return bitmap;
            }
        }
        T t = this.f20727c.get();
        if (t == null || (b2 = t.b(i, a2, z, z2)) == null) {
            return null;
        }
        a aVar2 = new a(i, a2, z, z2, b2);
        a[] aVarArr = this.f20728d;
        System.arraycopy(aVarArr, 0, aVarArr, 1, aVarArr.length - 1);
        this.f20728d[0] = aVar2;
        return b2;
    }

    @Override // com.nexstreaming.kinemaster.mediainfo.T
    public int a(int i) {
        T t = this.f20727c.get();
        if (t == null) {
            return 0;
        }
        return t.a(i);
    }

    @Override // com.nexstreaming.kinemaster.mediainfo.T
    public float a(int i, float f2) {
        T t = this.f20727c.get();
        if (t == null) {
            return 0.0f;
        }
        return t.a(i, f2);
    }

    @Override // com.nexstreaming.kinemaster.mediainfo.T
    public Bitmap a(int i, int i2, boolean z, boolean z2) {
        T t = this.f20727c.get();
        if (t == null) {
            return null;
        }
        return t.a(i, i2, z, z2);
    }
}
