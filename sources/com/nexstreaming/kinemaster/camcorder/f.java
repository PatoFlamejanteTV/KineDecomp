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
class f implements AdapterView.OnItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ e f3270a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.f3270a = eVar;
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
        int b;
        int c;
        Camera camera;
        t tVar;
        int b2;
        int c2;
        Camera camera2;
        z = this.f3270a.f3269a.g;
        if (!z) {
            camcorderProfileArr = this.f3270a.f3269a.L;
            i2 = this.f3270a.f3269a.k;
            list = this.f3270a.f3269a.K;
            camcorderProfileArr[i2] = (CamcorderProfile) list.get(i);
            SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(this.f3270a.f3269a).edit();
            StringBuilder append = new StringBuilder().append("CAMCORDER_SEL_PROFILE_");
            i3 = this.f3270a.f3269a.k;
            String sb = append.append(i3).toString();
            camcorderProfileArr2 = this.f3270a.f3269a.L;
            i4 = this.f3270a.f3269a.k;
            edit.putInt(sb, camcorderProfileArr2[i4].quality).apply();
            textView = this.f3270a.f3269a.m;
            StringBuilder sb2 = new StringBuilder();
            b = this.f3270a.f3269a.b();
            StringBuilder append2 = sb2.append(b).append(" x ");
            c = this.f3270a.f3269a.c();
            textView.setText(append2.append(c).toString());
            camera = this.f3270a.f3269a.f3262a;
            if (camera != null) {
                camera2 = this.f3270a.f3269a.f3262a;
                camera2.stopPreview();
            }
            tVar = this.f3270a.f3269a.b;
            b2 = this.f3270a.f3269a.b();
            c2 = this.f3270a.f3269a.c();
            tVar.setAspectRatio(b2 / c2);
            this.f3270a.f3269a.j();
            this.f3270a.f3269a.i();
            this.f3270a.f3269a.a();
        }
    }
}
