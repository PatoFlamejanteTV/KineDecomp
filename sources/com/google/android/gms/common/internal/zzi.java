package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes.dex */
public class zzi implements Parcelable.Creator<GetServiceRequest> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(GetServiceRequest getServiceRequest, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, getServiceRequest.f996a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, getServiceRequest.b);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, getServiceRequest.c);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, getServiceRequest.d, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, getServiceRequest.e, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, (Parcelable[]) getServiceRequest.f, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 7, getServiceRequest.g, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 8, (Parcelable) getServiceRequest.h, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public GetServiceRequest createFromParcel(Parcel parcel) {
        int i = 0;
        Account account = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        Bundle bundle = null;
        Scope[] scopeArr = null;
        IBinder iBinder = null;
        String str = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i3 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 3:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 4:
                    str = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 5:
                    iBinder = com.google.android.gms.common.internal.safeparcel.zza.q(parcel, a2);
                    break;
                case 6:
                    scopeArr = (Scope[]) com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2, Scope.CREATOR);
                    break;
                case 7:
                    bundle = com.google.android.gms.common.internal.safeparcel.zza.r(parcel, a2);
                    break;
                case 8:
                    account = (Account) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, Account.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new GetServiceRequest(i3, i2, i, str, iBinder, scopeArr, bundle, account);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public GetServiceRequest[] newArray(int i) {
        return new GetServiceRequest[i];
    }
}
