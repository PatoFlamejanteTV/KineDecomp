package com.google.firebase.dynamiclinks.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public final class zzp extends com.google.android.gms.internal.firebase_dynamic_links.zza implements zzo {
    public zzp(IBinder iBinder) {
        super(iBinder, "com.google.firebase.dynamiclinks.internal.IDynamicLinksService");
    }

    @Override // com.google.firebase.dynamiclinks.internal.zzo
    public final void a(zzm zzmVar, String str) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.firebase_dynamic_links.zzc.zza(zza, zzmVar);
        zza.writeString(str);
        zza(1, zza);
    }
}
