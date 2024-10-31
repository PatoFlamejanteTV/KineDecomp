package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.Context;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.ActivityChooserView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.C1730a;
import com.nexstreaming.kinemaster.editorwrapper.C1780za;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.ui.projectedit.TimelineView;
import com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f;
import com.nextreaming.nexeditorui.I;
import com.nextreaming.nexeditorui.NexTimeline;
import com.nextreaming.nexeditorui.NexTimelineItem;
import java.io.File;
import java.util.HashMap;
import kotlin.TypeCastException;

/* compiled from: VoiceRecorderFragment.kt */
/* loaded from: classes2.dex */
public final class zh extends Bg implements VideoEditor.g, I.a, TimelineView.f {
    private HashMap A;
    private ClipDrawable n;
    private Button o;
    private Oh p;
    private Oh q;
    private int r = -1;
    private File s;
    private int t;
    private boolean u;
    private boolean v;
    private boolean w;
    private boolean x;
    private C1730a y;
    private int z;
    public static final a m = new a(null);
    private static final String l = zh.class.getSimpleName();

    /* compiled from: VoiceRecorderFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    public static final /* synthetic */ Button h(zh zhVar) {
        return zhVar.o;
    }

    public static final /* synthetic */ int k(zh zhVar) {
        return zhVar.r;
    }

    public static final /* synthetic */ boolean l(zh zhVar) {
        return zhVar.x;
    }

    public static final /* synthetic */ boolean m(zh zhVar) {
        return zhVar.v;
    }

    public final boolean va() {
        VideoEditor da = da();
        if (da != null) {
            C1780za s = da.s();
            kotlin.jvm.internal.h.a((Object) s, "getVideoEditor()!!.project");
            NexTimeline a2 = s.a();
            kotlin.jvm.internal.h.a((Object) a2, "getVideoEditor()!!.project.timeline");
            this.t = a2.getTotalTime();
            int i = this.t - this.r;
            File c2 = c.d.b.m.l.c(requireContext());
            c2.mkdirs();
            kotlin.jvm.internal.h.a((Object) c2, "voiceRecordingDirectory");
            long freeSpace = c2.getFreeSpace();
            long j = ((i * 44100) / io.fabric.sdk.android.a.b.c.MAX_BYTE_SIZE_PER_FILE) + 3145728;
            long min = (int) Math.min(i, ((freeSpace - 3145728) * io.fabric.sdk.android.a.b.c.MAX_BYTE_SIZE_PER_FILE) / 44100);
            if (min < 1000 && freeSpace < j) {
                String string = getResources().getString(R.string.fail_enospc);
                kotlin.jvm.internal.h.a((Object) string, "resources.getString(R.string.fail_enospc)");
                a(string, 1);
                return false;
            }
            VideoEditor da2 = da();
            if (da2 == null) {
                kotlin.jvm.internal.h.a();
                throw null;
            }
            C1780za s2 = da2.s();
            kotlin.jvm.internal.h.a((Object) s2, "getVideoEditor()!!.project");
            NexTimeline a3 = s2.a();
            kotlin.jvm.internal.h.a((Object) a3, "getVideoEditor()!!.project.timeline");
            if (a3.getPrimaryItemCount() < 1) {
                String string2 = getResources().getString(R.string.add_video_before_audio);
                kotlin.jvm.internal.h.a((Object) string2, "resources.getString(R.st…g.add_video_before_audio)");
                a(string2, 1);
                return false;
            }
            VideoEditor da3 = da();
            if (da3 == null) {
                kotlin.jvm.internal.h.a();
                throw null;
            }
            C1780za s3 = da3.s();
            kotlin.jvm.internal.h.a((Object) s3, "getVideoEditor()!!.project");
            if (!s3.a().checkResources(requireContext())) {
                String string3 = getResources().getString(R.string.rec_audio_missing_rsrc);
                kotlin.jvm.internal.h.a((Object) string3, "resources.getString(R.st…g.rec_audio_missing_rsrc)");
                a(string3, 1);
                return false;
            }
            int i2 = this.t;
            int i3 = this.r;
            if (i2 - i3 < 100) {
                Log.d(l, "projectTotalTime = " + this.t + ", voiceRecStartTime = " + this.r);
                String string4 = getResources().getString(R.string.rec_audio_no_space);
                kotlin.jvm.internal.h.a((Object) string4, "resources.getString(R.string.rec_audio_no_space)");
                a(string4, 1);
                this.u = true;
                return false;
            }
            this.z = i3 + ((int) min);
            return true;
        }
        kotlin.jvm.internal.h.a();
        throw null;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg
    public void oa() {
        a(R.id.action_undo, 0, R.id.action_redo, 0);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg, com.nextreaming.nexeditorui.I.a
    public boolean onBackPressed() {
        Oh oh = this.p;
        if (oh == null) {
            return false;
        }
        if (oh == null) {
            kotlin.jvm.internal.h.a();
            throw null;
        }
        if (!oh.b()) {
            return false;
        }
        Oh oh2 = this.p;
        if (oh2 != null) {
            oh2.a(true);
            this.p = null;
            F();
            return false;
        }
        kotlin.jvm.internal.h.a();
        throw null;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.h.b(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.voice_recorder_fragment, viewGroup, false);
        kotlin.jvm.internal.h.a((Object) inflate, "view");
        a(inflate);
        NexTimelineItem Y = Y();
        if (Y != null) {
            n(R.string.opt_rerecord);
            e(false);
            f(true);
            this.r = Y.getAbsStartTime();
        } else {
            m(R.drawable.default_r_icon_voice_record);
            n(R.string.voicerec_desc_title_ready);
            e(true);
        }
        Context requireContext = requireContext();
        kotlin.jvm.internal.h.a((Object) requireContext, "requireContext()");
        this.y = new C1730a(requireContext.getApplicationContext());
        this.q = new Oh(requireContext(), true);
        this.p = new Oh(requireContext(), false);
        Oh oh = this.p;
        if (oh != null) {
            oh.a(da());
            Oh oh2 = this.p;
            if (oh2 != null) {
                oh2.a(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                Oh oh3 = this.p;
                if (oh3 != null) {
                    oh3.c();
                    Oh oh4 = this.q;
                    if (oh4 != null) {
                        oh4.a(new Ah(this));
                        Oh oh5 = this.p;
                        if (oh5 != null) {
                            oh5.a(new Ih(this));
                            ImageView imageView = (ImageView) inflate.findViewById(R.id.voicerec_meter_view);
                            kotlin.jvm.internal.h.a((Object) imageView, "voiceRecMeterView");
                            Drawable drawable = imageView.getDrawable();
                            if (drawable != null) {
                                this.n = (ClipDrawable) drawable;
                                this.o = (Button) inflate.findViewById(R.id.rec_start_stop_btn);
                                Button button = this.o;
                                if (button != null) {
                                    button.setEnabled(true);
                                    Button button2 = this.o;
                                    if (button2 != null) {
                                        button2.setText(getResources().getText(R.string.voicerec_btn_start));
                                        Button button3 = this.o;
                                        if (button3 != null) {
                                            button3.setOnClickListener(new Kh(this));
                                            Oh oh6 = this.q;
                                            if (oh6 != null) {
                                                oh6.d();
                                                return inflate;
                                            }
                                            kotlin.jvm.internal.h.a();
                                            throw null;
                                        }
                                        kotlin.jvm.internal.h.a();
                                        throw null;
                                    }
                                    kotlin.jvm.internal.h.a();
                                    throw null;
                                }
                                kotlin.jvm.internal.h.a();
                                throw null;
                            }
                            throw new TypeCastException("null cannot be cast to non-null type android.graphics.drawable.ClipDrawable");
                        }
                        kotlin.jvm.internal.h.a();
                        throw null;
                    }
                    kotlin.jvm.internal.h.a();
                    throw null;
                }
                kotlin.jvm.internal.h.a();
                throw null;
            }
            kotlin.jvm.internal.h.a();
            throw null;
        }
        kotlin.jvm.internal.h.a();
        throw null;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg, android.support.v4.app.Fragment
    public void onDestroy() {
        Oh oh = this.p;
        if (oh != null) {
            if (oh == null) {
                kotlin.jvm.internal.h.a();
                throw null;
            }
            oh.a(true);
        }
        Oh oh2 = this.q;
        if (oh2 != null) {
            if (oh2 == null) {
                kotlin.jvm.internal.h.a();
                throw null;
            }
            oh2.a(true);
        }
        this.p = null;
        this.q = null;
        F();
        InterfaceC2025f ba = ba();
        if (ba != null) {
            ba.setOnTimelineScrollListener(null);
        }
        super.onDestroy();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg, android.support.v4.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        z();
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        Oh oh = this.p;
        if (oh != null) {
            if (oh == null) {
                kotlin.jvm.internal.h.a();
                throw null;
            }
            if (oh.b()) {
                this.v = true;
                Button button = this.o;
                if (button == null) {
                    kotlin.jvm.internal.h.a();
                    throw null;
                }
                button.callOnClick();
            }
        }
        super.onPause();
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        if (this.v) {
            this.v = false;
            FragmentActivity requireActivity = requireActivity();
            if (!(requireActivity instanceof ProjectEditActivity)) {
                requireActivity = null;
            }
            ProjectEditActivity projectEditActivity = (ProjectEditActivity) requireActivity;
            if (projectEditActivity != null) {
                projectEditActivity.e(false);
            }
        }
        super.onStart();
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.h.b(view, "view");
        super.onViewCreated(view, bundle);
        VideoEditor da = da();
        if (da != null) {
            int v = da.v();
            VideoEditor da2 = da();
            if (da2 != null) {
                C1780za s = da2.s();
                kotlin.jvm.internal.h.a((Object) s, "getVideoEditor()!!.project");
                NexTimeline a2 = s.a();
                kotlin.jvm.internal.h.a((Object) a2, "getVideoEditor()!!.project.timeline");
                b(v, a2.getTotalTime());
                InterfaceC2025f ba = ba();
                if (ba != null) {
                    ba.setOnTimelineScrollListener(this);
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

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg
    public void pa() {
        a(R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_play_pause, R.drawable.action_play_pause, R.id.action_expand_preview, R.drawable.action_inset_preview);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg
    public void z() {
        HashMap hashMap = this.A;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public static final /* synthetic */ void c(zh zhVar, boolean z) {
        zhVar.w = z;
    }

    public static final /* synthetic */ void a(zh zhVar, File file) {
        zhVar.s = file;
    }

    private final void d(int i, int i2) {
        Button button = this.o;
        if (button != null) {
            button.setEnabled(i2 - i > 1000);
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.TimelineView.f
    public void b(int i, int i2) {
        d(i, i2);
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.VideoEditor.g
    public void a(int i, int i2) {
        int i3 = this.z;
        if (i3 < this.t) {
            b(this.r, i2, i3);
        } else {
            c(this.r, i2);
        }
        if (i2 >= this.z) {
            Oh oh = this.p;
            if (oh != null) {
                oh.a(false);
            } else {
                kotlin.jvm.internal.h.a();
                throw null;
            }
        }
    }
}
