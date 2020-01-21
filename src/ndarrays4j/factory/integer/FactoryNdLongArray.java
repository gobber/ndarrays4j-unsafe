package ndarrays4j.factory.integer;

import ndarrays4j.arrays.integer.NdLongArray;
import ndarrays4j.dtype.integer.LongUnsafe;
import ndarrays4j.factory.NdArrayFactory;

public class FactoryNdLongArray extends NdArrayFactory<NdLongArray, LongUnsafe>{
	
	@Override
	public NdLongArray create(int[] shape) {			
		return new NdLongArray(shape);			
	}

	@Override
	public NdLongArray create(int[] shape, int[] strides, int order, LongUnsafe vector) {	
		return new NdLongArray(shape, strides, order, vector);
	}

	@Override
	public NdLongArray create(int[] shape, int[] strides, LongUnsafe vector) {
		return new NdLongArray(shape, strides, vector);
	}

	@Override
	public NdLongArray create(int[] shape, LongUnsafe vector) {
		return new NdLongArray(shape, vector);
	}

	@Override
	public NdLongArray create(long address, int[] shape, int order) {
		return new NdLongArray(address, shape, order);
	}

	@Override
	public NdLongArray create(long address, int[] shape) {
		return new NdLongArray(address, shape);
	}

	@Override
	public NdLongArray create(long address, int[] shape, int[] strides, int order) {
		return new NdLongArray(address, shape, strides, order);
	}

	@Override
	public NdLongArray create(long address, int[] shape, int[] strides) {
		return new NdLongArray(address, shape, strides);
	}

	@Override
	public NdLongArray create(int[] shape, int order) {
		return new NdLongArray(shape, order);
	}
}
