package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class zzwd implements Parcelable.Creator<zzwb> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzwb createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        Bundle bundle = null;
        ArrayList<String> arrayList = null;
        String str = null;
        zzzs zzzsVar = null;
        Location location = null;
        String str2 = null;
        Bundle bundle2 = null;
        Bundle bundle3 = null;
        ArrayList<String> arrayList2 = null;
        String str3 = null;
        String str4 = null;
        zzvv zzvvVar = null;
        String str5 = null;
        long j = 0;
        int i = 0;
        int i2 = 0;
        boolean z = false;
        int i3 = 0;
        boolean z2 = false;
        boolean z3 = false;
        int i4 = 0;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a2)) {
                case 1:
                    i = SafeParcelReader.A(parcel, a2);
                    break;
                case 2:
                    j = SafeParcelReader.C(parcel, a2);
                    break;
                case 3:
                    bundle = SafeParcelReader.f(parcel, a2);
                    break;
                case 4:
                    i2 = SafeParcelReader.A(parcel, a2);
                    break;
                case 5:
                    arrayList = SafeParcelReader.r(parcel, a2);
                    break;
                case 6:
                    z = SafeParcelReader.t(parcel, a2);
                    break;
                case 7:
                    i3 = SafeParcelReader.A(parcel, a2);
                    break;
                case 8:
                    z2 = SafeParcelReader.t(parcel, a2);
                    break;
                case 9:
                    str = SafeParcelReader.p(parcel, a2);
                    break;
                case 10:
                    zzzsVar = (zzzs) SafeParcelReader.a(parcel, a2, zzzs.CREATOR);
                    break;
                case 11:
                    location = (Location) SafeParcelReader.a(parcel, a2, Location.CREATOR);
                    break;
                case 12:
                    str2 = SafeParcelReader.p(parcel, a2);
                    break;
                case 13:
                    bundle2 = SafeParcelReader.f(parcel, a2);
                    break;
                case 14:
                    bundle3 = SafeParcelReader.f(parcel, a2);
                    break;
                case 15:
                    arrayList2 = SafeParcelReader.r(parcel, a2);
                    break;
                case 16:
                    str3 = SafeParcelReader.p(parcel, a2);
                    break;
                case 17:
                    str4 = SafeParcelReader.p(parcel, a2);
                    break;
                case 18:
                    z3 = SafeParcelReader.t(parcel, a2);
                    break;
                case 19:
                    zzvvVar = (zzvv) SafeParcelReader.a(parcel, a2, zzvv.CREATOR);
                    break;
                case 20:
                    i4 = SafeParcelReader.A(parcel, a2);
                    break;
                case 21:
                    str5 = SafeParcelReader.p(parcel, a2);
                    break;
                default:
                    SafeParcelReader.F(parcel, a2);
                    break;
            }
        }
        SafeParcelReader.s(parcel, b2);
        return new zzwb(i, j, bundle, i2, arrayList, z, i3, z2, str, zzzsVar, location, str2, bundle2, bundle3, arrayList2, str3, str4, z3, zzvvVar, i4, str5);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzwb[] newArray(int i) {
        return new zzwb[i];
    }
}
