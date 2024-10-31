package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.wearable.ConnectionConfiguration;

/* loaded from: classes.dex */
public class zzao implements Parcelable.Creator<GetConfigResponse> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(GetConfigResponse getConfigResponse, Parcel parcel, int i) {
        int a2 = zzb.a(parcel);
        zzb.a(parcel, 1, getConfigResponse.f2350a);
        zzb.a(parcel, 2, getConfigResponse.b);
        zzb.a(parcel, 3, (Parcelable) getConfigResponse.c, i, false);
        zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public GetConfigResponse createFromParcel(Parcel parcel) {
        int i = 0;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        ConnectionConfiguration connectionConfiguration = null;
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
                    connectionConfiguration = (ConnectionConfiguration) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, ConnectionConfiguration.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new GetConfigResponse(i2, i, connectionConfiguration);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public GetConfigResponse[] newArray(int i) {
        return new GetConfigResponse[i];
    }
}
