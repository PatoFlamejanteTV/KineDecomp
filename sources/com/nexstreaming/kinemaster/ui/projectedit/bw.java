package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.DialogInterface;
import com.nextreaming.nexeditorui.NexExportProfile;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaEditFragment.java */
/* loaded from: classes.dex */
public class bw implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ boolean f3804a;
    final /* synthetic */ File b;
    final /* synthetic */ NexExportProfile c;
    final /* synthetic */ boolean d;
    final /* synthetic */ bo e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(bo boVar, boolean z, File file, NexExportProfile nexExportProfile, boolean z2) {
        this.e = boVar;
        this.f3804a = z;
        this.b = file;
        this.c = nexExportProfile;
        this.d = z2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f3804a) {
            this.e.a(this.b.getAbsolutePath());
        } else {
            this.e.k(false);
            this.e.i(false);
            this.e.a(this.c, this.b, this.d);
        }
        dialogInterface.dismiss();
    }
}
