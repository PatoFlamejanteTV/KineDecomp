package com.nexstreaming.kinemaster.ui.share;

import android.content.DialogInterface;
import com.nextreaming.nexeditorui.NexExportProfile;
import java.io.File;

/* compiled from: ShareBaseActivity.java */
/* loaded from: classes2.dex */
public class la implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ File f23363a;

    /* renamed from: b */
    final /* synthetic */ NexExportProfile f23364b;

    /* renamed from: c */
    final /* synthetic */ na f23365c;

    public la(na naVar, File file, NexExportProfile nexExportProfile) {
        this.f23365c = naVar;
        this.f23363a = file;
        this.f23364b = nexExportProfile;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f23365c.a(this.f23363a, this.f23364b.width(), this.f23364b.height());
    }
}
