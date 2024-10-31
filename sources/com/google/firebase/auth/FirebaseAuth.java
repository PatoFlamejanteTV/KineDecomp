package com.google.firebase.auth;

import android.support.annotation.Keep;
import android.util.Log;
import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.firebase_auth.zzcz;
import com.google.android.gms.internal.firebase_auth.zzjo;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.api.internal.zzao;
import com.google.firebase.auth.api.internal.zzds;
import com.google.firebase.auth.api.internal.zzed;
import com.google.firebase.auth.api.internal.zzeg;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.auth.internal.zza;
import com.google.firebase.auth.internal.zzaa;
import com.google.firebase.auth.internal.zzad;
import com.google.firebase.auth.internal.zzae;
import com.google.firebase.auth.internal.zzag;
import com.google.firebase.auth.internal.zzah;
import com.google.firebase.auth.internal.zzk;
import com.google.firebase.internal.InternalTokenResult;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public class FirebaseAuth implements InternalAuthProvider {

    /* renamed from: a, reason: collision with root package name */
    private FirebaseApp f16388a;

    /* renamed from: b, reason: collision with root package name */
    private final List<IdTokenListener> f16389b;

    /* renamed from: c, reason: collision with root package name */
    private final List<com.google.firebase.auth.internal.IdTokenListener> f16390c;

    /* renamed from: d, reason: collision with root package name */
    private List<AuthStateListener> f16391d;

    /* renamed from: e, reason: collision with root package name */
    private zzao f16392e;

    /* renamed from: f, reason: collision with root package name */
    private FirebaseUser f16393f;

    /* renamed from: g, reason: collision with root package name */
    private zzk f16394g;

    /* renamed from: h, reason: collision with root package name */
    private final Object f16395h;
    private String i;
    private final Object j;
    private String k;
    private final zzad l;
    private final com.google.firebase.auth.internal.zzz m;
    private zzae n;
    private zzag o;

    /* loaded from: classes2.dex */
    public interface AuthStateListener {
        void a(FirebaseAuth firebaseAuth);
    }

    /* loaded from: classes2.dex */
    public interface IdTokenListener {
        void a(FirebaseAuth firebaseAuth);
    }

    @VisibleForTesting
    /* loaded from: classes2.dex */
    class a implements zza {
        a() {
        }

        @Override // com.google.firebase.auth.internal.zza
        public final void a(zzcz zzczVar, FirebaseUser firebaseUser) {
            Preconditions.a(zzczVar);
            Preconditions.a(firebaseUser);
            firebaseUser.a(zzczVar);
            FirebaseAuth.this.a(firebaseUser, zzczVar, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* loaded from: classes2.dex */
    public class b extends a implements zza, com.google.firebase.auth.internal.zzw {
        b() {
            super();
        }

        @Override // com.google.firebase.auth.internal.zzw
        public final void zza(Status status) {
            if (status.getStatusCode() == 17011 || status.getStatusCode() == 17021 || status.getStatusCode() == 17005) {
                FirebaseAuth.this.b();
            }
        }
    }

    public FirebaseAuth(FirebaseApp firebaseApp) {
        this(firebaseApp, zzed.a(firebaseApp.b(), new zzeg(firebaseApp.e().a()).a()), new zzad(firebaseApp.b(), firebaseApp.f()), com.google.firebase.auth.internal.zzz.a());
    }

    private final void b(FirebaseUser firebaseUser) {
        if (firebaseUser != null) {
            String R = firebaseUser.R();
            StringBuilder sb = new StringBuilder(String.valueOf(R).length() + 45);
            sb.append("Notifying id token listeners about user ( ");
            sb.append(R);
            sb.append(" ).");
            Log.d("FirebaseAuth", sb.toString());
        } else {
            Log.d("FirebaseAuth", "Notifying id token listeners about a sign-out event.");
        }
        this.o.execute(new c(this, new InternalTokenResult(firebaseUser != null ? firebaseUser.zzci() : null)));
    }

    @VisibleForTesting
    private final synchronized zzae e() {
        if (this.n == null) {
            a(new zzae(this.f16388a));
        }
        return this.n;
    }

    @Keep
    public static FirebaseAuth getInstance() {
        return (FirebaseAuth) FirebaseApp.c().a(FirebaseAuth.class);
    }

    public FirebaseUser a() {
        return this.f16393f;
    }

    public final void c() {
        FirebaseUser firebaseUser = this.f16393f;
        if (firebaseUser != null) {
            zzad zzadVar = this.l;
            Preconditions.a(firebaseUser);
            zzadVar.a(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", firebaseUser.R()));
            this.f16393f = null;
        }
        this.l.a("com.google.firebase.auth.FIREBASE_USER");
        b((FirebaseUser) null);
        c((FirebaseUser) null);
    }

    public final FirebaseApp d() {
        return this.f16388a;
    }

    public final void a(FirebaseUser firebaseUser, zzcz zzczVar, boolean z) {
        boolean z2;
        Preconditions.a(firebaseUser);
        Preconditions.a(zzczVar);
        FirebaseUser firebaseUser2 = this.f16393f;
        boolean z3 = true;
        if (firebaseUser2 == null) {
            z2 = true;
        } else {
            boolean z4 = !firebaseUser2.X().zzdw().equals(zzczVar.zzdw());
            boolean equals = this.f16393f.R().equals(firebaseUser.R());
            z2 = !equals || z4;
            if (equals) {
                z3 = false;
            }
        }
        Preconditions.a(firebaseUser);
        FirebaseUser firebaseUser3 = this.f16393f;
        if (firebaseUser3 == null) {
            this.f16393f = firebaseUser;
        } else {
            firebaseUser3.a(firebaseUser.P());
            if (!firebaseUser.U()) {
                this.f16393f.W();
            }
        }
        if (z) {
            this.l.a(this.f16393f);
        }
        if (z2) {
            FirebaseUser firebaseUser4 = this.f16393f;
            if (firebaseUser4 != null) {
                firebaseUser4.a(zzczVar);
            }
            b(this.f16393f);
        }
        if (z3) {
            c(this.f16393f);
        }
        if (z) {
            this.l.a(firebaseUser, zzczVar);
        }
        e().a(this.f16393f.X());
    }

    @Keep
    public static FirebaseAuth getInstance(FirebaseApp firebaseApp) {
        return (FirebaseAuth) firebaseApp.a(FirebaseAuth.class);
    }

    public Task<AuthResult> b(String str, String str2) {
        Preconditions.b(str);
        Preconditions.b(str2);
        return this.f16392e.b(this.f16388a, str, str2, this.k, new a());
    }

    @VisibleForTesting
    private FirebaseAuth(FirebaseApp firebaseApp, zzao zzaoVar, zzad zzadVar, com.google.firebase.auth.internal.zzz zzzVar) {
        zzcz b2;
        this.f16395h = new Object();
        this.j = new Object();
        Preconditions.a(firebaseApp);
        this.f16388a = firebaseApp;
        Preconditions.a(zzaoVar);
        this.f16392e = zzaoVar;
        Preconditions.a(zzadVar);
        this.l = zzadVar;
        this.f16394g = new zzk();
        Preconditions.a(zzzVar);
        this.m = zzzVar;
        this.f16389b = new CopyOnWriteArrayList();
        this.f16390c = new CopyOnWriteArrayList();
        this.f16391d = new CopyOnWriteArrayList();
        this.o = zzag.a();
        this.f16393f = this.l.a();
        FirebaseUser firebaseUser = this.f16393f;
        if (firebaseUser != null && (b2 = this.l.b(firebaseUser)) != null) {
            a(this.f16393f, b2, false);
        }
        this.m.a(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.google.firebase.auth.FirebaseAuth$b, com.google.firebase.auth.internal.zzah] */
    public final Task<AuthResult> b(FirebaseUser firebaseUser, AuthCredential authCredential) {
        Preconditions.a(authCredential);
        Preconditions.a(firebaseUser);
        return this.f16392e.a(this.f16388a, firebaseUser, authCredential, (zzah) new b());
    }

    private final void c(FirebaseUser firebaseUser) {
        if (firebaseUser != null) {
            String R = firebaseUser.R();
            StringBuilder sb = new StringBuilder(String.valueOf(R).length() + 47);
            sb.append("Notifying auth state listeners about user ( ");
            sb.append(R);
            sb.append(" ).");
            Log.d("FirebaseAuth", sb.toString());
        } else {
            Log.d("FirebaseAuth", "Notifying auth state listeners about a sign-out event.");
        }
        this.o.execute(new d(this));
    }

    public Task<Void> b(String str) {
        Preconditions.b(str);
        return a(str, (ActionCodeSettings) null);
    }

    public final void c(String str) {
        Preconditions.b(str);
        synchronized (this.j) {
            this.k = str;
        }
    }

    public void b() {
        c();
        zzae zzaeVar = this.n;
        if (zzaeVar != null) {
            zzaeVar.a();
        }
    }

    @VisibleForTesting
    private final synchronized void a(zzae zzaeVar) {
        this.n = zzaeVar;
        this.f16388a.a(zzaeVar);
    }

    public void a(AuthStateListener authStateListener) {
        this.f16391d.add(authStateListener);
        this.o.execute(new com.google.firebase.auth.b(this, authStateListener));
    }

    @Override // com.google.firebase.internal.InternalTokenProvider
    public Task<GetTokenResult> a(boolean z) {
        return a(this.f16393f, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.google.firebase.auth.e, com.google.firebase.auth.internal.zzah] */
    public final Task<GetTokenResult> a(FirebaseUser firebaseUser, boolean z) {
        if (firebaseUser == null) {
            return Tasks.a((Exception) zzds.a(new Status(17495)));
        }
        zzcz X = firebaseUser.X();
        if (X.isValid() && !z) {
            return Tasks.a(zzaa.a(X.zzdw()));
        }
        return this.f16392e.a(this.f16388a, firebaseUser, X.zzr(), (zzah) new e(this));
    }

    public Task<AuthResult> a(AuthCredential authCredential) {
        Preconditions.a(authCredential);
        if (authCredential instanceof EmailAuthCredential) {
            EmailAuthCredential emailAuthCredential = (EmailAuthCredential) authCredential;
            if (!emailAuthCredential.P()) {
                return this.f16392e.b(this.f16388a, emailAuthCredential.getEmail(), emailAuthCredential.getPassword(), this.k, new a());
            }
            return this.f16392e.a(this.f16388a, emailAuthCredential, new a());
        }
        if (authCredential instanceof PhoneAuthCredential) {
            return this.f16392e.a(this.f16388a, (PhoneAuthCredential) authCredential, this.k, (zza) new a());
        }
        return this.f16392e.a(this.f16388a, authCredential, this.k, new a());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.google.firebase.auth.FirebaseAuth$b, com.google.firebase.auth.internal.zzah] */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.google.firebase.auth.FirebaseAuth$b, com.google.firebase.auth.internal.zzah] */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.google.firebase.auth.FirebaseAuth$b, com.google.firebase.auth.internal.zzah] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.google.firebase.auth.FirebaseAuth$b, com.google.firebase.auth.internal.zzah] */
    public final Task<AuthResult> a(FirebaseUser firebaseUser, AuthCredential authCredential) {
        Preconditions.a(firebaseUser);
        Preconditions.a(authCredential);
        if (EmailAuthCredential.class.isAssignableFrom(authCredential.getClass())) {
            EmailAuthCredential emailAuthCredential = (EmailAuthCredential) authCredential;
            if (AuthUI.EMAIL_PROVIDER.equals(emailAuthCredential.a())) {
                return this.f16392e.a(this.f16388a, firebaseUser, emailAuthCredential.getEmail(), emailAuthCredential.getPassword(), firebaseUser.zzcf(), new b());
            }
            return this.f16392e.a(this.f16388a, firebaseUser, emailAuthCredential, (zzah) new b());
        }
        if (authCredential instanceof PhoneAuthCredential) {
            return this.f16392e.a(this.f16388a, firebaseUser, (PhoneAuthCredential) authCredential, this.k, (zzah) new b());
        }
        return this.f16392e.a(this.f16388a, firebaseUser, authCredential, firebaseUser.zzcf(), (zzah) new b());
    }

    public Task<AuthResult> a(String str, String str2) {
        Preconditions.b(str);
        Preconditions.b(str2);
        return this.f16392e.a(this.f16388a, str, str2, this.k, new a());
    }

    @Deprecated
    public Task<ProviderQueryResult> a(String str) {
        Preconditions.b(str);
        return this.f16392e.a(this.f16388a, str, this.k);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.google.firebase.auth.FirebaseAuth$b, com.google.firebase.auth.internal.zzah] */
    public final Task<Void> a(FirebaseUser firebaseUser, UserProfileChangeRequest userProfileChangeRequest) {
        Preconditions.a(firebaseUser);
        Preconditions.a(userProfileChangeRequest);
        return this.f16392e.a(this.f16388a, firebaseUser, userProfileChangeRequest, (zzah) new b());
    }

    public Task<Void> a(String str, ActionCodeSettings actionCodeSettings) {
        Preconditions.b(str);
        if (actionCodeSettings == null) {
            actionCodeSettings = ActionCodeSettings.V();
        }
        String str2 = this.i;
        if (str2 != null) {
            actionCodeSettings.e(str2);
        }
        actionCodeSettings.a(zzjo.PASSWORD_RESET);
        return this.f16392e.a(this.f16388a, str, actionCodeSettings, this.k);
    }

    public final Task<Void> a(FirebaseUser firebaseUser) {
        Preconditions.a(firebaseUser);
        return this.f16392e.a(firebaseUser, new f(this, firebaseUser));
    }
}
