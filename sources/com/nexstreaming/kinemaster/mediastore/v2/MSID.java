package com.nexstreaming.kinemaster.mediastore.v2;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/* loaded from: classes.dex */
public class MSID implements Parcelable, Serializable, CharSequence {
    public static final Parcelable.Creator<MSID> CREATOR = new c();
    private static final long serialVersionUID = 1;

    /* renamed from: a, reason: collision with root package name */
    private transient String f3550a;
    private transient String b;
    private transient String c;
    private final String msid;

    public MSID(String str, String str2) {
        this.f3550a = null;
        this.b = null;
        this.c = null;
        if (str == null || str2 == null) {
            throw new NullPointerException();
        }
        if (str.length() < 1 || str.contains(":")) {
            throw new RuntimeException("bad namespace");
        }
        this.msid = str + ":" + str2;
        this.f3550a = str;
        this.c = str2;
    }

    public MSID(String str) {
        this.f3550a = null;
        this.b = null;
        this.c = null;
        if (str == null) {
            throw new NullPointerException("msid must not be null");
        }
        if (!str.contains(":")) {
            throw new RuntimeException("msid must include a namespace");
        }
        this.msid = str;
    }

    public MSID(Parcel parcel) {
        this.f3550a = null;
        this.b = null;
        this.c = null;
        this.msid = parcel.readString();
    }

    public void assertNamespace(String str) {
        if (!getNamespace().equals(str)) {
            throw new RuntimeException("wrong namespace; expected '" + str + "' but got '" + getNamespace() + "'");
        }
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.msid;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return this.msid.equals(obj.toString());
    }

    public int hashCode() {
        return this.msid.hashCode();
    }

    public String getNamespace() {
        if (this.f3550a == null) {
            this.f3550a = this.msid.substring(0, this.msid.indexOf(58));
        }
        return this.f3550a;
    }

    public String getGenericNamespace() {
        if (this.b == null) {
            String namespace = getNamespace();
            int indexOf = namespace.indexOf(47);
            if (indexOf >= 0) {
                namespace = namespace.substring(0, indexOf);
            }
            this.b = namespace;
        }
        return this.b;
    }

    public String getSimpleId() {
        if (this.c == null) {
            this.c = this.msid.substring(this.msid.indexOf(58) + 1);
        }
        return this.c;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        return this.msid.charAt(i);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.msid.length();
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i, int i2) {
        return this.msid.subSequence(i, i2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.msid);
    }
}
