package ndarrays4j.dtype.real;

import ndarrays4j.dtype.Dtype;
import ndarrays4j.utils.UnsafeUtil;

public class DoubleUnsafe extends Dtype{
	
	public DoubleUnsafe() {
		super(Double.BYTES);
	}	
	
	public DoubleUnsafe(long size) {
		super(size, Double.BYTES);
	}
	
	public double get(long i) {
		return UnsafeUtil.UNSAFE.getDouble(position(i));
	}
	
	public void set(long i, double value) {
		UnsafeUtil.UNSAFE.putDouble(position(i), value);
	}
	
	public DoubleUnsafe duplicate() {
		DoubleUnsafe copy = new DoubleUnsafe(size());
		UnsafeUtil.UNSAFE.copyMemory(address(), copy.address(), nbytes());
		return copy;
	}
	
}
