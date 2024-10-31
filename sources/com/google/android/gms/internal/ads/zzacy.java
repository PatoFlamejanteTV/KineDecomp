package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class zzacy extends zzex implements zzacx {
    public zzacy() {
        super("com.google.android.gms.ads.internal.formats.client.IAttributionInfo");
    }

    public static zzacx zzi(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IAttributionInfo");
        if (queryLocalInterface instanceof zzacx) {
            return (zzacx) queryLocalInterface;
        }
        return new zzacz(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzex
    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 2) {
            String text = getText();
            parcel2.writeNoException();
            parcel2.writeString(text);
            return true;
        }
        if (i != 3) {
            return false;
        }
        List<zzadb> zzro = zzro();
        parcel2.writeNoException();
        parcel2.writeList(zzro);
        return true;
    }
}
