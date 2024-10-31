package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.ConditionVariable;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.concurrent.Callable;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

@zzark
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public final class zzaak implements SharedPreferences.OnSharedPreferenceChangeListener {
    private Context zzcnq;
    private final Object lock = new Object();
    private final ConditionVariable zzcnn = new ConditionVariable();
    private volatile boolean zztd = false;

    @VisibleForTesting
    private volatile boolean zzcno = false;
    private SharedPreferences zzcnp = null;
    private JSONObject zzcnr = new JSONObject();

    private final void zzqy() {
        if (this.zzcnp == null) {
            return;
        }
        try {
            this.zzcnr = new JSONObject((String) zzbak.zza(this.zzcnq, new Callable(this) { // from class: com.google.android.gms.internal.ads.f

                /* renamed from: a, reason: collision with root package name */
                private final zzaak f12153a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f12153a = this;
                }

                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.f12153a.zzqz();
                }
            }));
        } catch (JSONException unused) {
        }
    }

    public final void initialize(Context context) {
        if (this.zztd) {
            return;
        }
        synchronized (this.lock) {
            if (this.zztd) {
                return;
            }
            if (!this.zzcno) {
                this.zzcno = true;
            }
            this.zzcnq = context.getApplicationContext() == null ? context : context.getApplicationContext();
            try {
                Context remoteContext = GooglePlayServicesUtilLight.getRemoteContext(context);
                if (remoteContext == null && context != null && (remoteContext = context.getApplicationContext()) == null) {
                    remoteContext = context;
                }
                if (remoteContext == null) {
                    return;
                }
                zzwu.zzpx();
                this.zzcnp = remoteContext.getSharedPreferences("google_ads_flags", 0);
                if (this.zzcnp != null) {
                    this.zzcnp.registerOnSharedPreferenceChangeListener(this);
                }
                zzqy();
                this.zztd = true;
            } finally {
                this.zzcno = false;
                this.zzcnn.open();
            }
        }
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if ("flag_configuration".equals(str)) {
            zzqy();
        }
    }

    public final <T> T zzd(zzaac<T> zzaacVar) {
        if (!this.zzcnn.block(5000L)) {
            synchronized (this.lock) {
                if (!this.zzcno) {
                    throw new IllegalStateException("Flags.initialize() was not called!");
                }
            }
        }
        if (!this.zztd || this.zzcnp == null) {
            synchronized (this.lock) {
                if (this.zztd && this.zzcnp != null) {
                }
                return zzaacVar.zzqv();
            }
        }
        if (zzaacVar.getSource() == 1 && this.zzcnr.has(zzaacVar.getKey())) {
            return zzaacVar.zzb(this.zzcnr);
        }
        return (T) zzbak.zza(this.zzcnq, new CallableC0909g(this, zzaacVar));
    }

    public final /* synthetic */ String zzqz() throws Exception {
        return this.zzcnp.getString("flag_configuration", "{}");
    }
}
