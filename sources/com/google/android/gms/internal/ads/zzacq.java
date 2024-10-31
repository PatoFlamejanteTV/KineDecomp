package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class zzacq implements Parcelable.Creator<zzacp> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzacp createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        zzzw zzzwVar = null;
        int i = 0;
        boolean z = false;
        int i2 = 0;
        boolean z2 = false;
        int i3 = 0;
        boolean z3 = false;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a2)) {
                case 1:
                    i = SafeParcelReader.A(parcel, a2);
                    break;
                case 2:
                    z = SafeParcelReader.t(parcel, a2);
                    break;
                case 3:
                    i2 = SafeParcelReader.A(parcel, a2);
                    break;
                case 4:
                    z2 = SafeParcelReader.t(parcel, a2);
                    break;
                case 5:
                    i3 = SafeParcelReader.A(parcel, a2);
                    break;
                case 6:
                    zzzwVar = (zzzw) SafeParcelReader.a(parcel, a2, zzzw.CREATOR);
                    break;
                case 7:
                    z3 = SafeParcelReader.t(parcel, a2);
                    break;
                default:
                    SafeParcelReader.F(parcel, a2);
                    break;
            }
        }
        SafeParcelReader.s(parcel, b2);
        return new zzacp(i, z, i2, z2, i3, zzzwVar, z3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzacp[] newArray(int i) {
        return new zzacp[i];
    }
}
