package com.google.android.gms.gcm;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.gcm.Task;

/* loaded from: classes.dex */
public class PeriodicTask extends Task {
    public static final Parcelable.Creator<PeriodicTask> CREATOR = new f();

    /* renamed from: a, reason: collision with root package name */
    protected long f1409a;
    protected long b;

    /* loaded from: classes.dex */
    public static class Builder extends Task.Builder {
        private long c = -1;
        private long d = -1;

        public Builder() {
            this.f1411a = true;
        }
    }

    @Deprecated
    private PeriodicTask(Parcel parcel) {
        super(parcel);
        this.f1409a = -1L;
        this.b = -1L;
        this.f1409a = parcel.readLong();
        this.b = parcel.readLong();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ PeriodicTask(Parcel parcel, f fVar) {
        this(parcel);
    }

    public long a() {
        return this.f1409a;
    }

    public long b() {
        return this.b;
    }

    public String toString() {
        return super.toString() + " period=" + a() + " flex=" + b();
    }

    @Override // com.google.android.gms.gcm.Task, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeLong(this.f1409a);
        parcel.writeLong(this.b);
    }
}
