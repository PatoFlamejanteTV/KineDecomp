package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes.dex */
public class zzz implements Parcelable.Creator<ResolveAccountResponse> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(ResolveAccountResponse resolveAccountResponse, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, resolveAccountResponse.f998a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, resolveAccountResponse.b, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, (Parcelable) resolveAccountResponse.b(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, resolveAccountResponse.c());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, resolveAccountResponse.d());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ResolveAccountResponse createFromParcel(Parcel parcel) {
        ConnectionResult connectionResult = null;
        boolean z = false;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        boolean z2 = false;
        IBinder iBinder = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    iBinder = com.google.android.gms.common.internal.safeparcel.zza.q(parcel, a2);
                    break;
                case 3:
                    connectionResult = (ConnectionResult) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, ConnectionResult.CREATOR);
                    break;
                case 4:
                    z2 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 5:
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
        return new ResolveAccountResponse(i, iBinder, connectionResult, z2, z);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ResolveAccountResponse[] newArray(int i) {
        return new ResolveAccountResponse[i];
    }
}
