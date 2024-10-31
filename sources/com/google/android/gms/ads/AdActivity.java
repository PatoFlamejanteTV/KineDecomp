package com.google.android.gms.ads;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzfj;
import com.google.android.gms.internal.zzfk;

/* loaded from: classes.dex */
public class AdActivity extends Activity {

    /* renamed from: a, reason: collision with root package name */
    private zzfk f511a;

    private void a() {
        if (this.f511a != null) {
            try {
                this.f511a.zzaE();
            } catch (RemoteException e) {
                zzb.d("Could not forward setContentViewSet to ad overlay:", e);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        boolean z = true;
        try {
            if (this.f511a != null) {
                z = this.f511a.zzeF();
            }
        } catch (RemoteException e) {
            zzb.d("Could not forward onBackPressed to ad overlay:", e);
        }
        if (z) {
            super.onBackPressed();
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f511a = zzfj.zzb(this);
        if (this.f511a == null) {
            zzb.e("Could not create ad overlay.");
            finish();
            return;
        }
        try {
            this.f511a.onCreate(bundle);
        } catch (RemoteException e) {
            zzb.d("Could not forward onCreate to ad overlay:", e);
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        try {
            if (this.f511a != null) {
                this.f511a.onDestroy();
            }
        } catch (RemoteException e) {
            zzb.d("Could not forward onDestroy to ad overlay:", e);
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onPause() {
        try {
            if (this.f511a != null) {
                this.f511a.onPause();
            }
        } catch (RemoteException e) {
            zzb.d("Could not forward onPause to ad overlay:", e);
            finish();
        }
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        try {
            if (this.f511a != null) {
                this.f511a.onRestart();
            }
        } catch (RemoteException e) {
            zzb.d("Could not forward onRestart to ad overlay:", e);
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        try {
            if (this.f511a != null) {
                this.f511a.onResume();
            }
        } catch (RemoteException e) {
            zzb.d("Could not forward onResume to ad overlay:", e);
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        try {
            if (this.f511a != null) {
                this.f511a.onSaveInstanceState(bundle);
            }
        } catch (RemoteException e) {
            zzb.d("Could not forward onSaveInstanceState to ad overlay:", e);
            finish();
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        try {
            if (this.f511a != null) {
                this.f511a.onStart();
            }
        } catch (RemoteException e) {
            zzb.d("Could not forward onStart to ad overlay:", e);
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        try {
            if (this.f511a != null) {
                this.f511a.onStop();
            }
        } catch (RemoteException e) {
            zzb.d("Could not forward onStop to ad overlay:", e);
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
