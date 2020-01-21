package ndarrays4j.arrays.integer;

import ndarrays4j.arrays.AbstractNdArray;
import ndarrays4j.dtype.integer.IntUnsafe;

public class NdUnsignedIntArray extends AbstractNdArray<IntUnsafe>{	

	public NdUnsignedIntArray(int[] shape, int[] strides, int order, IntUnsafe vector) {
		this.shape   = shape;
		this.order   = order;
		this.strides = strides;
		this.dtype   = U_INT;
		this.vector  = vector;
	}
	
	public NdUnsignedIntArray(long address, int[] shape, int[] strides, int order) {
		this.shape   = shape;
		this.order   = order;
		this.strides = strides;
		this.dtype   = U_INT;
		this.vector  = new IntUnsafe();
		this.vector.address(address);
		this.vector.size(size());
	}
	
	public NdUnsignedIntArray(int[] shape, int order) {
		this(shape, strides(shape, order), order, new IntUnsafe(size(shape)));
	}
	
	public NdUnsignedIntArray(int[] shape, int[] strides, IntUnsafe vector) {
		this(shape, strides, ORDER_C, vector);
	}
	
	public NdUnsignedIntArray(int[] shape, IntUnsafe vector) {
		this(shape, strides(shape, ORDER_C), ORDER_C, vector);
	}
	
	public NdUnsignedIntArray(int[] shape) {
		this(shape, new IntUnsafe(size(shape)));
	}
	
	public NdUnsignedIntArray(long address, int[] shape, int order) {		
		this(address, shape, strides(shape, order), order);
	}
	
	public NdUnsignedIntArray(long address, int[] shape) {
		this(address, shape, ORDER_C);
	}	
	
	public NdUnsignedIntArray(long address, int[] shape, int[] strides) {
		this(address, shape, strides, ORDER_C);
	}
	
	public static int toInt(long value) {
		return (int) (value & 0xffffffff);
	}
	
	public static long toLong(int value) {
		return value & 0xffffffffL;
	}
	
	public long get(int i) {
		return toLong(vector.get(i));
	}	
	
	public long get(int ... indexes) {
		return toLong(vector.get(offset(indexes)));
	}

	public void set(long value, int ... indexes) {
		vector.set(offset(indexes), toInt(value));
	}

	@Override
	public NdUnsignedIntArray duplicate() {
		NdUnsignedIntArray copy = new NdUnsignedIntArray(shape(), strides(), order(), vector.duplicate());			
		return copy;
	}
	
}
