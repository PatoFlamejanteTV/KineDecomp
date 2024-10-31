package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public class DocumentId implements SafeParcelable {
    public static final zzc CREATOR = new zzc();

    /* renamed from: a, reason: collision with root package name */
    final int f757a;
    final String b;
    final String c;
    final String d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DocumentId(int i, String str, String str2, String str3) {
        this.f757a = i;
        this.b = str;
        this.c = str2;
        this.d = str3;
    }

    public DocumentId(String str, String str2, String str3) {
        this(1, str, str2, str3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        zzc zzcVar = CREATOR;
        return 0;
    }

    public String toString() {
        return String.format("DocumentId[packageName=%s, corpusName=%s, uri=%s]", this.b, this.c, this.d);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzc zzcVar = CREATOR;
        zzc.a(this, parcel, i);
    }
}
