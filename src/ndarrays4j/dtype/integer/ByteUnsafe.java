package ndarrays4j.dtype.integer;

import ndarrays4j.dtype.Dtype;
import ndarrays4j.utils.UnsafeUtil;

public class ByteUnsafe extends Dtype {		
	
	public ByteUnsafe(){
		super(1);
	}
	
	public ByteUnsafe(long size){		
		super(size, 1);
	}	
	
	public byte get(long i) {
		return UnsafeUtil.UNSAFE.getByte(position(i));
	}
	
	public void set(long i, byte value) {
		UnsafeUtil.UNSAFE.putByte(position(i), value);
	}
	
	public ByteUnsafe duplicate() {
		ByteUnsafe copy = new ByteUnsafe(size());
		UnsafeUtil.UNSAFE.copyMemory(address(), copy.address(), nbytes());
		return copy;
	}

}
