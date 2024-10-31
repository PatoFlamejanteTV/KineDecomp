package com.nexstreaming.kinemaster.ui.projectgallery;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.a.a;
import com.nexstreaming.kinemaster.usage.KMUsage;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes.dex */
public class ay implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SharedPreferences f4151a;
    final /* synthetic */ ProjectGalleryActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(ProjectGalleryActivity projectGalleryActivity, SharedPreferences sharedPreferences) {
        this.b = projectGalleryActivity;
        this.f4151a = sharedPreferences;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Activity D;
        KMUsage.Rate_Like_KM.logEvent("selection", "No");
        dialogInterface.dismiss();
        D = this.b.D();
        new a.C0074a(D).f(R.string.rate_feedback_popup_title).a(R.string.rate_report_popup_msg).a(new bb(this)).b(R.string.button_close, new ba(this)).a(R.string.button_feedback, new az(this)).a().show();
    }
}
