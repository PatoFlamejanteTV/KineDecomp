package com.nextreaming.nexeditorui.newproject.b;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.widget.Toolbar;
import java.util.List;

/* compiled from: ThemeBrowserFragment.java */
/* loaded from: classes3.dex */
public class g extends Fragment {

    /* renamed from: a */
    private List<c.d.b.i.a> f24356a;

    /* renamed from: b */
    private c.d.b.i.a f24357b;

    /* renamed from: c */
    private View f24358c;

    /* renamed from: d */
    private Toolbar f24359d;

    /* renamed from: e */
    private GridView f24360e;

    /* renamed from: f */
    private c f24361f;

    /* renamed from: g */
    private a f24362g;

    /* renamed from: h */
    private boolean f24363h = false;
    private View.OnClickListener i = new e(this);
    private AdapterView.OnItemClickListener j = new f(this);

    /* compiled from: ThemeBrowserFragment.java */
    /* loaded from: classes3.dex */
    public interface a {
        void a(c.d.b.i.a aVar);

        void r();
    }

    private void z() {
        if (isAdded()) {
            this.f24356a = c.d.b.i.b.a();
            this.f24361f = new c(getActivity(), this.f24356a);
            this.f24360e.setAdapter((ListAdapter) this.f24361f);
            c.d.b.i.a aVar = this.f24357b;
            if (aVar != null) {
                this.f24361f.a(a(aVar));
                this.f24361f.notifyDataSetChanged();
                this.f24360e.post(new d(this));
                this.f24359d.a(this.f24357b.getName(getActivity()), 1);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f24359d.setTitle(getString(R.string.new_project_toolbar_title_theme_browser));
        this.f24359d.setLogo(R.drawable.icon_theme_title_logo);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.new_project_bottombar_height);
        GridView gridView = this.f24360e;
        gridView.setPadding(gridView.getPaddingLeft(), this.f24360e.getPaddingTop(), this.f24360e.getPaddingRight(), this.f24360e.getPaddingBottom() + dimensionPixelSize);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.toolbar_height);
        GridView gridView2 = this.f24360e;
        gridView2.setPadding(gridView2.getPaddingLeft(), dimensionPixelSize2, this.f24360e.getPaddingRight(), this.f24360e.getPaddingBottom());
        this.f24360e.setOnItemClickListener(this.j);
        z();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.f24362g = (a) activity;
        } catch (ClassCastException unused) {
            throw new ClassCastException(activity.toString() + " must implement OnInputTextFragmentListener");
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString("SelectedTheme");
            if (string != null) {
                this.f24357b = c.d.b.i.b.a(string);
            }
            this.f24363h = arguments.getBoolean("applyAndCancelButtons");
        }
        if (bundle != null) {
            String string2 = bundle.getString("selected_item_theme_id");
            if (string2 != null) {
                this.f24357b = c.d.b.i.b.a(string2);
            }
            this.f24363h = bundle.getBoolean("UseApplyAndCancelButtons");
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.nexstreaming.kinemaster.usage.analytics.b.a(g.class.getName());
        this.f24358c = layoutInflater.inflate(R.layout.fragment_themebrowser, viewGroup, false);
        this.f24359d = (Toolbar) this.f24358c.findViewById(R.id.toolbar_themebrowser);
        this.f24359d.setClickListener(this.i);
        this.f24360e = (GridView) this.f24358c.findViewById(R.id.gridView_themebrowser);
        if (this.f24363h) {
            this.f24359d.setExitButtonMode(Toolbar.ExitButtonMode.Done);
        }
        return this.f24358c;
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        c cVar = this.f24361f;
        if (cVar != null) {
            cVar.a();
            this.f24361f = null;
        }
        this.f24358c = null;
        this.f24359d = null;
        this.f24360e = null;
        this.f24362g = null;
        super.onDestroyView();
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        c cVar = this.f24361f;
        if (cVar != null) {
            cVar.a();
        }
        super.onPause();
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        if (bundle != null) {
            c.d.b.i.a aVar = this.f24357b;
            if (aVar != null) {
                bundle.putString("selected_item_theme_id", aVar.getId());
            }
            bundle.putBoolean("UseApplyAndCancelButtons", this.f24363h);
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        c cVar = this.f24361f;
        if (cVar != null) {
            cVar.notifyDataSetInvalidated();
        }
        super.onStart();
    }

    public static g a(String str, boolean z) {
        g gVar = new g();
        Bundle bundle = new Bundle();
        bundle.putString("SelectedTheme", str);
        bundle.putBoolean("applyAndCancelButtons", z);
        gVar.setArguments(bundle);
        return gVar;
    }

    public int a(c.d.b.i.a aVar) {
        return this.f24356a.indexOf(aVar);
    }
}
