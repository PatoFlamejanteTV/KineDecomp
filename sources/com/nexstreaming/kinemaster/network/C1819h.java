package com.nexstreaming.kinemaster.network;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import android.util.LruCache;
import com.android.volley.Request;
import com.android.volley.a.m;
import java.io.File;

/* compiled from: KMVolley.java */
/* renamed from: com.nexstreaming.kinemaster.network.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1819h {

    /* renamed from: a, reason: collision with root package name */
    private static C1819h f21135a;

    /* renamed from: b, reason: collision with root package name */
    private final com.android.volley.a.m f21136b;

    /* renamed from: c, reason: collision with root package name */
    private com.android.volley.l f21137c;

    /* compiled from: KMVolley.java */
    /* renamed from: com.nexstreaming.kinemaster.network.h$a */
    /* loaded from: classes.dex */
    private static class a extends LruCache<String, Bitmap> implements m.b {
        @Override // com.android.volley.a.m.b
        public Bitmap a(String str) {
            return get(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public int sizeOf(String str, Bitmap bitmap) {
            return bitmap.getRowBytes() * bitmap.getHeight();
        }

        private a(Context context) {
            super(a(context));
        }

        @Override // com.android.volley.a.m.b
        public void a(String str, Bitmap bitmap) {
            put(str, bitmap);
        }

        private static int a(Context context) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            return displayMetrics.widthPixels * displayMetrics.heightPixels * 4 * 3;
        }
    }

    private C1819h(Context context) {
        this.f21137c = new com.android.volley.l(new com.android.volley.a.e(new File(context.getFilesDir(), ".kmvnetcache"), 26214400), new com.android.volley.a.b(new com.android.volley.a.i()), 8);
        this.f21136b = new com.android.volley.a.m(this.f21137c, new a(context));
        this.f21137c.c();
    }

    public static C1819h a(Context context) {
        if (f21135a == null) {
            f21135a = new C1819h(context.getApplicationContext());
        }
        return f21135a;
    }

    public com.android.volley.l b() {
        return this.f21137c;
    }

    public com.android.volley.a.m a() {
        return this.f21136b;
    }

    public <T> Request<T> a(Request<T> request) {
        this.f21137c.a(request);
        return request;
    }
}
