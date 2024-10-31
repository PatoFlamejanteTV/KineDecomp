package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class zzj implements Parcelable.Creator<RealtimeDocumentSyncRequest> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(RealtimeDocumentSyncRequest realtimeDocumentSyncRequest, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, realtimeDocumentSyncRequest.f1064a);
        com.google.android.gms.common.internal.safeparcel.zzb.b(parcel, 2, realtimeDocumentSyncRequest.b, false);
        com.google.android.gms.common.internal.safeparcel.zzb.b(parcel, 3, realtimeDocumentSyncRequest.c, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public RealtimeDocumentSyncRequest createFromParcel(Parcel parcel) {
        ArrayList<String> arrayList = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        ArrayList<String> arrayList2 = null;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    arrayList2 = com.google.android.gms.common.internal.safeparcel.zza.D(parcel, a2);
                    break;
                case 3:
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
        return new RealtimeDocumentSyncRequest(i, arrayList2, arrayList);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public RealtimeDocumentSyncRequest[] newArray(int i) {
        return new RealtimeDocumentSyncRequest[i];
    }
}
