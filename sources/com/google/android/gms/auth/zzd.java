package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class zzd implements Parcelable.Creator<TokenData> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(TokenData tokenData, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, tokenData.f781a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, tokenData.a(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, tokenData.b(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, tokenData.c());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, tokenData.d());
        com.google.android.gms.common.internal.safeparcel.zzb.b(parcel, 6, tokenData.e(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public TokenData createFromParcel(Parcel parcel) {
        ArrayList<String> arrayList = null;
        boolean z = false;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        boolean z2 = false;
        Long l = null;
        String str = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    str = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 3:
                    l = com.google.android.gms.common.internal.safeparcel.zza.j(parcel, a2);
                    break;
                case 4:
                    z2 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 5:
                    z = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 6:
                    arrayList = com.google.android.gms.common.internal.safeparcel.zza.D(parcel, a2);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new TokenData(i, str, l, z2, z, arrayList);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public TokenData[] newArray(int i) {
        return new TokenData[i];
    }
}
