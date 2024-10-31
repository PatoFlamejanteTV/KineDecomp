package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes.dex */
public final class zzj implements Parcelable.Creator<HintRequest> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ HintRequest createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        CredentialPickerConfig credentialPickerConfig = null;
        String[] strArr = null;
        String str = null;
        String str2 = null;
        int i = 0;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            int a3 = SafeParcelReader.a(a2);
            if (a3 != 1000) {
                switch (a3) {
                    case 1:
                        credentialPickerConfig = (CredentialPickerConfig) SafeParcelReader.a(parcel, a2, CredentialPickerConfig.CREATOR);
                        break;
                    case 2:
                        z = SafeParcelReader.t(parcel, a2);
                        break;
                    case 3:
                        z2 = SafeParcelReader.t(parcel, a2);
                        break;
                    case 4:
                        strArr = SafeParcelReader.q(parcel, a2);
                        break;
                    case 5:
                        z3 = SafeParcelReader.t(parcel, a2);
                        break;
                    case 6:
                        str = SafeParcelReader.p(parcel, a2);
                        break;
                    case 7:
                        str2 = SafeParcelReader.p(parcel, a2);
                        break;
                    default:
                        SafeParcelReader.F(parcel, a2);
                        break;
                }
            } else {
                i = SafeParcelReader.A(parcel, a2);
            }
        }
        SafeParcelReader.s(parcel, b2);
        return new HintRequest(i, credentialPickerConfig, z, z2, strArr, z3, str, str2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ HintRequest[] newArray(int i) {
        return new HintRequest[i];
    }
}
