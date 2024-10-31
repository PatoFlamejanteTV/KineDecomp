package android.support.v7.internal.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.internal.widget.AbsSpinnerCompat;

/* compiled from: AbsSpinnerCompat.java */
/* loaded from: classes.dex */
final class b implements Parcelable.Creator<AbsSpinnerCompat.SavedState> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AbsSpinnerCompat.SavedState createFromParcel(Parcel parcel) {
        return new AbsSpinnerCompat.SavedState(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AbsSpinnerCompat.SavedState[] newArray(int i) {
        return new AbsSpinnerCompat.SavedState[i];
    }
}
