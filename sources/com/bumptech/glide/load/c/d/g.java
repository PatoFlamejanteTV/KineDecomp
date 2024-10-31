package com.bumptech.glide.load.c.d;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bumptech.glide.g.l;
import com.bumptech.glide.g.n;
import com.bumptech.glide.load.engine.q;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GifFrameLoader.java */
/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.b.a f8705a;

    /* renamed from: b, reason: collision with root package name */
    private final Handler f8706b;

    /* renamed from: c, reason: collision with root package name */
    private final List<b> f8707c;

    /* renamed from: d, reason: collision with root package name */
    final com.bumptech.glide.j f8708d;

    /* renamed from: e, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.a.e f8709e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f8710f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f8711g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f8712h;
    private com.bumptech.glide.h<Bitmap> i;
    private a j;
    private boolean k;
    private a l;
    private Bitmap m;
    private com.bumptech.glide.load.j<Bitmap> n;
    private a o;
    private d p;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GifFrameLoader.java */
    /* loaded from: classes.dex */
    public static class a extends com.bumptech.glide.request.a.g<Bitmap> {

        /* renamed from: d, reason: collision with root package name */
        private final Handler f8713d;

        /* renamed from: e, reason: collision with root package name */
        final int f8714e;

        /* renamed from: f, reason: collision with root package name */
        private final long f8715f;

        /* renamed from: g, reason: collision with root package name */
        private Bitmap f8716g;

        a(Handler handler, int i, long j) {
            this.f8713d = handler;
            this.f8714e = i;
            this.f8715f = j;
        }

        @Override // com.bumptech.glide.request.a.i
        public /* bridge */ /* synthetic */ void a(Object obj, com.bumptech.glide.request.b.f fVar) {
            a((Bitmap) obj, (com.bumptech.glide.request.b.f<? super Bitmap>) fVar);
        }

        Bitmap b() {
            return this.f8716g;
        }

        public void a(Bitmap bitmap, com.bumptech.glide.request.b.f<? super Bitmap> fVar) {
            this.f8716g = bitmap;
            this.f8713d.sendMessageAtTime(this.f8713d.obtainMessage(1, this), this.f8715f);
        }
    }

    /* compiled from: GifFrameLoader.java */
    /* loaded from: classes.dex */
    public interface b {
        void a();
    }

    /* compiled from: GifFrameLoader.java */
    /* loaded from: classes.dex */
    private class c implements Handler.Callback {
        c() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                g.this.a((a) message.obj);
                return true;
            }
            if (i != 2) {
                return false;
            }
            g.this.f8708d.a((a) message.obj);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GifFrameLoader.java */
    /* loaded from: classes.dex */
    public interface d {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(com.bumptech.glide.c cVar, com.bumptech.glide.b.a aVar, int i, int i2, com.bumptech.glide.load.j<Bitmap> jVar, Bitmap bitmap) {
        this(cVar.c(), com.bumptech.glide.c.b(cVar.e()), aVar, null, a(com.bumptech.glide.c.b(cVar.e()), i, i2), jVar, bitmap);
    }

    private static com.bumptech.glide.load.c j() {
        return new com.bumptech.glide.f.c(Double.valueOf(Math.random()));
    }

    private int k() {
        return n.a(c().getWidth(), c().getHeight(), c().getConfig());
    }

    private void l() {
        if (!this.f8710f || this.f8711g) {
            return;
        }
        if (this.f8712h) {
            l.a(this.o == null, "Pending target must be null when starting from the first frame");
            this.f8705a.d();
            this.f8712h = false;
        }
        a aVar = this.o;
        if (aVar != null) {
            this.o = null;
            a(aVar);
            return;
        }
        this.f8711g = true;
        long uptimeMillis = SystemClock.uptimeMillis() + this.f8705a.c();
        this.f8705a.advance();
        this.l = new a(this.f8706b, this.f8705a.e(), uptimeMillis);
        com.bumptech.glide.h<Bitmap> a2 = this.i.a((com.bumptech.glide.request.a<?>) com.bumptech.glide.request.f.b(j()));
        a2.a(this.f8705a);
        a2.a((com.bumptech.glide.h<Bitmap>) this.l);
    }

    private void m() {
        Bitmap bitmap = this.m;
        if (bitmap != null) {
            this.f8709e.a(bitmap);
            this.m = null;
        }
    }

    private void n() {
        if (this.f8710f) {
            return;
        }
        this.f8710f = true;
        this.k = false;
        l();
    }

    private void o() {
        this.f8710f = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.bumptech.glide.load.j<Bitmap> jVar, Bitmap bitmap) {
        l.a(jVar);
        this.n = jVar;
        l.a(bitmap);
        this.m = bitmap;
        this.i = this.i.a((com.bumptech.glide.request.a<?>) new com.bumptech.glide.request.f().a(jVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(b bVar) {
        this.f8707c.remove(bVar);
        if (this.f8707c.isEmpty()) {
            o();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bitmap c() {
        a aVar = this.j;
        return aVar != null ? aVar.b() : this.m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        a aVar = this.j;
        if (aVar != null) {
            return aVar.f8714e;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bitmap e() {
        return this.m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f() {
        return this.f8705a.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g() {
        return c().getHeight();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int h() {
        return this.f8705a.f() + k();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int i() {
        return c().getWidth();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar) {
        if (!this.k) {
            if (!this.f8707c.contains(bVar)) {
                boolean isEmpty = this.f8707c.isEmpty();
                this.f8707c.add(bVar);
                if (isEmpty) {
                    n();
                    return;
                }
                return;
            }
            throw new IllegalStateException("Cannot subscribe twice in a row");
        }
        throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ByteBuffer b() {
        return this.f8705a.getData().asReadOnlyBuffer();
    }

    g(com.bumptech.glide.load.engine.a.e eVar, com.bumptech.glide.j jVar, com.bumptech.glide.b.a aVar, Handler handler, com.bumptech.glide.h<Bitmap> hVar, com.bumptech.glide.load.j<Bitmap> jVar2, Bitmap bitmap) {
        this.f8707c = new ArrayList();
        this.f8708d = jVar;
        handler = handler == null ? new Handler(Looper.getMainLooper(), new c()) : handler;
        this.f8709e = eVar;
        this.f8706b = handler;
        this.i = hVar;
        this.f8705a = aVar;
        a(jVar2, bitmap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f8707c.clear();
        m();
        o();
        a aVar = this.j;
        if (aVar != null) {
            this.f8708d.a(aVar);
            this.j = null;
        }
        a aVar2 = this.l;
        if (aVar2 != null) {
            this.f8708d.a(aVar2);
            this.l = null;
        }
        a aVar3 = this.o;
        if (aVar3 != null) {
            this.f8708d.a(aVar3);
            this.o = null;
        }
        this.f8705a.clear();
        this.k = true;
    }

    void a(a aVar) {
        d dVar = this.p;
        if (dVar != null) {
            dVar.a();
        }
        this.f8711g = false;
        if (this.k) {
            this.f8706b.obtainMessage(2, aVar).sendToTarget();
            return;
        }
        if (!this.f8710f) {
            this.o = aVar;
            return;
        }
        if (aVar.b() != null) {
            m();
            a aVar2 = this.j;
            this.j = aVar;
            for (int size = this.f8707c.size() - 1; size >= 0; size--) {
                this.f8707c.get(size).a();
            }
            if (aVar2 != null) {
                this.f8706b.obtainMessage(2, aVar2).sendToTarget();
            }
        }
        l();
    }

    private static com.bumptech.glide.h<Bitmap> a(com.bumptech.glide.j jVar, int i, int i2) {
        return jVar.a().a((com.bumptech.glide.request.a<?>) com.bumptech.glide.request.f.b(q.f8926b).b(true).a(true).a(i, i2));
    }
}
