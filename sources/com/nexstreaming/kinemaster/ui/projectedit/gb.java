package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.Intent;
import android.os.Build;
import android.preference.PreferenceManager;
import android.view.View;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.itemstore.KMAssetStore;
import com.nexstreaming.kinemaster.usage.KMUsage;
import com.nextreaming.nexeditorui.newproject.mediabrowser.MediaBrowserFragment;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OptionPanelDefaultFragment.java */
/* loaded from: classes.dex */
public class gb implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ez f3919a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gb(ez ezVar) {
        this.f3919a = ezVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        View view3;
        int i;
        int i2;
        View view4;
        View view5;
        View view6;
        View view7;
        view2 = this.f3919a.b;
        if (view2 != null) {
            if (this.f3919a.c()) {
                this.f3919a.j();
            }
            view3 = this.f3919a.b;
            if (view3.findViewById(R.id.layer_button_holder).isSelected()) {
                view7 = this.f3919a.b;
                view7.findViewById(R.id.layer_button_holder).setSelected(false);
            }
            this.f3919a.o().p();
            int id = view.getId();
            if (id == R.id.btn_camera) {
                view6 = this.f3919a.b;
                view6.findViewById(R.id.right_panel_camera_holder).setVisibility(0);
                this.f3919a.d = true;
                this.f3919a.J();
                return;
            }
            if (id == R.id.btn_camera_back) {
                this.f3919a.d = false;
                this.f3919a.J();
                return;
            }
            if (id == R.id.camera_button_holder) {
                if (!this.f3919a.C()) {
                    this.f3919a.H();
                    view5 = this.f3919a.b;
                    view5.findViewById(R.id.right_panel_camera_holder).setVisibility(8);
                    this.f3919a.d = false;
                    this.f3919a.f = false;
                    return;
                }
                return;
            }
            if (id == R.id.camcorder_button_holder) {
                if (!this.f3919a.C()) {
                    this.f3919a.I();
                    view4 = this.f3919a.b;
                    view4.findViewById(R.id.right_panel_camera_holder).setVisibility(8);
                    this.f3919a.d = false;
                    this.f3919a.f = false;
                    return;
                }
                return;
            }
            if (id == R.id.mediabrowser_button_holder) {
                KMUsage.EditScreen_AddButton.logEvent("button", "media_browser");
                MediaBrowserFragment a2 = MediaBrowserFragment.b().b(R.id.req_add_visual_clip).a();
                if (PreferenceManager.getDefaultSharedPreferences(this.f3919a.getActivity()).getBoolean("pref_mbrowser_full", false)) {
                    i2 = R.id.fullscreenFragmentHolder;
                } else {
                    i2 = R.id.aboveTimelineFragmentHolder;
                }
                this.f3919a.getFragmentManager().beginTransaction().setTransition(4097).replace(i2, a2).addToBackStack("mediaBrowser").commit();
                this.f3919a.getFragmentManager().executePendingTransactions();
                return;
            }
            if (id == R.id.voicerecord_button_holder) {
                KMUsage.EditScreen_AddButton.logEvent("button", "voice");
                if (Build.VERSION.SDK_INT < 23) {
                    this.f3919a.h();
                    return;
                } else if (this.f3919a.getActivity().checkSelfPermission("android.permission.RECORD_AUDIO") != 0) {
                    this.f3919a.g = System.nanoTime();
                    this.f3919a.requestPermissions(new String[]{"android.permission.RECORD_AUDIO"}, R.id.req_perm_voicerec);
                    return;
                } else {
                    this.f3919a.h();
                    return;
                }
            }
            if (id == R.id.audiobrowser_button_holder) {
                if (this.f3919a.o() != null && this.f3919a.o().f() != null) {
                    if (this.f3919a.o().f().a().getPrimaryItemCount() < 1) {
                        this.f3919a.a(this.f3919a.getResources().getString(R.string.add_video_before_audio), 1);
                        return;
                    }
                    KMUsage.EditScreen_AddButton.logEvent("button", "audio");
                    if (PreferenceManager.getDefaultSharedPreferences(this.f3919a.getActivity()).getBoolean("pref_abrowser_full", false)) {
                        i = R.id.fullscreenFragmentHolder;
                    } else {
                        i = R.id.aboveTimelineFragmentHolder;
                    }
                    this.f3919a.getFragmentManager().beginTransaction().setTransition(4097).replace(i, new com.nexstreaming.kinemaster.ui.audiobrowser.a()).addToBackStack("audioMediaBrowser").commit();
                    return;
                }
                return;
            }
            if (id == R.id.btn_complete) {
                ((ProjectEditActivity) this.f3919a.getActivity()).e();
                return;
            }
            if (id == R.id.btn_playpause) {
                ((ProjectEditActivity) this.f3919a.getActivity()).i(R.id.action_play_pause);
                return;
            }
            if (id == R.id.btn_settings) {
                this.f3919a.e();
            } else if (id == R.id.btn_itemstore && com.nextreaming.nexeditorui.av.a().c() != null) {
                this.f3919a.startActivity(new Intent(this.f3919a.getActivity(), (Class<?>) KMAssetStore.class));
            }
        }
    }
}
