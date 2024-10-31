package com.google.android.gms.internal;

import com.google.android.gms.cast.games.GameManagerClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzko;
import java.util.Locale;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ff implements com.google.android.gms.cast.internal.zzo {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzko f1551a;
    final /* synthetic */ zzko.zzc b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ff(zzko.zzc zzcVar, zzko zzkoVar) {
        this.b = zzcVar;
        this.f1551a = zzkoVar;
    }

    @Override // com.google.android.gms.cast.internal.zzo
    public void a(long j) {
        this.b.zzb((zzko.zzc) this.b.zzb(new Status(2103)));
    }

    @Override // com.google.android.gms.cast.internal.zzo
    public void a(long j, int i, Object obj) {
        GameManagerClient gameManagerClient;
        GameManagerClient gameManagerClient2;
        try {
            if (obj == null) {
                zzko.zzc zzcVar = this.b;
                Status status = new Status(i, null, null);
                gameManagerClient2 = this.b.zzYd;
                zzcVar.zzb((zzko.zzc) new zzko.a(status, gameManagerClient2));
            } else {
                zzkq zzkqVar = (zzkq) obj;
                zzkp zzmN = zzkqVar.zzmN();
                if (zzmN == null || com.google.android.gms.cast.internal.zzf.a("1.0.0", zzmN.getVersion())) {
                    zzko.zzc zzcVar2 = this.b;
                    Status status2 = new Status(i, zzkqVar.zzmJ(), null);
                    gameManagerClient = this.b.zzYd;
                    zzcVar2.zzb((zzko.zzc) new zzko.a(status2, gameManagerClient));
                } else {
                    this.b.zzb((zzko.zzc) this.b.zzb(new Status(2150, String.format(Locale.ROOT, "Incorrect Game Manager SDK version. Receiver: %s Sender: %s", zzmN.getVersion(), "1.0.0"))));
                    zzko.this.zzXM = null;
                }
            }
        } catch (ClassCastException e) {
            this.b.zzb((zzko.zzc) this.b.zzb(new Status(13)));
        }
    }
}
