package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import com.nextreaming.nexeditorui.NexEditorDeviceProfile;

/* loaded from: classes.dex */
public class Space extends View {
    public Space(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        if (getVisibility() == 0) {
            setVisibility(4);
        }
    }

    public Space(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public Space(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
    }

    private static int a(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        switch (mode) {
            case NexEditorDeviceProfile.UNKNOWN /* -2147483648 */:
                return Math.min(i, size);
            case 0:
            default:
                return i;
            case 1073741824:
                return size;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(a(getSuggestedMinimumWidth(), i), a(getSuggestedMinimumHeight(), i2));
    }
}
