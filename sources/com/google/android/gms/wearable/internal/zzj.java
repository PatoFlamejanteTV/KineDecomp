package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.CapabilityApi;
import com.google.android.gms.wearable.CapabilityInfo;

/* loaded from: classes.dex */
public class zzj implements CapabilityApi {

    /* loaded from: classes.dex */
    public static class zza implements CapabilityApi.AddLocalCapabilityResult, CapabilityApi.RemoveLocalCapabilityResult {

        /* renamed from: a, reason: collision with root package name */
        private final Status f2394a;

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.f2394a;
        }
    }

    /* loaded from: classes.dex */
    public static class zzb implements CapabilityInfo {
    }

    /* loaded from: classes.dex */
    public static class zzc implements CapabilityApi.GetAllCapabilitiesResult {

        /* renamed from: a, reason: collision with root package name */
        private final Status f2395a;

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.f2395a;
        }
    }

    /* loaded from: classes.dex */
    public static class zzd implements CapabilityApi.GetCapabilityResult {

        /* renamed from: a, reason: collision with root package name */
        private final Status f2396a;

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.f2396a;
        }
    }
}
