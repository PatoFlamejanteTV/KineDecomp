package android.support.v4.app;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Parcelable;
import android.view.View;
import java.util.List;
import java.util.Map;

/* compiled from: ActivityCompat21.java */
/* loaded from: classes2.dex */
class b {

    /* compiled from: ActivityCompat21.java */
    /* loaded from: classes2.dex */
    public static abstract class a {
        public abstract Parcelable a(View view, Matrix matrix, RectF rectF);

        public abstract View a(Context context, Parcelable parcelable);

        public abstract void a(List<View> list);

        public abstract void a(List<String> list, List<View> list2, List<View> list3);

        public abstract void a(List<String> list, Map<String, View> map);

        public abstract void b(List<String> list, List<View> list2, List<View> list3);
    }

    public static void a(Activity activity) {
        activity.finishAfterTransition();
    }

    public static void a(Activity activity, a aVar) {
        activity.setEnterSharedElementCallback(a(aVar));
    }

    public static void b(Activity activity, a aVar) {
        activity.setExitSharedElementCallback(a(aVar));
    }

    public static void b(Activity activity) {
        activity.postponeEnterTransition();
    }

    public static void c(Activity activity) {
        activity.startPostponedEnterTransition();
    }

    private static SharedElementCallback a(a aVar) {
        if (aVar == null) {
            return null;
        }
        return new SharedElementCallbackC0006b(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ActivityCompat21.java */
    /* renamed from: android.support.v4.app.b$b, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class SharedElementCallbackC0006b extends SharedElementCallback {

        /* renamed from: a, reason: collision with root package name */
        private a f51a;

        public SharedElementCallbackC0006b(a aVar) {
            this.f51a = aVar;
        }

        @Override // android.app.SharedElementCallback
        public void onSharedElementStart(List<String> list, List<View> list2, List<View> list3) {
            this.f51a.a(list, list2, list3);
        }

        @Override // android.app.SharedElementCallback
        public void onSharedElementEnd(List<String> list, List<View> list2, List<View> list3) {
            this.f51a.b(list, list2, list3);
        }

        @Override // android.app.SharedElementCallback
        public void onRejectSharedElements(List<View> list) {
            this.f51a.a(list);
        }

        @Override // android.app.SharedElementCallback
        public void onMapSharedElements(List<String> list, Map<String, View> map) {
            this.f51a.a(list, map);
        }

        @Override // android.app.SharedElementCallback
        public Parcelable onCaptureSharedElementSnapshot(View view, Matrix matrix, RectF rectF) {
            return this.f51a.a(view, matrix, rectF);
        }

        @Override // android.app.SharedElementCallback
        public View onCreateSnapshotView(Context context, Parcelable parcelable) {
            return this.f51a.a(context, parcelable);
        }
    }
}
