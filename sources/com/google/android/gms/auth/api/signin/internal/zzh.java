package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.EmailSignInConfig;
import com.google.android.gms.auth.api.signin.FacebookSignInConfig;
import com.google.android.gms.auth.api.signin.GoogleSignInConfig;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes.dex */
public class zzh implements Parcelable.Creator<SignInConfiguration> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(SignInConfiguration signInConfiguration, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, signInConfiguration.f808a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, signInConfiguration.a(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, signInConfiguration.b(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, (Parcelable) signInConfiguration.c(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, (Parcelable) signInConfiguration.d(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, (Parcelable) signInConfiguration.e(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 7, signInConfiguration.f(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public SignInConfiguration createFromParcel(Parcel parcel) {
        String str = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        FacebookSignInConfig facebookSignInConfig = null;
        GoogleSignInConfig googleSignInConfig = null;
        EmailSignInConfig emailSignInConfig = null;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    str3 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 3:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 4:
                    emailSignInConfig = (EmailSignInConfig) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, EmailSignInConfig.CREATOR);
                    break;
                case 5:
                    googleSignInConfig = (GoogleSignInConfig) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, GoogleSignInConfig.CREATOR);
                    break;
                case 6:
                    facebookSignInConfig = (FacebookSignInConfig) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, FacebookSignInConfig.CREATOR);
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
        return new SignInConfiguration(i, str3, str2, emailSignInConfig, googleSignInConfig, facebookSignInConfig, str);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public SignInConfiguration[] newArray(int i) {
        return new SignInConfiguration[i];
    }
}
