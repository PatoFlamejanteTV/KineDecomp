package com.crashlytics.android.answers;

import android.content.Context;
import com.crashlytics.android.answers.SessionEvent;
import io.fabric.sdk.android.a.b.g;
import io.fabric.sdk.android.a.b.j;
import io.fabric.sdk.android.l;
import io.fabric.sdk.android.o;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.i;
import io.fabric.sdk.android.services.network.f;
import io.fabric.sdk.android.services.settings.b;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
class EnabledSessionAnalyticsManagerStrategy implements SessionAnalyticsManagerStrategy {
    static final int UNDEFINED_ROLLOVER_INTERVAL_SECONDS = -1;
    private final Context context;
    private final ScheduledExecutorService executorService;
    private final SessionAnalyticsFilesManager filesManager;
    g filesSender;
    private final FirebaseAnalyticsApiAdapter firebaseAnalyticsApiAdapter;
    private final f httpRequestFactory;
    private final l kit;
    final SessionEventMetadata metadata;
    private final AtomicReference<ScheduledFuture<?>> rolloverFutureRef = new AtomicReference<>();
    i apiKey = new i();
    EventFilter eventFilter = new KeepAllEventFilter();
    boolean customEventsEnabled = true;
    boolean predefinedEventsEnabled = true;
    volatile int rolloverIntervalSeconds = -1;
    boolean forwardToFirebaseAnalyticsEnabled = false;
    boolean includePurchaseEventsInForwardedEvents = false;

    public EnabledSessionAnalyticsManagerStrategy(l lVar, Context context, ScheduledExecutorService scheduledExecutorService, SessionAnalyticsFilesManager sessionAnalyticsFilesManager, f fVar, SessionEventMetadata sessionEventMetadata, FirebaseAnalyticsApiAdapter firebaseAnalyticsApiAdapter) {
        this.kit = lVar;
        this.context = context;
        this.executorService = scheduledExecutorService;
        this.filesManager = sessionAnalyticsFilesManager;
        this.httpRequestFactory = fVar;
        this.metadata = sessionEventMetadata;
        this.firebaseAnalyticsApiAdapter = firebaseAnalyticsApiAdapter;
    }

    @Override // io.fabric.sdk.android.a.b.f
    public void cancelTimeBasedFileRollOver() {
        if (this.rolloverFutureRef.get() != null) {
            CommonUtils.c(this.context, "Cancelling time-based rollover because no events are currently being generated.");
            this.rolloverFutureRef.get().cancel(false);
            this.rolloverFutureRef.set(null);
        }
    }

    @Override // com.crashlytics.android.answers.SessionAnalyticsManagerStrategy
    public void deleteAllEvents() {
        this.filesManager.deleteAllEventsFiles();
    }

    @Override // com.crashlytics.android.answers.SessionAnalyticsManagerStrategy
    public void processEvent(SessionEvent.Builder builder) {
        SessionEvent build = builder.build(this.metadata);
        if (!this.customEventsEnabled && SessionEvent.Type.CUSTOM.equals(build.type)) {
            io.fabric.sdk.android.f.f().d(Answers.TAG, "Custom events tracking disabled - skipping event: " + build);
            return;
        }
        if (!this.predefinedEventsEnabled && SessionEvent.Type.PREDEFINED.equals(build.type)) {
            io.fabric.sdk.android.f.f().d(Answers.TAG, "Predefined events tracking disabled - skipping event: " + build);
            return;
        }
        if (this.eventFilter.skipEvent(build)) {
            io.fabric.sdk.android.f.f().d(Answers.TAG, "Skipping filtered event: " + build);
            return;
        }
        try {
            this.filesManager.writeEvent(build);
        } catch (IOException e2) {
            io.fabric.sdk.android.f.f().c(Answers.TAG, "Failed to write event: " + build, e2);
        }
        scheduleTimeBasedRollOverIfNeeded();
        boolean z = SessionEvent.Type.CUSTOM.equals(build.type) || SessionEvent.Type.PREDEFINED.equals(build.type);
        boolean equals = "purchase".equals(build.predefinedType);
        if (this.forwardToFirebaseAnalyticsEnabled && z) {
            if (!equals || this.includePurchaseEventsInForwardedEvents) {
                try {
                    this.firebaseAnalyticsApiAdapter.processEvent(build);
                } catch (Exception e3) {
                    io.fabric.sdk.android.f.f().c(Answers.TAG, "Failed to map event to Firebase: " + build, e3);
                }
            }
        }
    }

    @Override // io.fabric.sdk.android.a.b.f
    public boolean rollFileOver() {
        try {
            return this.filesManager.rollFileOver();
        } catch (IOException e2) {
            CommonUtils.a(this.context, "Failed to roll file over.", e2);
            return false;
        }
    }

    void scheduleTimeBasedFileRollOver(long j, long j2) {
        if (this.rolloverFutureRef.get() == null) {
            j jVar = new j(this.context, this);
            CommonUtils.c(this.context, "Scheduling time based file roll over every " + j2 + " seconds");
            try {
                this.rolloverFutureRef.set(this.executorService.scheduleAtFixedRate(jVar, j, j2, TimeUnit.SECONDS));
            } catch (RejectedExecutionException e2) {
                CommonUtils.a(this.context, "Failed to schedule time based file roll over", e2);
            }
        }
    }

    public void scheduleTimeBasedRollOverIfNeeded() {
        if (this.rolloverIntervalSeconds != -1) {
            scheduleTimeBasedFileRollOver(this.rolloverIntervalSeconds, this.rolloverIntervalSeconds);
        }
    }

    @Override // com.crashlytics.android.answers.SessionAnalyticsManagerStrategy
    public void sendEvents() {
        if (this.filesSender == null) {
            CommonUtils.c(this.context, "skipping files send because we don't yet know the target endpoint");
            return;
        }
        CommonUtils.c(this.context, "Sending all files");
        List<File> batchOfFilesToSend = this.filesManager.getBatchOfFilesToSend();
        int i = 0;
        while (batchOfFilesToSend.size() > 0) {
            try {
                CommonUtils.c(this.context, String.format(Locale.US, "attempt to send batch of %d files", Integer.valueOf(batchOfFilesToSend.size())));
                boolean send = this.filesSender.send(batchOfFilesToSend);
                if (send) {
                    i += batchOfFilesToSend.size();
                    this.filesManager.deleteSentFiles(batchOfFilesToSend);
                }
                if (!send) {
                    break;
                } else {
                    batchOfFilesToSend = this.filesManager.getBatchOfFilesToSend();
                }
            } catch (Exception e2) {
                CommonUtils.a(this.context, "Failed to send batch of analytics files to server: " + e2.getMessage(), e2);
            }
        }
        if (i == 0) {
            this.filesManager.deleteOldestInRollOverIfOverMax();
        }
    }

    @Override // com.crashlytics.android.answers.SessionAnalyticsManagerStrategy
    public void setAnalyticsSettingsData(b bVar, String str) {
        this.filesSender = AnswersRetryFilesSender.build(new SessionAnalyticsFilesSender(this.kit, str, bVar.f26991a, this.httpRequestFactory, this.apiKey.d(this.context)));
        this.filesManager.setAnalyticsSettingsData(bVar);
        this.forwardToFirebaseAnalyticsEnabled = bVar.f26996f;
        this.includePurchaseEventsInForwardedEvents = bVar.f26997g;
        o f2 = io.fabric.sdk.android.f.f();
        StringBuilder sb = new StringBuilder();
        sb.append("Firebase analytics forwarding ");
        sb.append(this.forwardToFirebaseAnalyticsEnabled ? "enabled" : "disabled");
        f2.d(Answers.TAG, sb.toString());
        o f3 = io.fabric.sdk.android.f.f();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Firebase analytics including purchase events ");
        sb2.append(this.includePurchaseEventsInForwardedEvents ? "enabled" : "disabled");
        f3.d(Answers.TAG, sb2.toString());
        this.customEventsEnabled = bVar.f26998h;
        o f4 = io.fabric.sdk.android.f.f();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Custom event tracking ");
        sb3.append(this.customEventsEnabled ? "enabled" : "disabled");
        f4.d(Answers.TAG, sb3.toString());
        this.predefinedEventsEnabled = bVar.i;
        o f5 = io.fabric.sdk.android.f.f();
        StringBuilder sb4 = new StringBuilder();
        sb4.append("Predefined event tracking ");
        sb4.append(this.predefinedEventsEnabled ? "enabled" : "disabled");
        f5.d(Answers.TAG, sb4.toString());
        if (bVar.k > 1) {
            io.fabric.sdk.android.f.f().d(Answers.TAG, "Event sampling enabled");
            this.eventFilter = new SamplingEventFilter(bVar.k);
        }
        this.rolloverIntervalSeconds = bVar.f26992b;
        scheduleTimeBasedFileRollOver(0L, this.rolloverIntervalSeconds);
    }
}
