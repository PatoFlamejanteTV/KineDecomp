package com.google.android.gms.clearcut;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.clearcut.zzr;
import com.google.android.gms.phenotype.ExperimentTokens;

/* loaded from: classes.dex */
public final class zzf implements Parcelable.Creator<zze> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zze createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        zzr zzrVar = null;
        byte[] bArr = null;
        int[] iArr = null;
        String[] strArr = null;
        int[] iArr2 = null;
        byte[][] bArr2 = null;
        ExperimentTokens[] experimentTokensArr = null;
        boolean z = true;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a2)) {
                case 2:
                    zzrVar = (zzr) SafeParcelReader.a(parcel, a2, zzr.CREATOR);
                    break;
                case 3:
                    bArr = SafeParcelReader.g(parcel, a2);
                    break;
                case 4:
                    iArr = SafeParcelReader.k(parcel, a2);
                    break;
                case 5:
                    strArr = SafeParcelReader.q(parcel, a2);
                    break;
                case 6:
                    iArr2 = SafeParcelReader.k(parcel, a2);
                    break;
                case 7:
                    bArr2 = SafeParcelReader.h(parcel, a2);
                    break;
                case 8:
                    z = SafeParcelReader.t(parcel, a2);
                    break;
                case 9:
                    experimentTokensArr = (ExperimentTokens[]) SafeParcelReader.b(parcel, a2, ExperimentTokens.CREATOR);
                    break;
                default:
                    SafeParcelReader.F(parcel, a2);
                    break;
            }
        }
        SafeParcelReader.s(parcel, b2);
        return new zze(zzrVar, bArr, iArr, strArr, iArr2, bArr2, z, experimentTokensArr);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zze[] newArray(int i) {
        return new zze[i];
    }
}
