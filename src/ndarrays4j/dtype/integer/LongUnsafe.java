package ndarrays4j.dtype.integer;

import ndarrays4j.dtype.Dtype;
import ndarrays4j.utils.UnsafeUtil;

public class LongUnsafe extends Dtype{
	
	public LongUnsafe() {
		super(Long.BYTES);
	}
	
	public LongUnsafe(long size) {
		super(size, Long.BYTES);
	}
	
	public long get(long i) {
		return UnsafeUtil.UNSAFE.getLong(position(i));
	}
	
	public void set(long i, long value) {
		UnsafeUtil.UNSAFE.putLong(position(i), value);
	}
	
	public LongUnsafe duplicate() {
		LongUnsafe copy = new LongUnsafe(size());
		UnsafeUtil.UNSAFE.copyMemory(address(), copy.address(), nbytes());
		return copy;
	}
	
}

