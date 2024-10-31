package com.nexstreaming.kinemaster.ui.b;

import android.view.MotionEvent;
import android.view.View;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.kmpackage.EffectLibrary;
import com.nexstreaming.kinemaster.kmpackage.Font;
import com.nexstreaming.kinemaster.kmpackage.au;
import com.nexstreaming.kinemaster.ui.projectedit.FullScreenInputActivity;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EffectSettingsFragment.java */
/* loaded from: classes.dex */
public class i implements View.OnTouchListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ au f3696a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ int d;
    final /* synthetic */ f e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(f fVar, au auVar, String str, String str2, int i) {
        this.e = fVar;
        this.f3696a = auVar;
        this.b = str;
        this.c = str2;
        this.d = i;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        NexTimelineItem.j jVar;
        NexTimelineItem.j jVar2;
        String str;
        String str2;
        EffectLibrary effectLibrary;
        NexTimelineItem.j jVar3;
        EffectLibrary effectLibrary2;
        int indexOf;
        switch (motionEvent.getActionMasked()) {
            case 0:
                view.setPressed(true);
                return true;
            case 1:
                jVar = this.e.r;
                if (jVar == null) {
                    return true;
                }
                this.e.s = new j(this);
                jVar2 = this.e.r;
                String str3 = jVar2.getEffectOptions().get(this.b);
                if (str3 == null || (indexOf = str3.indexOf(27)) <= -1) {
                    str = str3;
                    str2 = null;
                } else {
                    String substring = str3.substring(0, indexOf);
                    str = str3.substring(indexOf + 1);
                    str2 = substring;
                }
                effectLibrary = this.e.p;
                jVar3 = this.e.r;
                com.nexstreaming.kinemaster.kmpackage.b c = effectLibrary.c(jVar3.getEffectID());
                if (c != null) {
                    effectLibrary2 = this.e.p;
                    Font a2 = effectLibrary2.a(c);
                    if (a2 != null) {
                        a2.m();
                    }
                }
                this.e.startActivityForResult(FullScreenInputActivity.a(this.e.getActivity()).a(str).c(this.d > 1).c(c.a()).b(str2).b(true).a(), R.id.edit_fx_userfield_text);
                view.setPressed(false);
                view.setEnabled(false);
                return true;
            case 2:
                return true;
            case 3:
                view.setPressed(false);
                return true;
            default:
                return false;
        }
    }
}
