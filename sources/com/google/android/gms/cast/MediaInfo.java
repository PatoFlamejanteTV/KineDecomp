package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zzmu;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class MediaInfo {

    /* renamed from: a, reason: collision with root package name */
    private final String f829a;
    private int b;
    private String c;
    private MediaMetadata d;
    private long e;
    private List<MediaTrack> f;
    private TextTrackStyle g;
    private JSONObject h;

    /* loaded from: classes.dex */
    public static class Builder {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MediaInfo(JSONObject jSONObject) throws JSONException {
        this.f829a = jSONObject.getString("contentId");
        String string = jSONObject.getString("streamType");
        if ("NONE".equals(string)) {
            this.b = 0;
        } else if ("BUFFERED".equals(string)) {
            this.b = 1;
        } else if ("LIVE".equals(string)) {
            this.b = 2;
        } else {
            this.b = -1;
        }
        this.c = jSONObject.getString("contentType");
        if (jSONObject.has("metadata")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("metadata");
            this.d = new MediaMetadata(jSONObject2.getInt("metadataType"));
            this.d.a(jSONObject2);
        }
        this.e = -1L;
        if (jSONObject.has("duration") && !jSONObject.isNull("duration")) {
            double optDouble = jSONObject.optDouble("duration", 0.0d);
            if (!Double.isNaN(optDouble) && !Double.isInfinite(optDouble)) {
                this.e = zzf.a(optDouble);
            }
        }
        if (jSONObject.has("tracks")) {
            this.f = new ArrayList();
            JSONArray jSONArray = jSONObject.getJSONArray("tracks");
            for (int i = 0; i < jSONArray.length(); i++) {
                this.f.add(new MediaTrack(jSONArray.getJSONObject(i)));
            }
        } else {
            this.f = null;
        }
        if (jSONObject.has("textTrackStyle")) {
            JSONObject jSONObject3 = jSONObject.getJSONObject("textTrackStyle");
            TextTrackStyle textTrackStyle = new TextTrackStyle();
            textTrackStyle.a(jSONObject3);
            this.g = textTrackStyle;
        } else {
            this.g = null;
        }
        this.h = jSONObject.optJSONObject("customData");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaInfo)) {
            return false;
        }
        MediaInfo mediaInfo = (MediaInfo) obj;
        if ((this.h == null) != (mediaInfo.h == null)) {
            return false;
        }
        if (this.h == null || mediaInfo.h == null || zzmu.zzd(this.h, mediaInfo.h)) {
            return zzf.a(this.f829a, mediaInfo.f829a) && this.b == mediaInfo.b && zzf.a(this.c, mediaInfo.c) && zzf.a(this.d, mediaInfo.d) && this.e == mediaInfo.e;
        }
        return false;
    }

    public int hashCode() {
        return zzw.a(this.f829a, Integer.valueOf(this.b), this.c, this.d, Long.valueOf(this.e), String.valueOf(this.h));
    }
}
