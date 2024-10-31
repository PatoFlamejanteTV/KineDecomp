package com.google.android.gms.analytics.internal;

import com.facebook.internal.Utility;
import com.google.android.gms.internal.zzlr;

/* loaded from: classes.dex */
public final class zzy {

    /* renamed from: a, reason: collision with root package name */
    public static zza<Boolean> f751a = zza.a("analytics.service_enabled", false);
    public static zza<Boolean> b = zza.a("analytics.service_client_enabled", true);
    public static zza<String> c = zza.a("analytics.log_tag", "GAv4", "GAv4-SVC");
    public static zza<Long> d = zza.a("analytics.max_tokens", 60L);
    public static zza<Float> e = zza.a("analytics.tokens_per_sec", 0.5f);
    public static zza<Integer> f = zza.a("analytics.max_stored_hits", 2000, 20000);
    public static zza<Integer> g = zza.a("analytics.max_stored_hits_per_app", 2000);
    public static zza<Integer> h = zza.a("analytics.max_stored_properties_per_app", 100);
    public static zza<Long> i = zza.a("analytics.local_dispatch_millis", 1800000L, 120000L);
    public static zza<Long> j = zza.a("analytics.initial_local_dispatch_millis", 5000L, 5000L);
    public static zza<Long> k = zza.a("analytics.min_local_dispatch_millis", 120000L);
    public static zza<Long> l = zza.a("analytics.max_local_dispatch_millis", 7200000L);
    public static zza<Long> m = zza.a("analytics.dispatch_alarm_millis", 7200000L);
    public static zza<Long> n = zza.a("analytics.max_dispatch_alarm_millis", 32400000L);
    public static zza<Integer> o = zza.a("analytics.max_hits_per_dispatch", 20);
    public static zza<Integer> p = zza.a("analytics.max_hits_per_batch", 20);
    public static zza<String> q = zza.a("analytics.insecure_host", "http://www.google-analytics.com");
    public static zza<String> r = zza.a("analytics.secure_host", "https://ssl.google-analytics.com");
    public static zza<String> s = zza.a("analytics.simple_endpoint", "/collect");
    public static zza<String> t = zza.a("analytics.batching_endpoint", "/batch");
    public static zza<Integer> u = zza.a("analytics.max_get_length", 2036);
    public static zza<String> v = zza.a("analytics.batching_strategy.k", zzm.BATCH_BY_COUNT.name(), zzm.BATCH_BY_COUNT.name());
    public static zza<String> w = zza.a("analytics.compression_strategy.k", zzo.GZIP.name());
    public static zza<Integer> x = zza.a("analytics.max_hits_per_request.k", 20);
    public static zza<Integer> y = zza.a("analytics.max_hit_length.k", Utility.DEFAULT_STREAM_BUFFER_SIZE);
    public static zza<Integer> z = zza.a("analytics.max_post_length.k", Utility.DEFAULT_STREAM_BUFFER_SIZE);
    public static zza<Integer> A = zza.a("analytics.max_batch_post_length", Utility.DEFAULT_STREAM_BUFFER_SIZE);
    public static zza<String> B = zza.a("analytics.fallback_responses.k", "404,502");
    public static zza<Integer> C = zza.a("analytics.batch_retry_interval.seconds.k", 3600);
    public static zza<Long> D = zza.a("analytics.service_monitor_interval", 86400000L);
    public static zza<Integer> E = zza.a("analytics.http_connection.connect_timeout_millis", 60000);
    public static zza<Integer> F = zza.a("analytics.http_connection.read_timeout_millis", 61000);
    public static zza<Long> G = zza.a("analytics.campaigns.time_limit", 86400000L);
    public static zza<String> H = zza.a("analytics.first_party_experiment_id", "");
    public static zza<Integer> I = zza.a("analytics.first_party_experiment_variant", 0);
    public static zza<Boolean> J = zza.a("analytics.test.disable_receiver", false);
    public static zza<Long> K = zza.a("analytics.service_client.idle_disconnect_millis", 10000L, 10000L);
    public static zza<Long> L = zza.a("analytics.service_client.connect_timeout_millis", 5000L);
    public static zza<Long> M = zza.a("analytics.service_client.second_connect_delay_millis", 5000L);
    public static zza<Long> N = zza.a("analytics.service_client.unexpected_reconnect_millis", 60000L);
    public static zza<Long> O = zza.a("analytics.service_client.reconnect_throttle_millis", 1800000L);
    public static zza<Long> P = zza.a("analytics.monitoring.sample_period_millis", 86400000L);
    public static zza<Long> Q = zza.a("analytics.initialization_warning_threshold", 5000L);

    /* loaded from: classes.dex */
    public static final class zza<V> {

        /* renamed from: a, reason: collision with root package name */
        private final V f752a;
        private final zzlr<V> b;
        private V c;

        private zza(zzlr<V> zzlrVar, V v) {
            com.google.android.gms.common.internal.zzx.a(zzlrVar);
            this.b = zzlrVar;
            this.f752a = v;
        }

        static zza<Float> a(String str, float f) {
            return a(str, f, f);
        }

        static zza<Float> a(String str, float f, float f2) {
            return new zza<>(zzlr.zza(str, Float.valueOf(f2)), Float.valueOf(f));
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
            return this.c != null ? this.c : (com.google.android.gms.common.internal.zzd.f1003a && zzlr.isInitialized()) ? this.b.zzop() : this.f752a;
        }
    }
}
