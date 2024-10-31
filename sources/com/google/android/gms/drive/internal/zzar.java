package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.DriveId;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class zzar implements Parcelable.Creator<LoadRealtimeRequest> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(LoadRealtimeRequest loadRealtimeRequest, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, loadRealtimeRequest.f1098a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, (Parcelable) loadRealtimeRequest.b, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, loadRealtimeRequest.c);
        com.google.android.gms.common.internal.safeparcel.zzb.b(parcel, 4, loadRealtimeRequest.d, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, loadRealtimeRequest.e);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, (Parcelable) loadRealtimeRequest.f, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 7, loadRealtimeRequest.g, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public LoadRealtimeRequest createFromParcel(Parcel parcel) {
        boolean z = false;
        String str = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        DataHolder dataHolder = null;
        ArrayList<String> arrayList = null;
        boolean z2 = false;
        DriveId driveId = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    driveId = (DriveId) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, DriveId.CREATOR);
                    break;
                case 3:
                    z2 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 4:
                    arrayList = com.google.android.gms.common.internal.safeparcel.zza.D(parcel, a2);
                    break;
                case 5:
                    z = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 6:
                    dataHolder = (DataHolder) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, DataHolder.CREATOR);
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
        return new LoadRealtimeRequest(i, driveId, z2, arrayList, z, dataHolder, str);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public LoadRealtimeRequest[] newArray(int i) {
        return new LoadRealtimeRequest[i];
    }
}
