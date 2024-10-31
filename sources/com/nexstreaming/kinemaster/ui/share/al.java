package com.nexstreaming.kinemaster.ui.share;

import android.content.DialogInterface;
import com.nextreaming.nexeditorui.NexExportProfile;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareBaseActivity.java */
/* loaded from: classes.dex */
public class al implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ File f4296a;
    final /* synthetic */ NexExportProfile b;
    final /* synthetic */ ad c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ad adVar, File file, NexExportProfile nexExportProfile) {
        this.c = adVar;
        this.f4296a = file;
        this.b = nexExportProfile;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.c.c(this.f4296a, this.b);
    }
}
