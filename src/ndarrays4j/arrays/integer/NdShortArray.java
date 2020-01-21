package ndarrays4j.arrays.integer;

import ndarrays4j.arrays.AbstractNdArray;
import ndarrays4j.dtype.integer.ShortUnsafe;

public class NdShortArray extends AbstractNdArray<ShortUnsafe>{
	
	public NdShortArray(int[] shape, int[] strides, int order, ShortUnsafe vector) {
		this.shape   = shape;
		this.order   = order;
		this.strides = strides;
		this.dtype   = SHORT;
		this.vector  = vector;
	}
	
	public NdShortArray(long address, int[] shape, int[] strides, int order) {
		this.shape   = shape;
		this.order   = order;
		this.strides = strides;
		this.dtype   = SHORT;
		this.vector  = new ShortUnsafe();
		this.vector.address(address);
		this.vector.size(size());
	}
	
	public NdShortArray(int[] shape, int order) {
		this(shape, strides(shape, order), order, new ShortUnsafe(size(shape)));
	}
	
	public NdShortArray(int[] shape, int[] strides, ShortUnsafe vector) {
		this(shape, strides, ORDER_C, vector);
	}
	
	public NdShortArray(int[] shape, ShortUnsafe vector) {
		this(shape, strides(shape, ORDER_C), ORDER_C, vector);
	}
	
	public NdShortArray(int[] shape) {
		this(shape, new ShortUnsafe(size(shape)));
	}
	
	public NdShortArray(long address, int[] shape, int order) {		
		this(address, shape, strides(shape, order), order);
	}
	
	public NdShortArray(long address, int[] shape) {
		this(address, shape, ORDER_C);
	}	
	
	public NdShortArray(long address, int[] shape, int[] strides) {
		this(address, shape, strides, ORDER_C);
	}	
	
	public short get(int i) {
		return vector.get(i);
	}
	
	public short get(int ... indexes) {
		return vector.get(offset(indexes));
	}

	public void set(short value, int i) {
		vector.set(i, value);
	}
	
	public void set(short value, int ... indexes) {
		vector.set(offset(indexes), value);
	}
	
	@Override
	public NdShortArray duplicate() {		
		NdShortArray copy = new NdShortArray(shape(), strides(), order(), vector.duplicate());
		return copy;
	}
	

}
