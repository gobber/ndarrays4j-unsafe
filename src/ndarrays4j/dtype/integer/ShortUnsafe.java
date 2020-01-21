package ndarrays4j.dtype.integer;

import ndarrays4j.dtype.Dtype;
import ndarrays4j.utils.UnsafeUtil;

public class ShortUnsafe extends Dtype {
	
	public ShortUnsafe(){
		super(Short.BYTES);			
	}
	
	public ShortUnsafe(long size){		
		super(size, Short.BYTES);
	}	
	
	public short get(long i) {
		return UnsafeUtil.UNSAFE.getShort(position(i));
	}
	
	public void set(long i, short value) {
		UnsafeUtil.UNSAFE.putShort(position(i), value);
	}
	
	public ShortUnsafe duplicate() {
		ShortUnsafe copy = new ShortUnsafe(size());
		UnsafeUtil.UNSAFE.copyMemory(address(), copy.address(), nbytes());
		return copy;
	}

}
