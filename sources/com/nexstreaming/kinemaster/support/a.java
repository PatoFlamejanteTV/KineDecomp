package com.nexstreaming.kinemaster.support;

import android.app.Fragment;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.widget.TransparentTextButton;

/* compiled from: SupportInfoFragment.java */
/* loaded from: classes.dex */
public class a extends Fragment {

    /* renamed from: a, reason: collision with root package name */
    private View f3630a;

    public static a a() {
        a aVar = new a();
        aVar.setArguments(new Bundle());
        return aVar;
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f3630a = layoutInflater.inflate(R.layout.fragment_support_info, viewGroup, false);
        TransparentTextButton transparentTextButton = (TransparentTextButton) this.f3630a.findViewById(R.id.websiteButton);
        TransparentTextButton transparentTextButton2 = (TransparentTextButton) this.f3630a.findViewById(R.id.emailSupportButton);
        transparentTextButton.setOnClickListener(new b(this));
        transparentTextButton2.setOnClickListener(new c(this));
        if (Resources.getSystem().getConfiguration().locale.toString().startsWith("zh")) {
            this.f3630a.findViewById(R.id.kineIconView).setVisibility(8);
            ((ImageView) this.f3630a.findViewById(R.id.imageView)).setImageDrawable(getResources().getDrawable(R.drawable.support_logo_cn));
        } else {
            this.f3630a.findViewById(R.id.kineIconView).setVisibility(0);
            ((ImageView) this.f3630a.findViewById(R.id.imageView)).setImageDrawable(getResources().getDrawable(R.drawable.img_kinemaster_about_logo));
        }
        return this.f3630a;
    }
}
