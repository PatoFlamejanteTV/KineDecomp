package com.nexstreaming.kinemaster.ui.projectedit;

import android.os.Handler;
import android.preference.PreferenceManager;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.layer.HandwritingLayer;
import com.nexstreaming.kinemaster.ui.projectedit.LayerSubMenuPopup;
import com.nextreaming.nexeditorui.NexEditorDeviceProfile;
import com.nextreaming.nexeditorui.newproject.mediabrowser.MediaBrowserFragment;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OptionPanelDefaultFragment.java */
/* loaded from: classes.dex */
public class ge implements LayerSubMenuPopup.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ez f3922a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ge(ez ezVar) {
        this.f3922a = ezVar;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.LayerSubMenuPopup.a
    public void a(LayerSubMenuPopup layerSubMenuPopup, LayerSubMenuPopup.LayerType layerType) {
        int i;
        int i2;
        MediaBrowserFragment.MediaViewerMode mediaViewerMode;
        int i3;
        switch (layerType) {
            case EFFECT:
                kp.b(this.f3922a.getFragmentManager().beginTransaction()).setTransition(4097).replace(R.id.optionPanelHolder, new r()).addToBackStack("effectLayer").commit();
                layerSubMenuPopup.dismiss();
                return;
            case MEDIA:
                if (NexEditorDeviceProfile.getDeviceProfile().getSupportsVideoLayers(this.f3922a.o().A())) {
                    mediaViewerMode = MediaBrowserFragment.MediaViewerMode.ALL;
                } else {
                    mediaViewerMode = MediaBrowserFragment.MediaViewerMode.IMAGES;
                }
                MediaBrowserFragment a2 = MediaBrowserFragment.b().a(mediaViewerMode).b(R.id.req_add_image_layer).a(true).a(R.string.default_menu_layer, R.string.layer_menu_media).a();
                if (PreferenceManager.getDefaultSharedPreferences(this.f3922a.getActivity()).getBoolean("pref_mbrowser_full", false)) {
                    i3 = R.id.fullscreenFragmentHolder;
                } else {
                    i3 = R.id.aboveTimelineFragmentHolder;
                }
                this.f3922a.getFragmentManager().beginTransaction().setTransition(4097).replace(i3, a2).addToBackStack("mediaBrowser").commit();
                layerSubMenuPopup.dismiss();
                return;
            case VIDEO:
                MediaBrowserFragment a3 = MediaBrowserFragment.b().a(MediaBrowserFragment.MediaViewerMode.VIDEO).b(R.id.req_add_image_layer).a(true).a(R.string.default_menu_layer, R.string.layer_menu_video).a();
                if (PreferenceManager.getDefaultSharedPreferences(this.f3922a.getActivity()).getBoolean("pref_mbrowser_full", false)) {
                    i2 = R.id.fullscreenFragmentHolder;
                } else {
                    i2 = R.id.aboveTimelineFragmentHolder;
                }
                this.f3922a.getFragmentManager().beginTransaction().setTransition(4097).replace(i2, a3).addToBackStack("mediaBrowser").commit();
                layerSubMenuPopup.dismiss();
                return;
            case IMAGE:
                MediaBrowserFragment a4 = MediaBrowserFragment.b().a(MediaBrowserFragment.MediaViewerMode.IMAGES).b(R.id.req_add_image_layer).a(true).a(R.string.default_menu_layer, R.string.layer_menu_image).a();
                if (PreferenceManager.getDefaultSharedPreferences(this.f3922a.getActivity()).getBoolean("pref_mbrowser_full", false)) {
                    i = R.id.fullscreenFragmentHolder;
                } else {
                    i = R.id.aboveTimelineFragmentHolder;
                }
                this.f3922a.getFragmentManager().beginTransaction().setTransition(4097).replace(i, a4).addToBackStack("mediaBrowser").commit();
                layerSubMenuPopup.dismiss();
                return;
            case STICKERS:
                kp.b(this.f3922a.getFragmentManager().beginTransaction()).setTransition(4097).replace(R.id.optionPanelHolder, new kx()).addToBackStack("stickerLayer").commit();
                layerSubMenuPopup.dismiss();
                return;
            case TEXT:
                this.f3922a.o().p();
                this.f3922a.startActivityForResult(FullScreenInputActivity.a(this.f3922a.getActivity()).c(true).e(true).a(), FullScreenInputActivity.a());
                layerSubMenuPopup.dismiss();
                return;
            case HANDWRITING:
                int u = this.f3922a.o().u();
                HandwritingLayer handwritingLayer = new HandwritingLayer();
                int parseInt = Integer.parseInt(PreferenceManager.getDefaultSharedPreferences(this.f3922a.getActivity()).getString("add_layer_def_duration", "6000"));
                handwritingLayer.setRelativeStartTime(u);
                handwritingLayer.setRelativeEndTime(u + parseInt);
                this.f3922a.o().a((NexLayerItem) handwritingLayer);
                this.f3922a.o().n();
                this.f3922a.b(handwritingLayer);
                new Handler().post(new gf(this, handwritingLayer));
                this.f3922a.d(handwritingLayer);
                layerSubMenuPopup.dismiss();
                return;
            default:
                return;
        }
    }
}
