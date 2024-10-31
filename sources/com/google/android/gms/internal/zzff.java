package com.google.android.gms.internal;

import org.json.JSONException;
import org.json.JSONObject;

@zzgr
/* loaded from: classes.dex */
public class zzff {
    private final boolean zzAv;
    private final boolean zzAw;
    private final boolean zzAx;
    private final boolean zzAy;
    private final boolean zzAz;

    /* loaded from: classes.dex */
    public static final class zza {
        private boolean zzAv;
        private boolean zzAw;
        private boolean zzAx;
        private boolean zzAy;
        private boolean zzAz;

        public zzff zzeh() {
            return new zzff(this);
        }

        public zza zzo(boolean z) {
            this.zzAv = z;
            return this;
        }

        public zza zzp(boolean z) {
            this.zzAw = z;
            return this;
        }

        public zza zzq(boolean z) {
            this.zzAx = z;
            return this;
        }

        public zza zzr(boolean z) {
            this.zzAy = z;
            return this;
        }

        public zza zzs(boolean z) {
            this.zzAz = z;
            return this;
        }
    }

    private zzff(zza zzaVar) {
        this.zzAv = zzaVar.zzAv;
        this.zzAw = zzaVar.zzAw;
        this.zzAx = zzaVar.zzAx;
        this.zzAy = zzaVar.zzAy;
        this.zzAz = zzaVar.zzAz;
    }

    public JSONObject toJson() {
        try {
            return new JSONObject().put("sms", this.zzAv).put("tel", this.zzAw).put("calendar", this.zzAx).put("storePicture", this.zzAy).put("inlineVideo", this.zzAz);
        } catch (JSONException e) {
            com.google.android.gms.ads.internal.util.client.zzb.b("Error occured while obtaining the MRAID capabilities.", e);
            return null;
        }
    }
}
