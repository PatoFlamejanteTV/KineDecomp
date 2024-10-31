package com.mixpanel.android.mpmetrics;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.facebook.share.internal.ShareConstants;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class InAppNotification implements Parcelable {
    public static final Parcelable.Creator<InAppNotification> CREATOR = new l();
    private static final Pattern k = Pattern.compile("(\\.[^./]+$)");

    /* renamed from: a, reason: collision with root package name */
    private Bitmap f3002a;
    private final JSONObject b;
    private final int c;
    private final int d;
    private final String e;
    private final String f;
    private final String g;
    private final String h;
    private final String i;
    private final String j;

    /* loaded from: classes.dex */
    public enum Type {
        UNKNOWN { // from class: com.mixpanel.android.mpmetrics.InAppNotification.Type.1
            @Override // java.lang.Enum
            public String toString() {
                return "*unknown_type*";
            }
        },
        MINI { // from class: com.mixpanel.android.mpmetrics.InAppNotification.Type.2
            @Override // java.lang.Enum
            public String toString() {
                return "mini";
            }
        },
        TAKEOVER { // from class: com.mixpanel.android.mpmetrics.InAppNotification.Type.3
            @Override // java.lang.Enum
            public String toString() {
                return "takeover";
            }
        };

        /* synthetic */ Type(l lVar) {
            this();
        }
    }

    public InAppNotification(Parcel parcel) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject = new JSONObject(parcel.readString());
        } catch (JSONException e) {
            Log.e("MixpanelAPI.InAppNotif", "Error reading JSON when creating InAppNotification from Parcel");
            jSONObject = jSONObject2;
        }
        this.b = jSONObject;
        this.c = parcel.readInt();
        this.d = parcel.readInt();
        this.e = parcel.readString();
        this.f = parcel.readString();
        this.g = parcel.readString();
        this.h = parcel.readString();
        this.i = parcel.readString();
        this.j = parcel.readString();
        this.f3002a = (Bitmap) parcel.readParcelable(Bitmap.class.getClassLoader());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public InAppNotification(JSONObject jSONObject) throws BadDecideObjectException {
        try {
            this.b = jSONObject;
            this.c = jSONObject.getInt(ShareConstants.WEB_DIALOG_PARAM_ID);
            this.d = jSONObject.getInt("message_id");
            this.e = jSONObject.getString("type");
            this.f = jSONObject.getString(ShareConstants.WEB_DIALOG_PARAM_TITLE);
            this.g = jSONObject.getString("body");
            this.h = jSONObject.getString("image_url");
            this.f3002a = Bitmap.createBitmap(500, 500, Bitmap.Config.ARGB_8888);
            this.i = jSONObject.getString("cta");
            this.j = jSONObject.getString("cta_url");
        } catch (JSONException e) {
            throw new BadDecideObjectException("Notification JSON was unexpected or bad", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("campaign_id", b());
            jSONObject.put("message_id", c());
            jSONObject.put("message_type", "inapp");
            jSONObject.put("message_subtype", this.e);
        } catch (JSONException e) {
            Log.e("MixpanelAPI.InAppNotif", "Impossible JSON Exception", e);
        }
        return jSONObject;
    }

    public int b() {
        return this.c;
    }

    public int c() {
        return this.d;
    }

    public Type d() {
        if (Type.MINI.toString().equals(this.e)) {
            return Type.MINI;
        }
        if (Type.TAKEOVER.toString().equals(this.e)) {
            return Type.TAKEOVER;
        }
        return Type.UNKNOWN;
    }

    public String e() {
        return this.f;
    }

    public String f() {
        return this.g;
    }

    public String g() {
        return this.h;
    }

    public String h() {
        return a(this.h, "@2x");
    }

    public String i() {
        return a(this.h, "@4x");
    }

    public String j() {
        return this.i;
    }

    public String k() {
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Bitmap bitmap) {
        this.f3002a = bitmap;
    }

    public Bitmap l() {
        return this.f3002a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.b.toString());
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeString(this.g);
        parcel.writeString(this.h);
        parcel.writeString(this.i);
        parcel.writeString(this.j);
        parcel.writeParcelable(this.f3002a, i);
    }

    static String a(String str, String str2) {
        Matcher matcher = k.matcher(str);
        if (matcher.find()) {
            return matcher.replaceFirst(str2 + "$1");
        }
        return str;
    }
}
