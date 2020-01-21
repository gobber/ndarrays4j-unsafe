package ndarrays4j.arrays.integer;

import ndarrays4j.arrays.AbstractNdArray;
import ndarrays4j.dtype.integer.LongUnsafe;

public class NdLongArray extends AbstractNdArray<LongUnsafe>{	

	public NdLongArray(int[] shape, int[] strides, int order, LongUnsafe vector) {
		this.shape   = shape;
		this.order   = order;
		this.strides = strides;
		this.dtype   = LONG;
		this.vector  = vector;
	}
	
	public NdLongArray(long address, int[] shape, int[] strides, int order) {
		this.shape   = shape;
		this.order   = order;
		this.strides = strides;
		this.dtype   = LONG;
		this.vector  = new LongUnsafe();
		this.vector.address(address);
		this.vector.size(size());
	}
	
	public NdLongArray(int[] shape, int order) {
		this(shape, strides(shape, order), order, new LongUnsafe(size(shape)));
	}
	
	public NdLongArray(int[] shape, int[] strides, LongUnsafe vector) {
		this(shape, strides, ORDER_C, vector);
	}
	
	public NdLongArray(int[] shape, LongUnsafe vector) {
		this(shape, strides(shape, ORDER_C), ORDER_C, vector);
	}
	
	public NdLongArray(int[] shape) {
		this(shape, new LongUnsafe(size(shape)));
	}
	
	public NdLongArray(long address, int[] shape, int order) {		
		this(address, shape, strides(shape, order), order);
	}
	
	public NdLongArray(long address, int[] shape) {
		this(address, shape, ORDER_C);
	}	
	
	public NdLongArray(long address, int[] shape, int[] strides) {
		this(address, shape, strides, ORDER_C);
	}
	
	public long get(int i) {
		return vector.get(i);
	}	
	
	public long get(int ... indexes) {
		return vector.get(offset(indexes));
	}

	public void set(long value, int ... indexes) {
		vector.set(offset(indexes), value);
	}

	@Override
	public NdLongArray duplicate() {
		NdLongArray copy = new NdLongArray(shape(), strides(), order(), vector.duplicate());			
		return copy;
	}
	
}
