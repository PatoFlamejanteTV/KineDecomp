package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.appdatasearch.RegisterSectionInfo;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

/* loaded from: classes.dex */
public class DocumentSection implements SafeParcelable {
    final int b;
    public final String c;
    final RegisterSectionInfo d;
    public final int e;
    public final byte[] f;

    /* renamed from: a, reason: collision with root package name */
    public static final int f758a = Integer.parseInt("-1");
    public static final zzd CREATOR = new zzd();
    private static final RegisterSectionInfo g = new RegisterSectionInfo.zza("SsbContext").a(true).a("blob").a();

    /* JADX INFO: Access modifiers changed from: package-private */
    public DocumentSection(int i, String str, RegisterSectionInfo registerSectionInfo, int i2, byte[] bArr) {
        zzx.b(i2 == f758a || zzh.a(i2) != null, "Invalid section type " + i2);
        this.b = i;
        this.c = str;
        this.d = registerSectionInfo;
        this.e = i2;
        this.f = bArr;
        String b = b();
        if (b != null) {
            throw new IllegalArgumentException(b);
        }
    }

    public DocumentSection(String str, RegisterSectionInfo registerSectionInfo) {
        this(1, str, registerSectionInfo, f758a, null);
    }

    public DocumentSection(String str, RegisterSectionInfo registerSectionInfo, String str2) {
        this(1, str, registerSectionInfo, zzh.a(str2), null);
    }

    public DocumentSection(byte[] bArr, RegisterSectionInfo registerSectionInfo) {
        this(1, null, registerSectionInfo, f758a, bArr);
    }

    public static DocumentSection a(byte[] bArr) {
        return new DocumentSection(bArr, g);
    }

    public RegisterSectionInfo a() {
        return this.d;
    }

    public String b() {
        if (this.e != f758a && zzh.a(this.e) == null) {
            return "Invalid section type " + this.e;
        }
        if (this.c == null || this.f == null) {
            return null;
        }
        return "Both content and blobContent set";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        zzd zzdVar = CREATOR;
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzd zzdVar = CREATOR;
        zzd.a(this, parcel, i);
    }
}
