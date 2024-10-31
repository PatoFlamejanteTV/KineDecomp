package com.google.android.gms.auth.api.credentials;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class Credential implements SafeParcelable {
    public static final Parcelable.Creator<Credential> CREATOR = new zza();

    /* renamed from: a, reason: collision with root package name */
    final int f787a;
    private final String b;
    private final String c;
    private final Uri d;
    private final List<IdToken> e;
    private final String f;
    private final String g;
    private final String h;
    private final String i;

    /* loaded from: classes.dex */
    public static class Builder {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Credential(int i, String str, String str2, Uri uri, List<IdToken> list, String str3, String str4, String str5, String str6) {
        this.f787a = i;
        this.b = (String) zzx.a(str);
        this.c = str2;
        this.d = uri;
        this.e = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
        this.f = str3;
        this.g = str4;
        this.h = str5;
        this.i = str6;
    }

    public String a() {
        return this.b;
    }

    public String b() {
        return this.c;
    }

    public Uri c() {
        return this.d;
    }

    public List<IdToken> d() {
        return this.e;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Credential)) {
            return false;
        }
        Credential credential = (Credential) obj;
        return TextUtils.equals(this.b, credential.b) && TextUtils.equals(this.c, credential.c) && zzw.a(this.d, credential.d) && TextUtils.equals(this.f, credential.f) && TextUtils.equals(this.g, credential.g) && TextUtils.equals(this.h, credential.h);
    }

    public String f() {
        return this.h;
    }

    public String g() {
        return this.g;
    }

    public String h() {
        return this.i;
    }

    public int hashCode() {
        return zzw.a(this.b, this.c, this.d, this.f, this.g, this.h);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza.a(this, parcel, i);
    }
}
