package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.PopupWindowCompat;
import android.support.v7.appcompat.R;
import android.support.v7.view.menu.ShowableListMenu;
import android.support.v7.widget.ActivityChooserView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class ListPopupWindow implements ShowableListMenu {
    public static final int INPUT_METHOD_FROM_FOCUSABLE = 0;
    public static final int INPUT_METHOD_NEEDED = 1;
    public static final int INPUT_METHOD_NOT_NEEDED = 2;
    public static final int MATCH_PARENT = -1;
    public static final int POSITION_PROMPT_ABOVE = 0;
    public static final int POSITION_PROMPT_BELOW = 1;
    public static final int WRAP_CONTENT = -2;

    /* renamed from: a, reason: collision with root package name */
    private static Method f2842a;

    /* renamed from: b, reason: collision with root package name */
    private static Method f2843b;

    /* renamed from: c, reason: collision with root package name */
    private static Method f2844c;
    final ResizePopupRunnable A;
    private final PopupTouchInterceptor B;
    private final PopupScrollListener C;
    private final ListSelectorHider D;
    private Runnable E;
    final Handler F;
    private final Rect G;
    private Rect H;
    private boolean I;
    PopupWindow J;

    /* renamed from: d, reason: collision with root package name */
    private Context f2845d;

    /* renamed from: e, reason: collision with root package name */
    private ListAdapter f2846e;

    /* renamed from: f, reason: collision with root package name */
    DropDownListView f2847f;

    /* renamed from: g, reason: collision with root package name */
    private int f2848g;

    /* renamed from: h, reason: collision with root package name */
    private int f2849h;
    private int i;
    private int j;
    private int k;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private int p;
    private boolean q;
    private boolean r;
    int s;
    private View t;
    private int u;
    private DataSetObserver v;
    private View w;
    private Drawable x;
    private AdapterView.OnItemClickListener y;
    private AdapterView.OnItemSelectedListener z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class ListSelectorHider implements Runnable {
        ListSelectorHider() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ListPopupWindow.this.clearListSelection();
        }
    }

    /* loaded from: classes.dex */
    private class PopupDataSetObserver extends DataSetObserver {
        PopupDataSetObserver() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            if (ListPopupWindow.this.isShowing()) {
                ListPopupWindow.this.show();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ListPopupWindow.this.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class PopupScrollListener implements AbsListView.OnScrollListener {
        PopupScrollListener() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i != 1 || ListPopupWindow.this.isInputMethodNotNeeded() || ListPopupWindow.this.J.getContentView() == null) {
                return;
            }
            ListPopupWindow listPopupWindow = ListPopupWindow.this;
            listPopupWindow.F.removeCallbacks(listPopupWindow.A);
            ListPopupWindow.this.A.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class PopupTouchInterceptor implements View.OnTouchListener {
        PopupTouchInterceptor() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            PopupWindow popupWindow;
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && (popupWindow = ListPopupWindow.this.J) != null && popupWindow.isShowing() && x >= 0 && x < ListPopupWindow.this.J.getWidth() && y >= 0 && y < ListPopupWindow.this.J.getHeight()) {
                ListPopupWindow listPopupWindow = ListPopupWindow.this;
                listPopupWindow.F.postDelayed(listPopupWindow.A, 250L);
                return false;
            }
            if (action != 1) {
                return false;
            }
            ListPopupWindow listPopupWindow2 = ListPopupWindow.this;
            listPopupWindow2.F.removeCallbacks(listPopupWindow2.A);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class ResizePopupRunnable implements Runnable {
        ResizePopupRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DropDownListView dropDownListView = ListPopupWindow.this.f2847f;
            if (dropDownListView == null || !ViewCompat.isAttachedToWindow(dropDownListView) || ListPopupWindow.this.f2847f.getCount() <= ListPopupWindow.this.f2847f.getChildCount()) {
                return;
            }
            int childCount = ListPopupWindow.this.f2847f.getChildCount();
            ListPopupWindow listPopupWindow = ListPopupWindow.this;
            if (childCount <= listPopupWindow.s) {
                listPopupWindow.J.setInputMethodMode(2);
                ListPopupWindow.this.show();
            }
        }
    }

    static {
        try {
            f2842a = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
        } catch (NoSuchMethodException unused) {
            Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
        }
        try {
            f2843b = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", View.class, Integer.TYPE, Boolean.TYPE);
        } catch (NoSuchMethodException unused2) {
            Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
        }
        try {
            f2844c = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
        } catch (NoSuchMethodException unused3) {
            Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
        }
    }

    public ListPopupWindow(Context context) {
        this(context, null, R.attr.listPopupWindowStyle);
    }

    private static boolean a(int i) {
        return i == 66 || i == 23;
    }

    private void b() {
        View view = this.t;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.t);
            }
        }
    }

    DropDownListView a(Context context, boolean z) {
        return new DropDownListView(context, z);
    }

    public void clearListSelection() {
        DropDownListView dropDownListView = this.f2847f;
        if (dropDownListView != null) {
            dropDownListView.setListSelectionHidden(true);
            dropDownListView.requestLayout();
        }
    }

    public View.OnTouchListener createDragToOpenListener(View view) {
        return new ForwardingListener(view) { // from class: android.support.v7.widget.ListPopupWindow.1
            @Override // android.support.v7.widget.ForwardingListener
            public ListPopupWindow getPopup() {
                return ListPopupWindow.this;
            }
        };
    }

    @Override // android.support.v7.view.menu.ShowableListMenu
    public void dismiss() {
        this.J.dismiss();
        b();
        this.J.setContentView(null);
        this.f2847f = null;
        this.F.removeCallbacks(this.A);
    }

    public View getAnchorView() {
        return this.w;
    }

    public int getAnimationStyle() {
        return this.J.getAnimationStyle();
    }

    public Drawable getBackground() {
        return this.J.getBackground();
    }

    public int getHeight() {
        return this.f2848g;
    }

    public int getHorizontalOffset() {
        return this.i;
    }

    public int getInputMethodMode() {
        return this.J.getInputMethodMode();
    }

    @Override // android.support.v7.view.menu.ShowableListMenu
    public ListView getListView() {
        return this.f2847f;
    }

    public int getPromptPosition() {
        return this.u;
    }

    public Object getSelectedItem() {
        if (isShowing()) {
            return this.f2847f.getSelectedItem();
        }
        return null;
    }

    public long getSelectedItemId() {
        if (isShowing()) {
            return this.f2847f.getSelectedItemId();
        }
        return Long.MIN_VALUE;
    }

    public int getSelectedItemPosition() {
        if (isShowing()) {
            return this.f2847f.getSelectedItemPosition();
        }
        return -1;
    }

    public View getSelectedView() {
        if (isShowing()) {
            return this.f2847f.getSelectedView();
        }
        return null;
    }

    public int getSoftInputMode() {
        return this.J.getSoftInputMode();
    }

    public int getVerticalOffset() {
        if (this.l) {
            return this.j;
        }
        return 0;
    }

    public int getWidth() {
        return this.f2849h;
    }

    public boolean isDropDownAlwaysVisible() {
        return this.q;
    }

    public boolean isInputMethodNotNeeded() {
        return this.J.getInputMethodMode() == 2;
    }

    public boolean isModal() {
        return this.I;
    }

    @Override // android.support.v7.view.menu.ShowableListMenu
    public boolean isShowing() {
        return this.J.isShowing();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        int i2;
        if (isShowing() && i != 62 && (this.f2847f.getSelectedItemPosition() >= 0 || !a(i))) {
            int selectedItemPosition = this.f2847f.getSelectedItemPosition();
            boolean z = !this.J.isAboveAnchor();
            ListAdapter listAdapter = this.f2846e;
            int i3 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            if (listAdapter != null) {
                boolean areAllItemsEnabled = listAdapter.areAllItemsEnabled();
                int lookForSelectablePosition = areAllItemsEnabled ? 0 : this.f2847f.lookForSelectablePosition(0, true);
                if (areAllItemsEnabled) {
                    i2 = listAdapter.getCount() - 1;
                } else {
                    i2 = this.f2847f.lookForSelectablePosition(listAdapter.getCount() - 1, false);
                }
                i3 = lookForSelectablePosition;
            } else {
                i2 = Integer.MIN_VALUE;
            }
            if ((z && i == 19 && selectedItemPosition <= i3) || (!z && i == 20 && selectedItemPosition >= i2)) {
                clearListSelection();
                this.J.setInputMethodMode(1);
                show();
                return true;
            }
            this.f2847f.setListSelectionHidden(false);
            if (this.f2847f.onKeyDown(i, keyEvent)) {
                this.J.setInputMethodMode(2);
                this.f2847f.requestFocusFromTouch();
                show();
                if (i == 19 || i == 20 || i == 23 || i == 66) {
                    return true;
                }
            } else if (z && i == 20) {
                if (selectedItemPosition == i2) {
                    return true;
                }
            } else if (!z && i == 19 && selectedItemPosition == i3) {
                return true;
            }
        }
        return false;
    }

    public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        if (i != 4 || !isShowing()) {
            return false;
        }
        View view = this.w;
        if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
            KeyEvent.DispatcherState keyDispatcherState = view.getKeyDispatcherState();
            if (keyDispatcherState != null) {
                keyDispatcherState.startTracking(keyEvent, this);
            }
            return true;
        }
        if (keyEvent.getAction() != 1) {
            return false;
        }
        KeyEvent.DispatcherState keyDispatcherState2 = view.getKeyDispatcherState();
        if (keyDispatcherState2 != null) {
            keyDispatcherState2.handleUpEvent(keyEvent);
        }
        if (!keyEvent.isTracking() || keyEvent.isCanceled()) {
            return false;
        }
        dismiss();
        return true;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (!isShowing() || this.f2847f.getSelectedItemPosition() < 0) {
            return false;
        }
        boolean onKeyUp = this.f2847f.onKeyUp(i, keyEvent);
        if (onKeyUp && a(i)) {
            dismiss();
        }
        return onKeyUp;
    }

    public boolean performItemClick(int i) {
        if (!isShowing()) {
            return false;
        }
        if (this.y == null) {
            return true;
        }
        DropDownListView dropDownListView = this.f2847f;
        this.y.onItemClick(dropDownListView, dropDownListView.getChildAt(i - dropDownListView.getFirstVisiblePosition()), i, dropDownListView.getAdapter().getItemId(i));
        return true;
    }

    public void postShow() {
        this.F.post(this.E);
    }

    public void setAdapter(ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.v;
        if (dataSetObserver == null) {
            this.v = new PopupDataSetObserver();
        } else {
            ListAdapter listAdapter2 = this.f2846e;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f2846e = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.v);
        }
        DropDownListView dropDownListView = this.f2847f;
        if (dropDownListView != null) {
            dropDownListView.setAdapter(this.f2846e);
        }
    }

    public void setAnchorView(View view) {
        this.w = view;
    }

    public void setAnimationStyle(int i) {
        this.J.setAnimationStyle(i);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        this.J.setBackgroundDrawable(drawable);
    }

    public void setContentWidth(int i) {
        Drawable background = this.J.getBackground();
        if (background != null) {
            background.getPadding(this.G);
            Rect rect = this.G;
            this.f2849h = rect.left + rect.right + i;
            return;
        }
        setWidth(i);
    }

    public void setDropDownAlwaysVisible(boolean z) {
        this.q = z;
    }

    public void setDropDownGravity(int i) {
        this.p = i;
    }

    public void setEpicenterBounds(Rect rect) {
        this.H = rect;
    }

    public void setForceIgnoreOutsideTouch(boolean z) {
        this.r = z;
    }

    public void setHeight(int i) {
        if (i < 0 && -2 != i && -1 != i) {
            throw new IllegalArgumentException("Invalid height. Must be a positive value, MATCH_PARENT, or WRAP_CONTENT.");
        }
        this.f2848g = i;
    }

    public void setHorizontalOffset(int i) {
        this.i = i;
    }

    public void setInputMethodMode(int i) {
        this.J.setInputMethodMode(i);
    }

    public void setListSelector(Drawable drawable) {
        this.x = drawable;
    }

    public void setModal(boolean z) {
        this.I = z;
        this.J.setFocusable(z);
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.J.setOnDismissListener(onDismissListener);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.y = onItemClickListener;
    }

    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.z = onItemSelectedListener;
    }

    public void setOverlapAnchor(boolean z) {
        this.o = true;
        this.n = z;
    }

    public void setPromptPosition(int i) {
        this.u = i;
    }

    public void setPromptView(View view) {
        boolean isShowing = isShowing();
        if (isShowing) {
            b();
        }
        this.t = view;
        if (isShowing) {
            show();
        }
    }

    public void setSelection(int i) {
        DropDownListView dropDownListView = this.f2847f;
        if (!isShowing() || dropDownListView == null) {
            return;
        }
        dropDownListView.setListSelectionHidden(false);
        dropDownListView.setSelection(i);
        if (dropDownListView.getChoiceMode() != 0) {
            dropDownListView.setItemChecked(i, true);
        }
    }

    public void setSoftInputMode(int i) {
        this.J.setSoftInputMode(i);
    }

    public void setVerticalOffset(int i) {
        this.j = i;
        this.l = true;
    }

    public void setWidth(int i) {
        this.f2849h = i;
    }

    public void setWindowLayoutType(int i) {
        this.k = i;
    }

    @Override // android.support.v7.view.menu.ShowableListMenu
    public void show() {
        int a2 = a();
        boolean isInputMethodNotNeeded = isInputMethodNotNeeded();
        PopupWindowCompat.setWindowLayoutType(this.J, this.k);
        if (this.J.isShowing()) {
            if (ViewCompat.isAttachedToWindow(getAnchorView())) {
                int i = this.f2849h;
                if (i == -1) {
                    i = -1;
                } else if (i == -2) {
                    i = getAnchorView().getWidth();
                }
                int i2 = this.f2848g;
                if (i2 == -1) {
                    if (!isInputMethodNotNeeded) {
                        a2 = -1;
                    }
                    if (isInputMethodNotNeeded) {
                        this.J.setWidth(this.f2849h == -1 ? -1 : 0);
                        this.J.setHeight(0);
                    } else {
                        this.J.setWidth(this.f2849h == -1 ? -1 : 0);
                        this.J.setHeight(-1);
                    }
                } else if (i2 != -2) {
                    a2 = i2;
                }
                this.J.setOutsideTouchable((this.r || this.q) ? false : true);
                this.J.update(getAnchorView(), this.i, this.j, i < 0 ? -1 : i, a2 < 0 ? -1 : a2);
                return;
            }
            return;
        }
        int i3 = this.f2849h;
        if (i3 == -1) {
            i3 = -1;
        } else if (i3 == -2) {
            i3 = getAnchorView().getWidth();
        }
        int i4 = this.f2848g;
        if (i4 == -1) {
            a2 = -1;
        } else if (i4 != -2) {
            a2 = i4;
        }
        this.J.setWidth(i3);
        this.J.setHeight(a2);
        a(true);
        this.J.setOutsideTouchable((this.r || this.q) ? false : true);
        this.J.setTouchInterceptor(this.B);
        if (this.o) {
            PopupWindowCompat.setOverlapAnchor(this.J, this.n);
        }
        Method method = f2844c;
        if (method != null) {
            try {
                method.invoke(this.J, this.H);
            } catch (Exception e2) {
                Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e2);
            }
        }
        PopupWindowCompat.showAsDropDown(this.J, getAnchorView(), this.i, this.j, this.p);
        this.f2847f.setSelection(-1);
        if (!this.I || this.f2847f.isInTouchMode()) {
            clearListSelection();
        }
        if (this.I) {
            return;
        }
        this.F.post(this.D);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listPopupWindowStyle);
    }

    private int a() {
        int i;
        int i2;
        int makeMeasureSpec;
        int i3;
        if (this.f2847f == null) {
            Context context = this.f2845d;
            this.E = new Runnable() { // from class: android.support.v7.widget.ListPopupWindow.2
                @Override // java.lang.Runnable
                public void run() {
                    View anchorView = ListPopupWindow.this.getAnchorView();
                    if (anchorView == null || anchorView.getWindowToken() == null) {
                        return;
                    }
                    ListPopupWindow.this.show();
                }
            };
            this.f2847f = a(context, !this.I);
            Drawable drawable = this.x;
            if (drawable != null) {
                this.f2847f.setSelector(drawable);
            }
            this.f2847f.setAdapter(this.f2846e);
            this.f2847f.setOnItemClickListener(this.y);
            this.f2847f.setFocusable(true);
            this.f2847f.setFocusableInTouchMode(true);
            this.f2847f.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: android.support.v7.widget.ListPopupWindow.3
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> adapterView, View view, int i4, long j) {
                    DropDownListView dropDownListView;
                    if (i4 == -1 || (dropDownListView = ListPopupWindow.this.f2847f) == null) {
                        return;
                    }
                    dropDownListView.setListSelectionHidden(false);
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            this.f2847f.setOnScrollListener(this.C);
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.z;
            if (onItemSelectedListener != null) {
                this.f2847f.setOnItemSelectedListener(onItemSelectedListener);
            }
            View view = this.f2847f;
            View view2 = this.t;
            if (view2 != null) {
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
                int i4 = this.u;
                if (i4 == 0) {
                    linearLayout.addView(view2);
                    linearLayout.addView(view, layoutParams);
                } else if (i4 != 1) {
                    Log.e("ListPopupWindow", "Invalid hint position " + this.u);
                } else {
                    linearLayout.addView(view, layoutParams);
                    linearLayout.addView(view2);
                }
                int i5 = this.f2849h;
                if (i5 >= 0) {
                    i3 = Integer.MIN_VALUE;
                } else {
                    i5 = 0;
                    i3 = 0;
                }
                view2.measure(View.MeasureSpec.makeMeasureSpec(i5, i3), 0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                i = view2.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin;
                view = linearLayout;
            } else {
                i = 0;
            }
            this.J.setContentView(view);
        } else {
            View view3 = this.t;
            if (view3 != null) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view3.getLayoutParams();
                i = view3.getMeasuredHeight() + layoutParams3.topMargin + layoutParams3.bottomMargin;
            } else {
                i = 0;
            }
        }
        Drawable background = this.J.getBackground();
        if (background != null) {
            background.getPadding(this.G);
            Rect rect = this.G;
            int i6 = rect.top;
            i2 = rect.bottom + i6;
            if (!this.l) {
                this.j = -i6;
            }
        } else {
            this.G.setEmpty();
            i2 = 0;
        }
        int a2 = a(getAnchorView(), this.j, this.J.getInputMethodMode() == 2);
        if (this.q || this.f2848g == -1) {
            return a2 + i2;
        }
        int i7 = this.f2849h;
        if (i7 == -2) {
            int i8 = this.f2845d.getResources().getDisplayMetrics().widthPixels;
            Rect rect2 = this.G;
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i8 - (rect2.left + rect2.right), Integer.MIN_VALUE);
        } else if (i7 != -1) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i7, 1073741824);
        } else {
            int i9 = this.f2845d.getResources().getDisplayMetrics().widthPixels;
            Rect rect3 = this.G;
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i9 - (rect3.left + rect3.right), 1073741824);
        }
        int measureHeightOfChildrenCompat = this.f2847f.measureHeightOfChildrenCompat(makeMeasureSpec, 0, -1, a2 - i, -1);
        if (measureHeightOfChildrenCompat > 0) {
            i += i2 + this.f2847f.getPaddingTop() + this.f2847f.getPaddingBottom();
        }
        return measureHeightOfChildrenCompat + i;
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i, int i2) {
        this.f2848g = -2;
        this.f2849h = -2;
        this.k = 1002;
        this.m = true;
        this.p = 0;
        this.q = false;
        this.r = false;
        this.s = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.u = 0;
        this.A = new ResizePopupRunnable();
        this.B = new PopupTouchInterceptor();
        this.C = new PopupScrollListener();
        this.D = new ListSelectorHider();
        this.G = new Rect();
        this.f2845d = context;
        this.F = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ListPopupWindow, i, i2);
        this.i = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        this.j = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownVerticalOffset, 0);
        if (this.j != 0) {
            this.l = true;
        }
        obtainStyledAttributes.recycle();
        this.J = new AppCompatPopupWindow(context, attributeSet, i, i2);
        this.J.setInputMethodMode(1);
    }

    private void a(boolean z) {
        Method method = f2842a;
        if (method != null) {
            try {
                method.invoke(this.J, Boolean.valueOf(z));
            } catch (Exception unused) {
                Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
        }
    }

    private int a(View view, int i, boolean z) {
        Method method = f2843b;
        if (method != null) {
            try {
                return ((Integer) method.invoke(this.J, view, Integer.valueOf(i), Boolean.valueOf(z))).intValue();
            } catch (Exception unused) {
                Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
            }
        }
        return this.J.getMaxAvailableHeight(view, i);
    }
}
