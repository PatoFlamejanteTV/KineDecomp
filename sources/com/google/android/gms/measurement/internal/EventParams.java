package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.Iterator;

/* loaded from: classes.dex */
public class EventParams implements SafeParcelable, Iterable<String> {
    public static final zzi CREATOR = new zzi();

    /* renamed from: a, reason: collision with root package name */
    public final int f2019a;
    private final Bundle b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public EventParams(int i, Bundle bundle) {
        this.f2019a = i;
        this.b = bundle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public EventParams(Bundle bundle) {
        zzx.a(bundle);
        this.b = bundle;
        this.f2019a = 1;
    }

    public int a() {
        return this.b.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object a(String str) {
        return this.b.get(str);
    }

    public Bundle b() {
        return new Bundle(this.b);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Iterable
    public Iterator<String> iterator() {
        return new a(this);
    }

    public String toString() {
        return this.b.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzi.a(this, parcel, i);
    }
}
