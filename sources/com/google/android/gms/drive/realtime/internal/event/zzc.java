package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class zzc implements Parcelable.Creator<ParcelableEvent> {
    public static void a(ParcelableEvent parcelableEvent, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, parcelableEvent.f1178a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, parcelableEvent.b, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, parcelableEvent.c, false);
        com.google.android.gms.common.internal.safeparcel.zzb.b(parcel, 4, parcelableEvent.d, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, parcelableEvent.e);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, parcelableEvent.h, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 7, parcelableEvent.i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 8, (Parcelable) parcelableEvent.j, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 9, (Parcelable) parcelableEvent.k, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 10, (Parcelable) parcelableEvent.l, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 11, (Parcelable) parcelableEvent.m, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 12, (Parcelable) parcelableEvent.n, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 13, (Parcelable) parcelableEvent.o, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 14, (Parcelable) parcelableEvent.p, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 15, (Parcelable) parcelableEvent.q, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 17, parcelableEvent.g);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 16, parcelableEvent.f);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 18, (Parcelable) parcelableEvent.r, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public ParcelableEvent createFromParcel(Parcel parcel) {
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        ArrayList<String> arrayList = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        String str3 = null;
        String str4 = null;
        TextInsertedDetails textInsertedDetails = null;
        TextDeletedDetails textDeletedDetails = null;
        ValuesAddedDetails valuesAddedDetails = null;
        ValuesRemovedDetails valuesRemovedDetails = null;
        ValuesSetDetails valuesSetDetails = null;
        ValueChangedDetails valueChangedDetails = null;
        ReferenceShiftedDetails referenceShiftedDetails = null;
        ObjectChangedDetails objectChangedDetails = null;
        FieldChangedDetails fieldChangedDetails = null;
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
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 4:
                    arrayList = com.google.android.gms.common.internal.safeparcel.zza.D(parcel, a2);
                    break;
                case 5:
                    z = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 6:
                    str3 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 7:
                    str4 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    break;
                case 8:
                    textInsertedDetails = (TextInsertedDetails) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, TextInsertedDetails.CREATOR);
                    break;
                case 9:
                    textDeletedDetails = (TextDeletedDetails) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, TextDeletedDetails.CREATOR);
                    break;
                case 10:
                    valuesAddedDetails = (ValuesAddedDetails) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, ValuesAddedDetails.CREATOR);
                    break;
                case 11:
                    valuesRemovedDetails = (ValuesRemovedDetails) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, ValuesRemovedDetails.CREATOR);
                    break;
                case 12:
                    valuesSetDetails = (ValuesSetDetails) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, ValuesSetDetails.CREATOR);
                    break;
                case 13:
                    valueChangedDetails = (ValueChangedDetails) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, ValueChangedDetails.CREATOR);
                    break;
                case 14:
                    referenceShiftedDetails = (ReferenceShiftedDetails) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, ReferenceShiftedDetails.CREATOR);
                    break;
                case 15:
                    objectChangedDetails = (ObjectChangedDetails) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, ObjectChangedDetails.CREATOR);
                    break;
                case 16:
                    z2 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 17:
                    z3 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    break;
                case 18:
                    fieldChangedDetails = (FieldChangedDetails) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, FieldChangedDetails.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new ParcelableEvent(i, str, str2, arrayList, z, z2, z3, str3, str4, textInsertedDetails, textDeletedDetails, valuesAddedDetails, valuesRemovedDetails, valuesSetDetails, valueChangedDetails, referenceShiftedDetails, objectChangedDetails, fieldChangedDetails);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public ParcelableEvent[] newArray(int i) {
        return new ParcelableEvent[i];
    }
}
