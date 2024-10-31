package com.google.android.gms.drive.events;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class zze implements Parcelable.Creator<CompletionEvent> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(CompletionEvent completionEvent, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, completionEvent.f1070a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, (Parcelable) completionEvent.b, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, completionEvent.c, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, (Parcelable) completionEvent.d, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, (Parcelable) completionEvent.e, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, (Parcelable) completionEvent.f, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.b(parcel, 7, completionEvent.g, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 8, completionEvent.h);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 9, completionEvent.i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public CompletionEvent createFromParcel(Parcel parcel) {
        int i = 0;
        IBinder iBinder = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        ArrayList<String> arrayList = null;
        MetadataBundle metadataBundle = null;
        ParcelFileDescriptor parcelFileDescriptor = null;
        ParcelFileDescriptor parcelFileDescriptor2 = null;
        String str = null;
        DriveId driveId = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    driveId = (DriveId) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, DriveId.CREATOR);
                    break;
                case 3:
                    str = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 4:
                    parcelFileDescriptor2 = (ParcelFileDescriptor) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, ParcelFileDescriptor.CREATOR);
                    break;
                case 5:
                    parcelFileDescriptor = (ParcelFileDescriptor) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, ParcelFileDescriptor.CREATOR);
                    break;
                case 6:
                    metadataBundle = (MetadataBundle) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, MetadataBundle.CREATOR);
                    break;
                case 7:
                    arrayList = com.google.android.gms.common.internal.safeparcel.zza.D(parcel, a2);
                    break;
                case 8:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 9:
                    iBinder = com.google.android.gms.common.internal.safeparcel.zza.q(parcel, a2);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new CompletionEvent(i2, driveId, str, parcelFileDescriptor2, parcelFileDescriptor, metadataBundle, arrayList, i, iBinder);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public CompletionEvent[] newArray(int i) {
        return new CompletionEvent[i];
    }
}
