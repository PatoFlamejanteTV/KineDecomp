package com.google.android.gms.dynamic;

import com.google.android.gms.dynamic.zza;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements zza.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zza f1206a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(zza zzaVar) {
        this.f1206a = zzaVar;
    }

    @Override // com.google.android.gms.dynamic.zza.a
    public int a() {
        return 4;
    }

    @Override // com.google.android.gms.dynamic.zza.a
    public void a(LifecycleDelegate lifecycleDelegate) {
        LifecycleDelegate lifecycleDelegate2;
        lifecycleDelegate2 = this.f1206a.f1208a;
        lifecycleDelegate2.a();
    }
}
