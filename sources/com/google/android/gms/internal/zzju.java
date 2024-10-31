package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.appdatasearch.GetRecentContextCall;
import com.google.android.gms.appdatasearch.UsageInfo;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndexApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzlb;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class zzju implements com.google.android.gms.appdatasearch.zzk, AppIndexApi {

    @Deprecated
    /* loaded from: classes.dex */
    private static final class a implements AppIndexApi.ActionResult {

        /* renamed from: a, reason: collision with root package name */
        private zzju f1734a;
        private PendingResult<Status> b;
        private Action c;

        a(zzju zzjuVar, PendingResult<Status> pendingResult, Action action) {
            this.f1734a = zzjuVar;
            this.b = pendingResult;
            this.c = action;
        }
    }

    /* loaded from: classes.dex */
    private static abstract class b<T extends Result> extends zzlb.zza<T, zzjs> {
        public b(GoogleApiClient googleApiClient) {
            super(com.google.android.gms.appdatasearch.zza.f769a, googleApiClient);
        }

        protected abstract void a(zzjp zzjpVar) throws RemoteException;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzlb.zza
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void zza(zzjs zzjsVar) throws RemoteException {
            a(zzjsVar.zzlw());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static abstract class c<T extends Result> extends b<Status> {
        /* JADX INFO: Access modifiers changed from: package-private */
        public c(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzlc
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Status zzb(Status status) {
            return status;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class d extends zzjr<Status> {
        public d(zzlb.zzb<Status> zzbVar) {
            super(zzbVar);
        }

        @Override // com.google.android.gms.internal.zzjr, com.google.android.gms.internal.zzjq
        public void zzc(Status status) {
            this.zzRb.zzp(status);
        }
    }

    public static Intent zza(String str, Uri uri) {
        zzb(str, uri);
        List<String> pathSegments = uri.getPathSegments();
        String str2 = pathSegments.get(0);
        Uri.Builder builder = new Uri.Builder();
        builder.scheme(str2);
        if (pathSegments.size() > 1) {
            builder.authority(pathSegments.get(1));
            int i = 2;
            while (true) {
                int i2 = i;
                if (i2 >= pathSegments.size()) {
                    break;
                }
                builder.appendPath(pathSegments.get(i2));
                i = i2 + 1;
            }
        }
        builder.encodedQuery(uri.getEncodedQuery());
        builder.encodedFragment(uri.getEncodedFragment());
        return new Intent("android.intent.action.VIEW", builder.build());
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, Action action, int i) {
        return zza(googleApiClient, zzjt.zza(action, System.currentTimeMillis(), googleApiClient.getContext().getPackageName(), i));
    }

    private static void zzb(String str, Uri uri) {
        if (!"android-app".equals(uri.getScheme())) {
            throw new IllegalArgumentException("AppIndex: The URI scheme must be 'android-app' and follow the format (android-app://<package_name>/<scheme>/[host_path]). Provided URI: " + uri);
        }
        String host = uri.getHost();
        if (str != null && !str.equals(host)) {
            throw new IllegalArgumentException("AppIndex: The URI host must match the package name and follow the format (android-app://<package_name>/<scheme>/[host_path]). Provided URI: " + uri);
        }
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.isEmpty() || pathSegments.get(0).isEmpty()) {
            throw new IllegalArgumentException("AppIndex: The app URI scheme must exist and follow the format android-app://<package_name>/<scheme>/[host_path]). Provided URI: " + uri);
        }
    }

    public static void zzp(List<AppIndexApi.AppIndexingLink> list) {
        if (list == null) {
            return;
        }
        Iterator<AppIndexApi.AppIndexingLink> it = list.iterator();
        while (it.hasNext()) {
            zzb(null, it.next().f773a);
        }
    }

    public AppIndexApi.ActionResult action(GoogleApiClient googleApiClient, Action action) {
        return new a(this, zza(googleApiClient, action, 1), action);
    }

    public PendingResult<Status> end(GoogleApiClient googleApiClient, Action action) {
        return zza(googleApiClient, action, 2);
    }

    public PendingResult<Status> start(GoogleApiClient googleApiClient, Action action) {
        return zza(googleApiClient, action, 1);
    }

    public PendingResult<Status> view(GoogleApiClient googleApiClient, Activity activity, Intent intent, String str, Uri uri, List<AppIndexApi.AppIndexingLink> list) {
        String packageName = googleApiClient.getContext().getPackageName();
        zzp(list);
        return zza(googleApiClient, new UsageInfo(packageName, intent, str, uri, null, list, 1));
    }

    public PendingResult<Status> view(GoogleApiClient googleApiClient, Activity activity, Uri uri, String str, Uri uri2, List<AppIndexApi.AppIndexingLink> list) {
        String packageName = googleApiClient.getContext().getPackageName();
        zzb(packageName, uri);
        return view(googleApiClient, activity, zza(packageName, uri), str, uri2, list);
    }

    public PendingResult<Status> viewEnd(GoogleApiClient googleApiClient, Activity activity, Intent intent) {
        return zza(googleApiClient, new UsageInfo.zza().a(UsageInfo.a(googleApiClient.getContext().getPackageName(), intent)).a(System.currentTimeMillis()).a(0).b(2).a());
    }

    public PendingResult<Status> viewEnd(GoogleApiClient googleApiClient, Activity activity, Uri uri) {
        return viewEnd(googleApiClient, activity, zza(googleApiClient.getContext().getPackageName(), uri));
    }

    @Override // com.google.android.gms.appdatasearch.zzk
    public PendingResult<GetRecentContextCall.Response> zza(GoogleApiClient googleApiClient, GetRecentContextCall.Request request) {
        return googleApiClient.zza((GoogleApiClient) new GetRecentContextCall.zza(request, googleApiClient));
    }

    public PendingResult<Status> zza(GoogleApiClient googleApiClient, UsageInfo... usageInfoArr) {
        return googleApiClient.zza((GoogleApiClient) new er(this, googleApiClient, googleApiClient.getContext().getPackageName(), usageInfoArr));
    }
}
