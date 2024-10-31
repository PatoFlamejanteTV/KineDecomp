package com.google.android.gms.measurement.internal;

/* loaded from: classes.dex */
public abstract class ac extends ab {

    /* renamed from: a */
    private boolean f2024a;
    private boolean b;
    private boolean c;

    public ac(zzv zzvVar) {
        super(zzvVar);
        this.g.a(this);
    }

    protected abstract void a();

    public boolean v() {
        return this.f2024a && !this.b;
    }

    public boolean w() {
        return this.c;
    }

    public void x() {
        if (!v()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void y() {
        if (this.f2024a) {
            throw new IllegalStateException("Can't initialize twice");
        }
        a();
        this.g.x();
        this.f2024a = true;
    }
}
