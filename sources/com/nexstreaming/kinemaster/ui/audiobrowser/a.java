package com.nexstreaming.kinemaster.ui.audiobrowser;

import android.app.Fragment;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.audiobrowser.q;
import com.nexstreaming.kinemaster.ui.widget.Toolbar;
import com.nextreaming.nexeditorui.NexIndexableListView;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

/* compiled from: AudioBrowserFragment.java */
/* loaded from: classes.dex */
public class a extends Fragment {
    private static final AudioCategory[] g = AudioCategory.ALL_UI_CATEGORIES;

    /* renamed from: a, reason: collision with root package name */
    private View f3656a;
    private ListView b;
    private ListView c;
    private View d;
    private NexIndexableListView e;
    private AudioCategory f;
    private List<l> h;
    private MediaPlayer j;
    private String k;
    private q l;
    private int m;
    private String n;
    private String o;
    private int p;
    private boolean q;
    private Toolbar r;
    private Map<AudioCategory, Long> i = new EnumMap(AudioCategory.class);
    private MediaPlayer.OnCompletionListener s = new h(this);
    private View.OnClickListener t = new i(this);
    private q.a u = new j(this);

    public static a a(int i, int i2, String str, String str2) {
        a aVar = new a();
        Bundle bundle = new Bundle();
        bundle.putInt("tag", i);
        bundle.putInt("paddingBottom", i2);
        bundle.putString("selectedMusicPath", str);
        bundle.putString("selectedMusicName", str2);
        bundle.putBoolean("selectionMode", true);
        aVar.setArguments(bundle);
        return aVar;
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.m = arguments.getInt("tag", 0);
            this.n = arguments.getString("selectedMusicPath");
            this.o = arguments.getString("selectedMusicName");
            this.p = arguments.getInt("paddingBottom", 0);
            this.q = arguments.getBoolean("selectionMode", false);
        }
    }

    private static void a(View view, int i) {
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom() + i);
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f3656a = layoutInflater.inflate(R.layout.n2_amediabrowser, viewGroup, false);
        this.c = (ListView) a(R.id.albumNames);
        this.e = (NexIndexableListView) a(R.id.songlistView);
        this.e.setFastScrollEnabled(true);
        this.e.setOnItemClickListener(new b(this));
        this.b = (ListView) a(R.id.catNames);
        this.b.setAdapter((ListAdapter) new o(g));
        this.d = a(R.id.noMedia);
        this.d.setOnClickListener(new c(this));
        this.b.setOnItemClickListener(new d(this));
        this.c.setOnItemClickListener(new e(this));
        a(AudioCategory.SONGS);
        this.r = (Toolbar) this.f3656a.findViewById(R.id.toolbar_amediabrowser);
        this.r.setLogo(R.drawable.default_r_icon_audio_browse);
        this.r.setClickListener(this.t);
        if (this.q) {
            this.r.setTitleMode(Toolbar.TitleMode.Title);
            this.r.setSubTitleMode(Toolbar.SubTitleMode.SelectItem);
            this.r.setExitButtonMode(Toolbar.ExitButtonMode.None);
            this.r.setTitle(getString(R.string.n2_bgm_label));
        } else {
            this.r.setTitle(getString(R.string.edit_project_toolbar_title_audio_browser));
            this.r.setExitButtonMode(Toolbar.ExitButtonMode.Done);
        }
        if (this.p != 0) {
            a(this.e, this.p);
            a(this.c, this.p);
            a(this.b, this.p);
        }
        if (this.o != null) {
            this.r.a(this.o, 1);
        }
        return this.f3656a;
    }

    public void a(AudioCategory audioCategory) {
        if (this.f != audioCategory) {
            d();
            this.f = audioCategory;
            b();
        }
    }

    public void a(long j) {
        Long l = this.i.get(this.f);
        if (l == null || l.longValue() != j) {
            d();
            this.i.put(this.f, Long.valueOf(j));
            c();
        }
    }

    private void b() {
        if (this.b != null) {
            int i = 0;
            while (true) {
                if (i >= g.length) {
                    break;
                }
                if (g[i] != this.f) {
                    i++;
                } else {
                    this.b.setItemChecked(i, true);
                    break;
                }
            }
        }
        if (this.c != null && this.e != null) {
            m lister = this.f.getLister();
            if (lister.a()) {
                lister.a(getActivity()).onResultAvailable(new f(this, lister));
            } else {
                c();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        long j = 0;
        if (this.e != null) {
            m lister = this.f.getLister();
            if (lister.a()) {
                Long l = this.i.get(this.f);
                if (l == null) {
                    long b = this.h.size() > 0 ? this.h.get(0).b() : 0L;
                    this.i.put(this.f, Long.valueOf(b));
                    j = b;
                } else {
                    j = l.longValue();
                }
                if (this.c != null) {
                    int size = this.h.size();
                    int i = 0;
                    while (true) {
                        if (i >= size) {
                            break;
                        }
                        if (this.h.get(i).b() != j) {
                            i++;
                        } else {
                            this.c.setItemChecked(i, true);
                            break;
                        }
                    }
                }
            }
            lister.a(getActivity(), j).onResultAvailable(new g(this, lister));
        }
    }

    private View a(int i) {
        return this.f3656a.findViewById(i);
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        this.f3656a = null;
        this.b = null;
        this.c = null;
        this.e = null;
        super.onDestroyView();
    }

    @Override // android.app.Fragment
    public void onPause() {
        if (this.j != null) {
            this.j.stop();
            this.j.reset();
            this.j.release();
            this.j = null;
        }
        d();
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.j != null) {
            this.j.stop();
            this.j.reset();
        }
        if (this.l != null) {
            this.l.a(-1);
        }
        this.k = null;
    }

    @Override // android.app.Fragment
    public void onResume() {
        this.j = new MediaPlayer();
        this.j.setOnCompletionListener(this.s);
        super.onResume();
    }
}
