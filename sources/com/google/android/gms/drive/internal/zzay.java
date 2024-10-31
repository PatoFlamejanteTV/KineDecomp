package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.DriveFileRange;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class zzay implements Parcelable.Creator<OnDownloadProgressResponse> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(OnDownloadProgressResponse onDownloadProgressResponse, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, onDownloadProgressResponse.f1102a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, onDownloadProgressResponse.b);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, onDownloadProgressResponse.c);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, onDownloadProgressResponse.d);
        com.google.android.gms.common.internal.safeparcel.zzb.c(parcel, 5, onDownloadProgressResponse.e, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public OnDownloadProgressResponse createFromParcel(Parcel parcel) {
        long j = 0;
        int i = 0;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        ArrayList arrayList = null;
        long j2 = 0;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    j2 = com.google.android.gms.common.internal.safeparcel.zza.i(parcel, a2);
                    break;
                case 3:
                    j = com.google.android.gms.common.internal.safeparcel.zza.i(parcel, a2);
                    break;
                case 4:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 5:
                    arrayList = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2, DriveFileRange.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new OnDownloadProgressResponse(i2, j2, j, i, arrayList);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public OnDownloadProgressResponse[] newArray(int i) {
        return new OnDownloadProgressResponse[i];
    }
}
