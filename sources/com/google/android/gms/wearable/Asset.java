package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

/* loaded from: classes.dex */
public class Asset implements SafeParcelable {
    public static final Parcelable.Creator<Asset> CREATOR = new zze();

    /* renamed from: a, reason: collision with root package name */
    final int f2324a;
    public ParcelFileDescriptor b;
    public Uri c;
    private byte[] d;
    private String e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Asset(int i, byte[] bArr, String str, ParcelFileDescriptor parcelFileDescriptor, Uri uri) {
        this.f2324a = i;
        this.d = bArr;
        this.e = str;
        this.b = parcelFileDescriptor;
        this.c = uri;
    }

    public byte[] a() {
        return this.d;
    }

    public String b() {
        return this.e;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Asset)) {
            return false;
        }
        Asset asset = (Asset) obj;
        return zzw.a(this.d, asset.d) && zzw.a(this.e, asset.e) && zzw.a(this.b, asset.b) && zzw.a(this.c, asset.c);
    }

    public int hashCode() {
        return zzw.a(this.d, this.e, this.b, this.c);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Asset[@");
        sb.append(Integer.toHexString(hashCode()));
        if (this.e == null) {
            sb.append(", nodigest");
        } else {
            sb.append(", ");
            sb.append(this.e);
        }
        if (this.d != null) {
            sb.append(", size=");
            sb.append(this.d.length);
        }
        if (this.b != null) {
            sb.append(", fd=");
            sb.append(this.b);
        }
        if (this.c != null) {
            sb.append(", uri=");
            sb.append(this.c);
        }
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zze.a(this, parcel, i | 1);
    }
}
