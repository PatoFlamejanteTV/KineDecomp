package com.google.android.gms.ads;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzaop;
import com.google.android.gms.internal.ads.zzbbd;
import com.google.android.gms.internal.ads.zzwu;

@KeepForSdkWithMembers
/* loaded from: classes.dex */
public class AdActivity extends Activity {

    /* renamed from: a, reason: collision with root package name */
    private zzaop f9924a;

    private final void a() {
        zzaop zzaopVar = this.f9924a;
        if (zzaopVar != null) {
            try {
                zzaopVar.zzay();
            } catch (RemoteException e2) {
                zzbbd.zzd("#007 Could not call remote method.", e2);
            }
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        try {
            this.f9924a.onActivityResult(i, i2, intent);
        } catch (Exception e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        boolean z = true;
        try {
            if (this.f9924a != null) {
                z = this.f9924a.zzvq();
            }
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
        }
        if (z) {
            super.onBackPressed();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        try {
            this.f9924a.zzq(ObjectWrapper.a(configuration));
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f9924a = zzwu.zzpw().zzb(this);
        zzaop zzaopVar = this.f9924a;
        if (zzaopVar == null) {
            zzbbd.zzd("#007 Could not call remote method.", null);
            finish();
            return;
        }
        try {
            zzaopVar.onCreate(bundle);
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        try {
            if (this.f9924a != null) {
                this.f9924a.onDestroy();
            }
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onPause() {
        try {
            if (this.f9924a != null) {
                this.f9924a.onPause();
            }
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
            finish();
        }
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        try {
            if (this.f9924a != null) {
                this.f9924a.onRestart();
            }
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        try {
            if (this.f9924a != null) {
                this.f9924a.onResume();
            }
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        try {
            if (this.f9924a != null) {
                this.f9924a.onSaveInstanceState(bundle);
            }
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
            finish();
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        try {
            if (this.f9924a != null) {
                this.f9924a.onStart();
            }
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        try {
            if (this.f9924a != null) {
                this.f9924a.onStop();
            }
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
            finish();
        }
        super.onStop();
    }

    @Override // android.app.Activity
    public void setContentView(int i) {
        super.setContentView(i);
        a();
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        super.setContentView(view);
        a();
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        a();
    }
}
