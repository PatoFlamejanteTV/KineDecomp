package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.Locale;

/* loaded from: classes2.dex */
public final class ChangesAvailableEvent implements SafeParcelable, DriveEvent {
    public static final Parcelable.Creator<ChangesAvailableEvent> CREATOR = new zzb();

    /* renamed from: a, reason: collision with root package name */
    final int f1068a;
    final String b;
    final ChangesAvailableOptions c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChangesAvailableEvent(int i, String str, ChangesAvailableOptions changesAvailableOptions) {
        this.f1068a = i;
        this.b = str;
        this.c = changesAvailableOptions;
    }

    @Override // com.google.android.gms.drive.events.DriveEvent
    public int a() {
        return 4;
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
        ChangesAvailableEvent changesAvailableEvent = (ChangesAvailableEvent) obj;
        return zzw.a(this.c, changesAvailableEvent.c) && zzw.a(this.b, changesAvailableEvent.b);
    }

    public int hashCode() {
        return zzw.a(this.c, this.b);
    }

    public String toString() {
        return String.format(Locale.US, "ChangesAvailableEvent [changesAvailableOptions=%s]", this.c);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb.a(this, parcel, i);
    }
}
