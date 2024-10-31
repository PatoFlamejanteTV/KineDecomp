package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.xiaomi.licensinglibrary.LicenseErrCode;

/* loaded from: classes.dex */
public class zzb implements Parcelable.Creator<CredentialPickerConfig> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(CredentialPickerConfig credentialPickerConfig, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, credentialPickerConfig.a());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, credentialPickerConfig.f788a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, credentialPickerConfig.b());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public CredentialPickerConfig createFromParcel(Parcel parcel) {
        boolean z = false;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        boolean z2 = false;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    z2 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 2:
                    z = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case LicenseErrCode.LICENSE_STATUS_NOT_LICENSED /* 1000 */:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new CredentialPickerConfig(i, z2, z);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public CredentialPickerConfig[] newArray(int i) {
        return new CredentialPickerConfig[i];
    }
}
