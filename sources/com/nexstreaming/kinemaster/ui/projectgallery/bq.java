package com.nexstreaming.kinemaster.ui.projectgallery;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.help.HelpActivity;
import com.nexstreaming.kinemaster.ui.a.a;
import com.nexstreaming.kinemaster.ui.projectgallery.cx;
import com.nexstreaming.kinemaster.ui.settings.SettingsActivity;
import com.nexstreaming.kinemaster.usage.KMUsage;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.StringTokenizer;

/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes.dex */
class bq implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ cx.a f4170a;
    final /* synthetic */ bp b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(bp bpVar, cx.a aVar) {
        this.b = bpVar;
        this.f4170a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Activity D;
        Activity D2;
        View view2;
        Runnable runnable;
        if (this.f4170a.c()) {
            Intent intent = new Intent(this.b.f4169a, (Class<?>) HelpActivity.class);
            StringTokenizer stringTokenizer = new StringTokenizer(this.f4170a.c, ":");
            ArrayList arrayList = new ArrayList();
            while (stringTokenizer.hasMoreTokens()) {
                arrayList.add(stringTokenizer.nextToken());
            }
            int i = 0;
            for (int i2 = 1; i2 < arrayList.size(); i2++) {
                if (i2 == 1) {
                    intent.putExtra("DEPTH_FIRST", Integer.parseInt((String) arrayList.get(i2)));
                } else if (i2 == 2) {
                    i = Integer.parseInt((String) arrayList.get(i2));
                    intent.putExtra("DEPTH_SECOND", i);
                }
            }
            KMUsage.ProjectList_TipTapped.logEvent("link", "help:" + this.b.f4169a.getResources().getResourceName(i));
            this.b.f4169a.startActivity(intent);
            return;
        }
        if (this.f4170a.d()) {
            KMUsage.ProjectList_TipTapped.logEvent("link", "settings:");
            this.b.f4169a.startActivity(new Intent(this.b.f4169a, (Class<?>) SettingsActivity.class));
            return;
        }
        if (this.f4170a.b()) {
            Uri parse = Uri.parse(this.f4170a.c);
            Intent intent2 = new Intent("android.intent.action.VIEW", parse);
            intent2.setFlags(805306368);
            if (parse.getHost().equalsIgnoreCase("plus.google.com")) {
                intent2.setPackage("com.google.android.apps.plus");
                if (intent2.resolveActivity(this.b.f4169a.getPackageManager()) == null) {
                    intent2.setPackage(null);
                }
            }
            D = this.b.f4169a.D();
            if (!com.nexstreaming.kinemaster.h.a.c(D)) {
                D2 = this.b.f4169a.D();
                com.nexstreaming.kinemaster.ui.a.a a2 = new a.C0074a(D2).a(R.string.theme_download_server_connection_error).b(R.string.button_cancel, new bs(this)).a(R.string.retry, new br(this, intent2)).a();
                this.b.f4169a.J = new WeakReference(a2);
                a2.show();
                a2.setOnDismissListener(new bt(this));
                view2 = this.b.f4169a.L;
                runnable = this.b.f4169a.R;
                view2.removeCallbacks(runnable);
                return;
            }
            this.b.f4169a.startActivity(intent2);
        }
    }
}
