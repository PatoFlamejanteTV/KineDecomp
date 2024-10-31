package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.realtime.internal.event.ParcelableEvent;
import java.util.List;

/* loaded from: classes2.dex */
public class ParcelableChangeInfo implements SafeParcelable {
    public static final Parcelable.Creator<ParcelableChangeInfo> CREATOR = new zzp();

    /* renamed from: a, reason: collision with root package name */
    final int f1173a;
    final long b;
    final List<ParcelableEvent> c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ParcelableChangeInfo(int i, long j, List<ParcelableEvent> list) {
        this.f1173a = i;
        this.b = j;
        this.c = list;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzp.a(this, parcel, i);
    }
}
