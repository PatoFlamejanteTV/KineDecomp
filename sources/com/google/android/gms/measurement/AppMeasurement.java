package com.google.android.gms.measurement;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Keep;
import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.measurement.internal.zzan;
import com.google.android.gms.measurement.internal.zzbw;
import com.google.android.gms.measurement.internal.zzcu;
import com.google.android.gms.measurement.internal.zzcv;
import com.google.android.gms.measurement.internal.zzcw;
import com.google.android.gms.measurement.internal.zzcx;
import com.google.android.gms.measurement.internal.zzcy;
import com.google.android.gms.measurement.internal.zzdw;
import com.google.android.gms.measurement.internal.zzfv;
import java.util.List;
import java.util.Map;

@ShowFirstParty
@Deprecated
/* loaded from: classes2.dex */
public class AppMeasurement {

    /* renamed from: a */
    private final zzbw f13599a;

    @ShowFirstParty
    @KeepForSdk
    /* loaded from: classes2.dex */
    public static class ConditionalUserProperty {

        @Keep
        @ShowFirstParty
        @KeepForSdk
        public boolean mActive;

        @Keep
        @ShowFirstParty
        @KeepForSdk
        public String mAppId;

        @Keep
        @ShowFirstParty
        @KeepForSdk
        public long mCreationTimestamp;

        @Keep
        public String mExpiredEventName;

        @Keep
        public Bundle mExpiredEventParams;

        @Keep
        @ShowFirstParty
        @KeepForSdk
        public String mName;

        @Keep
        @ShowFirstParty
        @KeepForSdk
        public String mOrigin;

        @Keep
        @ShowFirstParty
        @KeepForSdk
        public long mTimeToLive;

        @Keep
        public String mTimedOutEventName;

        @Keep
        public Bundle mTimedOutEventParams;

        @Keep
        @ShowFirstParty
        @KeepForSdk
        public String mTriggerEventName;

        @Keep
        @ShowFirstParty
        @KeepForSdk
        public long mTriggerTimeout;

        @Keep
        public String mTriggeredEventName;

        @Keep
        public Bundle mTriggeredEventParams;

        @Keep
        @ShowFirstParty
        @KeepForSdk
        public long mTriggeredTimestamp;

        @Keep
        @ShowFirstParty
        @KeepForSdk
        public Object mValue;

        public ConditionalUserProperty() {
        }

        public ConditionalUserProperty(ConditionalUserProperty conditionalUserProperty) {
            Preconditions.a(conditionalUserProperty);
            this.mAppId = conditionalUserProperty.mAppId;
            this.mOrigin = conditionalUserProperty.mOrigin;
            this.mCreationTimestamp = conditionalUserProperty.mCreationTimestamp;
            this.mName = conditionalUserProperty.mName;
            Object obj = conditionalUserProperty.mValue;
            if (obj != null) {
                this.mValue = zzdw.a(obj);
                if (this.mValue == null) {
                    this.mValue = conditionalUserProperty.mValue;
                }
            }
            this.mActive = conditionalUserProperty.mActive;
            this.mTriggerEventName = conditionalUserProperty.mTriggerEventName;
            this.mTriggerTimeout = conditionalUserProperty.mTriggerTimeout;
            this.mTimedOutEventName = conditionalUserProperty.mTimedOutEventName;
            Bundle bundle = conditionalUserProperty.mTimedOutEventParams;
            if (bundle != null) {
                this.mTimedOutEventParams = new Bundle(bundle);
            }
            this.mTriggeredEventName = conditionalUserProperty.mTriggeredEventName;
            Bundle bundle2 = conditionalUserProperty.mTriggeredEventParams;
            if (bundle2 != null) {
                this.mTriggeredEventParams = new Bundle(bundle2);
            }
            this.mTriggeredTimestamp = conditionalUserProperty.mTriggeredTimestamp;
            this.mTimeToLive = conditionalUserProperty.mTimeToLive;
            this.mExpiredEventName = conditionalUserProperty.mExpiredEventName;
            Bundle bundle3 = conditionalUserProperty.mExpiredEventParams;
            if (bundle3 != null) {
                this.mExpiredEventParams = new Bundle(bundle3);
            }
        }
    }

    @ShowFirstParty
    @KeepForSdk
    /* loaded from: classes2.dex */
    public static final class Event extends zzcu {
        private Event() {
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

    @ShowFirstParty
    @KeepForSdk
    /* loaded from: classes2.dex */
    public static final class Param extends zzcv {
        private Param() {
        }
    }

    @ShowFirstParty
    @KeepForSdk
    /* loaded from: classes2.dex */
    public static final class UserProperty extends zzcw {
        private UserProperty() {
        }
    }

    public AppMeasurement(zzbw zzbwVar) {
        Preconditions.a(zzbwVar);
        this.f13599a = zzbwVar;
    }

    @Keep
    @ShowFirstParty
    @Deprecated
    public static AppMeasurement getInstance(Context context) {
        return zzbw.a(context, (zzan) null).v();
    }

    @ShowFirstParty
    public final void a(String str, Bundle bundle) {
        this.f13599a.h().a("app", str, bundle, true);
    }

    @KeepForSdk
    @Deprecated
    public void b(boolean z) {
        this.f13599a.h().a(z);
    }

    @Keep
    public void beginAdUnitExposure(String str) {
        this.f13599a.g().a(str, this.f13599a.a().c());
    }

    public final void c(boolean z) {
        this.f13599a.h().b(z);
    }

    @Keep
    @ShowFirstParty
    @KeepForSdk
    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        this.f13599a.h().a(str, str2, bundle);
    }

    @Keep
    @VisibleForTesting
    protected void clearConditionalUserPropertyAs(String str, String str2, String str3, Bundle bundle) {
        this.f13599a.h().a(str, str2, str3, bundle);
    }

    @Keep
    public void endAdUnitExposure(String str) {
        this.f13599a.g().b(str, this.f13599a.a().c());
    }

    @Keep
    public long generateEventId() {
        return this.f13599a.p().r();
    }

    @Keep
    public String getAppInstanceId() {
        return this.f13599a.h().B();
    }

    @Keep
    @ShowFirstParty
    @KeepForSdk
    public List<ConditionalUserProperty> getConditionalUserProperties(String str, String str2) {
        return this.f13599a.h().b(str, str2);
    }

    @Keep
    @VisibleForTesting
    protected List<ConditionalUserProperty> getConditionalUserPropertiesAs(String str, String str2, String str3) {
        return this.f13599a.h().a(str, str2, str3);
    }

    @Keep
    public String getCurrentScreenClass() {
        return this.f13599a.h().y();
    }

    @Keep
    public String getCurrentScreenName() {
        return this.f13599a.h().z();
    }

    @Keep
    public String getGmpAppId() {
        return this.f13599a.h().A();
    }

    @Keep
    @ShowFirstParty
    @KeepForSdk
    public int getMaxUserProperties(String str) {
        this.f13599a.h();
        Preconditions.b(str);
        return 25;
    }

    @Keep
    @VisibleForTesting
    protected Map<String, Object> getUserProperties(String str, String str2, boolean z) {
        return this.f13599a.h().a(str, str2, z);
    }

    @Keep
    @VisibleForTesting
    protected Map<String, Object> getUserPropertiesAs(String str, String str2, String str3, boolean z) {
        return this.f13599a.h().a(str, str2, str3, z);
    }

    @Keep
    @ShowFirstParty
    public void logEventInternal(String str, String str2, Bundle bundle) {
        this.f13599a.h().b(str, str2, bundle);
    }

    @Keep
    @ShowFirstParty
    @KeepForSdk
    public void setConditionalUserProperty(ConditionalUserProperty conditionalUserProperty) {
        this.f13599a.h().a(conditionalUserProperty);
    }

    @Keep
    @VisibleForTesting
    protected void setConditionalUserPropertyAs(ConditionalUserProperty conditionalUserProperty) {
        this.f13599a.h().b(conditionalUserProperty);
    }

    @ShowFirstParty
    public final void a(String str, String str2) {
        this.f13599a.h().a("app", str, (Object) str2, false);
    }

    @ShowFirstParty
    @KeepForSdk
    public void a(String str, String str2, Object obj) {
        Preconditions.b(str);
        this.f13599a.h().a(str, str2, obj, true);
    }

    @ShowFirstParty
    @KeepForSdk
    public Map<String, Object> a(boolean z) {
        List<zzfv> c2 = this.f13599a.h().c(z);
        ArrayMap arrayMap = new ArrayMap(c2.size());
        for (zzfv zzfvVar : c2) {
            arrayMap.put(zzfvVar.f14052b, zzfvVar.getValue());
        }
        return arrayMap;
    }

    @ShowFirstParty
    @KeepForSdk
    public void a(OnEventListener onEventListener) {
        this.f13599a.h().a(onEventListener);
    }
}
