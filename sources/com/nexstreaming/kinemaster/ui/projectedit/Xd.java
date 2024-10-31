package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.nexstreaming.app.general.util.C1709m;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.C1780za;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.ui.a.e;
import com.nexstreaming.kinemaster.ui.mediabrowser.C1829g;
import com.nexstreaming.kinemaster.ui.store.controller.StoreActivity;
import com.nexstreaming.kinemaster.usage.AssetStoreEntry;
import com.nextreaming.nexeditorui.NexTimeline;
import java.io.File;
import kotlin.TypeCastException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OptionPanelDefaultFragment.kt */
/* loaded from: classes2.dex */
public final class Xd implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Bd f22169a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Xd(Bd bd) {
        this.f22169a = bd;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        View view2;
        boolean za;
        View view3;
        boolean z;
        String str;
        boolean z2;
        boolean z3;
        View view4;
        View view5;
        View view6;
        View view7;
        boolean z4;
        View view8;
        View view9;
        view2 = this.f22169a.o;
        if (view2 == null) {
            return;
        }
        za = this.f22169a.za();
        if (za) {
            this.f22169a.va();
        }
        view3 = this.f22169a.o;
        if (view3 != null) {
            View findViewById = view3.findViewById(R.id.layer_button_holder);
            kotlin.jvm.internal.h.a((Object) findViewById, "contentView!!.findViewBy…R.id.layer_button_holder)");
            if (findViewById.isSelected()) {
                view9 = this.f22169a.o;
                if (view9 == null) {
                    kotlin.jvm.internal.h.a();
                    throw null;
                }
                View findViewById2 = view9.findViewById(R.id.layer_button_holder);
                kotlin.jvm.internal.h.a((Object) findViewById2, "contentView!!.findViewBy…R.id.layer_button_holder)");
                findViewById2.setSelected(false);
            }
            VideoEditor da = this.f22169a.da();
            if (da != null) {
                da.M();
                kotlin.jvm.internal.h.a((Object) view, "v");
                int id = view.getId();
                if (id == R.id.btn_camera) {
                    view8 = this.f22169a.o;
                    if (view8 != null) {
                        View findViewById3 = view8.findViewById(R.id.right_panel_camera_holder);
                        kotlin.jvm.internal.h.a((Object) findViewById3, "contentView!!.findViewBy…ight_panel_camera_holder)");
                        findViewById3.setVisibility(0);
                        this.f22169a.p = true;
                        this.f22169a.Ea();
                    } else {
                        kotlin.jvm.internal.h.a();
                        throw null;
                    }
                } else if (id == R.id.btn_camera_back) {
                    this.f22169a.p = false;
                    this.f22169a.Ea();
                } else if (id == R.id.camera_button_holder) {
                    if (this.f22169a.E()) {
                        return;
                    }
                    Boolean ka = this.f22169a.ka();
                    if (ka == null) {
                        kotlin.jvm.internal.h.a();
                        throw null;
                    }
                    if (ka.booleanValue()) {
                        return;
                    }
                    if (C1709m.a(new File("/sdcard")) >= 10485760) {
                        view5 = this.f22169a.o;
                        if (view5 != null) {
                            View findViewById4 = view5.findViewById(R.id.right_panel_camera_holder);
                            kotlin.jvm.internal.h.a((Object) findViewById4, "contentView!!.findViewBy…ight_panel_camera_holder)");
                            findViewById4.setVisibility(8);
                            this.f22169a.p = false;
                            this.f22169a.r = false;
                            Bd bd = this.f22169a;
                            String[] strArr = com.nexstreaming.kinemaster.ui.e.b.f21564b;
                            kotlin.jvm.internal.h.a((Object) strArr, "PermissionHelper.CAMERA");
                            bd.a(strArr);
                        } else {
                            kotlin.jvm.internal.h.a();
                            throw null;
                        }
                    } else {
                        e.a aVar = new e.a(this.f22169a.getActivity());
                        aVar.a(this.f22169a.getString(R.string.fail_enospc));
                        aVar.c(R.string.button_ok, Vd.f22153a);
                        aVar.a().show();
                        return;
                    }
                } else if (id != R.id.camcorder_button_holder) {
                    int i = R.id.fullscreenFragmentHolder;
                    if (id == R.id.mediabrowser_button_holder) {
                        C1829g.a a2 = C1829g.f21680a.a();
                        a2.b(R.id.req_add_visual_clip);
                        a2.a(true);
                        C1829g a3 = a2.a();
                        ProjectEditActivity projectEditActivity = (ProjectEditActivity) this.f22169a.getActivity();
                        if (projectEditActivity != null) {
                            a3.a(projectEditActivity);
                            if (!PreferenceManager.getDefaultSharedPreferences(this.f22169a.getActivity()).getBoolean("pref_mbrowser_full", false)) {
                                i = R.id.aboveTimelineFragmentHolder;
                            }
                            z3 = this.f22169a.B;
                            if (z3) {
                                return;
                            }
                            this.f22169a.requireFragmentManager().beginTransaction().setTransition(4097).replace(i, a3).addToBackStack("mediaBrowser").commit();
                            this.f22169a.requireFragmentManager().executePendingTransactions();
                            this.f22169a.Ga();
                        } else {
                            kotlin.jvm.internal.h.a();
                            throw null;
                        }
                    } else if (id == R.id.voicerecord_button_holder) {
                        z2 = this.f22169a.B;
                        if (z2) {
                            return;
                        }
                        Bd bd2 = this.f22169a;
                        String[] strArr2 = com.nexstreaming.kinemaster.ui.e.b.f21566d;
                        kotlin.jvm.internal.h.a((Object) strArr2, "PermissionHelper.RECORD_AUDIO");
                        bd2.a(strArr2);
                    } else if (id == R.id.audiobrowser_button_holder) {
                        if (this.f22169a.da() == null) {
                            return;
                        }
                        VideoEditor da2 = this.f22169a.da();
                        if (da2 == null) {
                            kotlin.jvm.internal.h.a();
                            throw null;
                        }
                        if (da2.s() == null) {
                            return;
                        }
                        VideoEditor da3 = this.f22169a.da();
                        if (da3 == null) {
                            kotlin.jvm.internal.h.a();
                            throw null;
                        }
                        C1780za s = da3.s();
                        kotlin.jvm.internal.h.a((Object) s, "getVideoEditor()!!.project");
                        NexTimeline a4 = s.a();
                        kotlin.jvm.internal.h.a((Object) a4, "getVideoEditor()!!.project.timeline");
                        if (a4.getPrimaryItemCount() < 1) {
                            Bd bd3 = this.f22169a;
                            String string = bd3.getResources().getString(R.string.add_video_before_audio);
                            kotlin.jvm.internal.h.a((Object) string, "resources.getString(R.st…g.add_video_before_audio)");
                            bd3.a(string, 1);
                            return;
                        }
                        if (!PreferenceManager.getDefaultSharedPreferences(this.f22169a.getActivity()).getBoolean("pref_abrowser_full", false)) {
                            i = R.id.aboveTimelineFragmentHolder;
                        }
                        z = this.f22169a.B;
                        if (z) {
                            return;
                        }
                        VideoEditor da4 = this.f22169a.da();
                        if (da4 != null) {
                            if (da4.t() != null) {
                                VideoEditor da5 = this.f22169a.da();
                                if (da5 == null) {
                                    kotlin.jvm.internal.h.a();
                                    throw null;
                                }
                                File t = da5.t();
                                kotlin.jvm.internal.h.a((Object) t, "getVideoEditor()!!.projectFile");
                                str = t.getPath();
                            } else {
                                str = null;
                            }
                            this.f22169a.requireFragmentManager().beginTransaction().setTransition(4097).replace(i, com.nexstreaming.kinemaster.ui.audiobrowser.a.f21406b.a(str)).addToBackStack("audioMediaBrowser").commit();
                            this.f22169a.requireFragmentManager().executePendingTransactions();
                            this.f22169a.Ga();
                        } else {
                            kotlin.jvm.internal.h.a();
                            throw null;
                        }
                    } else if (id == R.id.btn_complete) {
                        FragmentActivity activity = this.f22169a.getActivity();
                        if (activity == null) {
                            throw new TypeCastException("null cannot be cast to non-null type com.nexstreaming.kinemaster.ui.projectedit.ProjectEditActivity");
                        }
                        ((ProjectEditActivity) activity).sa();
                    } else if (id == R.id.btn_playpause) {
                        FragmentActivity activity2 = this.f22169a.getActivity();
                        if (activity2 == null) {
                            throw new TypeCastException("null cannot be cast to non-null type com.nexstreaming.kinemaster.ui.projectedit.ProjectEditActivity");
                        }
                        ((ProjectEditActivity) activity2).g(R.id.action_play_pause);
                    } else if (id == R.id.btn_settings) {
                        this.f22169a.Aa();
                    } else if (id == R.id.btn_itemstore) {
                        Intent intent = new Intent(this.f22169a.getActivity(), (Class<?>) StoreActivity.class);
                        if (this.f22169a.da() != null) {
                            VideoEditor da6 = this.f22169a.da();
                            if (da6 == null) {
                                kotlin.jvm.internal.h.a();
                                throw null;
                            }
                            if (da6.t() != null) {
                                VideoEditor da7 = this.f22169a.da();
                                if (da7 != null) {
                                    File t2 = da7.t();
                                    kotlin.jvm.internal.h.a((Object) t2, "getVideoEditor()!!.projectFile");
                                    intent.putExtra("SELECTED_PROJECT", t2.getAbsolutePath());
                                    intent.putExtra("fromActivity", AssetStoreEntry.EDITING);
                                } else {
                                    kotlin.jvm.internal.h.a();
                                    throw null;
                                }
                            }
                        }
                        this.f22169a.startActivity(intent);
                    }
                } else {
                    if (this.f22169a.E()) {
                        return;
                    }
                    Boolean ka2 = this.f22169a.ka();
                    if (ka2 == null) {
                        kotlin.jvm.internal.h.a();
                        throw null;
                    }
                    if (ka2.booleanValue()) {
                        return;
                    }
                    if (C1709m.a(new File("/sdcard")) >= 104857600) {
                        view4 = this.f22169a.o;
                        if (view4 != null) {
                            View findViewById5 = view4.findViewById(R.id.right_panel_camera_holder);
                            kotlin.jvm.internal.h.a((Object) findViewById5, "contentView!!.findViewBy…ight_panel_camera_holder)");
                            findViewById5.setVisibility(8);
                            this.f22169a.p = false;
                            this.f22169a.r = false;
                            Bd bd4 = this.f22169a;
                            String[] strArr3 = com.nexstreaming.kinemaster.ui.e.b.f21565c;
                            kotlin.jvm.internal.h.a((Object) strArr3, "PermissionHelper.CAMCORDER");
                            bd4.a(strArr3);
                        } else {
                            kotlin.jvm.internal.h.a();
                            throw null;
                        }
                    } else {
                        e.a aVar2 = new e.a(this.f22169a.getActivity());
                        aVar2.a(this.f22169a.getString(R.string.fail_enospc));
                        aVar2.c(R.string.button_ok, Wd.f22165a);
                        aVar2.a().show();
                        return;
                    }
                }
                view6 = this.f22169a.o;
                if (view6 != null) {
                    view7 = this.f22169a.o;
                    if (view7 == null) {
                        kotlin.jvm.internal.h.a();
                        throw null;
                    }
                    View findViewById6 = view7.findViewById(R.id.default_right_panel_holder);
                    kotlin.jvm.internal.h.a((Object) findViewById6, "contentView!!.findViewBy…fault_right_panel_holder)");
                    z4 = this.f22169a.p;
                    findViewById6.setVisibility(z4 ? 8 : 0);
                    return;
                }
                return;
            }
            kotlin.jvm.internal.h.a();
            throw null;
        }
        kotlin.jvm.internal.h.a();
        throw null;
    }
}
