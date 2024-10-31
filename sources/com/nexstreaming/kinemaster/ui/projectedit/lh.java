package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.layer.TextLayer;
import com.nexstreaming.kinemaster.ui.projectedit.OptionMenuItem;
import com.nexstreaming.kinemaster.ui.projectedit.ep;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: TextAlignOptionMenuItem.java */
/* loaded from: classes.dex */
public class lh implements OptionMenuItem.b {

    /* renamed from: a */
    private TextLayer f4061a;

    @Override // com.nexstreaming.kinemaster.ui.projectedit.OptionMenuItem.b
    public View a(int i, View view, ViewGroup viewGroup, NexTimelineItem nexTimelineItem, OptionMenuItem optionMenuItem, ep.a aVar) {
        Context context = viewGroup.getContext();
        if (this.f4061a != nexTimelineItem && nexTimelineItem != null && (nexTimelineItem instanceof TextLayer)) {
            this.f4061a = (TextLayer) nexTimelineItem;
        }
        if (view == null) {
            view = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.text_align_btn, viewGroup, false);
            View findViewById = view.findViewById(R.id.textAlignLeft);
            View findViewById2 = view.findViewById(R.id.textAlignCenter);
            View findViewById3 = view.findViewById(R.id.textAlignRight);
            if (this.f4061a != null) {
                switch (AnonymousClass1.f4062a[this.f4061a.getTextAlign().ordinal()]) {
                    case 1:
                        findViewById.setSelected(true);
                        findViewById2.setSelected(false);
                        findViewById3.setSelected(false);
                        break;
                    case 2:
                        findViewById.setSelected(false);
                        findViewById2.setSelected(true);
                        findViewById3.setSelected(false);
                        break;
                    case 3:
                        findViewById.setSelected(false);
                        findViewById2.setSelected(false);
                        findViewById3.setSelected(true);
                        break;
                }
            }
            findViewById.setOnClickListener(new li(this, findViewById2, findViewById3, aVar, optionMenuItem));
            findViewById2.setOnClickListener(new lk(this, findViewById, findViewById3, aVar, optionMenuItem));
            findViewById3.setOnClickListener(new lm(this, findViewById, findViewById2, aVar, optionMenuItem));
        }
        return view;
    }

    /* compiled from: TextAlignOptionMenuItem.java */
    /* renamed from: com.nexstreaming.kinemaster.ui.projectedit.lh$1 */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a */
        static final /* synthetic */ int[] f4062a = new int[Layout.Alignment.values().length];

        static {
            try {
                f4062a[Layout.Alignment.ALIGN_NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f4062a[Layout.Alignment.ALIGN_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f4062a[Layout.Alignment.ALIGN_OPPOSITE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }
}
