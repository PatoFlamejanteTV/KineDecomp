package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class zzp implements Parcelable.Creator<zzo> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzo createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        ArrayList<String> arrayList = null;
        ArrayList<String> arrayList2 = null;
        ArrayList<String> arrayList3 = null;
        ArrayList<String> arrayList4 = null;
        ArrayList<String> arrayList5 = null;
        int i = 0;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a2)) {
                case 1:
                    i = SafeParcelReader.A(parcel, a2);
                    break;
                case 2:
                    arrayList = SafeParcelReader.r(parcel, a2);
                    break;
                case 3:
                    arrayList2 = SafeParcelReader.r(parcel, a2);
                    break;
                case 4:
                    arrayList3 = SafeParcelReader.r(parcel, a2);
                    break;
                case 5:
                    arrayList4 = SafeParcelReader.r(parcel, a2);
                    break;
                case 6:
                    arrayList5 = SafeParcelReader.r(parcel, a2);
                    break;
                default:
                    SafeParcelReader.F(parcel, a2);
                    break;
            }
        }
        SafeParcelReader.s(parcel, b2);
        return new zzo(i, arrayList, arrayList2, arrayList3, arrayList4, arrayList5);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzo[] newArray(int i) {
        return new zzo[i];
    }
}
