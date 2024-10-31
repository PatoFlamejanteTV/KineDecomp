package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zzmu;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class MediaQueueItem {

    /* renamed from: a, reason: collision with root package name */
    private MediaInfo f832a;
    private int b;
    private boolean c;
    private double d;
    private double e;
    private double f;
    private long[] g;
    private JSONObject h;

    /* loaded from: classes.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        private final MediaQueueItem f833a;

        public Builder(MediaInfo mediaInfo) throws IllegalArgumentException {
            this.f833a = new MediaQueueItem(mediaInfo);
        }

        public MediaQueueItem a() {
            this.f833a.b();
            return this.f833a;
        }
    }

    private MediaQueueItem(MediaInfo mediaInfo) throws IllegalArgumentException {
        this.b = 0;
        this.c = true;
        this.e = Double.POSITIVE_INFINITY;
        if (mediaInfo == null) {
            throw new IllegalArgumentException("media cannot be null.");
        }
        this.f832a = mediaInfo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MediaQueueItem(JSONObject jSONObject) throws JSONException {
        this.b = 0;
        this.c = true;
        this.e = Double.POSITIVE_INFINITY;
        a(jSONObject);
    }

    public int a() {
        return this.b;
    }

    public boolean a(JSONObject jSONObject) throws JSONException {
        boolean z;
        boolean z2;
        long[] jArr;
        boolean z3;
        int i;
        if (jSONObject.has("media")) {
            this.f832a = new MediaInfo(jSONObject.getJSONObject("media"));
            z = true;
        } else {
            z = false;
        }
        if (jSONObject.has("itemId") && this.b != (i = jSONObject.getInt("itemId"))) {
            this.b = i;
            z = true;
        }
        if (jSONObject.has("autoplay") && this.c != (z3 = jSONObject.getBoolean("autoplay"))) {
            this.c = z3;
            z = true;
        }
        if (jSONObject.has("startTime")) {
            double d = jSONObject.getDouble("startTime");
            if (Math.abs(d - this.d) > 1.0E-7d) {
                this.d = d;
                z = true;
            }
        }
        if (jSONObject.has("playbackDuration")) {
            double d2 = jSONObject.getDouble("playbackDuration");
            if (Math.abs(d2 - this.e) > 1.0E-7d) {
                this.e = d2;
                z = true;
            }
        }
        if (jSONObject.has("preloadTime")) {
            double d3 = jSONObject.getDouble("preloadTime");
            if (Math.abs(d3 - this.f) > 1.0E-7d) {
                this.f = d3;
                z = true;
            }
        }
        if (jSONObject.has("activeTrackIds")) {
            JSONArray jSONArray = jSONObject.getJSONArray("activeTrackIds");
            int length = jSONArray.length();
            long[] jArr2 = new long[length];
            for (int i2 = 0; i2 < length; i2++) {
                jArr2[i2] = jSONArray.getLong(i2);
            }
            if (this.g == null) {
                jArr = jArr2;
                z2 = true;
            } else if (this.g.length == length) {
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        z2 = false;
                        jArr = jArr2;
                        break;
                    }
                    if (this.g[i3] != jArr2[i3]) {
                        jArr = jArr2;
                        z2 = true;
                        break;
                    }
                    i3++;
                }
            } else {
                jArr = jArr2;
                z2 = true;
            }
        } else {
            z2 = false;
            jArr = null;
        }
        if (z2) {
            this.g = jArr;
            z = true;
        }
        if (!jSONObject.has("customData")) {
            return z;
        }
        this.h = jSONObject.getJSONObject("customData");
        return true;
    }

    void b() throws IllegalArgumentException {
        if (this.f832a == null) {
            throw new IllegalArgumentException("media cannot be null.");
        }
        if (Double.isNaN(this.d) || this.d < 0.0d) {
            throw new IllegalArgumentException("startTime cannot be negative or NaN.");
        }
        if (Double.isNaN(this.e)) {
            throw new IllegalArgumentException("playbackDuration cannot be NaN.");
        }
        if (Double.isNaN(this.f) || this.f < 0.0d) {
            throw new IllegalArgumentException("preloadTime cannot be negative or Nan.");
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaQueueItem)) {
            return false;
        }
        MediaQueueItem mediaQueueItem = (MediaQueueItem) obj;
        if ((this.h == null) != (mediaQueueItem.h == null)) {
            return false;
        }
        if (this.h == null || mediaQueueItem.h == null || zzmu.zzd(this.h, mediaQueueItem.h)) {
            return zzf.a(this.f832a, mediaQueueItem.f832a) && this.b == mediaQueueItem.b && this.c == mediaQueueItem.c && this.d == mediaQueueItem.d && this.e == mediaQueueItem.e && this.f == mediaQueueItem.f && zzf.a(this.g, mediaQueueItem.g);
        }
        return false;
    }

    public int hashCode() {
        return zzw.a(this.f832a, Integer.valueOf(this.b), Boolean.valueOf(this.c), Double.valueOf(this.d), Double.valueOf(this.e), Double.valueOf(this.f), this.g, String.valueOf(this.h));
    }
}
