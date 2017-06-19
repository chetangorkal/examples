import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * http://javarevisited.blogspot.in/2014/03/difference-between-weakreference-
 * vs-softreference-phantom-strong-reference-java.html#axzz4iEm5Q19f
 * 
 * @author Chetan Gorkal
 *
 */
public class A {

	public static void main(String[] args) {
		// strong reference - regular case
		Integer myInt = new Integer(1);
		// weak reference - for class loader / metadata
		WeakReference<Integer> weakInteger = new WeakReference<Integer>(myInt);
		// now Integer object is eligible for garbage collection
		myInt = null;
		// soft reference variable has SoftReference to Counter Object created -
		// for cacheing

		// SoftReference are more suitable for caches and WeakReference are more
		// suitable for storing meta data

		SoftReference<Integer> soft = new SoftReference<Integer>(myInt);

		// reference will be stored in this queue for cleanup
		ReferenceQueue refQueue = new ReferenceQueue();
		Integer digit = new Integer(1);
		PhantomReference<Integer> phantom = new PhantomReference<Integer>(digit, refQueue);

		// digit reference variable has strong
		Integer digit1 = new Integer(1);

		// phantom reference to object
		PhantomReference<Integer> phantom1 = new PhantomReference<Integer>(digit, refQueue);

	}

}
