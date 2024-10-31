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

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ CamcorderActivity f3268a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(CamcorderActivity camcorderActivity) {
        this.f3268a = camcorderActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        int i;
        int i2;
        int i3;
        int i4;
        Camera a2;
        List list;
        ImageButton imageButton;
        boolean z2;
        t tVar;
        int b;
        int c;
        int i5;
        int i6;
        Camera a3;
        z = this.f3268a.g;
        if (!z) {
            this.f3268a.h();
            i = this.f3268a.k;
            CamcorderActivity camcorderActivity = this.f3268a;
            i2 = this.f3268a.k;
            i3 = this.f3268a.l;
            camcorderActivity.k = (i2 + 1) % i3;
            CamcorderActivity camcorderActivity2 = this.f3268a;
            CamcorderActivity camcorderActivity3 = this.f3268a;
            i4 = this.f3268a.k;
            a2 = camcorderActivity3.a(i4);
            camcorderActivity2.f3262a = a2;
            this.f3268a.d();
            list = this.f3268a.K;
            if (list.size() < 1) {
                this.f3268a.h();
                Toast.makeText(this.f3268a, R.string.camera_no_support_res, 1).show();
                this.f3268a.k = i;
                CamcorderActivity camcorderActivity4 = this.f3268a;
                CamcorderActivity camcorderActivity5 = this.f3268a;
                i6 = this.f3268a.k;
                a3 = camcorderActivity5.a(i6);
                camcorderActivity4.f3262a = a3;
                this.f3268a.d();
            }
            this.f3268a.j();
            imageButton = this.f3268a.e;
            z2 = this.f3268a.t;
            imageButton.setVisibility(z2 ? 0 : 4);
            tVar = this.f3268a.b;
            b = this.f3268a.b();
            c = this.f3268a.c();
            tVar.setAspectRatio(b / c);
            this.f3268a.i();
            this.f3268a.k();
            SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(this.f3268a).edit();
            i5 = this.f3268a.k;
            edit.putInt("CAMCORDER_SEL_CAMERA_INDEX", i5).apply();
        }
    }
}
