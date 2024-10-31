package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.firebase_auth.zzcj;
import com.google.android.gms.internal.firebase_auth.zzct;
import com.google.android.gms.internal.firebase_auth.zzcz;
import com.google.android.gms.internal.firebase_auth.zzdg;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.auth.internal.zzw;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class Q<ResultT, CallbackT> implements zzam<zzdq, ResultT> {

    /* renamed from: a, reason: collision with root package name */
    protected final int f16432a;

    /* renamed from: c, reason: collision with root package name */
    protected FirebaseApp f16434c;

    /* renamed from: d, reason: collision with root package name */
    protected FirebaseUser f16435d;

    /* renamed from: e, reason: collision with root package name */
    protected CallbackT f16436e;

    /* renamed from: f, reason: collision with root package name */
    protected zzw f16437f;

    /* renamed from: g, reason: collision with root package name */
    protected P<ResultT> f16438g;
    protected Executor i;
    protected zzcz j;
    protected zzct k;
    protected zzcj l;
    protected zzdg m;
    protected String n;
    protected String o;
    protected AuthCredential p;
    protected String q;
    protected boolean r;
    private boolean s;

    @VisibleForTesting
    boolean t;

    @VisibleForTesting
    private ResultT u;

    @VisibleForTesting
    private Status v;

    /* renamed from: b, reason: collision with root package name */
    @VisibleForTesting
    final S f16433b = new S(this);

    /* renamed from: h, reason: collision with root package name */
    protected final List<PhoneAuthProvider.OnVerificationStateChangedCallbacks> f16439h = new ArrayList();

    public Q(int i) {
        this.f16432a = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e() {
        d();
        Preconditions.b(this.s, "no success or failure set on method implementation");
    }

    public final Q<ResultT, CallbackT> a(FirebaseApp firebaseApp) {
        Preconditions.a(firebaseApp, "firebaseApp cannot be null");
        this.f16434c = firebaseApp;
        return this;
    }

    public final void b(ResultT resultt) {
        this.s = true;
        this.t = true;
        this.u = resultt;
        this.f16438g.a(resultt, null);
    }

    @Override // com.google.firebase.auth.api.internal.zzam
    public final zzam<zzdq, ResultT> c() {
        this.r = true;
        return this;
    }

    public abstract void d();

    public final Q<ResultT, CallbackT> a(FirebaseUser firebaseUser) {
        Preconditions.a(firebaseUser, "firebaseUser cannot be null");
        this.f16435d = firebaseUser;
        return this;
    }

    public final Q<ResultT, CallbackT> a(CallbackT callbackt) {
        Preconditions.a(callbackt, "external callback cannot be null");
        this.f16436e = callbackt;
        return this;
    }

    public final Q<ResultT, CallbackT> a(zzw zzwVar) {
        Preconditions.a(zzwVar, "external failure callback cannot be null");
        this.f16437f = zzwVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(Status status) {
        zzw zzwVar = this.f16437f;
        if (zzwVar != null) {
            zzwVar.zza(status);
        }
    }

    public final void a(Status status) {
        this.s = true;
        this.t = false;
        this.v = status;
        this.f16438g.a(null, status);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean a(Q q, boolean z) {
        q.s = true;
        return true;
    }
}
