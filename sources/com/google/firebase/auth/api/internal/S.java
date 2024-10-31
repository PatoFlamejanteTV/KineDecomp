package com.google.firebase.auth.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.firebase_auth.zzcg;
import com.google.android.gms.internal.firebase_auth.zzcj;
import com.google.android.gms.internal.firebase_auth.zzct;
import com.google.android.gms.internal.firebase_auth.zzcz;
import com.google.android.gms.internal.firebase_auth.zzdg;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.internal.zzw;

/* JADX INFO: Access modifiers changed from: package-private */
@VisibleForTesting
/* loaded from: classes2.dex */
public final class S extends zzdy {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Q f16440a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public S(Q q) {
        this.f16440a = q;
    }

    @Override // com.google.firebase.auth.api.internal.zzdx
    public final void a(zzcz zzczVar) throws RemoteException {
        boolean z = this.f16440a.f16432a == 1;
        int i = this.f16440a.f16432a;
        StringBuilder sb = new StringBuilder(37);
        sb.append("Unexpected response type: ");
        sb.append(i);
        Preconditions.b(z, sb.toString());
        Q q = this.f16440a;
        q.j = zzczVar;
        q.e();
    }

    @Override // com.google.firebase.auth.api.internal.zzdx
    public final void c(String str) throws RemoteException {
        boolean z = this.f16440a.f16432a == 8;
        int i = this.f16440a.f16432a;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        Preconditions.b(z, sb.toString());
        this.f16440a.o = str;
        a(new T(this, str));
    }

    @Override // com.google.firebase.auth.api.internal.zzdx
    public final void d(String str) throws RemoteException {
        boolean z = this.f16440a.f16432a == 8;
        int i = this.f16440a.f16432a;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        Preconditions.b(z, sb.toString());
        Q q = this.f16440a;
        q.o = str;
        Q.a(q, true);
        this.f16440a.t = true;
        a(new V(this, str));
    }

    @Override // com.google.firebase.auth.api.internal.zzdx
    public final void e(String str) throws RemoteException {
        boolean z = this.f16440a.f16432a == 7;
        int i = this.f16440a.f16432a;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        Preconditions.b(z, sb.toString());
        Q q = this.f16440a;
        q.n = str;
        q.e();
    }

    @Override // com.google.firebase.auth.api.internal.zzdx
    public final void o() throws RemoteException {
        boolean z = this.f16440a.f16432a == 6;
        int i = this.f16440a.f16432a;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        Preconditions.b(z, sb.toString());
        this.f16440a.e();
    }

    @Override // com.google.firebase.auth.api.internal.zzdx
    public final void onFailure(Status status) throws RemoteException {
        Q q = this.f16440a;
        if (q.f16432a == 8) {
            Q.a(q, true);
            this.f16440a.t = false;
            a(new W(this, status));
        } else {
            q.b(status);
            this.f16440a.a(status);
        }
    }

    @Override // com.google.firebase.auth.api.internal.zzdx
    public final void p() throws RemoteException {
        boolean z = this.f16440a.f16432a == 9;
        int i = this.f16440a.f16432a;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        Preconditions.b(z, sb.toString());
        this.f16440a.e();
    }

    @Override // com.google.firebase.auth.api.internal.zzdx
    public final void zzde() throws RemoteException {
        boolean z = this.f16440a.f16432a == 5;
        int i = this.f16440a.f16432a;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        Preconditions.b(z, sb.toString());
        this.f16440a.e();
    }

    @Override // com.google.firebase.auth.api.internal.zzdx
    public final void a(zzcz zzczVar, zzct zzctVar) throws RemoteException {
        boolean z = this.f16440a.f16432a == 2;
        int i = this.f16440a.f16432a;
        StringBuilder sb = new StringBuilder(37);
        sb.append("Unexpected response type: ");
        sb.append(i);
        Preconditions.b(z, sb.toString());
        Q q = this.f16440a;
        q.j = zzczVar;
        q.k = zzctVar;
        q.e();
    }

    @Override // com.google.firebase.auth.api.internal.zzdx
    public final void a(zzcj zzcjVar) throws RemoteException {
        boolean z = this.f16440a.f16432a == 3;
        int i = this.f16440a.f16432a;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        Preconditions.b(z, sb.toString());
        Q q = this.f16440a;
        q.l = zzcjVar;
        q.e();
    }

    @Override // com.google.firebase.auth.api.internal.zzdx
    public final void a(zzdg zzdgVar) throws RemoteException {
        boolean z = this.f16440a.f16432a == 4;
        int i = this.f16440a.f16432a;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        Preconditions.b(z, sb.toString());
        Q q = this.f16440a;
        q.m = zzdgVar;
        q.e();
    }

    @Override // com.google.firebase.auth.api.internal.zzdx
    public final void a(PhoneAuthCredential phoneAuthCredential) throws RemoteException {
        boolean z = this.f16440a.f16432a == 8;
        int i = this.f16440a.f16432a;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        Preconditions.b(z, sb.toString());
        Q.a(this.f16440a, true);
        this.f16440a.t = true;
        a(new U(this, phoneAuthCredential));
    }

    @Override // com.google.firebase.auth.api.internal.zzdx
    public final void a(Status status, PhoneAuthCredential phoneAuthCredential) throws RemoteException {
        boolean z = this.f16440a.f16432a == 2;
        int i = this.f16440a.f16432a;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        Preconditions.b(z, sb.toString());
        a(status, phoneAuthCredential, null);
    }

    @Override // com.google.firebase.auth.api.internal.zzdx
    public final void a(zzcg zzcgVar) {
        a(zzcgVar.getStatus(), zzcgVar.zzcv(), zzcgVar.getEmail());
    }

    private final void a(Status status, AuthCredential authCredential, String str) {
        this.f16440a.b(status);
        Q q = this.f16440a;
        q.p = authCredential;
        q.q = str;
        zzw zzwVar = q.f16437f;
        if (zzwVar != null) {
            zzwVar.zza(status);
        }
        this.f16440a.a(status);
    }

    private final void a(Y y) {
        this.f16440a.i.execute(new X(this, y));
    }
}
