package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.support.v7.widget.ActivityChooserView;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public final class Api<O extends ApiOptions> {

    /* renamed from: a */
    private final AbstractClientBuilder<?, O> f10675a;

    /* renamed from: b */
    private final zaa<?, O> f10676b;

    /* renamed from: c */
    private final ClientKey<?> f10677c;

    /* renamed from: d */
    private final zab<?> f10678d;

    /* renamed from: e */
    private final String f10679e;

    @VisibleForTesting
    @KeepForSdk
    /* loaded from: classes.dex */
    public static abstract class AbstractClientBuilder<T extends Client, O> extends BaseClientBuilder<T, O> {
        @KeepForSdk
        public abstract T a(Context context, Looper looper, ClientSettings clientSettings, O o, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener);
    }

    @KeepForSdk
    /* loaded from: classes.dex */
    public interface AnyClient {
    }

    @KeepForSdk
    /* loaded from: classes.dex */
    public static class AnyClientKey<C extends AnyClient> {
    }

    /* loaded from: classes.dex */
    public interface ApiOptions {

        /* loaded from: classes.dex */
        public interface HasAccountOptions extends HasOptions, NotRequiredOptions {
            Account b();
        }

        /* loaded from: classes.dex */
        public interface HasGoogleSignInAccountOptions extends HasOptions {
            GoogleSignInAccount a();
        }

        /* loaded from: classes.dex */
        public interface HasOptions extends ApiOptions {
        }

        /* loaded from: classes.dex */
        public static final class NoOptions implements NotRequiredOptions {
            private NoOptions() {
            }
        }

        /* loaded from: classes.dex */
        public interface NotRequiredOptions extends ApiOptions {
        }

        /* loaded from: classes.dex */
        public interface Optional extends HasOptions, NotRequiredOptions {
        }
    }

    @VisibleForTesting
    @KeepForSdk
    /* loaded from: classes.dex */
    public static abstract class BaseClientBuilder<T extends AnyClient, O> {
        @KeepForSdk
        public int a() {
            return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }

        @KeepForSdk
        public List<Scope> a(O o) {
            return Collections.emptyList();
        }
    }

    @KeepForSdk
    /* loaded from: classes.dex */
    public interface Client extends AnyClient {
        @KeepForSdk
        void connect(BaseGmsClient.ConnectionProgressReportCallbacks connectionProgressReportCallbacks);

        @KeepForSdk
        void disconnect();

        @KeepForSdk
        void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

        @KeepForSdk
        Feature[] getAvailableFeatures();

        @KeepForSdk
        String getEndpointPackageName();

        @KeepForSdk
        int getMinApkVersion();

        @KeepForSdk
        void getRemoteService(IAccountAccessor iAccountAccessor, Set<Scope> set);

        @KeepForSdk
        IBinder getServiceBrokerBinder();

        @KeepForSdk
        Intent getSignInIntent();

        @KeepForSdk
        boolean isConnected();

        @KeepForSdk
        boolean isConnecting();

        @KeepForSdk
        void onUserSignOut(BaseGmsClient.SignOutCallbacks signOutCallbacks);

        @KeepForSdk
        boolean providesSignIn();

        @KeepForSdk
        boolean requiresGooglePlayServices();

        @KeepForSdk
        boolean requiresSignIn();
    }

    @VisibleForTesting
    @KeepForSdk
    /* loaded from: classes.dex */
    public static final class ClientKey<C extends Client> extends AnyClientKey<C> {
    }

    /* loaded from: classes.dex */
    public interface SimpleClient<T extends IInterface> extends AnyClient {
        T a(IBinder iBinder);

        void a(int i, T t);

        String c();

        String d();
    }

    @VisibleForTesting
    /* loaded from: classes.dex */
    public static abstract class zaa<T extends SimpleClient, O> extends BaseClientBuilder<T, O> {
    }

    @VisibleForTesting
    /* loaded from: classes.dex */
    public static final class zab<C extends SimpleClient> extends AnyClientKey<C> {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <C extends Client> Api(String str, AbstractClientBuilder<C, O> abstractClientBuilder, ClientKey<C> clientKey) {
        Preconditions.a(abstractClientBuilder, "Cannot construct an Api with a null ClientBuilder");
        Preconditions.a(clientKey, "Cannot construct an Api with a null ClientKey");
        this.f10679e = str;
        this.f10675a = abstractClientBuilder;
        this.f10676b = null;
        this.f10677c = clientKey;
        this.f10678d = null;
    }

    public final AnyClientKey<?> a() {
        ClientKey<?> clientKey = this.f10677c;
        if (clientKey != null) {
            return clientKey;
        }
        throw new IllegalStateException("This API was constructed with null client keys. This should not be possible.");
    }

    public final String b() {
        return this.f10679e;
    }

    public final BaseClientBuilder<?, O> c() {
        return this.f10675a;
    }

    public final AbstractClientBuilder<?, O> d() {
        Preconditions.b(this.f10675a != null, "This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
        return this.f10675a;
    }
}
