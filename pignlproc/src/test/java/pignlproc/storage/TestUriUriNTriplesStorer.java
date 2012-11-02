package pignlproc.storage;

import static org.apache.pig.ExecType.LOCAL;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.net.URL;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.pig.PigServer;
import org.junit.Test;

public class TestUriUriNTriplesStorer {

    protected File outputFile;

    public void cleanupOutputFile() {
        FileUtils.deleteQuietly(outputFile);
    }

    @Test
    public void testUriUriStorer() throws Exception {
        PigServer pig = new PigServer(LOCAL);
        URL dbpediaDump = Thread.currentThread().getContextClassLoader().getResource("graph.tsv");
        String inputFilename = dbpediaDump.getPath();
        inputFilename = inputFilename.replace("\\", "\\\\");
        outputFile = File.createTempFile("testUriUriStorer-", ".nt");
        FileUtils.deleteQuietly(outputFile);
        String outputFilename = outputFile.getAbsolutePath().replace("\\", "\\\\");
        String query = "A = LOAD 'file:" + inputFilename + "' AS (s: chararray, o: chararray);";
        pig.registerQuery(query);
        pig.store("A", outputFilename,
            "pignlproc.storage.UriUriNTriplesStorer('http://mynamespace#followerOf')");
        assertTrue(outputFile.exists());
        File outPart = new File(outputFile, "part-m-00000");
        assertTrue(outPart.exists());
        List<String> lines = FileUtils.readLines(outPart);
        assertEquals(5, lines.size());
        assertEquals("<a> <http://mynamespace#followerOf> <b> .", lines.get(0));
        assertEquals("<a> <http://mynamespace#followerOf> <c\\u00E9> .", lines.get(1));
        assertEquals("<d> <http://mynamespace#followerOf> <a> .", lines.get(2));
        assertEquals("<c\\u00E9> <http://mynamespace#followerOf> <d> .", lines.get(3));
    }

    @Test
    public void testUriUriStorerWithNamespaces() throws Exception {
        PigServer pig = new PigServer(LOCAL);
        URL dbpediaDump = Thread.currentThread().getContextClassLoader().getResource("graph.tsv");
        String inputFilename = dbpediaDump.getPath();
        inputFilename = inputFilename.replace("\\", "\\\\");
        outputFile = File.createTempFile("testUriUriStorer-", ".nt");
        FileUtils.deleteQuietly(outputFile);
        String outputFilename = outputFile.getAbsolutePath().replace("\\", "\\\\");
        String query = "A = LOAD 'file:" + inputFilename + "' AS (s: chararray, o: chararray);";
        pig.registerQuery(query);
        pig.store("A", outputFilename, "pignlproc.storage.UriUriNTriplesStorer("
                                       + "'http://mynamespace#followerOf', 'http://example.org/source#',"
                                       + " 'http://example.org/target#')");
        assertTrue(outputFile.exists());
        File outPart = new File(outputFile, "part-m-00000");
        assertTrue(outPart.exists());
        List<String> lines = FileUtils.readLines(outPart);
        assertEquals(5, lines.size());
        assertEquals(
            "<http://example.org/source#a> <http://mynamespace#followerOf> <http://example.org/target#b> .",
            lines.get(0));
        assertEquals(
            "<http://example.org/source#a> <http://mynamespace#followerOf> <http://example.org/target#c\\u00E9> .",
            lines.get(1));
        assertEquals(
            "<http://example.org/source#d> <http://mynamespace#followerOf> <http://example.org/target#a> .",
            lines.get(2));
        assertEquals(
            "<http://example.org/source#c\\u00E9> <http://mynamespace#followerOf> <http://example.org/target#d> .",
            lines.get(3));
    }

}
