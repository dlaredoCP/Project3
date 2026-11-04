import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CollectionTest {

    @Test
    void add(){
        Collection<HuffmanNode> ex = new Collection<>();
        ex.add(new HuffmanNode(98, 3, null, null));
        ex.add(new HuffmanNode(100, 1, null, null));
        ex.add(new HuffmanNode(99, 2, null, null));
        ex.add(new HuffmanNode(97, 4, null, null));
        ex.add(new HuffmanNode(32, 3, null, null));
        assertEquals(1, ex.get(0).freq());
    }

    @Test
    void remove(){
        Collection<HuffmanNode> ex = new Collection<>();
        ex.add(new HuffmanNode(98, 3, null, null));
        ex.add(new HuffmanNode(100, 1, null, null));
        ex.add(new HuffmanNode(99, 2, null, null));
        ex.add(new HuffmanNode(97, 4, null, null));
        ex.add(new HuffmanNode(32, 3, null, null));
        ex.remove(0);
        ex.remove(0);
        assertEquals(32, ex.get(0).charAscii());
    }

}