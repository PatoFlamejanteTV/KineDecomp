package com.google.firebase.inappmessaging.internal;

import android.os.Bundle;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.inappmessaging.CampaignAnalytics;
import com.google.firebase.inappmessaging.ClientAppInfo;
import com.google.firebase.inappmessaging.DismissType;
import com.google.firebase.inappmessaging.EventType;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks;
import com.google.firebase.inappmessaging.RenderErrorReason;
import com.google.firebase.inappmessaging.internal.vendored.Clock;
import com.google.firebase.inappmessaging.model.InAppMessage;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public class MetricsLoggerClient {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason, RenderErrorReason> f17799a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private static final Map<FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType, DismissType> f17800b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private final ClearcutLoggerInterface f17801c;

    /* renamed from: d, reason: collision with root package name */
    private final FirebaseApp f17802d;

    /* renamed from: e, reason: collision with root package name */
    private final FirebaseInstanceId f17803e;

    /* renamed from: f, reason: collision with root package name */
    private final Clock f17804f;

    /* renamed from: g, reason: collision with root package name */
    private final AnalyticsConnector f17805g;

    /* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
    /* loaded from: classes2.dex */
    public interface ClearcutLoggerInterface {
        void a(byte[] bArr);
    }

    static {
        f17799a.put(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason.UNSPECIFIED_RENDER_ERROR, RenderErrorReason.UNSPECIFIED_RENDER_ERROR);
        f17799a.put(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason.IMAGE_FETCH_ERROR, RenderErrorReason.IMAGE_FETCH_ERROR);
        f17799a.put(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason.IMAGE_DISPLAY_ERROR, RenderErrorReason.IMAGE_DISPLAY_ERROR);
        f17799a.put(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason.IMAGE_UNSUPPORTED_FORMAT, RenderErrorReason.IMAGE_UNSUPPORTED_FORMAT);
        f17800b.put(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType.AUTO, DismissType.AUTO);
        f17800b.put(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType.CLICK, DismissType.CLICK);
        f17800b.put(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType.SWIPE, DismissType.SWIPE);
        f17800b.put(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType.UNKNOWN_DISMISS_TYPE, DismissType.UNKNOWN_DISMISS_TYPE);
    }

    public MetricsLoggerClient(ClearcutLoggerInterface clearcutLoggerInterface, AnalyticsConnector analyticsConnector, FirebaseApp firebaseApp, FirebaseInstanceId firebaseInstanceId, Clock clock) {
        this.f17801c = clearcutLoggerInterface;
        this.f17805g = analyticsConnector;
        this.f17802d = firebaseApp;
        this.f17803e = firebaseInstanceId;
        this.f17804f = clock;
    }

    private CampaignAnalytics.Builder c(InAppMessage inAppMessage) {
        return CampaignAnalytics.x().b(this.f17802d.e().d()).a(inAppMessage.getCampaignId()).a(a()).a(this.f17804f.now());
    }

    private boolean d(InAppMessage inAppMessage) {
        return (inAppMessage.getAction() == null || inAppMessage.getAction().getActionUrl().isEmpty()) ? false : true;
    }

    private boolean e(InAppMessage inAppMessage) {
        return inAppMessage.getIsTestMessage().booleanValue();
    }

    public void a(InAppMessage inAppMessage) {
        if (e(inAppMessage)) {
            return;
        }
        this.f17801c.a(a(inAppMessage, EventType.IMPRESSION_EVENT_TYPE).toByteArray());
        a(inAppMessage, "firebase_in_app_message_impression", !d(inAppMessage));
    }

    public void b(InAppMessage inAppMessage) {
        if (e(inAppMessage)) {
            return;
        }
        this.f17801c.a(a(inAppMessage, EventType.CLICK_EVENT_TYPE).toByteArray());
        a(inAppMessage, "firebase_in_app_message_action", true);
    }

    public void a(InAppMessage inAppMessage, FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason inAppMessagingErrorReason) {
        if (e(inAppMessage)) {
            return;
        }
        this.f17801c.a(a(inAppMessage, f17799a.get(inAppMessagingErrorReason)).toByteArray());
    }

    public void a(InAppMessage inAppMessage, FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType inAppMessagingDismissType) {
        if (e(inAppMessage)) {
            return;
        }
        this.f17801c.a(a(inAppMessage, f17800b.get(inAppMessagingDismissType)).toByteArray());
        a(inAppMessage, "firebase_in_app_message_dismiss", false);
    }

    private CampaignAnalytics a(InAppMessage inAppMessage, EventType eventType) {
        return c(inAppMessage).a(eventType).build();
    }

    private CampaignAnalytics a(InAppMessage inAppMessage, DismissType dismissType) {
        return c(inAppMessage).a(dismissType).build();
    }

    private CampaignAnalytics a(InAppMessage inAppMessage, RenderErrorReason renderErrorReason) {
        return c(inAppMessage).a(renderErrorReason).build();
    }

    private ClientAppInfo a() {
        return ClientAppInfo.s().b(this.f17802d.e().b()).a(this.f17803e.a()).build();
    }

    private void a(InAppMessage inAppMessage, String str, boolean z) {
        String campaignId = inAppMessage.getCampaignId();
        Bundle a2 = a(inAppMessage.getCampaignName(), campaignId);
        Logging.a("Sending event=" + str + " params=" + a2);
        AnalyticsConnector analyticsConnector = this.f17805g;
        if (analyticsConnector != null) {
            analyticsConnector.logEvent("fiam", str, a2);
            if (z) {
                this.f17805g.a("fiam", "_ln", "fiam:" + campaignId);
                return;
            }
            return;
        }
        Logging.d("Unable to log event: analytics library is missing");
    }

    Bundle a(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("_nmid", str2);
        bundle.putString("_nmn", str);
        try {
            bundle.putInt("_ndt", (int) (this.f17804f.now() / 1000));
        } catch (NumberFormatException e2) {
            Logging.d("Error while parsing use_device_time in FIAM event: " + e2.getMessage());
        }
        return bundle;
    }
}
