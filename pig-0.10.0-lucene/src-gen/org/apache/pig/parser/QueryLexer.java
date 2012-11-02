// $ANTLR 3.4 /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g 2012-10-31 09:51:32

package org.apache.pig.parser;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * Lexer file for Pig Parser
 */
@SuppressWarnings({"all", "warnings", "unchecked"})
public class QueryLexer extends Lexer {
    public static final int EOF=-1;
    public static final int ALL=4;
    public static final int AND=5;
    public static final int AS=6;
    public static final int ASC=7;
    public static final int BAG=8;
    public static final int BOOLEAN=9;
    public static final int BY=10;
    public static final int BYTEARRAY=11;
    public static final int CACHE=12;
    public static final int CHARARRAY=13;
    public static final int COGROUP=14;
    public static final int COLON=15;
    public static final int COMMA=16;
    public static final int CROSS=17;
    public static final int DCOLON=18;
    public static final int DEFINE=19;
    public static final int DESC=20;
    public static final int DIGIT=21;
    public static final int DISTINCT=22;
    public static final int DIV=23;
    public static final int DOLLAR=24;
    public static final int DOLLARVAR=25;
    public static final int DOUBLE=26;
    public static final int DOUBLENUMBER=27;
    public static final int DOUBLE_PERIOD=28;
    public static final int EQUAL=29;
    public static final int EXECCOMMAND=30;
    public static final int FALSE=31;
    public static final int FILTER=32;
    public static final int FLATTEN=33;
    public static final int FLOAT=34;
    public static final int FLOATINGPOINT=35;
    public static final int FLOATNUMBER=36;
    public static final int FOREACH=37;
    public static final int FULL=38;
    public static final int GENERATE=39;
    public static final int GROUP=40;
    public static final int ID=41;
    public static final int IDENTIFIER_L=42;
    public static final int IF=43;
    public static final int IMPORT=44;
    public static final int INNER=45;
    public static final int INPUT=46;
    public static final int INT=47;
    public static final int INTEGER=48;
    public static final int INTO=49;
    public static final int IS=50;
    public static final int JOIN=51;
    public static final int LEFT=52;
    public static final int LEFT_BRACKET=53;
    public static final int LEFT_CURLY=54;
    public static final int LEFT_PAREN=55;
    public static final int LETTER=56;
    public static final int LIMIT=57;
    public static final int LOAD=58;
    public static final int LONG=59;
    public static final int LONGINTEGER=60;
    public static final int MAP=61;
    public static final int MAPREDUCE=62;
    public static final int MINUS=63;
    public static final int ML_COMMENT=64;
    public static final int MULTILINE_QUOTEDSTRING=65;
    public static final int NOT=66;
    public static final int NUM_OP_EQ=67;
    public static final int NUM_OP_GT=68;
    public static final int NUM_OP_GTE=69;
    public static final int NUM_OP_LT=70;
    public static final int NUM_OP_LTE=71;
    public static final int NUM_OP_NE=72;
    public static final int ONSCHEMA=73;
    public static final int OR=74;
    public static final int ORDER=75;
    public static final int OTHERWISE=76;
    public static final int OUTER=77;
    public static final int OUTPUT=78;
    public static final int PARALLEL=79;
    public static final int PARTITION=80;
    public static final int PERCENT=81;
    public static final int PERIOD=82;
    public static final int PLUS=83;
    public static final int POUND=84;
    public static final int QMARK=85;
    public static final int QUOTEDSTRING=86;
    public static final int RETURNS=87;
    public static final int RIGHT=88;
    public static final int RIGHT_BRACKET=89;
    public static final int RIGHT_CURLY=90;
    public static final int RIGHT_PAREN=91;
    public static final int SAMPLE=92;
    public static final int SEMI_COLON=93;
    public static final int SHIP=94;
    public static final int SL_COMMENT=95;
    public static final int SPECIALCHAR=96;
    public static final int SPLIT=97;
    public static final int STAR=98;
    public static final int STDERROR=99;
    public static final int STDIN=100;
    public static final int STDOUT=101;
    public static final int STORE=102;
    public static final int STREAM=103;
    public static final int STR_OP_EQ=104;
    public static final int STR_OP_GT=105;
    public static final int STR_OP_GTE=106;
    public static final int STR_OP_LT=107;
    public static final int STR_OP_LTE=108;
    public static final int STR_OP_MATCHES=109;
    public static final int STR_OP_NE=110;
    public static final int THROUGH=111;
    public static final int TRUE=112;
    public static final int TUPLE=113;
    public static final int UNION=114;
    public static final int USING=115;
    public static final int VOID=116;
    public static final int WS=117;


    @Override
    public void reportError(RecognitionException e) {
        super.reportError( e );
        
        // The method of this signature doesn't permit checked exception. Here we have to 
        // throw a unchecked execption in order to stop at the first error.
        // For more information, visit http://www.antlr.org/wiki/pages/viewpage.action?pageId=5341217.
        StringBuilder sb = new StringBuilder();
        sb.append( getErrorHeader( e ) ).append( " " );
        sb.append( getErrorMessage( e, getTokenNames() ) );
        throw new RuntimeException( sb.toString() );
    }

    @Override
    public String getErrorMessage(RecognitionException e, String[] tokenNames ) {
        if( e instanceof NoViableAltException ) {
            return "Unexpected character " + getCharErrorDisplay( e.c );
        } else {
            return super.getErrorMessage( e, tokenNames );
        }
    }

    @Override
    public String getErrorHeader(RecognitionException ex) {
    	return QueryParserUtils.generateErrorHeader( ex, this.getSourceName() );
    }



    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public QueryLexer() {} 
    public QueryLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public QueryLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "/Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g"; }

    // $ANTLR start "VOID"
    public final void mVOID() throws RecognitionException {
        try {
            int _type = VOID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:60:9: ( 'VOID' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:60:11: 'VOID'
            {
            match("VOID"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "VOID"

    // $ANTLR start "IMPORT"
    public final void mIMPORT() throws RecognitionException {
        try {
            int _type = IMPORT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:63:9: ( 'IMPORT' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:63:11: 'IMPORT'
            {
            match("IMPORT"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "IMPORT"

    // $ANTLR start "RETURNS"
    public final void mRETURNS() throws RecognitionException {
        try {
            int _type = RETURNS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:66:9: ( 'RETURNS' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:66:11: 'RETURNS'
            {
            match("RETURNS"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RETURNS"

    // $ANTLR start "DEFINE"
    public final void mDEFINE() throws RecognitionException {
        try {
            int _type = DEFINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:69:8: ( 'DEFINE' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:69:10: 'DEFINE'
            {
            match("DEFINE"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DEFINE"

    // $ANTLR start "LOAD"
    public final void mLOAD() throws RecognitionException {
        try {
            int _type = LOAD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:72:8: ( 'LOAD' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:72:10: 'LOAD'
            {
            match("LOAD"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LOAD"

    // $ANTLR start "FILTER"
    public final void mFILTER() throws RecognitionException {
        try {
            int _type = FILTER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:75:8: ( 'FILTER' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:75:10: 'FILTER'
            {
            match("FILTER"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FILTER"

    // $ANTLR start "FOREACH"
    public final void mFOREACH() throws RecognitionException {
        try {
            int _type = FOREACH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:78:9: ( 'FOREACH' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:78:11: 'FOREACH'
            {
            match("FOREACH"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FOREACH"

    // $ANTLR start "ORDER"
    public final void mORDER() throws RecognitionException {
        try {
            int _type = ORDER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:81:9: ( 'ORDER' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:81:12: 'ORDER'
            {
            match("ORDER"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ORDER"

    // $ANTLR start "DISTINCT"
    public final void mDISTINCT() throws RecognitionException {
        try {
            int _type = DISTINCT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:84:10: ( 'DISTINCT' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:84:12: 'DISTINCT'
            {
            match("DISTINCT"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DISTINCT"

    // $ANTLR start "COGROUP"
    public final void mCOGROUP() throws RecognitionException {
        try {
            int _type = COGROUP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:87:9: ( 'COGROUP' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:87:11: 'COGROUP'
            {
            match("COGROUP"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COGROUP"

    // $ANTLR start "JOIN"
    public final void mJOIN() throws RecognitionException {
        try {
            int _type = JOIN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:90:6: ( 'JOIN' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:90:8: 'JOIN'
            {
            match("JOIN"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "JOIN"

    // $ANTLR start "CROSS"
    public final void mCROSS() throws RecognitionException {
        try {
            int _type = CROSS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:93:7: ( 'CROSS' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:93:9: 'CROSS'
            {
            match("CROSS"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CROSS"

    // $ANTLR start "UNION"
    public final void mUNION() throws RecognitionException {
        try {
            int _type = UNION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:96:7: ( 'UNION' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:96:9: 'UNION'
            {
            match("UNION"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "UNION"

    // $ANTLR start "SPLIT"
    public final void mSPLIT() throws RecognitionException {
        try {
            int _type = SPLIT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:99:7: ( 'SPLIT' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:99:9: 'SPLIT'
            {
            match("SPLIT"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SPLIT"

    // $ANTLR start "INTO"
    public final void mINTO() throws RecognitionException {
        try {
            int _type = INTO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:102:6: ( 'INTO' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:102:8: 'INTO'
            {
            match("INTO"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INTO"

    // $ANTLR start "IF"
    public final void mIF() throws RecognitionException {
        try {
            int _type = IF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:105:4: ( 'IF' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:105:6: 'IF'
            {
            match("IF"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "IF"

    // $ANTLR start "OTHERWISE"
    public final void mOTHERWISE() throws RecognitionException {
        try {
            int _type = OTHERWISE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:108:11: ( 'OTHERWISE' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:108:13: 'OTHERWISE'
            {
            match("OTHERWISE"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OTHERWISE"

    // $ANTLR start "ALL"
    public final void mALL() throws RecognitionException {
        try {
            int _type = ALL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:111:5: ( 'ALL' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:111:7: 'ALL'
            {
            match("ALL"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ALL"

    // $ANTLR start "AS"
    public final void mAS() throws RecognitionException {
        try {
            int _type = AS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:114:4: ( 'AS' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:114:6: 'AS'
            {
            match("AS"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "AS"

    // $ANTLR start "BY"
    public final void mBY() throws RecognitionException {
        try {
            int _type = BY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:117:4: ( 'BY' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:117:6: 'BY'
            {
            match("BY"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "BY"

    // $ANTLR start "USING"
    public final void mUSING() throws RecognitionException {
        try {
            int _type = USING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:120:7: ( 'USING' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:120:9: 'USING'
            {
            match("USING"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "USING"

    // $ANTLR start "INNER"
    public final void mINNER() throws RecognitionException {
        try {
            int _type = INNER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:123:7: ( 'INNER' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:123:9: 'INNER'
            {
            match("INNER"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INNER"

    // $ANTLR start "OUTER"
    public final void mOUTER() throws RecognitionException {
        try {
            int _type = OUTER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:126:7: ( 'OUTER' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:126:9: 'OUTER'
            {
            match("OUTER"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OUTER"

    // $ANTLR start "ONSCHEMA"
    public final void mONSCHEMA() throws RecognitionException {
        try {
            int _type = ONSCHEMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:129:10: ( 'ONSCHEMA' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:129:12: 'ONSCHEMA'
            {
            match("ONSCHEMA"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ONSCHEMA"

    // $ANTLR start "PARALLEL"
    public final void mPARALLEL() throws RecognitionException {
        try {
            int _type = PARALLEL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:132:10: ( 'PARALLEL' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:132:12: 'PARALLEL'
            {
            match("PARALLEL"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PARALLEL"

    // $ANTLR start "PARTITION"
    public final void mPARTITION() throws RecognitionException {
        try {
            int _type = PARTITION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:135:11: ( 'PARTITION' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:135:13: 'PARTITION'
            {
            match("PARTITION"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PARTITION"

    // $ANTLR start "GROUP"
    public final void mGROUP() throws RecognitionException {
        try {
            int _type = GROUP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:138:7: ( 'GROUP' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:138:9: 'GROUP'
            {
            match("GROUP"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "GROUP"

    // $ANTLR start "AND"
    public final void mAND() throws RecognitionException {
        try {
            int _type = AND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:141:5: ( 'AND' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:141:7: 'AND'
            {
            match("AND"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "AND"

    // $ANTLR start "OR"
    public final void mOR() throws RecognitionException {
        try {
            int _type = OR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:144:4: ( 'OR' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:144:6: 'OR'
            {
            match("OR"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OR"

    // $ANTLR start "NOT"
    public final void mNOT() throws RecognitionException {
        try {
            int _type = NOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:147:5: ( 'NOT' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:147:7: 'NOT'
            {
            match("NOT"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NOT"

    // $ANTLR start "GENERATE"
    public final void mGENERATE() throws RecognitionException {
        try {
            int _type = GENERATE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:150:10: ( 'GENERATE' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:150:12: 'GENERATE'
            {
            match("GENERATE"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "GENERATE"

    // $ANTLR start "FLATTEN"
    public final void mFLATTEN() throws RecognitionException {
        try {
            int _type = FLATTEN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:153:9: ( 'FLATTEN' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:153:11: 'FLATTEN'
            {
            match("FLATTEN"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FLATTEN"

    // $ANTLR start "ASC"
    public final void mASC() throws RecognitionException {
        try {
            int _type = ASC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:156:5: ( 'ASC' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:156:7: 'ASC'
            {
            match("ASC"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ASC"

    // $ANTLR start "DESC"
    public final void mDESC() throws RecognitionException {
        try {
            int _type = DESC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:159:6: ( 'DESC' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:159:8: 'DESC'
            {
            match("DESC"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DESC"

    // $ANTLR start "BOOLEAN"
    public final void mBOOLEAN() throws RecognitionException {
        try {
            int _type = BOOLEAN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:162:9: ( 'BOOLEAN' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:162:11: 'BOOLEAN'
            {
            match("BOOLEAN"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "BOOLEAN"

    // $ANTLR start "INT"
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:165:5: ( 'INT' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:165:7: 'INT'
            {
            match("INT"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INT"

    // $ANTLR start "LONG"
    public final void mLONG() throws RecognitionException {
        try {
            int _type = LONG;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:168:6: ( 'LONG' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:168:8: 'LONG'
            {
            match("LONG"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LONG"

    // $ANTLR start "FLOAT"
    public final void mFLOAT() throws RecognitionException {
        try {
            int _type = FLOAT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:171:7: ( 'FLOAT' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:171:9: 'FLOAT'
            {
            match("FLOAT"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FLOAT"

    // $ANTLR start "DOUBLE"
    public final void mDOUBLE() throws RecognitionException {
        try {
            int _type = DOUBLE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:174:8: ( 'DOUBLE' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:174:10: 'DOUBLE'
            {
            match("DOUBLE"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DOUBLE"

    // $ANTLR start "CHARARRAY"
    public final void mCHARARRAY() throws RecognitionException {
        try {
            int _type = CHARARRAY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:177:11: ( 'CHARARRAY' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:177:13: 'CHARARRAY'
            {
            match("CHARARRAY"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CHARARRAY"

    // $ANTLR start "BYTEARRAY"
    public final void mBYTEARRAY() throws RecognitionException {
        try {
            int _type = BYTEARRAY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:180:11: ( 'BYTEARRAY' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:180:13: 'BYTEARRAY'
            {
            match("BYTEARRAY"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "BYTEARRAY"

    // $ANTLR start "BAG"
    public final void mBAG() throws RecognitionException {
        try {
            int _type = BAG;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:183:5: ( 'BAG' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:183:7: 'BAG'
            {
            match("BAG"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "BAG"

    // $ANTLR start "TUPLE"
    public final void mTUPLE() throws RecognitionException {
        try {
            int _type = TUPLE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:186:7: ( 'TUPLE' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:186:9: 'TUPLE'
            {
            match("TUPLE"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "TUPLE"

    // $ANTLR start "MAP"
    public final void mMAP() throws RecognitionException {
        try {
            int _type = MAP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:189:5: ( 'MAP' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:189:7: 'MAP'
            {
            match("MAP"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MAP"

    // $ANTLR start "IS"
    public final void mIS() throws RecognitionException {
        try {
            int _type = IS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:192:4: ( 'IS' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:192:6: 'IS'
            {
            match("IS"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "IS"

    // $ANTLR start "STREAM"
    public final void mSTREAM() throws RecognitionException {
        try {
            int _type = STREAM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:195:8: ( 'STREAM' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:195:10: 'STREAM'
            {
            match("STREAM"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STREAM"

    // $ANTLR start "THROUGH"
    public final void mTHROUGH() throws RecognitionException {
        try {
            int _type = THROUGH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:198:9: ( 'THROUGH' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:198:11: 'THROUGH'
            {
            match("THROUGH"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "THROUGH"

    // $ANTLR start "STORE"
    public final void mSTORE() throws RecognitionException {
        try {
            int _type = STORE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:201:7: ( 'STORE' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:201:9: 'STORE'
            {
            match("STORE"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STORE"

    // $ANTLR start "MAPREDUCE"
    public final void mMAPREDUCE() throws RecognitionException {
        try {
            int _type = MAPREDUCE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:204:11: ( 'MAPREDUCE' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:204:13: 'MAPREDUCE'
            {
            match("MAPREDUCE"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MAPREDUCE"

    // $ANTLR start "SHIP"
    public final void mSHIP() throws RecognitionException {
        try {
            int _type = SHIP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:207:6: ( 'SHIP' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:207:8: 'SHIP'
            {
            match("SHIP"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SHIP"

    // $ANTLR start "CACHE"
    public final void mCACHE() throws RecognitionException {
        try {
            int _type = CACHE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:210:7: ( 'CACHE' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:210:9: 'CACHE'
            {
            match("CACHE"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CACHE"

    // $ANTLR start "INPUT"
    public final void mINPUT() throws RecognitionException {
        try {
            int _type = INPUT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:213:7: ( 'INPUT' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:213:9: 'INPUT'
            {
            match("INPUT"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INPUT"

    // $ANTLR start "OUTPUT"
    public final void mOUTPUT() throws RecognitionException {
        try {
            int _type = OUTPUT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:216:8: ( 'OUTPUT' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:216:10: 'OUTPUT'
            {
            match("OUTPUT"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OUTPUT"

    // $ANTLR start "STDERROR"
    public final void mSTDERROR() throws RecognitionException {
        try {
            int _type = STDERROR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:219:10: ( 'STDERR' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:219:12: 'STDERR'
            {
            match("STDERR"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STDERROR"

    // $ANTLR start "STDIN"
    public final void mSTDIN() throws RecognitionException {
        try {
            int _type = STDIN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:222:7: ( 'STDIN' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:222:9: 'STDIN'
            {
            match("STDIN"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STDIN"

    // $ANTLR start "STDOUT"
    public final void mSTDOUT() throws RecognitionException {
        try {
            int _type = STDOUT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:225:8: ( 'STDOUT' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:225:10: 'STDOUT'
            {
            match("STDOUT"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STDOUT"

    // $ANTLR start "LIMIT"
    public final void mLIMIT() throws RecognitionException {
        try {
            int _type = LIMIT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:228:7: ( 'LIMIT' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:228:9: 'LIMIT'
            {
            match("LIMIT"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LIMIT"

    // $ANTLR start "SAMPLE"
    public final void mSAMPLE() throws RecognitionException {
        try {
            int _type = SAMPLE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:231:8: ( 'SAMPLE' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:231:10: 'SAMPLE'
            {
            match("SAMPLE"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SAMPLE"

    // $ANTLR start "LEFT"
    public final void mLEFT() throws RecognitionException {
        try {
            int _type = LEFT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:234:6: ( 'LEFT' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:234:8: 'LEFT'
            {
            match("LEFT"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LEFT"

    // $ANTLR start "RIGHT"
    public final void mRIGHT() throws RecognitionException {
        try {
            int _type = RIGHT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:237:7: ( 'RIGHT' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:237:9: 'RIGHT'
            {
            match("RIGHT"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RIGHT"

    // $ANTLR start "FULL"
    public final void mFULL() throws RecognitionException {
        try {
            int _type = FULL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:240:6: ( 'FULL' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:240:8: 'FULL'
            {
            match("FULL"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FULL"

    // $ANTLR start "STR_OP_EQ"
    public final void mSTR_OP_EQ() throws RecognitionException {
        try {
            int _type = STR_OP_EQ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:243:11: ( 'EQ' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:243:13: 'EQ'
            {
            match("EQ"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STR_OP_EQ"

    // $ANTLR start "STR_OP_GT"
    public final void mSTR_OP_GT() throws RecognitionException {
        try {
            int _type = STR_OP_GT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:246:11: ( 'GT' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:246:13: 'GT'
            {
            match("GT"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STR_OP_GT"

    // $ANTLR start "STR_OP_LT"
    public final void mSTR_OP_LT() throws RecognitionException {
        try {
            int _type = STR_OP_LT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:249:11: ( 'LT' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:249:13: 'LT'
            {
            match("LT"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STR_OP_LT"

    // $ANTLR start "STR_OP_GTE"
    public final void mSTR_OP_GTE() throws RecognitionException {
        try {
            int _type = STR_OP_GTE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:252:12: ( 'GTE' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:252:14: 'GTE'
            {
            match("GTE"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STR_OP_GTE"

    // $ANTLR start "STR_OP_LTE"
    public final void mSTR_OP_LTE() throws RecognitionException {
        try {
            int _type = STR_OP_LTE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:255:12: ( 'LTE' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:255:14: 'LTE'
            {
            match("LTE"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STR_OP_LTE"

    // $ANTLR start "STR_OP_NE"
    public final void mSTR_OP_NE() throws RecognitionException {
        try {
            int _type = STR_OP_NE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:258:11: ( 'NEQ' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:258:13: 'NEQ'
            {
            match("NEQ"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STR_OP_NE"

    // $ANTLR start "STR_OP_MATCHES"
    public final void mSTR_OP_MATCHES() throws RecognitionException {
        try {
            int _type = STR_OP_MATCHES;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:261:16: ( 'MATCHES' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:261:18: 'MATCHES'
            {
            match("MATCHES"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STR_OP_MATCHES"

    // $ANTLR start "TRUE"
    public final void mTRUE() throws RecognitionException {
        try {
            int _type = TRUE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:264:6: ( 'TRUE' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:264:8: 'TRUE'
            {
            match("TRUE"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "TRUE"

    // $ANTLR start "FALSE"
    public final void mFALSE() throws RecognitionException {
        try {
            int _type = FALSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:267:7: ( 'FALSE' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:267:9: 'FALSE'
            {
            match("FALSE"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FALSE"

    // $ANTLR start "NUM_OP_EQ"
    public final void mNUM_OP_EQ() throws RecognitionException {
        try {
            int _type = NUM_OP_EQ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:270:11: ( '==' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:270:13: '=='
            {
            match("=="); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NUM_OP_EQ"

    // $ANTLR start "NUM_OP_LT"
    public final void mNUM_OP_LT() throws RecognitionException {
        try {
            int _type = NUM_OP_LT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:273:11: ( '<' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:273:13: '<'
            {
            match('<'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NUM_OP_LT"

    // $ANTLR start "NUM_OP_LTE"
    public final void mNUM_OP_LTE() throws RecognitionException {
        try {
            int _type = NUM_OP_LTE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:276:12: ( '<=' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:276:14: '<='
            {
            match("<="); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NUM_OP_LTE"

    // $ANTLR start "NUM_OP_GT"
    public final void mNUM_OP_GT() throws RecognitionException {
        try {
            int _type = NUM_OP_GT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:279:11: ( '>' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:279:13: '>'
            {
            match('>'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NUM_OP_GT"

    // $ANTLR start "NUM_OP_GTE"
    public final void mNUM_OP_GTE() throws RecognitionException {
        try {
            int _type = NUM_OP_GTE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:282:12: ( '>=' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:282:14: '>='
            {
            match(">="); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NUM_OP_GTE"

    // $ANTLR start "NUM_OP_NE"
    public final void mNUM_OP_NE() throws RecognitionException {
        try {
            int _type = NUM_OP_NE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:285:11: ( '!=' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:285:13: '!='
            {
            match("!="); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NUM_OP_NE"

    // $ANTLR start "DIGIT"
    public final void mDIGIT() throws RecognitionException {
        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:288:16: ( '0' .. '9' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:
            {
            if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                input.consume();
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DIGIT"

    // $ANTLR start "LETTER"
    public final void mLETTER() throws RecognitionException {
        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:291:17: ( 'A' .. 'Z' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z') ) {
                input.consume();
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LETTER"

    // $ANTLR start "SPECIALCHAR"
    public final void mSPECIALCHAR() throws RecognitionException {
        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:294:22: ( '_' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:294:24: '_'
            {
            match('_'); if (state.failed) return ;

            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SPECIALCHAR"

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:297:12: ( LETTER ( DIGIT | LETTER | SPECIALCHAR )* )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:297:14: LETTER ( DIGIT | LETTER | SPECIALCHAR )*
            {
            mLETTER(); if (state.failed) return ;


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:297:21: ( DIGIT | LETTER | SPECIALCHAR )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= '0' && LA1_0 <= '9')||(LA1_0 >= 'A' && LA1_0 <= 'Z')||LA1_0=='_') ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_' ) {
            	        input.consume();
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ID"

    // $ANTLR start "DCOLON"
    public final void mDCOLON() throws RecognitionException {
        try {
            int _type = DCOLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:300:8: ( '::' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:300:10: '::'
            {
            match("::"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DCOLON"

    // $ANTLR start "IDENTIFIER_L"
    public final void mIDENTIFIER_L() throws RecognitionException {
        try {
            int _type = IDENTIFIER_L;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:303:14: ( ( ID DCOLON )=> ( ID DCOLON IDENTIFIER_L ) | ID )
            int alt2=2;
            alt2 = dfa2.predict(input);
            switch (alt2) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:303:16: ( ID DCOLON )=> ( ID DCOLON IDENTIFIER_L )
                    {
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:303:33: ( ID DCOLON IDENTIFIER_L )
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:303:35: ID DCOLON IDENTIFIER_L
                    {
                    mID(); if (state.failed) return ;


                    mDCOLON(); if (state.failed) return ;


                    mIDENTIFIER_L(); if (state.failed) return ;


                    }


                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:304:14: ID
                    {
                    mID(); if (state.failed) return ;


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "IDENTIFIER_L"

    // $ANTLR start "FLOATINGPOINT"
    public final void mFLOATINGPOINT() throws RecognitionException {
        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:307:24: ( INTEGER ( PERIOD INTEGER )? | PERIOD INTEGER )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( ((LA4_0 >= '0' && LA4_0 <= '9')) ) {
                alt4=1;
            }
            else if ( (LA4_0=='.') ) {
                alt4=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;

            }
            switch (alt4) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:307:26: INTEGER ( PERIOD INTEGER )?
                    {
                    mINTEGER(); if (state.failed) return ;


                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:307:34: ( PERIOD INTEGER )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0=='.') ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:307:36: PERIOD INTEGER
                            {
                            mPERIOD(); if (state.failed) return ;


                            mINTEGER(); if (state.failed) return ;


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:307:56: PERIOD INTEGER
                    {
                    mPERIOD(); if (state.failed) return ;


                    mINTEGER(); if (state.failed) return ;


                    }
                    break;

            }

        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FLOATINGPOINT"

    // $ANTLR start "INTEGER"
    public final void mINTEGER() throws RecognitionException {
        try {
            int _type = INTEGER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:310:8: ( ( DIGIT )+ )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:310:10: ( DIGIT )+
            {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:310:10: ( DIGIT )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0 >= '0' && LA5_0 <= '9')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INTEGER"

    // $ANTLR start "LONGINTEGER"
    public final void mLONGINTEGER() throws RecognitionException {
        try {
            int _type = LONGINTEGER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:313:12: ( INTEGER ( 'L' )? )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:313:14: INTEGER ( 'L' )?
            {
            mINTEGER(); if (state.failed) return ;


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:313:22: ( 'L' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='L') ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:313:24: 'L'
                    {
                    match('L'); if (state.failed) return ;

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LONGINTEGER"

    // $ANTLR start "DOLLARVAR"
    public final void mDOLLARVAR() throws RecognitionException {
        try {
            int _type = DOLLARVAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:316:11: ( DOLLAR INTEGER )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:316:13: DOLLAR INTEGER
            {
            mDOLLAR(); if (state.failed) return ;


            mINTEGER(); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DOLLARVAR"

    // $ANTLR start "DOUBLENUMBER"
    public final void mDOUBLENUMBER() throws RecognitionException {
        try {
            int _type = DOUBLENUMBER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:319:14: ( FLOATINGPOINT ( 'E' ( MINUS | PLUS )? INTEGER )? )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:319:16: FLOATINGPOINT ( 'E' ( MINUS | PLUS )? INTEGER )?
            {
            mFLOATINGPOINT(); if (state.failed) return ;


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:319:30: ( 'E' ( MINUS | PLUS )? INTEGER )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0=='E') ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:319:32: 'E' ( MINUS | PLUS )? INTEGER
                    {
                    match('E'); if (state.failed) return ;

                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:319:36: ( MINUS | PLUS )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0=='+'||LA7_0=='-') ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:
                            {
                            if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                                input.consume();
                                state.failed=false;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return ;}
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                recover(mse);
                                throw mse;
                            }


                            }
                            break;

                    }


                    mINTEGER(); if (state.failed) return ;


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DOUBLENUMBER"

    // $ANTLR start "FLOATNUMBER"
    public final void mFLOATNUMBER() throws RecognitionException {
        try {
            int _type = FLOATNUMBER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:322:13: ( DOUBLENUMBER ( 'F' )? )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:322:15: DOUBLENUMBER ( 'F' )?
            {
            mDOUBLENUMBER(); if (state.failed) return ;


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:322:28: ( 'F' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='F') ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:322:30: 'F'
                    {
                    match('F'); if (state.failed) return ;

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FLOATNUMBER"

    // $ANTLR start "QUOTEDSTRING"
    public final void mQUOTEDSTRING() throws RecognitionException {
        try {
            int _type = QUOTEDSTRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:325:14: ( '\\'' ( (~ ( '\\'' | '\\\\' | '\\n' | '\\r' ) ) | ( '\\\\' ( ( 'N' | 'T' | 'B' | 'R' | 'F' | '\\\\' | '\\'' ) ) ) | ( '\\\\U' ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ) )* '\\'' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:325:17: '\\'' ( (~ ( '\\'' | '\\\\' | '\\n' | '\\r' ) ) | ( '\\\\' ( ( 'N' | 'T' | 'B' | 'R' | 'F' | '\\\\' | '\\'' ) ) ) | ( '\\\\U' ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ) )* '\\''
            {
            match('\''); if (state.failed) return ;

            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:325:22: ( (~ ( '\\'' | '\\\\' | '\\n' | '\\r' ) ) | ( '\\\\' ( ( 'N' | 'T' | 'B' | 'R' | 'F' | '\\\\' | '\\'' ) ) ) | ( '\\\\U' ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ) )*
            loop10:
            do {
                int alt10=4;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0 >= '\u0000' && LA10_0 <= '\t')||(LA10_0 >= '\u000B' && LA10_0 <= '\f')||(LA10_0 >= '\u000E' && LA10_0 <= '&')||(LA10_0 >= '(' && LA10_0 <= '[')||(LA10_0 >= ']' && LA10_0 <= '\uFFFF')) ) {
                    alt10=1;
                }
                else if ( (LA10_0=='\\') ) {
                    int LA10_3 = input.LA(2);

                    if ( (LA10_3=='\''||LA10_3=='B'||LA10_3=='F'||LA10_3=='N'||LA10_3=='R'||LA10_3=='T'||LA10_3=='\\') ) {
                        alt10=2;
                    }
                    else if ( (LA10_3=='U') ) {
                        alt10=3;
                    }


                }


                switch (alt10) {
            	case 1 :
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:325:26: (~ ( '\\'' | '\\\\' | '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '&')||(input.LA(1) >= '(' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;
            	case 2 :
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:326:26: ( '\\\\' ( ( 'N' | 'T' | 'B' | 'R' | 'F' | '\\\\' | '\\'' ) ) )
            	    {
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:326:26: ( '\\\\' ( ( 'N' | 'T' | 'B' | 'R' | 'F' | '\\\\' | '\\'' ) ) )
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:326:28: '\\\\' ( ( 'N' | 'T' | 'B' | 'R' | 'F' | '\\\\' | '\\'' ) )
            	    {
            	    match('\\'); if (state.failed) return ;

            	    if ( input.LA(1)=='\''||input.LA(1)=='B'||input.LA(1)=='F'||input.LA(1)=='N'||input.LA(1)=='R'||input.LA(1)=='T'||input.LA(1)=='\\' ) {
            	        input.consume();
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:327:26: ( '\\\\U' ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) )
            	    {
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:327:26: ( '\\\\U' ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) )
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:327:28: '\\\\U' ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' )
            	    {
            	    match("\\U"); if (state.failed) return ;



            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F') ) {
            	        input.consume();
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F') ) {
            	        input.consume();
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F') ) {
            	        input.consume();
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F') ) {
            	        input.consume();
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            match('\''); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "QUOTEDSTRING"

    // $ANTLR start "MULTILINE_QUOTEDSTRING"
    public final void mMULTILINE_QUOTEDSTRING() throws RecognitionException {
        try {
            int _type = MULTILINE_QUOTEDSTRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:335:24: ( '\\'' ( (~ ( '\\'' | '\\\\' ) ) | ( '\\\\' ( ( 'N' | 'T' | 'B' | 'R' | 'F' | '\\\\' | '\\'' | 'n' | 'r' ) ) ) | ( '\\\\U' ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ) )* '\\'' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:335:27: '\\'' ( (~ ( '\\'' | '\\\\' ) ) | ( '\\\\' ( ( 'N' | 'T' | 'B' | 'R' | 'F' | '\\\\' | '\\'' | 'n' | 'r' ) ) ) | ( '\\\\U' ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ) )* '\\''
            {
            match('\''); if (state.failed) return ;

            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:335:32: ( (~ ( '\\'' | '\\\\' ) ) | ( '\\\\' ( ( 'N' | 'T' | 'B' | 'R' | 'F' | '\\\\' | '\\'' | 'n' | 'r' ) ) ) | ( '\\\\U' ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ) )*
            loop11:
            do {
                int alt11=4;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0 >= '\u0000' && LA11_0 <= '&')||(LA11_0 >= '(' && LA11_0 <= '[')||(LA11_0 >= ']' && LA11_0 <= '\uFFFF')) ) {
                    alt11=1;
                }
                else if ( (LA11_0=='\\') ) {
                    int LA11_3 = input.LA(2);

                    if ( (LA11_3=='\''||LA11_3=='B'||LA11_3=='F'||LA11_3=='N'||LA11_3=='R'||LA11_3=='T'||LA11_3=='\\'||LA11_3=='n'||LA11_3=='r') ) {
                        alt11=2;
                    }
                    else if ( (LA11_3=='U') ) {
                        alt11=3;
                    }


                }


                switch (alt11) {
            	case 1 :
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:335:36: (~ ( '\\'' | '\\\\' ) )
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '&')||(input.LA(1) >= '(' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;
            	case 2 :
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:336:36: ( '\\\\' ( ( 'N' | 'T' | 'B' | 'R' | 'F' | '\\\\' | '\\'' | 'n' | 'r' ) ) )
            	    {
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:336:36: ( '\\\\' ( ( 'N' | 'T' | 'B' | 'R' | 'F' | '\\\\' | '\\'' | 'n' | 'r' ) ) )
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:336:38: '\\\\' ( ( 'N' | 'T' | 'B' | 'R' | 'F' | '\\\\' | '\\'' | 'n' | 'r' ) )
            	    {
            	    match('\\'); if (state.failed) return ;

            	    if ( input.LA(1)=='\''||input.LA(1)=='B'||input.LA(1)=='F'||input.LA(1)=='N'||input.LA(1)=='R'||input.LA(1)=='T'||input.LA(1)=='\\'||input.LA(1)=='n'||input.LA(1)=='r' ) {
            	        input.consume();
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:337:36: ( '\\\\U' ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) )
            	    {
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:337:36: ( '\\\\U' ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) )
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:337:38: '\\\\U' ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' )
            	    {
            	    match("\\U"); if (state.failed) return ;



            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F') ) {
            	        input.consume();
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F') ) {
            	        input.consume();
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F') ) {
            	        input.consume();
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F') ) {
            	        input.consume();
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            match('\''); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MULTILINE_QUOTEDSTRING"

    // $ANTLR start "EXECCOMMAND"
    public final void mEXECCOMMAND() throws RecognitionException {
        try {
            int _type = EXECCOMMAND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:345:13: ( '`' (~ ( '`' ) )* '`' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:345:15: '`' (~ ( '`' ) )* '`'
            {
            match('`'); if (state.failed) return ;

            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:345:19: (~ ( '`' ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0 >= '\u0000' && LA12_0 <= '_')||(LA12_0 >= 'a' && LA12_0 <= '\uFFFF')) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '_')||(input.LA(1) >= 'a' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);


            match('`'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "EXECCOMMAND"

    // $ANTLR start "STAR"
    public final void mSTAR() throws RecognitionException {
        try {
            int _type = STAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:348:6: ( '*' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:348:8: '*'
            {
            match('*'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STAR"

    // $ANTLR start "COLON"
    public final void mCOLON() throws RecognitionException {
        try {
            int _type = COLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:351:7: ( ':' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:351:9: ':'
            {
            match(':'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COLON"

    // $ANTLR start "DOLLAR"
    public final void mDOLLAR() throws RecognitionException {
        try {
            int _type = DOLLAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:354:8: ( '$' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:354:10: '$'
            {
            match('$'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DOLLAR"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:357:5: ( ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:357:8: ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' )
            {
            if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||(input.LA(1) >= '\f' && input.LA(1) <= '\r')||input.LA(1)==' ' ) {
                input.consume();
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( state.backtracking==0 ) { _channel = HIDDEN; }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "SL_COMMENT"
    public final void mSL_COMMENT() throws RecognitionException {
        try {
            int _type = SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:360:12: ( '--' (~ ( '\\r' | '\\n' ) )* )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:360:14: '--' (~ ( '\\r' | '\\n' ) )*
            {
            match("--"); if (state.failed) return ;



            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:360:19: (~ ( '\\r' | '\\n' ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0 >= '\u0000' && LA13_0 <= '\t')||(LA13_0 >= '\u000B' && LA13_0 <= '\f')||(LA13_0 >= '\u000E' && LA13_0 <= '\uFFFF')) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);


            if ( state.backtracking==0 ) { _channel = HIDDEN; }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SL_COMMENT"

    // $ANTLR start "ML_COMMENT"
    public final void mML_COMMENT() throws RecognitionException {
        try {
            int _type = ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:363:12: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:363:14: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); if (state.failed) return ;



            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:363:19: ( options {greedy=false; } : . )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0=='*') ) {
                    int LA14_1 = input.LA(2);

                    if ( (LA14_1=='/') ) {
                        alt14=2;
                    }
                    else if ( ((LA14_1 >= '\u0000' && LA14_1 <= '.')||(LA14_1 >= '0' && LA14_1 <= '\uFFFF')) ) {
                        alt14=1;
                    }


                }
                else if ( ((LA14_0 >= '\u0000' && LA14_0 <= ')')||(LA14_0 >= '+' && LA14_0 <= '\uFFFF')) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:363:49: .
            	    {
            	    matchAny(); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);


            match("*/"); if (state.failed) return ;



            if ( state.backtracking==0 ) { _channel = HIDDEN; }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ML_COMMENT"

    // $ANTLR start "SEMI_COLON"
    public final void mSEMI_COLON() throws RecognitionException {
        try {
            int _type = SEMI_COLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:366:12: ( ';' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:366:14: ';'
            {
            match(';'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SEMI_COLON"

    // $ANTLR start "LEFT_PAREN"
    public final void mLEFT_PAREN() throws RecognitionException {
        try {
            int _type = LEFT_PAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:369:12: ( '(' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:369:14: '('
            {
            match('('); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LEFT_PAREN"

    // $ANTLR start "RIGHT_PAREN"
    public final void mRIGHT_PAREN() throws RecognitionException {
        try {
            int _type = RIGHT_PAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:372:13: ( ')' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:372:15: ')'
            {
            match(')'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RIGHT_PAREN"

    // $ANTLR start "LEFT_CURLY"
    public final void mLEFT_CURLY() throws RecognitionException {
        try {
            int _type = LEFT_CURLY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:375:12: ( '{' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:375:14: '{'
            {
            match('{'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LEFT_CURLY"

    // $ANTLR start "RIGHT_CURLY"
    public final void mRIGHT_CURLY() throws RecognitionException {
        try {
            int _type = RIGHT_CURLY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:378:13: ( '}' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:378:15: '}'
            {
            match('}'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RIGHT_CURLY"

    // $ANTLR start "LEFT_BRACKET"
    public final void mLEFT_BRACKET() throws RecognitionException {
        try {
            int _type = LEFT_BRACKET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:381:14: ( '[' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:381:16: '['
            {
            match('['); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LEFT_BRACKET"

    // $ANTLR start "RIGHT_BRACKET"
    public final void mRIGHT_BRACKET() throws RecognitionException {
        try {
            int _type = RIGHT_BRACKET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:384:15: ( ']' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:384:17: ']'
            {
            match(']'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RIGHT_BRACKET"

    // $ANTLR start "POUND"
    public final void mPOUND() throws RecognitionException {
        try {
            int _type = POUND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:387:7: ( '#' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:387:9: '#'
            {
            match('#'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "POUND"

    // $ANTLR start "EQUAL"
    public final void mEQUAL() throws RecognitionException {
        try {
            int _type = EQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:390:7: ( '=' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:390:9: '='
            {
            match('='); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "EQUAL"

    // $ANTLR start "COMMA"
    public final void mCOMMA() throws RecognitionException {
        try {
            int _type = COMMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:393:7: ( ',' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:393:9: ','
            {
            match(','); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COMMA"

    // $ANTLR start "PERIOD"
    public final void mPERIOD() throws RecognitionException {
        try {
            int _type = PERIOD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:396:8: ( '.' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:396:10: '.'
            {
            match('.'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PERIOD"

    // $ANTLR start "DOUBLE_PERIOD"
    public final void mDOUBLE_PERIOD() throws RecognitionException {
        try {
            int _type = DOUBLE_PERIOD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:399:15: ( '..' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:399:17: '..'
            {
            match(".."); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DOUBLE_PERIOD"

    // $ANTLR start "DIV"
    public final void mDIV() throws RecognitionException {
        try {
            int _type = DIV;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:402:5: ( '/' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:402:7: '/'
            {
            match('/'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DIV"

    // $ANTLR start "PERCENT"
    public final void mPERCENT() throws RecognitionException {
        try {
            int _type = PERCENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:405:9: ( '%' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:405:11: '%'
            {
            match('%'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PERCENT"

    // $ANTLR start "PLUS"
    public final void mPLUS() throws RecognitionException {
        try {
            int _type = PLUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:408:6: ( '+' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:408:8: '+'
            {
            match('+'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PLUS"

    // $ANTLR start "MINUS"
    public final void mMINUS() throws RecognitionException {
        try {
            int _type = MINUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:411:7: ( '-' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:411:9: '-'
            {
            match('-'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MINUS"

    // $ANTLR start "QMARK"
    public final void mQMARK() throws RecognitionException {
        try {
            int _type = QMARK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:414:7: ( '?' )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:414:9: '?'
            {
            match('?'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "QMARK"

    public void mTokens() throws RecognitionException {
        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:8: ( VOID | IMPORT | RETURNS | DEFINE | LOAD | FILTER | FOREACH | ORDER | DISTINCT | COGROUP | JOIN | CROSS | UNION | SPLIT | INTO | IF | OTHERWISE | ALL | AS | BY | USING | INNER | OUTER | ONSCHEMA | PARALLEL | PARTITION | GROUP | AND | OR | NOT | GENERATE | FLATTEN | ASC | DESC | BOOLEAN | INT | LONG | FLOAT | DOUBLE | CHARARRAY | BYTEARRAY | BAG | TUPLE | MAP | IS | STREAM | THROUGH | STORE | MAPREDUCE | SHIP | CACHE | INPUT | OUTPUT | STDERROR | STDIN | STDOUT | LIMIT | SAMPLE | LEFT | RIGHT | FULL | STR_OP_EQ | STR_OP_GT | STR_OP_LT | STR_OP_GTE | STR_OP_LTE | STR_OP_NE | STR_OP_MATCHES | TRUE | FALSE | NUM_OP_EQ | NUM_OP_LT | NUM_OP_LTE | NUM_OP_GT | NUM_OP_GTE | NUM_OP_NE | DCOLON | IDENTIFIER_L | INTEGER | LONGINTEGER | DOLLARVAR | DOUBLENUMBER | FLOATNUMBER | QUOTEDSTRING | MULTILINE_QUOTEDSTRING | EXECCOMMAND | STAR | COLON | DOLLAR | WS | SL_COMMENT | ML_COMMENT | SEMI_COLON | LEFT_PAREN | RIGHT_PAREN | LEFT_CURLY | RIGHT_CURLY | LEFT_BRACKET | RIGHT_BRACKET | POUND | EQUAL | COMMA | PERIOD | DOUBLE_PERIOD | DIV | PERCENT | PLUS | MINUS | QMARK )
        int alt15=109;
        alt15 = dfa15.predict(input);
        switch (alt15) {
            case 1 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:10: VOID
                {
                mVOID(); if (state.failed) return ;


                }
                break;
            case 2 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:15: IMPORT
                {
                mIMPORT(); if (state.failed) return ;


                }
                break;
            case 3 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:22: RETURNS
                {
                mRETURNS(); if (state.failed) return ;


                }
                break;
            case 4 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:30: DEFINE
                {
                mDEFINE(); if (state.failed) return ;


                }
                break;
            case 5 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:37: LOAD
                {
                mLOAD(); if (state.failed) return ;


                }
                break;
            case 6 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:42: FILTER
                {
                mFILTER(); if (state.failed) return ;


                }
                break;
            case 7 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:49: FOREACH
                {
                mFOREACH(); if (state.failed) return ;


                }
                break;
            case 8 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:57: ORDER
                {
                mORDER(); if (state.failed) return ;


                }
                break;
            case 9 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:63: DISTINCT
                {
                mDISTINCT(); if (state.failed) return ;


                }
                break;
            case 10 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:72: COGROUP
                {
                mCOGROUP(); if (state.failed) return ;


                }
                break;
            case 11 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:80: JOIN
                {
                mJOIN(); if (state.failed) return ;


                }
                break;
            case 12 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:85: CROSS
                {
                mCROSS(); if (state.failed) return ;


                }
                break;
            case 13 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:91: UNION
                {
                mUNION(); if (state.failed) return ;


                }
                break;
            case 14 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:97: SPLIT
                {
                mSPLIT(); if (state.failed) return ;


                }
                break;
            case 15 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:103: INTO
                {
                mINTO(); if (state.failed) return ;


                }
                break;
            case 16 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:108: IF
                {
                mIF(); if (state.failed) return ;


                }
                break;
            case 17 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:111: OTHERWISE
                {
                mOTHERWISE(); if (state.failed) return ;


                }
                break;
            case 18 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:121: ALL
                {
                mALL(); if (state.failed) return ;


                }
                break;
            case 19 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:125: AS
                {
                mAS(); if (state.failed) return ;


                }
                break;
            case 20 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:128: BY
                {
                mBY(); if (state.failed) return ;


                }
                break;
            case 21 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:131: USING
                {
                mUSING(); if (state.failed) return ;


                }
                break;
            case 22 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:137: INNER
                {
                mINNER(); if (state.failed) return ;


                }
                break;
            case 23 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:143: OUTER
                {
                mOUTER(); if (state.failed) return ;


                }
                break;
            case 24 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:149: ONSCHEMA
                {
                mONSCHEMA(); if (state.failed) return ;


                }
                break;
            case 25 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:158: PARALLEL
                {
                mPARALLEL(); if (state.failed) return ;


                }
                break;
            case 26 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:167: PARTITION
                {
                mPARTITION(); if (state.failed) return ;


                }
                break;
            case 27 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:177: GROUP
                {
                mGROUP(); if (state.failed) return ;


                }
                break;
            case 28 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:183: AND
                {
                mAND(); if (state.failed) return ;


                }
                break;
            case 29 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:187: OR
                {
                mOR(); if (state.failed) return ;


                }
                break;
            case 30 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:190: NOT
                {
                mNOT(); if (state.failed) return ;


                }
                break;
            case 31 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:194: GENERATE
                {
                mGENERATE(); if (state.failed) return ;


                }
                break;
            case 32 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:203: FLATTEN
                {
                mFLATTEN(); if (state.failed) return ;


                }
                break;
            case 33 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:211: ASC
                {
                mASC(); if (state.failed) return ;


                }
                break;
            case 34 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:215: DESC
                {
                mDESC(); if (state.failed) return ;


                }
                break;
            case 35 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:220: BOOLEAN
                {
                mBOOLEAN(); if (state.failed) return ;


                }
                break;
            case 36 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:228: INT
                {
                mINT(); if (state.failed) return ;


                }
                break;
            case 37 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:232: LONG
                {
                mLONG(); if (state.failed) return ;


                }
                break;
            case 38 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:237: FLOAT
                {
                mFLOAT(); if (state.failed) return ;


                }
                break;
            case 39 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:243: DOUBLE
                {
                mDOUBLE(); if (state.failed) return ;


                }
                break;
            case 40 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:250: CHARARRAY
                {
                mCHARARRAY(); if (state.failed) return ;


                }
                break;
            case 41 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:260: BYTEARRAY
                {
                mBYTEARRAY(); if (state.failed) return ;


                }
                break;
            case 42 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:270: BAG
                {
                mBAG(); if (state.failed) return ;


                }
                break;
            case 43 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:274: TUPLE
                {
                mTUPLE(); if (state.failed) return ;


                }
                break;
            case 44 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:280: MAP
                {
                mMAP(); if (state.failed) return ;


                }
                break;
            case 45 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:284: IS
                {
                mIS(); if (state.failed) return ;


                }
                break;
            case 46 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:287: STREAM
                {
                mSTREAM(); if (state.failed) return ;


                }
                break;
            case 47 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:294: THROUGH
                {
                mTHROUGH(); if (state.failed) return ;


                }
                break;
            case 48 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:302: STORE
                {
                mSTORE(); if (state.failed) return ;


                }
                break;
            case 49 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:308: MAPREDUCE
                {
                mMAPREDUCE(); if (state.failed) return ;


                }
                break;
            case 50 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:318: SHIP
                {
                mSHIP(); if (state.failed) return ;


                }
                break;
            case 51 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:323: CACHE
                {
                mCACHE(); if (state.failed) return ;


                }
                break;
            case 52 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:329: INPUT
                {
                mINPUT(); if (state.failed) return ;


                }
                break;
            case 53 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:335: OUTPUT
                {
                mOUTPUT(); if (state.failed) return ;


                }
                break;
            case 54 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:342: STDERROR
                {
                mSTDERROR(); if (state.failed) return ;


                }
                break;
            case 55 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:351: STDIN
                {
                mSTDIN(); if (state.failed) return ;


                }
                break;
            case 56 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:357: STDOUT
                {
                mSTDOUT(); if (state.failed) return ;


                }
                break;
            case 57 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:364: LIMIT
                {
                mLIMIT(); if (state.failed) return ;


                }
                break;
            case 58 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:370: SAMPLE
                {
                mSAMPLE(); if (state.failed) return ;


                }
                break;
            case 59 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:377: LEFT
                {
                mLEFT(); if (state.failed) return ;


                }
                break;
            case 60 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:382: RIGHT
                {
                mRIGHT(); if (state.failed) return ;


                }
                break;
            case 61 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:388: FULL
                {
                mFULL(); if (state.failed) return ;


                }
                break;
            case 62 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:393: STR_OP_EQ
                {
                mSTR_OP_EQ(); if (state.failed) return ;


                }
                break;
            case 63 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:403: STR_OP_GT
                {
                mSTR_OP_GT(); if (state.failed) return ;


                }
                break;
            case 64 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:413: STR_OP_LT
                {
                mSTR_OP_LT(); if (state.failed) return ;


                }
                break;
            case 65 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:423: STR_OP_GTE
                {
                mSTR_OP_GTE(); if (state.failed) return ;


                }
                break;
            case 66 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:434: STR_OP_LTE
                {
                mSTR_OP_LTE(); if (state.failed) return ;


                }
                break;
            case 67 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:445: STR_OP_NE
                {
                mSTR_OP_NE(); if (state.failed) return ;


                }
                break;
            case 68 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:455: STR_OP_MATCHES
                {
                mSTR_OP_MATCHES(); if (state.failed) return ;


                }
                break;
            case 69 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:470: TRUE
                {
                mTRUE(); if (state.failed) return ;


                }
                break;
            case 70 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:475: FALSE
                {
                mFALSE(); if (state.failed) return ;


                }
                break;
            case 71 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:481: NUM_OP_EQ
                {
                mNUM_OP_EQ(); if (state.failed) return ;


                }
                break;
            case 72 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:491: NUM_OP_LT
                {
                mNUM_OP_LT(); if (state.failed) return ;


                }
                break;
            case 73 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:501: NUM_OP_LTE
                {
                mNUM_OP_LTE(); if (state.failed) return ;


                }
                break;
            case 74 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:512: NUM_OP_GT
                {
                mNUM_OP_GT(); if (state.failed) return ;


                }
                break;
            case 75 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:522: NUM_OP_GTE
                {
                mNUM_OP_GTE(); if (state.failed) return ;


                }
                break;
            case 76 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:533: NUM_OP_NE
                {
                mNUM_OP_NE(); if (state.failed) return ;


                }
                break;
            case 77 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:543: DCOLON
                {
                mDCOLON(); if (state.failed) return ;


                }
                break;
            case 78 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:550: IDENTIFIER_L
                {
                mIDENTIFIER_L(); if (state.failed) return ;


                }
                break;
            case 79 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:563: INTEGER
                {
                mINTEGER(); if (state.failed) return ;


                }
                break;
            case 80 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:571: LONGINTEGER
                {
                mLONGINTEGER(); if (state.failed) return ;


                }
                break;
            case 81 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:583: DOLLARVAR
                {
                mDOLLARVAR(); if (state.failed) return ;


                }
                break;
            case 82 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:593: DOUBLENUMBER
                {
                mDOUBLENUMBER(); if (state.failed) return ;


                }
                break;
            case 83 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:606: FLOATNUMBER
                {
                mFLOATNUMBER(); if (state.failed) return ;


                }
                break;
            case 84 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:618: QUOTEDSTRING
                {
                mQUOTEDSTRING(); if (state.failed) return ;


                }
                break;
            case 85 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:631: MULTILINE_QUOTEDSTRING
                {
                mMULTILINE_QUOTEDSTRING(); if (state.failed) return ;


                }
                break;
            case 86 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:654: EXECCOMMAND
                {
                mEXECCOMMAND(); if (state.failed) return ;


                }
                break;
            case 87 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:666: STAR
                {
                mSTAR(); if (state.failed) return ;


                }
                break;
            case 88 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:671: COLON
                {
                mCOLON(); if (state.failed) return ;


                }
                break;
            case 89 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:677: DOLLAR
                {
                mDOLLAR(); if (state.failed) return ;


                }
                break;
            case 90 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:684: WS
                {
                mWS(); if (state.failed) return ;


                }
                break;
            case 91 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:687: SL_COMMENT
                {
                mSL_COMMENT(); if (state.failed) return ;


                }
                break;
            case 92 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:698: ML_COMMENT
                {
                mML_COMMENT(); if (state.failed) return ;


                }
                break;
            case 93 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:709: SEMI_COLON
                {
                mSEMI_COLON(); if (state.failed) return ;


                }
                break;
            case 94 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:720: LEFT_PAREN
                {
                mLEFT_PAREN(); if (state.failed) return ;


                }
                break;
            case 95 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:731: RIGHT_PAREN
                {
                mRIGHT_PAREN(); if (state.failed) return ;


                }
                break;
            case 96 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:743: LEFT_CURLY
                {
                mLEFT_CURLY(); if (state.failed) return ;


                }
                break;
            case 97 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:754: RIGHT_CURLY
                {
                mRIGHT_CURLY(); if (state.failed) return ;


                }
                break;
            case 98 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:766: LEFT_BRACKET
                {
                mLEFT_BRACKET(); if (state.failed) return ;


                }
                break;
            case 99 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:779: RIGHT_BRACKET
                {
                mRIGHT_BRACKET(); if (state.failed) return ;


                }
                break;
            case 100 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:793: POUND
                {
                mPOUND(); if (state.failed) return ;


                }
                break;
            case 101 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:799: EQUAL
                {
                mEQUAL(); if (state.failed) return ;


                }
                break;
            case 102 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:805: COMMA
                {
                mCOMMA(); if (state.failed) return ;


                }
                break;
            case 103 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:811: PERIOD
                {
                mPERIOD(); if (state.failed) return ;


                }
                break;
            case 104 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:818: DOUBLE_PERIOD
                {
                mDOUBLE_PERIOD(); if (state.failed) return ;


                }
                break;
            case 105 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:832: DIV
                {
                mDIV(); if (state.failed) return ;


                }
                break;
            case 106 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:836: PERCENT
                {
                mPERCENT(); if (state.failed) return ;


                }
                break;
            case 107 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:844: PLUS
                {
                mPLUS(); if (state.failed) return ;


                }
                break;
            case 108 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:849: MINUS
                {
                mMINUS(); if (state.failed) return ;


                }
                break;
            case 109 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:1:855: QMARK
                {
                mQMARK(); if (state.failed) return ;


                }
                break;

        }

    }

    // $ANTLR start synpred1_QueryLexer
    public final void synpred1_QueryLexer_fragment() throws RecognitionException {
        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:303:16: ( ID DCOLON )
        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/QueryLexer.g:303:18: ID DCOLON
        {
        mID(); if (state.failed) return ;


        mDCOLON(); if (state.failed) return ;


        }

    }
    // $ANTLR end synpred1_QueryLexer

    public final boolean synpred1_QueryLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_QueryLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA2 dfa2 = new DFA2(this);
    protected DFA15 dfa15 = new DFA15(this);
    static final String DFA2_eotS =
        "\1\uffff\1\2\1\uffff\1\2\1\uffff";
    static final String DFA2_eofS =
        "\5\uffff";
    static final String DFA2_minS =
        "\1\101\1\60\1\uffff\1\60\1\uffff";
    static final String DFA2_maxS =
        "\1\132\1\137\1\uffff\1\137\1\uffff";
    static final String DFA2_acceptS =
        "\2\uffff\1\2\1\uffff\1\1";
    static final String DFA2_specialS =
        "\1\uffff\1\0\1\uffff\1\1\1\uffff}>";
    static final String[] DFA2_transitionS = {
            "\32\1",
            "\12\3\1\4\6\uffff\32\3\4\uffff\1\3",
            "",
            "\12\3\1\4\6\uffff\32\3\4\uffff\1\3",
            ""
    };

    static final short[] DFA2_eot = DFA.unpackEncodedString(DFA2_eotS);
    static final short[] DFA2_eof = DFA.unpackEncodedString(DFA2_eofS);
    static final char[] DFA2_min = DFA.unpackEncodedStringToUnsignedChars(DFA2_minS);
    static final char[] DFA2_max = DFA.unpackEncodedStringToUnsignedChars(DFA2_maxS);
    static final short[] DFA2_accept = DFA.unpackEncodedString(DFA2_acceptS);
    static final short[] DFA2_special = DFA.unpackEncodedString(DFA2_specialS);
    static final short[][] DFA2_transition;

    static {
        int numStates = DFA2_transitionS.length;
        DFA2_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA2_transition[i] = DFA.unpackEncodedString(DFA2_transitionS[i]);
        }
    }

    class DFA2 extends DFA {

        public DFA2(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 2;
            this.eot = DFA2_eot;
            this.eof = DFA2_eof;
            this.min = DFA2_min;
            this.max = DFA2_max;
            this.accept = DFA2_accept;
            this.special = DFA2_special;
            this.transition = DFA2_transition;
        }
        public String getDescription() {
            return "303:1: IDENTIFIER_L : ( ( ID DCOLON )=> ( ID DCOLON IDENTIFIER_L ) | ID );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA2_1 = input.LA(1);

                         
                        int index2_1 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA2_1 >= '0' && LA2_1 <= '9')||(LA2_1 >= 'A' && LA2_1 <= 'Z')||LA2_1=='_') ) {s = 3;}

                        else if ( (LA2_1==':') && (synpred1_QueryLexer())) {s = 4;}

                        else s = 2;

                         
                        input.seek(index2_1);

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA2_3 = input.LA(1);

                         
                        int index2_3 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA2_3==':') && (synpred1_QueryLexer())) {s = 4;}

                        else if ( ((LA2_3 >= '0' && LA2_3 <= '9')||(LA2_3 >= 'A' && LA2_3 <= 'Z')||LA2_3=='_') ) {s = 3;}

                        else s = 2;

                         
                        input.seek(index2_3);

                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}

            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 2, _s, input);
            error(nvae);
            throw nvae;
        }

    }
    static final String DFA15_eotS =
        "\1\uffff\23\31\1\143\1\145\1\147\1\uffff\1\151\1\uffff\1\152\1\157"+
        "\1\162\4\uffff\1\171\1\173\14\uffff\3\31\1\u0081\1\u0082\10\31\1"+
        "\u008e\5\31\1\u0096\17\31\1\u00a9\1\31\1\u00ac\5\31\1\u00b3\6\31"+
        "\1\u00bb\21\uffff\1\u00bf\10\uffff\2\31\1\u00c6\2\31\2\uffff\12"+
        "\31\1\u00d3\1\uffff\7\31\1\uffff\20\31\1\u00ee\1\u00ef\1\uffff\1"+
        "\u00f0\1\31\1\uffff\1\31\1\u00f3\3\31\1\u00f8\1\uffff\1\u00f9\1"+
        "\u00fa\3\31\1\u00ff\1\31\1\uffff\1\u00bf\1\uffff\1\u00bf\4\uffff"+
        "\1\u0102\1\31\1\u0104\1\uffff\5\31\1\u010a\2\31\1\u010d\1\u010e"+
        "\1\31\1\u0110\1\uffff\4\31\1\u0115\12\31\1\u0120\10\31\1\u0129\1"+
        "\31\3\uffff\2\31\1\uffff\4\31\3\uffff\2\31\1\u0133\1\31\1\uffff"+
        "\1\31\2\uffff\1\31\1\uffff\1\u0138\1\u0139\1\31\1\u013b\1\31\1\uffff"+
        "\2\31\2\uffff\1\u013f\1\uffff\3\31\1\u0143\1\uffff\1\u0144\1\u0145"+
        "\1\31\1\u0147\3\31\1\u014b\1\31\1\u014d\1\uffff\1\u014e\1\u014f"+
        "\1\u0150\1\31\1\u0152\1\31\1\u0154\1\31\1\uffff\5\31\1\u015b\1\31"+
        "\1\u015d\1\31\1\uffff\2\31\1\uffff\1\u0162\2\uffff\1\31\1\uffff"+
        "\1\u0164\1\31\1\u0166\1\uffff\1\u0167\2\31\3\uffff\1\31\1\uffff"+
        "\1\u016b\2\31\1\uffff\1\31\4\uffff\1\u016f\1\uffff\1\u0170\1\uffff"+
        "\1\u0171\1\u0172\4\31\1\uffff\1\31\1\uffff\3\31\2\uffff\1\u017c"+
        "\1\uffff\1\31\2\uffff\1\u017e\1\u017f\1\31\1\uffff\1\31\1\u0182"+
        "\1\31\4\uffff\1\31\1\u0185\3\31\1\u0189\1\31\1\u018b\2\uffff\1\u018c"+
        "\2\uffff\1\31\1\u018e\1\uffff\2\31\1\uffff\1\u0191\1\31\1\u0193"+
        "\1\uffff\1\31\2\uffff\1\u0195\1\uffff\1\u0196\1\u0197\1\uffff\1"+
        "\u0198\1\uffff\1\u0199\5\uffff";
    static final String DFA15_eofS =
        "\u019a\uffff";
    static final String DFA15_minS =
        "\1\11\1\117\1\106\3\105\1\101\1\116\1\101\1\117\1\116\1\101\1\114"+
        "\2\101\2\105\1\110\1\101\1\121\3\75\1\uffff\1\72\1\uffff\1\56\1"+
        "\60\1\56\1\0\3\uffff\1\55\1\52\14\uffff\1\111\1\120\1\116\2\60\1"+
        "\124\1\107\1\106\1\123\1\125\1\101\1\115\1\106\1\60\1\114\1\122"+
        "\1\101\2\114\1\60\1\110\1\124\1\123\1\107\1\117\1\101\1\103\3\111"+
        "\1\114\1\104\1\111\1\115\1\114\1\60\1\104\1\60\1\117\1\107\1\122"+
        "\1\117\1\116\1\60\1\124\1\121\1\120\1\122\1\125\1\120\1\60\12\uffff"+
        "\1\60\1\53\5\uffff\1\60\1\0\1\47\6\uffff\1\104\1\117\1\60\1\105"+
        "\1\125\2\uffff\1\125\1\110\1\111\1\103\1\124\1\102\1\104\1\107\1"+
        "\111\1\124\1\60\1\uffff\1\124\1\105\1\124\1\101\1\114\1\123\1\105"+
        "\1\uffff\2\105\1\103\1\122\1\123\1\122\1\110\1\116\1\117\1\116\1"+
        "\111\1\105\1\122\1\105\2\120\2\60\1\uffff\1\60\1\105\1\uffff\1\114"+
        "\1\60\1\101\1\125\1\105\1\60\1\uffff\2\60\1\114\1\117\1\105\1\60"+
        "\1\103\1\uffff\3\60\1\uffff\1\0\1\60\1\uffff\1\60\1\122\1\60\1\uffff"+
        "\1\122\1\124\1\122\1\124\1\116\1\60\1\111\1\114\2\60\1\124\1\60"+
        "\1\uffff\1\105\1\101\2\124\1\60\1\105\3\122\1\125\1\110\1\117\1"+
        "\123\1\101\1\105\1\60\1\116\1\107\1\124\1\101\1\105\1\122\1\116"+
        "\1\125\1\60\1\114\3\uffff\1\101\1\105\1\uffff\1\114\1\111\1\120"+
        "\1\122\3\uffff\1\105\1\125\1\60\1\105\1\uffff\1\110\1\60\1\uffff"+
        "\1\124\1\uffff\2\60\1\116\1\60\1\105\1\uffff\1\116\1\105\2\uffff"+
        "\1\60\1\uffff\1\122\1\103\1\105\1\60\1\uffff\2\60\1\127\1\60\1\124"+
        "\1\105\1\125\1\60\1\122\1\60\1\uffff\3\60\1\115\1\60\1\122\1\60"+
        "\1\124\1\uffff\1\105\1\122\1\101\1\114\1\124\1\60\1\101\1\60\1\107"+
        "\1\uffff\1\104\1\105\2\60\2\uffff\1\123\1\uffff\1\60\1\103\1\60"+
        "\1\uffff\1\60\1\110\1\116\3\uffff\1\111\1\uffff\1\60\1\115\1\120"+
        "\1\uffff\1\122\4\uffff\1\60\1\uffff\1\60\1\uffff\2\60\1\122\1\116"+
        "\1\105\1\111\1\uffff\1\124\1\uffff\1\110\1\125\1\123\1\60\1\uffff"+
        "\1\60\1\uffff\1\124\2\uffff\2\60\1\123\1\uffff\1\101\1\60\1\101"+
        "\4\uffff\1\101\1\60\1\114\1\117\1\105\1\60\1\103\1\60\1\0\1\uffff"+
        "\1\60\2\uffff\1\105\1\60\1\uffff\2\131\1\uffff\1\60\1\116\1\60\1"+
        "\uffff\1\105\2\uffff\1\60\1\uffff\2\60\1\uffff\1\60\1\uffff\1\60"+
        "\5\uffff";
    static final String DFA15_maxS =
        "\1\175\1\117\1\123\1\111\1\117\1\124\2\125\1\122\1\117\1\123\1\124"+
        "\1\123\1\131\1\101\1\124\1\117\1\125\1\101\1\121\3\75\1\uffff\1"+
        "\72\1\uffff\1\114\2\71\1\uffff\3\uffff\1\55\1\52\14\uffff\1\111"+
        "\1\120\1\124\2\137\1\124\1\107\2\123\1\125\1\116\1\115\1\106\1\137"+
        "\1\114\1\122\1\117\2\114\1\137\1\110\1\124\1\123\1\107\1\117\1\101"+
        "\1\103\3\111\1\114\1\122\1\111\1\115\1\114\1\137\1\104\1\137\1\117"+
        "\1\107\1\122\1\117\1\116\1\137\1\124\1\121\1\120\1\122\1\125\1\124"+
        "\1\137\12\uffff\2\71\5\uffff\1\106\1\uffff\1\162\6\uffff\1\104\1"+
        "\117\1\137\1\105\1\125\2\uffff\1\125\1\110\1\111\1\103\1\124\1\102"+
        "\1\104\1\107\1\111\1\124\1\137\1\uffff\1\124\1\105\1\124\1\101\1"+
        "\114\1\123\1\105\1\uffff\1\105\1\120\1\103\1\122\1\123\1\122\1\110"+
        "\1\116\1\117\1\116\1\111\1\105\1\122\1\117\2\120\2\137\1\uffff\1"+
        "\137\1\105\1\uffff\1\114\1\137\1\124\1\125\1\105\1\137\1\uffff\2"+
        "\137\1\114\1\117\1\105\1\137\1\103\1\uffff\1\106\1\71\1\106\1\uffff"+
        "\1\uffff\1\106\1\uffff\1\137\1\122\1\137\1\uffff\1\122\1\124\1\122"+
        "\1\124\1\116\1\137\1\111\1\114\2\137\1\124\1\137\1\uffff\1\105\1"+
        "\101\2\124\1\137\1\105\3\122\1\125\1\110\1\117\1\123\1\101\1\105"+
        "\1\137\1\116\1\107\1\124\1\101\1\105\1\122\1\116\1\125\1\137\1\114"+
        "\3\uffff\1\101\1\105\1\uffff\1\114\1\111\1\120\1\122\3\uffff\1\105"+
        "\1\125\1\137\1\105\1\uffff\1\110\1\106\1\uffff\1\124\1\uffff\2\137"+
        "\1\116\1\137\1\105\1\uffff\1\116\1\105\2\uffff\1\137\1\uffff\1\122"+
        "\1\103\1\105\1\137\1\uffff\2\137\1\127\1\137\1\124\1\105\1\125\1"+
        "\137\1\122\1\137\1\uffff\3\137\1\115\1\137\1\122\1\137\1\124\1\uffff"+
        "\1\105\1\122\1\101\1\114\1\124\1\137\1\101\1\137\1\107\1\uffff\1"+
        "\104\1\105\1\106\1\137\2\uffff\1\123\1\uffff\1\137\1\103\1\137\1"+
        "\uffff\1\137\1\110\1\116\3\uffff\1\111\1\uffff\1\137\1\115\1\120"+
        "\1\uffff\1\122\4\uffff\1\137\1\uffff\1\137\1\uffff\2\137\1\122\1"+
        "\116\1\105\1\111\1\uffff\1\124\1\uffff\1\110\1\125\1\123\1\106\1"+
        "\uffff\1\137\1\uffff\1\124\2\uffff\2\137\1\123\1\uffff\1\101\1\137"+
        "\1\101\4\uffff\1\101\1\137\1\114\1\117\1\105\1\137\1\103\1\137\1"+
        "\uffff\1\uffff\1\137\2\uffff\1\105\1\137\1\uffff\2\131\1\uffff\1"+
        "\137\1\116\1\137\1\uffff\1\105\2\uffff\1\137\1\uffff\2\137\1\uffff"+
        "\1\137\1\uffff\1\137\5\uffff";
    static final String DFA15_acceptS =
        "\27\uffff\1\114\1\uffff\1\116\4\uffff\1\126\1\127\1\132\2\uffff"+
        "\1\135\1\136\1\137\1\140\1\141\1\142\1\143\1\144\1\146\1\152\1\153"+
        "\1\155\63\uffff\1\107\1\145\1\111\1\110\1\113\1\112\1\115\1\130"+
        "\1\117\1\120\2\uffff\1\123\1\131\1\121\1\150\1\147\3\uffff\1\124"+
        "\1\125\1\133\1\154\1\134\1\151\5\uffff\1\20\1\55\13\uffff\1\100"+
        "\7\uffff\1\35\22\uffff\1\23\2\uffff\1\24\6\uffff\1\77\7\uffff\1"+
        "\76\3\uffff\1\122\2\uffff\1\124\3\uffff\1\44\14\uffff\1\102\32\uffff"+
        "\1\22\1\41\1\34\2\uffff\1\52\4\uffff\1\101\1\36\1\103\4\uffff\1"+
        "\54\2\uffff\1\1\1\uffff\1\17\5\uffff\1\42\2\uffff\1\5\1\45\1\uffff"+
        "\1\73\4\uffff\1\75\12\uffff\1\13\10\uffff\1\62\11\uffff\1\105\4"+
        "\uffff\1\26\1\64\1\uffff\1\74\3\uffff\1\71\3\uffff\1\46\1\106\1"+
        "\10\1\uffff\1\27\3\uffff\1\14\1\uffff\1\63\1\15\1\25\1\16\1\uffff"+
        "\1\60\1\uffff\1\67\6\uffff\1\33\1\uffff\1\53\4\uffff\1\2\1\uffff"+
        "\1\4\1\uffff\1\47\1\6\3\uffff\1\65\3\uffff\1\56\1\66\1\70\1\72\11"+
        "\uffff\1\3\1\uffff\1\7\1\40\2\uffff\1\12\2\uffff\1\43\3\uffff\1"+
        "\57\1\uffff\1\104\1\11\1\uffff\1\30\2\uffff\1\31\1\uffff\1\37\1"+
        "\uffff\1\21\1\50\1\51\1\32\1\61";
    static final String DFA15_specialS =
        "\35\uffff\1\1\126\uffff\1\3\113\uffff\1\2\u00ba\uffff\1\0\36\uffff}>";
    static final String[] DFA15_transitionS = {
            "\2\40\1\uffff\2\40\22\uffff\1\40\1\27\1\uffff\1\52\1\33\1\54"+
            "\1\uffff\1\35\1\44\1\45\1\37\1\55\1\53\1\41\1\34\1\42\12\32"+
            "\1\30\1\43\1\25\1\24\1\26\1\56\1\uffff\1\14\1\15\1\10\1\4\1"+
            "\23\1\6\1\17\1\31\1\2\1\11\1\31\1\5\1\22\1\20\1\7\1\16\1\31"+
            "\1\3\1\13\1\21\1\12\1\1\4\31\1\50\1\uffff\1\51\2\uffff\1\36"+
            "\32\uffff\1\46\1\uffff\1\47",
            "\1\57",
            "\1\62\6\uffff\1\60\1\61\4\uffff\1\63",
            "\1\64\3\uffff\1\65",
            "\1\66\3\uffff\1\67\5\uffff\1\70",
            "\1\73\3\uffff\1\72\5\uffff\1\71\4\uffff\1\74",
            "\1\101\7\uffff\1\75\2\uffff\1\77\2\uffff\1\76\5\uffff\1\100",
            "\1\105\3\uffff\1\102\1\uffff\1\103\1\104",
            "\1\111\6\uffff\1\110\6\uffff\1\106\2\uffff\1\107",
            "\1\112",
            "\1\113\4\uffff\1\114",
            "\1\120\6\uffff\1\117\7\uffff\1\115\3\uffff\1\116",
            "\1\121\1\uffff\1\123\4\uffff\1\122",
            "\1\126\15\uffff\1\125\11\uffff\1\124",
            "\1\127",
            "\1\131\14\uffff\1\130\1\uffff\1\132",
            "\1\134\11\uffff\1\133",
            "\1\136\11\uffff\1\137\2\uffff\1\135",
            "\1\140",
            "\1\141",
            "\1\142",
            "\1\144",
            "\1\146",
            "",
            "\1\150",
            "",
            "\1\154\1\uffff\12\32\13\uffff\1\155\1\156\5\uffff\1\153",
            "\12\160",
            "\1\161\1\uffff\12\163",
            "\12\164\1\167\2\164\1\167\31\164\1\166\64\164\1\165\uffa3\164",
            "",
            "",
            "",
            "\1\170",
            "\1\172",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\174",
            "\1\175",
            "\1\177\1\uffff\1\u0080\3\uffff\1\176",
            "\13\31\6\uffff\32\31\4\uffff\1\31",
            "\13\31\6\uffff\32\31\4\uffff\1\31",
            "\1\u0083",
            "\1\u0084",
            "\1\u0085\14\uffff\1\u0086",
            "\1\u0087",
            "\1\u0088",
            "\1\u0089\14\uffff\1\u008a",
            "\1\u008b",
            "\1\u008c",
            "\13\31\6\uffff\4\31\1\u008d\25\31\4\uffff\1\31",
            "\1\u008f",
            "\1\u0090",
            "\1\u0091\15\uffff\1\u0092",
            "\1\u0093",
            "\1\u0094",
            "\13\31\6\uffff\3\31\1\u0095\26\31\4\uffff\1\31",
            "\1\u0097",
            "\1\u0098",
            "\1\u0099",
            "\1\u009a",
            "\1\u009b",
            "\1\u009c",
            "\1\u009d",
            "\1\u009e",
            "\1\u009f",
            "\1\u00a0",
            "\1\u00a1",
            "\1\u00a4\12\uffff\1\u00a3\2\uffff\1\u00a2",
            "\1\u00a5",
            "\1\u00a6",
            "\1\u00a7",
            "\13\31\6\uffff\2\31\1\u00a8\27\31\4\uffff\1\31",
            "\1\u00aa",
            "\13\31\6\uffff\23\31\1\u00ab\6\31\4\uffff\1\31",
            "\1\u00ad",
            "\1\u00ae",
            "\1\u00af",
            "\1\u00b0",
            "\1\u00b1",
            "\13\31\6\uffff\4\31\1\u00b2\25\31\4\uffff\1\31",
            "\1\u00b4",
            "\1\u00b5",
            "\1\u00b6",
            "\1\u00b7",
            "\1\u00b8",
            "\1\u00b9\3\uffff\1\u00ba",
            "\13\31\6\uffff\32\31\4\uffff\1\31",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\12\u00bc",
            "\1\u00bd\1\uffff\1\u00bd\2\uffff\12\u00be",
            "",
            "",
            "",
            "",
            "",
            "\12\163\13\uffff\1\155\1\156",
            "\12\164\1\167\2\164\1\167\31\164\1\166\64\164\1\165\uffa3\164",
            "\1\u00c0\32\uffff\1\u00c0\3\uffff\1\u00c0\7\uffff\1\u00c0\3"+
            "\uffff\1\u00c0\1\uffff\1\u00c0\1\u00c1\6\uffff\1\u00c0\21\uffff"+
            "\1\167\3\uffff\1\167",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u00c3",
            "\1\u00c4",
            "\13\31\6\uffff\16\31\1\u00c5\13\31\4\uffff\1\31",
            "\1\u00c7",
            "\1\u00c8",
            "",
            "",
            "\1\u00c9",
            "\1\u00ca",
            "\1\u00cb",
            "\1\u00cc",
            "\1\u00cd",
            "\1\u00ce",
            "\1\u00cf",
            "\1\u00d0",
            "\1\u00d1",
            "\1\u00d2",
            "\13\31\6\uffff\32\31\4\uffff\1\31",
            "",
            "\1\u00d4",
            "\1\u00d5",
            "\1\u00d6",
            "\1\u00d7",
            "\1\u00d8",
            "\1\u00d9",
            "\1\u00da",
            "",
            "\1\u00db",
            "\1\u00dc\12\uffff\1\u00dd",
            "\1\u00de",
            "\1\u00df",
            "\1\u00e0",
            "\1\u00e1",
            "\1\u00e2",
            "\1\u00e3",
            "\1\u00e4",
            "\1\u00e5",
            "\1\u00e6",
            "\1\u00e7",
            "\1\u00e8",
            "\1\u00e9\3\uffff\1\u00ea\5\uffff\1\u00eb",
            "\1\u00ec",
            "\1\u00ed",
            "\13\31\6\uffff\32\31\4\uffff\1\31",
            "\13\31\6\uffff\32\31\4\uffff\1\31",
            "",
            "\13\31\6\uffff\32\31\4\uffff\1\31",
            "\1\u00f1",
            "",
            "\1\u00f2",
            "\13\31\6\uffff\32\31\4\uffff\1\31",
            "\1\u00f4\22\uffff\1\u00f5",
            "\1\u00f6",
            "\1\u00f7",
            "\13\31\6\uffff\32\31\4\uffff\1\31",
            "",
            "\13\31\6\uffff\32\31\4\uffff\1\31",
            "\13\31\6\uffff\32\31\4\uffff\1\31",
            "\1\u00fb",
            "\1\u00fc",
            "\1\u00fd",
            "\13\31\6\uffff\21\31\1\u00fe\10\31\4\uffff\1\31",
            "\1\u0100",
            "",
            "\12\u00bc\13\uffff\1\155\1\156",
            "\12\u00be",
            "\12\u00be\14\uffff\1\156",
            "",
            "\12\164\1\167\2\164\1\167\31\164\1\166\64\164\1\165\uffa3\164",
            "\12\u0101\7\uffff\6\u0101",
            "",
            "\13\31\6\uffff\32\31\4\uffff\1\31",
            "\1\u0103",
            "\13\31\6\uffff\32\31\4\uffff\1\31",
            "",
            "\1\u0105",
            "\1\u0106",
            "\1\u0107",
            "\1\u0108",
            "\1\u0109",
            "\13\31\6\uffff\32\31\4\uffff\1\31",
            "\1\u010b",
            "\1\u010c",
            "\13\31\6\uffff\32\31\4\uffff\1\31",
            "\13\31\6\uffff\32\31\4\uffff\1\31",
            "\1\u010f",
            "\13\31\6\uffff\32\31\4\uffff\1\31",
            "",
            "\1\u0111",
            "\1\u0112",
            "\1\u0113",
            "\1\u0114",
            "\13\31\6\uffff\32\31\4\uffff\1\31",
            "\1\u0116",
            "\1\u0117",
            "\1\u0118",
            "\1\u0119",
            "\1\u011a",
            "\1\u011b",
            "\1\u011c",
            "\1\u011d",
            "\1\u011e",
            "\1\u011f",
            "\13\31\6\uffff\32\31\4\uffff\1\31",
            "\1\u0121",
            "\1\u0122",
            "\1\u0123",
            "\1\u0124",
            "\1\u0125",
            "\1\u0126",
            "\1\u0127",
            "\1\u0128",
            "\13\31\6\uffff\32\31\4\uffff\1\31",
            "\1\u012a",
            "",
            "",
            "",
            "\1\u012b",
            "\1\u012c",
            "",
            "\1\u012d",
            "\1\u012e",
            "\1\u012f",
            "\1\u0130",
            "",
            "",
            "",
            "\1\u0131",
            "\1\u0132",
            "\13\31\6\uffff\32\31\4\uffff\1\31",
            "\1\u0134",
            "",
            "\1\u0135",
            "\12\u0136\7\uffff\6\u0136",
            "",
            "\1\u0137",
            "",
            "\13\31\6\uffff\32\31\4\uffff\1\31",
            "\13\31\6\uffff\32\31\4\uffff\1\31",
            "\1\u013a",
            "\13\31\6\uffff\32\31\4\uffff\1\31",
            "\1\u013c",
            "",
            "\1\u013d",
            "\1\u013e",
            "",
            "",
            "\13\31\6\uffff\32\31\4\uffff\1\31",
            "",
            "\1\u0140",
            "\1\u0141",
            "\1\u0142",
            "\13\31\6\uffff\32\31\4\uffff\1\31",
            "",
            "\13\31\6\uffff\32\31\4\uffff\1\31",
            "\13\31\6\uffff\32\31\4\uffff\1\31",
            "\1\u0146",
            "\13\31\6\uffff\32\31\4\uffff\1\31",
            "\1\u0148",
            "\1\u0149",
            "\1\u014a",
            "\13\31\6\uffff\32\31\4\uffff\1\31",
            "\1\u014c",
            "\13\31\6\uffff\32\31\4\uffff\1\31",
            "",
            "\13\31\6\uffff\32\31\4\uffff\1\31",
            "\13\31\6\uffff\32\31\4\uffff\1\31",
            "\13\31\6\uffff\32\31\4\uffff\1\31",
            "\1\u0151",
            "\13\31\6\uffff\32\31\4\uffff\1\31",
            "\1\u0153",
            "\13\31\6\uffff\32\31\4\uffff\1\31",
            "\1\u0155",
            "",
            "\1\u0156",
            "\1\u0157",
            "\1\u0158",
            "\1\u0159",
            "\1\u015a",
            "\13\31\6\uffff\32\31\4\uffff\1\31",
            "\1\u015c",
            "\13\31\6\uffff\32\31\4\uffff\1\31",
            "\1\u015e",
            "",
            "\1\u015f",
            "\1\u0160",
            "\12\u0161\7\uffff\6\u0161",
            "\13\31\6\uffff\32\31\4\uffff\1\31",
            "",
            "",
            "\1\u0163",
            "",
            "\13\31\6\uffff\32\31\4\uffff\1\31",
            "\1\u0165",
            "\13\31\6\uffff\32\31\4\uffff\1\31",
            "",
            "\13\31\6\uffff\32\31\4\uffff\1\31",
            "\1\u0168",
            "\1\u0169",
            "",
            "",
            "",
            "\1\u016a",
            "",
            "\13\31\6\uffff\32\31\4\uffff\1\31",
            "\1\u016c",
            "\1\u016d",
            "",
            "\1\u016e",
            "",
            "",
            "",
            "",
            "\13\31\6\uffff\32\31\4\uffff\1\31",
            "",
            "\13\31\6\uffff\32\31\4\uffff\1\31",
            "",
            "\13\31\6\uffff\32\31\4\uffff\1\31",
            "\13\31\6\uffff\32\31\4\uffff\1\31",
            "\1\u0173",
            "\1\u0174",
            "\1\u0175",
            "\1\u0176",
            "",
            "\1\u0177",
            "",
            "\1\u0178",
            "\1\u0179",
            "\1\u017a",
            "\12\u017b\7\uffff\6\u017b",
            "",
            "\13\31\6\uffff\32\31\4\uffff\1\31",
            "",
            "\1\u017d",
            "",
            "",
            "\13\31\6\uffff\32\31\4\uffff\1\31",
            "\13\31\6\uffff\32\31\4\uffff\1\31",
            "\1\u0180",
            "",
            "\1\u0181",
            "\13\31\6\uffff\32\31\4\uffff\1\31",
            "\1\u0183",
            "",
            "",
            "",
            "",
            "\1\u0184",
            "\13\31\6\uffff\32\31\4\uffff\1\31",
            "\1\u0186",
            "\1\u0187",
            "\1\u0188",
            "\13\31\6\uffff\32\31\4\uffff\1\31",
            "\1\u018a",
            "\13\31\6\uffff\32\31\4\uffff\1\31",
            "\12\164\1\167\2\164\1\167\31\164\1\166\64\164\1\165\uffa3\164",
            "",
            "\13\31\6\uffff\32\31\4\uffff\1\31",
            "",
            "",
            "\1\u018d",
            "\13\31\6\uffff\32\31\4\uffff\1\31",
            "",
            "\1\u018f",
            "\1\u0190",
            "",
            "\13\31\6\uffff\32\31\4\uffff\1\31",
            "\1\u0192",
            "\13\31\6\uffff\32\31\4\uffff\1\31",
            "",
            "\1\u0194",
            "",
            "",
            "\13\31\6\uffff\32\31\4\uffff\1\31",
            "",
            "\13\31\6\uffff\32\31\4\uffff\1\31",
            "\13\31\6\uffff\32\31\4\uffff\1\31",
            "",
            "\13\31\6\uffff\32\31\4\uffff\1\31",
            "",
            "\13\31\6\uffff\32\31\4\uffff\1\31",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA15_eot = DFA.unpackEncodedString(DFA15_eotS);
    static final short[] DFA15_eof = DFA.unpackEncodedString(DFA15_eofS);
    static final char[] DFA15_min = DFA.unpackEncodedStringToUnsignedChars(DFA15_minS);
    static final char[] DFA15_max = DFA.unpackEncodedStringToUnsignedChars(DFA15_maxS);
    static final short[] DFA15_accept = DFA.unpackEncodedString(DFA15_acceptS);
    static final short[] DFA15_special = DFA.unpackEncodedString(DFA15_specialS);
    static final short[][] DFA15_transition;

    static {
        int numStates = DFA15_transitionS.length;
        DFA15_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA15_transition[i] = DFA.unpackEncodedString(DFA15_transitionS[i]);
        }
    }

    class DFA15 extends DFA {

        public DFA15(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 15;
            this.eot = DFA15_eot;
            this.eof = DFA15_eof;
            this.min = DFA15_min;
            this.max = DFA15_max;
            this.accept = DFA15_accept;
            this.special = DFA15_special;
            this.transition = DFA15_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( VOID | IMPORT | RETURNS | DEFINE | LOAD | FILTER | FOREACH | ORDER | DISTINCT | COGROUP | JOIN | CROSS | UNION | SPLIT | INTO | IF | OTHERWISE | ALL | AS | BY | USING | INNER | OUTER | ONSCHEMA | PARALLEL | PARTITION | GROUP | AND | OR | NOT | GENERATE | FLATTEN | ASC | DESC | BOOLEAN | INT | LONG | FLOAT | DOUBLE | CHARARRAY | BYTEARRAY | BAG | TUPLE | MAP | IS | STREAM | THROUGH | STORE | MAPREDUCE | SHIP | CACHE | INPUT | OUTPUT | STDERROR | STDIN | STDOUT | LIMIT | SAMPLE | LEFT | RIGHT | FULL | STR_OP_EQ | STR_OP_GT | STR_OP_LT | STR_OP_GTE | STR_OP_LTE | STR_OP_NE | STR_OP_MATCHES | TRUE | FALSE | NUM_OP_EQ | NUM_OP_LT | NUM_OP_LTE | NUM_OP_GT | NUM_OP_GTE | NUM_OP_NE | DCOLON | IDENTIFIER_L | INTEGER | LONGINTEGER | DOLLARVAR | DOUBLENUMBER | FLOATNUMBER | QUOTEDSTRING | MULTILINE_QUOTEDSTRING | EXECCOMMAND | STAR | COLON | DOLLAR | WS | SL_COMMENT | ML_COMMENT | SEMI_COLON | LEFT_PAREN | RIGHT_PAREN | LEFT_CURLY | RIGHT_CURLY | LEFT_BRACKET | RIGHT_BRACKET | POUND | EQUAL | COMMA | PERIOD | DOUBLE_PERIOD | DIV | PERCENT | PLUS | MINUS | QMARK );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA15_379 = input.LA(1);

                        s = -1;
                        if ( (LA15_379=='\'') ) {s = 118;}

                        else if ( ((LA15_379 >= '\u0000' && LA15_379 <= '\t')||(LA15_379 >= '\u000B' && LA15_379 <= '\f')||(LA15_379 >= '\u000E' && LA15_379 <= '&')||(LA15_379 >= '(' && LA15_379 <= '[')||(LA15_379 >= ']' && LA15_379 <= '\uFFFF')) ) {s = 116;}

                        else if ( (LA15_379=='\\') ) {s = 117;}

                        else if ( (LA15_379=='\n'||LA15_379=='\r') ) {s = 119;}

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA15_29 = input.LA(1);

                        s = -1;
                        if ( ((LA15_29 >= '\u0000' && LA15_29 <= '\t')||(LA15_29 >= '\u000B' && LA15_29 <= '\f')||(LA15_29 >= '\u000E' && LA15_29 <= '&')||(LA15_29 >= '(' && LA15_29 <= '[')||(LA15_29 >= ']' && LA15_29 <= '\uFFFF')) ) {s = 116;}

                        else if ( (LA15_29=='\\') ) {s = 117;}

                        else if ( (LA15_29=='\'') ) {s = 118;}

                        else if ( (LA15_29=='\n'||LA15_29=='\r') ) {s = 119;}

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA15_192 = input.LA(1);

                        s = -1;
                        if ( (LA15_192=='\'') ) {s = 118;}

                        else if ( ((LA15_192 >= '\u0000' && LA15_192 <= '\t')||(LA15_192 >= '\u000B' && LA15_192 <= '\f')||(LA15_192 >= '\u000E' && LA15_192 <= '&')||(LA15_192 >= '(' && LA15_192 <= '[')||(LA15_192 >= ']' && LA15_192 <= '\uFFFF')) ) {s = 116;}

                        else if ( (LA15_192=='\\') ) {s = 117;}

                        else if ( (LA15_192=='\n'||LA15_192=='\r') ) {s = 119;}

                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA15_116 = input.LA(1);

                        s = -1;
                        if ( (LA15_116=='\'') ) {s = 118;}

                        else if ( ((LA15_116 >= '\u0000' && LA15_116 <= '\t')||(LA15_116 >= '\u000B' && LA15_116 <= '\f')||(LA15_116 >= '\u000E' && LA15_116 <= '&')||(LA15_116 >= '(' && LA15_116 <= '[')||(LA15_116 >= ']' && LA15_116 <= '\uFFFF')) ) {s = 116;}

                        else if ( (LA15_116=='\\') ) {s = 117;}

                        else if ( (LA15_116=='\n'||LA15_116=='\r') ) {s = 119;}

                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}

            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 15, _s, input);
            error(nvae);
            throw nvae;
        }

    }
 

}