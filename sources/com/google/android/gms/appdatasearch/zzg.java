package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.appdatasearch.GetRecentContextCall;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.xiaomi.licensinglibrary.LicenseErrCode;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class zzg implements Parcelable.Creator<GetRecentContextCall.Response> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(GetRecentContextCall.Response response, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, response.d);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, (Parcelable) response.f762a, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.c(parcel, 2, response.b, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, response.c, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public GetRecentContextCall.Response createFromParcel(Parcel parcel) {
        String[] B;
        ArrayList arrayList;
        Status status;
        int i;
        String[] strArr = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i2 = 0;
        ArrayList arrayList2 = null;
        Status status2 = null;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i = i2;
                    ArrayList arrayList3 = arrayList2;
                    status = (Status) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, Status.CREATOR);
                    B = strArr;
                    arrayList = arrayList3;
                    break;
                case 2:
                    status = status2;
                    i = i2;
                    String[] strArr2 = strArr;
                    arrayList = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2, UsageInfo.CREATOR);
                    B = strArr2;
                    break;
                case 3:
                    B = com.google.android.gms.common.internal.safeparcel.zza.B(parcel, a2);
                    arrayList = arrayList2;
                    status = status2;
                    i = i2;
                    break;
                case LicenseErrCode.LICENSE_STATUS_NOT_LICENSED /* 1000 */:
                    String[] strArr3 = strArr;
                    arrayList = arrayList2;
                    status = status2;
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    B = strArr3;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    B = strArr;
                    arrayList = arrayList2;
                    status = status2;
                    i = i2;
                    break;
            }
            i2 = i;
            status2 = status;
            arrayList2 = arrayList;
            strArr = B;
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new GetRecentContextCall.Response(i2, status2, arrayList2, strArr);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public GetRecentContextCall.Response[] newArray(int i) {
        return new GetRecentContextCall.Response[i];
    }
}
