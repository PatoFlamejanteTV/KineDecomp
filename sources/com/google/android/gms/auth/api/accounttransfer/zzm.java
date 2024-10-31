package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;
import java.util.HashSet;

/* loaded from: classes.dex */
public final class zzm implements Parcelable.Creator<zzl> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzl createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        HashSet hashSet = new HashSet();
        int i = 0;
        ArrayList arrayList = null;
        zzo zzoVar = null;
        int i2 = 0;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            int a3 = SafeParcelReader.a(a2);
            if (a3 == 1) {
                i = SafeParcelReader.A(parcel, a2);
                hashSet.add(1);
            } else if (a3 == 2) {
                arrayList = SafeParcelReader.c(parcel, a2, zzr.CREATOR);
                hashSet.add(2);
            } else if (a3 == 3) {
                i2 = SafeParcelReader.A(parcel, a2);
                hashSet.add(3);
            } else if (a3 != 4) {
                SafeParcelReader.F(parcel, a2);
            } else {
                zzoVar = (zzo) SafeParcelReader.a(parcel, a2, zzo.CREATOR);
                hashSet.add(4);
            }
        }
        if (parcel.dataPosition() == b2) {
            return new zzl(hashSet, i, arrayList, i2, zzoVar);
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Overread allowed size end=");
        sb.append(b2);
        throw new SafeParcelReader.ParseException(sb.toString(), parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzl[] newArray(int i) {
        return new zzl[i];
    }
}
