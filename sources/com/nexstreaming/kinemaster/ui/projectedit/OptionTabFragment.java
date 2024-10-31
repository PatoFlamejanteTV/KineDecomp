package com.nexstreaming.kinemaster.ui.projectedit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.nexstreaming.app.kinemasterfree.R;

/* loaded from: classes2.dex */
public abstract class OptionTabFragment extends Xc {
    private View C;
    private TabId D;

    /* loaded from: classes2.dex */
    public enum TabId {
        ItemEditTab,
        ItemOptionTab
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc
    public final View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.C = layoutInflater.inflate(R.layout.option_tabmenu_fragment, viewGroup, false);
        this.C.findViewById(R.id.optmenu_item_tab).setOnClickListener(new Ne(this));
        this.C.findViewById(R.id.optmenu_opt_tab).setOnClickListener(new Oe(this));
        ((ImageView) this.C.findViewById(R.id.optmenu_item_tab)).setImageResource(za());
        ViewGroup viewGroup2 = (ViewGroup) this.C.findViewById(R.id.itemEditTabContent);
        View b2 = b(layoutInflater, viewGroup2, bundle);
        if (b2 != null) {
            viewGroup2.addView(b2);
        }
        TabId tabId = this.D;
        this.D = null;
        if (tabId == null) {
            tabId = TabId.ItemEditTab;
        }
        d(tabId);
        return this.C;
    }

    protected abstract View b(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle);

    public void b(TabId tabId) {
        View view = this.C;
        if (view != null) {
            if (tabId == TabId.ItemOptionTab) {
                view.findViewById(R.id.optmenu_opt_tab).setEnabled(true);
            } else if (tabId == TabId.ItemEditTab) {
                view.findViewById(R.id.optmenu_item_tab).setEnabled(true);
            }
        }
    }

    protected abstract void c(TabId tabId);

    public void d(TabId tabId) {
        if (this.D != tabId) {
            this.D = tabId;
            View view = this.C;
            if (view != null) {
                int i = 0;
                view.findViewById(R.id.optmenu_item_tab).setActivated(tabId == TabId.ItemEditTab);
                ViewGroup viewGroup = (ViewGroup) this.C.findViewById(R.id.itemEditTabContent);
                viewGroup.setVisibility((tabId != TabId.ItemEditTab || viewGroup.getChildCount() <= 0) ? 8 : 0);
                this.C.findViewById(R.id.optmenu_opt_tab).setActivated(tabId == TabId.ItemOptionTab);
                View findViewById = this.C.findViewById(R.id.MenuListHolder);
                if (tabId != TabId.ItemOptionTab && viewGroup.getChildCount() > 0) {
                    i = 8;
                }
                findViewById.setVisibility(i);
                c(tabId);
            }
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc, com.nexstreaming.kinemaster.ui.projectedit.Bg, android.support.v4.app.Fragment
    public void onDestroyView() {
        this.C = null;
        super.onDestroyView();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc
    protected boolean ta() {
        return true;
    }

    protected abstract int za();

    public void a(TabId tabId) {
        View view = this.C;
        if (view != null) {
            if (tabId == TabId.ItemOptionTab) {
                view.findViewById(R.id.optmenu_opt_tab).setEnabled(false);
            } else if (tabId == TabId.ItemEditTab) {
                view.findViewById(R.id.optmenu_item_tab).setEnabled(false);
            }
        }
    }
}
