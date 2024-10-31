package com.google.android.gms.internal;

import android.hardware.display.DisplayManager;
import android.hardware.display.VirtualDisplay;
import android.os.RemoteException;
import android.view.Display;
import android.view.Surface;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.cast.CastRemoteDisplay;
import com.google.android.gms.cast.CastRemoteDisplayApi;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzky;
import com.google.android.gms.internal.zzlb;

/* loaded from: classes.dex */
public class zzkw implements CastRemoteDisplayApi {
    private static final com.google.android.gms.cast.internal.zzl zzVo = new com.google.android.gms.cast.internal.zzl("CastRemoteDisplayApiImpl");
    private Api.zzc<zzkx> zzZM;
    private VirtualDisplay zzZN;
    private final zzla zzZO = new fh(this);

    /* loaded from: classes.dex */
    private abstract class a extends zzky.zza {
        private a() {
        }

        /* synthetic */ a(zzkw zzkwVar, fh fhVar) {
            this();
        }

        @Override // com.google.android.gms.internal.zzky
        public void onDisconnected() throws RemoteException {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.android.gms.internal.zzky
        public void onError(int i) throws RemoteException {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.android.gms.internal.zzky
        public void zza(int i, int i2, Surface surface) throws RemoteException {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.android.gms.internal.zzky
        public void zznn() throws RemoteException {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b implements CastRemoteDisplay.CastRemoteDisplaySessionResult {

        /* renamed from: a, reason: collision with root package name */
        private final Status f1746a;
        private final Display b;

        public b(Display display) {
            this.f1746a = Status.f979a;
            this.b = display;
        }

        public b(Status status) {
            this.f1746a = status;
            this.b = null;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.f1746a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public abstract class zzb extends zzlb.zza<CastRemoteDisplay.CastRemoteDisplaySessionResult, zzkx> {

        /* loaded from: classes.dex */
        protected final class zza extends a {
            private final zzkx zzZR;

            public zza(zzkx zzkxVar) {
                super(zzkw.this, null);
                this.zzZR = zzkxVar;
            }

            private int zzi(int i, int i2) {
                if (i >= i2) {
                    i = i2;
                }
                return (i * 320) / 1080;
            }

            @Override // com.google.android.gms.internal.zzkw.a, com.google.android.gms.internal.zzky
            public void onError(int i) throws RemoteException {
                zzkw.zzVo.b("onError: %d", Integer.valueOf(i));
                zzkw.this.zznl();
                zzb.this.zzb((zzb) new b(Status.c));
            }

            @Override // com.google.android.gms.internal.zzkw.a, com.google.android.gms.internal.zzky
            public void zza(int i, int i2, Surface surface) {
                zzkw.zzVo.b("onConnected", new Object[0]);
                DisplayManager displayManager = (DisplayManager) this.zzZR.getContext().getSystemService(ServerProtocol.DIALOG_PARAM_DISPLAY);
                if (displayManager == null) {
                    zzkw.zzVo.e("Unable to get the display manager", new Object[0]);
                    zzb.this.zzb((zzb) new b(Status.c));
                    return;
                }
                zzkw.this.zznl();
                int zzi = zzi(i, i2);
                zzkw.this.zzZN = displayManager.createVirtualDisplay("private_display", i, i2, zzi, surface, 2);
                if (zzkw.this.zzZN == null) {
                    zzkw.zzVo.e("Unable to create virtual display", new Object[0]);
                    zzb.this.zzb((zzb) new b(Status.c));
                } else if (zzkw.this.zzZN.getDisplay() == null) {
                    zzkw.zzVo.e("Virtual display does not have a display", new Object[0]);
                    zzb.this.zzb((zzb) new b(Status.c));
                } else {
                    try {
                        this.zzZR.zza(this, zzkw.this.zzZN.getDisplay().getDisplayId());
                    } catch (RemoteException | IllegalStateException e) {
                        zzkw.zzVo.e("Unable to provision the route's new virtual Display", new Object[0]);
                        zzb.this.zzb((zzb) new b(Status.c));
                    }
                }
            }

            @Override // com.google.android.gms.internal.zzkw.a, com.google.android.gms.internal.zzky
            public void zznn() {
                zzkw.zzVo.b("onConnectedWithDisplay", new Object[0]);
                Display display = zzkw.this.zzZN.getDisplay();
                if (display != null) {
                    zzb.this.zzb((zzb) new b(display));
                } else {
                    zzkw.zzVo.e("Virtual display no longer has a display", new Object[0]);
                    zzb.this.zzb((zzb) new b(Status.c));
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: com.google.android.gms.internal.zzkw$zzb$zzb, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public final class BinderC0035zzb extends a {
            /* JADX INFO: Access modifiers changed from: protected */
            public BinderC0035zzb() {
                super(zzkw.this, null);
            }

            @Override // com.google.android.gms.internal.zzkw.a, com.google.android.gms.internal.zzky
            public void onDisconnected() throws RemoteException {
                zzkw.zzVo.b("onDisconnected", new Object[0]);
                zzkw.this.zznl();
                zzb.this.zzb((zzb) new b(Status.f979a));
            }

            @Override // com.google.android.gms.internal.zzkw.a, com.google.android.gms.internal.zzky
            public void onError(int i) throws RemoteException {
                zzkw.zzVo.b("onError: %d", Integer.valueOf(i));
                zzkw.this.zznl();
                zzb.this.zzb((zzb) new b(Status.c));
            }
        }

        public zzb(GoogleApiClient googleApiClient) {
            super(zzkw.this.zzZM, googleApiClient);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzlc
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public CastRemoteDisplay.CastRemoteDisplaySessionResult zzb(Status status) {
            return new b(status);
        }
    }

    public zzkw(Api.zzc<zzkx> zzcVar) {
        this.zzZM = zzcVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zznl() {
        if (this.zzZN != null) {
            if (this.zzZN.getDisplay() != null) {
                zzVo.b("releasing virtual display: " + this.zzZN.getDisplay().getDisplayId(), new Object[0]);
            }
            this.zzZN.release();
            this.zzZN = null;
        }
    }

    public PendingResult<CastRemoteDisplay.CastRemoteDisplaySessionResult> startRemoteDisplay(GoogleApiClient googleApiClient, String str) {
        zzVo.b("startRemoteDisplay", new Object[0]);
        return googleApiClient.zzb(new fi(this, googleApiClient, str));
    }

    public PendingResult<CastRemoteDisplay.CastRemoteDisplaySessionResult> stopRemoteDisplay(GoogleApiClient googleApiClient) {
        zzVo.b("stopRemoteDisplay", new Object[0]);
        return googleApiClient.zzb(new fj(this, googleApiClient));
    }
}
