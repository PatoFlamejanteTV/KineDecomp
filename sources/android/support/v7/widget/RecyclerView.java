package android.support.v7.widget;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.os.TraceCompat;
import android.support.v4.util.Preconditions;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.NestedScrollingChild2;
import android.support.v4.view.NestedScrollingChildHelper;
import android.support.v4.view.ScrollingView;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v7.widget.ActivityChooserView;
import android.support.v7.widget.AdapterHelper;
import android.support.v7.widget.ChildHelper;
import android.support.v7.widget.GapWorker;
import android.support.v7.widget.ViewBoundsCheck;
import android.support.v7.widget.ViewInfoStore;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import com.google.protos.datapol.SemanticAnnotations;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class RecyclerView extends ViewGroup implements ScrollingView, NestedScrollingChild2 {
    public static final int HORIZONTAL = 0;
    public static final int INVALID_TYPE = -1;
    public static final long NO_ID = -1;
    public static final int NO_POSITION = -1;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    public static final int TOUCH_SLOP_DEFAULT = 0;
    public static final int TOUCH_SLOP_PAGING = 1;
    public static final int VERTICAL = 1;

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f2881a = {R.attr.nestedScrollingEnabled};

    /* renamed from: b, reason: collision with root package name */
    private static final int[] f2882b = {R.attr.clipToPadding};

    /* renamed from: c, reason: collision with root package name */
    static final boolean f2883c;

    /* renamed from: d, reason: collision with root package name */
    static final boolean f2884d;

    /* renamed from: e, reason: collision with root package name */
    static final boolean f2885e;

    /* renamed from: f, reason: collision with root package name */
    private static final boolean f2886f;

    /* renamed from: g, reason: collision with root package name */
    private static final boolean f2887g;

    /* renamed from: h, reason: collision with root package name */
    private static final boolean f2888h;
    private static final Class<?>[] i;
    static final Interpolator j;
    private OnItemTouchListener A;
    private final int[] Aa;
    boolean B;
    private NestedScrollingChildHelper Ba;
    boolean C;
    private final int[] Ca;
    boolean D;
    private final int[] Da;
    boolean E;
    private final int[] Ea;
    private int F;
    final List<ViewHolder> Fa;
    boolean G;
    private Runnable Ga;
    boolean H;
    private final ViewInfoStore.ProcessCallback Ha;
    private boolean I;
    private int J;
    boolean K;
    private final AccessibilityManager L;
    private List<OnChildAttachStateChangeListener> M;
    boolean N;
    boolean O;
    private int P;
    private int Q;
    private EdgeEffectFactory R;
    private EdgeEffect S;
    private EdgeEffect T;
    private EdgeEffect U;
    private EdgeEffect V;
    ItemAnimator W;
    private int aa;
    private int ba;
    private VelocityTracker ca;
    private int da;
    private int ea;
    private int fa;
    private int ga;
    private int ha;
    private OnFlingListener ia;
    private final int ja;
    private final RecyclerViewDataObserver k;
    private final int ka;
    final Recycler l;
    private float la;
    private SavedState m;
    private float ma;
    AdapterHelper n;
    private boolean na;
    ChildHelper o;
    final ViewFlinger oa;
    final ViewInfoStore p;
    GapWorker pa;
    boolean q;
    GapWorker.LayoutPrefetchRegistryImpl qa;
    final Runnable r;
    final State ra;
    final Rect s;
    private OnScrollListener sa;
    private final Rect t;
    private List<OnScrollListener> ta;
    final RectF u;
    boolean ua;
    Adapter v;
    boolean va;
    LayoutManager w;
    private ItemAnimator.ItemAnimatorListener wa;
    RecyclerListener x;
    boolean xa;
    final ArrayList<ItemDecoration> y;
    RecyclerViewAccessibilityDelegate ya;
    private final ArrayList<OnItemTouchListener> z;
    private ChildDrawingOrderCallback za;

    /* loaded from: classes.dex */
    public static abstract class Adapter<VH extends ViewHolder> {

        /* renamed from: a, reason: collision with root package name */
        private final AdapterDataObservable f2894a = new AdapterDataObservable();

        /* renamed from: b, reason: collision with root package name */
        private boolean f2895b = false;

        public final void bindViewHolder(VH vh, int i) {
            vh.f2964c = i;
            if (hasStableIds()) {
                vh.f2966e = getItemId(i);
            }
            vh.a(1, 519);
            TraceCompat.beginSection("RV OnBindView");
            onBindViewHolder(vh, i, vh.e());
            vh.b();
            ViewGroup.LayoutParams layoutParams = vh.itemView.getLayoutParams();
            if (layoutParams instanceof LayoutParams) {
                ((LayoutParams) layoutParams).f2915c = true;
            }
            TraceCompat.endSection();
        }

        public final VH createViewHolder(ViewGroup viewGroup, int i) {
            try {
                TraceCompat.beginSection("RV CreateView");
                VH onCreateViewHolder = onCreateViewHolder(viewGroup, i);
                if (onCreateViewHolder.itemView.getParent() == null) {
                    onCreateViewHolder.f2967f = i;
                    return onCreateViewHolder;
                }
                throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
            } finally {
                TraceCompat.endSection();
            }
        }

        public abstract int getItemCount();

        public long getItemId(int i) {
            return -1L;
        }

        public int getItemViewType(int i) {
            return 0;
        }

        public final boolean hasObservers() {
            return this.f2894a.hasObservers();
        }

        public final boolean hasStableIds() {
            return this.f2895b;
        }

        public final void notifyDataSetChanged() {
            this.f2894a.notifyChanged();
        }

        public final void notifyItemChanged(int i) {
            this.f2894a.notifyItemRangeChanged(i, 1);
        }

        public final void notifyItemInserted(int i) {
            this.f2894a.notifyItemRangeInserted(i, 1);
        }

        public final void notifyItemMoved(int i, int i2) {
            this.f2894a.notifyItemMoved(i, i2);
        }

        public final void notifyItemRangeChanged(int i, int i2) {
            this.f2894a.notifyItemRangeChanged(i, i2);
        }

        public final void notifyItemRangeInserted(int i, int i2) {
            this.f2894a.notifyItemRangeInserted(i, i2);
        }

        public final void notifyItemRangeRemoved(int i, int i2) {
            this.f2894a.notifyItemRangeRemoved(i, i2);
        }

        public final void notifyItemRemoved(int i) {
            this.f2894a.notifyItemRangeRemoved(i, 1);
        }

        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        }

        public abstract void onBindViewHolder(VH vh, int i);

        public void onBindViewHolder(VH vh, int i, List<Object> list) {
            onBindViewHolder(vh, i);
        }

        public abstract VH onCreateViewHolder(ViewGroup viewGroup, int i);

        public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        }

        public boolean onFailedToRecycleView(VH vh) {
            return false;
        }

        public void onViewAttachedToWindow(VH vh) {
        }

        public void onViewDetachedFromWindow(VH vh) {
        }

        public void onViewRecycled(VH vh) {
        }

        public void registerAdapterDataObserver(AdapterDataObserver adapterDataObserver) {
            this.f2894a.registerObserver(adapterDataObserver);
        }

        public void setHasStableIds(boolean z) {
            if (!hasObservers()) {
                this.f2895b = z;
                return;
            }
            throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
        }

        public void unregisterAdapterDataObserver(AdapterDataObserver adapterDataObserver) {
            this.f2894a.unregisterObserver(adapterDataObserver);
        }

        public final void notifyItemChanged(int i, Object obj) {
            this.f2894a.notifyItemRangeChanged(i, 1, obj);
        }

        public final void notifyItemRangeChanged(int i, int i2, Object obj) {
            this.f2894a.notifyItemRangeChanged(i, i2, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class AdapterDataObservable extends Observable<AdapterDataObserver> {
        AdapterDataObservable() {
        }

        public boolean hasObservers() {
            return !((Observable) this).mObservers.isEmpty();
        }

        public void notifyChanged() {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) ((Observable) this).mObservers.get(size)).onChanged();
            }
        }

        public void notifyItemMoved(int i, int i2) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) ((Observable) this).mObservers.get(size)).onItemRangeMoved(i, i2, 1);
            }
        }

        public void notifyItemRangeChanged(int i, int i2) {
            notifyItemRangeChanged(i, i2, null);
        }

        public void notifyItemRangeInserted(int i, int i2) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) ((Observable) this).mObservers.get(size)).onItemRangeInserted(i, i2);
            }
        }

        public void notifyItemRangeRemoved(int i, int i2) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) ((Observable) this).mObservers.get(size)).onItemRangeRemoved(i, i2);
            }
        }

        public void notifyItemRangeChanged(int i, int i2, Object obj) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) ((Observable) this).mObservers.get(size)).onItemRangeChanged(i, i2, obj);
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class AdapterDataObserver {
        public void onChanged() {
        }

        public void onItemRangeChanged(int i, int i2) {
        }

        public void onItemRangeChanged(int i, int i2, Object obj) {
            onItemRangeChanged(i, i2);
        }

        public void onItemRangeInserted(int i, int i2) {
        }

        public void onItemRangeMoved(int i, int i2, int i3) {
        }

        public void onItemRangeRemoved(int i, int i2) {
        }
    }

    /* loaded from: classes.dex */
    public interface ChildDrawingOrderCallback {
        int onGetChildDrawingOrder(int i, int i2);
    }

    /* loaded from: classes.dex */
    public static class EdgeEffectFactory {
        public static final int DIRECTION_BOTTOM = 3;
        public static final int DIRECTION_LEFT = 0;
        public static final int DIRECTION_RIGHT = 2;
        public static final int DIRECTION_TOP = 1;

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes.dex */
        public @interface EdgeDirection {
        }

        protected EdgeEffect a(RecyclerView recyclerView, int i) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    /* loaded from: classes.dex */
    public static abstract class ItemAnimator {
        public static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
        public static final int FLAG_CHANGED = 2;
        public static final int FLAG_INVALIDATED = 4;
        public static final int FLAG_MOVED = 2048;
        public static final int FLAG_REMOVED = 8;

        /* renamed from: a, reason: collision with root package name */
        private ItemAnimatorListener f2896a = null;

        /* renamed from: b, reason: collision with root package name */
        private ArrayList<ItemAnimatorFinishedListener> f2897b = new ArrayList<>();

        /* renamed from: c, reason: collision with root package name */
        private long f2898c = 120;

        /* renamed from: d, reason: collision with root package name */
        private long f2899d = 120;

        /* renamed from: e, reason: collision with root package name */
        private long f2900e = 250;

        /* renamed from: f, reason: collision with root package name */
        private long f2901f = 250;

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes.dex */
        public @interface AdapterChanges {
        }

        /* loaded from: classes.dex */
        public interface ItemAnimatorFinishedListener {
            void onAnimationsFinished();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public interface ItemAnimatorListener {
            void onAnimationFinished(ViewHolder viewHolder);
        }

        /* loaded from: classes.dex */
        public static class ItemHolderInfo {
            public int bottom;
            public int changeFlags;
            public int left;
            public int right;
            public int top;

            public ItemHolderInfo setFrom(ViewHolder viewHolder) {
                return setFrom(viewHolder, 0);
            }

            public ItemHolderInfo setFrom(ViewHolder viewHolder, int i) {
                View view = viewHolder.itemView;
                this.left = view.getLeft();
                this.top = view.getTop();
                this.right = view.getRight();
                this.bottom = view.getBottom();
                return this;
            }
        }

        void a(ItemAnimatorListener itemAnimatorListener) {
            this.f2896a = itemAnimatorListener;
        }

        public abstract boolean animateAppearance(ViewHolder viewHolder, ItemHolderInfo itemHolderInfo, ItemHolderInfo itemHolderInfo2);

        public abstract boolean animateChange(ViewHolder viewHolder, ViewHolder viewHolder2, ItemHolderInfo itemHolderInfo, ItemHolderInfo itemHolderInfo2);

        public abstract boolean animateDisappearance(ViewHolder viewHolder, ItemHolderInfo itemHolderInfo, ItemHolderInfo itemHolderInfo2);

        public abstract boolean animatePersistence(ViewHolder viewHolder, ItemHolderInfo itemHolderInfo, ItemHolderInfo itemHolderInfo2);

        public boolean canReuseUpdatedViewHolder(ViewHolder viewHolder) {
            return true;
        }

        public boolean canReuseUpdatedViewHolder(ViewHolder viewHolder, List<Object> list) {
            return canReuseUpdatedViewHolder(viewHolder);
        }

        public final void dispatchAnimationFinished(ViewHolder viewHolder) {
            onAnimationFinished(viewHolder);
            ItemAnimatorListener itemAnimatorListener = this.f2896a;
            if (itemAnimatorListener != null) {
                itemAnimatorListener.onAnimationFinished(viewHolder);
            }
        }

        public final void dispatchAnimationStarted(ViewHolder viewHolder) {
            onAnimationStarted(viewHolder);
        }

        public final void dispatchAnimationsFinished() {
            int size = this.f2897b.size();
            for (int i = 0; i < size; i++) {
                this.f2897b.get(i).onAnimationsFinished();
            }
            this.f2897b.clear();
        }

        public abstract void endAnimation(ViewHolder viewHolder);

        public abstract void endAnimations();

        public long getAddDuration() {
            return this.f2898c;
        }

        public long getChangeDuration() {
            return this.f2901f;
        }

        public long getMoveDuration() {
            return this.f2900e;
        }

        public long getRemoveDuration() {
            return this.f2899d;
        }

        public abstract boolean isRunning();

        public final boolean isRunning(ItemAnimatorFinishedListener itemAnimatorFinishedListener) {
            boolean isRunning = isRunning();
            if (itemAnimatorFinishedListener != null) {
                if (!isRunning) {
                    itemAnimatorFinishedListener.onAnimationsFinished();
                } else {
                    this.f2897b.add(itemAnimatorFinishedListener);
                }
            }
            return isRunning;
        }

        public ItemHolderInfo obtainHolderInfo() {
            return new ItemHolderInfo();
        }

        public void onAnimationFinished(ViewHolder viewHolder) {
        }

        public void onAnimationStarted(ViewHolder viewHolder) {
        }

        public ItemHolderInfo recordPostLayoutInformation(State state, ViewHolder viewHolder) {
            return obtainHolderInfo().setFrom(viewHolder);
        }

        public ItemHolderInfo recordPreLayoutInformation(State state, ViewHolder viewHolder, int i, List<Object> list) {
            return obtainHolderInfo().setFrom(viewHolder);
        }

        public abstract void runPendingAnimations();

        public void setAddDuration(long j) {
            this.f2898c = j;
        }

        public void setChangeDuration(long j) {
            this.f2901f = j;
        }

        public void setMoveDuration(long j) {
            this.f2900e = j;
        }

        public void setRemoveDuration(long j) {
            this.f2899d = j;
        }

        static int a(ViewHolder viewHolder) {
            int i = viewHolder.j & 14;
            if (viewHolder.h()) {
                return 4;
            }
            if ((i & 4) != 0) {
                return i;
            }
            int oldPosition = viewHolder.getOldPosition();
            int adapterPosition = viewHolder.getAdapterPosition();
            return (oldPosition == -1 || adapterPosition == -1 || oldPosition == adapterPosition) ? i : i | 2048;
        }
    }

    /* loaded from: classes.dex */
    private class ItemAnimatorRestoreListener implements ItemAnimator.ItemAnimatorListener {
        ItemAnimatorRestoreListener() {
        }

        @Override // android.support.v7.widget.RecyclerView.ItemAnimator.ItemAnimatorListener
        public void onAnimationFinished(ViewHolder viewHolder) {
            viewHolder.setIsRecyclable(true);
            if (viewHolder.f2969h != null && viewHolder.i == null) {
                viewHolder.f2969h = null;
            }
            viewHolder.i = null;
            if (viewHolder.v() || RecyclerView.this.f(viewHolder.itemView) || !viewHolder.k()) {
                return;
            }
            RecyclerView.this.removeDetachedView(viewHolder.itemView, false);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class ItemDecoration {
        @Deprecated
        public void getItemOffsets(Rect rect, int i, RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        @Deprecated
        public void onDraw(Canvas canvas, RecyclerView recyclerView) {
        }

        public void onDraw(Canvas canvas, RecyclerView recyclerView, State state) {
            onDraw(canvas, recyclerView);
        }

        @Deprecated
        public void onDrawOver(Canvas canvas, RecyclerView recyclerView) {
        }

        public void onDrawOver(Canvas canvas, RecyclerView recyclerView, State state) {
            onDrawOver(canvas, recyclerView);
        }

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, State state) {
            getItemOffsets(rect, ((LayoutParams) view.getLayoutParams()).getViewLayoutPosition(), recyclerView);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class LayoutManager {

        /* renamed from: a, reason: collision with root package name */
        ChildHelper f2903a;

        /* renamed from: b, reason: collision with root package name */
        RecyclerView f2904b;

        /* renamed from: g, reason: collision with root package name */
        SmoothScroller f2909g;
        int m;
        boolean n;
        private int o;
        private int p;
        private int q;
        private int r;

        /* renamed from: c, reason: collision with root package name */
        private final ViewBoundsCheck.Callback f2905c = new ViewBoundsCheck.Callback() { // from class: android.support.v7.widget.RecyclerView.LayoutManager.1
            @Override // android.support.v7.widget.ViewBoundsCheck.Callback
            public View getChildAt(int i) {
                return LayoutManager.this.getChildAt(i);
            }

            @Override // android.support.v7.widget.ViewBoundsCheck.Callback
            public int getChildCount() {
                return LayoutManager.this.getChildCount();
            }

            @Override // android.support.v7.widget.ViewBoundsCheck.Callback
            public int getChildEnd(View view) {
                return LayoutManager.this.getDecoratedRight(view) + ((ViewGroup.MarginLayoutParams) ((LayoutParams) view.getLayoutParams())).rightMargin;
            }

            @Override // android.support.v7.widget.ViewBoundsCheck.Callback
            public int getChildStart(View view) {
                return LayoutManager.this.getDecoratedLeft(view) - ((ViewGroup.MarginLayoutParams) ((LayoutParams) view.getLayoutParams())).leftMargin;
            }

            @Override // android.support.v7.widget.ViewBoundsCheck.Callback
            public View getParent() {
                return LayoutManager.this.f2904b;
            }

            @Override // android.support.v7.widget.ViewBoundsCheck.Callback
            public int getParentEnd() {
                return LayoutManager.this.getWidth() - LayoutManager.this.getPaddingRight();
            }

            @Override // android.support.v7.widget.ViewBoundsCheck.Callback
            public int getParentStart() {
                return LayoutManager.this.getPaddingLeft();
            }
        };

        /* renamed from: d, reason: collision with root package name */
        private final ViewBoundsCheck.Callback f2906d = new ViewBoundsCheck.Callback() { // from class: android.support.v7.widget.RecyclerView.LayoutManager.2
            @Override // android.support.v7.widget.ViewBoundsCheck.Callback
            public View getChildAt(int i) {
                return LayoutManager.this.getChildAt(i);
            }

            @Override // android.support.v7.widget.ViewBoundsCheck.Callback
            public int getChildCount() {
                return LayoutManager.this.getChildCount();
            }

            @Override // android.support.v7.widget.ViewBoundsCheck.Callback
            public int getChildEnd(View view) {
                return LayoutManager.this.getDecoratedBottom(view) + ((ViewGroup.MarginLayoutParams) ((LayoutParams) view.getLayoutParams())).bottomMargin;
            }

            @Override // android.support.v7.widget.ViewBoundsCheck.Callback
            public int getChildStart(View view) {
                return LayoutManager.this.getDecoratedTop(view) - ((ViewGroup.MarginLayoutParams) ((LayoutParams) view.getLayoutParams())).topMargin;
            }

            @Override // android.support.v7.widget.ViewBoundsCheck.Callback
            public View getParent() {
                return LayoutManager.this.f2904b;
            }

            @Override // android.support.v7.widget.ViewBoundsCheck.Callback
            public int getParentEnd() {
                return LayoutManager.this.getHeight() - LayoutManager.this.getPaddingBottom();
            }

            @Override // android.support.v7.widget.ViewBoundsCheck.Callback
            public int getParentStart() {
                return LayoutManager.this.getPaddingTop();
            }
        };

        /* renamed from: e, reason: collision with root package name */
        ViewBoundsCheck f2907e = new ViewBoundsCheck(this.f2905c);

        /* renamed from: f, reason: collision with root package name */
        ViewBoundsCheck f2908f = new ViewBoundsCheck(this.f2906d);

        /* renamed from: h, reason: collision with root package name */
        boolean f2910h = false;
        boolean i = false;
        boolean j = false;
        private boolean k = true;
        private boolean l = true;

        /* loaded from: classes.dex */
        public interface LayoutPrefetchRegistry {
            void addPosition(int i, int i2);
        }

        /* loaded from: classes.dex */
        public static class Properties {
            public int orientation;
            public boolean reverseLayout;
            public int spanCount;
            public boolean stackFromEnd;
        }

        public static int chooseSize(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            if (mode != Integer.MIN_VALUE) {
                return mode != 1073741824 ? Math.max(i2, i3) : size;
            }
            return Math.min(size, Math.max(i2, i3));
        }

        /* JADX WARN: Code restructure failed: missing block: B:3:0x000a, code lost:            if (r3 >= 0) goto L8;     */
        @java.lang.Deprecated
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static int getChildMeasureSpec(int r1, int r2, int r3, boolean r4) {
            /*
                int r1 = r1 - r2
                r2 = 0
                int r1 = java.lang.Math.max(r2, r1)
                r0 = 1073741824(0x40000000, float:2.0)
                if (r4 == 0) goto Lf
                if (r3 < 0) goto Ld
                goto L11
            Ld:
                r1 = 0
                goto L1e
            Lf:
                if (r3 < 0) goto L15
            L11:
                r1 = r3
            L12:
                r2 = 1073741824(0x40000000, float:2.0)
                goto L1e
            L15:
                r4 = -1
                if (r3 != r4) goto L19
                goto L12
            L19:
                r4 = -2
                if (r3 != r4) goto Ld
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
            L1e:
                int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r2)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.RecyclerView.LayoutManager.getChildMeasureSpec(int, int, int, boolean):int");
        }

        public static Properties getProperties(Context context, AttributeSet attributeSet, int i, int i2) {
            Properties properties = new Properties();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, android.support.v7.recyclerview.R.styleable.RecyclerView, i, i2);
            properties.orientation = obtainStyledAttributes.getInt(android.support.v7.recyclerview.R.styleable.RecyclerView_android_orientation, 1);
            properties.spanCount = obtainStyledAttributes.getInt(android.support.v7.recyclerview.R.styleable.RecyclerView_spanCount, 1);
            properties.reverseLayout = obtainStyledAttributes.getBoolean(android.support.v7.recyclerview.R.styleable.RecyclerView_reverseLayout, false);
            properties.stackFromEnd = obtainStyledAttributes.getBoolean(android.support.v7.recyclerview.R.styleable.RecyclerView_stackFromEnd, false);
            obtainStyledAttributes.recycle();
            return properties;
        }

        public void addDisappearingView(View view) {
            addDisappearingView(view, -1);
        }

        public void addView(View view) {
            addView(view, -1);
        }

        public void assertInLayoutOrScroll(String str) {
            RecyclerView recyclerView = this.f2904b;
            if (recyclerView != null) {
                recyclerView.a(str);
            }
        }

        public void assertNotInLayoutOrScroll(String str) {
            RecyclerView recyclerView = this.f2904b;
            if (recyclerView != null) {
                recyclerView.b(str);
            }
        }

        public void attachView(View view, int i, LayoutParams layoutParams) {
            ViewHolder d2 = RecyclerView.d(view);
            if (d2.i()) {
                this.f2904b.p.a(d2);
            } else {
                this.f2904b.p.f(d2);
            }
            this.f2903a.a(view, i, layoutParams, d2.i());
        }

        void b(int i, int i2) {
            int childCount = getChildCount();
            if (childCount == 0) {
                this.f2904b.c(i, i2);
                return;
            }
            int i3 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            int i4 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            int i5 = Integer.MIN_VALUE;
            int i6 = Integer.MIN_VALUE;
            for (int i7 = 0; i7 < childCount; i7++) {
                View childAt = getChildAt(i7);
                Rect rect = this.f2904b.s;
                getDecoratedBoundsWithMargins(childAt, rect);
                int i8 = rect.left;
                if (i8 < i3) {
                    i3 = i8;
                }
                int i9 = rect.right;
                if (i9 > i5) {
                    i5 = i9;
                }
                int i10 = rect.top;
                if (i10 < i4) {
                    i4 = i10;
                }
                int i11 = rect.bottom;
                if (i11 > i6) {
                    i6 = i11;
                }
            }
            this.f2904b.s.set(i3, i4, i5, i6);
            setMeasuredDimension(this.f2904b.s, i, i2);
        }

        boolean b() {
            return false;
        }

        void c(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.f2904b = null;
                this.f2903a = null;
                this.q = 0;
                this.r = 0;
            } else {
                this.f2904b = recyclerView;
                this.f2903a = recyclerView.o;
                this.q = recyclerView.getWidth();
                this.r = recyclerView.getHeight();
            }
            this.o = 1073741824;
            this.p = 1073741824;
        }

        public void calculateItemDecorationsForChild(View view, Rect rect) {
            RecyclerView recyclerView = this.f2904b;
            if (recyclerView == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(recyclerView.e(view));
            }
        }

        public boolean canScrollHorizontally() {
            return false;
        }

        public boolean canScrollVertically() {
            return false;
        }

        public boolean checkLayoutParams(LayoutParams layoutParams) {
            return layoutParams != null;
        }

        public void collectAdjacentPrefetchPositions(int i, int i2, State state, LayoutPrefetchRegistry layoutPrefetchRegistry) {
        }

        public void collectInitialPrefetchPositions(int i, LayoutPrefetchRegistry layoutPrefetchRegistry) {
        }

        public int computeHorizontalScrollExtent(State state) {
            return 0;
        }

        public int computeHorizontalScrollOffset(State state) {
            return 0;
        }

        public int computeHorizontalScrollRange(State state) {
            return 0;
        }

        public int computeVerticalScrollExtent(State state) {
            return 0;
        }

        public int computeVerticalScrollOffset(State state) {
            return 0;
        }

        public int computeVerticalScrollRange(State state) {
            return 0;
        }

        public void detachAndScrapAttachedViews(Recycler recycler) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                a(recycler, childCount, getChildAt(childCount));
            }
        }

        public void detachAndScrapView(View view, Recycler recycler) {
            a(recycler, this.f2903a.b(view), view);
        }

        public void detachAndScrapViewAt(int i, Recycler recycler) {
            a(recycler, i, getChildAt(i));
        }

        public void detachView(View view) {
            int b2 = this.f2903a.b(view);
            if (b2 >= 0) {
                a(b2, view);
            }
        }

        public void detachViewAt(int i) {
            a(i, getChildAt(i));
        }

        public void endAnimation(View view) {
            ItemAnimator itemAnimator = this.f2904b.W;
            if (itemAnimator != null) {
                itemAnimator.endAnimation(RecyclerView.d(view));
            }
        }

        public View findContainingItemView(View view) {
            View findContainingItemView;
            RecyclerView recyclerView = this.f2904b;
            if (recyclerView == null || (findContainingItemView = recyclerView.findContainingItemView(view)) == null || this.f2903a.c(findContainingItemView)) {
                return null;
            }
            return findContainingItemView;
        }

        public View findViewByPosition(int i) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                ViewHolder d2 = RecyclerView.d(childAt);
                if (d2 != null && d2.getLayoutPosition() == i && !d2.p() && (this.f2904b.ra.isPreLayout() || !d2.i())) {
                    return childAt;
                }
            }
            return null;
        }

        public abstract LayoutParams generateDefaultLayoutParams();

        public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
            if (layoutParams instanceof LayoutParams) {
                return new LayoutParams((LayoutParams) layoutParams);
            }
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
            }
            return new LayoutParams(layoutParams);
        }

        public int getBaseline() {
            return -1;
        }

        public int getBottomDecorationHeight(View view) {
            return ((LayoutParams) view.getLayoutParams()).f2914b.bottom;
        }

        public View getChildAt(int i) {
            ChildHelper childHelper = this.f2903a;
            if (childHelper != null) {
                return childHelper.c(i);
            }
            return null;
        }

        public int getChildCount() {
            ChildHelper childHelper = this.f2903a;
            if (childHelper != null) {
                return childHelper.a();
            }
            return 0;
        }

        public boolean getClipToPadding() {
            RecyclerView recyclerView = this.f2904b;
            return recyclerView != null && recyclerView.q;
        }

        public int getColumnCountForAccessibility(Recycler recycler, State state) {
            RecyclerView recyclerView = this.f2904b;
            if (recyclerView == null || recyclerView.v == null || !canScrollHorizontally()) {
                return 1;
            }
            return this.f2904b.v.getItemCount();
        }

        public int getDecoratedBottom(View view) {
            return view.getBottom() + getBottomDecorationHeight(view);
        }

        public void getDecoratedBoundsWithMargins(View view, Rect rect) {
            RecyclerView.a(view, rect);
        }

        public int getDecoratedLeft(View view) {
            return view.getLeft() - getLeftDecorationWidth(view);
        }

        public int getDecoratedMeasuredHeight(View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).f2914b;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public int getDecoratedMeasuredWidth(View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).f2914b;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public int getDecoratedRight(View view) {
            return view.getRight() + getRightDecorationWidth(view);
        }

        public int getDecoratedTop(View view) {
            return view.getTop() - getTopDecorationHeight(view);
        }

        public View getFocusedChild() {
            View focusedChild;
            RecyclerView recyclerView = this.f2904b;
            if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.f2903a.c(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public int getHeight() {
            return this.r;
        }

        public int getHeightMode() {
            return this.p;
        }

        public int getItemCount() {
            RecyclerView recyclerView = this.f2904b;
            Adapter adapter = recyclerView != null ? recyclerView.getAdapter() : null;
            if (adapter != null) {
                return adapter.getItemCount();
            }
            return 0;
        }

        public int getItemViewType(View view) {
            return RecyclerView.d(view).getItemViewType();
        }

        public int getLayoutDirection() {
            return ViewCompat.getLayoutDirection(this.f2904b);
        }

        public int getLeftDecorationWidth(View view) {
            return ((LayoutParams) view.getLayoutParams()).f2914b.left;
        }

        public int getMinimumHeight() {
            return ViewCompat.getMinimumHeight(this.f2904b);
        }

        public int getMinimumWidth() {
            return ViewCompat.getMinimumWidth(this.f2904b);
        }

        public int getPaddingBottom() {
            RecyclerView recyclerView = this.f2904b;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        public int getPaddingEnd() {
            RecyclerView recyclerView = this.f2904b;
            if (recyclerView != null) {
                return ViewCompat.getPaddingEnd(recyclerView);
            }
            return 0;
        }

        public int getPaddingLeft() {
            RecyclerView recyclerView = this.f2904b;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        public int getPaddingRight() {
            RecyclerView recyclerView = this.f2904b;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        public int getPaddingStart() {
            RecyclerView recyclerView = this.f2904b;
            if (recyclerView != null) {
                return ViewCompat.getPaddingStart(recyclerView);
            }
            return 0;
        }

        public int getPaddingTop() {
            RecyclerView recyclerView = this.f2904b;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        public int getPosition(View view) {
            return ((LayoutParams) view.getLayoutParams()).getViewLayoutPosition();
        }

        public int getRightDecorationWidth(View view) {
            return ((LayoutParams) view.getLayoutParams()).f2914b.right;
        }

        public int getRowCountForAccessibility(Recycler recycler, State state) {
            RecyclerView recyclerView = this.f2904b;
            if (recyclerView == null || recyclerView.v == null || !canScrollVertically()) {
                return 1;
            }
            return this.f2904b.v.getItemCount();
        }

        public int getSelectionModeForAccessibility(Recycler recycler, State state) {
            return 0;
        }

        public int getTopDecorationHeight(View view) {
            return ((LayoutParams) view.getLayoutParams()).f2914b.top;
        }

        public void getTransformedBoundingBox(View view, boolean z, Rect rect) {
            Matrix matrix;
            if (z) {
                Rect rect2 = ((LayoutParams) view.getLayoutParams()).f2914b;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (this.f2904b != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
                RectF rectF = this.f2904b.u;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public int getWidth() {
            return this.q;
        }

        public int getWidthMode() {
            return this.o;
        }

        public boolean hasFocus() {
            RecyclerView recyclerView = this.f2904b;
            return recyclerView != null && recyclerView.hasFocus();
        }

        public void ignoreView(View view) {
            ViewParent parent = view.getParent();
            RecyclerView recyclerView = this.f2904b;
            if (parent == recyclerView && recyclerView.indexOfChild(view) != -1) {
                ViewHolder d2 = RecyclerView.d(view);
                d2.a(128);
                this.f2904b.p.g(d2);
            } else {
                throw new IllegalArgumentException("View should be fully attached to be ignored" + this.f2904b.v());
            }
        }

        public boolean isAttachedToWindow() {
            return this.i;
        }

        public boolean isAutoMeasureEnabled() {
            return this.j;
        }

        public boolean isFocused() {
            RecyclerView recyclerView = this.f2904b;
            return recyclerView != null && recyclerView.isFocused();
        }

        public final boolean isItemPrefetchEnabled() {
            return this.l;
        }

        public boolean isLayoutHierarchical(Recycler recycler, State state) {
            return false;
        }

        public boolean isMeasurementCacheEnabled() {
            return this.k;
        }

        public boolean isSmoothScrolling() {
            SmoothScroller smoothScroller = this.f2909g;
            return smoothScroller != null && smoothScroller.isRunning();
        }

        public boolean isViewPartiallyVisible(View view, boolean z, boolean z2) {
            boolean z3 = this.f2907e.a(view, 24579) && this.f2908f.a(view, 24579);
            return z ? z3 : !z3;
        }

        public void layoutDecorated(View view, int i, int i2, int i3, int i4) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).f2914b;
            view.layout(i + rect.left, i2 + rect.top, i3 - rect.right, i4 - rect.bottom);
        }

        public void layoutDecoratedWithMargins(View view, int i, int i2, int i3, int i4) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect rect = layoutParams.f2914b;
            view.layout(i + rect.left + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, i2 + rect.top + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, (i3 - rect.right) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, (i4 - rect.bottom) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
        }

        public void measureChild(View view, int i, int i2) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect e2 = this.f2904b.e(view);
            int i3 = i + e2.left + e2.right;
            int i4 = i2 + e2.top + e2.bottom;
            int childMeasureSpec = getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight() + i3, ((ViewGroup.MarginLayoutParams) layoutParams).width, canScrollHorizontally());
            int childMeasureSpec2 = getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom() + i4, ((ViewGroup.MarginLayoutParams) layoutParams).height, canScrollVertically());
            if (a(view, childMeasureSpec, childMeasureSpec2, layoutParams)) {
                view.measure(childMeasureSpec, childMeasureSpec2);
            }
        }

        public void measureChildWithMargins(View view, int i, int i2) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect e2 = this.f2904b.e(view);
            int i3 = i + e2.left + e2.right;
            int i4 = i2 + e2.top + e2.bottom;
            int childMeasureSpec = getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + i3, ((ViewGroup.MarginLayoutParams) layoutParams).width, canScrollHorizontally());
            int childMeasureSpec2 = getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + i4, ((ViewGroup.MarginLayoutParams) layoutParams).height, canScrollVertically());
            if (a(view, childMeasureSpec, childMeasureSpec2, layoutParams)) {
                view.measure(childMeasureSpec, childMeasureSpec2);
            }
        }

        public void moveView(int i, int i2) {
            View childAt = getChildAt(i);
            if (childAt != null) {
                detachViewAt(i);
                attachView(childAt, i2);
            } else {
                throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i + this.f2904b.toString());
            }
        }

        public void offsetChildrenHorizontal(int i) {
            RecyclerView recyclerView = this.f2904b;
            if (recyclerView != null) {
                recyclerView.offsetChildrenHorizontal(i);
            }
        }

        public void offsetChildrenVertical(int i) {
            RecyclerView recyclerView = this.f2904b;
            if (recyclerView != null) {
                recyclerView.offsetChildrenVertical(i);
            }
        }

        public void onAdapterChanged(Adapter adapter, Adapter adapter2) {
        }

        public boolean onAddFocusables(RecyclerView recyclerView, ArrayList<View> arrayList, int i, int i2) {
            return false;
        }

        public void onAttachedToWindow(RecyclerView recyclerView) {
        }

        @Deprecated
        public void onDetachedFromWindow(RecyclerView recyclerView) {
        }

        public void onDetachedFromWindow(RecyclerView recyclerView, Recycler recycler) {
            onDetachedFromWindow(recyclerView);
        }

        public View onFocusSearchFailed(View view, int i, Recycler recycler, State state) {
            return null;
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f2904b;
            onInitializeAccessibilityEvent(recyclerView.l, recyclerView.ra, accessibilityEvent);
        }

        public void onInitializeAccessibilityNodeInfo(Recycler recycler, State state, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (this.f2904b.canScrollVertically(-1) || this.f2904b.canScrollHorizontally(-1)) {
                accessibilityNodeInfoCompat.addAction(8192);
                accessibilityNodeInfoCompat.setScrollable(true);
            }
            if (this.f2904b.canScrollVertically(1) || this.f2904b.canScrollHorizontally(1)) {
                accessibilityNodeInfoCompat.addAction(4096);
                accessibilityNodeInfoCompat.setScrollable(true);
            }
            accessibilityNodeInfoCompat.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(getRowCountForAccessibility(recycler, state), getColumnCountForAccessibility(recycler, state), isLayoutHierarchical(recycler, state), getSelectionModeForAccessibility(recycler, state)));
        }

        public void onInitializeAccessibilityNodeInfoForItem(Recycler recycler, State state, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(canScrollVertically() ? getPosition(view) : 0, 1, canScrollHorizontally() ? getPosition(view) : 0, 1, false, false));
        }

        public View onInterceptFocusSearch(View view, int i) {
            return null;
        }

        public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        }

        public void onItemsChanged(RecyclerView recyclerView) {
        }

        public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        }

        public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        }

        public void onItemsUpdated(RecyclerView recyclerView, int i, int i2) {
        }

        public void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
            onItemsUpdated(recyclerView, i, i2);
        }

        public void onLayoutChildren(Recycler recycler, State state) {
            Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public void onLayoutCompleted(State state) {
        }

        public void onMeasure(Recycler recycler, State state, int i, int i2) {
            this.f2904b.c(i, i2);
        }

        @Deprecated
        public boolean onRequestChildFocus(RecyclerView recyclerView, View view, View view2) {
            return isSmoothScrolling() || recyclerView.isComputingLayout();
        }

        public void onRestoreInstanceState(Parcelable parcelable) {
        }

        public Parcelable onSaveInstanceState() {
            return null;
        }

        public void onScrollStateChanged(int i) {
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0070 A[ADDED_TO_REGION] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean performAccessibilityAction(android.support.v7.widget.RecyclerView.Recycler r2, android.support.v7.widget.RecyclerView.State r3, int r4, android.os.Bundle r5) {
            /*
                r1 = this;
                android.support.v7.widget.RecyclerView r2 = r1.f2904b
                r3 = 0
                if (r2 != 0) goto L6
                return r3
            L6:
                r5 = 4096(0x1000, float:5.74E-42)
                r0 = 1
                if (r4 == r5) goto L42
                r5 = 8192(0x2000, float:1.148E-41)
                if (r4 == r5) goto L12
                r2 = 0
            L10:
                r4 = 0
                goto L6e
            L12:
                r4 = -1
                boolean r2 = r2.canScrollVertically(r4)
                if (r2 == 0) goto L29
                int r2 = r1.getHeight()
                int r5 = r1.getPaddingTop()
                int r2 = r2 - r5
                int r5 = r1.getPaddingBottom()
                int r2 = r2 - r5
                int r2 = -r2
                goto L2a
            L29:
                r2 = 0
            L2a:
                android.support.v7.widget.RecyclerView r5 = r1.f2904b
                boolean r4 = r5.canScrollHorizontally(r4)
                if (r4 == 0) goto L10
                int r4 = r1.getWidth()
                int r5 = r1.getPaddingLeft()
                int r4 = r4 - r5
                int r5 = r1.getPaddingRight()
                int r4 = r4 - r5
                int r4 = -r4
                goto L6e
            L42:
                boolean r2 = r2.canScrollVertically(r0)
                if (r2 == 0) goto L57
                int r2 = r1.getHeight()
                int r4 = r1.getPaddingTop()
                int r2 = r2 - r4
                int r4 = r1.getPaddingBottom()
                int r2 = r2 - r4
                goto L58
            L57:
                r2 = 0
            L58:
                android.support.v7.widget.RecyclerView r4 = r1.f2904b
                boolean r4 = r4.canScrollHorizontally(r0)
                if (r4 == 0) goto L10
                int r4 = r1.getWidth()
                int r5 = r1.getPaddingLeft()
                int r4 = r4 - r5
                int r5 = r1.getPaddingRight()
                int r4 = r4 - r5
            L6e:
                if (r2 != 0) goto L73
                if (r4 != 0) goto L73
                return r3
            L73:
                android.support.v7.widget.RecyclerView r3 = r1.f2904b
                r3.scrollBy(r4, r2)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.RecyclerView.LayoutManager.performAccessibilityAction(android.support.v7.widget.RecyclerView$Recycler, android.support.v7.widget.RecyclerView$State, int, android.os.Bundle):boolean");
        }

        public boolean performAccessibilityActionForItem(Recycler recycler, State state, View view, int i, Bundle bundle) {
            return false;
        }

        public void postOnAnimation(Runnable runnable) {
            RecyclerView recyclerView = this.f2904b;
            if (recyclerView != null) {
                ViewCompat.postOnAnimation(recyclerView, runnable);
            }
        }

        public void removeAllViews() {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                this.f2903a.e(childCount);
            }
        }

        public void removeAndRecycleAllViews(Recycler recycler) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                if (!RecyclerView.d(getChildAt(childCount)).p()) {
                    removeAndRecycleViewAt(childCount, recycler);
                }
            }
        }

        public void removeAndRecycleView(View view, Recycler recycler) {
            removeView(view);
            recycler.recycleView(view);
        }

        public void removeAndRecycleViewAt(int i, Recycler recycler) {
            View childAt = getChildAt(i);
            removeViewAt(i);
            recycler.recycleView(childAt);
        }

        public boolean removeCallbacks(Runnable runnable) {
            RecyclerView recyclerView = this.f2904b;
            if (recyclerView != null) {
                return recyclerView.removeCallbacks(runnable);
            }
            return false;
        }

        public void removeDetachedView(View view) {
            this.f2904b.removeDetachedView(view, false);
        }

        public void removeView(View view) {
            this.f2903a.d(view);
        }

        public void removeViewAt(int i) {
            if (getChildAt(i) != null) {
                this.f2903a.e(i);
            }
        }

        public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            return requestChildRectangleOnScreen(recyclerView, view, rect, z, false);
        }

        public void requestLayout() {
            RecyclerView recyclerView = this.f2904b;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public void requestSimpleAnimationsInNextLayout() {
            this.f2910h = true;
        }

        public int scrollHorizontallyBy(int i, Recycler recycler, State state) {
            return 0;
        }

        public void scrollToPosition(int i) {
        }

        public int scrollVerticallyBy(int i, Recycler recycler, State state) {
            return 0;
        }

        @Deprecated
        public void setAutoMeasureEnabled(boolean z) {
            this.j = z;
        }

        public final void setItemPrefetchEnabled(boolean z) {
            if (z != this.l) {
                this.l = z;
                this.m = 0;
                RecyclerView recyclerView = this.f2904b;
                if (recyclerView != null) {
                    recyclerView.l.h();
                }
            }
        }

        public void setMeasuredDimension(Rect rect, int i, int i2) {
            setMeasuredDimension(chooseSize(i, rect.width() + getPaddingLeft() + getPaddingRight(), getMinimumWidth()), chooseSize(i2, rect.height() + getPaddingTop() + getPaddingBottom(), getMinimumHeight()));
        }

        public void setMeasurementCacheEnabled(boolean z) {
            this.k = z;
        }

        public void smoothScrollToPosition(RecyclerView recyclerView, State state, int i) {
            Log.e("RecyclerView", "You must override smoothScrollToPosition to support smooth scrolling");
        }

        public void startSmoothScroll(SmoothScroller smoothScroller) {
            SmoothScroller smoothScroller2 = this.f2909g;
            if (smoothScroller2 != null && smoothScroller != smoothScroller2 && smoothScroller2.isRunning()) {
                this.f2909g.c();
            }
            this.f2909g = smoothScroller;
            this.f2909g.a(this.f2904b, this);
        }

        public void stopIgnoringView(View view) {
            ViewHolder d2 = RecyclerView.d(view);
            d2.q();
            d2.n();
            d2.a(4);
        }

        public boolean supportsPredictiveItemAnimations() {
            return false;
        }

        void a(int i, int i2) {
            this.q = View.MeasureSpec.getSize(i);
            this.o = View.MeasureSpec.getMode(i);
            if (this.o == 0 && !RecyclerView.f2884d) {
                this.q = 0;
            }
            this.r = View.MeasureSpec.getSize(i2);
            this.p = View.MeasureSpec.getMode(i2);
            if (this.p != 0 || RecyclerView.f2884d) {
                return;
            }
            this.r = 0;
        }

        public void addDisappearingView(View view, int i) {
            a(view, i, true);
        }

        public void addView(View view, int i) {
            a(view, i, false);
        }

        public void onInitializeAccessibilityEvent(Recycler recycler, State state, AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f2904b;
            if (recyclerView == null || accessibilityEvent == null) {
                return;
            }
            boolean z = true;
            if (!recyclerView.canScrollVertically(1) && !this.f2904b.canScrollVertically(-1) && !this.f2904b.canScrollHorizontally(-1) && !this.f2904b.canScrollHorizontally(1)) {
                z = false;
            }
            accessibilityEvent.setScrollable(z);
            Adapter adapter = this.f2904b.v;
            if (adapter != null) {
                accessibilityEvent.setItemCount(adapter.getItemCount());
            }
        }

        public boolean onRequestChildFocus(RecyclerView recyclerView, State state, View view, View view2) {
            return onRequestChildFocus(recyclerView, view, view2);
        }

        public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
            int[] a2 = a(recyclerView, view, rect, z);
            int i = a2[0];
            int i2 = a2[1];
            if ((z2 && !a(recyclerView, i, i2)) || (i == 0 && i2 == 0)) {
                return false;
            }
            if (z) {
                recyclerView.scrollBy(i, i2);
            } else {
                recyclerView.smoothScrollBy(i, i2);
            }
            return true;
        }

        public static int getChildMeasureSpec(int i, int i2, int i3, int i4, boolean z) {
            int i5;
            int i6 = i - i3;
            int i7 = 0;
            int max = Math.max(0, i6);
            if (z) {
                if (i4 < 0) {
                    if (i4 == -1) {
                        if (i2 == Integer.MIN_VALUE || (i2 != 0 && i2 == 1073741824)) {
                            i5 = max;
                        } else {
                            i2 = 0;
                            i5 = 0;
                        }
                        i7 = i2;
                        max = i5;
                    }
                    max = 0;
                }
                max = i4;
                i7 = 1073741824;
            } else {
                if (i4 < 0) {
                    if (i4 == -1) {
                        i7 = i2;
                    } else {
                        if (i4 == -2) {
                            if (i2 == Integer.MIN_VALUE || i2 == 1073741824) {
                                i7 = Integer.MIN_VALUE;
                            }
                        }
                        max = 0;
                    }
                }
                max = i4;
                i7 = 1073741824;
            }
            return View.MeasureSpec.makeMeasureSpec(max, i7);
        }

        public void attachView(View view, int i) {
            attachView(view, i, (LayoutParams) view.getLayoutParams());
        }

        public LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
            return new LayoutParams(context, attributeSet);
        }

        public void setMeasuredDimension(int i, int i2) {
            this.f2904b.setMeasuredDimension(i, i2);
        }

        public void attachView(View view) {
            attachView(view, -1);
        }

        void a(RecyclerView recyclerView) {
            this.i = true;
            onAttachedToWindow(recyclerView);
        }

        void c() {
            SmoothScroller smoothScroller = this.f2909g;
            if (smoothScroller != null) {
                smoothScroller.c();
            }
        }

        void a(RecyclerView recyclerView, Recycler recycler) {
            this.i = false;
            onDetachedFromWindow(recyclerView, recycler);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean b(View view, int i, int i2, LayoutParams layoutParams) {
            return (this.k && a(view.getMeasuredWidth(), i, ((ViewGroup.MarginLayoutParams) layoutParams).width) && a(view.getMeasuredHeight(), i2, ((ViewGroup.MarginLayoutParams) layoutParams).height)) ? false : true;
        }

        private void a(View view, int i, boolean z) {
            ViewHolder d2 = RecyclerView.d(view);
            if (!z && !d2.i()) {
                this.f2904b.p.f(d2);
            } else {
                this.f2904b.p.a(d2);
            }
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (!d2.s() && !d2.j()) {
                if (view.getParent() == this.f2904b) {
                    int b2 = this.f2903a.b(view);
                    if (i == -1) {
                        i = this.f2903a.a();
                    }
                    if (b2 == -1) {
                        throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.f2904b.indexOfChild(view) + this.f2904b.v());
                    }
                    if (b2 != i) {
                        this.f2904b.w.moveView(b2, i);
                    }
                } else {
                    this.f2903a.a(view, i, false);
                    layoutParams.f2915c = true;
                    SmoothScroller smoothScroller = this.f2909g;
                    if (smoothScroller != null && smoothScroller.isRunning()) {
                        this.f2909g.a(view);
                    }
                }
            } else {
                if (d2.j()) {
                    d2.r();
                } else {
                    d2.c();
                }
                this.f2903a.a(view, i, view.getLayoutParams(), false);
            }
            if (layoutParams.f2916d) {
                d2.itemView.invalidate();
                layoutParams.f2916d = false;
            }
        }

        void b(RecyclerView recyclerView) {
            a(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        private void a(int i, View view) {
            this.f2903a.a(i);
        }

        private void a(Recycler recycler, int i, View view) {
            ViewHolder d2 = RecyclerView.d(view);
            if (d2.p()) {
                return;
            }
            if (d2.h() && !d2.i() && !this.f2904b.v.hasStableIds()) {
                removeViewAt(i);
                recycler.b(d2);
            } else {
                detachViewAt(i);
                recycler.b(view);
                this.f2904b.p.onViewDetached(d2);
            }
        }

        void a(Recycler recycler) {
            int d2 = recycler.d();
            for (int i = d2 - 1; i >= 0; i--) {
                View b2 = recycler.b(i);
                ViewHolder d3 = RecyclerView.d(b2);
                if (!d3.p()) {
                    d3.setIsRecyclable(false);
                    if (d3.k()) {
                        this.f2904b.removeDetachedView(b2, false);
                    }
                    ItemAnimator itemAnimator = this.f2904b.W;
                    if (itemAnimator != null) {
                        itemAnimator.endAnimation(d3);
                    }
                    d3.setIsRecyclable(true);
                    recycler.a(b2);
                }
            }
            recycler.b();
            if (d2 > 0) {
                this.f2904b.invalidate();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean a(View view, int i, int i2, LayoutParams layoutParams) {
            return (!view.isLayoutRequested() && this.k && a(view.getWidth(), i, ((ViewGroup.MarginLayoutParams) layoutParams).width) && a(view.getHeight(), i2, ((ViewGroup.MarginLayoutParams) layoutParams).height)) ? false : true;
        }

        private static boolean a(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (i3 > 0 && i != i3) {
                return false;
            }
            if (mode == Integer.MIN_VALUE) {
                return size >= i;
            }
            if (mode != 0) {
                return mode == 1073741824 && size == i;
            }
            return true;
        }

        private int[] a(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            int[] iArr = new int[2];
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int height = getHeight() - getPaddingBottom();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int width2 = rect.width() + left;
            int height2 = rect.height() + top;
            int i = left - paddingLeft;
            int min = Math.min(0, i);
            int i2 = top - paddingTop;
            int min2 = Math.min(0, i2);
            int i3 = width2 - width;
            int max = Math.max(0, i3);
            int max2 = Math.max(0, height2 - height);
            if (getLayoutDirection() != 1) {
                if (min == 0) {
                    min = Math.min(i, max);
                }
                max = min;
            } else if (max == 0) {
                max = Math.max(min, i3);
            }
            if (min2 == 0) {
                min2 = Math.min(i2, max2);
            }
            iArr[0] = max;
            iArr[1] = min2;
            return iArr;
        }

        private boolean a(RecyclerView recyclerView, int i, int i2) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int height = getHeight() - getPaddingBottom();
            Rect rect = this.f2904b.s;
            getDecoratedBoundsWithMargins(focusedChild, rect);
            return rect.left - i < width && rect.right - i > paddingLeft && rect.top - i2 < height && rect.bottom - i2 > paddingTop;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(SmoothScroller smoothScroller) {
            if (this.f2909g == smoothScroller) {
                this.f2909g = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            RecyclerView recyclerView = this.f2904b;
            onInitializeAccessibilityNodeInfo(recyclerView.l, recyclerView.ra, accessibilityNodeInfoCompat);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            ViewHolder d2 = RecyclerView.d(view);
            if (d2 == null || d2.i() || this.f2903a.c(d2.itemView)) {
                return;
            }
            RecyclerView recyclerView = this.f2904b;
            onInitializeAccessibilityNodeInfoForItem(recyclerView.l, recyclerView.ra, view, accessibilityNodeInfoCompat);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean a(int i, Bundle bundle) {
            RecyclerView recyclerView = this.f2904b;
            return performAccessibilityAction(recyclerView.l, recyclerView.ra, i, bundle);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean a(View view, int i, Bundle bundle) {
            RecyclerView recyclerView = this.f2904b;
            return performAccessibilityActionForItem(recyclerView.l, recyclerView.ra, view, i, bundle);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean a() {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                ViewGroup.LayoutParams layoutParams = getChildAt(i).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    public interface OnChildAttachStateChangeListener {
        void onChildViewAttachedToWindow(View view);

        void onChildViewDetachedFromWindow(View view);
    }

    /* loaded from: classes.dex */
    public static abstract class OnFlingListener {
        public abstract boolean onFling(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface OnItemTouchListener {
        boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent);

        void onRequestDisallowInterceptTouchEvent(boolean z);

        void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent);
    }

    /* loaded from: classes.dex */
    public static abstract class OnScrollListener {
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        }

        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface Orientation {
    }

    /* loaded from: classes.dex */
    public static class RecycledViewPool {

        /* renamed from: a, reason: collision with root package name */
        SparseArray<ScrapData> f2917a = new SparseArray<>();

        /* renamed from: b, reason: collision with root package name */
        private int f2918b = 0;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public static class ScrapData {

            /* renamed from: a, reason: collision with root package name */
            final ArrayList<ViewHolder> f2919a = new ArrayList<>();

            /* renamed from: b, reason: collision with root package name */
            int f2920b = 5;

            /* renamed from: c, reason: collision with root package name */
            long f2921c = 0;

            /* renamed from: d, reason: collision with root package name */
            long f2922d = 0;

            ScrapData() {
            }
        }

        long a(long j, long j2) {
            return j == 0 ? j2 : ((j / 4) * 3) + (j2 / 4);
        }

        void b(int i, long j) {
            ScrapData a2 = a(i);
            a2.f2921c = a(a2.f2921c, j);
        }

        public void clear() {
            for (int i = 0; i < this.f2917a.size(); i++) {
                this.f2917a.valueAt(i).f2919a.clear();
            }
        }

        public ViewHolder getRecycledView(int i) {
            ScrapData scrapData = this.f2917a.get(i);
            if (scrapData == null || scrapData.f2919a.isEmpty()) {
                return null;
            }
            return scrapData.f2919a.remove(r2.size() - 1);
        }

        public int getRecycledViewCount(int i) {
            return a(i).f2919a.size();
        }

        public void putRecycledView(ViewHolder viewHolder) {
            int itemViewType = viewHolder.getItemViewType();
            ArrayList<ViewHolder> arrayList = a(itemViewType).f2919a;
            if (this.f2917a.get(itemViewType).f2920b <= arrayList.size()) {
                return;
            }
            viewHolder.n();
            arrayList.add(viewHolder);
        }

        public void setMaxRecycledViews(int i, int i2) {
            ScrapData a2 = a(i);
            a2.f2920b = i2;
            ArrayList<ViewHolder> arrayList = a2.f2919a;
            while (arrayList.size() > i2) {
                arrayList.remove(arrayList.size() - 1);
            }
        }

        void a(int i, long j) {
            ScrapData a2 = a(i);
            a2.f2922d = a(a2.f2922d, j);
        }

        boolean b(int i, long j, long j2) {
            long j3 = a(i).f2921c;
            return j3 == 0 || j + j3 < j2;
        }

        boolean a(int i, long j, long j2) {
            long j3 = a(i).f2922d;
            return j3 == 0 || j + j3 < j2;
        }

        void a(Adapter adapter) {
            this.f2918b++;
        }

        void a() {
            this.f2918b--;
        }

        void a(Adapter adapter, Adapter adapter2, boolean z) {
            if (adapter != null) {
                a();
            }
            if (!z && this.f2918b == 0) {
                clear();
            }
            if (adapter2 != null) {
                a(adapter2);
            }
        }

        private ScrapData a(int i) {
            ScrapData scrapData = this.f2917a.get(i);
            if (scrapData != null) {
                return scrapData;
            }
            ScrapData scrapData2 = new ScrapData();
            this.f2917a.put(i, scrapData2);
            return scrapData2;
        }
    }

    /* loaded from: classes.dex */
    public final class Recycler {

        /* renamed from: a, reason: collision with root package name */
        final ArrayList<ViewHolder> f2923a = new ArrayList<>();

        /* renamed from: b, reason: collision with root package name */
        ArrayList<ViewHolder> f2924b = null;

        /* renamed from: c, reason: collision with root package name */
        final ArrayList<ViewHolder> f2925c = new ArrayList<>();

        /* renamed from: d, reason: collision with root package name */
        private final List<ViewHolder> f2926d = Collections.unmodifiableList(this.f2923a);

        /* renamed from: e, reason: collision with root package name */
        private int f2927e = 2;

        /* renamed from: f, reason: collision with root package name */
        int f2928f = 2;

        /* renamed from: g, reason: collision with root package name */
        RecycledViewPool f2929g;

        /* renamed from: h, reason: collision with root package name */
        private ViewCacheExtension f2930h;

        public Recycler() {
        }

        private boolean a(ViewHolder viewHolder, int i, int i2, long j) {
            viewHolder.r = RecyclerView.this;
            int itemViewType = viewHolder.getItemViewType();
            long nanoTime = RecyclerView.this.getNanoTime();
            if (j != Long.MAX_VALUE && !this.f2929g.a(itemViewType, nanoTime, j)) {
                return false;
            }
            RecyclerView.this.v.bindViewHolder(viewHolder, i);
            this.f2929g.a(viewHolder.getItemViewType(), RecyclerView.this.getNanoTime() - nanoTime);
            e(viewHolder);
            if (!RecyclerView.this.ra.isPreLayout()) {
                return true;
            }
            viewHolder.f2968g = i2;
            return true;
        }

        private void e(ViewHolder viewHolder) {
            if (RecyclerView.this.y()) {
                View view = viewHolder.itemView;
                if (ViewCompat.getImportantForAccessibility(view) == 0) {
                    ViewCompat.setImportantForAccessibility(view, 1);
                }
                if (ViewCompat.hasAccessibilityDelegate(view)) {
                    return;
                }
                viewHolder.a(16384);
                ViewCompat.setAccessibilityDelegate(view, RecyclerView.this.ya.getItemDelegate());
            }
        }

        private void f(ViewHolder viewHolder) {
            View view = viewHolder.itemView;
            if (view instanceof ViewGroup) {
                a((ViewGroup) view, false);
            }
        }

        View b(int i, boolean z) {
            return a(i, z, Long.MAX_VALUE).itemView;
        }

        public void bindViewToPosition(View view, int i) {
            LayoutParams layoutParams;
            ViewHolder d2 = RecyclerView.d(view);
            if (d2 != null) {
                int a2 = RecyclerView.this.n.a(i);
                if (a2 >= 0 && a2 < RecyclerView.this.v.getItemCount()) {
                    a(d2, a2, i, Long.MAX_VALUE);
                    ViewGroup.LayoutParams layoutParams2 = d2.itemView.getLayoutParams();
                    if (layoutParams2 == null) {
                        layoutParams = (LayoutParams) RecyclerView.this.generateDefaultLayoutParams();
                        d2.itemView.setLayoutParams(layoutParams);
                    } else if (!RecyclerView.this.checkLayoutParams(layoutParams2)) {
                        layoutParams = (LayoutParams) RecyclerView.this.generateLayoutParams(layoutParams2);
                        d2.itemView.setLayoutParams(layoutParams);
                    } else {
                        layoutParams = (LayoutParams) layoutParams2;
                    }
                    layoutParams.f2915c = true;
                    layoutParams.f2913a = d2;
                    layoutParams.f2916d = d2.itemView.getParent() == null;
                    return;
                }
                throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i + "(offset:" + a2 + ").state:" + RecyclerView.this.ra.getItemCount() + RecyclerView.this.v());
            }
            throw new IllegalArgumentException("The view does not have a ViewHolder. You cannot pass arbitrary views to this method, they should be created by the Adapter" + RecyclerView.this.v());
        }

        void c(int i) {
            a(this.f2925c.get(i), true);
            this.f2925c.remove(i);
        }

        public void clear() {
            this.f2923a.clear();
            g();
        }

        public int convertPreLayoutPositionToPostLayout(int i) {
            if (i >= 0 && i < RecyclerView.this.ra.getItemCount()) {
                return !RecyclerView.this.ra.isPreLayout() ? i : RecyclerView.this.n.a(i);
            }
            throw new IndexOutOfBoundsException("invalid position " + i + ". State item count is " + RecyclerView.this.ra.getItemCount() + RecyclerView.this.v());
        }

        boolean d(ViewHolder viewHolder) {
            if (viewHolder.i()) {
                return RecyclerView.this.ra.isPreLayout();
            }
            int i = viewHolder.f2964c;
            if (i >= 0 && i < RecyclerView.this.v.getItemCount()) {
                if (RecyclerView.this.ra.isPreLayout() || RecyclerView.this.v.getItemViewType(viewHolder.f2964c) == viewHolder.getItemViewType()) {
                    return !RecyclerView.this.v.hasStableIds() || viewHolder.getItemId() == RecyclerView.this.v.getItemId(viewHolder.f2964c);
                }
                return false;
            }
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + viewHolder + RecyclerView.this.v());
        }

        void g() {
            for (int size = this.f2925c.size() - 1; size >= 0; size--) {
                c(size);
            }
            this.f2925c.clear();
            if (RecyclerView.f2886f) {
                RecyclerView.this.qa.a();
            }
        }

        public List<ViewHolder> getScrapList() {
            return this.f2926d;
        }

        public View getViewForPosition(int i) {
            return b(i, false);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void h() {
            LayoutManager layoutManager = RecyclerView.this.w;
            this.f2928f = this.f2927e + (layoutManager != null ? layoutManager.m : 0);
            for (int size = this.f2925c.size() - 1; size >= 0 && this.f2925c.size() > this.f2928f; size--) {
                c(size);
            }
        }

        public void recycleView(View view) {
            ViewHolder d2 = RecyclerView.d(view);
            if (d2.k()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (d2.j()) {
                d2.r();
            } else if (d2.s()) {
                d2.c();
            }
            b(d2);
        }

        public void setViewCacheSize(int i) {
            this.f2927e = i;
            h();
        }

        void b(ViewHolder viewHolder) {
            boolean z;
            if (!viewHolder.j() && viewHolder.itemView.getParent() == null) {
                if (!viewHolder.k()) {
                    if (!viewHolder.p()) {
                        boolean u = viewHolder.u();
                        Adapter adapter = RecyclerView.this.v;
                        if ((adapter != null && u && adapter.onFailedToRecycleView(viewHolder)) || viewHolder.isRecyclable()) {
                            if (this.f2928f <= 0 || viewHolder.b(526)) {
                                z = false;
                            } else {
                                int size = this.f2925c.size();
                                if (size >= this.f2928f && size > 0) {
                                    c(0);
                                    size--;
                                }
                                if (RecyclerView.f2886f && size > 0 && !RecyclerView.this.qa.a(viewHolder.f2964c)) {
                                    int i = size - 1;
                                    while (i >= 0) {
                                        if (!RecyclerView.this.qa.a(this.f2925c.get(i).f2964c)) {
                                            break;
                                        } else {
                                            i--;
                                        }
                                    }
                                    size = i + 1;
                                }
                                this.f2925c.add(size, viewHolder);
                                z = true;
                            }
                            if (!z) {
                                a(viewHolder, true);
                                r1 = true;
                            }
                        } else {
                            z = false;
                        }
                        RecyclerView.this.p.g(viewHolder);
                        if (z || r1 || !u) {
                            return;
                        }
                        viewHolder.r = null;
                        return;
                    }
                    throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + RecyclerView.this.v());
                }
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + viewHolder + RecyclerView.this.v());
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Scrapped or attached views may not be recycled. isScrap:");
            sb.append(viewHolder.j());
            sb.append(" isAttached:");
            sb.append(viewHolder.itemView.getParent() != null);
            sb.append(RecyclerView.this.v());
            throw new IllegalArgumentException(sb.toString());
        }

        void f() {
            int size = this.f2925c.size();
            for (int i = 0; i < size; i++) {
                ViewHolder viewHolder = this.f2925c.get(i);
                if (viewHolder != null) {
                    viewHolder.a(6);
                    viewHolder.a((Object) null);
                }
            }
            Adapter adapter = RecyclerView.this.v;
            if (adapter == null || !adapter.hasStableIds()) {
                g();
            }
        }

        void c(ViewHolder viewHolder) {
            if (viewHolder.o) {
                this.f2924b.remove(viewHolder);
            } else {
                this.f2923a.remove(viewHolder);
            }
            viewHolder.n = null;
            viewHolder.o = false;
            viewHolder.c();
        }

        RecycledViewPool c() {
            if (this.f2929g == null) {
                this.f2929g = new RecycledViewPool();
            }
            return this.f2929g;
        }

        void e() {
            int size = this.f2925c.size();
            for (int i = 0; i < size; i++) {
                LayoutParams layoutParams = (LayoutParams) this.f2925c.get(i).itemView.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.f2915c = true;
                }
            }
        }

        int d() {
            return this.f2923a.size();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x005f  */
        /* JADX WARN: Removed duplicated region for block: B:69:0x018b  */
        /* JADX WARN: Removed duplicated region for block: B:75:0x01a8  */
        /* JADX WARN: Removed duplicated region for block: B:78:0x01cb  */
        /* JADX WARN: Removed duplicated region for block: B:84:0x0204  */
        /* JADX WARN: Removed duplicated region for block: B:87:0x022e A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:91:0x0212  */
        /* JADX WARN: Removed duplicated region for block: B:97:0x01da  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public android.support.v7.widget.RecyclerView.ViewHolder a(int r17, boolean r18, long r19) {
            /*
                Method dump skipped, instructions count: 621
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.RecyclerView.Recycler.a(int, boolean, long):android.support.v7.widget.RecyclerView$ViewHolder");
        }

        void c(int i, int i2) {
            int i3;
            int i4 = i2 + i;
            for (int size = this.f2925c.size() - 1; size >= 0; size--) {
                ViewHolder viewHolder = this.f2925c.get(size);
                if (viewHolder != null && (i3 = viewHolder.f2964c) >= i && i3 < i4) {
                    viewHolder.a(2);
                    c(size);
                }
            }
        }

        void b(View view) {
            ViewHolder d2 = RecyclerView.d(view);
            if (!d2.b(12) && d2.l() && !RecyclerView.this.a(d2)) {
                if (this.f2924b == null) {
                    this.f2924b = new ArrayList<>();
                }
                d2.a(this, true);
                this.f2924b.add(d2);
                return;
            }
            if (d2.h() && !d2.i() && !RecyclerView.this.v.hasStableIds()) {
                throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + RecyclerView.this.v());
            }
            d2.a(this, false);
            this.f2923a.add(d2);
        }

        View b(int i) {
            return this.f2923a.get(i).itemView;
        }

        void b() {
            this.f2923a.clear();
            ArrayList<ViewHolder> arrayList = this.f2924b;
            if (arrayList != null) {
                arrayList.clear();
            }
        }

        void b(int i, int i2) {
            int i3;
            int i4;
            int i5;
            int i6;
            if (i < i2) {
                i4 = i;
                i3 = i2;
                i5 = -1;
            } else {
                i3 = i;
                i4 = i2;
                i5 = 1;
            }
            int size = this.f2925c.size();
            for (int i7 = 0; i7 < size; i7++) {
                ViewHolder viewHolder = this.f2925c.get(i7);
                if (viewHolder != null && (i6 = viewHolder.f2964c) >= i4 && i6 <= i3) {
                    if (i6 == i) {
                        viewHolder.a(i2 - i, false);
                    } else {
                        viewHolder.a(i5, false);
                    }
                }
            }
        }

        private void a(ViewGroup viewGroup, boolean z) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    a((ViewGroup) childAt, true);
                }
            }
            if (z) {
                if (viewGroup.getVisibility() == 4) {
                    viewGroup.setVisibility(0);
                    viewGroup.setVisibility(4);
                } else {
                    int visibility = viewGroup.getVisibility();
                    viewGroup.setVisibility(4);
                    viewGroup.setVisibility(visibility);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(ViewHolder viewHolder, boolean z) {
            RecyclerView.b(viewHolder);
            if (viewHolder.b(16384)) {
                viewHolder.a(0, 16384);
                ViewCompat.setAccessibilityDelegate(viewHolder.itemView, null);
            }
            if (z) {
                a(viewHolder);
            }
            viewHolder.r = null;
            c().putRecycledView(viewHolder);
        }

        void a(View view) {
            ViewHolder d2 = RecyclerView.d(view);
            d2.n = null;
            d2.o = false;
            d2.c();
            b(d2);
        }

        ViewHolder a(int i) {
            int size;
            int a2;
            ArrayList<ViewHolder> arrayList = this.f2924b;
            if (arrayList != null && (size = arrayList.size()) != 0) {
                for (int i2 = 0; i2 < size; i2++) {
                    ViewHolder viewHolder = this.f2924b.get(i2);
                    if (!viewHolder.s() && viewHolder.getLayoutPosition() == i) {
                        viewHolder.a(32);
                        return viewHolder;
                    }
                }
                if (RecyclerView.this.v.hasStableIds() && (a2 = RecyclerView.this.n.a(i)) > 0 && a2 < RecyclerView.this.v.getItemCount()) {
                    long itemId = RecyclerView.this.v.getItemId(a2);
                    for (int i3 = 0; i3 < size; i3++) {
                        ViewHolder viewHolder2 = this.f2924b.get(i3);
                        if (!viewHolder2.s() && viewHolder2.getItemId() == itemId) {
                            viewHolder2.a(32);
                            return viewHolder2;
                        }
                    }
                }
            }
            return null;
        }

        ViewHolder a(int i, boolean z) {
            View b2;
            int size = this.f2923a.size();
            for (int i2 = 0; i2 < size; i2++) {
                ViewHolder viewHolder = this.f2923a.get(i2);
                if (!viewHolder.s() && viewHolder.getLayoutPosition() == i && !viewHolder.h() && (RecyclerView.this.ra.f2954h || !viewHolder.i())) {
                    viewHolder.a(32);
                    return viewHolder;
                }
            }
            if (!z && (b2 = RecyclerView.this.o.b(i)) != null) {
                ViewHolder d2 = RecyclerView.d(b2);
                RecyclerView.this.o.f(b2);
                int b3 = RecyclerView.this.o.b(b2);
                if (b3 != -1) {
                    RecyclerView.this.o.a(b3);
                    b(b2);
                    d2.a(8224);
                    return d2;
                }
                throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + d2 + RecyclerView.this.v());
            }
            int size2 = this.f2925c.size();
            for (int i3 = 0; i3 < size2; i3++) {
                ViewHolder viewHolder2 = this.f2925c.get(i3);
                if (!viewHolder2.h() && viewHolder2.getLayoutPosition() == i) {
                    if (!z) {
                        this.f2925c.remove(i3);
                    }
                    return viewHolder2;
                }
            }
            return null;
        }

        ViewHolder a(long j, int i, boolean z) {
            for (int size = this.f2923a.size() - 1; size >= 0; size--) {
                ViewHolder viewHolder = this.f2923a.get(size);
                if (viewHolder.getItemId() == j && !viewHolder.s()) {
                    if (i == viewHolder.getItemViewType()) {
                        viewHolder.a(32);
                        if (viewHolder.i() && !RecyclerView.this.ra.isPreLayout()) {
                            viewHolder.a(2, 14);
                        }
                        return viewHolder;
                    }
                    if (!z) {
                        this.f2923a.remove(size);
                        RecyclerView.this.removeDetachedView(viewHolder.itemView, false);
                        a(viewHolder.itemView);
                    }
                }
            }
            int size2 = this.f2925c.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    return null;
                }
                ViewHolder viewHolder2 = this.f2925c.get(size2);
                if (viewHolder2.getItemId() == j) {
                    if (i == viewHolder2.getItemViewType()) {
                        if (!z) {
                            this.f2925c.remove(size2);
                        }
                        return viewHolder2;
                    }
                    if (!z) {
                        c(size2);
                        return null;
                    }
                }
            }
        }

        void a(ViewHolder viewHolder) {
            RecyclerListener recyclerListener = RecyclerView.this.x;
            if (recyclerListener != null) {
                recyclerListener.onViewRecycled(viewHolder);
            }
            Adapter adapter = RecyclerView.this.v;
            if (adapter != null) {
                adapter.onViewRecycled(viewHolder);
            }
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.ra != null) {
                recyclerView.p.g(viewHolder);
            }
        }

        void a(Adapter adapter, Adapter adapter2, boolean z) {
            clear();
            c().a(adapter, adapter2, z);
        }

        void a(int i, int i2) {
            int size = this.f2925c.size();
            for (int i3 = 0; i3 < size; i3++) {
                ViewHolder viewHolder = this.f2925c.get(i3);
                if (viewHolder != null && viewHolder.f2964c >= i) {
                    viewHolder.a(i2, true);
                }
            }
        }

        void a(int i, int i2, boolean z) {
            int i3 = i + i2;
            for (int size = this.f2925c.size() - 1; size >= 0; size--) {
                ViewHolder viewHolder = this.f2925c.get(size);
                if (viewHolder != null) {
                    int i4 = viewHolder.f2964c;
                    if (i4 >= i3) {
                        viewHolder.a(-i2, z);
                    } else if (i4 >= i) {
                        viewHolder.a(8);
                        c(size);
                    }
                }
            }
        }

        void a(ViewCacheExtension viewCacheExtension) {
            this.f2930h = viewCacheExtension;
        }

        void a(RecycledViewPool recycledViewPool) {
            RecycledViewPool recycledViewPool2 = this.f2929g;
            if (recycledViewPool2 != null) {
                recycledViewPool2.a();
            }
            this.f2929g = recycledViewPool;
            if (recycledViewPool != null) {
                this.f2929g.a(RecyclerView.this.getAdapter());
            }
        }

        void a() {
            int size = this.f2925c.size();
            for (int i = 0; i < size; i++) {
                this.f2925c.get(i).a();
            }
            int size2 = this.f2923a.size();
            for (int i2 = 0; i2 < size2; i2++) {
                this.f2923a.get(i2).a();
            }
            ArrayList<ViewHolder> arrayList = this.f2924b;
            if (arrayList != null) {
                int size3 = arrayList.size();
                for (int i3 = 0; i3 < size3; i3++) {
                    this.f2924b.get(i3).a();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public interface RecyclerListener {
        void onViewRecycled(ViewHolder viewHolder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class RecyclerViewDataObserver extends AdapterDataObserver {
        RecyclerViewDataObserver() {
        }

        void a() {
            if (RecyclerView.f2885e) {
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.C && recyclerView.B) {
                    ViewCompat.postOnAnimation(recyclerView, recyclerView.r);
                    return;
                }
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            recyclerView2.K = true;
            recyclerView2.requestLayout();
        }

        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            RecyclerView.this.b((String) null);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.ra.f2953g = true;
            recyclerView.c(true);
            if (RecyclerView.this.n.c()) {
                return;
            }
            RecyclerView.this.requestLayout();
        }

        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i, int i2, Object obj) {
            RecyclerView.this.b((String) null);
            if (RecyclerView.this.n.a(i, i2, obj)) {
                a();
            }
        }

        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i, int i2) {
            RecyclerView.this.b((String) null);
            if (RecyclerView.this.n.b(i, i2)) {
                a();
            }
        }

        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i, int i2, int i3) {
            RecyclerView.this.b((String) null);
            if (RecyclerView.this.n.a(i, i2, i3)) {
                a();
            }
        }

        @Override // android.support.v7.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i, int i2) {
            RecyclerView.this.b((String) null);
            if (RecyclerView.this.n.c(i, i2)) {
                a();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class SimpleOnItemTouchListener implements OnItemTouchListener {
        @Override // android.support.v7.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            return false;
        }

        @Override // android.support.v7.widget.RecyclerView.OnItemTouchListener
        public void onRequestDisallowInterceptTouchEvent(boolean z) {
        }

        @Override // android.support.v7.widget.RecyclerView.OnItemTouchListener
        public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        }
    }

    /* loaded from: classes.dex */
    public static abstract class SmoothScroller {

        /* renamed from: b, reason: collision with root package name */
        private RecyclerView f2934b;

        /* renamed from: c, reason: collision with root package name */
        private LayoutManager f2935c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f2936d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f2937e;

        /* renamed from: f, reason: collision with root package name */
        private View f2938f;

        /* renamed from: a, reason: collision with root package name */
        private int f2933a = -1;

        /* renamed from: g, reason: collision with root package name */
        private final Action f2939g = new Action(0, 0);

        /* loaded from: classes.dex */
        public static class Action {
            public static final int UNDEFINED_DURATION = Integer.MIN_VALUE;

            /* renamed from: a, reason: collision with root package name */
            private int f2940a;

            /* renamed from: b, reason: collision with root package name */
            private int f2941b;

            /* renamed from: c, reason: collision with root package name */
            private int f2942c;

            /* renamed from: d, reason: collision with root package name */
            private int f2943d;

            /* renamed from: e, reason: collision with root package name */
            private Interpolator f2944e;

            /* renamed from: f, reason: collision with root package name */
            private boolean f2945f;

            /* renamed from: g, reason: collision with root package name */
            private int f2946g;

            public Action(int i, int i2) {
                this(i, i2, Integer.MIN_VALUE, null);
            }

            private void b() {
                if (this.f2944e != null && this.f2942c < 1) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                }
                if (this.f2942c < 1) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
            }

            boolean a() {
                return this.f2943d >= 0;
            }

            public int getDuration() {
                return this.f2942c;
            }

            public int getDx() {
                return this.f2940a;
            }

            public int getDy() {
                return this.f2941b;
            }

            public Interpolator getInterpolator() {
                return this.f2944e;
            }

            public void jumpTo(int i) {
                this.f2943d = i;
            }

            public void setDuration(int i) {
                this.f2945f = true;
                this.f2942c = i;
            }

            public void setDx(int i) {
                this.f2945f = true;
                this.f2940a = i;
            }

            public void setDy(int i) {
                this.f2945f = true;
                this.f2941b = i;
            }

            public void setInterpolator(Interpolator interpolator) {
                this.f2945f = true;
                this.f2944e = interpolator;
            }

            public void update(int i, int i2, int i3, Interpolator interpolator) {
                this.f2940a = i;
                this.f2941b = i2;
                this.f2942c = i3;
                this.f2944e = interpolator;
                this.f2945f = true;
            }

            public Action(int i, int i2, int i3) {
                this(i, i2, i3, null);
            }

            void a(RecyclerView recyclerView) {
                int i = this.f2943d;
                if (i >= 0) {
                    this.f2943d = -1;
                    recyclerView.c(i);
                    this.f2945f = false;
                    return;
                }
                if (this.f2945f) {
                    b();
                    Interpolator interpolator = this.f2944e;
                    if (interpolator == null) {
                        int i2 = this.f2942c;
                        if (i2 == Integer.MIN_VALUE) {
                            recyclerView.oa.smoothScrollBy(this.f2940a, this.f2941b);
                        } else {
                            recyclerView.oa.smoothScrollBy(this.f2940a, this.f2941b, i2);
                        }
                    } else {
                        recyclerView.oa.smoothScrollBy(this.f2940a, this.f2941b, this.f2942c, interpolator);
                    }
                    this.f2946g++;
                    if (this.f2946g > 10) {
                        Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                    }
                    this.f2945f = false;
                    return;
                }
                this.f2946g = 0;
            }

            public Action(int i, int i2, int i3, Interpolator interpolator) {
                this.f2943d = -1;
                this.f2945f = false;
                this.f2946g = 0;
                this.f2940a = i;
                this.f2941b = i2;
                this.f2942c = i3;
                this.f2944e = interpolator;
            }
        }

        /* loaded from: classes.dex */
        public interface ScrollVectorProvider {
            PointF computeScrollVectorForPosition(int i);
        }

        protected abstract void a();

        protected abstract void a(int i, int i2, State state, Action action);

        protected abstract void a(View view, State state, Action action);

        protected abstract void b();

        /* JADX INFO: Access modifiers changed from: protected */
        public final void c() {
            if (this.f2937e) {
                this.f2937e = false;
                b();
                this.f2934b.ra.f2947a = -1;
                this.f2938f = null;
                this.f2933a = -1;
                this.f2936d = false;
                this.f2935c.a(this);
                this.f2935c = null;
                this.f2934b = null;
            }
        }

        public View findViewByPosition(int i) {
            return this.f2934b.w.findViewByPosition(i);
        }

        public int getChildCount() {
            return this.f2934b.w.getChildCount();
        }

        public int getChildPosition(View view) {
            return this.f2934b.getChildLayoutPosition(view);
        }

        public LayoutManager getLayoutManager() {
            return this.f2935c;
        }

        public int getTargetPosition() {
            return this.f2933a;
        }

        @Deprecated
        public void instantScrollToPosition(int i) {
            this.f2934b.scrollToPosition(i);
        }

        public boolean isPendingInitialRun() {
            return this.f2936d;
        }

        public boolean isRunning() {
            return this.f2937e;
        }

        public void setTargetPosition(int i) {
            this.f2933a = i;
        }

        void a(RecyclerView recyclerView, LayoutManager layoutManager) {
            this.f2934b = recyclerView;
            this.f2935c = layoutManager;
            int i = this.f2933a;
            if (i != -1) {
                this.f2934b.ra.f2947a = i;
                this.f2937e = true;
                this.f2936d = true;
                this.f2938f = findViewByPosition(getTargetPosition());
                a();
                this.f2934b.oa.b();
                return;
            }
            throw new IllegalArgumentException("Invalid target position");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i, int i2) {
            RecyclerView recyclerView = this.f2934b;
            if (!this.f2937e || this.f2933a == -1 || recyclerView == null) {
                c();
            }
            this.f2936d = false;
            View view = this.f2938f;
            if (view != null) {
                if (getChildPosition(view) == this.f2933a) {
                    a(this.f2938f, recyclerView.ra, this.f2939g);
                    this.f2939g.a(recyclerView);
                    c();
                } else {
                    Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                    this.f2938f = null;
                }
            }
            if (this.f2937e) {
                a(i, i2, recyclerView.ra, this.f2939g);
                boolean a2 = this.f2939g.a();
                this.f2939g.a(recyclerView);
                if (a2) {
                    if (this.f2937e) {
                        this.f2936d = true;
                        recyclerView.oa.b();
                    } else {
                        c();
                    }
                }
            }
        }

        protected void a(View view) {
            if (getChildPosition(view) == getTargetPosition()) {
                this.f2938f = view;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void a(PointF pointF) {
            float f2 = pointF.x;
            float f3 = pointF.y;
            float sqrt = (float) Math.sqrt((f2 * f2) + (f3 * f3));
            pointF.x /= sqrt;
            pointF.y /= sqrt;
        }
    }

    /* loaded from: classes.dex */
    public static class State {

        /* renamed from: b, reason: collision with root package name */
        private SparseArray<Object> f2948b;
        int m;
        long n;
        int o;
        int p;
        int q;

        /* renamed from: a, reason: collision with root package name */
        private int f2947a = -1;

        /* renamed from: c, reason: collision with root package name */
        int f2949c = 0;

        /* renamed from: d, reason: collision with root package name */
        int f2950d = 0;

        /* renamed from: e, reason: collision with root package name */
        int f2951e = 1;

        /* renamed from: f, reason: collision with root package name */
        int f2952f = 0;

        /* renamed from: g, reason: collision with root package name */
        boolean f2953g = false;

        /* renamed from: h, reason: collision with root package name */
        boolean f2954h = false;
        boolean i = false;
        boolean j = false;
        boolean k = false;
        boolean l = false;

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes.dex */
        @interface LayoutState {
        }

        public boolean didStructureChange() {
            return this.f2953g;
        }

        public <T> T get(int i) {
            SparseArray<Object> sparseArray = this.f2948b;
            if (sparseArray == null) {
                return null;
            }
            return (T) sparseArray.get(i);
        }

        public int getItemCount() {
            return this.f2954h ? this.f2949c - this.f2950d : this.f2952f;
        }

        public int getRemainingScrollHorizontal() {
            return this.p;
        }

        public int getRemainingScrollVertical() {
            return this.q;
        }

        public int getTargetScrollPosition() {
            return this.f2947a;
        }

        public boolean hasTargetScrollPosition() {
            return this.f2947a != -1;
        }

        public boolean isMeasuring() {
            return this.j;
        }

        public boolean isPreLayout() {
            return this.f2954h;
        }

        public void put(int i, Object obj) {
            if (this.f2948b == null) {
                this.f2948b = new SparseArray<>();
            }
            this.f2948b.put(i, obj);
        }

        public void remove(int i) {
            SparseArray<Object> sparseArray = this.f2948b;
            if (sparseArray == null) {
                return;
            }
            sparseArray.remove(i);
        }

        public String toString() {
            return "State{mTargetPosition=" + this.f2947a + ", mData=" + this.f2948b + ", mItemCount=" + this.f2952f + ", mIsMeasuring=" + this.j + ", mPreviousLayoutItemCount=" + this.f2949c + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f2950d + ", mStructureChanged=" + this.f2953g + ", mInPreLayout=" + this.f2954h + ", mRunSimpleAnimations=" + this.k + ", mRunPredictiveAnimations=" + this.l + '}';
        }

        public boolean willRunPredictiveAnimations() {
            return this.l;
        }

        public boolean willRunSimpleAnimations() {
            return this.k;
        }

        void a(int i) {
            if ((this.f2951e & i) != 0) {
                return;
            }
            throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i) + " but it is " + Integer.toBinaryString(this.f2951e));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(Adapter adapter) {
            this.f2951e = 1;
            this.f2952f = adapter.getItemCount();
            this.f2954h = false;
            this.i = false;
            this.j = false;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class ViewCacheExtension {
        public abstract View getViewForPositionAndType(Recycler recycler, int i, int i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class ViewFlinger implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private int f2955a;

        /* renamed from: b, reason: collision with root package name */
        private int f2956b;

        /* renamed from: c, reason: collision with root package name */
        private OverScroller f2957c;

        /* renamed from: d, reason: collision with root package name */
        Interpolator f2958d = RecyclerView.j;

        /* renamed from: e, reason: collision with root package name */
        private boolean f2959e = false;

        /* renamed from: f, reason: collision with root package name */
        private boolean f2960f = false;

        ViewFlinger() {
            this.f2957c = new OverScroller(RecyclerView.this.getContext(), RecyclerView.j);
        }

        private void c() {
            this.f2960f = false;
            this.f2959e = true;
        }

        private void d() {
            this.f2959e = false;
            if (this.f2960f) {
                b();
            }
        }

        void b() {
            if (this.f2959e) {
                this.f2960f = true;
            } else {
                RecyclerView.this.removeCallbacks(this);
                ViewCompat.postOnAnimation(RecyclerView.this, this);
            }
        }

        public void fling(int i, int i2) {
            RecyclerView.this.setScrollState(2);
            this.f2956b = 0;
            this.f2955a = 0;
            this.f2957c.fling(0, 0, i, i2, Integer.MIN_VALUE, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, Integer.MIN_VALUE, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            b();
        }

        /* JADX WARN: Code restructure failed: missing block: B:60:0x0128, code lost:            if (r8 > 0) goto L57;     */
        /* JADX WARN: Removed duplicated region for block: B:46:0x0124  */
        /* JADX WARN: Removed duplicated region for block: B:50:0x0134  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x013b A[ADDED_TO_REGION] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 481
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.RecyclerView.ViewFlinger.run():void");
        }

        public void smoothScrollBy(int i, int i2) {
            smoothScrollBy(i, i2, 0, 0);
        }

        public void stop() {
            RecyclerView.this.removeCallbacks(this);
            this.f2957c.abortAnimation();
        }

        private float a(float f2) {
            return (float) Math.sin((f2 - 0.5f) * 0.47123894f);
        }

        public void smoothScrollBy(int i, int i2, int i3, int i4) {
            smoothScrollBy(i, i2, a(i, i2, i3, i4));
        }

        private int a(int i, int i2, int i3, int i4) {
            int i5;
            int abs = Math.abs(i);
            int abs2 = Math.abs(i2);
            boolean z = abs > abs2;
            int sqrt = (int) Math.sqrt((i3 * i3) + (i4 * i4));
            int sqrt2 = (int) Math.sqrt((i * i) + (i2 * i2));
            int width = z ? RecyclerView.this.getWidth() : RecyclerView.this.getHeight();
            int i6 = width / 2;
            float f2 = width;
            float f3 = i6;
            float a2 = f3 + (a(Math.min(1.0f, (sqrt2 * 1.0f) / f2)) * f3);
            if (sqrt > 0) {
                i5 = Math.round(Math.abs(a2 / sqrt) * 1000.0f) * 4;
            } else {
                if (!z) {
                    abs = abs2;
                }
                i5 = (int) (((abs / f2) + 1.0f) * 300.0f);
            }
            return Math.min(i5, SemanticAnnotations.SemanticType.ST_THIRD_PARTY_DATA_VALUE);
        }

        public void smoothScrollBy(int i, int i2, int i3) {
            smoothScrollBy(i, i2, i3, RecyclerView.j);
        }

        public void smoothScrollBy(int i, int i2, Interpolator interpolator) {
            int a2 = a(i, i2, 0, 0);
            if (interpolator == null) {
                interpolator = RecyclerView.j;
            }
            smoothScrollBy(i, i2, a2, interpolator);
        }

        public void smoothScrollBy(int i, int i2, int i3, Interpolator interpolator) {
            if (this.f2958d != interpolator) {
                this.f2958d = interpolator;
                this.f2957c = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            RecyclerView.this.setScrollState(2);
            this.f2956b = 0;
            this.f2955a = 0;
            this.f2957c.startScroll(0, 0, i, i2, i3);
            if (Build.VERSION.SDK_INT < 23) {
                this.f2957c.computeScrollOffset();
            }
            b();
        }
    }

    /* loaded from: classes.dex */
    public static abstract class ViewHolder {

        /* renamed from: a, reason: collision with root package name */
        private static final List<Object> f2962a = Collections.EMPTY_LIST;

        /* renamed from: b, reason: collision with root package name */
        WeakReference<RecyclerView> f2963b;
        public final View itemView;
        private int j;
        RecyclerView r;

        /* renamed from: c, reason: collision with root package name */
        int f2964c = -1;

        /* renamed from: d, reason: collision with root package name */
        int f2965d = -1;

        /* renamed from: e, reason: collision with root package name */
        long f2966e = -1;

        /* renamed from: f, reason: collision with root package name */
        int f2967f = -1;

        /* renamed from: g, reason: collision with root package name */
        int f2968g = -1;

        /* renamed from: h, reason: collision with root package name */
        ViewHolder f2969h = null;
        ViewHolder i = null;
        List<Object> k = null;
        List<Object> l = null;
        private int m = 0;
        private Recycler n = null;
        private boolean o = false;
        private int p = 0;
        int q = -1;

        public ViewHolder(View view) {
            if (view != null) {
                this.itemView = view;
                return;
            }
            throw new IllegalArgumentException("itemView may not be null");
        }

        private void t() {
            if (this.k == null) {
                this.k = new ArrayList();
                this.l = Collections.unmodifiableList(this.k);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean u() {
            return (this.j & 16) == 0 && ViewCompat.hasTransientState(this.itemView);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean v() {
            return (this.j & 16) != 0;
        }

        List<Object> e() {
            if ((this.j & 1024) == 0) {
                List<Object> list = this.k;
                if (list != null && list.size() != 0) {
                    return this.l;
                }
                return f2962a;
            }
            return f2962a;
        }

        boolean f() {
            return (this.j & 512) != 0 || h();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean g() {
            return (this.j & 1) != 0;
        }

        public final int getAdapterPosition() {
            RecyclerView recyclerView = this.r;
            if (recyclerView == null) {
                return -1;
            }
            return recyclerView.c(this);
        }

        public final long getItemId() {
            return this.f2966e;
        }

        public final int getItemViewType() {
            return this.f2967f;
        }

        public final int getLayoutPosition() {
            int i = this.f2968g;
            return i == -1 ? this.f2964c : i;
        }

        public final int getOldPosition() {
            return this.f2965d;
        }

        @Deprecated
        public final int getPosition() {
            int i = this.f2968g;
            return i == -1 ? this.f2964c : i;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean h() {
            return (this.j & 4) != 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean i() {
            return (this.j & 8) != 0;
        }

        public final boolean isRecyclable() {
            return (this.j & 16) == 0 && !ViewCompat.hasTransientState(this.itemView);
        }

        boolean j() {
            return this.n != null;
        }

        boolean k() {
            return (this.j & 256) != 0;
        }

        boolean l() {
            return (this.j & 2) != 0;
        }

        boolean m() {
            return (this.j & 2) != 0;
        }

        void n() {
            this.j = 0;
            this.f2964c = -1;
            this.f2965d = -1;
            this.f2966e = -1L;
            this.f2968g = -1;
            this.m = 0;
            this.f2969h = null;
            this.i = null;
            b();
            this.p = 0;
            this.q = -1;
            RecyclerView.b(this);
        }

        void o() {
            if (this.f2965d == -1) {
                this.f2965d = this.f2964c;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean p() {
            return (this.j & 128) != 0;
        }

        void q() {
            this.j &= -129;
        }

        void r() {
            this.n.c(this);
        }

        boolean s() {
            return (this.j & 32) != 0;
        }

        public final void setIsRecyclable(boolean z) {
            this.m = z ? this.m - 1 : this.m + 1;
            int i = this.m;
            if (i < 0) {
                this.m = 0;
                Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
                return;
            }
            if (!z && i == 1) {
                this.j |= 16;
            } else if (z && this.m == 0) {
                this.j &= -17;
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("ViewHolder{" + Integer.toHexString(hashCode()) + " position=" + this.f2964c + " id=" + this.f2966e + ", oldPos=" + this.f2965d + ", pLpos:" + this.f2968g);
            if (j()) {
                sb.append(" scrap ");
                sb.append(this.o ? "[changeScrap]" : "[attachedScrap]");
            }
            if (h()) {
                sb.append(" invalid");
            }
            if (!g()) {
                sb.append(" unbound");
            }
            if (m()) {
                sb.append(" update");
            }
            if (i()) {
                sb.append(" removed");
            }
            if (p()) {
                sb.append(" ignored");
            }
            if (k()) {
                sb.append(" tmpDetached");
            }
            if (!isRecyclable()) {
                sb.append(" not recyclable(" + this.m + ")");
            }
            if (f()) {
                sb.append(" undefined adapter position");
            }
            if (this.itemView.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append("}");
            return sb.toString();
        }

        void c() {
            this.j &= -33;
        }

        void d() {
            this.j &= -257;
        }

        boolean b(int i) {
            return (i & this.j) != 0;
        }

        void b() {
            List<Object> list = this.k;
            if (list != null) {
                list.clear();
            }
            this.j &= -1025;
        }

        void a(int i, int i2, boolean z) {
            a(8);
            a(i2, z);
            this.f2964c = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(RecyclerView recyclerView) {
            recyclerView.a(this, this.p);
            this.p = 0;
        }

        void a(int i, boolean z) {
            if (this.f2965d == -1) {
                this.f2965d = this.f2964c;
            }
            if (this.f2968g == -1) {
                this.f2968g = this.f2964c;
            }
            if (z) {
                this.f2968g += i;
            }
            this.f2964c += i;
            if (this.itemView.getLayoutParams() != null) {
                ((LayoutParams) this.itemView.getLayoutParams()).f2915c = true;
            }
        }

        void a() {
            this.f2965d = -1;
            this.f2968g = -1;
        }

        void a(Recycler recycler, boolean z) {
            this.n = recycler;
            this.o = z;
        }

        void a(int i, int i2) {
            this.j = (i & i2) | (this.j & (i2 ^ (-1)));
        }

        void a(int i) {
            this.j = i | this.j;
        }

        void a(Object obj) {
            if (obj == null) {
                a(1024);
            } else if ((1024 & this.j) == 0) {
                t();
                this.k.add(obj);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(RecyclerView recyclerView) {
            int i = this.q;
            if (i != -1) {
                this.p = i;
            } else {
                this.p = ViewCompat.getImportantForAccessibility(this.itemView);
            }
            recyclerView.a(this, 4);
        }
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        f2883c = i2 == 18 || i2 == 19 || i2 == 20;
        f2884d = Build.VERSION.SDK_INT >= 23;
        f2885e = Build.VERSION.SDK_INT >= 16;
        f2886f = Build.VERSION.SDK_INT >= 21;
        f2887g = Build.VERSION.SDK_INT <= 15;
        f2888h = Build.VERSION.SDK_INT <= 15;
        Class<?> cls = Integer.TYPE;
        i = new Class[]{Context.class, AttributeSet.class, cls, cls};
        j = new Interpolator() { // from class: android.support.v7.widget.RecyclerView.3
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f2) {
                float f3 = f2 - 1.0f;
                return (f3 * f3 * f3 * f3 * f3) + 1.0f;
            }
        };
    }

    public RecyclerView(Context context) {
        this(context, null);
    }

    private void I() {
        V();
        setScrollState(0);
    }

    private void J() {
        int i2 = this.J;
        this.J = 0;
        if (i2 == 0 || !y()) {
            return;
        }
        AccessibilityEvent obtain = AccessibilityEvent.obtain();
        obtain.setEventType(2048);
        AccessibilityEventCompat.setContentChangeTypes(obtain, i2);
        sendAccessibilityEventUnchecked(obtain);
    }

    private void K() {
        this.ra.a(1);
        a(this.ra);
        this.ra.j = false;
        H();
        this.p.a();
        B();
        R();
        W();
        State state = this.ra;
        state.i = state.k && this.va;
        this.va = false;
        this.ua = false;
        State state2 = this.ra;
        state2.f2954h = state2.l;
        state2.f2952f = this.v.getItemCount();
        a(this.Aa);
        if (this.ra.k) {
            int a2 = this.o.a();
            for (int i2 = 0; i2 < a2; i2++) {
                ViewHolder d2 = d(this.o.c(i2));
                if (!d2.p() && (!d2.h() || this.v.hasStableIds())) {
                    this.p.c(d2, this.W.recordPreLayoutInformation(this.ra, d2, ItemAnimator.a(d2), d2.e()));
                    if (this.ra.i && d2.l() && !d2.i() && !d2.p() && !d2.h()) {
                        this.p.a(d(d2), d2);
                    }
                }
            }
        }
        if (this.ra.l) {
            G();
            State state3 = this.ra;
            boolean z = state3.f2953g;
            state3.f2953g = false;
            this.w.onLayoutChildren(this.l, state3);
            this.ra.f2953g = z;
            for (int i3 = 0; i3 < this.o.a(); i3++) {
                ViewHolder d3 = d(this.o.c(i3));
                if (!d3.p() && !this.p.c(d3)) {
                    int a3 = ItemAnimator.a(d3);
                    boolean b2 = d3.b(8192);
                    if (!b2) {
                        a3 |= 4096;
                    }
                    ItemAnimator.ItemHolderInfo recordPreLayoutInformation = this.W.recordPreLayoutInformation(this.ra, d3, a3, d3.e());
                    if (b2) {
                        a(d3, recordPreLayoutInformation);
                    } else {
                        this.p.a(d3, recordPreLayoutInformation);
                    }
                }
            }
            n();
        } else {
            n();
        }
        C();
        d(false);
        this.ra.f2951e = 2;
    }

    private void L() {
        H();
        B();
        this.ra.a(6);
        this.n.b();
        this.ra.f2952f = this.v.getItemCount();
        State state = this.ra;
        state.f2950d = 0;
        state.f2954h = false;
        this.w.onLayoutChildren(this.l, state);
        State state2 = this.ra;
        state2.f2953g = false;
        this.m = null;
        state2.k = state2.k && this.W != null;
        this.ra.f2951e = 4;
        C();
        d(false);
    }

    private void M() {
        this.ra.a(4);
        H();
        B();
        State state = this.ra;
        state.f2951e = 1;
        if (state.k) {
            for (int a2 = this.o.a() - 1; a2 >= 0; a2--) {
                ViewHolder d2 = d(this.o.c(a2));
                if (!d2.p()) {
                    long d3 = d(d2);
                    ItemAnimator.ItemHolderInfo recordPostLayoutInformation = this.W.recordPostLayoutInformation(this.ra, d2);
                    ViewHolder a3 = this.p.a(d3);
                    if (a3 != null && !a3.p()) {
                        boolean b2 = this.p.b(a3);
                        boolean b3 = this.p.b(d2);
                        if (b2 && a3 == d2) {
                            this.p.b(d2, recordPostLayoutInformation);
                        } else {
                            ItemAnimator.ItemHolderInfo e2 = this.p.e(a3);
                            this.p.b(d2, recordPostLayoutInformation);
                            ItemAnimator.ItemHolderInfo d4 = this.p.d(d2);
                            if (e2 == null) {
                                a(d3, d2, a3);
                            } else {
                                a(a3, d2, e2, d4, b2, b3);
                            }
                        }
                    } else {
                        this.p.b(d2, recordPostLayoutInformation);
                    }
                }
            }
            this.p.a(this.Ha);
        }
        this.w.a(this.l);
        State state2 = this.ra;
        state2.f2949c = state2.f2952f;
        this.N = false;
        this.O = false;
        state2.k = false;
        state2.l = false;
        this.w.f2910h = false;
        ArrayList<ViewHolder> arrayList = this.l.f2924b;
        if (arrayList != null) {
            arrayList.clear();
        }
        LayoutManager layoutManager = this.w;
        if (layoutManager.n) {
            layoutManager.m = 0;
            layoutManager.n = false;
            this.l.h();
        }
        this.w.onLayoutCompleted(this.ra);
        C();
        d(false);
        this.p.a();
        int[] iArr = this.Aa;
        if (g(iArr[0], iArr[1])) {
            d(0, 0);
        }
        S();
        U();
    }

    private View N() {
        ViewHolder findViewHolderForAdapterPosition;
        int i2 = this.ra.m;
        if (i2 == -1) {
            i2 = 0;
        }
        int itemCount = this.ra.getItemCount();
        for (int i3 = i2; i3 < itemCount; i3++) {
            ViewHolder findViewHolderForAdapterPosition2 = findViewHolderForAdapterPosition(i3);
            if (findViewHolderForAdapterPosition2 == null) {
                break;
            }
            if (findViewHolderForAdapterPosition2.itemView.hasFocusable()) {
                return findViewHolderForAdapterPosition2.itemView;
            }
        }
        int min = Math.min(itemCount, i2);
        do {
            min--;
            if (min < 0 || (findViewHolderForAdapterPosition = findViewHolderForAdapterPosition(min)) == null) {
                return null;
            }
        } while (!findViewHolderForAdapterPosition.itemView.hasFocusable());
        return findViewHolderForAdapterPosition.itemView;
    }

    private boolean O() {
        int a2 = this.o.a();
        for (int i2 = 0; i2 < a2; i2++) {
            ViewHolder d2 = d(this.o.c(i2));
            if (d2 != null && !d2.p() && d2.l()) {
                return true;
            }
        }
        return false;
    }

    private void P() {
        this.o = new ChildHelper(new ChildHelper.Callback() { // from class: android.support.v7.widget.RecyclerView.5
            @Override // android.support.v7.widget.ChildHelper.Callback
            public void addView(View view, int i2) {
                RecyclerView.this.addView(view, i2);
                RecyclerView.this.a(view);
            }

            @Override // android.support.v7.widget.ChildHelper.Callback
            public void attachViewToParent(View view, int i2, ViewGroup.LayoutParams layoutParams) {
                ViewHolder d2 = RecyclerView.d(view);
                if (d2 != null) {
                    if (!d2.k() && !d2.p()) {
                        throw new IllegalArgumentException("Called attach on a child which is not detached: " + d2 + RecyclerView.this.v());
                    }
                    d2.d();
                }
                RecyclerView.this.attachViewToParent(view, i2, layoutParams);
            }

            @Override // android.support.v7.widget.ChildHelper.Callback
            public void detachViewFromParent(int i2) {
                ViewHolder d2;
                View childAt = getChildAt(i2);
                if (childAt != null && (d2 = RecyclerView.d(childAt)) != null) {
                    if (d2.k() && !d2.p()) {
                        throw new IllegalArgumentException("called detach on an already detached child " + d2 + RecyclerView.this.v());
                    }
                    d2.a(256);
                }
                RecyclerView.this.detachViewFromParent(i2);
            }

            @Override // android.support.v7.widget.ChildHelper.Callback
            public View getChildAt(int i2) {
                return RecyclerView.this.getChildAt(i2);
            }

            @Override // android.support.v7.widget.ChildHelper.Callback
            public int getChildCount() {
                return RecyclerView.this.getChildCount();
            }

            @Override // android.support.v7.widget.ChildHelper.Callback
            public ViewHolder getChildViewHolder(View view) {
                return RecyclerView.d(view);
            }

            @Override // android.support.v7.widget.ChildHelper.Callback
            public int indexOfChild(View view) {
                return RecyclerView.this.indexOfChild(view);
            }

            @Override // android.support.v7.widget.ChildHelper.Callback
            public void onEnteredHiddenState(View view) {
                ViewHolder d2 = RecyclerView.d(view);
                if (d2 != null) {
                    d2.a(RecyclerView.this);
                }
            }

            @Override // android.support.v7.widget.ChildHelper.Callback
            public void onLeftHiddenState(View view) {
                ViewHolder d2 = RecyclerView.d(view);
                if (d2 != null) {
                    d2.b(RecyclerView.this);
                }
            }

            @Override // android.support.v7.widget.ChildHelper.Callback
            public void removeAllViews() {
                int childCount = getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = getChildAt(i2);
                    RecyclerView.this.b(childAt);
                    childAt.clearAnimation();
                }
                RecyclerView.this.removeAllViews();
            }

            @Override // android.support.v7.widget.ChildHelper.Callback
            public void removeViewAt(int i2) {
                View childAt = RecyclerView.this.getChildAt(i2);
                if (childAt != null) {
                    RecyclerView.this.b(childAt);
                    childAt.clearAnimation();
                }
                RecyclerView.this.removeViewAt(i2);
            }
        });
    }

    private boolean Q() {
        return this.W != null && this.w.supportsPredictiveItemAnimations();
    }

    private void R() {
        if (this.N) {
            this.n.f();
            if (this.O) {
                this.w.onItemsChanged(this);
            }
        }
        if (Q()) {
            this.n.e();
        } else {
            this.n.b();
        }
        boolean z = false;
        boolean z2 = this.ua || this.va;
        this.ra.k = this.E && this.W != null && (this.N || z2 || this.w.f2910h) && (!this.N || this.v.hasStableIds());
        State state = this.ra;
        if (state.k && z2 && !this.N && Q()) {
            z = true;
        }
        state.l = z;
    }

    private void S() {
        View view;
        if (!this.na || this.v == null || !hasFocus() || getDescendantFocusability() == 393216) {
            return;
        }
        if (getDescendantFocusability() == 131072 && isFocused()) {
            return;
        }
        if (!isFocused()) {
            View focusedChild = getFocusedChild();
            if (f2888h && (focusedChild.getParent() == null || !focusedChild.hasFocus())) {
                if (this.o.a() == 0) {
                    requestFocus();
                    return;
                }
            } else if (!this.o.c(focusedChild)) {
                return;
            }
        }
        View view2 = null;
        ViewHolder findViewHolderForItemId = (this.ra.n == -1 || !this.v.hasStableIds()) ? null : findViewHolderForItemId(this.ra.n);
        if (findViewHolderForItemId != null && !this.o.c(findViewHolderForItemId.itemView) && findViewHolderForItemId.itemView.hasFocusable()) {
            view2 = findViewHolderForItemId.itemView;
        } else if (this.o.a() > 0) {
            view2 = N();
        }
        if (view2 != null) {
            int i2 = this.ra.o;
            if (i2 == -1 || (view = view2.findViewById(i2)) == null || !view.isFocusable()) {
                view = view2;
            }
            view.requestFocus();
        }
    }

    private void T() {
        boolean z;
        EdgeEffect edgeEffect = this.S;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            z = this.S.isFinished();
        } else {
            z = false;
        }
        EdgeEffect edgeEffect2 = this.T;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            z |= this.T.isFinished();
        }
        EdgeEffect edgeEffect3 = this.U;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            z |= this.U.isFinished();
        }
        EdgeEffect edgeEffect4 = this.V;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            z |= this.V.isFinished();
        }
        if (z) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    private void U() {
        State state = this.ra;
        state.n = -1L;
        state.m = -1;
        state.o = -1;
    }

    private void V() {
        VelocityTracker velocityTracker = this.ca;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        stopNestedScroll(0);
        T();
    }

    private void W() {
        int adapterPosition;
        View focusedChild = (this.na && hasFocus() && this.v != null) ? getFocusedChild() : null;
        ViewHolder findContainingViewHolder = focusedChild != null ? findContainingViewHolder(focusedChild) : null;
        if (findContainingViewHolder == null) {
            U();
            return;
        }
        this.ra.n = this.v.hasStableIds() ? findContainingViewHolder.getItemId() : -1L;
        State state = this.ra;
        if (this.N) {
            adapterPosition = -1;
        } else {
            adapterPosition = findContainingViewHolder.i() ? findContainingViewHolder.f2965d : findContainingViewHolder.getAdapterPosition();
        }
        state.m = adapterPosition;
        this.ra.o = g(findContainingViewHolder.itemView);
    }

    private void X() {
        this.oa.stop();
        LayoutManager layoutManager = this.w;
        if (layoutManager != null) {
            layoutManager.c();
        }
    }

    private void e(ViewHolder viewHolder) {
        View view = viewHolder.itemView;
        boolean z = view.getParent() == this;
        this.l.c(getChildViewHolder(view));
        if (viewHolder.k()) {
            this.o.a(view, -1, view.getLayoutParams(), true);
        } else if (!z) {
            this.o.a(view, true);
        } else {
            this.o.a(view);
        }
    }

    private int g(View view) {
        int id = view.getId();
        while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
            view = ((ViewGroup) view).getFocusedChild();
            if (view.getId() != -1) {
                id = view.getId();
            }
        }
        return id;
    }

    private NestedScrollingChildHelper getScrollingChildHelper() {
        if (this.Ba == null) {
            this.Ba = new NestedScrollingChildHelper(this);
        }
        return this.Ba;
    }

    void A() {
        int b2 = this.o.b();
        for (int i2 = 0; i2 < b2; i2++) {
            ViewHolder d2 = d(this.o.d(i2));
            if (d2 != null && !d2.p()) {
                d2.a(6);
            }
        }
        z();
        this.l.f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B() {
        this.P++;
    }

    void C() {
        b(true);
    }

    void D() {
        if (this.xa || !this.B) {
            return;
        }
        ViewCompat.postOnAnimation(this, this.Ga);
        this.xa = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void E() {
        ItemAnimator itemAnimator = this.W;
        if (itemAnimator != null) {
            itemAnimator.endAnimations();
        }
        LayoutManager layoutManager = this.w;
        if (layoutManager != null) {
            layoutManager.removeAndRecycleAllViews(this.l);
            this.w.a(this.l);
        }
        this.l.clear();
    }

    void F() {
        ViewHolder viewHolder;
        int a2 = this.o.a();
        for (int i2 = 0; i2 < a2; i2++) {
            View c2 = this.o.c(i2);
            ViewHolder childViewHolder = getChildViewHolder(c2);
            if (childViewHolder != null && (viewHolder = childViewHolder.i) != null) {
                View view = viewHolder.itemView;
                int left = c2.getLeft();
                int top = c2.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    void G() {
        int b2 = this.o.b();
        for (int i2 = 0; i2 < b2; i2++) {
            ViewHolder d2 = d(this.o.d(i2));
            if (!d2.p()) {
                d2.o();
            }
        }
    }

    void H() {
        this.F++;
        if (this.F != 1 || this.H) {
            return;
        }
        this.G = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        LayoutManager layoutManager = this.w;
        if (layoutManager == null || !layoutManager.onAddFocusables(this, arrayList, i2, i3)) {
            super.addFocusables(arrayList, i2, i3);
        }
    }

    public void addItemDecoration(ItemDecoration itemDecoration, int i2) {
        LayoutManager layoutManager = this.w;
        if (layoutManager != null) {
            layoutManager.assertNotInLayoutOrScroll("Cannot add item decoration during a scroll  or layout");
        }
        if (this.y.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i2 < 0) {
            this.y.add(itemDecoration);
        } else {
            this.y.add(i2, itemDecoration);
        }
        z();
        requestLayout();
    }

    public void addOnChildAttachStateChangeListener(OnChildAttachStateChangeListener onChildAttachStateChangeListener) {
        if (this.M == null) {
            this.M = new ArrayList();
        }
        this.M.add(onChildAttachStateChangeListener);
    }

    public void addOnItemTouchListener(OnItemTouchListener onItemTouchListener) {
        this.z.add(onItemTouchListener);
    }

    public void addOnScrollListener(OnScrollListener onScrollListener) {
        if (this.ta == null) {
            this.ta = new ArrayList();
        }
        this.ta.add(onScrollListener);
    }

    void c(int i2) {
        LayoutManager layoutManager = this.w;
        if (layoutManager == null) {
            return;
        }
        layoutManager.scrollToPosition(i2);
        awakenScrollBars();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && this.w.checkLayoutParams((LayoutParams) layoutParams);
    }

    public void clearOnChildAttachStateChangeListeners() {
        List<OnChildAttachStateChangeListener> list = this.M;
        if (list != null) {
            list.clear();
        }
    }

    public void clearOnScrollListeners() {
        List<OnScrollListener> list = this.ta;
        if (list != null) {
            list.clear();
        }
    }

    @Override // android.view.View, android.support.v4.view.ScrollingView
    public int computeHorizontalScrollExtent() {
        LayoutManager layoutManager = this.w;
        if (layoutManager != null && layoutManager.canScrollHorizontally()) {
            return this.w.computeHorizontalScrollExtent(this.ra);
        }
        return 0;
    }

    @Override // android.view.View, android.support.v4.view.ScrollingView
    public int computeHorizontalScrollOffset() {
        LayoutManager layoutManager = this.w;
        if (layoutManager != null && layoutManager.canScrollHorizontally()) {
            return this.w.computeHorizontalScrollOffset(this.ra);
        }
        return 0;
    }

    @Override // android.view.View, android.support.v4.view.ScrollingView
    public int computeHorizontalScrollRange() {
        LayoutManager layoutManager = this.w;
        if (layoutManager != null && layoutManager.canScrollHorizontally()) {
            return this.w.computeHorizontalScrollRange(this.ra);
        }
        return 0;
    }

    @Override // android.view.View, android.support.v4.view.ScrollingView
    public int computeVerticalScrollExtent() {
        LayoutManager layoutManager = this.w;
        if (layoutManager != null && layoutManager.canScrollVertically()) {
            return this.w.computeVerticalScrollExtent(this.ra);
        }
        return 0;
    }

    @Override // android.view.View, android.support.v4.view.ScrollingView
    public int computeVerticalScrollOffset() {
        LayoutManager layoutManager = this.w;
        if (layoutManager != null && layoutManager.canScrollVertically()) {
            return this.w.computeVerticalScrollOffset(this.ra);
        }
        return 0;
    }

    @Override // android.view.View, android.support.v4.view.ScrollingView
    public int computeVerticalScrollRange() {
        LayoutManager layoutManager = this.w;
        if (layoutManager != null && layoutManager.canScrollVertically()) {
            return this.w.computeVerticalScrollRange(this.ra);
        }
        return 0;
    }

    void d(boolean z) {
        if (this.F < 1) {
            this.F = 1;
        }
        if (!z && !this.H) {
            this.G = false;
        }
        if (this.F == 1) {
            if (z && this.G && !this.H && this.w != null && this.v != null) {
                p();
            }
            if (!this.H) {
                this.G = false;
            }
        }
        this.F--;
    }

    @Override // android.view.View, android.support.v4.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f2, float f3, boolean z) {
        return getScrollingChildHelper().dispatchNestedFling(f2, f3, z);
    }

    @Override // android.view.View, android.support.v4.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f2, float f3) {
        return getScrollingChildHelper().dispatchNestedPreFling(f2, f3);
    }

    @Override // android.view.View, android.support.v4.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().dispatchNestedPreScroll(i2, i3, iArr, iArr2);
    }

    @Override // android.view.View, android.support.v4.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return getScrollingChildHelper().dispatchNestedScroll(i2, i3, i4, i5, iArr);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean z;
        boolean z2;
        super.draw(canvas);
        int size = this.y.size();
        boolean z3 = false;
        for (int i2 = 0; i2 < size; i2++) {
            this.y.get(i2).onDrawOver(canvas, this, this.ra);
        }
        EdgeEffect edgeEffect = this.S;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z = false;
        } else {
            int save = canvas.save();
            int paddingBottom = this.q ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + paddingBottom, 0.0f);
            EdgeEffect edgeEffect2 = this.S;
            z = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(save);
        }
        EdgeEffect edgeEffect3 = this.T;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int save2 = canvas.save();
            if (this.q) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.T;
            z |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(save2);
        }
        EdgeEffect edgeEffect5 = this.U;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int save3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.q ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(-paddingTop, -width);
            EdgeEffect edgeEffect6 = this.U;
            z |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(save3);
        }
        EdgeEffect edgeEffect7 = this.V;
        if (edgeEffect7 == null || edgeEffect7.isFinished()) {
            z2 = z;
        } else {
            int save4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.q) {
                canvas.translate((-getWidth()) + getPaddingRight(), (-getHeight()) + getPaddingBottom());
            } else {
                canvas.translate(-getWidth(), -getHeight());
            }
            EdgeEffect edgeEffect8 = this.V;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z3 = true;
            }
            z2 = z3 | z;
            canvas.restoreToCount(save4);
        }
        if (!z2 && this.W != null && this.y.size() > 0 && this.W.isRunning()) {
            z2 = true;
        }
        if (z2) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j2) {
        return super.drawChild(canvas, view, j2);
    }

    boolean f(View view) {
        H();
        boolean e2 = this.o.e(view);
        if (e2) {
            ViewHolder d2 = d(view);
            this.l.c(d2);
            this.l.b(d2);
        }
        d(!e2);
        return e2;
    }

    public View findChildViewUnder(float f2, float f3) {
        for (int a2 = this.o.a() - 1; a2 >= 0; a2--) {
            View c2 = this.o.c(a2);
            float translationX = c2.getTranslationX();
            float translationY = c2.getTranslationY();
            if (f2 >= c2.getLeft() + translationX && f2 <= c2.getRight() + translationX && f3 >= c2.getTop() + translationY && f3 <= c2.getBottom() + translationY) {
                return c2;
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:?, code lost:            return r3;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.View findContainingItemView(android.view.View r3) {
        /*
            r2 = this;
            android.view.ViewParent r0 = r3.getParent()
        L4:
            if (r0 == 0) goto L14
            if (r0 == r2) goto L14
            boolean r1 = r0 instanceof android.view.View
            if (r1 == 0) goto L14
            r3 = r0
            android.view.View r3 = (android.view.View) r3
            android.view.ViewParent r0 = r3.getParent()
            goto L4
        L14:
            if (r0 != r2) goto L17
            goto L18
        L17:
            r3 = 0
        L18:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.RecyclerView.findContainingItemView(android.view.View):android.view.View");
    }

    public ViewHolder findContainingViewHolder(View view) {
        View findContainingItemView = findContainingItemView(view);
        if (findContainingItemView == null) {
            return null;
        }
        return getChildViewHolder(findContainingItemView);
    }

    public ViewHolder findViewHolderForAdapterPosition(int i2) {
        ViewHolder viewHolder = null;
        if (this.N) {
            return null;
        }
        int b2 = this.o.b();
        for (int i3 = 0; i3 < b2; i3++) {
            ViewHolder d2 = d(this.o.d(i3));
            if (d2 != null && !d2.i() && c(d2) == i2) {
                if (!this.o.c(d2.itemView)) {
                    return d2;
                }
                viewHolder = d2;
            }
        }
        return viewHolder;
    }

    public ViewHolder findViewHolderForItemId(long j2) {
        Adapter adapter = this.v;
        ViewHolder viewHolder = null;
        if (adapter != null && adapter.hasStableIds()) {
            int b2 = this.o.b();
            for (int i2 = 0; i2 < b2; i2++) {
                ViewHolder d2 = d(this.o.d(i2));
                if (d2 != null && !d2.i() && d2.getItemId() == j2) {
                    if (!this.o.c(d2.itemView)) {
                        return d2;
                    }
                    viewHolder = d2;
                }
            }
        }
        return viewHolder;
    }

    public ViewHolder findViewHolderForLayoutPosition(int i2) {
        return b(i2, false);
    }

    @Deprecated
    public ViewHolder findViewHolderForPosition(int i2) {
        return b(i2, false);
    }

    public boolean fling(int i2, int i3) {
        LayoutManager layoutManager = this.w;
        if (layoutManager == null) {
            Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        }
        if (this.H) {
            return false;
        }
        boolean canScrollHorizontally = layoutManager.canScrollHorizontally();
        boolean canScrollVertically = this.w.canScrollVertically();
        if (!canScrollHorizontally || Math.abs(i2) < this.ja) {
            i2 = 0;
        }
        if (!canScrollVertically || Math.abs(i3) < this.ja) {
            i3 = 0;
        }
        if (i2 == 0 && i3 == 0) {
            return false;
        }
        float f2 = i2;
        float f3 = i3;
        if (!dispatchNestedPreFling(f2, f3)) {
            boolean z = canScrollHorizontally || canScrollVertically;
            dispatchNestedFling(f2, f3, z);
            OnFlingListener onFlingListener = this.ia;
            if (onFlingListener != null && onFlingListener.onFling(i2, i3)) {
                return true;
            }
            if (z) {
                int i4 = canScrollHorizontally ? 1 : 0;
                if (canScrollVertically) {
                    i4 |= 2;
                }
                startNestedScroll(i4, 1);
                int i5 = this.ka;
                int max = Math.max(-i5, Math.min(i2, i5));
                int i6 = this.ka;
                this.oa.fling(max, Math.max(-i6, Math.min(i3, i6)));
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View view, int i2) {
        View view2;
        boolean z;
        View onInterceptFocusSearch = this.w.onInterceptFocusSearch(view, i2);
        if (onInterceptFocusSearch != null) {
            return onInterceptFocusSearch;
        }
        boolean z2 = (this.v == null || this.w == null || isComputingLayout() || this.H) ? false : true;
        FocusFinder focusFinder = FocusFinder.getInstance();
        if (z2 && (i2 == 2 || i2 == 1)) {
            if (this.w.canScrollVertically()) {
                int i3 = i2 == 2 ? 130 : 33;
                z = focusFinder.findNextFocus(this, view, i3) == null;
                if (f2887g) {
                    i2 = i3;
                }
            } else {
                z = false;
            }
            if (!z && this.w.canScrollHorizontally()) {
                int i4 = (this.w.getLayoutDirection() == 1) ^ (i2 == 2) ? 66 : 17;
                z = focusFinder.findNextFocus(this, view, i4) == null;
                if (f2887g) {
                    i2 = i4;
                }
            }
            if (z) {
                o();
                if (findContainingItemView(view) == null) {
                    return null;
                }
                H();
                this.w.onFocusSearchFailed(view, i2, this.l, this.ra);
                d(false);
            }
            view2 = focusFinder.findNextFocus(this, view, i2);
        } else {
            View findNextFocus = focusFinder.findNextFocus(this, view, i2);
            if (findNextFocus == null && z2) {
                o();
                if (findContainingItemView(view) == null) {
                    return null;
                }
                H();
                view2 = this.w.onFocusSearchFailed(view, i2, this.l, this.ra);
                d(false);
            } else {
                view2 = findNextFocus;
            }
        }
        if (view2 == null || view2.hasFocusable()) {
            return a(view, view2, i2) ? view2 : super.focusSearch(view, i2);
        }
        if (getFocusedChild() == null) {
            return super.focusSearch(view, i2);
        }
        a(view2, (View) null);
        return view;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        LayoutManager layoutManager = this.w;
        if (layoutManager != null) {
            return layoutManager.generateDefaultLayoutParams();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + v());
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        LayoutManager layoutManager = this.w;
        if (layoutManager != null) {
            return layoutManager.generateLayoutParams(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + v());
    }

    public Adapter getAdapter() {
        return this.v;
    }

    @Override // android.view.View
    public int getBaseline() {
        LayoutManager layoutManager = this.w;
        if (layoutManager != null) {
            return layoutManager.getBaseline();
        }
        return super.getBaseline();
    }

    public int getChildAdapterPosition(View view) {
        ViewHolder d2 = d(view);
        if (d2 != null) {
            return d2.getAdapterPosition();
        }
        return -1;
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i2, int i3) {
        ChildDrawingOrderCallback childDrawingOrderCallback = this.za;
        if (childDrawingOrderCallback == null) {
            return super.getChildDrawingOrder(i2, i3);
        }
        return childDrawingOrderCallback.onGetChildDrawingOrder(i2, i3);
    }

    public long getChildItemId(View view) {
        ViewHolder d2;
        Adapter adapter = this.v;
        if (adapter == null || !adapter.hasStableIds() || (d2 = d(view)) == null) {
            return -1L;
        }
        return d2.getItemId();
    }

    public int getChildLayoutPosition(View view) {
        ViewHolder d2 = d(view);
        if (d2 != null) {
            return d2.getLayoutPosition();
        }
        return -1;
    }

    @Deprecated
    public int getChildPosition(View view) {
        return getChildAdapterPosition(view);
    }

    public ViewHolder getChildViewHolder(View view) {
        ViewParent parent = view.getParent();
        if (parent != null && parent != this) {
            throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
        }
        return d(view);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.q;
    }

    public RecyclerViewAccessibilityDelegate getCompatAccessibilityDelegate() {
        return this.ya;
    }

    public void getDecoratedBoundsWithMargins(View view, Rect rect) {
        a(view, rect);
    }

    public EdgeEffectFactory getEdgeEffectFactory() {
        return this.R;
    }

    public ItemAnimator getItemAnimator() {
        return this.W;
    }

    public ItemDecoration getItemDecorationAt(int i2) {
        int itemDecorationCount = getItemDecorationCount();
        if (i2 >= 0 && i2 < itemDecorationCount) {
            return this.y.get(i2);
        }
        throw new IndexOutOfBoundsException(i2 + " is an invalid index for size " + itemDecorationCount);
    }

    public int getItemDecorationCount() {
        return this.y.size();
    }

    public LayoutManager getLayoutManager() {
        return this.w;
    }

    public int getMaxFlingVelocity() {
        return this.ka;
    }

    public int getMinFlingVelocity() {
        return this.ja;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getNanoTime() {
        if (f2886f) {
            return System.nanoTime();
        }
        return 0L;
    }

    public OnFlingListener getOnFlingListener() {
        return this.ia;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.na;
    }

    public RecycledViewPool getRecycledViewPool() {
        return this.l.c();
    }

    public int getScrollState() {
        return this.aa;
    }

    public boolean hasFixedSize() {
        return this.C;
    }

    @Override // android.view.View, android.support.v4.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().hasNestedScrollingParent();
    }

    public boolean hasPendingAdapterUpdates() {
        return !this.E || this.N || this.n.c();
    }

    public void invalidateItemDecorations() {
        if (this.y.size() == 0) {
            return;
        }
        LayoutManager layoutManager = this.w;
        if (layoutManager != null) {
            layoutManager.assertNotInLayoutOrScroll("Cannot invalidate item decorations during a scroll or layout");
        }
        z();
        requestLayout();
    }

    public boolean isAnimating() {
        ItemAnimator itemAnimator = this.W;
        return itemAnimator != null && itemAnimator.isRunning();
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return this.B;
    }

    public boolean isComputingLayout() {
        return this.P > 0;
    }

    public boolean isLayoutFrozen() {
        return this.H;
    }

    @Override // android.view.View, android.support.v4.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().isNestedScrollingEnabled();
    }

    void n() {
        int b2 = this.o.b();
        for (int i2 = 0; i2 < b2; i2++) {
            ViewHolder d2 = d(this.o.d(i2));
            if (!d2.p()) {
                d2.a();
            }
        }
        this.l.a();
    }

    void o() {
        if (this.E && !this.N) {
            if (this.n.c()) {
                if (this.n.b(4) && !this.n.b(11)) {
                    TraceCompat.beginSection("RV PartialInvalidate");
                    H();
                    B();
                    this.n.e();
                    if (!this.G) {
                        if (O()) {
                            p();
                        } else {
                            this.n.a();
                        }
                    }
                    d(true);
                    C();
                    TraceCompat.endSection();
                    return;
                }
                if (this.n.c()) {
                    TraceCompat.beginSection("RV FullInvalidate");
                    p();
                    TraceCompat.endSection();
                    return;
                }
                return;
            }
            return;
        }
        TraceCompat.beginSection("RV FullInvalidate");
        p();
        TraceCompat.endSection();
    }

    public void offsetChildrenHorizontal(int i2) {
        int a2 = this.o.a();
        for (int i3 = 0; i3 < a2; i3++) {
            this.o.c(i3).offsetLeftAndRight(i2);
        }
    }

    public void offsetChildrenVertical(int i2) {
        int a2 = this.o.a();
        for (int i3 = 0; i3 < a2; i3++) {
            this.o.c(i3).offsetTopAndBottom(i2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x004f, code lost:            if (r0 >= 30.0f) goto L22;     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onAttachedToWindow() {
        /*
            r4 = this;
            super.onAttachedToWindow()
            r0 = 0
            r4.P = r0
            r1 = 1
            r4.B = r1
            boolean r2 = r4.E
            if (r2 == 0) goto L14
            boolean r2 = r4.isLayoutRequested()
            if (r2 != 0) goto L14
            goto L15
        L14:
            r1 = 0
        L15:
            r4.E = r1
            android.support.v7.widget.RecyclerView$LayoutManager r1 = r4.w
            if (r1 == 0) goto L1e
            r1.a(r4)
        L1e:
            r4.xa = r0
            boolean r0 = android.support.v7.widget.RecyclerView.f2886f
            if (r0 == 0) goto L67
            java.lang.ThreadLocal<android.support.v7.widget.GapWorker> r0 = android.support.v7.widget.GapWorker.f2793a
            java.lang.Object r0 = r0.get()
            android.support.v7.widget.GapWorker r0 = (android.support.v7.widget.GapWorker) r0
            r4.pa = r0
            android.support.v7.widget.GapWorker r0 = r4.pa
            if (r0 != 0) goto L62
            android.support.v7.widget.GapWorker r0 = new android.support.v7.widget.GapWorker
            r0.<init>()
            r4.pa = r0
            android.view.Display r0 = android.support.v4.view.ViewCompat.getDisplay(r4)
            r1 = 1114636288(0x42700000, float:60.0)
            boolean r2 = r4.isInEditMode()
            if (r2 != 0) goto L52
            if (r0 == 0) goto L52
            float r0 = r0.getRefreshRate()
            r2 = 1106247680(0x41f00000, float:30.0)
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 < 0) goto L52
            goto L54
        L52:
            r0 = 1114636288(0x42700000, float:60.0)
        L54:
            android.support.v7.widget.GapWorker r1 = r4.pa
            r2 = 1315859240(0x4e6e6b28, float:1.0E9)
            float r2 = r2 / r0
            long r2 = (long) r2
            r1.f2797e = r2
            java.lang.ThreadLocal<android.support.v7.widget.GapWorker> r0 = android.support.v7.widget.GapWorker.f2793a
            r0.set(r1)
        L62:
            android.support.v7.widget.GapWorker r0 = r4.pa
            r0.add(r4)
        L67:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.RecyclerView.onAttachedToWindow():void");
    }

    public void onChildAttachedToWindow(View view) {
    }

    public void onChildDetachedFromWindow(View view) {
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        GapWorker gapWorker;
        super.onDetachedFromWindow();
        ItemAnimator itemAnimator = this.W;
        if (itemAnimator != null) {
            itemAnimator.endAnimations();
        }
        stopScroll();
        this.B = false;
        LayoutManager layoutManager = this.w;
        if (layoutManager != null) {
            layoutManager.a(this, this.l);
        }
        this.Fa.clear();
        removeCallbacks(this.Ga);
        this.p.b();
        if (!f2886f || (gapWorker = this.pa) == null) {
            return;
        }
        gapWorker.remove(this);
        this.pa = null;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.y.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.y.get(i2).onDraw(canvas, this, this.ra);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0066  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onGenericMotionEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            android.support.v7.widget.RecyclerView$LayoutManager r0 = r5.w
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            boolean r0 = r5.H
            if (r0 == 0) goto Lb
            return r1
        Lb:
            int r0 = r6.getAction()
            r2 = 8
            if (r0 != r2) goto L77
            int r0 = r6.getSource()
            r0 = r0 & 2
            r2 = 0
            if (r0 == 0) goto L3c
            android.support.v7.widget.RecyclerView$LayoutManager r0 = r5.w
            boolean r0 = r0.canScrollVertically()
            if (r0 == 0) goto L2c
            r0 = 9
            float r0 = r6.getAxisValue(r0)
            float r0 = -r0
            goto L2d
        L2c:
            r0 = 0
        L2d:
            android.support.v7.widget.RecyclerView$LayoutManager r3 = r5.w
            boolean r3 = r3.canScrollHorizontally()
            if (r3 == 0) goto L61
            r3 = 10
            float r3 = r6.getAxisValue(r3)
            goto L62
        L3c:
            int r0 = r6.getSource()
            r3 = 4194304(0x400000, float:5.877472E-39)
            r0 = r0 & r3
            if (r0 == 0) goto L60
            r0 = 26
            float r0 = r6.getAxisValue(r0)
            android.support.v7.widget.RecyclerView$LayoutManager r3 = r5.w
            boolean r3 = r3.canScrollVertically()
            if (r3 == 0) goto L55
            float r0 = -r0
            goto L61
        L55:
            android.support.v7.widget.RecyclerView$LayoutManager r3 = r5.w
            boolean r3 = r3.canScrollHorizontally()
            if (r3 == 0) goto L60
            r3 = r0
            r0 = 0
            goto L62
        L60:
            r0 = 0
        L61:
            r3 = 0
        L62:
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L6a
            int r2 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r2 == 0) goto L77
        L6a:
            float r2 = r5.la
            float r3 = r3 * r2
            int r2 = (int) r3
            float r3 = r5.ma
            float r0 = r0 * r3
            int r0 = (int) r0
            r5.a(r2, r0, r6)
        L77:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.RecyclerView.onGenericMotionEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (this.H) {
            return false;
        }
        if (b(motionEvent)) {
            I();
            return true;
        }
        LayoutManager layoutManager = this.w;
        if (layoutManager == null) {
            return false;
        }
        boolean canScrollHorizontally = layoutManager.canScrollHorizontally();
        boolean canScrollVertically = this.w.canScrollVertically();
        if (this.ca == null) {
            this.ca = VelocityTracker.obtain();
        }
        this.ca.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.I) {
                this.I = false;
            }
            this.ba = motionEvent.getPointerId(0);
            int x = (int) (motionEvent.getX() + 0.5f);
            this.fa = x;
            this.da = x;
            int y = (int) (motionEvent.getY() + 0.5f);
            this.ga = y;
            this.ea = y;
            if (this.aa == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
            }
            int[] iArr = this.Ea;
            iArr[1] = 0;
            iArr[0] = 0;
            int i2 = canScrollHorizontally ? 1 : 0;
            if (canScrollVertically) {
                i2 |= 2;
            }
            startNestedScroll(i2, 0);
        } else if (actionMasked == 1) {
            this.ca.clear();
            stopNestedScroll(0);
        } else if (actionMasked == 2) {
            int findPointerIndex = motionEvent.findPointerIndex(this.ba);
            if (findPointerIndex < 0) {
                Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.ba + " not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x2 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
            int y2 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
            if (this.aa != 1) {
                int i3 = x2 - this.da;
                int i4 = y2 - this.ea;
                if (!canScrollHorizontally || Math.abs(i3) <= this.ha) {
                    z = false;
                } else {
                    this.fa = x2;
                    z = true;
                }
                if (canScrollVertically && Math.abs(i4) > this.ha) {
                    this.ga = y2;
                    z = true;
                }
                if (z) {
                    setScrollState(1);
                }
            }
        } else if (actionMasked == 3) {
            I();
        } else if (actionMasked == 5) {
            this.ba = motionEvent.getPointerId(actionIndex);
            int x3 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.fa = x3;
            this.da = x3;
            int y3 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.ga = y3;
            this.ea = y3;
        } else if (actionMasked == 6) {
            c(motionEvent);
        }
        return this.aa == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        TraceCompat.beginSection("RV OnLayout");
        p();
        TraceCompat.endSection();
        this.E = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        LayoutManager layoutManager = this.w;
        if (layoutManager == null) {
            c(i2, i3);
            return;
        }
        boolean z = false;
        if (layoutManager.isAutoMeasureEnabled()) {
            int mode = View.MeasureSpec.getMode(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            this.w.onMeasure(this.l, this.ra, i2, i3);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z = true;
            }
            if (z || this.v == null) {
                return;
            }
            if (this.ra.f2951e == 1) {
                K();
            }
            this.w.a(i2, i3);
            this.ra.j = true;
            L();
            this.w.b(i2, i3);
            if (this.w.b()) {
                this.w.a(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                this.ra.j = true;
                L();
                this.w.b(i2, i3);
                return;
            }
            return;
        }
        if (this.C) {
            this.w.onMeasure(this.l, this.ra, i2, i3);
            return;
        }
        if (this.K) {
            H();
            B();
            R();
            C();
            State state = this.ra;
            if (state.l) {
                state.f2954h = true;
            } else {
                this.n.b();
                this.ra.f2954h = false;
            }
            this.K = false;
            d(false);
        } else if (this.ra.l) {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
            return;
        }
        Adapter adapter = this.v;
        if (adapter != null) {
            this.ra.f2952f = adapter.getItemCount();
        } else {
            this.ra.f2952f = 0;
        }
        H();
        this.w.onMeasure(this.l, this.ra, i2, i3);
        d(false);
        this.ra.f2954h = false;
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i2, Rect rect) {
        if (isComputingLayout()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i2, rect);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        this.m = (SavedState) parcelable;
        super.onRestoreInstanceState(this.m.getSuperState());
        LayoutManager layoutManager = this.w;
        if (layoutManager == null || (parcelable2 = this.m.f2932b) == null) {
            return;
        }
        layoutManager.onRestoreInstanceState(parcelable2);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SavedState savedState2 = this.m;
        if (savedState2 != null) {
            savedState.a(savedState2);
        } else {
            LayoutManager layoutManager = this.w;
            if (layoutManager != null) {
                savedState.f2932b = layoutManager.onSaveInstanceState();
            } else {
                savedState.f2932b = null;
            }
        }
        return savedState;
    }

    public void onScrollStateChanged(int i2) {
    }

    public void onScrolled(int i2, int i3) {
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 == i4 && i3 == i5) {
            return;
        }
        x();
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x011c  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r15) {
        /*
            Method dump skipped, instructions count: 456
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.RecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    void p() {
        if (this.v == null) {
            Log.e("RecyclerView", "No adapter attached; skipping layout");
            return;
        }
        if (this.w == null) {
            Log.e("RecyclerView", "No layout manager attached; skipping layout");
            return;
        }
        State state = this.ra;
        state.j = false;
        if (state.f2951e == 1) {
            K();
            this.w.b(this);
            L();
        } else if (!this.n.d() && this.w.getWidth() == getWidth() && this.w.getHeight() == getHeight()) {
            this.w.b(this);
        } else {
            this.w.b(this);
            L();
        }
        M();
    }

    void q() {
        int i2;
        for (int size = this.Fa.size() - 1; size >= 0; size--) {
            ViewHolder viewHolder = this.Fa.get(size);
            if (viewHolder.itemView.getParent() == this && !viewHolder.p() && (i2 = viewHolder.q) != -1) {
                ViewCompat.setImportantForAccessibility(viewHolder.itemView, i2);
                viewHolder.q = -1;
            }
        }
        this.Fa.clear();
    }

    void r() {
        if (this.V != null) {
            return;
        }
        this.V = this.R.a(this, 3);
        if (this.q) {
            this.V.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            this.V.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    @Override // android.view.ViewGroup
    protected void removeDetachedView(View view, boolean z) {
        ViewHolder d2 = d(view);
        if (d2 != null) {
            if (d2.k()) {
                d2.d();
            } else if (!d2.p()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + d2 + v());
            }
        }
        view.clearAnimation();
        b(view);
        super.removeDetachedView(view, z);
    }

    public void removeItemDecoration(ItemDecoration itemDecoration) {
        LayoutManager layoutManager = this.w;
        if (layoutManager != null) {
            layoutManager.assertNotInLayoutOrScroll("Cannot remove item decoration during a scroll  or layout");
        }
        this.y.remove(itemDecoration);
        if (this.y.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        z();
        requestLayout();
    }

    public void removeItemDecorationAt(int i2) {
        int itemDecorationCount = getItemDecorationCount();
        if (i2 >= 0 && i2 < itemDecorationCount) {
            removeItemDecoration(getItemDecorationAt(i2));
            return;
        }
        throw new IndexOutOfBoundsException(i2 + " is an invalid index for size " + itemDecorationCount);
    }

    public void removeOnChildAttachStateChangeListener(OnChildAttachStateChangeListener onChildAttachStateChangeListener) {
        List<OnChildAttachStateChangeListener> list = this.M;
        if (list == null) {
            return;
        }
        list.remove(onChildAttachStateChangeListener);
    }

    public void removeOnItemTouchListener(OnItemTouchListener onItemTouchListener) {
        this.z.remove(onItemTouchListener);
        if (this.A == onItemTouchListener) {
            this.A = null;
        }
    }

    public void removeOnScrollListener(OnScrollListener onScrollListener) {
        List<OnScrollListener> list = this.ta;
        if (list != null) {
            list.remove(onScrollListener);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.w.onRequestChildFocus(this, this.ra, view, view2) && view2 != null) {
            a(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        return this.w.requestChildRectangleOnScreen(this, view, rect, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        int size = this.z.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.z.get(i2).onRequestDisallowInterceptTouchEvent(z);
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.F == 0 && !this.H) {
            super.requestLayout();
        } else {
            this.G = true;
        }
    }

    void s() {
        if (this.S != null) {
            return;
        }
        this.S = this.R.a(this, 0);
        if (this.q) {
            this.S.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            this.S.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    @Override // android.view.View
    public void scrollBy(int i2, int i3) {
        LayoutManager layoutManager = this.w;
        if (layoutManager == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.H) {
            return;
        }
        boolean canScrollHorizontally = layoutManager.canScrollHorizontally();
        boolean canScrollVertically = this.w.canScrollVertically();
        if (canScrollHorizontally || canScrollVertically) {
            if (!canScrollHorizontally) {
                i2 = 0;
            }
            if (!canScrollVertically) {
                i3 = 0;
            }
            a(i2, i3, (MotionEvent) null);
        }
    }

    @Override // android.view.View
    public void scrollTo(int i2, int i3) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    public void scrollToPosition(int i2) {
        if (this.H) {
            return;
        }
        stopScroll();
        LayoutManager layoutManager = this.w;
        if (layoutManager == null) {
            Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            layoutManager.scrollToPosition(i2);
            awakenScrollBars();
        }
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (a(accessibilityEvent)) {
            return;
        }
        super.sendAccessibilityEventUnchecked(accessibilityEvent);
    }

    public void setAccessibilityDelegateCompat(RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate) {
        this.ya = recyclerViewAccessibilityDelegate;
        ViewCompat.setAccessibilityDelegate(this, this.ya);
    }

    public void setAdapter(Adapter adapter) {
        setLayoutFrozen(false);
        a(adapter, false, true);
        c(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(ChildDrawingOrderCallback childDrawingOrderCallback) {
        if (childDrawingOrderCallback == this.za) {
            return;
        }
        this.za = childDrawingOrderCallback;
        setChildrenDrawingOrderEnabled(this.za != null);
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z) {
        if (z != this.q) {
            x();
        }
        this.q = z;
        super.setClipToPadding(z);
        if (this.E) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(EdgeEffectFactory edgeEffectFactory) {
        Preconditions.checkNotNull(edgeEffectFactory);
        this.R = edgeEffectFactory;
        x();
    }

    public void setHasFixedSize(boolean z) {
        this.C = z;
    }

    public void setItemAnimator(ItemAnimator itemAnimator) {
        ItemAnimator itemAnimator2 = this.W;
        if (itemAnimator2 != null) {
            itemAnimator2.endAnimations();
            this.W.a((ItemAnimator.ItemAnimatorListener) null);
        }
        this.W = itemAnimator;
        ItemAnimator itemAnimator3 = this.W;
        if (itemAnimator3 != null) {
            itemAnimator3.a(this.wa);
        }
    }

    public void setItemViewCacheSize(int i2) {
        this.l.setViewCacheSize(i2);
    }

    public void setLayoutFrozen(boolean z) {
        if (z != this.H) {
            b("Do not setLayoutFrozen in layout or scroll");
            if (!z) {
                this.H = false;
                if (this.G && this.w != null && this.v != null) {
                    requestLayout();
                }
                this.G = false;
                return;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
            this.H = true;
            this.I = true;
            stopScroll();
        }
    }

    public void setLayoutManager(LayoutManager layoutManager) {
        if (layoutManager == this.w) {
            return;
        }
        stopScroll();
        if (this.w != null) {
            ItemAnimator itemAnimator = this.W;
            if (itemAnimator != null) {
                itemAnimator.endAnimations();
            }
            this.w.removeAndRecycleAllViews(this.l);
            this.w.a(this.l);
            this.l.clear();
            if (this.B) {
                this.w.a(this, this.l);
            }
            this.w.c(null);
            this.w = null;
        } else {
            this.l.clear();
        }
        this.o.c();
        this.w = layoutManager;
        if (layoutManager != null) {
            if (layoutManager.f2904b == null) {
                this.w.c(this);
                if (this.B) {
                    this.w.a(this);
                }
            } else {
                throw new IllegalArgumentException("LayoutManager " + layoutManager + " is already attached to a RecyclerView:" + layoutManager.f2904b.v());
            }
        }
        this.l.h();
        requestLayout();
    }

    @Override // android.view.View, android.support.v4.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z) {
        getScrollingChildHelper().setNestedScrollingEnabled(z);
    }

    public void setOnFlingListener(OnFlingListener onFlingListener) {
        this.ia = onFlingListener;
    }

    @Deprecated
    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.sa = onScrollListener;
    }

    public void setPreserveFocusAfterLayout(boolean z) {
        this.na = z;
    }

    public void setRecycledViewPool(RecycledViewPool recycledViewPool) {
        this.l.a(recycledViewPool);
    }

    public void setRecyclerListener(RecyclerListener recyclerListener) {
        this.x = recyclerListener;
    }

    void setScrollState(int i2) {
        if (i2 == this.aa) {
            return;
        }
        this.aa = i2;
        if (i2 != 2) {
            X();
        }
        b(i2);
    }

    public void setScrollingTouchSlop(int i2) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i2 != 0) {
            if (i2 != 1) {
                Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + i2 + "; using default value");
            } else {
                this.ha = viewConfiguration.getScaledPagingTouchSlop();
                return;
            }
        }
        this.ha = viewConfiguration.getScaledTouchSlop();
    }

    public void setViewCacheExtension(ViewCacheExtension viewCacheExtension) {
        this.l.a(viewCacheExtension);
    }

    public void smoothScrollBy(int i2, int i3) {
        smoothScrollBy(i2, i3, null);
    }

    public void smoothScrollToPosition(int i2) {
        if (this.H) {
            return;
        }
        LayoutManager layoutManager = this.w;
        if (layoutManager == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            layoutManager.smoothScrollToPosition(this, this.ra, i2);
        }
    }

    @Override // android.view.View, android.support.v4.view.NestedScrollingChild
    public boolean startNestedScroll(int i2) {
        return getScrollingChildHelper().startNestedScroll(i2);
    }

    @Override // android.view.View, android.support.v4.view.NestedScrollingChild
    public void stopNestedScroll() {
        getScrollingChildHelper().stopNestedScroll();
    }

    public void stopScroll() {
        setScrollState(0);
        X();
    }

    public void swapAdapter(Adapter adapter, boolean z) {
        setLayoutFrozen(false);
        a(adapter, true, z);
        c(true);
        requestLayout();
    }

    void t() {
        if (this.U != null) {
            return;
        }
        this.U = this.R.a(this, 2);
        if (this.q) {
            this.U.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            this.U.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    void u() {
        if (this.T != null) {
            return;
        }
        this.T = this.R.a(this, 1);
        if (this.q) {
            this.T.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            this.T.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    String v() {
        return " " + super.toString() + ", adapter:" + this.v + ", layout:" + this.w + ", context:" + getContext();
    }

    void w() {
        this.n = new AdapterHelper(new AdapterHelper.Callback() { // from class: android.support.v7.widget.RecyclerView.6
            void a(AdapterHelper.UpdateOp updateOp) {
                int i2 = updateOp.f2601a;
                if (i2 == 1) {
                    RecyclerView recyclerView = RecyclerView.this;
                    recyclerView.w.onItemsAdded(recyclerView, updateOp.f2602b, updateOp.f2604d);
                    return;
                }
                if (i2 == 2) {
                    RecyclerView recyclerView2 = RecyclerView.this;
                    recyclerView2.w.onItemsRemoved(recyclerView2, updateOp.f2602b, updateOp.f2604d);
                } else if (i2 == 4) {
                    RecyclerView recyclerView3 = RecyclerView.this;
                    recyclerView3.w.onItemsUpdated(recyclerView3, updateOp.f2602b, updateOp.f2604d, updateOp.f2603c);
                } else {
                    if (i2 != 8) {
                        return;
                    }
                    RecyclerView recyclerView4 = RecyclerView.this;
                    recyclerView4.w.onItemsMoved(recyclerView4, updateOp.f2602b, updateOp.f2604d, 1);
                }
            }

            @Override // android.support.v7.widget.AdapterHelper.Callback
            public ViewHolder findViewHolder(int i2) {
                ViewHolder b2 = RecyclerView.this.b(i2, true);
                if (b2 == null || RecyclerView.this.o.c(b2.itemView)) {
                    return null;
                }
                return b2;
            }

            @Override // android.support.v7.widget.AdapterHelper.Callback
            public void markViewHoldersUpdated(int i2, int i3, Object obj) {
                RecyclerView.this.a(i2, i3, obj);
                RecyclerView.this.va = true;
            }

            @Override // android.support.v7.widget.AdapterHelper.Callback
            public void offsetPositionsForAdd(int i2, int i3) {
                RecyclerView.this.e(i2, i3);
                RecyclerView.this.ua = true;
            }

            @Override // android.support.v7.widget.AdapterHelper.Callback
            public void offsetPositionsForMove(int i2, int i3) {
                RecyclerView.this.f(i2, i3);
                RecyclerView.this.ua = true;
            }

            @Override // android.support.v7.widget.AdapterHelper.Callback
            public void offsetPositionsForRemovingInvisible(int i2, int i3) {
                RecyclerView.this.a(i2, i3, true);
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.ua = true;
                recyclerView.ra.f2950d += i3;
            }

            @Override // android.support.v7.widget.AdapterHelper.Callback
            public void offsetPositionsForRemovingLaidOutOrNewView(int i2, int i3) {
                RecyclerView.this.a(i2, i3, false);
                RecyclerView.this.ua = true;
            }

            @Override // android.support.v7.widget.AdapterHelper.Callback
            public void onDispatchFirstPass(AdapterHelper.UpdateOp updateOp) {
                a(updateOp);
            }

            @Override // android.support.v7.widget.AdapterHelper.Callback
            public void onDispatchSecondPass(AdapterHelper.UpdateOp updateOp) {
                a(updateOp);
            }
        });
    }

    void x() {
        this.V = null;
        this.T = null;
        this.U = null;
        this.S = null;
    }

    boolean y() {
        AccessibilityManager accessibilityManager = this.L;
        return accessibilityManager != null && accessibilityManager.isEnabled();
    }

    void z() {
        int b2 = this.o.b();
        for (int i2 = 0; i2 < b2; i2++) {
            ((LayoutParams) this.o.d(i2).getLayoutParams()).f2915c = true;
        }
        this.l.e();
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    void b(int i2, int i3) {
        boolean z;
        EdgeEffect edgeEffect = this.S;
        if (edgeEffect == null || edgeEffect.isFinished() || i2 <= 0) {
            z = false;
        } else {
            this.S.onRelease();
            z = this.S.isFinished();
        }
        EdgeEffect edgeEffect2 = this.U;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i2 < 0) {
            this.U.onRelease();
            z |= this.U.isFinished();
        }
        EdgeEffect edgeEffect3 = this.T;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i3 > 0) {
            this.T.onRelease();
            z |= this.T.isFinished();
        }
        EdgeEffect edgeEffect4 = this.V;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i3 < 0) {
            this.V.onRelease();
            z |= this.V.isFinished();
        }
        if (z) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    @Override // android.support.v4.view.NestedScrollingChild2
    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2, int i4) {
        return getScrollingChildHelper().dispatchNestedPreScroll(i2, i3, iArr, iArr2, i4);
    }

    @Override // android.support.v4.view.NestedScrollingChild2
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr, int i6) {
        return getScrollingChildHelper().dispatchNestedScroll(i2, i3, i4, i5, iArr, i6);
    }

    @Override // android.support.v4.view.NestedScrollingChild2
    public boolean hasNestedScrollingParent(int i2) {
        return getScrollingChildHelper().hasNestedScrollingParent(i2);
    }

    public void smoothScrollBy(int i2, int i3, Interpolator interpolator) {
        LayoutManager layoutManager = this.w;
        if (layoutManager == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.H) {
            return;
        }
        if (!layoutManager.canScrollHorizontally()) {
            i2 = 0;
        }
        if (!this.w.canScrollVertically()) {
            i3 = 0;
        }
        if (i2 == 0 && i3 == 0) {
            return;
        }
        this.oa.smoothScrollBy(i2, i3, interpolator);
    }

    @Override // android.support.v4.view.NestedScrollingChild2
    public boolean startNestedScroll(int i2, int i3) {
        return getScrollingChildHelper().startNestedScroll(i2, i3);
    }

    @Override // android.support.v4.view.NestedScrollingChild2
    public void stopNestedScroll(int i2) {
        getScrollingChildHelper().stopNestedScroll(i2);
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.k = new RecyclerViewDataObserver();
        this.l = new Recycler();
        this.p = new ViewInfoStore();
        this.r = new Runnable() { // from class: android.support.v7.widget.RecyclerView.1
            @Override // java.lang.Runnable
            public void run() {
                RecyclerView recyclerView = RecyclerView.this;
                if (!recyclerView.E || recyclerView.isLayoutRequested()) {
                    return;
                }
                RecyclerView recyclerView2 = RecyclerView.this;
                if (!recyclerView2.B) {
                    recyclerView2.requestLayout();
                } else if (recyclerView2.H) {
                    recyclerView2.G = true;
                } else {
                    recyclerView2.o();
                }
            }
        };
        this.s = new Rect();
        this.t = new Rect();
        this.u = new RectF();
        this.y = new ArrayList<>();
        this.z = new ArrayList<>();
        this.F = 0;
        this.N = false;
        this.O = false;
        this.P = 0;
        this.Q = 0;
        this.R = new EdgeEffectFactory();
        this.W = new DefaultItemAnimator();
        this.aa = 0;
        this.ba = -1;
        this.la = Float.MIN_VALUE;
        this.ma = Float.MIN_VALUE;
        boolean z = true;
        this.na = true;
        this.oa = new ViewFlinger();
        this.qa = f2886f ? new GapWorker.LayoutPrefetchRegistryImpl() : null;
        this.ra = new State();
        this.ua = false;
        this.va = false;
        this.wa = new ItemAnimatorRestoreListener();
        this.xa = false;
        this.Aa = new int[2];
        this.Ca = new int[2];
        this.Da = new int[2];
        this.Ea = new int[2];
        this.Fa = new ArrayList();
        this.Ga = new Runnable() { // from class: android.support.v7.widget.RecyclerView.2
            @Override // java.lang.Runnable
            public void run() {
                ItemAnimator itemAnimator = RecyclerView.this.W;
                if (itemAnimator != null) {
                    itemAnimator.runPendingAnimations();
                }
                RecyclerView.this.xa = false;
            }
        };
        this.Ha = new ViewInfoStore.ProcessCallback() { // from class: android.support.v7.widget.RecyclerView.4
            @Override // android.support.v7.widget.ViewInfoStore.ProcessCallback
            public void processAppeared(ViewHolder viewHolder, ItemAnimator.ItemHolderInfo itemHolderInfo, ItemAnimator.ItemHolderInfo itemHolderInfo2) {
                RecyclerView.this.a(viewHolder, itemHolderInfo, itemHolderInfo2);
            }

            @Override // android.support.v7.widget.ViewInfoStore.ProcessCallback
            public void processDisappeared(ViewHolder viewHolder, ItemAnimator.ItemHolderInfo itemHolderInfo, ItemAnimator.ItemHolderInfo itemHolderInfo2) {
                RecyclerView.this.l.c(viewHolder);
                RecyclerView.this.b(viewHolder, itemHolderInfo, itemHolderInfo2);
            }

            @Override // android.support.v7.widget.ViewInfoStore.ProcessCallback
            public void processPersistent(ViewHolder viewHolder, ItemAnimator.ItemHolderInfo itemHolderInfo, ItemAnimator.ItemHolderInfo itemHolderInfo2) {
                viewHolder.setIsRecyclable(false);
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.N) {
                    if (recyclerView.W.animateChange(viewHolder, viewHolder, itemHolderInfo, itemHolderInfo2)) {
                        RecyclerView.this.D();
                    }
                } else if (recyclerView.W.animatePersistence(viewHolder, itemHolderInfo, itemHolderInfo2)) {
                    RecyclerView.this.D();
                }
            }

            @Override // android.support.v7.widget.ViewInfoStore.ProcessCallback
            public void unused(ViewHolder viewHolder) {
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.w.removeAndRecycleView(viewHolder.itemView, recyclerView.l);
            }
        };
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f2882b, i2, 0);
            this.q = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
        } else {
            this.q = true;
        }
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.ha = viewConfiguration.getScaledTouchSlop();
        this.la = ViewConfigurationCompat.getScaledHorizontalScrollFactor(viewConfiguration, context);
        this.ma = ViewConfigurationCompat.getScaledVerticalScrollFactor(viewConfiguration, context);
        this.ja = viewConfiguration.getScaledMinimumFlingVelocity();
        this.ka = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.W.a(this.wa);
        w();
        P();
        if (ViewCompat.getImportantForAccessibility(this) == 0) {
            ViewCompat.setImportantForAccessibility(this, 1);
        }
        this.L = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new RecyclerViewAccessibilityDelegate(this));
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, android.support.v7.recyclerview.R.styleable.RecyclerView, i2, 0);
            String string = obtainStyledAttributes2.getString(android.support.v7.recyclerview.R.styleable.RecyclerView_layoutManager);
            if (obtainStyledAttributes2.getInt(android.support.v7.recyclerview.R.styleable.RecyclerView_android_descendantFocusability, -1) == -1) {
                setDescendantFocusability(262144);
            }
            this.D = obtainStyledAttributes2.getBoolean(android.support.v7.recyclerview.R.styleable.RecyclerView_fastScrollEnabled, false);
            if (this.D) {
                a((StateListDrawable) obtainStyledAttributes2.getDrawable(android.support.v7.recyclerview.R.styleable.RecyclerView_fastScrollVerticalThumbDrawable), obtainStyledAttributes2.getDrawable(android.support.v7.recyclerview.R.styleable.RecyclerView_fastScrollVerticalTrackDrawable), (StateListDrawable) obtainStyledAttributes2.getDrawable(android.support.v7.recyclerview.R.styleable.RecyclerView_fastScrollHorizontalThumbDrawable), obtainStyledAttributes2.getDrawable(android.support.v7.recyclerview.R.styleable.RecyclerView_fastScrollHorizontalTrackDrawable));
            }
            obtainStyledAttributes2.recycle();
            a(context, string, attributeSet, i2, 0);
            if (Build.VERSION.SDK_INT >= 21) {
                TypedArray obtainStyledAttributes3 = context.obtainStyledAttributes(attributeSet, f2881a, i2, 0);
                boolean z2 = obtainStyledAttributes3.getBoolean(0, true);
                obtainStyledAttributes3.recycle();
                z = z2;
            }
        } else {
            setDescendantFocusability(262144);
        }
        setNestedScrollingEnabled(z);
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* renamed from: a, reason: collision with root package name */
        ViewHolder f2913a;

        /* renamed from: b, reason: collision with root package name */
        final Rect f2914b;

        /* renamed from: c, reason: collision with root package name */
        boolean f2915c;

        /* renamed from: d, reason: collision with root package name */
        boolean f2916d;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2914b = new Rect();
            this.f2915c = true;
            this.f2916d = false;
        }

        public int getViewAdapterPosition() {
            return this.f2913a.getAdapterPosition();
        }

        public int getViewLayoutPosition() {
            return this.f2913a.getLayoutPosition();
        }

        @Deprecated
        public int getViewPosition() {
            return this.f2913a.getPosition();
        }

        public boolean isItemChanged() {
            return this.f2913a.l();
        }

        public boolean isItemRemoved() {
            return this.f2913a.i();
        }

        public boolean isViewInvalid() {
            return this.f2913a.h();
        }

        public boolean viewNeedsUpdate() {
            return this.f2913a.m();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.f2914b = new Rect();
            this.f2915c = true;
            this.f2916d = false;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f2914b = new Rect();
            this.f2915c = true;
            this.f2916d = false;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f2914b = new Rect();
            this.f2915c = true;
            this.f2916d = false;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.LayoutParams) layoutParams);
            this.f2914b = new Rect();
            this.f2915c = true;
            this.f2916d = false;
        }
    }

    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: android.support.v7.widget.RecyclerView.SavedState.1
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }
        };

        /* renamed from: b, reason: collision with root package name */
        Parcelable f2932b;

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f2932b = parcel.readParcelable(classLoader == null ? LayoutManager.class.getClassLoader() : classLoader);
        }

        void a(SavedState savedState) {
            this.f2932b = savedState.f2932b;
        }

        @Override // android.support.v4.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(this.f2932b, 0);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    private void c(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.ba) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.ba = motionEvent.getPointerId(i2);
            int x = (int) (motionEvent.getX(i2) + 0.5f);
            this.fa = x;
            this.da = x;
            int y = (int) (motionEvent.getY(i2) + 0.5f);
            this.ga = y;
            this.ea = y;
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        LayoutManager layoutManager = this.w;
        if (layoutManager != null) {
            return layoutManager.generateLayoutParams(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + v());
    }

    private void a(Context context, String str, AttributeSet attributeSet, int i2, int i3) {
        ClassLoader classLoader;
        Constructor constructor;
        if (str != null) {
            String trim = str.trim();
            if (trim.isEmpty()) {
                return;
            }
            String a2 = a(context, trim);
            try {
                if (isInEditMode()) {
                    classLoader = getClass().getClassLoader();
                } else {
                    classLoader = context.getClassLoader();
                }
                Class<? extends U> asSubclass = classLoader.loadClass(a2).asSubclass(LayoutManager.class);
                Object[] objArr = null;
                try {
                    constructor = asSubclass.getConstructor(i);
                    objArr = new Object[]{context, attributeSet, Integer.valueOf(i2), Integer.valueOf(i3)};
                } catch (NoSuchMethodException e2) {
                    try {
                        constructor = asSubclass.getConstructor(new Class[0]);
                    } catch (NoSuchMethodException e3) {
                        e3.initCause(e2);
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + a2, e3);
                    }
                }
                constructor.setAccessible(true);
                setLayoutManager((LayoutManager) constructor.newInstance(objArr));
            } catch (ClassCastException e4) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + a2, e4);
            } catch (ClassNotFoundException e5) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + a2, e5);
            } catch (IllegalAccessException e6) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + a2, e6);
            } catch (InstantiationException e7) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + a2, e7);
            } catch (InvocationTargetException e8) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + a2, e8);
            }
        }
    }

    private boolean g(int i2, int i3) {
        a(this.Aa);
        int[] iArr = this.Aa;
        return (iArr[0] == i2 && iArr[1] == i3) ? false : true;
    }

    void f(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int b2 = this.o.b();
        if (i2 < i3) {
            i5 = i2;
            i4 = i3;
            i6 = -1;
        } else {
            i4 = i2;
            i5 = i3;
            i6 = 1;
        }
        for (int i8 = 0; i8 < b2; i8++) {
            ViewHolder d2 = d(this.o.d(i8));
            if (d2 != null && (i7 = d2.f2964c) >= i5 && i7 <= i4) {
                if (i7 == i2) {
                    d2.a(i3 - i2, false);
                } else {
                    d2.a(i6, false);
                }
                this.ra.f2953g = true;
            }
        }
        this.l.b(i2, i3);
        requestLayout();
    }

    void e(int i2, int i3) {
        int b2 = this.o.b();
        for (int i4 = 0; i4 < b2; i4++) {
            ViewHolder d2 = d(this.o.d(i4));
            if (d2 != null && !d2.p() && d2.f2964c >= i2) {
                d2.a(i3, false);
                this.ra.f2953g = true;
            }
        }
        this.l.a(i2, i3);
        requestLayout();
    }

    public void addItemDecoration(ItemDecoration itemDecoration) {
        addItemDecoration(itemDecoration, -1);
    }

    void c(int i2, int i3) {
        setMeasuredDimension(LayoutManager.chooseSize(i2, getPaddingLeft() + getPaddingRight(), ViewCompat.getMinimumWidth(this)), LayoutManager.chooseSize(i3, getPaddingTop() + getPaddingBottom(), ViewCompat.getMinimumHeight(this)));
    }

    long d(ViewHolder viewHolder) {
        return this.v.hasStableIds() ? viewHolder.getItemId() : viewHolder.f2964c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ViewHolder d(View view) {
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).f2913a;
    }

    void d(int i2, int i3) {
        this.Q++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX, scrollY);
        onScrolled(i2, i3);
        OnScrollListener onScrollListener = this.sa;
        if (onScrollListener != null) {
            onScrollListener.onScrolled(this, i2, i3);
        }
        List<OnScrollListener> list = this.ta;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.ta.get(size).onScrolled(this, i2, i3);
            }
        }
        this.Q--;
    }

    void b(String str) {
        if (isComputingLayout()) {
            if (str == null) {
                throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + v());
            }
            throw new IllegalStateException(str);
        }
        if (this.Q > 0) {
            Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException("" + v()));
        }
    }

    Rect e(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.f2915c) {
            return layoutParams.f2914b;
        }
        if (this.ra.isPreLayout() && (layoutParams.isItemChanged() || layoutParams.isViewInvalid())) {
            return layoutParams.f2914b;
        }
        Rect rect = layoutParams.f2914b;
        rect.set(0, 0, 0, 0);
        int size = this.y.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.s.set(0, 0, 0, 0);
            this.y.get(i2).getItemOffsets(this.s, view, this, this.ra);
            int i3 = rect.left;
            Rect rect2 = this.s;
            rect.left = i3 + rect2.left;
            rect.top += rect2.top;
            rect.right += rect2.right;
            rect.bottom += rect2.bottom;
        }
        layoutParams.f2915c = false;
        return rect;
    }

    void c(boolean z) {
        this.O = z | this.O;
        this.N = true;
        A();
    }

    static RecyclerView c(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            RecyclerView c2 = c(viewGroup.getChildAt(i2));
            if (c2 != null) {
                return c2;
            }
        }
        return null;
    }

    private boolean b(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 3 || action == 0) {
            this.A = null;
        }
        int size = this.z.size();
        for (int i2 = 0; i2 < size; i2++) {
            OnItemTouchListener onItemTouchListener = this.z.get(i2);
            if (onItemTouchListener.onInterceptTouchEvent(this, motionEvent) && action != 3) {
                this.A = onItemTouchListener;
                return true;
            }
        }
        return false;
    }

    private String a(Context context, String str) {
        if (str.charAt(0) == '.') {
            return context.getPackageName() + str;
        }
        if (str.contains(".")) {
            return str;
        }
        return RecyclerView.class.getPackage().getName() + '.' + str;
    }

    int c(ViewHolder viewHolder) {
        if (viewHolder.b(524) || !viewHolder.g()) {
            return -1;
        }
        return this.n.applyPendingUpdatesToPosition(viewHolder.f2964c);
    }

    private void a(Adapter adapter, boolean z, boolean z2) {
        Adapter adapter2 = this.v;
        if (adapter2 != null) {
            adapter2.unregisterAdapterDataObserver(this.k);
            this.v.onDetachedFromRecyclerView(this);
        }
        if (!z || z2) {
            E();
        }
        this.n.f();
        Adapter adapter3 = this.v;
        this.v = adapter;
        if (adapter != null) {
            adapter.registerAdapterDataObserver(this.k);
            adapter.onAttachedToRecyclerView(this);
        }
        LayoutManager layoutManager = this.w;
        if (layoutManager != null) {
            layoutManager.onAdapterChanged(adapter3, this.v);
        }
        this.l.a(adapter3, this.v, z);
        this.ra.f2953g = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(boolean z) {
        this.P--;
        if (this.P < 1) {
            this.P = 0;
            if (z) {
                J();
                q();
            }
        }
    }

    void b(ViewHolder viewHolder, ItemAnimator.ItemHolderInfo itemHolderInfo, ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        e(viewHolder);
        viewHolder.setIsRecyclable(false);
        if (this.W.animateDisappearance(viewHolder, itemHolderInfo, itemHolderInfo2)) {
            D();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0036 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    android.support.v7.widget.RecyclerView.ViewHolder b(int r6, boolean r7) {
        /*
            r5 = this;
            android.support.v7.widget.ChildHelper r0 = r5.o
            int r0 = r0.b()
            r1 = 0
            r2 = 0
        L8:
            if (r2 >= r0) goto L3a
            android.support.v7.widget.ChildHelper r3 = r5.o
            android.view.View r3 = r3.d(r2)
            android.support.v7.widget.RecyclerView$ViewHolder r3 = d(r3)
            if (r3 == 0) goto L37
            boolean r4 = r3.i()
            if (r4 != 0) goto L37
            if (r7 == 0) goto L23
            int r4 = r3.f2964c
            if (r4 == r6) goto L2a
            goto L37
        L23:
            int r4 = r3.getLayoutPosition()
            if (r4 == r6) goto L2a
            goto L37
        L2a:
            android.support.v7.widget.ChildHelper r1 = r5.o
            android.view.View r4 = r3.itemView
            boolean r1 = r1.c(r4)
            if (r1 == 0) goto L36
            r1 = r3
            goto L37
        L36:
            return r3
        L37:
            int r2 = r2 + 1
            goto L8
        L3a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.RecyclerView.b(int, boolean):android.support.v7.widget.RecyclerView$ViewHolder");
    }

    boolean a(int i2, int i3, MotionEvent motionEvent) {
        int i4;
        int i5;
        int i6;
        int i7;
        o();
        if (this.v != null) {
            H();
            B();
            TraceCompat.beginSection("RV Scroll");
            a(this.ra);
            if (i2 != 0) {
                i4 = this.w.scrollHorizontallyBy(i2, this.l, this.ra);
                i5 = i2 - i4;
            } else {
                i4 = 0;
                i5 = 0;
            }
            if (i3 != 0) {
                i6 = this.w.scrollVerticallyBy(i3, this.l, this.ra);
                i7 = i3 - i6;
            } else {
                i6 = 0;
                i7 = 0;
            }
            TraceCompat.endSection();
            F();
            C();
            d(false);
        } else {
            i4 = 0;
            i5 = 0;
            i6 = 0;
            i7 = 0;
        }
        if (!this.y.isEmpty()) {
            invalidate();
        }
        if (dispatchNestedScroll(i4, i6, i5, i7, this.Ca, 0)) {
            int i8 = this.fa;
            int[] iArr = this.Ca;
            this.fa = i8 - iArr[0];
            this.ga -= iArr[1];
            if (motionEvent != null) {
                motionEvent.offsetLocation(iArr[0], iArr[1]);
            }
            int[] iArr2 = this.Ea;
            int i9 = iArr2[0];
            int[] iArr3 = this.Ca;
            iArr2[0] = i9 + iArr3[0];
            iArr2[1] = iArr2[1] + iArr3[1];
        } else if (getOverScrollMode() != 2) {
            if (motionEvent != null && !MotionEventCompat.isFromSource(motionEvent, 8194)) {
                a(motionEvent.getX(), i5, motionEvent.getY(), i7);
            }
            b(i2, i3);
        }
        if (i4 != 0 || i6 != 0) {
            d(i4, i6);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        return (i4 == 0 && i6 == 0) ? false : true;
    }

    void b(int i2) {
        LayoutManager layoutManager = this.w;
        if (layoutManager != null) {
            layoutManager.onScrollStateChanged(i2);
        }
        onScrollStateChanged(i2);
        OnScrollListener onScrollListener = this.sa;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChanged(this, i2);
        }
        List<OnScrollListener> list = this.ta;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.ta.get(size).onScrollStateChanged(this, i2);
            }
        }
    }

    static void b(ViewHolder viewHolder) {
        WeakReference<RecyclerView> weakReference = viewHolder.f2963b;
        if (weakReference != null) {
            RecyclerView recyclerView = weakReference.get();
            while (recyclerView != null) {
                if (recyclerView == viewHolder.itemView) {
                    return;
                }
                Object parent = recyclerView.getParent();
                recyclerView = parent instanceof View ? (View) parent : null;
            }
            viewHolder.f2963b = null;
        }
    }

    void b(View view) {
        ViewHolder d2 = d(view);
        onChildDetachedFromWindow(view);
        Adapter adapter = this.v;
        if (adapter != null && d2 != null) {
            adapter.onViewDetachedFromWindow(d2);
        }
        List<OnChildAttachStateChangeListener> list = this.M;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.M.get(size).onChildViewDetachedFromWindow(view);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(float r7, float r8, float r9, float r10) {
        /*
            r6 = this;
            r0 = 1065353216(0x3f800000, float:1.0)
            r1 = 1
            r2 = 0
            int r3 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r3 >= 0) goto L21
            r6.s()
            android.widget.EdgeEffect r3 = r6.S
            float r4 = -r8
            int r5 = r6.getWidth()
            float r5 = (float) r5
            float r4 = r4 / r5
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            float r9 = r0 - r9
            android.support.v4.widget.EdgeEffectCompat.onPull(r3, r4, r9)
        L1f:
            r9 = 1
            goto L3c
        L21:
            int r3 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r3 <= 0) goto L3b
            r6.t()
            android.widget.EdgeEffect r3 = r6.U
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r4 = r8 / r4
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            android.support.v4.widget.EdgeEffectCompat.onPull(r3, r4, r9)
            goto L1f
        L3b:
            r9 = 0
        L3c:
            int r3 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r3 >= 0) goto L56
            r6.u()
            android.widget.EdgeEffect r9 = r6.T
            float r0 = -r10
            int r3 = r6.getHeight()
            float r3 = (float) r3
            float r0 = r0 / r3
            int r3 = r6.getWidth()
            float r3 = (float) r3
            float r7 = r7 / r3
            android.support.v4.widget.EdgeEffectCompat.onPull(r9, r0, r7)
            goto L72
        L56:
            int r3 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r3 <= 0) goto L71
            r6.r()
            android.widget.EdgeEffect r9 = r6.V
            int r3 = r6.getHeight()
            float r3 = (float) r3
            float r3 = r10 / r3
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r7 = r7 / r4
            float r0 = r0 - r7
            android.support.v4.widget.EdgeEffectCompat.onPull(r9, r3, r0)
            goto L72
        L71:
            r1 = r9
        L72:
            if (r1 != 0) goto L7c
            int r7 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r7 != 0) goto L7c
            int r7 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r7 == 0) goto L7f
        L7c:
            android.support.v4.view.ViewCompat.postInvalidateOnAnimation(r6)
        L7f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.RecyclerView.a(float, float, float, float):void");
    }

    void a(int i2, int i3) {
        if (i2 < 0) {
            s();
            this.S.onAbsorb(-i2);
        } else if (i2 > 0) {
            t();
            this.U.onAbsorb(i2);
        }
        if (i3 < 0) {
            u();
            this.T.onAbsorb(-i3);
        } else if (i3 > 0) {
            r();
            this.V.onAbsorb(i3);
        }
        if (i2 == 0 && i3 == 0) {
            return;
        }
        ViewCompat.postInvalidateOnAnimation(this);
    }

    private boolean a(View view, View view2, int i2) {
        int i3;
        if (view2 == null || view2 == this || findContainingItemView(view2) == null) {
            return false;
        }
        if (view == null || findContainingItemView(view) == null) {
            return true;
        }
        this.s.set(0, 0, view.getWidth(), view.getHeight());
        this.t.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.s);
        offsetDescendantRectToMyCoords(view2, this.t);
        char c2 = 65535;
        int i4 = this.w.getLayoutDirection() == 1 ? -1 : 1;
        Rect rect = this.s;
        int i5 = rect.left;
        int i6 = this.t.left;
        if ((i5 < i6 || rect.right <= i6) && this.s.right < this.t.right) {
            i3 = 1;
        } else {
            Rect rect2 = this.s;
            int i7 = rect2.right;
            int i8 = this.t.right;
            i3 = ((i7 > i8 || rect2.left >= i8) && this.s.left > this.t.left) ? -1 : 0;
        }
        Rect rect3 = this.s;
        int i9 = rect3.top;
        int i10 = this.t.top;
        if ((i9 < i10 || rect3.bottom <= i10) && this.s.bottom < this.t.bottom) {
            c2 = 1;
        } else {
            Rect rect4 = this.s;
            int i11 = rect4.bottom;
            int i12 = this.t.bottom;
            if ((i11 <= i12 && rect4.top < i12) || this.s.top <= this.t.top) {
                c2 = 0;
            }
        }
        if (i2 == 1) {
            return c2 < 0 || (c2 == 0 && i3 * i4 <= 0);
        }
        if (i2 == 2) {
            return c2 > 0 || (c2 == 0 && i3 * i4 >= 0);
        }
        if (i2 == 17) {
            return i3 < 0;
        }
        if (i2 == 33) {
            return c2 < 0;
        }
        if (i2 == 66) {
            return i3 > 0;
        }
        if (i2 == 130) {
            return c2 > 0;
        }
        throw new IllegalArgumentException("Invalid direction: " + i2 + v());
    }

    private void a(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        this.s.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof LayoutParams) {
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            if (!layoutParams2.f2915c) {
                Rect rect = layoutParams2.f2914b;
                Rect rect2 = this.s;
                rect2.left -= rect.left;
                rect2.right += rect.right;
                rect2.top -= rect.top;
                rect2.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.s);
            offsetRectIntoDescendantCoords(view, this.s);
        }
        this.w.requestChildRectangleOnScreen(this, view, this.s, !this.E, view2 == null);
    }

    void a(String str) {
        if (isComputingLayout()) {
            return;
        }
        if (str == null) {
            throw new IllegalStateException("Cannot call this method unless RecyclerView is computing a layout or scrolling" + v());
        }
        throw new IllegalStateException(str + v());
    }

    private boolean a(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        OnItemTouchListener onItemTouchListener = this.A;
        if (onItemTouchListener != null) {
            if (action == 0) {
                this.A = null;
            } else {
                onItemTouchListener.onTouchEvent(this, motionEvent);
                if (action == 3 || action == 1) {
                    this.A = null;
                }
                return true;
            }
        }
        if (action != 0) {
            int size = this.z.size();
            for (int i2 = 0; i2 < size; i2++) {
                OnItemTouchListener onItemTouchListener2 = this.z.get(i2);
                if (onItemTouchListener2.onInterceptTouchEvent(this, motionEvent)) {
                    this.A = onItemTouchListener2;
                    return true;
                }
            }
        }
        return false;
    }

    boolean a(AccessibilityEvent accessibilityEvent) {
        if (!isComputingLayout()) {
            return false;
        }
        int contentChangeTypes = accessibilityEvent != null ? AccessibilityEventCompat.getContentChangeTypes(accessibilityEvent) : 0;
        if (contentChangeTypes == 0) {
            contentChangeTypes = 0;
        }
        this.J = contentChangeTypes | this.J;
        return true;
    }

    final void a(State state) {
        if (getScrollState() == 2) {
            OverScroller overScroller = this.oa.f2957c;
            state.p = overScroller.getFinalX() - overScroller.getCurrX();
            state.q = overScroller.getFinalY() - overScroller.getCurrY();
        } else {
            state.p = 0;
            state.q = 0;
        }
    }

    private void a(long j2, ViewHolder viewHolder, ViewHolder viewHolder2) {
        int a2 = this.o.a();
        for (int i2 = 0; i2 < a2; i2++) {
            ViewHolder d2 = d(this.o.c(i2));
            if (d2 != viewHolder && d(d2) == j2) {
                Adapter adapter = this.v;
                if (adapter != null && adapter.hasStableIds()) {
                    throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + d2 + " \n View Holder 2:" + viewHolder + v());
                }
                throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + d2 + " \n View Holder 2:" + viewHolder + v());
            }
        }
        Log.e("RecyclerView", "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + viewHolder2 + " cannot be found but it is necessary for " + viewHolder + v());
    }

    void a(ViewHolder viewHolder, ItemAnimator.ItemHolderInfo itemHolderInfo) {
        viewHolder.a(0, 8192);
        if (this.ra.i && viewHolder.l() && !viewHolder.i() && !viewHolder.p()) {
            this.p.a(d(viewHolder), viewHolder);
        }
        this.p.c(viewHolder, itemHolderInfo);
    }

    private void a(int[] iArr) {
        int a2 = this.o.a();
        if (a2 == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i2 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int i3 = Integer.MIN_VALUE;
        for (int i4 = 0; i4 < a2; i4++) {
            ViewHolder d2 = d(this.o.c(i4));
            if (!d2.p()) {
                int layoutPosition = d2.getLayoutPosition();
                if (layoutPosition < i2) {
                    i2 = layoutPosition;
                }
                if (layoutPosition > i3) {
                    i3 = layoutPosition;
                }
            }
        }
        iArr[0] = i2;
        iArr[1] = i3;
    }

    void a(ViewHolder viewHolder, ItemAnimator.ItemHolderInfo itemHolderInfo, ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        viewHolder.setIsRecyclable(false);
        if (this.W.animateAppearance(viewHolder, itemHolderInfo, itemHolderInfo2)) {
            D();
        }
    }

    private void a(ViewHolder viewHolder, ViewHolder viewHolder2, ItemAnimator.ItemHolderInfo itemHolderInfo, ItemAnimator.ItemHolderInfo itemHolderInfo2, boolean z, boolean z2) {
        viewHolder.setIsRecyclable(false);
        if (z) {
            e(viewHolder);
        }
        if (viewHolder != viewHolder2) {
            if (z2) {
                e(viewHolder2);
            }
            viewHolder.f2969h = viewHolder2;
            e(viewHolder);
            this.l.c(viewHolder);
            viewHolder2.setIsRecyclable(false);
            viewHolder2.i = viewHolder;
        }
        if (this.W.animateChange(viewHolder, viewHolder2, itemHolderInfo, itemHolderInfo2)) {
            D();
        }
    }

    void a(int i2, int i3, boolean z) {
        int i4 = i2 + i3;
        int b2 = this.o.b();
        for (int i5 = 0; i5 < b2; i5++) {
            ViewHolder d2 = d(this.o.d(i5));
            if (d2 != null && !d2.p()) {
                int i6 = d2.f2964c;
                if (i6 >= i4) {
                    d2.a(-i3, z);
                    this.ra.f2953g = true;
                } else if (i6 >= i2) {
                    d2.a(i2 - 1, -i3, z);
                    this.ra.f2953g = true;
                }
            }
        }
        this.l.a(i2, i3, z);
        requestLayout();
    }

    void a(int i2, int i3, Object obj) {
        int i4;
        int b2 = this.o.b();
        int i5 = i2 + i3;
        for (int i6 = 0; i6 < b2; i6++) {
            View d2 = this.o.d(i6);
            ViewHolder d3 = d(d2);
            if (d3 != null && !d3.p() && (i4 = d3.f2964c) >= i2 && i4 < i5) {
                d3.a(2);
                d3.a(obj);
                ((LayoutParams) d2.getLayoutParams()).f2915c = true;
            }
        }
        this.l.c(i2, i3);
    }

    boolean a(ViewHolder viewHolder) {
        ItemAnimator itemAnimator = this.W;
        return itemAnimator == null || itemAnimator.canReuseUpdatedViewHolder(viewHolder, viewHolder.e());
    }

    static void a(View view, Rect rect) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect2 = layoutParams.f2914b;
        rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
    }

    void a(View view) {
        ViewHolder d2 = d(view);
        onChildAttachedToWindow(view);
        Adapter adapter = this.v;
        if (adapter != null && d2 != null) {
            adapter.onViewAttachedToWindow(d2);
        }
        List<OnChildAttachStateChangeListener> list = this.M;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.M.get(size).onChildViewAttachedToWindow(view);
            }
        }
    }

    boolean a(ViewHolder viewHolder, int i2) {
        if (isComputingLayout()) {
            viewHolder.q = i2;
            this.Fa.add(viewHolder);
            return false;
        }
        ViewCompat.setImportantForAccessibility(viewHolder.itemView, i2);
        return true;
    }

    void a(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        if (stateListDrawable != null && drawable != null && stateListDrawable2 != null && drawable2 != null) {
            Resources resources = getContext().getResources();
            new FastScroller(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(android.support.v7.recyclerview.R.dimen.fastscroll_default_thickness), resources.getDimensionPixelSize(android.support.v7.recyclerview.R.dimen.fastscroll_minimum_range), resources.getDimensionPixelOffset(android.support.v7.recyclerview.R.dimen.fastscroll_margin));
        } else {
            throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + v());
        }
    }
}
