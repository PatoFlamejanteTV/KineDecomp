package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class WebImage implements SafeParcelable {
    public static final Parcelable.Creator<WebImage> CREATOR = new zzb();

    /* renamed from: a, reason: collision with root package name */
    private final int f990a;
    private final Uri b;
    private final int c;
    private final int d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebImage(int i, Uri uri, int i2, int i3) {
        this.f990a = i;
        this.b = uri;
        this.c = i2;
        this.d = i3;
    }

    public WebImage(Uri uri, int i, int i2) throws IllegalArgumentException {
        this(1, uri, i, i2);
        if (uri == null) {
            throw new IllegalArgumentException("url cannot be null");
        }
        if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("width and height must not be negative");
        }
    }

    public WebImage(JSONObject jSONObject) throws IllegalArgumentException {
        this(a(jSONObject), jSONObject.optInt("width", 0), jSONObject.optInt("height", 0));
    }

    private static Uri a(JSONObject jSONObject) {
        if (!jSONObject.has("url")) {
            return null;
        }
        try {
            return Uri.parse(jSONObject.getString("url"));
        } catch (JSONException e) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.f990a;
    }

    public Uri b() {
        return this.b;
    }

    public int c() {
        return this.c;
    }

    public int d() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public JSONObject e() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", this.b.toString());
            jSONObject.put("width", this.c);
            jSONObject.put("height", this.d);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof WebImage)) {
            return false;
        }
        WebImage webImage = (WebImage) obj;
        return zzw.a(this.b, webImage.b) && this.c == webImage.c && this.d == webImage.d;
    }

    public int hashCode() {
        return zzw.a(this.b, Integer.valueOf(this.c), Integer.valueOf(this.d));
    }

    public String toString() {
        return String.format("Image %dx%d %s", Integer.valueOf(this.c), Integer.valueOf(this.d), this.b.toString());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb.a(this, parcel, i);
    }
}
