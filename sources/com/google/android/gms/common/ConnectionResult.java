package com.google.android.gms.common;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

/* loaded from: classes.dex */
public final class ConnectionResult implements SafeParcelable {
    final int b;
    private final int c;
    private final PendingIntent d;
    private final String e;

    /* renamed from: a, reason: collision with root package name */
    public static final ConnectionResult f860a = new ConnectionResult(0);
    public static final Parcelable.Creator<ConnectionResult> CREATOR = new zzb();

    public ConnectionResult(int i) {
        this(i, null, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConnectionResult(int i, int i2, PendingIntent pendingIntent, String str) {
        this.b = i;
        this.c = i2;
        this.d = pendingIntent;
        this.e = str;
    }

    public ConnectionResult(int i, PendingIntent pendingIntent) {
        this(i, pendingIntent, null);
    }

    public ConnectionResult(int i, PendingIntent pendingIntent, String str) {
        this(1, i, pendingIntent, str);
    }

    static String a(int i) {
        switch (i) {
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
            case 12:
            default:
                return "UNKNOWN_ERROR_CODE(" + i + ")";
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
        }
    }

    public void a(Activity activity, int i) throws IntentSender.SendIntentException {
        if (a()) {
            activity.startIntentSenderForResult(this.d.getIntentSender(), i, null, 0, 0, 0);
        }
    }

    public boolean a() {
        return (this.c == 0 || this.d == null) ? false : true;
    }

    public boolean b() {
        return this.c == 0;
    }

    public int c() {
        return this.c;
    }

    public PendingIntent d() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConnectionResult)) {
            return false;
        }
        ConnectionResult connectionResult = (ConnectionResult) obj;
        return this.c == connectionResult.c && zzw.a(this.d, connectionResult.d) && zzw.a(this.e, connectionResult.e);
    }

    public int hashCode() {
        return zzw.a(Integer.valueOf(this.c), this.d, this.e);
    }

    public String toString() {
        return zzw.a(this).a("statusCode", a(this.c)).a("resolution", this.d).a(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, this.e).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb.a(this, parcel, i);
    }
}
