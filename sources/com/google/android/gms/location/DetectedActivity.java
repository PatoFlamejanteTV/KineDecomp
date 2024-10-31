package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.Comparator;

/* loaded from: classes.dex */
public class DetectedActivity implements SafeParcelable {
    int b;
    int c;
    private final int d;

    /* renamed from: a, reason: collision with root package name */
    public static final Comparator<DetectedActivity> f1838a = new b();
    public static final DetectedActivityCreator CREATOR = new DetectedActivityCreator();

    public DetectedActivity(int i, int i2, int i3) {
        this.d = i;
        this.b = i2;
        this.c = i3;
    }

    public static String a(int i) {
        switch (i) {
            case 0:
                return "IN_VEHICLE";
            case 1:
                return "ON_BICYCLE";
            case 2:
                return "ON_FOOT";
            case 3:
                return "STILL";
            case 4:
                return "UNKNOWN";
            case 5:
                return "TILTING";
            case 6:
            default:
                return Integer.toString(i);
            case 7:
                return "WALKING";
            case 8:
                return "RUNNING";
        }
    }

    private int b(int i) {
        if (i > 15) {
            return 4;
        }
        return i;
    }

    public int a() {
        return b(this.b);
    }

    public int b() {
        return this.c;
    }

    public int c() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DetectedActivity detectedActivity = (DetectedActivity) obj;
        return this.b == detectedActivity.b && this.c == detectedActivity.c;
    }

    public int hashCode() {
        return zzw.a(Integer.valueOf(this.b), Integer.valueOf(this.c));
    }

    public String toString() {
        return "DetectedActivity [type=" + a(a()) + ", confidence=" + this.c + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        DetectedActivityCreator.a(this, parcel, i);
    }
}
