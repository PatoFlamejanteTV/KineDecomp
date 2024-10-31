package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes2.dex */
public class ParcelableCollaborator implements SafeParcelable {
    public static final Parcelable.Creator<ParcelableCollaborator> CREATOR = new zzq();

    /* renamed from: a, reason: collision with root package name */
    final int f1174a;
    final boolean b;
    final boolean c;
    final String d;
    final String e;
    final String f;
    final String g;
    final String h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ParcelableCollaborator(int i, boolean z, boolean z2, String str, String str2, String str3, String str4, String str5) {
        this.f1174a = i;
        this.b = z;
        this.c = z2;
        this.d = str;
        this.e = str2;
        this.f = str3;
        this.g = str4;
        this.h = str5;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ParcelableCollaborator) {
            return this.d.equals(((ParcelableCollaborator) obj).d);
        }
        return false;
    }

    public int hashCode() {
        return this.d.hashCode();
    }

    public String toString() {
        return "Collaborator [isMe=" + this.b + ", isAnonymous=" + this.c + ", sessionId=" + this.d + ", userId=" + this.e + ", displayName=" + this.f + ", color=" + this.g + ", photoUrl=" + this.h + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzq.a(this, parcel, i);
    }
}
