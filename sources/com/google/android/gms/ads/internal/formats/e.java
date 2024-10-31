package com.google.android.gms.ads.internal.formats;

import com.google.android.gms.internal.zzdk;
import com.google.android.gms.internal.zziz;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements zzdk {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzh f568a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(zzh zzhVar) {
        this.f568a = zzhVar;
    }

    @Override // com.google.android.gms.internal.zzdk
    public void zza(zziz zzizVar, Map<String, String> map) {
        zziz zzizVar2;
        zzizVar2 = this.f568a.j;
        zzizVar2.getView().setVisibility(8);
    }
}
