package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.widget.Toolbar;

/* compiled from: Toolbar.java */
/* loaded from: classes.dex */
final class o implements Parcelable.Creator<Toolbar.SavedState> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Toolbar.SavedState createFromParcel(Parcel parcel) {
        return new Toolbar.SavedState(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Toolbar.SavedState[] newArray(int i) {
        return new Toolbar.SavedState[i];
    }
}
