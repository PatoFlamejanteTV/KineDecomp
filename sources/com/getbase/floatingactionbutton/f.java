package com.getbase.floatingactionbutton;

import android.os.Parcel;
import android.os.Parcelable;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

/* compiled from: FloatingActionsMenu.java */
/* loaded from: classes.dex */
class f implements Parcelable.Creator<FloatingActionsMenu.d> {
    @Override // android.os.Parcelable.Creator
    public FloatingActionsMenu.d createFromParcel(Parcel parcel) {
        return new FloatingActionsMenu.d(parcel, null);
    }

    @Override // android.os.Parcelable.Creator
    public FloatingActionsMenu.d[] newArray(int i) {
        return new FloatingActionsMenu.d[i];
    }
}
