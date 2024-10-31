package com.google.android.gms.auth.api.proxy;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.xiaomi.licensinglibrary.LicenseErrCode;

/* loaded from: classes.dex */
public class zzb implements Parcelable.Creator<ProxyRequest> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(ProxyRequest proxyRequest, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, proxyRequest.k, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, proxyRequest.j);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, proxyRequest.l);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, proxyRequest.m);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, proxyRequest.n, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, proxyRequest.o, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ProxyRequest createFromParcel(Parcel parcel) {
        int i = 0;
        Bundle bundle = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        long j = 0;
        byte[] bArr = null;
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    str = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 2:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 3:
                    j = com.google.android.gms.common.internal.safeparcel.zza.i(parcel, a2);
                    break;
                case 4:
                    bArr = com.google.android.gms.common.internal.safeparcel.zza.s(parcel, a2);
                    break;
                case 5:
                    bundle = com.google.android.gms.common.internal.safeparcel.zza.r(parcel, a2);
                    break;
                case LicenseErrCode.LICENSE_STATUS_NOT_LICENSED /* 1000 */:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new ProxyRequest(i2, str, i, j, bArr, bundle);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ProxyRequest[] newArray(int i) {
        return new ProxyRequest[i];
    }
}
