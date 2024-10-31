package com.google.android.gms.wearable;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.wearable.internal.zzaz;
import com.google.android.gms.wearable.internal.zzbb;
import com.google.android.gms.wearable.internal.zzbm;
import com.google.android.gms.wearable.internal.zzbo;
import com.google.android.gms.wearable.internal.zzbq;
import com.google.android.gms.wearable.internal.zzl;
import com.google.android.gms.wearable.internal.zzw;
import com.google.android.gms.wearable.internal.zzx;

/* loaded from: classes.dex */
public class Wearable {

    /* renamed from: a, reason: collision with root package name */
    public static final DataApi f2328a = new zzx();
    public static final CapabilityApi b = new com.google.android.gms.wearable.internal.zzj();
    public static final MessageApi c = new zzaz();
    public static final NodeApi d = new zzbb();
    public static final ChannelApi e = new zzl();
    public static final zzc f = new com.google.android.gms.wearable.internal.zzg();
    public static final zza g = new com.google.android.gms.wearable.internal.zze();
    public static final zzf h = new zzw();
    public static final zzi i = new zzbm();
    public static final zzk j = new zzbq();
    public static final Api.zzc<zzbo> k = new Api.zzc<>();
    private static final Api.zza<zzbo, WearableOptions> m = new a();
    public static final Api<WearableOptions> l = new Api<>("Wearable.API", m, k);

    /* loaded from: classes.dex */
    public static final class WearableOptions implements Api.ApiOptions.Optional {

        /* loaded from: classes.dex */
        public static class Builder {
        }

        private WearableOptions(Builder builder) {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ WearableOptions(Builder builder, a aVar) {
            this(builder);
        }
    }

    private Wearable() {
    }
}
