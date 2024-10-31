package com.google.android.gms.cast;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class ApplicationMetadata implements SafeParcelable {
    public static final Parcelable.Creator<ApplicationMetadata> CREATOR = new zza();

    /* renamed from: a, reason: collision with root package name */
    String f817a;
    String b;
    List<WebImage> c;
    List<String> d;
    String e;
    Uri f;
    private final int g;

    private ApplicationMetadata() {
        this.g = 1;
        this.c = new ArrayList();
        this.d = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ApplicationMetadata(int i, String str, String str2, List<WebImage> list, List<String> list2, String str3, Uri uri) {
        this.g = i;
        this.f817a = str;
        this.b = str2;
        this.c = list;
        this.d = list2;
        this.e = str3;
        this.f = uri;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.g;
    }

    public String b() {
        return this.f817a;
    }

    public String c() {
        return this.b;
    }

    public String d() {
        return this.e;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Uri e() {
        return this.f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ApplicationMetadata)) {
            return false;
        }
        ApplicationMetadata applicationMetadata = (ApplicationMetadata) obj;
        return zzf.a(this.f817a, applicationMetadata.f817a) && zzf.a(this.c, applicationMetadata.c) && zzf.a(this.b, applicationMetadata.b) && zzf.a(this.d, applicationMetadata.d) && zzf.a(this.e, applicationMetadata.e) && zzf.a(this.f, applicationMetadata.f);
    }

    public List<WebImage> f() {
        return this.c;
    }

    public int hashCode() {
        return zzw.a(Integer.valueOf(this.g), this.f817a, this.b, this.c, this.d, this.e, this.f);
    }

    public String toString() {
        return "applicationId: " + this.f817a + ", name: " + this.b + ", images.count: " + (this.c == null ? 0 : this.c.size()) + ", namespaces.count: " + (this.d != null ? this.d.size() : 0) + ", senderAppIdentifier: " + this.e + ", senderAppLaunchUrl: " + this.f;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza.a(this, parcel, i);
    }
}
