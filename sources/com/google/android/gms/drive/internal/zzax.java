package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes2.dex */
public class zzax implements Parcelable.Creator<OnDeviceUsagePreferenceResponse> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(OnDeviceUsagePreferenceResponse onDeviceUsagePreferenceResponse, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, onDeviceUsagePreferenceResponse.f1101a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, (Parcelable) onDeviceUsagePreferenceResponse.b, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public OnDeviceUsagePreferenceResponse createFromParcel(Parcel parcel) {
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        FileUploadPreferencesImpl fileUploadPreferencesImpl = null;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    fileUploadPreferencesImpl = (FileUploadPreferencesImpl) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, FileUploadPreferencesImpl.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new OnDeviceUsagePreferenceResponse(i, fileUploadPreferencesImpl);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public OnDeviceUsagePreferenceResponse[] newArray(int i) {
        return new OnDeviceUsagePreferenceResponse[i];
    }
}
