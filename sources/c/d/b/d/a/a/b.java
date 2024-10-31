package c.d.b.d.a.a;

import android.content.Context;
import c.d.b.d.a.a.a.c;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.integration.fcpxml.adapter.effect.Effect;
import com.nexstreaming.kinemaster.integration.fcpxml.adapter.effect.a;
import com.nexstreaming.kinemaster.integration.fcpxml.adapter.effect.c;
import com.nexstreaming.kinemaster.integration.fcpxml.adapter.effect.e;
import com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.SourceItem;
import com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.a;
import com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.b;
import com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.d;
import com.nexstreaming.kinemaster.layer.ImageLayer;
import com.nexstreaming.kinemaster.layer.SplitScreenType;
import com.nexstreaming.kinemaster.layer.VideoLayer;
import com.nexstreaming.kinemaster.mediainfo.MediaInfo;
import com.nextreaming.nexeditorui.NexAudioClipItem;
import com.nextreaming.nexeditorui.NexPrimaryTimelineItem;
import com.nextreaming.nexeditorui.NexSecondaryTimelineItem;
import com.nextreaming.nexeditorui.NexTimeline;
import com.nextreaming.nexeditorui.NexTransitionItem;
import com.nextreaming.nexeditorui.NexVideoClipItem;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* compiled from: FcpXmlAdapter.java */
/* loaded from: classes.dex */
public class b implements c.d.b.d.d.a.a {

    /* renamed from: a, reason: collision with root package name */
    private Context f3637a;

    /* renamed from: b, reason: collision with root package name */
    private int f3638b;

    /* renamed from: c, reason: collision with root package name */
    private int f3639c;

    /* renamed from: d, reason: collision with root package name */
    private int f3640d;

    /* renamed from: e, reason: collision with root package name */
    private int f3641e;

    /* renamed from: f, reason: collision with root package name */
    private NexTimeline f3642f;

    /* renamed from: g, reason: collision with root package name */
    private c.d.b.d.a.a.c.a f3643g;

    /* renamed from: h, reason: collision with root package name */
    private String f3644h;
    int i = 1;
    private final int j = 1;
    private int k = -1;
    private String l;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FcpXmlAdapter.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private int f3649a;

        /* renamed from: b, reason: collision with root package name */
        private int f3650b;

        /* renamed from: c, reason: collision with root package name */
        private int f3651c;

        /* renamed from: d, reason: collision with root package name */
        private int f3652d;

        /* renamed from: e, reason: collision with root package name */
        private int f3653e;

        /* renamed from: f, reason: collision with root package name */
        private int f3654f;

        /* renamed from: g, reason: collision with root package name */
        private int f3655g;

        /* renamed from: h, reason: collision with root package name */
        private int f3656h;
        private int i;
        private int j;
        private int k;

        private a() {
        }

        /* synthetic */ a(c.d.b.d.a.a.a aVar) {
            this();
        }
    }

    public b(Context context) {
        this.f3637a = context;
    }

    public void a(NexTimeline nexTimeline) {
        this.f3642f = nexTimeline;
    }

    public void a(int i, int i2, int i3) {
        this.f3638b = i;
        this.f3639c = i2;
        this.f3640d = i3;
    }

    public void a(String str) {
        this.f3644h = str;
    }

    public ArrayList<String> a() {
        this.f3643g = new c.d.b.d.a.a.c.a(this.f3638b, this.f3639c, this.f3640d);
        this.f3643g.b(this.f3644h);
        this.f3643g.a(this.f3641e);
        int primaryItemCount = this.f3642f.getPrimaryItemCount();
        int secondaryItemCount = this.f3642f.getSecondaryItemCount();
        if (primaryItemCount > 0) {
            for (int i = 0; i < primaryItemCount; i++) {
                NexPrimaryTimelineItem primaryItem = this.f3642f.getPrimaryItem(i);
                if (primaryItem instanceof NexVideoClipItem) {
                    a((NexVideoClipItem) primaryItem);
                } else if (primaryItem instanceof NexTransitionItem) {
                    a((NexTransitionItem) primaryItem);
                }
            }
        }
        if (secondaryItemCount > 0) {
            for (int i2 = 0; i2 < secondaryItemCount; i2++) {
                NexSecondaryTimelineItem secondaryItem = this.f3642f.getSecondaryItem(i2);
                if (secondaryItem instanceof NexAudioClipItem) {
                    a((NexAudioClipItem) secondaryItem, this.f3643g.c());
                } else if (secondaryItem instanceof NexLayerItem) {
                    a((NexLayerItem) secondaryItem);
                }
            }
        }
        String a2 = c.d.b.d.c.a.f3754a.booleanValue() ? c.d.b.d.e.a.a(this.f3637a, this.f3643g.e(), "fcpxml") : null;
        try {
            new c.d.b.d.a.b.a(this.f3643g, a2).a();
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(a2);
            for (com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.b bVar : this.f3643g.b()) {
                if (new File(bVar.s).exists()) {
                    arrayList.add(bVar.s);
                }
            }
            return arrayList;
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private void a(NexLayerItem nexLayerItem) {
        long j = this.f3640d;
        MediaInfo mediaInfo = null;
        a aVar = new a(0 == true ? 1 : 0);
        boolean z = nexLayerItem instanceof ImageLayer;
        if (z) {
            mediaInfo = MediaInfo.a(((ImageLayer) nexLayerItem).getMediaPath());
        } else if (nexLayerItem instanceof VideoLayer) {
            mediaInfo = MediaInfo.a(((VideoLayer) nexLayerItem).getMediaPath());
            j = mediaInfo.t();
        }
        aVar.f3650b = c.d.b.d.e.a.a(nexLayerItem.getStartTrim(), j);
        aVar.f3651c = c.d.b.d.e.a.a(nexLayerItem.getEndTrim(), j);
        aVar.j = c.d.b.d.e.a.a(nexLayerItem.getRelativeStartTime(), j);
        aVar.k = c.d.b.d.e.a.a(nexLayerItem.getRelativeEndTime(), j);
        aVar.f3649a = aVar.k - aVar.j;
        aVar.f3654f = aVar.j;
        aVar.f3655g = ((aVar.f3649a - aVar.f3650b) - aVar.f3651c) + aVar.j;
        aVar.f3656h = aVar.f3650b;
        aVar.i = aVar.f3649a - aVar.f3651c;
        if (z) {
            a((ImageLayer) nexLayerItem, aVar, mediaInfo);
        } else if (nexLayerItem instanceof VideoLayer) {
            a((VideoLayer) nexLayerItem, aVar, mediaInfo);
        }
    }

    private void a(VideoLayer videoLayer, a aVar, MediaInfo mediaInfo) {
        com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.b b2;
        int a2 = this.f3643g.a(videoLayer.getMediaPath());
        if (a2 == -1) {
            b.C0105b c0105b = new b.C0105b(this.f3637a);
            c0105b.b(videoLayer.getMediaPath());
            c0105b.a(c.d.b.d.e.a.c(videoLayer.getMediaPath()));
            c0105b.b(true);
            c0105b.a(videoLayer.getHasAudio());
            c0105b.a(mediaInfo.t(), mediaInfo.R(), mediaInfo.v(), SourceItem.PixelAspectRatio.square, 24L);
            c0105b.a(mediaInfo.m() * 8, mediaInfo.q(), mediaInfo.m());
            c0105b.a(aVar.f3649a);
            c0105b.a(SourceItem.MediaType.VIDEO);
            c0105b.a(mediaInfo.t());
            b2 = c0105b.a();
            this.f3643g.a(b2);
        } else {
            b2 = this.f3643g.b(a2);
        }
        boolean a3 = c.d.b.d.a.a.c.a.a(b2, videoLayer.getAudioLeftVolume(), videoLayer.getAudioRightVolume());
        ArrayList arrayList = new ArrayList();
        this.l = b2.t;
        int c2 = this.f3643g.c();
        a.C0104a c0104a = new a.C0104a();
        c0104a.a(SourceItem.ItemType.VISUAL);
        c0104a.a(SourceItem.MediaType.VIDEO);
        c0104a.b(aVar.f3649a);
        c0104a.a(this.l);
        c0104a.i(aVar.f3654f);
        c0104a.c(aVar.f3655g);
        c0104a.f(aVar.f3656h);
        c0104a.g(aVar.i);
        c0104a.e(b2.a());
        int i = this.i;
        this.i = i + 1;
        c0104a.a(i);
        c0104a.k(c2);
        c0104a.a(a3);
        c0104a.h(videoLayer.getPlaybackSpeed());
        c0104a.a(b2);
        com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.a build = c0104a.build();
        this.f3643g.a(c2, build);
        a(videoLayer, build, mediaInfo.R(), mediaInfo.v());
        if (mediaInfo.S()) {
            a.C0104a c0104a2 = new a.C0104a();
            c0104a2.a(SourceItem.ItemType.VISUAL);
            c0104a2.a(SourceItem.MediaType.AUDIO);
            c0104a2.b(aVar.f3649a);
            c0104a2.a((!a3 || b2.y.f20484c < 2) ? this.l : this.l.concat(" Left"));
            c0104a2.i(aVar.f3654f);
            c0104a2.c(aVar.f3655g);
            c0104a2.f(aVar.f3656h);
            c0104a2.g(aVar.i);
            c0104a2.e(b2.a());
            int i2 = this.i;
            this.i = i2 + 1;
            c0104a2.a(i2);
            c0104a2.k(c2);
            c0104a2.l(videoLayer.getClipVolume());
            c0104a2.b(videoLayer.getMuteAudio());
            c0104a2.a(a3);
            c0104a2.a(videoLayer.getAudioLeftVolume());
            c0104a2.h(videoLayer.getPlaybackSpeed());
            c0104a2.a(SourceItem.OutputChannel.LEFT);
            c0104a2.a(b2);
            com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.a build2 = c0104a2.build();
            this.f3643g.a(c2, build2);
            arrayList.add(build2);
            if (b2.y.f20484c >= 2) {
                int c3 = this.f3643g.c();
                int i3 = this.i;
                this.i = i3 + 1;
                com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.a a4 = build2.a(c3, i3, (a3 && b2.y.f20484c == 2) ? this.l.concat(" Right") : this.l, videoLayer.getAudioRightVolume(), SourceItem.OutputChannel.RIGHT);
                this.f3643g.a(c3, a4);
                arrayList.add(a4);
            }
        }
        if (arrayList.size() > 0) {
            a(arrayList);
        }
    }

    private void a(ImageLayer imageLayer, a aVar, MediaInfo mediaInfo) {
        com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.b b2;
        int a2 = this.f3643g.a(imageLayer.getMediaPath());
        if (a2 == -1) {
            b.C0105b c0105b = new b.C0105b(this.f3637a);
            c0105b.b(imageLayer.getMediaPath());
            c0105b.a(c.d.b.d.e.a.c(imageLayer.getMediaPath()));
            c0105b.b(true);
            c0105b.a(false);
            c0105b.a(this.f3643g.g().b(), mediaInfo.R(), mediaInfo.v(), SourceItem.PixelAspectRatio.square, 24L);
            c0105b.a(aVar.f3649a);
            c0105b.a(SourceItem.MediaType.IMAGE);
            c0105b.a(this.f3643g.g().b());
            b2 = c0105b.a();
            this.f3643g.a(b2);
        } else {
            b2 = this.f3643g.b(a2);
        }
        int c2 = this.f3643g.c();
        a.C0104a c0104a = new a.C0104a();
        c0104a.a(SourceItem.ItemType.VISUAL);
        c0104a.a(SourceItem.MediaType.IMAGE);
        c0104a.b(aVar.f3649a);
        c0104a.a(b2.t);
        c0104a.i(aVar.f3654f);
        c0104a.c(aVar.f3655g);
        c0104a.f(aVar.f3656h);
        c0104a.g(aVar.i);
        c0104a.e(b2.a());
        int i = this.i;
        this.i = i + 1;
        c0104a.a(i);
        c0104a.k(c2);
        c0104a.a(b2);
        com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.a build = c0104a.build();
        this.f3643g.a(c2, build);
        a(imageLayer, build, mediaInfo.R(), mediaInfo.v());
    }

    private void a(NexLayerItem nexLayerItem, com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.a aVar, int i, int i2) {
        SplitScreenType splitScreenType = nexLayerItem.getSplitScreenType();
        c.d.b.d.a.a.a.a aVar2 = new c.d.b.d.a.a.a.a(new c.b(i, i2), new c.b(this.f3643g.g().d(), this.f3643g.g().c()));
        int i3 = c.d.b.d.a.a.a.f3623a[splitScreenType.ordinal()];
        if (i3 == 1) {
            c.a a2 = aVar2.a(nexLayerItem);
            double d2 = nexLayerItem.getKeyFrames().get(0).f20231b;
            double a3 = aVar2.a();
            Double.isNaN(d2);
            aVar.a(Double.parseDouble(String.format(Locale.US, "%.2f", Double.valueOf(d2 * a3 * 100.0d))), nexLayerItem.getKeyFrames().get(0).f20234e, a2, null);
            return;
        }
        if (i3 != 2) {
            c.a a4 = aVar2.a(nexLayerItem);
            double parseDouble = Double.parseDouble(String.format(Locale.US, "%.2f", Double.valueOf(aVar2.a() * 100.0d)));
            if (a4 != null) {
                aVar.a(parseDouble, 0.0d, a4, null);
                return;
            }
            return;
        }
        aVar.a(Double.parseDouble(String.format(Locale.US, "%.2f", Double.valueOf(aVar2.a() * 100.0d))), 0.0d, null, null);
    }

    private void a(NexAudioClipItem nexAudioClipItem, int i) {
        com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.b b2;
        if (c.d.b.d.e.a.f(nexAudioClipItem.getMediaPath())) {
            a aVar = new a(null);
            int i2 = this.f3640d;
            if (i2 == 0) {
                i2 = 30;
            }
            long j = i2;
            aVar.f3649a = c.d.b.d.e.a.a(nexAudioClipItem.getDuration(), j);
            aVar.f3650b = c.d.b.d.e.a.a(nexAudioClipItem.getStartTrim(), j);
            aVar.f3651c = c.d.b.d.e.a.a(nexAudioClipItem.getEndTrim(), j);
            aVar.j = c.d.b.d.e.a.a(nexAudioClipItem.getRelativeStartTime(), j);
            aVar.k = c.d.b.d.e.a.a(nexAudioClipItem.getRelativeEndTime(), j);
            int i3 = (aVar.f3649a - aVar.f3650b) - aVar.f3651c;
            aVar.f3654f = aVar.j;
            aVar.f3655g = i3 + aVar.f3654f;
            aVar.f3656h = aVar.f3650b;
            aVar.i = aVar.f3649a - aVar.f3651c;
            MediaInfo a2 = MediaInfo.a(nexAudioClipItem.getMediaPath());
            long m = a2.m();
            long q = a2.q();
            long j2 = m * 8;
            int a3 = this.f3643g.a(nexAudioClipItem.getMediaPath());
            if (a3 == -1) {
                b.C0105b c0105b = new b.C0105b(this.f3637a);
                c0105b.b(nexAudioClipItem.getMediaPath());
                c0105b.a(c.d.b.d.e.a.c(nexAudioClipItem.getMediaPath()));
                c0105b.a(true);
                c0105b.b(true);
                c0105b.a(this.f3643g.g().b(), this.f3643g.g().d(), this.f3643g.g().c(), SourceItem.PixelAspectRatio.square, 24L);
                c0105b.a(j2, q, m);
                c0105b.a(aVar.f3649a);
                c0105b.a(SourceItem.MediaType.AUDIO);
                c0105b.a(this.f3640d);
                b2 = c0105b.a();
                this.f3643g.a(b2);
            } else {
                b2 = this.f3643g.b(a3);
            }
            com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.b bVar = b2;
            String str = bVar.t;
            boolean a4 = c.d.b.d.a.a.c.a.a(bVar, nexAudioClipItem.getAudioLeftVolume(), nexAudioClipItem.getAudioRightVolume());
            ArrayList arrayList = new ArrayList();
            arrayList.add(new c.d.b.d.a.a.e.a(this.i, 1, i, 1, SourceItem.MediaType.AUDIO));
            if (bVar.y.f20484c >= 2) {
                arrayList.add(new c.d.b.d.a.a.e.a(this.i + 1, 2, i + 1, 1, SourceItem.MediaType.AUDIO));
            }
            a.C0104a c0104a = new a.C0104a();
            c0104a.a(SourceItem.ItemType.SOUNDTRACK);
            c0104a.a(SourceItem.MediaType.AUDIO);
            c0104a.a((!a4 || bVar.y.f20484c < 2) ? str : str.concat(" Left"));
            c0104a.b(aVar.f3649a);
            c0104a.i(aVar.f3654f);
            c0104a.c(aVar.f3655g);
            c0104a.f(aVar.f3656h);
            c0104a.g(aVar.i);
            c0104a.e(bVar.a());
            c0104a.a(this.i);
            c0104a.a(arrayList);
            c0104a.k(i);
            c0104a.l(nexAudioClipItem.getClipVolume());
            c0104a.b(nexAudioClipItem.getMuteAudio());
            c0104a.a(a4);
            c0104a.a(nexAudioClipItem.getAudioLeftVolume());
            c0104a.a(SourceItem.OutputChannel.LEFT);
            c0104a.a(bVar);
            com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.a build = c0104a.build();
            this.f3643g.a(i, build);
            this.i++;
            if (bVar.y.f20484c >= 2) {
                int c2 = this.f3643g.c();
                int i4 = this.i;
                if (a4) {
                    str = str.concat(" Right");
                }
                this.f3643g.a(c2, build.a(c2, i4, str, nexAudioClipItem.getAudioRightVolume(), SourceItem.OutputChannel.RIGHT, arrayList));
                this.i++;
            }
        }
    }

    private void a(NexTransitionItem nexTransitionItem) {
        e eVar = new e();
        if (nexTransitionItem.getTransitionEffectID().equals(NexTimeline.DEFAULT_PROJECT_PHOTO_CROP_MODE)) {
            return;
        }
        d.a aVar = new d.a();
        aVar.a(SourceItem.ItemType.TRANSITION);
        aVar.a(SourceItem.Alignment.CENTER);
        aVar.a(c.d.b.d.e.a.a(nexTransitionItem.getDuration(), this.f3640d));
        aVar.a(this.f3640d);
        aVar.a(eVar.a(nexTransitionItem.getTransitionEffectID()));
        aVar.a(SourceItem.MediaType.VIDEO);
        aVar.a(Effect.EffectType.transition);
        aVar.d(0);
        aVar.c(100);
        aVar.b(0.0f);
        aVar.a(1.0f);
        aVar.a(false);
        aVar.b(1);
        this.f3643g.a(1, aVar.build());
    }

    private void a(NexVideoClipItem nexVideoClipItem) {
        long j;
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        int i;
        com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.b b2;
        a aVar = new a(null);
        int fps = nexVideoClipItem.getFPS();
        if (fps == 0) {
            fps = 30;
        }
        long j7 = fps;
        aVar.f3649a = c.d.b.d.e.a.a(nexVideoClipItem.getDuration(), j7);
        aVar.f3650b = c.d.b.d.e.a.a(nexVideoClipItem.getTrimTimeStart(), j7);
        aVar.f3651c = c.d.b.d.e.a.a(nexVideoClipItem.getTrimTimeEnd(), j7);
        aVar.f3652d = c.d.b.d.e.a.a(nexVideoClipItem.getStartOverlap(), j7);
        aVar.f3653e = c.d.b.d.e.a.a(nexVideoClipItem.getEndOverlap(), j7);
        aVar.f3654f = 0;
        aVar.f3655g = (aVar.f3649a - aVar.f3650b) - aVar.f3651c;
        aVar.f3656h = aVar.f3650b;
        aVar.i = aVar.f3649a - aVar.f3651c;
        if (nexVideoClipItem.isSolid()) {
            j = 16;
            j2 = 0;
            j3 = 0;
            j4 = 0;
            j5 = 48000;
            j6 = 2;
        } else {
            MediaInfo a2 = MediaInfo.a(nexVideoClipItem.getMediaPath());
            long t = a2.t();
            long R = a2.R();
            long v = a2.v();
            if (a2.S()) {
                long m = a2.m();
                j6 = m;
                j5 = a2.q();
                j2 = R;
                j = 8 * m;
                j3 = v;
            } else {
                j3 = v;
                j = 16;
                j2 = R;
                j5 = 48000;
                j6 = 2;
            }
            j4 = t;
        }
        int a3 = this.f3643g.a(nexVideoClipItem.getMediaPath());
        if (a3 == -1) {
            b.C0105b c0105b = new b.C0105b(this.f3637a);
            c0105b.b(nexVideoClipItem.getMediaPath());
            c0105b.a(c.d.b.d.e.a.c(nexVideoClipItem.getMediaPath()));
            c0105b.a(nexVideoClipItem.getHasAudio());
            c0105b.b(nexVideoClipItem.isImage() || nexVideoClipItem.isSolid() || nexVideoClipItem.isVideo());
            i = 1;
            c0105b.a(j4, j2, j3, SourceItem.PixelAspectRatio.square, 24L);
            c0105b.a(j, j5, j6);
            c0105b.a(aVar.f3649a);
            c0105b.a(nexVideoClipItem.isImage() ? SourceItem.MediaType.IMAGE : SourceItem.MediaType.VIDEO);
            c0105b.a(j4);
            b2 = c0105b.a();
            this.f3643g.a(b2);
        } else {
            i = 1;
            b2 = this.f3643g.b(a3);
        }
        boolean a4 = c.d.b.d.a.a.c.a.a(b2, nexVideoClipItem.getAudioLeftVolume(), nexVideoClipItem.getAudioRightVolume());
        ArrayList arrayList = new ArrayList();
        this.l = b2.t;
        if (nexVideoClipItem.isSolid()) {
            this.f3643g.a(i, a(b2, nexVideoClipItem, a.C0102a.a(b2.s), aVar));
            this.i += i;
        } else if (c.d.b.d.e.a.f(nexVideoClipItem.getMediaPath())) {
            com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.a a5 = a(b2, nexVideoClipItem, aVar);
            b.c cVar = b2.x;
            c.d.b.d.a.a.a.d dVar = new c.d.b.d.a.a.a.d(new c.b(cVar.f20493a, cVar.f20494b), new c.b(this.f3643g.g().d(), this.f3643g.g().c()));
            if (nexVideoClipItem.isImage()) {
                a5.a(0, (aVar.f3655g - aVar.f3654f) - i, dVar.f3630f);
            } else {
                Locale locale = Locale.US;
                Object[] objArr = new Object[i];
                objArr[0] = Double.valueOf(dVar.f3630f * 100.0d);
                double parseDouble = Double.parseDouble(String.format(locale, "%.2f", objArr));
                if (parseDouble != 100.0d) {
                    a5.a(parseDouble, 0.0d, null, null);
                }
            }
            this.f3643g.a(i, a5);
            if (!nexVideoClipItem.isImage()) {
                arrayList.add(a5);
            }
            this.i += i;
        }
        if (b2.w && c.d.b.d.e.a.f(nexVideoClipItem.getMediaPath())) {
            com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.a a6 = a(b2, nexVideoClipItem, aVar, false);
            this.f3643g.a(i, a6);
            arrayList.add(a6);
            this.i += i;
            long j8 = b2.y.f20484c;
            if (j8 >= 2) {
                this.k = 2;
                com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.a a7 = a6.a(this.k, this.i, (!a4 || j8 < 2) ? this.l : this.l.concat(" Right"), nexVideoClipItem.getAudioRightVolume(), SourceItem.OutputChannel.RIGHT);
                this.f3643g.a(this.k, a7);
                arrayList.add(a7);
                this.i += i;
            }
        }
        if (arrayList.size() > 0) {
            a(arrayList);
        }
    }

    private com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.a a(com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.b bVar, NexVideoClipItem nexVideoClipItem, a aVar, boolean z) {
        String str;
        String str2;
        String str3;
        boolean a2 = c.d.b.d.a.a.c.a.a(bVar, nexVideoClipItem.getAudioLeftVolume(), nexVideoClipItem.getAudioRightVolume());
        a.C0104a c0104a = new a.C0104a();
        c0104a.a(SourceItem.ItemType.VISUAL);
        c0104a.a(SourceItem.MediaType.AUDIO);
        c0104a.b(aVar.f3649a);
        if (!a2 || bVar.y.f20484c < 2) {
            str = this.l;
        } else {
            if (z) {
                str2 = this.l;
                str3 = " Right";
            } else {
                str2 = this.l;
                str3 = " Left";
            }
            str = str2.concat(str3);
        }
        c0104a.a(str);
        c0104a.i(aVar.f3654f);
        c0104a.c(aVar.f3655g);
        c0104a.f(aVar.f3656h);
        c0104a.g(aVar.i);
        c0104a.j(aVar.f3652d);
        c0104a.d(aVar.f3653e);
        c0104a.e(bVar.a());
        c0104a.a(this.i);
        c0104a.k(1);
        c0104a.l(nexVideoClipItem.getClipVolume());
        c0104a.b(nexVideoClipItem.getMuteAudio());
        c0104a.a(a2);
        c0104a.a(z ? nexVideoClipItem.getAudioRightVolume() : nexVideoClipItem.getAudioLeftVolume());
        c0104a.h(nexVideoClipItem.getPlaybackSpeed());
        c0104a.a(z ? SourceItem.OutputChannel.RIGHT : SourceItem.OutputChannel.LEFT);
        c0104a.a(bVar);
        return c0104a.build();
    }

    private com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.a a(com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.b bVar, NexVideoClipItem nexVideoClipItem, a aVar) {
        boolean a2 = c.d.b.d.a.a.c.a.a(bVar, nexVideoClipItem.getAudioLeftVolume(), nexVideoClipItem.getAudioRightVolume());
        a.C0104a c0104a = new a.C0104a();
        c0104a.a(SourceItem.ItemType.VISUAL);
        c0104a.a(bVar.u);
        c0104a.b(aVar.f3649a);
        c0104a.a(this.l);
        c0104a.i(aVar.f3654f);
        c0104a.c(aVar.f3655g);
        c0104a.f(aVar.f3656h);
        c0104a.g(aVar.i);
        c0104a.j(aVar.f3652d);
        c0104a.d(aVar.f3653e);
        c0104a.e(bVar.a());
        c0104a.a(this.i);
        c0104a.k(1);
        c0104a.a(a2);
        c0104a.h(nexVideoClipItem.getPlaybackSpeed());
        c0104a.a(bVar);
        return c0104a.build();
    }

    private com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.c a(com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.b bVar, NexVideoClipItem nexVideoClipItem, a.C0102a c0102a, a aVar) {
        a.C0104a c0104a = new a.C0104a();
        c0104a.a(SourceItem.ItemType.VISUAL);
        c0104a.a(bVar.u);
        c0104a.b(aVar.f3649a);
        c0104a.a(this.l);
        c0104a.i(aVar.f3654f);
        c0104a.c(aVar.f3655g);
        c0104a.f(aVar.f3656h);
        c0104a.g(aVar.i);
        c0104a.j(aVar.f3652d);
        c0104a.d(aVar.f3653e);
        c0104a.a(this.i);
        c0104a.e(bVar.a());
        c0104a.k(1);
        c0104a.a(false);
        c0104a.h(nexVideoClipItem.getPlaybackSpeed());
        c0104a.a(bVar);
        return new com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.c(c0104a, c0102a);
    }

    private void a(List<com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.a> list) {
        ArrayList arrayList = new ArrayList();
        for (com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.a aVar : list) {
            int i = aVar.s;
            SourceItem.MediaType mediaType = aVar.u;
            int i2 = aVar.j;
            List<SourceItem> a2 = this.f3643g.a(i2).a();
            int i3 = 0;
            if (mediaType == SourceItem.MediaType.VIDEO) {
                Iterator<SourceItem> it = a2.iterator();
                int i4 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    SourceItem next = it.next();
                    SourceItem.ItemType itemType = next.i;
                    if (itemType == SourceItem.ItemType.VISUAL) {
                        com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.a aVar2 = (com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.a) next;
                        if (aVar2.u != SourceItem.MediaType.VIDEO) {
                            continue;
                        } else {
                            if (aVar2.s == i) {
                                i3 = i4 + 1;
                                break;
                            }
                            i4++;
                        }
                    } else if (itemType == SourceItem.ItemType.TRANSITION) {
                        i4++;
                    }
                }
            } else if (mediaType == SourceItem.MediaType.AUDIO) {
                Iterator<SourceItem> it2 = a2.iterator();
                int i5 = 0;
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    SourceItem next2 = it2.next();
                    if (next2.i == SourceItem.ItemType.VISUAL) {
                        com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.a aVar3 = (com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.a) next2;
                        if (aVar3.u != SourceItem.MediaType.AUDIO) {
                            continue;
                        } else {
                            if (aVar3.s == i) {
                                i3 = i5 + 1;
                                break;
                            }
                            i5++;
                        }
                    }
                }
            }
            arrayList.add(new c.d.b.d.a.a.e.a(i, i3, i2, mediaType == SourceItem.MediaType.VIDEO ? -1 : 1, mediaType));
        }
        if (arrayList.size() > 0) {
            Iterator<com.nexstreaming.kinemaster.integration.fcpxml.adapter.items.a> it3 = list.iterator();
            while (it3.hasNext()) {
                it3.next().a(arrayList);
            }
        }
    }
}
