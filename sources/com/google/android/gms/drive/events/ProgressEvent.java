package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.drive.DriveId;

/* loaded from: classes2.dex */
public final class ProgressEvent implements DriveEvent {
    public static final Parcelable.Creator<ProgressEvent> CREATOR = new zzh();

    /* renamed from: a, reason: collision with root package name */
    final int f1072a;
    final DriveId b;
    final int c;
    final long d;
    final long e;
    final int f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProgressEvent(int i, DriveId driveId, int i2, long j, long j2, int i3) {
        this.f1072a = i;
        this.b = driveId;
        this.c = i2;
        this.d = j;
        this.e = j2;
        this.f = i3;
    }

    @Override // com.google.android.gms.drive.events.DriveEvent
    public int a() {
        return this.f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        ProgressEvent progressEvent = (ProgressEvent) obj;
        return zzw.a(this.b, progressEvent.b) && this.c == progressEvent.c && this.d == progressEvent.d && this.e == progressEvent.e;
    }

    public int hashCode() {
        return zzw.a(this.b, Integer.valueOf(this.c), Long.valueOf(this.d), Long.valueOf(this.e));
    }

    public String toString() {
        return String.format("ProgressEvent[DriveId: %s, status: %d, bytes transferred: %d, total bytes: %d]", this.b, Integer.valueOf(this.c), Long.valueOf(this.d), Long.valueOf(this.e));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzh.a(this, parcel, i);
    }
}
