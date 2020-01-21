package ndarrays4j.factory.real;

import ndarrays4j.arrays.real.NdFloatArray;
import ndarrays4j.dtype.real.FloatUnsafe;
import ndarrays4j.factory.NdArrayFactory;

public class FactoryNdFloatArray extends NdArrayFactory<NdFloatArray, FloatUnsafe>{

	@Override
	public NdFloatArray create(int[] shape, int[] strides, int order, FloatUnsafe vector) {
		return new NdFloatArray(shape, strides, order, vector);
	}

	@Override
	public NdFloatArray create(int[] shape, int[] strides, FloatUnsafe vector) {
		return new NdFloatArray(shape, strides, vector);
	}

	@Override
	public NdFloatArray create(int[] shape, FloatUnsafe vector) {
		return new NdFloatArray(shape, vector);
	}

	@Override
	public NdFloatArray create(int[] shape) {
		return new NdFloatArray(shape);
	}

	@Override
	public NdFloatArray create(int[] shape, int order) {
		return new NdFloatArray(shape, order);
	}

	@Override
	public NdFloatArray create(long address, int[] shape, int order) {
		return new NdFloatArray(address, shape, order);
	}

	@Override
	public NdFloatArray create(long address, int[] shape) {
		return new NdFloatArray(address, shape);
	}

	@Override
	public NdFloatArray create(long address, int[] shape, int[] strides, int order) {
		return new NdFloatArray(address, shape, strides, order);
	}

	@Override
	public NdFloatArray create(long address, int[] shape, int[] strides) {
		return new NdFloatArray(address, shape, strides);
	}
	
}
