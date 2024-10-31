package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.plus.internal.model.people.PersonEntity;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class zzc implements Parcelable.Creator<PersonEntity.CoverEntity> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(PersonEntity.CoverEntity coverEntity, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        Set<Integer> set = coverEntity.f2166a;
        if (set.contains(1)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, coverEntity.b);
        }
        if (set.contains(2)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, (Parcelable) coverEntity.c, i, true);
        }
        if (set.contains(3)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, (Parcelable) coverEntity.d, i, true);
        }
        if (set.contains(4)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, coverEntity.e);
        }
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public PersonEntity.CoverEntity createFromParcel(Parcel parcel) {
        PersonEntity.CoverEntity.CoverPhotoEntity coverPhotoEntity = null;
        int i = 0;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        HashSet hashSet = new HashSet();
        PersonEntity.CoverEntity.CoverInfoEntity coverInfoEntity = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    hashSet.add(1);
                    break;
                case 2:
                    PersonEntity.CoverEntity.CoverInfoEntity coverInfoEntity2 = (PersonEntity.CoverEntity.CoverInfoEntity) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, PersonEntity.CoverEntity.CoverInfoEntity.CREATOR);
                    hashSet.add(2);
                    coverInfoEntity = coverInfoEntity2;
                    break;
                case 3:
                    PersonEntity.CoverEntity.CoverPhotoEntity coverPhotoEntity2 = (PersonEntity.CoverEntity.CoverPhotoEntity) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, PersonEntity.CoverEntity.CoverPhotoEntity.CREATOR);
                    hashSet.add(3);
                    coverPhotoEntity = coverPhotoEntity2;
                    break;
                case 4:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    hashSet.add(4);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new PersonEntity.CoverEntity(hashSet, i2, coverInfoEntity, coverPhotoEntity, i);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public PersonEntity.CoverEntity[] newArray(int i) {
        return new PersonEntity.CoverEntity[i];
    }
}
