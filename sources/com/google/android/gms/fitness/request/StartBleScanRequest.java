package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.zzn;
import com.google.android.gms.internal.zzoj;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class StartBleScanRequest implements SafeParcelable {
    public static final Parcelable.Creator<StartBleScanRequest> CREATOR = new zzaa();

    /* renamed from: a, reason: collision with root package name */
    private final int f1273a;
    private final List<DataType> b;
    private final zzn c;
    private final int d;
    private final zzoj e;

    /* loaded from: classes.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        private DataType[] f1274a = new DataType[0];
        private int b = 10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public StartBleScanRequest(int i, List<DataType> list, IBinder iBinder, int i2, IBinder iBinder2) {
        this.f1273a = i;
        this.b = list;
        this.c = zzn.zza.a(iBinder);
        this.d = i2;
        this.e = zzoj.zza.zzbJ(iBinder2);
    }

    public StartBleScanRequest(StartBleScanRequest startBleScanRequest, zzoj zzojVar) {
        this(startBleScanRequest.b, startBleScanRequest.c, startBleScanRequest.d, zzojVar);
    }

    public StartBleScanRequest(List<DataType> list, zzn zznVar, int i, zzoj zzojVar) {
        this.f1273a = 4;
        this.b = list;
        this.c = zznVar;
        this.d = i;
        this.e = zzojVar;
    }

    public List<DataType> a() {
        return Collections.unmodifiableList(this.b);
    }

    public int b() {
        return this.d;
    }

    public IBinder c() {
        return this.c.asBinder();
    }

    public IBinder d() {
        if (this.e == null) {
            return null;
        }
        return this.e.asBinder();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        return this.f1273a;
    }

    public String toString() {
        return com.google.android.gms.common.internal.zzw.a(this).a("dataTypes", this.b).a("timeoutSecs", Integer.valueOf(this.d)).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzaa.a(this, parcel, i);
    }
}
