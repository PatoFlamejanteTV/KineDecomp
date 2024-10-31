package com.google.android.gms.fitness;

import android.os.Build;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.zznm;
import com.google.android.gms.internal.zznn;
import com.google.android.gms.internal.zzno;
import com.google.android.gms.internal.zznp;
import com.google.android.gms.internal.zznq;
import com.google.android.gms.internal.zznr;
import com.google.android.gms.internal.zzns;
import com.google.android.gms.internal.zzol;
import com.google.android.gms.internal.zzon;
import com.google.android.gms.internal.zzoo;
import com.google.android.gms.internal.zzop;
import com.google.android.gms.internal.zzoq;
import com.google.android.gms.internal.zzor;
import com.google.android.gms.internal.zzos;
import com.google.android.gms.internal.zzot;
import com.google.android.gms.internal.zzov;

/* loaded from: classes.dex */
public class Fitness {

    /* renamed from: a, reason: collision with root package name */
    public static final Api.zzc<zznm> f1214a = new Api.zzc<>();
    public static final Api.zzc<zznn> b = new Api.zzc<>();
    public static final Api.zzc<zzno> c = new Api.zzc<>();
    public static final Api.zzc<zznp> d = new Api.zzc<>();
    public static final Api.zzc<zznq> e = new Api.zzc<>();
    public static final Api.zzc<zznr> f = new Api.zzc<>();
    public static final Api.zzc<zzns> g = new Api.zzc<>();

    @Deprecated
    public static final Void h = null;
    public static final Api<Api.ApiOptions.NoOptions> i = new Api<>("Fitness.SENSORS_API", new zznr.zzb(), f);
    public static final SensorsApi j = new zzos();
    public static final Api<Api.ApiOptions.NoOptions> k = new Api<>("Fitness.RECORDING_API", new zznq.zzb(), e);
    public static final RecordingApi l = new zzor();
    public static final Api<Api.ApiOptions.NoOptions> m = new Api<>("Fitness.SESSIONS_API", new zzns.zzb(), g);
    public static final SessionsApi n = new zzot();
    public static final Api<Api.ApiOptions.NoOptions> o = new Api<>("Fitness.HISTORY_API", new zzno.zzb(), c);
    public static final HistoryApi p = new zzop();
    public static final Api<Api.ApiOptions.NoOptions> q = new Api<>("Fitness.CONFIG_API", new zznn.zzb(), b);
    public static final ConfigApi r = new zzoo();
    public static final Api<Api.ApiOptions.NoOptions> s = new Api<>("Fitness.BLE_API", new zznm.zzb(), f1214a);
    public static final BleApi t = a();
    public static final Api<Api.ApiOptions.NoOptions> u = new Api<>("Fitness.INTERNAL_API", new zznp.zza(), d);
    public static final zzol v = new zzoq();
    public static final Scope w = new Scope("https://www.googleapis.com/auth/fitness.activity.read");
    public static final Scope x = new Scope("https://www.googleapis.com/auth/fitness.activity.write");
    public static final Scope y = new Scope("https://www.googleapis.com/auth/fitness.location.read");
    public static final Scope z = new Scope("https://www.googleapis.com/auth/fitness.location.write");
    public static final Scope A = new Scope("https://www.googleapis.com/auth/fitness.body.read");
    public static final Scope B = new Scope("https://www.googleapis.com/auth/fitness.body.write");
    public static final Scope C = new Scope("https://www.googleapis.com/auth/fitness.nutrition.read");
    public static final Scope D = new Scope("https://www.googleapis.com/auth/fitness.nutrition.write");

    private Fitness() {
    }

    private static BleApi a() {
        return Build.VERSION.SDK_INT >= 18 ? new zzon() : new zzov();
    }
}
