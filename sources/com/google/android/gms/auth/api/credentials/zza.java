package com.google.android.gms.auth.api.credentials;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.xiaomi.licensinglibrary.LicenseErrCode;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class zza implements Parcelable.Creator<Credential> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Credential credential, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, credential.a(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, credential.f787a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, credential.b(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, (Parcelable) credential.c(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.c(parcel, 4, credential.d(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, credential.e(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, credential.g(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 7, credential.f(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 8, credential.h(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Credential createFromParcel(Parcel parcel) {
        String str = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        ArrayList arrayList = null;
        Uri uri = null;
        String str5 = null;
        String str6 = null;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    str6 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 2:
                    str5 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 3:
                    uri = (Uri) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, Uri.CREATOR);
                    break;
                case 4:
                    arrayList = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2, IdToken.CREATOR);
                    break;
                case 5:
                    str4 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 6:
                    str3 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 7:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 8:
                    str = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case LicenseErrCode.LICENSE_STATUS_NOT_LICENSED /* 1000 */:
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
        return new Credential(i, str6, str5, uri, arrayList, str4, str3, str2, str);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Credential[] newArray(int i) {
        return new Credential[i];
    }
}
