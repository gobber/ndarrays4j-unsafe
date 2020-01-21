package ndarrays4j.dtype;

import ndarrays4j.utils.UnsafeUtil;

public abstract class Dtype {
	
	private long address = 0;
	private long stride = 1;
	private long size = 0; 
	
	public Dtype(long stride) {
		this.stride = stride;
	}
	
	public Dtype(long size, long stride) {		
		this.address = UnsafeUtil.UNSAFE.allocateMemory(size * stride);		
		this.stride = stride;
		this.size = size;
	}
	
	public long nbytes() {
		return size * stride;
	}
	
	public long stride() {
		return stride;
	}

	public void stride(long stride) {
		this.stride = stride;
	}

	public long size() {
		return size;
	}

	public void size(long size) {
		this.size = size;
	}

	public long position(final long index) {
		return address + index * stride;
	}
	
	public void address(long address) {
		this.address = address;
	}
	
	public long address() {
		return address;
	}
	
	public void discard() {
		UnsafeUtil.UNSAFE.freeMemory( address );
		this.address = 0;
	}
	
	public boolean isValid() {
		return this.address > 0;
	}

	@Override
	public void finalize() {
		if ( isValid() )
			discard();
	}
	
}

