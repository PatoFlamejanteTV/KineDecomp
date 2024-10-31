package com.google.android.gms.internal.ads;

import java.io.IOException;

/* renamed from: com.google.android.gms.internal.ads.sl, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class RunnableC1087sl implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ IOException f12534a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ C1032ol f12535b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1087sl(C1032ol c1032ol, IOException iOException) {
        this.f12535b = c1032ol;
        this.f12534a = iOException;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzll zzllVar;
        zzllVar = this.f12535b.f12402e;
        zzllVar.zzb(this.f12534a);
    }
}
