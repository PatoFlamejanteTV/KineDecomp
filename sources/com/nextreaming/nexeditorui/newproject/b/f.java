package com.nextreaming.nexeditorui.newproject.b;

import android.app.Activity;
import android.app.Fragment;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ProgressBar;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.kmpackage.EffectLibrary;
import com.nexstreaming.kinemaster.kmpackage.Theme;
import com.nexstreaming.kinemaster.kmpackage.aq;
import com.nexstreaming.kinemaster.ui.widget.Toolbar;
import com.nextreaming.nexeditorui.newproject.b.s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* compiled from: ThemeBrowserFragment.java */
/* loaded from: classes.dex */
public class f extends Fragment implements aq {

    /* renamed from: a, reason: collision with root package name */
    private EffectLibrary f4667a;
    private ArrayList<Theme> b;
    private ArrayList<b> c;
    private Theme[] d;
    private Theme e;
    private View f;
    private View g;
    private Toolbar h;
    private GridView i;
    private com.nextreaming.nexeditorui.newproject.b.a j;
    private s k;
    private a l;
    private boolean m = false;
    private BroadcastReceiver n = new g(this);
    private View.OnClickListener o = new l(this);
    private View.OnClickListener p = new m(this);
    private AdapterView.OnItemClickListener q = new n(this);
    private AdapterView.OnItemLongClickListener r = new o(this);
    private s.a s = new r(this);

    /* compiled from: ThemeBrowserFragment.java */
    /* loaded from: classes.dex */
    public interface a {
        void a(Theme theme);

        void b();
    }

    public static f a(String str, boolean z) {
        f fVar = new f();
        Bundle bundle = new Bundle();
        bundle.putString("SelectedTheme", str);
        bundle.putBoolean("applyAndCancelButtons", z);
        fVar.setArguments(bundle);
        return fVar;
    }

    @Override // android.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        if (bundle != null) {
            if (this.e != null) {
                bundle.putString("selected_item_theme_id", this.e.i());
            }
            bundle.putBoolean("UseApplyAndCancelButtons", this.m);
        }
        super.onSaveInstanceState(bundle);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.l = (a) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnInputTextFragmentListener");
        }
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f4667a = EffectLibrary.a(getActivity());
        this.c = new ArrayList<>();
        this.f4667a.a(this);
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString("SelectedTheme");
            if (string != null) {
                this.e = this.f4667a.e(string);
            }
            this.m = arguments.getBoolean("applyAndCancelButtons");
        }
        if (bundle != null) {
            String string2 = bundle.getString("selected_item_theme_id");
            if (string2 != null) {
                this.f4667a.b().onComplete(new h(this, string2));
            }
            this.m = bundle.getBoolean("UseApplyAndCancelButtons");
        }
        getActivity().registerReceiver(this.n, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f = layoutInflater.inflate(R.layout.fragment_themebrowser, viewGroup, false);
        this.h = (Toolbar) this.f.findViewById(R.id.toolbar_themebrowser);
        this.h.setClickListener(this.o);
        this.g = this.f.findViewById(R.id.linear_theme_browser_network_error);
        this.i = (GridView) this.f.findViewById(R.id.gridView_themebrowser);
        if (this.m) {
            this.h.setExitButtonMode(Toolbar.ExitButtonMode.Done);
        }
        return this.f;
    }

    @Override // android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.h.setTitle(getString(R.string.new_project_toolbar_title_theme_browser));
        this.h.setLogo(R.drawable.icon_theme_title_logo);
        this.i.setPadding(this.i.getPaddingLeft(), this.i.getPaddingTop(), this.i.getPaddingRight(), getResources().getDimensionPixelSize(R.dimen.new_project_bottombar_height) + this.i.getPaddingBottom());
        this.i.setPadding(this.i.getPaddingLeft(), getResources().getDimensionPixelSize(R.dimen.toolbar_height), this.i.getPaddingRight(), this.i.getPaddingBottom());
        this.i.setOnItemClickListener(this.q);
        this.i.setOnItemLongClickListener(this.r);
        a();
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        if (this.j != null) {
            this.j.a();
            this.j = null;
        }
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.l = null;
        super.onDestroyView();
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        getActivity().unregisterReceiver(this.n);
        super.onDestroy();
    }

    @Override // android.app.Fragment
    public void onDetach() {
        super.onDetach();
    }

    @Override // android.app.Fragment
    public void onPause() {
        if (this.j != null) {
            this.j.a();
        }
        super.onPause();
    }

    @Override // android.app.Fragment
    public void onStart() {
        if (this.j != null) {
            this.j.notifyDataSetInvalidated();
        }
        super.onStart();
    }

    private void a() {
        this.f4667a.b().onComplete(new i(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        this.b.clear();
        this.c.clear();
        for (Theme theme : this.d) {
            this.c.add(new b(theme));
        }
        Collections.sort(this.c, new k(this));
        int i = 0;
        while (true) {
            if (i >= this.c.size()) {
                break;
            }
            if (!this.c.get(i).a().i().equals("com.nexstreaming.kinemaster.basic")) {
                i++;
            } else {
                this.c.add(0, this.c.remove(i));
                break;
            }
        }
        Iterator<b> it = this.c.iterator();
        while (it.hasNext()) {
            this.b.add(it.next().a());
        }
        this.j.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b(Theme theme) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.b.size()) {
                if (this.b.get(i2) != theme) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            } else {
                return -1;
            }
        }
    }

    @Override // com.nexstreaming.kinemaster.kmpackage.aq
    public void a(Theme theme) {
        View findViewWithTag;
        if (isAdded() && this.i != null && (findViewWithTag = this.i.findViewWithTag(theme)) != null) {
            ProgressBar progressBar = (ProgressBar) findViewWithTag.findViewById(R.id.progressBar_theme_item_download);
            if (theme.r()) {
                progressBar.setProgress((theme.s() * 100) / theme.t());
            } else if (theme.p()) {
                progressBar.setVisibility(8);
                progressBar.setProgress(0);
            } else {
                progressBar.setVisibility(8);
            }
        }
    }

    @Override // com.nexstreaming.kinemaster.kmpackage.aq
    public void a(Theme theme, Task.TaskError taskError) {
        View findViewWithTag;
        if (this.i != null && (findViewWithTag = this.i.findViewWithTag(theme)) != null) {
            ((ProgressBar) findViewWithTag.findViewById(R.id.progressBar_theme_item_download)).setVisibility(8);
            findViewWithTag.findViewById(R.id.linear_theme_item_button_holder).setVisibility(0);
            this.g.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ThemeBrowserFragment.java */
    /* loaded from: classes.dex */
    public class b {
        private Theme b;
        private boolean c;

        public b(Theme theme) {
            this.b = theme;
            this.c = theme.p();
        }

        public Theme a() {
            return this.b;
        }

        public boolean b() {
            return this.c;
        }
    }
}
