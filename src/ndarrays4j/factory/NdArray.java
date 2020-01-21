package ndarrays4j.factory;

import ndarrays4j.arrays.AbstractNdArray;
import ndarrays4j.arrays.integer.NdUnsignedByteArray;
import ndarrays4j.dtype.Dtype;
import ndarrays4j.dtype.integer.ByteUnsafe;

public class NdArray<T extends AbstractNdArray<K>, K extends Dtype> {

	private NdArrayFactory<T, K> factory;
	public T data;
	
	public NdArray (NdArrayFactory<T, K> factory, int[] shape, int[] strides, int order, K vector) {
		this.factory = factory;
		this.data = factory.create(shape, strides, order, vector);		
	}
	
	public NdArray (NdArrayFactory<T, K> factory, int[] shape, int[] strides, K vector) {
		this.factory = factory;
		this.data = factory.create(shape, strides, vector);
	}
	
	public NdArray (NdArrayFactory<T, K> factory, int[] shape, K vector) {
		this.factory = factory;
		this.data = factory.create(shape, vector);
	}
	
	public NdArray (NdArrayFactory<T, K> factory, int[] shape, int order) {
		this.factory = factory;
		this.data = factory.create(shape, order);
	}
	
	public NdArray (NdArrayFactory<T, K> factory, long address, int[] shape, int order) {
		this.factory = factory;
		this.data = factory.create(address, shape, order);
	}
	
	public NdArray (NdArrayFactory<T, K> factory, long address, int[] shape) {
		this.factory = factory;
		this.data = factory.create(address, shape);
	}
	
	public NdArray (NdArrayFactory<T, K> factory, long address, int[] shape, int[] strides, int order) {
		this.factory = factory;
		this.data = factory.create(address, shape, strides, order);
	}
	
	public NdArray (NdArrayFactory<T, K> factory, long address, int[] shape, int[] strides) {
		this.factory = factory;
		this.data = factory.create(address, shape, strides);
	}
	
	public NdArray (NdArrayFactory<T, K> factory, int[] shape){
		this.factory = factory;
		this.data = factory.create(shape);
	}		
	
	public void factory(NdArrayFactory<T, K> factory){
		this.factory = factory;
	}
	
	public NdArrayFactory<T, K> factory(){
		return factory;
	}
	
	public void data(T data) {
		this.data = data;
	}	
	
	public T data() {
		return data;
	}
	
	public long address() {
		return data.address();
	}
	
	public void address(long address) {
		data.address(address);
	}
	
	public void vector(K vector) {
		this.data.vector(vector);
	}
	
	public K vector() {
		return this.data.vector();
	}
	
	public int order() {
		return this.data.order();
	}
	
	public int dtype() {
		return this.data.dtype();
	}		
		
	public int[] shape() {
		return this.data.shape();
	}
	
	public int size() {
		return this.data.size();
	}
	
	public int[] strides() {		
		return this.data.strides();
	}
	
	public static int[] strides(int[] shape, int order) {
		return AbstractNdArray.strides(shape, order);
	}
	
	public int offset(int ... indexes) {
		return this.data.offset(indexes);
	}
	
	@Override
	public void finalize() {
		data.finalize();
	}
	
	public static void main(String args[]) {		
		NdArray<NdUnsignedByteArray, ByteUnsafe> arr = new NdArray<>(NdArrayFactory.U_BYTE, new int[] {10,10,10});
		arr.data.set(255, 0, 1, 1);
		System.out.println(arr.data.get(0, 1, 1));		
	}	
	
}
