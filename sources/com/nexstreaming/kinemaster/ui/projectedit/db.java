package com.nexstreaming.kinemaster.ui.projectedit;

import android.app.Activity;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.widget.ChromaKeyGraphView;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: OptionChromaKeyTestFragment.java */
/* loaded from: classes.dex */
public class db extends kp implements ChromaKeyGraphView.a {
    private ChromaKeyGraphView d;
    private NexTimelineItem.c e;

    /* renamed from: a */
    private float[] f3836a = new float[2];
    private float[] b = new float[2];
    private float[] c = new float[4];
    private boolean f = false;

    private boolean c() {
        Activity activity = getActivity();
        if (activity == null) {
            return false;
        }
        return PreferenceManager.getDefaultSharedPreferences(activity).getBoolean("km.chroma.showmask", false);
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.option_chrome_key_test_fragment, viewGroup, false);
        b(inflate);
        f(R.string.opt_chroma_key_details);
        d(true);
        this.d = (ChromaKeyGraphView) inflate.findViewById(R.id.chromaKeyGraphView);
        this.d.setOnChromaKeyGraphValueChangeListener(this);
        f();
        return inflate;
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        this.d = null;
        super.onDestroyView();
    }

    @Override // android.app.Fragment
    public void onStop() {
        if (this.f) {
            d();
            this.f = false;
        }
        super.onPause();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.kp, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        a(R.id.action_undo, 0, R.id.action_redo, 0);
        super.onActivityCreated(bundle);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.kp
    public void f() {
        Object m = m();
        if ((m instanceof NexTimelineItem.c) && this.d != null) {
            this.e = (NexTimelineItem.c) m;
            this.e.getChromaKeyBlend(this.c);
            this.f3836a[0] = this.c[0];
            this.b[0] = this.c[1];
            this.f3836a[1] = this.c[2];
            this.b[1] = this.c[3];
            this.d.setChromaKeyDivisions(this.f3836a);
            this.d.setChromaKeyStrengths(this.b);
            this.e.setChromaKeyMaskEnabled(c());
        }
        super.f();
    }

    @Override // com.nexstreaming.kinemaster.ui.widget.ChromaKeyGraphView.a
    public void a(int i, float f, float f2) {
        this.f3836a[i] = f;
        this.b[i] = f2;
        this.c[0] = this.f3836a[0];
        this.c[1] = this.b[0];
        this.c[2] = this.f3836a[1];
        this.c[3] = this.b[1];
        if (this.e != null && o() != null) {
            this.e.setChromaKeyBlend(this.c);
            o().z().a();
        }
        this.f = true;
    }

    @Override // android.app.Fragment
    public void onPause() {
        if (this.e != null) {
            this.e.setChromaKeyMaskEnabled(false);
        }
        super.onPause();
    }

    @Override // android.app.Fragment
    public void onResume() {
        if (this.e != null) {
            this.e.setChromaKeyMaskEnabled(c());
        }
        super.onResume();
    }
}
