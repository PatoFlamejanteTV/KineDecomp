package com.nexstreaming.kinemaster.ui.share;

import android.content.DialogInterface;
import android.content.Intent;
import com.nexstreaming.app.kinemasterfree.R;
import com.nextreaming.nexeditorui.NexExportProfile;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ExportAndShareActivity.java */
/* renamed from: com.nexstreaming.kinemaster.ui.share.k, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class DialogInterfaceOnClickListenerC2227k implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ExportAndShareActivity f23358a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DialogInterfaceOnClickListenerC2227k(ExportAndShareActivity exportAndShareActivity) {
        this.f23358a = exportAndShareActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        boolean z;
        NexExportProfile P;
        Intent intent;
        NexExportProfile P2;
        z = this.f23358a.ga;
        if (z) {
            intent = this.f23358a.fa;
            if (intent != null) {
                ExportAndShareActivity exportAndShareActivity = this.f23358a;
                P2 = exportAndShareActivity.P();
                exportAndShareActivity.a(P2, true, R.string.remove_watermark);
                dialogInterface.dismiss();
            }
        }
        if (!this.f23358a.C()) {
            this.f23358a.fa();
        } else {
            ExportAndShareActivity exportAndShareActivity2 = this.f23358a;
            P = exportAndShareActivity2.P();
            exportAndShareActivity2.d(P);
        }
        dialogInterface.dismiss();
    }
}
