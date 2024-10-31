package com.google.android.gms.measurement.internal;

import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.internal.zzd;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzlr;

/* loaded from: classes.dex */
public final class zzk {

    /* renamed from: a, reason: collision with root package name */
    public static zza<Boolean> f2058a = zza.a("measurement.service_enabled", false);
    public static zza<Boolean> b = zza.a("measurement.service_client_enabled", true);
    public static zza<String> c = zza.a("measurement.log_tag", "GMPM", "GMPM-SVC");
    public static zza<Long> d = zza.a("measurement.ad_id_cache_time", 10000L);
    public static zza<Long> e = zza.a("measurement.monitoring.sample_period_millis", 86400000L);
    public static zza<Integer> f = zza.a("measurement.upload.max_bundles", 100);
    public static zza<Integer> g = zza.a("measurement.upload.max_batch_size", NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
    public static zza<String> h = zza.a("measurement.upload.url", "https://app-measurement.com/a");
    public static zza<Long> i = zza.a("measurement.upload.backoff_period", 43200000L);
    public static zza<Long> j = zza.a("measurement.upload.interval", 3600000L);
    public static zza<Long> k = zza.a("measurement.upload.stale_data_deletion_interval", 86400000L);
    public static zza<Long> l = zza.a("measurement.upload.initial_upload_delay_time", 15000L);
    public static zza<Long> m = zza.a("measurement.upload.retry_time", 1800000L);
    public static zza<Integer> n = zza.a("measurement.upload.retry_count", 6);
    public static zza<Long> o = zza.a("measurement.upload.retry_time", 2419200000L);
    public static zza<Long> p = zza.a("measurement.service_client.idle_disconnect_millis", 5000L);

    /* loaded from: classes.dex */
    public static final class zza<V> {

        /* renamed from: a, reason: collision with root package name */
        private final V f2059a;
        private final zzlr<V> b;
        private V c;

        private zza(zzlr<V> zzlrVar, V v) {
            zzx.a(zzlrVar);
            this.b = zzlrVar;
            this.f2059a = v;
        }

        static zza<Integer> a(String str, int i) {
            return a(str, i, i);
        }

        static zza<Integer> a(String str, int i, int i2) {
            return new zza<>(zzlr.zza(str, Integer.valueOf(i2)), Integer.valueOf(i));
        }

        static zza<Long> a(String str, long j) {
            return a(str, j, j);
        }

        static zza<Long> a(String str, long j, long j2) {
            return new zza<>(zzlr.zza(str, Long.valueOf(j2)), Long.valueOf(j));
        }

        static zza<String> a(String str, String str2) {
            return a(str, str2, str2);
        }

        static zza<String> a(String str, String str2, String str3) {
            return new zza<>(zzlr.zzu(str, str3), str2);
        }

        static zza<Boolean> a(String str, boolean z) {
            return a(str, z, z);
        }

        static zza<Boolean> a(String str, boolean z, boolean z2) {
            return new zza<>(zzlr.zzg(str, z2), Boolean.valueOf(z));
        }

        public V a() {
            return this.c != null ? this.c : (zzd.f1003a && zzlr.isInitialized()) ? this.b.zzop() : this.f2059a;
        }
    }
}
