package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class zzafo implements Parcelable.Creator<zzafn> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzafn createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        String str = null;
        byte[] bArr = null;
        String[] strArr = null;
        String[] strArr2 = null;
        long j = 0;
        boolean z = false;
        int i = 0;
        boolean z2 = false;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a2)) {
                case 1:
                    z = SafeParcelReader.t(parcel, a2);
                    break;
                case 2:
                    str = SafeParcelReader.p(parcel, a2);
                    break;
                case 3:
                    i = SafeParcelReader.A(parcel, a2);
                    break;
                case 4:
                    bArr = SafeParcelReader.g(parcel, a2);
                    break;
                case 5:
                    strArr = SafeParcelReader.q(parcel, a2);
                    break;
                case 6:
                    strArr2 = SafeParcelReader.q(parcel, a2);
                    break;
                case 7:
                    z2 = SafeParcelReader.t(parcel, a2);
                    break;
                case 8:
                    j = SafeParcelReader.C(parcel, a2);
                    break;
                default:
                    SafeParcelReader.F(parcel, a2);
                    break;
            }
        }
        SafeParcelReader.s(parcel, b2);
        return new zzafn(z, str, i, bArr, strArr, strArr2, z2, j);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzafn[] newArray(int i) {
        return new zzafn[i];
    }
}
