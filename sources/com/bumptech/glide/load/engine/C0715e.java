package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.a.d;
import com.bumptech.glide.load.b.u;
import com.bumptech.glide.load.engine.InterfaceC0718h;
import java.io.File;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DataCacheGenerator.java */
/* renamed from: com.bumptech.glide.load.engine.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0715e implements InterfaceC0718h, d.a<Object> {

    /* renamed from: a, reason: collision with root package name */
    private final List<com.bumptech.glide.load.c> f8896a;

    /* renamed from: b, reason: collision with root package name */
    private final C0719i<?> f8897b;

    /* renamed from: c, reason: collision with root package name */
    private final InterfaceC0718h.a f8898c;

    /* renamed from: d, reason: collision with root package name */
    private int f8899d;

    /* renamed from: e, reason: collision with root package name */
    private com.bumptech.glide.load.c f8900e;

    /* renamed from: f, reason: collision with root package name */
    private List<com.bumptech.glide.load.b.u<File, ?>> f8901f;

    /* renamed from: g, reason: collision with root package name */
    private int f8902g;

    /* renamed from: h, reason: collision with root package name */
    private volatile u.a<?> f8903h;
    private File i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0715e(C0719i<?> c0719i, InterfaceC0718h.a aVar) {
        this(c0719i.c(), c0719i, aVar);
    }

    private boolean b() {
        return this.f8902g < this.f8901f.size();
    }

    @Override // com.bumptech.glide.load.engine.InterfaceC0718h
    public boolean a() {
        while (true) {
            boolean z = false;
            if (this.f8901f != null && b()) {
                this.f8903h = null;
                while (!z && b()) {
                    List<com.bumptech.glide.load.b.u<File, ?>> list = this.f8901f;
                    int i = this.f8902g;
                    this.f8902g = i + 1;
                    this.f8903h = list.get(i).a(this.i, this.f8897b.n(), this.f8897b.f(), this.f8897b.i());
                    if (this.f8903h != null && this.f8897b.c(this.f8903h.f8648c.a())) {
                        this.f8903h.f8648c.a(this.f8897b.j(), this);
                        z = true;
                    }
                }
                return z;
            }
            this.f8899d++;
            if (this.f8899d >= this.f8896a.size()) {
                return false;
            }
            com.bumptech.glide.load.c cVar = this.f8896a.get(this.f8899d);
            this.i = this.f8897b.d().a(new C0716f(cVar, this.f8897b.l()));
            File file = this.i;
            if (file != null) {
                this.f8900e = cVar;
                this.f8901f = this.f8897b.a(file);
                this.f8902g = 0;
            }
        }
    }

    @Override // com.bumptech.glide.load.engine.InterfaceC0718h
    public void cancel() {
        u.a<?> aVar = this.f8903h;
        if (aVar != null) {
            aVar.f8648c.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0715e(List<com.bumptech.glide.load.c> list, C0719i<?> c0719i, InterfaceC0718h.a aVar) {
        this.f8899d = -1;
        this.f8896a = list;
        this.f8897b = c0719i;
        this.f8898c = aVar;
    }

    @Override // com.bumptech.glide.load.a.d.a
    public void a(Object obj) {
        this.f8898c.a(this.f8900e, obj, this.f8903h.f8648c, DataSource.DATA_DISK_CACHE, this.f8900e);
    }

    @Override // com.bumptech.glide.load.a.d.a
    public void a(Exception exc) {
        this.f8898c.a(this.f8900e, exc, this.f8903h.f8648c, DataSource.DATA_DISK_CACHE);
    }
}
