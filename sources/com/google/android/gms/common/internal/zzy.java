package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes.dex */
public class zzy implements Parcelable.Creator<ResolveAccountRequest> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(ResolveAccountRequest resolveAccountRequest, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, resolveAccountRequest.f997a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, (Parcelable) resolveAccountRequest.a(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, resolveAccountRequest.b());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ResolveAccountRequest createFromParcel(Parcel parcel) {
        int g;
        Account account;
        int i;
        int i2 = 0;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        Account account2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    int i4 = i2;
                    account = account2;
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    g = i4;
                    break;
                case 2:
                    Account account3 = (Account) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, Account.CREATOR);
                    i = i3;
                    g = i2;
                    account = account3;
                    break;
                case 3:
                    g = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    account = account2;
                    i = i3;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    g = i2;
                    account = account2;
                    i = i3;
                    break;
            }
            i3 = i;
            account2 = account;
            i2 = g;
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new ResolveAccountRequest(i3, account2, i2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ResolveAccountRequest[] newArray(int i) {
        return new ResolveAccountRequest[i];
    }
}
