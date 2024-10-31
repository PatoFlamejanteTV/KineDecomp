package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class zze implements Parcelable.Creator<GoogleSignInConfig> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(GoogleSignInConfig googleSignInConfig, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, googleSignInConfig.e);
        com.google.android.gms.common.internal.safeparcel.zzb.c(parcel, 2, googleSignInConfig.a(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, (Parcelable) googleSignInConfig.b(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, googleSignInConfig.c());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, googleSignInConfig.d());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, googleSignInConfig.e());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 7, googleSignInConfig.f(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public GoogleSignInConfig createFromParcel(Parcel parcel) {
        String str = null;
        boolean z = false;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        boolean z2 = false;
        boolean z3 = false;
        Account account = null;
        ArrayList arrayList = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    arrayList = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2, Scope.CREATOR);
                    break;
                case 3:
                    account = (Account) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, Account.CREATOR);
                    break;
                case 4:
                    z3 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 5:
                    z2 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 6:
                    z = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 7:
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
        return new GoogleSignInConfig(i, (ArrayList<Scope>) arrayList, account, z3, z2, z, str);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public GoogleSignInConfig[] newArray(int i) {
        return new GoogleSignInConfig[i];
    }
}
