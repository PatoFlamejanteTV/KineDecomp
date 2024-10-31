package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class zzasp implements Parcelable.Creator<zzaso> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaso createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        boolean z = false;
        ArrayList<String> arrayList = null;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            int a3 = SafeParcelReader.a(a2);
            if (a3 == 2) {
                z = SafeParcelReader.t(parcel, a2);
            } else if (a3 != 3) {
                SafeParcelReader.F(parcel, a2);
            } else {
                arrayList = SafeParcelReader.r(parcel, a2);
            }
        }
        SafeParcelReader.s(parcel, b2);
        return new zzaso(z, arrayList);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaso[] newArray(int i) {
        return new zzaso[i];
    }
}
