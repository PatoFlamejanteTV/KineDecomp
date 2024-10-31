package com.nexstreaming.kinemaster.ui.audiobrowser;

import android.R;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.nexstreaming.app.general.iab.IABManager;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.ui.settings.C2202xa;
import com.nexstreaming.kinemaster.ui.settings.tb;
import com.nexstreaming.kinemaster.ui.widget.Toolbar;
import com.nextreaming.nexeditorui.I;
import com.nextreaming.nexeditorui.KineMasterApplication;
import com.nextreaming.nexeditorui.NexIndexableListView;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import kotlin.TypeCastException;

/* compiled from: AudioBrowserFragment.kt */
/* loaded from: classes.dex */
public final class a extends Fragment implements FragmentManager.OnBackStackChangedListener {
    private HashMap A;

    /* renamed from: c, reason: collision with root package name */
    private View f21407c;

    /* renamed from: d, reason: collision with root package name */
    private ListView f21408d;

    /* renamed from: e, reason: collision with root package name */
    private ListView f21409e;

    /* renamed from: f, reason: collision with root package name */
    private NexIndexableListView f21410f;

    /* renamed from: g, reason: collision with root package name */
    private View f21411g;

    /* renamed from: h, reason: collision with root package name */
    private View f21412h;
    private ProgressBar i;
    private AudioCategory j;
    private List<? extends s> k;
    private MediaPlayer m;
    private String n;
    private x o;
    private int p;
    private String q;
    private String r;
    private String s;
    private int t;
    private boolean u;
    private Toolbar v;

    /* renamed from: b, reason: collision with root package name */
    public static final C0113a f21406b = new C0113a(null);

    /* renamed from: a, reason: collision with root package name */
    private static final AudioCategory[] f21405a = AudioCategory.ALL_UI_CATEGORIES;
    private final EnumMap<AudioCategory, Long> l = new EnumMap<>(AudioCategory.class);
    private int w = 3;
    private final MediaPlayer.OnCompletionListener x = new d(this);
    private final View.OnClickListener y = new q(this);
    private final c z = new c(this);

    /* compiled from: AudioBrowserFragment.kt */
    /* renamed from: com.nexstreaming.kinemaster.ui.audiobrowser.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0113a {
        private C0113a() {
        }

        public /* synthetic */ C0113a(kotlin.jvm.internal.f fVar) {
            this();
        }

        public final a a(String str) {
            a aVar = new a();
            Bundle bundle = new Bundle();
            if (str != null) {
                bundle.putString("SELECTED_PROJECT", str);
            }
            aVar.setArguments(bundle);
            return aVar;
        }

        public final a a(int i, int i2, String str, String str2) {
            a aVar = new a();
            Bundle bundle = new Bundle();
            bundle.putInt("tag", i);
            bundle.putInt("paddingBottom", i2);
            if (str == null) {
                str = "";
            }
            bundle.putString("selectedMusicPath", str);
            bundle.putString("selectedMusicName", str2 != null ? str2 : "");
            bundle.putBoolean("selectionMode", true);
            aVar.setArguments(bundle);
            return aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void a(View view, int i) {
            view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom() + i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean C() {
        IABManager y;
        I i = (I) getActivity();
        if (i == null || (y = i.y()) == null) {
            return false;
        }
        return y.t();
    }

    private final void D() {
        AudioCategory audioCategory;
        t lister;
        if (this.f21408d != null) {
            int i = 0;
            AudioCategory[] audioCategoryArr = f21405a;
            kotlin.jvm.internal.h.a((Object) audioCategoryArr, "CATEGORIES");
            int length = audioCategoryArr.length;
            while (true) {
                if (i >= length) {
                    break;
                }
                if (f21405a[i] == this.j) {
                    ListView listView = this.f21408d;
                    if (listView == null) {
                        kotlin.jvm.internal.h.a();
                        throw null;
                    }
                    listView.setItemChecked(i, true);
                } else {
                    i++;
                }
            }
        }
        if (this.f21409e == null || this.f21410f == null || (audioCategory = this.j) == null || (lister = audioCategory.getLister()) == null) {
            return;
        }
        if (lister.a() && this.j != AudioCategory.MUSIC_ASSETS) {
            lister.a(KineMasterApplication.f24058f.c()).onResultAvailable(new k(this, lister));
        } else {
            E();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E() {
        AudioCategory audioCategory;
        if (this.f21410f == null) {
            return;
        }
        b(true);
        AudioCategory audioCategory2 = this.j;
        if (audioCategory2 != null) {
            t lister = audioCategory2.getLister();
            Long l = 0L;
            if (lister.a() && (audioCategory = this.j) != AudioCategory.MUSIC_ASSETS) {
                l = this.l.get(audioCategory);
                ListView listView = this.f21409e;
                if (listView != null) {
                    int i = 0;
                    if (l != null) {
                        List<? extends s> list = this.k;
                        if (list != null) {
                            int size = list.size();
                            while (true) {
                                if (i >= size) {
                                    break;
                                }
                                long b2 = list.get(i).b();
                                if (l != null && b2 == l.longValue()) {
                                    ListView listView2 = this.f21409e;
                                    if (listView2 == null) {
                                        kotlin.jvm.internal.h.a();
                                        throw null;
                                    }
                                    listView2.setItemChecked(i, true);
                                } else {
                                    i++;
                                }
                            }
                        }
                    } else if (listView != null) {
                        listView.setItemChecked(0, true);
                        List<? extends s> list2 = this.k;
                        if (list2 == null) {
                            kotlin.jvm.internal.h.a();
                            throw null;
                        }
                        l = Long.valueOf(list2.get(0).b());
                    } else {
                        kotlin.jvm.internal.h.a();
                        throw null;
                    }
                }
            }
            if (this.j == AudioCategory.MUSIC_ASSETS && (lister instanceof com.nexstreaming.kinemaster.ui.audiobrowser.a.g)) {
                ((com.nexstreaming.kinemaster.ui.audiobrowser.a.g) lister).c(requireContext()).onResultAvailable(new l(this, lister)).onComplete((Task.OnTaskEventListener) new m(this));
            } else {
                Context requireContext = requireContext();
                kotlin.jvm.internal.h.a((Object) requireContext, "requireContext()");
                if (l != null) {
                    lister.a(requireContext, l.longValue()).onResultAvailable(new n(this, lister)).onComplete((Task.OnTaskEventListener) new o(this));
                } else {
                    kotlin.jvm.internal.h.a();
                    throw null;
                }
            }
            x xVar = this.o;
            if (xVar != null) {
                xVar.notifyDataSetChanged();
                return;
            }
            return;
        }
        kotlin.jvm.internal.h.a();
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F() {
        FragmentTransaction beginTransaction;
        FragmentTransaction replace;
        FragmentTransaction addToBackStack;
        FragmentActivity activity = getActivity();
        if (!(activity instanceof I)) {
            activity = null;
        }
        I i = (I) activity;
        tb a2 = tb.a(i != null ? i.y() : null, 0, "assetBrowser", "Asset Browser");
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager == null || (beginTransaction = fragmentManager.beginTransaction()) == null || (replace = beginTransaction.replace(R.id.content, a2, tb.f23200a)) == null || (addToBackStack = replace.addToBackStack(tb.f23200a)) == null) {
            return;
        }
        addToBackStack.commitAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G() {
        MediaPlayer mediaPlayer = this.m;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.reset();
        }
        x xVar = this.o;
        if (xVar != null) {
            xVar.b(-1);
        }
        this.n = null;
    }

    public final void B() {
        if (getActivity() == null) {
            return;
        }
        D();
    }

    @Override // android.support.v4.app.FragmentManager.OnBackStackChangedListener
    public void onBackStackChanged() {
        Fragment fragment = null;
        if (getFragmentManager() != null) {
            FragmentManager fragmentManager = getFragmentManager();
            if (fragmentManager == null) {
                kotlin.jvm.internal.h.a();
                throw null;
            }
            fragment = fragmentManager.findFragmentById(com.nexstreaming.app.kinemasterfree.R.id.fullscreenFragmentHolder);
        }
        if (fragment != null && (fragment instanceof C2202xa)) {
            MediaPlayer mediaPlayer = this.m;
            if (mediaPlayer != null) {
                mediaPlayer.pause();
                x xVar = this.o;
                if (xVar != null) {
                    xVar.b(-1);
                }
            }
            MediaPlayer mediaPlayer2 = this.m;
            if (mediaPlayer2 != null) {
                mediaPlayer2.pause();
                x xVar2 = this.o;
                if (xVar2 != null) {
                    xVar2.b(-1);
                }
            }
        }
        B();
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.p = arguments.getInt("tag", 0);
            this.r = arguments.getString("SELECTED_PROJECT");
            this.q = arguments.getString("selectedMusicPath");
            this.s = arguments.getString("selectedMusicName");
            this.t = arguments.getInt("paddingBottom", 0);
            this.u = arguments.getBoolean("selectionMode", false);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Toolbar toolbar;
        kotlin.jvm.internal.h.b(layoutInflater, "inflater");
        this.f21407c = layoutInflater.inflate(com.nexstreaming.app.kinemasterfree.R.layout.n2_amediabrowser, viewGroup, false);
        View m = m(com.nexstreaming.app.kinemasterfree.R.id.pb_loading);
        if (m != null) {
            this.i = (ProgressBar) m;
            View m2 = m(com.nexstreaming.app.kinemasterfree.R.id.albumNames);
            if (m2 != null) {
                this.f21409e = (ListView) m2;
                View m3 = m(com.nexstreaming.app.kinemasterfree.R.id.songlistView);
                if (m3 != null) {
                    this.f21410f = (NexIndexableListView) m3;
                    NexIndexableListView nexIndexableListView = this.f21410f;
                    if (nexIndexableListView != null) {
                        nexIndexableListView.setFastScrollEnabled(true);
                    }
                    NexIndexableListView nexIndexableListView2 = this.f21410f;
                    if (nexIndexableListView2 != null) {
                        nexIndexableListView2.setOnItemClickListener(new e(this));
                    }
                    View m4 = m(com.nexstreaming.app.kinemasterfree.R.id.catNames);
                    if (m4 != null) {
                        this.f21408d = (ListView) m4;
                        ListView listView = this.f21408d;
                        if (listView != null) {
                            AudioCategory[] audioCategoryArr = f21405a;
                            kotlin.jvm.internal.h.a((Object) audioCategoryArr, "CATEGORIES");
                            listView.setAdapter((ListAdapter) new v(audioCategoryArr));
                        }
                        this.f21411g = m(com.nexstreaming.app.kinemasterfree.R.id.noMedia);
                        View view = this.f21411g;
                        if (view != null) {
                            view.setOnClickListener(f.f21440a);
                        }
                        this.f21412h = m(com.nexstreaming.app.kinemasterfree.R.id.asset_get_more);
                        View view2 = this.f21412h;
                        if (view2 != null) {
                            view2.setOnClickListener(new g(this));
                        }
                        m(com.nexstreaming.app.kinemasterfree.R.id.asset_get_more_holder).setOnClickListener(new h(this));
                        ListView listView2 = this.f21408d;
                        if (listView2 != null) {
                            listView2.setOnItemClickListener(new i(this));
                        }
                        ListView listView3 = this.f21409e;
                        if (listView3 != null) {
                            listView3.setOnItemClickListener(new j(this));
                        }
                        a(AudioCategory.SONGS);
                        View view3 = this.f21407c;
                        this.v = view3 != null ? (Toolbar) view3.findViewById(com.nexstreaming.app.kinemasterfree.R.id.toolbar_amediabrowser) : null;
                        Toolbar toolbar2 = this.v;
                        if (toolbar2 != null) {
                            toolbar2.setLogo(com.nexstreaming.app.kinemasterfree.R.drawable.default_r_icon_audio_browse);
                        }
                        Toolbar toolbar3 = this.v;
                        if (toolbar3 != null) {
                            toolbar3.setClickListener(this.y);
                        }
                        if (this.u) {
                            Toolbar toolbar4 = this.v;
                            if (toolbar4 != null) {
                                toolbar4.setTitleMode(Toolbar.TitleMode.Title);
                                toolbar4.setSubTitleMode(Toolbar.SubTitleMode.SelectItem);
                                toolbar4.setExitButtonMode(Toolbar.ExitButtonMode.None);
                                toolbar4.setTitle(getString(com.nexstreaming.app.kinemasterfree.R.string.n2_bgm_label));
                                toolbar4.setRightButtonVisiblity(false);
                            }
                        } else {
                            Toolbar toolbar5 = this.v;
                            if (toolbar5 != null) {
                                toolbar5.setTitle(getString(com.nexstreaming.app.kinemasterfree.R.string.edit_project_toolbar_title_audio_browser));
                                toolbar5.setExitButtonMode(Toolbar.ExitButtonMode.Done);
                                toolbar5.setRightButtonVisiblity(true);
                            }
                        }
                        int i = this.t;
                        if (i != 0) {
                            NexIndexableListView nexIndexableListView3 = this.f21410f;
                            if (nexIndexableListView3 != null) {
                                f21406b.a(nexIndexableListView3, i);
                            }
                            ListView listView4 = this.f21409e;
                            if (listView4 != null) {
                                f21406b.a(listView4, this.t);
                            }
                            ListView listView5 = this.f21408d;
                            if (listView5 != null) {
                                f21406b.a(listView5, this.t);
                            }
                        }
                        String str = this.s;
                        if (str != null && (toolbar = this.v) != null) {
                            toolbar.a(str, 1);
                        }
                        FragmentManager fragmentManager = getFragmentManager();
                        if (fragmentManager != null) {
                            fragmentManager.addOnBackStackChangedListener(this);
                        }
                        return this.f21407c;
                    }
                    throw new TypeCastException("null cannot be cast to non-null type android.widget.ListView");
                }
                throw new TypeCastException("null cannot be cast to non-null type com.nextreaming.nexeditorui.NexIndexableListView");
            }
            throw new TypeCastException("null cannot be cast to non-null type android.widget.ListView");
        }
        throw new TypeCastException("null cannot be cast to non-null type android.widget.ProgressBar");
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        this.f21407c = null;
        this.f21408d = null;
        this.f21409e = null;
        this.f21410f = null;
        super.onDestroyView();
        z();
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        MediaPlayer mediaPlayer = this.m;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.reset();
            mediaPlayer.release();
            this.m = null;
        }
        G();
        super.onPause();
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        this.m = new MediaPlayer();
        MediaPlayer mediaPlayer = this.m;
        if (mediaPlayer != null) {
            mediaPlayer.setOnCompletionListener(this.x);
        }
        x xVar = this.o;
        if (xVar != null) {
            xVar.a(C());
        }
        super.onResume();
    }

    public void z() {
        HashMap hashMap = this.A;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    private final View m(int i) {
        View view = this.f21407c;
        if (view == null) {
            kotlin.jvm.internal.h.a();
            throw null;
        }
        View findViewById = view.findViewById(i);
        kotlin.jvm.internal.h.a((Object) findViewById, "contentView!!.findViewById(id)");
        return findViewById;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(boolean z) {
        ProgressBar progressBar = this.i;
        if (progressBar != null) {
            progressBar.setVisibility(z ? 0 : 4);
        }
    }

    public final void a(AudioCategory audioCategory) {
        kotlin.jvm.internal.h.b(audioCategory, "category");
        if (this.j == audioCategory) {
            return;
        }
        G();
        this.j = audioCategory;
        D();
    }

    public final void a(long j) {
        G();
        this.l.put((EnumMap<AudioCategory, Long>) this.j, (AudioCategory) Long.valueOf(j));
        E();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(t tVar, List<? extends u> list) {
        View findViewById;
        if (list.isEmpty()) {
            NexIndexableListView nexIndexableListView = this.f21410f;
            TextView textView = null;
            if (nexIndexableListView != null) {
                nexIndexableListView.setVisibility(4);
                View view = this.f21407c;
                if (view != null) {
                    if (view != null) {
                        View findViewById2 = view.findViewById(com.nexstreaming.app.kinemasterfree.R.id.asset_get_more_holder);
                        kotlin.jvm.internal.h.a((Object) findViewById2, "contentView!!.findViewBy…id.asset_get_more_holder)");
                        findViewById2.setVisibility(0);
                        View view2 = this.f21407c;
                        if (view2 == null) {
                            kotlin.jvm.internal.h.a();
                            throw null;
                        }
                        textView = (TextView) view2.findViewById(com.nexstreaming.app.kinemasterfree.R.id.getMoreTv);
                    } else {
                        kotlin.jvm.internal.h.a();
                        throw null;
                    }
                }
                AudioCategory audioCategory = this.j;
                if (audioCategory != AudioCategory.MUSIC_ASSETS && audioCategory != AudioCategory.SFX_ASSETS) {
                    View view3 = this.f21411g;
                    if (view3 != null) {
                        view3.setVisibility(0);
                    }
                    View view4 = this.f21412h;
                    if (view4 != null) {
                        view4.setVisibility(4);
                        return;
                    }
                    return;
                }
                View view5 = this.f21412h;
                if (view5 != null) {
                    view5.setVisibility(0);
                }
                View view6 = this.f21411g;
                if (view6 != null) {
                    view6.setVisibility(4);
                }
                if (textView != null && this.j == AudioCategory.MUSIC_ASSETS) {
                    textView.setText(getResources().getString(com.nexstreaming.app.kinemasterfree.R.string.asset_get_music));
                    return;
                } else {
                    if (textView == null || this.j != AudioCategory.SFX_ASSETS) {
                        return;
                    }
                    textView.setText(getResources().getString(com.nexstreaming.app.kinemasterfree.R.string.asset_get_sound_effects));
                    return;
                }
            }
            kotlin.jvm.internal.h.a();
            throw null;
        }
        NexIndexableListView nexIndexableListView2 = this.f21410f;
        if (nexIndexableListView2 != null) {
            nexIndexableListView2.setVisibility(0);
        }
        View view7 = this.f21412h;
        if (view7 != null) {
            view7.setVisibility(4);
        }
        View view8 = this.f21411g;
        if (view8 != null) {
            view8.setVisibility(4);
        }
        if (tVar.a() && this.j != AudioCategory.MUSIC_ASSETS) {
            a(this.f21408d, this.f21409e, this.f21410f);
            a(this.f21409e, this.f21410f, this.f21408d);
            a(this.f21410f, this.f21408d, this.f21409e);
        } else {
            ListView listView = this.f21408d;
            NexIndexableListView nexIndexableListView3 = this.f21410f;
            a(listView, nexIndexableListView3, nexIndexableListView3);
            NexIndexableListView nexIndexableListView4 = this.f21410f;
            ListView listView2 = this.f21408d;
            a(nexIndexableListView4, listView2, listView2);
        }
        View view9 = this.f21407c;
        if (view9 != null && (findViewById = view9.findViewById(com.nexstreaming.app.kinemasterfree.R.id.asset_get_more_holder)) != null) {
            findViewById.setVisibility(4);
        }
        x xVar = this.o;
        if (xVar != null) {
            xVar.a(list);
            return;
        }
        this.o = new x(list, this.z, C());
        NexIndexableListView nexIndexableListView5 = this.f21410f;
        if (nexIndexableListView5 != null) {
            nexIndexableListView5.setAdapter((ListAdapter) this.o);
        }
    }

    public final void a(View view, View view2, View view3) {
        if (view != null) {
            view.setOnKeyListener(new p(view3, view2));
        } else {
            kotlin.jvm.internal.h.a();
            throw null;
        }
    }
}
