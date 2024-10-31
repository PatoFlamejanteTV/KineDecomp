package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.ads.m */
/* loaded from: classes2.dex */
public final class C0992m implements com.google.android.gms.ads.internal.gmsg.zzu<Object> {

    /* renamed from: a */
    private final /* synthetic */ zzabn f12318a;

    public C0992m(zzabn zzabnVar) {
        this.f12318a = zzabnVar;
    }

    @Override // com.google.android.gms.ads.internal.gmsg.zzu
    public final void zza(Object obj, Map<String, String> map) {
        zzaet zzaetVar;
        zzaet zzaetVar2;
        try {
            this.f12318a.zzdal = Long.valueOf(Long.parseLong(map.get("timestamp")));
        } catch (NumberFormatException unused) {
            zzbbd.e("Failed to call parse unconfirmedClickTimestamp.");
        }
        this.f12318a.zzdak = map.get("id");
        String str = map.get("asset_id");
        zzaetVar = this.f12318a.zzdai;
        if (zzaetVar == null) {
            zzbbd.zzdn("Received unconfirmed click but UnconfirmedClickListener is null.");
            return;
        }
        try {
            zzaetVar2 = this.f12318a.zzdai;
            zzaetVar2.onUnconfirmedClickReceived(str);
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
        }
    }
}
