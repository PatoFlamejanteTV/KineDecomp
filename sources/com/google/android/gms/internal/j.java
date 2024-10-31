package com.google.android.gms.internal;

import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements zzdk {

    /* renamed from: a */
    final /* synthetic */ zzaz f1642a;

    public j(zzaz zzazVar) {
        this.f1642a = zzazVar;
    }

    @Override // com.google.android.gms.internal.zzdk
    public void zza(zziz zzizVar, Map<String, String> map) {
        if (this.f1642a.zzb(map)) {
            this.f1642a.zza(zzizVar.getView(), map);
        }
    }
}
