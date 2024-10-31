package com.bumptech.glide.request;

/* compiled from: ThumbnailRequestCoordinator.java */
/* loaded from: classes.dex */
public class i implements d, c {

    /* renamed from: a */
    private final d f9110a;

    /* renamed from: b */
    private c f9111b;

    /* renamed from: c */
    private c f9112c;

    /* renamed from: d */
    private boolean f9113d;

    i() {
        this(null);
    }

    private boolean g() {
        d dVar = this.f9110a;
        return dVar == null || dVar.f(this);
    }

    private boolean h() {
        d dVar = this.f9110a;
        return dVar == null || dVar.b(this);
    }

    private boolean i() {
        d dVar = this.f9110a;
        return dVar == null || dVar.c(this);
    }

    private boolean j() {
        d dVar = this.f9110a;
        return dVar != null && dVar.d();
    }

    public void a(c cVar, c cVar2) {
        this.f9111b = cVar;
        this.f9112c = cVar2;
    }

    @Override // com.bumptech.glide.request.d
    public boolean b(c cVar) {
        return h() && cVar.equals(this.f9111b) && !d();
    }

    @Override // com.bumptech.glide.request.d
    public boolean c(c cVar) {
        return i() && (cVar.equals(this.f9111b) || !this.f9111b.c());
    }

    @Override // com.bumptech.glide.request.c
    public void clear() {
        this.f9113d = false;
        this.f9112c.clear();
        this.f9111b.clear();
    }

    @Override // com.bumptech.glide.request.d
    public boolean d() {
        return j() || c();
    }

    @Override // com.bumptech.glide.request.d
    public void e(c cVar) {
        if (cVar.equals(this.f9112c)) {
            return;
        }
        d dVar = this.f9110a;
        if (dVar != null) {
            dVar.e(this);
        }
        if (this.f9112c.isComplete()) {
            return;
        }
        this.f9112c.clear();
    }

    @Override // com.bumptech.glide.request.d
    public boolean f(c cVar) {
        return g() && cVar.equals(this.f9111b);
    }

    @Override // com.bumptech.glide.request.c
    public boolean isComplete() {
        return this.f9111b.isComplete() || this.f9112c.isComplete();
    }

    @Override // com.bumptech.glide.request.c
    public boolean isRunning() {
        return this.f9111b.isRunning();
    }

    public i(d dVar) {
        this.f9110a = dVar;
    }

    @Override // com.bumptech.glide.request.c
    public void b() {
        this.f9111b.b();
        this.f9112c.b();
    }

    @Override // com.bumptech.glide.request.c
    public boolean c() {
        return this.f9111b.c() || this.f9112c.c();
    }

    @Override // com.bumptech.glide.request.d
    public void d(c cVar) {
        d dVar;
        if (cVar.equals(this.f9111b) && (dVar = this.f9110a) != null) {
            dVar.d(this);
        }
    }

    @Override // com.bumptech.glide.request.c
    public boolean f() {
        return this.f9111b.f();
    }

    @Override // com.bumptech.glide.request.c
    public void a() {
        this.f9113d = true;
        if (!this.f9111b.isComplete() && !this.f9112c.isRunning()) {
            this.f9112c.a();
        }
        if (!this.f9113d || this.f9111b.isRunning()) {
            return;
        }
        this.f9111b.a();
    }

    @Override // com.bumptech.glide.request.c
    public boolean e() {
        return this.f9111b.e();
    }

    @Override // com.bumptech.glide.request.c
    public boolean a(c cVar) {
        if (!(cVar instanceof i)) {
            return false;
        }
        i iVar = (i) cVar;
        c cVar2 = this.f9111b;
        if (cVar2 == null) {
            if (iVar.f9111b != null) {
                return false;
            }
        } else if (!cVar2.a(iVar.f9111b)) {
            return false;
        }
        c cVar3 = this.f9112c;
        if (cVar3 == null) {
            if (iVar.f9112c != null) {
                return false;
            }
        } else if (!cVar3.a(iVar.f9112c)) {
            return false;
        }
        return true;
    }
}
