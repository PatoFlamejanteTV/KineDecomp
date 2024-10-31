package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.drive.DriveSpace;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* loaded from: classes2.dex */
public final class ChangesAvailableOptions implements SafeParcelable {
    public static final Parcelable.Creator<ChangesAvailableOptions> CREATOR = new zzd();

    /* renamed from: a, reason: collision with root package name */
    final int f1069a;
    final int b;
    final boolean c;
    final List<DriveSpace> d;
    private final Set<DriveSpace> e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChangesAvailableOptions(int i, int i2, boolean z, List<DriveSpace> list) {
        this(i, i2, z, list, list == null ? null : new HashSet(list));
    }

    private ChangesAvailableOptions(int i, int i2, boolean z, List<DriveSpace> list, Set<DriveSpace> set) {
        this.f1069a = i;
        this.b = i2;
        this.c = z;
        this.d = list;
        this.e = set;
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
        ChangesAvailableOptions changesAvailableOptions = (ChangesAvailableOptions) obj;
        return zzw.a(this.e, changesAvailableOptions.e) && this.b == changesAvailableOptions.b && this.c == changesAvailableOptions.c;
    }

    public int hashCode() {
        return zzw.a(this.e, Integer.valueOf(this.b), Boolean.valueOf(this.c));
    }

    public String toString() {
        return String.format(Locale.US, "ChangesAvailableOptions[ChangesSizeLimit=%d, Repeats=%s, Spaces=%s]", Integer.valueOf(this.b), Boolean.valueOf(this.c), this.d);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzd.a(this, parcel, i);
    }
}
