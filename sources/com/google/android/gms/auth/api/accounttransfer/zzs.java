package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.HashSet;

/* loaded from: classes.dex */
public final class zzs implements Parcelable.Creator<zzr> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzr createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        HashSet hashSet = new HashSet();
        int i = 0;
        zzt zztVar = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            int a3 = SafeParcelReader.a(a2);
            if (a3 == 1) {
                i = SafeParcelReader.A(parcel, a2);
                hashSet.add(1);
            } else if (a3 == 2) {
                zztVar = (zzt) SafeParcelReader.a(parcel, a2, zzt.CREATOR);
                hashSet.add(2);
            } else if (a3 == 3) {
                str = SafeParcelReader.p(parcel, a2);
                hashSet.add(3);
            } else if (a3 == 4) {
                str2 = SafeParcelReader.p(parcel, a2);
                hashSet.add(4);
            } else if (a3 != 5) {
                SafeParcelReader.F(parcel, a2);
            } else {
                str3 = SafeParcelReader.p(parcel, a2);
                hashSet.add(5);
            }
        }
        if (parcel.dataPosition() == b2) {
            return new zzr(hashSet, i, zztVar, str, str2, str3);
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Overread allowed size end=");
        sb.append(b2);
        throw new SafeParcelReader.ParseException(sb.toString(), parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzr[] newArray(int i) {
        return new zzr[i];
    }
}
