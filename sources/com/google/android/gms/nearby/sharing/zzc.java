package com.google.android.gms.nearby.sharing;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

/* loaded from: classes.dex */
public class zzc implements Parcelable.Creator<SharedContent> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(SharedContent sharedContent, Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, sharedContent.a());
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, sharedContent.b(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 8, (Parcelable[]) sharedContent.c(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 9, (Parcelable[]) sharedContent.d(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public SharedContent createFromParcel(Parcel parcel) {
        LocalContent[] localContentArr;
        ViewableItem[] viewableItemArr;
        String str;
        int i;
        LocalContent[] localContentArr2 = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i2 = 0;
        ViewableItem[] viewableItemArr2 = null;
        String str2 = null;
        while (parcel.dataPosition() < b) {
            int a2 = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a2)) {
                case 1:
                    LocalContent[] localContentArr3 = localContentArr2;
                    viewableItemArr = viewableItemArr2;
                    str = str2;
                    i = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a2);
                    localContentArr = localContentArr3;
                    break;
                case 2:
                case 4:
                case 5:
                case 6:
                case 7:
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2);
                    localContentArr = localContentArr2;
                    viewableItemArr = viewableItemArr2;
                    str = str2;
                    i = i2;
                    break;
                case 3:
                    i = i2;
                    ViewableItem[] viewableItemArr3 = viewableItemArr2;
                    str = com.google.android.gms.common.internal.safeparcel.zza.p(parcel, a2);
                    localContentArr = localContentArr2;
                    viewableItemArr = viewableItemArr3;
                    break;
                case 8:
                    str = str2;
                    i = i2;
                    LocalContent[] localContentArr4 = localContentArr2;
                    viewableItemArr = (ViewableItem[]) com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2, ViewableItem.CREATOR);
                    localContentArr = localContentArr4;
                    break;
                case 9:
                    localContentArr = (LocalContent[]) com.google.android.gms.common.internal.safeparcel.zza.b(parcel, a2, LocalContent.CREATOR);
                    viewableItemArr = viewableItemArr2;
                    str = str2;
                    i = i2;
                    break;
            }
            i2 = i;
            str2 = str;
            viewableItemArr2 = viewableItemArr;
            localContentArr2 = localContentArr;
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new SharedContent(i2, str2, viewableItemArr2, localContentArr2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public SharedContent[] newArray(int i) {
        return new SharedContent[i];
    }
}
