package android.support.v7.internal.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.internal.widget.SpinnerCompat;

/* compiled from: SpinnerCompat.java */
/* loaded from: classes.dex */
final class x implements Parcelable.Creator<SpinnerCompat.SavedState> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public SpinnerCompat.SavedState createFromParcel(Parcel parcel) {
        return new SpinnerCompat.SavedState(parcel, null);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public SpinnerCompat.SavedState[] newArray(int i) {
        return new SpinnerCompat.SavedState[i];
    }
}
