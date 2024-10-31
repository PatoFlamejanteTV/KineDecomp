package com.google.android.gms.cast;

import android.util.SparseArray;
import com.google.android.gms.cast.internal.zzf;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class MediaStatus {
    private long b;
    private MediaInfo c;
    private double d;
    private int e;
    private int f;
    private long g;
    private long h;
    private double i;
    private boolean j;
    private long[] k;
    private JSONObject l;

    /* renamed from: a, reason: collision with root package name */
    private int f834a = 0;
    private int m = 0;
    private int n = 0;
    private final a o = new a();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private int b = 0;
        private List<MediaQueueItem> c = new ArrayList();
        private SparseArray<Integer> d = new SparseArray<>();

        a() {
        }

        private void a(MediaQueueItem[] mediaQueueItemArr) {
            this.c.clear();
            this.d.clear();
            for (int i = 0; i < mediaQueueItemArr.length; i++) {
                MediaQueueItem mediaQueueItem = mediaQueueItemArr[i];
                this.c.add(mediaQueueItem);
                this.d.put(mediaQueueItem.a(), Integer.valueOf(i));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:12:0x002f  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x00f5  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean a(org.json.JSONObject r11) throws org.json.JSONException {
            /*
                Method dump skipped, instructions count: 280
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.MediaStatus.a.a(org.json.JSONObject):boolean");
        }

        private Integer b(int i) {
            return this.d.get(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            this.b = 0;
            this.c.clear();
            this.d.clear();
        }

        public int a() {
            return this.c.size();
        }

        public MediaQueueItem a(int i) {
            Integer num = this.d.get(i);
            if (num == null) {
                return null;
            }
            return this.c.get(num.intValue());
        }
    }

    public MediaStatus(JSONObject jSONObject) throws JSONException {
        a(jSONObject, 0);
    }

    private boolean a(int i, int i2) {
        return i == 1 && i2 == 0;
    }

    public int a(JSONObject jSONObject, int i) throws JSONException {
        int i2;
        long[] jArr;
        boolean z;
        int i3;
        boolean z2 = true;
        long j = jSONObject.getLong("mediaSessionId");
        if (j != this.b) {
            this.b = j;
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (jSONObject.has("playerState")) {
            String string = jSONObject.getString("playerState");
            int i4 = string.equals("IDLE") ? 1 : string.equals("PLAYING") ? 2 : string.equals("PAUSED") ? 3 : string.equals("BUFFERING") ? 4 : 0;
            if (i4 != this.e) {
                this.e = i4;
                i2 |= 2;
            }
            if (i4 == 1 && jSONObject.has("idleReason")) {
                String string2 = jSONObject.getString("idleReason");
                int i5 = string2.equals("CANCELLED") ? 2 : string2.equals("INTERRUPTED") ? 3 : string2.equals("FINISHED") ? 1 : string2.equals("ERROR") ? 4 : 0;
                if (i5 != this.f) {
                    this.f = i5;
                    i2 |= 2;
                }
            }
        }
        if (jSONObject.has("playbackRate")) {
            double d = jSONObject.getDouble("playbackRate");
            if (this.d != d) {
                this.d = d;
                i2 |= 2;
            }
        }
        if (jSONObject.has("currentTime") && (i & 2) == 0) {
            long a2 = zzf.a(jSONObject.getDouble("currentTime"));
            if (a2 != this.g) {
                this.g = a2;
                i2 |= 2;
            }
        }
        if (jSONObject.has("supportedMediaCommands")) {
            long j2 = jSONObject.getLong("supportedMediaCommands");
            if (j2 != this.h) {
                this.h = j2;
                i2 |= 2;
            }
        }
        if (jSONObject.has("volume") && (i & 1) == 0) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("volume");
            double d2 = jSONObject2.getDouble("level");
            if (d2 != this.i) {
                this.i = d2;
                i2 |= 2;
            }
            boolean z3 = jSONObject2.getBoolean("muted");
            if (z3 != this.j) {
                this.j = z3;
                i2 |= 2;
            }
        }
        if (jSONObject.has("activeTrackIds")) {
            JSONArray jSONArray = jSONObject.getJSONArray("activeTrackIds");
            int length = jSONArray.length();
            long[] jArr2 = new long[length];
            for (int i6 = 0; i6 < length; i6++) {
                jArr2[i6] = jSONArray.getLong(i6);
            }
            if (this.k != null && this.k.length == length) {
                int i7 = 0;
                while (true) {
                    if (i7 >= length) {
                        z2 = false;
                        break;
                    }
                    if (this.k[i7] != jArr2[i7]) {
                        break;
                    }
                    i7++;
                }
            }
            if (z2) {
                this.k = jArr2;
            }
            z = z2;
            jArr = jArr2;
        } else if (this.k != null) {
            z = true;
            jArr = null;
        } else {
            jArr = null;
            z = false;
        }
        if (z) {
            this.k = jArr;
            i2 |= 2;
        }
        if (jSONObject.has("customData")) {
            this.l = jSONObject.getJSONObject("customData");
            i2 |= 2;
        }
        if (jSONObject.has("media")) {
            JSONObject jSONObject3 = jSONObject.getJSONObject("media");
            this.c = new MediaInfo(jSONObject3);
            i2 |= 2;
            if (jSONObject3.has("metadata")) {
                i2 |= 4;
            }
        }
        if (jSONObject.has("currentItemId") && this.f834a != (i3 = jSONObject.getInt("currentItemId"))) {
            this.f834a = i3;
            i2 |= 2;
        }
        int optInt = jSONObject.optInt("preloadedItemId", 0);
        if (this.n != optInt) {
            this.n = optInt;
            i2 |= 16;
        }
        int optInt2 = jSONObject.optInt("loadingItemId", 0);
        if (this.m != optInt2) {
            this.m = optInt2;
            i2 |= 2;
        }
        if (!a(this.e, this.m)) {
            return this.o.a(jSONObject) ? i2 | 8 : i2;
        }
        this.f834a = 0;
        this.m = 0;
        this.n = 0;
        if (this.o.a() <= 0) {
            return i2;
        }
        this.o.b();
        return i2 | 8;
    }
}
