package ndarrays4j.arrays.real;

import ndarrays4j.arrays.AbstractNdArray;
import ndarrays4j.dtype.real.DoubleUnsafe;

public class NdDoubleArray extends AbstractNdArray<DoubleUnsafe>{
	
	public NdDoubleArray(int[] shape, int[] strides, int order, DoubleUnsafe vector) {
		this.shape   = shape;
		this.order   = order;
		this.strides = strides;
		this.dtype   = DOUBLE;
		this.vector  = vector;
	}
	
	public NdDoubleArray(long address, int[] shape, int[] strides, int order) {
		this.shape   = shape;
		this.order   = order;
		this.strides = strides;
		this.dtype   = DOUBLE;
		this.vector  = new DoubleUnsafe();
		this.vector.address(address);
		this.vector.size(size());
	}
	
	public NdDoubleArray(int[] shape, int order) {
		this(shape, strides(shape, order), order, new DoubleUnsafe(size(shape)));
	}
	
	public NdDoubleArray(int[] shape, int[] strides, DoubleUnsafe vector) {
		this(shape, strides, ORDER_C, vector);
	}
	
	public NdDoubleArray(int[] shape, DoubleUnsafe vector) {
		this(shape, strides(shape, ORDER_C), ORDER_C, vector);
	}
	
	public NdDoubleArray(int[] shape) {
		this(shape, new DoubleUnsafe(size(shape)));
	}
	
	public NdDoubleArray(long address, int[] shape, int order) {		
		this(address, shape, strides(shape, order), order);
	}
	
	public NdDoubleArray(long address, int[] shape) {
		this(address, shape, ORDER_C);
	}	
	
	public NdDoubleArray(long address, int[] shape, int[] strides) {
		this(address, shape, strides, ORDER_C);
	}
			
	public double get(int i) {
		return vector.get(i);
	}
	
	public double get(int ... indexes) {
		return vector.get(offset(indexes));
	}

	public void set(double value, int ... indexes) {
		vector.set(offset(indexes), value);
	}
	
	@Override
	public NdDoubleArray duplicate() {
		NdDoubleArray copy = new NdDoubleArray(shape(), strides(), order(), vector.duplicate());		
		return copy;
	}

}
