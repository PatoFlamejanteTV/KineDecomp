package com.crashlytics.android.core;

import android.content.Context;
import android.util.Log;
import com.crashlytics.android.answers.AppMeasurementEventLogger;
import com.crashlytics.android.answers.EventLogger;
import io.fabric.sdk.android.a.c.b;
import io.fabric.sdk.android.a.c.d;
import io.fabric.sdk.android.l;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.common.i;
import io.fabric.sdk.android.services.common.r;
import io.fabric.sdk.android.services.concurrency.Priority;
import io.fabric.sdk.android.services.concurrency.UnmetDependencyException;
import io.fabric.sdk.android.services.concurrency.h;
import io.fabric.sdk.android.services.concurrency.k;
import io.fabric.sdk.android.services.concurrency.p;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import io.fabric.sdk.android.services.network.c;
import io.fabric.sdk.android.services.network.f;
import io.fabric.sdk.android.services.settings.s;
import io.fabric.sdk.android.services.settings.u;
import java.net.URL;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.net.ssl.HttpsURLConnection;

@h({CrashlyticsNdkDataProvider.class})
/* loaded from: classes.dex */
public class CrashlyticsCore extends l<Void> {
    static final float CLS_DEFAULT_PROCESS_DELAY = 1.0f;
    static final String CRASHLYTICS_REQUIRE_BUILD_ID = "com.crashlytics.RequireBuildId";
    static final boolean CRASHLYTICS_REQUIRE_BUILD_ID_DEFAULT = true;
    static final String CRASH_MARKER_FILE_NAME = "crash_marker";
    static final int DEFAULT_MAIN_HANDLER_TIMEOUT_SEC = 4;
    private static final String INITIALIZATION_MARKER_FILE_NAME = "initialization_marker";
    static final int MAX_ATTRIBUTES = 64;
    static final int MAX_ATTRIBUTE_SIZE = 1024;
    private static final String MISSING_BUILD_ID_MSG = "This app relies on Crashlytics. Please sign up for access at https://fabric.io/sign_up,\ninstall an Android build tool and ask a team member to invite you to this app's organization.";
    private static final String PREFERENCE_STORE_NAME = "com.crashlytics.android.core.CrashlyticsCore";
    public static final String TAG = "CrashlyticsCore";
    private final ConcurrentHashMap<String, String> attributes;
    private CrashlyticsBackgroundWorker backgroundWorker;
    private CrashlyticsController controller;
    private CrashlyticsFileMarker crashMarker;
    private CrashlyticsNdkDataProvider crashlyticsNdkDataProvider;
    private float delay;
    private boolean disabled;
    private f httpRequestFactory;
    private CrashlyticsFileMarker initializationMarker;
    private CrashlyticsListener listener;
    private final PinningInfoProvider pinningInfo;
    private final long startTime;
    private String userEmail;
    private String userId;
    private String userName;

    /* loaded from: classes.dex */
    public static class Builder {
        private float delay = -1.0f;
        private boolean disabled = false;
        private CrashlyticsListener listener;
        private PinningInfoProvider pinningInfoProvider;

        public CrashlyticsCore build() {
            if (this.delay < 0.0f) {
                this.delay = CrashlyticsCore.CLS_DEFAULT_PROCESS_DELAY;
            }
            return new CrashlyticsCore(this.delay, this.listener, this.pinningInfoProvider, this.disabled);
        }

        public Builder delay(float f2) {
            if (f2 <= 0.0f) {
                throw new IllegalArgumentException("delay must be greater than 0");
            }
            if (this.delay <= 0.0f) {
                this.delay = f2;
                return this;
            }
            throw new IllegalStateException("delay already set.");
        }

        public Builder disabled(boolean z) {
            this.disabled = z;
            return this;
        }

        public Builder listener(CrashlyticsListener crashlyticsListener) {
            if (crashlyticsListener != null) {
                if (this.listener == null) {
                    this.listener = crashlyticsListener;
                    return this;
                }
                throw new IllegalStateException("listener already set.");
            }
            throw new IllegalArgumentException("listener must not be null.");
        }

        @Deprecated
        public Builder pinningInfo(PinningInfoProvider pinningInfoProvider) {
            if (pinningInfoProvider != null) {
                if (this.pinningInfoProvider == null) {
                    this.pinningInfoProvider = pinningInfoProvider;
                    return this;
                }
                throw new IllegalStateException("pinningInfoProvider already set.");
            }
            throw new IllegalArgumentException("pinningInfoProvider must not be null.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class CrashMarkerCheck implements Callable<Boolean> {
        private final CrashlyticsFileMarker crashMarker;

        public CrashMarkerCheck(CrashlyticsFileMarker crashlyticsFileMarker) {
            this.crashMarker = crashlyticsFileMarker;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Boolean call() throws Exception {
            if (!this.crashMarker.isPresent()) {
                return Boolean.FALSE;
            }
            io.fabric.sdk.android.f.f().d(CrashlyticsCore.TAG, "Found previous crash marker.");
            this.crashMarker.remove();
            return Boolean.TRUE;
        }
    }

    /* loaded from: classes.dex */
    private static final class NoOpListener implements CrashlyticsListener {
        private NoOpListener() {
        }

        @Override // com.crashlytics.android.core.CrashlyticsListener
        public void crashlyticsDidDetectCrashDuringPreviousExecution() {
        }
    }

    public CrashlyticsCore() {
        this(CLS_DEFAULT_PROCESS_DELAY, null, null, false);
    }

    private void checkForPreviousCrash() {
        if (Boolean.TRUE.equals((Boolean) this.backgroundWorker.submitAndWait(new CrashMarkerCheck(this.crashMarker)))) {
            try {
                this.listener.crashlyticsDidDetectCrashDuringPreviousExecution();
            } catch (Exception e2) {
                io.fabric.sdk.android.f.f().c(TAG, "Exception thrown by CrashlyticsListener while notifying of previous crash.", e2);
            }
        }
    }

    private void doLog(int i, String str, String str2) {
        if (!this.disabled && ensureFabricWithCalled("prior to logging messages.")) {
            this.controller.writeToLog(System.currentTimeMillis() - this.startTime, formatLogMessage(i, str, str2));
        }
    }

    private static boolean ensureFabricWithCalled(String str) {
        CrashlyticsCore crashlyticsCore = getInstance();
        if (crashlyticsCore != null && crashlyticsCore.controller != null) {
            return CRASHLYTICS_REQUIRE_BUILD_ID_DEFAULT;
        }
        io.fabric.sdk.android.f.f().c(TAG, "Crashlytics must be initialized by calling Fabric.with(Context) " + str, null);
        return false;
    }

    private void finishInitSynchronously() {
        k<Void> kVar = new k<Void>() { // from class: com.crashlytics.android.core.CrashlyticsCore.1
            @Override // io.fabric.sdk.android.services.concurrency.n, io.fabric.sdk.android.services.concurrency.m
            public Priority getPriority() {
                return Priority.IMMEDIATE;
            }

            @Override // java.util.concurrent.Callable
            public Void call() throws Exception {
                return CrashlyticsCore.this.doInBackground();
            }
        };
        Iterator<p> it = getDependencies().iterator();
        while (it.hasNext()) {
            kVar.addDependency(it.next());
        }
        Future submit = getFabric().c().submit(kVar);
        io.fabric.sdk.android.f.f().d(TAG, "Crashlytics detected incomplete initialization on previous app launch. Will initialize synchronously.");
        try {
            submit.get(4L, TimeUnit.SECONDS);
        } catch (InterruptedException e2) {
            io.fabric.sdk.android.f.f().c(TAG, "Crashlytics was interrupted during initialization.", e2);
        } catch (ExecutionException e3) {
            io.fabric.sdk.android.f.f().c(TAG, "Problem encountered during Crashlytics initialization.", e3);
        } catch (TimeoutException e4) {
            io.fabric.sdk.android.f.f().c(TAG, "Crashlytics timed out during initialization.", e4);
        }
    }

    private static String formatLogMessage(int i, String str, String str2) {
        return CommonUtils.a(i) + "/" + str + " " + str2;
    }

    public static CrashlyticsCore getInstance() {
        return (CrashlyticsCore) io.fabric.sdk.android.f.a(CrashlyticsCore.class);
    }

    static boolean isBuildIdValid(String str, boolean z) {
        if (!z) {
            io.fabric.sdk.android.f.f().d(TAG, "Configured not to require a build ID.");
            return CRASHLYTICS_REQUIRE_BUILD_ID_DEFAULT;
        }
        if (!CommonUtils.b(str)) {
            return CRASHLYTICS_REQUIRE_BUILD_ID_DEFAULT;
        }
        Log.e(TAG, ".");
        Log.e(TAG, ".     |  | ");
        Log.e(TAG, ".     |  |");
        Log.e(TAG, ".     |  |");
        Log.e(TAG, ".   \\ |  | /");
        Log.e(TAG, ".    \\    /");
        Log.e(TAG, ".     \\  /");
        Log.e(TAG, ".      \\/");
        Log.e(TAG, ".");
        Log.e(TAG, MISSING_BUILD_ID_MSG);
        Log.e(TAG, ".");
        Log.e(TAG, ".      /\\");
        Log.e(TAG, ".     /  \\");
        Log.e(TAG, ".    /    \\");
        Log.e(TAG, ".   / |  | \\");
        Log.e(TAG, ".     |  |");
        Log.e(TAG, ".     |  |");
        Log.e(TAG, ".     |  |");
        Log.e(TAG, ".");
        return false;
    }

    private static String sanitizeAttribute(String str) {
        if (str == null) {
            return str;
        }
        String trim = str.trim();
        return trim.length() > 1024 ? trim.substring(0, 1024) : trim;
    }

    public void crash() {
        new CrashTest().indexOutOfBounds();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void createCrashMarker() {
        this.crashMarker.create();
    }

    boolean didPreviousInitializationFail() {
        return this.initializationMarker.isPresent();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<String, String> getAttributes() {
        return Collections.unmodifiableMap(this.attributes);
    }

    CrashlyticsController getController() {
        return this.controller;
    }

    @Override // io.fabric.sdk.android.l
    public String getIdentifier() {
        return "com.crashlytics.sdk.android.crashlytics-core";
    }

    CrashlyticsNdkData getNativeCrashData() {
        CrashlyticsNdkDataProvider crashlyticsNdkDataProvider = this.crashlyticsNdkDataProvider;
        if (crashlyticsNdkDataProvider != null) {
            return crashlyticsNdkDataProvider.getCrashlyticsNdkData();
        }
        return null;
    }

    public PinningInfoProvider getPinningInfoProvider() {
        if (this.disabled) {
            return null;
        }
        return this.pinningInfo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getUserEmail() {
        if (getIdManager().a()) {
            return this.userEmail;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getUserIdentifier() {
        if (getIdManager().a()) {
            return this.userId;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getUserName() {
        if (getIdManager().a()) {
            return this.userName;
        }
        return null;
    }

    @Override // io.fabric.sdk.android.l
    public String getVersion() {
        return "2.6.1.23";
    }

    boolean internalVerifyPinning(URL url) {
        if (getPinningInfoProvider() == null) {
            return false;
        }
        HttpRequest a2 = this.httpRequestFactory.a(HttpMethod.GET, url.toString());
        ((HttpsURLConnection) a2.j()).setInstanceFollowRedirects(false);
        a2.g();
        return CRASHLYTICS_REQUIRE_BUILD_ID_DEFAULT;
    }

    public void log(String str) {
        doLog(3, TAG, str);
    }

    public void logException(Throwable th) {
        if (!this.disabled && ensureFabricWithCalled("prior to logging exceptions.")) {
            if (th == null) {
                io.fabric.sdk.android.f.f().log(5, TAG, "Crashlytics is ignoring a request to log a null exception.");
            } else {
                this.controller.writeNonFatalException(Thread.currentThread(), th);
            }
        }
    }

    void markInitializationComplete() {
        this.backgroundWorker.submit(new Callable<Boolean>() { // from class: com.crashlytics.android.core.CrashlyticsCore.3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Boolean call() throws Exception {
                try {
                    boolean remove = CrashlyticsCore.this.initializationMarker.remove();
                    io.fabric.sdk.android.f.f().d(CrashlyticsCore.TAG, "Initialization marker file removed: " + remove);
                    return Boolean.valueOf(remove);
                } catch (Exception e2) {
                    io.fabric.sdk.android.f.f().c(CrashlyticsCore.TAG, "Problem encountered deleting Crashlytics initialization marker.", e2);
                    return false;
                }
            }
        });
    }

    void markInitializationStarted() {
        this.backgroundWorker.submitAndWait(new Callable<Void>() { // from class: com.crashlytics.android.core.CrashlyticsCore.2
            @Override // java.util.concurrent.Callable
            public Void call() throws Exception {
                CrashlyticsCore.this.initializationMarker.create();
                io.fabric.sdk.android.f.f().d(CrashlyticsCore.TAG, "Initialization marker file created.");
                return null;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.fabric.sdk.android.l
    public boolean onPreExecute() {
        return onPreExecute(super.getContext());
    }

    public void setBool(String str, boolean z) {
        setString(str, Boolean.toString(z));
    }

    void setCrashlyticsNdkDataProvider(CrashlyticsNdkDataProvider crashlyticsNdkDataProvider) {
        this.crashlyticsNdkDataProvider = crashlyticsNdkDataProvider;
    }

    public void setDouble(String str, double d2) {
        setString(str, Double.toString(d2));
    }

    public void setFloat(String str, float f2) {
        setString(str, Float.toString(f2));
    }

    public void setInt(String str, int i) {
        setString(str, Integer.toString(i));
    }

    @Deprecated
    public synchronized void setListener(CrashlyticsListener crashlyticsListener) {
        io.fabric.sdk.android.f.f().b(TAG, "Use of setListener is deprecated.");
        if (crashlyticsListener != null) {
            this.listener = crashlyticsListener;
        } else {
            throw new IllegalArgumentException("listener must not be null.");
        }
    }

    public void setLong(String str, long j) {
        setString(str, Long.toString(j));
    }

    public void setString(String str, String str2) {
        if (!this.disabled && ensureFabricWithCalled("prior to setting keys.")) {
            if (str == null) {
                Context context = getContext();
                if (context != null && CommonUtils.j(context)) {
                    throw new IllegalArgumentException("Custom attribute key must not be null.");
                }
                io.fabric.sdk.android.f.f().c(TAG, "Attempting to set custom attribute with null key, ignoring.", null);
                return;
            }
            String sanitizeAttribute = sanitizeAttribute(str);
            if (this.attributes.size() >= 64 && !this.attributes.containsKey(sanitizeAttribute)) {
                io.fabric.sdk.android.f.f().d(TAG, "Exceeded maximum number of custom attributes (64)");
            } else {
                this.attributes.put(sanitizeAttribute, str2 == null ? "" : sanitizeAttribute(str2));
                this.controller.cacheKeyData(this.attributes);
            }
        }
    }

    public void setUserEmail(String str) {
        if (!this.disabled && ensureFabricWithCalled("prior to setting user data.")) {
            this.userEmail = sanitizeAttribute(str);
            this.controller.cacheUserData(this.userId, this.userName, this.userEmail);
        }
    }

    public void setUserIdentifier(String str) {
        if (!this.disabled && ensureFabricWithCalled("prior to setting user data.")) {
            this.userId = sanitizeAttribute(str);
            this.controller.cacheUserData(this.userId, this.userName, this.userEmail);
        }
    }

    public void setUserName(String str) {
        if (!this.disabled && ensureFabricWithCalled("prior to setting user data.")) {
            this.userName = sanitizeAttribute(str);
            this.controller.cacheUserData(this.userId, this.userName, this.userEmail);
        }
    }

    public boolean verifyPinning(URL url) {
        try {
            return internalVerifyPinning(url);
        } catch (Exception e2) {
            io.fabric.sdk.android.f.f().c(TAG, "Could not verify SSL pinning", e2);
            return false;
        }
    }

    CrashlyticsCore(float f2, CrashlyticsListener crashlyticsListener, PinningInfoProvider pinningInfoProvider, boolean z) {
        this(f2, crashlyticsListener, pinningInfoProvider, z, r.a("Crashlytics Exception Handler"));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.fabric.sdk.android.l
    public Void doInBackground() {
        u a2;
        markInitializationStarted();
        this.controller.cleanInvalidTempFiles();
        try {
            try {
                this.controller.registerDevicePowerStateListener();
                a2 = s.b().a();
            } catch (Exception e2) {
                io.fabric.sdk.android.f.f().c(TAG, "Crashlytics encountered a problem during asynchronous initialization.", e2);
            }
            if (a2 == null) {
                io.fabric.sdk.android.f.f().b(TAG, "Received null settings, skipping report submission!");
                return null;
            }
            this.controller.registerAnalyticsEventListener(a2);
            if (!a2.f27058d.f27029c) {
                io.fabric.sdk.android.f.f().d(TAG, "Collection of crash reports disabled in Crashlytics settings.");
                return null;
            }
            CrashlyticsNdkData nativeCrashData = getNativeCrashData();
            if (nativeCrashData != null && !this.controller.finalizeNativeReport(nativeCrashData)) {
                io.fabric.sdk.android.f.f().d(TAG, "Could not finalize previous NDK sessions.");
            }
            if (!this.controller.finalizeSessions(a2.f27056b)) {
                io.fabric.sdk.android.f.f().d(TAG, "Could not finalize previous sessions.");
            }
            this.controller.submitAllReports(this.delay, a2);
            return null;
        } finally {
            markInitializationComplete();
        }
    }

    public void log(int i, String str, String str2) {
        doLog(i, str, str2);
        io.fabric.sdk.android.f.f().a(i, "" + str, "" + str2, CRASHLYTICS_REQUIRE_BUILD_ID_DEFAULT);
    }

    boolean onPreExecute(Context context) {
        String d2;
        if (this.disabled || (d2 = new i().d(context)) == null) {
            return false;
        }
        String n = CommonUtils.n(context);
        if (isBuildIdValid(n, CommonUtils.a(context, CRASHLYTICS_REQUIRE_BUILD_ID, CRASHLYTICS_REQUIRE_BUILD_ID_DEFAULT))) {
            try {
                io.fabric.sdk.android.f.f().a(TAG, "Initializing Crashlytics " + getVersion());
                b bVar = new b(this);
                this.crashMarker = new CrashlyticsFileMarker(CRASH_MARKER_FILE_NAME, bVar);
                this.initializationMarker = new CrashlyticsFileMarker(INITIALIZATION_MARKER_FILE_NAME, bVar);
                PreferenceManager create = PreferenceManager.create(new d(getContext(), PREFERENCE_STORE_NAME), this);
                CrashlyticsPinningInfoProvider crashlyticsPinningInfoProvider = this.pinningInfo != null ? new CrashlyticsPinningInfoProvider(this.pinningInfo) : null;
                this.httpRequestFactory = new c(io.fabric.sdk.android.f.f());
                this.httpRequestFactory.a(crashlyticsPinningInfoProvider);
                IdManager idManager = getIdManager();
                AppData create2 = AppData.create(context, idManager, d2, n);
                ManifestUnityVersionProvider manifestUnityVersionProvider = new ManifestUnityVersionProvider(context, create2.packageName);
                AppMeasurementEventListenerRegistrar instanceFrom = DefaultAppMeasurementEventListenerRegistrar.instanceFrom(this);
                EventLogger eventLogger = AppMeasurementEventLogger.getEventLogger(context);
                io.fabric.sdk.android.f.f().d(TAG, "Installer package name is: " + create2.installerPackageName);
                this.controller = new CrashlyticsController(this, this.backgroundWorker, this.httpRequestFactory, idManager, create, bVar, create2, manifestUnityVersionProvider, instanceFrom, eventLogger);
                boolean didPreviousInitializationFail = didPreviousInitializationFail();
                checkForPreviousCrash();
                this.controller.enableExceptionHandling(Thread.getDefaultUncaughtExceptionHandler(), new io.fabric.sdk.android.services.common.s().b(context));
                if (didPreviousInitializationFail && CommonUtils.b(context)) {
                    io.fabric.sdk.android.f.f().d(TAG, "Crashlytics did not finish previous background initialization. Initializing synchronously.");
                    finishInitSynchronously();
                    return false;
                }
                io.fabric.sdk.android.f.f().d(TAG, "Exception handling initialization successful");
                return CRASHLYTICS_REQUIRE_BUILD_ID_DEFAULT;
            } catch (Exception e2) {
                io.fabric.sdk.android.f.f().c(TAG, "Crashlytics was not started due to an exception during initialization", e2);
                this.controller = null;
                return false;
            }
        }
        throw new UnmetDependencyException(MISSING_BUILD_ID_MSG);
    }

    CrashlyticsCore(float f2, CrashlyticsListener crashlyticsListener, PinningInfoProvider pinningInfoProvider, boolean z, ExecutorService executorService) {
        this.userId = null;
        this.userEmail = null;
        this.userName = null;
        this.delay = f2;
        this.listener = crashlyticsListener == null ? new NoOpListener() : crashlyticsListener;
        this.pinningInfo = pinningInfoProvider;
        this.disabled = z;
        this.backgroundWorker = new CrashlyticsBackgroundWorker(executorService);
        this.attributes = new ConcurrentHashMap<>();
        this.startTime = System.currentTimeMillis();
    }
}
