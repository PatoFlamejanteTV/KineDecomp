package com.google.android.gms.auth.api.proxy;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes.dex */
public final class zza implements Parcelable.Creator<ProxyRequest> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ProxyRequest createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        String str = null;
        byte[] bArr = null;
        Bundle bundle = null;
        long j = 0;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            int a3 = SafeParcelReader.a(a2);
            if (a3 == 1) {
                str = SafeParcelReader.p(parcel, a2);
            } else if (a3 == 2) {
                i2 = SafeParcelReader.A(parcel, a2);
            } else if (a3 == 3) {
                j = SafeParcelReader.C(parcel, a2);
            } else if (a3 == 4) {
                bArr = SafeParcelReader.g(parcel, a2);
            } else if (a3 == 5) {
                bundle = SafeParcelReader.f(parcel, a2);
            } else if (a3 != 1000) {
                SafeParcelReader.F(parcel, a2);
            } else {
                i = SafeParcelReader.A(parcel, a2);
            }
        }
        SafeParcelReader.s(parcel, b2);
        return new ProxyRequest(i, str, i2, j, bArr, bundle);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ProxyRequest[] newArray(int i) {
        return new ProxyRequest[i];
    }
}
