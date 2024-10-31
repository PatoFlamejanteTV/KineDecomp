package com.google.firebase.dynamiclinks.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class zzb implements Parcelable.Creator<zza> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zza createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        String str = null;
        String str2 = null;
        Bundle bundle = null;
        Uri uri = null;
        long j = 0;
        int i = 0;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a2)) {
                case 1:
                    str = SafeParcelReader.p(parcel, a2);
                    break;
                case 2:
                    str2 = SafeParcelReader.p(parcel, a2);
                    break;
                case 3:
                    i = SafeParcelReader.A(parcel, a2);
                    break;
                case 4:
                    j = SafeParcelReader.C(parcel, a2);
                    break;
                case 5:
                    bundle = SafeParcelReader.f(parcel, a2);
                    break;
                case 6:
                    uri = (Uri) SafeParcelReader.a(parcel, a2, Uri.CREATOR);
                    break;
                default:
                    SafeParcelReader.F(parcel, a2);
                    break;
            }
        }
        SafeParcelReader.s(parcel, b2);
        return new zza(str, str2, i, j, bundle, uri);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zza[] newArray(int i) {
        return new zza[i];
    }
}
