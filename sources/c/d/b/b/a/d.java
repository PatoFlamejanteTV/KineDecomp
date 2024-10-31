package c.d.b.b.a;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: User.java */
/* loaded from: classes.dex */
class d implements Parcelable.Creator<e> {
    @Override // android.os.Parcelable.Creator
    public e createFromParcel(Parcel parcel) {
        return new e(parcel, null);
    }

    @Override // android.os.Parcelable.Creator
    public e[] newArray(int i) {
        return new e[i];
    }
}
