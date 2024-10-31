package android.support.v4.app;

import android.app.Activity;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.SparseIntArray;
import android.view.FrameMetrics;
import android.view.Window;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class FrameMetricsAggregator {
    public static final int ANIMATION_DURATION = 256;
    public static final int ANIMATION_INDEX = 8;
    public static final int COMMAND_DURATION = 32;
    public static final int COMMAND_INDEX = 5;
    public static final int DELAY_DURATION = 128;
    public static final int DELAY_INDEX = 7;
    public static final int DRAW_DURATION = 8;
    public static final int DRAW_INDEX = 3;
    public static final int EVERY_DURATION = 511;
    public static final int INPUT_DURATION = 2;
    public static final int INPUT_INDEX = 1;
    public static final int LAYOUT_MEASURE_DURATION = 4;
    public static final int LAYOUT_MEASURE_INDEX = 2;
    public static final int SWAP_DURATION = 64;
    public static final int SWAP_INDEX = 6;
    public static final int SYNC_DURATION = 16;
    public static final int SYNC_INDEX = 4;
    public static final int TOTAL_DURATION = 1;
    public static final int TOTAL_INDEX = 0;

    /* renamed from: a */
    private FrameMetricsBaseImpl f859a;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class FrameMetricsApi24Impl extends FrameMetricsBaseImpl {

        /* renamed from: a */
        private static HandlerThread f860a;

        /* renamed from: b */
        private static Handler f861b;

        /* renamed from: c */
        private int f862c;

        /* renamed from: d */
        private SparseIntArray[] f863d;

        /* renamed from: e */
        private ArrayList<WeakReference<Activity>> f864e;

        /* renamed from: f */
        Window.OnFrameMetricsAvailableListener f865f;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: android.support.v4.app.FrameMetricsAggregator$FrameMetricsApi24Impl$1 */
        /* loaded from: classes.dex */
        public class AnonymousClass1 implements Window.OnFrameMetricsAvailableListener {
            AnonymousClass1() {
            }

            @Override // android.view.Window.OnFrameMetricsAvailableListener
            public void onFrameMetricsAvailable(Window window, FrameMetrics frameMetrics, int i) {
                if ((FrameMetricsApi24Impl.this.f862c & 1) != 0) {
                    FrameMetricsApi24Impl frameMetricsApi24Impl = FrameMetricsApi24Impl.this;
                    frameMetricsApi24Impl.a(frameMetricsApi24Impl.f863d[0], frameMetrics.getMetric(8));
                }
                if ((FrameMetricsApi24Impl.this.f862c & 2) != 0) {
                    FrameMetricsApi24Impl frameMetricsApi24Impl2 = FrameMetricsApi24Impl.this;
                    frameMetricsApi24Impl2.a(frameMetricsApi24Impl2.f863d[1], frameMetrics.getMetric(1));
                }
                if ((FrameMetricsApi24Impl.this.f862c & 4) != 0) {
                    FrameMetricsApi24Impl frameMetricsApi24Impl3 = FrameMetricsApi24Impl.this;
                    frameMetricsApi24Impl3.a(frameMetricsApi24Impl3.f863d[2], frameMetrics.getMetric(3));
                }
                if ((FrameMetricsApi24Impl.this.f862c & 8) != 0) {
                    FrameMetricsApi24Impl frameMetricsApi24Impl4 = FrameMetricsApi24Impl.this;
                    frameMetricsApi24Impl4.a(frameMetricsApi24Impl4.f863d[3], frameMetrics.getMetric(4));
                }
                if ((FrameMetricsApi24Impl.this.f862c & 16) != 0) {
                    FrameMetricsApi24Impl frameMetricsApi24Impl5 = FrameMetricsApi24Impl.this;
                    frameMetricsApi24Impl5.a(frameMetricsApi24Impl5.f863d[4], frameMetrics.getMetric(5));
                }
                if ((FrameMetricsApi24Impl.this.f862c & 64) != 0) {
                    FrameMetricsApi24Impl frameMetricsApi24Impl6 = FrameMetricsApi24Impl.this;
                    frameMetricsApi24Impl6.a(frameMetricsApi24Impl6.f863d[6], frameMetrics.getMetric(7));
                }
                if ((FrameMetricsApi24Impl.this.f862c & 32) != 0) {
                    FrameMetricsApi24Impl frameMetricsApi24Impl7 = FrameMetricsApi24Impl.this;
                    frameMetricsApi24Impl7.a(frameMetricsApi24Impl7.f863d[5], frameMetrics.getMetric(6));
                }
                if ((FrameMetricsApi24Impl.this.f862c & 128) != 0) {
                    FrameMetricsApi24Impl frameMetricsApi24Impl8 = FrameMetricsApi24Impl.this;
                    frameMetricsApi24Impl8.a(frameMetricsApi24Impl8.f863d[7], frameMetrics.getMetric(0));
                }
                if ((FrameMetricsApi24Impl.this.f862c & 256) != 0) {
                    FrameMetricsApi24Impl frameMetricsApi24Impl9 = FrameMetricsApi24Impl.this;
                    frameMetricsApi24Impl9.a(frameMetricsApi24Impl9.f863d[8], frameMetrics.getMetric(2));
                }
            }
        }

        FrameMetricsApi24Impl(int i) {
            super();
            this.f863d = new SparseIntArray[9];
            this.f864e = new ArrayList<>();
            this.f865f = new Window.OnFrameMetricsAvailableListener() { // from class: android.support.v4.app.FrameMetricsAggregator.FrameMetricsApi24Impl.1
                AnonymousClass1() {
                }

                @Override // android.view.Window.OnFrameMetricsAvailableListener
                public void onFrameMetricsAvailable(Window window, FrameMetrics frameMetrics, int i2) {
                    if ((FrameMetricsApi24Impl.this.f862c & 1) != 0) {
                        FrameMetricsApi24Impl frameMetricsApi24Impl = FrameMetricsApi24Impl.this;
                        frameMetricsApi24Impl.a(frameMetricsApi24Impl.f863d[0], frameMetrics.getMetric(8));
                    }
                    if ((FrameMetricsApi24Impl.this.f862c & 2) != 0) {
                        FrameMetricsApi24Impl frameMetricsApi24Impl2 = FrameMetricsApi24Impl.this;
                        frameMetricsApi24Impl2.a(frameMetricsApi24Impl2.f863d[1], frameMetrics.getMetric(1));
                    }
                    if ((FrameMetricsApi24Impl.this.f862c & 4) != 0) {
                        FrameMetricsApi24Impl frameMetricsApi24Impl3 = FrameMetricsApi24Impl.this;
                        frameMetricsApi24Impl3.a(frameMetricsApi24Impl3.f863d[2], frameMetrics.getMetric(3));
                    }
                    if ((FrameMetricsApi24Impl.this.f862c & 8) != 0) {
                        FrameMetricsApi24Impl frameMetricsApi24Impl4 = FrameMetricsApi24Impl.this;
                        frameMetricsApi24Impl4.a(frameMetricsApi24Impl4.f863d[3], frameMetrics.getMetric(4));
                    }
                    if ((FrameMetricsApi24Impl.this.f862c & 16) != 0) {
                        FrameMetricsApi24Impl frameMetricsApi24Impl5 = FrameMetricsApi24Impl.this;
                        frameMetricsApi24Impl5.a(frameMetricsApi24Impl5.f863d[4], frameMetrics.getMetric(5));
                    }
                    if ((FrameMetricsApi24Impl.this.f862c & 64) != 0) {
                        FrameMetricsApi24Impl frameMetricsApi24Impl6 = FrameMetricsApi24Impl.this;
                        frameMetricsApi24Impl6.a(frameMetricsApi24Impl6.f863d[6], frameMetrics.getMetric(7));
                    }
                    if ((FrameMetricsApi24Impl.this.f862c & 32) != 0) {
                        FrameMetricsApi24Impl frameMetricsApi24Impl7 = FrameMetricsApi24Impl.this;
                        frameMetricsApi24Impl7.a(frameMetricsApi24Impl7.f863d[5], frameMetrics.getMetric(6));
                    }
                    if ((FrameMetricsApi24Impl.this.f862c & 128) != 0) {
                        FrameMetricsApi24Impl frameMetricsApi24Impl8 = FrameMetricsApi24Impl.this;
                        frameMetricsApi24Impl8.a(frameMetricsApi24Impl8.f863d[7], frameMetrics.getMetric(0));
                    }
                    if ((FrameMetricsApi24Impl.this.f862c & 256) != 0) {
                        FrameMetricsApi24Impl frameMetricsApi24Impl9 = FrameMetricsApi24Impl.this;
                        frameMetricsApi24Impl9.a(frameMetricsApi24Impl9.f863d[8], frameMetrics.getMetric(2));
                    }
                }
            };
            this.f862c = i;
        }

        @Override // android.support.v4.app.FrameMetricsAggregator.FrameMetricsBaseImpl
        public void add(Activity activity) {
            if (f860a == null) {
                f860a = new HandlerThread("FrameMetricsAggregator");
                f860a.start();
                f861b = new Handler(f860a.getLooper());
            }
            for (int i = 0; i <= 8; i++) {
                SparseIntArray[] sparseIntArrayArr = this.f863d;
                if (sparseIntArrayArr[i] == null && (this.f862c & (1 << i)) != 0) {
                    sparseIntArrayArr[i] = new SparseIntArray();
                }
            }
            activity.getWindow().addOnFrameMetricsAvailableListener(this.f865f, f861b);
            this.f864e.add(new WeakReference<>(activity));
        }

        @Override // android.support.v4.app.FrameMetricsAggregator.FrameMetricsBaseImpl
        public SparseIntArray[] getMetrics() {
            return this.f863d;
        }

        @Override // android.support.v4.app.FrameMetricsAggregator.FrameMetricsBaseImpl
        public SparseIntArray[] remove(Activity activity) {
            Iterator<WeakReference<Activity>> it = this.f864e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                WeakReference<Activity> next = it.next();
                if (next.get() == activity) {
                    this.f864e.remove(next);
                    break;
                }
            }
            activity.getWindow().removeOnFrameMetricsAvailableListener(this.f865f);
            return this.f863d;
        }

        @Override // android.support.v4.app.FrameMetricsAggregator.FrameMetricsBaseImpl
        public SparseIntArray[] reset() {
            SparseIntArray[] sparseIntArrayArr = this.f863d;
            this.f863d = new SparseIntArray[9];
            return sparseIntArrayArr;
        }

        @Override // android.support.v4.app.FrameMetricsAggregator.FrameMetricsBaseImpl
        public SparseIntArray[] stop() {
            for (int size = this.f864e.size() - 1; size >= 0; size--) {
                WeakReference<Activity> weakReference = this.f864e.get(size);
                Activity activity = weakReference.get();
                if (weakReference.get() != null) {
                    activity.getWindow().removeOnFrameMetricsAvailableListener(this.f865f);
                    this.f864e.remove(size);
                }
            }
            return this.f863d;
        }

        void a(SparseIntArray sparseIntArray, long j) {
            if (sparseIntArray != null) {
                int i = (int) ((500000 + j) / 1000000);
                if (j >= 0) {
                    sparseIntArray.put(i, sparseIntArray.get(i) + 1);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class FrameMetricsBaseImpl {
        private FrameMetricsBaseImpl() {
        }

        public void add(Activity activity) {
        }

        public SparseIntArray[] getMetrics() {
            return null;
        }

        public SparseIntArray[] remove(Activity activity) {
            return null;
        }

        public SparseIntArray[] reset() {
            return null;
        }

        public SparseIntArray[] stop() {
            return null;
        }

        /* synthetic */ FrameMetricsBaseImpl(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface MetricType {
    }

    public FrameMetricsAggregator() {
        this(1);
    }

    public void add(Activity activity) {
        this.f859a.add(activity);
    }

    public SparseIntArray[] getMetrics() {
        return this.f859a.getMetrics();
    }

    public SparseIntArray[] remove(Activity activity) {
        return this.f859a.remove(activity);
    }

    public SparseIntArray[] reset() {
        return this.f859a.reset();
    }

    public SparseIntArray[] stop() {
        return this.f859a.stop();
    }

    public FrameMetricsAggregator(int i) {
        if (Build.VERSION.SDK_INT >= 24) {
            this.f859a = new FrameMetricsApi24Impl(i);
        } else {
            this.f859a = new FrameMetricsBaseImpl();
        }
    }
}
