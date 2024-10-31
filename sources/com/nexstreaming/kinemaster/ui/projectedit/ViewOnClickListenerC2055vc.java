package com.nexstreaming.kinemaster.ui.projectedit;

import android.graphics.Rect;
import android.view.View;
import android.widget.ImageButton;
import com.nexstreaming.kinemaster.ui.projectedit.OptionCroppingFragment;

/* compiled from: OptionCroppingFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.vc, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class ViewOnClickListenerC2055vc implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ OptionCroppingFragment f22739a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewOnClickListenerC2055vc(OptionCroppingFragment optionCroppingFragment) {
        this.f22739a = optionCroppingFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ImageButton imageButton;
        View view2;
        ImageButton imageButton2;
        OptionCroppingFragment.EditMode editMode;
        OptionCroppingFragment.EditMode editMode2;
        View view3;
        ImageButton imageButton3;
        imageButton = this.f22739a.n;
        if (imageButton.isSelected()) {
            view3 = this.f22739a.o;
            view3.setVisibility(8);
            imageButton3 = this.f22739a.n;
            imageButton3.setSelected(false);
            this.f22739a.sa().setCropLink(false);
        } else {
            view2 = this.f22739a.o;
            view2.setVisibility(0);
            imageButton2 = this.f22739a.n;
            imageButton2.setSelected(true);
            this.f22739a.sa().setCropLink(true);
            Rect rect = new Rect();
            editMode = this.f22739a.K;
            if (editMode == OptionCroppingFragment.EditMode.Start) {
                this.f22739a.sa().getStartPosition(rect);
                this.f22739a.sa().setEndPosition(rect);
            } else {
                this.f22739a.sa().getEndPosition(rect);
                this.f22739a.sa().setStartPosition(rect);
            }
        }
        OptionCroppingFragment optionCroppingFragment = this.f22739a;
        editMode2 = optionCroppingFragment.K;
        optionCroppingFragment.a(editMode2);
        this.f22739a.Aa();
        this.f22739a.L = true;
    }
}
