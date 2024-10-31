package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class zzawe implements Parcelable.Creator<zzawd> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzawd createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        String str = null;
        int i = 0;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            int a3 = SafeParcelReader.a(a2);
            if (a3 == 2) {
                str = SafeParcelReader.p(parcel, a2);
            } else if (a3 != 3) {
                SafeParcelReader.F(parcel, a2);
            } else {
                i = SafeParcelReader.A(parcel, a2);
            }
        }
        SafeParcelReader.s(parcel, b2);
        return new zzawd(str, i);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzawd[] newArray(int i) {
        return new zzawd[i];
    }
}
