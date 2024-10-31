package com.nexstreaming.kinemaster.ui.projectedit;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.Fa;
import com.nexstreaming.kinemaster.ui.widget.ChromaKeyGraphView;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: OptionChromaKeyTestFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.hc, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C1908hc extends Bg implements ChromaKeyGraphView.a {
    private ChromaKeyGraphView o;
    private NexTimelineItem.d p;
    private float[] l = new float[2];
    private float[] m = new float[2];
    private float[] n = new float[4];
    private boolean q = false;

    private boolean va() {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return false;
        }
        return PreferenceManager.getDefaultSharedPreferences(activity).getBoolean("km.chroma.showmask", false);
    }

    @Override // com.nexstreaming.kinemaster.ui.widget.ChromaKeyGraphView.a
    public void a(int i, float f2, float f3) {
        float[] fArr = this.l;
        fArr[i] = f2;
        float[] fArr2 = this.m;
        fArr2[i] = f3;
        float[] fArr3 = this.n;
        fArr3[0] = fArr[0];
        fArr3[1] = fArr2[0];
        fArr3[2] = fArr[1];
        fArr3[3] = fArr2[1];
        if (this.p != null && da() != null) {
            this.p.setChromaKeyBlend(this.n);
            da().n().execute();
        }
        this.q = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg
    public void na() {
        Fa.a Y = Y();
        if ((Y instanceof NexTimelineItem.d) && this.o != null) {
            this.p = (NexTimelineItem.d) Y;
            this.p.getChromaKeyBlend(this.n);
            float[] fArr = this.l;
            float[] fArr2 = this.n;
            fArr[0] = fArr2[0];
            float[] fArr3 = this.m;
            fArr3[0] = fArr2[1];
            fArr[1] = fArr2[2];
            fArr3[1] = fArr2[3];
            this.o.setChromaKeyDivisions(fArr);
            this.o.setChromaKeyStrengths(this.m);
            this.p.setChromaKeyMaskEnabled(va());
        }
        super.na();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        a(R.id.action_undo, 0, R.id.action_redo, 0);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.option_chrome_key_test_fragment, viewGroup, false);
        a(inflate);
        n(R.string.opt_chroma_key_details);
        f(true);
        this.o = (ChromaKeyGraphView) inflate.findViewById(R.id.chromaKeyGraphView);
        this.o.setOnChromaKeyGraphValueChangeListener(this);
        na();
        return inflate;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg, android.support.v4.app.Fragment
    public void onDestroyView() {
        this.o = null;
        super.onDestroyView();
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        NexTimelineItem.d dVar = this.p;
        if (dVar != null) {
            dVar.setChromaKeyMaskEnabled(false);
        }
        super.onPause();
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        NexTimelineItem.d dVar = this.p;
        if (dVar != null) {
            dVar.setChromaKeyMaskEnabled(va());
        }
        super.onResume();
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        if (this.q) {
            G();
            this.q = false;
        }
        super.onStop();
    }
}
