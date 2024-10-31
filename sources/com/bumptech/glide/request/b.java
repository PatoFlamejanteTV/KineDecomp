package com.bumptech.glide.request;

/* compiled from: ErrorRequestCoordinator.java */
/* loaded from: classes.dex */
public final class b implements d, c {

    /* renamed from: a */
    private final d f9095a;

    /* renamed from: b */
    private c f9096b;

    /* renamed from: c */
    private c f9097c;

    public b(d dVar) {
        this.f9095a = dVar;
    }

    private boolean g() {
        d dVar = this.f9095a;
        return dVar == null || dVar.f(this);
    }

    private boolean h() {
        d dVar = this.f9095a;
        return dVar == null || dVar.b(this);
    }

    private boolean i() {
        d dVar = this.f9095a;
        return dVar == null || dVar.c(this);
    }

    private boolean j() {
        d dVar = this.f9095a;
        return dVar != null && dVar.d();
    }

    public void a(c cVar, c cVar2) {
        this.f9096b = cVar;
        this.f9097c = cVar2;
    }

    @Override // com.bumptech.glide.request.c
    public void b() {
        this.f9096b.b();
        this.f9097c.b();
    }

    @Override // com.bumptech.glide.request.c
    public boolean c() {
        return (this.f9096b.e() ? this.f9097c : this.f9096b).c();
    }

    @Override // com.bumptech.glide.request.c
    public void clear() {
        this.f9096b.clear();
        if (this.f9097c.isRunning()) {
            this.f9097c.clear();
        }
    }

    @Override // com.bumptech.glide.request.d
    public boolean d() {
        return j() || c();
    }

    @Override // com.bumptech.glide.request.c
    public boolean e() {
        return this.f9096b.e() && this.f9097c.e();
    }

    @Override // com.bumptech.glide.request.c
    public boolean f() {
        return (this.f9096b.e() ? this.f9097c : this.f9096b).f();
    }

    @Override // com.bumptech.glide.request.c
    public boolean isComplete() {
        return (this.f9096b.e() ? this.f9097c : this.f9096b).isComplete();
    }

    @Override // com.bumptech.glide.request.c
    public boolean isRunning() {
        return (this.f9096b.e() ? this.f9097c : this.f9096b).isRunning();
    }

    private boolean g(c cVar) {
        return cVar.equals(this.f9096b) || (this.f9096b.e() && cVar.equals(this.f9097c));
    }

    @Override // com.bumptech.glide.request.d
    public boolean c(c cVar) {
        return i() && g(cVar);
    }

    @Override // com.bumptech.glide.request.d
    public void d(c cVar) {
        if (!cVar.equals(this.f9097c)) {
            if (this.f9097c.isRunning()) {
                return;
            }
            this.f9097c.a();
        } else {
            d dVar = this.f9095a;
            if (dVar != null) {
                dVar.d(this);
            }
        }
    }

    @Override // com.bumptech.glide.request.d
    public void e(c cVar) {
        d dVar = this.f9095a;
        if (dVar != null) {
            dVar.e(this);
        }
    }

    @Override // com.bumptech.glide.request.d
    public boolean f(c cVar) {
        return g() && g(cVar);
    }

    @Override // com.bumptech.glide.request.c
    public void a() {
        if (this.f9096b.isRunning()) {
            return;
        }
        this.f9096b.a();
    }

    @Override // com.bumptech.glide.request.d
    public boolean b(c cVar) {
        return h() && g(cVar);
    }

    @Override // com.bumptech.glide.request.c
    public boolean a(c cVar) {
        if (!(cVar instanceof b)) {
            return false;
        }
        b bVar = (b) cVar;
        return this.f9096b.a(bVar.f9096b) && this.f9097c.a(bVar.f9097c);
    }
}
