package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zzni;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class BleDevice implements SafeParcelable {
    public static final Parcelable.Creator<BleDevice> CREATOR = new zzb();

    /* renamed from: a, reason: collision with root package name */
    private final int f1217a;
    private final String b;
    private final String c;
    private final List<String> d;
    private final List<DataType> e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BleDevice(int i, String str, String str2, List<String> list, List<DataType> list2) {
        this.f1217a = i;
        this.b = str;
        this.c = str2;
        this.d = Collections.unmodifiableList(list);
        this.e = Collections.unmodifiableList(list2);
    }

    private boolean a(BleDevice bleDevice) {
        return this.c.equals(bleDevice.c) && this.b.equals(bleDevice.b) && zzni.zza(bleDevice.d, this.d) && zzni.zza(this.e, bleDevice.e);
    }

    public String a() {
        return this.b;
    }

    public String b() {
        return this.c;
    }

    public List<String> c() {
        return this.d;
    }

    public List<DataType> d() {
        return this.e;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        return this.f1217a;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof BleDevice) && a((BleDevice) obj));
    }

    public int hashCode() {
        return zzw.a(this.c, this.b, this.d, this.e);
    }

    public String toString() {
        return zzw.a(this).a("name", this.c).a("address", this.b).a("dataTypes", this.e).a("supportedProfiles", this.d).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb.a(this, parcel, i);
    }
}
