package com.nexstreaming.kinemaster.f;

import android.content.Context;
import android.util.SparseBooleanArray;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.editorwrapper.ar;
import com.nexstreaming.kinemaster.kmpackage.EffectLibrary;
import com.nextreaming.nexeditorui.NexAudioClipItem;
import com.nextreaming.nexeditorui.NexPrimaryTimelineItem;
import com.nextreaming.nexeditorui.NexSecondaryTimelineItem;
import com.nextreaming.nexeditorui.NexTimeline;
import com.nextreaming.nexeditorui.NexTransitionItem;
import com.nextreaming.nexeditorui.NexVideoClipItem;
import java.util.Collections;
import java.util.List;

/* compiled from: AbstractThemeApplicator.java */
/* loaded from: classes.dex */
public abstract class a implements c {
    protected abstract boolean a(b bVar, NexLayerItem nexLayerItem);

    protected abstract boolean a(b bVar, NexAudioClipItem nexAudioClipItem);

    protected abstract boolean a(b bVar, NexTimeline nexTimeline);

    protected abstract boolean a(b bVar, NexTransitionItem nexTransitionItem, NexVideoClipItem nexVideoClipItem, NexVideoClipItem nexVideoClipItem2, int i, int i2);

    protected abstract boolean a(b bVar, NexVideoClipItem nexVideoClipItem, int i, int i2);

    /* compiled from: AbstractThemeApplicator.java */
    /* renamed from: com.nexstreaming.kinemaster.f.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0068a implements b {

        /* renamed from: a, reason: collision with root package name */
        private final List<String> f3383a;
        private final int b;
        private final EffectLibrary c;
        private final Context d;
        private final NexTimeline e;
        private SparseBooleanArray f = new SparseBooleanArray();

        C0068a(List<String> list, EffectLibrary effectLibrary, Context context, NexTimeline nexTimeline) {
            this.f3383a = list;
            this.c = effectLibrary;
            this.d = context;
            this.e = nexTimeline;
            this.b = list == null ? 0 : list.size();
        }

        @Override // com.nexstreaming.kinemaster.f.b
        public String a(int i) {
            if (i < 0 || i >= this.b) {
                return null;
            }
            String str = this.f3383a.get(i);
            if (str.trim().length() < 1) {
                return null;
            }
            return str;
        }

        @Override // com.nexstreaming.kinemaster.f.b
        public void a(int i, boolean z) {
            this.f.put(i, z);
        }

        @Override // com.nexstreaming.kinemaster.f.b
        public EffectLibrary a() {
            return this.c;
        }

        @Override // com.nexstreaming.kinemaster.f.b
        public NexTimeline b() {
            return this.e;
        }
    }

    @Override // com.nexstreaming.kinemaster.f.c
    public boolean a(Context context, ar arVar, List<String> list) {
        boolean z;
        boolean z2;
        C0068a c0068a = new C0068a(list, EffectLibrary.a(context), context, arVar.a());
        if (list == null) {
            Collections.emptyList();
        }
        boolean z3 = false;
        NexTimeline a2 = arVar.a();
        int primaryItemCount = a2.getPrimaryItemCount();
        int i = 0;
        while (i < primaryItemCount) {
            NexPrimaryTimelineItem primaryItem = a2.getPrimaryItem(i);
            if (primaryItem instanceof NexTransitionItem) {
                if (a(c0068a, (NexTransitionItem) primaryItem, i > 0 ? (NexVideoClipItem) a2.getPrimaryItem(i - 1) : null, i + 1 < primaryItemCount ? (NexVideoClipItem) a2.getPrimaryItem(i + 1) : null, (i - 1) / 2, (primaryItemCount - 1) / 2)) {
                    z2 = true;
                    i++;
                    z3 = z2;
                }
            }
            z2 = z3;
            i++;
            z3 = z2;
        }
        int i2 = 0;
        boolean z4 = z3;
        while (i2 < primaryItemCount) {
            NexPrimaryTimelineItem primaryItem2 = a2.getPrimaryItem(i2);
            boolean z5 = ((primaryItem2 instanceof NexVideoClipItem) && a(c0068a, (NexVideoClipItem) primaryItem2, (i2 + 1) / 2, (primaryItemCount + 1) / 2)) ? true : z4;
            i2++;
            z4 = z5;
        }
        int secondaryItemCount = a2.getSecondaryItemCount();
        int i3 = 0;
        while (i3 < secondaryItemCount) {
            NexSecondaryTimelineItem secondaryItem = a2.getSecondaryItem(i3);
            if (secondaryItem instanceof NexAudioClipItem) {
                if (a(c0068a, (NexAudioClipItem) secondaryItem)) {
                    z = true;
                }
                z = z4;
            } else {
                if ((secondaryItem instanceof NexLayerItem) && a(c0068a, (NexLayerItem) secondaryItem)) {
                    z = true;
                }
                z = z4;
            }
            i3++;
            z4 = z;
        }
        if (a(c0068a, a2)) {
            return true;
        }
        return z4;
    }
}
