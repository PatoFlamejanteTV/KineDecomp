package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.zzaw;

/* loaded from: classes.dex */
public class RemoveListenerRequest implements SafeParcelable {
    public static final Parcelable.Creator<RemoveListenerRequest> CREATOR = new zzbg();

    /* renamed from: a, reason: collision with root package name */
    final int f2361a;
    public final zzaw b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RemoveListenerRequest(int i, IBinder iBinder) {
        this.f2361a = i;
        if (iBinder != null) {
            this.b = zzaw.zza.a(iBinder);
        } else {
            this.b = null;
        }
    }

    public RemoveListenerRequest(zzaw zzawVar) {
        this.f2361a = 1;
        this.b = zzawVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IBinder a() {
        if (this.b == null) {
            return null;
        }
        return this.b.asBinder();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzbg.a(this, parcel, i);
    }
}
