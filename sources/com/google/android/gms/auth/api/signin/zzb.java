package com.google.android.gms.auth.api.signin;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class zzb implements Parcelable.Creator<FacebookSignInConfig> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(FacebookSignInConfig facebookSignInConfig, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, facebookSignInConfig.f804a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, (Parcelable) facebookSignInConfig.a(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.b(parcel, 3, facebookSignInConfig.b(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public FacebookSignInConfig createFromParcel(Parcel parcel) {
        ArrayList<String> D;
        Intent intent;
        int i;
        ArrayList<String> arrayList = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i2 = 0;
        Intent intent2 = null;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    ArrayList<String> arrayList2 = arrayList;
                    intent = intent2;
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    D = arrayList2;
                    break;
                case 2:
                    Intent intent3 = (Intent) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, Intent.CREATOR);
                    i = i2;
                    D = arrayList;
                    intent = intent3;
                    break;
                case 3:
                    D = com.google.android.gms.common.internal.safeparcel.zza.D(parcel, a2);
                    intent = intent2;
                    i = i2;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    D = arrayList;
                    intent = intent2;
                    i = i2;
                    break;
            }
            i2 = i;
            intent2 = intent;
            arrayList = D;
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new FacebookSignInConfig(i2, intent2, arrayList);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public FacebookSignInConfig[] newArray(int i) {
        return new FacebookSignInConfig[i];
    }
}
