package com.google.android.gms.gcm;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.gcm.Task;

/* loaded from: classes.dex */
public class OneoffTask extends Task {
    public static final Parcelable.Creator<OneoffTask> CREATOR = new d();

    /* renamed from: a, reason: collision with root package name */
    private final long f1407a;
    private final long b;

    /* loaded from: classes.dex */
    public static class Builder extends Task.Builder {
        private long c = -1;
        private long d = -1;

        public Builder() {
            this.f1411a = false;
        }
    }

    @Deprecated
    private OneoffTask(Parcel parcel) {
        super(parcel);
        this.f1407a = parcel.readLong();
        this.b = parcel.readLong();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ OneoffTask(Parcel parcel, d dVar) {
        this(parcel);
    }

    public long a() {
        return this.f1407a;
    }

    public long b() {
        return this.b;
    }

    public String toString() {
        return super.toString() + " windowStart=" + a() + " windowEnd=" + b();
    }

    @Override // com.google.android.gms.gcm.Task, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeLong(this.f1407a);
        parcel.writeLong(this.b);
    }
}
