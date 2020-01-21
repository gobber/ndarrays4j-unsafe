package ndarrays4j.arrays.integer;

import ndarrays4j.arrays.AbstractNdArray;
import ndarrays4j.dtype.integer.ByteUnsafe;

public class NdUnsignedByteArray extends AbstractNdArray<ByteUnsafe>{
	
	public NdUnsignedByteArray(int[] shape, int[] strides, int order, ByteUnsafe vector) {
		this.shape   = shape;
		this.order   = order;
		this.strides = strides;
		this.dtype   = U_BYTE;
		this.vector  = vector;
	}
	
	public NdUnsignedByteArray(long address, int[] shape, int[] strides, int order) {
		this.shape   = shape;
		this.order   = order;
		this.strides = strides;
		this.dtype   = U_BYTE;
		this.vector  = new ByteUnsafe();
		this.vector.address(address);
		this.vector.size(size());
	}
	
	public NdUnsignedByteArray(int[] shape, int order) {
		this(shape, strides(shape, order), order, new ByteUnsafe(size(shape)));
	}
	
	public NdUnsignedByteArray(int[] shape, int[] strides, ByteUnsafe vector) {
		this(shape, strides, ORDER_C, vector);
	}
	
	public NdUnsignedByteArray(int[] shape, ByteUnsafe vector) {
		this(shape, strides(shape, ORDER_C), ORDER_C, vector);
	}
	
	public NdUnsignedByteArray(int[] shape) {
		this(shape, new ByteUnsafe(size(shape)));
	}
	
	public NdUnsignedByteArray(long address, int[] shape, int order) {		
		this(address, shape, strides(shape, order), order);
	}
	
	public NdUnsignedByteArray(long address, int[] shape) {
		this(address, shape, ORDER_C);
	}	
	
	public NdUnsignedByteArray(long address, int[] shape, int[] strides) {
		this(address, shape, strides, ORDER_C);
	}
	
	public static byte toByte(int value) {
		return (byte) (value & 0xff);
	}
	
	public static int toInt(byte value) {
		return value & 0xff;
	}
	
	public int get(int i) {
		return toInt(vector.get(i));
	}	
	
	public int get(int ... indexes) {
		return toInt(vector.get(offset(indexes)));
	}
	
	public void set(int value, int i) {
		vector.set(i, toByte(value));
	}

	public void set(int value, int ... indexes) {
		vector.set(offset(indexes), toByte(value));
	}

	@Override
	public NdUnsignedByteArray duplicate() {
		NdUnsignedByteArray copy = new NdUnsignedByteArray(shape(), strides(), order(), vector.duplicate());			
		return copy;
	}

}
