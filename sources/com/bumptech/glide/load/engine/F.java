package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.a.d;
import com.bumptech.glide.load.b.u;
import com.bumptech.glide.load.engine.InterfaceC0718h;
import java.io.File;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ResourceCacheGenerator.java */
/* loaded from: classes.dex */
public class F implements InterfaceC0718h, d.a<Object> {

    /* renamed from: a, reason: collision with root package name */
    private final InterfaceC0718h.a f8763a;

    /* renamed from: b, reason: collision with root package name */
    private final C0719i<?> f8764b;

    /* renamed from: c, reason: collision with root package name */
    private int f8765c;

    /* renamed from: d, reason: collision with root package name */
    private int f8766d = -1;

    /* renamed from: e, reason: collision with root package name */
    private com.bumptech.glide.load.c f8767e;

    /* renamed from: f, reason: collision with root package name */
    private List<com.bumptech.glide.load.b.u<File, ?>> f8768f;

    /* renamed from: g, reason: collision with root package name */
    private int f8769g;

    /* renamed from: h, reason: collision with root package name */
    private volatile u.a<?> f8770h;
    private File i;
    private G j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public F(C0719i<?> c0719i, InterfaceC0718h.a aVar) {
        this.f8764b = c0719i;
        this.f8763a = aVar;
    }

    private boolean b() {
        return this.f8769g < this.f8768f.size();
    }

    @Override // com.bumptech.glide.load.engine.InterfaceC0718h
    public boolean a() {
        List<com.bumptech.glide.load.c> c2 = this.f8764b.c();
        boolean z = false;
        if (c2.isEmpty()) {
            return false;
        }
        List<Class<?>> k = this.f8764b.k();
        if (k.isEmpty()) {
            if (File.class.equals(this.f8764b.m())) {
                return false;
            }
            throw new IllegalStateException("Failed to find any load path from " + this.f8764b.h() + " to " + this.f8764b.m());
        }
        while (true) {
            if (this.f8768f != null && b()) {
                this.f8770h = null;
                while (!z && b()) {
                    List<com.bumptech.glide.load.b.u<File, ?>> list = this.f8768f;
                    int i = this.f8769g;
                    this.f8769g = i + 1;
                    this.f8770h = list.get(i).a(this.i, this.f8764b.n(), this.f8764b.f(), this.f8764b.i());
                    if (this.f8770h != null && this.f8764b.c(this.f8770h.f8648c.a())) {
                        this.f8770h.f8648c.a(this.f8764b.j(), this);
                        z = true;
                    }
                }
                return z;
            }
            this.f8766d++;
            if (this.f8766d >= k.size()) {
                this.f8765c++;
                if (this.f8765c >= c2.size()) {
                    return false;
                }
                this.f8766d = 0;
            }
            com.bumptech.glide.load.c cVar = c2.get(this.f8765c);
            Class<?> cls = k.get(this.f8766d);
            this.j = new G(this.f8764b.b(), cVar, this.f8764b.l(), this.f8764b.n(), this.f8764b.f(), this.f8764b.b(cls), cls, this.f8764b.i());
            this.i = this.f8764b.d().a(this.j);
            File file = this.i;
            if (file != null) {
                this.f8767e = cVar;
                this.f8768f = this.f8764b.a(file);
                this.f8769g = 0;
            }
        }
    }

    @Override // com.bumptech.glide.load.engine.InterfaceC0718h
    public void cancel() {
        u.a<?> aVar = this.f8770h;
        if (aVar != null) {
            aVar.f8648c.cancel();
        }
    }

    @Override // com.bumptech.glide.load.a.d.a
    public void a(Object obj) {
        this.f8763a.a(this.f8767e, obj, this.f8770h.f8648c, DataSource.RESOURCE_DISK_CACHE, this.j);
    }

    @Override // com.bumptech.glide.load.a.d.a
    public void a(Exception exc) {
        this.f8763a.a(this.j, exc, this.f8770h.f8648c, DataSource.RESOURCE_DISK_CACHE);
    }
}
