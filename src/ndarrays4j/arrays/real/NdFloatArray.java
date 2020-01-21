package ndarrays4j.arrays.real;

import ndarrays4j.arrays.AbstractNdArray;
import ndarrays4j.dtype.real.FloatUnsafe;

public class NdFloatArray extends AbstractNdArray<FloatUnsafe>{
	
	public NdFloatArray(int[] shape, int[] strides, int order, FloatUnsafe vector) {
		this.shape   = shape;
		this.order   = order;
		this.strides = strides;
		this.dtype   = FLOAT;
		this.vector  = vector;
	}
	
	public NdFloatArray(long address, int[] shape, int[] strides, int order) {
		this.shape   = shape;
		this.order   = order;
		this.strides = strides;
		this.dtype   = FLOAT;
		this.vector  = new FloatUnsafe();
		this.vector.address(address);
		this.vector.size(size());
	}
	
	public NdFloatArray(int[] shape, int order) {
		this(shape, strides(shape, order), order, new FloatUnsafe(size(shape)));
	}
	
	public NdFloatArray(int[] shape, int[] strides, FloatUnsafe vector) {
		this(shape, strides, ORDER_C, vector);
	}
	
	public NdFloatArray(int[] shape, FloatUnsafe vector) {
		this(shape, strides(shape, ORDER_C), ORDER_C, vector);
	}
	
	public NdFloatArray(int[] shape) {
		this(shape, new FloatUnsafe(size(shape)));
	}
	
	public NdFloatArray(long address, int[] shape, int order) {		
		this(address, shape, strides(shape, order), order);
	}
	
	public NdFloatArray(long address, int[] shape) {
		this(address, shape, ORDER_C);
	}	
	
	public NdFloatArray(long address, int[] shape, int[] strides) {
		this(address, shape, strides, ORDER_C);
	}
	
	public float get(int i) {
		return vector.get(i);
	}
	
	public float get(int ... indexes) {
		return vector.get(offset(indexes));
	}

	public void set(float value, int ... indexes) {
		vector.set(offset(indexes), value);
	}

	@Override
	public NdFloatArray duplicate() {		
		NdFloatArray copy = new NdFloatArray(shape(), strides(), order(), vector.duplicate());
		return copy;
	}
	
}
