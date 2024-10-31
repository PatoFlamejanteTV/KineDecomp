package android.support.v7.widget.helper;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.recyclerview.R;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchUIUtilImpl;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class ItemTouchHelper extends RecyclerView.ItemDecoration implements RecyclerView.OnChildAttachStateChangeListener {
    public static final int ACTION_STATE_DRAG = 2;
    public static final int ACTION_STATE_IDLE = 0;
    public static final int ACTION_STATE_SWIPE = 1;
    public static final int ANIMATION_TYPE_DRAG = 8;
    public static final int ANIMATION_TYPE_SWIPE_CANCEL = 4;
    public static final int ANIMATION_TYPE_SWIPE_SUCCESS = 2;
    public static final int DOWN = 2;
    public static final int END = 32;
    public static final int LEFT = 4;
    public static final int RIGHT = 8;
    public static final int START = 16;
    public static final int UP = 1;
    private ItemTouchHelperGestureListener A;
    private Rect C;
    private long D;

    /* renamed from: d, reason: collision with root package name */
    float f3184d;

    /* renamed from: e, reason: collision with root package name */
    float f3185e;

    /* renamed from: f, reason: collision with root package name */
    float f3186f;

    /* renamed from: g, reason: collision with root package name */
    float f3187g;

    /* renamed from: h, reason: collision with root package name */
    float f3188h;
    float i;
    float j;
    float k;
    Callback m;
    int o;
    private int q;
    RecyclerView r;
    VelocityTracker t;
    private List<RecyclerView.ViewHolder> u;
    private List<Integer> v;
    GestureDetectorCompat z;

    /* renamed from: a, reason: collision with root package name */
    final List<View> f3181a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private final float[] f3182b = new float[2];

    /* renamed from: c, reason: collision with root package name */
    RecyclerView.ViewHolder f3183c = null;
    int l = -1;
    int n = 0;
    List<RecoverAnimation> p = new ArrayList();
    final Runnable s = new Runnable() { // from class: android.support.v7.widget.helper.ItemTouchHelper.1
        @Override // java.lang.Runnable
        public void run() {
            ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
            if (itemTouchHelper.f3183c == null || !itemTouchHelper.c()) {
                return;
            }
            ItemTouchHelper itemTouchHelper2 = ItemTouchHelper.this;
            RecyclerView.ViewHolder viewHolder = itemTouchHelper2.f3183c;
            if (viewHolder != null) {
                itemTouchHelper2.a(viewHolder);
            }
            ItemTouchHelper itemTouchHelper3 = ItemTouchHelper.this;
            itemTouchHelper3.r.removeCallbacks(itemTouchHelper3.s);
            ViewCompat.postOnAnimation(ItemTouchHelper.this.r, this);
        }
    };
    private RecyclerView.ChildDrawingOrderCallback w = null;
    View x = null;
    int y = -1;
    private final RecyclerView.OnItemTouchListener B = new RecyclerView.OnItemTouchListener() { // from class: android.support.v7.widget.helper.ItemTouchHelper.2
        @Override // android.support.v7.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            int findPointerIndex;
            RecoverAnimation a2;
            ItemTouchHelper.this.z.onTouchEvent(motionEvent);
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                ItemTouchHelper.this.l = motionEvent.getPointerId(0);
                ItemTouchHelper.this.f3184d = motionEvent.getX();
                ItemTouchHelper.this.f3185e = motionEvent.getY();
                ItemTouchHelper.this.b();
                ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
                if (itemTouchHelper.f3183c == null && (a2 = itemTouchHelper.a(motionEvent)) != null) {
                    ItemTouchHelper itemTouchHelper2 = ItemTouchHelper.this;
                    itemTouchHelper2.f3184d -= a2.i;
                    itemTouchHelper2.f3185e -= a2.j;
                    itemTouchHelper2.a(a2.f3205e, true);
                    if (ItemTouchHelper.this.f3181a.remove(a2.f3205e.itemView)) {
                        ItemTouchHelper itemTouchHelper3 = ItemTouchHelper.this;
                        itemTouchHelper3.m.clearView(itemTouchHelper3.r, a2.f3205e);
                    }
                    ItemTouchHelper.this.a(a2.f3205e, a2.f3206f);
                    ItemTouchHelper itemTouchHelper4 = ItemTouchHelper.this;
                    itemTouchHelper4.a(motionEvent, itemTouchHelper4.o, 0);
                }
            } else if (actionMasked != 3 && actionMasked != 1) {
                int i = ItemTouchHelper.this.l;
                if (i != -1 && (findPointerIndex = motionEvent.findPointerIndex(i)) >= 0) {
                    ItemTouchHelper.this.a(actionMasked, motionEvent, findPointerIndex);
                }
            } else {
                ItemTouchHelper itemTouchHelper5 = ItemTouchHelper.this;
                itemTouchHelper5.l = -1;
                itemTouchHelper5.a((RecyclerView.ViewHolder) null, 0);
            }
            VelocityTracker velocityTracker = ItemTouchHelper.this.t;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
            return ItemTouchHelper.this.f3183c != null;
        }

        @Override // android.support.v7.widget.RecyclerView.OnItemTouchListener
        public void onRequestDisallowInterceptTouchEvent(boolean z) {
            if (z) {
                ItemTouchHelper.this.a((RecyclerView.ViewHolder) null, 0);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnItemTouchListener
        public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            ItemTouchHelper.this.z.onTouchEvent(motionEvent);
            VelocityTracker velocityTracker = ItemTouchHelper.this.t;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
            if (ItemTouchHelper.this.l == -1) {
                return;
            }
            int actionMasked = motionEvent.getActionMasked();
            int findPointerIndex = motionEvent.findPointerIndex(ItemTouchHelper.this.l);
            if (findPointerIndex >= 0) {
                ItemTouchHelper.this.a(actionMasked, motionEvent, findPointerIndex);
            }
            ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
            RecyclerView.ViewHolder viewHolder = itemTouchHelper.f3183c;
            if (viewHolder == null) {
                return;
            }
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    if (findPointerIndex >= 0) {
                        itemTouchHelper.a(motionEvent, itemTouchHelper.o, findPointerIndex);
                        ItemTouchHelper.this.a(viewHolder);
                        ItemTouchHelper itemTouchHelper2 = ItemTouchHelper.this;
                        itemTouchHelper2.r.removeCallbacks(itemTouchHelper2.s);
                        ItemTouchHelper.this.s.run();
                        ItemTouchHelper.this.r.invalidate();
                        return;
                    }
                    return;
                }
                if (actionMasked != 3) {
                    if (actionMasked != 6) {
                        return;
                    }
                    int actionIndex = motionEvent.getActionIndex();
                    if (motionEvent.getPointerId(actionIndex) == ItemTouchHelper.this.l) {
                        ItemTouchHelper.this.l = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
                        ItemTouchHelper itemTouchHelper3 = ItemTouchHelper.this;
                        itemTouchHelper3.a(motionEvent, itemTouchHelper3.o, actionIndex);
                        return;
                    }
                    return;
                }
                VelocityTracker velocityTracker2 = itemTouchHelper.t;
                if (velocityTracker2 != null) {
                    velocityTracker2.clear();
                }
            }
            ItemTouchHelper.this.a((RecyclerView.ViewHolder) null, 0);
            ItemTouchHelper.this.l = -1;
        }
    };

    /* loaded from: classes.dex */
    public static abstract class Callback {
        public static final int DEFAULT_DRAG_ANIMATION_DURATION = 200;
        public static final int DEFAULT_SWIPE_ANIMATION_DURATION = 250;

        /* renamed from: a, reason: collision with root package name */
        private static final ItemTouchUIUtil f3195a;

        /* renamed from: b, reason: collision with root package name */
        private static final Interpolator f3196b = new Interpolator() { // from class: android.support.v7.widget.helper.ItemTouchHelper.Callback.1
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f2) {
                return f2 * f2 * f2 * f2 * f2;
            }
        };

        /* renamed from: c, reason: collision with root package name */
        private static final Interpolator f3197c = new Interpolator() { // from class: android.support.v7.widget.helper.ItemTouchHelper.Callback.2
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f2) {
                float f3 = f2 - 1.0f;
                return (f3 * f3 * f3 * f3 * f3) + 1.0f;
            }
        };

        /* renamed from: d, reason: collision with root package name */
        private int f3198d = -1;

        static {
            if (Build.VERSION.SDK_INT >= 21) {
                f3195a = new ItemTouchUIUtilImpl.Api21Impl();
            } else {
                f3195a = new ItemTouchUIUtilImpl.BaseImpl();
            }
        }

        public static int convertToRelativeDirection(int i, int i2) {
            int i3;
            int i4 = i & 789516;
            if (i4 == 0) {
                return i;
            }
            int i5 = i & (i4 ^ (-1));
            if (i2 == 0) {
                i3 = i4 << 2;
            } else {
                int i6 = i4 << 1;
                i5 |= (-789517) & i6;
                i3 = (i6 & 789516) << 2;
            }
            return i5 | i3;
        }

        public static ItemTouchUIUtil getDefaultUIUtil() {
            return f3195a;
        }

        public static int makeFlag(int i, int i2) {
            return i2 << (i * 8);
        }

        public static int makeMovementFlags(int i, int i2) {
            return makeFlag(2, i) | makeFlag(1, i2) | makeFlag(0, i2 | i);
        }

        final int a(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return convertToAbsoluteDirection(getMovementFlags(recyclerView, viewHolder), ViewCompat.getLayoutDirection(recyclerView));
        }

        boolean b(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return (a(recyclerView, viewHolder) & 16711680) != 0;
        }

        boolean c(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return (a(recyclerView, viewHolder) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) != 0;
        }

        public boolean canDropOver(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
            return true;
        }

        public RecyclerView.ViewHolder chooseDropTarget(RecyclerView.ViewHolder viewHolder, List<RecyclerView.ViewHolder> list, int i, int i2) {
            int i3;
            int bottom;
            int top;
            int abs;
            int left;
            int abs2;
            int right;
            int width = i + viewHolder.itemView.getWidth();
            int height = i2 + viewHolder.itemView.getHeight();
            int left2 = i - viewHolder.itemView.getLeft();
            int top2 = i2 - viewHolder.itemView.getTop();
            int size = list.size();
            RecyclerView.ViewHolder viewHolder2 = null;
            int i4 = -1;
            for (int i5 = 0; i5 < size; i5++) {
                RecyclerView.ViewHolder viewHolder3 = list.get(i5);
                if (left2 <= 0 || (right = viewHolder3.itemView.getRight() - width) >= 0 || viewHolder3.itemView.getRight() <= viewHolder.itemView.getRight() || (i3 = Math.abs(right)) <= i4) {
                    i3 = i4;
                } else {
                    viewHolder2 = viewHolder3;
                }
                if (left2 < 0 && (left = viewHolder3.itemView.getLeft() - i) > 0 && viewHolder3.itemView.getLeft() < viewHolder.itemView.getLeft() && (abs2 = Math.abs(left)) > i3) {
                    i3 = abs2;
                    viewHolder2 = viewHolder3;
                }
                if (top2 < 0 && (top = viewHolder3.itemView.getTop() - i2) > 0 && viewHolder3.itemView.getTop() < viewHolder.itemView.getTop() && (abs = Math.abs(top)) > i3) {
                    i3 = abs;
                    viewHolder2 = viewHolder3;
                }
                if (top2 <= 0 || (bottom = viewHolder3.itemView.getBottom() - height) >= 0 || viewHolder3.itemView.getBottom() <= viewHolder.itemView.getBottom() || (i4 = Math.abs(bottom)) <= i3) {
                    i4 = i3;
                } else {
                    viewHolder2 = viewHolder3;
                }
            }
            return viewHolder2;
        }

        public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            f3195a.clearView(viewHolder.itemView);
        }

        public int convertToAbsoluteDirection(int i, int i2) {
            int i3;
            int i4 = i & 3158064;
            if (i4 == 0) {
                return i;
            }
            int i5 = i & (i4 ^ (-1));
            if (i2 == 0) {
                i3 = i4 >> 2;
            } else {
                int i6 = i4 >> 1;
                i5 |= (-3158065) & i6;
                i3 = (i6 & 3158064) >> 2;
            }
            return i5 | i3;
        }

        public long getAnimationDuration(RecyclerView recyclerView, int i, float f2, float f3) {
            RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
            if (itemAnimator == null) {
                return i == 8 ? 200L : 250L;
            }
            if (i == 8) {
                return itemAnimator.getMoveDuration();
            }
            return itemAnimator.getRemoveDuration();
        }

        public int getBoundingBoxMargin() {
            return 0;
        }

        public float getMoveThreshold(RecyclerView.ViewHolder viewHolder) {
            return 0.5f;
        }

        public abstract int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder);

        public float getSwipeEscapeVelocity(float f2) {
            return f2;
        }

        public float getSwipeThreshold(RecyclerView.ViewHolder viewHolder) {
            return 0.5f;
        }

        public float getSwipeVelocityThreshold(float f2) {
            return f2;
        }

        public int interpolateOutOfBoundsScroll(RecyclerView recyclerView, int i, int i2, int i3, long j) {
            int signum = (int) (((int) (((int) Math.signum(i2)) * a(recyclerView) * f3197c.getInterpolation(Math.min(1.0f, (Math.abs(i2) * 1.0f) / i)))) * f3196b.getInterpolation(j <= 2000 ? ((float) j) / 2000.0f : 1.0f));
            return signum == 0 ? i2 > 0 ? 1 : -1 : signum;
        }

        public boolean isItemViewSwipeEnabled() {
            return true;
        }

        public boolean isLongPressDragEnabled() {
            return true;
        }

        public void onChildDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float f2, float f3, int i, boolean z) {
            f3195a.onDraw(canvas, recyclerView, viewHolder.itemView, f2, f3, i, z);
        }

        public void onChildDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float f2, float f3, int i, boolean z) {
            f3195a.onDrawOver(canvas, recyclerView, viewHolder.itemView, f2, f3, i, z);
        }

        public abstract boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2);

        /* JADX WARN: Multi-variable type inference failed */
        public void onMoved(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, int i, RecyclerView.ViewHolder viewHolder2, int i2, int i3, int i4) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof ViewDropHandler) {
                ((ViewDropHandler) layoutManager).prepareForDrop(viewHolder.itemView, viewHolder2.itemView, i3, i4);
                return;
            }
            if (layoutManager.canScrollHorizontally()) {
                if (layoutManager.getDecoratedLeft(viewHolder2.itemView) <= recyclerView.getPaddingLeft()) {
                    recyclerView.scrollToPosition(i2);
                }
                if (layoutManager.getDecoratedRight(viewHolder2.itemView) >= recyclerView.getWidth() - recyclerView.getPaddingRight()) {
                    recyclerView.scrollToPosition(i2);
                }
            }
            if (layoutManager.canScrollVertically()) {
                if (layoutManager.getDecoratedTop(viewHolder2.itemView) <= recyclerView.getPaddingTop()) {
                    recyclerView.scrollToPosition(i2);
                }
                if (layoutManager.getDecoratedBottom(viewHolder2.itemView) >= recyclerView.getHeight() - recyclerView.getPaddingBottom()) {
                    recyclerView.scrollToPosition(i2);
                }
            }
        }

        public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int i) {
            if (viewHolder != null) {
                f3195a.onSelected(viewHolder.itemView);
            }
        }

        public abstract void onSwiped(RecyclerView.ViewHolder viewHolder, int i);

        void b(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, List<RecoverAnimation> list, int i, float f2, float f3) {
            int size = list.size();
            boolean z = false;
            for (int i2 = 0; i2 < size; i2++) {
                RecoverAnimation recoverAnimation = list.get(i2);
                int save = canvas.save();
                onChildDrawOver(canvas, recyclerView, recoverAnimation.f3205e, recoverAnimation.i, recoverAnimation.j, recoverAnimation.f3206f, false);
                canvas.restoreToCount(save);
            }
            if (viewHolder != null) {
                int save2 = canvas.save();
                onChildDrawOver(canvas, recyclerView, viewHolder, f2, f3, i, true);
                canvas.restoreToCount(save2);
            }
            for (int i3 = size - 1; i3 >= 0; i3--) {
                RecoverAnimation recoverAnimation2 = list.get(i3);
                if (recoverAnimation2.l && !recoverAnimation2.mIsPendingCleanup) {
                    list.remove(i3);
                } else if (!recoverAnimation2.l) {
                    z = true;
                }
            }
            if (z) {
                recyclerView.invalidate();
            }
        }

        private int a(RecyclerView recyclerView) {
            if (this.f3198d == -1) {
                this.f3198d = recyclerView.getResources().getDimensionPixelSize(R.dimen.item_touch_helper_max_drag_scroll_per_frame);
            }
            return this.f3198d;
        }

        void a(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, List<RecoverAnimation> list, int i, float f2, float f3) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                RecoverAnimation recoverAnimation = list.get(i2);
                recoverAnimation.update();
                int save = canvas.save();
                onChildDraw(canvas, recyclerView, recoverAnimation.f3205e, recoverAnimation.i, recoverAnimation.j, recoverAnimation.f3206f, false);
                canvas.restoreToCount(save);
            }
            if (viewHolder != null) {
                int save2 = canvas.save();
                onChildDraw(canvas, recyclerView, viewHolder, f2, f3, i, true);
                canvas.restoreToCount(save2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class ItemTouchHelperGestureListener extends GestureDetector.SimpleOnGestureListener {

        /* renamed from: a, reason: collision with root package name */
        private boolean f3199a = true;

        ItemTouchHelperGestureListener() {
        }

        void a() {
            this.f3199a = false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            View b2;
            RecyclerView.ViewHolder childViewHolder;
            if (!this.f3199a || (b2 = ItemTouchHelper.this.b(motionEvent)) == null || (childViewHolder = ItemTouchHelper.this.r.getChildViewHolder(b2)) == null) {
                return;
            }
            ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
            if (itemTouchHelper.m.b(itemTouchHelper.r, childViewHolder)) {
                int pointerId = motionEvent.getPointerId(0);
                int i = ItemTouchHelper.this.l;
                if (pointerId == i) {
                    int findPointerIndex = motionEvent.findPointerIndex(i);
                    float x = motionEvent.getX(findPointerIndex);
                    float y = motionEvent.getY(findPointerIndex);
                    ItemTouchHelper itemTouchHelper2 = ItemTouchHelper.this;
                    itemTouchHelper2.f3184d = x;
                    itemTouchHelper2.f3185e = y;
                    itemTouchHelper2.i = 0.0f;
                    itemTouchHelper2.f3188h = 0.0f;
                    if (itemTouchHelper2.m.isLongPressDragEnabled()) {
                        ItemTouchHelper.this.a(childViewHolder, 2);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class RecoverAnimation implements Animator.AnimatorListener {

        /* renamed from: a, reason: collision with root package name */
        final float f3201a;

        /* renamed from: b, reason: collision with root package name */
        final float f3202b;

        /* renamed from: c, reason: collision with root package name */
        final float f3203c;

        /* renamed from: d, reason: collision with root package name */
        final float f3204d;

        /* renamed from: e, reason: collision with root package name */
        final RecyclerView.ViewHolder f3205e;

        /* renamed from: f, reason: collision with root package name */
        final int f3206f;

        /* renamed from: h, reason: collision with root package name */
        final int f3208h;
        float i;
        float j;
        private float m;
        public boolean mIsPendingCleanup;
        boolean k = false;
        boolean l = false;

        /* renamed from: g, reason: collision with root package name */
        private final ValueAnimator f3207g = ValueAnimator.ofFloat(0.0f, 1.0f);

        RecoverAnimation(RecyclerView.ViewHolder viewHolder, int i, int i2, float f2, float f3, float f4, float f5) {
            this.f3206f = i2;
            this.f3208h = i;
            this.f3205e = viewHolder;
            this.f3201a = f2;
            this.f3202b = f3;
            this.f3203c = f4;
            this.f3204d = f5;
            this.f3207g.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: android.support.v7.widget.helper.ItemTouchHelper.RecoverAnimation.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    RecoverAnimation.this.setFraction(valueAnimator.getAnimatedFraction());
                }
            });
            this.f3207g.setTarget(viewHolder.itemView);
            this.f3207g.addListener(this);
            setFraction(0.0f);
        }

        public void cancel() {
            this.f3207g.cancel();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            setFraction(1.0f);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (!this.l) {
                this.f3205e.setIsRecyclable(true);
            }
            this.l = true;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        public void setDuration(long j) {
            this.f3207g.setDuration(j);
        }

        public void setFraction(float f2) {
            this.m = f2;
        }

        public void start() {
            this.f3205e.setIsRecyclable(false);
            this.f3207g.start();
        }

        public void update() {
            float f2 = this.f3201a;
            float f3 = this.f3203c;
            if (f2 == f3) {
                this.i = this.f3205e.itemView.getTranslationX();
            } else {
                this.i = f2 + (this.m * (f3 - f2));
            }
            float f4 = this.f3202b;
            float f5 = this.f3204d;
            if (f4 == f5) {
                this.j = this.f3205e.itemView.getTranslationY();
            } else {
                this.j = f4 + (this.m * (f5 - f4));
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class SimpleCallback extends Callback {

        /* renamed from: e, reason: collision with root package name */
        private int f3210e;

        /* renamed from: f, reason: collision with root package name */
        private int f3211f;

        public SimpleCallback(int i, int i2) {
            this.f3210e = i2;
            this.f3211f = i;
        }

        public int getDragDirs(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return this.f3211f;
        }

        @Override // android.support.v7.widget.helper.ItemTouchHelper.Callback
        public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return Callback.makeMovementFlags(getDragDirs(recyclerView, viewHolder), getSwipeDirs(recyclerView, viewHolder));
        }

        public int getSwipeDirs(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return this.f3210e;
        }

        public void setDefaultDragDirs(int i) {
            this.f3211f = i;
        }

        public void setDefaultSwipeDirs(int i) {
            this.f3210e = i;
        }
    }

    /* loaded from: classes.dex */
    public interface ViewDropHandler {
        void prepareForDrop(View view, View view2, int i, int i2);
    }

    public ItemTouchHelper(Callback callback) {
        this.m = callback;
    }

    private static boolean a(View view, float f2, float f3, float f4, float f5) {
        return f2 >= f4 && f2 <= f4 + ((float) view.getWidth()) && f3 >= f5 && f3 <= f5 + ((float) view.getHeight());
    }

    private List<RecyclerView.ViewHolder> b(RecyclerView.ViewHolder viewHolder) {
        RecyclerView.ViewHolder viewHolder2 = viewHolder;
        List<RecyclerView.ViewHolder> list = this.u;
        if (list == null) {
            this.u = new ArrayList();
            this.v = new ArrayList();
        } else {
            list.clear();
            this.v.clear();
        }
        int boundingBoxMargin = this.m.getBoundingBoxMargin();
        int round = Math.round(this.j + this.f3188h) - boundingBoxMargin;
        int round2 = Math.round(this.k + this.i) - boundingBoxMargin;
        int i = boundingBoxMargin * 2;
        int width = viewHolder2.itemView.getWidth() + round + i;
        int height = viewHolder2.itemView.getHeight() + round2 + i;
        int i2 = (round + width) / 2;
        int i3 = (round2 + height) / 2;
        RecyclerView.LayoutManager layoutManager = this.r.getLayoutManager();
        int childCount = layoutManager.getChildCount();
        int i4 = 0;
        while (i4 < childCount) {
            View childAt = layoutManager.getChildAt(i4);
            if (childAt != viewHolder2.itemView && childAt.getBottom() >= round2 && childAt.getTop() <= height && childAt.getRight() >= round && childAt.getLeft() <= width) {
                RecyclerView.ViewHolder childViewHolder = this.r.getChildViewHolder(childAt);
                if (this.m.canDropOver(this.r, this.f3183c, childViewHolder)) {
                    int abs = Math.abs(i2 - ((childAt.getLeft() + childAt.getRight()) / 2));
                    int abs2 = Math.abs(i3 - ((childAt.getTop() + childAt.getBottom()) / 2));
                    int i5 = (abs * abs) + (abs2 * abs2);
                    int size = this.u.size();
                    int i6 = 0;
                    for (int i7 = 0; i7 < size && i5 > this.v.get(i7).intValue(); i7++) {
                        i6++;
                    }
                    this.u.add(i6, childViewHolder);
                    this.v.add(i6, Integer.valueOf(i5));
                }
            }
            i4++;
            viewHolder2 = viewHolder;
        }
        return this.u;
    }

    private void d() {
        if (Build.VERSION.SDK_INT >= 21) {
            return;
        }
        if (this.w == null) {
            this.w = new RecyclerView.ChildDrawingOrderCallback() { // from class: android.support.v7.widget.helper.ItemTouchHelper.5
                @Override // android.support.v7.widget.RecyclerView.ChildDrawingOrderCallback
                public int onGetChildDrawingOrder(int i, int i2) {
                    ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
                    View view = itemTouchHelper.x;
                    if (view == null) {
                        return i2;
                    }
                    int i3 = itemTouchHelper.y;
                    if (i3 == -1) {
                        i3 = itemTouchHelper.r.indexOfChild(view);
                        ItemTouchHelper.this.y = i3;
                    }
                    return i2 == i + (-1) ? i3 : i2 < i3 ? i2 : i2 + 1;
                }
            };
        }
        this.r.setChildDrawingOrderCallback(this.w);
    }

    private void e() {
        this.r.removeItemDecoration(this);
        this.r.removeOnItemTouchListener(this.B);
        this.r.removeOnChildAttachStateChangeListener(this);
        for (int size = this.p.size() - 1; size >= 0; size--) {
            this.m.clearView(this.r, this.p.get(0).f3205e);
        }
        this.p.clear();
        this.x = null;
        this.y = -1;
        f();
        i();
    }

    private void f() {
        VelocityTracker velocityTracker = this.t;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.t = null;
        }
    }

    private void g() {
        this.q = ViewConfiguration.get(this.r.getContext()).getScaledTouchSlop();
        this.r.addItemDecoration(this);
        this.r.addOnItemTouchListener(this.B);
        this.r.addOnChildAttachStateChangeListener(this);
        h();
    }

    private void h() {
        this.A = new ItemTouchHelperGestureListener();
        this.z = new GestureDetectorCompat(this.r.getContext(), this.A);
    }

    private void i() {
        ItemTouchHelperGestureListener itemTouchHelperGestureListener = this.A;
        if (itemTouchHelperGestureListener != null) {
            itemTouchHelperGestureListener.a();
            this.A = null;
        }
        if (this.z != null) {
            this.z = null;
        }
    }

    public void attachToRecyclerView(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.r;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            e();
        }
        this.r = recyclerView;
        if (recyclerView != null) {
            Resources resources = recyclerView.getResources();
            this.f3186f = resources.getDimension(R.dimen.item_touch_helper_swipe_escape_velocity);
            this.f3187g = resources.getDimension(R.dimen.item_touch_helper_swipe_escape_max_velocity);
            g();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x00c5, code lost:            if (r1 > 0) goto L37;     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0104 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0101  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    boolean c() {
        /*
            Method dump skipped, instructions count: 281
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.helper.ItemTouchHelper.c():boolean");
    }

    @Override // android.support.v7.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        rect.setEmpty();
    }

    @Override // android.support.v7.widget.RecyclerView.OnChildAttachStateChangeListener
    public void onChildViewAttachedToWindow(View view) {
    }

    @Override // android.support.v7.widget.RecyclerView.OnChildAttachStateChangeListener
    public void onChildViewDetachedFromWindow(View view) {
        a(view);
        RecyclerView.ViewHolder childViewHolder = this.r.getChildViewHolder(view);
        if (childViewHolder == null) {
            return;
        }
        RecyclerView.ViewHolder viewHolder = this.f3183c;
        if (viewHolder != null && childViewHolder == viewHolder) {
            a((RecyclerView.ViewHolder) null, 0);
            return;
        }
        a(childViewHolder, false);
        if (this.f3181a.remove(childViewHolder.itemView)) {
            this.m.clearView(this.r, childViewHolder);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        float f2;
        float f3;
        this.y = -1;
        if (this.f3183c != null) {
            a(this.f3182b);
            float[] fArr = this.f3182b;
            float f4 = fArr[0];
            f3 = fArr[1];
            f2 = f4;
        } else {
            f2 = 0.0f;
            f3 = 0.0f;
        }
        this.m.a(canvas, recyclerView, this.f3183c, this.p, this.n, f2, f3);
    }

    @Override // android.support.v7.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        float f2;
        float f3;
        if (this.f3183c != null) {
            a(this.f3182b);
            float[] fArr = this.f3182b;
            float f4 = fArr[0];
            f3 = fArr[1];
            f2 = f4;
        } else {
            f2 = 0.0f;
            f3 = 0.0f;
        }
        this.m.b(canvas, recyclerView, this.f3183c, this.p, this.n, f2, f3);
    }

    public void startDrag(RecyclerView.ViewHolder viewHolder) {
        if (!this.m.b(this.r, viewHolder)) {
            Log.e("ItemTouchHelper", "Start drag has been called but dragging is not enabled");
            return;
        }
        if (viewHolder.itemView.getParent() != this.r) {
            Log.e("ItemTouchHelper", "Start drag has been called with a view holder which is not a child of the RecyclerView which is controlled by this ItemTouchHelper.");
            return;
        }
        b();
        this.i = 0.0f;
        this.f3188h = 0.0f;
        a(viewHolder, 2);
    }

    public void startSwipe(RecyclerView.ViewHolder viewHolder) {
        if (!this.m.c(this.r, viewHolder)) {
            Log.e("ItemTouchHelper", "Start swipe has been called but swiping is not enabled");
            return;
        }
        if (viewHolder.itemView.getParent() != this.r) {
            Log.e("ItemTouchHelper", "Start swipe has been called with a view holder which is not a child of the RecyclerView controlled by this ItemTouchHelper.");
            return;
        }
        b();
        this.i = 0.0f;
        this.f3188h = 0.0f;
        a(viewHolder, 1);
    }

    private void a(float[] fArr) {
        if ((this.o & 12) != 0) {
            fArr[0] = (this.j + this.f3188h) - this.f3183c.itemView.getLeft();
        } else {
            fArr[0] = this.f3183c.itemView.getTranslationX();
        }
        if ((this.o & 3) != 0) {
            fArr[1] = (this.k + this.i) - this.f3183c.itemView.getTop();
        } else {
            fArr[1] = this.f3183c.itemView.getTranslationY();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x012c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void a(android.support.v7.widget.RecyclerView.ViewHolder r24, int r25) {
        /*
            Method dump skipped, instructions count: 324
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.helper.ItemTouchHelper.a(android.support.v7.widget.RecyclerView$ViewHolder, int):void");
    }

    void b() {
        VelocityTracker velocityTracker = this.t;
        if (velocityTracker != null) {
            velocityTracker.recycle();
        }
        this.t = VelocityTracker.obtain();
    }

    View b(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        RecyclerView.ViewHolder viewHolder = this.f3183c;
        if (viewHolder != null) {
            View view = viewHolder.itemView;
            if (a(view, x, y, this.j + this.f3188h, this.k + this.i)) {
                return view;
            }
        }
        for (int size = this.p.size() - 1; size >= 0; size--) {
            RecoverAnimation recoverAnimation = this.p.get(size);
            View view2 = recoverAnimation.f3205e.itemView;
            if (a(view2, x, y, recoverAnimation.i, recoverAnimation.j)) {
                return view2;
            }
        }
        return this.r.findChildViewUnder(x, y);
    }

    private RecyclerView.ViewHolder c(MotionEvent motionEvent) {
        View b2;
        RecyclerView.LayoutManager layoutManager = this.r.getLayoutManager();
        int i = this.l;
        if (i == -1) {
            return null;
        }
        int findPointerIndex = motionEvent.findPointerIndex(i);
        float x = motionEvent.getX(findPointerIndex) - this.f3184d;
        float y = motionEvent.getY(findPointerIndex) - this.f3185e;
        float abs = Math.abs(x);
        float abs2 = Math.abs(y);
        int i2 = this.q;
        if (abs < i2 && abs2 < i2) {
            return null;
        }
        if (abs > abs2 && layoutManager.canScrollHorizontally()) {
            return null;
        }
        if ((abs2 <= abs || !layoutManager.canScrollVertically()) && (b2 = b(motionEvent)) != null) {
            return this.r.getChildViewHolder(b2);
        }
        return null;
    }

    private int b(RecyclerView.ViewHolder viewHolder, int i) {
        if ((i & 12) == 0) {
            return 0;
        }
        int i2 = this.f3188h > 0.0f ? 8 : 4;
        VelocityTracker velocityTracker = this.t;
        if (velocityTracker != null && this.l > -1) {
            velocityTracker.computeCurrentVelocity(1000, this.m.getSwipeVelocityThreshold(this.f3187g));
            float xVelocity = this.t.getXVelocity(this.l);
            float yVelocity = this.t.getYVelocity(this.l);
            int i3 = xVelocity <= 0.0f ? 4 : 8;
            float abs = Math.abs(xVelocity);
            if ((i3 & i) != 0 && i2 == i3 && abs >= this.m.getSwipeEscapeVelocity(this.f3186f) && abs > Math.abs(yVelocity)) {
                return i3;
            }
        }
        float width = this.r.getWidth() * this.m.getSwipeThreshold(viewHolder);
        if ((i & i2) == 0 || Math.abs(this.f3188h) <= width) {
            return 0;
        }
        return i2;
    }

    void a(final RecoverAnimation recoverAnimation, final int i) {
        this.r.post(new Runnable() { // from class: android.support.v7.widget.helper.ItemTouchHelper.4
            @Override // java.lang.Runnable
            public void run() {
                RecyclerView recyclerView = ItemTouchHelper.this.r;
                if (recyclerView == null || !recyclerView.isAttachedToWindow()) {
                    return;
                }
                RecoverAnimation recoverAnimation2 = recoverAnimation;
                if (recoverAnimation2.k || recoverAnimation2.f3205e.getAdapterPosition() == -1) {
                    return;
                }
                RecyclerView.ItemAnimator itemAnimator = ItemTouchHelper.this.r.getItemAnimator();
                if ((itemAnimator == null || !itemAnimator.isRunning(null)) && !ItemTouchHelper.this.a()) {
                    ItemTouchHelper.this.m.onSwiped(recoverAnimation.f3205e, i);
                } else {
                    ItemTouchHelper.this.r.post(this);
                }
            }
        });
    }

    boolean a() {
        int size = this.p.size();
        for (int i = 0; i < size; i++) {
            if (!this.p.get(i).l) {
                return true;
            }
        }
        return false;
    }

    void a(RecyclerView.ViewHolder viewHolder) {
        if (!this.r.isLayoutRequested() && this.n == 2) {
            float moveThreshold = this.m.getMoveThreshold(viewHolder);
            int i = (int) (this.j + this.f3188h);
            int i2 = (int) (this.k + this.i);
            if (Math.abs(i2 - viewHolder.itemView.getTop()) >= viewHolder.itemView.getHeight() * moveThreshold || Math.abs(i - viewHolder.itemView.getLeft()) >= viewHolder.itemView.getWidth() * moveThreshold) {
                List<RecyclerView.ViewHolder> b2 = b(viewHolder);
                if (b2.size() == 0) {
                    return;
                }
                RecyclerView.ViewHolder chooseDropTarget = this.m.chooseDropTarget(viewHolder, b2, i, i2);
                if (chooseDropTarget == null) {
                    this.u.clear();
                    this.v.clear();
                    return;
                }
                int adapterPosition = chooseDropTarget.getAdapterPosition();
                int adapterPosition2 = viewHolder.getAdapterPosition();
                if (this.m.onMove(this.r, viewHolder, chooseDropTarget)) {
                    this.m.onMoved(this.r, viewHolder, adapterPosition2, chooseDropTarget, adapterPosition, i, i2);
                }
            }
        }
    }

    private int c(RecyclerView.ViewHolder viewHolder) {
        if (this.n == 2) {
            return 0;
        }
        int movementFlags = this.m.getMovementFlags(this.r, viewHolder);
        int convertToAbsoluteDirection = (this.m.convertToAbsoluteDirection(movementFlags, ViewCompat.getLayoutDirection(this.r)) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
        if (convertToAbsoluteDirection == 0) {
            return 0;
        }
        int i = (movementFlags & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
        if (Math.abs(this.f3188h) > Math.abs(this.i)) {
            int b2 = b(viewHolder, convertToAbsoluteDirection);
            if (b2 > 0) {
                return (i & b2) == 0 ? Callback.convertToRelativeDirection(b2, ViewCompat.getLayoutDirection(this.r)) : b2;
            }
            int c2 = c(viewHolder, convertToAbsoluteDirection);
            if (c2 > 0) {
                return c2;
            }
        } else {
            int c3 = c(viewHolder, convertToAbsoluteDirection);
            if (c3 > 0) {
                return c3;
            }
            int b3 = b(viewHolder, convertToAbsoluteDirection);
            if (b3 > 0) {
                return (i & b3) == 0 ? Callback.convertToRelativeDirection(b3, ViewCompat.getLayoutDirection(this.r)) : b3;
            }
        }
        return 0;
    }

    private int c(RecyclerView.ViewHolder viewHolder, int i) {
        if ((i & 3) == 0) {
            return 0;
        }
        int i2 = this.i > 0.0f ? 2 : 1;
        VelocityTracker velocityTracker = this.t;
        if (velocityTracker != null && this.l > -1) {
            velocityTracker.computeCurrentVelocity(1000, this.m.getSwipeVelocityThreshold(this.f3187g));
            float xVelocity = this.t.getXVelocity(this.l);
            float yVelocity = this.t.getYVelocity(this.l);
            int i3 = yVelocity <= 0.0f ? 1 : 2;
            float abs = Math.abs(yVelocity);
            if ((i3 & i) != 0 && i3 == i2 && abs >= this.m.getSwipeEscapeVelocity(this.f3186f) && abs > Math.abs(xVelocity)) {
                return i3;
            }
        }
        float height = this.r.getHeight() * this.m.getSwipeThreshold(viewHolder);
        if ((i & i2) == 0 || Math.abs(this.i) <= height) {
            return 0;
        }
        return i2;
    }

    int a(RecyclerView.ViewHolder viewHolder, boolean z) {
        for (int size = this.p.size() - 1; size >= 0; size--) {
            RecoverAnimation recoverAnimation = this.p.get(size);
            if (recoverAnimation.f3205e == viewHolder) {
                recoverAnimation.k |= z;
                if (!recoverAnimation.l) {
                    recoverAnimation.cancel();
                }
                this.p.remove(size);
                return recoverAnimation.f3208h;
            }
        }
        return 0;
    }

    boolean a(int i, MotionEvent motionEvent, int i2) {
        RecyclerView.ViewHolder c2;
        int a2;
        if (this.f3183c != null || i != 2 || this.n == 2 || !this.m.isItemViewSwipeEnabled() || this.r.getScrollState() == 1 || (c2 = c(motionEvent)) == null || (a2 = (this.m.a(this.r, c2) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8) == 0) {
            return false;
        }
        float x = motionEvent.getX(i2);
        float y = motionEvent.getY(i2);
        float f2 = x - this.f3184d;
        float f3 = y - this.f3185e;
        float abs = Math.abs(f2);
        float abs2 = Math.abs(f3);
        int i3 = this.q;
        if (abs < i3 && abs2 < i3) {
            return false;
        }
        if (abs > abs2) {
            if (f2 < 0.0f && (a2 & 4) == 0) {
                return false;
            }
            if (f2 > 0.0f && (a2 & 8) == 0) {
                return false;
            }
        } else {
            if (f3 < 0.0f && (a2 & 1) == 0) {
                return false;
            }
            if (f3 > 0.0f && (a2 & 2) == 0) {
                return false;
            }
        }
        this.i = 0.0f;
        this.f3188h = 0.0f;
        this.l = motionEvent.getPointerId(0);
        a(c2, 1);
        return true;
    }

    RecoverAnimation a(MotionEvent motionEvent) {
        if (this.p.isEmpty()) {
            return null;
        }
        View b2 = b(motionEvent);
        for (int size = this.p.size() - 1; size >= 0; size--) {
            RecoverAnimation recoverAnimation = this.p.get(size);
            if (recoverAnimation.f3205e.itemView == b2) {
                return recoverAnimation;
            }
        }
        return null;
    }

    void a(MotionEvent motionEvent, int i, int i2) {
        float x = motionEvent.getX(i2);
        float y = motionEvent.getY(i2);
        this.f3188h = x - this.f3184d;
        this.i = y - this.f3185e;
        if ((i & 4) == 0) {
            this.f3188h = Math.max(0.0f, this.f3188h);
        }
        if ((i & 8) == 0) {
            this.f3188h = Math.min(0.0f, this.f3188h);
        }
        if ((i & 1) == 0) {
            this.i = Math.max(0.0f, this.i);
        }
        if ((i & 2) == 0) {
            this.i = Math.min(0.0f, this.i);
        }
    }

    void a(View view) {
        if (view == this.x) {
            this.x = null;
            if (this.w != null) {
                this.r.setChildDrawingOrderCallback(null);
            }
        }
    }
}
