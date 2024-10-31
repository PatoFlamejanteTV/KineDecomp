package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class Rb implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ zzaph f11799a;

    public Rb(zzaph zzaphVar) {
        this.f11799a = zzaphVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f11799a.onStop();
    }
}
