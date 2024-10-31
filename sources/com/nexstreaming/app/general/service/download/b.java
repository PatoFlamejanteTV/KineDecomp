package com.nexstreaming.app.general.service.download;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.nexstreaming.app.general.task.Task;

/* compiled from: DownloadError.java */
/* loaded from: classes2.dex */
public class b implements Task.TaskError, Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* renamed from: a */
    public final int f19687a;

    /* renamed from: b */
    public final int f19688b;

    /* renamed from: c */
    public final String f19689c;

    /* renamed from: d */
    public final String f19690d;

    public b(int i, int i2, Exception exc) {
        String str;
        this.f19687a = i;
        this.f19688b = i2;
        this.f19689c = exc.getMessage();
        StringBuilder sb = new StringBuilder();
        sb.append(exc.getMessage());
        if (exc.getCause() != null) {
            str = "\n" + exc.getCause().getMessage();
        } else {
            str = "";
        }
        sb.append(str);
        this.f19690d = sb.toString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.nexstreaming.app.general.task.Task.TaskError
    public Exception getException() {
        String str = this.f19690d;
        if (str == null) {
            str = "DownloadError has no any dev message";
        }
        return new Exception(str);
    }

    @Override // com.nexstreaming.app.general.task.Task.TaskError
    public String getLocalizedMessage(Context context) {
        return context.getString(this.f19688b);
    }

    @Override // com.nexstreaming.app.general.task.Task.TaskError
    public String getMessage() {
        return this.f19689c;
    }

    public String toString() {
        return "{errorCode=" + this.f19687a + ", message='" + this.f19689c + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f19687a);
        parcel.writeInt(this.f19688b);
        parcel.writeString(this.f19689c);
        parcel.writeString(this.f19690d);
    }

    public b(int i, int i2, String str) {
        this.f19687a = i;
        this.f19688b = i2;
        this.f19689c = str;
        this.f19690d = null;
    }

    public b(int i, int i2) {
        this.f19687a = i;
        this.f19688b = i2;
        this.f19689c = null;
        this.f19690d = null;
    }

    public b(Parcel parcel) {
        this.f19687a = parcel.readInt();
        this.f19688b = parcel.readInt();
        this.f19689c = parcel.readString();
        this.f19690d = parcel.readString();
    }
}
