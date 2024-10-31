package com.google.android.gms.cast;

import android.graphics.Color;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zzmu;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class TextTrackStyle {

    /* renamed from: a, reason: collision with root package name */
    private float f840a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private String i;
    private int j;
    private int k;
    private JSONObject l;

    public TextTrackStyle() {
        a();
    }

    private int a(String str) {
        if (str == null || str.length() != 9 || str.charAt(0) != '#') {
            return 0;
        }
        try {
            return Color.argb(Integer.parseInt(str.substring(7, 9), 16), Integer.parseInt(str.substring(1, 3), 16), Integer.parseInt(str.substring(3, 5), 16), Integer.parseInt(str.substring(5, 7), 16));
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private void a() {
        this.f840a = 1.0f;
        this.b = 0;
        this.c = 0;
        this.d = -1;
        this.e = 0;
        this.f = -1;
        this.g = 0;
        this.h = 0;
        this.i = null;
        this.j = -1;
        this.k = -1;
        this.l = null;
    }

    public void a(JSONObject jSONObject) throws JSONException {
        a();
        this.f840a = (float) jSONObject.optDouble("fontScale", 1.0d);
        this.b = a(jSONObject.optString("foregroundColor"));
        this.c = a(jSONObject.optString("backgroundColor"));
        if (jSONObject.has("edgeType")) {
            String string = jSONObject.getString("edgeType");
            if ("NONE".equals(string)) {
                this.d = 0;
            } else if ("OUTLINE".equals(string)) {
                this.d = 1;
            } else if ("DROP_SHADOW".equals(string)) {
                this.d = 2;
            } else if ("RAISED".equals(string)) {
                this.d = 3;
            } else if ("DEPRESSED".equals(string)) {
                this.d = 4;
            }
        }
        this.e = a(jSONObject.optString("edgeColor"));
        if (jSONObject.has("windowType")) {
            String string2 = jSONObject.getString("windowType");
            if ("NONE".equals(string2)) {
                this.f = 0;
            } else if ("NORMAL".equals(string2)) {
                this.f = 1;
            } else if ("ROUNDED_CORNERS".equals(string2)) {
                this.f = 2;
            }
        }
        this.g = a(jSONObject.optString("windowColor"));
        if (this.f == 2) {
            this.h = jSONObject.optInt("windowRoundedCornerRadius", 0);
        }
        this.i = jSONObject.optString("fontFamily", null);
        if (jSONObject.has("fontGenericFamily")) {
            String string3 = jSONObject.getString("fontGenericFamily");
            if ("SANS_SERIF".equals(string3)) {
                this.j = 0;
            } else if ("MONOSPACED_SANS_SERIF".equals(string3)) {
                this.j = 1;
            } else if ("SERIF".equals(string3)) {
                this.j = 2;
            } else if ("MONOSPACED_SERIF".equals(string3)) {
                this.j = 3;
            } else if ("CASUAL".equals(string3)) {
                this.j = 4;
            } else if ("CURSIVE".equals(string3)) {
                this.j = 5;
            } else if ("SMALL_CAPITALS".equals(string3)) {
                this.j = 6;
            }
        }
        if (jSONObject.has("fontStyle")) {
            String string4 = jSONObject.getString("fontStyle");
            if ("NORMAL".equals(string4)) {
                this.k = 0;
            } else if ("BOLD".equals(string4)) {
                this.k = 1;
            } else if ("ITALIC".equals(string4)) {
                this.k = 2;
            } else if ("BOLD_ITALIC".equals(string4)) {
                this.k = 3;
            }
        }
        this.l = jSONObject.optJSONObject("customData");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextTrackStyle)) {
            return false;
        }
        TextTrackStyle textTrackStyle = (TextTrackStyle) obj;
        if ((this.l == null) != (textTrackStyle.l == null)) {
            return false;
        }
        if (this.l == null || textTrackStyle.l == null || zzmu.zzd(this.l, textTrackStyle.l)) {
            return this.f840a == textTrackStyle.f840a && this.b == textTrackStyle.b && this.c == textTrackStyle.c && this.d == textTrackStyle.d && this.e == textTrackStyle.e && this.f == textTrackStyle.f && this.h == textTrackStyle.h && zzf.a(this.i, textTrackStyle.i) && this.j == textTrackStyle.j && this.k == textTrackStyle.k;
        }
        return false;
    }

    public int hashCode() {
        return zzw.a(Float.valueOf(this.f840a), Integer.valueOf(this.b), Integer.valueOf(this.c), Integer.valueOf(this.d), Integer.valueOf(this.e), Integer.valueOf(this.f), Integer.valueOf(this.g), Integer.valueOf(this.h), this.i, Integer.valueOf(this.j), Integer.valueOf(this.k), this.l);
    }
}
