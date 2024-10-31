package android.support.v4.app;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class FragmentTabHost extends TabHost implements TabHost.OnTabChangeListener {

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList<TabInfo> f792a;

    /* renamed from: b, reason: collision with root package name */
    private FrameLayout f793b;

    /* renamed from: c, reason: collision with root package name */
    private Context f794c;

    /* renamed from: d, reason: collision with root package name */
    private FragmentManager f795d;

    /* renamed from: e, reason: collision with root package name */
    private int f796e;

    /* renamed from: f, reason: collision with root package name */
    private TabHost.OnTabChangeListener f797f;

    /* renamed from: g, reason: collision with root package name */
    private TabInfo f798g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f799h;

    /* loaded from: classes.dex */
    static class DummyTabFactory implements TabHost.TabContentFactory {

        /* renamed from: a, reason: collision with root package name */
        private final Context f800a;

        public DummyTabFactory(Context context) {
            this.f800a = context;
        }

        @Override // android.widget.TabHost.TabContentFactory
        public View createTabContent(String str) {
            View view = new View(this.f800a);
            view.setMinimumWidth(0);
            view.setMinimumHeight(0);
            return view;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: android.support.v4.app.FragmentTabHost.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };

        /* renamed from: a, reason: collision with root package name */
        String f801a;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " curTab=" + this.f801a + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.f801a);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.f801a = parcel.readString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class TabInfo {

        /* renamed from: a, reason: collision with root package name */
        final String f802a;

        /* renamed from: b, reason: collision with root package name */
        final Class<?> f803b;

        /* renamed from: c, reason: collision with root package name */
        final Bundle f804c;

        /* renamed from: d, reason: collision with root package name */
        Fragment f805d;

        TabInfo(String str, Class<?> cls, Bundle bundle) {
            this.f802a = str;
            this.f803b = cls;
            this.f804c = bundle;
        }
    }

    public FragmentTabHost(Context context) {
        super(context, null);
        this.f792a = new ArrayList<>();
        a(context, (AttributeSet) null);
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.inflatedId}, 0, 0);
        this.f796e = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        super.setOnTabChangedListener(this);
    }

    public void addTab(TabHost.TabSpec tabSpec, Class<?> cls, Bundle bundle) {
        tabSpec.setContent(new DummyTabFactory(this.f794c));
        String tag = tabSpec.getTag();
        TabInfo tabInfo = new TabInfo(tag, cls, bundle);
        if (this.f799h) {
            tabInfo.f805d = this.f795d.findFragmentByTag(tag);
            Fragment fragment = tabInfo.f805d;
            if (fragment != null && !fragment.isDetached()) {
                FragmentTransaction beginTransaction = this.f795d.beginTransaction();
                beginTransaction.detach(tabInfo.f805d);
                beginTransaction.commit();
            }
        }
        this.f792a.add(tabInfo);
        addTab(tabSpec);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        String currentTabTag = getCurrentTabTag();
        int size = this.f792a.size();
        FragmentTransaction fragmentTransaction = null;
        for (int i = 0; i < size; i++) {
            TabInfo tabInfo = this.f792a.get(i);
            tabInfo.f805d = this.f795d.findFragmentByTag(tabInfo.f802a);
            Fragment fragment = tabInfo.f805d;
            if (fragment != null && !fragment.isDetached()) {
                if (tabInfo.f802a.equals(currentTabTag)) {
                    this.f798g = tabInfo;
                } else {
                    if (fragmentTransaction == null) {
                        fragmentTransaction = this.f795d.beginTransaction();
                    }
                    fragmentTransaction.detach(tabInfo.f805d);
                }
            }
        }
        this.f799h = true;
        FragmentTransaction a2 = a(currentTabTag, fragmentTransaction);
        if (a2 != null) {
            a2.commit();
            this.f795d.executePendingTransactions();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f799h = false;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setCurrentTabByTag(savedState.f801a);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f801a = getCurrentTabTag();
        return savedState;
    }

    @Override // android.widget.TabHost.OnTabChangeListener
    public void onTabChanged(String str) {
        FragmentTransaction a2;
        if (this.f799h && (a2 = a(str, (FragmentTransaction) null)) != null) {
            a2.commit();
        }
        TabHost.OnTabChangeListener onTabChangeListener = this.f797f;
        if (onTabChangeListener != null) {
            onTabChangeListener.onTabChanged(str);
        }
    }

    @Override // android.widget.TabHost
    public void setOnTabChangedListener(TabHost.OnTabChangeListener onTabChangeListener) {
        this.f797f = onTabChangeListener;
    }

    @Override // android.widget.TabHost
    @Deprecated
    public void setup() {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }

    public void setup(Context context, FragmentManager fragmentManager) {
        a(context);
        super.setup();
        this.f794c = context;
        this.f795d = fragmentManager;
        a();
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f792a = new ArrayList<>();
        a(context, attributeSet);
    }

    private void a(Context context) {
        if (findViewById(R.id.tabs) == null) {
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(1);
            addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
            TabWidget tabWidget = new TabWidget(context);
            tabWidget.setId(R.id.tabs);
            tabWidget.setOrientation(0);
            linearLayout.addView(tabWidget, new LinearLayout.LayoutParams(-1, -2, 0.0f));
            FrameLayout frameLayout = new FrameLayout(context);
            frameLayout.setId(R.id.tabcontent);
            linearLayout.addView(frameLayout, new LinearLayout.LayoutParams(0, 0, 0.0f));
            FrameLayout frameLayout2 = new FrameLayout(context);
            this.f793b = frameLayout2;
            this.f793b.setId(this.f796e);
            linearLayout.addView(frameLayout2, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        }
    }

    public void setup(Context context, FragmentManager fragmentManager, int i) {
        a(context);
        super.setup();
        this.f794c = context;
        this.f795d = fragmentManager;
        this.f796e = i;
        a();
        this.f793b.setId(i);
        if (getId() == -1) {
            setId(R.id.tabhost);
        }
    }

    private void a() {
        if (this.f793b == null) {
            this.f793b = (FrameLayout) findViewById(this.f796e);
            if (this.f793b != null) {
                return;
            }
            throw new IllegalStateException("No tab content FrameLayout found for id " + this.f796e);
        }
    }

    private FragmentTransaction a(String str, FragmentTransaction fragmentTransaction) {
        Fragment fragment;
        TabInfo a2 = a(str);
        if (this.f798g != a2) {
            if (fragmentTransaction == null) {
                fragmentTransaction = this.f795d.beginTransaction();
            }
            TabInfo tabInfo = this.f798g;
            if (tabInfo != null && (fragment = tabInfo.f805d) != null) {
                fragmentTransaction.detach(fragment);
            }
            if (a2 != null) {
                Fragment fragment2 = a2.f805d;
                if (fragment2 == null) {
                    a2.f805d = Fragment.instantiate(this.f794c, a2.f803b.getName(), a2.f804c);
                    fragmentTransaction.add(this.f796e, a2.f805d, a2.f802a);
                } else {
                    fragmentTransaction.attach(fragment2);
                }
            }
            this.f798g = a2;
        }
        return fragmentTransaction;
    }

    private TabInfo a(String str) {
        int size = this.f792a.size();
        for (int i = 0; i < size; i++) {
            TabInfo tabInfo = this.f792a.get(i);
            if (tabInfo.f802a.equals(str)) {
                return tabInfo;
            }
        }
        return null;
    }
}
