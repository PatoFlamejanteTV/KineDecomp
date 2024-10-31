package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class Aa extends C1417ga {

    /* renamed from: b, reason: collision with root package name */
    private boolean f13607b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Aa(zzbw zzbwVar) {
        super(zzbwVar);
        this.f13672a.a(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean s() {
        return this.f13607b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void t() {
        if (!s()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void u() {
        if (!this.f13607b) {
            w();
            this.f13672a.D();
            this.f13607b = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }

    protected abstract boolean v();

    protected void w() {
    }

    public final void x() {
        if (!this.f13607b) {
            if (v()) {
                return;
            }
            this.f13672a.D();
            this.f13607b = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }
}
