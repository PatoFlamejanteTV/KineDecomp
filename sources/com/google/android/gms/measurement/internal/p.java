package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class P extends O {

    /* renamed from: b, reason: collision with root package name */
    private boolean f13674b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public P(zzbw zzbwVar) {
        super(zzbwVar);
        this.f13672a.a(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean k() {
        return this.f13674b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void l() {
        if (!k()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void m() {
        if (!this.f13674b) {
            o();
            this.f13672a.D();
            this.f13674b = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }

    protected abstract boolean n();

    protected void o() {
    }

    public final void p() {
        if (!this.f13674b) {
            if (n()) {
                return;
            }
            this.f13672a.D();
            this.f13674b = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }
}
