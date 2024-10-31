package com.nexstreaming.kinemaster.ui.projectedit.timeline;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.nexstreaming.app.general.iab.PurchaseType;
import com.nexstreaming.kinemaster.editorwrapper.Ea;
import com.nexstreaming.kinemaster.editorwrapper.Fa;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nextreaming.nexeditorui.NexPrimaryTimelineItem;
import com.nextreaming.nexeditorui.NexSecondaryTimelineItem;
import com.nextreaming.nexeditorui.NexTimeline;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UniformTimelineAdapter.java */
/* loaded from: classes2.dex */
public class T extends RecyclerView.Adapter<X> {

    /* renamed from: c, reason: collision with root package name */
    private static long f22629c = 1;

    /* renamed from: d, reason: collision with root package name */
    private NexTimeline f22630d;

    /* renamed from: e, reason: collision with root package name */
    private WeakReference<UniformTimelineView> f22631e;

    /* renamed from: g, reason: collision with root package name */
    private List<b> f22633g;

    /* renamed from: f, reason: collision with root package name */
    private a f22632f = new a();

    /* renamed from: h, reason: collision with root package name */
    private WeakHashMap<Fa, Long> f22634h = new WeakHashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: UniformTimelineAdapter.java */
    /* loaded from: classes2.dex */
    public static class a implements InterfaceC2028i {

        /* renamed from: a, reason: collision with root package name */
        int f22635a;

        /* renamed from: b, reason: collision with root package name */
        boolean f22636b;

        /* renamed from: c, reason: collision with root package name */
        c.e.a.a.f f22637c;

        /* renamed from: d, reason: collision with root package name */
        PurchaseType f22638d;

        /* renamed from: e, reason: collision with root package name */
        VideoEditor f22639e;

        private a() {
        }

        @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2028i
        public boolean a() {
            return this.f22636b;
        }

        @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2028i
        public int b() {
            return this.f22635a;
        }

        @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2028i
        public VideoEditor c() {
            return this.f22639e;
        }

        @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2028i
        public c.e.a.a.f d() {
            return this.f22637c;
        }

        void e() {
            this.f22635a = 0;
            this.f22636b = false;
            this.f22637c = null;
            this.f22638d = null;
            this.f22639e = null;
        }
    }

    /* compiled from: UniformTimelineAdapter.java */
    /* loaded from: classes2.dex */
    public interface b {
        void a(X x);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public T(NexTimeline nexTimeline, UniformTimelineView uniformTimelineView) {
        this.f22630d = nexTimeline;
        this.f22631e = new WeakReference<>(uniformTimelineView);
        setHasStableIds(true);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(X x, int i) {
        UniformTimelineView uniformTimelineView = this.f22631e.get();
        this.f22632f.e();
        if (uniformTimelineView != null) {
            this.f22632f.f22636b = uniformTimelineView.getSelectedItems().contains(getItem(i));
            this.f22632f.f22635a = uniformTimelineView.getEditingMode();
            this.f22632f.f22637c = uniformTimelineView.getImageWorker();
            this.f22632f.f22638d = uniformTimelineView.getPurchaseType();
            this.f22632f.f22639e = uniformTimelineView.getVideoEditor();
        }
        x.a(getItem(i), this.f22632f);
    }

    public void b(b bVar) {
        List<b> list = this.f22633g;
        if (list != null) {
            list.remove(bVar);
        }
    }

    public Fa getItem(int i) {
        int trackCount = this.f22630d.getTrackCount();
        int primaryItemCount = this.f22630d.getPrimaryItemCount();
        int secondaryItemCount = this.f22630d.getSecondaryItemCount();
        if (i < 0 || i >= secondaryItemCount + primaryItemCount + trackCount + trackCount + 2) {
            return null;
        }
        if (i == 0) {
            return C2035p.f22705a;
        }
        if (i == 1) {
            return C2036q.f22706a;
        }
        int i2 = i - 2;
        if (i2 < trackCount) {
            return this.f22630d.getTrackAtIndex(i2);
        }
        int i3 = trackCount * 2;
        if (i2 < i3) {
            return M.a(this.f22630d.getTrackAtIndex(i2 - trackCount));
        }
        if (i2 < primaryItemCount + i3) {
            int i4 = i2 - i3;
            int i5 = (primaryItemCount + 1) / 2;
            if (i4 < i5) {
                return this.f22630d.getPrimaryItem(i4 * 2);
            }
            return this.f22630d.getPrimaryItem(((i4 - i5) * 2) + 1);
        }
        return this.f22630d.getSecondaryItem((i2 - primaryItemCount) - i3);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f22630d.getPrimaryItemCount() + this.f22630d.getSecondaryItemCount() + (this.f22630d.getTrackCount() * 2) + 2;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        Fa item = getItem(i);
        Long l = this.f22634h.get(item);
        if (l == null) {
            long j = f22629c;
            f22629c = 1 + j;
            l = Long.valueOf(j);
            this.f22634h.put(item, l);
        }
        return l.longValue();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return getItem(i).getTimelineViewLayoutResource();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public X onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new X(LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onViewRecycled(X x) {
        List<b> list = this.f22633g;
        if (list == null) {
            return;
        }
        Iterator<b> it = list.iterator();
        while (it.hasNext()) {
            it.next().a(x);
        }
    }

    public int a(Fa fa) {
        int indexOfSecondaryItem;
        int trackCount;
        int i;
        if (fa instanceof C2035p) {
            return 0;
        }
        if (fa instanceof C2036q) {
            return 1;
        }
        if (fa instanceof Ea) {
            i = this.f22630d.getTrackIndexById(((Ea) fa).c());
        } else {
            if (fa instanceof M) {
                indexOfSecondaryItem = this.f22630d.getTrackIndexById(((M) fa).a().c());
                trackCount = this.f22630d.getTrackCount();
            } else {
                if (fa instanceof NexPrimaryTimelineItem) {
                    int indexOfPrimaryItem = this.f22630d.getIndexOfPrimaryItem((NexPrimaryTimelineItem) fa);
                    return (indexOfPrimaryItem % 2 != 0 ? (this.f22630d.getPrimaryItemCount() + 1) / 2 : 0) + (indexOfPrimaryItem / 2) + (this.f22630d.getTrackCount() * 2) + 2;
                }
                if (!(fa instanceof NexSecondaryTimelineItem)) {
                    return -1;
                }
                indexOfSecondaryItem = this.f22630d.getIndexOfSecondaryItem((NexSecondaryTimelineItem) fa) + this.f22630d.getPrimaryItemCount();
                trackCount = this.f22630d.getTrackCount() * 2;
            }
            i = indexOfSecondaryItem + trackCount;
        }
        return i + 2;
    }

    public void a(b bVar) {
        if (this.f22633g == null) {
            this.f22633g = new ArrayList();
        }
        if (this.f22633g.contains(bVar)) {
            return;
        }
        this.f22633g.add(bVar);
    }
}
