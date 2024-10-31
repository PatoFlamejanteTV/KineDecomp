package com.google.android.gms.phenotype;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class zzk implements Parcelable.Creator<zzi> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzi createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        String str = null;
        String str2 = null;
        byte[] bArr = null;
        long j = 0;
        double d2 = 0.0d;
        boolean z = false;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a2)) {
                case 2:
                    str = SafeParcelReader.p(parcel, a2);
                    break;
                case 3:
                    j = SafeParcelReader.C(parcel, a2);
                    break;
                case 4:
                    z = SafeParcelReader.t(parcel, a2);
                    break;
                case 5:
                    d2 = SafeParcelReader.v(parcel, a2);
                    break;
                case 6:
                    str2 = SafeParcelReader.p(parcel, a2);
                    break;
                case 7:
                    bArr = SafeParcelReader.g(parcel, a2);
                    break;
                case 8:
                    i = SafeParcelReader.A(parcel, a2);
                    break;
                case 9:
                    i2 = SafeParcelReader.A(parcel, a2);
                    break;
                default:
                    SafeParcelReader.F(parcel, a2);
                    break;
            }
        }
        SafeParcelReader.s(parcel, b2);
        return new zzi(str, j, z, d2, str2, bArr, i, i2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzi[] newArray(int i) {
        return new zzi[i];
    }
}
