package com.nexstreaming.kinemaster.ui.projectedit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.nexstreaming.app.kinemasterfree.R;

/* loaded from: classes.dex */
public abstract class OptionTabFragment extends ed {

    /* renamed from: a, reason: collision with root package name */
    private View f3740a;
    private TabId b;

    /* loaded from: classes.dex */
    public enum TabId {
        ItemEditTab,
        ItemOptionTab
    }

    protected abstract View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle);

    protected abstract void a(TabId tabId);

    protected abstract int h();

    @Override // com.nexstreaming.kinemaster.ui.projectedit.ed
    protected final View a_(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f3740a = layoutInflater.inflate(R.layout.option_tabmenu_fragment, viewGroup, false);
        this.f3740a.findViewById(R.id.optmenu_item_tab).setOnClickListener(new hd(this));
        this.f3740a.findViewById(R.id.optmenu_opt_tab).setOnClickListener(new he(this));
        ((ImageView) this.f3740a.findViewById(R.id.optmenu_item_tab)).setImageResource(h());
        ViewGroup viewGroup2 = (ViewGroup) this.f3740a.findViewById(R.id.itemEditTabContent);
        View a2 = a(layoutInflater, viewGroup2, bundle);
        if (a2 != null) {
            viewGroup2.addView(a2);
        }
        TabId tabId = this.b;
        this.b = null;
        if (tabId == null) {
            tabId = TabId.ItemEditTab;
        }
        b(tabId);
        return this.f3740a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(TabId tabId) {
        if (this.b != tabId) {
            this.b = tabId;
            if (this.f3740a != null) {
                this.f3740a.findViewById(R.id.optmenu_item_tab).setActivated(tabId == TabId.ItemEditTab);
                this.f3740a.findViewById(R.id.itemEditTabContent).setVisibility(tabId == TabId.ItemEditTab ? 0 : 8);
                this.f3740a.findViewById(R.id.optmenu_opt_tab).setActivated(tabId == TabId.ItemOptionTab);
                this.f3740a.findViewById(R.id.MenuListHolder).setVisibility(tabId != TabId.ItemOptionTab ? 8 : 0);
                a(tabId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(TabId tabId) {
        if (this.f3740a != null) {
            if (tabId == TabId.ItemOptionTab) {
                this.f3740a.findViewById(R.id.optmenu_opt_tab).setEnabled(true);
            } else if (tabId == TabId.ItemEditTab) {
                this.f3740a.findViewById(R.id.optmenu_item_tab).setEnabled(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(TabId tabId) {
        if (this.f3740a != null) {
            if (tabId == TabId.ItemOptionTab) {
                this.f3740a.findViewById(R.id.optmenu_opt_tab).setEnabled(false);
            } else if (tabId == TabId.ItemEditTab) {
                this.f3740a.findViewById(R.id.optmenu_item_tab).setEnabled(false);
            }
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.ed
    protected boolean e() {
        return true;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.ed, android.app.Fragment
    public void onDestroyView() {
        this.f3740a = null;
        super.onDestroyView();
    }
}
