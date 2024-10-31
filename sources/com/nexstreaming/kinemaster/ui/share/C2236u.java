package com.nexstreaming.kinemaster.ui.share;

import android.content.SharedPreferences;
import com.nexstreaming.kinemaster.ui.projectedit.Slider;
import com.nextreaming.nexeditorui.NexExportProfile;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ExportAndShareActivity.java */
/* renamed from: com.nexstreaming.kinemaster.ui.share.u, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C2236u implements Slider.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ExportAndShareActivity f23386a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2236u(ExportAndShareActivity exportAndShareActivity) {
        this.f23386a = exportAndShareActivity;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a(float f2) {
        NexExportProfile P;
        P = this.f23386a.P();
        this.f23386a.e(P);
        this.f23386a.h(P);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void b() {
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a() {
        NexExportProfile P;
        SharedPreferences sharedPreferences;
        P = this.f23386a.P();
        float a2 = P == null ? 0.0f : this.f23386a.a(P);
        sharedPreferences = this.f23386a.ia;
        sharedPreferences.edit().putFloat("export_user_custom_bitrate_percent", a2).apply();
    }
}
