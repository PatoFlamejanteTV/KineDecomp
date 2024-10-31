package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import android.widget.LinearLayout;
import com.facebook.internal.NativeProtocol;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.usage.KMUsage;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectEditActivity.java */
/* loaded from: classes.dex */
public class ij implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ LinearLayout f3980a;
    final /* synthetic */ WeakReference b;
    final /* synthetic */ int c;
    final /* synthetic */ ProjectEditActivity d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ij(ProjectEditActivity projectEditActivity, LinearLayout linearLayout, WeakReference weakReference, int i) {
        this.d = projectEditActivity;
        this.f3980a = linearLayout;
        this.b = weakReference;
        this.c = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f3980a.isEnabled()) {
            a aVar = this.b == null ? null : (a) this.b.get();
            if (this.c != R.id.action_play_pause) {
                KMUsage.EditScreen_ActionButton.logEvent(NativeProtocol.WEB_DIALOG_ACTION, this.d.getResources().getResourceEntryName(this.c));
            }
            if (!(aVar != null ? aVar.a(this.c) : false)) {
                this.d.a(this.c, aVar);
            }
        }
    }
}
