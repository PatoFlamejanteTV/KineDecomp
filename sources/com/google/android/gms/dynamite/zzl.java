package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.common.zza;
import com.google.android.gms.internal.common.zzc;

/* loaded from: classes.dex */
public final class zzl extends zza implements zzk {
    public zzl(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoaderV2");
    }

    @Override // com.google.android.gms.dynamite.zzk
    public final IObjectWrapper a(IObjectWrapper iObjectWrapper, String str, int i, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, iObjectWrapper);
        zza.writeString(str);
        zza.writeInt(i);
        zzc.zza(zza, iObjectWrapper2);
        Parcel zza2 = zza(2, zza);
        IObjectWrapper a2 = IObjectWrapper.Stub.a(zza2.readStrongBinder());
        zza2.recycle();
        return a2;
    }

    @Override // com.google.android.gms.dynamite.zzk
    public final IObjectWrapper b(IObjectWrapper iObjectWrapper, String str, int i, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, iObjectWrapper);
        zza.writeString(str);
        zza.writeInt(i);
        zzc.zza(zza, iObjectWrapper2);
        Parcel zza2 = zza(3, zza);
        IObjectWrapper a2 = IObjectWrapper.Stub.a(zza2.readStrongBinder());
        zza2.recycle();
        return a2;
    }
}
