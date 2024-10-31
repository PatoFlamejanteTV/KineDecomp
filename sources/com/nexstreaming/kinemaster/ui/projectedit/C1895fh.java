package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.layer.TextLayer;
import com.nexstreaming.kinemaster.ui.projectedit.C1935kd;
import com.nexstreaming.kinemaster.ui.projectedit.OptionMenuItem;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: TextAlignOptionMenuItem.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.fh, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C1895fh implements OptionMenuItem.b {

    /* renamed from: a, reason: collision with root package name */
    private TextLayer f22338a;

    @Override // com.nexstreaming.kinemaster.ui.projectedit.OptionMenuItem.b
    public View a(int i, View view, ViewGroup viewGroup, NexTimelineItem nexTimelineItem, OptionMenuItem optionMenuItem, C1935kd.a aVar) {
        Context context = viewGroup.getContext();
        if (this.f22338a != nexTimelineItem && nexTimelineItem != null && (nexTimelineItem instanceof TextLayer)) {
            this.f22338a = (TextLayer) nexTimelineItem;
        }
        if (view == null) {
            view = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.text_align_btn, viewGroup, false);
            View findViewById = view.findViewById(R.id.textAlignLeft);
            View findViewById2 = view.findViewById(R.id.textAlignCenter);
            View findViewById3 = view.findViewById(R.id.textAlignRight);
            TextLayer textLayer = this.f22338a;
            if (textLayer != null) {
                int i2 = C1886eh.f22330a[textLayer.getTextAlign().ordinal()];
                if (i2 == 1) {
                    findViewById.setSelected(true);
                    findViewById2.setSelected(false);
                    findViewById3.setSelected(false);
                } else if (i2 == 2) {
                    findViewById.setSelected(false);
                    findViewById2.setSelected(true);
                    findViewById3.setSelected(false);
                } else if (i2 == 3) {
                    findViewById.setSelected(false);
                    findViewById2.setSelected(false);
                    findViewById3.setSelected(true);
                }
            }
            findViewById.setOnClickListener(new _g(this, findViewById2, findViewById3, aVar, optionMenuItem));
            findViewById2.setOnClickListener(new ViewOnClickListenerC1859bh(this, findViewById, findViewById3, aVar, optionMenuItem));
            findViewById3.setOnClickListener(new ViewOnClickListenerC1877dh(this, findViewById, findViewById2, aVar, optionMenuItem));
        }
        return view;
    }
}
