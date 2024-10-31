package com.google.android.gms.dynamic;

import android.os.Bundle;
import com.google.android.gms.dynamic.zza;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements zza.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Bundle f1203a;
    final /* synthetic */ zza b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(zza zzaVar, Bundle bundle) {
        this.b = zzaVar;
        this.f1203a = bundle;
    }

    @Override // com.google.android.gms.dynamic.zza.a
    public int a() {
        return 1;
    }

    @Override // com.google.android.gms.dynamic.zza.a
    public void a(LifecycleDelegate lifecycleDelegate) {
        LifecycleDelegate lifecycleDelegate2;
        lifecycleDelegate2 = this.b.f1208a;
        lifecycleDelegate2.a(this.f1203a);
    }
}
