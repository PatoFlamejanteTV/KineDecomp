package com.google.android.gms.cast;

import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zzmu;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class MediaTrack {

    /* renamed from: a, reason: collision with root package name */
    private long f836a;
    private int b;
    private String c;
    private String d;
    private String e;
    private String f;
    private int g;
    private JSONObject h;

    /* loaded from: classes.dex */
    public static class Builder {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MediaTrack(JSONObject jSONObject) throws JSONException {
        a(jSONObject);
    }

    private void a() {
        this.f836a = 0L;
        this.b = 0;
        this.c = null;
        this.e = null;
        this.f = null;
        this.g = -1;
        this.h = null;
    }

    private void a(JSONObject jSONObject) throws JSONException {
        a();
        this.f836a = jSONObject.getLong("trackId");
        String string = jSONObject.getString("type");
        if ("TEXT".equals(string)) {
            this.b = 1;
        } else if ("AUDIO".equals(string)) {
            this.b = 2;
        } else {
            if (!ShareConstants.VIDEO_URL.equals(string)) {
                throw new JSONException("invalid type: " + string);
            }
            this.b = 3;
        }
        this.c = jSONObject.optString("trackContentId", null);
        this.d = jSONObject.optString("trackContentType", null);
        this.e = jSONObject.optString("name", null);
        this.f = jSONObject.optString("language", null);
        if (jSONObject.has("subtype")) {
            String string2 = jSONObject.getString("subtype");
            if ("SUBTITLES".equals(string2)) {
                this.g = 1;
            } else if ("CAPTIONS".equals(string2)) {
                this.g = 2;
            } else if ("DESCRIPTIONS".equals(string2)) {
                this.g = 3;
            } else if ("CHAPTERS".equals(string2)) {
                this.g = 4;
            } else {
                if (!"METADATA".equals(string2)) {
                    throw new JSONException("invalid subtype: " + string2);
                }
                this.g = 5;
            }
        } else {
            this.g = 0;
        }
        this.h = jSONObject.optJSONObject("customData");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaTrack)) {
            return false;
        }
        MediaTrack mediaTrack = (MediaTrack) obj;
        if ((this.h == null) != (mediaTrack.h == null)) {
            return false;
        }
        if (this.h == null || mediaTrack.h == null || zzmu.zzd(this.h, mediaTrack.h)) {
            return this.f836a == mediaTrack.f836a && this.b == mediaTrack.b && zzf.a(this.c, mediaTrack.c) && zzf.a(this.d, mediaTrack.d) && zzf.a(this.e, mediaTrack.e) && zzf.a(this.f, mediaTrack.f) && this.g == mediaTrack.g;
        }
        return false;
    }

    public int hashCode() {
        return zzw.a(Long.valueOf(this.f836a), Integer.valueOf(this.b), this.c, this.d, this.e, this.f, Integer.valueOf(this.g), this.h);
    }
}
