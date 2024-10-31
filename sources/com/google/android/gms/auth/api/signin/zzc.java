package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes.dex */
public class zzc implements Parcelable.Creator<GoogleSignInAccount> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(GoogleSignInAccount googleSignInAccount, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, googleSignInAccount.b);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, googleSignInAccount.a(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, googleSignInAccount.b(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, googleSignInAccount.c(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, googleSignInAccount.d(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, (Parcelable) googleSignInAccount.e(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 7, googleSignInAccount.f(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 8, googleSignInAccount.g());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public GoogleSignInAccount createFromParcel(Parcel parcel) {
        String str = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        long j = 0;
        Uri uri = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    str5 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 3:
                    str4 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 4:
                    str3 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 5:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 6:
                    uri = (Uri) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, Uri.CREATOR);
                    break;
                case 7:
                    str = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 8:
                    j = com.google.android.gms.common.internal.safeparcel.zza.i(parcel, a2);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new GoogleSignInAccount(i, str5, str4, str3, str2, uri, str, j);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public GoogleSignInAccount[] newArray(int i) {
        return new GoogleSignInAccount[i];
    }
}
