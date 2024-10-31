package com.nextreaming.nexeditorui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Log;
import android.util.LruCache;
import android.widget.Toast;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.kmpackage.EffectLibrary;
import com.nexstreaming.kinemaster.kmpackage.Theme;
import com.nexstreaming.kinemaster.layer.EffectLayer;
import com.nexstreaming.kinemaster.layer.HandwritingLayer;
import com.nexstreaming.kinemaster.layer.ImageLayer;
import com.nexstreaming.kinemaster.layer.StickerLayer;
import com.nexstreaming.kinemaster.layer.TextLayer;
import com.nexstreaming.kinemaster.layer.VideoLayer;
import com.nexstreaming.kinemaster.mediastore.v2.MSID;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStore;
import com.nexstreaming.kinemaster.project.ProjectDependency;
import com.nexstreaming.kinemaster.project.TimelineResourceUsage;
import com.nexstreaming.kinemaster.wire.KMProto;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.NexVideoClipItem;
import com.nextreaming.nexvideoeditor.NexEditor;
import com.xiaomi.licensinglibrary.LicenseErrCode;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class NexTimeline implements Serializable {
    private static long i = 0;
    private static final long serialVersionUID = 1;
    private transient TimelineResourceUsage d;
    private transient TimelineResourceUsage e;
    private transient NexAudioClipItem j;
    private transient NexProjectHeader k;
    private transient int[] l;
    private transient int m;
    private Set<Integer> m_bookmarks;
    private boolean m_isProjectVideoFadeInOn;
    private boolean m_isProjectVideoFadeOutOn;
    private ProjectAspectRatio m_projectRatio;
    private int m_recentScrollTime;
    private int m_simulAudioTracks;
    private String m_themeId;
    private boolean m_themeMusicEnable;
    private int m_themeMusicVolume;
    private transient LruCache<UUID, Bitmap> n;
    private transient WeakReference<MediaStore> o;

    /* renamed from: a */
    private transient int f4491a = 0;
    private transient int b = 0;
    private transient int c = 0;
    private transient com.nexstreaming.kinemaster.project.k f = null;
    private transient com.nexstreaming.app.general.util.m<b> g = null;
    private transient WeakHashMap<NexTimelineItem, TimelineResourceUsage.b> h = new WeakHashMap<>();
    private List<NexPrimaryTimelineItem> m_primaryItems = new ArrayList();
    private List<NexSecondaryTimelineItem> m_secondaryItems = new ArrayList();
    private String m_customBackgroundMusicPath = null;
    private String m_customBackgroundMusicTitle = null;
    private float m_projectVideoFadeInTime = 2.0f;
    private float m_projectVideoFadeOutTime = 2.0f;
    private int m_timelimeFormatVersion = 5;
    private float m_projectAudioFadeInTime = 0.2f;
    private float m_projectAudioFadeOutTime = 4.0f;
    private boolean m_isProjectAudioFadeInOn = false;
    private boolean m_isProjectAudioFadeOutOn = true;

    /* loaded from: classes.dex */
    public interface b {
        void d(int i);

        int getCTSBeforeTimeChange();
    }

    /* loaded from: classes.dex */
    public interface c {
        void a();
    }

    public void addLayer(NexLayerItem nexLayerItem) {
        if (nexLayerItem instanceof VideoLayer) {
            ((VideoLayer) nexLayerItem).setEngineClipID(nextAvailableEngineClipId());
        }
        nexLayerItem.setZOrder(getFrontmostLayerZOrder() + serialVersionUID);
        nexLayerItem.getUniqueId();
        addSecondaryItem(nexLayerItem);
    }

    public int getDecoderMemoryUsageAtTime(int i2) {
        int i3;
        int i4 = 0;
        int primaryItemCount = getPrimaryItemCount();
        int i5 = 0;
        for (int i6 = 0; i6 < primaryItemCount; i6++) {
            NexPrimaryTimelineItem primaryItem = getPrimaryItem(i6);
            if (i2 >= primaryItem.getAbsStartTime() && i2 <= primaryItem.getAbsEndTime()) {
                if (primaryItem instanceof NexVideoClipItem) {
                    NexVideoClipItem nexVideoClipItem = (NexVideoClipItem) primaryItem;
                    i5 = nexVideoClipItem.isVideo() ? ((nexVideoClipItem.getFPS() * (((nexVideoClipItem.getWidth() * nexVideoClipItem.getHeight()) * 150) / 100)) / 30) + i5 : i5;
                } else if (primaryItem instanceof NexTransitionItem) {
                }
            }
        }
        int secondaryItemCount = getSecondaryItemCount();
        while (i4 < secondaryItemCount) {
            NexSecondaryTimelineItem secondaryItem = getSecondaryItem(i4);
            if (i2 < secondaryItem.getAbsStartTime() || i2 > secondaryItem.getAbsEndTime() || !(secondaryItem instanceof VideoLayer)) {
                i3 = i5;
            } else {
                VideoLayer videoLayer = (VideoLayer) secondaryItem;
                i3 = ((videoLayer.getFPS() * (((videoLayer.getWidth() * videoLayer.getHeight()) * 150) / 100)) / 30) + i5;
            }
            i4++;
            i5 = i3;
        }
        return i5;
    }

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a */
        int f4493a;
        int b;
        NexSecondaryTimelineItem c;
        NexVideoClipItem d;

        private a() {
        }

        public /* synthetic */ a(cw cwVar) {
            this();
        }

        public String toString() {
            return "[" + (this.c == null ? "null" : "S@" + this.c.getStartTime()) + " at " + (this.d == null ? "null" : "E@" + this.d.getEngineClipID()) + "+" + this.f4493a + "->" + this.b + "]";
        }
    }

    public com.nexstreaming.app.general.util.m<b> a() {
        if (this.g == null) {
            this.g = new com.nexstreaming.app.general.util.m<>();
        }
        return this.g;
    }

    public void registerTimeChangeCTSCallback(b bVar) {
        a().a((com.nexstreaming.app.general.util.m<b>) bVar);
    }

    public void unregisterTimeChangeCTSCallback(b bVar) {
        a().b(bVar);
    }

    public c beginTimeChange() {
        c();
        List<a> b2 = b();
        HashMap hashMap = new HashMap();
        a().a(new cw(this, hashMap));
        return new cx(this, b2, hashMap);
    }

    private List<a> b() {
        int secondaryItemCount = getSecondaryItemCount();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < secondaryItemCount; i2++) {
            NexSecondaryTimelineItem secondaryItem = getSecondaryItem(i2);
            if (!secondaryItem.getPinned()) {
                a aVar = new a(null);
                aVar.d = getFirstVideoClipAtTime(secondaryItem.getAbsStartTime());
                if (aVar.d != null) {
                    aVar.c = secondaryItem;
                    aVar.f4493a = secondaryItem.getAbsStartTime() - aVar.d.getAbsStartTime();
                    aVar.b = secondaryItem.getAbsEndTime() - aVar.d.getAbsStartTime();
                    arrayList.add(aVar);
                }
            }
        }
        return arrayList;
    }

    public void a(List<a> list) {
        c();
        for (a aVar : list) {
            aVar.c.moveClip(aVar.f4493a + aVar.d.getAbsStartTime());
        }
    }

    public void fireOnLoadEvent(EffectLibrary effectLibrary, int i2) {
        this.f4491a = i2;
        int size = this.m_primaryItems.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.m_primaryItems.get(i3).onTimelineLoaded(effectLibrary, i2);
        }
        int size2 = this.m_secondaryItems.size();
        for (int i4 = 0; i4 < size2; i4++) {
            this.m_secondaryItems.get(i4).onTimelineLoaded(effectLibrary, i2);
        }
    }

    public long getFrontmostLayerZOrder() {
        int size = this.m_secondaryItems.size();
        long j = 0;
        int i2 = 0;
        while (i2 < size) {
            NexSecondaryTimelineItem nexSecondaryTimelineItem = this.m_secondaryItems.get(i2);
            i2++;
            j = nexSecondaryTimelineItem instanceof NexLayerItem ? Math.max(j, ((NexLayerItem) nexSecondaryTimelineItem).getZOrder()) : j;
        }
        return j;
    }

    public long getBackmostLayerZOrder() {
        int size = this.m_secondaryItems.size();
        long j = -1;
        int i2 = 0;
        while (i2 < size) {
            NexSecondaryTimelineItem nexSecondaryTimelineItem = this.m_secondaryItems.get(i2);
            i2++;
            j = nexSecondaryTimelineItem instanceof NexLayerItem ? Math.min(j, ((NexLayerItem) nexSecondaryTimelineItem).getZOrder()) : j;
        }
        return j;
    }

    public boolean checkSecondaryItemLimits() {
        boolean z = checkSecondaryItemLimits(com.nexstreaming.kinemaster.project.a.f3620a, 4);
        if (checkSecondaryItemLimits(com.nexstreaming.kinemaster.project.a.b, 2)) {
            return true;
        }
        return z;
    }

    public boolean checkSecondaryItemLimits(com.nexstreaming.kinemaster.project.a aVar, int i2) {
        boolean z;
        if (this.f == null) {
            this.f = new com.nexstreaming.kinemaster.project.k();
        }
        this.f.a();
        int size = this.m_secondaryItems.size();
        int i3 = 0;
        boolean z2 = false;
        while (i3 < size) {
            NexSecondaryTimelineItem nexSecondaryTimelineItem = this.m_secondaryItems.get(i3);
            if (aVar == null || aVar.a(nexSecondaryTimelineItem)) {
                int max = Math.max(0, nexSecondaryTimelineItem.getAbsStartTime());
                int absEndTime = nexSecondaryTimelineItem.getAbsEndTime();
                if (max > absEndTime) {
                    z = z2;
                } else {
                    int i4 = 0;
                    while (max < this.f.b(i4)) {
                        i4++;
                    }
                    this.f.a(i4, absEndTime);
                    boolean z3 = i4 >= i2;
                    if (nexSecondaryTimelineItem.getOverLimit() != z3) {
                        nexSecondaryTimelineItem.setOverLimit(z3);
                        z = true;
                    } else {
                        z = z2;
                    }
                }
            } else {
                z = z2;
            }
            i3++;
            z2 = z;
        }
        return z2;
    }

    public int getClipTimingSerial() {
        return this.b;
    }

    public int getSecondaryLimitSerial() {
        return this.c;
    }

    public boolean checkResources(Context context) {
        boolean z = true;
        int size = this.m_primaryItems.size();
        int i2 = 0;
        while (i2 < size) {
            boolean z2 = !this.m_primaryItems.get(i2).checkResourceState(context) ? false : z;
            i2++;
            z = z2;
        }
        int size2 = this.m_secondaryItems.size();
        int i3 = 0;
        while (i3 < size2) {
            boolean z3 = !this.m_secondaryItems.get(i3).checkResourceState(context) ? false : z;
            i3++;
            z = z3;
        }
        String customBGMusic = getCustomBGMusic();
        if (customBGMusic == null || customBGMusic.startsWith("@") || new File(customBGMusic).exists()) {
            return z;
        }
        return false;
    }

    public boolean checkReadyToPlay() {
        boolean z = true;
        int size = this.m_primaryItems.size();
        int i2 = 0;
        while (i2 < size) {
            boolean z2 = !this.m_primaryItems.get(i2).isReadyToPlay() ? false : z;
            i2++;
            z = z2;
        }
        int size2 = this.m_secondaryItems.size();
        int i3 = 0;
        while (i3 < size2) {
            boolean z3 = !this.m_secondaryItems.get(i3).isReadyToPlay() ? false : z;
            i3++;
            z = z3;
        }
        return z;
    }

    public int getSecondaryItemsAtTime(int i2) {
        int i3 = 0;
        Iterator<NexSecondaryTimelineItem> it = this.m_secondaryItems.iterator();
        while (true) {
            int i4 = i3;
            if (it.hasNext()) {
                NexSecondaryTimelineItem next = it.next();
                int absStartTime = next.getAbsStartTime();
                int absEndTime = next.getAbsEndTime();
                if (i2 >= absStartTime && i2 <= absEndTime) {
                    i4++;
                }
                i3 = i4;
            } else {
                return i4;
            }
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int primaryItemCount = getPrimaryItemCount();
        int secondaryItemCount = getSecondaryItemCount();
        for (int i2 = 0; i2 < primaryItemCount; i2++) {
            getPrimaryItem(i2).wasAddedToTimeline(this);
        }
        for (int i3 = 0; i3 < secondaryItemCount; i3++) {
            getSecondaryItem(i3).wasAddedToTimeline(this);
        }
        requestCalcTimes();
    }

    public void requestCalcTimes() {
        c();
    }

    private int a(int i2) {
        return i2;
    }

    public void addBookmark(int i2) {
        int a2 = a(i2);
        if (this.m_bookmarks == null) {
            this.m_bookmarks = new HashSet();
        }
        if (!this.m_bookmarks.contains(Integer.valueOf(a2))) {
            this.m_bookmarks.add(Integer.valueOf(a2));
            this.l = null;
        }
    }

    public void removeBookmark(int i2) {
        if (this.m_bookmarks != null) {
            this.m_bookmarks.remove(Integer.valueOf(a(i2)));
            this.l = null;
        }
    }

    public boolean isSameBookmark(int i2, int i3) {
        int a2 = a(i2);
        return a2 == a(i3) && this.m_bookmarks.contains(Integer.valueOf(a2));
    }

    public boolean isBookmark(int i2) {
        if (this.m_bookmarks == null) {
            return false;
        }
        return this.m_bookmarks.contains(Integer.valueOf(a(i2)));
    }

    public boolean toggleBookmark(int i2) {
        int a2 = a(i2);
        if (isBookmark(a2)) {
            removeBookmark(a2);
            return false;
        }
        addBookmark(a2);
        return true;
    }

    public void clearAllBookmarks() {
        this.m_bookmarks = null;
        this.l = null;
    }

    public int[] getBookmarks() {
        if (this.l == null) {
            this.l = com.nexstreaming.app.general.util.l.a(this.m_bookmarks);
        }
        return this.l;
    }

    private void c() {
        a(false);
    }

    private void a(boolean z) {
        boolean z2;
        int size = this.m_primaryItems.size();
        int i2 = 0;
        boolean z3 = false;
        while (i2 < size) {
            if (this.m_primaryItems.get(i2) instanceof NexTransitionItem) {
                NexTransitionItem nexTransitionItem = (NexTransitionItem) this.m_primaryItems.get(i2);
                int transitionOverlap = nexTransitionItem.getTransitionOverlap();
                int transitionOffset = nexTransitionItem.getTransitionOffset();
                int duration = nexTransitionItem.getDuration();
                if (i2 > 0) {
                    NexPrimaryTimelineItem nexPrimaryTimelineItem = this.m_primaryItems.get(i2 - 1);
                    if (nexPrimaryTimelineItem instanceof NexVideoClipItem) {
                        NexVideoClipItem nexVideoClipItem = (NexVideoClipItem) nexPrimaryTimelineItem;
                        int endOverlap = nexVideoClipItem.getEndOverlap();
                        if (z && transitionOffset < endOverlap) {
                            if (nexVideoClipItem.isImage()) {
                                nexVideoClipItem.setDuration(nexVideoClipItem.getDuration() - (endOverlap - transitionOffset));
                                z3 = true;
                            } else {
                                nexVideoClipItem.setTrimEnd(nexVideoClipItem.getTrimTimeEnd() + (endOverlap - transitionOffset));
                                z3 = true;
                            }
                        }
                        if (transitionOffset != endOverlap) {
                            nexVideoClipItem.setEndOverlap(transitionOffset);
                            z3 = true;
                        }
                    }
                }
                if (i2 + 1 < size) {
                    NexPrimaryTimelineItem nexPrimaryTimelineItem2 = this.m_primaryItems.get(i2 + 1);
                    if (nexPrimaryTimelineItem2 instanceof NexVideoClipItem) {
                        NexVideoClipItem nexVideoClipItem2 = (NexVideoClipItem) nexPrimaryTimelineItem2;
                        int startOverlap = nexVideoClipItem2.getStartOverlap();
                        int i3 = transitionOverlap + (duration - transitionOffset);
                        if (z && i3 < startOverlap) {
                            if (nexVideoClipItem2.isImage()) {
                                nexVideoClipItem2.setDuration(nexVideoClipItem2.getDuration() - (startOverlap - i3));
                                z3 = true;
                            } else {
                                nexVideoClipItem2.setTrimStart(nexVideoClipItem2.getTrimTimeStart() + (startOverlap - i3));
                                z3 = true;
                            }
                        }
                        if (i3 != startOverlap) {
                            nexVideoClipItem2.setStartOverlap(i3);
                            z2 = true;
                            i2++;
                            z3 = z2;
                        }
                    }
                }
            }
            z2 = z3;
            i2++;
            z3 = z2;
        }
        if (size > 0) {
            if (this.m_primaryItems.get(0).getStartOverlap() != 0) {
                ((NexVideoClipItem) this.m_primaryItems.get(0)).setStartOverlap(0);
                z3 = true;
            }
            if (this.m_primaryItems.get(size - 1).getEndOverlap() != 0) {
                ((NexVideoClipItem) this.m_primaryItems.get(size - 1)).setEndOverlap(0);
                z3 = true;
            }
        }
        int i4 = 0;
        int i5 = 0;
        boolean z4 = z3;
        while (i4 < size) {
            NexPrimaryTimelineItem nexPrimaryTimelineItem3 = this.m_primaryItems.get(i4);
            int startOverlap2 = nexPrimaryTimelineItem3 instanceof NexVideoClipItem ? nexPrimaryTimelineItem3.getStartOverlap() : 0;
            int endOverlap2 = nexPrimaryTimelineItem3 instanceof NexVideoClipItem ? nexPrimaryTimelineItem3.getEndOverlap() : 0;
            int representedDuration = nexPrimaryTimelineItem3.getRepresentedDuration();
            boolean z5 = nexPrimaryTimelineItem3.updateAbsStartEndTime(i5 - startOverlap2, endOverlap2 + (i5 + representedDuration)) ? true : z4;
            i4++;
            i5 += representedDuration;
            z4 = z5;
        }
        Collections.sort(this.m_secondaryItems);
        if (z4) {
            recalculateResourceUsage();
            this.b++;
        }
    }

    public TimelineResourceUsage.b getResourceUsageForItem(NexTimelineItem nexTimelineItem) {
        if (this.h == null) {
            this.h = new WeakHashMap<>();
        }
        TimelineResourceUsage.b bVar = this.h.get(nexTimelineItem);
        if (bVar == null) {
            TimelineResourceUsage.b a2 = getResourceUsage().a(nexTimelineItem.getAbsStartTime(), nexTimelineItem.getAbsEndTime());
            this.h.put(nexTimelineItem, a2);
            return a2;
        }
        return bVar;
    }

    public void recalculateResourceUsage() {
        if (this.d != null || this.e != null) {
            if (this.h == null) {
                this.h = new WeakHashMap<>();
            }
            this.d = null;
            this.e = null;
            this.h.clear();
            this.c++;
        }
        getResourceUsage();
    }

    public TimelineResourceUsage getAdjustedResourceUsage() {
        getResourceUsage();
        return this.e;
    }

    public TimelineResourceUsage getResourceUsage() {
        if (this.d == null || this.e == null) {
            d();
            this.d = new TimelineResourceUsage(this);
            this.e = this.d;
        }
        return this.d;
    }

    private void d() {
        Iterator<NexSecondaryTimelineItem> it = this.m_secondaryItems.iterator();
        while (it.hasNext()) {
            it.next().setOverLimit(false);
        }
    }

    public void dumpPrimaryTimeline(String str, String str2) {
    }

    public synchronized void addPrimaryItem(EffectLibrary effectLibrary, int i2, NexPrimaryTimelineItem nexPrimaryTimelineItem) {
        a(effectLibrary, i2, nexPrimaryTimelineItem, true);
    }

    private synchronized void a(EffectLibrary effectLibrary, int i2, NexPrimaryTimelineItem nexPrimaryTimelineItem, boolean z) {
        dumpPrimaryTimeline("NexTimeline", "addPrimaryItem/IN");
        Theme e = effectLibrary.e(getThemeId());
        if (nexPrimaryTimelineItem instanceof NexTransitionItem) {
            throw new IllegalStateException("Cannot add a transition to a timeline explicitly");
        }
        int size = this.m_primaryItems.size();
        if (i2 == 0 && size == 0) {
            this.m_primaryItems.add(nexPrimaryTimelineItem);
            if (z) {
                nexPrimaryTimelineItem.wasAddedToTimeline(this);
            }
        } else if (i2 > size && size % 2 == 1) {
            NexTransitionItem transition = this.m_primaryItems.get(size - 1).getTransition();
            this.m_primaryItems.add(size, transition);
            this.m_primaryItems.add(size + 1, nexPrimaryTimelineItem);
            if (z) {
                nexPrimaryTimelineItem.wasAddedToTimeline(this);
                transition.wasAddedToTimeline(this);
                transition.onThemeChanged(e, effectLibrary);
            }
        } else if (i2 % 2 == 0) {
            NexTransitionItem transition2 = nexPrimaryTimelineItem.getTransition();
            this.m_primaryItems.add(i2, nexPrimaryTimelineItem.getTransition());
            this.m_primaryItems.add(i2, nexPrimaryTimelineItem);
            if (z) {
                nexPrimaryTimelineItem.wasAddedToTimeline(this);
                transition2.wasAddedToTimeline(this);
                transition2.onThemeChanged(e, effectLibrary);
            }
        } else {
            throw new IllegalStateException("Cannot add a clip between another clip and that clip's attached transition");
        }
        dumpPrimaryTimeline("NexTimeline", "addPrimaryItem/BCALC");
        requestCalcTimes();
        dumpPrimaryTimeline("NexTimeline", "addPrimaryItem/OUT");
    }

    public synchronized void addPrimaryItem(EffectLibrary effectLibrary, NexPrimaryTimelineItem nexPrimaryTimelineItem) {
        addPrimaryItem(effectLibrary, this.m_primaryItems.size(), nexPrimaryTimelineItem);
    }

    public synchronized void addSecondaryItem(NexSecondaryTimelineItem nexSecondaryTimelineItem) {
        this.m_secondaryItems.add(nexSecondaryTimelineItem);
        nexSecondaryTimelineItem.wasAddedToTimeline(this);
        requestCalcTimes();
    }

    public synchronized void deletePrimaryItem(int i2) {
        a(i2, true);
    }

    public int getIndexOfPrimaryItem(NexPrimaryTimelineItem nexPrimaryTimelineItem) {
        return this.m_primaryItems.indexOf(nexPrimaryTimelineItem);
    }

    public int getIndexOfSecondaryItem(NexSecondaryTimelineItem nexSecondaryTimelineItem) {
        return this.m_secondaryItems.indexOf(nexSecondaryTimelineItem);
    }

    private void a(NexTimelineItem nexTimelineItem) {
        if (nexTimelineItem.getUniqueId() == null) {
            nexTimelineItem.setUniqueId(UUID.randomUUID());
        }
    }

    public void ensureItemsHaveUniqueIds() {
        Iterator<NexPrimaryTimelineItem> it = this.m_primaryItems.iterator();
        while (it.hasNext()) {
            a(it.next());
        }
        Iterator<NexSecondaryTimelineItem> it2 = this.m_secondaryItems.iterator();
        while (it2.hasNext()) {
            a(it2.next());
        }
        int[] bookmarks = getBookmarks();
        clearAllBookmarks();
        for (int i2 : bookmarks) {
            addBookmark(i2);
        }
    }

    public NexTimelineItem findItemByUniqueId(UUID uuid) {
        ensureItemsHaveUniqueIds();
        for (NexPrimaryTimelineItem nexPrimaryTimelineItem : this.m_primaryItems) {
            if (nexPrimaryTimelineItem.getUniqueId().equals(uuid)) {
                return nexPrimaryTimelineItem;
            }
        }
        for (NexSecondaryTimelineItem nexSecondaryTimelineItem : this.m_secondaryItems) {
            if (nexSecondaryTimelineItem.getUniqueId().equals(uuid)) {
                return nexSecondaryTimelineItem;
            }
        }
        if (this.j != null && this.j.getUniqueId().equals(uuid)) {
            return this.j;
        }
        return null;
    }

    public void movePrimaryItem(EffectLibrary effectLibrary, int i2, int i3) {
        NexPrimaryTimelineItem primaryItem = getPrimaryItem(i2);
        int primaryItemCount = getPrimaryItemCount();
        if (i3 > i2) {
            a(effectLibrary, i3, primaryItem, true);
            a(i2, false);
            if (i3 >= primaryItemCount) {
                if (primaryItemCount >= 3) {
                    getPrimaryItem(primaryItemCount - 3).getTransition().wasAddedToTimeline(this);
                }
                primaryItem.getTransition().wasRemovedFromTimeline(this);
            }
        } else {
            a(i2, false);
            a(effectLibrary, i3, primaryItem, true);
            if (i2 + 1 == primaryItemCount) {
                getPrimaryItem(primaryItemCount - 1).getTransition().wasRemovedFromTimeline(this);
                primaryItem.getTransition().wasAddedToTimeline(this);
            }
        }
        requestCalcTimes();
    }

    private synchronized void a(int i2, boolean z) {
        if (i2 % 2 == 0) {
            if (i2 + 1 < this.m_primaryItems.size()) {
                NexPrimaryTimelineItem nexPrimaryTimelineItem = this.m_primaryItems.get(i2);
                NexPrimaryTimelineItem nexPrimaryTimelineItem2 = this.m_primaryItems.get(i2 + 1);
                this.m_primaryItems.remove(i2 + 1);
                this.m_primaryItems.remove(i2);
                if (z) {
                    nexPrimaryTimelineItem.wasRemovedFromTimeline(this);
                    nexPrimaryTimelineItem2.wasRemovedFromTimeline(this);
                }
                requestCalcTimes();
            } else if (i2 - 1 >= 0) {
                NexPrimaryTimelineItem nexPrimaryTimelineItem3 = this.m_primaryItems.get(i2);
                NexPrimaryTimelineItem nexPrimaryTimelineItem4 = this.m_primaryItems.get(i2 - 1);
                if (z) {
                    nexPrimaryTimelineItem3.wasRemovedFromTimeline(this);
                    nexPrimaryTimelineItem4.wasRemovedFromTimeline(this);
                }
                this.m_primaryItems.remove(i2);
                this.m_primaryItems.remove(i2 - 1);
                requestCalcTimes();
            }
        }
        this.m_primaryItems.remove(i2);
        requestCalcTimes();
    }

    public synchronized void deleteSecondaryItem(int i2) {
        NexSecondaryTimelineItem nexSecondaryTimelineItem = this.m_secondaryItems.get(i2);
        this.m_secondaryItems.remove(i2);
        nexSecondaryTimelineItem.wasRemovedFromTimeline(this);
        requestCalcTimes();
    }

    public synchronized void deleteSecondaryItem(NexSecondaryTimelineItem nexSecondaryTimelineItem) {
        if (this.m_secondaryItems.contains(nexSecondaryTimelineItem)) {
            this.m_secondaryItems.remove(nexSecondaryTimelineItem);
            nexSecondaryTimelineItem.wasRemovedFromTimeline(this);
            requestCalcTimes();
        }
    }

    public int getPrimaryItemCount() {
        return this.m_primaryItems.size();
    }

    public int getSecondaryItemCount() {
        return this.m_secondaryItems.size();
    }

    public NexPrimaryTimelineItem getPrimaryItem(int i2) {
        return this.m_primaryItems.get(i2);
    }

    public NexPrimaryTimelineItem[] getPrimaryItemsAtTime(int i2) {
        int primaryItemCount = getPrimaryItemCount();
        NexPrimaryTimelineItem[] nexPrimaryTimelineItemArr = new NexPrimaryTimelineItem[3];
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i3 >= primaryItemCount) {
                break;
            }
            NexPrimaryTimelineItem primaryItem = getPrimaryItem(i3);
            if (i2 >= primaryItem.getAbsStartTime() && i2 <= primaryItem.getAbsEndTime()) {
                if (i4 >= nexPrimaryTimelineItemArr.length) {
                    Log.w("NexTimeline", "getPrimaryItemsAtTime : more than 2 items detected at this time; internal consistency error");
                    break;
                }
                nexPrimaryTimelineItemArr[i4] = primaryItem;
                i4++;
            }
            i3++;
        }
        NexPrimaryTimelineItem[] nexPrimaryTimelineItemArr2 = new NexPrimaryTimelineItem[i4];
        for (int i5 = 0; i5 < i4; i5++) {
            nexPrimaryTimelineItemArr2[i5] = nexPrimaryTimelineItemArr[i5];
        }
        return nexPrimaryTimelineItemArr2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002a, code lost:            return (com.nextreaming.nexeditorui.NexVideoClipItem) r0;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.nextreaming.nexeditorui.NexVideoClipItem getFirstVideoClipAtTime(int r6) {
        /*
            r5 = this;
            r0 = -1
            java.util.List<com.nextreaming.nexeditorui.NexPrimaryTimelineItem> r1 = r5.m_primaryItems
            java.util.Iterator r3 = r1.iterator()
            r1 = r0
        L8:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L2e
            java.lang.Object r0 = r3.next()
            com.nextreaming.nexeditorui.NexPrimaryTimelineItem r0 = (com.nextreaming.nexeditorui.NexPrimaryTimelineItem) r0
            boolean r2 = r0 instanceof com.nextreaming.nexeditorui.NexVideoClipItem
            if (r2 == 0) goto L30
            int r4 = r0.getAbsStartTime()
            int r2 = r0.getAbsEndTime()
            if (r6 < r4) goto L24
            if (r6 < r2) goto L28
        L24:
            if (r1 >= r6) goto L2b
            if (r4 <= r6) goto L2b
        L28:
            com.nextreaming.nexeditorui.NexVideoClipItem r0 = (com.nextreaming.nexeditorui.NexVideoClipItem) r0
        L2a:
            return r0
        L2b:
            r0 = r2
        L2c:
            r1 = r0
            goto L8
        L2e:
            r0 = 0
            goto L2a
        L30:
            r0 = r1
            goto L2c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nextreaming.nexeditorui.NexTimeline.getFirstVideoClipAtTime(int):com.nextreaming.nexeditorui.NexVideoClipItem");
    }

    public NexPrimaryTimelineItem getPrimaryItemById(int i2, String str) {
        int i3 = 0;
        int primaryItemCount = getPrimaryItemCount();
        for (int i4 = 0; i4 < primaryItemCount; i4++) {
            NexPrimaryTimelineItem primaryItem = getPrimaryItem(i4);
            if ((primaryItem instanceof NexVideoClipItem) && ((NexVideoClipItem) primaryItem).getEngineClipID() == i2) {
                return primaryItem;
            }
        }
        String str2 = "";
        while (i3 < primaryItemCount) {
            NexPrimaryTimelineItem primaryItem2 = getPrimaryItem(i3);
            i3++;
            str2 = primaryItem2 instanceof NexVideoClipItem ? str2 + " " + ((NexVideoClipItem) primaryItem2).getEngineClipID() : str2;
        }
        throw new ClipNotFoundException("" + i2 + " not found in [" + str2 + " ] " + str);
    }

    public int nextAvailableEngineClipId() {
        int i2;
        int engineClipID;
        int engineClipID2;
        int engineClipID3;
        int i3 = LicenseErrCode.LICENSE_STATUS_NOT_LICENSED;
        Iterator<NexPrimaryTimelineItem> it = this.m_primaryItems.iterator();
        while (true) {
            i2 = i3;
            if (!it.hasNext()) {
                break;
            }
            NexPrimaryTimelineItem next = it.next();
            if ((next instanceof NexVideoClipItem) && i2 <= (engineClipID3 = ((NexVideoClipItem) next).getEngineClipID())) {
                i2 = engineClipID3 + 1;
            }
            i3 = i2;
        }
        Iterator<NexSecondaryTimelineItem> it2 = this.m_secondaryItems.iterator();
        while (true) {
            int i4 = i2;
            if (it2.hasNext()) {
                NexSecondaryTimelineItem next2 = it2.next();
                if ((next2 instanceof NexAudioClipItem) && i4 <= (engineClipID2 = ((NexAudioClipItem) next2).getEngineClipID())) {
                    i4 = engineClipID2 + 1;
                }
                if ((next2 instanceof VideoLayer) && i4 <= (engineClipID = ((VideoLayer) next2).getEngineClipID())) {
                    i4 = engineClipID + 1;
                }
                i2 = i4;
            } else {
                return i4;
            }
        }
    }

    public void applyFinalPathForMSID(MSID msid, String str, NexVideoClipItem.CropMode cropMode, int i2) {
        Iterator<NexPrimaryTimelineItem> it = this.m_primaryItems.iterator();
        while (it.hasNext()) {
            it.next().applyFinalPath(msid, str, cropMode, i2);
        }
        Iterator<NexSecondaryTimelineItem> it2 = this.m_secondaryItems.iterator();
        while (it2.hasNext()) {
            it2.next().applyFinalPath(msid, str, cropMode, i2);
        }
        c();
    }

    /* loaded from: classes.dex */
    public static class ClipNotFoundException extends RuntimeException {
        private static final long serialVersionUID = 1;

        public ClipNotFoundException(String str) {
            super(str);
        }
    }

    public NexSecondaryTimelineItem getSecondaryItem(int i2) {
        return this.m_secondaryItems.get(i2);
    }

    public void clearTimeline() {
        this.m_primaryItems.clear();
        this.m_secondaryItems.clear();
    }

    public NexProjectHeader getProjectHeader() {
        if (this.k == null) {
            this.k = new NexProjectHeader();
            this.k.creationTime = new Date();
        }
        if (this.k.projectUUID == null) {
            this.k.projectUUID = UUID.randomUUID();
        }
        return this.k;
    }

    public void setProjectheader(NexProjectHeader nexProjectHeader) {
        this.k = nexProjectHeader;
        if (this.k.projectUUID == null) {
            this.k.projectUUID = UUID.randomUUID();
        }
    }

    public String getThemeId() {
        return this.m_themeId == null ? "com.nexstreaming.kinemaster.basic" : this.m_themeId;
    }

    public void setThemeId(String str) {
        EffectLibrary q;
        if (str != null && !str.equals(this.m_themeId)) {
            this.m_themeId = str;
            if (EditorGlobal.a() != null && (q = EditorGlobal.a().q()) != null) {
                Theme e = q.e(this.m_themeId);
                q.g(this.m_themeId);
                Theme e2 = e == null ? q.e("com.nexstreaming.kinemaster.basic") : e;
                if (e2 != null) {
                    Iterator<NexPrimaryTimelineItem> it = this.m_primaryItems.iterator();
                    while (it.hasNext()) {
                        it.next().onThemeChanged(e2, q);
                    }
                    Iterator<NexSecondaryTimelineItem> it2 = this.m_secondaryItems.iterator();
                    while (it2.hasNext()) {
                        it2.next().onThemeChanged(e2, q);
                    }
                }
            }
        }
    }

    public int getTotalTime() {
        if (this.m_primaryItems.size() < 1) {
            return 0;
        }
        return this.m_primaryItems.get(this.m_primaryItems.size() - 1).getAbsEndTime();
    }

    public int getTotalSecondaryTime() {
        if (this.m_secondaryItems.size() < 1) {
            return 0;
        }
        int size = this.m_secondaryItems.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 = Math.max(i2, this.m_secondaryItems.get(i3).getAbsEndTime());
        }
        return i2;
    }

    public int freeSpaceAtTime(int i2, int i3, int i4, boolean z) {
        return freeSpaceAtTime(i2, i3, i4, null, 0, z);
    }

    public int freeSpaceAtTime(int i2, int i3, int i4, NexTimelineItem nexTimelineItem, int i5, boolean z) {
        int i6;
        int totalTime = getTotalTime();
        int secondaryItemCount = getSecondaryItemCount();
        int[] iArr = new int[i3];
        for (int i7 = 0; i7 < iArr.length; i7++) {
            iArr[i7] = 0;
        }
        int i8 = 0;
        int i9 = 0;
        while (i9 < secondaryItemCount) {
            NexSecondaryTimelineItem secondaryItem = getSecondaryItem(i9);
            if (secondaryItem == nexTimelineItem) {
                i6 = i8;
            } else {
                int absStartTime = secondaryItem.getAbsStartTime();
                int absEndTime = secondaryItem.getAbsEndTime();
                int i10 = -1;
                int i11 = 0;
                for (int i12 = 0; i12 < iArr.length; i12++) {
                    if (absStartTime >= iArr[i12]) {
                        i11++;
                        if (i10 == -1) {
                            i10 = i12;
                        }
                    }
                }
                if (i10 == -1) {
                    i6 = i8;
                } else {
                    iArr[i10] = absEndTime;
                    if (i11 - 1 < 1) {
                        i6 = iArr[0];
                        for (int i13 = 1; i13 < iArr.length; i13++) {
                            if (iArr[i13] < i6) {
                                i6 = iArr[i13];
                            }
                        }
                        if (z) {
                            if (i6 < i2) {
                                continue;
                            } else {
                                if (absStartTime <= i2) {
                                    return 0;
                                }
                                if (absStartTime > i2) {
                                    return (i2 - i8) - 1;
                                }
                            }
                        } else if (i6 < i2) {
                            i6 = i8;
                        } else {
                            if (absStartTime <= i2) {
                                return 0;
                            }
                            if (absStartTime > i2) {
                                if (absStartTime > totalTime) {
                                    return Math.max(0, totalTime - i2);
                                }
                                return Math.max(0, (absStartTime - i2) - i4);
                            }
                        }
                    }
                    i6 = i8;
                }
            }
            i9++;
            i8 = i6;
        }
        return z ? Math.max(0, (i2 - i8) - 1) : Math.max(0, (totalTime - i2) + i5);
    }

    public boolean validateTimeline() {
        EditorGlobal.a aVar;
        boolean z;
        boolean z2 = true;
        int secondaryItemCount = getSecondaryItemCount();
        int[] iArr = new int[3];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr[i2] = 0;
        }
        int i3 = 0;
        EditorGlobal.a aVar2 = null;
        while (i3 < secondaryItemCount) {
            NexSecondaryTimelineItem secondaryItem = getSecondaryItem(i3);
            int absStartTime = secondaryItem.getAbsStartTime();
            int i4 = absStartTime < 0 ? 0 : absStartTime;
            int absEndTime = secondaryItem.getAbsEndTime();
            int i5 = absEndTime - (absEndTime % 100);
            if (i4 > i5) {
                if (aVar2 == null) {
                    aVar2 = new EditorGlobal.a("timeline_validation");
                }
                aVar2.a("NexTimeline", "validateTimeline() : PROBLEM FOUND -> startTime > endTime : itemIdx(" + i3 + ") startTime(" + i4 + ") endTime(" + i5 + ")");
                aVar = aVar2;
                z = false;
            } else {
                boolean z3 = z2;
                aVar = aVar2;
                z = z3;
            }
            int i6 = 0;
            int i7 = -1;
            for (int i8 = 0; i8 < iArr.length; i8++) {
                if (i4 >= iArr[i8]) {
                    i6++;
                    if (i7 == -1) {
                        i7 = i8;
                    }
                }
            }
            if (i7 == -1) {
                if (aVar == null) {
                    aVar = new EditorGlobal.a("timeline_validation");
                }
                aVar.a("NexTimeline", "validateTimeline() : PROBLEM FOUND -> Too many secondary items : itemIdx(" + i3 + ") startTime(" + i4 + ")");
                z = false;
            } else {
                iArr[i7] = i5;
                int i9 = i6 - 1;
            }
            i3++;
            boolean z4 = z;
            aVar2 = aVar;
            z2 = z4;
        }
        if (!z2) {
            dumpSecondaryTimeline(aVar2);
        }
        return z2;
    }

    public void dumpSecondaryTimeline(EditorGlobal.a aVar) {
        if (aVar == null) {
            aVar = new EditorGlobal.a("timeline_validation");
        }
        EditorGlobal.h().mkdirs();
        new File(EditorGlobal.h(), "timeline_validation.log");
        int secondaryItemCount = getSecondaryItemCount();
        for (int i2 = 0; i2 < secondaryItemCount; i2++) {
            NexSecondaryTimelineItem secondaryItem = getSecondaryItem(i2);
            int duration = secondaryItem.getDuration();
            aVar.a("NexTimeline", "    " + i2 + ": " + secondaryItem.getAbsStartTime() + "->" + secondaryItem.getAbsEndTime() + "  (" + duration + ")");
            if (secondaryItem instanceof NexAudioClipItem) {
                NexAudioClipItem nexAudioClipItem = (NexAudioClipItem) secondaryItem;
                String mediaPath = nexAudioClipItem.getMediaPath();
                if (mediaPath == null) {
                    mediaPath = "(null)";
                }
                aVar.a("NexTimeline", "        AUDIO: rel(" + nexAudioClipItem.getRelativeStartTime() + "," + nexAudioClipItem.getRelativeEndTime() + ") extra(" + nexAudioClipItem.getExtraRelativeStartTime() + ") videoStart(" + nexAudioClipItem.getVideoClip().getEngineClipID() + "/" + nexAudioClipItem.getVideoClip().getAbsStartTime() + ")");
                aVar.a("NexTimeline", "                  media-a: " + mediaPath);
                aVar.a("NexTimeline", "                  media-v: " + nexAudioClipItem.getVideoClip().getMediaPath());
            }
        }
    }

    public boolean getThemeMusicMute() {
        return !this.m_themeMusicEnable;
    }

    public void applyProjectSettingsToEditor(NexEditor nexEditor, EffectLibrary effectLibrary) {
        if (nexEditor == null || effectLibrary == null) {
            nexEditor.a((File) null);
            return;
        }
        if (this.f4491a < 3) {
            if (getThemeMusicMute()) {
                nexEditor.a((File) null);
            } else {
                String customBGMusic = getCustomBGMusic();
                if (customBGMusic == null || customBGMusic.equals("@themeauto")) {
                    nexEditor.a(effectLibrary.h(getThemeId()));
                } else if (customBGMusic.startsWith("@theme:")) {
                    nexEditor.a(effectLibrary.h(customBGMusic.substring(7)));
                } else {
                    nexEditor.a(new File(customBGMusic));
                }
                nexEditor.setBackgroundMusicVolume(getThemeMusicVolume(), 0, 0);
            }
        }
        applyVolumeFadingToEditor(nexEditor);
    }

    public void applyVolumeFadingToEditor(NexEditor nexEditor) {
        int projectAudioFadeInTimeMillis = !isProjectAudioFadeInTimeOn() ? 0 : getProjectAudioFadeInTimeMillis();
        int projectAudioFadeOutTimeMillis = isProjectAudioFadeOutTimeOn() ? getProjectAudioFadeOutTimeMillis() : 0;
        int totalTime = getTotalTime();
        if (projectAudioFadeInTimeMillis + projectAudioFadeOutTimeMillis > totalTime) {
            projectAudioFadeInTimeMillis = (projectAudioFadeInTimeMillis * totalTime) / (projectAudioFadeInTimeMillis + projectAudioFadeOutTimeMillis);
            projectAudioFadeOutTimeMillis = totalTime - projectAudioFadeInTimeMillis;
        }
        nexEditor.setProjectVolumeFade(projectAudioFadeInTimeMillis, projectAudioFadeOutTimeMillis);
    }

    public File resolveMusicPath(String str) {
        EffectLibrary e = KineMasterApplication.a().e();
        if (e == null || str == null) {
            return null;
        }
        if (str.equals("@themeauto")) {
            return e.h(getThemeId());
        }
        if (str.startsWith("@theme:")) {
            return e.h(str.substring(7));
        }
        return new File(str);
    }

    @Deprecated
    public void setCustomBGMusic(String str, String str2) {
        if (com.nexstreaming.app.general.util.v.a(this.m_customBackgroundMusicPath, str) != 0) {
            this.m_customBackgroundMusicPath = str;
            this.m_customBackgroundMusicTitle = str2;
            if (this.j != null) {
                this.j.setCustomBGMusic(this.m_customBackgroundMusicPath, this.m_customBackgroundMusicTitle);
            }
        }
    }

    @Deprecated
    public String getCustomBGMusic() {
        return this.m_customBackgroundMusicPath;
    }

    @Deprecated
    public String getCustomBGMTitle() {
        return this.m_customBackgroundMusicTitle;
    }

    @Deprecated
    public void setThemeMusicMute(boolean z) {
        if (this.m_themeMusicEnable != (!z)) {
            this.m_themeMusicEnable = !z;
            if (this.j != null) {
                this.j.setMuteAudio(this.m_themeMusicEnable ? false : true);
            }
        }
    }

    public int getThemeMusicVolume() {
        return this.m_themeMusicVolume;
    }

    public void setThemeMusicVolume(int i2) {
        if (this.m_themeMusicVolume != i2) {
            this.m_themeMusicVolume = i2;
            if (this.j != null) {
                this.j.setClipVolume(this.m_themeMusicVolume);
            }
        }
    }

    public int getRecentScrollTime() {
        return this.m_recentScrollTime;
    }

    public void setRecentScrollTime(int i2) {
        this.m_recentScrollTime = i2;
    }

    @Deprecated
    public NexAudioClipItem getBGMAudioClip(Resources resources) {
        if (this.f4491a >= 3) {
            return null;
        }
        if (this.j != null) {
            return this.j;
        }
        this.j = new NexAudioClipItem(true);
        this.j.wasAddedToTimeline(this);
        a(this.j);
        this.j.setClipVolume(this.m_themeMusicVolume);
        this.j.setMuteAudio(this.m_themeMusicEnable ? false : true);
        this.j.setCustomBGMusic(this.m_customBackgroundMusicPath, this.m_customBackgroundMusicTitle);
        return this.j;
    }

    public void upgradeToLatestVersion(EffectLibrary effectLibrary, int i2) {
        this.m = i2;
        if (this.m_timelimeFormatVersion < 5) {
            Log.i("NexTimeline", "Upgrade " + this.m_timelimeFormatVersion + " to 5 (IN)");
            if (this.m_timelimeFormatVersion < 2) {
                if (this.m_themeId == null && this.m_themeId.trim().length() < 1) {
                    this.m_themeId = "com.nexstreaming.kinemaster.basic";
                } else if (!this.m_themeId.contains(".")) {
                    String[][] strArr = {new String[]{"3D Theme", "com.nexstreaming.kinemaster.threed"}, new String[]{"Album Theme", "com.nexstreaming.kinemaster.album"}, new String[]{"km_theme_baby", "com.nexstreaming.kinemaster.baby"}, new String[]{"Basic Theme", "com.nexstreaming.kinemaster.basic"}, new String[]{"Cloudy Theme", "com.nexstreaming.kinemaster.cloudy"}, new String[]{"Energy", "com.nexstreaming.kinemaster.energy"}, new String[]{"Fun Theme", "com.nexstreaming.kinemaster.fun"}, new String[]{"Love Theme", "com.nexstreaming.kinemaster.love"}, new String[]{"Museum Theme", "com.nexstreaming.kinemaster.museum"}, new String[]{"km_theme_nature", "com.nexstreaming.kinemaster.nature"}, new String[]{"On-Stage Theme", "com.nexstreaming.kinemaster.onstage"}, new String[]{"Serene Theme", "com.nexstreaming.kinemaster.serene"}, new String[]{"Snow Theme", "com.nexstreaming.kinemaster.snow"}, new String[]{"Travel", "com.nexstreaming.kinemaster.travel"}};
                    int length = strArr.length;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= length) {
                            break;
                        }
                        String[] strArr2 = strArr[i3];
                        if (!strArr2[0].equals(this.m_themeId)) {
                            i3++;
                        } else {
                            this.m_themeId = strArr2[1];
                            break;
                        }
                    }
                }
                Theme e = effectLibrary.e(this.m_themeId);
                if (e == null) {
                    e = effectLibrary.e("com.nexstreaming.kinemaster.basic");
                    this.m_themeId = "com.nexstreaming.kinemaster.basic";
                }
                Theme theme = e;
                if (theme != null) {
                    Iterator<NexPrimaryTimelineItem> it = this.m_primaryItems.iterator();
                    while (it.hasNext()) {
                        it.next().onThemeChanged(theme, effectLibrary);
                    }
                    Iterator<NexSecondaryTimelineItem> it2 = this.m_secondaryItems.iterator();
                    while (it2.hasNext()) {
                        it2.next().onThemeChanged(theme, effectLibrary);
                    }
                }
            }
            if (this.m_timelimeFormatVersion < 3 && this.m_projectAudioFadeInTime == 0.0f && this.m_projectAudioFadeOutTime == 0.0f) {
                this.m_projectAudioFadeInTime = 0.2f;
                this.m_projectAudioFadeOutTime = 4.0f;
                this.m_isProjectAudioFadeInOn = false;
                this.m_isProjectAudioFadeOutOn = false;
            }
            if (this.m_timelimeFormatVersion < 4) {
                c();
                for (NexPrimaryTimelineItem nexPrimaryTimelineItem : this.m_primaryItems) {
                    if (nexPrimaryTimelineItem instanceof NexTransitionItem) {
                        ((NexTransitionItem) nexPrimaryTimelineItem).updateOffsetOverlap();
                    }
                }
                a(true);
            }
            if (this.m_timelimeFormatVersion < 5) {
                for (NexPrimaryTimelineItem nexPrimaryTimelineItem2 : this.m_primaryItems) {
                    if (nexPrimaryTimelineItem2 instanceof NexVideoClipItem) {
                        NexVideoClipItem nexVideoClipItem = (NexVideoClipItem) nexPrimaryTimelineItem2;
                        if (nexVideoClipItem.isPreset()) {
                            Rect rect = new Rect(3, 3, nexVideoClipItem.getWidth() - 3, nexVideoClipItem.getHeight() - 3);
                            nexVideoClipItem.setStartPosition(rect);
                            nexVideoClipItem.setEndPosition(rect);
                        }
                    }
                }
            }
            Log.i("NexTimeline", "Upgrade " + this.m_timelimeFormatVersion + " to 5 (OUT)");
            this.m_timelimeFormatVersion = 5;
        }
    }

    public int getAppVersionCode() {
        return this.m;
    }

    @Deprecated
    public int getMaxSimultaneousAudioTrackCount() {
        return this.m_simulAudioTracks;
    }

    @Deprecated
    public void setMaxSimultaneousAudioTrackCount(int i2) {
        this.m_simulAudioTracks = i2;
    }

    public ProjectAspectRatio getProjectRatio() {
        if (this.m_projectRatio == null || this.m_projectRatio.equals("")) {
            this.m_projectRatio = ProjectAspectRatio.R_16_9;
        }
        return this.m_projectRatio;
    }

    public void setProjectRatio(ProjectAspectRatio projectAspectRatio) {
        this.m_projectRatio = projectAspectRatio;
    }

    public void setProjectAudioFadeInTimeOn(boolean z) {
        this.m_isProjectAudioFadeInOn = z;
    }

    public void setProjectAudioFadeOutTimeOn(boolean z) {
        this.m_isProjectAudioFadeOutOn = z;
    }

    public boolean isProjectAudioFadeInTimeOn() {
        return this.m_isProjectAudioFadeInOn;
    }

    public boolean isProjectAudioFadeOutTimeOn() {
        return this.m_isProjectAudioFadeOutOn;
    }

    public void setProjectAudioFadeInTimeMillis(int i2) {
        this.m_projectAudioFadeInTime = i2 / 1000.0f;
    }

    public void setProjectAudioFadeOutTimeMillis(int i2) {
        this.m_projectAudioFadeOutTime = i2 / 1000.0f;
    }

    public int getProjectAudioFadeInTimeMillis() {
        return this.m_projectAudioFadeInTime > 100.0f ? (int) this.m_projectAudioFadeInTime : (int) (this.m_projectAudioFadeInTime * 1000.0f);
    }

    public int getProjectAudioFadeOutTimeMillis() {
        return this.m_projectAudioFadeOutTime > 100.0f ? (int) this.m_projectAudioFadeOutTime : (int) (this.m_projectAudioFadeOutTime * 1000.0f);
    }

    public void setProjectVideoFadeInTimeOn(boolean z) {
        this.m_isProjectVideoFadeInOn = z;
    }

    public void setProjectVideoFadeOutTimeOn(boolean z) {
        this.m_isProjectVideoFadeOutOn = z;
    }

    public boolean isProjectVideoFadeInTimeOn() {
        return this.m_isProjectVideoFadeInOn;
    }

    public boolean isProjectVideoFadeOutTimeOn() {
        return this.m_isProjectVideoFadeOutOn;
    }

    public void setProjectVideoFadeInTimeMillis(int i2) {
        this.m_projectVideoFadeInTime = i2 / 1000.0f;
    }

    public void setProjectVideoFadeOutTimeMillis(int i2) {
        this.m_projectVideoFadeOutTime = i2 / 1000.0f;
    }

    public int getProjectVideoFadeInTimeMillis() {
        return (int) (this.m_projectVideoFadeInTime * 1000.0f);
    }

    public int getProjectVideoFadeOutTimeMillis() {
        return (int) (this.m_projectVideoFadeOutTime * 1000.0f);
    }

    public LruCache<UUID, Bitmap> getThumbnailCache() {
        if (this.n == null) {
            this.n = new LruCache<>(150);
        }
        return this.n;
    }

    public KMProto.KMProject asProtoBuf() {
        KMProto.KMProject.Builder builder = new KMProto.KMProject.Builder();
        builder.primary_items = new ArrayList();
        for (NexPrimaryTimelineItem nexPrimaryTimelineItem : this.m_primaryItems) {
            KMProto.KMProject.TimelineItem asProtoBuf = nexPrimaryTimelineItem.asProtoBuf();
            if (asProtoBuf != null) {
                builder.primary_items.add(asProtoBuf);
            } else if (System.currentTimeMillis() - i > 120000) {
                i = System.currentTimeMillis();
                Toast.makeText(KineMasterApplication.a().getApplicationContext(), "No Serializer: " + nexPrimaryTimelineItem.getClass().getName(), 0).show();
            }
        }
        builder.secondary_items = new ArrayList();
        for (NexSecondaryTimelineItem nexSecondaryTimelineItem : this.m_secondaryItems) {
            KMProto.KMProject.TimelineItem asProtoBuf2 = nexSecondaryTimelineItem.asProtoBuf();
            if (asProtoBuf2 != null) {
                builder.secondary_items.add(asProtoBuf2);
            } else if (System.currentTimeMillis() - i > 120000) {
                i = System.currentTimeMillis();
                Toast.makeText(KineMasterApplication.a().getApplicationContext(), "No Serializer: " + nexSecondaryTimelineItem.getClass().getName(), 0).show();
            }
        }
        if (this.m_bookmarks != null) {
            builder.bookmarks = new ArrayList();
            builder.bookmarks.addAll(this.m_bookmarks);
        }
        builder.project_ratio = this.m_projectRatio == null ? null : this.m_projectRatio.asProtoBuf();
        return builder.timeline_format_version(Integer.valueOf(this.m_timelimeFormatVersion)).recent_scroll_time(Integer.valueOf(this.m_recentScrollTime)).project_audio_fade_in_time(Float.valueOf(this.m_projectAudioFadeInTime)).project_audio_fade_out_time(Float.valueOf(this.m_projectAudioFadeOutTime)).is_project_audio_fade_in_on(Boolean.valueOf(this.m_isProjectAudioFadeInOn)).is_project_audio_fade_out_on(Boolean.valueOf(this.m_isProjectAudioFadeOutOn)).project_video_fade_in_time(Float.valueOf(this.m_projectVideoFadeInTime)).project_video_fade_out_time(Float.valueOf(this.m_projectVideoFadeOutTime)).is_project_video_fade_in_on(Boolean.valueOf(this.m_isProjectVideoFadeInOn)).is_project_video_fade_out_on(Boolean.valueOf(this.m_isProjectVideoFadeOutOn)).build();
    }

    public static NexPrimaryTimelineItem primaryItemFromProtoBuf(KMProto.KMProject.TimelineItem timelineItem) {
        switch (timelineItem.clip_type) {
            case TRANSITION:
                return NexTransitionItem.fromProtoBuf(timelineItem);
            case VISUAL_CLIP:
                return NexVideoClipItem.fromProtoBuf(timelineItem);
            default:
                return null;
        }
    }

    public static NexSecondaryTimelineItem secondaryItemFromProtoBuf(KMProto.KMProject.TimelineItem timelineItem) {
        switch (timelineItem.clip_type) {
            case AUDIO_CLIP:
                return NexAudioClipItem.fromProtoBuf(timelineItem);
            case LAYER_HANDWRITING:
                return HandwritingLayer.fromProtoBuf(timelineItem);
            case LAYER_STICKER:
                return StickerLayer.fromProtoBuf(timelineItem);
            case LAYER_TEXT:
                return TextLayer.fromProtoBuf(timelineItem);
            case LAYER_IMAGE:
                return ImageLayer.fromProtoBuf(timelineItem);
            case LAYER_EFFECT:
                return EffectLayer.fromProtoBuf(timelineItem);
            case LAYER_VIDEO:
                return VideoLayer.fromProtoBuf(timelineItem);
            default:
                return null;
        }
    }

    public static NexTimeline fromProtoBuf(KMProto.KMProject kMProject) {
        NexTimeline nexTimeline = new NexTimeline();
        nexTimeline.m_bookmarks = new HashSet(kMProject.bookmarks);
        nexTimeline.m_projectRatio = ProjectAspectRatio.fromProtoBuf(kMProject.project_ratio);
        nexTimeline.m_timelimeFormatVersion = kMProject.timeline_format_version.intValue();
        nexTimeline.m_recentScrollTime = kMProject.recent_scroll_time.intValue();
        if (kMProject.project_video_fade_in_time != null && kMProject.project_video_fade_out_time != null && kMProject.is_project_video_fade_in_on != null && kMProject.is_project_video_fade_out_on != null) {
            nexTimeline.m_projectVideoFadeInTime = kMProject.project_video_fade_in_time.floatValue();
            nexTimeline.m_projectVideoFadeOutTime = kMProject.project_video_fade_out_time.floatValue();
            nexTimeline.m_isProjectVideoFadeInOn = kMProject.is_project_video_fade_in_on.booleanValue();
            nexTimeline.m_isProjectVideoFadeOutOn = kMProject.is_project_video_fade_out_on.booleanValue();
        } else {
            nexTimeline.m_projectVideoFadeInTime = 2.0f;
            nexTimeline.m_projectVideoFadeOutTime = 2.0f;
            nexTimeline.m_isProjectVideoFadeInOn = false;
            nexTimeline.m_isProjectVideoFadeOutOn = false;
        }
        nexTimeline.m_projectAudioFadeInTime = kMProject.project_audio_fade_in_time.floatValue();
        nexTimeline.m_projectAudioFadeOutTime = kMProject.project_audio_fade_out_time.floatValue();
        nexTimeline.m_isProjectAudioFadeInOn = kMProject.is_project_audio_fade_in_on.booleanValue();
        nexTimeline.m_isProjectAudioFadeOutOn = kMProject.is_project_audio_fade_out_on.booleanValue();
        Iterator<KMProto.KMProject.TimelineItem> it = kMProject.primary_items.iterator();
        while (it.hasNext()) {
            NexPrimaryTimelineItem primaryItemFromProtoBuf = primaryItemFromProtoBuf(it.next());
            if (primaryItemFromProtoBuf != null) {
                nexTimeline.m_primaryItems.add(primaryItemFromProtoBuf);
            }
        }
        Iterator<KMProto.KMProject.TimelineItem> it2 = kMProject.secondary_items.iterator();
        while (it2.hasNext()) {
            NexSecondaryTimelineItem secondaryItemFromProtoBuf = secondaryItemFromProtoBuf(it2.next());
            if (secondaryItemFromProtoBuf != null) {
                nexTimeline.m_secondaryItems.add(secondaryItemFromProtoBuf);
            }
        }
        int primaryItemCount = nexTimeline.getPrimaryItemCount();
        int secondaryItemCount = nexTimeline.getSecondaryItemCount();
        for (int i2 = 0; i2 < primaryItemCount; i2++) {
            nexTimeline.getPrimaryItem(i2).wasAddedToTimeline(nexTimeline);
        }
        for (int i3 = 0; i3 < secondaryItemCount; i3++) {
            nexTimeline.getSecondaryItem(i3).wasAddedToTimeline(nexTimeline);
        }
        nexTimeline.requestCalcTimes();
        return nexTimeline;
    }

    public void setMediaStore(MediaStore mediaStore) {
        this.o = new WeakReference<>(mediaStore);
    }

    public MediaStore getMediaStore() {
        if (this.o != null) {
            return this.o.get();
        }
        return null;
    }

    public Set<ProjectDependency> getDependencies() {
        HashSet hashSet = new HashSet();
        if (this.m_themeId != null) {
            hashSet.add(ProjectDependency.a(this.m_themeId));
        }
        int size = this.m_primaryItems.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.m_primaryItems.get(i2).addDependencies(hashSet);
        }
        int size2 = this.m_secondaryItems.size();
        for (int i3 = 0; i3 < size2; i3++) {
            this.m_secondaryItems.get(i3).addDependencies(hashSet);
        }
        return hashSet;
    }

    public Set<File> getRequiredFiles() {
        HashSet hashSet = new HashSet();
        int size = this.m_primaryItems.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.m_primaryItems.get(i2) instanceof NexVideoClipItem) {
                NexVideoClipItem nexVideoClipItem = (NexVideoClipItem) this.m_primaryItems.get(i2);
                if (!nexVideoClipItem.isPreset()) {
                    hashSet.add(new File(nexVideoClipItem.getMediaPath()));
                }
            }
        }
        int size2 = this.m_secondaryItems.size();
        for (int i3 = 0; i3 < size2; i3++) {
            NexSecondaryTimelineItem nexSecondaryTimelineItem = this.m_secondaryItems.get(i3);
            if ((nexSecondaryTimelineItem instanceof NexAudioClipItem) && ((NexAudioClipItem) nexSecondaryTimelineItem).getIsVoiceRecording()) {
                hashSet.add(new File(((NexAudioClipItem) nexSecondaryTimelineItem).getMediaPath()));
            } else if (nexSecondaryTimelineItem instanceof ImageLayer) {
                hashSet.add(new File(((ImageLayer) nexSecondaryTimelineItem).getMediaPath()));
            } else if (nexSecondaryTimelineItem instanceof VideoLayer) {
                hashSet.add(new File(((VideoLayer) nexSecondaryTimelineItem).getMediaPath()));
            }
        }
        return hashSet;
    }

    public void release() {
        this.m_primaryItems.clear();
        this.m_secondaryItems.clear();
    }
}
