package ndarrays4j.factory.integer;

import ndarrays4j.arrays.integer.NdByteArray;
import ndarrays4j.dtype.integer.ByteUnsafe;
import ndarrays4j.factory.NdArrayFactory;

public class FactoryNdByteArray extends NdArrayFactory<NdByteArray, ByteUnsafe>{
	
	@Override
	public NdByteArray create(int[] shape) {		
		return new NdByteArray(shape);			
	}

	@Override
	public NdByteArray create(int[] shape, int[] strides, int order, ByteUnsafe vector) {	
		return new NdByteArray(shape, strides, order, vector);
	}

	@Override
	public NdByteArray create(int[] shape, int[] strides, ByteUnsafe vector) {
		return new NdByteArray(shape, strides, vector);
	}

	@Override
	public NdByteArray create(int[] shape, ByteUnsafe vector) {
		return new NdByteArray(shape, vector);
	}

	@Override
	public NdByteArray create(long address, int[] shape, int order) {
		return new NdByteArray(address, shape, order);
	}

	@Override
	public NdByteArray create(long address, int[] shape) {
		return new NdByteArray(address, shape);
	}

	@Override
	public NdByteArray create(long address, int[] shape, int[] strides, int order) {
		return new NdByteArray(address, shape, strides, order);
	}

	@Override
	public NdByteArray create(long address, int[] shape, int[] strides) {
		return new NdByteArray(address, shape, strides);
	}

	@Override
	public NdByteArray create(int[] shape, int order) {
		return new NdByteArray(shape, order);
	}
}
