package com.google.android.gms.gcm;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

/* loaded from: classes.dex */
public abstract class Task implements Parcelable {

    /* renamed from: a, reason: collision with root package name */
    private final String f1410a;
    private final String b;
    private final boolean c;
    private final boolean d;
    private final int e;
    private final boolean f;
    private final zzc g;
    private final Bundle h;

    /* loaded from: classes.dex */
    public static abstract class Builder {

        /* renamed from: a, reason: collision with root package name */
        protected boolean f1411a;
        protected zzc b = zzc.f1416a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public Task(Parcel parcel) {
        Log.e("Task", "Constructing a Task object using a parcel.");
        this.f1410a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readInt() == 1;
        this.d = parcel.readInt() == 1;
        this.e = 2;
        this.f = false;
        this.g = zzc.f1416a;
        this.h = null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f1410a);
        parcel.writeString(this.b);
        parcel.writeInt(this.c ? 1 : 0);
        parcel.writeInt(this.d ? 1 : 0);
    }
}
