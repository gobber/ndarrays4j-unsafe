package ndarrays4j.arrays.integer;

import ndarrays4j.arrays.AbstractNdArray;
import ndarrays4j.dtype.integer.ByteUnsafe;

public class NdByteArray extends AbstractNdArray<ByteUnsafe>{	

	public NdByteArray(int[] shape, int[] strides, int order, ByteUnsafe vector) {
		this.shape   = shape;
		this.order   = order;
		this.strides = strides;
		this.dtype   = BYTE;
		this.vector  = vector;
	}
	
	public NdByteArray(long address, int[] shape, int[] strides, int order) {
		this.shape   = shape;
		this.order   = order;
		this.strides = strides;
		this.dtype   = BYTE;
		this.vector  = new ByteUnsafe();
		this.vector.address(address);
		this.vector.size(size());
	}
	
	public NdByteArray(int[] shape, int order) {
		this(shape, strides(shape, order), order, new ByteUnsafe(size(shape)));
	}
	
	public NdByteArray(int[] shape, int[] strides, ByteUnsafe vector) {
		this(shape, strides, ORDER_C, vector);
	}
	
	public NdByteArray(int[] shape, ByteUnsafe vector) {
		this(shape, strides(shape, ORDER_C), ORDER_C, vector);
	}
	
	public NdByteArray(int[] shape) {
		this(shape, new ByteUnsafe(size(shape)));
	}
	
	public NdByteArray(long address, int[] shape, int order) {		
		this(address, shape, strides(shape, order), order);
	}
	
	public NdByteArray(long address, int[] shape) {
		this(address, shape, ORDER_C);
	}	
	
	public NdByteArray(long address, int[] shape, int[] strides) {
		this(address, shape, strides, ORDER_C);
	}
	
	public byte get(int i) {
		return vector.get(i);
	}	
	
	public byte get(int ... indexes) {
		return vector.get(offset(indexes));
	}

	public void set(byte value, int ... indexes) {
		vector.set(offset(indexes), value);
	}

	@Override
	public NdByteArray duplicate() {
		NdByteArray copy = new NdByteArray(shape(), strides(), order(), vector.duplicate());			
		return copy;
	}
	
}
