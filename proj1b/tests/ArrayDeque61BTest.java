import jh61b.utils.Reflection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

public class ArrayDeque61BTest {

    @Test
    @DisplayName("ArrayDeque61B has no fields besides backing array and primitives")
    void noNonTrivialFields() {
        List<Field> badFields = Reflection.getFields(ArrayDeque61B.class)
                .filter(f -> !(f.getType().isPrimitive() || f.getType().equals(Object[].class) || f.isSynthetic()))
                .toList();

        assertWithMessage("Found fields that are not array or primitives").that(badFields).isEmpty();
    }

    @Test
    public void addFirstTest() {
        Deque61B<Integer> lst = new ArrayDeque61B<>();

        for (int i = 7; i >= 0; i--) {
            lst.addFirst(i);
        }
        assertThat(lst.toList()).containsExactly(0, 1, 2, 3, 4, 5, 6, 7).inOrder();

        // 扩容
        lst.addFirst(8);
        assertThat(lst.toList()).containsExactly(8, 0, 1, 2, 3, 4, 5, 6, 7).inOrder();
    }

    @Test
    public void addLastTest() {
        Deque61B<Integer> lst = new ArrayDeque61B<>();

        for (int i = 0; i < 8; i++) {
            lst.addLast(i);
        }
        assertThat(lst.toList()).containsExactly(0, 1, 2, 3, 4, 5, 6, 7).inOrder();

        // 扩容
        lst.addLast(8);
        assertThat(lst.toList()).containsExactly(0, 1, 2, 3, 4, 5, 6, 7, 8).inOrder();
    }

    @Test
    public void isEmptyTest() {
        Deque61B<Integer> lst = new ArrayDeque61B<>();

        assertThat(lst.isEmpty()).isTrue();
        lst.addFirst(1);
        assertThat(lst.isEmpty()).isFalse();
    }

    @Test
    public void sizeTest() {
        Deque61B<Integer> lst = new ArrayDeque61B<>();

        assertThat(lst.size()).isEqualTo(0);
        lst.addLast(0);
        assertThat(lst.size()).isEqualTo(1);
        lst.addFirst(1);
        assertThat(lst.size()).isEqualTo(2);
    }

    @Test
    public void getTest() {
        Deque61B<Integer> lst = new ArrayDeque61B<>();

        lst.addLast(0);   // [0]
        lst.addLast(1);   // [0, 1]
        lst.addFirst(-1); // [-1, 0, 1]
        lst.addLast(2);   // [-1, 0, 1, 2]
        lst.addFirst(-2); // [-2, -1, 0, 1, 2]

        assertThat(lst.get(2)).isEqualTo(0);
        assertThat(lst.get(4)).isEqualTo(2);
        assertThat(lst.get(-1)).isEqualTo(null);
        assertThat(lst.get(50)).isEqualTo(null);

        // 扩容
        lst.addFirst(-1);
        lst.addFirst(-1);
        lst.addFirst(-1);
        lst.addLast(99);
        assertThat(lst.get(8)).isEqualTo(99);
    }

    @Test
    public void removeFirstAndremoveLastTest() {
        Deque61B<Integer> lst = new ArrayDeque61B<>();

        lst.addLast(0);   // [0]
        lst.addLast(1);   // [0, 1]
        lst.addFirst(-1); // [-1, 0, 1]
        lst.addLast(2);   // [-1, 0, 1, 2]
        lst.addFirst(-2); // [-2, -1, 0, 1, 2]

        lst.removeFirst();
        assertThat(lst.toList()).containsExactly(-1, 0, 1, 2).inOrder();
        lst.removeLast();
        assertThat(lst.toList()).containsExactly(-1, 0, 1).inOrder();
        assertThat(lst.removeFirst()).isEqualTo(-1);
        assertThat(lst.removeLast()).isEqualTo(1);
        lst.removeFirst();
        assertThat(lst.removeFirst()).isEqualTo(null);
        assertThat(lst.removeLast()).isEqualTo(null);
    }

}
