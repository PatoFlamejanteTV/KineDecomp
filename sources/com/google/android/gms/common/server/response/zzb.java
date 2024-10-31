package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.server.response.FieldMappingDictionary;

/* loaded from: classes.dex */
public class zzb implements Parcelable.Creator<FieldMappingDictionary.FieldMapPair> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(FieldMappingDictionary.FieldMapPair fieldMapPair, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, fieldMapPair.f1036a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, fieldMapPair.b, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, (Parcelable) fieldMapPair.c, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public FieldMappingDictionary.FieldMapPair createFromParcel(Parcel parcel) {
        FastJsonResponse.Field field = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
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
                    field = (FastJsonResponse.Field) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, FastJsonResponse.Field.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new FieldMappingDictionary.FieldMapPair(i, str, field);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public FieldMappingDictionary.FieldMapPair[] newArray(int i) {
        return new FieldMappingDictionary.FieldMapPair[i];
    }
}
