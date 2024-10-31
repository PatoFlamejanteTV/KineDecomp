package com.google.android.gms.games.internal.request;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.games.request.GameRequestEntity;
import com.xiaomi.licensinglibrary.LicenseErrCode;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class GameRequestClusterCreator implements Parcelable.Creator<GameRequestCluster> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(GameRequestCluster gameRequestCluster, Parcel parcel, int i) {
        int a2 = zzb.a(parcel);
        zzb.c(parcel, 1, gameRequestCluster.c(), false);
        zzb.a(parcel, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, gameRequestCluster.b());
        zzb.a(parcel, a2);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public GameRequestCluster createFromParcel(Parcel parcel) {
        int b = zza.b(parcel);
        int i = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < b) {
            int a2 = zza.a(parcel);
            switch (zza.a(a2)) {
                case 1:
                    arrayList = zza.c(parcel, a2, GameRequestEntity.CREATOR);
                    break;
                case LicenseErrCode.LICENSE_STATUS_NOT_LICENSED /* 1000 */:
                    i = zza.g(parcel, a2);
                    break;
                default:
                    zza.b(parcel, a2);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.C0032zza("Overread allowed size end=" + b, parcel);
        }
        return new GameRequestCluster(i, arrayList);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public GameRequestCluster[] newArray(int i) {
        return new GameRequestCluster[i];
    }
}
