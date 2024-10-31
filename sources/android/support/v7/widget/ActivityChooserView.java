package android.support.v7.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v7.appcompat.R;
import android.support.v7.view.menu.ShowableListMenu;
import android.support.v7.widget.ActivityChooserModel;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

/* loaded from: classes.dex */
public class ActivityChooserView extends ViewGroup implements ActivityChooserModel.ActivityChooserModelClient {

    /* renamed from: a */
    final ActivityChooserViewAdapter f2573a;

    /* renamed from: b */
    private final Callbacks f2574b;

    /* renamed from: c */
    private final View f2575c;

    /* renamed from: d */
    private final Drawable f2576d;

    /* renamed from: e */
    final FrameLayout f2577e;

    /* renamed from: f */
    private final ImageView f2578f;

    /* renamed from: g */
    final FrameLayout f2579g;

    /* renamed from: h */
    private final ImageView f2580h;
    private final int i;
    ActionProvider j;
    final DataSetObserver k;
    private final ViewTreeObserver.OnGlobalLayoutListener l;
    private ListPopupWindow m;
    PopupWindow.OnDismissListener n;
    boolean o;
    int p;
    private boolean q;
    private int r;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: android.support.v7.widget.ActivityChooserView$1 */
    /* loaded from: classes.dex */
    public class AnonymousClass1 extends DataSetObserver {
        AnonymousClass1() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            super.onChanged();
            ActivityChooserView.this.f2573a.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            super.onInvalidated();
            ActivityChooserView.this.f2573a.notifyDataSetInvalidated();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: android.support.v7.widget.ActivityChooserView$2 */
    /* loaded from: classes.dex */
    public class AnonymousClass2 implements ViewTreeObserver.OnGlobalLayoutListener {
        AnonymousClass2() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (ActivityChooserView.this.isShowingPopup()) {
                if (!ActivityChooserView.this.isShown()) {
                    ActivityChooserView.this.getListPopupWindow().dismiss();
                    return;
                }
                ActivityChooserView.this.getListPopupWindow().show();
                ActionProvider actionProvider = ActivityChooserView.this.j;
                if (actionProvider != null) {
                    actionProvider.subUiVisibilityChanged(true);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: android.support.v7.widget.ActivityChooserView$3 */
    /* loaded from: classes.dex */
    public class AnonymousClass3 extends View.AccessibilityDelegate {
        AnonymousClass3() {
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCanOpenPopup(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: android.support.v7.widget.ActivityChooserView$4 */
    /* loaded from: classes.dex */
    public class AnonymousClass4 extends ForwardingListener {
        AnonymousClass4(View view) {
            super(view);
        }

        @Override // android.support.v7.widget.ForwardingListener
        public ShowableListMenu getPopup() {
            return ActivityChooserView.this.getListPopupWindow();
        }

        @Override // android.support.v7.widget.ForwardingListener
        protected boolean onForwardingStarted() {
            ActivityChooserView.this.showPopup();
            return true;
        }

        @Override // android.support.v7.widget.ForwardingListener
        protected boolean onForwardingStopped() {
            ActivityChooserView.this.dismissPopup();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: android.support.v7.widget.ActivityChooserView$5 */
    /* loaded from: classes.dex */
    public class AnonymousClass5 extends DataSetObserver {
        AnonymousClass5() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            super.onChanged();
            ActivityChooserView.this.a();
        }
    }

    /* loaded from: classes.dex */
    public class ActivityChooserViewAdapter extends BaseAdapter {
        public static final int MAX_ACTIVITY_COUNT_DEFAULT = 4;
        public static final int MAX_ACTIVITY_COUNT_UNLIMITED = Integer.MAX_VALUE;

        /* renamed from: a */
        private ActivityChooserModel f2585a;

        /* renamed from: b */
        private int f2586b = 4;

        /* renamed from: c */
        private boolean f2587c;

        /* renamed from: d */
        private boolean f2588d;

        /* renamed from: e */
        private boolean f2589e;

        ActivityChooserViewAdapter() {
        }

        public int getActivityCount() {
            return this.f2585a.getActivityCount();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int activityCount = this.f2585a.getActivityCount();
            if (!this.f2587c && this.f2585a.getDefaultActivity() != null) {
                activityCount--;
            }
            int min = Math.min(activityCount, this.f2586b);
            return this.f2589e ? min + 1 : min;
        }

        public ActivityChooserModel getDataModel() {
            return this.f2585a;
        }

        public ResolveInfo getDefaultActivity() {
            return this.f2585a.getDefaultActivity();
        }

        public int getHistorySize() {
            return this.f2585a.getHistorySize();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            int itemViewType = getItemViewType(i);
            if (itemViewType != 0) {
                if (itemViewType == 1) {
                    return null;
                }
                throw new IllegalArgumentException();
            }
            if (!this.f2587c && this.f2585a.getDefaultActivity() != null) {
                i++;
            }
            return this.f2585a.getActivity(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i) {
            return (this.f2589e && i == getCount() - 1) ? 1 : 0;
        }

        public boolean getShowDefaultActivity() {
            return this.f2587c;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            int itemViewType = getItemViewType(i);
            if (itemViewType != 0) {
                if (itemViewType == 1) {
                    if (view != null && view.getId() == 1) {
                        return view;
                    }
                    View inflate = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(R.layout.abc_activity_chooser_view_list_item, viewGroup, false);
                    inflate.setId(1);
                    ((TextView) inflate.findViewById(R.id.title)).setText(ActivityChooserView.this.getContext().getString(R.string.abc_activity_chooser_view_see_all));
                    return inflate;
                }
                throw new IllegalArgumentException();
            }
            if (view == null || view.getId() != R.id.list_item) {
                view = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(R.layout.abc_activity_chooser_view_list_item, viewGroup, false);
            }
            PackageManager packageManager = ActivityChooserView.this.getContext().getPackageManager();
            ImageView imageView = (ImageView) view.findViewById(R.id.icon);
            ResolveInfo resolveInfo = (ResolveInfo) getItem(i);
            imageView.setImageDrawable(resolveInfo.loadIcon(packageManager));
            ((TextView) view.findViewById(R.id.title)).setText(resolveInfo.loadLabel(packageManager));
            if (this.f2587c && i == 0 && this.f2588d) {
                view.setActivated(true);
            } else {
                view.setActivated(false);
            }
            return view;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return 3;
        }

        public int measureContentWidth() {
            int i = this.f2586b;
            this.f2586b = MAX_ACTIVITY_COUNT_UNLIMITED;
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
            int count = getCount();
            View view = null;
            int i2 = 0;
            for (int i3 = 0; i3 < count; i3++) {
                view = getView(i3, view, null);
                view.measure(makeMeasureSpec, makeMeasureSpec2);
                i2 = Math.max(i2, view.getMeasuredWidth());
            }
            this.f2586b = i;
            return i2;
        }

        public void setDataModel(ActivityChooserModel activityChooserModel) {
            ActivityChooserModel dataModel = ActivityChooserView.this.f2573a.getDataModel();
            if (dataModel != null && ActivityChooserView.this.isShown()) {
                dataModel.unregisterObserver(ActivityChooserView.this.k);
            }
            this.f2585a = activityChooserModel;
            if (activityChooserModel != null && ActivityChooserView.this.isShown()) {
                activityChooserModel.registerObserver(ActivityChooserView.this.k);
            }
            notifyDataSetChanged();
        }

        public void setMaxActivityCount(int i) {
            if (this.f2586b != i) {
                this.f2586b = i;
                notifyDataSetChanged();
            }
        }

        public void setShowDefaultActivity(boolean z, boolean z2) {
            if (this.f2587c == z && this.f2588d == z2) {
                return;
            }
            this.f2587c = z;
            this.f2588d = z2;
            notifyDataSetChanged();
        }

        public void setShowFooterView(boolean z) {
            if (this.f2589e != z) {
                this.f2589e = z;
                notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes.dex */
    public class Callbacks implements AdapterView.OnItemClickListener, View.OnClickListener, View.OnLongClickListener, PopupWindow.OnDismissListener {
        Callbacks() {
        }

        private void a() {
            PopupWindow.OnDismissListener onDismissListener = ActivityChooserView.this.n;
            if (onDismissListener != null) {
                onDismissListener.onDismiss();
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ActivityChooserView activityChooserView = ActivityChooserView.this;
            if (view == activityChooserView.f2579g) {
                activityChooserView.dismissPopup();
                Intent chooseActivity = ActivityChooserView.this.f2573a.getDataModel().chooseActivity(ActivityChooserView.this.f2573a.getDataModel().getActivityIndex(ActivityChooserView.this.f2573a.getDefaultActivity()));
                if (chooseActivity != null) {
                    chooseActivity.addFlags(524288);
                    ActivityChooserView.this.getContext().startActivity(chooseActivity);
                    return;
                }
                return;
            }
            if (view == activityChooserView.f2577e) {
                activityChooserView.o = false;
                activityChooserView.a(activityChooserView.p);
                return;
            }
            throw new IllegalArgumentException();
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            a();
            ActionProvider actionProvider = ActivityChooserView.this.j;
            if (actionProvider != null) {
                actionProvider.subUiVisibilityChanged(false);
            }
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            int itemViewType = ((ActivityChooserViewAdapter) adapterView.getAdapter()).getItemViewType(i);
            if (itemViewType != 0) {
                if (itemViewType == 1) {
                    ActivityChooserView.this.a(ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                    return;
                }
                throw new IllegalArgumentException();
            }
            ActivityChooserView.this.dismissPopup();
            ActivityChooserView activityChooserView = ActivityChooserView.this;
            if (activityChooserView.o) {
                if (i > 0) {
                    activityChooserView.f2573a.getDataModel().setDefaultActivity(i);
                    return;
                }
                return;
            }
            if (!activityChooserView.f2573a.getShowDefaultActivity()) {
                i++;
            }
            Intent chooseActivity = ActivityChooserView.this.f2573a.getDataModel().chooseActivity(i);
            if (chooseActivity != null) {
                chooseActivity.addFlags(524288);
                ActivityChooserView.this.getContext().startActivity(chooseActivity);
            }
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            ActivityChooserView activityChooserView = ActivityChooserView.this;
            if (view == activityChooserView.f2579g) {
                if (activityChooserView.f2573a.getCount() > 0) {
                    ActivityChooserView activityChooserView2 = ActivityChooserView.this;
                    activityChooserView2.o = true;
                    activityChooserView2.a(activityChooserView2.p);
                }
                return true;
            }
            throw new IllegalArgumentException();
        }
    }

    /* loaded from: classes.dex */
    public static class InnerLayout extends LinearLayout {

        /* renamed from: a */
        private static final int[] f2592a = {android.R.attr.background};

        public InnerLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, f2592a);
            setBackgroundDrawable(obtainStyledAttributes.getDrawable(0));
            obtainStyledAttributes.recycle();
        }
    }

    public ActivityChooserView(Context context) {
        this(context, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7, types: [boolean, int] */
    void a(int i) {
        if (this.f2573a.getDataModel() != null) {
            getViewTreeObserver().addOnGlobalLayoutListener(this.l);
            ?? r0 = this.f2579g.getVisibility() == 0 ? 1 : 0;
            int activityCount = this.f2573a.getActivityCount();
            if (i != Integer.MAX_VALUE && activityCount > i + r0) {
                this.f2573a.setShowFooterView(true);
                this.f2573a.setMaxActivityCount(i - 1);
            } else {
                this.f2573a.setShowFooterView(false);
                this.f2573a.setMaxActivityCount(i);
            }
            ListPopupWindow listPopupWindow = getListPopupWindow();
            if (listPopupWindow.isShowing()) {
                return;
            }
            if (!this.o && r0 != 0) {
                this.f2573a.setShowDefaultActivity(false, false);
            } else {
                this.f2573a.setShowDefaultActivity(true, r0);
            }
            listPopupWindow.setContentWidth(Math.min(this.f2573a.measureContentWidth(), this.i));
            listPopupWindow.show();
            ActionProvider actionProvider = this.j;
            if (actionProvider != null) {
                actionProvider.subUiVisibilityChanged(true);
            }
            listPopupWindow.getListView().setContentDescription(getContext().getString(R.string.abc_activitychooserview_choose_application));
            listPopupWindow.getListView().setSelector(new ColorDrawable(0));
            return;
        }
        throw new IllegalStateException("No data model. Did you call #setDataModel?");
    }

    public boolean dismissPopup() {
        if (!isShowingPopup()) {
            return true;
        }
        getListPopupWindow().dismiss();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (!viewTreeObserver.isAlive()) {
            return true;
        }
        viewTreeObserver.removeGlobalOnLayoutListener(this.l);
        return true;
    }

    public ActivityChooserModel getDataModel() {
        return this.f2573a.getDataModel();
    }

    ListPopupWindow getListPopupWindow() {
        if (this.m == null) {
            this.m = new ListPopupWindow(getContext());
            this.m.setAdapter(this.f2573a);
            this.m.setAnchorView(this);
            this.m.setModal(true);
            this.m.setOnItemClickListener(this.f2574b);
            this.m.setOnDismissListener(this.f2574b);
        }
        return this.m;
    }

    public boolean isShowingPopup() {
        return getListPopupWindow().isShowing();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ActivityChooserModel dataModel = this.f2573a.getDataModel();
        if (dataModel != null) {
            dataModel.registerObserver(this.k);
        }
        this.q = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ActivityChooserModel dataModel = this.f2573a.getDataModel();
        if (dataModel != null) {
            dataModel.unregisterObserver(this.k);
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.l);
        }
        if (isShowingPopup()) {
            dismissPopup();
        }
        this.q = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.f2575c.layout(0, 0, i3 - i, i4 - i2);
        if (isShowingPopup()) {
            return;
        }
        dismissPopup();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        View view = this.f2575c;
        if (this.f2579g.getVisibility() != 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2), 1073741824);
        }
        measureChild(view, i, i2);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    @Override // android.support.v7.widget.ActivityChooserModel.ActivityChooserModelClient
    public void setActivityChooserModel(ActivityChooserModel activityChooserModel) {
        this.f2573a.setDataModel(activityChooserModel);
        if (isShowingPopup()) {
            dismissPopup();
            showPopup();
        }
    }

    public void setDefaultActionButtonContentDescription(int i) {
        this.r = i;
    }

    public void setExpandActivityOverflowButtonContentDescription(int i) {
        this.f2578f.setContentDescription(getContext().getString(i));
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.f2578f.setImageDrawable(drawable);
    }

    public void setInitialActivityCount(int i) {
        this.p = i;
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.n = onDismissListener;
    }

    public void setProvider(ActionProvider actionProvider) {
        this.j = actionProvider;
    }

    public boolean showPopup() {
        if (isShowingPopup() || !this.q) {
            return false;
        }
        this.o = false;
        a(this.p);
        return true;
    }

    public ActivityChooserView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActivityChooserView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.k = new DataSetObserver() { // from class: android.support.v7.widget.ActivityChooserView.1
            AnonymousClass1() {
            }

            @Override // android.database.DataSetObserver
            public void onChanged() {
                super.onChanged();
                ActivityChooserView.this.f2573a.notifyDataSetChanged();
            }

            @Override // android.database.DataSetObserver
            public void onInvalidated() {
                super.onInvalidated();
                ActivityChooserView.this.f2573a.notifyDataSetInvalidated();
            }
        };
        this.l = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: android.support.v7.widget.ActivityChooserView.2
            AnonymousClass2() {
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (ActivityChooserView.this.isShowingPopup()) {
                    if (!ActivityChooserView.this.isShown()) {
                        ActivityChooserView.this.getListPopupWindow().dismiss();
                        return;
                    }
                    ActivityChooserView.this.getListPopupWindow().show();
                    ActionProvider actionProvider = ActivityChooserView.this.j;
                    if (actionProvider != null) {
                        actionProvider.subUiVisibilityChanged(true);
                    }
                }
            }
        };
        this.p = 4;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ActivityChooserView, i, 0);
        this.p = obtainStyledAttributes.getInt(R.styleable.ActivityChooserView_initialActivityCount, 4);
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.ActivityChooserView_expandActivityOverflowButtonDrawable);
        obtainStyledAttributes.recycle();
        LayoutInflater.from(getContext()).inflate(R.layout.abc_activity_chooser_view, (ViewGroup) this, true);
        this.f2574b = new Callbacks();
        this.f2575c = findViewById(R.id.activity_chooser_view_content);
        this.f2576d = this.f2575c.getBackground();
        this.f2579g = (FrameLayout) findViewById(R.id.default_activity_button);
        this.f2579g.setOnClickListener(this.f2574b);
        this.f2579g.setOnLongClickListener(this.f2574b);
        this.f2580h = (ImageView) this.f2579g.findViewById(R.id.image);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.expand_activities_button);
        frameLayout.setOnClickListener(this.f2574b);
        frameLayout.setAccessibilityDelegate(new View.AccessibilityDelegate() { // from class: android.support.v7.widget.ActivityChooserView.3
            AnonymousClass3() {
            }

            @Override // android.view.View.AccessibilityDelegate
            public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCanOpenPopup(true);
            }
        });
        frameLayout.setOnTouchListener(new ForwardingListener(frameLayout) { // from class: android.support.v7.widget.ActivityChooserView.4
            AnonymousClass4(View frameLayout2) {
                super(frameLayout2);
            }

            @Override // android.support.v7.widget.ForwardingListener
            public ShowableListMenu getPopup() {
                return ActivityChooserView.this.getListPopupWindow();
            }

            @Override // android.support.v7.widget.ForwardingListener
            protected boolean onForwardingStarted() {
                ActivityChooserView.this.showPopup();
                return true;
            }

            @Override // android.support.v7.widget.ForwardingListener
            protected boolean onForwardingStopped() {
                ActivityChooserView.this.dismissPopup();
                return true;
            }
        });
        this.f2577e = frameLayout2;
        this.f2578f = (ImageView) frameLayout2.findViewById(R.id.image);
        this.f2578f.setImageDrawable(drawable);
        this.f2573a = new ActivityChooserViewAdapter();
        this.f2573a.registerDataSetObserver(new DataSetObserver() { // from class: android.support.v7.widget.ActivityChooserView.5
            AnonymousClass5() {
            }

            @Override // android.database.DataSetObserver
            public void onChanged() {
                super.onChanged();
                ActivityChooserView.this.a();
            }
        });
        Resources resources = context.getResources();
        this.i = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
    }

    void a() {
        if (this.f2573a.getCount() > 0) {
            this.f2577e.setEnabled(true);
        } else {
            this.f2577e.setEnabled(false);
        }
        int activityCount = this.f2573a.getActivityCount();
        int historySize = this.f2573a.getHistorySize();
        if (activityCount != 1 && (activityCount <= 1 || historySize <= 0)) {
            this.f2579g.setVisibility(8);
        } else {
            this.f2579g.setVisibility(0);
            ResolveInfo defaultActivity = this.f2573a.getDefaultActivity();
            PackageManager packageManager = getContext().getPackageManager();
            this.f2580h.setImageDrawable(defaultActivity.loadIcon(packageManager));
            if (this.r != 0) {
                this.f2579g.setContentDescription(getContext().getString(this.r, defaultActivity.loadLabel(packageManager)));
            }
        }
        if (this.f2579g.getVisibility() == 0) {
            this.f2575c.setBackgroundDrawable(this.f2576d);
        } else {
            this.f2575c.setBackgroundDrawable(null);
        }
    }
}
