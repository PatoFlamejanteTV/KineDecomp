package com.nexstreaming.kinemaster.ui.projectedit;

import android.app.Activity;
import android.graphics.Rect;
import android.os.AsyncTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.LayerExpression;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.intent.KMIntentData;
import com.nexstreaming.kinemaster.layer.ImageLayer;
import com.nexstreaming.kinemaster.layer.TextLayer;
import com.nexstreaming.kinemaster.layer.VideoLayer;
import com.nexstreaming.kinemaster.mediainfo.MediaInfo;
import com.nexstreaming.kinemaster.mediastore.MediaStore;
import com.nexstreaming.kinemaster.mediastore.item.MediaStoreItemId;
import com.nexstreaming.kinemaster.mediastore.provider.AndroidMediaStoreProvider;
import com.nextreaming.nexeditorui.ColorEffect;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.NexAudioClipItem;
import com.nextreaming.nexeditorui.NexVideoClipItem;
import java.io.File;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectEditActivity.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.xf, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class AsyncTaskC2075xf extends AsyncTask<Void, Integer, Void> {

    /* renamed from: a, reason: collision with root package name */
    int f22774a = 0;

    /* renamed from: b, reason: collision with root package name */
    int f22775b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ KMIntentData.Project f22776c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ com.nexstreaming.kinemaster.ui.a.r f22777d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ MediaStore f22778e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ int f22779f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ Task f22780g;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ ProjectEditActivity f22781h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AsyncTaskC2075xf(ProjectEditActivity projectEditActivity, KMIntentData.Project project, com.nexstreaming.kinemaster.ui.a.r rVar, MediaStore mediaStore, int i, Task task) {
        this.f22781h = projectEditActivity;
        this.f22776c = project;
        this.f22777d = rVar;
        this.f22778e = mediaStore;
        this.f22779f = i;
        this.f22780g = task;
        this.f22775b = this.f22776c.visualClips.size() + this.f22776c.audioClips.size() + this.f22776c.layers.size();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onProgressUpdate(Integer... numArr) {
        com.nexstreaming.kinemaster.ui.a.r rVar;
        super.onProgressUpdate(numArr);
        if (numArr == null || numArr.length <= 0 || (rVar = this.f22777d) == null || !rVar.isShowing()) {
            return;
        }
        this.f22777d.j(numArr[0].intValue());
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
        com.nexstreaming.kinemaster.ui.a.r rVar = this.f22777d;
        if (rVar != null) {
            rVar.setCancelable(false);
            this.f22777d.show();
            this.f22777d.j(this.f22774a);
            this.f22777d.i(this.f22775b);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void doInBackground(Void... voidArr) {
        ImageLayer imageLayer;
        Activity u;
        TextLayer textLayer;
        com.nexstreaming.kinemaster.mediastore.item.c b2;
        List<KMIntentData.VisualClip> list = this.f22776c.visualClips;
        if (list != null && list.size() > 0) {
            for (int size = this.f22776c.visualClips.size() - 1; size >= 0; size--) {
                KMIntentData.VisualClip visualClip = this.f22776c.visualClips.get(size);
                if (visualClip != null) {
                    MediaStoreItemId a2 = com.nexstreaming.kinemaster.mediastore.provider.s.a(this.f22781h, visualClip.path);
                    if (a2 == null) {
                        a2 = AndroidMediaStoreProvider.a(new File(visualClip.path));
                    }
                    MediaStoreItemId mediaStoreItemId = a2;
                    if (mediaStoreItemId != null && (b2 = this.f22778e.b(mediaStoreItemId)) != null) {
                        NexVideoClipItem a3 = this.f22781h.ja().a(0, mediaStoreItemId, b2, this.f22779f, false);
                        if (!a3.isImage()) {
                            double d2 = visualClip.duration;
                            double d3 = visualClip.playbackSpeed;
                            Double.isNaN(d3);
                            Double.isNaN(d2);
                            double d4 = d2 * (d3 / 100.0d);
                            int i = visualClip.startTrim;
                            double duration = a3.getDuration() - visualClip.startTrim;
                            Double.isNaN(duration);
                            a3.setTrim(i, (int) Math.max(0.0d, duration - d4));
                            a3.setPlaybackSpeed(visualClip.playbackSpeed);
                            a3.setClipVolume(visualClip.volume);
                            a3.setMuteAudio(visualClip.mute);
                        } else {
                            a3.setDuration(visualClip.duration);
                        }
                        a3.setRotation(visualClip.rotation);
                        a3.setBrightness(visualClip.brightness);
                        a3.setContrast(visualClip.contrast);
                        a3.setSaturation(visualClip.saturation);
                        a3.setEffectID(visualClip.clipEffectId);
                        a3.setVignette(visualClip.vignette);
                        a3.setColorEffect(ColorEffect.fromPresetName(visualClip.colorFilterId));
                        float f2 = visualClip.cropStartLeft;
                        float f3 = visualClip.cropStartRight;
                        if (f2 != f3) {
                            float f4 = visualClip.cropStartTop;
                            float f5 = visualClip.cropStartBottom;
                            if (f4 != f5) {
                                a3.setStartPosition(new Rect((int) f2, (int) f4, (int) f3, (int) f5));
                            }
                        }
                        float f6 = visualClip.cropEndLeft;
                        float f7 = visualClip.cropEndRight;
                        if (f6 != f7) {
                            float f8 = visualClip.cropEndTop;
                            float f9 = visualClip.cropEndBottom;
                            if (f8 != f9) {
                                a3.setEndPosition(new Rect((int) f6, (int) f8, (int) f7, (int) f9));
                            }
                        }
                        a3.setFlipH(visualClip.fliph);
                        a3.setFlipV(visualClip.flipv);
                        a3.getTransition().setTransitionEffectID(visualClip.transitionEffectId);
                        a3.getTransition().setDuration(visualClip.transitionDuration);
                        this.f22778e.a(b2, new C1973of(this, a3));
                    }
                }
                int i2 = this.f22774a + 1;
                this.f22774a = i2;
                publishProgress(Integer.valueOf(i2));
            }
        }
        List<KMIntentData.AudioClip> list2 = this.f22776c.audioClips;
        if (list2 != null && list2.size() > 0) {
            for (KMIntentData.AudioClip audioClip : this.f22776c.audioClips) {
                NexAudioClipItem a4 = this.f22781h.ja().a(audioClip.startTime, audioClip.path, false);
                a4.setStartTime(audioClip.startTime);
                int i3 = audioClip.endTime;
                if (i3 > 0) {
                    a4.setEndTime(i3);
                }
                a4.setLoop(audioClip.loop);
                a4.setBGM(audioClip.background);
                int i4 = audioClip.startTrim;
                if (i4 > 0) {
                    a4.setStartTrim(i4);
                }
                int i5 = audioClip.endTrim;
                if (i5 > 0) {
                    a4.setEndTrim(i5);
                }
                a4.setClipVolume(audioClip.volume);
                int i6 = this.f22774a + 1;
                this.f22774a = i6;
                publishProgress(Integer.valueOf(i6));
            }
        }
        List<KMIntentData.Layer> list3 = this.f22776c.layers;
        if (list3 == null || list3.size() <= 0) {
            return null;
        }
        for (KMIntentData.Layer layer : this.f22776c.layers) {
            int i7 = C2068wg.f22756a[layer.layerType.ordinal()];
            if (i7 == 1) {
                imageLayer = new ImageLayer();
                com.nexstreaming.kinemaster.mediastore.item.c b3 = this.f22781h.W().b(AndroidMediaStoreProvider.a(new File(layer.imageLayerAttributes.path)));
                imageLayer.setRelativeStartTime(layer.startTime);
                imageLayer.setRelativeEndTime(layer.startTime + this.f22779f);
                NexLayerItem.b closestKeyframe = imageLayer.getClosestKeyframe(0.0f);
                closestKeyframe.f20232c = EditorGlobal.n() / 2;
                closestKeyframe.f20233d = EditorGlobal.m() / 2;
                closestKeyframe.f20231b = 1.0f;
                closestKeyframe.f20234e = 0.0f;
                String path = b3.getPath();
                u = this.f22781h.u();
                imageLayer.setMediaPath(path, u);
                int height = imageLayer.getHeight();
                int width = imageLayer.getWidth();
                if (width > 1440) {
                    closestKeyframe.f20231b = 1440.0f / width;
                }
                if (height > 540) {
                    closestKeyframe.f20231b = Math.min(closestKeyframe.f20231b, 540.0f / height);
                }
            } else if (i7 == 2) {
                KMIntentData.VideoLayerAttributes videoLayerAttributes = layer.videoLayerAttributes;
                com.nexstreaming.kinemaster.mediastore.item.c b4 = this.f22781h.W().b(AndroidMediaStoreProvider.a(new File(videoLayerAttributes.path)));
                MediaInfo a5 = MediaInfo.a(videoLayerAttributes.path);
                VideoLayer fromMediaStoreItem = VideoLayer.fromMediaStoreItem(b4);
                fromMediaStoreItem.setEndTime(layer.endTime);
                fromMediaStoreItem.setStartTime(layer.startTime);
                fromMediaStoreItem.setStartTrim(videoLayerAttributes.startTrim);
                fromMediaStoreItem.setMuteAudio(videoLayerAttributes.mute);
                fromMediaStoreItem.setBrightness(videoLayerAttributes.brightness);
                fromMediaStoreItem.setClipVolume(videoLayerAttributes.volume);
                fromMediaStoreItem.setSaturation(videoLayerAttributes.saturation);
                fromMediaStoreItem.setContrast(videoLayerAttributes.contrast);
                NexLayerItem.b closestKeyframe2 = fromMediaStoreItem.getClosestKeyframe(0.0f);
                closestKeyframe2.f20232c = EditorGlobal.n() / 2;
                closestKeyframe2.f20233d = EditorGlobal.m() / 2;
                closestKeyframe2.f20231b = 1.0f;
                closestKeyframe2.f20234e = -a5.z();
                int height2 = fromMediaStoreItem.getHeight();
                int width2 = fromMediaStoreItem.getWidth();
                if ((closestKeyframe2.f20234e / 90.0f) % 2.0f != 0.0f) {
                    if (height2 > 1440) {
                        closestKeyframe2.f20231b = 1440.0f / height2;
                    }
                    if (width2 > 540) {
                        closestKeyframe2.f20231b = Math.min(closestKeyframe2.f20231b, 540.0f / width2);
                    }
                } else {
                    if (width2 > 1440) {
                        closestKeyframe2.f20231b = 1440.0f / width2;
                    }
                    if (height2 > 540) {
                        closestKeyframe2.f20231b = Math.min(closestKeyframe2.f20231b, 540.0f / height2);
                    }
                }
                imageLayer = fromMediaStoreItem;
            } else if (i7 == 3 || i7 != 4) {
                imageLayer = null;
            } else {
                KMIntentData.TextLayerAttributes textLayerAttributes = layer.textLayerAttributes;
                List<KMIntentData.KeyFrame> list4 = layer.keyFrames;
                if (list4 != null && list4.size() > 0) {
                    TextLayer newInstance = TextLayer.newInstance(textLayerAttributes.text, layer.startTime, layer.endTime, (int) layer.keyFrames.get(0).x, (int) layer.keyFrames.get(0).y, layer.keyFrames.get(0).scale, layer.keyFrames.get(0).angle);
                    newInstance.setAlpha((int) (layer.keyFrames.get(0).alpha * 255.0f));
                    textLayer = newInstance;
                } else {
                    textLayer = TextLayer.newInstance(textLayerAttributes.text, layer.startTime, layer.endTime);
                }
                textLayer.setTextSize(textLayerAttributes.textSize);
                textLayer.setFontId(textLayerAttributes.fontId);
                textLayer.setColorOption(R.id.opt_text_color, textLayerAttributes.textColor);
                textLayer.setColorOption(R.id.opt_shadow, textLayerAttributes.shadowColor);
                textLayer.setColorOption(R.id.opt_outline, textLayerAttributes.outlineColor);
                textLayer.setColorOption(R.id.opt_glow, textLayerAttributes.glowColor);
                textLayer.setColorOption(R.id.opt_background_color, textLayerAttributes.backgroundColor);
                String str = layer.animationIn;
                if (str != null && !str.equalsIgnoreCase(LayerExpression.None.name())) {
                    textLayer.setLayerExpression(LayerExpression.Type.In, LayerExpression.valueOf(layer.animationIn));
                    textLayer.setLayerExpressionDuration(LayerExpression.Type.In, layer.animationInDuration);
                }
                String str2 = layer.animationOut;
                if (str2 != null && !str2.equalsIgnoreCase(LayerExpression.None.name())) {
                    textLayer.setLayerExpression(LayerExpression.Type.Out, LayerExpression.valueOf(layer.animationOut));
                    textLayer.setLayerExpressionDuration(LayerExpression.Type.Out, layer.animationOutDuration);
                }
                String str3 = layer.animationOverall;
                if (str3 != null && !str3.equalsIgnoreCase(LayerExpression.None.name())) {
                    textLayer.setLayerExpression(LayerExpression.Type.Overall, LayerExpression.valueOf(layer.animationOverall));
                }
                imageLayer = textLayer;
            }
            if (imageLayer != null) {
                this.f22781h.ja().a((NexLayerItem) imageLayer);
            }
            int i8 = this.f22774a + 1;
            this.f22774a = i8;
            publishProgress(Integer.valueOf(i8));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Void r4) {
        super.onPostExecute(r4);
        this.f22780g.signalEvent(Task.Event.COMPLETE, Task.Event.SUCCESS);
    }
}
