package com.google.android.gms.ads.internal.overlay;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.zzaq;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.ads.zzbbi;

/* loaded from: classes.dex */
public final class zzm implements Parcelable.Creator<AdOverlayInfoParcel> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ AdOverlayInfoParcel createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        zzc zzcVar = null;
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        IBinder iBinder4 = null;
        String str = null;
        String str2 = null;
        IBinder iBinder5 = null;
        String str3 = null;
        zzbbi zzbbiVar = null;
        String str4 = null;
        zzaq zzaqVar = null;
        IBinder iBinder6 = null;
        boolean z = false;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a2)) {
                case 2:
                    zzcVar = (zzc) SafeParcelReader.a(parcel, a2, zzc.CREATOR);
                    break;
                case 3:
                    iBinder = SafeParcelReader.z(parcel, a2);
                    break;
                case 4:
                    iBinder2 = SafeParcelReader.z(parcel, a2);
                    break;
                case 5:
                    iBinder3 = SafeParcelReader.z(parcel, a2);
                    break;
                case 6:
                    iBinder4 = SafeParcelReader.z(parcel, a2);
                    break;
                case 7:
                    str = SafeParcelReader.p(parcel, a2);
                    break;
                case 8:
                    z = SafeParcelReader.t(parcel, a2);
                    break;
                case 9:
                    str2 = SafeParcelReader.p(parcel, a2);
                    break;
                case 10:
                    iBinder5 = SafeParcelReader.z(parcel, a2);
                    break;
                case 11:
                    i = SafeParcelReader.A(parcel, a2);
                    break;
                case 12:
                    i2 = SafeParcelReader.A(parcel, a2);
                    break;
                case 13:
                    str3 = SafeParcelReader.p(parcel, a2);
                    break;
                case 14:
                    zzbbiVar = (zzbbi) SafeParcelReader.a(parcel, a2, zzbbi.CREATOR);
                    break;
                case 15:
                default:
                    SafeParcelReader.F(parcel, a2);
                    break;
                case 16:
                    str4 = SafeParcelReader.p(parcel, a2);
                    break;
                case 17:
                    zzaqVar = (zzaq) SafeParcelReader.a(parcel, a2, zzaq.CREATOR);
                    break;
                case 18:
                    iBinder6 = SafeParcelReader.z(parcel, a2);
                    break;
            }
        }
        SafeParcelReader.s(parcel, b2);
        return new AdOverlayInfoParcel(zzcVar, iBinder, iBinder2, iBinder3, iBinder4, str, z, str2, iBinder5, i, i2, str3, zzbbiVar, str4, zzaqVar, iBinder6);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ AdOverlayInfoParcel[] newArray(int i) {
        return new AdOverlayInfoParcel[i];
    }
}
