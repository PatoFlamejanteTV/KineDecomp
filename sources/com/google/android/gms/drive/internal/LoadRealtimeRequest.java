package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import java.util.List;

/* loaded from: classes2.dex */
public class LoadRealtimeRequest implements SafeParcelable {
    public static final Parcelable.Creator<LoadRealtimeRequest> CREATOR = new zzar();

    /* renamed from: a, reason: collision with root package name */
    final int f1098a;
    final DriveId b;
    final boolean c;
    final List<String> d;
    final boolean e;
    final DataHolder f;
    final String g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LoadRealtimeRequest(int i, DriveId driveId, boolean z, List<String> list, boolean z2, DataHolder dataHolder, String str) {
        this.f1098a = i;
        this.b = driveId;
        this.c = z;
        this.d = list;
        this.e = z2;
        this.f = dataHolder;
        this.g = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzar.a(this, parcel, i);
    }
}
