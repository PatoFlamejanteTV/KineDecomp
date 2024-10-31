package com.google.android.gms.common.api.internal;

import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.Preconditions;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: classes.dex */
public class zaj extends zal {

    /* renamed from: f, reason: collision with root package name */
    private final SparseArray<a> f10939f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements GoogleApiClient.OnConnectionFailedListener {

        /* renamed from: a, reason: collision with root package name */
        public final int f10940a;

        /* renamed from: b, reason: collision with root package name */
        public final GoogleApiClient f10941b;

        /* renamed from: c, reason: collision with root package name */
        public final GoogleApiClient.OnConnectionFailedListener f10942c;

        public a(int i, GoogleApiClient googleApiClient, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            this.f10940a = i;
            this.f10941b = googleApiClient;
            this.f10942c = onConnectionFailedListener;
            googleApiClient.a(this);
        }

        @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
        public final void onConnectionFailed(ConnectionResult connectionResult) {
            String valueOf = String.valueOf(connectionResult);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
            sb.append("beginFailureResolution for ");
            sb.append(valueOf);
            Log.d("AutoManageHelper", sb.toString());
            zaj.this.b(connectionResult, this.f10940a);
        }
    }

    private zaj(LifecycleFragment lifecycleFragment) {
        super(lifecycleFragment);
        this.f10939f = new SparseArray<>();
        this.f10774a.a("AutoManageHelper", this);
    }

    public static zaj b(LifecycleActivity lifecycleActivity) {
        LifecycleFragment a2 = LifecycleCallback.a(lifecycleActivity);
        zaj zajVar = (zaj) a2.a("AutoManageHelper", zaj.class);
        return zajVar != null ? zajVar : new zaj(a2);
    }

    public final void a(int i, GoogleApiClient googleApiClient, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        Preconditions.a(googleApiClient, "GoogleApiClient instance cannot be null");
        boolean z = this.f10939f.indexOfKey(i) < 0;
        StringBuilder sb = new StringBuilder(54);
        sb.append("Already managing a GoogleApiClient with id ");
        sb.append(i);
        Preconditions.b(z, sb.toString());
        P p = this.f10950c.get();
        boolean z2 = this.f10949b;
        String valueOf = String.valueOf(p);
        StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 49);
        sb2.append("starting AutoManage for client ");
        sb2.append(i);
        sb2.append(" ");
        sb2.append(z2);
        sb2.append(" ");
        sb2.append(valueOf);
        Log.d("AutoManageHelper", sb2.toString());
        this.f10939f.put(i, new a(i, googleApiClient, onConnectionFailedListener));
        if (this.f10949b && p == null) {
            String valueOf2 = String.valueOf(googleApiClient);
            StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf2).length() + 11);
            sb3.append("connecting ");
            sb3.append(valueOf2);
            Log.d("AutoManageHelper", sb3.toString());
            googleApiClient.c();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zal, com.google.android.gms.common.api.internal.LifecycleCallback
    public void d() {
        super.d();
        boolean z = this.f10949b;
        String valueOf = String.valueOf(this.f10939f);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 14);
        sb.append("onStart ");
        sb.append(z);
        sb.append(" ");
        sb.append(valueOf);
        Log.d("AutoManageHelper", sb.toString());
        if (this.f10950c.get() == null) {
            for (int i = 0; i < this.f10939f.size(); i++) {
                a b2 = b(i);
                if (b2 != null) {
                    b2.f10941b.c();
                }
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.zal, com.google.android.gms.common.api.internal.LifecycleCallback
    public void e() {
        super.e();
        for (int i = 0; i < this.f10939f.size(); i++) {
            a b2 = b(i);
            if (b2 != null) {
                b2.f10941b.d();
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.zal
    protected final void f() {
        for (int i = 0; i < this.f10939f.size(); i++) {
            a b2 = b(i);
            if (b2 != null) {
                b2.f10941b.c();
            }
        }
    }

    private final a b(int i) {
        if (this.f10939f.size() <= i) {
            return null;
        }
        SparseArray<a> sparseArray = this.f10939f;
        return sparseArray.get(sparseArray.keyAt(i));
    }

    public final void a(int i) {
        a aVar = this.f10939f.get(i);
        this.f10939f.remove(i);
        if (aVar != null) {
            aVar.f10941b.b(aVar);
            aVar.f10941b.d();
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        for (int i = 0; i < this.f10939f.size(); i++) {
            a b2 = b(i);
            if (b2 != null) {
                printWriter.append((CharSequence) str).append("GoogleApiClient #").print(b2.f10940a);
                printWriter.println(":");
                b2.f10941b.a(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.zal
    public final void a(ConnectionResult connectionResult, int i) {
        Log.w("AutoManageHelper", "Unresolved error while connecting client. Stopping auto-manage.");
        if (i < 0) {
            Log.wtf("AutoManageHelper", "AutoManageLifecycleHelper received onErrorResolutionFailed callback but no failing client ID is set", new Exception());
            return;
        }
        a aVar = this.f10939f.get(i);
        if (aVar != null) {
            a(i);
            GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener = aVar.f10942c;
            if (onConnectionFailedListener != null) {
                onConnectionFailedListener.onConnectionFailed(connectionResult);
            }
        }
    }
}
