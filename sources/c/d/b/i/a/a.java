package c.d.b.i.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.google.protos.datapol.SemanticAnnotations;
import com.nexstreaming.app.general.task.ResultTask;

/* compiled from: AbstractBuiltinTemplate.java */
/* loaded from: classes.dex */
public abstract class a implements c.d.b.i.a {

    /* renamed from: a */
    final String f3807a;

    /* renamed from: b */
    final int f3808b;

    /* renamed from: c */
    final int f3809c;

    /* renamed from: d */
    final int[] f3810d;

    /* renamed from: e */
    final int f3811e = SemanticAnnotations.SemanticType.ST_THIRD_PARTY_DATA_VALUE;

    public a(String str, int i, int i2, int... iArr) {
        this.f3807a = str;
        this.f3808b = i;
        this.f3809c = i2;
        this.f3810d = iArr;
    }

    @Override // c.d.b.i.a
    public ResultTask<Bitmap> a(Context context) {
        Drawable drawable = context.getResources().getDrawable(this.f3809c);
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        return ResultTask.completedResultTask(createBitmap);
    }

    @Override // c.d.b.i.a
    public String b() {
        return null;
    }

    @Override // c.d.b.i.a
    public String getId() {
        return this.f3807a;
    }

    @Override // c.d.b.i.a
    public String getName(Context context) {
        return context.getString(this.f3808b);
    }

    @Override // c.d.b.i.a
    public int a() {
        return this.f3810d.length;
    }
}
