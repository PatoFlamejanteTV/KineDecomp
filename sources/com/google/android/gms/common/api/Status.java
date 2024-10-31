package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.umeng.commonsdk.proguard.e;

@KeepForSdk
/* loaded from: classes.dex */
public final class Status extends AbstractSafeParcelable implements Result, ReflectedParcelable {

    /* renamed from: h */
    private final int f10711h;
    private final int i;
    private final String j;
    private final PendingIntent k;

    /* renamed from: a */
    @VisibleForTesting
    @KeepForSdk
    public static final Status f10704a = new Status(0);

    /* renamed from: b */
    @KeepForSdk
    public static final Status f10705b = new Status(14);

    /* renamed from: c */
    @KeepForSdk
    public static final Status f10706c = new Status(8);

    /* renamed from: d */
    @KeepForSdk
    public static final Status f10707d = new Status(15);

    /* renamed from: e */
    @KeepForSdk
    public static final Status f10708e = new Status(16);

    /* renamed from: f */
    private static final Status f10709f = new Status(17);

    /* renamed from: g */
    @KeepForSdk
    public static final Status f10710g = new Status(18);
    public static final Parcelable.Creator<Status> CREATOR = new zzb();

    @SafeParcelable.Constructor
    @KeepForSdk
    public Status(@SafeParcelable.Param(id = 1000) int i, @SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) PendingIntent pendingIntent) {
        this.f10711h = i;
        this.i = i2;
        this.j = str;
        this.k = pendingIntent;
    }

    public final String O() {
        return this.j;
    }

    @VisibleForTesting
    public final boolean P() {
        return this.k != null;
    }

    public final boolean Q() {
        return this.i <= 0;
    }

    public final String R() {
        String str = this.j;
        return str != null ? str : CommonStatusCodes.a(this.i);
    }

    public final boolean S() {
        return this.i == 16;
    }

    public final void a(Activity activity, int i) throws IntentSender.SendIntentException {
        if (P()) {
            activity.startIntentSenderForResult(this.k.getIntentSender(), i, null, 0, 0, 0);
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.f10711h == status.f10711h && this.i == status.i && Objects.a(this.j, status.j) && Objects.a(this.k, status.k);
    }

    @Override // com.google.android.gms.common.api.Result
    @KeepForSdk
    public final Status getStatus() {
        return this;
    }

    public final int getStatusCode() {
        return this.i;
    }

    public final int hashCode() {
        return Objects.a(Integer.valueOf(this.f10711h), Integer.valueOf(this.i), this.j, this.k);
    }

    public final String toString() {
        return Objects.a(this).a("statusCode", R()).a(e.y, this.k).toString();
    }

    @Override // android.os.Parcelable
    @KeepForSdk
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, getStatusCode());
        SafeParcelWriter.a(parcel, 2, O(), false);
        SafeParcelWriter.a(parcel, 3, (Parcelable) this.k, i, false);
        SafeParcelWriter.a(parcel, 1000, this.f10711h);
        SafeParcelWriter.a(parcel, a2);
    }

    public final PendingIntent a() {
        return this.k;
    }

    @KeepForSdk
    public Status(int i) {
        this(i, null);
    }

    @KeepForSdk
    public Status(int i, String str) {
        this(1, i, str, null);
    }

    @KeepForSdk
    public Status(int i, String str, PendingIntent pendingIntent) {
        this(1, i, str, pendingIntent);
    }
}
