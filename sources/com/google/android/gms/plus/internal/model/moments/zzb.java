package com.google.android.gms.plus.internal.model.moments;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class zzb implements Parcelable.Creator<MomentEntity> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(MomentEntity momentEntity, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        Set<Integer> set = momentEntity.f2163a;
        if (set.contains(1)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, momentEntity.b);
        }
        if (set.contains(2)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, momentEntity.c, true);
        }
        if (set.contains(4)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, (Parcelable) momentEntity.d, i, true);
        }
        if (set.contains(5)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, momentEntity.e, true);
        }
        if (set.contains(6)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, (Parcelable) momentEntity.f, i, true);
        }
        if (set.contains(7)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 7, momentEntity.g, true);
        }
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public MomentEntity createFromParcel(Parcel parcel) {
        String str = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        HashSet hashSet = new HashSet();
        int i = 0;
        ItemScopeEntity itemScopeEntity = null;
        String str2 = null;
        ItemScopeEntity itemScopeEntity2 = null;
        String str3 = null;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    hashSet.add(1);
                    break;
                case 2:
                    str3 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    hashSet.add(2);
                    break;
                case 3:
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
                case 4:
                    ItemScopeEntity itemScopeEntity3 = (ItemScopeEntity) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, ItemScopeEntity.CREATOR);
                    hashSet.add(4);
                    itemScopeEntity2 = itemScopeEntity3;
                    break;
                case 5:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    hashSet.add(5);
                    break;
                case 6:
                    ItemScopeEntity itemScopeEntity4 = (ItemScopeEntity) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, ItemScopeEntity.CREATOR);
                    hashSet.add(6);
                    itemScopeEntity = itemScopeEntity4;
                    break;
                case 7:
                    str = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    hashSet.add(7);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new MomentEntity(hashSet, i, str3, itemScopeEntity2, str2, itemScopeEntity, str);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public MomentEntity[] newArray(int i) {
        return new MomentEntity[i];
    }
}
