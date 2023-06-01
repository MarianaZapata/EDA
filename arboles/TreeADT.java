package arboles;
/**
 *
 * @author Mariana Zapata Covarrubias
 */

public interface TreeADT<T> {

	public int size();
	public boolean find(T element);
	public boolean isEmpty();

}