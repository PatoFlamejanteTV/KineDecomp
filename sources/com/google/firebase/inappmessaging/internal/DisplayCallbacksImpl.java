package com.google.firebase.inappmessaging.internal;

import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks;
import com.google.firebase.inappmessaging.internal.vendored.Clock;
import com.google.firebase.inappmessaging.model.InAppMessage;
import com.google.firebase.inappmessaging.model.RateLimit;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.CampaignImpression;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public class DisplayCallbacksImpl implements FirebaseInAppMessagingDisplayCallbacks {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f17749a;

    /* renamed from: b, reason: collision with root package name */
    private final ImpressionStorageClient f17750b;

    /* renamed from: c, reason: collision with root package name */
    private final Clock f17751c;

    /* renamed from: d, reason: collision with root package name */
    private final Schedulers f17752d;

    /* renamed from: e, reason: collision with root package name */
    private final RateLimiterClient f17753e;

    /* renamed from: f, reason: collision with root package name */
    private final CampaignCacheClient f17754f;

    /* renamed from: g, reason: collision with root package name */
    private final RateLimit f17755g;

    /* renamed from: h, reason: collision with root package name */
    private final MetricsLoggerClient f17756h;
    private final DataCollectionHelper i;
    private final InAppMessage j;
    private final String k;

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public DisplayCallbacksImpl(ImpressionStorageClient impressionStorageClient, Clock clock, Schedulers schedulers, RateLimiterClient rateLimiterClient, CampaignCacheClient campaignCacheClient, RateLimit rateLimit, MetricsLoggerClient metricsLoggerClient, DataCollectionHelper dataCollectionHelper, InAppMessage inAppMessage, String str) {
        this.f17750b = impressionStorageClient;
        this.f17751c = clock;
        this.f17752d = schedulers;
        this.f17753e = rateLimiterClient;
        this.f17754f = campaignCacheClient;
        this.f17755g = rateLimit;
        this.f17756h = metricsLoggerClient;
        this.i = dataCollectionHelper;
        this.j = inAppMessage;
        this.k = str;
        f17749a = false;
    }

    private io.reactivex.a f() {
        Logging.a("Attempting to record: message impression in impression store");
        io.reactivex.a a2 = this.f17750b.a(CampaignImpression.o().a(this.f17751c.now()).a(this.j.getCampaignId()).build()).a(C1635o.a()).a(C1636p.a());
        return InAppMessageStreamManager.a(this.k) ? this.f17753e.a(this.f17755g).a(C1637q.a()).a(r.a()).b().a(a2) : a2;
    }

    private boolean g() {
        return this.i.a() && !this.j.getIsTestMessage().booleanValue();
    }

    private io.reactivex.a h() {
        return io.reactivex.a.b(C1631k.a());
    }

    @Override // com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks
    public Task<Void> b() {
        if (g() && !f17749a) {
            Logging.a("Attempting to record: message impression to metrics logger");
            return a(f().a(io.reactivex.a.b(C1630j.a(this))).a(h()).d(), this.f17752d.a());
        }
        a("message impression to metrics logger");
        return new TaskCompletionSource().a();
    }

    @Override // com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks
    public Task<Void> a(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType inAppMessagingDismissType) {
        if (g()) {
            Logging.a("Attempting to record: message dismissal to metrics logger");
            return a(io.reactivex.a.b(C1632l.a(this, inAppMessagingDismissType)));
        }
        a("message dismissal to metrics logger");
        return new TaskCompletionSource().a();
    }

    @Override // com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks
    public Task<Void> a() {
        if (g()) {
            Logging.a("Attempting to record: message click to metrics logger");
            return a(io.reactivex.a.b(C1633m.a(this)));
        }
        a("message click to metrics logger");
        return new TaskCompletionSource().a();
    }

    @Override // com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks
    public Task<Void> a(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason inAppMessagingErrorReason) {
        if (g()) {
            Logging.a("Attempting to record: render error to metrics logger");
            return a(f().a(io.reactivex.a.b(C1634n.a(this, inAppMessagingErrorReason))).a(h()).d(), this.f17752d.a());
        }
        a("render error to metrics logger");
        return new TaskCompletionSource().a();
    }

    private Task<Void> a(io.reactivex.a aVar) {
        if (!f17749a) {
            b();
        }
        return a(aVar.d(), this.f17752d.a());
    }

    private void a(String str, io.reactivex.i<String> iVar) {
        if (iVar != null) {
            Logging.a(String.format("Not recording: %s. Reason: %s", str, iVar));
            return;
        }
        if (this.j.getIsTestMessage().booleanValue()) {
            Logging.a(String.format("Not recording: %s. Reason: Message is test message", str));
        } else if (this.i.a()) {
            Logging.a(String.format("Not recording: %s", str));
        } else {
            Logging.a(String.format("Not recording: %s. Reason: Data collection is disabled", str));
        }
    }

    private void a(String str) {
        a(str, (io.reactivex.i<String>) null);
    }

    private static <T> Task<T> a(io.reactivex.i<T> iVar, io.reactivex.r rVar) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        iVar.b((io.reactivex.c.e) C1627g.a(taskCompletionSource)).b((io.reactivex.k) io.reactivex.i.a(CallableC1628h.a(taskCompletionSource))).e(C1629i.a(taskCompletionSource)).a(rVar).d();
        return taskCompletionSource.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object a(TaskCompletionSource taskCompletionSource) throws Exception {
        taskCompletionSource.a((TaskCompletionSource) null);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ io.reactivex.k a(TaskCompletionSource taskCompletionSource, Throwable th) throws Exception {
        if (th instanceof Exception) {
            taskCompletionSource.a((Exception) th);
        } else {
            taskCompletionSource.a((Exception) new RuntimeException(th));
        }
        return io.reactivex.i.b();
    }
}
