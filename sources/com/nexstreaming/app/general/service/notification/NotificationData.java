package com.nexstreaming.app.general.service.notification;

import android.content.ContextWrapper;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class NotificationData implements Parcelable {
    public static final String ACTION_NOTIFICATION = NotificationData.class.getName() + ".notification";
    public static Parcelable.Creator<NotificationData> CREATOR = new a();
    public int defaultLargeImageResource;
    public int defaultSmallImageResource;
    public boolean hasLarge;
    public int id;
    public String message;
    public String targetClass;
    public String title;
    public String uri;

    public NotificationData() {
        this.id = -1;
        this.title = null;
        this.message = null;
        this.targetClass = null;
        this.uri = null;
        this.defaultSmallImageResource = -1;
        this.defaultLargeImageResource = -1;
        this.hasLarge = false;
    }

    public NotificationData(int i, String str, String str2, Class<? extends ContextWrapper> cls, String str3) {
        this(i, str, str2, cls, str3, -1, -1, false);
    }

    public NotificationData(int i, String str, String str2, Class<? extends ContextWrapper> cls, String str3, int i2) {
        this(i, str, str2, cls, str3, i2, -1, false);
    }

    public NotificationData(int i, String str, String str2, Class<? extends ContextWrapper> cls, String str3, int i2, int i3, boolean z) {
        this.id = -1;
        this.title = null;
        this.message = null;
        this.targetClass = null;
        this.uri = null;
        this.defaultSmallImageResource = -1;
        this.defaultLargeImageResource = -1;
        this.hasLarge = false;
        this.id = i;
        this.title = str;
        this.message = str2;
        this.targetClass = cls.getName();
        this.uri = str3;
        this.defaultSmallImageResource = i2;
        this.defaultLargeImageResource = i3;
        this.hasLarge = z;
    }

    public NotificationData(Parcel parcel) {
        this.id = -1;
        this.title = null;
        this.message = null;
        this.targetClass = null;
        this.uri = null;
        this.defaultSmallImageResource = -1;
        this.defaultLargeImageResource = -1;
        this.hasLarge = false;
        this.id = parcel.readInt();
        this.title = parcel.readString();
        this.message = parcel.readString();
        this.targetClass = parcel.readString();
        this.uri = parcel.readString();
        this.defaultSmallImageResource = parcel.readInt();
        this.defaultLargeImageResource = parcel.readInt();
        this.hasLarge = parcel.readInt() == 1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.id);
        parcel.writeString(this.title);
        parcel.writeString(this.message);
        parcel.writeString(this.targetClass);
        parcel.writeString(this.uri);
        parcel.writeInt(this.defaultSmallImageResource);
        parcel.writeInt(this.defaultLargeImageResource);
        parcel.writeInt(this.hasLarge ? 1 : 0);
    }

    public String toString() {
        return "NotificationData{id=" + this.id + ", title='" + this.title + "', message='" + this.message + "', targetClass='" + this.targetClass + "', uri=" + this.uri + ", defaultSmallImageResource=" + this.defaultSmallImageResource + ", defaultLargeImageResource=" + this.defaultLargeImageResource + ", hasLarge=" + this.hasLarge + '}';
    }
}
