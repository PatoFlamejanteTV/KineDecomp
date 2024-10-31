package com.bumptech.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import com.bumptech.glide.c.c;
import com.bumptech.glide.c.o;
import com.bumptech.glide.c.p;
import com.bumptech.glide.c.r;
import com.bumptech.glide.g.n;
import com.bumptech.glide.load.engine.q;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: RequestManager.java */
/* loaded from: classes.dex */
public class j implements com.bumptech.glide.c.j, f<h<Drawable>> {

    /* renamed from: a, reason: collision with root package name */
    private static final com.bumptech.glide.request.f f8522a;

    /* renamed from: b, reason: collision with root package name */
    private static final com.bumptech.glide.request.f f8523b;

    /* renamed from: c, reason: collision with root package name */
    private static final com.bumptech.glide.request.f f8524c;

    /* renamed from: d, reason: collision with root package name */
    protected final c f8525d;

    /* renamed from: e, reason: collision with root package name */
    protected final Context f8526e;

    /* renamed from: f, reason: collision with root package name */
    final com.bumptech.glide.c.i f8527f;

    /* renamed from: g, reason: collision with root package name */
    private final p f8528g;

    /* renamed from: h, reason: collision with root package name */
    private final o f8529h;
    private final r i;
    private final Runnable j;
    private final Handler k;
    private final com.bumptech.glide.c.c l;
    private final CopyOnWriteArrayList<com.bumptech.glide.request.e<Object>> m;
    private com.bumptech.glide.request.f n;

    /* compiled from: RequestManager.java */
    /* loaded from: classes.dex */
    private class a implements c.a {

        /* renamed from: a, reason: collision with root package name */
        private final p f8530a;

        a(p pVar) {
            this.f8530a = pVar;
        }

        @Override // com.bumptech.glide.c.c.a
        public void a(boolean z) {
            if (z) {
                synchronized (j.this) {
                    this.f8530a.c();
                }
            }
        }
    }

    static {
        com.bumptech.glide.request.f b2 = com.bumptech.glide.request.f.b((Class<?>) Bitmap.class);
        b2.C();
        f8522a = b2;
        com.bumptech.glide.request.f b3 = com.bumptech.glide.request.f.b((Class<?>) com.bumptech.glide.load.c.d.c.class);
        b3.C();
        f8523b = b3;
        f8524c = com.bumptech.glide.request.f.b(q.f8927c).a(Priority.LOW).a(true);
    }

    public j(c cVar, com.bumptech.glide.c.i iVar, o oVar, Context context) {
        this(cVar, iVar, oVar, new p(), cVar.d(), context);
    }

    private void c(com.bumptech.glide.request.a.i<?> iVar) {
        if (b(iVar) || this.f8525d.a(iVar) || iVar.getRequest() == null) {
            return;
        }
        com.bumptech.glide.request.c request = iVar.getRequest();
        iVar.a((com.bumptech.glide.request.c) null);
        request.clear();
    }

    protected synchronized void a(com.bumptech.glide.request.f fVar) {
        com.bumptech.glide.request.f mo7clone = fVar.mo7clone();
        mo7clone.a();
        this.n = mo7clone;
    }

    public h<Drawable> b() {
        return a(Drawable.class);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized com.bumptech.glide.request.f d() {
        return this.n;
    }

    public synchronized void e() {
        this.f8528g.b();
    }

    public synchronized void f() {
        this.f8528g.d();
    }

    @Override // com.bumptech.glide.c.j
    public synchronized void onDestroy() {
        this.i.onDestroy();
        Iterator<com.bumptech.glide.request.a.i<?>> it = this.i.b().iterator();
        while (it.hasNext()) {
            a(it.next());
        }
        this.i.a();
        this.f8528g.a();
        this.f8527f.a(this);
        this.f8527f.a(this.l);
        this.k.removeCallbacks(this.j);
        this.f8525d.b(this);
    }

    @Override // com.bumptech.glide.c.j
    public synchronized void onStart() {
        f();
        this.i.onStart();
    }

    @Override // com.bumptech.glide.c.j
    public synchronized void onStop() {
        e();
        this.i.onStop();
    }

    public synchronized String toString() {
        return super.toString() + "{tracker=" + this.f8528g + ", treeNode=" + this.f8529h + "}";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean b(com.bumptech.glide.request.a.i<?> iVar) {
        com.bumptech.glide.request.c request = iVar.getRequest();
        if (request == null) {
            return true;
        }
        if (!this.f8528g.a(request)) {
            return false;
        }
        this.i.b(iVar);
        iVar.a((com.bumptech.glide.request.c) null);
        return true;
    }

    public h<Bitmap> a() {
        return a(Bitmap.class).a((com.bumptech.glide.request.a<?>) f8522a);
    }

    j(c cVar, com.bumptech.glide.c.i iVar, o oVar, p pVar, com.bumptech.glide.c.d dVar, Context context) {
        this.i = new r();
        this.j = new i(this);
        this.k = new Handler(Looper.getMainLooper());
        this.f8525d = cVar;
        this.f8527f = iVar;
        this.f8529h = oVar;
        this.f8528g = pVar;
        this.f8526e = context;
        this.l = dVar.a(context.getApplicationContext(), new a(pVar));
        if (n.b()) {
            this.k.post(this.j);
        } else {
            iVar.b(this);
        }
        iVar.b(this.l);
        this.m = new CopyOnWriteArrayList<>(cVar.f().b());
        a(cVar.f().c());
        cVar.a(this);
    }

    public h<Drawable> a(Bitmap bitmap) {
        return b().a(bitmap);
    }

    public h<Drawable> a(String str) {
        h<Drawable> b2 = b();
        b2.a(str);
        return b2;
    }

    public h<Drawable> a(Integer num) {
        return b().a(num);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<com.bumptech.glide.request.e<Object>> c() {
        return this.m;
    }

    public <ResourceType> h<ResourceType> a(Class<ResourceType> cls) {
        return new h<>(this.f8525d, this, cls, this.f8526e);
    }

    public synchronized void a(com.bumptech.glide.request.a.i<?> iVar) {
        if (iVar == null) {
            return;
        }
        c(iVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <T> k<?, T> b(Class<T> cls) {
        return this.f8525d.f().a(cls);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(com.bumptech.glide.request.a.i<?> iVar, com.bumptech.glide.request.c cVar) {
        this.i.a(iVar);
        this.f8528g.b(cVar);
    }
}
