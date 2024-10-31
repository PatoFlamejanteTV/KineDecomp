package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public class ObjectChangedDetails implements SafeParcelable {
    public static final Parcelable.Creator<ObjectChangedDetails> CREATOR = new zzb();

    /* renamed from: a, reason: collision with root package name */
    final int f1177a;
    final int b;
    final int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ObjectChangedDetails(int i, int i2, int i3) {
        this.f1177a = i;
        this.b = i2;
        this.c = i3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb.a(this, parcel, i);
    }
}
