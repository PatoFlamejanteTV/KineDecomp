package com.google.android.gms.common.internal.safeparcel;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
@KeepForSdk
/* loaded from: classes.dex */
public final class SafeParcelableSerializer {
    @KeepForSdk
    public static <T extends SafeParcelable> byte[] a(T t) {
        Parcel obtain = Parcel.obtain();
        t.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        return marshall;
    }

    @KeepForSdk
    public static <T extends SafeParcelable> String b(T t) {
        return Base64Utils.b(a(t));
    }

    @KeepForSdk
    public static <T extends SafeParcelable> T a(byte[] bArr, Parcelable.Creator<T> creator) {
        Preconditions.a(creator);
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        T createFromParcel = creator.createFromParcel(obtain);
        obtain.recycle();
        return createFromParcel;
    }

    @KeepForSdk
    public static <T extends SafeParcelable> T a(String str, Parcelable.Creator<T> creator) {
        return (T) a(Base64Utils.a(str), creator);
    }

    @KeepForSdk
    public static <T extends SafeParcelable> void a(T t, Intent intent, String str) {
        intent.putExtra(str, a(t));
    }

    @KeepForSdk
    public static <T extends SafeParcelable> T a(Intent intent, String str, Parcelable.Creator<T> creator) {
        byte[] byteArrayExtra = intent.getByteArrayExtra(str);
        if (byteArrayExtra == null) {
            return null;
        }
        return (T) a(byteArrayExtra, creator);
    }
}
