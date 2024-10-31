package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import android.widget.ImageButton;
import com.nexstreaming.kinemaster.ui.projectedit.OptionCroppingFragment;

/* compiled from: OptionCroppingFragment.java */
/* loaded from: classes.dex */
class dm implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ OptionCroppingFragment f3847a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dm(OptionCroppingFragment optionCroppingFragment) {
        this.f3847a = optionCroppingFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ImageButton imageButton;
        View view2;
        ImageButton imageButton2;
        View view3;
        ImageButton imageButton3;
        imageButton = this.f3847a.c;
        if (imageButton.isSelected()) {
            view3 = this.f3847a.d;
            view3.setVisibility(8);
            imageButton3 = this.f3847a.c;
            imageButton3.setSelected(false);
            this.f3847a.a().setCropLink(false);
            this.f3847a.a(OptionCroppingFragment.EditMode.Start);
        } else {
            view2 = this.f3847a.d;
            view2.setVisibility(0);
            imageButton2 = this.f3847a.c;
            imageButton2.setSelected(true);
            this.f3847a.a().setCropLink(true);
            this.f3847a.a(OptionCroppingFragment.EditMode.Link);
        }
        this.f3847a.c();
        this.f3847a.A = true;
    }
}
