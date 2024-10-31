package com.google.firebase.dynamiclinks;

import android.os.Bundle;
import com.google.firebase.FirebaseApp;

/* loaded from: classes2.dex */
public final class DynamicLink {

    /* loaded from: classes2.dex */
    public static final class AndroidParameters {

        /* loaded from: classes2.dex */
        public static final class Builder {

            /* renamed from: a, reason: collision with root package name */
            private final Bundle f17268a;

            public Builder() {
                if (FirebaseApp.c() != null) {
                    this.f17268a = new Bundle();
                    this.f17268a.putString("apn", FirebaseApp.c().b().getPackageName());
                    return;
                }
                throw new IllegalStateException("FirebaseApp not initialized.");
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class Builder {
    }

    /* loaded from: classes2.dex */
    public static final class GoogleAnalyticsParameters {

        /* loaded from: classes2.dex */
        public static final class Builder {

            /* renamed from: a, reason: collision with root package name */
            private final Bundle f17269a = new Bundle();
        }
    }

    /* loaded from: classes2.dex */
    public static final class IosParameters {

        /* loaded from: classes2.dex */
        public static final class Builder {
        }
    }

    /* loaded from: classes2.dex */
    public static final class ItunesConnectAnalyticsParameters {

        /* loaded from: classes2.dex */
        public static final class Builder {

            /* renamed from: a, reason: collision with root package name */
            private final Bundle f17270a = new Bundle();
        }
    }

    /* loaded from: classes2.dex */
    public static final class NavigationInfoParameters {

        /* loaded from: classes2.dex */
        public static final class Builder {

            /* renamed from: a, reason: collision with root package name */
            private final Bundle f17271a = new Bundle();
        }
    }

    /* loaded from: classes2.dex */
    public static final class SocialMetaTagParameters {

        /* loaded from: classes2.dex */
        public static final class Builder {

            /* renamed from: a, reason: collision with root package name */
            private final Bundle f17272a = new Bundle();
        }
    }
}
