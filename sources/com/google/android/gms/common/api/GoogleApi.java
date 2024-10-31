package com.google.android.gms.common.api;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.api.internal.RegisterListenerMethod;
import com.google.android.gms.common.api.internal.RegistrationMethods;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.api.internal.UnregisterListenerMethod;
import com.google.android.gms.common.api.internal.zaae;
import com.google.android.gms.common.api.internal.zabp;
import com.google.android.gms.common.api.internal.zace;
import com.google.android.gms.common.api.internal.zai;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Collections;
import java.util.Set;

@KeepForSdk
/* loaded from: classes.dex */
public class GoogleApi<O extends Api.ApiOptions> {
    private final Api<O> mApi;
    private final Context mContext;
    private final int mId;
    private final O zabh;
    private final zai<O> zabi;
    private final Looper zabj;
    private final GoogleApiClient zabk;
    private final StatusExceptionMapper zabl;
    protected final GoogleApiManager zabm;

    @KeepForSdk
    /* loaded from: classes.dex */
    public static class Settings {

        /* renamed from: a, reason: collision with root package name */
        @KeepForSdk
        public static final Settings f10684a = new Builder().a();

        /* renamed from: b, reason: collision with root package name */
        public final StatusExceptionMapper f10685b;

        /* renamed from: c, reason: collision with root package name */
        public final Looper f10686c;

        @KeepForSdk
        private Settings(StatusExceptionMapper statusExceptionMapper, Account account, Looper looper) {
            this.f10685b = statusExceptionMapper;
            this.f10686c = looper;
        }

        @KeepForSdk
        /* loaded from: classes.dex */
        public static class Builder {

            /* renamed from: a, reason: collision with root package name */
            private StatusExceptionMapper f10687a;

            /* renamed from: b, reason: collision with root package name */
            private Looper f10688b;

            @KeepForSdk
            public Builder() {
            }

            @KeepForSdk
            public Builder a(StatusExceptionMapper statusExceptionMapper) {
                Preconditions.a(statusExceptionMapper, "StatusExceptionMapper must not be null.");
                this.f10687a = statusExceptionMapper;
                return this;
            }

            @KeepForSdk
            public Builder a(Looper looper) {
                Preconditions.a(looper, "Looper must not be null.");
                this.f10688b = looper;
                return this;
            }

            @KeepForSdk
            public Settings a() {
                if (this.f10687a == null) {
                    this.f10687a = new ApiExceptionMapper();
                }
                if (this.f10688b == null) {
                    this.f10688b = Looper.getMainLooper();
                }
                return new Settings(this.f10687a, this.f10688b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @KeepForSdk
    public GoogleApi(Context context, Api<O> api, Looper looper) {
        Preconditions.a(context, "Null context is not permitted.");
        Preconditions.a(api, "Api must not be null.");
        Preconditions.a(looper, "Looper must not be null.");
        this.mContext = context.getApplicationContext();
        this.mApi = api;
        this.zabh = null;
        this.zabj = looper;
        this.zabi = zai.a(api);
        this.zabk = new zabp(this);
        this.zabm = GoogleApiManager.a(this.mContext);
        this.mId = this.zabm.d();
        this.zabl = new ApiExceptionMapper();
    }

    private final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T zaa(int i, T t) {
        t.f();
        this.zabm.a(this, i, (BaseImplementation.ApiMethodImpl<? extends Result, Api.AnyClient>) t);
        return t;
    }

    @KeepForSdk
    public GoogleApiClient asGoogleApiClient() {
        return this.zabk;
    }

    @KeepForSdk
    protected ClientSettings.Builder createClientSettingsBuilder() {
        Account b2;
        Set<Scope> emptySet;
        GoogleSignInAccount a2;
        GoogleSignInAccount a3;
        ClientSettings.Builder builder = new ClientSettings.Builder();
        O o = this.zabh;
        if ((o instanceof Api.ApiOptions.HasGoogleSignInAccountOptions) && (a3 = ((Api.ApiOptions.HasGoogleSignInAccountOptions) o).a()) != null) {
            b2 = a3.a();
        } else {
            O o2 = this.zabh;
            b2 = o2 instanceof Api.ApiOptions.HasAccountOptions ? ((Api.ApiOptions.HasAccountOptions) o2).b() : null;
        }
        ClientSettings.Builder a4 = builder.a(b2);
        O o3 = this.zabh;
        if ((o3 instanceof Api.ApiOptions.HasGoogleSignInAccountOptions) && (a2 = ((Api.ApiOptions.HasGoogleSignInAccountOptions) o3).a()) != null) {
            emptySet = a2.R();
        } else {
            emptySet = Collections.emptySet();
        }
        return a4.a(emptySet).a(this.mContext.getClass().getName()).b(this.mContext.getPackageName());
    }

    @KeepForSdk
    protected Task<Boolean> disconnectService() {
        return this.zabm.b((GoogleApi<?>) this);
    }

    @KeepForSdk
    public <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T doBestEffortWrite(T t) {
        zaa(2, (int) t);
        return t;
    }

    @KeepForSdk
    public <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T doRead(T t) {
        zaa(0, (int) t);
        return t;
    }

    @KeepForSdk
    @Deprecated
    public <A extends Api.AnyClient, T extends RegisterListenerMethod<A, ?>, U extends UnregisterListenerMethod<A, ?>> Task<Void> doRegisterEventListener(T t, U u) {
        Preconditions.a(t);
        Preconditions.a(u);
        Preconditions.a(t.b(), "Listener has already been released.");
        Preconditions.a(u.a(), "Listener has already been released.");
        Preconditions.a(t.b().equals(u.a()), "Listener registration and unregistration methods must be constructed with the same ListenerHolder.");
        return this.zabm.a(this, (RegisterListenerMethod<Api.AnyClient, ?>) t, (UnregisterListenerMethod<Api.AnyClient, ?>) u);
    }

    @KeepForSdk
    public Task<Boolean> doUnregisterEventListener(ListenerHolder.ListenerKey<?> listenerKey) {
        Preconditions.a(listenerKey, "Listener key cannot be null.");
        return this.zabm.a(this, listenerKey);
    }

    @KeepForSdk
    public <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T doWrite(T t) {
        zaa(1, (int) t);
        return t;
    }

    public final Api<O> getApi() {
        return this.mApi;
    }

    @KeepForSdk
    public O getApiOptions() {
        return this.zabh;
    }

    @KeepForSdk
    public Context getApplicationContext() {
        return this.mContext;
    }

    public final int getInstanceId() {
        return this.mId;
    }

    @KeepForSdk
    public Looper getLooper() {
        return this.zabj;
    }

    @KeepForSdk
    public <L> ListenerHolder<L> registerListener(L l, String str) {
        return ListenerHolders.a(l, this.zabj, str);
    }

    public final zai<O> zak() {
        return this.zabi;
    }

    @KeepForSdk
    public <TResult, A extends Api.AnyClient> Task<TResult> doBestEffortWrite(TaskApiCall<A, TResult> taskApiCall) {
        return zaa(2, taskApiCall);
    }

    @KeepForSdk
    public <TResult, A extends Api.AnyClient> Task<TResult> doRead(TaskApiCall<A, TResult> taskApiCall) {
        return zaa(0, taskApiCall);
    }

    @KeepForSdk
    public <TResult, A extends Api.AnyClient> Task<TResult> doWrite(TaskApiCall<A, TResult> taskApiCall) {
        return zaa(1, taskApiCall);
    }

    private final <TResult, A extends Api.AnyClient> Task<TResult> zaa(int i, TaskApiCall<A, TResult> taskApiCall) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.zabm.a(this, i, taskApiCall, taskCompletionSource, this.zabl);
        return taskCompletionSource.a();
    }

    /* JADX WARN: Type inference failed for: r9v1, types: [com.google.android.gms.common.api.Api$Client] */
    public Api.Client zaa(Looper looper, GoogleApiManager.zaa<O> zaaVar) {
        return this.mApi.d().a(this.mContext, looper, createClientSettingsBuilder().a(), this.zabh, zaaVar, zaaVar);
    }

    public zace zaa(Context context, Handler handler) {
        return new zace(context, handler, createClientSettingsBuilder().a());
    }

    @KeepForSdk
    public <A extends Api.AnyClient> Task<Void> doRegisterEventListener(RegistrationMethods<A, ?> registrationMethods) {
        Preconditions.a(registrationMethods);
        Preconditions.a(registrationMethods.f10794a.b(), "Listener has already been released.");
        Preconditions.a(registrationMethods.f10795b.a(), "Listener has already been released.");
        return this.zabm.a(this, registrationMethods.f10794a, registrationMethods.f10795b);
    }

    @KeepForSdk
    @Deprecated
    public GoogleApi(Context context, Api<O> api, O o, Looper looper, StatusExceptionMapper statusExceptionMapper) {
        this(context, api, o, new Settings.Builder().a(looper).a(statusExceptionMapper).a());
    }

    @KeepForSdk
    public GoogleApi(Activity activity, Api<O> api, O o, Settings settings) {
        Preconditions.a(activity, "Null activity is not permitted.");
        Preconditions.a(api, "Api must not be null.");
        Preconditions.a(settings, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        this.mContext = activity.getApplicationContext();
        this.mApi = api;
        this.zabh = o;
        this.zabj = settings.f10686c;
        this.zabi = zai.a(this.mApi, this.zabh);
        this.zabk = new zabp(this);
        this.zabm = GoogleApiManager.a(this.mContext);
        this.mId = this.zabm.d();
        this.zabl = settings.f10685b;
        if (!(activity instanceof GoogleApiActivity)) {
            zaae.a(activity, this.zabm, (zai<?>) this.zabi);
        }
        this.zabm.a((GoogleApi<?>) this);
    }

    @KeepForSdk
    public GoogleApi(Context context, Api<O> api, O o, Settings settings) {
        Preconditions.a(context, "Null context is not permitted.");
        Preconditions.a(api, "Api must not be null.");
        Preconditions.a(settings, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        this.mContext = context.getApplicationContext();
        this.mApi = api;
        this.zabh = o;
        this.zabj = settings.f10686c;
        this.zabi = zai.a(this.mApi, this.zabh);
        this.zabk = new zabp(this);
        this.zabm = GoogleApiManager.a(this.mContext);
        this.mId = this.zabm.d();
        this.zabl = settings.f10685b;
        this.zabm.a((GoogleApi<?>) this);
    }

    @KeepForSdk
    @Deprecated
    public GoogleApi(Activity activity, Api<O> api, O o, StatusExceptionMapper statusExceptionMapper) {
        this(activity, (Api) api, (Api.ApiOptions) o, new Settings.Builder().a(statusExceptionMapper).a(activity.getMainLooper()).a());
    }

    @KeepForSdk
    @Deprecated
    public GoogleApi(Context context, Api<O> api, O o, StatusExceptionMapper statusExceptionMapper) {
        this(context, api, o, new Settings.Builder().a(statusExceptionMapper).a());
    }
}
