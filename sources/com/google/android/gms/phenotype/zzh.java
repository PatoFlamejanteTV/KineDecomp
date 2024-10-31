package com.google.android.gms.phenotype;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class zzh implements Parcelable.Creator<ExperimentTokens> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ExperimentTokens createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        String str = null;
        byte[] bArr = null;
        byte[][] bArr2 = null;
        byte[][] bArr3 = null;
        byte[][] bArr4 = null;
        byte[][] bArr5 = null;
        int[] iArr = null;
        byte[][] bArr6 = null;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a2)) {
                case 2:
                    str = SafeParcelReader.p(parcel, a2);
                    break;
                case 3:
                    bArr = SafeParcelReader.g(parcel, a2);
                    break;
                case 4:
                    bArr2 = SafeParcelReader.h(parcel, a2);
                    break;
                case 5:
                    bArr3 = SafeParcelReader.h(parcel, a2);
                    break;
                case 6:
                    bArr4 = SafeParcelReader.h(parcel, a2);
                    break;
                case 7:
                    bArr5 = SafeParcelReader.h(parcel, a2);
                    break;
                case 8:
                    iArr = SafeParcelReader.k(parcel, a2);
                    break;
                case 9:
                    bArr6 = SafeParcelReader.h(parcel, a2);
                    break;
                default:
                    SafeParcelReader.F(parcel, a2);
                    break;
            }
        }
        SafeParcelReader.s(parcel, b2);
        return new ExperimentTokens(str, bArr, bArr2, bArr3, bArr4, bArr5, iArr, bArr6);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ExperimentTokens[] newArray(int i) {
        return new ExperimentTokens[i];
    }
}
