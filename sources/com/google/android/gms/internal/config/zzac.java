package com.google.android.gms.internal.config;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class zzac implements Parcelable.Creator<zzab> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzab createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        String str = null;
        DataHolder dataHolder = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        ArrayList<String> arrayList = null;
        ArrayList arrayList2 = null;
        long j = 0;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
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
                    dataHolder = (DataHolder) SafeParcelReader.a(parcel, a2, DataHolder.CREATOR);
                    break;
                case 5:
                    str2 = SafeParcelReader.p(parcel, a2);
                    break;
                case 6:
                    str3 = SafeParcelReader.p(parcel, a2);
                    break;
                case 7:
                    str4 = SafeParcelReader.p(parcel, a2);
                    break;
                case 8:
                    arrayList = SafeParcelReader.r(parcel, a2);
                    break;
                case 9:
                    i = SafeParcelReader.A(parcel, a2);
                    break;
                case 10:
                    arrayList2 = SafeParcelReader.c(parcel, a2, zzl.CREATOR);
                    break;
                case 11:
                    i2 = SafeParcelReader.A(parcel, a2);
                    break;
                case 12:
                    i3 = SafeParcelReader.A(parcel, a2);
                    break;
                default:
                    SafeParcelReader.F(parcel, a2);
                    break;
            }
        }
        SafeParcelReader.s(parcel, b2);
        return new zzab(str, j, dataHolder, str2, str3, str4, arrayList, i, arrayList2, i2, i3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzab[] newArray(int i) {
        return new zzab[i];
    }
}
