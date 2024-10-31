package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.zzaw;

/* loaded from: classes.dex */
public class AddListenerRequest implements SafeParcelable {
    public static final Parcelable.Creator<AddListenerRequest> CREATOR = new zzc();

    /* renamed from: a, reason: collision with root package name */
    final int f2330a;
    public final zzaw b;
    public final IntentFilter[] c;
    public final String d;
    public final String e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AddListenerRequest(int i, IBinder iBinder, IntentFilter[] intentFilterArr, String str, String str2) {
        this.f2330a = i;
        if (iBinder != null) {
            this.b = zzaw.zza.a(iBinder);
        } else {
            this.b = null;
        }
        this.c = intentFilterArr;
        this.d = str;
        this.e = str2;
    }

    public AddListenerRequest(g gVar) {
        this.f2330a = 1;
        this.b = gVar;
        this.c = gVar.b();
        this.d = gVar.c();
        this.e = gVar.d();
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
        zzc.a(this, parcel, i);
    }
}
