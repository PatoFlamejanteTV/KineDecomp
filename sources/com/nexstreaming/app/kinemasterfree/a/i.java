package com.nexstreaming.app.kinemasterfree.a;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.nexstreaming.app.kinemasterfree.R;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: ClipInfoPopupBinding.java */
/* loaded from: classes2.dex */
public abstract class i extends ViewDataBinding {
    public final TextView A;
    public final LinearLayout B;
    protected View.OnClickListener C;
    protected NexTimelineItem D;
    public final CardView y;
    public final TextView z;

    /* JADX INFO: Access modifiers changed from: protected */
    public i(Object obj, View view, int i, CardView cardView, TextView textView, TextView textView2, LinearLayout linearLayout) {
        super(obj, view, i);
        this.y = cardView;
        this.z = textView;
        this.A = textView2;
        this.B = linearLayout;
    }

    public static i a(LayoutInflater layoutInflater) {
        return a(layoutInflater, android.databinding.e.a());
    }

    public abstract void a(View.OnClickListener onClickListener);

    public abstract void a(NexTimelineItem nexTimelineItem);

    public NexTimelineItem h() {
        return this.D;
    }

    @Deprecated
    public static i a(LayoutInflater layoutInflater, Object obj) {
        return (i) ViewDataBinding.a(layoutInflater, R.layout.clip_info_popup, (ViewGroup) null, false, obj);
    }
}
