package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.Intent;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.codeccaps.CapabilityManager;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.layer.ImageLayer;
import com.nexstreaming.kinemaster.layer.MediaLayer;
import com.nexstreaming.kinemaster.layer.VideoLayer;
import com.nexstreaming.kinemaster.mediastore.MediaSupportType;
import com.nexstreaming.kinemaster.project.TimelineResourceUsage;
import com.nexstreaming.kinemaster.ui.a.e;
import com.nexstreaming.kinemaster.ui.a.r;
import com.nexstreaming.kinemaster.ui.layereditrender.MarchingAnts;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.NexAudioClipItem;
import com.nextreaming.nexeditorui.NexEditorDeviceProfile;
import com.nextreaming.nexeditorui.NexExportProfile;
import com.nextreaming.nexeditorui.NexTimeline;
import com.nextreaming.nexeditorui.NexTimelineItem;
import com.nextreaming.nexeditorui.NexVideoClipItem;
import com.nextreaming.nexvideoeditor.NexEditor;
import java.io.File;
import java.lang.ref.WeakReference;

/* compiled from: MediaEditFragment.java */
/* loaded from: classes2.dex */
public class Mb extends Xc implements InterfaceC1866cf, FragmentManager.OnBackStackChangedListener {
    private LayerTransformTouchHandler C;
    private WeakReference<com.nexstreaming.kinemaster.ui.a.e> G;
    private MarchingAnts D = new MarchingAnts(MarchingAnts.Feature.SIZE_HANDLE, MarchingAnts.Feature.ROTATE_HANDLE, MarchingAnts.Feature.SPLIT_HANDLE);
    private VideoEditor.b E = new Db(this);
    private boolean F = false;
    private Object H = this;
    private boolean I = false;

    private void Aa() {
        VideoLayer videoLayer;
        NexTimelineItem Y = Y();
        if (Y == null) {
            return;
        }
        NexVideoClipItem nexVideoClipItem = null;
        if (Y instanceof NexVideoClipItem) {
            nexVideoClipItem = (NexVideoClipItem) Y;
            videoLayer = null;
        } else {
            videoLayer = Y instanceof VideoLayer ? (VideoLayer) Y : null;
        }
        if (nexVideoClipItem != null) {
            NexAudioClipItem a2 = da().a(nexVideoClipItem.getAbsStartTime() - nexVideoClipItem.getTrimTimeStart(), nexVideoClipItem.getMediaPath(), false);
            nexVideoClipItem.setMuteAudio(true);
            da().c(nexVideoClipItem);
            a2.trimClip(nexVideoClipItem.getAbsStartTime(), nexVideoClipItem.getAbsEndTime() - 1);
            b(a2);
            return;
        }
        if (videoLayer != null) {
            NexAudioClipItem a3 = da().a(videoLayer.getAbsStartTime() - videoLayer.getStartTrim(), videoLayer.getMediaPath(), false);
            videoLayer.setMuteAudio(true);
            da().c((NexTimelineItem) videoLayer);
            a3.trimClip(videoLayer.getAbsStartTime(), videoLayer.getAbsEndTime() - 1);
            b(a3);
        }
    }

    private MediaLayer Ba() {
        NexTimelineItem Y = Y();
        if (Y == null || !(Y instanceof MediaLayer)) {
            return null;
        }
        return (MediaLayer) Y;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(String str) {
        VideoLayer videoLayer = (VideoLayer) Y();
        if (str == null || str.equals(videoLayer.getMediaPath())) {
            return;
        }
        videoLayer.changeMediaPathAfterTranscode(str);
        da().s().a().recalculateResourceUsage();
        da().J();
        ha();
        na();
        da().N();
        da().H();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc, com.nexstreaming.kinemaster.ui.projectedit.Bg
    public void na() {
        super.na();
        if (this.I) {
            this.I = false;
            za();
        }
        VideoEditor da = da();
        View Q = Q();
        MediaLayer Ba = Ba();
        if (da == null || da.s() == null || Q == null) {
            return;
        }
        this.C.a((NexLayerItem) Y());
        if (this.D == null) {
            this.D = new MarchingAnts(MarchingAnts.Feature.SIZE_HANDLE, MarchingAnts.Feature.ROTATE_HANDLE);
        }
        Rect rect = new Rect();
        Ba.getBounds(rect);
        if (Ba.getCropBounds(new RectF())) {
            this.D.a((int) r5.left, (int) r5.top, (int) r5.right, (int) r5.bottom);
        } else {
            this.D.a(rect);
        }
        Q.addOnLayoutChangeListener(new Hb(this));
        Q.getViewTreeObserver().addOnGlobalLayoutListener(new Ib(this));
        c(R.id.action_animation, Ba.isSplitScreenEnabled() ? false : true);
        o(R.id.editmode_trim);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg
    public void oa() {
        if (Y() instanceof NexLayerItem) {
            a(R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_animation, R.drawable.action_animation, R.id.action_delete, R.drawable.action_icon_delete, R.id.action_overflow, R.drawable.action_overflow, R.id.action_duplicate_clip, R.string.action_duplicate_clip, R.id.action_bring_to_front, R.string.action_bring_to_front, R.id.action_bring_forward, R.string.action_bring_forward, R.id.action_send_backward, R.string.action_send_backward, R.id.action_send_to_back, R.string.action_send_to_back, R.id.action_align_center_horizontal, R.string.action_center_horizontal, R.id.action_align_center_vertical, R.string.action_center_vertical);
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc, android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.support.v4.app.FragmentManager.OnBackStackChangedListener
    public void onBackStackChanged() {
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg, android.support.v4.app.Fragment
    public void onDestroy() {
        this.I = false;
        super.onDestroy();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc, com.nexstreaming.kinemaster.ui.projectedit.Bg, android.support.v4.app.Fragment
    public void onDestroyView() {
        WeakReference<com.nexstreaming.kinemaster.ui.a.e> weakReference = this.G;
        if (weakReference != null) {
            com.nexstreaming.kinemaster.ui.a.e eVar = weakReference.get();
            if (eVar != null) {
                eVar.dismiss();
            }
            this.G = null;
        }
        this.C = null;
        this.I = false;
        super.onDestroyView();
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        if (da().q() == this.D) {
            da().a(this.H, (NexLayerItem) null, (VideoEditor.b) null, (VideoEditor.b) null);
        }
        this.D = null;
        da().a(NexEditor.FastPreviewOption.normal, 0, true);
        super.onStop();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg
    public void pa() {
        if (Y() instanceof NexLayerItem) {
            a(R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_expand_preview, R.drawable.action_inset_preview, R.id.action_delete, R.drawable.action_icon_delete, R.id.action_overflow, R.drawable.action_overflow, R.id.action_duplicate_clip, R.string.action_duplicate_clip);
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc
    protected boolean r(int i) {
        if (i == R.id.opt_extract_audio) {
            Aa();
            return true;
        }
        if (i == R.id.opt_color_filter) {
            if (da().q() == this.D) {
                da().a(this.H, (NexLayerItem) null, (VideoEditor.b) null, (VideoEditor.b) null);
            }
            this.D = null;
            da().a(NexEditor.FastPreviewOption.normal, 0, true);
        }
        if (i != R.id.opt_reverse) {
            return false;
        }
        e(Y());
        return true;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc
    protected boolean ta() {
        return true;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc
    protected int[] ua() {
        MediaLayer Ba = Ba();
        if (Ba instanceof VideoLayer) {
            if (Build.VERSION.SDK_INT >= 18) {
                return new int[]{R.id.opt_split_trim, R.id.opt_splitscreen, R.id.opt_volume_and_balance, R.id.opt_in_expression, R.id.opt_overall_expression, R.id.opt_out_expression, R.id.opt_chroma_key, R.id.opt_layer_crop, R.id.opt_reverse, R.id.opt_layer_nudge, R.id.opt_alpha_adj, R.id.opt_color_filter, R.id.opt_rotate, R.id.opt_color_adj, R.id.opt_audio_eq, R.id.opt_volume_env, R.id.opt_audio_voice_changer, R.id.opt_layer_mask, R.id.opt_blending, R.id.opt_extract_audio, R.id.opt_information};
            }
            return new int[]{R.id.opt_split_trim, R.id.opt_splitscreen, R.id.opt_volume_and_balance, R.id.opt_in_expression, R.id.opt_overall_expression, R.id.opt_out_expression, R.id.opt_chroma_key, R.id.opt_layer_crop, R.id.opt_layer_nudge, R.id.opt_alpha_adj, R.id.opt_color_filter, R.id.opt_rotate, R.id.opt_color_adj, R.id.opt_audio_eq, R.id.opt_volume_env, R.id.opt_audio_voice_changer, R.id.opt_layer_mask, R.id.opt_blending, R.id.opt_extract_audio, R.id.opt_information};
        }
        if ((Ba instanceof ImageLayer) && ((ImageLayer) Ba).isSolid()) {
            return new int[]{R.id.opt_color, R.id.opt_split_trim, R.id.opt_splitscreen, R.id.opt_in_expression, R.id.opt_overall_expression, R.id.opt_out_expression, R.id.opt_layer_crop, R.id.opt_layer_nudge, R.id.opt_alpha_adj, R.id.opt_color_filter, R.id.opt_color_adj, R.id.opt_layer_mask, R.id.opt_blending, R.id.opt_information};
        }
        return new int[]{R.id.opt_split_trim, R.id.opt_splitscreen, R.id.opt_rotate, R.id.opt_in_expression, R.id.opt_overall_expression, R.id.opt_out_expression, R.id.opt_layer_crop, R.id.opt_layer_nudge, R.id.opt_alpha_adj, R.id.opt_color_filter, R.id.opt_color_adj, R.id.opt_layer_mask, R.id.opt_blending, R.id.opt_information};
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc
    protected String va() {
        return Y().getDescriptiveSubtitle(xa());
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc
    protected String wa() {
        return Y().getDescriptiveTitle(xa());
    }

    public void za() {
        NexExportProfile nexExportProfile;
        File a2;
        String string;
        String string2;
        String string3;
        String string4;
        boolean z;
        boolean z2;
        String string5;
        String string6;
        String string7;
        NexExportProfile transcodeProfile;
        String string8;
        NexExportProfile transcodeProfile2;
        if (!isAdded()) {
            this.I = true;
            return;
        }
        MediaLayer Ba = Ba();
        if (Ba != null) {
            VideoEditor da = da();
            o(R.id.editmode_trim);
            if (this.F || !Ba.getOverLimit() || da == null || da.s() == null || !(Ba instanceof VideoLayer)) {
                return;
            }
            this.F = true;
            NexTimeline a3 = da.s().a();
            TimelineResourceUsage.b a4 = a3.getResourceUsage().a(Ba);
            boolean i = da.i();
            MediaSupportType mediaSupportType = Ba.getMediaSupportType();
            NexEditorDeviceProfile deviceProfile = NexEditorDeviceProfile.getDeviceProfile();
            File file = new File(Ba.getMediaPath());
            if (a4.a(TimelineResourceUsage.Limit.VideoLayerCount)) {
                e.a a5 = com.nexstreaming.kinemaster.ui.a.e.a(getActivity());
                a5.e(R.string.tllimit_max_video_title);
                a5.c(R.string.tllimit_max_video_text);
                a5.a().show();
                return;
            }
            if (a4.a(TimelineResourceUsage.Limit.AudioTrackCount)) {
                e.a a6 = com.nexstreaming.kinemaster.ui.a.e.a(getActivity());
                a6.e(R.string.tllimit_max_audio_title);
                a6.c(R.string.tllimit_max_audio_text);
                a6.a().show();
                return;
            }
            if (mediaSupportType.isNotSupported()) {
                e.a a7 = com.nexstreaming.kinemaster.ui.a.e.a(getActivity());
                a7.a(mediaSupportType.getNotSupportedReason(getActivity()));
                a7.a().show();
                return;
            }
            if (mediaSupportType.needsTranscode() || a4.a(TimelineResourceUsage.Limit.DecoderMemoryUsage)) {
                int g2 = a3.getAdjustedResourceUsage().a(Ba).g();
                int i2 = Cb.f21798a[mediaSupportType.ordinal()];
                if (i2 == 1) {
                    nexExportProfile = null;
                } else if (i2 == 2 || i2 == 3) {
                    nexExportProfile = deviceProfile.getTranscodeProfile(i, Ba.getOriginalWidth(), Ba.getOriginalHeight());
                } else if (i2 == 4) {
                    if (CapabilityManager.f20040b.t()) {
                        nexExportProfile = deviceProfile.getTranscodeProfile(i);
                    } else {
                        nexExportProfile = deviceProfile.getTranscodeProfile(Ba.getOriginalWidth(), Ba.getOriginalHeight());
                    }
                } else {
                    throw new IllegalStateException(String.valueOf(mediaSupportType));
                }
                NexExportProfile preferredTranscodingProfile = ((VideoLayer) Ba).getPreferredTranscodingProfile();
                if (preferredTranscodingProfile == null) {
                    if (CapabilityManager.f20040b.t()) {
                        transcodeProfile2 = deviceProfile.getTranscodeProfile(i, Ba.getOriginalWidth(), Ba.getOriginalHeight(), g2);
                    } else {
                        transcodeProfile2 = deviceProfile.getTranscodeProfile(Ba.getOriginalWidth(), Ba.getOriginalHeight());
                    }
                    preferredTranscodingProfile = transcodeProfile2;
                }
                if (preferredTranscodingProfile == null) {
                    e.a a8 = com.nexstreaming.kinemaster.ui.a.e.a(getActivity());
                    a8.c(R.string.tllimit_no_codecmem);
                    a8.a().show();
                    return;
                }
                if (nexExportProfile != null && nexExportProfile.equals(preferredTranscodingProfile)) {
                    if (CapabilityManager.f20040b.t()) {
                        a2 = c.d.b.k.b.a(xa(), file, mediaSupportType);
                    } else {
                        a2 = c.d.b.k.b.a(xa(), file, mediaSupportType, Ba.getOriginalHeight());
                    }
                    boolean exists = a2.exists();
                    int i3 = Cb.f21798a[mediaSupportType.ordinal()];
                    if (i3 == 2 || i3 == 3) {
                        if (exists) {
                            string2 = getResources().getString(R.string.mediabrowser_dialog_exist_coverted_file_by_fps);
                            string6 = getResources().getString(R.string.mediabrowser_dialog_button_use_fps);
                            string7 = getResources().getString(R.string.button_cancel);
                        } else {
                            string2 = getResources().getString(R.string.mediabrowser_dialog_transcoder_by_fps);
                            string6 = getResources().getString(R.string.mediabrowser_dialog_button_convert_fps);
                            string7 = getResources().getString(R.string.tllimit_heavy_no_reencode);
                        }
                        string4 = string7;
                        z = exists;
                        z2 = true;
                    } else if (i3 == 4) {
                        if (CapabilityManager.f20040b.t()) {
                            transcodeProfile = NexEditorDeviceProfile.getDeviceProfile().getTranscodeProfile(EditorGlobal.i().b());
                        } else {
                            transcodeProfile = NexEditorDeviceProfile.getDeviceProfile().getTranscodeProfile(Ba.getOriginalWidth(), Ba.getOriginalHeight());
                        }
                        if (exists) {
                            string2 = getResources().getString(R.string.mediabrowser_dialog_exist_coverted_file_by_resolution, Integer.valueOf(Ba.getOriginalWidth()), Integer.valueOf(Ba.getOriginalHeight()), Integer.valueOf(transcodeProfile.width()), Integer.valueOf(transcodeProfile.displayHeight()), Integer.valueOf(transcodeProfile.displayHeight()));
                            string6 = getResources().getString(R.string.mediabrowser_dialog_button_use_resolution, Integer.valueOf(transcodeProfile.displayHeight()));
                            string8 = getResources().getString(R.string.button_cancel);
                        } else {
                            string2 = getResources().getString(R.string.mediabrowser_dialog_transcoder_by_resolution, Integer.valueOf(Ba.getOriginalWidth()), Integer.valueOf(Ba.getOriginalHeight()), Integer.valueOf(transcodeProfile.width()), Integer.valueOf(transcodeProfile.displayHeight()), Integer.valueOf(transcodeProfile.displayHeight()));
                            string6 = getResources().getString(R.string.mediabrowser_dialog_button_convert_resolution, Integer.valueOf(transcodeProfile.displayHeight()));
                            string8 = getResources().getString(R.string.tllimit_heavy_no_reencode);
                        }
                        string4 = string8;
                        z = exists;
                        z2 = false;
                    } else {
                        throw new IllegalStateException(String.valueOf(mediaSupportType));
                    }
                    string = null;
                    string3 = string6;
                } else {
                    a2 = c.d.b.k.b.a(xa(), file, preferredTranscodingProfile);
                    boolean exists2 = a2.exists();
                    string = getResources().getString(R.string.tllimit_heavy_title);
                    if (preferredTranscodingProfile.displayHeight() >= Ba.getOriginalHeight()) {
                        string2 = getResources().getString(R.string.mediabrowser_dialog_exist_coverted_file_by_fps);
                        if (exists2) {
                            string5 = getResources().getString(R.string.mediabrowser_dialog_button_use_fps);
                        } else {
                            string5 = getResources().getString(R.string.mediabrowser_dialog_button_convert_fps);
                        }
                        string3 = string5;
                        string4 = getResources().getString(R.string.button_cancel);
                        z = exists2;
                        z2 = true;
                    } else {
                        string2 = getResources().getString(R.string.tllimit_heavy_text, Integer.valueOf(preferredTranscodingProfile.displayHeight()));
                        string3 = getResources().getString(R.string.tllimit_heavy_reencode, Integer.valueOf(preferredTranscodingProfile.displayHeight()));
                        string4 = getResources().getString(R.string.tllimit_heavy_no_reencode);
                        z = exists2;
                        z2 = false;
                    }
                }
                e.a aVar = new e.a(getActivity());
                aVar.c(string);
                aVar.a(string2);
                aVar.b(string3, new Fb(this, z, a2, preferredTranscodingProfile, z2));
                aVar.a(string4, new Eb(this));
                aVar.a(true);
                com.nexstreaming.kinemaster.ui.a.e a9 = aVar.a();
                this.G = new WeakReference<>(a9);
                a9.show();
                a9.setOnDismissListener(new Gb(this));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.C = new LayerTransformTouchHandler(getActivity(), Ba(), da());
        return super.a(layoutInflater, viewGroup, bundle);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.InterfaceC1866cf
    public boolean a(View view, MotionEvent motionEvent) {
        LayerTransformTouchHandler layerTransformTouchHandler;
        if (!isAdded() || Ba() == null || (layerTransformTouchHandler = this.C) == null) {
            return false;
        }
        return layerTransformTouchHandler.a(view, motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(c.d.b.k.j jVar) {
        if (((int) jVar.d()) < 0) {
            return getString(R.string.export_est);
        }
        return isAdded() ? EditorGlobal.b(getResources(), (int) jVar.d()) : "Oops, Can't get the remaining time.";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(NexExportProfile nexExportProfile, File file, boolean z) {
        File file2 = new File(((VideoLayer) Y()).getMediaPath());
        boolean a2 = c.d.b.k.i.a(file2);
        c.d.b.k.j a3 = c.d.b.k.i.a(getActivity(), file2, file, nexExportProfile);
        r.a aVar = new r.a(getActivity());
        aVar.c(R.string.file_prep_transcoding);
        if (z) {
            aVar.a(getString(R.string.mediabrowser_transcode_in_progress_fps, getString(R.string.export_est)));
        } else {
            aVar.a(getString(R.string.mediabrowser_transcode_in_progress, Integer.valueOf(nexExportProfile.width()), Integer.valueOf(nexExportProfile.displayHeight()), getString(R.string.export_est)));
        }
        aVar.a(false);
        aVar.a(R.string.button_cancel, new Jb(this, a2, a3));
        com.nexstreaming.kinemaster.ui.a.r a4 = aVar.a();
        a4.setOnShowListener(new Kb(this));
        a4.show();
        a3.onProgress(new Lb(this, a4, a3, z, nexExportProfile));
        a3.onComplete(new C2087zb(this, file, a4));
        a3.onFailure(new Bb(this, a4));
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc, com.nexstreaming.kinemaster.ui.projectedit.C1935kd.a
    public void a(int i) {
        super.a(i);
    }
}
