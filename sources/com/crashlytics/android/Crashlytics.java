package com.crashlytics.android;

import com.crashlytics.android.answers.Answers;
import com.crashlytics.android.beta.Beta;
import com.crashlytics.android.core.CrashlyticsCore;
import com.crashlytics.android.core.CrashlyticsListener;
import com.crashlytics.android.core.PinningInfoProvider;
import io.fabric.sdk.android.f;
import io.fabric.sdk.android.l;
import io.fabric.sdk.android.m;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/* loaded from: classes.dex */
public class Crashlytics extends l<Void> implements m {
    public static final String TAG = "Crashlytics";
    public final Answers answers;
    public final Beta beta;
    public final CrashlyticsCore core;
    public final Collection<? extends l> kits;

    /* loaded from: classes.dex */
    public static class Builder {
        private Answers answers;
        private Beta beta;
        private CrashlyticsCore core;
        private CrashlyticsCore.Builder coreBuilder;

        private synchronized CrashlyticsCore.Builder getCoreBuilder() {
            if (this.coreBuilder == null) {
                this.coreBuilder = new CrashlyticsCore.Builder();
            }
            return this.coreBuilder;
        }

        public Builder answers(Answers answers) {
            if (answers != null) {
                if (this.answers == null) {
                    this.answers = answers;
                    return this;
                }
                throw new IllegalStateException("Answers Kit already set.");
            }
            throw new NullPointerException("Answers Kit must not be null.");
        }

        public Builder beta(Beta beta) {
            if (beta != null) {
                if (this.beta == null) {
                    this.beta = beta;
                    return this;
                }
                throw new IllegalStateException("Beta Kit already set.");
            }
            throw new NullPointerException("Beta Kit must not be null.");
        }

        public Crashlytics build() {
            CrashlyticsCore.Builder builder = this.coreBuilder;
            if (builder != null) {
                if (this.core == null) {
                    this.core = builder.build();
                } else {
                    throw new IllegalStateException("Must not use Deprecated methods delay(), disabled(), listener(), pinningInfoProvider() with core()");
                }
            }
            if (this.answers == null) {
                this.answers = new Answers();
            }
            if (this.beta == null) {
                this.beta = new Beta();
            }
            if (this.core == null) {
                this.core = new CrashlyticsCore();
            }
            return new Crashlytics(this.answers, this.beta, this.core);
        }

        public Builder core(CrashlyticsCore crashlyticsCore) {
            if (crashlyticsCore != null) {
                if (this.core == null) {
                    this.core = crashlyticsCore;
                    return this;
                }
                throw new IllegalStateException("CrashlyticsCore Kit already set.");
            }
            throw new NullPointerException("CrashlyticsCore Kit must not be null.");
        }

        @Deprecated
        public Builder delay(float f2) {
            getCoreBuilder().delay(f2);
            return this;
        }

        @Deprecated
        public Builder disabled(boolean z) {
            getCoreBuilder().disabled(z);
            return this;
        }

        @Deprecated
        public Builder listener(CrashlyticsListener crashlyticsListener) {
            getCoreBuilder().listener(crashlyticsListener);
            return this;
        }

        @Deprecated
        public Builder pinningInfo(PinningInfoProvider pinningInfoProvider) {
            getCoreBuilder().pinningInfo(pinningInfoProvider);
            return this;
        }
    }

    public Crashlytics() {
        this(new Answers(), new Beta(), new CrashlyticsCore());
    }

    private static void checkInitialized() {
        if (getInstance() == null) {
            throw new IllegalStateException("Crashlytics must be initialized by calling Fabric.with(Context) prior to calling Crashlytics.getInstance()");
        }
    }

    public static Crashlytics getInstance() {
        return (Crashlytics) f.a(Crashlytics.class);
    }

    public static PinningInfoProvider getPinningInfoProvider() {
        checkInitialized();
        return getInstance().core.getPinningInfoProvider();
    }

    public static void log(String str) {
        checkInitialized();
        getInstance().core.log(str);
    }

    public static void logException(Throwable th) {
        checkInitialized();
        getInstance().core.logException(th);
    }

    public static void setBool(String str, boolean z) {
        checkInitialized();
        getInstance().core.setBool(str, z);
    }

    public static void setDouble(String str, double d2) {
        checkInitialized();
        getInstance().core.setDouble(str, d2);
    }

    public static void setFloat(String str, float f2) {
        checkInitialized();
        getInstance().core.setFloat(str, f2);
    }

    public static void setInt(String str, int i) {
        checkInitialized();
        getInstance().core.setInt(str, i);
    }

    public static void setLong(String str, long j) {
        checkInitialized();
        getInstance().core.setLong(str, j);
    }

    @Deprecated
    public static void setPinningInfoProvider(PinningInfoProvider pinningInfoProvider) {
        f.f().b(TAG, "Use of Crashlytics.setPinningInfoProvider is deprecated");
    }

    public static void setString(String str, String str2) {
        checkInitialized();
        getInstance().core.setString(str, str2);
    }

    public static void setUserEmail(String str) {
        checkInitialized();
        getInstance().core.setUserEmail(str);
    }

    public static void setUserIdentifier(String str) {
        checkInitialized();
        getInstance().core.setUserIdentifier(str);
    }

    public static void setUserName(String str) {
        checkInitialized();
        getInstance().core.setUserName(str);
    }

    public void crash() {
        this.core.crash();
    }

    @Override // io.fabric.sdk.android.l
    public Void doInBackground() {
        return null;
    }

    @Deprecated
    public boolean getDebugMode() {
        f.f().b(TAG, "Use of Crashlytics.getDebugMode is deprecated.");
        getFabric();
        return f.h();
    }

    @Override // io.fabric.sdk.android.l
    public String getIdentifier() {
        return "com.crashlytics.sdk.android:crashlytics";
    }

    @Override // io.fabric.sdk.android.m
    public Collection<? extends l> getKits() {
        return this.kits;
    }

    @Override // io.fabric.sdk.android.l
    public String getVersion() {
        return "2.9.1.23";
    }

    @Deprecated
    public void setDebugMode(boolean z) {
        f.f().b(TAG, "Use of Crashlytics.setDebugMode is deprecated.");
    }

    @Deprecated
    public synchronized void setListener(CrashlyticsListener crashlyticsListener) {
        this.core.setListener(crashlyticsListener);
    }

    public boolean verifyPinning(URL url) {
        return this.core.verifyPinning(url);
    }

    Crashlytics(Answers answers, Beta beta, CrashlyticsCore crashlyticsCore) {
        this.answers = answers;
        this.beta = beta;
        this.core = crashlyticsCore;
        this.kits = Collections.unmodifiableCollection(Arrays.asList(answers, beta, crashlyticsCore));
    }

    public static void log(int i, String str, String str2) {
        checkInitialized();
        getInstance().core.log(i, str, str2);
    }
}
