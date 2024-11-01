package android.support.v4.widget;

import android.view.View;
import android.widget.ListView;

/* compiled from: ListViewAutoScrollHelper.java */
/* loaded from: classes.dex */
public class d extends a {

    /* renamed from: a, reason: collision with root package name */
    private final ListView f113a;

    public d(ListView listView) {
        super(listView);
        this.f113a = listView;
    }

    @Override // android.support.v4.widget.a
    public void a(int i, int i2) {
        View childAt;
        ListView listView = this.f113a;
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        if (firstVisiblePosition != -1 && (childAt = listView.getChildAt(0)) != null) {
            listView.setSelectionFromTop(firstVisiblePosition, childAt.getTop() - i2);
        }
    }

    @Override // android.support.v4.widget.a
    public boolean e(int i) {
        return false;
    }

    @Override // android.support.v4.widget.a
    public boolean f(int i) {
        ListView listView = this.f113a;
        int count = listView.getCount();
        if (count == 0) {
            return false;
        }
        int childCount = listView.getChildCount();
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        int i2 = firstVisiblePosition + childCount;
        if (i > 0) {
            if (i2 >= count && listView.getChildAt(childCount - 1).getBottom() <= listView.getHeight()) {
                return false;
            }
        } else {
            if (i >= 0) {
                return false;
            }
            if (firstVisiblePosition <= 0 && listView.getChildAt(0).getTop() >= 0) {
                return false;
            }
        }
        return true;
    }
}
