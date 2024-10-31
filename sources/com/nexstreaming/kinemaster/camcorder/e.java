package com.nexstreaming.kinemaster.camcorder;

import android.content.SharedPreferences;
import android.hardware.Camera;
import android.media.CamcorderProfile;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import java.util.List;

/* compiled from: CamcorderActivity.java */
/* loaded from: classes.dex */
class e implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ f f19992a;

    public e(f fVar) {
        this.f19992a = fVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        boolean z;
        CamcorderProfile[] camcorderProfileArr;
        int i2;
        List list;
        int i3;
        CamcorderProfile[] camcorderProfileArr2;
        int i4;
        TextView textView;
        int u;
        int t;
        Camera camera;
        v vVar;
        int u2;
        int t2;
        Camera camera2;
        z = this.f19992a.f19993a.f19975g;
        if (z) {
            return;
        }
        camcorderProfileArr = this.f19992a.f19993a.N;
        i2 = this.f19992a.f19993a.k;
        list = this.f19992a.f19993a.M;
        camcorderProfileArr[i2] = (CamcorderProfile) list.get(i);
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(this.f19992a.f19993a).edit();
        StringBuilder sb = new StringBuilder();
        sb.append("CAMCORDER_SEL_PROFILE_");
        i3 = this.f19992a.f19993a.k;
        sb.append(i3);
        String sb2 = sb.toString();
        camcorderProfileArr2 = this.f19992a.f19993a.N;
        i4 = this.f19992a.f19993a.k;
        edit.putInt(sb2, camcorderProfileArr2[i4].quality).apply();
        textView = this.f19992a.f19993a.m;
        StringBuilder sb3 = new StringBuilder();
        u = this.f19992a.f19993a.u();
        sb3.append(u);
        sb3.append(" x ");
        t = this.f19992a.f19993a.t();
        sb3.append(t);
        textView.setText(sb3.toString());
        camera = this.f19992a.f19993a.f19969a;
        if (camera != null) {
            camera2 = this.f19992a.f19993a.f19969a;
            camera2.stopPreview();
        }
        vVar = this.f19992a.f19993a.f19970b;
        u2 = this.f19992a.f19993a.u();
        t2 = this.f19992a.f19993a.t();
        vVar.setAspectRatio(u2 / t2);
        this.f19992a.f19993a.v();
        this.f19992a.f19993a.B();
        this.f19992a.f19993a.s();
    }
}
