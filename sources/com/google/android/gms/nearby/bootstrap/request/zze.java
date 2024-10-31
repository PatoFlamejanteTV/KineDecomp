package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.xiaomi.licensinglibrary.LicenseErrCode;

/* loaded from: classes.dex */
public class zze implements Parcelable.Creator<EnableTargetRequest> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(EnableTargetRequest enableTargetRequest, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, enableTargetRequest.a(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, enableTargetRequest.f2088a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, enableTargetRequest.b(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, enableTargetRequest.d(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, enableTargetRequest.e(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, enableTargetRequest.f(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, enableTargetRequest.c());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public EnableTargetRequest createFromParcel(Parcel parcel) {
        byte b = 0;
        IBinder iBinder = null;
        int b2 = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        String str = null;
        String str2 = null;
        int i = 0;
        while (parcel.dataPosition() < b2) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 2:
                    str = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 3:
                    iBinder3 = com.google.android.gms.common.internal.safeparcel.zza.q(parcel, a2);
                    break;
                case 4:
                    iBinder2 = com.google.android.gms.common.internal.safeparcel.zza.q(parcel, a2);
                    break;
                case 5:
                    iBinder = com.google.android.gms.common.internal.safeparcel.zza.q(parcel, a2);
                    break;
                case 6:
                    b = com.google.android.gms.common.internal.safeparcel.zza.e(parcel, a2);
                    break;
                case LicenseErrCode.LICENSE_STATUS_NOT_LICENSED /* 1000 */:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b2) {
            throw new zza.C0032zza("Overread allowed size end=" + b2, parcel);
        }
        return new EnableTargetRequest(i, str2, str, b, iBinder3, iBinder2, iBinder);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public EnableTargetRequest[] newArray(int i) {
        return new EnableTargetRequest[i];
    }
}
