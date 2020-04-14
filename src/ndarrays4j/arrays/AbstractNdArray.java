package ndarrays4j.arrays;

import ndarrays4j.dtype.Dtype;

public abstract class AbstractNdArray<T extends Dtype> {
	
	protected T vector;	
	protected int [] shape, strides;
	protected int order;
	protected int dtype;
	public static final int ORDER_C = 0;
	public static final int ORDER_F = 1;
	
	public static final int BYTE = 0;
	public static final int U_BYTE = 1;
	public static final int SHORT = 2;
	public static final int U_SHORT = 3;
	public static final int FLOAT = 4;
	public static final int DOUBLE = 5;
	public static final int INT = 6;
	public static final int U_INT = 7;
	public static final int LONG = 8;
	public static final int U_LONG = 9;
	
	public void vector(T vector) {
		this.vector = vector;
	}
	
	public T vector() {
		return vector;
	}
	
	public int order() {
		return order;
	}
	
	public int dtype() {
		return dtype;
	}		
		
	public int[] shape() {
		return shape;
	}
	
	protected static int size(int[] shape) {
		int size = 1;
		for(int s : shape)
			size *= s;
		return size;
	}	 
	
	public int size() {
		return size(shape);
	}
	
	public static int[] strides(int[] shape, int order) {
		int[] strides = new int[shape.length];		
		int init = shape.length-1, end = 0, step = -1;
		
		if (order == ORDER_F) {
			init = 0; end = shape.length-1; step = 1;
		}
		
		// this is the same of the cusum of shape
		strides[init] = 1;	
		for(int i = init ; i != end ; i += step)
			strides[i+step] = strides[i] * shape[i];
		
		return strides;
	}
	
	public void strides(int[] strides) {
		this.strides = strides;
	}
	
	public int[] strides() {		
		return strides;
	}
	
	public int offset(int ... indexes) {
		int i = 0;
		for(int j = 0 ; j < strides.length ; j++) 
			i += strides[j] * indexes[j];
		return i;
	}	
	
	public long address() {
		return vector.address(); 
	}
		
	public void address(long address) {
		vector.address(address);
	}
	
	@Override
	public void finalize() {
		this.vector.finalize();
	}
	
	public abstract AbstractNdArray<T> duplicate();
		
}
