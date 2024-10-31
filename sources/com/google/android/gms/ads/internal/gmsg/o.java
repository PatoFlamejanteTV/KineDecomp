package com.google.android.gms.ads.internal.gmsg;

import com.google.android.gms.internal.ads.zzahu;
import com.google.android.gms.internal.ads.zzayh;
import com.google.android.gms.internal.ads.zzbbd;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class o implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ Map f10052a;

    /* renamed from: b */
    final /* synthetic */ zzahu f10053b;

    /* renamed from: c */
    private final /* synthetic */ HttpClient f10054c;

    public o(HttpClient httpClient, Map map, zzahu zzahuVar) {
        this.f10054c = httpClient;
        this.f10052a = map;
        this.f10053b = zzahuVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbbd.zzdn("Received Http request.");
        try {
            JSONObject send = this.f10054c.send(new JSONObject((String) this.f10052a.get("http_request")));
            if (send == null) {
                zzbbd.e("Response should not be null.");
            } else {
                zzayh.zzelc.post(new p(this, send));
            }
        } catch (Exception e2) {
            zzbbd.zzb("Error converting request to json.", e2);
        }
    }
}
