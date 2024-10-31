package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.server.converter.zaa;
import com.google.android.gms.common.server.response.FastJsonResponse;

/* loaded from: classes.dex */
public final class zai implements Parcelable.Creator<FastJsonResponse.Field> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ FastJsonResponse.Field createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        String str = null;
        String str2 = null;
        zaa zaaVar = null;
        int i = 0;
        int i2 = 0;
        boolean z = false;
        int i3 = 0;
        boolean z2 = false;
        int i4 = 0;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a2)) {
                case 1:
                    i = SafeParcelReader.A(parcel, a2);
                    break;
                case 2:
                    i2 = SafeParcelReader.A(parcel, a2);
                    break;
                case 3:
                    z = SafeParcelReader.t(parcel, a2);
                    break;
                case 4:
                    i3 = SafeParcelReader.A(parcel, a2);
                    break;
                case 5:
                    z2 = SafeParcelReader.t(parcel, a2);
                    break;
                case 6:
                    str = SafeParcelReader.p(parcel, a2);
                    break;
                case 7:
                    i4 = SafeParcelReader.A(parcel, a2);
                    break;
                case 8:
                    str2 = SafeParcelReader.p(parcel, a2);
                    break;
                case 9:
                    zaaVar = (zaa) SafeParcelReader.a(parcel, a2, zaa.CREATOR);
                    break;
                default:
                    SafeParcelReader.F(parcel, a2);
                    break;
            }
        }
        SafeParcelReader.s(parcel, b2);
        return new FastJsonResponse.Field(i, i2, z, i3, z2, str, i4, str2, zaaVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ FastJsonResponse.Field[] newArray(int i) {
        return new FastJsonResponse.Field[i];
    }
}
