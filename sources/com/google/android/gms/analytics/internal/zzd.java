package com.google.android.gms.analytics.internal;

/* loaded from: classes.dex */
public abstract class zzd extends zzc {

    /* renamed from: a */
    private boolean f739a;
    private boolean b;

    public zzd(zzf zzfVar) {
        super(zzfVar);
    }

    public boolean C() {
        return this.f739a && !this.b;
    }

    public void D() {
        if (!C()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public void E() {
        a();
        this.f739a = true;
    }

    protected abstract void a();
}
