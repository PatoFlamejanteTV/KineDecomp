package android.support.design.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.design.widget.CoordinatorLayout;

/* compiled from: CoordinatorLayout.java */
/* renamed from: android.support.design.widget.o */
/* loaded from: classes.dex */
class C0189o implements Parcelable.ClassLoaderCreator<CoordinatorLayout.g> {
    @Override // android.os.Parcelable.Creator
    public CoordinatorLayout.g[] newArray(int i) {
        return new CoordinatorLayout.g[i];
    }

    @Override // android.os.Parcelable.ClassLoaderCreator
    public CoordinatorLayout.g createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new CoordinatorLayout.g(parcel, classLoader);
    }

    @Override // android.os.Parcelable.Creator
    public CoordinatorLayout.g createFromParcel(Parcel parcel) {
        return new CoordinatorLayout.g(parcel, null);
    }
}
