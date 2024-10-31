package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.plus.internal.model.people.PersonEntity;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class zzg implements Parcelable.Creator<PersonEntity.NameEntity> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(PersonEntity.NameEntity nameEntity, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        Set<Integer> set = nameEntity.f2170a;
        if (set.contains(1)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, nameEntity.b);
        }
        if (set.contains(2)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, nameEntity.c, true);
        }
        if (set.contains(3)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, nameEntity.d, true);
        }
        if (set.contains(4)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, nameEntity.e, true);
        }
        if (set.contains(5)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, nameEntity.f, true);
        }
        if (set.contains(6)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, nameEntity.g, true);
        }
        if (set.contains(7)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 7, nameEntity.h, true);
        }
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public PersonEntity.NameEntity createFromParcel(Parcel parcel) {
        String str = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        HashSet hashSet = new HashSet();
        int i = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    hashSet.add(1);
                    break;
                case 2:
                    str6 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    hashSet.add(2);
                    break;
                case 3:
                    str5 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    hashSet.add(3);
                    break;
                case 4:
                    str4 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    hashSet.add(4);
                    break;
                case 5:
                    str3 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    hashSet.add(5);
                    break;
                case 6:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    hashSet.add(6);
                    break;
                case 7:
                    str = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    hashSet.add(7);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new PersonEntity.NameEntity(hashSet, i, str6, str5, str4, str3, str2, str);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public PersonEntity.NameEntity[] newArray(int i) {
        return new PersonEntity.NameEntity[i];
    }
}
