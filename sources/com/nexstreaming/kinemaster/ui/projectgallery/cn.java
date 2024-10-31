package com.nexstreaming.kinemaster.ui.projectgallery;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.a.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes.dex */
public class cn implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectGalleryActivity f4194a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cn(ProjectGalleryActivity projectGalleryActivity) {
        this.f4194a = projectGalleryActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Activity D;
        Activity D2;
        Uri parse = Uri.parse("https://support.kinemaster.com");
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setFlags(805306368);
        intent.setData(parse);
        D = this.f4194a.D();
        if (!com.nexstreaming.kinemaster.h.a.c(D)) {
            D2 = this.f4194a.D();
            new a.C0074a(D2).a(R.string.theme_download_server_connection_error).b(R.string.button_cancel, new cp(this)).a(R.string.retry, new co(this, intent)).a().show();
        } else {
            this.f4194a.startActivity(intent);
        }
    }
}
