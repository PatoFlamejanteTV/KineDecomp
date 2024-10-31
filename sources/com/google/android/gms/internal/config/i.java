package com.google.android.gms.internal.config;

import com.google.android.gms.common.api.Status;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class i extends f {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ h f12941a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.f12941a = hVar;
    }

    @Override // com.google.android.gms.internal.config.zzaf
    public final void zza(Status status, zzad zzadVar) {
        Status zzd;
        HashMap zza;
        Status zzd2;
        HashMap zza2;
        if (zzadVar.getStatusCode() != 6502 && zzadVar.getStatusCode() != 6507) {
            h hVar = this.f12941a;
            zzd2 = zzo.zzd(zzadVar.getStatusCode());
            zza2 = zzo.zza(zzadVar);
            hVar.a((h) new zzu(zzd2, zza2, zzo.zzb(zzadVar)));
            return;
        }
        h hVar2 = this.f12941a;
        zzd = zzo.zzd(zzadVar.getStatusCode());
        zza = zzo.zza(zzadVar);
        hVar2.a((h) new zzu(zzd, zza, zzadVar.getThrottleEndTimeMillis(), zzo.zzb(zzadVar)));
    }
}
