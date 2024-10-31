package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes.dex */
public class zzg implements Parcelable.Creator<RecordConsentRequest> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(RecordConsentRequest recordConsentRequest, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, recordConsentRequest.f2195a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, (Parcelable) recordConsentRequest.a(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, (Parcelable[]) recordConsentRequest.b(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, recordConsentRequest.c(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public RecordConsentRequest createFromParcel(Parcel parcel) {
        String p;
        Scope[] scopeArr;
        Account account;
        int i;
        String str = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i2 = 0;
        Scope[] scopeArr2 = null;
        Account account2 = null;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    String str2 = str;
                    scopeArr = scopeArr2;
                    account = account2;
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    p = str2;
                    break;
                case 2:
                    i = i2;
                    Scope[] scopeArr3 = scopeArr2;
                    account = (Account) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, Account.CREATOR);
                    p = str;
                    scopeArr = scopeArr3;
                    break;
                case 3:
                    account = account2;
                    i = i2;
                    String str3 = str;
                    scopeArr = (Scope[]) com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2, Scope.CREATOR);
                    p = str3;
                    break;
                case 4:
                    p = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    scopeArr = scopeArr2;
                    account = account2;
                    i = i2;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    p = str;
                    scopeArr = scopeArr2;
                    account = account2;
                    i = i2;
                    break;
            }
            i2 = i;
            account2 = account;
            scopeArr2 = scopeArr;
            str = p;
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new RecordConsentRequest(i2, account2, scopeArr2, str);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public RecordConsentRequest[] newArray(int i) {
        return new RecordConsentRequest[i];
    }
}
