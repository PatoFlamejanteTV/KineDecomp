package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.a.e;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectGalleryActivity.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectgallery.ya */
/* loaded from: classes2.dex */
public class DialogInterfaceOnClickListenerC2153ya implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SharedPreferences f23003a;

    /* renamed from: b */
    final /* synthetic */ ProjectGalleryActivity f23004b;

    public DialogInterfaceOnClickListenerC2153ya(ProjectGalleryActivity projectGalleryActivity, SharedPreferences sharedPreferences) {
        this.f23004b = projectGalleryActivity;
        this.f23003a = sharedPreferences;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        e.a aVar = new e.a(this.f23004b);
        aVar.e(R.string.rate_feedback_popup_title);
        aVar.c(R.string.rate_report_popup_msg);
        aVar.a(new DialogInterfaceOnCancelListenerC2151xa(this));
        aVar.a(R.string.button_close, new DialogInterfaceOnClickListenerC2149wa(this));
        aVar.c(R.string.button_feedback, new DialogInterfaceOnClickListenerC2147va(this));
        aVar.a().show();
    }
}
