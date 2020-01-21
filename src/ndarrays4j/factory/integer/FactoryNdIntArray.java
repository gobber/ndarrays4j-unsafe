package ndarrays4j.factory.integer;

import ndarrays4j.arrays.integer.NdIntArray;
import ndarrays4j.dtype.integer.IntUnsafe;
import ndarrays4j.factory.NdArrayFactory;

public class FactoryNdIntArray extends NdArrayFactory<NdIntArray, IntUnsafe>{
	
	@Override
	public NdIntArray create(int[] shape) {			
		return new NdIntArray(shape);			
	}

	@Override
	public NdIntArray create(int[] shape, int[] strides, int order, IntUnsafe vector) {	
		return new NdIntArray(shape, strides, order, vector);
	}

	@Override
	public NdIntArray create(int[] shape, int[] strides, IntUnsafe vector) {
		return new NdIntArray(shape, strides, vector);
	}

	@Override
	public NdIntArray create(int[] shape, IntUnsafe vector) {
		return new NdIntArray(shape, vector);
	}

	@Override
	public NdIntArray create(long address, int[] shape, int order) {
		return new NdIntArray(address, shape, order);
	}

	@Override
	public NdIntArray create(long address, int[] shape) {
		return new NdIntArray(address, shape);
	}

	@Override
	public NdIntArray create(long address, int[] shape, int[] strides, int order) {
		return new NdIntArray(address, shape, strides, order);
	}

	@Override
	public NdIntArray create(long address, int[] shape, int[] strides) {
		return new NdIntArray(address, shape, strides);
	}

	@Override
	public NdIntArray create(int[] shape, int order) {
		return new NdIntArray(shape, order);
	}
}
