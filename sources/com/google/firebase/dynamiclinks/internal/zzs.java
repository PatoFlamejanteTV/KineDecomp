package com.google.firebase.dynamiclinks.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class zzs implements Parcelable.Creator<zzq> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzq createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        Uri uri = null;
        Uri uri2 = null;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            int a3 = SafeParcelReader.a(a2);
            if (a3 == 1) {
                uri = (Uri) SafeParcelReader.a(parcel, a2, Uri.CREATOR);
            } else if (a3 == 2) {
                uri2 = (Uri) SafeParcelReader.a(parcel, a2, Uri.CREATOR);
            } else if (a3 != 3) {
                SafeParcelReader.F(parcel, a2);
            } else {
                arrayList = SafeParcelReader.c(parcel, a2, zzr.CREATOR);
            }
        }
        SafeParcelReader.s(parcel, b2);
        return new zzq(uri, uri2, arrayList);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzq[] newArray(int i) {
        return new zzq[i];
    }
}
