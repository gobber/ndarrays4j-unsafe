package ndarrays4j.factory.integer;

import ndarrays4j.arrays.integer.NdShortArray;
import ndarrays4j.dtype.integer.ShortUnsafe;
import ndarrays4j.factory.NdArrayFactory;

public class FactoryNdShortArray extends NdArrayFactory<NdShortArray, ShortUnsafe>{

	@Override
	public NdShortArray create(int[] shape, int[] strides, int order, ShortUnsafe vector) {
		return new NdShortArray(shape, strides, order, vector);
	}

	@Override
	public NdShortArray create(int[] shape, int[] strides, ShortUnsafe vector) {
		return new NdShortArray(shape, strides, vector);
	}

	@Override
	public NdShortArray create(int[] shape, ShortUnsafe vector) {
		return new NdShortArray(shape, vector);
	}

	@Override
	public NdShortArray create(int[] shape) {
		return new NdShortArray(shape);
	}

	@Override
	public NdShortArray create(int[] shape, int order) {
		return new NdShortArray(shape, order);
	}

	@Override
	public NdShortArray create(long address, int[] shape, int order) {
		return new NdShortArray(address, shape, order);
	}

	@Override
	public NdShortArray create(long address, int[] shape) {
		return new NdShortArray(address, shape);
	}

	@Override
	public NdShortArray create(long address, int[] shape, int[] strides, int order) {
		return new NdShortArray(address, shape, strides, order);
	}

	@Override
	public NdShortArray create(long address, int[] shape, int[] strides) {
		return new NdShortArray(address, shape, strides);
	}
	
	
	
}
