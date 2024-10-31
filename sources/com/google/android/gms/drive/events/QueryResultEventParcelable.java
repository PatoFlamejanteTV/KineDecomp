package com.google.android.gms.drive.events;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.WriteAwareParcelable;

/* loaded from: classes2.dex */
public class QueryResultEventParcelable extends WriteAwareParcelable implements DriveEvent {
    public static final zzk CREATOR = new zzk();

    /* renamed from: a, reason: collision with root package name */
    final int f1073a;
    final DataHolder b;
    final boolean c;
    final int d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public QueryResultEventParcelable(int i, DataHolder dataHolder, boolean z, int i2) {
        this.f1073a = i;
        this.b = dataHolder;
        this.c = z;
        this.d = i2;
    }

    @Override // com.google.android.gms.drive.events.DriveEvent
    public int a() {
        return 3;
    }

    @Override // com.google.android.gms.drive.WriteAwareParcelable
    public void a(Parcel parcel, int i) {
        zzk.a(this, parcel, i);
    }

    public DataHolder b() {
        return this.b;
    }

    public boolean c() {
        return this.c;
    }

    public int d() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }
}
