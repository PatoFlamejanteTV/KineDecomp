package com.google.android.gms.location.places;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public final class UserDataType implements SafeParcelable {
    final int e;
    final String f;
    final int g;

    /* renamed from: a, reason: collision with root package name */
    public static final UserDataType f1879a = a("test_type", 1);
    public static final UserDataType b = a("labeled_place", 6);
    public static final UserDataType c = a("here_content", 7);
    public static final Set<UserDataType> d = Collections.unmodifiableSet(new HashSet(Arrays.asList(f1879a, b, c)));
    public static final zzm CREATOR = new zzm();

    /* JADX INFO: Access modifiers changed from: package-private */
    public UserDataType(int i, String str, int i2) {
        zzx.a(str);
        this.e = i;
        this.f = str;
        this.g = i2;
    }

    private static UserDataType a(String str, int i) {
        return new UserDataType(0, str, i);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        zzm zzmVar = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserDataType)) {
            return false;
        }
        UserDataType userDataType = (UserDataType) obj;
        return this.f.equals(userDataType.f) && this.g == userDataType.g;
    }

    public int hashCode() {
        return this.f.hashCode();
    }

    public String toString() {
        return this.f;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzm zzmVar = CREATOR;
        zzm.a(this, parcel, i);
    }
}
