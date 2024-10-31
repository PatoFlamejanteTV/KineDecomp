package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes.dex */
public class zzad implements Parcelable.Creator<ValidateAccountRequest> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(ValidateAccountRequest validateAccountRequest, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, validateAccountRequest.f999a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, validateAccountRequest.a());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, validateAccountRequest.b, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, (Parcelable[]) validateAccountRequest.b(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, validateAccountRequest.d(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, validateAccountRequest.c(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ValidateAccountRequest createFromParcel(Parcel parcel) {
        int i = 0;
        String str = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        Bundle bundle = null;
        Scope[] scopeArr = null;
        IBinder iBinder = null;
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
                    iBinder = com.google.android.gms.common.internal.safeparcel.zza.q(parcel, a2);
                    break;
                case 4:
                    scopeArr = (Scope[]) com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2, Scope.CREATOR);
                    break;
                case 5:
                    bundle = com.google.android.gms.common.internal.safeparcel.zza.r(parcel, a2);
                    break;
                case 6:
                    str = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new ValidateAccountRequest(i2, i, iBinder, scopeArr, bundle, str);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ValidateAccountRequest[] newArray(int i) {
        return new ValidateAccountRequest[i];
    }
}
