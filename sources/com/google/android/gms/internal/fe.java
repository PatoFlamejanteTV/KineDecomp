package com.google.android.gms.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzko;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fe implements com.google.android.gms.cast.internal.zzo {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzko f1550a;
    final /* synthetic */ zzko.zza b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fe(zzko.zza zzaVar, zzko zzkoVar) {
        this.b = zzaVar;
        this.f1550a = zzkoVar;
    }

    @Override // com.google.android.gms.cast.internal.zzo
    public void a(long j) {
        this.b.zzb((zzko.zza) this.b.zzb(new Status(2103)));
    }

    @Override // com.google.android.gms.cast.internal.zzo
    public void a(long j, int i, Object obj) {
        try {
            if (obj == null) {
                this.b.zzb((zzko.zza) new zzko.b(new Status(i, null, null), null, j, null));
                return;
            }
            zzkq zzkqVar = (zzkq) obj;
            String playerId = zzkqVar.getPlayerId();
            if (i == 0 && playerId != null) {
                zzko.this.zzXU = playerId;
            }
            this.b.zzb((zzko.zza) new zzko.b(new Status(i, zzkqVar.zzmJ(), null), playerId, zzkqVar.getRequestId(), zzkqVar.getExtraMessageData()));
        } catch (ClassCastException e) {
            this.b.zzb((zzko.zza) this.b.zzb(new Status(13)));
        }
    }
}
