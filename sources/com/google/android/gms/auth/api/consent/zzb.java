package com.google.android.gms.auth.api.consent;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.firstparty.shared.ScopeDetail;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes.dex */
public class zzb implements Parcelable.Creator<GetConsentIntentRequest> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(GetConsentIntentRequest getConsentIntentRequest, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, getConsentIntentRequest.a());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, getConsentIntentRequest.b(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, getConsentIntentRequest.c());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, getConsentIntentRequest.d(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, (Parcelable) getConsentIntentRequest.e(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, (Parcelable[]) getConsentIntentRequest.f786a, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 7, getConsentIntentRequest.f());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 8, getConsentIntentRequest.g());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public GetConsentIntentRequest createFromParcel(Parcel parcel) {
        ScopeDetail[] scopeDetailArr = null;
        int i = 0;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        boolean z = false;
        Account account = null;
        String str = null;
        int i2 = 0;
        String str2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i3 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 3:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 4:
                    str = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 5:
                    account = (Account) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, Account.CREATOR);
                    break;
                case 6:
                    scopeDetailArr = (ScopeDetail[]) com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2, ScopeDetail.CREATOR);
                    break;
                case 7:
                    z = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 8:
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
        return new GetConsentIntentRequest(i3, str2, i2, str, account, scopeDetailArr, z, i);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public GetConsentIntentRequest[] newArray(int i) {
        return new GetConsentIntentRequest[i];
    }
}
