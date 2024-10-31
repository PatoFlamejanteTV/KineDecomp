package com.google.android.gms.internal;

import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.games.GameManagerClient;
import com.google.android.gms.internal.zzko;
import java.io.IOException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ez extends zzko.zzc {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzko f1544a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ez(zzko zzkoVar, GameManagerClient gameManagerClient) {
        super(gameManagerClient);
        this.f1544a = zzkoVar;
    }

    @Override // com.google.android.gms.internal.zzko.zzb
    public void execute() {
        Cast.CastApi castApi;
        try {
            castApi = this.f1544a.zzXK;
            castApi.a(this.f1544a.zzXL, this.f1544a.getNamespace(), new fa(this));
            this.f1544a.zzmE();
            this.f1544a.zzmD();
            this.f1544a.zza((String) null, 1100, (JSONObject) null, zzmG());
        } catch (IOException | IllegalStateException e) {
            zzmG().a(-1L, 8, null);
        }
    }
}
