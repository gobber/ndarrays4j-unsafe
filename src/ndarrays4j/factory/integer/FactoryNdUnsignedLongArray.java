package ndarrays4j.factory.integer;

import ndarrays4j.arrays.integer.NdUnsignedLongArray;
import ndarrays4j.dtype.integer.LongUnsafe;
import ndarrays4j.factory.NdArrayFactory;

public class FactoryNdUnsignedLongArray extends NdArrayFactory<NdUnsignedLongArray, LongUnsafe>{
	
	@Override
	public NdUnsignedLongArray create(int[] shape) {			
		return new NdUnsignedLongArray(shape);			
	}

	@Override
	public NdUnsignedLongArray create(int[] shape, int[] strides, int order, LongUnsafe vector) {	
		return new NdUnsignedLongArray(shape, strides, order, vector);
	}

	@Override
	public NdUnsignedLongArray create(int[] shape, int[] strides, LongUnsafe vector) {
		return new NdUnsignedLongArray(shape, strides, vector);
	}

	@Override
	public NdUnsignedLongArray create(int[] shape, LongUnsafe vector) {
		return new NdUnsignedLongArray(shape, vector);
	}

	@Override
	public NdUnsignedLongArray create(long address, int[] shape, int order) {
		return new NdUnsignedLongArray(address, shape, order);
	}

	@Override
	public NdUnsignedLongArray create(long address, int[] shape) {
		return new NdUnsignedLongArray(address, shape);
	}

	@Override
	public NdUnsignedLongArray create(long address, int[] shape, int[] strides, int order) {
		return new NdUnsignedLongArray(address, shape, strides, order);
	}

	@Override
	public NdUnsignedLongArray create(long address, int[] shape, int[] strides) {
		return new NdUnsignedLongArray(address, shape, strides);
	}

	@Override
	public NdUnsignedLongArray create(int[] shape, int order) {
		return new NdUnsignedLongArray(shape, order);
	}
}
