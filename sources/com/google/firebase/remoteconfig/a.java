package com.google.firebase.remoteconfig;

import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.internal.config.zzk;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes2.dex */
final class a implements ResultCallback<zzk> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ TaskCompletionSource f18078a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ FirebaseRemoteConfig f18079b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(FirebaseRemoteConfig firebaseRemoteConfig, TaskCompletionSource taskCompletionSource) {
        this.f18079b = firebaseRemoteConfig;
        this.f18078a = taskCompletionSource;
    }

    @Override // com.google.android.gms.common.api.ResultCallback
    public final /* synthetic */ void onResult(zzk zzkVar) {
        this.f18079b.a(this.f18078a, zzkVar);
    }
}
