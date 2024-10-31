package com.google.android.gms.common.internal.safeparcel;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzx;

/* loaded from: classes.dex */
public final class zzc {
    public static <T extends SafeParcelable> T a(byte[] bArr, Parcelable.Creator<T> creator) {
        zzx.a(creator);
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        T createFromParcel = creator.createFromParcel(obtain);
        obtain.recycle();
        return createFromParcel;
    }

    public static <T extends SafeParcelable> byte[] a(T t) {
        Parcel obtain = Parcel.obtain();
        t.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        return marshall;
    }
}
