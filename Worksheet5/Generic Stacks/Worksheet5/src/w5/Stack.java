/** Stack interface 
 * 
 * @author noreen
 * 
 */

package w5;

public interface Stack<E> {
	public int size();
	public boolean isEmpty();
	public E pop();
	public void push(E object);
	public E top();
}