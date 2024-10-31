package com.google.android.gms.dynamic;

import android.app.Activity;
import android.os.Bundle;
import com.google.android.gms.dynamic.zza;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements zza.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Activity f1202a;
    final /* synthetic */ Bundle b;
    final /* synthetic */ Bundle c;
    final /* synthetic */ zza d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(zza zzaVar, Activity activity, Bundle bundle, Bundle bundle2) {
        this.d = zzaVar;
        this.f1202a = activity;
        this.b = bundle;
        this.c = bundle2;
    }

    @Override // com.google.android.gms.dynamic.zza.a
    public int a() {
        return 0;
    }

    @Override // com.google.android.gms.dynamic.zza.a
    public void a(LifecycleDelegate lifecycleDelegate) {
        LifecycleDelegate lifecycleDelegate2;
        lifecycleDelegate2 = this.d.f1208a;
        lifecycleDelegate2.a(this.f1202a, this.b, this.c);
    }
}
