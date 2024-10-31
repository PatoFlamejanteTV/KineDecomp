package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class zztw implements Parcelable.Creator<zztv> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zztv createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        ParcelFileDescriptor parcelFileDescriptor = null;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            if (SafeParcelReader.a(a2) != 2) {
                SafeParcelReader.F(parcel, a2);
            } else {
                parcelFileDescriptor = (ParcelFileDescriptor) SafeParcelReader.a(parcel, a2, ParcelFileDescriptor.CREATOR);
            }
        }
        SafeParcelReader.s(parcel, b2);
        return new zztv(parcelFileDescriptor);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zztv[] newArray(int i) {
        return new zztv[i];
    }
}
