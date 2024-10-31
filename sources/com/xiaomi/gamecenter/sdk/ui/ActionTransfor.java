package com.xiaomi.gamecenter.sdk.ui;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.UUID;

/* loaded from: classes3.dex */
public class ActionTransfor {

    /* loaded from: classes3.dex */
    public enum ActionResult {
        ACTION_FAIL,
        ACTION_OK,
        ACTION_CANCEL,
        ACTION_NONE
    }

    /* loaded from: classes3.dex */
    public class DataAction implements Parcelable {
        public static final Parcelable.Creator CREATOR = new a();

        /* renamed from: b */
        public ActionResult f26635b;

        /* renamed from: c */
        public Bundle f26636c = new Bundle();

        /* renamed from: a */
        public String f26634a = UUID.randomUUID().toString();

        /* renamed from: d */
        public int f26637d = 0;

        public DataAction() {
            this.f26635b = ActionResult.ACTION_NONE;
            this.f26635b = ActionResult.ACTION_NONE;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f26634a);
            parcel.writeString(this.f26635b.toString());
            parcel.writeBundle(this.f26636c);
            parcel.writeInt(this.f26637d);
        }
    }
}
