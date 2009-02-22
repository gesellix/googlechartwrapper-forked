package googlechartwrapper.util;

/**
 * From http://en.wikipedia.org/wiki/Generics_in_Java
 * 
 * @author steffan
 * 
 * @param <T>
 * @param <S>
 */
public class Pair<T, S> {

	private T first;
	private S second;

	public Pair(T f, S s) {
		first = f;
		second = s;
	}

	public T getFirst() {
		return first;
	}

	public S getSecond() {
		return second;
	}

	@Override
	public String toString() {
		return "(" + first.toString() + ", " + second.toString() + ")";
	}

}
