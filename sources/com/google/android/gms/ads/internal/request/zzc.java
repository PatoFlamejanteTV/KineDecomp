package com.google.android.gms.ads.internal.request;

import android.content.Context;
import com.google.android.gms.ads.internal.request.zzd;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zzhz;

@zzgr
/* loaded from: classes.dex */
public final class zzc {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        boolean a(AdRequestInfoParcel adRequestInfoParcel);
    }

    /* loaded from: classes.dex */
    public interface zza {
        void a(AdResponseParcel adResponseParcel);
    }

    public static zzhz a(Context context, AdRequestInfoParcel adRequestInfoParcel, zza zzaVar) {
        return a(context, adRequestInfoParcel, zzaVar, new c(context));
    }

    static zzhz a(Context context, AdRequestInfoParcel adRequestInfoParcel, zza zzaVar, a aVar) {
        return aVar.a(adRequestInfoParcel) ? b(context, adRequestInfoParcel, zzaVar) : c(context, adRequestInfoParcel, zzaVar);
    }

    private static zzhz b(Context context, AdRequestInfoParcel adRequestInfoParcel, zza zzaVar) {
        com.google.android.gms.ads.internal.util.client.zzb.a("Fetching ad response from local ad request service.");
        zzd.zza zzaVar2 = new zzd.zza(context, adRequestInfoParcel, zzaVar);
        zzaVar2.zzfu();
        return zzaVar2;
    }

    private static zzhz c(Context context, AdRequestInfoParcel adRequestInfoParcel, zza zzaVar) {
        com.google.android.gms.ads.internal.util.client.zzb.a("Fetching ad response from remote ad request service.");
        if (com.google.android.gms.ads.internal.client.zzl.a().b(context)) {
            return new zzd.zzb(context, adRequestInfoParcel, zzaVar);
        }
        com.google.android.gms.ads.internal.util.client.zzb.e("Failed to connect to remote ad request service.");
        return null;
    }
}
