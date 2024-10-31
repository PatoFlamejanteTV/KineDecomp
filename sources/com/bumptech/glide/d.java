package com.bumptech.glide;

import android.content.Context;
import android.support.v4.util.ArrayMap;
import com.bumptech.glide.c.n;
import com.bumptech.glide.load.engine.b.a;
import com.bumptech.glide.load.engine.b.j;
import com.bumptech.glide.load.engine.s;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: GlideBuilder.java */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: b, reason: collision with root package name */
    private s f8452b;

    /* renamed from: c, reason: collision with root package name */
    private com.bumptech.glide.load.engine.a.e f8453c;

    /* renamed from: d, reason: collision with root package name */
    private com.bumptech.glide.load.engine.a.b f8454d;

    /* renamed from: e, reason: collision with root package name */
    private com.bumptech.glide.load.engine.b.i f8455e;

    /* renamed from: f, reason: collision with root package name */
    private com.bumptech.glide.load.engine.c.b f8456f;

    /* renamed from: g, reason: collision with root package name */
    private com.bumptech.glide.load.engine.c.b f8457g;

    /* renamed from: h, reason: collision with root package name */
    private a.InterfaceC0055a f8458h;
    private com.bumptech.glide.load.engine.b.j i;
    private com.bumptech.glide.c.d j;
    private n.a m;
    private com.bumptech.glide.load.engine.c.b n;
    private boolean o;
    private List<com.bumptech.glide.request.e<Object>> p;
    private boolean q;

    /* renamed from: a, reason: collision with root package name */
    private final Map<Class<?>, k<?, ?>> f8451a = new ArrayMap();
    private int k = 4;
    private com.bumptech.glide.request.f l = new com.bumptech.glide.request.f();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(n.a aVar) {
        this.m = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c a(Context context) {
        if (this.f8456f == null) {
            this.f8456f = com.bumptech.glide.load.engine.c.b.d();
        }
        if (this.f8457g == null) {
            this.f8457g = com.bumptech.glide.load.engine.c.b.c();
        }
        if (this.n == null) {
            this.n = com.bumptech.glide.load.engine.c.b.b();
        }
        if (this.i == null) {
            this.i = new j.a(context).a();
        }
        if (this.j == null) {
            this.j = new com.bumptech.glide.c.g();
        }
        if (this.f8453c == null) {
            int b2 = this.i.b();
            if (b2 > 0) {
                this.f8453c = new com.bumptech.glide.load.engine.a.k(b2);
            } else {
                this.f8453c = new com.bumptech.glide.load.engine.a.f();
            }
        }
        if (this.f8454d == null) {
            this.f8454d = new com.bumptech.glide.load.engine.a.j(this.i.a());
        }
        if (this.f8455e == null) {
            this.f8455e = new com.bumptech.glide.load.engine.b.h(this.i.c());
        }
        if (this.f8458h == null) {
            this.f8458h = new com.bumptech.glide.load.engine.b.g(context);
        }
        if (this.f8452b == null) {
            this.f8452b = new s(this.f8455e, this.f8458h, this.f8457g, this.f8456f, com.bumptech.glide.load.engine.c.b.e(), com.bumptech.glide.load.engine.c.b.b(), this.o);
        }
        List<com.bumptech.glide.request.e<Object>> list = this.p;
        if (list == null) {
            this.p = Collections.emptyList();
        } else {
            this.p = Collections.unmodifiableList(list);
        }
        n nVar = new n(this.m);
        s sVar = this.f8452b;
        com.bumptech.glide.load.engine.b.i iVar = this.f8455e;
        com.bumptech.glide.load.engine.a.e eVar = this.f8453c;
        com.bumptech.glide.load.engine.a.b bVar = this.f8454d;
        com.bumptech.glide.c.d dVar = this.j;
        int i = this.k;
        com.bumptech.glide.request.f fVar = this.l;
        fVar.C();
        return new c(context, sVar, iVar, eVar, bVar, nVar, dVar, i, fVar, this.f8451a, this.p, this.q);
    }
}
