package com.nexstreaming.kinemaster.ui.projectedit.timeline;

import android.view.View;
import android.widget.ImageView;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.Ea;
import com.nexstreaming.kinemaster.editorwrapper.Fa;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: TimelineTrackHeader.java */
/* loaded from: classes2.dex */
public class M implements Fa {

    /* renamed from: a */
    private static WeakHashMap<Ea, M> f22599a = new WeakHashMap<>();

    /* renamed from: b */
    private final Ea f22600b;

    private M(Ea ea) {
        this.f22600b = ea;
    }

    public static M a(Ea ea) {
        M m = f22599a.get(ea);
        if (m != null) {
            return m;
        }
        M m2 = new M(ea);
        f22599a.put(ea, m2);
        return m2;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.Fa
    public void bindView(View view, InterfaceC2028i interfaceC2028i) {
        Set<Integer> k = this.f22600b.k();
        Iterator<Integer> it = k.iterator();
        ImageView imageView = (ImageView) view.findViewById(R.id.big_icon_view);
        View findViewById = view.findViewById(R.id.small_icon_holder);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.small_icon_1);
        ImageView imageView3 = (ImageView) view.findViewById(R.id.small_icon_2);
        boolean a2 = interfaceC2028i.a();
        if (k.size() == 2) {
            findViewById.setVisibility(0);
            imageView.setVisibility(8);
            imageView2.setSelected(a2);
            imageView3.setSelected(a2);
            imageView2.setImageResource(it.next().intValue());
            imageView3.setImageResource(it.next().intValue());
            return;
        }
        findViewById.setVisibility(8);
        imageView.setVisibility(0);
        imageView.setSelected(a2);
        if (k.size() >= 3) {
            imageView.setImageResource(R.drawable.track_header_layer_icon);
        } else if (k.size() > 0) {
            imageView.setImageResource(it.next().intValue());
        } else {
            imageView.setVisibility(8);
        }
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.Fa
    public int getTimelineViewLayoutResource() {
        return R.layout.timeline_track_header;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.InterfaceC1732b
    public boolean isDraggable() {
        return true;
    }

    public Ea a() {
        return this.f22600b;
    }
}
