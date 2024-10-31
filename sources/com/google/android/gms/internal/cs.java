package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.zzip;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cs implements zzip.zza<List<com.google.android.gms.ads.internal.formats.zzc>, com.google.android.gms.ads.internal.formats.zza> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f1485a;
    final /* synthetic */ Integer b;
    final /* synthetic */ Integer c;
    final /* synthetic */ int d;
    final /* synthetic */ int e;
    final /* synthetic */ int f;
    final /* synthetic */ zzgm g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cs(zzgm zzgmVar, String str, Integer num, Integer num2, int i, int i2, int i3) {
        this.g = zzgmVar;
        this.f1485a = str;
        this.b = num;
        this.c = num2;
        this.d = i;
        this.e = i2;
        this.f = i3;
    }

    @Override // com.google.android.gms.internal.zzip.zza
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public com.google.android.gms.ads.internal.formats.zza zze(List<com.google.android.gms.ads.internal.formats.zzc> list) {
        com.google.android.gms.ads.internal.formats.zza zzaVar;
        List zzd;
        if (list != null) {
            try {
                if (!list.isEmpty()) {
                    String str = this.f1485a;
                    zzd = zzgm.zzd((List<com.google.android.gms.ads.internal.formats.zzc>) list);
                    zzaVar = new com.google.android.gms.ads.internal.formats.zza(str, zzd, this.b, this.c, this.d > 0 ? Integer.valueOf(this.d) : null, this.e + this.f);
                    return zzaVar;
                }
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzb.b("Could not get attribution icon", e);
                return null;
            }
        }
        zzaVar = null;
        return zzaVar;
    }
}
