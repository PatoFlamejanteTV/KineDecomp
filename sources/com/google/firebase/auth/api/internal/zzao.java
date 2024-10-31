package com.google.firebase.auth.api.internal;

import android.content.Context;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.firebase_auth.zzct;
import com.google.android.gms.internal.firebase_auth.zzdb;
import com.google.android.gms.internal.firebase_auth.zzjo;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.ProviderQueryResult;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.auth.internal.zzh;
import com.google.firebase.auth.internal.zzl;
import com.google.firebase.auth.internal.zzn;
import com.google.firebase.auth.internal.zzv;
import com.google.firebase.auth.internal.zzw;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/* loaded from: classes2.dex */
public final class zzao extends zzah {

    /* renamed from: c, reason: collision with root package name */
    private final Context f16469c;

    /* renamed from: d, reason: collision with root package name */
    private final zzef f16470d;

    /* renamed from: e, reason: collision with root package name */
    private final Future<C1561a<zzef>> f16471e = a();

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzao(Context context, zzef zzefVar) {
        this.f16469c = context;
        this.f16470d = zzefVar;
    }

    @Override // com.google.firebase.auth.api.internal.zzah
    final Future<C1561a<zzef>> a() {
        Future<C1561a<zzef>> future = this.f16471e;
        if (future != null) {
            return future;
        }
        return Executors.newSingleThreadExecutor().submit(new N(this.f16470d, this.f16469c));
    }

    public final Task<AuthResult> b(FirebaseApp firebaseApp, String str, String str2, String str3, com.google.firebase.auth.internal.zza zzaVar) {
        F f2 = new F(str, str2, str3);
        f2.a(firebaseApp);
        f2.a((F) zzaVar);
        F f3 = f2;
        return a(b(f3), f3);
    }

    public final Task<GetTokenResult> a(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, com.google.firebase.auth.internal.zzah zzahVar) {
        C1570j c1570j = new C1570j(str);
        c1570j.a(firebaseApp);
        c1570j.a(firebaseUser);
        c1570j.a((C1570j) zzahVar);
        c1570j.a((zzw) zzahVar);
        C1570j c1570j2 = c1570j;
        return a(a(c1570j2), c1570j2);
    }

    public final Task<AuthResult> a(FirebaseApp firebaseApp, AuthCredential authCredential, String str, com.google.firebase.auth.internal.zza zzaVar) {
        D d2 = new D(authCredential, str);
        d2.a(firebaseApp);
        d2.a((D) zzaVar);
        D d3 = d2;
        return a(b(d3), d3);
    }

    public final Task<AuthResult> a(FirebaseApp firebaseApp, FirebaseUser firebaseUser, AuthCredential authCredential, String str, com.google.firebase.auth.internal.zzah zzahVar) {
        C1579t c1579t = new C1579t(authCredential, str);
        c1579t.a(firebaseApp);
        c1579t.a(firebaseUser);
        c1579t.a((C1579t) zzahVar);
        c1579t.a((zzw) zzahVar);
        C1579t c1579t2 = c1579t;
        return a(b(c1579t2), c1579t2);
    }

    public final Task<Void> a(FirebaseApp firebaseApp, FirebaseUser firebaseUser, UserProfileChangeRequest userProfileChangeRequest, com.google.firebase.auth.internal.zzah zzahVar) {
        L l = new L(userProfileChangeRequest);
        l.a(firebaseApp);
        l.a(firebaseUser);
        l.a((L) zzahVar);
        l.a((zzw) zzahVar);
        L l2 = l;
        return a(b(l2), l2);
    }

    public final Task<AuthResult> a(FirebaseApp firebaseApp, String str, String str2, String str3, com.google.firebase.auth.internal.zza zzaVar) {
        C1564d c1564d = new C1564d(str, str2, str3);
        c1564d.a(firebaseApp);
        c1564d.a((C1564d) zzaVar);
        C1564d c1564d2 = c1564d;
        return a(b(c1564d2), c1564d2);
    }

    public final Task<AuthResult> a(FirebaseApp firebaseApp, EmailAuthCredential emailAuthCredential, com.google.firebase.auth.internal.zza zzaVar) {
        H h2 = new H(emailAuthCredential);
        h2.a(firebaseApp);
        h2.a((H) zzaVar);
        H h3 = h2;
        return a(b(h3), h3);
    }

    public final Task<AuthResult> a(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, String str2, String str3, com.google.firebase.auth.internal.zzah zzahVar) {
        C1583x c1583x = new C1583x(str, str2, str3);
        c1583x.a(firebaseApp);
        c1583x.a(firebaseUser);
        c1583x.a((C1583x) zzahVar);
        c1583x.a((zzw) zzahVar);
        C1583x c1583x2 = c1583x;
        return a(b(c1583x2), c1583x2);
    }

    public final Task<AuthResult> a(FirebaseApp firebaseApp, FirebaseUser firebaseUser, EmailAuthCredential emailAuthCredential, com.google.firebase.auth.internal.zzah zzahVar) {
        C1581v c1581v = new C1581v(emailAuthCredential);
        c1581v.a(firebaseApp);
        c1581v.a(firebaseUser);
        c1581v.a((C1581v) zzahVar);
        c1581v.a((zzw) zzahVar);
        C1581v c1581v2 = c1581v;
        return a(b(c1581v2), c1581v2);
    }

    public final Task<AuthResult> a(FirebaseApp firebaseApp, PhoneAuthCredential phoneAuthCredential, String str, com.google.firebase.auth.internal.zza zzaVar) {
        J j = new J(phoneAuthCredential, str);
        j.a(firebaseApp);
        j.a((J) zzaVar);
        J j2 = j;
        return a(b(j2), j2);
    }

    public final Task<AuthResult> a(FirebaseApp firebaseApp, FirebaseUser firebaseUser, PhoneAuthCredential phoneAuthCredential, String str, com.google.firebase.auth.internal.zzah zzahVar) {
        z zVar = new z(phoneAuthCredential, str);
        zVar.a(firebaseApp);
        zVar.a(firebaseUser);
        zVar.a((z) zzahVar);
        zVar.a((zzw) zzahVar);
        z zVar2 = zVar;
        return a(b(zVar2), zVar2);
    }

    public final Task<ProviderQueryResult> a(FirebaseApp firebaseApp, String str, String str2) {
        C1568h c1568h = new C1568h(str, str2);
        c1568h.a(firebaseApp);
        C1568h c1568h2 = c1568h;
        return a(a(c1568h2), c1568h2);
    }

    public final Task<Void> a(FirebaseApp firebaseApp, String str, ActionCodeSettings actionCodeSettings, String str2) {
        actionCodeSettings.a(zzjo.PASSWORD_RESET);
        B b2 = new B(str, actionCodeSettings, str2, "sendPasswordResetEmail");
        b2.a(firebaseApp);
        B b3 = b2;
        return a(b(b3), b3);
    }

    public final Task<AuthResult> a(FirebaseApp firebaseApp, FirebaseUser firebaseUser, AuthCredential authCredential, com.google.firebase.auth.internal.zzah zzahVar) {
        Preconditions.a(firebaseApp);
        Preconditions.a(authCredential);
        Preconditions.a(firebaseUser);
        Preconditions.a(zzahVar);
        List<String> Q = firebaseUser.Q();
        if (Q != null && Q.contains(authCredential.getProvider())) {
            return Tasks.a((Exception) zzds.a(new Status(17015)));
        }
        if (authCredential instanceof EmailAuthCredential) {
            EmailAuthCredential emailAuthCredential = (EmailAuthCredential) authCredential;
            if (!emailAuthCredential.P()) {
                C1572l c1572l = new C1572l(emailAuthCredential);
                c1572l.a(firebaseApp);
                c1572l.a(firebaseUser);
                c1572l.a((C1572l) zzahVar);
                c1572l.a((zzw) zzahVar);
                C1572l c1572l2 = c1572l;
                return a(b(c1572l2), c1572l2);
            }
            r rVar = new r(emailAuthCredential);
            rVar.a(firebaseApp);
            rVar.a(firebaseUser);
            rVar.a((r) zzahVar);
            rVar.a((zzw) zzahVar);
            r rVar2 = rVar;
            return a(b(rVar2), rVar2);
        }
        if (authCredential instanceof PhoneAuthCredential) {
            C1576p c1576p = new C1576p((PhoneAuthCredential) authCredential);
            c1576p.a(firebaseApp);
            c1576p.a(firebaseUser);
            c1576p.a((C1576p) zzahVar);
            c1576p.a((zzw) zzahVar);
            C1576p c1576p2 = c1576p;
            return a(b(c1576p2), c1576p2);
        }
        Preconditions.a(firebaseApp);
        Preconditions.a(authCredential);
        Preconditions.a(firebaseUser);
        Preconditions.a(zzahVar);
        C1574n c1574n = new C1574n(authCredential);
        c1574n.a(firebaseApp);
        c1574n.a(firebaseUser);
        c1574n.a((C1574n) zzahVar);
        c1574n.a((zzw) zzahVar);
        C1574n c1574n2 = c1574n;
        return a(b(c1574n2), c1574n2);
    }

    public final Task<Void> a(FirebaseUser firebaseUser, zzv zzvVar) {
        C1566f c1566f = new C1566f();
        c1566f.a(firebaseUser);
        c1566f.a((C1566f) zzvVar);
        c1566f.a((zzw) zzvVar);
        C1566f c1566f2 = c1566f;
        return a(b(c1566f2), c1566f2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public static zzl a(FirebaseApp firebaseApp, zzct zzctVar) {
        Preconditions.a(firebaseApp);
        Preconditions.a(zzctVar);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new zzh(zzctVar, "firebase"));
        List<zzdb> zzdu = zzctVar.zzdu();
        if (zzdu != null && !zzdu.isEmpty()) {
            for (int i = 0; i < zzdu.size(); i++) {
                arrayList.add(new zzh(zzdu.get(i)));
            }
        }
        zzl zzlVar = new zzl(firebaseApp, arrayList);
        zzlVar.a(new zzn(zzctVar.getLastSignInTimestamp(), zzctVar.getCreationTimestamp()));
        zzlVar.b(zzctVar.isNewUser());
        zzlVar.a(zzctVar.zzcv());
        return zzlVar;
    }

    @VisibleForTesting
    private final <ResultT> Task<ResultT> a(Task<ResultT> task, zzam<zzdq, ResultT> zzamVar) {
        return (Task<ResultT>) task.b(new C1563c(this, zzamVar));
    }
}
