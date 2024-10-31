package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.DataLayer;
import java.util.List;

/* loaded from: classes.dex */
class at implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ DataLayer.zzc.zza f2222a;
    final /* synthetic */ ar b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(ar arVar, DataLayer.zzc.zza zzaVar) {
        this.b = arVar;
        this.f2222a = zzaVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        List<DataLayer.a> b;
        DataLayer.zzc.zza zzaVar = this.f2222a;
        b = this.b.b();
        zzaVar.a(b);
    }
}
