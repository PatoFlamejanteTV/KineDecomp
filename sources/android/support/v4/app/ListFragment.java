package android.support.v4.app;

import android.R;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

/* loaded from: classes.dex */
public class ListFragment extends Fragment {

    /* renamed from: a */
    private final Handler f895a = new Handler();

    /* renamed from: b */
    private final Runnable f896b = new Runnable() { // from class: android.support.v4.app.ListFragment.1
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ListView listView = ListFragment.this.f899e;
            listView.focusableViewAvailable(listView);
        }
    };

    /* renamed from: c */
    private final AdapterView.OnItemClickListener f897c = new AdapterView.OnItemClickListener() { // from class: android.support.v4.app.ListFragment.2
        AnonymousClass2() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ListFragment.this.onListItemClick((ListView) adapterView, view, i, j);
        }
    };

    /* renamed from: d */
    ListAdapter f898d;

    /* renamed from: e */
    ListView f899e;

    /* renamed from: f */
    View f900f;

    /* renamed from: g */
    TextView f901g;

    /* renamed from: h */
    View f902h;
    View i;
    CharSequence j;
    boolean k;

    /* renamed from: android.support.v4.app.ListFragment$1 */
    /* loaded from: classes.dex */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ListView listView = ListFragment.this.f899e;
            listView.focusableViewAvailable(listView);
        }
    }

    /* renamed from: android.support.v4.app.ListFragment$2 */
    /* loaded from: classes.dex */
    class AnonymousClass2 implements AdapterView.OnItemClickListener {
        AnonymousClass2() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ListFragment.this.onListItemClick((ListView) adapterView, view, i, j);
        }
    }

    private void a(boolean z, boolean z2) {
        z();
        View view = this.f902h;
        if (view != null) {
            if (this.k == z) {
                return;
            }
            this.k = z;
            if (z) {
                if (z2) {
                    view.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.fade_out));
                    this.i.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.fade_in));
                } else {
                    view.clearAnimation();
                    this.i.clearAnimation();
                }
                this.f902h.setVisibility(8);
                this.i.setVisibility(0);
                return;
            }
            if (z2) {
                view.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.fade_in));
                this.i.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.fade_out));
            } else {
                view.clearAnimation();
                this.i.clearAnimation();
            }
            this.f902h.setVisibility(0);
            this.i.setVisibility(8);
            return;
        }
        throw new IllegalStateException("Can't be used with a custom content view");
    }

    private void z() {
        if (this.f899e != null) {
            return;
        }
        View view = getView();
        if (view != null) {
            if (view instanceof ListView) {
                this.f899e = (ListView) view;
            } else {
                this.f901g = (TextView) view.findViewById(16711681);
                TextView textView = this.f901g;
                if (textView == null) {
                    this.f900f = view.findViewById(R.id.empty);
                } else {
                    textView.setVisibility(8);
                }
                this.f902h = view.findViewById(16711682);
                this.i = view.findViewById(16711683);
                View findViewById = view.findViewById(R.id.list);
                if (!(findViewById instanceof ListView)) {
                    if (findViewById == null) {
                        throw new RuntimeException("Your content must have a ListView whose id attribute is 'android.R.id.list'");
                    }
                    throw new RuntimeException("Content has view with id attribute 'android.R.id.list' that is not a ListView class");
                }
                this.f899e = (ListView) findViewById;
                View view2 = this.f900f;
                if (view2 != null) {
                    this.f899e.setEmptyView(view2);
                } else {
                    CharSequence charSequence = this.j;
                    if (charSequence != null) {
                        this.f901g.setText(charSequence);
                        this.f899e.setEmptyView(this.f901g);
                    }
                }
            }
            this.k = true;
            this.f899e.setOnItemClickListener(this.f897c);
            ListAdapter listAdapter = this.f898d;
            if (listAdapter != null) {
                this.f898d = null;
                setListAdapter(listAdapter);
            } else if (this.f902h != null) {
                a(false, false);
            }
            this.f895a.post(this.f896b);
            return;
        }
        throw new IllegalStateException("Content view not yet created");
    }

    public ListAdapter getListAdapter() {
        return this.f898d;
    }

    public ListView getListView() {
        z();
        return this.f899e;
    }

    public long getSelectedItemId() {
        z();
        return this.f899e.getSelectedItemId();
    }

    public int getSelectedItemPosition() {
        z();
        return this.f899e.getSelectedItemPosition();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Context context = getContext();
        FrameLayout frameLayout = new FrameLayout(context);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setId(16711682);
        linearLayout.setOrientation(1);
        linearLayout.setVisibility(8);
        linearLayout.setGravity(17);
        linearLayout.addView(new ProgressBar(context, null, R.attr.progressBarStyleLarge), new FrameLayout.LayoutParams(-2, -2));
        frameLayout.addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout frameLayout2 = new FrameLayout(context);
        frameLayout2.setId(16711683);
        TextView textView = new TextView(context);
        textView.setId(16711681);
        textView.setGravity(17);
        frameLayout2.addView(textView, new FrameLayout.LayoutParams(-1, -1));
        ListView listView = new ListView(context);
        listView.setId(R.id.list);
        listView.setDrawSelectorOnTop(false);
        frameLayout2.addView(listView, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return frameLayout;
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        this.f895a.removeCallbacks(this.f896b);
        this.f899e = null;
        this.k = false;
        this.i = null;
        this.f902h = null;
        this.f900f = null;
        this.f901g = null;
        super.onDestroyView();
    }

    public void onListItemClick(ListView listView, View view, int i, long j) {
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        z();
    }

    public void setEmptyText(CharSequence charSequence) {
        z();
        TextView textView = this.f901g;
        if (textView != null) {
            textView.setText(charSequence);
            if (this.j == null) {
                this.f899e.setEmptyView(this.f901g);
            }
            this.j = charSequence;
            return;
        }
        throw new IllegalStateException("Can't be used with a custom content view");
    }

    public void setListAdapter(ListAdapter listAdapter) {
        boolean z = this.f898d != null;
        this.f898d = listAdapter;
        ListView listView = this.f899e;
        if (listView != null) {
            listView.setAdapter(listAdapter);
            if (this.k || z) {
                return;
            }
            a(true, getView().getWindowToken() != null);
        }
    }

    public void setListShown(boolean z) {
        a(z, true);
    }

    public void setListShownNoAnimation(boolean z) {
        a(z, false);
    }

    public void setSelection(int i) {
        z();
        this.f899e.setSelection(i);
    }
}
