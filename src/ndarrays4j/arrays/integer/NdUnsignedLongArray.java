package ndarrays4j.arrays.integer;

import java.math.BigInteger;

import ndarrays4j.arrays.AbstractNdArray;
import ndarrays4j.dtype.integer.LongUnsafe;

public class NdUnsignedLongArray extends AbstractNdArray<LongUnsafe>{	

	public NdUnsignedLongArray(int[] shape, int[] strides, int order, LongUnsafe vector) {
		this.shape   = shape;
		this.order   = order;
		this.strides = strides;
		this.dtype   = U_LONG;
		this.vector  = vector;
	}
	
	public NdUnsignedLongArray(long address, int[] shape, int[] strides, int order) {
		this.shape   = shape;
		this.order   = order;
		this.strides = strides;
		this.dtype   = U_LONG;
		this.vector  = new LongUnsafe();
		this.vector.address(address);
		this.vector.size(size());
	}
	
	public NdUnsignedLongArray(int[] shape, int order) {
		this(shape, strides(shape, order), order, new LongUnsafe(size(shape)));
	}
	
	public NdUnsignedLongArray(int[] shape, int[] strides, LongUnsafe vector) {
		this(shape, strides, ORDER_C, vector);
	}
	
	public NdUnsignedLongArray(int[] shape, LongUnsafe vector) {
		this(shape, strides(shape, ORDER_C), ORDER_C, vector);
	}
	
	public NdUnsignedLongArray(int[] shape) {
		this(shape, new LongUnsafe(size(shape)));
	}
	
	public NdUnsignedLongArray(long address, int[] shape, int order) {		
		this(address, shape, strides(shape, order), order);
	}
	
	public NdUnsignedLongArray(long address, int[] shape) {
		this(address, shape, ORDER_C);
	}	
	
	public NdUnsignedLongArray(long address, int[] shape, int[] strides) {
		this(address, shape, strides, ORDER_C);
	}
	
	public long get(int i) {		
		//final BigInteger mask = new BigInteger( "FFFFFFFFFFFFFFFF", 16 );
		//return BigInteger.valueOf( vector.get(i) ).and( mask );		
		return vector.get(i);
	}	
	
	public long get(int ... indexes) {
		//final BigInteger mask = new BigInteger( "FFFFFFFFFFFFFFFF", 16 );
		//return BigInteger.valueOf( vector.get(offset(indexes)) ).and( mask );
		return vector.get(offset(indexes));
	}

	public void set(BigInteger value, int i) {
		vector.set(i, value.longValue());
	}
	
	public void set(BigInteger value, int ... indexes) {
		vector.set(offset(indexes), value.longValue());
	}

	@Override
	public NdUnsignedLongArray duplicate() {
		NdUnsignedLongArray copy = new NdUnsignedLongArray(shape(), strides(), order(), vector.duplicate());			
		return copy;
	}
	
}
