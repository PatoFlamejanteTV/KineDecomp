package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class zzask implements Parcelable.Creator<zzasi> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzasi createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        long j = 0;
        long j2 = 0;
        Bundle bundle = null;
        zzwb zzwbVar = null;
        zzwf zzwfVar = null;
        String str = null;
        ApplicationInfo applicationInfo = null;
        PackageInfo packageInfo = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        zzbbi zzbbiVar = null;
        Bundle bundle2 = null;
        ArrayList<String> arrayList = null;
        Bundle bundle3 = null;
        String str5 = null;
        String str6 = null;
        ArrayList<String> arrayList2 = null;
        String str7 = null;
        zzacp zzacpVar = null;
        ArrayList<String> arrayList3 = null;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        Bundle bundle4 = null;
        String str11 = null;
        zzyv zzyvVar = null;
        Bundle bundle5 = null;
        String str12 = null;
        String str13 = null;
        String str14 = null;
        ArrayList<Integer> arrayList4 = null;
        String str15 = null;
        ArrayList<String> arrayList5 = null;
        ArrayList<String> arrayList6 = null;
        String str16 = null;
        zzafz zzafzVar = null;
        String str17 = null;
        Bundle bundle6 = null;
        int i = 0;
        int i2 = 0;
        boolean z = false;
        int i3 = 0;
        int i4 = 0;
        float f2 = 0.0f;
        float f3 = 0.0f;
        boolean z2 = false;
        int i5 = 0;
        int i6 = 0;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        int i7 = 0;
        boolean z6 = false;
        boolean z7 = false;
        int i8 = 0;
        boolean z8 = false;
        boolean z9 = false;
        boolean z10 = false;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a2)) {
                case 1:
                    i = SafeParcelReader.A(parcel, a2);
                    break;
                case 2:
                    bundle = SafeParcelReader.f(parcel, a2);
                    break;
                case 3:
                    zzwbVar = (zzwb) SafeParcelReader.a(parcel, a2, zzwb.CREATOR);
                    break;
                case 4:
                    zzwfVar = (zzwf) SafeParcelReader.a(parcel, a2, zzwf.CREATOR);
                    break;
                case 5:
                    str = SafeParcelReader.p(parcel, a2);
                    break;
                case 6:
                    applicationInfo = (ApplicationInfo) SafeParcelReader.a(parcel, a2, ApplicationInfo.CREATOR);
                    break;
                case 7:
                    packageInfo = (PackageInfo) SafeParcelReader.a(parcel, a2, PackageInfo.CREATOR);
                    break;
                case 8:
                    str2 = SafeParcelReader.p(parcel, a2);
                    break;
                case 9:
                    str3 = SafeParcelReader.p(parcel, a2);
                    break;
                case 10:
                    str4 = SafeParcelReader.p(parcel, a2);
                    break;
                case 11:
                    zzbbiVar = (zzbbi) SafeParcelReader.a(parcel, a2, zzbbi.CREATOR);
                    break;
                case 12:
                    bundle2 = SafeParcelReader.f(parcel, a2);
                    break;
                case 13:
                    i2 = SafeParcelReader.A(parcel, a2);
                    break;
                case 14:
                    arrayList = SafeParcelReader.r(parcel, a2);
                    break;
                case 15:
                    bundle3 = SafeParcelReader.f(parcel, a2);
                    break;
                case 16:
                    z = SafeParcelReader.t(parcel, a2);
                    break;
                case 17:
                case 22:
                case 23:
                case 24:
                case 32:
                case 62:
                default:
                    SafeParcelReader.F(parcel, a2);
                    break;
                case 18:
                    i3 = SafeParcelReader.A(parcel, a2);
                    break;
                case 19:
                    i4 = SafeParcelReader.A(parcel, a2);
                    break;
                case 20:
                    f2 = SafeParcelReader.x(parcel, a2);
                    break;
                case 21:
                    str5 = SafeParcelReader.p(parcel, a2);
                    break;
                case 25:
                    j = SafeParcelReader.C(parcel, a2);
                    break;
                case 26:
                    str6 = SafeParcelReader.p(parcel, a2);
                    break;
                case 27:
                    arrayList2 = SafeParcelReader.r(parcel, a2);
                    break;
                case 28:
                    str7 = SafeParcelReader.p(parcel, a2);
                    break;
                case 29:
                    zzacpVar = (zzacp) SafeParcelReader.a(parcel, a2, zzacp.CREATOR);
                    break;
                case 30:
                    arrayList3 = SafeParcelReader.r(parcel, a2);
                    break;
                case 31:
                    j2 = SafeParcelReader.C(parcel, a2);
                    break;
                case 33:
                    str8 = SafeParcelReader.p(parcel, a2);
                    break;
                case 34:
                    f3 = SafeParcelReader.x(parcel, a2);
                    break;
                case 35:
                    i5 = SafeParcelReader.A(parcel, a2);
                    break;
                case 36:
                    i6 = SafeParcelReader.A(parcel, a2);
                    break;
                case 37:
                    z3 = SafeParcelReader.t(parcel, a2);
                    break;
                case 38:
                    z4 = SafeParcelReader.t(parcel, a2);
                    break;
                case 39:
                    str9 = SafeParcelReader.p(parcel, a2);
                    break;
                case 40:
                    z2 = SafeParcelReader.t(parcel, a2);
                    break;
                case 41:
                    str10 = SafeParcelReader.p(parcel, a2);
                    break;
                case 42:
                    z5 = SafeParcelReader.t(parcel, a2);
                    break;
                case 43:
                    i7 = SafeParcelReader.A(parcel, a2);
                    break;
                case 44:
                    bundle4 = SafeParcelReader.f(parcel, a2);
                    break;
                case 45:
                    str11 = SafeParcelReader.p(parcel, a2);
                    break;
                case 46:
                    zzyvVar = (zzyv) SafeParcelReader.a(parcel, a2, zzyv.CREATOR);
                    break;
                case 47:
                    z6 = SafeParcelReader.t(parcel, a2);
                    break;
                case 48:
                    bundle5 = SafeParcelReader.f(parcel, a2);
                    break;
                case 49:
                    str12 = SafeParcelReader.p(parcel, a2);
                    break;
                case 50:
                    str13 = SafeParcelReader.p(parcel, a2);
                    break;
                case 51:
                    str14 = SafeParcelReader.p(parcel, a2);
                    break;
                case 52:
                    z7 = SafeParcelReader.t(parcel, a2);
                    break;
                case 53:
                    arrayList4 = SafeParcelReader.l(parcel, a2);
                    break;
                case 54:
                    str15 = SafeParcelReader.p(parcel, a2);
                    break;
                case 55:
                    arrayList5 = SafeParcelReader.r(parcel, a2);
                    break;
                case 56:
                    i8 = SafeParcelReader.A(parcel, a2);
                    break;
                case 57:
                    z8 = SafeParcelReader.t(parcel, a2);
                    break;
                case 58:
                    z9 = SafeParcelReader.t(parcel, a2);
                    break;
                case 59:
                    z10 = SafeParcelReader.t(parcel, a2);
                    break;
                case 60:
                    arrayList6 = SafeParcelReader.r(parcel, a2);
                    break;
                case 61:
                    str16 = SafeParcelReader.p(parcel, a2);
                    break;
                case 63:
                    zzafzVar = (zzafz) SafeParcelReader.a(parcel, a2, zzafz.CREATOR);
                    break;
                case 64:
                    str17 = SafeParcelReader.p(parcel, a2);
                    break;
                case 65:
                    bundle6 = SafeParcelReader.f(parcel, a2);
                    break;
            }
        }
        SafeParcelReader.s(parcel, b2);
        return new zzasi(i, bundle, zzwbVar, zzwfVar, str, applicationInfo, packageInfo, str2, str3, str4, zzbbiVar, bundle2, i2, arrayList, bundle3, z, i3, i4, f2, str5, j, str6, arrayList2, str7, zzacpVar, arrayList3, j2, str8, f3, z2, i5, i6, z3, z4, str9, str10, z5, i7, bundle4, str11, zzyvVar, z6, bundle5, str12, str13, str14, z7, arrayList4, str15, arrayList5, i8, z8, z9, z10, arrayList6, str16, zzafzVar, str17, bundle6);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzasi[] newArray(int i) {
        return new zzasi[i];
    }
}
