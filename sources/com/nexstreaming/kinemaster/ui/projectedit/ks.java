package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.nexstreaming.app.general.util.IconView;
import com.nexstreaming.app.kinemasterfree.R;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectEditingFragmentBase.java */
/* loaded from: classes.dex */
public class ks implements View.OnTouchListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ kp f4043a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ks(kp kpVar) {
        this.f4043a = kpVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        int color;
        WeakReference weakReference;
        z = this.f4043a.f;
        if (z) {
            switch (motionEvent.getActionMasked()) {
                case 0:
                    color = this.f4043a.getResources().getColor(R.color.km_red);
                    break;
                case 1:
                case 3:
                    color = this.f4043a.getResources().getColor(R.color.km_white);
                    break;
            }
            weakReference = this.f4043a.c;
            View view2 = (View) weakReference.get();
            if (view2 != null) {
                ((IconView) view2.findViewById(R.id.optmenu_back)).setIconColor(color);
                ((TextView) view2.findViewById(R.id.descTitle)).setTextColor(color);
                ((TextView) view2.findViewById(R.id.descTitleSm)).setTextColor(color);
                ((TextView) view2.findViewById(R.id.descSubtitleSm)).setTextColor(color);
            }
        }
        return false;
    }
}
