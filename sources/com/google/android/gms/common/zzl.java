package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes.dex */
public final class zzl implements Parcelable.Creator<zzk> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzk createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        String str = null;
        IBinder iBinder = null;
        boolean z = false;
        boolean z2 = false;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            int a3 = SafeParcelReader.a(a2);
            if (a3 == 1) {
                str = SafeParcelReader.p(parcel, a2);
            } else if (a3 == 2) {
                iBinder = SafeParcelReader.z(parcel, a2);
            } else if (a3 == 3) {
                z = SafeParcelReader.t(parcel, a2);
            } else if (a3 != 4) {
                SafeParcelReader.F(parcel, a2);
            } else {
                z2 = SafeParcelReader.t(parcel, a2);
            }
        }
        SafeParcelReader.s(parcel, b2);
        return new zzk(str, iBinder, z, z2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzk[] newArray(int i) {
        return new zzk[i];
    }
}
