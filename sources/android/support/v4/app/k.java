package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.Fragment;

/* compiled from: Fragment.java */
/* loaded from: classes.dex */
final class k implements Parcelable.Creator<Fragment.SavedState> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Fragment.SavedState createFromParcel(Parcel parcel) {
        return new Fragment.SavedState(parcel, null);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Fragment.SavedState[] newArray(int i) {
        return new Fragment.SavedState[i];
    }
}
