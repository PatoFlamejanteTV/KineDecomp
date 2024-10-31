package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.measurement.internal.ba, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class RunnableC1407ba implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ boolean f13748a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzda f13749b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1407ba(zzda zzdaVar, boolean z) {
        this.f13749b = zzdaVar;
        this.f13748a = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f13749b.d(this.f13748a);
    }
}
