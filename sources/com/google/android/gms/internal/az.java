package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.zzdz;

/* loaded from: classes.dex */
public class az implements Runnable {

    /* renamed from: a */
    final /* synthetic */ zzdz.zze f1440a;
    final /* synthetic */ zzdz b;

    public az(zzdz zzdzVar, zzdz.zze zzeVar) {
        this.b = zzdzVar;
        this.f1440a = zzeVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        VersionInfoParcel versionInfoParcel;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        zzdz zzdzVar = this.b;
        context = this.b.mContext;
        versionInfoParcel = this.b.zzpb;
        zzbb zza = zzdzVar.zza(context, versionInfoParcel);
        zza.zza(new ba(this, zza));
        zza.zza("/jsLoaded", new bd(this, zza));
        zzil zzilVar = new zzil();
        be beVar = new be(this, zza, zzilVar);
        zzilVar.set(beVar);
        zza.zza("/requestReload", beVar);
        str = this.b.zzyo;
        if (str.endsWith(".js")) {
            str5 = this.b.zzyo;
            zza.zzs(str5);
        } else {
            str2 = this.b.zzyo;
            if (str2.startsWith("<html>")) {
                str4 = this.b.zzyo;
                zza.zzu(str4);
            } else {
                str3 = this.b.zzyo;
                zza.zzt(str3);
            }
        }
        zzid.zzIE.postDelayed(new bf(this, zza), zzdz.a.f1704a);
    }
}
