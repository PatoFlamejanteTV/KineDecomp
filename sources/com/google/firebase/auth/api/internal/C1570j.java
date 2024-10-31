package com.google.firebase.auth.api.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.firebase_auth.zzau;
import com.google.android.gms.internal.firebase_auth.zze;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.auth.internal.zzaa;

/* JADX INFO: Access modifiers changed from: package-private */
@VisibleForTesting
/* renamed from: com.google.firebase.auth.api.internal.j, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1570j extends Q<GetTokenResult, com.google.firebase.auth.internal.zza> {
    private final zzau w;

    public C1570j(String str) {
        super(1);
        Preconditions.a(str, (Object) "refresh token cannot be null");
        this.w = new zzau(str);
    }

    @Override // com.google.firebase.auth.api.internal.zzam
    public final String a() {
        return "getAccessToken";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(zzdq zzdqVar, TaskCompletionSource taskCompletionSource) throws RemoteException {
        this.f16438g = new zzew(this, taskCompletionSource);
        if (this.r) {
            zzdqVar.a().g(this.w.zzr(), this.f16433b);
        } else {
            zzdqVar.a().a(this.w, this.f16433b);
        }
    }

    @Override // com.google.firebase.auth.api.internal.zzam
    public final TaskApiCall<zzdq, GetTokenResult> b() {
        return TaskApiCall.a().a(false).a(this.r ? null : new Feature[]{zze.zzf}).a(new RemoteCall(this) { // from class: com.google.firebase.auth.api.internal.k

            /* renamed from: a, reason: collision with root package name */
            private final C1570j f16458a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f16458a = this;
            }

            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                this.f16458a.a((zzdq) obj, (TaskCompletionSource) obj2);
            }
        }).a();
    }

    @Override // com.google.firebase.auth.api.internal.Q
    public final void d() {
        if (TextUtils.isEmpty(this.j.zzr())) {
            this.j.zzce(this.w.zzr());
        }
        ((com.google.firebase.auth.internal.zza) this.f16436e).a(this.j, this.f16435d);
        b((C1570j) zzaa.a(this.j.zzdw()));
    }
}
