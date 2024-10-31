package com.google.android.gms.nearby;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.zzpm;
import com.google.android.gms.internal.zzpu;
import com.google.android.gms.nearby.bootstrap.zza;
import com.google.android.gms.nearby.connection.Connections;
import com.google.android.gms.nearby.messages.Messages;
import com.google.android.gms.nearby.messages.MessagesOptions;
import com.google.android.gms.nearby.messages.internal.zzk;
import com.google.android.gms.nearby.messages.internal.zzl;
import com.google.android.gms.nearby.messages.zzc;
import com.google.android.gms.nearby.sharing.internal.zzh;
import com.google.android.gms.nearby.sharing.internal.zzi;
import com.google.android.gms.nearby.sharing.zzd;
import com.google.android.gms.nearby.sharing.zze;

/* loaded from: classes.dex */
public final class Nearby {

    /* renamed from: a */
    public static final Api<Api.ApiOptions.NoOptions> f2082a = new Api<>("Nearby.CONNECTIONS_API", zzpu.zzRl, zzpu.zzRk);
    public static final Connections b = new zzpu();
    public static final Api<MessagesOptions> c = new Api<>("Nearby.MESSAGES_API", zzk.b, zzk.f2128a);
    public static final Messages d = new zzk();
    public static final zzc e = new zzl();
    public static final Api<Api.ApiOptions.NoOptions> f = new Api<>("Nearby.SHARING_API", zzh.b, zzh.f2142a);
    public static final zzd g = new zzh();
    public static final zze h = new zzi();
    public static final Api<Api.ApiOptions.NoOptions> i = new Api<>("Nearby.BOOTSTRAP_API", zzpm.zzRl, zzpm.zzRk);
    public static final zza j = new zzpm();

    private Nearby() {
    }
}
