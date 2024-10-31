package com.google.android.gms.nearby.sharing;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

/* loaded from: classes.dex */
public class LocalContent implements SafeParcelable {
    public static final Parcelable.Creator<LocalContent> CREATOR = new zzb();

    /* renamed from: a, reason: collision with root package name */
    private final int f2131a;
    private int b;
    private String c;

    private LocalContent() {
        this.f2131a = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LocalContent(int i, int i2, String str) {
        this.f2131a = i;
        this.b = i2;
        this.c = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.f2131a;
    }

    public int b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LocalContent)) {
            return false;
        }
        LocalContent localContent = (LocalContent) obj;
        return zzw.a(Integer.valueOf(this.b), Integer.valueOf(localContent.b)) && zzw.a(this.c, localContent.c);
    }

    public int hashCode() {
        return zzw.a(Integer.valueOf(this.b), this.c);
    }

    public String toString() {
        return "LocalContent[contentUri=" + this.c + ", type=" + (this.b == 1 ? "PUBLIC_CONTENT" : "APP_CONTENT") + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb.a(this, parcel, i);
    }
}
