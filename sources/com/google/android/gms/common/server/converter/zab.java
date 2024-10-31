package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes.dex */
public final class zab implements Parcelable.Creator<zaa> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zaa createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        int i = 0;
        StringToIntConverter stringToIntConverter = null;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            int a3 = SafeParcelReader.a(a2);
            if (a3 == 1) {
                i = SafeParcelReader.A(parcel, a2);
            } else if (a3 != 2) {
                SafeParcelReader.F(parcel, a2);
            } else {
                stringToIntConverter = (StringToIntConverter) SafeParcelReader.a(parcel, a2, StringToIntConverter.CREATOR);
            }
        }
        SafeParcelReader.s(parcel, b2);
        return new zaa(i, stringToIntConverter);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zaa[] newArray(int i) {
        return new zaa[i];
    }
}
