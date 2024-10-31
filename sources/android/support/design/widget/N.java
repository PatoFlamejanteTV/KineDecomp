package android.support.design.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.design.widget.TextInputLayout;

/* compiled from: TextInputLayout.java */
/* loaded from: classes.dex */
class N implements Parcelable.ClassLoaderCreator<TextInputLayout.a> {
    @Override // android.os.Parcelable.Creator
    public TextInputLayout.a[] newArray(int i) {
        return new TextInputLayout.a[i];
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.ClassLoaderCreator
    public TextInputLayout.a createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new TextInputLayout.a(parcel, classLoader);
    }

    @Override // android.os.Parcelable.Creator
    public TextInputLayout.a createFromParcel(Parcel parcel) {
        return new TextInputLayout.a(parcel, null);
    }
}
