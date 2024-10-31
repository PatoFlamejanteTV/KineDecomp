package com.nexstreaming.kinemaster.mediainfo;

import android.graphics.Bitmap;
import android.util.LruCache;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* compiled from: CachedThumbnails.java */
/* loaded from: classes.dex */
public class a implements aq {

    /* renamed from: a, reason: collision with root package name */
    private static WeakHashMap<aq, a> f3487a = new WeakHashMap<>();
    private static final LruCache<Bitmap, Bitmap> c = new LruCache<>(500);
    private final WeakReference<aq> b;
    private C0070a[] d = new C0070a[100];

    /* compiled from: CachedThumbnails.java */
    /* renamed from: com.nexstreaming.kinemaster.mediainfo.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0070a {

        /* renamed from: a, reason: collision with root package name */
        public final int f3488a;
        public final int b;
        public final int c;
        public final int d;
        public final boolean e;
        public final boolean f;
        public final WeakReference<Bitmap> g;

        private C0070a(int i, int i2, boolean z, boolean z2, Bitmap bitmap) {
            this.f3488a = i;
            this.c = bitmap.getWidth();
            this.d = bitmap.getHeight();
            this.b = i2;
            this.e = z;
            this.f = z2;
            this.g = new WeakReference<>(bitmap);
        }
    }

    public static aq a(aq aqVar) {
        if (!(aqVar instanceof a)) {
            a aVar = f3487a.get(aqVar);
            if (aVar != null) {
                return aVar;
            }
            a aVar2 = new a(aqVar);
            f3487a.put(aqVar, aVar2);
            return aVar2;
        }
        return aqVar;
    }

    private a(aq aqVar) {
        this.b = new WeakReference<>(aqVar);
    }

    @Override // com.nexstreaming.kinemaster.mediainfo.aq
    public int a(int i) {
        aq aqVar = this.b.get();
        if (aqVar == null) {
            return 0;
        }
        return aqVar.a(i);
    }

    @Override // com.nexstreaming.kinemaster.mediainfo.aq
    public int b(int i) {
        aq aqVar = this.b.get();
        if (aqVar == null) {
            return 0;
        }
        return aqVar.b(i);
    }

    @Override // com.nexstreaming.kinemaster.mediainfo.aq
    public int c(int i) {
        aq aqVar = this.b.get();
        if (aqVar == null) {
            return 0;
        }
        return aqVar.c(i);
    }

    @Override // com.nexstreaming.kinemaster.mediainfo.aq
    public float a(int i, float f) {
        aq aqVar = this.b.get();
        if (aqVar == null) {
            return 0.0f;
        }
        return aqVar.a(i, f);
    }

    @Override // com.nexstreaming.kinemaster.mediainfo.aq
    public Bitmap a(int i, int i2, boolean z, boolean z2) {
        Bitmap bitmap;
        int a2 = a(i2);
        for (C0070a c0070a : this.d) {
            if (c0070a != null && c0070a.f3488a == i && c0070a.b == a2 && c0070a.e == z && c0070a.f == z2 && (bitmap = c0070a.g.get()) != null) {
                synchronized (c) {
                    c.get(bitmap);
                }
                return bitmap;
            }
        }
        aq aqVar = this.b.get();
        if (aqVar == null) {
            return null;
        }
        Bitmap a3 = aqVar.a(i, a2, z, z2);
        C0070a c0070a2 = new C0070a(i, a2, z, z2, a3);
        System.arraycopy(this.d, 0, this.d, 1, this.d.length - 1);
        this.d[0] = c0070a2;
        return a3;
    }

    @Override // com.nexstreaming.kinemaster.mediainfo.aq
    public Bitmap b(int i, int i2, boolean z, boolean z2) {
        aq aqVar = this.b.get();
        if (aqVar == null) {
            return null;
        }
        return aqVar.b(i, i2, z, z2);
    }
}
