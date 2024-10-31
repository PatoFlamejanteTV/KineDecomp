package com.bumptech.glide.load.engine.a;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: LruBitmapPool.java */
/* loaded from: classes.dex */
public class k implements e {

    /* renamed from: a */
    private static final Bitmap.Config f8815a = Bitmap.Config.ARGB_8888;

    /* renamed from: b */
    private final l f8816b;

    /* renamed from: c */
    private final Set<Bitmap.Config> f8817c;

    /* renamed from: d */
    private final long f8818d;

    /* renamed from: e */
    private final a f8819e;

    /* renamed from: f */
    private long f8820f;

    /* renamed from: g */
    private long f8821g;

    /* renamed from: h */
    private int f8822h;
    private int i;
    private int j;
    private int k;

    /* compiled from: LruBitmapPool.java */
    /* loaded from: classes.dex */
    public interface a {
        void a(Bitmap bitmap);

        void b(Bitmap bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LruBitmapPool.java */
    /* loaded from: classes.dex */
    public static final class b implements a {
        b() {
        }

        @Override // com.bumptech.glide.load.engine.a.k.a
        public void a(Bitmap bitmap) {
        }

        @Override // com.bumptech.glide.load.engine.a.k.a
        public void b(Bitmap bitmap) {
        }
    }

    k(long j, l lVar, Set<Bitmap.Config> set) {
        this.f8818d = j;
        this.f8820f = j;
        this.f8816b = lVar;
        this.f8817c = set;
        this.f8819e = new b();
    }

    private static Bitmap c(int i, int i2, Bitmap.Config config) {
        if (config == null) {
            config = f8815a;
        }
        return Bitmap.createBitmap(i, i2, config);
    }

    private synchronized Bitmap d(int i, int i2, Bitmap.Config config) {
        Bitmap a2;
        a(config);
        a2 = this.f8816b.a(i, i2, config != null ? config : f8815a);
        if (a2 == null) {
            if (Log.isLoggable("LruBitmapPool", 3)) {
                Log.d("LruBitmapPool", "Missing bitmap=" + this.f8816b.b(i, i2, config));
            }
            this.i++;
        } else {
            this.f8822h++;
            this.f8821g -= this.f8816b.c(a2);
            this.f8819e.a(a2);
            c(a2);
        }
        if (Log.isLoggable("LruBitmapPool", 2)) {
            Log.v("LruBitmapPool", "Get bitmap=" + this.f8816b.b(i, i2, config));
        }
        c();
        return a2;
    }

    private void e() {
        a(this.f8820f);
    }

    @TargetApi(26)
    private static Set<Bitmap.Config> f() {
        HashSet hashSet = new HashSet(Arrays.asList(Bitmap.Config.values()));
        if (Build.VERSION.SDK_INT >= 19) {
            hashSet.add(null);
        }
        if (Build.VERSION.SDK_INT >= 26) {
            hashSet.remove(Bitmap.Config.HARDWARE);
        }
        return Collections.unmodifiableSet(hashSet);
    }

    private static l g() {
        if (Build.VERSION.SDK_INT >= 19) {
            return new o();
        }
        return new c();
    }

    @Override // com.bumptech.glide.load.engine.a.e
    public synchronized void a(Bitmap bitmap) {
        try {
            if (bitmap != null) {
                if (!bitmap.isRecycled()) {
                    if (bitmap.isMutable() && this.f8816b.c(bitmap) <= this.f8820f && this.f8817c.contains(bitmap.getConfig())) {
                        int c2 = this.f8816b.c(bitmap);
                        this.f8816b.a(bitmap);
                        this.f8819e.b(bitmap);
                        this.j++;
                        this.f8821g += c2;
                        if (Log.isLoggable("LruBitmapPool", 2)) {
                            Log.v("LruBitmapPool", "Put bitmap in pool=" + this.f8816b.b(bitmap));
                        }
                        c();
                        e();
                        return;
                    }
                    if (Log.isLoggable("LruBitmapPool", 2)) {
                        Log.v("LruBitmapPool", "Reject bitmap from pool, bitmap: " + this.f8816b.b(bitmap) + ", is mutable: " + bitmap.isMutable() + ", is allowed config: " + this.f8817c.contains(bitmap.getConfig()));
                    }
                    bitmap.recycle();
                    return;
                }
                throw new IllegalStateException("Cannot pool recycled bitmap");
            }
            throw new NullPointerException("Bitmap must not be null");
        } catch (Throwable th) {
            throw th;
        }
    }

    public long b() {
        return this.f8820f;
    }

    private static void c(Bitmap bitmap) {
        bitmap.setHasAlpha(true);
        b(bitmap);
    }

    @Override // com.bumptech.glide.load.engine.a.e
    public Bitmap b(int i, int i2, Bitmap.Config config) {
        Bitmap d2 = d(i, i2, config);
        return d2 == null ? c(i, i2, config) : d2;
    }

    @TargetApi(19)
    private static void b(Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= 19) {
            bitmap.setPremultiplied(true);
        }
    }

    private void c() {
        if (Log.isLoggable("LruBitmapPool", 2)) {
            d();
        }
    }

    public k(long j) {
        this(j, g(), f());
    }

    private void d() {
        Log.v("LruBitmapPool", "Hits=" + this.f8822h + ", misses=" + this.i + ", puts=" + this.j + ", evictions=" + this.k + ", currentSize=" + this.f8821g + ", maxSize=" + this.f8820f + "\nStrategy=" + this.f8816b);
    }

    @Override // com.bumptech.glide.load.engine.a.e
    public Bitmap a(int i, int i2, Bitmap.Config config) {
        Bitmap d2 = d(i, i2, config);
        if (d2 != null) {
            d2.eraseColor(0);
            return d2;
        }
        return c(i, i2, config);
    }

    @TargetApi(26)
    private static void a(Bitmap.Config config) {
        if (Build.VERSION.SDK_INT >= 26 && config == Bitmap.Config.HARDWARE) {
            throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + config + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
        }
    }

    @Override // com.bumptech.glide.load.engine.a.e
    public void a() {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "clearMemory");
        }
        a(0L);
    }

    @Override // com.bumptech.glide.load.engine.a.e
    @SuppressLint({"InlinedApi"})
    public void a(int i) {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "trimMemory, level=" + i);
        }
        if (i >= 40) {
            a();
        } else if (i >= 20 || i == 15) {
            a(b() / 2);
        }
    }

    private synchronized void a(long j) {
        while (this.f8821g > j) {
            Bitmap removeLast = this.f8816b.removeLast();
            if (removeLast == null) {
                if (Log.isLoggable("LruBitmapPool", 5)) {
                    Log.w("LruBitmapPool", "Size mismatch, resetting");
                    d();
                }
                this.f8821g = 0L;
                return;
            }
            this.f8819e.a(removeLast);
            this.f8821g -= this.f8816b.c(removeLast);
            this.k++;
            if (Log.isLoggable("LruBitmapPool", 3)) {
                Log.d("LruBitmapPool", "Evicting bitmap=" + this.f8816b.b(removeLast));
            }
            c();
            removeLast.recycle();
        }
    }
}
