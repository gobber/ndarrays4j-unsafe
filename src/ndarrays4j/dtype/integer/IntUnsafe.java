package ndarrays4j.dtype.integer;

import ndarrays4j.dtype.Dtype;
import ndarrays4j.utils.UnsafeUtil;

public class IntUnsafe extends Dtype{
	
	public IntUnsafe() {
		super(Integer.BYTES);
	}
	
	public IntUnsafe(long size) {
		super(size, Integer.BYTES);
	}
	
	public int get(long i) {
		return UnsafeUtil.UNSAFE.getInt(position(i));
	}
	
	public void set(long i, int value) {
		UnsafeUtil.UNSAFE.putInt(position(i), value);
	}
	
	public IntUnsafe duplicate() {
		IntUnsafe copy = new IntUnsafe(size());
		UnsafeUtil.UNSAFE.copyMemory(address(), copy.address(), nbytes());
		return copy;
	}
	
}

