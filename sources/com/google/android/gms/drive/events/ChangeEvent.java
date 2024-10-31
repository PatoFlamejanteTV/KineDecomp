package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import java.util.Locale;

/* loaded from: classes2.dex */
public final class ChangeEvent implements SafeParcelable, ResourceEvent {
    public static final Parcelable.Creator<ChangeEvent> CREATOR = new zza();

    /* renamed from: a, reason: collision with root package name */
    final int f1067a;
    final DriveId b;
    final int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChangeEvent(int i, DriveId driveId, int i2) {
        this.f1067a = i;
        this.b = driveId;
        this.c = i2;
    }

    @Override // com.google.android.gms.drive.events.DriveEvent
    public int a() {
        return 1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return String.format(Locale.US, "ChangeEvent [id=%s,changeFlags=%x]", this.b, Integer.valueOf(this.c));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza.a(this, parcel, i);
    }
}
