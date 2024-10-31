package b.b.h.a;

import android.app.Activity;
import android.os.Build;
import android.view.DragAndDropPermissions;
import android.view.DragEvent;

/* compiled from: DragAndDropPermissionsCompat.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a */
    private Object f3366a;

    private a(Object obj) {
        this.f3366a = obj;
    }

    public static a a(Activity activity, DragEvent dragEvent) {
        DragAndDropPermissions requestDragAndDropPermissions;
        if (Build.VERSION.SDK_INT < 24 || (requestDragAndDropPermissions = activity.requestDragAndDropPermissions(dragEvent)) == null) {
            return null;
        }
        return new a(requestDragAndDropPermissions);
    }
}
