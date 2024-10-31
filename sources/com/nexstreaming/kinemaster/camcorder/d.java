package com.nexstreaming.kinemaster.camcorder;

import android.content.SharedPreferences;
import android.hardware.Camera;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;
import com.nexstreaming.app.kinemasterfree.R;
import java.util.List;

/* compiled from: CamcorderActivity.java */
/* loaded from: classes.dex */
class d implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ CamcorderActivity f19991a;

    public d(CamcorderActivity camcorderActivity) {
        this.f19991a = camcorderActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        int i;
        int i2;
        int i3;
        int i4;
        Camera c2;
        List list;
        ImageButton imageButton;
        boolean z2;
        v vVar;
        int u;
        int t;
        int i5;
        int i6;
        Camera c3;
        z = this.f19991a.f19975g;
        if (z) {
            return;
        }
        this.f19991a.y();
        i = this.f19991a.k;
        CamcorderActivity camcorderActivity = this.f19991a;
        i2 = camcorderActivity.k;
        i3 = this.f19991a.l;
        camcorderActivity.k = (i2 + 1) % i3;
        CamcorderActivity camcorderActivity2 = this.f19991a;
        i4 = camcorderActivity2.k;
        c2 = camcorderActivity2.c(i4);
        camcorderActivity2.f19969a = c2;
        this.f19991a.x();
        list = this.f19991a.M;
        if (list.size() < 1) {
            this.f19991a.y();
            Toast.makeText(this.f19991a, R.string.camera_no_support_res, 1).show();
            this.f19991a.k = i;
            CamcorderActivity camcorderActivity3 = this.f19991a;
            i6 = camcorderActivity3.k;
            c3 = camcorderActivity3.c(i6);
            camcorderActivity3.f19969a = c3;
            this.f19991a.x();
        }
        this.f19991a.v();
        imageButton = this.f19991a.f19973e;
        z2 = this.f19991a.t;
        imageButton.setVisibility(z2 ? 0 : 4);
        vVar = this.f19991a.f19970b;
        u = this.f19991a.u();
        t = this.f19991a.t();
        vVar.setAspectRatio(u / t);
        this.f19991a.B();
        this.f19991a.A();
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(this.f19991a).edit();
        i5 = this.f19991a.k;
        edit.putInt("CAMCORDER_SEL_CAMERA_INDEX", i5).apply();
    }
}
