package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.usage.KMUsage;

/* compiled from: OptionPanelDefaultFragment.java */
/* loaded from: classes.dex */
class fo implements View.OnTouchListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ez f3905a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fo(ez ezVar) {
        this.f3905a = ezVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        View view2;
        if (this.f3905a.o().f() != null) {
            switch (motionEvent.getActionMasked()) {
                case 0:
                    if (this.f3905a.o().f().a().getPrimaryItemCount() < 1) {
                        this.f3905a.a(this.f3905a.getResources().getString(R.string.add_video_before_layer), 1);
                    } else {
                        this.f3905a.o().p();
                        view2 = this.f3905a.b;
                        LinearLayout linearLayout = (LinearLayout) view2.findViewById(R.id.layer_button_holder);
                        if (linearLayout.isSelected() || this.f3905a.c()) {
                            this.f3905a.j();
                        } else {
                            linearLayout.setSelected(true);
                            KMUsage.EditScreen_AddButton.logEvent("button", "layer");
                            this.f3905a.i();
                        }
                    }
                    break;
                default:
                    return false;
            }
        }
        return false;
    }
}
