package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.Subscription;
import com.google.android.gms.internal.zzoj;

/* loaded from: classes.dex */
public class SubscribeRequest implements SafeParcelable {
    public static final Parcelable.Creator<SubscribeRequest> CREATOR = new zzac();

    /* renamed from: a, reason: collision with root package name */
    private final int f1276a;
    private Subscription b;
    private final boolean c;
    private final zzoj d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SubscribeRequest(int i, Subscription subscription, boolean z, IBinder iBinder) {
        this.f1276a = i;
        this.b = subscription;
        this.c = z;
        this.d = zzoj.zza.zzbJ(iBinder);
    }

    public SubscribeRequest(Subscription subscription, boolean z, zzoj zzojVar) {
        this.f1276a = 3;
        this.b = subscription;
        this.c = z;
        this.d = zzojVar;
    }

    public Subscription a() {
        return this.b;
    }

    public boolean b() {
        return this.c;
    }

    public IBinder c() {
        if (this.d == null) {
            return null;
        }
        return this.d.asBinder();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return this.f1276a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return com.google.android.gms.common.internal.zzw.a(this).a("subscription", this.b).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzac.a(this, parcel, i);
    }
}
