package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: FragmentManager.java */
/* loaded from: classes.dex */
final class u implements Parcelable.Creator<FragmentManagerState> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public FragmentManagerState createFromParcel(Parcel parcel) {
        return new FragmentManagerState(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public FragmentManagerState[] newArray(int i) {
        return new FragmentManagerState[i];
    }
}
