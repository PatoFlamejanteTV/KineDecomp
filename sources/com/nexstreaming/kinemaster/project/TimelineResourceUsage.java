package com.nexstreaming.kinemaster.project;

import com.nexstreaming.app.general.util.l;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.layer.VideoLayer;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.NexAudioClipItem;
import com.nextreaming.nexeditorui.NexEditorDeviceProfile;
import com.nextreaming.nexeditorui.NexPrimaryTimelineItem;
import com.nextreaming.nexeditorui.NexSecondaryTimelineItem;
import com.nextreaming.nexeditorui.NexTimeline;
import com.nextreaming.nexeditorui.NexTimelineItem;
import com.nextreaming.nexeditorui.NexTransitionItem;
import com.nextreaming.nexeditorui.NexVideoClipItem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public class TimelineResourceUsage {

    /* renamed from: a */
    private static final b f3617a = new a();
    private final b[] b;
    private final List<? extends b> c;
    private final boolean d;
    private final b e;
    private final b f;

    /* loaded from: classes.dex */
    public enum Limit {
        AudioTrackCount,
        VideoLayerCount,
        DecoderMemoryUsage,
        UnsupportedContent
    }

    /* loaded from: classes.dex */
    public interface b {
        int a();

        boolean a(Limit limit);

        int b();

        int c();

        int d();

        int e();

        int f();

        int g();

        int h();

        int i();

        boolean j();

        boolean k();

        Set<Limit> l();
    }

    /* loaded from: classes.dex */
    private static class a implements b {
        private a() {
        }

        /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.nexstreaming.kinemaster.project.TimelineResourceUsage.b
        public int a() {
            return 0;
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
        public int e() {
            return 0;
        }

        @Override // com.nexstreaming.kinemaster.project.TimelineResourceUsage.b
        public int f() {
            return 0;
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
        public boolean k() {
            return false;
        }

        @Override // com.nexstreaming.kinemaster.project.TimelineResourceUsage.b
        public boolean a(Limit limit) {
            return false;
        }

        @Override // com.nexstreaming.kinemaster.project.TimelineResourceUsage.b
        public Set<Limit> l() {
            return Collections.emptySet();
        }
    }

    /* loaded from: classes.dex */
    public static class d implements b {

        /* renamed from: a */
        private final int f3619a;
        private final int b;
        private final int c;
        private final int d;
        private final int e;
        private final int f;
        private final int g;
        private final int h;
        private final int i;
        private final boolean j;
        private final Set<Limit> k;

        /* synthetic */ d(b[] bVarArr, int i, int i2, AnonymousClass1 anonymousClass1) {
            this(bVarArr, i, i2);
        }

        private d(b[] bVarArr, int i, int i2) {
            EnumSet noneOf = EnumSet.noneOf(Limit.class);
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            int i8 = 0;
            boolean z = false;
            int i9 = Integer.MAX_VALUE;
            int i10 = 0;
            int i11 = 0;
            int i12 = i;
            while (i12 < i2) {
                i11 = i12 == i ? bVarArr[i12].c() : i11;
                i10 = i12 + 1 == i2 ? bVarArr[i12].d() : i10;
                int max = Math.max(i3, bVarArr[i12].b());
                int max2 = Math.max(i4, bVarArr[i12].i());
                int max3 = Math.max(i5, bVarArr[i12].e());
                int max4 = Math.max(i6, bVarArr[i12].a());
                int max5 = Math.max(i7, bVarArr[i12].h());
                int max6 = Math.max(i8, bVarArr[i12].g());
                int min = Math.min(i9, bVarArr[i12].f());
                boolean z2 = z || bVarArr[i12].j();
                noneOf.addAll(bVarArr[i12].l());
                i12++;
                z = z2;
                i9 = min;
                i8 = max6;
                i7 = max5;
                i6 = max4;
                i5 = max3;
                i4 = max2;
                i3 = max;
            }
            this.f3619a = i11;
            this.b = i10;
            this.c = i3;
            this.d = i4;
            this.e = i5;
            this.f = i6;
            this.g = i7;
            this.h = i8;
            this.j = z;
            this.i = i9 == Integer.MAX_VALUE ? 0 : i9;
            this.k = Collections.unmodifiableSet(noneOf);
        }

        @Override // com.nexstreaming.kinemaster.project.TimelineResourceUsage.b
        public int a() {
            return this.f;
        }

        @Override // com.nexstreaming.kinemaster.project.TimelineResourceUsage.b
        public int b() {
            return this.c;
        }

        @Override // com.nexstreaming.kinemaster.project.TimelineResourceUsage.b
        public int c() {
            return this.f3619a;
        }

        @Override // com.nexstreaming.kinemaster.project.TimelineResourceUsage.b
        public int d() {
            return this.b;
        }

        @Override // com.nexstreaming.kinemaster.project.TimelineResourceUsage.b
        public int e() {
            return this.e;
        }

        @Override // com.nexstreaming.kinemaster.project.TimelineResourceUsage.b
        public int f() {
            return this.i;
        }

        @Override // com.nexstreaming.kinemaster.project.TimelineResourceUsage.b
        public int g() {
            return this.h;
        }

        @Override // com.nexstreaming.kinemaster.project.TimelineResourceUsage.b
        public int h() {
            return this.g;
        }

        @Override // com.nexstreaming.kinemaster.project.TimelineResourceUsage.b
        public int i() {
            return this.d;
        }

        @Override // com.nexstreaming.kinemaster.project.TimelineResourceUsage.b
        public boolean j() {
            return this.j;
        }

        @Override // com.nexstreaming.kinemaster.project.TimelineResourceUsage.b
        public boolean k() {
            return !this.k.isEmpty();
        }

        @Override // com.nexstreaming.kinemaster.project.TimelineResourceUsage.b
        public boolean a(Limit limit) {
            return this.k.contains(limit);
        }

        @Override // com.nexstreaming.kinemaster.project.TimelineResourceUsage.b
        public Set<Limit> l() {
            return this.k;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c implements b {

        /* renamed from: a */
        private final int f3618a;
        private final int b;
        private final int c;
        private final int d;
        private final int e;
        private final int f;
        private final int g;
        private final int h;
        private final boolean i;
        private final Set<Limit> j;
        private final int k;

        /* synthetic */ c(NexTimeline nexTimeline, int i, int i2, NexTimelineItem nexTimelineItem, AnonymousClass1 anonymousClass1) {
            this(nexTimeline, i, i2, nexTimelineItem);
        }

        private c(NexTimeline nexTimeline, int i, int i2, NexTimelineItem nexTimelineItem) {
            int i3;
            int i4;
            int i5;
            int i6;
            int i7;
            int i8;
            boolean z;
            int i9;
            int i10;
            int i11;
            boolean z2;
            int i12;
            int i13;
            int i14;
            this.f3618a = i;
            this.b = i2;
            int i15 = 0;
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            int i19 = 0;
            int i20 = 0;
            boolean z3 = false;
            int totalTime = nexTimeline.getTotalTime();
            int primaryItemCount = nexTimeline.getPrimaryItemCount();
            int secondaryItemCount = nexTimeline.getSecondaryItemCount();
            int i21 = 0;
            while (i21 < primaryItemCount) {
                NexPrimaryTimelineItem primaryItem = nexTimeline.getPrimaryItem(i21);
                int absEndTime = primaryItem.getAbsEndTime();
                int absStartTime = primaryItem.getAbsStartTime();
                absStartTime = primaryItem instanceof NexVideoClipItem ? Math.max(0, absStartTime - 1000) : absStartTime;
                if (primaryItem == nexTimelineItem || absEndTime < i) {
                    z2 = z3;
                    i12 = i17;
                    i13 = i16;
                    i14 = i15;
                } else if (absStartTime >= i2) {
                    z2 = z3;
                    i12 = i17;
                    i13 = i16;
                    i14 = i15;
                } else if (primaryItem instanceof NexTransitionItem) {
                    z2 = true;
                    i12 = i17;
                    i13 = i16;
                    i14 = i15;
                } else {
                    int audioTrackUsage = i15 + primaryItem.getAudioTrackUsage();
                    int videoTrackUsage = i16 + primaryItem.getVideoTrackUsage();
                    int videoCodecMemoryUsage = primaryItem.getVideoCodecMemoryUsage() + i17;
                    i13 = videoTrackUsage;
                    i14 = audioTrackUsage;
                    boolean z4 = z3;
                    i12 = videoCodecMemoryUsage;
                    z2 = z4;
                }
                i21++;
                i15 = i14;
                i16 = i13;
                i17 = i12;
                z3 = z2;
            }
            int i22 = 0;
            int i23 = 0;
            int i24 = i17;
            int i25 = i16;
            boolean z5 = false;
            while (i23 < secondaryItemCount) {
                NexSecondaryTimelineItem secondaryItem = nexTimeline.getSecondaryItem(i23);
                int absStartTime2 = secondaryItem.getAbsStartTime();
                if (absStartTime2 >= totalTime) {
                    i3 = i20;
                    i4 = i25;
                    i5 = i18;
                    int i26 = i24;
                    i6 = i19;
                    i7 = i22;
                    i8 = i26;
                } else {
                    absStartTime2 = secondaryItem instanceof VideoLayer ? Math.max(0, absStartTime2 - 1000) : absStartTime2;
                    if (secondaryItem == nexTimelineItem || secondaryItem.getAbsEndTime() <= i || absStartTime2 >= i2) {
                        i3 = i20;
                        i4 = i25;
                        i5 = i18;
                        int i27 = i24;
                        i6 = i19;
                        i7 = i22;
                        i8 = i27;
                    } else if (secondaryItem.getOverLimit()) {
                        i3 = i20;
                        i4 = i25;
                        i5 = i18;
                        int i28 = i24;
                        i6 = i19;
                        i7 = i22;
                        i8 = i28;
                    } else {
                        MediaStoreItem.MediaSupportType mediaSupportType = secondaryItem.getMediaSupportType();
                        if (mediaSupportType.isNotSupported() || mediaSupportType.needsTranscode()) {
                            z = true;
                            secondaryItem.setOverLimit(true);
                            i9 = i24;
                            i10 = i25;
                            i11 = i22;
                        } else {
                            int audioTrackUsage2 = i22 + secondaryItem.getAudioTrackUsage();
                            int videoTrackUsage2 = i25 + secondaryItem.getVideoTrackUsage();
                            int videoCodecMemoryUsage2 = secondaryItem.getVideoCodecMemoryUsage() + i24;
                            i10 = videoTrackUsage2;
                            i11 = audioTrackUsage2;
                            boolean z6 = z5;
                            i9 = videoCodecMemoryUsage2;
                            z = z6;
                        }
                        if (secondaryItem instanceof NexAudioClipItem) {
                            boolean z7 = z;
                            i3 = i20;
                            i4 = i10;
                            i6 = i19;
                            i7 = i11;
                            i5 = i18 + 1;
                            i8 = i9;
                            z5 = z7;
                        } else if (secondaryItem instanceof VideoLayer) {
                            int i29 = i19 + 1;
                            i7 = i11;
                            i5 = i18;
                            i8 = i9;
                            z5 = z;
                            i3 = i20;
                            i4 = i10;
                            i6 = i29;
                        } else if (secondaryItem instanceof NexLayerItem) {
                            int i30 = i20 + 1;
                            i4 = i10;
                            i6 = i19;
                            i7 = i11;
                            i5 = i18;
                            int i31 = i9;
                            z5 = z;
                            i3 = i30;
                            i8 = i31;
                        } else {
                            i8 = i9;
                            z5 = z;
                            i3 = i20;
                            i4 = i10;
                            i6 = i19;
                            i7 = i11;
                            i5 = i18;
                        }
                    }
                }
                i23++;
                i18 = i5;
                i25 = i4;
                i20 = i3;
                int i32 = i8;
                i22 = i7;
                i19 = i6;
                i24 = i32;
            }
            if (i19 > 2 || i22 > 4) {
                ArrayList<NexSecondaryTimelineItem> arrayList = new ArrayList(secondaryItemCount);
                ArrayList<NexSecondaryTimelineItem> arrayList2 = new ArrayList(secondaryItemCount);
                for (int i33 = 0; i33 < secondaryItemCount; i33++) {
                    NexSecondaryTimelineItem secondaryItem2 = nexTimeline.getSecondaryItem(i33);
                    int absStartTime3 = secondaryItem2.getAbsStartTime();
                    absStartTime3 = secondaryItem2 instanceof VideoLayer ? Math.max(0, absStartTime3 - 1000) : absStartTime3;
                    if (secondaryItem2 != nexTimelineItem && secondaryItem2.getAbsEndTime() > i && absStartTime3 < i2 && !secondaryItem2.getOverLimit()) {
                        if (secondaryItem2 instanceof NexAudioClipItem) {
                            arrayList2.add(secondaryItem2);
                        } else if (secondaryItem2 instanceof VideoLayer) {
                            arrayList.add(secondaryItem2);
                        }
                    }
                }
                Collections.sort(arrayList);
                Collections.sort(arrayList2);
                int i34 = 0;
                int i35 = 0;
                for (NexSecondaryTimelineItem nexSecondaryTimelineItem : arrayList) {
                    i35++;
                    if (i35 > 2) {
                        nexSecondaryTimelineItem.setOverLimit(true);
                    }
                    i34 += nexSecondaryTimelineItem.getAudioTrackUsage();
                    if (i34 > 4) {
                        nexSecondaryTimelineItem.setOverLimit(true);
                    }
                }
                for (NexSecondaryTimelineItem nexSecondaryTimelineItem2 : arrayList2) {
                    i34 += nexSecondaryTimelineItem2.getAudioTrackUsage();
                    if (i34 > 4) {
                        nexSecondaryTimelineItem2.setOverLimit(true);
                    }
                }
                int i36 = i35;
                i22 = i34;
                i19 = i36;
            }
            EnumSet noneOf = EnumSet.noneOf(Limit.class);
            NexEditorDeviceProfile deviceProfile = NexEditorDeviceProfile.getDeviceProfile();
            if (z5) {
                noneOf.add(Limit.UnsupportedContent);
            }
            if (i22 > 4) {
                noneOf.add(Limit.AudioTrackCount);
            }
            if (i19 > 2) {
                noneOf.add(Limit.VideoLayerCount);
            }
            int maxCodecMemSizeForVideoLayers = deviceProfile.getMaxCodecMemSizeForVideoLayers() - deviceProfile.getMaxEncoderMemorySize(EditorGlobal.a().i());
            int i37 = maxCodecMemSizeForVideoLayers - i17;
            if (maxCodecMemSizeForVideoLayers - i24 < 0) {
                noneOf.add(Limit.DecoderMemoryUsage);
                ArrayList arrayList3 = new ArrayList();
                for (int i38 = 0; i38 < secondaryItemCount; i38++) {
                    NexSecondaryTimelineItem secondaryItem3 = nexTimeline.getSecondaryItem(i38);
                    int absStartTime4 = secondaryItem3.getAbsStartTime();
                    absStartTime4 = secondaryItem3 instanceof VideoLayer ? Math.max(0, absStartTime4 - 1000) : absStartTime4;
                    if (secondaryItem3 != nexTimelineItem && secondaryItem3.getAbsEndTime() > i && absStartTime4 < i2 && !secondaryItem3.getOverLimit() && (secondaryItem3 instanceof VideoLayer)) {
                        arrayList3.add(secondaryItem3);
                    }
                }
                Collections.sort(arrayList3);
                Iterator it = arrayList3.iterator();
                while (true) {
                    int i39 = i37;
                    if (!it.hasNext()) {
                        break;
                    }
                    NexSecondaryTimelineItem nexSecondaryTimelineItem3 = (NexSecondaryTimelineItem) it.next();
                    if ((nexSecondaryTimelineItem3 instanceof VideoLayer) && (i39 = i39 - nexSecondaryTimelineItem3.getVideoCodecMemoryUsage()) < 0) {
                        nexSecondaryTimelineItem3.setOverLimit(true);
                        i24 -= nexSecondaryTimelineItem3.getVideoCodecMemoryUsage();
                    }
                    i37 = i39;
                }
            }
            this.k = maxCodecMemSizeForVideoLayers - i24;
            this.c = i22;
            this.d = i25;
            this.e = i24;
            this.f = i18;
            this.g = i19;
            this.h = i20;
            this.i = z3;
            this.j = Collections.unmodifiableSet(noneOf);
        }

        @Override // com.nexstreaming.kinemaster.project.TimelineResourceUsage.b
        public int a() {
            return this.f;
        }

        @Override // com.nexstreaming.kinemaster.project.TimelineResourceUsage.b
        public int b() {
            return this.c;
        }

        @Override // com.nexstreaming.kinemaster.project.TimelineResourceUsage.b
        public int c() {
            return this.f3618a;
        }

        @Override // com.nexstreaming.kinemaster.project.TimelineResourceUsage.b
        public int d() {
            return this.b;
        }

        @Override // com.nexstreaming.kinemaster.project.TimelineResourceUsage.b
        public int e() {
            return this.e;
        }

        @Override // com.nexstreaming.kinemaster.project.TimelineResourceUsage.b
        public int f() {
            return this.k;
        }

        @Override // com.nexstreaming.kinemaster.project.TimelineResourceUsage.b
        public int g() {
            return this.h;
        }

        @Override // com.nexstreaming.kinemaster.project.TimelineResourceUsage.b
        public int h() {
            return this.g;
        }

        @Override // com.nexstreaming.kinemaster.project.TimelineResourceUsage.b
        public int i() {
            return this.d;
        }

        @Override // com.nexstreaming.kinemaster.project.TimelineResourceUsage.b
        public boolean j() {
            return this.i;
        }

        @Override // com.nexstreaming.kinemaster.project.TimelineResourceUsage.b
        public boolean k() {
            return !this.j.isEmpty();
        }

        @Override // com.nexstreaming.kinemaster.project.TimelineResourceUsage.b
        public boolean a(Limit limit) {
            return this.j.contains(limit);
        }

        @Override // com.nexstreaming.kinemaster.project.TimelineResourceUsage.b
        public Set<Limit> l() {
            return this.j;
        }
    }

    public TimelineResourceUsage(NexTimeline nexTimeline) {
        b bVar;
        b bVar2;
        boolean z;
        int primaryItemCount = nexTimeline.getPrimaryItemCount();
        int secondaryItemCount = nexTimeline.getSecondaryItemCount();
        if (primaryItemCount == 0) {
            this.b = new b[]{f3617a};
            this.e = null;
            this.f = null;
            this.d = false;
            this.c = Collections.singletonList(f3617a);
            return;
        }
        HashSet hashSet = new HashSet();
        int totalTime = nexTimeline.getTotalTime();
        for (int i = 0; i < primaryItemCount; i++) {
            NexPrimaryTimelineItem primaryItem = nexTimeline.getPrimaryItem(i);
            int absStartTime = primaryItem.getAbsStartTime();
            if (primaryItem instanceof NexVideoClipItem) {
                absStartTime = Math.max(0, absStartTime - 1000);
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
                hashSet.add(Integer.valueOf(secondaryItem instanceof VideoLayer ? Math.max(0, absStartTime2 - 1000) : absStartTime2));
                hashSet.add(Integer.valueOf(absEndTime));
            }
        }
        int[] a2 = l.a(hashSet);
        Arrays.sort(a2);
        this.b = new c[a2.length - 1];
        int i3 = 0;
        b bVar3 = null;
        b bVar4 = null;
        boolean z2 = false;
        while (i3 < this.b.length) {
            this.b[i3] = new c(nexTimeline, a2[i3], a2[i3 + 1], null);
            if (this.b[i3].k()) {
                if (z2) {
                    bVar2 = bVar4;
                    z = z2;
                } else {
                    bVar2 = this.b[i3];
                    z = true;
                }
                bVar = this.b[i3];
            } else {
                bVar = bVar3;
                bVar2 = bVar4;
                z = z2;
            }
            i3++;
            bVar3 = bVar;
            bVar4 = bVar2;
            z2 = z;
        }
        this.d = z2;
        this.e = bVar4;
        this.f = bVar3;
        this.c = new com.nexstreaming.app.general.util.j(this.b);
    }

    public b a(NexTimelineItem nexTimelineItem) {
        int absStartTime = nexTimelineItem.getAbsStartTime();
        if (nexTimelineItem instanceof VideoLayer) {
            absStartTime = Math.max(0, absStartTime - 1000);
        }
        return a(absStartTime, nexTimelineItem.getAbsEndTime());
    }

    public b a(int i, int i2) {
        int i3 = 0;
        int i4 = -1;
        int i5 = -1;
        for (int i6 = 0; i6 < this.b.length; i6++) {
            if (i5 == -1 && i >= this.b[i6].c() && i < this.b[i6].d()) {
                i5 = i6;
            }
            if (i4 == -1 && i2 > this.b[i6].c() && i2 <= this.b[i6].d()) {
                i4 = i6;
            }
        }
        if (i5 >= 0) {
            i3 = i5;
        } else if (i >= this.b[0].c() && i >= this.b[this.b.length - 1].d()) {
            i3 = this.b.length - 1;
        }
        if (i3 >= 0 && i4 == -1) {
            i4 = this.b.length - 1;
        }
        if (i3 >= 0 && i3 == i4) {
            return this.b[i3];
        }
        return new d(this.b, i3, i4 + 1);
    }
}
