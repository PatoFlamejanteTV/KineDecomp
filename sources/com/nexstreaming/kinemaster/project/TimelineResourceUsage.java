package com.nexstreaming.kinemaster.project;

import android.support.v7.widget.ActivityChooserView;
import com.nexstreaming.app.general.util.C1711o;
import com.nexstreaming.app.general.util.q;
import com.nexstreaming.kinemaster.codeccaps.CapabilityManager;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.layer.VideoLayer;
import com.nexstreaming.kinemaster.mediastore.MediaSupportType;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.NexAudioClipItem;
import com.nextreaming.nexeditorui.NexEditorDeviceProfile;
import com.nextreaming.nexeditorui.NexPrimaryTimelineItem;
import com.nextreaming.nexeditorui.NexSecondaryTimelineItem;
import com.nextreaming.nexeditorui.NexTimeline;
import com.nextreaming.nexeditorui.NexTimelineItem;
import com.nextreaming.nexeditorui.NexTransitionItem;
import com.nextreaming.nexeditorui.NexVideoClipItem;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public class TimelineResourceUsage {

    /* renamed from: a, reason: collision with root package name */
    private static final b f21159a = new a();

    /* renamed from: b, reason: collision with root package name */
    private static Deque<List<NexSecondaryTimelineItem>> f21160b = new ArrayDeque();

    /* renamed from: c, reason: collision with root package name */
    private final b[] f21161c;

    /* renamed from: d, reason: collision with root package name */
    private final List<? extends b> f21162d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f21163e;

    /* renamed from: f, reason: collision with root package name */
    private final b f21164f;

    /* renamed from: g, reason: collision with root package name */
    private final b f21165g;

    /* loaded from: classes.dex */
    public enum Limit {
        AudioTrackCount,
        VideoLayerCount,
        DecoderMemoryUsage,
        UnsupportedContent,
        ContentPreviewWeight,
        ExportCodecMemoryUsage
    }

    /* loaded from: classes.dex */
    private static class a implements b {
        private a() {
        }

        @Override // com.nexstreaming.kinemaster.project.TimelineResourceUsage.b
        public int a() {
            return 0;
        }

        @Override // com.nexstreaming.kinemaster.project.TimelineResourceUsage.b
        public boolean a(Limit limit) {
            return false;
        }

        @Override // com.nexstreaming.kinemaster.project.TimelineResourceUsage.b
        public int b() {
            return 0;
        }

        @Override // com.nexstreaming.kinemaster.project.TimelineResourceUsage.b
        public int c() {
            return 0;
        }

        @Override // com.nexstreaming.kinemaster.project.TimelineResourceUsage.b
        public int d() {
            return 0;
        }

        @Override // com.nexstreaming.kinemaster.project.TimelineResourceUsage.b
        public boolean e() {
            return false;
        }

        @Override // com.nexstreaming.kinemaster.project.TimelineResourceUsage.b
        public Set<Limit> f() {
            return Collections.emptySet();
        }

        @Override // com.nexstreaming.kinemaster.project.TimelineResourceUsage.b
        public int g() {
            return 0;
        }

        @Override // com.nexstreaming.kinemaster.project.TimelineResourceUsage.b
        public int h() {
            return 0;
        }

        @Override // com.nexstreaming.kinemaster.project.TimelineResourceUsage.b
        public int i() {
            return 0;
        }

        @Override // com.nexstreaming.kinemaster.project.TimelineResourceUsage.b
        public boolean j() {
            return false;
        }

        @Override // com.nexstreaming.kinemaster.project.TimelineResourceUsage.b
        public int k() {
            return 0;
        }

        @Override // com.nexstreaming.kinemaster.project.TimelineResourceUsage.b
        public int l() {
            return 0;
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        int a();

        boolean a(Limit limit);

        int b();

        int c();

        int d();

        boolean e();

        Set<Limit> f();

        int g();

        int h();

        int i();

        boolean j();

        int k();

        int l();
    }

    /* loaded from: classes.dex */
    private static class c implements b {

        /* renamed from: a, reason: collision with root package name */
        private final int f21166a;

        /* renamed from: b, reason: collision with root package name */
        private final int f21167b;

        /* renamed from: c, reason: collision with root package name */
        private final int f21168c;

        /* renamed from: d, reason: collision with root package name */
        private final int f21169d;

        /* renamed from: e, reason: collision with root package name */
        private final int f21170e;

        /* renamed from: f, reason: collision with root package name */
        private final int f21171f;

        /* renamed from: g, reason: collision with root package name */
        private final int f21172g;

        /* renamed from: h, reason: collision with root package name */
        private final int f21173h;
        private final int i;
        private final boolean j;
        private final Set<Limit> k;
        private final int l;

        @Override // com.nexstreaming.kinemaster.project.TimelineResourceUsage.b
        public int a() {
            return this.f21168c;
        }

        @Override // com.nexstreaming.kinemaster.project.TimelineResourceUsage.b
        public int b() {
            return this.f21170e;
        }

        @Override // com.nexstreaming.kinemaster.project.TimelineResourceUsage.b
        public int c() {
            return this.f21173h;
        }

        @Override // com.nexstreaming.kinemaster.project.TimelineResourceUsage.b
        public int d() {
            return this.i;
        }

        @Override // com.nexstreaming.kinemaster.project.TimelineResourceUsage.b
        public boolean e() {
            return !this.k.isEmpty();
        }

        @Override // com.nexstreaming.kinemaster.project.TimelineResourceUsage.b
        public Set<Limit> f() {
            return this.k;
        }

        @Override // com.nexstreaming.kinemaster.project.TimelineResourceUsage.b
        public int g() {
            return this.l;
        }

        @Override // com.nexstreaming.kinemaster.project.TimelineResourceUsage.b
        public int h() {
            return this.f21166a;
        }

        @Override // com.nexstreaming.kinemaster.project.TimelineResourceUsage.b
        public int i() {
            return this.f21169d;
        }

        @Override // com.nexstreaming.kinemaster.project.TimelineResourceUsage.b
        public boolean j() {
            return this.j;
        }

        @Override // com.nexstreaming.kinemaster.project.TimelineResourceUsage.b
        public int k() {
            return this.f21167b;
        }

        @Override // com.nexstreaming.kinemaster.project.TimelineResourceUsage.b
        public int l() {
            return this.f21172g;
        }

        private c(NexTimeline nexTimeline, int i, int i2, NexTimelineItem nexTimelineItem) {
            c cVar;
            int i3;
            int i4;
            int i5;
            int i6;
            NexTimeline nexTimeline2 = nexTimeline;
            this.f21166a = i;
            this.f21167b = i2;
            NexEditorDeviceProfile deviceProfile = NexEditorDeviceProfile.getDeviceProfile();
            int maxAudioTrackCount = deviceProfile.getMaxAudioTrackCount();
            int hardwareDecMaxCount = deviceProfile.allowOverlappingVideo() ? deviceProfile.getHardwareDecMaxCount() - 2 : 0;
            List a2 = TimelineResourceUsage.a();
            List a3 = TimelineResourceUsage.a();
            List a4 = TimelineResourceUsage.a();
            EnumSet noneOf = EnumSet.noneOf(Limit.class);
            int secondaryItemCount = nexTimeline.getSecondaryItemCount();
            e eVar = new e();
            eVar.f21182a = nexTimeline.getPrimaryItemCount();
            int i7 = 0;
            boolean z = false;
            while (i7 < eVar.f21182a) {
                NexPrimaryTimelineItem primaryItem = nexTimeline2.getPrimaryItem(i7);
                int absEndTime = primaryItem.getAbsEndTime();
                int absStartTime = primaryItem.getAbsStartTime();
                NexEditorDeviceProfile nexEditorDeviceProfile = deviceProfile;
                if (primaryItem instanceof NexVideoClipItem) {
                    i6 = maxAudioTrackCount;
                    absStartTime = Math.max(0, absStartTime - 100);
                } else {
                    i6 = maxAudioTrackCount;
                }
                int i8 = absStartTime;
                if (primaryItem != nexTimelineItem && absEndTime >= i && i8 < i2) {
                    if (primaryItem instanceof NexTransitionItem) {
                        z = true;
                    } else {
                        eVar.f21183b += primaryItem.getAudioTrackUsage();
                        eVar.f21184c += primaryItem.getVideoTrackUsage();
                        eVar.f21185d += primaryItem.getVideoCodecLegacyMemoryUsage();
                        eVar.f21187f += primaryItem.getVideoCodecExportMemoryUsage();
                        eVar.f21186e += primaryItem.getContentWeight();
                    }
                }
                i7++;
                deviceProfile = nexEditorDeviceProfile;
                maxAudioTrackCount = i6;
            }
            NexEditorDeviceProfile nexEditorDeviceProfile2 = deviceProfile;
            int i9 = maxAudioTrackCount;
            e eVar2 = new e();
            int totalTime = nexTimeline.getTotalTime();
            int i10 = 0;
            int i11 = 0;
            while (i10 < secondaryItemCount) {
                NexSecondaryTimelineItem secondaryItem = nexTimeline2.getSecondaryItem(i10);
                int absStartTime2 = secondaryItem.getAbsStartTime();
                if (absStartTime2 >= totalTime) {
                    i4 = totalTime;
                    i5 = secondaryItemCount;
                } else {
                    i4 = totalTime;
                    boolean z2 = secondaryItem instanceof VideoLayer;
                    if (z2) {
                        i5 = secondaryItemCount;
                        absStartTime2 = Math.max(0, absStartTime2 - 100);
                    } else {
                        i5 = secondaryItemCount;
                    }
                    if (secondaryItem != nexTimelineItem && secondaryItem.getAbsEndTime() > i && absStartTime2 < i2 && !secondaryItem.getOverLimit()) {
                        MediaSupportType mediaSupportType = secondaryItem.getMediaSupportType();
                        if (mediaSupportType.isNotSupported()) {
                            noneOf.add(Limit.UnsupportedContent);
                            secondaryItem.setOverLimit(true);
                        } else if (mediaSupportType.needsTranscode()) {
                            noneOf.add(Limit.UnsupportedContent);
                            secondaryItem.setOverLimit(true);
                        } else {
                            eVar2.f21183b += secondaryItem.getAudioTrackUsage();
                            eVar2.f21184c += secondaryItem.getVideoTrackUsage();
                            eVar2.f21185d += secondaryItem.getVideoCodecLegacyMemoryUsage();
                            eVar2.f21187f += secondaryItem.getVideoCodecExportMemoryUsage();
                            eVar2.f21186e += secondaryItem.getContentWeight();
                            if (secondaryItem.getAudioTrackUsage() > 0) {
                                a4.add(secondaryItem);
                            }
                        }
                        if (secondaryItem instanceof NexAudioClipItem) {
                            a3.add(secondaryItem);
                        } else if (z2) {
                            a2.add(secondaryItem);
                        } else if (secondaryItem instanceof NexLayerItem) {
                            i11++;
                        }
                    }
                }
                i10++;
                nexTimeline2 = nexTimeline;
                totalTime = i4;
                secondaryItemCount = i5;
            }
            int i12 = secondaryItemCount;
            Collections.sort(a2);
            Collections.sort(a3);
            e eVar3 = new e(eVar, eVar2);
            while (a2.size() > hardwareDecMaxCount) {
                noneOf.add(Limit.VideoLayerCount);
                NexSecondaryTimelineItem nexSecondaryTimelineItem = (NexSecondaryTimelineItem) a2.remove(a2.size() - 1);
                if (!nexSecondaryTimelineItem.getOverLimit()) {
                    eVar2.f21183b -= nexSecondaryTimelineItem.getAudioTrackUsage();
                    eVar3.f21186e -= nexSecondaryTimelineItem.getContentWeight();
                    eVar2.f21186e -= nexSecondaryTimelineItem.getContentWeight();
                    eVar3.f21187f -= nexSecondaryTimelineItem.getVideoCodecExportMemoryUsage();
                    eVar2.f21187f -= nexSecondaryTimelineItem.getVideoCodecExportMemoryUsage();
                    nexSecondaryTimelineItem.setOverLimit(true);
                }
            }
            while (true) {
                int i13 = i9;
                if (eVar2.f21183b <= i13) {
                    break;
                }
                noneOf.add(Limit.AudioTrackCount);
                NexSecondaryTimelineItem nexSecondaryTimelineItem2 = (NexSecondaryTimelineItem) a4.remove(a4.size() - 1);
                if (!nexSecondaryTimelineItem2.getOverLimit()) {
                    eVar2.f21183b -= nexSecondaryTimelineItem2.getAudioTrackUsage();
                    eVar3.f21186e -= nexSecondaryTimelineItem2.getContentWeight();
                    eVar2.f21186e -= nexSecondaryTimelineItem2.getContentWeight();
                    eVar3.f21187f -= nexSecondaryTimelineItem2.getVideoCodecExportMemoryUsage();
                    eVar2.f21187f -= nexSecondaryTimelineItem2.getVideoCodecExportMemoryUsage();
                    nexSecondaryTimelineItem2.setOverLimit(true);
                }
                i9 = i13;
            }
            if (CapabilityManager.f20040b.t()) {
                int maxCodecMemSizeForVideoLayers = nexEditorDeviceProfile2.getMaxCodecMemSizeForVideoLayers() - nexEditorDeviceProfile2.getMaxEncoderMemorySize(EditorGlobal.i().b());
                int i14 = maxCodecMemSizeForVideoLayers - eVar.f21185d;
                if (maxCodecMemSizeForVideoLayers - eVar3.f21185d < 0) {
                    noneOf.add(Limit.DecoderMemoryUsage);
                    ArrayList<NexSecondaryTimelineItem> arrayList = new ArrayList();
                    int i15 = i12;
                    int i16 = 0;
                    while (i16 < i15) {
                        NexSecondaryTimelineItem secondaryItem2 = nexTimeline.getSecondaryItem(i16);
                        int absStartTime3 = secondaryItem2.getAbsStartTime();
                        int i17 = i14;
                        boolean z3 = secondaryItem2 instanceof VideoLayer;
                        if (z3) {
                            i3 = i15;
                            absStartTime3 = Math.max(0, absStartTime3 - 100);
                        } else {
                            i3 = i15;
                        }
                        int i18 = absStartTime3;
                        if (secondaryItem2 != nexTimelineItem && secondaryItem2.getAbsEndTime() > i && i18 < i2 && !secondaryItem2.getOverLimit() && z3) {
                            arrayList.add((VideoLayer) secondaryItem2);
                        }
                        i16++;
                        i14 = i17;
                        i15 = i3;
                    }
                    int i19 = i14;
                    Collections.sort(arrayList);
                    for (NexSecondaryTimelineItem nexSecondaryTimelineItem3 : arrayList) {
                        if ((nexSecondaryTimelineItem3 instanceof VideoLayer) && (i19 = i19 - nexSecondaryTimelineItem3.getVideoCodecLegacyMemoryUsage()) < 0) {
                            nexSecondaryTimelineItem3.setOverLimit(true);
                            eVar3.f21185d -= nexSecondaryTimelineItem3.getVideoCodecLegacyMemoryUsage();
                        }
                    }
                }
                cVar = this;
                cVar.l = maxCodecMemSizeForVideoLayers - eVar3.f21185d;
            } else {
                cVar = this;
                int q = CapabilityManager.f20040b.q();
                boolean w = EditorGlobal.w();
                int i20 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                q = w ? ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : q;
                while (eVar3.f21186e > q && !a2.isEmpty()) {
                    noneOf.add(Limit.ContentPreviewWeight);
                    VideoLayer videoLayer = (VideoLayer) a2.remove(a2.size() - 1);
                    if (!videoLayer.getOverLimit()) {
                        videoLayer.setOverLimit(true);
                        eVar2.f21183b -= videoLayer.getAudioTrackUsage();
                        eVar3.f21186e -= videoLayer.getContentWeight();
                        eVar2.f21186e -= videoLayer.getContentWeight();
                        eVar3.f21187f -= videoLayer.getVideoCodecExportMemoryUsage();
                        eVar2.f21187f -= videoLayer.getVideoCodecExportMemoryUsage();
                    }
                }
                int n = CapabilityManager.f20040b.n();
                int o = CapabilityManager.f20040b.o();
                if (EditorGlobal.w()) {
                    o = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                } else {
                    i20 = n;
                }
                while (eVar3.f21187f > i20 && ((eVar.f21187f > i20 || eVar2.f21187f > o) && !a2.isEmpty())) {
                    noneOf.add(Limit.ExportCodecMemoryUsage);
                    VideoLayer videoLayer2 = (VideoLayer) a2.remove(a2.size() - 1);
                    if (!videoLayer2.getOverLimit()) {
                        videoLayer2.setOverLimit(true);
                        eVar2.f21183b -= videoLayer2.getAudioTrackUsage();
                        eVar3.f21186e -= videoLayer2.getContentWeight();
                        eVar2.f21186e -= videoLayer2.getContentWeight();
                        eVar3.f21187f -= videoLayer2.getVideoCodecExportMemoryUsage();
                        eVar2.f21187f -= videoLayer2.getVideoCodecExportMemoryUsage();
                    }
                }
                cVar.l = Math.min(q - eVar3.f21186e, i20 - eVar3.f21187f);
            }
            cVar.f21168c = eVar3.f21183b;
            cVar.f21169d = eVar3.f21184c;
            cVar.f21170e = eVar3.f21185d;
            cVar.f21171f = eVar3.f21187f;
            cVar.f21172g = a3.size();
            cVar.f21173h = a2.size();
            cVar.i = i11;
            cVar.j = z;
            cVar.k = Collections.unmodifiableSet(noneOf);
            TimelineResourceUsage.b(a2);
            TimelineResourceUsage.b(a3);
            TimelineResourceUsage.b(a4);
        }

        @Override // com.nexstreaming.kinemaster.project.TimelineResourceUsage.b
        public boolean a(Limit limit) {
            return this.k.contains(limit);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d implements b {

        /* renamed from: a, reason: collision with root package name */
        private final int f21174a;

        /* renamed from: b, reason: collision with root package name */
        private final int f21175b;

        /* renamed from: c, reason: collision with root package name */
        private final int f21176c;

        /* renamed from: d, reason: collision with root package name */
        private final int f21177d;

        /* renamed from: e, reason: collision with root package name */
        private final int f21178e;

        /* renamed from: f, reason: collision with root package name */
        private final int f21179f;

        /* renamed from: g, reason: collision with root package name */
        private final int f21180g;

        /* renamed from: h, reason: collision with root package name */
        private final int f21181h;
        private final int i;
        private final boolean j;
        private final Set<Limit> k;

        @Override // com.nexstreaming.kinemaster.project.TimelineResourceUsage.b
        public int a() {
            return this.f21176c;
        }

        @Override // com.nexstreaming.kinemaster.project.TimelineResourceUsage.b
        public int b() {
            return this.f21178e;
        }

        @Override // com.nexstreaming.kinemaster.project.TimelineResourceUsage.b
        public int c() {
            return this.f21180g;
        }

        @Override // com.nexstreaming.kinemaster.project.TimelineResourceUsage.b
        public int d() {
            return this.f21181h;
        }

        @Override // com.nexstreaming.kinemaster.project.TimelineResourceUsage.b
        public boolean e() {
            return !this.k.isEmpty();
        }

        @Override // com.nexstreaming.kinemaster.project.TimelineResourceUsage.b
        public Set<Limit> f() {
            return this.k;
        }

        @Override // com.nexstreaming.kinemaster.project.TimelineResourceUsage.b
        public int g() {
            return this.i;
        }

        @Override // com.nexstreaming.kinemaster.project.TimelineResourceUsage.b
        public int h() {
            return this.f21174a;
        }

        @Override // com.nexstreaming.kinemaster.project.TimelineResourceUsage.b
        public int i() {
            return this.f21177d;
        }

        @Override // com.nexstreaming.kinemaster.project.TimelineResourceUsage.b
        public boolean j() {
            return this.j;
        }

        @Override // com.nexstreaming.kinemaster.project.TimelineResourceUsage.b
        public int k() {
            return this.f21175b;
        }

        @Override // com.nexstreaming.kinemaster.project.TimelineResourceUsage.b
        public int l() {
            return this.f21179f;
        }

        private d(b[] bVarArr, int i, int i2) {
            int i3 = i2;
            EnumSet noneOf = EnumSet.noneOf(Limit.class);
            int i4 = i;
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            int i8 = 0;
            int i9 = 0;
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            boolean z = false;
            int i13 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            while (i4 < i3) {
                i5 = i4 == i ? bVarArr[i4].h() : i5;
                int i14 = i4 + 1;
                i6 = i14 == i3 ? bVarArr[i4].k() : i6;
                i7 = Math.max(i7, bVarArr[i4].a());
                i8 = Math.max(i8, bVarArr[i4].i());
                i9 = Math.max(i9, bVarArr[i4].b());
                i10 = Math.max(i10, bVarArr[i4].l());
                i11 = Math.max(i11, bVarArr[i4].c());
                i12 = Math.max(i12, bVarArr[i4].d());
                i13 = Math.min(i13, bVarArr[i4].g());
                z = z || bVarArr[i4].j();
                noneOf.addAll(bVarArr[i4].f());
                i3 = i2;
                i4 = i14;
            }
            this.f21174a = i5;
            this.f21175b = i6;
            this.f21176c = i7;
            this.f21177d = i8;
            this.f21178e = i9;
            this.f21179f = i10;
            this.f21180g = i11;
            this.f21181h = i12;
            this.j = z;
            this.i = i13 == Integer.MAX_VALUE ? 0 : i13;
            this.k = Collections.unmodifiableSet(noneOf);
        }

        @Override // com.nexstreaming.kinemaster.project.TimelineResourceUsage.b
        public boolean a(Limit limit) {
            return this.k.contains(limit);
        }
    }

    public TimelineResourceUsage(NexTimeline nexTimeline) {
        int primaryItemCount = nexTimeline.getPrimaryItemCount();
        int secondaryItemCount = nexTimeline.getSecondaryItemCount();
        if (primaryItemCount == 0) {
            b bVar = f21159a;
            this.f21161c = new b[]{bVar};
            this.f21164f = null;
            this.f21165g = null;
            this.f21163e = false;
            this.f21162d = Collections.singletonList(bVar);
            return;
        }
        HashSet hashSet = new HashSet();
        int totalTime = nexTimeline.getTotalTime();
        for (int i = 0; i < primaryItemCount; i++) {
            NexPrimaryTimelineItem primaryItem = nexTimeline.getPrimaryItem(i);
            int absStartTime = primaryItem.getAbsStartTime();
            if (primaryItem instanceof NexVideoClipItem) {
                absStartTime = Math.max(0, absStartTime - 100);
            }
            hashSet.add(Integer.valueOf(absStartTime));
            hashSet.add(Integer.valueOf(primaryItem.getAbsEndTime()));
        }
        for (int i2 = 0; i2 < secondaryItemCount; i2++) {
            NexSecondaryTimelineItem secondaryItem = nexTimeline.getSecondaryItem(i2);
            int absStartTime2 = secondaryItem.getAbsStartTime();
            int absEndTime = secondaryItem.getAbsEndTime();
            if (absStartTime2 < totalTime) {
                absEndTime = absEndTime > totalTime ? totalTime : absEndTime;
                hashSet.add(Integer.valueOf(secondaryItem instanceof VideoLayer ? Math.max(0, absStartTime2 - 100) : absStartTime2));
                hashSet.add(Integer.valueOf(absEndTime));
            }
        }
        int[] a2 = q.a(hashSet);
        Arrays.sort(a2);
        this.f21161c = new c[a2.length - 1];
        b bVar2 = null;
        b bVar3 = null;
        int i3 = 0;
        boolean z = false;
        while (true) {
            b[] bVarArr = this.f21161c;
            if (i3 < bVarArr.length) {
                int i4 = i3 + 1;
                bVarArr[i3] = new c(nexTimeline, a2[i3], a2[i4], null);
                if (this.f21161c[i3].e()) {
                    if (!z) {
                        bVar2 = this.f21161c[i3];
                        z = true;
                    }
                    bVar3 = this.f21161c[i3];
                }
                i3 = i4;
            } else {
                this.f21163e = z;
                this.f21164f = bVar2;
                this.f21165g = bVar3;
                this.f21162d = new C1711o(bVarArr);
                return;
            }
        }
    }

    static /* synthetic */ List a() {
        return c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(List<NexSecondaryTimelineItem> list) {
        if (list != null) {
            list.clear();
            if (f21160b.size() < 8) {
                f21160b.add(list);
            }
        }
    }

    private static List<NexSecondaryTimelineItem> c() {
        List<NexSecondaryTimelineItem> pollLast = f21160b.pollLast();
        return pollLast == null ? new ArrayList() : pollLast;
    }

    public b a(NexTimelineItem nexTimelineItem) {
        int absStartTime = nexTimelineItem.getAbsStartTime();
        if (nexTimelineItem instanceof VideoLayer) {
            absStartTime = Math.max(0, absStartTime - 100);
        }
        return a(absStartTime, nexTimelineItem.getAbsEndTime());
    }

    public List<? extends b> b() {
        return this.f21162d;
    }

    /* loaded from: classes.dex */
    private static class e {

        /* renamed from: a, reason: collision with root package name */
        int f21182a;

        /* renamed from: b, reason: collision with root package name */
        int f21183b;

        /* renamed from: c, reason: collision with root package name */
        int f21184c;

        /* renamed from: d, reason: collision with root package name */
        int f21185d;

        /* renamed from: e, reason: collision with root package name */
        int f21186e;

        /* renamed from: f, reason: collision with root package name */
        int f21187f;

        public e() {
            this.f21182a = 0;
            this.f21183b = 0;
            this.f21184c = 0;
            this.f21185d = 0;
            this.f21186e = 0;
            this.f21187f = 0;
        }

        public e(e eVar, e eVar2) {
            this.f21182a = 0;
            this.f21183b = 0;
            this.f21184c = 0;
            this.f21185d = 0;
            this.f21186e = 0;
            this.f21187f = 0;
            this.f21182a = eVar.f21182a + eVar2.f21182a;
            this.f21183b = eVar.f21183b + eVar2.f21183b;
            this.f21184c = eVar.f21184c + eVar2.f21184c;
            this.f21185d = eVar.f21185d + eVar2.f21185d;
            this.f21186e = eVar.f21186e + eVar2.f21186e;
            this.f21187f = eVar.f21187f + eVar2.f21187f;
        }
    }

    public b a(int i, int i2) {
        b[] bVarArr;
        int i3 = 0;
        int i4 = 0;
        int i5 = -1;
        int i6 = -1;
        while (true) {
            bVarArr = this.f21161c;
            if (i4 >= bVarArr.length) {
                break;
            }
            if (i5 == -1 && i >= bVarArr[i4].h() && i < this.f21161c[i4].k()) {
                i5 = i4;
            }
            if (i6 == -1 && i2 > this.f21161c[i4].h() && i2 <= this.f21161c[i4].k()) {
                i6 = i4;
            }
            i4++;
        }
        if (i5 >= 0) {
            i3 = i5;
        } else if (i >= bVarArr[0].h()) {
            if (i >= this.f21161c[r9.length - 1].k()) {
                i3 = this.f21161c.length - 1;
            }
        }
        if (i3 >= 0 && i6 == -1) {
            i6 = this.f21161c.length - 1;
        }
        if (i3 >= 0 && i3 == i6) {
            return this.f21161c[i3];
        }
        return new d(this.f21161c, i3, i6 + 1);
    }
}
