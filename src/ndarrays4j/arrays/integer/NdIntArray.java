package ndarrays4j.arrays.integer;

import ndarrays4j.arrays.AbstractNdArray;
import ndarrays4j.dtype.integer.IntUnsafe;

public class NdIntArray extends AbstractNdArray<IntUnsafe>{	

	public NdIntArray(int[] shape, int[] strides, int order, IntUnsafe vector) {
		this.shape   = shape;
		this.order   = order;
		this.strides = strides;
		this.dtype   = INT;
		this.vector  = vector;
	}
	
	public NdIntArray(long address, int[] shape, int[] strides, int order) {
		this.shape   = shape;
		this.order   = order;
		this.strides = strides;
		this.dtype   = INT;
		this.vector  = new IntUnsafe();
		this.vector.address(address);
		this.vector.size(size());
	}
	
	public NdIntArray(int[] shape, int order) {
		this(shape, strides(shape, order), order, new IntUnsafe(size(shape)));
	}
	
	public NdIntArray(int[] shape, int[] strides, IntUnsafe vector) {
		this(shape, strides, ORDER_C, vector);
	}
	
	public NdIntArray(int[] shape, IntUnsafe vector) {
		this(shape, strides(shape, ORDER_C), ORDER_C, vector);
	}
	
	public NdIntArray(int[] shape) {
		this(shape, new IntUnsafe(size(shape)));
	}
	
	public NdIntArray(long address, int[] shape, int order) {		
		this(address, shape, strides(shape, order), order);
	}
	
	public NdIntArray(long address, int[] shape) {
		this(address, shape, ORDER_C);
	}	
	
	public NdIntArray(long address, int[] shape, int[] strides) {
		this(address, shape, strides, ORDER_C);
	}
	
	public int get(int i) {
		return vector.get(i);
	}	
	
	public int get(int ... indexes) {
		return vector.get(offset(indexes));
	}

	public void set(int value, int ... indexes) {
		vector.set(offset(indexes), value);
	}

	@Override
	public NdIntArray duplicate() {
		NdIntArray copy = new NdIntArray(shape(), strides(), order(), vector.duplicate());			
		return copy;
	}
	
}
