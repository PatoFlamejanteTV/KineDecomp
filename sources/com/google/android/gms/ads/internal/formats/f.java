package com.google.android.gms.ads.internal.formats;

import com.google.android.gms.internal.zzdk;
import com.google.android.gms.internal.zziz;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements zzdk {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzh f569a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(zzh zzhVar) {
        this.f569a = zzhVar;
    }

    @Override // com.google.android.gms.internal.zzdk
    public void zza(zziz zzizVar, Map<String, String> map) {
        zziz zzizVar2;
        zzizVar2 = this.f569a.j;
        zzizVar2.getView().setVisibility(8);
    }
}
