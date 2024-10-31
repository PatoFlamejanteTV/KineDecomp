package com.nexstreaming.kinemaster.ui.settings;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.nexstreaming.app.kinemasterfree.R;

/* compiled from: KineLegalInfoFragment.java */
/* loaded from: classes.dex */
public class u extends Fragment {
    public static u a() {
        u uVar = new u();
        uVar.setArguments(new Bundle());
        return uVar;
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_legal_info, viewGroup, false);
        com.nexstreaming.app.general.util.w.a(R.raw.legal, (TextView) inflate.findViewById(R.id.legalInfoText));
        return inflate;
    }
}
