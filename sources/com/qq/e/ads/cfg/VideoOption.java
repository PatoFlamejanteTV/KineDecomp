package com.qq.e.ads.cfg;

import com.qq.e.comm.util.GDTLogger;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class VideoOption {

    /* renamed from: a */
    private final boolean f24813a;

    /* renamed from: b */
    private final int f24814b;

    /* loaded from: classes3.dex */
    public static final class AutoPlayPolicy {
        public static final int ALWAYS = 1;
        public static final int WIFI = 0;
    }

    /* loaded from: classes3.dex */
    public static final class Builder {

        /* renamed from: a */
        private boolean f24815a = true;

        /* renamed from: b */
        private int f24816b = 0;

        public final VideoOption build() {
            return new VideoOption(this, (byte) 0);
        }

        public final Builder setAutoPlayMuted(boolean z) {
            this.f24815a = z;
            return this;
        }

        public final Builder setAutoPlayPolicy(int i) {
            this.f24816b = i;
            return this;
        }
    }

    private VideoOption(Builder builder) {
        this.f24813a = builder.f24815a;
        this.f24814b = builder.f24816b;
    }

    /* synthetic */ VideoOption(Builder builder, byte b2) {
        this(builder);
    }

    public boolean getAutoPlayMuted() {
        return this.f24813a;
    }

    public int getAutoPlayPolicy() {
        return this.f24814b;
    }

    public JSONObject getOptions() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("autoPlayMuted", Boolean.valueOf(this.f24813a));
            jSONObject.putOpt("autoPlayPolicy", Integer.valueOf(this.f24814b));
        } catch (Exception e2) {
            GDTLogger.e("Get video options error: " + e2.getMessage());
        }
        return jSONObject;
    }
}
