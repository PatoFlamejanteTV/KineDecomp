package com.google.android.gms.analytics.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class Command implements Parcelable {

    @Deprecated
    public static final Parcelable.Creator<Command> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f698a;
    private String b;
    private String c;

    @Deprecated
    public Command() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public Command(Parcel parcel) {
        a(parcel);
    }

    @Deprecated
    private void a(Parcel parcel) {
        this.f698a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
    }

    public String a() {
        return this.f698a;
    }

    public String b() {
        return this.c;
    }

    @Override // android.os.Parcelable
    @Deprecated
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    @Deprecated
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f698a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
    }
}
