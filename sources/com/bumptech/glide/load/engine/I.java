package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.a.d;
import com.bumptech.glide.load.b.u;
import com.bumptech.glide.load.engine.InterfaceC0718h;
import java.util.Collections;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SourceGenerator.java */
/* loaded from: classes.dex */
public class I implements InterfaceC0718h, d.a<Object>, InterfaceC0718h.a {

    /* renamed from: a, reason: collision with root package name */
    private final C0719i<?> f8784a;

    /* renamed from: b, reason: collision with root package name */
    private final InterfaceC0718h.a f8785b;

    /* renamed from: c, reason: collision with root package name */
    private int f8786c;

    /* renamed from: d, reason: collision with root package name */
    private C0715e f8787d;

    /* renamed from: e, reason: collision with root package name */
    private Object f8788e;

    /* renamed from: f, reason: collision with root package name */
    private volatile u.a<?> f8789f;

    /* renamed from: g, reason: collision with root package name */
    private C0716f f8790g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public I(C0719i<?> c0719i, InterfaceC0718h.a aVar) {
        this.f8784a = c0719i;
        this.f8785b = aVar;
    }

    private boolean b() {
        return this.f8786c < this.f8784a.g().size();
    }

    @Override // com.bumptech.glide.load.engine.InterfaceC0718h
    public boolean a() {
        Object obj = this.f8788e;
        if (obj != null) {
            this.f8788e = null;
            b(obj);
        }
        C0715e c0715e = this.f8787d;
        if (c0715e != null && c0715e.a()) {
            return true;
        }
        this.f8787d = null;
        this.f8789f = null;
        boolean z = false;
        while (!z && b()) {
            List<u.a<?>> g2 = this.f8784a.g();
            int i = this.f8786c;
            this.f8786c = i + 1;
            this.f8789f = g2.get(i);
            if (this.f8789f != null && (this.f8784a.e().a(this.f8789f.f8648c.c()) || this.f8784a.c(this.f8789f.f8648c.a()))) {
                this.f8789f.f8648c.a(this.f8784a.j(), this);
                z = true;
            }
        }
        return z;
    }

    @Override // com.bumptech.glide.load.engine.InterfaceC0718h
    public void cancel() {
        u.a<?> aVar = this.f8789f;
        if (aVar != null) {
            aVar.f8648c.cancel();
        }
    }

    @Override // com.bumptech.glide.load.engine.InterfaceC0718h.a
    public void e() {
        throw new UnsupportedOperationException();
    }

    private void b(Object obj) {
        long a2 = com.bumptech.glide.g.h.a();
        try {
            com.bumptech.glide.load.a<X> a3 = this.f8784a.a((C0719i<?>) obj);
            C0717g c0717g = new C0717g(a3, obj, this.f8784a.i());
            this.f8790g = new C0716f(this.f8789f.f8646a, this.f8784a.l());
            this.f8784a.d().a(this.f8790g, c0717g);
            if (Log.isLoggable("SourceGenerator", 2)) {
                Log.v("SourceGenerator", "Finished encoding source to cache, key: " + this.f8790g + ", data: " + obj + ", encoder: " + a3 + ", duration: " + com.bumptech.glide.g.h.a(a2));
            }
            this.f8789f.f8648c.b();
            this.f8787d = new C0715e(Collections.singletonList(this.f8789f.f8646a), this.f8784a, this);
        } catch (Throwable th) {
            this.f8789f.f8648c.b();
            throw th;
        }
    }

    @Override // com.bumptech.glide.load.a.d.a
    public void a(Object obj) {
        q e2 = this.f8784a.e();
        if (obj != null && e2.a(this.f8789f.f8648c.c())) {
            this.f8788e = obj;
            this.f8785b.e();
        } else {
            this.f8785b.a(this.f8789f.f8646a, obj, this.f8789f.f8648c, this.f8789f.f8648c.c(), this.f8790g);
        }
    }

    @Override // com.bumptech.glide.load.a.d.a
    public void a(Exception exc) {
        this.f8785b.a(this.f8790g, exc, this.f8789f.f8648c, this.f8789f.f8648c.c());
    }

    @Override // com.bumptech.glide.load.engine.InterfaceC0718h.a
    public void a(com.bumptech.glide.load.c cVar, Object obj, com.bumptech.glide.load.a.d<?> dVar, DataSource dataSource, com.bumptech.glide.load.c cVar2) {
        this.f8785b.a(cVar, obj, dVar, this.f8789f.f8648c.c(), cVar);
    }

    @Override // com.bumptech.glide.load.engine.InterfaceC0718h.a
    public void a(com.bumptech.glide.load.c cVar, Exception exc, com.bumptech.glide.load.a.d<?> dVar, DataSource dataSource) {
        this.f8785b.a(cVar, exc, dVar, this.f8789f.f8648c.c());
    }
}
