package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.wearable.ConnectionConfiguration;

/* loaded from: classes.dex */
public class zzap implements Parcelable.Creator<GetConfigsResponse> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(GetConfigsResponse getConfigsResponse, Parcel parcel, int i) {
        int a2 = zzb.a(parcel);
        zzb.a(parcel, 1, getConfigsResponse.f2351a);
        zzb.a(parcel, 2, getConfigsResponse.b);
        zzb.a(parcel, 3, (Parcelable[]) getConfigsResponse.c, i, false);
        zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public GetConfigsResponse createFromParcel(Parcel parcel) {
        int i = 0;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        ConnectionConfiguration[] connectionConfigurationArr = null;
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
                    connectionConfigurationArr = (ConnectionConfiguration[]) com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2, ConnectionConfiguration.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new GetConfigsResponse(i2, i, connectionConfigurationArr);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public GetConfigsResponse[] newArray(int i) {
        return new GetConfigsResponse[i];
    }
}
