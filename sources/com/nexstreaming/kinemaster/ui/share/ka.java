package com.nexstreaming.kinemaster.ui.share;

import android.content.DialogInterface;
import com.nextreaming.nexeditorui.NexExportProfile;
import java.io.File;

/* compiled from: ShareBaseActivity.java */
/* loaded from: classes2.dex */
public class ka implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ File f23359a;

    /* renamed from: b */
    final /* synthetic */ NexExportProfile f23360b;

    /* renamed from: c */
    final /* synthetic */ na f23361c;

    public ka(na naVar, File file, NexExportProfile nexExportProfile) {
        this.f23361c = naVar;
        this.f23359a = file;
        this.f23360b = nexExportProfile;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f23361c.b(this.f23359a, this.f23360b.width(), this.f23360b.displayHeight());
    }
}
