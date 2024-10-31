package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class zzasn implements Parcelable.Creator<zzasm> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzasm createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        String str = null;
        String str2 = null;
        ArrayList<String> arrayList = null;
        ArrayList<String> arrayList2 = null;
        ArrayList<String> arrayList3 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        zzasy zzasyVar = null;
        String str7 = null;
        String str8 = null;
        zzawd zzawdVar = null;
        ArrayList<String> arrayList4 = null;
        ArrayList<String> arrayList5 = null;
        zzaso zzasoVar = null;
        String str9 = null;
        ArrayList<String> arrayList6 = null;
        String str10 = null;
        zzawo zzawoVar = null;
        String str11 = null;
        Bundle bundle = null;
        ArrayList<String> arrayList7 = null;
        String str12 = null;
        String str13 = null;
        int i = 0;
        int i2 = 0;
        boolean z = false;
        int i3 = 0;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        boolean z8 = false;
        boolean z9 = false;
        boolean z10 = false;
        boolean z11 = false;
        boolean z12 = false;
        boolean z13 = false;
        boolean z14 = false;
        boolean z15 = false;
        int i4 = 0;
        boolean z16 = false;
        boolean z17 = false;
        boolean z18 = false;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a2)) {
                case 1:
                    i = SafeParcelReader.A(parcel, a2);
                    break;
                case 2:
                    str = SafeParcelReader.p(parcel, a2);
                    break;
                case 3:
                    str2 = SafeParcelReader.p(parcel, a2);
                    break;
                case 4:
                    arrayList = SafeParcelReader.r(parcel, a2);
                    break;
                case 5:
                    i2 = SafeParcelReader.A(parcel, a2);
                    break;
                case 6:
                    arrayList2 = SafeParcelReader.r(parcel, a2);
                    break;
                case 7:
                    j = SafeParcelReader.C(parcel, a2);
                    break;
                case 8:
                    z = SafeParcelReader.t(parcel, a2);
                    break;
                case 9:
                    j2 = SafeParcelReader.C(parcel, a2);
                    break;
                case 10:
                    arrayList3 = SafeParcelReader.r(parcel, a2);
                    break;
                case 11:
                    j3 = SafeParcelReader.C(parcel, a2);
                    break;
                case 12:
                    i3 = SafeParcelReader.A(parcel, a2);
                    break;
                case 13:
                    str3 = SafeParcelReader.p(parcel, a2);
                    break;
                case 14:
                    j4 = SafeParcelReader.C(parcel, a2);
                    break;
                case 15:
                    str4 = SafeParcelReader.p(parcel, a2);
                    break;
                case 16:
                case 17:
                case 20:
                case 27:
                case 41:
                default:
                    SafeParcelReader.F(parcel, a2);
                    break;
                case 18:
                    z2 = SafeParcelReader.t(parcel, a2);
                    break;
                case 19:
                    str5 = SafeParcelReader.p(parcel, a2);
                    break;
                case 21:
                    str6 = SafeParcelReader.p(parcel, a2);
                    break;
                case 22:
                    z3 = SafeParcelReader.t(parcel, a2);
                    break;
                case 23:
                    z4 = SafeParcelReader.t(parcel, a2);
                    break;
                case 24:
                    z5 = SafeParcelReader.t(parcel, a2);
                    break;
                case 25:
                    z6 = SafeParcelReader.t(parcel, a2);
                    break;
                case 26:
                    z7 = SafeParcelReader.t(parcel, a2);
                    break;
                case 28:
                    zzasyVar = (zzasy) SafeParcelReader.a(parcel, a2, zzasy.CREATOR);
                    break;
                case 29:
                    str7 = SafeParcelReader.p(parcel, a2);
                    break;
                case 30:
                    str8 = SafeParcelReader.p(parcel, a2);
                    break;
                case 31:
                    z8 = SafeParcelReader.t(parcel, a2);
                    break;
                case 32:
                    z9 = SafeParcelReader.t(parcel, a2);
                    break;
                case 33:
                    zzawdVar = (zzawd) SafeParcelReader.a(parcel, a2, zzawd.CREATOR);
                    break;
                case 34:
                    arrayList4 = SafeParcelReader.r(parcel, a2);
                    break;
                case 35:
                    arrayList5 = SafeParcelReader.r(parcel, a2);
                    break;
                case 36:
                    z10 = SafeParcelReader.t(parcel, a2);
                    break;
                case 37:
                    zzasoVar = (zzaso) SafeParcelReader.a(parcel, a2, zzaso.CREATOR);
                    break;
                case 38:
                    z11 = SafeParcelReader.t(parcel, a2);
                    break;
                case 39:
                    str9 = SafeParcelReader.p(parcel, a2);
                    break;
                case 40:
                    arrayList6 = SafeParcelReader.r(parcel, a2);
                    break;
                case 42:
                    z12 = SafeParcelReader.t(parcel, a2);
                    break;
                case 43:
                    str10 = SafeParcelReader.p(parcel, a2);
                    break;
                case 44:
                    zzawoVar = (zzawo) SafeParcelReader.a(parcel, a2, zzawo.CREATOR);
                    break;
                case 45:
                    str11 = SafeParcelReader.p(parcel, a2);
                    break;
                case 46:
                    z13 = SafeParcelReader.t(parcel, a2);
                    break;
                case 47:
                    z14 = SafeParcelReader.t(parcel, a2);
                    break;
                case 48:
                    bundle = SafeParcelReader.f(parcel, a2);
                    break;
                case 49:
                    z15 = SafeParcelReader.t(parcel, a2);
                    break;
                case 50:
                    i4 = SafeParcelReader.A(parcel, a2);
                    break;
                case 51:
                    z16 = SafeParcelReader.t(parcel, a2);
                    break;
                case 52:
                    arrayList7 = SafeParcelReader.r(parcel, a2);
                    break;
                case 53:
                    z17 = SafeParcelReader.t(parcel, a2);
                    break;
                case 54:
                    str12 = SafeParcelReader.p(parcel, a2);
                    break;
                case 55:
                    str13 = SafeParcelReader.p(parcel, a2);
                    break;
                case 56:
                    z18 = SafeParcelReader.t(parcel, a2);
                    break;
            }
        }
        SafeParcelReader.s(parcel, b2);
        return new zzasm(i, str, str2, arrayList, i2, arrayList2, j, z, j2, arrayList3, j3, i3, str3, j4, str4, z2, str5, str6, z3, z4, z5, z6, z7, zzasyVar, str7, str8, z8, z9, zzawdVar, arrayList4, arrayList5, z10, zzasoVar, z11, str9, arrayList6, z12, str10, zzawoVar, str11, z13, z14, bundle, z15, i4, z16, arrayList7, z17, str12, str13, z18);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzasm[] newArray(int i) {
        return new zzasm[i];
    }
}
