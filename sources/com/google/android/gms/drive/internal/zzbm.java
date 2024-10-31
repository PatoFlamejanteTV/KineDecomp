package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.query.internal.FilterHolder;

/* loaded from: classes2.dex */
public class zzbm implements Parcelable.Creator<OpenFileIntentSenderRequest> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(OpenFileIntentSenderRequest openFileIntentSenderRequest, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, openFileIntentSenderRequest.f1115a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, openFileIntentSenderRequest.b, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, openFileIntentSenderRequest.c, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, (Parcelable) openFileIntentSenderRequest.d, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, (Parcelable) openFileIntentSenderRequest.e, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public OpenFileIntentSenderRequest createFromParcel(Parcel parcel) {
        FilterHolder filterHolder = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        DriveId driveId = null;
        String[] strArr = null;
        String str = null;
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
                    strArr = com.google.android.gms.common.internal.safeparcel.zza.B(parcel, a2);
                    break;
                case 4:
                    driveId = (DriveId) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, DriveId.CREATOR);
                    break;
                case 5:
                    filterHolder = (FilterHolder) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, FilterHolder.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new OpenFileIntentSenderRequest(i, str, strArr, driveId, filterHolder);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public OpenFileIntentSenderRequest[] newArray(int i) {
        return new OpenFileIntentSenderRequest[i];
    }
}
