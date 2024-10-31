package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class zzbjj implements Parcelable.Creator<zzbji> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbji createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        int i = 0;
        byte[] bArr = null;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            int a3 = SafeParcelReader.a(a2);
            if (a3 == 1) {
                i = SafeParcelReader.A(parcel, a2);
            } else if (a3 != 2) {
                SafeParcelReader.F(parcel, a2);
            } else {
                bArr = SafeParcelReader.g(parcel, a2);
            }
        }
        SafeParcelReader.s(parcel, b2);
        return new zzbji(i, bArr);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbji[] newArray(int i) {
        return new zzbji[i];
    }
}
