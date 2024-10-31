package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.List;

/* loaded from: classes.dex */
public class ActivityRecognitionResult implements SafeParcelable {
    public static final ActivityRecognitionResultCreator CREATOR = new ActivityRecognitionResultCreator();

    /* renamed from: a, reason: collision with root package name */
    List<DetectedActivity> f1837a;
    long b;
    long c;
    int d;
    private final int e;

    public ActivityRecognitionResult(int i, List<DetectedActivity> list, long j, long j2, int i2) {
        this.e = i;
        this.f1837a = list;
        this.b = j;
        this.c = j2;
        this.d = i2;
    }

    public int a() {
        return this.e;
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
        ActivityRecognitionResult activityRecognitionResult = (ActivityRecognitionResult) obj;
        return this.b == activityRecognitionResult.b && this.c == activityRecognitionResult.c && this.d == activityRecognitionResult.d && zzw.a(this.f1837a, activityRecognitionResult.f1837a);
    }

    public int hashCode() {
        return zzw.a(Long.valueOf(this.b), Long.valueOf(this.c), Integer.valueOf(this.d), this.f1837a);
    }

    public String toString() {
        return "ActivityRecognitionResult [probableActivities=" + this.f1837a + ", timeMillis=" + this.b + ", elapsedRealtimeMillis=" + this.c + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ActivityRecognitionResultCreator.a(this, parcel, i);
    }
}
