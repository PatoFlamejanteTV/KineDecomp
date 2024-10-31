package com.google.android.gms.dynamic;

import com.google.android.gms.dynamic.zza;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements zza.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zza f1207a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(zza zzaVar) {
        this.f1207a = zzaVar;
    }

    @Override // com.google.android.gms.dynamic.zza.a
    public int a() {
        return 5;
    }

    @Override // com.google.android.gms.dynamic.zza.a
    public void a(LifecycleDelegate lifecycleDelegate) {
        LifecycleDelegate lifecycleDelegate2;
        lifecycleDelegate2 = this.f1207a.f1208a;
        lifecycleDelegate2.b();
    }
}
