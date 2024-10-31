package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.plus.internal.model.people.PersonEntity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class zza implements Parcelable.Creator<PersonEntity> {
    public static void a(PersonEntity personEntity, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        Set<Integer> set = personEntity.f2164a;
        if (set.contains(1)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, personEntity.b);
        }
        if (set.contains(2)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, personEntity.c, true);
        }
        if (set.contains(3)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, (Parcelable) personEntity.d, i, true);
        }
        if (set.contains(4)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, personEntity.e, true);
        }
        if (set.contains(5)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, personEntity.f, true);
        }
        if (set.contains(6)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, personEntity.g);
        }
        if (set.contains(7)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 7, (Parcelable) personEntity.h, i, true);
        }
        if (set.contains(8)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 8, personEntity.i, true);
        }
        if (set.contains(9)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 9, personEntity.j, true);
        }
        if (set.contains(12)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 12, personEntity.k);
        }
        if (set.contains(14)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 14, personEntity.l, true);
        }
        if (set.contains(15)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 15, (Parcelable) personEntity.m, i, true);
        }
        if (set.contains(16)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 16, personEntity.n);
        }
        if (set.contains(19)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 19, (Parcelable) personEntity.p, i, true);
        }
        if (set.contains(18)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 18, personEntity.o, true);
        }
        if (set.contains(21)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 21, personEntity.r);
        }
        if (set.contains(20)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 20, personEntity.q, true);
        }
        if (set.contains(23)) {
            com.google.android.gms.common.internal.safeparcel.zzb.c(parcel, 23, personEntity.t, true);
        }
        if (set.contains(22)) {
            com.google.android.gms.common.internal.safeparcel.zzb.c(parcel, 22, personEntity.s, true);
        }
        if (set.contains(25)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 25, personEntity.v);
        }
        if (set.contains(24)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 24, personEntity.u);
        }
        if (set.contains(27)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 27, personEntity.x, true);
        }
        if (set.contains(26)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 26, personEntity.w, true);
        }
        if (set.contains(29)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 29, personEntity.z);
        }
        if (set.contains(28)) {
            com.google.android.gms.common.internal.safeparcel.zzb.c(parcel, 28, personEntity.y, true);
        }
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public PersonEntity createFromParcel(Parcel parcel) {
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        HashSet hashSet = new HashSet();
        int i = 0;
        String str = null;
        PersonEntity.AgeRangeEntity ageRangeEntity = null;
        String str2 = null;
        String str3 = null;
        int i2 = 0;
        PersonEntity.CoverEntity coverEntity = null;
        String str4 = null;
        String str5 = null;
        int i3 = 0;
        String str6 = null;
        PersonEntity.ImageEntity imageEntity = null;
        boolean z = false;
        String str7 = null;
        PersonEntity.NameEntity nameEntity = null;
        String str8 = null;
        int i4 = 0;
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        int i5 = 0;
        int i6 = 0;
        String str9 = null;
        String str10 = null;
        ArrayList arrayList3 = null;
        boolean z2 = false;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    hashSet.add(1);
                    break;
                case 2:
                    str = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    hashSet.add(2);
                    break;
                case 3:
                    PersonEntity.AgeRangeEntity ageRangeEntity2 = (PersonEntity.AgeRangeEntity) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, PersonEntity.AgeRangeEntity.CREATOR);
                    hashSet.add(3);
                    ageRangeEntity = ageRangeEntity2;
                    break;
                case 4:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    hashSet.add(4);
                    break;
                case 5:
                    str3 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    hashSet.add(5);
                    break;
                case 6:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    hashSet.add(6);
                    break;
                case 7:
                    PersonEntity.CoverEntity coverEntity2 = (PersonEntity.CoverEntity) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, PersonEntity.CoverEntity.CREATOR);
                    hashSet.add(7);
                    coverEntity = coverEntity2;
                    break;
                case 8:
                    str4 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    hashSet.add(8);
                    break;
                case 9:
                    str5 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    hashSet.add(9);
                    break;
                case 10:
                case 11:
                case 13:
                case 17:
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
                case 12:
                    i3 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    hashSet.add(12);
                    break;
                case 14:
                    str6 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    hashSet.add(14);
                    break;
                case 15:
                    PersonEntity.ImageEntity imageEntity2 = (PersonEntity.ImageEntity) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, PersonEntity.ImageEntity.CREATOR);
                    hashSet.add(15);
                    imageEntity = imageEntity2;
                    break;
                case 16:
                    z = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    hashSet.add(16);
                    break;
                case 18:
                    str7 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    hashSet.add(18);
                    break;
                case 19:
                    PersonEntity.NameEntity nameEntity2 = (PersonEntity.NameEntity) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, PersonEntity.NameEntity.CREATOR);
                    hashSet.add(19);
                    nameEntity = nameEntity2;
                    break;
                case 20:
                    str8 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    hashSet.add(20);
                    break;
                case 21:
                    i4 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    hashSet.add(21);
                    break;
                case 22:
                    arrayList = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2, PersonEntity.OrganizationsEntity.CREATOR);
                    hashSet.add(22);
                    break;
                case 23:
                    arrayList2 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2, PersonEntity.PlacesLivedEntity.CREATOR);
                    hashSet.add(23);
                    break;
                case 24:
                    i5 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    hashSet.add(24);
                    break;
                case 25:
                    i6 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    hashSet.add(25);
                    break;
                case 26:
                    str9 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    hashSet.add(26);
                    break;
                case 27:
                    str10 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    hashSet.add(27);
                    break;
                case 28:
                    arrayList3 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2, PersonEntity.UrlsEntity.CREATOR);
                    hashSet.add(28);
                    break;
                case 29:
                    z2 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    hashSet.add(29);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new PersonEntity(hashSet, i, str, ageRangeEntity, str2, str3, i2, coverEntity, str4, str5, i3, str6, imageEntity, z, str7, nameEntity, str8, i4, arrayList, arrayList2, i5, i6, str9, str10, arrayList3, z2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public PersonEntity[] newArray(int i) {
        return new PersonEntity[i];
    }
}
