package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class WebImage extends AbstractSafeParcelable {
    public static final Parcelable.Creator<WebImage> CREATOR = new zae();

    /* renamed from: a */
    private final int f11032a;

    /* renamed from: b */
    private final Uri f11033b;

    /* renamed from: c */
    private final int f11034c;

    /* renamed from: d */
    private final int f11035d;

    @SafeParcelable.Constructor
    public WebImage(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) Uri uri, @SafeParcelable.Param(id = 3) int i2, @SafeParcelable.Param(id = 4) int i3) {
        this.f11032a = i;
        this.f11033b = uri;
        this.f11034c = i2;
        this.f11035d = i3;
    }

    private static Uri a(JSONObject jSONObject) {
        if (jSONObject.has("url")) {
            try {
                return Uri.parse(jSONObject.getString("url"));
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    public final Uri O() {
        return this.f11033b;
    }

    public final int P() {
        return this.f11034c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof WebImage)) {
            WebImage webImage = (WebImage) obj;
            if (Objects.a(this.f11033b, webImage.f11033b) && this.f11034c == webImage.f11034c && this.f11035d == webImage.f11035d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.a(this.f11033b, Integer.valueOf(this.f11034c), Integer.valueOf(this.f11035d));
    }

    public final String toString() {
        return String.format(Locale.US, "Image %dx%d %s", Integer.valueOf(this.f11034c), Integer.valueOf(this.f11035d), this.f11033b.toString());
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, this.f11032a);
        SafeParcelWriter.a(parcel, 2, (Parcelable) O(), i, false);
        SafeParcelWriter.a(parcel, 3, P());
        SafeParcelWriter.a(parcel, 4, a());
        SafeParcelWriter.a(parcel, a2);
    }

    public final int a() {
        return this.f11035d;
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

    @KeepForSdk
    public WebImage(JSONObject jSONObject) throws IllegalArgumentException {
        this(a(jSONObject), jSONObject.optInt("width", 0), jSONObject.optInt("height", 0));
    }
}
