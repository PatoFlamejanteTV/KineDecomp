package com.google.android.gms.measurement.api;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.internal.measurement.zzea;
import com.google.android.gms.measurement.internal.zzcx;
import com.google.android.gms.measurement.internal.zzcy;
import java.util.List;
import java.util.Map;

@KeepForSdk
/* loaded from: classes2.dex */
public class AppMeasurementSdk {

    /* renamed from: a */
    private final zzea f13604a;

    @KeepForSdk
    /* loaded from: classes2.dex */
    public static final class ConditionalUserProperty {
        private ConditionalUserProperty() {
        }
    }

    @ShowFirstParty
    @KeepForSdk
    /* loaded from: classes2.dex */
    public interface EventInterceptor extends zzcx {
    }

    @ShowFirstParty
    @KeepForSdk
    /* loaded from: classes2.dex */
    public interface OnEventListener extends zzcy {
    }

    public AppMeasurementSdk(zzea zzeaVar) {
        this.f13604a = zzeaVar;
    }

    @KeepForSdk
    public static AppMeasurementSdk a(Context context, String str, String str2, String str3, Bundle bundle) {
        return zzea.zza(context, str, str2, str3, bundle).zzga();
    }

    @KeepForSdk
    public void b(String str, String str2, Bundle bundle) {
        this.f13604a.logEventInternal(str, str2, bundle);
    }

    @KeepForSdk
    public void c(Bundle bundle) {
        this.f13604a.setConditionalUserProperty(bundle);
    }

    @KeepForSdk
    public String d() {
        return this.f13604a.getCurrentScreenClass();
    }

    @KeepForSdk
    public String e() {
        return this.f13604a.getCurrentScreenName();
    }

    @KeepForSdk
    public String f() {
        return this.f13604a.getGmpAppId();
    }

    @KeepForSdk
    public void b(String str) {
        this.f13604a.endAdUnitExposure(str);
    }

    @KeepForSdk
    public String c() {
        return this.f13604a.zzgc();
    }

    @KeepForSdk
    public void a(String str, String str2, Object obj) {
        this.f13604a.zza(str, str2, obj, true);
    }

    @KeepForSdk
    public Bundle b(Bundle bundle) {
        return this.f13604a.zza(bundle, true);
    }

    @KeepForSdk
    public int c(String str) {
        return this.f13604a.getMaxUserProperties(str);
    }

    @KeepForSdk
    public String b() {
        return this.f13604a.getAppIdOrigin();
    }

    @KeepForSdk
    public Map<String, Object> a(String str, String str2, boolean z) {
        return this.f13604a.getUserProperties(str, str2, z);
    }

    @KeepForSdk
    public void a(String str, String str2, Bundle bundle) {
        this.f13604a.clearConditionalUserProperty(str, str2, bundle);
    }

    @KeepForSdk
    public List<Bundle> a(String str, String str2) {
        return this.f13604a.getConditionalUserProperties(str, str2);
    }

    @KeepForSdk
    public long a() {
        return this.f13604a.generateEventId();
    }

    @KeepForSdk
    public void a(String str) {
        this.f13604a.beginAdUnitExposure(str);
    }

    @KeepForSdk
    public void a(Bundle bundle) {
        this.f13604a.zza(bundle, false);
    }

    @KeepForSdk
    public void a(Activity activity, String str, String str2) {
        this.f13604a.setCurrentScreen(activity, str, str2);
    }
}
