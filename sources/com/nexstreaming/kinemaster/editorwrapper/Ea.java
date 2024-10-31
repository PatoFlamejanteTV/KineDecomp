package com.nexstreaming.kinemaster.editorwrapper;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.view.View;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.Fa;
import com.nexstreaming.kinemaster.layer.TextLayer;
import com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2028i;
import com.nexstreaming.kinemaster.wire.KMProto;
import com.nextreaming.nexeditorui.NexSecondaryTimelineItem;
import com.nextreaming.nexeditorui.NexTimeline;
import com.nextreaming.nexeditorui.NexTimelineItem;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: TimelineTrack.java */
/* loaded from: classes.dex */
public class Ea implements Fa, Fa.b, NexTimelineItem.e, NexTimelineItem.b, NexTimelineItem.a, NexTimelineItem.v, Fa.a {

    /* renamed from: a */
    private final int f20192a;

    /* renamed from: b */
    private final b f20193b;

    /* renamed from: c */
    private transient WeakReference<NexTimeline> f20194c;

    /* renamed from: d */
    private int[] f20195d;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TimelineTrack.java */
    /* loaded from: classes.dex */
    public interface a {

        /* renamed from: a */
        public static final String f20196a = null;
    }

    /* compiled from: TimelineTrack.java */
    /* loaded from: classes.dex */
    public static class b implements a {

        /* renamed from: a */
        boolean f20197a = true;

        /* renamed from: b */
        int f20198b = 100;

        /* renamed from: c */
        boolean f20199c = false;

        /* renamed from: d */
        int f20200d = 0;

        /* renamed from: e */
        int f20201e = 0;

        /* renamed from: f */
        int f20202f = 0;

        /* renamed from: g */
        int f20203g = 0;

        /* renamed from: h */
        int f20204h = 255;
        boolean i = false;
        String j = a.f20196a;
        int k = -1;
        boolean l = false;
        int m = ViewCompat.MEASURED_STATE_MASK;
        boolean n = false;
        int o = -1426063446;
        boolean p = false;
        int q = -3355444;

        b() {
        }
    }

    public Ea(int i) {
        this(i, new b());
    }

    private NexTimeline r() {
        WeakReference<NexTimeline> weakReference = this.f20194c;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    private void s() {
        NexTimeline r = r();
        if (r == null) {
            return;
        }
        for (NexSecondaryTimelineItem nexSecondaryTimelineItem : r.getSecondaryItemsByTrackId(this.f20192a)) {
            if (nexSecondaryTimelineItem instanceof TextLayer) {
                ((TextLayer) nexSecondaryTimelineItem).notifyStyleChanged();
            }
        }
    }

    public void a(NexTimeline nexTimeline) {
        this.f20194c = new WeakReference<>(nexTimeline);
    }

    public int b() {
        NexTimeline r = r();
        int i = 0;
        if (r == null) {
            return 0;
        }
        Iterator<NexSecondaryTimelineItem> it = r.getSecondaryItems().iterator();
        while (it.hasNext()) {
            if (it.next().getTrackId() == this.f20192a) {
                i++;
            }
        }
        return i;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.Fa
    public void bindView(View view, InterfaceC2028i interfaceC2028i) {
    }

    public int c() {
        return this.f20192a;
    }

    public int d() {
        NexTimeline r = r();
        if (r == null) {
            return -1;
        }
        return r.getTrackIndexById(this.f20192a);
    }

    public int e() {
        if (this.f20195d == null) {
            this.f20195d = new int[8];
        }
        Arrays.fill(this.f20195d, -1);
        NexTimeline r = r();
        if (r == null) {
            return 0;
        }
        int secondaryItemCount = r.getSecondaryItemCount();
        int i = 0;
        for (int i2 = 0; i2 < secondaryItemCount; i2++) {
            NexSecondaryTimelineItem secondaryItem = r.getSecondaryItem(i2);
            if (secondaryItem.getTrackId() == this.f20192a) {
                int startTime = secondaryItem.getStartTime();
                int endTime = secondaryItem.getEndTime();
                int i3 = 0;
                while (true) {
                    int[] iArr = this.f20195d;
                    if (i3 >= iArr.length) {
                        i3 = -1;
                        break;
                    }
                    if (startTime > iArr[i3]) {
                        iArr[i3] = endTime - 1;
                        break;
                    }
                    i3++;
                }
                if (i3 < 0) {
                    int[] iArr2 = new int[this.f20195d.length + 8];
                    Arrays.fill(iArr2, -1);
                    int[] iArr3 = this.f20195d;
                    System.arraycopy(iArr3, 0, iArr2, 0, iArr3.length);
                    int[] iArr4 = this.f20195d;
                    iArr2[iArr4.length] = endTime;
                    i3 = iArr4.length;
                    this.f20195d = iArr2;
                }
                secondaryItem.setSubTrackMapping(i3);
                i = Math.max(i, i3 + 1);
            }
        }
        return i;
    }

    public int f() {
        return this.f20193b.k;
    }

    public String g() {
        return this.f20193b.j;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.a
    public int getAlpha() {
        return this.f20193b.f20204h;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.e
    public int getAudioCompressor() {
        return this.f20193b.f20200d;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.e
    public int getAudioLeftVolume() {
        return this.f20193b.f20201e;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.e
    public int getAudioPitch() {
        return this.f20193b.f20203g;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.e
    public int getAudioRightVolume() {
        return this.f20193b.f20202f;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.e
    public int getClipVolume() {
        return this.f20193b.f20198b;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.Fa.a
    public int getColorOption(int i) {
        if (i == R.id.opt_text_color) {
            return f();
        }
        if (i == R.id.opt_shadow) {
            return j();
        }
        if (i == R.id.opt_glow) {
            return h();
        }
        if (i == R.id.opt_outline) {
            return i();
        }
        return 0;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.b
    public String getEqualizer() {
        return com.nexstreaming.kinemaster.ui.projectedit.audioeffect.b.f22223b.a().f();
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.e
    public boolean getMuteAudio() {
        return this.f20193b.f20199c;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.Fa.b
    public boolean getSwitchOption(int i) {
        switch (i) {
            case R.id.opt_apply_style_to_all /* 2131363086 */:
                return n();
            case R.id.opt_glow /* 2131363115 */:
                return o();
            case R.id.opt_outline /* 2131363133 */:
                return p();
            case R.id.opt_shadow /* 2131363139 */:
                return q();
            case R.id.opt_track_visibility /* 2131363160 */:
                return m();
            default:
                return false;
        }
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.Fa
    public int getTimelineViewLayoutResource() {
        return R.layout.timeline_track;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.b
    public String getVoiceChanger() {
        return com.nexstreaming.kinemaster.ui.projectedit.audioeffect.b.f22223b.a().f();
    }

    public int h() {
        return this.f20193b.o;
    }

    public int i() {
        return this.f20193b.q;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.e
    public boolean isCheckedAudioCompressor() {
        return this.f20193b.f20200d > 0;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.InterfaceC1732b
    public boolean isDraggable() {
        return false;
    }

    public int j() {
        return this.f20193b.m;
    }

    public Set<Integer> k() {
        NexTimeline r = r();
        if (r == null) {
            return Collections.emptySet();
        }
        int secondaryItemCount = r.getSecondaryItemCount();
        HashSet hashSet = new HashSet();
        for (int i = 0; i < secondaryItemCount; i++) {
            NexSecondaryTimelineItem secondaryItem = r.getSecondaryItem(i);
            if (secondaryItem.getTrackId() == this.f20192a) {
                hashSet.add(Integer.valueOf(secondaryItem.getTrackAffinity()));
            }
        }
        return hashSet;
    }

    public List<Integer> l() {
        NexTimeline r = r();
        if (r == null) {
            return null;
        }
        int secondaryItemCount = r.getSecondaryItemCount();
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(R.id.opt_track_visibility));
        for (int i = 0; i < secondaryItemCount; i++) {
            NexSecondaryTimelineItem secondaryItem = r.getSecondaryItem(i);
            if (secondaryItem.getTrackId() == this.f20192a) {
                for (int i2 : secondaryItem.getTrackOptionItems()) {
                    if (!arrayList.contains(Integer.valueOf(i2))) {
                        arrayList.add(Integer.valueOf(i2));
                    }
                }
            }
        }
        return arrayList;
    }

    public boolean m() {
        return this.f20193b.f20197a;
    }

    public boolean n() {
        return this.f20193b.i;
    }

    public boolean o() {
        return this.f20193b.n;
    }

    public boolean p() {
        return this.f20193b.p;
    }

    public boolean q() {
        return this.f20193b.l;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.a
    public void setAlpha(int i) {
        this.f20193b.f20204h = i;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.e
    public void setAudioCompressor(boolean z) {
        this.f20193b.f20200d = z ? 4 : 0;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.e
    public void setAudioLeftVolume(int i) {
        this.f20193b.f20201e = i;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.e
    public void setAudioPitch(int i) {
        this.f20193b.f20203g = i;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.e
    public void setAudioRightVolume(int i) {
        this.f20193b.f20202f = i;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.e
    public void setClipVolume(int i) {
        this.f20193b.f20198b = i;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.Fa.a
    public void setColorOption(int i, int i2) {
        if (i == R.id.opt_text_color) {
            a(i2);
        } else if (i == R.id.opt_shadow) {
            d(i2);
        } else if (i == R.id.opt_outline) {
            c(i2);
        } else if (i == R.id.opt_glow) {
            b(i2);
        }
        s();
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.b
    public void setEqualizer(String str) {
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.e
    public void setMuteAudio(boolean z) {
        this.f20193b.f20199c = z;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.b
    public void setVoiceChanger(String str) {
    }

    public Ea(int i, b bVar) {
        this.f20192a = i;
        this.f20193b = bVar;
    }

    public boolean a(NexSecondaryTimelineItem nexSecondaryTimelineItem) {
        int trackAffinity = nexSecondaryTimelineItem.getTrackAffinity();
        NexTimeline r = r();
        if (r != null) {
            int secondaryItemCount = r.getSecondaryItemCount();
            for (int i = 0; i < secondaryItemCount; i++) {
                NexSecondaryTimelineItem secondaryItem = r.getSecondaryItem(i);
                if (secondaryItem.getTrackId() == this.f20192a && secondaryItem.getClass().isInstance(nexSecondaryTimelineItem) && secondaryItem.getTrackAffinity() == trackAffinity) {
                    return true;
                }
            }
        }
        return false;
    }

    public void c(boolean z) {
        this.f20193b.n = z;
    }

    public void c(int i) {
        this.f20193b.q = i;
    }

    public void d(int i) {
        this.f20193b.m = i;
    }

    public void b(boolean z) {
        this.f20193b.i = z;
    }

    public void d(boolean z) {
        this.f20193b.p = z;
    }

    public void b(int i) {
        this.f20193b.o = i;
    }

    public Task a(int i, boolean z, Context context) {
        switch (i) {
            case R.id.opt_apply_style_to_all /* 2131363086 */:
                b(z);
                break;
            case R.id.opt_glow /* 2131363115 */:
                c(z);
                break;
            case R.id.opt_outline /* 2131363133 */:
                d(z);
                break;
            case R.id.opt_shadow /* 2131363139 */:
                e(z);
                break;
            case R.id.opt_track_visibility /* 2131363160 */:
                a(z);
                break;
        }
        s();
        return null;
    }

    public void a(boolean z) {
        this.f20193b.f20197a = z;
    }

    public void a(String str) {
        this.f20193b.j = str;
        s();
    }

    public void a(int i) {
        this.f20193b.k = i;
    }

    public KMProto.KMProject.Track a() {
        KMProto.KMProject.Track.Builder builder = new KMProto.KMProject.Track.Builder();
        builder.track_id(Integer.valueOf(this.f20192a));
        builder.visible(Boolean.valueOf(this.f20193b.f20197a));
        builder.clip_volume(Integer.valueOf(this.f20193b.f20198b));
        builder.mute_audio(Boolean.valueOf(this.f20193b.f20199c));
        builder.compressor(Integer.valueOf(this.f20193b.f20200d));
        builder.pan_left(Integer.valueOf(this.f20193b.f20201e));
        builder.pan_right(Integer.valueOf(this.f20193b.f20202f));
        builder.pitch_factor(Integer.valueOf(this.f20193b.f20203g));
        builder.overall_alpha(Integer.valueOf(this.f20193b.f20204h));
        builder.override_text_style(Boolean.valueOf(this.f20193b.i));
        builder.text_font_id(this.f20193b.j);
        builder.text_color(Integer.valueOf(this.f20193b.k));
        builder.text_shadow(Boolean.valueOf(this.f20193b.l));
        builder.text_shadow_color(Integer.valueOf(this.f20193b.m));
        builder.text_glow(Boolean.valueOf(this.f20193b.n));
        builder.text_glow_color(Integer.valueOf(this.f20193b.o));
        builder.text_outline(Boolean.valueOf(this.f20193b.p));
        builder.text_outline_color(Integer.valueOf(this.f20193b.q));
        return builder.build();
    }

    public void e(boolean z) {
        this.f20193b.l = z;
    }

    public static Ea a(KMProto.KMProject.Track track) {
        b bVar = new b();
        Boolean bool = track.visible;
        if (bool != null) {
            bVar.f20197a = bool.booleanValue();
        }
        Integer num = track.clip_volume;
        if (num != null) {
            bVar.f20198b = num.intValue();
        }
        Boolean bool2 = track.mute_audio;
        if (bool2 != null) {
            bVar.f20199c = bool2.booleanValue();
        }
        Integer num2 = track.compressor;
        if (num2 != null) {
            bVar.f20200d = num2.intValue();
        }
        Integer num3 = track.pan_left;
        if (num3 != null) {
            bVar.f20201e = num3.intValue();
        }
        Integer num4 = track.pan_right;
        if (num4 != null) {
            bVar.f20202f = num4.intValue();
        }
        Integer num5 = track.pitch_factor;
        if (num5 != null) {
            bVar.f20203g = num5.intValue();
        }
        Integer num6 = track.overall_alpha;
        if (num6 != null) {
            bVar.f20204h = num6.intValue();
        }
        Boolean bool3 = track.override_text_style;
        if (bool3 != null) {
            bVar.i = bool3.booleanValue();
        }
        String str = track.text_font_id;
        if (str != null) {
            bVar.j = str;
        }
        Integer num7 = track.text_color;
        if (num7 != null) {
            bVar.k = num7.intValue();
        }
        Boolean bool4 = track.text_shadow;
        if (bool4 != null) {
            bVar.l = bool4.booleanValue();
        }
        Integer num8 = track.text_shadow_color;
        if (num8 != null) {
            bVar.m = num8.intValue();
        }
        Boolean bool5 = track.text_glow;
        if (bool5 != null) {
            bVar.n = bool5.booleanValue();
        }
        Integer num9 = track.text_glow_color;
        if (num9 != null) {
            bVar.o = num9.intValue();
        }
        Boolean bool6 = track.text_outline;
        if (bool6 != null) {
            bVar.p = bool6.booleanValue();
        }
        Integer num10 = track.text_outline_color;
        if (num10 != null) {
            bVar.q = num10.intValue();
        }
        return new Ea(track.track_id.intValue(), bVar);
    }
}
