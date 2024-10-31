package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class zzatc implements Parcelable.Creator<zzatb> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzatb createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        Bundle bundle = null;
        zzbbi zzbbiVar = null;
        ApplicationInfo applicationInfo = null;
        String str = null;
        ArrayList<String> arrayList = null;
        PackageInfo packageInfo = null;
        String str2 = null;
        String str3 = null;
        boolean z = false;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a2)) {
                case 1:
                    bundle = SafeParcelReader.f(parcel, a2);
                    break;
                case 2:
                    zzbbiVar = (zzbbi) SafeParcelReader.a(parcel, a2, zzbbi.CREATOR);
                    break;
                case 3:
                    applicationInfo = (ApplicationInfo) SafeParcelReader.a(parcel, a2, ApplicationInfo.CREATOR);
                    break;
                case 4:
                    str = SafeParcelReader.p(parcel, a2);
                    break;
                case 5:
                    arrayList = SafeParcelReader.r(parcel, a2);
                    break;
                case 6:
                    packageInfo = (PackageInfo) SafeParcelReader.a(parcel, a2, PackageInfo.CREATOR);
                    break;
                case 7:
                    str2 = SafeParcelReader.p(parcel, a2);
                    break;
                case 8:
                    z = SafeParcelReader.t(parcel, a2);
                    break;
                case 9:
                    str3 = SafeParcelReader.p(parcel, a2);
                    break;
                default:
                    SafeParcelReader.F(parcel, a2);
                    break;
            }
        }
        SafeParcelReader.s(parcel, b2);
        return new zzatb(bundle, zzbbiVar, applicationInfo, str, arrayList, packageInfo, str2, z, str3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzatb[] newArray(int i) {
        return new zzatb[i];
    }
}
