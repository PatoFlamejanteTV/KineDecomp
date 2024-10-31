package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

/* loaded from: classes.dex */
public class zzam implements Parcelable.Creator<GetCloudSyncOptInStatusResponse> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(GetCloudSyncOptInStatusResponse getCloudSyncOptInStatusResponse, Parcel parcel, int i) {
        int a2 = zzb.a(parcel);
        zzb.a(parcel, 1, getCloudSyncOptInStatusResponse.f2348a);
        zzb.a(parcel, 2, getCloudSyncOptInStatusResponse.b);
        zzb.a(parcel, 3, getCloudSyncOptInStatusResponse.c);
        zzb.a(parcel, 4, getCloudSyncOptInStatusResponse.d);
        zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public GetCloudSyncOptInStatusResponse createFromParcel(Parcel parcel) {
        boolean z = false;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        boolean z2 = false;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 3:
                    z2 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 4:
                    z = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new GetCloudSyncOptInStatusResponse(i2, i, z2, z);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public GetCloudSyncOptInStatusResponse[] newArray(int i) {
        return new GetCloudSyncOptInStatusResponse[i];
    }
}
