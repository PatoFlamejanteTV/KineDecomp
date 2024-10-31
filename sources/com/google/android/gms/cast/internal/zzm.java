package com.google.android.gms.cast.internal;

import android.os.SystemClock;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.cast.MediaStatus;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class zzm extends zzc {

    /* renamed from: a, reason: collision with root package name */
    private static final String f858a = zzf.b("com.google.cast.media");
    private long b;
    private MediaStatus c;
    private final List<zzp> d;
    private final zzp e;
    private final zzp f;
    private final zzp g;
    private final zzp h;
    private final zzp i;
    private final zzp j;
    private final zzp k;
    private final zzp l;
    private final zzp m;
    private final zzp n;
    private final zzp o;
    private final zzp p;
    private final zzp q;
    private final zzp r;

    public zzm(String str) {
        super(f858a, "MediaControlChannel", str, 1000L);
        this.e = new zzp(86400000L);
        this.f = new zzp(86400000L);
        this.g = new zzp(86400000L);
        this.h = new zzp(86400000L);
        this.i = new zzp(86400000L);
        this.j = new zzp(86400000L);
        this.k = new zzp(86400000L);
        this.l = new zzp(86400000L);
        this.m = new zzp(86400000L);
        this.n = new zzp(86400000L);
        this.o = new zzp(86400000L);
        this.p = new zzp(86400000L);
        this.q = new zzp(86400000L);
        this.r = new zzp(86400000L);
        this.d = new ArrayList();
        this.d.add(this.e);
        this.d.add(this.f);
        this.d.add(this.g);
        this.d.add(this.h);
        this.d.add(this.i);
        this.d.add(this.j);
        this.d.add(this.k);
        this.d.add(this.l);
        this.d.add(this.m);
        this.d.add(this.n);
        this.d.add(this.o);
        this.d.add(this.p);
        this.d.add(this.q);
        this.d.add(this.r);
        e();
    }

    private void a(long j, JSONObject jSONObject) throws JSONException {
        int i;
        boolean z = true;
        boolean a2 = this.e.a(j);
        boolean z2 = this.i.b() && !this.i.a(j);
        if ((!this.j.b() || this.j.a(j)) && (!this.k.b() || this.k.a(j))) {
            z = false;
        }
        int i2 = z2 ? 2 : 0;
        if (z) {
            i2 |= 1;
        }
        if (a2 || this.c == null) {
            this.c = new MediaStatus(jSONObject);
            this.b = SystemClock.elapsedRealtime();
            i = 31;
        } else {
            i = this.c.a(jSONObject, i2);
        }
        if ((i & 1) != 0) {
            this.b = SystemClock.elapsedRealtime();
            a();
        }
        if ((i & 2) != 0) {
            this.b = SystemClock.elapsedRealtime();
            a();
        }
        if ((i & 4) != 0) {
            b();
        }
        if ((i & 8) != 0) {
            c();
        }
        if ((i & 16) != 0) {
            d();
        }
        Iterator<zzp> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().a(j, 0);
        }
    }

    private void e() {
        this.b = 0L;
        this.c = null;
        Iterator<zzp> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    protected void a() {
    }

    protected void b() {
    }

    protected void c() {
    }

    protected void d() {
    }

    @Override // com.google.android.gms.cast.internal.zzd
    public void zzb(long j, int i) {
        Iterator<zzp> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().a(j, i);
        }
    }

    @Override // com.google.android.gms.cast.internal.zzd
    public final void zzbK(String str) {
        this.zzYC.b("message received: %s", str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("type");
            long optLong = jSONObject.optLong("requestId", -1L);
            if (string.equals("MEDIA_STATUS")) {
                JSONArray jSONArray = jSONObject.getJSONArray(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS);
                if (jSONArray.length() > 0) {
                    a(optLong, jSONArray.getJSONObject(0));
                    return;
                }
                this.c = null;
                a();
                b();
                c();
                d();
                this.l.a(optLong, 0);
                return;
            }
            if (string.equals("INVALID_PLAYER_STATE")) {
                this.zzYC.d("received unexpected error: Invalid Player State.", new Object[0]);
                JSONObject optJSONObject = jSONObject.optJSONObject("customData");
                Iterator<zzp> it = this.d.iterator();
                while (it.hasNext()) {
                    it.next().a(optLong, 2100, optJSONObject);
                }
                return;
            }
            if (string.equals("LOAD_FAILED")) {
                this.e.a(optLong, 2100, jSONObject.optJSONObject("customData"));
                return;
            }
            if (string.equals("LOAD_CANCELLED")) {
                this.e.a(optLong, 2101, jSONObject.optJSONObject("customData"));
                return;
            }
            if (string.equals("INVALID_REQUEST")) {
                this.zzYC.d("received unexpected error: Invalid Request.", new Object[0]);
                JSONObject optJSONObject2 = jSONObject.optJSONObject("customData");
                Iterator<zzp> it2 = this.d.iterator();
                while (it2.hasNext()) {
                    it2.next().a(optLong, 2100, optJSONObject2);
                }
            }
        } catch (JSONException e) {
            this.zzYC.d("Message is malformed (%s); ignoring: %s", e.getMessage(), str);
        }
    }

    @Override // com.google.android.gms.cast.internal.zzc, com.google.android.gms.cast.internal.zzd
    public void zzmP() {
        super.zzmP();
        e();
    }

    @Override // com.google.android.gms.cast.internal.zzc
    protected boolean zzz(long j) {
        boolean z;
        Iterator<zzp> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().b(j, 2102);
        }
        synchronized (zzp.f859a) {
            Iterator<zzp> it2 = this.d.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z = false;
                    break;
                }
                if (it2.next().b()) {
                    z = true;
                    break;
                }
            }
        }
        return z;
    }
}
