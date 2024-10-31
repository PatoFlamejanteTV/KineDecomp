package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.DataItemAssetParcelable;
import java.security.SecureRandom;
import java.util.Random;

/* loaded from: classes.dex */
public class PutDataRequest implements SafeParcelable {
    public static final Parcelable.Creator<PutDataRequest> CREATOR = new zzh();
    private static final Random b = new SecureRandom();

    /* renamed from: a, reason: collision with root package name */
    final int f2327a;
    private final Uri c;
    private final Bundle d;
    private byte[] e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PutDataRequest(int i, Uri uri, Bundle bundle, byte[] bArr) {
        this.f2327a = i;
        this.c = uri;
        this.d = bundle;
        this.d.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
        this.e = bArr;
    }

    public Uri a() {
        return this.c;
    }

    public String a(boolean z) {
        StringBuilder sb = new StringBuilder("PutDataRequest[");
        sb.append("dataSz=" + (this.e == null ? "null" : Integer.valueOf(this.e.length)));
        sb.append(", numAssets=" + this.d.size());
        sb.append(", uri=" + this.c);
        if (!z) {
            sb.append("]");
            return sb.toString();
        }
        sb.append("]\n  assets: ");
        for (String str : this.d.keySet()) {
            sb.append("\n    " + str + ": " + this.d.getParcelable(str));
        }
        sb.append("\n  ]");
        return sb.toString();
    }

    public byte[] b() {
        return this.e;
    }

    public Bundle c() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return a(Log.isLoggable("DataMap", 3));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzh.a(this, parcel, i);
    }
}
