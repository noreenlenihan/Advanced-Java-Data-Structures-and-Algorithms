/** Generic queue interface
 * 
 * @author noreen
 * 
 */

package worksheet6;

public interface Queue<T> {
	public void enqueue(T value);

	public T dequeue();

	public T front();

	public boolean isEmpty();

	public int size();

}
