package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes.dex */
public class zza implements Parcelable.Creator<EmailSignInConfig> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(EmailSignInConfig emailSignInConfig, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, emailSignInConfig.f803a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, (Parcelable) emailSignInConfig.a(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, emailSignInConfig.c(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, (Parcelable) emailSignInConfig.b(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public EmailSignInConfig createFromParcel(Parcel parcel) {
        Uri uri;
        String str;
        Uri uri2;
        int i;
        Uri uri3 = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i2 = 0;
        String str2 = null;
        Uri uri4 = null;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    Uri uri5 = uri3;
                    str = str2;
                    uri2 = uri4;
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    uri = uri5;
                    break;
                case 2:
                    i = i2;
                    String str3 = str2;
                    uri2 = (Uri) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, Uri.CREATOR);
                    uri = uri3;
                    str = str3;
                    break;
                case 3:
                    uri2 = uri4;
                    i = i2;
                    Uri uri6 = uri3;
                    str = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    uri = uri6;
                    break;
                case 4:
                    uri = (Uri) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, Uri.CREATOR);
                    str = str2;
                    uri2 = uri4;
                    i = i2;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    uri = uri3;
                    str = str2;
                    uri2 = uri4;
                    i = i2;
                    break;
            }
            i2 = i;
            uri4 = uri2;
            str2 = str;
            uri3 = uri;
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new EmailSignInConfig(i2, uri4, str2, uri3);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public EmailSignInConfig[] newArray(int i) {
        return new EmailSignInConfig[i];
    }
}
