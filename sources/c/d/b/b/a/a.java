package c.d.b.b.a;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: Device.java */
/* loaded from: classes.dex */
class a implements Parcelable.Creator<b> {
    @Override // android.os.Parcelable.Creator
    public b createFromParcel(Parcel parcel) {
        return new b(parcel, null);
    }

    @Override // android.os.Parcelable.Creator
    public b[] newArray(int i) {
        return new b[i];
    }
}
