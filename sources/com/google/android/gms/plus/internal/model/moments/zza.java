package com.google.android.gms.plus.internal.model.moments;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class zza implements Parcelable.Creator<ItemScopeEntity> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(ItemScopeEntity itemScopeEntity, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        Set<Integer> set = itemScopeEntity.f2162a;
        if (set.contains(1)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, itemScopeEntity.b);
        }
        if (set.contains(2)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, (Parcelable) itemScopeEntity.c, i, true);
        }
        if (set.contains(3)) {
            com.google.android.gms.common.internal.safeparcel.zzb.b(parcel, 3, itemScopeEntity.d, true);
        }
        if (set.contains(4)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, (Parcelable) itemScopeEntity.e, i, true);
        }
        if (set.contains(5)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, itemScopeEntity.f, true);
        }
        if (set.contains(6)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, itemScopeEntity.g, true);
        }
        if (set.contains(7)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 7, itemScopeEntity.h, true);
        }
        if (set.contains(8)) {
            com.google.android.gms.common.internal.safeparcel.zzb.c(parcel, 8, itemScopeEntity.i, true);
        }
        if (set.contains(9)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 9, itemScopeEntity.j);
        }
        if (set.contains(10)) {
            com.google.android.gms.common.internal.safeparcel.zzb.c(parcel, 10, itemScopeEntity.k, true);
        }
        if (set.contains(11)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 11, (Parcelable) itemScopeEntity.l, i, true);
        }
        if (set.contains(12)) {
            com.google.android.gms.common.internal.safeparcel.zzb.c(parcel, 12, itemScopeEntity.m, true);
        }
        if (set.contains(13)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 13, itemScopeEntity.n, true);
        }
        if (set.contains(14)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 14, itemScopeEntity.o, true);
        }
        if (set.contains(15)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 15, (Parcelable) itemScopeEntity.p, i, true);
        }
        if (set.contains(17)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 17, itemScopeEntity.r, true);
        }
        if (set.contains(16)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 16, itemScopeEntity.q, true);
        }
        if (set.contains(19)) {
            com.google.android.gms.common.internal.safeparcel.zzb.c(parcel, 19, itemScopeEntity.t, true);
        }
        if (set.contains(18)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 18, itemScopeEntity.s, true);
        }
        if (set.contains(21)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 21, itemScopeEntity.v, true);
        }
        if (set.contains(20)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 20, itemScopeEntity.u, true);
        }
        if (set.contains(23)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 23, itemScopeEntity.x, true);
        }
        if (set.contains(22)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 22, itemScopeEntity.w, true);
        }
        if (set.contains(25)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 25, itemScopeEntity.z, true);
        }
        if (set.contains(24)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 24, itemScopeEntity.y, true);
        }
        if (set.contains(27)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 27, itemScopeEntity.B, true);
        }
        if (set.contains(26)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 26, itemScopeEntity.A, true);
        }
        if (set.contains(29)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 29, (Parcelable) itemScopeEntity.D, i, true);
        }
        if (set.contains(28)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 28, itemScopeEntity.C, true);
        }
        if (set.contains(31)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 31, itemScopeEntity.F, true);
        }
        if (set.contains(30)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 30, itemScopeEntity.E, true);
        }
        if (set.contains(34)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 34, (Parcelable) itemScopeEntity.I, i, true);
        }
        if (set.contains(32)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 32, itemScopeEntity.G, true);
        }
        if (set.contains(33)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 33, itemScopeEntity.H, true);
        }
        if (set.contains(38)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 38, itemScopeEntity.L);
        }
        if (set.contains(39)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 39, itemScopeEntity.M, true);
        }
        if (set.contains(36)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 36, itemScopeEntity.J);
        }
        if (set.contains(37)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 37, (Parcelable) itemScopeEntity.K, i, true);
        }
        if (set.contains(42)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 42, itemScopeEntity.P, true);
        }
        if (set.contains(43)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 43, itemScopeEntity.Q, true);
        }
        if (set.contains(40)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 40, (Parcelable) itemScopeEntity.N, i, true);
        }
        if (set.contains(41)) {
            com.google.android.gms.common.internal.safeparcel.zzb.c(parcel, 41, itemScopeEntity.O, true);
        }
        if (set.contains(46)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 46, (Parcelable) itemScopeEntity.T, i, true);
        }
        if (set.contains(47)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 47, itemScopeEntity.U, true);
        }
        if (set.contains(44)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 44, itemScopeEntity.R, true);
        }
        if (set.contains(45)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 45, itemScopeEntity.S, true);
        }
        if (set.contains(51)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 51, itemScopeEntity.Y, true);
        }
        if (set.contains(50)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 50, (Parcelable) itemScopeEntity.X, i, true);
        }
        if (set.contains(49)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 49, itemScopeEntity.W, true);
        }
        if (set.contains(48)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 48, itemScopeEntity.V, true);
        }
        if (set.contains(55)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 55, itemScopeEntity.ac, true);
        }
        if (set.contains(54)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 54, itemScopeEntity.ab, true);
        }
        if (set.contains(53)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 53, itemScopeEntity.aa, true);
        }
        if (set.contains(52)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 52, itemScopeEntity.Z, true);
        }
        if (set.contains(56)) {
            com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 56, itemScopeEntity.ad, true);
        }
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ItemScopeEntity createFromParcel(Parcel parcel) {
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        HashSet hashSet = new HashSet();
        int i = 0;
        ItemScopeEntity itemScopeEntity = null;
        ArrayList<String> arrayList = null;
        ItemScopeEntity itemScopeEntity2 = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        ArrayList arrayList2 = null;
        int i2 = 0;
        ArrayList arrayList3 = null;
        ItemScopeEntity itemScopeEntity3 = null;
        ArrayList arrayList4 = null;
        String str4 = null;
        String str5 = null;
        ItemScopeEntity itemScopeEntity4 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        ArrayList arrayList5 = null;
        String str9 = null;
        String str10 = null;
        String str11 = null;
        String str12 = null;
        String str13 = null;
        String str14 = null;
        String str15 = null;
        String str16 = null;
        String str17 = null;
        ItemScopeEntity itemScopeEntity5 = null;
        String str18 = null;
        String str19 = null;
        String str20 = null;
        String str21 = null;
        ItemScopeEntity itemScopeEntity6 = null;
        double d = 0.0d;
        ItemScopeEntity itemScopeEntity7 = null;
        double d2 = 0.0d;
        String str22 = null;
        ItemScopeEntity itemScopeEntity8 = null;
        ArrayList arrayList6 = null;
        String str23 = null;
        String str24 = null;
        String str25 = null;
        String str26 = null;
        ItemScopeEntity itemScopeEntity9 = null;
        String str27 = null;
        String str28 = null;
        String str29 = null;
        ItemScopeEntity itemScopeEntity10 = null;
        String str30 = null;
        String str31 = null;
        String str32 = null;
        String str33 = null;
        String str34 = null;
        String str35 = null;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    hashSet.add(1);
                    break;
                case 2:
                    ItemScopeEntity itemScopeEntity11 = (ItemScopeEntity) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, ItemScopeEntity.CREATOR);
                    hashSet.add(2);
                    itemScopeEntity = itemScopeEntity11;
                    break;
                case 3:
                    arrayList = com.google.android.gms.common.internal.safeparcel.zza.D(parcel, a2);
                    hashSet.add(3);
                    break;
                case 4:
                    ItemScopeEntity itemScopeEntity12 = (ItemScopeEntity) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, ItemScopeEntity.CREATOR);
                    hashSet.add(4);
                    itemScopeEntity2 = itemScopeEntity12;
                    break;
                case 5:
                    str = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    hashSet.add(5);
                    break;
                case 6:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    hashSet.add(6);
                    break;
                case 7:
                    str3 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    hashSet.add(7);
                    break;
                case 8:
                    arrayList2 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2, ItemScopeEntity.CREATOR);
                    hashSet.add(8);
                    break;
                case 9:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    hashSet.add(9);
                    break;
                case 10:
                    arrayList3 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2, ItemScopeEntity.CREATOR);
                    hashSet.add(10);
                    break;
                case 11:
                    ItemScopeEntity itemScopeEntity13 = (ItemScopeEntity) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, ItemScopeEntity.CREATOR);
                    hashSet.add(11);
                    itemScopeEntity3 = itemScopeEntity13;
                    break;
                case 12:
                    arrayList4 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2, ItemScopeEntity.CREATOR);
                    hashSet.add(12);
                    break;
                case 13:
                    str4 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    hashSet.add(13);
                    break;
                case 14:
                    str5 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    hashSet.add(14);
                    break;
                case 15:
                    ItemScopeEntity itemScopeEntity14 = (ItemScopeEntity) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, ItemScopeEntity.CREATOR);
                    hashSet.add(15);
                    itemScopeEntity4 = itemScopeEntity14;
                    break;
                case 16:
                    str6 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    hashSet.add(16);
                    break;
                case 17:
                    str7 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    hashSet.add(17);
                    break;
                case 18:
                    str8 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    hashSet.add(18);
                    break;
                case 19:
                    arrayList5 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2, ItemScopeEntity.CREATOR);
                    hashSet.add(19);
                    break;
                case 20:
                    str9 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    hashSet.add(20);
                    break;
                case 21:
                    str10 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    hashSet.add(21);
                    break;
                case 22:
                    str11 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    hashSet.add(22);
                    break;
                case 23:
                    str12 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    hashSet.add(23);
                    break;
                case 24:
                    str13 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    hashSet.add(24);
                    break;
                case 25:
                    str14 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    hashSet.add(25);
                    break;
                case 26:
                    str15 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    hashSet.add(26);
                    break;
                case 27:
                    str16 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    hashSet.add(27);
                    break;
                case 28:
                    str17 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    hashSet.add(28);
                    break;
                case 29:
                    ItemScopeEntity itemScopeEntity15 = (ItemScopeEntity) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, ItemScopeEntity.CREATOR);
                    hashSet.add(29);
                    itemScopeEntity5 = itemScopeEntity15;
                    break;
                case 30:
                    str18 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    hashSet.add(30);
                    break;
                case 31:
                    str19 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    hashSet.add(31);
                    break;
                case 32:
                    str20 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    hashSet.add(32);
                    break;
                case 33:
                    str21 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    hashSet.add(33);
                    break;
                case 34:
                    ItemScopeEntity itemScopeEntity16 = (ItemScopeEntity) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, ItemScopeEntity.CREATOR);
                    hashSet.add(34);
                    itemScopeEntity6 = itemScopeEntity16;
                    break;
                case 35:
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    break;
                case 36:
                    d = com.google.android.gms.common.internal.safeparcel.zza.n(parcel, a2);
                    hashSet.add(36);
                    break;
                case 37:
                    ItemScopeEntity itemScopeEntity17 = (ItemScopeEntity) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, ItemScopeEntity.CREATOR);
                    hashSet.add(37);
                    itemScopeEntity7 = itemScopeEntity17;
                    break;
                case 38:
                    d2 = com.google.android.gms.common.internal.safeparcel.zza.n(parcel, a2);
                    hashSet.add(38);
                    break;
                case 39:
                    str22 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    hashSet.add(39);
                    break;
                case 40:
                    ItemScopeEntity itemScopeEntity18 = (ItemScopeEntity) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, ItemScopeEntity.CREATOR);
                    hashSet.add(40);
                    itemScopeEntity8 = itemScopeEntity18;
                    break;
                case 41:
                    arrayList6 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a2, ItemScopeEntity.CREATOR);
                    hashSet.add(41);
                    break;
                case 42:
                    str23 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    hashSet.add(42);
                    break;
                case 43:
                    str24 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    hashSet.add(43);
                    break;
                case 44:
                    str25 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    hashSet.add(44);
                    break;
                case 45:
                    str26 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    hashSet.add(45);
                    break;
                case 46:
                    ItemScopeEntity itemScopeEntity19 = (ItemScopeEntity) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, ItemScopeEntity.CREATOR);
                    hashSet.add(46);
                    itemScopeEntity9 = itemScopeEntity19;
                    break;
                case 47:
                    str27 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    hashSet.add(47);
                    break;
                case 48:
                    str28 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    hashSet.add(48);
                    break;
                case 49:
                    str29 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    hashSet.add(49);
                    break;
                case 50:
                    ItemScopeEntity itemScopeEntity20 = (ItemScopeEntity) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a2, ItemScopeEntity.CREATOR);
                    hashSet.add(50);
                    itemScopeEntity10 = itemScopeEntity20;
                    break;
                case 51:
                    str30 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    hashSet.add(51);
                    break;
                case 52:
                    str31 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    hashSet.add(52);
                    break;
                case 53:
                    str32 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    hashSet.add(53);
                    break;
                case 54:
                    str33 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    hashSet.add(54);
                    break;
                case 55:
                    str34 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    hashSet.add(55);
                    break;
                case 56:
                    str35 = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    hashSet.add(56);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new ItemScopeEntity(hashSet, i, itemScopeEntity, arrayList, itemScopeEntity2, str, str2, str3, arrayList2, i2, arrayList3, itemScopeEntity3, arrayList4, str4, str5, itemScopeEntity4, str6, str7, str8, arrayList5, str9, str10, str11, str12, str13, str14, str15, str16, str17, itemScopeEntity5, str18, str19, str20, str21, itemScopeEntity6, d, itemScopeEntity7, d2, str22, itemScopeEntity8, arrayList6, str23, str24, str25, str26, itemScopeEntity9, str27, str28, str29, itemScopeEntity10, str30, str31, str32, str33, str34, str35);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ItemScopeEntity[] newArray(int i) {
        return new ItemScopeEntity[i];
    }
}
