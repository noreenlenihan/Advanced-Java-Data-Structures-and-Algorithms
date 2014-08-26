/** Genericized queue interface 
 * 
 */

package w7;

public interface Queue<T> {
	public void enqueue(T value);
	public T dequeue();
	public T front();
	public boolean isEmpty();
	public int size();

}
