package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class Oa implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzajm f11725a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzaii f11726b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ zzait f11727c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Oa(zzait zzaitVar, zzajm zzajmVar, zzaii zzaiiVar) {
        this.f11727c = zzaitVar;
        this.f11725a = zzajmVar;
        this.f11726b = zzaiiVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        obj = this.f11727c.mLock;
        synchronized (obj) {
            if (this.f11725a.getStatus() != -1 && this.f11725a.getStatus() != 1) {
                this.f11725a.reject();
                Executor executor = zzbcg.zzepo;
                zzaii zzaiiVar = this.f11726b;
                zzaiiVar.getClass();
                executor.execute(Pa.a(zzaiiVar));
                zzaxz.v("Could not receive loaded message in a timely manner. Rejecting.");
            }
        }
    }
}
