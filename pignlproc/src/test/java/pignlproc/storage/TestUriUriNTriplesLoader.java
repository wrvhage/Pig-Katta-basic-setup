package pignlproc.storage;

import static org.apache.pig.ExecType.LOCAL;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.net.URL;
import java.util.Iterator;

import org.apache.pig.PigServer;
import org.apache.pig.data.Tuple;
import org.junit.Test;

public class TestUriUriNTriplesLoader {

    @Test
    public void testUriUriNTriplesLoader() throws Exception {
        URL dbpediaDump = Thread.currentThread().getContextClassLoader().getResource(
                "dbpedia_3.4_instancetype_en.nt");
        String filename = dbpediaDump.getPath();
        PigServer pig = new PigServer(LOCAL);
        filename = filename.replace("\\", "\\\\");
        String query = "A = LOAD 'file:" + filename
                + "' USING pignlproc.storage.UriUriNTriplesLoader()"
                + " AS (s: chararray, o: chararray);";
        pig.registerQuery(query);
        Iterator<Tuple> it = pig.openIterator("A");
        int tupleCount = 0;
        Tuple tuple = null;
        while (it.hasNext()) {
            tuple = it.next();
            if (tuple == null) {
                throw new Exception("got unexpected null tuple");
            } else {
                if (tuple.size() > 0) {
                    tupleCount++;
                }
            }
        }
        assertEquals(110, tupleCount);
        // introspect last tuple
        assertNotNull(tuple);
        assertEquals(2, tuple.size());
        assertEquals("http://dbpedia.org/resource/%22Looked_Up%22_Plus_Four",
                tuple.get(0));
        assertEquals("http://dbpedia.org/ontology/Album", tuple.get(1));
    }

    @Test
    public void testUriUriNTriplesLoaderWithPrefix() throws Exception {
	URL dbpediaDump = Thread.currentThread().getContextClassLoader()
		.getResource("dbpedia_3.4_instancetype_en.nt");
	String filename = dbpediaDump.getPath();
	PigServer pig = new PigServer(LOCAL);
	filename = filename.replace("\\", "\\\\");
	String query = "A = LOAD 'file:"
		+ filename
		+ "' USING pignlproc.storage.UriUriNTriplesLoader("
		+ "'http://www.w3.org/1999/02/22-rdf-syntax-ns#type',"
		+ " 'http://dbpedia.org/resource/', 'http://dbpedia.org/ontology/')"
		+ " AS (s: chararray, o: chararray);";
	pig.registerQuery(query);
	Iterator<Tuple> it = pig.openIterator("A");
	int tupleCount = 0;
        Tuple tuple = null;
        while (it.hasNext()) {
            tuple = it.next();
            if (tuple == null) {
                throw new Exception("got unexpected null tuple");
            } else {
                if (tuple.size() > 0) {
                    tupleCount++;
                }
            }
        }
        assertEquals(110, tupleCount);
        // introspect last tuple
        assertNotNull(tuple);
        assertEquals(2, tuple.size());
        assertEquals("%22Looked_Up%22_Plus_Four",
                tuple.get(0));
        assertEquals("Album", tuple.get(1));
    }
}
