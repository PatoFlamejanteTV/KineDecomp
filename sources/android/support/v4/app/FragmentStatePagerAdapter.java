package android.support.v4.app;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class FragmentStatePagerAdapter extends PagerAdapter {

    /* renamed from: c, reason: collision with root package name */
    private final FragmentManager f787c;

    /* renamed from: d, reason: collision with root package name */
    private FragmentTransaction f788d = null;

    /* renamed from: e, reason: collision with root package name */
    private ArrayList<Fragment.SavedState> f789e = new ArrayList<>();

    /* renamed from: f, reason: collision with root package name */
    private ArrayList<Fragment> f790f = new ArrayList<>();

    /* renamed from: g, reason: collision with root package name */
    private Fragment f791g = null;

    public FragmentStatePagerAdapter(FragmentManager fragmentManager) {
        this.f787c = fragmentManager;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (this.f788d == null) {
            this.f788d = this.f787c.beginTransaction();
        }
        while (this.f789e.size() <= i) {
            this.f789e.add(null);
        }
        this.f789e.set(i, fragment.isAdded() ? this.f787c.saveFragmentInstanceState(fragment) : null);
        this.f790f.set(i, null);
        this.f788d.remove(fragment);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void finishUpdate(ViewGroup viewGroup) {
        FragmentTransaction fragmentTransaction = this.f788d;
        if (fragmentTransaction != null) {
            fragmentTransaction.commitNowAllowingStateLoss();
            this.f788d = null;
        }
    }

    public abstract Fragment getItem(int i);

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        Fragment.SavedState savedState;
        Fragment fragment;
        if (this.f790f.size() > i && (fragment = this.f790f.get(i)) != null) {
            return fragment;
        }
        if (this.f788d == null) {
            this.f788d = this.f787c.beginTransaction();
        }
        Fragment item = getItem(i);
        if (this.f789e.size() > i && (savedState = this.f789e.get(i)) != null) {
            item.setInitialSavedState(savedState);
        }
        while (this.f790f.size() <= i) {
            this.f790f.add(null);
        }
        item.setMenuVisibility(false);
        item.setUserVisibleHint(false);
        this.f790f.set(i, item);
        this.f788d.add(viewGroup.getId(), item);
        return item;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return ((Fragment) obj).getView() == view;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
        if (parcelable != null) {
            Bundle bundle = (Bundle) parcelable;
            bundle.setClassLoader(classLoader);
            Parcelable[] parcelableArray = bundle.getParcelableArray("states");
            this.f789e.clear();
            this.f790f.clear();
            if (parcelableArray != null) {
                for (Parcelable parcelable2 : parcelableArray) {
                    this.f789e.add((Fragment.SavedState) parcelable2);
                }
            }
            for (String str : bundle.keySet()) {
                if (str.startsWith("f")) {
                    int parseInt = Integer.parseInt(str.substring(1));
                    Fragment fragment = this.f787c.getFragment(bundle, str);
                    if (fragment != null) {
                        while (this.f790f.size() <= parseInt) {
                            this.f790f.add(null);
                        }
                        fragment.setMenuVisibility(false);
                        this.f790f.set(parseInt, fragment);
                    } else {
                        Log.w("FragmentStatePagerAdapt", "Bad fragment at key " + str);
                    }
                }
            }
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public Parcelable saveState() {
        Bundle bundle;
        if (this.f789e.size() > 0) {
            bundle = new Bundle();
            Fragment.SavedState[] savedStateArr = new Fragment.SavedState[this.f789e.size()];
            this.f789e.toArray(savedStateArr);
            bundle.putParcelableArray("states", savedStateArr);
        } else {
            bundle = null;
        }
        for (int i = 0; i < this.f790f.size(); i++) {
            Fragment fragment = this.f790f.get(i);
            if (fragment != null && fragment.isAdded()) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                this.f787c.putFragment(bundle, "f" + i, fragment);
            }
        }
        return bundle;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        Fragment fragment2 = this.f791g;
        if (fragment != fragment2) {
            if (fragment2 != null) {
                fragment2.setMenuVisibility(false);
                this.f791g.setUserVisibleHint(false);
            }
            if (fragment != null) {
                fragment.setMenuVisibility(true);
                fragment.setUserVisibleHint(true);
            }
            this.f791g = fragment;
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public void startUpdate(ViewGroup viewGroup) {
        if (viewGroup.getId() != -1) {
            return;
        }
        throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
    }
}
