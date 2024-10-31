package com.google.android.gms.internal;

import android.app.Dialog;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: classes.dex */
public class zzlp extends Fragment implements DialogInterface.OnCancelListener {
    private static final GoogleApiAvailability zzacJ = GoogleApiAvailability.a();
    private boolean mStarted;
    private boolean zzacK;
    private ConnectionResult zzacM;
    private fy zzacO;
    private int zzacL = -1;
    private final Handler zzacN = new Handler(Looper.getMainLooper());
    private final SparseArray<a> zzacP = new SparseArray<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements GoogleApiClient.OnConnectionFailedListener {

        /* renamed from: a, reason: collision with root package name */
        public final int f1763a;
        public final GoogleApiClient b;
        public final GoogleApiClient.OnConnectionFailedListener c;

        public a(int i, GoogleApiClient googleApiClient, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            this.f1763a = i;
            this.b = googleApiClient;
            this.c = onConnectionFailedListener;
            googleApiClient.registerConnectionFailedListener(this);
        }

        public void a() {
            this.b.unregisterConnectionFailedListener(this);
            this.b.disconnect();
        }

        @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
        public void a(ConnectionResult connectionResult) {
            zzlp.this.zzacN.post(new b(this.f1763a, connectionResult));
        }

        public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.append((CharSequence) str).append("GoogleApiClient #").print(this.f1763a);
            printWriter.println(":");
            this.b.dump(str + "  ", fileDescriptor, printWriter, strArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        private final int b;
        private final ConnectionResult c;

        public b(int i, ConnectionResult connectionResult) {
            this.b = i;
            this.c = connectionResult;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!zzlp.this.mStarted || zzlp.this.zzacK) {
                return;
            }
            zzlp.this.zzacK = true;
            zzlp.this.zzacL = this.b;
            zzlp.this.zzacM = this.c;
            if (this.c.a()) {
                try {
                    this.c.a(zzlp.this.getActivity(), ((zzlp.this.getActivity().getSupportFragmentManager().c().indexOf(zzlp.this) + 1) << 16) + 1);
                    return;
                } catch (IntentSender.SendIntentException e) {
                    zzlp.this.zzok();
                    return;
                }
            }
            if (zzlp.zzacJ.a(this.c.c())) {
                GooglePlayServicesUtil.a(this.c.c(), zzlp.this.getActivity(), zzlp.this, 2, zzlp.this);
            } else {
                if (this.c.c() != 18) {
                    zzlp.this.zza(this.b, this.c);
                    return;
                }
                Dialog a2 = zzlp.zzacJ.a(zzlp.this.getActivity(), zzlp.this);
                zzlp.this.zzacO = fy.a(zzlp.this.getActivity().getApplicationContext(), new fz(this, a2));
            }
        }
    }

    public static zzlp zza(android.support.v4.app.l lVar) {
        com.google.android.gms.common.internal.zzx.b("Must be called from main thread of process");
        try {
            zzlp zzlpVar = (zzlp) lVar.getSupportFragmentManager().a("GmsSupportLifecycleFragment");
            if (zzlpVar == null || zzlpVar.isRemoving()) {
                return null;
            }
            return zzlpVar;
        } catch (ClassCastException e) {
            throw new IllegalStateException("Fragment with tag GmsSupportLifecycleFragment is not a SupportLifecycleFragment", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zza(int i, ConnectionResult connectionResult) {
        Log.w("GmsSupportLifecycleFragment", "Unresolved error while connecting client. Stopping auto-manage.");
        a aVar = this.zzacP.get(i);
        if (aVar != null) {
            zzbp(i);
            GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener = aVar.c;
            if (onConnectionFailedListener != null) {
                onConnectionFailedListener.a(connectionResult);
            }
        }
        zzok();
    }

    public static zzlp zzb(android.support.v4.app.l lVar) {
        zzlp zza = zza(lVar);
        android.support.v4.app.p supportFragmentManager = lVar.getSupportFragmentManager();
        if (zza != null) {
            return zza;
        }
        zzlp zzlpVar = new zzlp();
        supportFragmentManager.a().a(zzlpVar, "GmsSupportLifecycleFragment").b();
        supportFragmentManager.b();
        return zzlpVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzok() {
        int i = 0;
        this.zzacK = false;
        this.zzacL = -1;
        this.zzacM = null;
        if (this.zzacO != null) {
            this.zzacO.b();
            this.zzacO = null;
        }
        while (true) {
            int i2 = i;
            if (i2 >= this.zzacP.size()) {
                return;
            }
            this.zzacP.valueAt(i2).b.connect();
            i = i2 + 1;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.zzacP.size()) {
                return;
            }
            this.zzacP.valueAt(i2).a(str, fileDescriptor, printWriter, strArr);
            i = i2 + 1;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0016, code lost:            if (com.google.android.gms.internal.zzlp.zzacJ.a(getActivity()) == 0) goto L5;     */
    @Override // android.support.v4.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onActivityResult(int r5, int r6, android.content.Intent r7) {
        /*
            r4 = this;
            r0 = 1
            r1 = 0
            switch(r5) {
                case 1: goto L19;
                case 2: goto Lc;
                default: goto L5;
            }
        L5:
            r0 = r1
        L6:
            if (r0 == 0) goto L29
            r4.zzok()
        Lb:
            return
        Lc:
            com.google.android.gms.common.GoogleApiAvailability r2 = com.google.android.gms.internal.zzlp.zzacJ
            android.support.v4.app.l r3 = r4.getActivity()
            int r2 = r2.a(r3)
            if (r2 != 0) goto L5
            goto L6
        L19:
            r2 = -1
            if (r6 == r2) goto L6
            if (r6 != 0) goto L5
            com.google.android.gms.common.ConnectionResult r0 = new com.google.android.gms.common.ConnectionResult
            r2 = 13
            r3 = 0
            r0.<init>(r2, r3)
            r4.zzacM = r0
            goto L5
        L29:
            int r0 = r4.zzacL
            com.google.android.gms.common.ConnectionResult r1 = r4.zzacM
            r4.zza(r0, r1)
            goto Lb
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzlp.onActivityResult(int, int, android.content.Intent):void");
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        zza(this.zzacL, new ConnectionResult(13, null));
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.zzacK = bundle.getBoolean("resolving_error", false);
            this.zzacL = bundle.getInt("failed_client_id", -1);
            if (this.zzacL >= 0) {
                this.zzacM = new ConnectionResult(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution"));
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("resolving_error", this.zzacK);
        if (this.zzacL >= 0) {
            bundle.putInt("failed_client_id", this.zzacL);
            bundle.putInt("failed_status", this.zzacM.c());
            bundle.putParcelable("failed_resolution", this.zzacM.d());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.mStarted = true;
        if (this.zzacK) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.zzacP.size()) {
                return;
            }
            this.zzacP.valueAt(i2).b.connect();
            i = i2 + 1;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        int i = 0;
        super.onStop();
        this.mStarted = false;
        while (true) {
            int i2 = i;
            if (i2 >= this.zzacP.size()) {
                return;
            }
            this.zzacP.valueAt(i2).b.disconnect();
            i = i2 + 1;
        }
    }

    public void zza(int i, GoogleApiClient googleApiClient, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        com.google.android.gms.common.internal.zzx.a(googleApiClient, "GoogleApiClient instance cannot be null");
        com.google.android.gms.common.internal.zzx.a(this.zzacP.indexOfKey(i) < 0, "Already managing a GoogleApiClient with id " + i);
        this.zzacP.put(i, new a(i, googleApiClient, onConnectionFailedListener));
        if (!this.mStarted || this.zzacK) {
            return;
        }
        googleApiClient.connect();
    }

    public void zzbp(int i) {
        a aVar = this.zzacP.get(i);
        this.zzacP.remove(i);
        if (aVar != null) {
            aVar.a();
        }
    }
}
