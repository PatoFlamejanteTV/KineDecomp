package com.google.android.gms.common.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public class zzd<T extends SafeParcelable> extends AbstractDataBuffer<T> {
    private static final String[] b = {ShareConstants.WEB_DIALOG_PARAM_DATA};
    private final Parcelable.Creator<T> c;

    public zzd(DataHolder dataHolder, Parcelable.Creator<T> creator) {
        super(dataHolder);
        this.c = creator;
    }

    @Override // com.google.android.gms.common.data.DataBuffer
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public T a(int i) {
        byte[] f = this.f982a.f(ShareConstants.WEB_DIALOG_PARAM_DATA, i, this.f982a.a(i));
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(f, 0, f.length);
        obtain.setDataPosition(0);
        T createFromParcel = this.c.createFromParcel(obtain);
        obtain.recycle();
        return createFromParcel;
    }
}
