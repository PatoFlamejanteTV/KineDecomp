package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class zzawp implements Parcelable.Creator<zzawo> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzawo createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        String str = null;
        String str2 = null;
        ArrayList<String> arrayList = null;
        ArrayList<String> arrayList2 = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a2)) {
                case 2:
                    str = SafeParcelReader.p(parcel, a2);
                    break;
                case 3:
                    str2 = SafeParcelReader.p(parcel, a2);
                    break;
                case 4:
                    z = SafeParcelReader.t(parcel, a2);
                    break;
                case 5:
                    z2 = SafeParcelReader.t(parcel, a2);
                    break;
                case 6:
                    arrayList = SafeParcelReader.r(parcel, a2);
                    break;
                case 7:
                    z3 = SafeParcelReader.t(parcel, a2);
                    break;
                case 8:
                    z4 = SafeParcelReader.t(parcel, a2);
                    break;
                case 9:
                    arrayList2 = SafeParcelReader.r(parcel, a2);
                    break;
                default:
                    SafeParcelReader.F(parcel, a2);
                    break;
            }
        }
        SafeParcelReader.s(parcel, b2);
        return new zzawo(str, str2, z, z2, arrayList, z3, z4, arrayList2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzawo[] newArray(int i) {
        return new zzawo[i];
    }
}
