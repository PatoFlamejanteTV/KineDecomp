package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.help.HelpActivity;
import com.nexstreaming.kinemaster.ui.a.e;
import com.nexstreaming.kinemaster.ui.projectgallery.Lb;
import com.nexstreaming.kinemaster.ui.settings.SettingsActivity;
import com.nexstreaming.kinemaster.ui.store.controller.StoreActivity;
import com.nexstreaming.kinemaster.usage.analytics.KMEvents;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.StringTokenizer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectGalleryActivity.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectgallery.bb */
/* loaded from: classes2.dex */
public class ViewOnClickListenerC2098bb implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ Lb.a f22907a;

    /* renamed from: b */
    final /* synthetic */ RunnableC2104db f22908b;

    public ViewOnClickListenerC2098bb(RunnableC2104db runnableC2104db, Lb.a aVar) {
        this.f22908b = runnableC2104db;
        this.f22907a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        Runnable runnable;
        KMEvents.MAIN_TIP.logEvent(this.f22907a.f22859b);
        if (this.f22907a.c()) {
            Intent intent = new Intent(this.f22908b.f22914a, (Class<?>) HelpActivity.class);
            StringTokenizer stringTokenizer = new StringTokenizer(this.f22907a.f22860c, ":");
            ArrayList arrayList = new ArrayList();
            while (stringTokenizer.hasMoreTokens()) {
                arrayList.add(stringTokenizer.nextToken());
            }
            for (int i = 1; i < arrayList.size(); i++) {
                if (i == 1) {
                    intent.putExtra("DEPTH_FIRST", Integer.parseInt((String) arrayList.get(i)));
                } else if (i == 2) {
                    intent.putExtra("DEPTH_SECOND", Integer.parseInt((String) arrayList.get(i)));
                }
            }
            this.f22908b.f22914a.startActivity(intent);
            return;
        }
        if (this.f22907a.e()) {
            this.f22908b.f22914a.startActivity(new Intent(this.f22908b.f22914a, (Class<?>) SettingsActivity.class));
            return;
        }
        if (this.f22907a.b()) {
            Intent intent2 = new Intent(this.f22908b.f22914a, (Class<?>) StoreActivity.class);
            intent2.setData(Uri.parse(this.f22907a.f22860c));
            this.f22908b.f22914a.startActivity(intent2);
            return;
        }
        if (this.f22907a.f()) {
            Intent intent3 = new Intent("android.intent.action.VIEW", Uri.parse(this.f22907a.f22860c));
            intent3.setFlags(805306368);
            if (!c.d.b.m.i.f(this.f22908b.f22914a)) {
                e.a aVar = new e.a(this.f22908b.f22914a);
                aVar.c(R.string.theme_download_server_connection_error);
                aVar.a(R.string.button_cancel, new _a(this));
                aVar.c(R.string.retry, new Za(this, intent3));
                com.nexstreaming.kinemaster.ui.a.e a2 = aVar.a();
                this.f22908b.f22914a.Aa = new WeakReference(a2);
                a2.show();
                a2.setOnDismissListener(new DialogInterfaceOnDismissListenerC2095ab(this));
                view2 = this.f22908b.f22914a.ca;
                runnable = this.f22908b.f22914a.Ma;
                view2.removeCallbacks(runnable);
                return;
            }
            try {
                this.f22908b.f22914a.startActivity(intent3);
            } catch (ActivityNotFoundException e2) {
                e2.printStackTrace();
            }
        }
    }
}
