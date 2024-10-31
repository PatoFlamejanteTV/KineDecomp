package com.nexstreaming.kinemaster.ui.projectedit;

import android.app.FragmentManager;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.layer.ImageLayer;
import com.nexstreaming.kinemaster.layer.MediaLayer;
import com.nexstreaming.kinemaster.layer.VideoLayer;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem;
import com.nexstreaming.kinemaster.project.TimelineResourceUsage;
import com.nexstreaming.kinemaster.ui.a.a;
import com.nexstreaming.kinemaster.ui.a.e;
import com.nexstreaming.kinemaster.ui.layereditrender.MarchingAnts;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.NexEditorDeviceProfile;
import com.nextreaming.nexeditorui.NexExportProfile;
import com.nextreaming.nexeditorui.NexTimeline;
import com.nextreaming.nexeditorui.NexTimelineItem;
import com.nextreaming.nexvideoeditor.NexEditor;
import java.io.File;
import java.lang.ref.WeakReference;

/* compiled from: MediaEditFragment.java */
/* loaded from: classes.dex */
public class bo extends ed implements FragmentManager.OnBackStackChangedListener, ht {

    /* renamed from: a, reason: collision with root package name */
    private LayerTransformTouchHandler f3795a;
    private WeakReference<com.nexstreaming.kinemaster.ui.a.a> e;
    private MarchingAnts b = new MarchingAnts(MarchingAnts.Feature.SIZE_HANDLE, MarchingAnts.Feature.ROTATE_HANDLE, MarchingAnts.Feature.SPLIT_HANDLE);
    private VideoEditor.b c = new bp(this);
    private boolean d = false;
    private boolean f = false;

    @Override // android.app.Fragment
    public void onStop() {
        this.b = null;
        o().a((NexLayerItem) null, (VideoEditor.b) null, (VideoEditor.b) null);
        o().a(NexEditor.FastPreviewOption.normal, 0, true);
        super.onStop();
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        this.f = false;
        super.onDestroy();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.ed, android.app.Fragment
    public void onDestroyView() {
        if (this.e != null) {
            com.nexstreaming.kinemaster.ui.a.a aVar = this.e.get();
            if (aVar != null) {
                aVar.dismiss();
            }
            this.e = null;
        }
        this.f3795a = null;
        this.f = false;
        super.onDestroyView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.projectedit.ed
    public View a_(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f3795a = new LayerTransformTouchHandler(getActivity(), H(), o());
        return super.a_(layoutInflater, viewGroup, bundle);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.kp, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        a(R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_animation, R.drawable.action_animation, R.id.action_delete, R.drawable.action_icon_delete, R.id.action_overflow, R.drawable.action_overflow, R.id.action_send_to_back, R.string.action_send_to_back, R.id.action_bring_to_front, R.string.action_bring_to_front, R.id.action_duplicate_clip, R.string.action_duplicate_clip);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.ed
    protected String a() {
        return m().getDescriptiveTitle(i());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.projectedit.ed
    public String j_() {
        return m().getDescriptiveSubtitle(i());
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.ed
    protected int[] c() {
        MediaLayer H = H();
        if (H instanceof VideoLayer) {
            return new int[]{R.id.opt_split_trim, R.id.opt_splitscreen, R.id.opt_volume_and_balance, R.id.opt_in_expression, R.id.opt_overall_expression, R.id.opt_out_expression, R.id.opt_chroma_key, R.id.opt_alpha_adj, R.id.opt_color_tint, R.id.opt_color_adj, R.id.opt_rotate, R.id.opt_volume_env, R.id.opt_audio_effect, R.id.opt_layer_mask, R.id.opt_layer_name};
        }
        if ((H instanceof ImageLayer) && ((ImageLayer) H).isSolid()) {
            return new int[]{R.id.opt_color, R.id.opt_split_trim, R.id.opt_splitscreen, R.id.opt_in_expression, R.id.opt_overall_expression, R.id.opt_out_expression, R.id.opt_alpha_adj, R.id.opt_color_tint, R.id.opt_color_adj, R.id.opt_layer_mask, R.id.opt_layer_name};
        }
        return new int[]{R.id.opt_split_trim, R.id.opt_splitscreen, R.id.opt_rotate, R.id.opt_in_expression, R.id.opt_overall_expression, R.id.opt_out_expression, R.id.opt_color_tint, R.id.opt_alpha_adj, R.id.opt_color_adj, R.id.opt_layer_mask, R.id.opt_layer_name};
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.ed
    protected boolean d(int i) {
        return false;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.ed, android.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    private MediaLayer H() {
        NexTimelineItem m = m();
        if (m == null || !(m instanceof MediaLayer)) {
            return null;
        }
        return (MediaLayer) m;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.ht
    public boolean a(View view, MotionEvent motionEvent) {
        if (!isAdded() || H() == null || this.f3795a == null) {
            return false;
        }
        return this.f3795a.a(view, motionEvent);
    }

    public void h() {
        NexExportProfile transcodeProfile;
        File a2;
        boolean exists;
        String str;
        String string;
        String str2;
        String str3;
        boolean z;
        String string2;
        String string3;
        String string4;
        String string5;
        String string6;
        String string7;
        String string8;
        if (!isAdded()) {
            this.f = true;
            return;
        }
        MediaLayer H = H();
        if (H != null) {
            VideoEditor o = o();
            g(R.id.editmode_trim);
            if (!this.d && H.getOverLimit() && o != null && o.f() != null && (H instanceof VideoLayer)) {
                this.d = true;
                NexTimeline a3 = o.f().a();
                TimelineResourceUsage.b a4 = a3.getResourceUsage().a(H);
                boolean A = o.A();
                MediaStoreItem.MediaSupportType mediaSupportType = H.getMediaSupportType();
                NexEditorDeviceProfile deviceProfile = NexEditorDeviceProfile.getDeviceProfile();
                File file = new File(H.getMediaPath());
                if (a4.a(TimelineResourceUsage.Limit.VideoLayerCount)) {
                    com.nexstreaming.kinemaster.ui.a.a.a(getActivity()).f(R.string.tllimit_max_video_title).a(R.string.tllimit_max_video_text).a().show();
                    return;
                }
                if (a4.a(TimelineResourceUsage.Limit.AudioTrackCount)) {
                    com.nexstreaming.kinemaster.ui.a.a.a(getActivity()).f(R.string.tllimit_max_audio_title).a(R.string.tllimit_max_audio_text).a().show();
                    return;
                }
                if (mediaSupportType.isNotSupported()) {
                    com.nexstreaming.kinemaster.ui.a.a.a(getActivity()).a(mediaSupportType.getNotSupportedReason(getActivity())).a().show();
                    return;
                }
                if (mediaSupportType.needsTranscode() || a4.a(TimelineResourceUsage.Limit.DecoderMemoryUsage)) {
                    int f = a3.getAdjustedResourceUsage().a(H).f();
                    switch (mediaSupportType) {
                        case Supported:
                            transcodeProfile = null;
                            break;
                        case NeedTranscodeFPS:
                            transcodeProfile = deviceProfile.getTranscodeProfile(A, H.getOriginalWidth(), H.getOriginalHeight());
                            break;
                        case NeedTranscodeRes:
                            transcodeProfile = deviceProfile.getTranscodeProfile(A);
                            break;
                        default:
                            throw new IllegalStateException(String.valueOf(mediaSupportType));
                    }
                    NexExportProfile preferredTranscodingProfile = ((VideoLayer) H).getPreferredTranscodingProfile();
                    if (preferredTranscodingProfile == null) {
                        preferredTranscodingProfile = deviceProfile.getTranscodeProfile(A, H.getOriginalWidth(), H.getOriginalHeight(), f);
                    }
                    if (preferredTranscodingProfile == null) {
                        com.nexstreaming.kinemaster.ui.a.a.a(getActivity()).a(R.string.tllimit_no_codecmem).a().show();
                        return;
                    }
                    boolean z2 = false;
                    if (transcodeProfile != null && transcodeProfile.equals(preferredTranscodingProfile)) {
                        File a5 = com.nexstreaming.kinemaster.g.a.a(i(), file, mediaSupportType);
                        boolean exists2 = a5.exists();
                        switch (mediaSupportType) {
                            case NeedTranscodeFPS:
                                if (exists2) {
                                    string6 = getResources().getString(R.string.mediabrowser_dialog_exist_coverted_file_by_fps);
                                    string7 = getResources().getString(R.string.mediabrowser_dialog_button_use_fps);
                                    string8 = getResources().getString(R.string.button_cancel);
                                } else {
                                    string6 = getResources().getString(R.string.mediabrowser_dialog_transcoder_by_fps);
                                    string7 = getResources().getString(R.string.mediabrowser_dialog_button_convert_fps);
                                    string8 = getResources().getString(R.string.tllimit_heavy_no_reencode);
                                }
                                string3 = string6;
                                string4 = string7;
                                string5 = string8;
                                z2 = true;
                                break;
                            case NeedTranscodeRes:
                                NexExportProfile transcodeProfile2 = NexEditorDeviceProfile.getDeviceProfile().getTranscodeProfile(EditorGlobal.a().i());
                                if (exists2) {
                                    string3 = getResources().getString(R.string.mediabrowser_dialog_exist_coverted_file_by_resolution, Integer.valueOf(H.getOriginalWidth()), Integer.valueOf(H.getOriginalHeight()), Integer.valueOf(transcodeProfile2.width()), Integer.valueOf(transcodeProfile2.displayHeight()), Integer.valueOf(transcodeProfile2.displayHeight()));
                                    string4 = getResources().getString(R.string.mediabrowser_dialog_button_use_resolution, Integer.valueOf(transcodeProfile2.displayHeight()));
                                    string5 = getResources().getString(R.string.button_cancel);
                                    break;
                                } else {
                                    string3 = getResources().getString(R.string.mediabrowser_dialog_transcoder_by_resolution, Integer.valueOf(H.getOriginalWidth()), Integer.valueOf(H.getOriginalHeight()), Integer.valueOf(transcodeProfile2.width()), Integer.valueOf(transcodeProfile2.displayHeight()), Integer.valueOf(transcodeProfile2.displayHeight()));
                                    string4 = getResources().getString(R.string.mediabrowser_dialog_button_convert_resolution, Integer.valueOf(transcodeProfile2.displayHeight()));
                                    string5 = getResources().getString(R.string.tllimit_heavy_no_reencode);
                                    break;
                                }
                            default:
                                throw new IllegalStateException(String.valueOf(mediaSupportType));
                        }
                        boolean z3 = z2;
                        str = string3;
                        a2 = a5;
                        z = z3;
                        String str4 = string5;
                        str2 = null;
                        str3 = string4;
                        exists = exists2;
                        string = str4;
                    } else {
                        a2 = com.nexstreaming.kinemaster.g.a.a(i(), file, preferredTranscodingProfile);
                        exists = a2.exists();
                        String string9 = getResources().getString(R.string.tllimit_heavy_title);
                        if (preferredTranscodingProfile.displayHeight() == H.getOriginalHeight()) {
                            String string10 = getResources().getString(R.string.mediabrowser_dialog_exist_coverted_file_by_fps);
                            if (exists) {
                                string2 = getResources().getString(R.string.mediabrowser_dialog_button_use_fps);
                            } else {
                                string2 = getResources().getString(R.string.mediabrowser_dialog_button_convert_fps);
                            }
                            z = true;
                            str2 = string9;
                            str3 = string2;
                            str = string10;
                            string = getResources().getString(R.string.button_cancel);
                        } else {
                            String string11 = getResources().getString(R.string.tllimit_heavy_text, Integer.valueOf(preferredTranscodingProfile.displayHeight()));
                            String string12 = getResources().getString(R.string.tllimit_heavy_reencode, Integer.valueOf(preferredTranscodingProfile.displayHeight()));
                            str = string11;
                            string = getResources().getString(R.string.tllimit_heavy_no_reencode);
                            str2 = string9;
                            str3 = string12;
                            z = false;
                        }
                    }
                    com.nexstreaming.kinemaster.ui.a.a a6 = new a.C0074a(getActivity()).d(str2).a(str).a(str3, new bw(this, exists, a2, preferredTranscodingProfile, z)).b(string, new bv(this)).a(true).a();
                    this.e = new WeakReference<>(a6);
                    a6.show();
                    a6.setOnDismissListener(new bx(this));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.projectedit.ed, com.nexstreaming.kinemaster.ui.projectedit.kp
    public void f() {
        super.f();
        if (this.f) {
            this.f = false;
            h();
        }
        VideoEditor o = o();
        View w = w();
        MediaLayer H = H();
        if (o != null && o.f() != null && w != null) {
            this.f3795a.a((NexLayerItem) m());
            if (this.b == null) {
                this.b = new MarchingAnts(MarchingAnts.Feature.SIZE_HANDLE, MarchingAnts.Feature.ROTATE_HANDLE);
            }
            Rect rect = new Rect();
            H.getBounds(rect);
            this.b.a(rect);
            w.addOnLayoutChangeListener(new by(this));
            w.getViewTreeObserver().addOnGlobalLayoutListener(new bz(this));
            d(R.id.action_animation, !H.isSplitScreenEnabled());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(com.nexstreaming.kinemaster.g.i iVar) {
        return ((int) iVar.i()) < 0 ? getString(R.string.export_est) : EditorGlobal.b(getResources(), (int) iVar.i());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(NexExportProfile nexExportProfile, File file, boolean z) {
        File file2 = new File(((VideoLayer) m()).getMediaPath());
        boolean a2 = com.nexstreaming.kinemaster.g.b.a(file2);
        com.nexstreaming.kinemaster.g.i a3 = com.nexstreaming.kinemaster.g.b.a(getActivity(), file2, file, nexExportProfile);
        e.a aVar = new e.a(getActivity());
        aVar.d(R.string.file_prep_transcoding);
        if (z) {
            aVar.a(getString(R.string.mediabrowser_transcode_in_progress_fps, new Object[]{getString(R.string.export_est)}));
        } else {
            aVar.a(getString(R.string.mediabrowser_transcode_in_progress, new Object[]{Integer.valueOf(nexExportProfile.width()), Integer.valueOf(nexExportProfile.displayHeight()), getString(R.string.export_est)}));
        }
        aVar.a(false);
        aVar.a(R.string.button_cancel, new ca(this, a2, a3));
        com.nexstreaming.kinemaster.ui.a.e a4 = aVar.a();
        a4.setOnShowListener(new cb(this));
        a4.show();
        a3.onProgress(new cc(this, a4, a3, z, nexExportProfile));
        a3.onComplete(new bq(this, file, a4));
        a3.onFailure(new bt(this, a4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        VideoLayer videoLayer = (VideoLayer) m();
        if (str != null && !str.equals(videoLayer.getMediaPath())) {
            videoLayer.changeMediaPathAfterTranscode(str);
            o().f().a().recalculateResourceUsage();
            o().l();
            s();
            f();
            o().C();
        }
    }

    @Override // android.app.FragmentManager.OnBackStackChangedListener
    public void onBackStackChanged() {
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.ed
    protected boolean e() {
        return true;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.ep.a
    public void c(int i) {
    }
}
