package com.google.android.gms.ads.internal.request;

import android.content.Context;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.internal.zzan;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zzhs;
import com.google.android.gms.internal.zzhz;

@zzgr
/* loaded from: classes.dex */
public class zza {

    /* renamed from: com.google.android.gms.ads.internal.request.zza$zza */
    /* loaded from: classes.dex */
    public interface InterfaceC0027zza {
        void zza(zzhs.zza zzaVar);
    }

    public zzhz a(Context context, AdRequestInfoParcel.zza zzaVar, zzan zzanVar, InterfaceC0027zza interfaceC0027zza) {
        zzhz zzmVar = zzaVar.b.c.getBundle("sdk_less_server_data") != null ? new zzm(context, zzaVar, interfaceC0027zza) : new zzb(context, zzaVar, zzanVar, interfaceC0027zza);
        zzmVar.zzfu();
        return zzmVar;
    }
}
