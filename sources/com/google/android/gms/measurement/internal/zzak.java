package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzr;
import com.google.android.gms.internal.measurement.zzs;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class zzak extends zzr implements zzaj {
    public zzak() {
        super("com.google.android.gms.measurement.internal.IMeasurementService");
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                a((zzag) zzs.zza(parcel, zzag.CREATOR), (zzk) zzs.zza(parcel, zzk.CREATOR));
                parcel2.writeNoException();
                return true;
            case 2:
                a((zzfv) zzs.zza(parcel, zzfv.CREATOR), (zzk) zzs.zza(parcel, zzk.CREATOR));
                parcel2.writeNoException();
                return true;
            case 3:
            case 8:
            default:
                return false;
            case 4:
                a((zzk) zzs.zza(parcel, zzk.CREATOR));
                parcel2.writeNoException();
                return true;
            case 5:
                a((zzag) zzs.zza(parcel, zzag.CREATOR), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 6:
                c((zzk) zzs.zza(parcel, zzk.CREATOR));
                parcel2.writeNoException();
                return true;
            case 7:
                List<zzfv> a2 = a((zzk) zzs.zza(parcel, zzk.CREATOR), zzs.zza(parcel));
                parcel2.writeNoException();
                parcel2.writeTypedList(a2);
                return true;
            case 9:
                byte[] a3 = a((zzag) zzs.zza(parcel, zzag.CREATOR), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeByteArray(a3);
                return true;
            case 10:
                a(parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 11:
                String d2 = d((zzk) zzs.zza(parcel, zzk.CREATOR));
                parcel2.writeNoException();
                parcel2.writeString(d2);
                return true;
            case 12:
                a((zzo) zzs.zza(parcel, zzo.CREATOR), (zzk) zzs.zza(parcel, zzk.CREATOR));
                parcel2.writeNoException();
                return true;
            case 13:
                a((zzo) zzs.zza(parcel, zzo.CREATOR));
                parcel2.writeNoException();
                return true;
            case 14:
                List<zzfv> a4 = a(parcel.readString(), parcel.readString(), zzs.zza(parcel), (zzk) zzs.zza(parcel, zzk.CREATOR));
                parcel2.writeNoException();
                parcel2.writeTypedList(a4);
                return true;
            case 15:
                List<zzfv> a5 = a(parcel.readString(), parcel.readString(), parcel.readString(), zzs.zza(parcel));
                parcel2.writeNoException();
                parcel2.writeTypedList(a5);
                return true;
            case 16:
                List<zzo> a6 = a(parcel.readString(), parcel.readString(), (zzk) zzs.zza(parcel, zzk.CREATOR));
                parcel2.writeNoException();
                parcel2.writeTypedList(a6);
                return true;
            case 17:
                List<zzo> a7 = a(parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeTypedList(a7);
                return true;
            case 18:
                b((zzk) zzs.zza(parcel, zzk.CREATOR));
                parcel2.writeNoException();
                return true;
        }
    }
}
