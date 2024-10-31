package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class La extends Ka {

    /* renamed from: c, reason: collision with root package name */
    private boolean f13660c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public La(zzfo zzfoVar) {
        super(zzfoVar);
        this.f13657b.a(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean n() {
        return this.f13660c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void o() {
        if (!n()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    protected abstract boolean p();

    public final void q() {
        if (!this.f13660c) {
            p();
            this.f13657b.o();
            this.f13660c = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }
}
