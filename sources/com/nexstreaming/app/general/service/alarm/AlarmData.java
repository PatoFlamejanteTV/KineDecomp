package com.nexstreaming.app.general.service.alarm;

import android.os.Parcel;
import android.os.Parcelable;
import com.nexstreaming.app.general.service.notification.NotificationData;

/* loaded from: classes.dex */
public class AlarmData implements Parcelable {
    public static Parcelable.Creator<AlarmData> CREATOR = new a();
    public long dTime;
    public int id;
    public String name;
    public NotificationData notificationData;

    public AlarmData() {
        this.id = -1;
        this.name = null;
        this.dTime = 0L;
        this.notificationData = null;
    }

    public AlarmData(int i, String str, long j, NotificationData notificationData) {
        this.id = -1;
        this.name = null;
        this.dTime = 0L;
        this.notificationData = null;
        this.id = i;
        this.name = str;
        this.dTime = j;
        this.notificationData = notificationData;
    }

    public AlarmData(Parcel parcel) {
        this.id = -1;
        this.name = null;
        this.dTime = 0L;
        this.notificationData = null;
        this.id = parcel.readInt();
        this.name = parcel.readString();
        this.dTime = parcel.readLong();
        this.notificationData = (NotificationData) parcel.readParcelable(NotificationData.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.id);
        parcel.writeString(this.name);
        parcel.writeLong(this.dTime);
        parcel.writeParcelable(this.notificationData, i);
    }

    public String toString() {
        return "AlarmData{id=" + this.id + ", name='" + this.name + "', dTime=" + this.dTime + ", notificationData=" + this.notificationData + '}';
    }
}
