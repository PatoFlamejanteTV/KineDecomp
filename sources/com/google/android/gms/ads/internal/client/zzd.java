package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.client.zzr;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.internal.zzel;
import com.google.android.gms.internal.zzgr;

@zzgr
/* loaded from: classes.dex */
public final class zzd extends com.google.android.gms.dynamic.zzg<zzr> {

    /* renamed from: a, reason: collision with root package name */
    private static final zzd f540a = new zzd();

    private zzd() {
        super("com.google.android.gms.ads.AdLoaderBuilderCreatorImpl");
    }

    public static zzq a(Context context, String str, zzel zzelVar) {
        zzq b;
        if (zzl.a().b(context) && (b = f540a.b(context, str, zzelVar)) != null) {
            return b;
        }
        com.google.android.gms.ads.internal.util.client.zzb.a("Using AdLoader from the client jar.");
        return new com.google.android.gms.ads.internal.zzj(context, str, zzelVar, new VersionInfoParcel(8115000, 8115000, true));
    }

    private zzq b(Context context, String str, zzel zzelVar) {
        try {
            return zzq.zza.a(zzas(context).a(com.google.android.gms.dynamic.zze.a(context), str, zzelVar, 8115000));
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Could not create remote builder for AdLoader.", e);
            return null;
        } catch (zzg.zza e2) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Could not create remote builder for AdLoader.", e2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.dynamic.zzg
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public zzr zzd(IBinder iBinder) {
        return zzr.zza.a(iBinder);
    }
}
