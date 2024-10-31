package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.concurrent.Future;

@zzgr
/* loaded from: classes.dex */
public class zzbc {
    /* JADX INFO: Access modifiers changed from: private */
    public zzbb zza(Context context, VersionInfoParcel versionInfoParcel, zzin<zzbb> zzinVar, zzan zzanVar) {
        zzbd zzbdVar = new zzbd(context, versionInfoParcel, zzanVar);
        zzbdVar.zza(new o(this, zzinVar, zzbdVar));
        return zzbdVar;
    }

    public Future<zzbb> zza(Context context, VersionInfoParcel versionInfoParcel, String str, zzan zzanVar) {
        zzin zzinVar = new zzin();
        zzid.zzIE.post(new n(this, context, versionInfoParcel, zzinVar, zzanVar, str));
        return zzinVar;
    }
}
