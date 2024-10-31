package c.d.b.j;

import android.content.Context;
import android.util.SparseBooleanArray;
import com.nexstreaming.kinemaster.editorwrapper.C1780za;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
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

    /* compiled from: AbstractThemeApplicator.java */
    /* renamed from: c.d.b.j.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0018a implements b {

        /* renamed from: a, reason: collision with root package name */
        private final List<String> f3817a;

        /* renamed from: b, reason: collision with root package name */
        private final int f3818b;

        /* renamed from: c, reason: collision with root package name */
        private final Context f3819c;

        /* renamed from: d, reason: collision with root package name */
        private final NexTimeline f3820d;

        /* renamed from: e, reason: collision with root package name */
        private SparseBooleanArray f3821e = new SparseBooleanArray();

        C0018a(List<String> list, Context context, NexTimeline nexTimeline) {
            this.f3817a = list;
            this.f3819c = context;
            this.f3820d = nexTimeline;
            this.f3818b = list == null ? 0 : list.size();
        }

        @Override // c.d.b.j.b
        public int a() {
            return this.f3818b;
        }

        @Override // c.d.b.j.b
        public Context getContext() {
            return this.f3819c;
        }

        @Override // c.d.b.j.b
        public NexTimeline getTimeline() {
            return this.f3820d;
        }

        @Override // c.d.b.j.b
        public String a(int i) {
            if (i < 0 || i >= this.f3818b) {
                return null;
            }
            String str = this.f3817a.get(i);
            if (str.trim().length() < 1) {
                return null;
            }
            return str;
        }

        @Override // c.d.b.j.b
        public void a(int i, boolean z) {
            this.f3821e.put(i, z);
        }
    }

    @Override // c.d.b.j.c
    public boolean a(Context context, C1780za c1780za, List<String> list) {
        int i;
        C0018a c0018a = new C0018a(list, context, c1780za.a());
        if (list == null) {
            Collections.emptyList();
        }
        NexTimeline a2 = c1780za.a();
        int primaryItemCount = a2.getPrimaryItemCount();
        int i2 = 0;
        boolean z = false;
        while (i2 < primaryItemCount) {
            NexPrimaryTimelineItem primaryItem = a2.getPrimaryItem(i2);
            if (primaryItem instanceof NexTransitionItem) {
                int i3 = i2 + 1;
                if (a(c0018a, (NexTransitionItem) primaryItem, i2 > 0 ? (NexVideoClipItem) a2.getPrimaryItem(i2 - 1) : null, i3 < primaryItemCount ? (NexVideoClipItem) a2.getPrimaryItem(i3) : null, (i2 - 1) / 2, (primaryItemCount - 1) / 2)) {
                    z = true;
                }
            }
            i2++;
        }
        for (int i4 = 0; i4 < primaryItemCount; i4++) {
            NexPrimaryTimelineItem primaryItem2 = a2.getPrimaryItem(i4);
            if ((primaryItem2 instanceof NexVideoClipItem) && a(c0018a, (NexVideoClipItem) primaryItem2, (i4 + 1) / 2, (primaryItemCount + 1) / 2)) {
                z = true;
            }
        }
        int secondaryItemCount = a2.getSecondaryItemCount();
        while (i < secondaryItemCount) {
            NexSecondaryTimelineItem secondaryItem = a2.getSecondaryItem(i);
            if (secondaryItem instanceof NexAudioClipItem) {
                i = a(c0018a, (NexAudioClipItem) secondaryItem) ? 0 : i + 1;
                z = true;
            } else if (secondaryItem instanceof NexLayerItem) {
                if (!a(c0018a, (NexLayerItem) secondaryItem)) {
                }
                z = true;
            }
        }
        if (a(c0018a, a2)) {
            return true;
        }
        return z;
    }

    protected abstract boolean a(b bVar, NexLayerItem nexLayerItem);

    protected abstract boolean a(b bVar, NexAudioClipItem nexAudioClipItem);

    protected abstract boolean a(b bVar, NexTimeline nexTimeline);

    protected abstract boolean a(b bVar, NexTransitionItem nexTransitionItem, NexVideoClipItem nexVideoClipItem, NexVideoClipItem nexVideoClipItem2, int i, int i2);

    protected abstract boolean a(b bVar, NexVideoClipItem nexVideoClipItem, int i, int i2);
}
