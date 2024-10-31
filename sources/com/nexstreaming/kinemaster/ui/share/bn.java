package com.nexstreaming.kinemaster.ui.share;

import android.preference.PreferenceManager;
import android.widget.TextView;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.projectedit.Slider;
import com.nextreaming.nexeditorui.NexExportProfile;
import com.xiaomi.licensinglibrary.LicenseErrCode;

/* compiled from: ShareQualityActivity.java */
/* loaded from: classes.dex */
class bn implements Slider.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ NexExportProfile f4325a;
    final /* synthetic */ com.nexstreaming.kinemaster.project.f b;
    final /* synthetic */ TextView c;
    final /* synthetic */ TextView d;
    final /* synthetic */ bm e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(bm bmVar, NexExportProfile nexExportProfile, com.nexstreaming.kinemaster.project.f fVar, TextView textView, TextView textView2) {
        this.e = bmVar;
        this.f4325a = nexExportProfile;
        this.b = fVar;
        this.c = textView;
        this.d = textView2;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a(float f) {
        this.f4325a.setBitrate((int) f);
        this.c.setText(this.f4325a.width() + "×" + this.f4325a.displayHeight() + " / " + this.e.f4324a.getResources().getString(R.string.export_estimated_size, Integer.valueOf(Math.max(1, (((this.b.d() / LicenseErrCode.LICENSE_STATUS_NOT_LICENSED) * (this.f4325a.bitrate() / 1024)) / 1024) / 8))));
        this.d.setText(String.format("%.2f %s", Float.valueOf(this.f4325a.bitrate() / 1048576.0f), "Mbps"));
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a() {
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void b() {
        PreferenceManager.getDefaultSharedPreferences(this.e.f4324a).edit().putInt("export_" + this.f4325a.width() + "x" + this.f4325a.height() + "_bitrate", this.f4325a.bitrate()).apply();
    }
}
