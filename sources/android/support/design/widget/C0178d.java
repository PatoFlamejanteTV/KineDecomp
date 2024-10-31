package android.support.design.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.design.widget.AppBarLayout;

/* compiled from: AppBarLayout.java */
/* renamed from: android.support.design.widget.d */
/* loaded from: classes.dex */
class C0178d implements Parcelable.ClassLoaderCreator<AppBarLayout.Behavior.b> {
    @Override // android.os.Parcelable.Creator
    public AppBarLayout.Behavior.b[] newArray(int i) {
        return new AppBarLayout.Behavior.b[i];
    }

    @Override // android.os.Parcelable.ClassLoaderCreator
    public AppBarLayout.Behavior.b createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new AppBarLayout.Behavior.b(parcel, classLoader);
    }

    @Override // android.os.Parcelable.Creator
    public AppBarLayout.Behavior.b createFromParcel(Parcel parcel) {
        return new AppBarLayout.Behavior.b(parcel, null);
    }
}
