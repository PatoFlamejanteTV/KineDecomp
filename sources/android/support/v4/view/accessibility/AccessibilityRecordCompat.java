package android.support.v4.view.accessibility;

import android.os.Build;
import android.os.Parcelable;
import android.view.View;
import android.view.accessibility.AccessibilityRecord;
import java.util.List;

/* loaded from: classes.dex */
public class AccessibilityRecordCompat {

    /* renamed from: a */
    private final AccessibilityRecord f1888a;

    @Deprecated
    public AccessibilityRecordCompat(Object obj) {
        this.f1888a = (AccessibilityRecord) obj;
    }

    @Deprecated
    public static AccessibilityRecordCompat obtain(AccessibilityRecordCompat accessibilityRecordCompat) {
        return new AccessibilityRecordCompat(AccessibilityRecord.obtain(accessibilityRecordCompat.f1888a));
    }

    @Deprecated
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AccessibilityRecordCompat.class != obj.getClass()) {
            return false;
        }
        AccessibilityRecordCompat accessibilityRecordCompat = (AccessibilityRecordCompat) obj;
        AccessibilityRecord accessibilityRecord = this.f1888a;
        if (accessibilityRecord == null) {
            if (accessibilityRecordCompat.f1888a != null) {
                return false;
            }
        } else if (!accessibilityRecord.equals(accessibilityRecordCompat.f1888a)) {
            return false;
        }
        return true;
    }

    @Deprecated
    public int getAddedCount() {
        return this.f1888a.getAddedCount();
    }

    @Deprecated
    public CharSequence getBeforeText() {
        return this.f1888a.getBeforeText();
    }

    @Deprecated
    public CharSequence getClassName() {
        return this.f1888a.getClassName();
    }

    @Deprecated
    public CharSequence getContentDescription() {
        return this.f1888a.getContentDescription();
    }

    @Deprecated
    public int getCurrentItemIndex() {
        return this.f1888a.getCurrentItemIndex();
    }

    @Deprecated
    public int getFromIndex() {
        return this.f1888a.getFromIndex();
    }

    @Deprecated
    public Object getImpl() {
        return this.f1888a;
    }

    @Deprecated
    public int getItemCount() {
        return this.f1888a.getItemCount();
    }

    @Deprecated
    public int getMaxScrollX() {
        return getMaxScrollX(this.f1888a);
    }

    @Deprecated
    public int getMaxScrollY() {
        return getMaxScrollY(this.f1888a);
    }

    @Deprecated
    public Parcelable getParcelableData() {
        return this.f1888a.getParcelableData();
    }

    @Deprecated
    public int getRemovedCount() {
        return this.f1888a.getRemovedCount();
    }

    @Deprecated
    public int getScrollX() {
        return this.f1888a.getScrollX();
    }

    @Deprecated
    public int getScrollY() {
        return this.f1888a.getScrollY();
    }

    @Deprecated
    public AccessibilityNodeInfoCompat getSource() {
        return AccessibilityNodeInfoCompat.a(this.f1888a.getSource());
    }

    @Deprecated
    public List<CharSequence> getText() {
        return this.f1888a.getText();
    }

    @Deprecated
    public int getToIndex() {
        return this.f1888a.getToIndex();
    }

    @Deprecated
    public int getWindowId() {
        return this.f1888a.getWindowId();
    }

    @Deprecated
    public int hashCode() {
        AccessibilityRecord accessibilityRecord = this.f1888a;
        if (accessibilityRecord == null) {
            return 0;
        }
        return accessibilityRecord.hashCode();
    }

    @Deprecated
    public boolean isChecked() {
        return this.f1888a.isChecked();
    }

    @Deprecated
    public boolean isEnabled() {
        return this.f1888a.isEnabled();
    }

    @Deprecated
    public boolean isFullScreen() {
        return this.f1888a.isFullScreen();
    }

    @Deprecated
    public boolean isPassword() {
        return this.f1888a.isPassword();
    }

    @Deprecated
    public boolean isScrollable() {
        return this.f1888a.isScrollable();
    }

    @Deprecated
    public void recycle() {
        this.f1888a.recycle();
    }

    @Deprecated
    public void setAddedCount(int i) {
        this.f1888a.setAddedCount(i);
    }

    @Deprecated
    public void setBeforeText(CharSequence charSequence) {
        this.f1888a.setBeforeText(charSequence);
    }

    @Deprecated
    public void setChecked(boolean z) {
        this.f1888a.setChecked(z);
    }

    @Deprecated
    public void setClassName(CharSequence charSequence) {
        this.f1888a.setClassName(charSequence);
    }

    @Deprecated
    public void setContentDescription(CharSequence charSequence) {
        this.f1888a.setContentDescription(charSequence);
    }

    @Deprecated
    public void setCurrentItemIndex(int i) {
        this.f1888a.setCurrentItemIndex(i);
    }

    @Deprecated
    public void setEnabled(boolean z) {
        this.f1888a.setEnabled(z);
    }

    @Deprecated
    public void setFromIndex(int i) {
        this.f1888a.setFromIndex(i);
    }

    @Deprecated
    public void setFullScreen(boolean z) {
        this.f1888a.setFullScreen(z);
    }

    @Deprecated
    public void setItemCount(int i) {
        this.f1888a.setItemCount(i);
    }

    @Deprecated
    public void setMaxScrollX(int i) {
        setMaxScrollX(this.f1888a, i);
    }

    @Deprecated
    public void setMaxScrollY(int i) {
        setMaxScrollY(this.f1888a, i);
    }

    @Deprecated
    public void setParcelableData(Parcelable parcelable) {
        this.f1888a.setParcelableData(parcelable);
    }

    @Deprecated
    public void setPassword(boolean z) {
        this.f1888a.setPassword(z);
    }

    @Deprecated
    public void setRemovedCount(int i) {
        this.f1888a.setRemovedCount(i);
    }

    @Deprecated
    public void setScrollX(int i) {
        this.f1888a.setScrollX(i);
    }

    @Deprecated
    public void setScrollY(int i) {
        this.f1888a.setScrollY(i);
    }

    @Deprecated
    public void setScrollable(boolean z) {
        this.f1888a.setScrollable(z);
    }

    @Deprecated
    public void setSource(View view) {
        this.f1888a.setSource(view);
    }

    @Deprecated
    public void setToIndex(int i) {
        this.f1888a.setToIndex(i);
    }

    public static int getMaxScrollX(AccessibilityRecord accessibilityRecord) {
        if (Build.VERSION.SDK_INT >= 15) {
            return accessibilityRecord.getMaxScrollX();
        }
        return 0;
    }

    public static int getMaxScrollY(AccessibilityRecord accessibilityRecord) {
        if (Build.VERSION.SDK_INT >= 15) {
            return accessibilityRecord.getMaxScrollY();
        }
        return 0;
    }

    @Deprecated
    public static AccessibilityRecordCompat obtain() {
        return new AccessibilityRecordCompat(AccessibilityRecord.obtain());
    }

    public static void setMaxScrollX(AccessibilityRecord accessibilityRecord, int i) {
        if (Build.VERSION.SDK_INT >= 15) {
            accessibilityRecord.setMaxScrollX(i);
        }
    }

    public static void setMaxScrollY(AccessibilityRecord accessibilityRecord, int i) {
        if (Build.VERSION.SDK_INT >= 15) {
            accessibilityRecord.setMaxScrollY(i);
        }
    }

    @Deprecated
    public void setSource(View view, int i) {
        setSource(this.f1888a, view, i);
    }

    public static void setSource(AccessibilityRecord accessibilityRecord, View view, int i) {
        if (Build.VERSION.SDK_INT >= 16) {
            accessibilityRecord.setSource(view, i);
        }
    }
}
