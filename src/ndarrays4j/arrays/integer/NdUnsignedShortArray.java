package ndarrays4j.arrays.integer;

import ndarrays4j.arrays.AbstractNdArray;
import ndarrays4j.dtype.integer.ShortUnsafe;

public class NdUnsignedShortArray extends AbstractNdArray<ShortUnsafe>{
	
	public NdUnsignedShortArray(int[] shape, int[] strides, int order, ShortUnsafe vector) {
		this.shape   = shape;
		this.order   = order;
		this.strides = strides;
		this.dtype   = U_SHORT;
		this.vector  = vector;
	}
	
	public NdUnsignedShortArray(long address, int[] shape, int[] strides, int order) {
		this.shape   = shape;
		this.order   = order;
		this.strides = strides;
		this.dtype   = U_SHORT;
		this.vector  = new ShortUnsafe();
		this.vector.address(address);
		this.vector.size(size());
	}
	
	public NdUnsignedShortArray(int[] shape, int order) {
		this(shape, strides(shape, order), order, new ShortUnsafe(size(shape)));
	}
	
	public NdUnsignedShortArray(int[] shape, int[] strides, ShortUnsafe vector) {
		this(shape, strides, ORDER_C, vector);
	}
	
	public NdUnsignedShortArray(int[] shape, ShortUnsafe vector) {
		this(shape, strides(shape, ORDER_C), ORDER_C, vector);
	}
	
	public NdUnsignedShortArray(int[] shape) {
		this(shape, new ShortUnsafe(size(shape)));
	}
	
	public NdUnsignedShortArray(long address, int[] shape, int order) {		
		this(address, shape, strides(shape, order), order);
	}
	
	public NdUnsignedShortArray(long address, int[] shape) {
		this(address, shape, ORDER_C);
	}	
	
	public NdUnsignedShortArray(long address, int[] shape, int[] strides) {
		this(address, shape, strides, ORDER_C);
	}
	
	
	public static short toShort(int value) {
		return (short) (value & 0xffff);
	}
	
	public static int toInt(short value) {
		return value & 0xffff;
	}
	
	public int get(int i) {
		return toInt(vector.get(i));
	}
	
	public int get(int ... indexes) {
		return toInt(vector.get(offset(indexes)));
	}

	public void set(int value, int i) {
		vector.set(i, toShort(value));
	}
	
	public void set(int value, int ... indexes) {
		vector.set(offset(indexes), toShort(value));
	}
	
	@Override
	public NdUnsignedShortArray duplicate() {		
		NdUnsignedShortArray copy = new NdUnsignedShortArray(shape(), strides(), order(), vector.duplicate());
		return copy;
	}

}
