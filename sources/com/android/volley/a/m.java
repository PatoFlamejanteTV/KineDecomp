package com.android.volley.a;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.m;
import java.util.HashMap;
import java.util.LinkedList;

/* compiled from: ImageLoader.java */
/* loaded from: classes.dex */
public class m {

    /* renamed from: a */
    private final com.android.volley.l f8023a;

    /* renamed from: c */
    private final b f8025c;

    /* renamed from: g */
    private Runnable f8029g;

    /* renamed from: b */
    private int f8024b = 100;

    /* renamed from: d */
    private final HashMap<String, a> f8026d = new HashMap<>();

    /* renamed from: e */
    private final HashMap<String, a> f8027e = new HashMap<>();

    /* renamed from: f */
    private final Handler f8028f = new Handler(Looper.getMainLooper());

    /* compiled from: ImageLoader.java */
    /* loaded from: classes.dex */
    public class a {

        /* renamed from: a */
        private final Request<?> f8030a;

        /* renamed from: b */
        private Bitmap f8031b;

        /* renamed from: c */
        private VolleyError f8032c;

        /* renamed from: d */
        private final LinkedList<c> f8033d = new LinkedList<>();

        public a(Request<?> request, c cVar) {
            this.f8030a = request;
            this.f8033d.add(cVar);
        }

        public void a(VolleyError volleyError) {
            this.f8032c = volleyError;
        }

        public VolleyError a() {
            return this.f8032c;
        }

        public void a(c cVar) {
            this.f8033d.add(cVar);
        }
    }

    /* compiled from: ImageLoader.java */
    /* loaded from: classes.dex */
    public interface b {
        Bitmap a(String str);

        void a(String str, Bitmap bitmap);
    }

    /* compiled from: ImageLoader.java */
    /* loaded from: classes.dex */
    public class c {

        /* renamed from: a */
        private Bitmap f8035a;

        /* renamed from: b */
        private final d f8036b;

        /* renamed from: c */
        private final String f8037c;

        /* renamed from: d */
        private final String f8038d;

        public c(Bitmap bitmap, String str, String str2, d dVar) {
            this.f8035a = bitmap;
            this.f8038d = str;
            this.f8037c = str2;
            this.f8036b = dVar;
        }

        public Bitmap a() {
            return this.f8035a;
        }
    }

    /* compiled from: ImageLoader.java */
    /* loaded from: classes.dex */
    public interface d extends m.a {
        void a(c cVar, boolean z);
    }

    public m(com.android.volley.l lVar, b bVar) {
        this.f8023a = lVar;
        this.f8025c = bVar;
    }

    public c a(String str, d dVar) {
        return a(str, dVar, 0, 0);
    }

    public c a(String str, d dVar, int i, int i2) {
        return a(str, dVar, i, i2, ImageView.ScaleType.CENTER_INSIDE);
    }

    public c a(String str, d dVar, int i, int i2, ImageView.ScaleType scaleType) {
        a();
        String a2 = a(str, i, i2, scaleType);
        Bitmap a3 = this.f8025c.a(a2);
        if (a3 != null) {
            c cVar = new c(a3, str, null, null);
            dVar.a(cVar, true);
            return cVar;
        }
        c cVar2 = new c(null, str, a2, dVar);
        dVar.a(cVar2, true);
        a aVar = this.f8026d.get(a2);
        if (aVar != null) {
            aVar.a(cVar2);
            return cVar2;
        }
        Request<Bitmap> a4 = a(str, i, i2, scaleType, a2);
        this.f8023a.a(a4);
        this.f8026d.put(a2, new a(a4, cVar2));
        return cVar2;
    }

    protected Request<Bitmap> a(String str, int i, int i2, ImageView.ScaleType scaleType, String str2) {
        return new n(str, new j(this, str2), i, i2, scaleType, Bitmap.Config.RGB_565, new k(this, str2));
    }

    public void a(String str, Bitmap bitmap) {
        this.f8025c.a(str, bitmap);
        a remove = this.f8026d.remove(str);
        if (remove != null) {
            remove.f8031b = bitmap;
            a(str, remove);
        }
    }

    public void a(String str, VolleyError volleyError) {
        a remove = this.f8026d.remove(str);
        if (remove != null) {
            remove.a(volleyError);
            a(str, remove);
        }
    }

    private void a(String str, a aVar) {
        this.f8027e.put(str, aVar);
        if (this.f8029g == null) {
            this.f8029g = new l(this);
            this.f8028f.postDelayed(this.f8029g, this.f8024b);
        }
    }

    private void a() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("ImageLoader must be invoked from the main thread.");
        }
    }

    private static String a(String str, int i, int i2, ImageView.ScaleType scaleType) {
        StringBuilder sb = new StringBuilder(str.length() + 12);
        sb.append("#W");
        sb.append(i);
        sb.append("#H");
        sb.append(i2);
        sb.append("#S");
        sb.append(scaleType.ordinal());
        sb.append(str);
        return sb.toString();
    }
}
