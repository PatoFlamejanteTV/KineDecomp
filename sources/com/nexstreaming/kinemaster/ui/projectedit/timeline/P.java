package com.nexstreaming.kinemaster.ui.projectedit.timeline;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.Ea;
import com.nexstreaming.kinemaster.ui.projectedit.Xc;
import java.util.List;

/* compiled from: TrackOptionFragment.java */
/* loaded from: classes2.dex */
public class P extends Xc {
    private Ea C;

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc, com.nexstreaming.kinemaster.ui.projectedit.C1935kd.a
    public void a(int i, boolean z) {
        this.C.a(i, z, xa());
        ia();
        G();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc, com.nexstreaming.kinemaster.ui.projectedit.Bg
    public void na() {
        super.na();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg
    public void oa() {
        a(R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_delete, R.drawable.action_icon_delete);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        this.C = aa();
        na();
        return onCreateView;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc, com.nexstreaming.kinemaster.ui.projectedit.Bg, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg
    public void pa() {
        a(R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_multi_select, R.drawable.icon_multi_select_normal, R.id.action_delete, R.drawable.action_icon_delete);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc
    protected boolean r(int i) {
        if (i != R.id.opt_track_visibility) {
            return false;
        }
        a(i, !this.C.m());
        return true;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc
    protected boolean sa() {
        return true;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc
    protected int[] ua() {
        Ea ea = this.C;
        if (ea != null) {
            List<Integer> l = ea.l();
            int[] iArr = new int[l.size()];
            for (int i = 0; i < iArr.length; i++) {
                iArr[i] = l.get(i).intValue();
            }
            return iArr;
        }
        return new int[0];
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc
    protected String wa() {
        return null;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc
    protected boolean ya() {
        return true;
    }

    public static P a(Ea ea) {
        P p = new P();
        p.a((P) ea);
        return p;
    }
}
