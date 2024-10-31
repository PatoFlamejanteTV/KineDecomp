package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.data.BleDevice;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class BleDevicesResult implements Result, SafeParcelable {
    public static final Parcelable.Creator<BleDevicesResult> CREATOR = new zza();

    /* renamed from: a, reason: collision with root package name */
    private final int f1282a;
    private final List<BleDevice> b;
    private final Status c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BleDevicesResult(int i, List<BleDevice> list, Status status) {
        this.f1282a = i;
        this.b = Collections.unmodifiableList(list);
        this.c = status;
    }

    public BleDevicesResult(List<BleDevice> list, Status status) {
        this.f1282a = 3;
        this.b = Collections.unmodifiableList(list);
        this.c = status;
    }

    public static BleDevicesResult a(Status status) {
        return new BleDevicesResult(Collections.emptyList(), status);
    }

    private boolean a(BleDevicesResult bleDevicesResult) {
        return this.c.equals(bleDevicesResult.c) && zzw.a(this.b, bleDevicesResult.b);
    }

    public List<BleDevice> a() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f1282a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof BleDevicesResult) && a((BleDevicesResult) obj));
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.c;
    }

    public int hashCode() {
        return zzw.a(this.c, this.b);
    }

    public String toString() {
        return zzw.a(this).a(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, this.c).a("bleDevices", this.b).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza.a(this, parcel, i);
    }
}
