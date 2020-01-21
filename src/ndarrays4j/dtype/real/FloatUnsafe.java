package ndarrays4j.dtype.real;

import ndarrays4j.dtype.Dtype;
import ndarrays4j.utils.UnsafeUtil;

public class FloatUnsafe extends Dtype{
	
	public FloatUnsafe() {
		super(Float.BYTES);
	}
	
	public FloatUnsafe(long size) {
		super(size, Float.BYTES);
	}
	
	public float get(long i) {
		return UnsafeUtil.UNSAFE.getFloat(position(i));
	}
	
	public void set(long i, float value) {
		UnsafeUtil.UNSAFE.putFloat(position(i), value);
	}
	
	public FloatUnsafe duplicate() {
		FloatUnsafe copy = new FloatUnsafe(size());
		UnsafeUtil.UNSAFE.copyMemory(address(), copy.address(), nbytes());
		return copy;
	}
	
}
