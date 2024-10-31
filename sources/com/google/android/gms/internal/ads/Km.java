package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class Km implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ zztq f11650a;

    public Km(zztq zztqVar) {
        this.f11650a = zztqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f11650a.disconnect();
    }
}
