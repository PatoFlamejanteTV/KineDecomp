package com.nexstreaming.app.general.expression;

import com.facebook.internal.ServerProtocol;
import com.nexstreaming.app.general.expression.af;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class Expression {
    private final List<g> b;
    private final f c;
    private j<?> d;
    private boolean e = false;
    private ae f = null;
    private ad g = null;

    /* renamed from: a, reason: collision with root package name */
    private static af<g, f> f3126a = null;
    private static final b h = new b(true);
    private static final b i = new b(false);
    private static final a j = new y();
    private static final s k = new z();
    private static final s l = new aa();
    private static final a m = new ab();
    private static final s n = new ac();
    private static final a o = new com.nexstreaming.app.general.expression.c();
    private static final a p = new com.nexstreaming.app.general.expression.d();
    private static final a q = new com.nexstreaming.app.general.expression.e();
    private static final a r = new com.nexstreaming.app.general.expression.f();
    private static final a s = new com.nexstreaming.app.general.expression.g();
    private static final a t = new com.nexstreaming.app.general.expression.h();
    private static final a u = new com.nexstreaming.app.general.expression.i();
    private static final a v = new com.nexstreaming.app.general.expression.j();
    private static final a w = new com.nexstreaming.app.general.expression.k();
    private static final a x = new com.nexstreaming.app.general.expression.l();
    private static final a y = new com.nexstreaming.app.general.expression.n();
    private static final a z = new com.nexstreaming.app.general.expression.o();
    private static final a A = new com.nexstreaming.app.general.expression.p();
    private static final a B = new com.nexstreaming.app.general.expression.q();
    private static final s C = new com.nexstreaming.app.general.expression.r();
    private static final a D = new com.nexstreaming.app.general.expression.s();
    private static final a E = new t();
    private static final a F = new u();
    private static final d G = new v();
    private static final k H = new k(k, j);
    private static final k I = new k(n, m);
    private static final p J = new m('(', ')');
    private static final p K = new c('(', ')');

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum Assoc {
        LEFT,
        RIGHT
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Failed to check method usage
    java.lang.NullPointerException: Cannot invoke "jadx.core.dex.nodes.MethodNode.getTopParentClass()" because "m" is null
    	at jadx.core.codegen.ClassGen.lambda$skipMethod$4(ClassGen.java:360)
    	at java.base/java.util.stream.ReferencePipeline$2$1.accept(Unknown Source)
    	at java.base/java.util.ArrayList$ArrayListSpliterator.forEachRemaining(Unknown Source)
    	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
    	at java.base/java.util.stream.ReduceOps$ReduceOp.evaluateSequential(Unknown Source)
    	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
    	at java.base/java.util.stream.ReferencePipeline.collect(Unknown Source)
    	at jadx.core.codegen.ClassGen.skipMethod(ClassGen.java:361)
    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:327)
    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
    	at java.base/java.util.ArrayList.forEach(Unknown Source)
    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
    	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
     */
    public static /* synthetic */ b c() {
        return h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Failed to check method usage
    java.lang.NullPointerException: Cannot invoke "jadx.core.dex.nodes.MethodNode.getTopParentClass()" because "m" is null
    	at jadx.core.codegen.ClassGen.lambda$skipMethod$4(ClassGen.java:360)
    	at java.base/java.util.stream.ReferencePipeline$2$1.accept(Unknown Source)
    	at java.base/java.util.ArrayList$ArrayListSpliterator.forEachRemaining(Unknown Source)
    	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
    	at java.base/java.util.stream.ReduceOps$ReduceOp.evaluateSequential(Unknown Source)
    	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
    	at java.base/java.util.stream.ReferencePipeline.collect(Unknown Source)
    	at jadx.core.codegen.ClassGen.skipMethod(ClassGen.java:361)
    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:327)
    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
    	at java.base/java.util.ArrayList.forEach(Unknown Source)
    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
    	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
     */
    public static /* synthetic */ b d() {
        return i;
    }

    private static void e() {
        if (f3126a == null) {
            f3126a = new af<>();
            f3126a.a(af.f, f3126a.f3135a);
            f3126a.a(new af.d(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE), new l(h));
            f3126a.a(new af.d("false"), new l(i));
            f3126a.a(new af.d("and"), new l(x));
            f3126a.a(new af.d("or"), new l(y));
            f3126a.a(new af.c("!="), new l(w));
            f3126a.a(new af.c("=="), new l(v));
            f3126a.a(new af.c("<="), new l(t));
            f3126a.a(new af.c(">="), new l(u));
            f3126a.a(new af.c("&&"), new l(x));
            f3126a.a(new af.c("||"), new l(y));
            f3126a.a(new af.c("<<"), new l(B));
            f3126a.a(new af.c(">>>"), new l(z));
            f3126a.a(new af.c(">>"), new l(A));
            f3126a.a(new af.a('&'), new l(F));
            f3126a.a(new af.a('|'), new l(D));
            f3126a.a(new af.a('^'), new l(E));
            f3126a.a(new af.a('+'), new l(H));
            f3126a.a(new af.a('~'), new l(C));
            f3126a.a(new af.a('-'), new l(I));
            f3126a.a(new af.a('*'), new l(o));
            f3126a.a(new af.a('/'), new l(p));
            f3126a.a(new af.a('%'), new l(q));
            f3126a.a(new af.a('<'), new l(r));
            f3126a.a(new af.a('>'), new l(s));
            f3126a.a(new af.a(','), new l(G));
            f3126a.a(new af.a('!'), new l(l));
            f3126a.a(new af.a('('), new l(J));
            f3126a.a(new af.a(')'), new l(K));
            f3126a.a(new af.b('\"', '\\'), new com.nexstreaming.app.general.expression.b());
            f3126a.a(af.e, new com.nexstreaming.app.general.expression.m());
            f3126a.a(af.b, new w());
            f3126a.a(af.d, new x());
        }
    }

    public Expression(String str) throws ExpressionParseException {
        g gVar;
        e();
        f fVar = new f(null);
        try {
            List<g> a2 = f3126a.a(str, (String) fVar);
            ArrayList arrayList = new ArrayList(a2.size());
            ArrayDeque arrayDeque = new ArrayDeque(a2.size());
            for (int i2 = 0; i2 < a2.size() - 1; i2++) {
                g gVar2 = a2.get(i2);
                g gVar3 = a2.get(i2 + 1);
                if ((gVar2 instanceof r) && gVar3 == J) {
                    a2.set(i2, new h(((r) gVar2).f3134a));
                }
            }
            g gVar4 = null;
            for (g gVar5 : a2) {
                if (!(gVar5 instanceof k)) {
                    gVar = gVar5;
                } else if (gVar4 != null && ((gVar4 instanceof c) || (gVar4 instanceof n))) {
                    gVar = ((k) gVar5).d();
                } else {
                    gVar = ((k) gVar5).c();
                }
                if (gVar instanceof n) {
                    arrayList.add(gVar);
                } else if (gVar instanceof h) {
                    arrayDeque.push(gVar);
                } else if (gVar instanceof d) {
                    while (arrayDeque.size() > 0 && !(arrayDeque.peek() instanceof m)) {
                        arrayList.add(arrayDeque.pop());
                    }
                    if (arrayDeque.size() < 1 || !(arrayDeque.peek() instanceof m)) {
                        throw new ExpressionParseException("Unbalanced parenthesis");
                    }
                    ((m) arrayDeque.peek()).f3132a++;
                } else if (gVar instanceof o) {
                    o oVar = (o) gVar;
                    while (arrayDeque.peek() instanceof o) {
                        o oVar2 = (o) arrayDeque.peek();
                        if (!(oVar.a() == Assoc.LEFT && oVar.b().level == oVar2.b().level) && oVar.b().level >= oVar2.b().level) {
                            break;
                        } else {
                            arrayList.add(arrayDeque.pop());
                        }
                    }
                    arrayDeque.push(oVar);
                } else if (gVar instanceof m) {
                    arrayDeque.push(gVar);
                } else if (gVar instanceof c) {
                    int i3 = gVar4 instanceof m ? 0 : 1;
                    c cVar = (c) gVar;
                    while (arrayDeque.size() > 0 && !(arrayDeque.peek() instanceof m)) {
                        arrayList.add(arrayDeque.pop());
                    }
                    if (arrayDeque.size() < 1 || !(arrayDeque.peek() instanceof m)) {
                        throw new ExpressionParseException("Unbalanced parenthesis");
                    }
                    m mVar = (m) arrayDeque.pop();
                    if (!mVar.a(cVar)) {
                        throw new ExpressionParseException("Mismatched parenthesis");
                    }
                    if (arrayDeque.peek() instanceof h) {
                        ((h) arrayDeque.peek()).f3128a = mVar.f3132a + i3;
                    }
                    if (arrayDeque.peek() instanceof s) {
                        arrayList.add(arrayDeque.pop());
                    }
                } else {
                    throw new ExpressionParseException("Bad state : " + gVar.toString());
                }
                gVar4 = gVar;
            }
            while (arrayDeque.size() > 0) {
                g gVar6 = (g) arrayDeque.pop();
                if (gVar6 instanceof p) {
                    throw new ExpressionParseException("Mismatched parenthesis");
                }
                arrayList.add(gVar6);
            }
            this.b = Collections.unmodifiableList(arrayList);
            this.c = fVar;
        } catch (TokenNotMatchedException e2) {
            throw new ExpressionParseException("Unexpected character encountered", e2);
        }
    }

    public void a(ae aeVar) {
        this.f = aeVar;
    }

    public void a() throws ExpressionEvalException {
        if (this.g == null) {
            this.g = new com.nexstreaming.app.general.expression.a();
        }
        this.d = null;
        if (this.f != null) {
            for (Map.Entry<String, r> entry : this.c.f3127a.entrySet()) {
                entry.getValue().b = b(this.f.a(entry.getKey()));
            }
        }
        ArrayDeque arrayDeque = new ArrayDeque(32);
        for (g gVar : this.b) {
            gVar.a(arrayDeque, this.g);
            if (this.e) {
                System.out.println("-> " + gVar + "  :  " + arrayDeque);
            }
        }
        if (arrayDeque.size() != 1) {
            throw new ExpressionEvalException("Malformed expression");
        }
        this.d = (j) arrayDeque.pop();
    }

    public boolean b() {
        try {
            return this.d.a();
        } catch (ExpressionEvalException e2) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static abstract class g {
        public abstract void a(Deque<j<?>> deque, ad adVar) throws ExpressionEvalException;

        private g() {
        }

        /* synthetic */ g(com.nexstreaming.app.general.expression.b bVar) {
            this();
        }
    }

    /* loaded from: classes.dex */
    private static abstract class n extends g {
        private n() {
            super(null);
        }

        /* synthetic */ n(com.nexstreaming.app.general.expression.b bVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static j<?> b(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Integer) {
            return new i(((Integer) obj).intValue());
        }
        if (obj instanceof Short) {
            return new i(((Short) obj).shortValue());
        }
        if (obj instanceof Character) {
            return new i(((Character) obj).charValue());
        }
        if (obj instanceof Double) {
            return new e(((Double) obj).doubleValue());
        }
        if (obj instanceof String) {
            return new q((String) obj);
        }
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue() ? h : i;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static abstract class j<T> extends n {

        /* renamed from: a, reason: collision with root package name */
        protected T f3129a;

        private j() {
            super(null);
        }

        /* synthetic */ j(com.nexstreaming.app.general.expression.b bVar) {
            this();
        }

        @Override // com.nexstreaming.app.general.expression.Expression.g
        public void a(Deque<j<?>> deque, ad adVar) throws ExpressionEvalException {
            deque.push(this);
        }

        public j<?> a(j<?> jVar) throws ExpressionEvalException {
            throw new ExpressionEvalException("Operation not supported for this type");
        }

        public j<?> d(j<?> jVar) throws ExpressionEvalException {
            throw new ExpressionEvalException("Operation not supported for this type");
        }

        public j<?> e() throws ExpressionEvalException {
            throw new ExpressionEvalException("Operation not supported for this type");
        }

        public j<?> f() throws ExpressionEvalException {
            throw new ExpressionEvalException("Operation not supported for this type");
        }

        public j<?> d() throws ExpressionEvalException {
            throw new ExpressionEvalException("Operation not supported for this type");
        }

        public j<?> e(j<?> jVar) throws ExpressionEvalException {
            throw new ExpressionEvalException("Operation not supported for this type");
        }

        public j<?> f(j<?> jVar) throws ExpressionEvalException {
            throw new ExpressionEvalException("Operation not supported for this type");
        }

        public j<?> g(j<?> jVar) throws ExpressionEvalException {
            throw new ExpressionEvalException("Operation not supported for this type");
        }

        public int h(j<?> jVar) throws ExpressionEvalException {
            throw new ExpressionEvalException("Operation not supported for this type");
        }

        public j<?> b(j<?> jVar) throws ExpressionEvalException {
            throw new ExpressionEvalException("Operation not supported for this type");
        }

        public j<?> c(j<?> jVar) throws ExpressionEvalException {
            throw new ExpressionEvalException("Operation not supported for this type");
        }

        public int b() throws ExpressionEvalException {
            throw new ExpressionEvalException("Operation not supported for this type");
        }

        public boolean a() throws ExpressionEvalException {
            throw new ExpressionEvalException("Operation not supported for this type");
        }

        public String c() throws ExpressionEvalException {
            return this.f3129a.toString();
        }

        public String toString() {
            return this.f3129a.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class q extends j<String> {
        /* JADX WARN: Multi-variable type inference failed */
        public q(String str) {
            super(null);
            this.f3129a = str;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.nexstreaming.app.general.expression.Expression.j
        public j<?> a(j<?> jVar) throws ExpressionEvalException {
            return new q(((String) this.f3129a) + jVar.c());
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.nexstreaming.app.general.expression.Expression.j
        public String c() throws ExpressionEvalException {
            return (String) this.f3129a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class i extends j<Integer> {
        /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Integer] */
        public i(int i) {
            super(null);
            this.f3129a = Integer.valueOf(i);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.nexstreaming.app.general.expression.Expression.j
        public j<?> a(j<?> jVar) throws ExpressionEvalException {
            if (jVar instanceof i) {
                return new i(((Integer) this.f3129a).intValue() + ((Integer) ((i) jVar).f3129a).intValue());
            }
            if (jVar instanceof e) {
                return new e(((Double) ((e) jVar).f3129a).doubleValue() + ((Integer) this.f3129a).intValue());
            }
            if (jVar instanceof q) {
                return new q(this.f3129a + ((String) ((q) jVar).f3129a));
            }
            return super.a(jVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.nexstreaming.app.general.expression.Expression.j
        public j<?> d(j<?> jVar) throws ExpressionEvalException {
            if (jVar instanceof i) {
                return new i(((Integer) this.f3129a).intValue() - ((Integer) ((i) jVar).f3129a).intValue());
            }
            if (jVar instanceof e) {
                return new e(((Integer) this.f3129a).intValue() - ((Double) ((e) jVar).f3129a).doubleValue());
            }
            return super.d(jVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.nexstreaming.app.general.expression.Expression.j
        public j<?> e(j<?> jVar) throws ExpressionEvalException {
            if (jVar instanceof i) {
                return new i(((Integer) this.f3129a).intValue() * ((Integer) ((i) jVar).f3129a).intValue());
            }
            if (jVar instanceof e) {
                return new e(((Double) ((e) jVar).f3129a).doubleValue() * ((Integer) this.f3129a).intValue());
            }
            return super.e(jVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.nexstreaming.app.general.expression.Expression.j
        public j<?> f(j<?> jVar) throws ExpressionEvalException {
            if (jVar instanceof i) {
                return new i(((Integer) this.f3129a).intValue() / ((Integer) ((i) jVar).f3129a).intValue());
            }
            if (jVar instanceof e) {
                return new e(((Integer) this.f3129a).intValue() / ((Double) ((e) jVar).f3129a).doubleValue());
            }
            return super.f(jVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.nexstreaming.app.general.expression.Expression.j
        public j<?> g(j<?> jVar) throws ExpressionEvalException {
            if (jVar instanceof i) {
                return new i(((Integer) this.f3129a).intValue() % ((Integer) ((i) jVar).f3129a).intValue());
            }
            if (jVar instanceof e) {
                return new e(((Integer) this.f3129a).intValue() % ((Double) ((e) jVar).f3129a).doubleValue());
            }
            return super.g(jVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.nexstreaming.app.general.expression.Expression.j
        public j<?> e() throws ExpressionEvalException {
            return new i(-((Integer) this.f3129a).intValue());
        }

        @Override // com.nexstreaming.app.general.expression.Expression.j
        public j<?> f() throws ExpressionEvalException {
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.nexstreaming.app.general.expression.Expression.j
        public int h(j<?> jVar) throws ExpressionEvalException {
            if (jVar instanceof i) {
                return ((Integer) this.f3129a).compareTo((Integer) ((i) jVar).f3129a);
            }
            if (jVar instanceof e) {
                return Double.valueOf(((Integer) this.f3129a).intValue()).compareTo((Double) ((e) jVar).f3129a);
            }
            return super.h(jVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.nexstreaming.app.general.expression.Expression.j
        public int b() throws ExpressionEvalException {
            return ((Integer) this.f3129a).intValue();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.nexstreaming.app.general.expression.Expression.j
        public String c() throws ExpressionEvalException {
            return ((Integer) this.f3129a).toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b extends j<Boolean> {
        /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Boolean] */
        public b(boolean z) {
            super(null);
            this.f3129a = Boolean.valueOf(z);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.nexstreaming.app.general.expression.Expression.j
        public boolean a() throws ExpressionEvalException {
            return ((Boolean) this.f3129a).booleanValue();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.nexstreaming.app.general.expression.Expression.j
        public int b() throws ExpressionEvalException {
            return ((Boolean) this.f3129a).booleanValue() ? 1 : 0;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.nexstreaming.app.general.expression.Expression.j
        public String c() throws ExpressionEvalException {
            return ((Boolean) this.f3129a).booleanValue() ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false";
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.nexstreaming.app.general.expression.Expression.j
        public j<?> a(j<?> jVar) throws ExpressionEvalException {
            if (jVar instanceof q) {
                return new q((((Boolean) this.f3129a).booleanValue() ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false") + ((String) ((q) jVar).f3129a));
            }
            return super.a(jVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.nexstreaming.app.general.expression.Expression.j
        public j<?> b(j<?> jVar) throws ExpressionEvalException {
            if (jVar instanceof b) {
                return (((Boolean) ((b) jVar).f3129a).booleanValue() && ((Boolean) this.f3129a).booleanValue()) ? Expression.h : Expression.i;
            }
            return super.b(jVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.nexstreaming.app.general.expression.Expression.j
        public j<?> c(j<?> jVar) throws ExpressionEvalException {
            if (jVar instanceof b) {
                return (((Boolean) ((b) jVar).f3129a).booleanValue() || ((Boolean) this.f3129a).booleanValue()) ? Expression.h : Expression.i;
            }
            return super.b(jVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.nexstreaming.app.general.expression.Expression.j
        public j<?> d() throws ExpressionEvalException {
            return ((Boolean) this.f3129a).booleanValue() ? Expression.i : Expression.h;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class e extends j<Double> {
        /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Double] */
        public e(double d) {
            super(null);
            this.f3129a = Double.valueOf(d);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.nexstreaming.app.general.expression.Expression.j
        public j<?> a(j<?> jVar) throws ExpressionEvalException {
            if (jVar instanceof i) {
                return new e(((Integer) ((i) jVar).f3129a).intValue() + ((Double) this.f3129a).doubleValue());
            }
            if (jVar instanceof e) {
                return new e(((Double) ((e) jVar).f3129a).doubleValue() + ((Double) this.f3129a).doubleValue());
            }
            if (jVar instanceof q) {
                return new q(this.f3129a + ((String) ((q) jVar).f3129a));
            }
            return super.a(jVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.nexstreaming.app.general.expression.Expression.j
        public j<?> d(j<?> jVar) throws ExpressionEvalException {
            if (jVar instanceof i) {
                return new e(((Double) this.f3129a).doubleValue() - ((Integer) ((i) jVar).f3129a).intValue());
            }
            if (jVar instanceof e) {
                return new e(((Double) this.f3129a).doubleValue() - ((Double) ((e) jVar).f3129a).doubleValue());
            }
            return super.d(jVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.nexstreaming.app.general.expression.Expression.j
        public j<?> e(j<?> jVar) throws ExpressionEvalException {
            if (jVar instanceof i) {
                return new e(((Integer) ((i) jVar).f3129a).intValue() * ((Double) this.f3129a).doubleValue());
            }
            if (jVar instanceof e) {
                return new e(((Double) ((e) jVar).f3129a).doubleValue() * ((Double) this.f3129a).doubleValue());
            }
            return super.e(jVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.nexstreaming.app.general.expression.Expression.j
        public j<?> f(j<?> jVar) throws ExpressionEvalException {
            if (jVar instanceof i) {
                return new e(((Double) this.f3129a).doubleValue() / ((Integer) ((i) jVar).f3129a).intValue());
            }
            if (jVar instanceof e) {
                return new e(((Double) this.f3129a).doubleValue() / ((Double) ((e) jVar).f3129a).doubleValue());
            }
            return super.f(jVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.nexstreaming.app.general.expression.Expression.j
        public j<?> g(j<?> jVar) throws ExpressionEvalException {
            if (jVar instanceof i) {
                return new e(((Double) this.f3129a).doubleValue() % ((Integer) ((i) jVar).f3129a).intValue());
            }
            if (jVar instanceof e) {
                return new e(((Double) this.f3129a).doubleValue() % ((Double) ((e) jVar).f3129a).doubleValue());
            }
            return super.g(jVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.nexstreaming.app.general.expression.Expression.j
        public j<?> e() throws ExpressionEvalException {
            return new e(-((Double) this.f3129a).doubleValue());
        }

        @Override // com.nexstreaming.app.general.expression.Expression.j
        public j<?> f() throws ExpressionEvalException {
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.nexstreaming.app.general.expression.Expression.j
        public int h(j<?> jVar) throws ExpressionEvalException {
            if (jVar instanceof i) {
                return ((Double) this.f3129a).compareTo(Double.valueOf(((Integer) ((i) jVar).f3129a).doubleValue()));
            }
            if (jVar instanceof e) {
                return ((Double) this.f3129a).compareTo((Double) ((e) jVar).f3129a);
            }
            return super.h(jVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.nexstreaming.app.general.expression.Expression.j
        public int b() throws ExpressionEvalException {
            return ((Double) this.f3129a).intValue();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.nexstreaming.app.general.expression.Expression.j
        public String c() throws ExpressionEvalException {
            return ((Double) this.f3129a).toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class r extends n {

        /* renamed from: a, reason: collision with root package name */
        public final String f3134a;
        public j<?> b;

        @Override // com.nexstreaming.app.general.expression.Expression.g
        public void a(Deque<j<?>> deque, ad adVar) throws ExpressionEvalException {
            if (this.b == null) {
                throw new ExpressionEvalException("Undefined symbol: " + this.f3134a);
            }
            deque.push(this.b);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public r(String str) {
            super(null);
            this.f3134a = str;
        }

        public String toString() {
            return this.f3134a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class l implements af.e<g, f> {

        /* renamed from: a, reason: collision with root package name */
        private final g f3131a;

        public l(g gVar) {
            this.f3131a = gVar;
        }

        @Override // com.nexstreaming.app.general.expression.af.e
        public g a(String str, f fVar) {
            return this.f3131a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static abstract class d extends g {
        private d() {
            super(null);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ d(com.nexstreaming.app.general.expression.b bVar) {
            this();
        }
    }

    /* loaded from: classes.dex */
    private static abstract class o extends g {
        public abstract Assoc a();

        public abstract Precd b();

        private o() {
            super(null);
        }

        /* synthetic */ o(com.nexstreaming.app.general.expression.b bVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static abstract class s extends o {
        private s() {
            super(null);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ s(com.nexstreaming.app.general.expression.b bVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum Precd {
        UNARYFUNC(14),
        UNARYNEG(13),
        EXPONENT(12),
        MULTIPLICATIVE(11),
        ADDITIVE(10),
        SHIFT(9),
        BITWISE(8),
        RELATIONAL(7),
        EQUALITY(6),
        UNARYNOT(5),
        LOGICAL_AND(4),
        LOGICAL_OR(3);

        public final int level;

        Precd(int i) {
            this.level = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static abstract class a extends o {
        private a() {
            super(null);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ a(com.nexstreaming.app.general.expression.b bVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static abstract class p extends g {

        /* renamed from: a, reason: collision with root package name */
        private final char f3133a;
        private final char b;
        private final boolean c;

        protected p(char c, char c2, boolean z) {
            super(null);
            this.f3133a = c;
            this.b = c2;
            this.c = z;
        }

        public char a() {
            return this.c ? this.f3133a : this.b;
        }

        public char b() {
            return this.c ? this.b : this.f3133a;
        }

        public boolean a(p pVar) {
            return pVar != null && pVar.a() == b();
        }

        @Override // com.nexstreaming.app.general.expression.Expression.g
        public void a(Deque<j<?>> deque, ad adVar) throws ExpressionEvalException {
            throw new RuntimeException("Bad state : attempt to execute paren.");
        }
    }

    /* loaded from: classes.dex */
    private static class m extends p {

        /* renamed from: a, reason: collision with root package name */
        public int f3132a;

        protected m(char c, char c2) {
            super(c, c2, true);
        }
    }

    /* loaded from: classes.dex */
    private static class c extends p {
        protected c(char c, char c2) {
            super(c, c2, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class k extends o {

        /* renamed from: a, reason: collision with root package name */
        private final s f3130a;
        private final a b;

        @Override // com.nexstreaming.app.general.expression.Expression.o
        public Assoc a() {
            throw new IllegalStateException();
        }

        @Override // com.nexstreaming.app.general.expression.Expression.o
        public Precd b() {
            throw new IllegalStateException();
        }

        k(s sVar, a aVar) {
            super(null);
            this.f3130a = sVar;
            this.b = aVar;
        }

        public s c() {
            return this.f3130a;
        }

        public a d() {
            return this.b;
        }

        @Override // com.nexstreaming.app.general.expression.Expression.g
        public void a(Deque<j<?>> deque, ad adVar) throws ExpressionEvalException {
            throw new RuntimeException("Bad state : attempt to execute multi-op (should have been resolved first).");
        }
    }

    /* loaded from: classes.dex */
    private static class h extends s {

        /* renamed from: a, reason: collision with root package name */
        public int f3128a;
        public final String b;

        h(String str) {
            super(null);
            this.f3128a = 0;
            this.b = str;
        }

        @Override // com.nexstreaming.app.general.expression.Expression.o
        public Assoc a() {
            return Assoc.RIGHT;
        }

        @Override // com.nexstreaming.app.general.expression.Expression.o
        public Precd b() {
            return Precd.UNARYFUNC;
        }

        @Override // com.nexstreaming.app.general.expression.Expression.g
        public void a(Deque<j<?>> deque, ad adVar) throws ExpressionEvalException {
            if (adVar == null) {
                throw new ExpressionEvalException("Undefined function: " + this.b);
            }
            Object[] objArr = new Object[this.f3128a];
            for (int i = this.f3128a - 1; i >= 0; i--) {
                objArr[i] = deque.pop().f3129a;
            }
            j<?> b = Expression.b(adVar.a(this.b, objArr));
            if (b == null) {
                throw new ExpressionEvalException("Undefined or broken function: " + this.b);
            }
            deque.push(b);
        }

        public String toString() {
            return this.b + "(" + this.f3128a + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        public Map<String, r> f3127a;

        private f() {
            this.f3127a = new HashMap();
        }

        /* synthetic */ f(com.nexstreaming.app.general.expression.b bVar) {
            this();
        }
    }
}
