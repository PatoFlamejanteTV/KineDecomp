package com.google.android.gms.drive.metadata;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class CustomPropertyKey implements SafeParcelable {
    public static final Parcelable.Creator<CustomPropertyKey> CREATOR = new zzc();
    private static final Pattern d = Pattern.compile("[\\w.!@$%^&*()/-]+");

    /* renamed from: a, reason: collision with root package name */
    final int f1143a;
    final String b;
    final int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CustomPropertyKey(int i, String str, int i2) {
        boolean z = true;
        zzx.a(str, (Object) "key");
        zzx.b(d.matcher(str).matches(), "key name characters must be alphanumeric or one of .!@$%^&*()-_/");
        if (i2 != 0 && i2 != 1) {
            z = false;
        }
        zzx.b(z, "visibility must be either PUBLIC or PRIVATE");
        this.f1143a = i;
        this.b = str;
        this.c = i2;
    }

    public CustomPropertyKey(String str, int i) {
        this(1, str, i);
    }

    public String a() {
        return this.b;
    }

    public int b() {
        return this.c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CustomPropertyKey)) {
            return false;
        }
        CustomPropertyKey customPropertyKey = (CustomPropertyKey) obj;
        return customPropertyKey.a().equals(this.b) && customPropertyKey.b() == this.c;
    }

    public int hashCode() {
        return (this.b + this.c).hashCode();
    }

    public String toString() {
        return "CustomPropertyKey(" + this.b + "," + this.c + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzc.a(this, parcel, i);
    }
}
