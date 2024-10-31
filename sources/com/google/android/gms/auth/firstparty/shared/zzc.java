package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class zzc implements Parcelable.Creator<ScopeDetail> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(ScopeDetail scopeDetail, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, scopeDetail.f816a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, scopeDetail.b, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, scopeDetail.c, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, scopeDetail.d, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, scopeDetail.e, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, scopeDetail.f, false);
        com.google.android.gms.common.internal.safeparcel.zzb.b(parcel, 7, scopeDetail.g, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 8, (Parcelable) scopeDetail.h, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ScopeDetail createFromParcel(Parcel parcel) {
        FACLData fACLData = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        ArrayList<String> arrayList = new ArrayList<>();
        String str = null;
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
                    str = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 7:
                    arrayList = com.google.android.gms.common.internal.safeparcel.zza.D(parcel, a2);
                    break;
                case 8:
                    fACLData = (FACLData) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, FACLData.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new ScopeDetail(i, str5, str4, str3, str2, str, arrayList, fACLData);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ScopeDetail[] newArray(int i) {
        return new ScopeDetail[i];
    }
}
