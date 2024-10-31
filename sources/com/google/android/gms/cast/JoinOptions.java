package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

/* loaded from: classes.dex */
public class JoinOptions implements SafeParcelable {
    public static final Parcelable.Creator<JoinOptions> CREATOR = new zzc();

    /* renamed from: a, reason: collision with root package name */
    private final int f826a;
    private int b;

    public JoinOptions() {
        this(1, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JoinOptions(int i, int i2) {
        this.f826a = i;
        this.b = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.f826a;
    }

    public int b() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof JoinOptions) && this.b == ((JoinOptions) obj).b;
    }

    public int hashCode() {
        return zzw.a(Integer.valueOf(this.b));
    }

    public String toString() {
        String str;
        switch (this.b) {
            case 0:
                str = "STRONG";
                break;
            case 1:
            default:
                str = "UNKNOWN";
                break;
            case 2:
                str = "INVISIBLE";
                break;
        }
        return String.format("joinOptions(connectionType=%s)", str);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzc.a(this, parcel, i);
    }
}
