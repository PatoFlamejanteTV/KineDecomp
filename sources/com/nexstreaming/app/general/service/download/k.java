package com.nexstreaming.app.general.service.download;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.File;
import java.net.URI;

/* compiled from: DownloadInfo.java */
/* loaded from: classes2.dex */
public class k implements Parcelable {
    public static final Parcelable.Creator<k> CREATOR = new j();

    /* renamed from: a */
    private final String f19708a;

    /* renamed from: b */
    private final String f19709b;

    /* renamed from: c */
    private final String f19710c;

    /* renamed from: d */
    private final String f19711d;

    /* renamed from: e */
    private final String f19712e;

    /* renamed from: f */
    private long f19713f;

    /* renamed from: g */
    private final long f19714g;

    public k(String str, String str2, String str3, String str4, String str5, long j) {
        this.f19708a = str;
        this.f19709b = str2;
        this.f19710c = str3;
        this.f19711d = str4;
        this.f19712e = str5;
        this.f19713f = j;
        this.f19714g = System.currentTimeMillis();
    }

    public void a(long j) {
        this.f19713f = j;
    }

    public File b() {
        return new File(this.f19712e);
    }

    public String c() {
        return this.f19712e;
    }

    public URI d() {
        return URI.create(this.f19711d);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.f19708a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof k)) {
            return super.equals(obj);
        }
        k kVar = (k) obj;
        return this.f19713f == kVar.f19713f && this.f19711d.equals(kVar.f19711d);
    }

    public String f() {
        return this.f19710c;
    }

    public String g() {
        return this.f19709b;
    }

    public boolean h() {
        File b2 = b();
        return b2 != null && b2.exists() && b2.length() == this.f19713f;
    }

    public String toString() {
        return "{id='" + this.f19708a + "', name='" + this.f19709b + "', destinationPath='" + this.f19712e + "', createDate=" + this.f19714g + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f19708a);
        parcel.writeString(this.f19709b);
        parcel.writeString(this.f19710c);
        parcel.writeString(this.f19711d);
        parcel.writeString(this.f19712e);
        parcel.writeLong(this.f19713f);
        parcel.writeLong(this.f19714g);
    }

    public long a() {
        return this.f19714g;
    }

    public k(Parcel parcel) {
        this.f19708a = parcel.readString();
        this.f19709b = parcel.readString();
        this.f19710c = parcel.readString();
        this.f19711d = parcel.readString();
        this.f19712e = parcel.readString();
        this.f19713f = parcel.readLong();
        this.f19714g = parcel.readLong();
    }
}
