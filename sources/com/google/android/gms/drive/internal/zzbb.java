package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.ChangesAvailableEvent;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.events.ProgressEvent;
import com.google.android.gms.drive.events.QueryResultEventParcelable;

/* loaded from: classes2.dex */
public class zzbb implements Parcelable.Creator<OnEventResponse> {
    public static void a(OnEventResponse onEventResponse, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, onEventResponse.f1105a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, onEventResponse.b);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, (Parcelable) onEventResponse.c, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, (Parcelable) onEventResponse.d, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, (Parcelable) onEventResponse.e, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 7, (Parcelable) onEventResponse.f, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 8, (Parcelable) onEventResponse.g, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public OnEventResponse createFromParcel(Parcel parcel) {
        int i = 0;
        ProgressEvent progressEvent = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        ChangesAvailableEvent changesAvailableEvent = null;
        QueryResultEventParcelable queryResultEventParcelable = null;
        CompletionEvent completionEvent = null;
        ChangeEvent changeEvent = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 2:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    break;
                case 3:
                    changeEvent = (ChangeEvent) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, ChangeEvent.CREATOR);
                    break;
                case 4:
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
                case 5:
                    completionEvent = (CompletionEvent) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, CompletionEvent.CREATOR);
                    break;
                case 6:
                    queryResultEventParcelable = (QueryResultEventParcelable) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, QueryResultEventParcelable.CREATOR);
                    break;
                case 7:
                    changesAvailableEvent = (ChangesAvailableEvent) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, ChangesAvailableEvent.CREATOR);
                    break;
                case 8:
                    progressEvent = (ProgressEvent) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, ProgressEvent.CREATOR);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new OnEventResponse(i2, i, changeEvent, completionEvent, queryResultEventParcelable, changesAvailableEvent, progressEvent);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public OnEventResponse[] newArray(int i) {
        return new OnEventResponse[i];
    }
}
