package com.google.android.gms.ads.internal.formats;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzn;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzan;
import com.google.android.gms.internal.zzeq;
import com.google.android.gms.internal.zzer;
import com.google.android.gms.internal.zziz;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class zzg extends zzh {

    /* renamed from: a */
    private zzeq f577a;
    private zzer b;
    private final zzn c;
    private zzh d;
    private boolean e;
    private Object f;

    private zzg(Context context, zzn zznVar, zzan zzanVar) {
        super(context, zznVar, null, zzanVar, null, null, null);
        this.e = false;
        this.f = new Object();
        this.c = zznVar;
    }

    public zzg(Context context, zzn zznVar, zzan zzanVar, zzeq zzeqVar) {
        this(context, zznVar, zzanVar);
        this.f577a = zzeqVar;
    }

    public zzg(Context context, zzn zznVar, zzan zzanVar, zzer zzerVar) {
        this(context, zznVar, zzanVar);
        this.b = zzerVar;
    }

    @Override // com.google.android.gms.ads.internal.formats.zzh
    public a a(View.OnClickListener onClickListener) {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.formats.zzh
    public void a() {
        zzx.b("recordImpression must be called on the main UI thread.");
        synchronized (this.f) {
            a(true);
            if (this.d != null) {
                this.d.a();
            } else {
                try {
                    if (this.f577a != null && !this.f577a.getOverrideClickHandling()) {
                        this.f577a.recordImpression();
                    } else if (this.b != null && !this.b.getOverrideClickHandling()) {
                        this.b.recordImpression();
                    }
                } catch (RemoteException e) {
                    zzb.d("Failed to call recordImpression", e);
                }
            }
            this.c.recordImpression();
        }
    }

    @Override // com.google.android.gms.ads.internal.formats.zzh
    public void a(View view) {
        synchronized (this.f) {
            this.e = true;
            try {
                if (this.f577a != null) {
                    this.f577a.zzd(com.google.android.gms.dynamic.zze.a(view));
                } else if (this.b != null) {
                    this.b.zzd(com.google.android.gms.dynamic.zze.a(view));
                }
            } catch (RemoteException e) {
                zzb.d("Failed to call prepareAd", e);
            }
            this.e = false;
        }
    }

    @Override // com.google.android.gms.ads.internal.formats.zzh
    public void a(View view, Map<String, WeakReference<View>> map, JSONObject jSONObject, JSONObject jSONObject2) {
        zzx.b("performClick must be called on the main UI thread.");
        synchronized (this.f) {
            if (this.d != null) {
                this.d.a(view, map, jSONObject, jSONObject2);
            } else {
                try {
                    if (this.f577a != null && !this.f577a.getOverrideClickHandling()) {
                        this.f577a.zzc(com.google.android.gms.dynamic.zze.a(view));
                    }
                    if (this.b != null && !this.b.getOverrideClickHandling()) {
                        this.f577a.zzc(com.google.android.gms.dynamic.zze.a(view));
                    }
                } catch (RemoteException e) {
                    zzb.d("Failed to call performClick", e);
                }
            }
            this.c.onAdClicked();
        }
    }

    public void a(zzh zzhVar) {
        synchronized (this.f) {
            this.d = zzhVar;
        }
    }

    public boolean b() {
        boolean z;
        synchronized (this.f) {
            z = this.e;
        }
        return z;
    }

    @Override // com.google.android.gms.ads.internal.formats.zzh
    public zziz c() {
        return null;
    }
}
