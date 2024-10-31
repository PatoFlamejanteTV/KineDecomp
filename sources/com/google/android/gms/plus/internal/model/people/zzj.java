package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.plus.internal.model.people.PersonEntity;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class zzj implements Parcelable.Creator<PersonEntity.UrlsEntity> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(PersonEntity.UrlsEntity urlsEntity, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        Set<Integer> set = urlsEntity.f2173a;
        if (set.contains(1)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, urlsEntity.b);
        }
        if (set.contains(3)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, urlsEntity.f());
        }
        if (set.contains(4)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, urlsEntity.e, true);
        }
        if (set.contains(5)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, urlsEntity.c, true);
        }
        if (set.contains(6)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, urlsEntity.d);
        }
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public PersonEntity.UrlsEntity createFromParcel(Parcel parcel) {
        String str = null;
        int i = 0;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        HashSet hashSet = new HashSet();
        int i2 = 0;
        String str2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i3 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    hashSet.add(1);
                    break;
                case 2:
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
                case 3:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    hashSet.add(3);
                    break;
                case 4:
                    str = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    hashSet.add(4);
                    break;
                case 5:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    hashSet.add(5);
                    break;
                case 6:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    hashSet.add(6);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new PersonEntity.UrlsEntity(hashSet, i3, str2, i2, str, i);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public PersonEntity.UrlsEntity[] newArray(int i) {
        return new PersonEntity.UrlsEntity[i];
    }
}
