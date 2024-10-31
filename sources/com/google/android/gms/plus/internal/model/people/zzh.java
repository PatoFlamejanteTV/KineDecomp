package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.plus.internal.model.people.PersonEntity;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class zzh implements Parcelable.Creator<PersonEntity.OrganizationsEntity> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(PersonEntity.OrganizationsEntity organizationsEntity, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        Set<Integer> set = organizationsEntity.f2171a;
        if (set.contains(1)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, organizationsEntity.b);
        }
        if (set.contains(2)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, organizationsEntity.c, true);
        }
        if (set.contains(3)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, organizationsEntity.d, true);
        }
        if (set.contains(4)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, organizationsEntity.e, true);
        }
        if (set.contains(5)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, organizationsEntity.f, true);
        }
        if (set.contains(6)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, organizationsEntity.g, true);
        }
        if (set.contains(7)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 7, organizationsEntity.h);
        }
        if (set.contains(8)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 8, organizationsEntity.i, true);
        }
        if (set.contains(9)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 9, organizationsEntity.j, true);
        }
        if (set.contains(10)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 10, organizationsEntity.k);
        }
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public PersonEntity.OrganizationsEntity createFromParcel(Parcel parcel) {
        int i = 0;
        String str = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        HashSet hashSet = new HashSet();
        String str2 = null;
        boolean z = false;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    hashSet.add(1);
                    break;
                case 2:
                    str7 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    hashSet.add(2);
                    break;
                case 3:
                    str6 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    hashSet.add(3);
                    break;
                case 4:
                    str5 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    hashSet.add(4);
                    break;
                case 5:
                    str4 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    hashSet.add(5);
                    break;
                case 6:
                    str3 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    hashSet.add(6);
                    break;
                case 7:
                    z = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2);
                    hashSet.add(7);
                    break;
                case 8:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    hashSet.add(8);
                    break;
                case 9:
                    str = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    hashSet.add(9);
                    break;
                case 10:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    hashSet.add(10);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new PersonEntity.OrganizationsEntity(hashSet, i2, str7, str6, str5, str4, str3, z, str2, str, i);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public PersonEntity.OrganizationsEntity[] newArray(int i) {
        return new PersonEntity.OrganizationsEntity[i];
    }
}
