package com.google.android.gms.drive.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.Process;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.ChangeListener;
import com.google.android.gms.drive.internal.zzam;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class zzu extends com.google.android.gms.common.internal.zzj<zzam> {

    /* renamed from: a, reason: collision with root package name */
    final GoogleApiClient.ConnectionCallbacks f1141a;
    final Map<DriveId, Map<ChangeListener, zzae>> b;
    final Map<com.google.android.gms.drive.events.zzc, zzae> c;
    final Map<DriveId, Map<com.google.android.gms.drive.events.zzi, zzae>> d;
    final Map<DriveId, Map<com.google.android.gms.drive.events.zzi, zzae>> e;
    private final String f;
    private final Bundle g;
    private final boolean h;
    private volatile DriveId i;
    private volatile DriveId j;
    private volatile boolean k;

    public zzu(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, Bundle bundle) {
        super(context, looper, 11, zzfVar, connectionCallbacks, onConnectionFailedListener);
        this.k = false;
        this.b = new HashMap();
        this.c = new HashMap();
        this.d = new HashMap();
        this.e = new HashMap();
        this.f = zzfVar.h();
        this.f1141a = connectionCallbacks;
        this.g = bundle;
        Intent intent = new Intent("com.google.android.gms.drive.events.HANDLE_EVENT");
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        switch (queryIntentServices.size()) {
            case 0:
                this.h = false;
                return;
            case 1:
                ServiceInfo serviceInfo = queryIntentServices.get(0).serviceInfo;
                if (!serviceInfo.exported) {
                    throw new IllegalStateException("Drive event service " + serviceInfo.name + " must be exported in AndroidManifest.xml");
                }
                this.h = true;
                return;
            default:
                throw new IllegalStateException("AndroidManifest.xml can only define one service that handles the " + intent.getAction() + " action");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzj
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public zzam zzW(IBinder iBinder) {
        return zzam.zza.a(iBinder);
    }

    boolean a() {
        return GooglePlayServicesUtil.a(getContext(), Process.myUid());
    }

    @Override // com.google.android.gms.common.internal.zzj, com.google.android.gms.common.api.Api.zzb
    public void disconnect() {
        if (isConnected()) {
            try {
                zzpc().a(new DisconnectRequest());
            } catch (RemoteException e) {
            }
        }
        super.disconnect();
        synchronized (this.b) {
            this.b.clear();
        }
        synchronized (this.c) {
            this.c.clear();
        }
        synchronized (this.d) {
            this.d.clear();
        }
        synchronized (this.e) {
            this.e.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzj
    public void zza(int i, IBinder iBinder, Bundle bundle, int i2) {
        if (bundle != null) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.i = (DriveId) bundle.getParcelable("com.google.android.gms.drive.root_id");
            this.j = (DriveId) bundle.getParcelable("com.google.android.gms.drive.appdata_id");
            this.k = true;
        }
        super.zza(i, iBinder, bundle, i2);
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzfK() {
        return "com.google.android.gms.drive.ApiService.START";
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzfL() {
        return "com.google.android.gms.drive.internal.IDriveService";
    }

    @Override // com.google.android.gms.common.internal.zzj, com.google.android.gms.common.api.Api.zzb
    public boolean zzlN() {
        return (getContext().getPackageName().equals(this.f) && a()) ? false : true;
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected Bundle zzly() {
        String packageName = getContext().getPackageName();
        com.google.android.gms.common.internal.zzx.a(packageName);
        com.google.android.gms.common.internal.zzx.a(!zzpa().f().isEmpty());
        Bundle bundle = new Bundle();
        if (!packageName.equals(this.f)) {
            bundle.putString("proxy_package_name", this.f);
        }
        bundle.putAll(this.g);
        return bundle;
    }

    @Override // com.google.android.gms.common.internal.zzj
    public boolean zzpe() {
        return true;
    }
}
