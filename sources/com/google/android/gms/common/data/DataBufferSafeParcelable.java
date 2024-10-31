package com.google.android.gms.common.data;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@KeepForSdk
/* loaded from: classes.dex */
public class DataBufferSafeParcelable<T extends SafeParcelable> extends AbstractDataBuffer<T> {

    /* renamed from: b */
    private static final String[] f11002b = {ShareConstants.WEB_DIALOG_PARAM_DATA};

    /* renamed from: c */
    private final Parcelable.Creator<T> f11003c;

    @KeepForSdk
    public DataBufferSafeParcelable(DataHolder dataHolder, Parcelable.Creator<T> creator) {
        super(dataHolder);
        this.f11003c = creator;
    }

    @KeepForSdk
    public static DataHolder.Builder a() {
        return DataHolder.a(f11002b);
    }

    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    @KeepForSdk
    public T get(int i) {
        DataHolder dataHolder = this.f10989a;
        byte[] a2 = dataHolder.a(ShareConstants.WEB_DIALOG_PARAM_DATA, i, dataHolder.j(i));
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(a2, 0, a2.length);
        obtain.setDataPosition(0);
        T createFromParcel = this.f11003c.createFromParcel(obtain);
        obtain.recycle();
        return createFromParcel;
    }

    @KeepForSdk
    public static <T extends SafeParcelable> void a(DataHolder.Builder builder, T t) {
        Parcel obtain = Parcel.obtain();
        t.writeToParcel(obtain, 0);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ShareConstants.WEB_DIALOG_PARAM_DATA, obtain.marshall());
        builder.a(contentValues);
        obtain.recycle();
    }
}
