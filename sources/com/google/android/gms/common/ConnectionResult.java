package com.google.android.gms.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public final class ConnectionResult extends AbstractSafeParcelable {

    /* renamed from: b */
    private final int f10648b;

    /* renamed from: c */
    private final int f10649c;

    /* renamed from: d */
    private final PendingIntent f10650d;

    /* renamed from: e */
    private final String f10651e;

    /* renamed from: a */
    @KeepForSdk
    public static final ConnectionResult f10647a = new ConnectionResult(0);
    public static final Parcelable.Creator<ConnectionResult> CREATOR = new zza();

    @SafeParcelable.Constructor
    public ConnectionResult(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) int i2, @SafeParcelable.Param(id = 3) PendingIntent pendingIntent, @SafeParcelable.Param(id = 4) String str) {
        this.f10648b = i;
        this.f10649c = i2;
        this.f10650d = pendingIntent;
        this.f10651e = str;
    }

    public static String j(int i) {
        if (i == 99) {
            return "UNFINISHED";
        }
        if (i == 1500) {
            return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
        }
        switch (i) {
            case -1:
                return "UNKNOWN";
            case 0:
                return "SUCCESS";
            case 1:
                return "SERVICE_MISSING";
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 9:
                return "SERVICE_INVALID";
            case 10:
                return "DEVELOPER_ERROR";
            case 11:
                return "LICENSE_CHECK_FAILED";
            default:
                switch (i) {
                    case 13:
                        return "CANCELED";
                    case 14:
                        return "TIMEOUT";
                    case 15:
                        return "INTERRUPTED";
                    case 16:
                        return "API_UNAVAILABLE";
                    case 17:
                        return "SIGN_IN_FAILED";
                    case 18:
                        return "SERVICE_UPDATING";
                    case 19:
                        return "SERVICE_MISSING_PERMISSION";
                    case 20:
                        return "RESTRICTED_PROFILE";
                    case 21:
                        return "API_VERSION_UPDATE_REQUIRED";
                    default:
                        StringBuilder sb = new StringBuilder(31);
                        sb.append("UNKNOWN_ERROR_CODE(");
                        sb.append(i);
                        sb.append(")");
                        return sb.toString();
                }
        }
    }

    public final String O() {
        return this.f10651e;
    }

    public final PendingIntent P() {
        return this.f10650d;
    }

    public final boolean Q() {
        return (this.f10649c == 0 || this.f10650d == null) ? false : true;
    }

    public final boolean R() {
        return this.f10649c == 0;
    }

    public final int a() {
        return this.f10649c;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConnectionResult)) {
            return false;
        }
        ConnectionResult connectionResult = (ConnectionResult) obj;
        return this.f10649c == connectionResult.f10649c && Objects.a(this.f10650d, connectionResult.f10650d) && Objects.a(this.f10651e, connectionResult.f10651e);
    }

    public final int hashCode() {
        return Objects.a(Integer.valueOf(this.f10649c), this.f10650d, this.f10651e);
    }

    public final String toString() {
        return Objects.a(this).a("statusCode", j(this.f10649c)).a(com.umeng.commonsdk.proguard.e.y, this.f10650d).a(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, this.f10651e).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, this.f10648b);
        SafeParcelWriter.a(parcel, 2, a());
        SafeParcelWriter.a(parcel, 3, (Parcelable) P(), i, false);
        SafeParcelWriter.a(parcel, 4, O(), false);
        SafeParcelWriter.a(parcel, a2);
    }

    public ConnectionResult(int i) {
        this(i, null, null);
    }

    public ConnectionResult(int i, PendingIntent pendingIntent) {
        this(i, pendingIntent, null);
    }

    public ConnectionResult(int i, PendingIntent pendingIntent, String str) {
        this(1, i, pendingIntent, str);
    }
}
