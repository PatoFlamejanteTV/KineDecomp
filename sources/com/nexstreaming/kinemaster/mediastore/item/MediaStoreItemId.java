package com.nexstreaming.kinemaster.mediastore.item;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/* loaded from: classes.dex */
public class MediaStoreItemId implements Serializable, CharSequence, Parcelable {
    public static final Parcelable.Creator<MediaStoreItemId> CREATOR = new d();
    private static final long serialVersionUID = 1;

    /* renamed from: a */
    private transient String f20900a;

    /* renamed from: b */
    private transient String f20901b;
    private final String id;

    public MediaStoreItemId(String str, String str2) {
        if (str.length() >= 1 && !str.contains(":")) {
            this.id = str + ":" + str2;
            this.f20900a = str;
            this.f20901b = str2;
            return;
        }
        throw new RuntimeException("bad namespace");
    }

    public void assertNamespace(String str) {
        if (getNamespace().equals(str)) {
            return;
        }
        throw new RuntimeException("wrong namespace; expected '" + str + "' but got '" + getNamespace() + "'");
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        return this.id.charAt(i);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return this.id.equals(obj.toString());
    }

    public String getId() {
        return this.id;
    }

    public String getNamespace() {
        if (this.f20900a == null) {
            String str = this.id;
            this.f20900a = str.substring(0, str.indexOf(58));
        }
        return this.f20900a;
    }

    public String getSimpleId() {
        if (this.f20901b == null) {
            String str = this.id;
            this.f20901b = str.substring(str.indexOf(58) + 1);
        }
        return this.f20901b;
    }

    public int hashCode() {
        return this.id.hashCode();
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.id.length();
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i, int i2) {
        return this.id.subSequence(i, i2);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.id;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
    }

    public MediaStoreItemId(String str) {
        if (str.contains(":")) {
            this.id = str;
            return;
        }
        throw new RuntimeException("id must include a namespace");
    }

    public MediaStoreItemId(Parcel parcel) {
        this.id = parcel.readString();
    }
}
