package com.google.android.gms.games.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.internal.PopupManager;

/* loaded from: classes.dex */
public final class PopupLocationInfoParcelable implements SafeParcelable {
    public static final PopupLocationInfoParcelableCreator CREATOR = new PopupLocationInfoParcelableCreator();

    /* renamed from: a, reason: collision with root package name */
    private final int f1365a;
    private final Bundle b;
    private final IBinder c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PopupLocationInfoParcelable(int i, Bundle bundle, IBinder iBinder) {
        this.f1365a = i;
        this.b = bundle;
        this.c = iBinder;
    }

    public PopupLocationInfoParcelable(PopupManager.PopupLocationInfo popupLocationInfo) {
        this.f1365a = 1;
        this.b = popupLocationInfo.a();
        this.c = popupLocationInfo.f1367a;
    }

    public int a() {
        return this.f1365a;
    }

    public Bundle b() {
        return this.b;
    }

    public IBinder c() {
        return this.c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        PopupLocationInfoParcelableCreator.a(this, parcel, i);
    }
}
