package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.DialogInterface;
import com.nextreaming.nexeditorui.NexExportProfile;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaEditFragment.java */
/* loaded from: classes2.dex */
public class Fb implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ boolean f21839a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ File f21840b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ NexExportProfile f21841c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ boolean f21842d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ Mb f21843e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fb(Mb mb, boolean z, File file, NexExportProfile nexExportProfile, boolean z2) {
        this.f21843e = mb;
        this.f21839a = z;
        this.f21840b = file;
        this.f21841c = nexExportProfile;
        this.f21842d = z2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f21839a) {
            this.f21843e.h(this.f21840b.getAbsolutePath());
        } else {
            this.f21843e.j(false);
            this.f21843e.l(false);
            this.f21843e.a(this.f21841c, this.f21840b, this.f21842d);
        }
        dialogInterface.dismiss();
    }
}
