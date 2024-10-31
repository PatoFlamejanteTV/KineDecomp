package c.d.b.d.b.a;

import android.content.Context;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.integration.kmxml.adapter.effect.Effect;
import com.nexstreaming.kinemaster.integration.kmxml.adapter.effect.c;
import com.nexstreaming.kinemaster.integration.kmxml.adapter.effect.e;
import com.nexstreaming.kinemaster.integration.kmxml.adapter.effect.g;
import com.nexstreaming.kinemaster.integration.kmxml.adapter.items.SourceItem;
import com.nexstreaming.kinemaster.integration.kmxml.adapter.items.d;
import com.nexstreaming.kinemaster.integration.kmxml.adapter.layer.f;
import com.nexstreaming.kinemaster.layer.VideoLayer;
import com.nexstreaming.kinemaster.mediainfo.MediaInfo;
import com.nextreaming.nexeditorui.NexAudioClipItem;
import com.nextreaming.nexeditorui.NexPrimaryTimelineItem;
import com.nextreaming.nexeditorui.NexSecondaryTimelineItem;
import com.nextreaming.nexeditorui.NexTimeline;
import com.nextreaming.nexeditorui.NexTimelineItem;
import com.nextreaming.nexeditorui.NexTransitionItem;
import com.nextreaming.nexeditorui.NexVideoClipItem;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* compiled from: KmXmlAdapter.java */
/* loaded from: classes.dex */
public class a implements c.d.b.d.d.a.a {

    /* renamed from: a, reason: collision with root package name */
    private int f3700a;

    /* renamed from: b, reason: collision with root package name */
    private int f3701b;

    /* renamed from: c, reason: collision with root package name */
    private int f3702c;

    /* renamed from: d, reason: collision with root package name */
    private NexTimeline f3703d;

    /* renamed from: e, reason: collision with root package name */
    private c.d.b.d.b.a.b.a f3704e;

    /* renamed from: f, reason: collision with root package name */
    private String f3705f;

    /* renamed from: g, reason: collision with root package name */
    private Context f3706g;

    public a(Context context) {
        this.f3706g = context;
    }

    public void a(NexTimeline nexTimeline) {
        this.f3703d = nexTimeline;
    }

    public void a(int i, int i2, int i3) {
        this.f3700a = i;
        this.f3701b = i2;
        this.f3702c = i3;
    }

    public void a(String str) {
        this.f3705f = str;
    }

    public ArrayList<String> a() {
        this.f3704e = new c.d.b.d.b.a.b.a(this.f3700a, this.f3701b, this.f3702c);
        this.f3704e.a(this.f3705f);
        int primaryItemCount = this.f3703d.getPrimaryItemCount();
        int secondaryItemCount = this.f3703d.getSecondaryItemCount();
        if (primaryItemCount > 0) {
            c.d.b.d.b.a.d.a aVar = new c.d.b.d.b.a.d.a();
            for (int i = 0; i < primaryItemCount; i++) {
                NexPrimaryTimelineItem primaryItem = this.f3703d.getPrimaryItem(i);
                if (primaryItem instanceof NexVideoClipItem) {
                    NexVideoClipItem nexVideoClipItem = (NexVideoClipItem) primaryItem;
                    SourceItem a2 = a(nexVideoClipItem);
                    a((NexTimelineItem.e) nexVideoClipItem, a2);
                    a((NexTimelineItem.s) nexVideoClipItem, a2);
                    a(nexVideoClipItem, a2);
                    aVar.a(a2);
                } else if (primaryItem instanceof NexTransitionItem) {
                    NexTransitionItem nexTransitionItem = (NexTransitionItem) primaryItem;
                    d dVar = new d(c.d.b.d.e.a.a(nexTransitionItem.getDuration()), nexTransitionItem.getTransitionEffectID());
                    Map<String, String> effectOptions = nexTransitionItem.getEffectOptions();
                    if (effectOptions != null && effectOptions.size() > 0) {
                        for (Map.Entry<String, String> entry : effectOptions.entrySet()) {
                            dVar.a(new Effect.a(entry.getKey(), entry.getValue()));
                        }
                    }
                    aVar.a(dVar);
                }
            }
            this.f3704e.a(aVar);
        }
        if (secondaryItemCount > 0) {
            for (int i2 = 0; i2 < secondaryItemCount; i2++) {
                NexSecondaryTimelineItem secondaryItem = this.f3703d.getSecondaryItem(i2);
                if (secondaryItem instanceof NexAudioClipItem) {
                    NexAudioClipItem nexAudioClipItem = (NexAudioClipItem) secondaryItem;
                    com.nexstreaming.kinemaster.integration.kmxml.adapter.items.a a3 = a(nexAudioClipItem);
                    a(nexAudioClipItem, a3);
                    if (nexAudioClipItem.getVolumeEnvelopeLength() > 0) {
                        g gVar = new g();
                        for (int i3 = 0; i3 < nexAudioClipItem.getVolumeEnvelopeLength(); i3++) {
                            gVar.a(new g.a(c.d.b.d.e.a.a(nexAudioClipItem.getVolumeEnvelopeTime(i3)), nexAudioClipItem.getVolumeEnvelopeLevel(i3) / 100.0f));
                        }
                        a3.a(gVar);
                    }
                    this.f3704e.a(a3);
                } else if (secondaryItem instanceof NexLayerItem) {
                    this.f3704e.a(a((NexLayerItem) secondaryItem));
                }
            }
        }
        String a4 = c.d.b.d.c.a.f3755b.booleanValue() ? c.d.b.d.e.a.a(this.f3706g, this.f3704e.g(), "kmxml") : null;
        try {
            new c.d.b.d.b.b.a(this.f3704e, a4).a();
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(a4);
            Iterator<c.d.b.d.b.a.a.a> it = this.f3704e.e().iterator();
            while (it.hasNext()) {
                c.d.b.d.b.a.a.a next = it.next();
                if (new File(next.c()).exists()) {
                    arrayList.add(next.c());
                }
            }
            return arrayList;
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private void a(NexVideoClipItem nexVideoClipItem, SourceItem sourceItem) {
        if (nexVideoClipItem.getPlaybackSpeed() != 100) {
            sourceItem.a(new e(nexVideoClipItem.getPlaybackSpeed() / 100.0f));
        }
    }

    private void a(VideoLayer videoLayer, f fVar) {
        if (videoLayer.getPlaybackSpeed() != 100) {
            fVar.a(new e(videoLayer.getPlaybackSpeed() / 100.0f));
        }
    }

    private void a(NexTimelineItem.s sVar, SourceItem sourceItem) {
        sourceItem.a(new com.nexstreaming.kinemaster.integration.kmxml.adapter.effect.d(sVar.getRotation()));
    }

    private void a(NexTimelineItem.e eVar, SourceItem sourceItem) {
        com.nexstreaming.kinemaster.integration.kmxml.adapter.effect.a aVar = new com.nexstreaming.kinemaster.integration.kmxml.adapter.effect.a(eVar.getClipVolume(), eVar.getAudioLeftVolume(), eVar.getAudioRightVolume(), eVar.getMuteAudio());
        sourceItem.a(aVar);
        if (eVar.isCheckedAudioCompressor()) {
            new c("com.kinemaster.builtin.compressor").a(new Effect.a("strength", String.valueOf(eVar.getAudioCompressor())));
            sourceItem.a(aVar);
        }
    }

    private com.nexstreaming.kinemaster.integration.kmxml.adapter.items.a a(NexAudioClipItem nexAudioClipItem) {
        MediaInfo a2 = MediaInfo.a(nexAudioClipItem.getMediaPath());
        c.d.b.d.b.a.a.a aVar = new c.d.b.d.b.a.a.a(com.umeng.commonsdk.proguard.e.al + this.f3704e.e().size(), nexAudioClipItem.getMediaPath(), c.d.b.d.e.a.a(this.f3706g, nexAudioClipItem.getMediaPath()), c.d.b.d.e.a.e(nexAudioClipItem.getMediaPath()), c.d.b.d.e.a.a(a2.r()));
        com.nexstreaming.kinemaster.integration.kmxml.adapter.items.a aVar2 = new com.nexstreaming.kinemaster.integration.kmxml.adapter.items.a(aVar, c.d.b.d.e.a.a(nexAudioClipItem.getDuration()), c.d.b.d.e.a.a(nexAudioClipItem.getAbsStartTime()), c.d.b.d.e.a.a(nexAudioClipItem.getAbsEndTime()), c.d.b.d.e.a.a(nexAudioClipItem.getStartTrim()));
        this.f3704e.a(aVar);
        return aVar2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0098, code lost:            if (r14.getFlipV() != false) goto L11;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.nexstreaming.kinemaster.integration.kmxml.adapter.items.SourceItem a(com.nextreaming.nexeditorui.NexVideoClipItem r14) {
        /*
            Method dump skipped, instructions count: 491
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.d.b.d.b.a.a.a(com.nextreaming.nexeditorui.NexVideoClipItem):com.nexstreaming.kinemaster.integration.kmxml.adapter.items.SourceItem");
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x02ee A[LOOP:2: B:64:0x02e8->B:66:0x02ee, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0323  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x030d  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0314  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.nexstreaming.kinemaster.integration.kmxml.adapter.layer.LayerItem a(com.nexstreaming.kinemaster.editorwrapper.NexLayerItem r25) {
        /*
            Method dump skipped, instructions count: 1037
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.d.b.d.b.a.a.a(com.nexstreaming.kinemaster.editorwrapper.NexLayerItem):com.nexstreaming.kinemaster.integration.kmxml.adapter.layer.LayerItem");
    }
}
