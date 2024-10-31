package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes.dex */
public class zzc implements Parcelable.Creator<AuthAccountRequest> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(AuthAccountRequest authAccountRequest, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, authAccountRequest.f993a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, authAccountRequest.b, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, (Parcelable[]) authAccountRequest.c, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AuthAccountRequest createFromParcel(Parcel parcel) {
        Scope[] scopeArr = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        IBinder iBinder = null;
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
                    scopeArr = (Scope[]) com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2, Scope.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new AuthAccountRequest(i, iBinder, scopeArr);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AuthAccountRequest[] newArray(int i) {
        return new AuthAccountRequest[i];
    }
}
