package android.support.design.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.design.widget.BottomSheetBehavior;

/* compiled from: BottomSheetBehavior.java */
/* renamed from: android.support.design.widget.j */
/* loaded from: classes.dex */
class C0184j implements Parcelable.ClassLoaderCreator<BottomSheetBehavior.b> {
    @Override // android.os.Parcelable.Creator
    public BottomSheetBehavior.b[] newArray(int i) {
        return new BottomSheetBehavior.b[i];
    }

    @Override // android.os.Parcelable.ClassLoaderCreator
    public BottomSheetBehavior.b createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new BottomSheetBehavior.b(parcel, classLoader);
    }

    @Override // android.os.Parcelable.Creator
    public BottomSheetBehavior.b createFromParcel(Parcel parcel) {
        return new BottomSheetBehavior.b(parcel, (ClassLoader) null);
    }
}
