// $ANTLR 3.4 /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g 2012-10-31 09:51:38

package org.apache.pig.parser;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;


/**
 * Grammar file for Pig tree parser (visitor for printing Pig script from Ast).
 *
 * NOTE: THIS FILE IS BASED ON QueryParser.g, SO IF YOU CHANGE THAT FILE, YOU WILL 
 *       PROBABLY NEED TO MAKE CORRESPONDING CHANGES TO THIS FILE AS WELL.
 */
@SuppressWarnings({"all", "warnings", "unchecked"})
public class AstPrinter extends TreeParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ALL", "AND", "AS", "ASC", "BAG", "BOOLEAN", "BY", "BYTEARRAY", "CACHE", "CHARARRAY", "COGROUP", "COLON", "COMMA", "CROSS", "DCOLON", "DEFINE", "DESC", "DIGIT", "DISTINCT", "DIV", "DOLLAR", "DOLLARVAR", "DOUBLE", "DOUBLENUMBER", "DOUBLE_PERIOD", "EQUAL", "EXECCOMMAND", "FALSE", "FILTER", "FLATTEN", "FLOAT", "FLOATINGPOINT", "FLOATNUMBER", "FOREACH", "FULL", "GENERATE", "GROUP", "ID", "IDENTIFIER_L", "IF", "IMPORT", "INNER", "INPUT", "INT", "INTEGER", "INTO", "IS", "JOIN", "LEFT", "LEFT_BRACKET", "LEFT_CURLY", "LEFT_PAREN", "LETTER", "LIMIT", "LOAD", "LONG", "LONGINTEGER", "MAP", "MAPREDUCE", "MINUS", "ML_COMMENT", "MULTILINE_QUOTEDSTRING", "NOT", "NUM_OP_EQ", "NUM_OP_GT", "NUM_OP_GTE", "NUM_OP_LT", "NUM_OP_LTE", "NUM_OP_NE", "ONSCHEMA", "OR", "ORDER", "OTHERWISE", "OUTER", "OUTPUT", "PARALLEL", "PARTITION", "PERCENT", "PERIOD", "PLUS", "POUND", "QMARK", "QUOTEDSTRING", "RETURNS", "RIGHT", "RIGHT_BRACKET", "RIGHT_CURLY", "RIGHT_PAREN", "SAMPLE", "SEMI_COLON", "SHIP", "SL_COMMENT", "SPECIALCHAR", "SPLIT", "STAR", "STDERROR", "STDIN", "STDOUT", "STORE", "STREAM", "STR_OP_EQ", "STR_OP_GT", "STR_OP_GTE", "STR_OP_LT", "STR_OP_LTE", "STR_OP_MATCHES", "STR_OP_NE", "THROUGH", "TRUE", "TUPLE", "UNION", "USING", "VOID", "WS", "ANY", "BAG_TYPE", "BAG_TYPE_CAST", "BAG_VAL", "BIN_EXPR", "BOOL", "CAST_EXPR", "COL_RANGE", "EXPR_IN_PAREN", "FIELD_DEF", "FOREACH_PLAN_COMPLEX", "FOREACH_PLAN_SIMPLE", "FUNC", "FUNC_EVAL", "FUNC_REF", "IDENTIFIER", "JOIN_ITEM", "KEY_VAL_PAIR", "MACRO_BODY", "MACRO_DEF", "MACRO_INLINE", "MAP_TYPE", "MAP_VAL", "NEG", "NESTED_CMD", "NESTED_CMD_ASSI", "NESTED_PROJ", "NULL", "PARAMS", "QUERY", "REALIAS", "RETURN_VAL", "SPLIT_BRANCH", "STATEMENT", "TOBAG", "TOMAP", "TOTUPLE", "TUPLE_TYPE", "TUPLE_TYPE_CAST", "TUPLE_VAL", "EVAL", "MATCHES"
    };

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
    public static final int ANY=118;
    public static final int BAG_TYPE=119;
    public static final int BAG_TYPE_CAST=120;
    public static final int BAG_VAL=121;
    public static final int BIN_EXPR=122;
    public static final int BOOL=123;
    public static final int CAST_EXPR=124;
    public static final int COL_RANGE=125;
    public static final int EXPR_IN_PAREN=126;
    public static final int FIELD_DEF=127;
    public static final int FOREACH_PLAN_COMPLEX=128;
    public static final int FOREACH_PLAN_SIMPLE=129;
    public static final int FUNC=130;
    public static final int FUNC_EVAL=131;
    public static final int FUNC_REF=132;
    public static final int IDENTIFIER=133;
    public static final int JOIN_ITEM=134;
    public static final int KEY_VAL_PAIR=135;
    public static final int MACRO_BODY=136;
    public static final int MACRO_DEF=137;
    public static final int MACRO_INLINE=138;
    public static final int MAP_TYPE=139;
    public static final int MAP_VAL=140;
    public static final int NEG=141;
    public static final int NESTED_CMD=142;
    public static final int NESTED_CMD_ASSI=143;
    public static final int NESTED_PROJ=144;
    public static final int NULL=145;
    public static final int PARAMS=146;
    public static final int QUERY=147;
    public static final int REALIAS=148;
    public static final int RETURN_VAL=149;
    public static final int SPLIT_BRANCH=150;
    public static final int STATEMENT=151;
    public static final int TOBAG=152;
    public static final int TOMAP=153;
    public static final int TOTUPLE=154;
    public static final int TUPLE_TYPE=155;
    public static final int TUPLE_TYPE_CAST=156;
    public static final int TUPLE_VAL=157;
    public static final int EVAL=158;
    public static final int MATCHES=159;

    // delegates
    public TreeParser[] getDelegates() {
        return new TreeParser[] {};
    }

    // delegators


    public AstPrinter(TreeNodeStream input) {
        this(input, new RecognizerSharedState());
    }
    public AstPrinter(TreeNodeStream input, RecognizerSharedState state) {
        super(input, state);
    }

protected TreeAdaptor adaptor = new CommonTreeAdaptor();

public void setTreeAdaptor(TreeAdaptor adaptor) {
    this.adaptor = adaptor;
}
public TreeAdaptor getTreeAdaptor() {
    return adaptor;
}
    public String[] getTokenNames() { return AstPrinter.tokenNames; }
    public String getGrammarFileName() { return "/Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g"; }



    public String getResult() { return sb.toString(); }

    private StringBuilder sb = new StringBuilder();



    public static class query_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "query"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:53:1: query : ^( QUERY ( statement )* ) ;
    public final AstPrinter.query_return query() throws RecognitionException {
        AstPrinter.query_return retval = new AstPrinter.query_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUERY1=null;
        AstPrinter.statement_return statement2 =null;


        CommonTree QUERY1_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:53:7: ( ^( QUERY ( statement )* ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:53:9: ^( QUERY ( statement )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            QUERY1=(CommonTree)match(input,QUERY,FOLLOW_QUERY_in_query81); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUERY1_tree = (CommonTree)adaptor.dupNode(QUERY1);


            root_1 = (CommonTree)adaptor.becomeRoot(QUERY1_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:53:18: ( statement )*
                loop1:
                do {
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==SPLIT||LA1_0==REALIAS||LA1_0==STATEMENT) ) {
                        alt1=1;
                    }


                    switch (alt1) {
                	case 1 :
                	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:53:18: statement
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_statement_in_query83);
                	    statement2=statement();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, statement2.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop1;
                    }
                } while (true);


                match(input, Token.UP, null); if (state.failed) return retval;
            }
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "query"


    public static class statement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "statement"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:56:1: statement : ( general_statement | split_statement | realias_statement );
    public final AstPrinter.statement_return statement() throws RecognitionException {
        AstPrinter.statement_return retval = new AstPrinter.statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.general_statement_return general_statement3 =null;

        AstPrinter.split_statement_return split_statement4 =null;

        AstPrinter.realias_statement_return realias_statement5 =null;



        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:56:11: ( general_statement | split_statement | realias_statement )
            int alt2=3;
            switch ( input.LA(1) ) {
            case STATEMENT:
                {
                alt2=1;
                }
                break;
            case SPLIT:
                {
                alt2=2;
                }
                break;
            case REALIAS:
                {
                alt2=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }

            switch (alt2) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:56:13: general_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_general_statement_in_statement95);
                    general_statement3=general_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, general_statement3.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:57:13: split_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_split_statement_in_statement109);
                    split_statement4=split_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, split_statement4.getTree());


                    if ( state.backtracking==0 ) { sb.append(";\n"); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:58:13: realias_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_realias_statement_in_statement125);
                    realias_statement5=realias_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, realias_statement5.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "statement"


    public static class split_statement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "split_statement"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:61:1: split_statement : split_clause ;
    public final AstPrinter.split_statement_return split_statement() throws RecognitionException {
        AstPrinter.split_statement_return retval = new AstPrinter.split_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.split_clause_return split_clause6 =null;



        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:61:17: ( split_clause )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:61:19: split_clause
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_split_clause_in_split_statement134);
            split_clause6=split_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, split_clause6.getTree());


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "split_statement"


    public static class realias_statement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "realias_statement"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:64:1: realias_statement : realias_clause ;
    public final AstPrinter.realias_statement_return realias_statement() throws RecognitionException {
        AstPrinter.realias_statement_return retval = new AstPrinter.realias_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.realias_clause_return realias_clause7 =null;



        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:64:19: ( realias_clause )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:64:21: realias_clause
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_realias_clause_in_realias_statement143);
            realias_clause7=realias_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, realias_clause7.getTree());


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "realias_statement"


    public static class general_statement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "general_statement"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:68:1: general_statement : ^( STATEMENT ( alias )? op_clause ( parallel_clause )? ) ;
    public final AstPrinter.general_statement_return general_statement() throws RecognitionException {
        AstPrinter.general_statement_return retval = new AstPrinter.general_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STATEMENT8=null;
        AstPrinter.alias_return alias9 =null;

        AstPrinter.op_clause_return op_clause10 =null;

        AstPrinter.parallel_clause_return parallel_clause11 =null;


        CommonTree STATEMENT8_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:69:5: ( ^( STATEMENT ( alias )? op_clause ( parallel_clause )? ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:69:7: ^( STATEMENT ( alias )? op_clause ( parallel_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            STATEMENT8=(CommonTree)match(input,STATEMENT,FOLLOW_STATEMENT_in_general_statement160); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STATEMENT8_tree = (CommonTree)adaptor.dupNode(STATEMENT8);


            root_1 = (CommonTree)adaptor.becomeRoot(STATEMENT8_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:69:20: ( alias )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==IDENTIFIER) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:69:22: alias
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_alias_in_general_statement164);
                    alias9=alias();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, alias9.getTree());


                    if ( state.backtracking==0 ) { sb.append(" = "); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_op_clause_in_general_statement180);
            op_clause10=op_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, op_clause10.getTree());


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:70:19: ( parallel_clause )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==PARALLEL) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:70:19: parallel_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_parallel_clause_in_general_statement182);
                    parallel_clause11=parallel_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, parallel_clause11.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) { sb.append(";\n"); }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "general_statement"


    public static class realias_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "realias_clause"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:73:1: realias_clause : ^( REALIAS alias IDENTIFIER ) ;
    public final AstPrinter.realias_clause_return realias_clause() throws RecognitionException {
        AstPrinter.realias_clause_return retval = new AstPrinter.realias_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree REALIAS12=null;
        CommonTree IDENTIFIER14=null;
        AstPrinter.alias_return alias13 =null;


        CommonTree REALIAS12_tree=null;
        CommonTree IDENTIFIER14_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:73:16: ( ^( REALIAS alias IDENTIFIER ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:73:18: ^( REALIAS alias IDENTIFIER )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            REALIAS12=(CommonTree)match(input,REALIAS,FOLLOW_REALIAS_in_realias_clause197); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            REALIAS12_tree = (CommonTree)adaptor.dupNode(REALIAS12);


            root_1 = (CommonTree)adaptor.becomeRoot(REALIAS12_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_alias_in_realias_clause199);
            alias13=alias();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, alias13.getTree());


            _last = (CommonTree)input.LT(1);
            IDENTIFIER14=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_realias_clause201); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER14_tree = (CommonTree)adaptor.dupNode(IDENTIFIER14);


            adaptor.addChild(root_1, IDENTIFIER14_tree);
            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "realias_clause"


    public static class parallel_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "parallel_clause"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:76:1: parallel_clause : ^( PARALLEL INTEGER ) ;
    public final AstPrinter.parallel_clause_return parallel_clause() throws RecognitionException {
        AstPrinter.parallel_clause_return retval = new AstPrinter.parallel_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PARALLEL15=null;
        CommonTree INTEGER16=null;

        CommonTree PARALLEL15_tree=null;
        CommonTree INTEGER16_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:77:5: ( ^( PARALLEL INTEGER ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:77:7: ^( PARALLEL INTEGER )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            PARALLEL15=(CommonTree)match(input,PARALLEL,FOLLOW_PARALLEL_in_parallel_clause218); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PARALLEL15_tree = (CommonTree)adaptor.dupNode(PARALLEL15);


            root_1 = (CommonTree)adaptor.becomeRoot(PARALLEL15_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            INTEGER16=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_parallel_clause220); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            INTEGER16_tree = (CommonTree)adaptor.dupNode(INTEGER16);


            adaptor.addChild(root_1, INTEGER16_tree);
            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) { sb.append(" ").append((PARALLEL15!=null?PARALLEL15.getText():null)).append(" ").append((INTEGER16!=null?INTEGER16.getText():null)); }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "parallel_clause"


    public static class alias_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "alias"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:80:1: alias : IDENTIFIER ;
    public final AstPrinter.alias_return alias() throws RecognitionException {
        AstPrinter.alias_return retval = new AstPrinter.alias_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IDENTIFIER17=null;

        CommonTree IDENTIFIER17_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:81:5: ( IDENTIFIER )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:81:7: IDENTIFIER
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            IDENTIFIER17=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_alias238); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER17_tree = (CommonTree)adaptor.dupNode(IDENTIFIER17);


            adaptor.addChild(root_0, IDENTIFIER17_tree);
            }


            if ( state.backtracking==0 ) { sb.append((IDENTIFIER17!=null?IDENTIFIER17.getText():null)); }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "alias"


    public static class op_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "op_clause"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:84:1: op_clause : ( define_clause | load_clause | group_clause | store_clause | filter_clause | distinct_clause | limit_clause | sample_clause | order_clause | cross_clause | join_clause | union_clause | stream_clause | mr_clause | split_clause | foreach_clause );
    public final AstPrinter.op_clause_return op_clause() throws RecognitionException {
        AstPrinter.op_clause_return retval = new AstPrinter.op_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.define_clause_return define_clause18 =null;

        AstPrinter.load_clause_return load_clause19 =null;

        AstPrinter.group_clause_return group_clause20 =null;

        AstPrinter.store_clause_return store_clause21 =null;

        AstPrinter.filter_clause_return filter_clause22 =null;

        AstPrinter.distinct_clause_return distinct_clause23 =null;

        AstPrinter.limit_clause_return limit_clause24 =null;

        AstPrinter.sample_clause_return sample_clause25 =null;

        AstPrinter.order_clause_return order_clause26 =null;

        AstPrinter.cross_clause_return cross_clause27 =null;

        AstPrinter.join_clause_return join_clause28 =null;

        AstPrinter.union_clause_return union_clause29 =null;

        AstPrinter.stream_clause_return stream_clause30 =null;

        AstPrinter.mr_clause_return mr_clause31 =null;

        AstPrinter.split_clause_return split_clause32 =null;

        AstPrinter.foreach_clause_return foreach_clause33 =null;



        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:84:11: ( define_clause | load_clause | group_clause | store_clause | filter_clause | distinct_clause | limit_clause | sample_clause | order_clause | cross_clause | join_clause | union_clause | stream_clause | mr_clause | split_clause | foreach_clause )
            int alt5=16;
            switch ( input.LA(1) ) {
            case DEFINE:
                {
                alt5=1;
                }
                break;
            case LOAD:
                {
                alt5=2;
                }
                break;
            case COGROUP:
            case GROUP:
                {
                alt5=3;
                }
                break;
            case STORE:
                {
                alt5=4;
                }
                break;
            case FILTER:
                {
                alt5=5;
                }
                break;
            case DISTINCT:
                {
                alt5=6;
                }
                break;
            case LIMIT:
                {
                alt5=7;
                }
                break;
            case SAMPLE:
                {
                alt5=8;
                }
                break;
            case ORDER:
                {
                alt5=9;
                }
                break;
            case CROSS:
                {
                alt5=10;
                }
                break;
            case JOIN:
                {
                alt5=11;
                }
                break;
            case UNION:
                {
                alt5=12;
                }
                break;
            case STREAM:
                {
                alt5=13;
                }
                break;
            case MAPREDUCE:
                {
                alt5=14;
                }
                break;
            case SPLIT:
                {
                alt5=15;
                }
                break;
            case FOREACH:
                {
                alt5=16;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;

            }

            switch (alt5) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:84:13: define_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_define_clause_in_op_clause249);
                    define_clause18=define_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, define_clause18.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:85:13: load_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_load_clause_in_op_clause264);
                    load_clause19=load_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, load_clause19.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:86:13: group_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_group_clause_in_op_clause278);
                    group_clause20=group_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, group_clause20.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:87:13: store_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_store_clause_in_op_clause292);
                    store_clause21=store_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, store_clause21.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:88:13: filter_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_filter_clause_in_op_clause306);
                    filter_clause22=filter_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, filter_clause22.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:89:13: distinct_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_distinct_clause_in_op_clause320);
                    distinct_clause23=distinct_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, distinct_clause23.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:90:13: limit_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_limit_clause_in_op_clause334);
                    limit_clause24=limit_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, limit_clause24.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:91:13: sample_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_sample_clause_in_op_clause348);
                    sample_clause25=sample_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, sample_clause25.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:92:13: order_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_order_clause_in_op_clause362);
                    order_clause26=order_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, order_clause26.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:93:13: cross_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cross_clause_in_op_clause376);
                    cross_clause27=cross_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, cross_clause27.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 11 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:94:13: join_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_clause_in_op_clause390);
                    join_clause28=join_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, join_clause28.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 12 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:95:13: union_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_union_clause_in_op_clause404);
                    union_clause29=union_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, union_clause29.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 13 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:96:13: stream_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_stream_clause_in_op_clause418);
                    stream_clause30=stream_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, stream_clause30.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 14 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:97:13: mr_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_mr_clause_in_op_clause432);
                    mr_clause31=mr_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, mr_clause31.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 15 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:98:13: split_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_split_clause_in_op_clause446);
                    split_clause32=split_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, split_clause32.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 16 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:99:13: foreach_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_foreach_clause_in_op_clause460);
                    foreach_clause33=foreach_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, foreach_clause33.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "op_clause"


    public static class define_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "define_clause"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:102:1: define_clause : ^( DEFINE IDENTIFIER ( cmd | func_clause ) ) ;
    public final AstPrinter.define_clause_return define_clause() throws RecognitionException {
        AstPrinter.define_clause_return retval = new AstPrinter.define_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DEFINE34=null;
        CommonTree IDENTIFIER35=null;
        AstPrinter.cmd_return cmd36 =null;

        AstPrinter.func_clause_return func_clause37 =null;


        CommonTree DEFINE34_tree=null;
        CommonTree IDENTIFIER35_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:103:5: ( ^( DEFINE IDENTIFIER ( cmd | func_clause ) ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:103:7: ^( DEFINE IDENTIFIER ( cmd | func_clause ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            DEFINE34=(CommonTree)match(input,DEFINE,FOLLOW_DEFINE_in_define_clause476); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DEFINE34_tree = (CommonTree)adaptor.dupNode(DEFINE34);


            root_1 = (CommonTree)adaptor.becomeRoot(DEFINE34_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            IDENTIFIER35=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_define_clause478); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER35_tree = (CommonTree)adaptor.dupNode(IDENTIFIER35);


            adaptor.addChild(root_1, IDENTIFIER35_tree);
            }


            if ( state.backtracking==0 ) { sb.append((DEFINE34!=null?DEFINE34.getText():null)).append(" ").append((IDENTIFIER35!=null?IDENTIFIER35.getText():null)).append(" "); }

            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:104:9: ( cmd | func_clause )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==EXECCOMMAND) ) {
                alt6=1;
            }
            else if ( (LA6_0==FUNC||LA6_0==FUNC_REF) ) {
                alt6=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;

            }
            switch (alt6) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:104:11: cmd
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cmd_in_define_clause493);
                    cmd36=cmd();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cmd36.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:104:17: func_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_define_clause497);
                    func_clause37=func_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause37.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "define_clause"


    public static class cmd_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cmd"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:107:1: cmd : ^( EXECCOMMAND ( ship_clause | cache_clause | input_clause | output_clause | error_clause )* ) ;
    public final AstPrinter.cmd_return cmd() throws RecognitionException {
        AstPrinter.cmd_return retval = new AstPrinter.cmd_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree EXECCOMMAND38=null;
        AstPrinter.ship_clause_return ship_clause39 =null;

        AstPrinter.cache_clause_return cache_clause40 =null;

        AstPrinter.input_clause_return input_clause41 =null;

        AstPrinter.output_clause_return output_clause42 =null;

        AstPrinter.error_clause_return error_clause43 =null;


        CommonTree EXECCOMMAND38_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:108:5: ( ^( EXECCOMMAND ( ship_clause | cache_clause | input_clause | output_clause | error_clause )* ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:108:7: ^( EXECCOMMAND ( ship_clause | cache_clause | input_clause | output_clause | error_clause )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            EXECCOMMAND38=(CommonTree)match(input,EXECCOMMAND,FOLLOW_EXECCOMMAND_in_cmd517); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            EXECCOMMAND38_tree = (CommonTree)adaptor.dupNode(EXECCOMMAND38);


            root_1 = (CommonTree)adaptor.becomeRoot(EXECCOMMAND38_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((EXECCOMMAND38!=null?EXECCOMMAND38.getText():null)); }

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:109:9: ( ship_clause | cache_clause | input_clause | output_clause | error_clause )*
                loop7:
                do {
                    int alt7=6;
                    switch ( input.LA(1) ) {
                    case SHIP:
                        {
                        alt7=1;
                        }
                        break;
                    case CACHE:
                        {
                        alt7=2;
                        }
                        break;
                    case INPUT:
                        {
                        alt7=3;
                        }
                        break;
                    case OUTPUT:
                        {
                        alt7=4;
                        }
                        break;
                    case STDERROR:
                        {
                        alt7=5;
                        }
                        break;

                    }

                    switch (alt7) {
                	case 1 :
                	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:109:11: ship_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_ship_clause_in_cmd531);
                	    ship_clause39=ship_clause();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, ship_clause39.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;
                	case 2 :
                	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:109:25: cache_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_cache_clause_in_cmd535);
                	    cache_clause40=cache_clause();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, cache_clause40.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;
                	case 3 :
                	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:109:40: input_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_input_clause_in_cmd539);
                	    input_clause41=input_clause();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, input_clause41.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;
                	case 4 :
                	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:109:55: output_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_output_clause_in_cmd543);
                	    output_clause42=output_clause();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, output_clause42.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;
                	case 5 :
                	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:109:71: error_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_error_clause_in_cmd547);
                	    error_clause43=error_clause();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, error_clause43.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop7;
                    }
                } while (true);


                match(input, Token.UP, null); if (state.failed) return retval;
            }
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "cmd"


    public static class ship_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "ship_clause"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:112:1: ship_clause : ^( SHIP ( path_list )? ) ;
    public final AstPrinter.ship_clause_return ship_clause() throws RecognitionException {
        AstPrinter.ship_clause_return retval = new AstPrinter.ship_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SHIP44=null;
        AstPrinter.path_list_return path_list45 =null;


        CommonTree SHIP44_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:113:5: ( ^( SHIP ( path_list )? ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:113:7: ^( SHIP ( path_list )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            SHIP44=(CommonTree)match(input,SHIP,FOLLOW_SHIP_in_ship_clause568); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SHIP44_tree = (CommonTree)adaptor.dupNode(SHIP44);


            root_1 = (CommonTree)adaptor.becomeRoot(SHIP44_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append(" ").append((SHIP44!=null?SHIP44.getText():null)).append(" ("); }

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:113:67: ( path_list )?
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==QUOTEDSTRING) ) {
                    alt8=1;
                }
                switch (alt8) {
                    case 1 :
                        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:113:67: path_list
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_path_list_in_ship_clause572);
                        path_list45=path_list();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, path_list45.getTree());


                        if ( state.backtracking==0 ) {
                        }
                        }
                        break;

                }


                if ( state.backtracking==0 ) { sb.append(")"); }

                match(input, Token.UP, null); if (state.failed) return retval;
            }
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "ship_clause"


    public static class path_list_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "path_list"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:116:1: path_list : a= QUOTEDSTRING (b= QUOTEDSTRING )* ;
    public final AstPrinter.path_list_return path_list() throws RecognitionException {
        AstPrinter.path_list_return retval = new AstPrinter.path_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree a=null;
        CommonTree b=null;

        CommonTree a_tree=null;
        CommonTree b_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:117:5: (a= QUOTEDSTRING (b= QUOTEDSTRING )* )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:117:7: a= QUOTEDSTRING (b= QUOTEDSTRING )*
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            a=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_path_list593); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            a_tree = (CommonTree)adaptor.dupNode(a);


            adaptor.addChild(root_0, a_tree);
            }


            if ( state.backtracking==0 ) { sb.append(" ").append((a!=null?a.getText():null)); }

            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:118:9: (b= QUOTEDSTRING )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==QUOTEDSTRING) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:118:10: b= QUOTEDSTRING
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    b=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_path_list608); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    b_tree = (CommonTree)adaptor.dupNode(b);


            	    adaptor.addChild(root_0, b_tree);
            	    }


            	    if ( state.backtracking==0 ) { sb.append(", ").append((b!=null?b.getText():null)); }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "path_list"


    public static class cache_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cache_clause"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:121:1: cache_clause : ^( CACHE path_list ) ;
    public final AstPrinter.cache_clause_return cache_clause() throws RecognitionException {
        AstPrinter.cache_clause_return retval = new AstPrinter.cache_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CACHE46=null;
        AstPrinter.path_list_return path_list47 =null;


        CommonTree CACHE46_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:122:5: ( ^( CACHE path_list ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:122:7: ^( CACHE path_list )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CACHE46=(CommonTree)match(input,CACHE,FOLLOW_CACHE_in_cache_clause629); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CACHE46_tree = (CommonTree)adaptor.dupNode(CACHE46);


            root_1 = (CommonTree)adaptor.becomeRoot(CACHE46_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append(" ").append((CACHE46!=null?CACHE46.getText():null)).append(" ("); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_path_list_in_cache_clause633);
            path_list47=path_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, path_list47.getTree());


            if ( state.backtracking==0 ) { sb.append(")"); }

            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "cache_clause"


    public static class input_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "input_clause"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:125:1: input_clause : ^( INPUT stream_cmd ( stream_cmd )* ) ;
    public final AstPrinter.input_clause_return input_clause() throws RecognitionException {
        AstPrinter.input_clause_return retval = new AstPrinter.input_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree INPUT48=null;
        AstPrinter.stream_cmd_return stream_cmd49 =null;

        AstPrinter.stream_cmd_return stream_cmd50 =null;


        CommonTree INPUT48_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:126:5: ( ^( INPUT stream_cmd ( stream_cmd )* ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:126:7: ^( INPUT stream_cmd ( stream_cmd )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            INPUT48=(CommonTree)match(input,INPUT,FOLLOW_INPUT_in_input_clause653); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            INPUT48_tree = (CommonTree)adaptor.dupNode(INPUT48);


            root_1 = (CommonTree)adaptor.becomeRoot(INPUT48_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append(" ").append((INPUT48!=null?INPUT48.getText():null)).append("("); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_stream_cmd_in_input_clause666);
            stream_cmd49=stream_cmd();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, stream_cmd49.getTree());


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:127:20: ( stream_cmd )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==QUOTEDSTRING||(LA10_0 >= STDIN && LA10_0 <= STDOUT)) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:127:22: stream_cmd
            	    {
            	    if ( state.backtracking==0 ) { sb.append(", "); }

            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_stream_cmd_in_input_clause672);
            	    stream_cmd50=stream_cmd();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, stream_cmd50.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            if ( state.backtracking==0 ) { sb.append(")"); }

            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "input_clause"


    public static class stream_cmd_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "stream_cmd"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:130:1: stream_cmd : ( ^( STDIN ( func_clause )? ) | ^( STDOUT ( func_clause )? ) | ^( QUOTEDSTRING ( func_clause )? ) );
    public final AstPrinter.stream_cmd_return stream_cmd() throws RecognitionException {
        AstPrinter.stream_cmd_return retval = new AstPrinter.stream_cmd_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STDIN51=null;
        CommonTree STDOUT53=null;
        CommonTree QUOTEDSTRING55=null;
        AstPrinter.func_clause_return func_clause52 =null;

        AstPrinter.func_clause_return func_clause54 =null;

        AstPrinter.func_clause_return func_clause56 =null;


        CommonTree STDIN51_tree=null;
        CommonTree STDOUT53_tree=null;
        CommonTree QUOTEDSTRING55_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:131:5: ( ^( STDIN ( func_clause )? ) | ^( STDOUT ( func_clause )? ) | ^( QUOTEDSTRING ( func_clause )? ) )
            int alt14=3;
            switch ( input.LA(1) ) {
            case STDIN:
                {
                alt14=1;
                }
                break;
            case STDOUT:
                {
                alt14=2;
                }
                break;
            case QUOTEDSTRING:
                {
                alt14=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;

            }

            switch (alt14) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:131:7: ^( STDIN ( func_clause )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    STDIN51=(CommonTree)match(input,STDIN,FOLLOW_STDIN_in_stream_cmd694); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDIN51_tree = (CommonTree)adaptor.dupNode(STDIN51);


                    root_1 = (CommonTree)adaptor.becomeRoot(STDIN51_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { sb.append((STDIN51!=null?STDIN51.getText():null)).append(" USING "); }

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
                        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:131:62: ( func_clause )?
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==FUNC||LA11_0==FUNC_REF) ) {
                            alt11=1;
                        }
                        switch (alt11) {
                            case 1 :
                                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:131:62: func_clause
                                {
                                _last = (CommonTree)input.LT(1);
                                pushFollow(FOLLOW_func_clause_in_stream_cmd698);
                                func_clause52=func_clause();

                                state._fsp--;
                                if (state.failed) return retval;
                                if ( state.backtracking==0 ) 
                                adaptor.addChild(root_1, func_clause52.getTree());


                                if ( state.backtracking==0 ) {
                                }
                                }
                                break;

                        }


                        match(input, Token.UP, null); if (state.failed) return retval;
                    }
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:132:7: ^( STDOUT ( func_clause )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    STDOUT53=(CommonTree)match(input,STDOUT,FOLLOW_STDOUT_in_stream_cmd711); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDOUT53_tree = (CommonTree)adaptor.dupNode(STDOUT53);


                    root_1 = (CommonTree)adaptor.becomeRoot(STDOUT53_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { sb.append((STDOUT53!=null?STDOUT53.getText():null)).append(" USING "); }

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
                        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:132:64: ( func_clause )?
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==FUNC||LA12_0==FUNC_REF) ) {
                            alt12=1;
                        }
                        switch (alt12) {
                            case 1 :
                                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:132:64: func_clause
                                {
                                _last = (CommonTree)input.LT(1);
                                pushFollow(FOLLOW_func_clause_in_stream_cmd715);
                                func_clause54=func_clause();

                                state._fsp--;
                                if (state.failed) return retval;
                                if ( state.backtracking==0 ) 
                                adaptor.addChild(root_1, func_clause54.getTree());


                                if ( state.backtracking==0 ) {
                                }
                                }
                                break;

                        }


                        match(input, Token.UP, null); if (state.failed) return retval;
                    }
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:133:7: ^( QUOTEDSTRING ( func_clause )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    QUOTEDSTRING55=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_stream_cmd728); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    QUOTEDSTRING55_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING55);


                    root_1 = (CommonTree)adaptor.becomeRoot(QUOTEDSTRING55_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { sb.append((QUOTEDSTRING55!=null?QUOTEDSTRING55.getText():null)).append(" USING "); }

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
                        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:133:76: ( func_clause )?
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==FUNC||LA13_0==FUNC_REF) ) {
                            alt13=1;
                        }
                        switch (alt13) {
                            case 1 :
                                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:133:76: func_clause
                                {
                                _last = (CommonTree)input.LT(1);
                                pushFollow(FOLLOW_func_clause_in_stream_cmd732);
                                func_clause56=func_clause();

                                state._fsp--;
                                if (state.failed) return retval;
                                if ( state.backtracking==0 ) 
                                adaptor.addChild(root_1, func_clause56.getTree());


                                if ( state.backtracking==0 ) {
                                }
                                }
                                break;

                        }


                        match(input, Token.UP, null); if (state.failed) return retval;
                    }
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "stream_cmd"


    public static class output_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "output_clause"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:136:1: output_clause : ^( OUTPUT stream_cmd ( stream_cmd )* ) ;
    public final AstPrinter.output_clause_return output_clause() throws RecognitionException {
        AstPrinter.output_clause_return retval = new AstPrinter.output_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree OUTPUT57=null;
        AstPrinter.stream_cmd_return stream_cmd58 =null;

        AstPrinter.stream_cmd_return stream_cmd59 =null;


        CommonTree OUTPUT57_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:137:5: ( ^( OUTPUT stream_cmd ( stream_cmd )* ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:137:7: ^( OUTPUT stream_cmd ( stream_cmd )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            OUTPUT57=(CommonTree)match(input,OUTPUT,FOLLOW_OUTPUT_in_output_clause751); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            OUTPUT57_tree = (CommonTree)adaptor.dupNode(OUTPUT57);


            root_1 = (CommonTree)adaptor.becomeRoot(OUTPUT57_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append(" ").append((OUTPUT57!=null?OUTPUT57.getText():null)).append(" ("); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_stream_cmd_in_output_clause765);
            stream_cmd58=stream_cmd();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, stream_cmd58.getTree());


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:138:20: ( stream_cmd )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==QUOTEDSTRING||(LA15_0 >= STDIN && LA15_0 <= STDOUT)) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:138:22: stream_cmd
            	    {
            	    if ( state.backtracking==0 ) { sb.append(","); }

            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_stream_cmd_in_output_clause771);
            	    stream_cmd59=stream_cmd();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, stream_cmd59.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);


            if ( state.backtracking==0 ) { sb.append(")"); }

            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "output_clause"


    public static class error_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "error_clause"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:141:1: error_clause : ^( STDERROR ( QUOTEDSTRING ( INTEGER )? )? ) ;
    public final AstPrinter.error_clause_return error_clause() throws RecognitionException {
        AstPrinter.error_clause_return retval = new AstPrinter.error_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STDERROR60=null;
        CommonTree QUOTEDSTRING61=null;
        CommonTree INTEGER62=null;

        CommonTree STDERROR60_tree=null;
        CommonTree QUOTEDSTRING61_tree=null;
        CommonTree INTEGER62_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:142:5: ( ^( STDERROR ( QUOTEDSTRING ( INTEGER )? )? ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:142:7: ^( STDERROR ( QUOTEDSTRING ( INTEGER )? )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            STDERROR60=(CommonTree)match(input,STDERROR,FOLLOW_STDERROR_in_error_clause793); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STDERROR60_tree = (CommonTree)adaptor.dupNode(STDERROR60);


            root_1 = (CommonTree)adaptor.becomeRoot(STDERROR60_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append(" ").append((STDERROR60!=null?STDERROR60.getText():null)).append(" ("); }

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:143:9: ( QUOTEDSTRING ( INTEGER )? )?
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==QUOTEDSTRING) ) {
                    alt17=1;
                }
                switch (alt17) {
                    case 1 :
                        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:143:11: QUOTEDSTRING ( INTEGER )?
                        {
                        _last = (CommonTree)input.LT(1);
                        QUOTEDSTRING61=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_error_clause807); if (state.failed) return retval;
                        if ( state.backtracking==0 ) {
                        QUOTEDSTRING61_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING61);


                        adaptor.addChild(root_1, QUOTEDSTRING61_tree);
                        }


                        if ( state.backtracking==0 ) { sb.append((QUOTEDSTRING61!=null?QUOTEDSTRING61.getText():null)); }

                        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:143:59: ( INTEGER )?
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==INTEGER) ) {
                            alt16=1;
                        }
                        switch (alt16) {
                            case 1 :
                                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:143:60: INTEGER
                                {
                                _last = (CommonTree)input.LT(1);
                                INTEGER62=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_error_clause812); if (state.failed) return retval;
                                if ( state.backtracking==0 ) {
                                INTEGER62_tree = (CommonTree)adaptor.dupNode(INTEGER62);


                                adaptor.addChild(root_1, INTEGER62_tree);
                                }


                                if ( state.backtracking==0 ) { sb.append(" LIMIT ").append(INTEGER62); }

                                if ( state.backtracking==0 ) {
                                }
                                }
                                break;

                        }


                        if ( state.backtracking==0 ) {
                        }
                        }
                        break;

                }


                if ( state.backtracking==0 ) { sb.append(")"); }

                match(input, Token.UP, null); if (state.failed) return retval;
            }
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "error_clause"


    public static class load_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "load_clause"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:146:1: load_clause : ^( LOAD filename ( func_clause )? ( as_clause )? ) ;
    public final AstPrinter.load_clause_return load_clause() throws RecognitionException {
        AstPrinter.load_clause_return retval = new AstPrinter.load_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree LOAD63=null;
        AstPrinter.filename_return filename64 =null;

        AstPrinter.func_clause_return func_clause65 =null;

        AstPrinter.as_clause_return as_clause66 =null;


        CommonTree LOAD63_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:147:5: ( ^( LOAD filename ( func_clause )? ( as_clause )? ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:147:7: ^( LOAD filename ( func_clause )? ( as_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            LOAD63=(CommonTree)match(input,LOAD,FOLLOW_LOAD_in_load_clause840); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LOAD63_tree = (CommonTree)adaptor.dupNode(LOAD63);


            root_1 = (CommonTree)adaptor.becomeRoot(LOAD63_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((LOAD63!=null?LOAD63.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_filename_in_load_clause844);
            filename64=filename();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, filename64.getTree());


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:148:9: ( func_clause )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==FUNC||LA18_0==FUNC_REF) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:148:11: func_clause
                    {
                    if ( state.backtracking==0 ) { sb.append(" USING "); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_load_clause859);
                    func_clause65=func_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause65.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:148:51: ( as_clause )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==AS) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:148:51: as_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_as_clause_in_load_clause863);
                    as_clause66=as_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, as_clause66.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "load_clause"


    public static class filename_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "filename"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:151:1: filename : QUOTEDSTRING ;
    public final AstPrinter.filename_return filename() throws RecognitionException {
        AstPrinter.filename_return retval = new AstPrinter.filename_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING67=null;

        CommonTree QUOTEDSTRING67_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:152:5: ( QUOTEDSTRING )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:152:7: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING67=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_filename880); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING67_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING67);


            adaptor.addChild(root_0, QUOTEDSTRING67_tree);
            }


            if ( state.backtracking==0 ) { sb.append((QUOTEDSTRING67!=null?QUOTEDSTRING67.getText():null)); }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "filename"


    public static class as_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "as_clause"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:155:1: as_clause : ^( AS field_def_list ) ;
    public final AstPrinter.as_clause_return as_clause() throws RecognitionException {
        AstPrinter.as_clause_return retval = new AstPrinter.as_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree AS68=null;
        AstPrinter.field_def_list_return field_def_list69 =null;


        CommonTree AS68_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:156:5: ( ^( AS field_def_list ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:156:7: ^( AS field_def_list )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            AS68=(CommonTree)match(input,AS,FOLLOW_AS_in_as_clause897); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            AS68_tree = (CommonTree)adaptor.dupNode(AS68);


            root_1 = (CommonTree)adaptor.becomeRoot(AS68_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append(" ").append((AS68!=null?AS68.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_field_def_list_in_as_clause901);
            field_def_list69=field_def_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, field_def_list69.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "as_clause"


    public static class field_def_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "field_def"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:159:1: field_def : ^( FIELD_DEF IDENTIFIER ( type )? ) ;
    public final AstPrinter.field_def_return field_def() throws RecognitionException {
        AstPrinter.field_def_return retval = new AstPrinter.field_def_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FIELD_DEF70=null;
        CommonTree IDENTIFIER71=null;
        AstPrinter.type_return type72 =null;


        CommonTree FIELD_DEF70_tree=null;
        CommonTree IDENTIFIER71_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:160:5: ( ^( FIELD_DEF IDENTIFIER ( type )? ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:160:7: ^( FIELD_DEF IDENTIFIER ( type )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FIELD_DEF70=(CommonTree)match(input,FIELD_DEF,FOLLOW_FIELD_DEF_in_field_def918); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FIELD_DEF70_tree = (CommonTree)adaptor.dupNode(FIELD_DEF70);


            root_1 = (CommonTree)adaptor.becomeRoot(FIELD_DEF70_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            IDENTIFIER71=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_field_def920); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER71_tree = (CommonTree)adaptor.dupNode(IDENTIFIER71);


            adaptor.addChild(root_1, IDENTIFIER71_tree);
            }


            if ( state.backtracking==0 ) { sb.append((IDENTIFIER71!=null?IDENTIFIER71.getText():null)); }

            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:160:65: ( type )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==BOOLEAN||LA20_0==BYTEARRAY||LA20_0==CHARARRAY||LA20_0==DOUBLE||LA20_0==FLOAT||LA20_0==INT||LA20_0==LONG||LA20_0==BAG_TYPE||LA20_0==MAP_TYPE||LA20_0==TUPLE_TYPE) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:160:67: type
                    {
                    if ( state.backtracking==0 ) {sb.append(":"); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_type_in_field_def930);
                    type72=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, type72.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "field_def"


    public static class field_def_list_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "field_def_list"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:163:1: field_def_list : ( field_def ( field_def )+ | field_def );
    public final AstPrinter.field_def_list_return field_def_list() throws RecognitionException {
        AstPrinter.field_def_list_return retval = new AstPrinter.field_def_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.field_def_return field_def73 =null;

        AstPrinter.field_def_return field_def74 =null;

        AstPrinter.field_def_return field_def75 =null;



        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:164:5: ( field_def ( field_def )+ | field_def )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==FIELD_DEF) ) {
                int LA22_1 = input.LA(2);

                if ( (synpred42_AstPrinter()) ) {
                    alt22=1;
                }
                else if ( (true) ) {
                    alt22=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 22, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;

            }
            switch (alt22) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:164:7: field_def ( field_def )+
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    if ( state.backtracking==0 ) { sb.append("("); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_field_def_in_field_def_list949);
                    field_def73=field_def();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, field_def73.getTree());


                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:164:37: ( field_def )+
                    int cnt21=0;
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( (LA21_0==FIELD_DEF) ) {
                            alt21=1;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:164:39: field_def
                    	    {
                    	    if ( state.backtracking==0 ) { sb.append(", "); }

                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_field_def_in_field_def_list955);
                    	    field_def74=field_def();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, field_def74.getTree());


                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    if ( cnt21 >= 1 ) break loop21;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(21, input);
                                throw eee;
                        }
                        cnt21++;
                    } while (true);


                    if ( state.backtracking==0 ) { sb.append(")"); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:165:7: field_def
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_field_def_in_field_def_list968);
                    field_def75=field_def();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, field_def75.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "field_def_list"


    public static class type_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "type"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:168:1: type : ( simple_type | tuple_type | bag_type | map_type );
    public final AstPrinter.type_return type() throws RecognitionException {
        AstPrinter.type_return retval = new AstPrinter.type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.simple_type_return simple_type76 =null;

        AstPrinter.tuple_type_return tuple_type77 =null;

        AstPrinter.bag_type_return bag_type78 =null;

        AstPrinter.map_type_return map_type79 =null;



        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:168:6: ( simple_type | tuple_type | bag_type | map_type )
            int alt23=4;
            switch ( input.LA(1) ) {
            case BOOLEAN:
            case BYTEARRAY:
            case CHARARRAY:
            case DOUBLE:
            case FLOAT:
            case INT:
            case LONG:
                {
                alt23=1;
                }
                break;
            case TUPLE_TYPE:
                {
                alt23=2;
                }
                break;
            case BAG_TYPE:
                {
                alt23=3;
                }
                break;
            case MAP_TYPE:
                {
                alt23=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;

            }

            switch (alt23) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:168:8: simple_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_simple_type_in_type977);
                    simple_type76=simple_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, simple_type76.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:168:22: tuple_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_tuple_type_in_type981);
                    tuple_type77=tuple_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, tuple_type77.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:168:35: bag_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_bag_type_in_type985);
                    bag_type78=bag_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, bag_type78.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:168:46: map_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_map_type_in_type989);
                    map_type79=map_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, map_type79.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "type"


    public static class simple_type_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "simple_type"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:171:1: simple_type : ( BOOLEAN | INT | LONG | FLOAT | DOUBLE | CHARARRAY | BYTEARRAY );
    public final AstPrinter.simple_type_return simple_type() throws RecognitionException {
        AstPrinter.simple_type_return retval = new AstPrinter.simple_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BOOLEAN80=null;
        CommonTree INT81=null;
        CommonTree LONG82=null;
        CommonTree FLOAT83=null;
        CommonTree DOUBLE84=null;
        CommonTree CHARARRAY85=null;
        CommonTree BYTEARRAY86=null;

        CommonTree BOOLEAN80_tree=null;
        CommonTree INT81_tree=null;
        CommonTree LONG82_tree=null;
        CommonTree FLOAT83_tree=null;
        CommonTree DOUBLE84_tree=null;
        CommonTree CHARARRAY85_tree=null;
        CommonTree BYTEARRAY86_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:172:5: ( BOOLEAN | INT | LONG | FLOAT | DOUBLE | CHARARRAY | BYTEARRAY )
            int alt24=7;
            switch ( input.LA(1) ) {
            case BOOLEAN:
                {
                alt24=1;
                }
                break;
            case INT:
                {
                alt24=2;
                }
                break;
            case LONG:
                {
                alt24=3;
                }
                break;
            case FLOAT:
                {
                alt24=4;
                }
                break;
            case DOUBLE:
                {
                alt24=5;
                }
                break;
            case CHARARRAY:
                {
                alt24=6;
                }
                break;
            case BYTEARRAY:
                {
                alt24=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;

            }

            switch (alt24) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:172:7: BOOLEAN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BOOLEAN80=(CommonTree)match(input,BOOLEAN,FOLLOW_BOOLEAN_in_simple_type1003); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BOOLEAN80_tree = (CommonTree)adaptor.dupNode(BOOLEAN80);


                    adaptor.addChild(root_0, BOOLEAN80_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((BOOLEAN80!=null?BOOLEAN80.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:173:7: INT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INT81=(CommonTree)match(input,INT,FOLLOW_INT_in_simple_type1013); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INT81_tree = (CommonTree)adaptor.dupNode(INT81);


                    adaptor.addChild(root_0, INT81_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((INT81!=null?INT81.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:174:7: LONG
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LONG82=(CommonTree)match(input,LONG,FOLLOW_LONG_in_simple_type1023); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LONG82_tree = (CommonTree)adaptor.dupNode(LONG82);


                    adaptor.addChild(root_0, LONG82_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((LONG82!=null?LONG82.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:175:7: FLOAT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FLOAT83=(CommonTree)match(input,FLOAT,FOLLOW_FLOAT_in_simple_type1033); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FLOAT83_tree = (CommonTree)adaptor.dupNode(FLOAT83);


                    adaptor.addChild(root_0, FLOAT83_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((FLOAT83!=null?FLOAT83.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:176:7: DOUBLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DOUBLE84=(CommonTree)match(input,DOUBLE,FOLLOW_DOUBLE_in_simple_type1043); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DOUBLE84_tree = (CommonTree)adaptor.dupNode(DOUBLE84);


                    adaptor.addChild(root_0, DOUBLE84_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((DOUBLE84!=null?DOUBLE84.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:177:7: CHARARRAY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CHARARRAY85=(CommonTree)match(input,CHARARRAY,FOLLOW_CHARARRAY_in_simple_type1053); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CHARARRAY85_tree = (CommonTree)adaptor.dupNode(CHARARRAY85);


                    adaptor.addChild(root_0, CHARARRAY85_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((CHARARRAY85!=null?CHARARRAY85.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:178:7: BYTEARRAY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BYTEARRAY86=(CommonTree)match(input,BYTEARRAY,FOLLOW_BYTEARRAY_in_simple_type1063); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BYTEARRAY86_tree = (CommonTree)adaptor.dupNode(BYTEARRAY86);


                    adaptor.addChild(root_0, BYTEARRAY86_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((BYTEARRAY86!=null?BYTEARRAY86.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "simple_type"


    public static class tuple_type_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "tuple_type"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:181:1: tuple_type : ^( TUPLE_TYPE ( field_def_list )? ) ;
    public final AstPrinter.tuple_type_return tuple_type() throws RecognitionException {
        AstPrinter.tuple_type_return retval = new AstPrinter.tuple_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree TUPLE_TYPE87=null;
        AstPrinter.field_def_list_return field_def_list88 =null;


        CommonTree TUPLE_TYPE87_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:182:5: ( ^( TUPLE_TYPE ( field_def_list )? ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:182:7: ^( TUPLE_TYPE ( field_def_list )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            TUPLE_TYPE87=(CommonTree)match(input,TUPLE_TYPE,FOLLOW_TUPLE_TYPE_in_tuple_type1081); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            TUPLE_TYPE87_tree = (CommonTree)adaptor.dupNode(TUPLE_TYPE87);


            root_1 = (CommonTree)adaptor.becomeRoot(TUPLE_TYPE87_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:182:21: ( field_def_list )?
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==FIELD_DEF) ) {
                    alt25=1;
                }
                switch (alt25) {
                    case 1 :
                        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:182:21: field_def_list
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_field_def_list_in_tuple_type1083);
                        field_def_list88=field_def_list();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, field_def_list88.getTree());


                        if ( state.backtracking==0 ) {
                        }
                        }
                        break;

                }


                match(input, Token.UP, null); if (state.failed) return retval;
            }
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "tuple_type"


    public static class bag_type_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "bag_type"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:185:1: bag_type : ^( BAG_TYPE ( ( IDENTIFIER )? tuple_type )? ) ;
    public final AstPrinter.bag_type_return bag_type() throws RecognitionException {
        AstPrinter.bag_type_return retval = new AstPrinter.bag_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BAG_TYPE89=null;
        CommonTree IDENTIFIER90=null;
        AstPrinter.tuple_type_return tuple_type91 =null;


        CommonTree BAG_TYPE89_tree=null;
        CommonTree IDENTIFIER90_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:186:5: ( ^( BAG_TYPE ( ( IDENTIFIER )? tuple_type )? ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:186:7: ^( BAG_TYPE ( ( IDENTIFIER )? tuple_type )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BAG_TYPE89=(CommonTree)match(input,BAG_TYPE,FOLLOW_BAG_TYPE_in_bag_type1102); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BAG_TYPE89_tree = (CommonTree)adaptor.dupNode(BAG_TYPE89);


            root_1 = (CommonTree)adaptor.becomeRoot(BAG_TYPE89_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append("bag{"); }

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:186:42: ( ( IDENTIFIER )? tuple_type )?
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==IDENTIFIER||LA27_0==TUPLE_TYPE) ) {
                    alt27=1;
                }
                switch (alt27) {
                    case 1 :
                        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:186:44: ( IDENTIFIER )? tuple_type
                        {
                        if ( state.backtracking==0 ) { sb.append("T:"); }

                        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:186:65: ( IDENTIFIER )?
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0==IDENTIFIER) ) {
                            alt26=1;
                        }
                        switch (alt26) {
                            case 1 :
                                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:186:65: IDENTIFIER
                                {
                                _last = (CommonTree)input.LT(1);
                                IDENTIFIER90=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_bag_type1110); if (state.failed) return retval;
                                if ( state.backtracking==0 ) {
                                IDENTIFIER90_tree = (CommonTree)adaptor.dupNode(IDENTIFIER90);


                                adaptor.addChild(root_1, IDENTIFIER90_tree);
                                }


                                if ( state.backtracking==0 ) {
                                }
                                }
                                break;

                        }


                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_tuple_type_in_bag_type1113);
                        tuple_type91=tuple_type();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, tuple_type91.getTree());


                        if ( state.backtracking==0 ) {
                        }
                        }
                        break;

                }


                match(input, Token.UP, null); if (state.failed) return retval;
            }
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) { sb.append("}"); }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "bag_type"


    public static class map_type_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "map_type"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:189:1: map_type : ^( MAP_TYPE ( type )? ) ;
    public final AstPrinter.map_type_return map_type() throws RecognitionException {
        AstPrinter.map_type_return retval = new AstPrinter.map_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MAP_TYPE92=null;
        AstPrinter.type_return type93 =null;


        CommonTree MAP_TYPE92_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:189:10: ( ^( MAP_TYPE ( type )? ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:189:12: ^( MAP_TYPE ( type )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            MAP_TYPE92=(CommonTree)match(input,MAP_TYPE,FOLLOW_MAP_TYPE_in_map_type1132); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            MAP_TYPE92_tree = (CommonTree)adaptor.dupNode(MAP_TYPE92);


            root_1 = (CommonTree)adaptor.becomeRoot(MAP_TYPE92_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append("map["); }

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:189:47: ( type )?
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==BOOLEAN||LA28_0==BYTEARRAY||LA28_0==CHARARRAY||LA28_0==DOUBLE||LA28_0==FLOAT||LA28_0==INT||LA28_0==LONG||LA28_0==BAG_TYPE||LA28_0==MAP_TYPE||LA28_0==TUPLE_TYPE) ) {
                    alt28=1;
                }
                switch (alt28) {
                    case 1 :
                        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:189:47: type
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_type_in_map_type1136);
                        type93=type();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, type93.getTree());


                        if ( state.backtracking==0 ) {
                        }
                        }
                        break;

                }


                match(input, Token.UP, null); if (state.failed) return retval;
            }
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) { sb.append("]"); }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "map_type"


    public static class func_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "func_clause"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:192:1: func_clause : ( ^( FUNC_REF func_name ) | ^( FUNC func_name ( func_args )? ) );
    public final AstPrinter.func_clause_return func_clause() throws RecognitionException {
        AstPrinter.func_clause_return retval = new AstPrinter.func_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FUNC_REF94=null;
        CommonTree FUNC96=null;
        AstPrinter.func_name_return func_name95 =null;

        AstPrinter.func_name_return func_name97 =null;

        AstPrinter.func_args_return func_args98 =null;


        CommonTree FUNC_REF94_tree=null;
        CommonTree FUNC96_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:193:5: ( ^( FUNC_REF func_name ) | ^( FUNC func_name ( func_args )? ) )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==FUNC_REF) ) {
                alt30=1;
            }
            else if ( (LA30_0==FUNC) ) {
                alt30=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;

            }
            switch (alt30) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:193:7: ^( FUNC_REF func_name )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FUNC_REF94=(CommonTree)match(input,FUNC_REF,FOLLOW_FUNC_REF_in_func_clause1157); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FUNC_REF94_tree = (CommonTree)adaptor.dupNode(FUNC_REF94);


                    root_1 = (CommonTree)adaptor.becomeRoot(FUNC_REF94_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_name_in_func_clause1159);
                    func_name95=func_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_name95.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:194:7: ^( FUNC func_name ( func_args )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FUNC96=(CommonTree)match(input,FUNC,FOLLOW_FUNC_in_func_clause1171); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FUNC96_tree = (CommonTree)adaptor.dupNode(FUNC96);


                    root_1 = (CommonTree)adaptor.becomeRoot(FUNC96_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_name_in_func_clause1173);
                    func_name97=func_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_name97.getTree());


                    if ( state.backtracking==0 ) { sb.append("("); }

                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:194:45: ( func_args )?
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( (LA29_0==QUOTEDSTRING) ) {
                        alt29=1;
                    }
                    switch (alt29) {
                        case 1 :
                            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:194:45: func_args
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_func_args_in_func_clause1177);
                            func_args98=func_args();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_1, func_args98.getTree());


                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    if ( state.backtracking==0 ) { sb.append(")"); }

                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "func_clause"


    public static class func_name_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "func_name"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:197:1: func_name : eid ( ( PERIOD | DOLLAR ) eid )* ;
    public final AstPrinter.func_name_return func_name() throws RecognitionException {
        AstPrinter.func_name_return retval = new AstPrinter.func_name_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PERIOD100=null;
        CommonTree DOLLAR101=null;
        AstPrinter.eid_return eid99 =null;

        AstPrinter.eid_return eid102 =null;


        CommonTree PERIOD100_tree=null;
        CommonTree DOLLAR101_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:198:5: ( eid ( ( PERIOD | DOLLAR ) eid )* )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:198:7: eid ( ( PERIOD | DOLLAR ) eid )*
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_eid_in_func_name1196);
            eid99=eid();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, eid99.getTree());


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:198:11: ( ( PERIOD | DOLLAR ) eid )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==DOLLAR||LA32_0==PERIOD) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:198:13: ( PERIOD | DOLLAR ) eid
            	    {
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:198:13: ( PERIOD | DOLLAR )
            	    int alt31=2;
            	    int LA31_0 = input.LA(1);

            	    if ( (LA31_0==PERIOD) ) {
            	        alt31=1;
            	    }
            	    else if ( (LA31_0==DOLLAR) ) {
            	        alt31=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 31, 0, input);

            	        throw nvae;

            	    }
            	    switch (alt31) {
            	        case 1 :
            	            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:198:15: PERIOD
            	            {
            	            _last = (CommonTree)input.LT(1);
            	            PERIOD100=(CommonTree)match(input,PERIOD,FOLLOW_PERIOD_in_func_name1202); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            PERIOD100_tree = (CommonTree)adaptor.dupNode(PERIOD100);


            	            adaptor.addChild(root_0, PERIOD100_tree);
            	            }


            	            if ( state.backtracking==0 ) { sb.append((PERIOD100!=null?PERIOD100.getText():null)); }

            	            if ( state.backtracking==0 ) {
            	            }
            	            }
            	            break;
            	        case 2 :
            	            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:198:53: DOLLAR
            	            {
            	            _last = (CommonTree)input.LT(1);
            	            DOLLAR101=(CommonTree)match(input,DOLLAR,FOLLOW_DOLLAR_in_func_name1208); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            DOLLAR101_tree = (CommonTree)adaptor.dupNode(DOLLAR101);


            	            adaptor.addChild(root_0, DOLLAR101_tree);
            	            }


            	            if ( state.backtracking==0 ) { sb.append((DOLLAR101!=null?DOLLAR101.getText():null)); }

            	            if ( state.backtracking==0 ) {
            	            }
            	            }
            	            break;

            	    }


            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_eid_in_func_name1214);
            	    eid102=eid();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, eid102.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "func_name"


    public static class func_args_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "func_args"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:201:1: func_args : a= QUOTEDSTRING (b= QUOTEDSTRING )* ;
    public final AstPrinter.func_args_return func_args() throws RecognitionException {
        AstPrinter.func_args_return retval = new AstPrinter.func_args_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree a=null;
        CommonTree b=null;

        CommonTree a_tree=null;
        CommonTree b_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:202:5: (a= QUOTEDSTRING (b= QUOTEDSTRING )* )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:202:7: a= QUOTEDSTRING (b= QUOTEDSTRING )*
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            a=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_func_args1233); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            a_tree = (CommonTree)adaptor.dupNode(a);


            adaptor.addChild(root_0, a_tree);
            }


            if ( state.backtracking==0 ) { sb.append((a!=null?a.getText():null)); }

            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:203:9: (b= QUOTEDSTRING )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==QUOTEDSTRING) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:203:10: b= QUOTEDSTRING
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    b=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_func_args1248); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    b_tree = (CommonTree)adaptor.dupNode(b);


            	    adaptor.addChild(root_0, b_tree);
            	    }


            	    if ( state.backtracking==0 ) { sb.append(", ").append((b!=null?b.getText():null)); }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "func_args"


    public static class group_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "group_clause"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:206:1: group_clause : ^( ( GROUP | COGROUP ) group_item ( group_item )* ( group_type )? ( partition_clause )? ) ;
    public final AstPrinter.group_clause_return group_clause() throws RecognitionException {
        AstPrinter.group_clause_return retval = new AstPrinter.group_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree GROUP103=null;
        CommonTree COGROUP104=null;
        AstPrinter.group_item_return group_item105 =null;

        AstPrinter.group_item_return group_item106 =null;

        AstPrinter.group_type_return group_type107 =null;

        AstPrinter.partition_clause_return partition_clause108 =null;


        CommonTree GROUP103_tree=null;
        CommonTree COGROUP104_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:207:5: ( ^( ( GROUP | COGROUP ) group_item ( group_item )* ( group_type )? ( partition_clause )? ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:207:7: ^( ( GROUP | COGROUP ) group_item ( group_item )* ( group_type )? ( partition_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:207:10: ( GROUP | COGROUP )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==GROUP) ) {
                alt34=1;
            }
            else if ( (LA34_0==COGROUP) ) {
                alt34=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;

            }
            switch (alt34) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:207:12: GROUP
                    {
                    _last = (CommonTree)input.LT(1);
                    GROUP103=(CommonTree)match(input,GROUP,FOLLOW_GROUP_in_group_clause1270); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    GROUP103_tree = (CommonTree)adaptor.dupNode(GROUP103);


                    adaptor.addChild(root_1, GROUP103_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((GROUP103!=null?GROUP103.getText():null)).append(" "); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:207:60: COGROUP
                    {
                    _last = (CommonTree)input.LT(1);
                    COGROUP104=(CommonTree)match(input,COGROUP,FOLLOW_COGROUP_in_group_clause1276); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    COGROUP104_tree = (CommonTree)adaptor.dupNode(COGROUP104);


                    adaptor.addChild(root_1, COGROUP104_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((COGROUP104!=null?COGROUP104.getText():null)).append(" "); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_group_item_in_group_clause1291);
            group_item105=group_item();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, group_item105.getTree());


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:208:20: ( group_item )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==COGROUP||LA35_0==CROSS||LA35_0==DEFINE||LA35_0==DISTINCT||LA35_0==FILTER||LA35_0==FOREACH||LA35_0==GROUP||LA35_0==JOIN||(LA35_0 >= LIMIT && LA35_0 <= LOAD)||LA35_0==MAPREDUCE||LA35_0==ORDER||LA35_0==SAMPLE||LA35_0==SPLIT||(LA35_0 >= STORE && LA35_0 <= STREAM)||LA35_0==UNION||LA35_0==IDENTIFIER) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:208:22: group_item
            	    {
            	    if ( state.backtracking==0 ) { sb.append(", "); }

            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_group_item_in_group_clause1297);
            	    group_item106=group_item();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, group_item106.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:209:7: ( group_type )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==QUOTEDSTRING) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:209:9: group_type
                    {
                    if ( state.backtracking==0 ) { sb.append(" USING "); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_group_type_in_group_clause1313);
                    group_type107=group_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, group_type107.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:210:7: ( partition_clause )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==PARTITION) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:210:7: partition_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_partition_clause_in_group_clause1325);
                    partition_clause108=partition_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, partition_clause108.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "group_clause"


    public static class group_type_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "group_type"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:214:1: group_type : QUOTEDSTRING ;
    public final AstPrinter.group_type_return group_type() throws RecognitionException {
        AstPrinter.group_type_return retval = new AstPrinter.group_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING109=null;

        CommonTree QUOTEDSTRING109_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:214:12: ( QUOTEDSTRING )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:214:14: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING109=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_group_type1341); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING109_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING109);


            adaptor.addChild(root_0, QUOTEDSTRING109_tree);
            }


            if ( state.backtracking==0 ) { sb.append((QUOTEDSTRING109!=null?QUOTEDSTRING109.getText():null)); }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "group_type"


    public static class group_item_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "group_item"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:217:1: group_item : rel ( join_group_by_clause | ALL | ANY ) ( INNER | OUTER )? ;
    public final AstPrinter.group_item_return group_item() throws RecognitionException {
        AstPrinter.group_item_return retval = new AstPrinter.group_item_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ALL112=null;
        CommonTree ANY113=null;
        CommonTree INNER114=null;
        CommonTree OUTER115=null;
        AstPrinter.rel_return rel110 =null;

        AstPrinter.join_group_by_clause_return join_group_by_clause111 =null;


        CommonTree ALL112_tree=null;
        CommonTree ANY113_tree=null;
        CommonTree INNER114_tree=null;
        CommonTree OUTER115_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:218:5: ( rel ( join_group_by_clause | ALL | ANY ) ( INNER | OUTER )? )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:218:7: rel ( join_group_by_clause | ALL | ANY ) ( INNER | OUTER )?
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_group_item1356);
            rel110=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, rel110.getTree());


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:218:11: ( join_group_by_clause | ALL | ANY )
            int alt38=3;
            switch ( input.LA(1) ) {
            case BY:
                {
                alt38=1;
                }
                break;
            case ALL:
                {
                alt38=2;
                }
                break;
            case ANY:
                {
                alt38=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;

            }

            switch (alt38) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:218:13: join_group_by_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_group_by_clause_in_group_item1360);
                    join_group_by_clause111=join_group_by_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, join_group_by_clause111.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:219:15: ALL
                    {
                    _last = (CommonTree)input.LT(1);
                    ALL112=(CommonTree)match(input,ALL,FOLLOW_ALL_in_group_item1377); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ALL112_tree = (CommonTree)adaptor.dupNode(ALL112);


                    adaptor.addChild(root_0, ALL112_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append(" ").append((ALL112!=null?ALL112.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:219:59: ANY
                    {
                    _last = (CommonTree)input.LT(1);
                    ANY113=(CommonTree)match(input,ANY,FOLLOW_ANY_in_group_item1383); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ANY113_tree = (CommonTree)adaptor.dupNode(ANY113);


                    adaptor.addChild(root_0, ANY113_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append(" ").append((ANY113!=null?ANY113.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:220:13: ( INNER | OUTER )?
            int alt39=3;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==INNER) ) {
                alt39=1;
            }
            else if ( (LA39_0==OUTER) ) {
                alt39=2;
            }
            switch (alt39) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:220:15: INNER
                    {
                    _last = (CommonTree)input.LT(1);
                    INNER114=(CommonTree)match(input,INNER,FOLLOW_INNER_in_group_item1404); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INNER114_tree = (CommonTree)adaptor.dupNode(INNER114);


                    adaptor.addChild(root_0, INNER114_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append(" ").append((INNER114!=null?INNER114.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:220:63: OUTER
                    {
                    _last = (CommonTree)input.LT(1);
                    OUTER115=(CommonTree)match(input,OUTER,FOLLOW_OUTER_in_group_item1410); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OUTER115_tree = (CommonTree)adaptor.dupNode(OUTER115);


                    adaptor.addChild(root_0, OUTER115_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append(" ").append((OUTER115!=null?OUTER115.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "group_item"


    public static class rel_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:223:1: rel : ( alias | ( op_clause ( parallel_clause )? ) );
    public final AstPrinter.rel_return rel() throws RecognitionException {
        AstPrinter.rel_return retval = new AstPrinter.rel_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.alias_return alias116 =null;

        AstPrinter.op_clause_return op_clause117 =null;

        AstPrinter.parallel_clause_return parallel_clause118 =null;



        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:224:5: ( alias | ( op_clause ( parallel_clause )? ) )
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==IDENTIFIER) ) {
                alt41=1;
            }
            else if ( (LA41_0==COGROUP||LA41_0==CROSS||LA41_0==DEFINE||LA41_0==DISTINCT||LA41_0==FILTER||LA41_0==FOREACH||LA41_0==GROUP||LA41_0==JOIN||(LA41_0 >= LIMIT && LA41_0 <= LOAD)||LA41_0==MAPREDUCE||LA41_0==ORDER||LA41_0==SAMPLE||LA41_0==SPLIT||(LA41_0 >= STORE && LA41_0 <= STREAM)||LA41_0==UNION) ) {
                alt41=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;

            }
            switch (alt41) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:224:7: alias
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_alias_in_rel1429);
                    alias116=alias();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, alias116.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:225:7: ( op_clause ( parallel_clause )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:225:7: ( op_clause ( parallel_clause )? )
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:225:9: op_clause ( parallel_clause )?
                    {
                    if ( state.backtracking==0 ) { sb.append(" ("); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_op_clause_in_rel1442);
                    op_clause117=op_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, op_clause117.getTree());


                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:225:40: ( parallel_clause )?
                    int alt40=2;
                    int LA40_0 = input.LA(1);

                    if ( (LA40_0==PARALLEL) ) {
                        alt40=1;
                    }
                    switch (alt40) {
                        case 1 :
                            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:225:40: parallel_clause
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_parallel_clause_in_rel1444);
                            parallel_clause118=parallel_clause();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_0, parallel_clause118.getTree());


                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    if ( state.backtracking==0 ) { sb.append(") "); }

                    if ( state.backtracking==0 ) {
                    }
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rel"


    public static class flatten_generated_item_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "flatten_generated_item"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:228:1: flatten_generated_item : ( flatten_clause | col_range | expr | STAR ) ( field_def_list )? ;
    public final AstPrinter.flatten_generated_item_return flatten_generated_item() throws RecognitionException {
        AstPrinter.flatten_generated_item_return retval = new AstPrinter.flatten_generated_item_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR122=null;
        AstPrinter.flatten_clause_return flatten_clause119 =null;

        AstPrinter.col_range_return col_range120 =null;

        AstPrinter.expr_return expr121 =null;

        AstPrinter.field_def_list_return field_def_list123 =null;


        CommonTree STAR122_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:229:5: ( ( flatten_clause | col_range | expr | STAR ) ( field_def_list )? )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:229:7: ( flatten_clause | col_range | expr | STAR ) ( field_def_list )?
            {
            root_0 = (CommonTree)adaptor.nil();


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:229:7: ( flatten_clause | col_range | expr | STAR )
            int alt42=4;
            switch ( input.LA(1) ) {
            case FLATTEN:
                {
                alt42=1;
                }
                break;
            case COL_RANGE:
                {
                alt42=2;
                }
                break;
            case DIV:
            case DOLLARVAR:
            case DOUBLENUMBER:
            case FALSE:
            case FLOATNUMBER:
            case GROUP:
            case INTEGER:
            case LONGINTEGER:
            case MINUS:
            case PERCENT:
            case PLUS:
            case QUOTEDSTRING:
            case TRUE:
            case BAG_VAL:
            case BIN_EXPR:
            case CAST_EXPR:
            case EXPR_IN_PAREN:
            case FUNC_EVAL:
            case IDENTIFIER:
            case MAP_VAL:
            case NEG:
            case NULL:
            case TUPLE_VAL:
                {
                alt42=3;
                }
                break;
            case STAR:
                {
                int LA42_4 = input.LA(2);

                if ( (LA42_4==DOWN) ) {
                    alt42=3;
                }
                else if ( (LA42_4==EOF||LA42_4==UP||LA42_4==DIV||LA42_4==DOLLARVAR||LA42_4==DOUBLENUMBER||LA42_4==FALSE||LA42_4==FLATTEN||LA42_4==FLOATNUMBER||LA42_4==GROUP||LA42_4==INTEGER||LA42_4==LONGINTEGER||LA42_4==MINUS||LA42_4==PERCENT||LA42_4==PLUS||LA42_4==QUOTEDSTRING||LA42_4==STAR||LA42_4==TRUE||(LA42_4 >= BAG_VAL && LA42_4 <= BIN_EXPR)||(LA42_4 >= CAST_EXPR && LA42_4 <= FIELD_DEF)||LA42_4==FUNC_EVAL||LA42_4==IDENTIFIER||(LA42_4 >= MAP_VAL && LA42_4 <= NEG)||LA42_4==NULL||LA42_4==TUPLE_VAL) ) {
                    alt42=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 42, 4, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;

            }

            switch (alt42) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:229:9: flatten_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_flatten_clause_in_flatten_generated_item1465);
                    flatten_clause119=flatten_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, flatten_clause119.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:229:26: col_range
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_flatten_generated_item1469);
                    col_range120=col_range();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range120.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:229:38: expr
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_flatten_generated_item1473);
                    expr121=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expr121.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:229:45: STAR
                    {
                    _last = (CommonTree)input.LT(1);
                    STAR122=(CommonTree)match(input,STAR,FOLLOW_STAR_in_flatten_generated_item1477); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR122_tree = (CommonTree)adaptor.dupNode(STAR122);


                    adaptor.addChild(root_0, STAR122_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append(" ").append((STAR122!=null?STAR122.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:229:91: ( field_def_list )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==FIELD_DEF) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:229:93: field_def_list
                    {
                    if ( state.backtracking==0 ) { sb.append(" AS "); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_field_def_list_in_flatten_generated_item1487);
                    field_def_list123=field_def_list();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, field_def_list123.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "flatten_generated_item"


    public static class flatten_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "flatten_clause"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:232:1: flatten_clause : ^( FLATTEN expr ) ;
    public final AstPrinter.flatten_clause_return flatten_clause() throws RecognitionException {
        AstPrinter.flatten_clause_return retval = new AstPrinter.flatten_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FLATTEN124=null;
        AstPrinter.expr_return expr125 =null;


        CommonTree FLATTEN124_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:233:5: ( ^( FLATTEN expr ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:233:7: ^( FLATTEN expr )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FLATTEN124=(CommonTree)match(input,FLATTEN,FOLLOW_FLATTEN_in_flatten_clause1505); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FLATTEN124_tree = (CommonTree)adaptor.dupNode(FLATTEN124);


            root_1 = (CommonTree)adaptor.becomeRoot(FLATTEN124_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((FLATTEN124!=null?FLATTEN124.getText():null)).append("("); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expr_in_flatten_clause1509);
            expr125=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, expr125.getTree());


            if ( state.backtracking==0 ) { sb.append(") "); }

            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "flatten_clause"


    public static class store_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "store_clause"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:236:1: store_clause : ^( STORE rel filename ( func_clause )? ) ;
    public final AstPrinter.store_clause_return store_clause() throws RecognitionException {
        AstPrinter.store_clause_return retval = new AstPrinter.store_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STORE126=null;
        AstPrinter.rel_return rel127 =null;

        AstPrinter.filename_return filename128 =null;

        AstPrinter.func_clause_return func_clause129 =null;


        CommonTree STORE126_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:237:5: ( ^( STORE rel filename ( func_clause )? ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:237:7: ^( STORE rel filename ( func_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            STORE126=(CommonTree)match(input,STORE,FOLLOW_STORE_in_store_clause1529); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STORE126_tree = (CommonTree)adaptor.dupNode(STORE126);


            root_1 = (CommonTree)adaptor.becomeRoot(STORE126_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((STORE126!=null?STORE126.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_store_clause1533);
            rel127=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel127.getTree());


            if ( state.backtracking==0 ) { sb.append(" INTO "); }

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_filename_in_store_clause1537);
            filename128=filename();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, filename128.getTree());


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:237:94: ( func_clause )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==FUNC||LA44_0==FUNC_REF) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:237:96: func_clause
                    {
                    if ( state.backtracking==0 ) { sb.append(" USING "); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_store_clause1543);
                    func_clause129=func_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause129.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "store_clause"


    public static class filter_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "filter_clause"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:240:1: filter_clause : ^( FILTER rel cond ) ;
    public final AstPrinter.filter_clause_return filter_clause() throws RecognitionException {
        AstPrinter.filter_clause_return retval = new AstPrinter.filter_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FILTER130=null;
        AstPrinter.rel_return rel131 =null;

        AstPrinter.cond_return cond132 =null;


        CommonTree FILTER130_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:241:5: ( ^( FILTER rel cond ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:241:7: ^( FILTER rel cond )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FILTER130=(CommonTree)match(input,FILTER,FOLLOW_FILTER_in_filter_clause1563); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FILTER130_tree = (CommonTree)adaptor.dupNode(FILTER130);


            root_1 = (CommonTree)adaptor.becomeRoot(FILTER130_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((FILTER130!=null?FILTER130.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_filter_clause1567);
            rel131=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel131.getTree());


            if ( state.backtracking==0 ) { sb.append(" BY ("); }

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_filter_clause1571);
            cond132=cond();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond132.getTree());


            if ( state.backtracking==0 ) { sb.append(")"); }

            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "filter_clause"


    public static class cond_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cond"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:244:1: cond : ( ^( OR cond cond ) | ^( AND cond cond ) | ^( NOT cond ) | ^( NULL expr ( NOT )? ) | ^( rel_op expr expr ) | func_eval );
    public final AstPrinter.cond_return cond() throws RecognitionException {
        AstPrinter.cond_return retval = new AstPrinter.cond_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree OR133=null;
        CommonTree AND136=null;
        CommonTree NOT139=null;
        CommonTree NULL141=null;
        CommonTree NOT143=null;
        AstPrinter.cond_return cond134 =null;

        AstPrinter.cond_return cond135 =null;

        AstPrinter.cond_return cond137 =null;

        AstPrinter.cond_return cond138 =null;

        AstPrinter.cond_return cond140 =null;

        AstPrinter.expr_return expr142 =null;

        AstPrinter.rel_op_return rel_op144 =null;

        AstPrinter.expr_return expr145 =null;

        AstPrinter.expr_return expr146 =null;

        AstPrinter.func_eval_return func_eval147 =null;


        CommonTree OR133_tree=null;
        CommonTree AND136_tree=null;
        CommonTree NOT139_tree=null;
        CommonTree NULL141_tree=null;
        CommonTree NOT143_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:245:5: ( ^( OR cond cond ) | ^( AND cond cond ) | ^( NOT cond ) | ^( NULL expr ( NOT )? ) | ^( rel_op expr expr ) | func_eval )
            int alt46=6;
            switch ( input.LA(1) ) {
            case OR:
                {
                alt46=1;
                }
                break;
            case AND:
                {
                alt46=2;
                }
                break;
            case NOT:
                {
                alt46=3;
                }
                break;
            case NULL:
                {
                alt46=4;
                }
                break;
            case NUM_OP_EQ:
            case NUM_OP_GT:
            case NUM_OP_GTE:
            case NUM_OP_LT:
            case NUM_OP_LTE:
            case NUM_OP_NE:
            case STR_OP_EQ:
            case STR_OP_GT:
            case STR_OP_GTE:
            case STR_OP_LT:
            case STR_OP_LTE:
            case STR_OP_MATCHES:
            case STR_OP_NE:
                {
                alt46=5;
                }
                break;
            case FUNC_EVAL:
                {
                alt46=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;

            }

            switch (alt46) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:245:7: ^( OR cond cond )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    OR133=(CommonTree)match(input,OR,FOLLOW_OR_in_cond1591); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OR133_tree = (CommonTree)adaptor.dupNode(OR133);


                    root_1 = (CommonTree)adaptor.becomeRoot(OR133_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { sb.append("("); }

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond1595);
                    cond134=cond();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cond134.getTree());


                    if ( state.backtracking==0 ) { sb.append(") ").append((OR133!=null?OR133.getText():null)).append(" ("); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond1599);
                    cond135=cond();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cond135.getTree());


                    if ( state.backtracking==0 ) { sb.append(")"); }

                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:246:7: ^( AND cond cond )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    AND136=(CommonTree)match(input,AND,FOLLOW_AND_in_cond1613); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    AND136_tree = (CommonTree)adaptor.dupNode(AND136);


                    root_1 = (CommonTree)adaptor.becomeRoot(AND136_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { sb.append("("); }

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond1617);
                    cond137=cond();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cond137.getTree());


                    if ( state.backtracking==0 ) { sb.append(") ").append((AND136!=null?AND136.getText():null)).append(" ("); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond1621);
                    cond138=cond();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cond138.getTree());


                    if ( state.backtracking==0 ) { sb.append(")"); }

                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:247:7: ^( NOT cond )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NOT139=(CommonTree)match(input,NOT,FOLLOW_NOT_in_cond1635); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NOT139_tree = (CommonTree)adaptor.dupNode(NOT139);


                    root_1 = (CommonTree)adaptor.becomeRoot(NOT139_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { sb.append(" ").append((NOT139!=null?NOT139.getText():null)).append(" ("); }

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond1639);
                    cond140=cond();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cond140.getTree());


                    if ( state.backtracking==0 ) { sb.append(")"); }

                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:248:7: ^( NULL expr ( NOT )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NULL141=(CommonTree)match(input,NULL,FOLLOW_NULL_in_cond1653); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NULL141_tree = (CommonTree)adaptor.dupNode(NULL141);


                    root_1 = (CommonTree)adaptor.becomeRoot(NULL141_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond1655);
                    expr142=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr142.getTree());


                    if ( state.backtracking==0 ) { sb.append(" IS "); }

                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:248:43: ( NOT )?
                    int alt45=2;
                    int LA45_0 = input.LA(1);

                    if ( (LA45_0==NOT) ) {
                        alt45=1;
                    }
                    switch (alt45) {
                        case 1 :
                            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:248:44: NOT
                            {
                            _last = (CommonTree)input.LT(1);
                            NOT143=(CommonTree)match(input,NOT,FOLLOW_NOT_in_cond1660); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            NOT143_tree = (CommonTree)adaptor.dupNode(NOT143);


                            adaptor.addChild(root_1, NOT143_tree);
                            }


                            if ( state.backtracking==0 ) { sb.append((NOT143!=null?NOT143.getText():null)).append(" "); }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    if ( state.backtracking==0 ) { sb.append((NULL141!=null?NULL141.getText():null)); }

                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:249:7: ^( rel_op expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_in_cond1680);
                    rel_op144=rel_op();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_1 = (CommonTree)adaptor.becomeRoot(rel_op144.getTree(), root_1);


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond1682);
                    expr145=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr145.getTree());


                    if ( state.backtracking==0 ) { sb.append(" ").append((rel_op144!=null?rel_op144.result:null)).append(" "); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond1686);
                    expr146=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr146.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:250:7: func_eval
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_eval_in_cond1696);
                    func_eval147=func_eval();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, func_eval147.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "cond"


    public static class func_eval_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "func_eval"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:253:1: func_eval : ( ^( FUNC_EVAL func_name real_arg ( real_arg )* ) | ^( FUNC_EVAL func_name ) );
    public final AstPrinter.func_eval_return func_eval() throws RecognitionException {
        AstPrinter.func_eval_return retval = new AstPrinter.func_eval_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FUNC_EVAL148=null;
        CommonTree FUNC_EVAL152=null;
        AstPrinter.func_name_return func_name149 =null;

        AstPrinter.real_arg_return real_arg150 =null;

        AstPrinter.real_arg_return real_arg151 =null;

        AstPrinter.func_name_return func_name153 =null;


        CommonTree FUNC_EVAL148_tree=null;
        CommonTree FUNC_EVAL152_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:254:5: ( ^( FUNC_EVAL func_name real_arg ( real_arg )* ) | ^( FUNC_EVAL func_name ) )
            int alt48=2;
            alt48 = dfa48.predict(input);
            switch (alt48) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:254:7: ^( FUNC_EVAL func_name real_arg ( real_arg )* )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FUNC_EVAL148=(CommonTree)match(input,FUNC_EVAL,FOLLOW_FUNC_EVAL_in_func_eval1711); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FUNC_EVAL148_tree = (CommonTree)adaptor.dupNode(FUNC_EVAL148);


                    root_1 = (CommonTree)adaptor.becomeRoot(FUNC_EVAL148_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_name_in_func_eval1713);
                    func_name149=func_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_name149.getTree());


                    if ( state.backtracking==0 ) { sb.append("("); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_real_arg_in_func_eval1717);
                    real_arg150=real_arg();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, real_arg150.getTree());


                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:254:59: ( real_arg )*
                    loop47:
                    do {
                        int alt47=2;
                        int LA47_0 = input.LA(1);

                        if ( (LA47_0==DIV||LA47_0==DOLLARVAR||LA47_0==DOUBLENUMBER||LA47_0==FALSE||LA47_0==FLOATNUMBER||LA47_0==GROUP||LA47_0==INTEGER||LA47_0==LONGINTEGER||LA47_0==MINUS||LA47_0==PERCENT||LA47_0==PLUS||LA47_0==QUOTEDSTRING||LA47_0==STAR||LA47_0==TRUE||(LA47_0 >= BAG_VAL && LA47_0 <= BIN_EXPR)||(LA47_0 >= CAST_EXPR && LA47_0 <= EXPR_IN_PAREN)||LA47_0==FUNC_EVAL||LA47_0==IDENTIFIER||(LA47_0 >= MAP_VAL && LA47_0 <= NEG)||LA47_0==NULL||LA47_0==TUPLE_VAL) ) {
                            alt47=1;
                        }


                        switch (alt47) {
                    	case 1 :
                    	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:254:61: real_arg
                    	    {
                    	    if ( state.backtracking==0 ) { sb.append(", "); }

                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_real_arg_in_func_eval1723);
                    	    real_arg151=real_arg();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, real_arg151.getTree());


                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop47;
                        }
                    } while (true);


                    if ( state.backtracking==0 ) { sb.append(")"); }

                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:255:7: ^( FUNC_EVAL func_name )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FUNC_EVAL152=(CommonTree)match(input,FUNC_EVAL,FOLLOW_FUNC_EVAL_in_func_eval1739); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FUNC_EVAL152_tree = (CommonTree)adaptor.dupNode(FUNC_EVAL152);


                    root_1 = (CommonTree)adaptor.becomeRoot(FUNC_EVAL152_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_name_in_func_eval1741);
                    func_name153=func_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_name153.getTree());


                    if ( state.backtracking==0 ) { sb.append("()"); }

                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "func_eval"


    public static class real_arg_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "real_arg"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:258:1: real_arg : ( expr | STAR | col_range );
    public final AstPrinter.real_arg_return real_arg() throws RecognitionException {
        AstPrinter.real_arg_return retval = new AstPrinter.real_arg_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR155=null;
        AstPrinter.expr_return expr154 =null;

        AstPrinter.col_range_return col_range156 =null;


        CommonTree STAR155_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:259:5: ( expr | STAR | col_range )
            int alt49=3;
            switch ( input.LA(1) ) {
            case DIV:
            case DOLLARVAR:
            case DOUBLENUMBER:
            case FALSE:
            case FLOATNUMBER:
            case GROUP:
            case INTEGER:
            case LONGINTEGER:
            case MINUS:
            case PERCENT:
            case PLUS:
            case QUOTEDSTRING:
            case TRUE:
            case BAG_VAL:
            case BIN_EXPR:
            case CAST_EXPR:
            case EXPR_IN_PAREN:
            case FUNC_EVAL:
            case IDENTIFIER:
            case MAP_VAL:
            case NEG:
            case NULL:
            case TUPLE_VAL:
                {
                alt49=1;
                }
                break;
            case STAR:
                {
                int LA49_2 = input.LA(2);

                if ( (LA49_2==DOWN) ) {
                    alt49=1;
                }
                else if ( (LA49_2==EOF||LA49_2==UP||LA49_2==DIV||LA49_2==DOLLARVAR||LA49_2==DOUBLENUMBER||LA49_2==FALSE||LA49_2==FLOATNUMBER||LA49_2==GROUP||LA49_2==INTEGER||LA49_2==LONGINTEGER||LA49_2==MINUS||LA49_2==PERCENT||LA49_2==PLUS||LA49_2==QUOTEDSTRING||LA49_2==STAR||LA49_2==TRUE||(LA49_2 >= BAG_VAL && LA49_2 <= BIN_EXPR)||(LA49_2 >= CAST_EXPR && LA49_2 <= EXPR_IN_PAREN)||LA49_2==FUNC_EVAL||LA49_2==IDENTIFIER||(LA49_2 >= MAP_VAL && LA49_2 <= NEG)||LA49_2==NULL||LA49_2==TUPLE_VAL) ) {
                    alt49=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 49, 2, input);

                    throw nvae;

                }
                }
                break;
            case COL_RANGE:
                {
                alt49=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;

            }

            switch (alt49) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:259:7: expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_real_arg1760);
                    expr154=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expr154.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:259:14: STAR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR155=(CommonTree)match(input,STAR,FOLLOW_STAR_in_real_arg1764); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR155_tree = (CommonTree)adaptor.dupNode(STAR155);


                    adaptor.addChild(root_0, STAR155_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((STAR155!=null?STAR155.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:259:48: col_range
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_real_arg1770);
                    col_range156=col_range();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range156.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "real_arg"


    public static class expr_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "expr"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:262:1: expr : ( ^( PLUS expr expr ) | ^( MINUS expr expr ) | ^( STAR expr expr ) | ^( DIV expr expr ) | ^( PERCENT expr expr ) | ^( CAST_EXPR type expr ) | const_expr | var_expr | ^( NEG expr ) | ^( CAST_EXPR type_cast expr ) | ^( EXPR_IN_PAREN expr ) );
    public final AstPrinter.expr_return expr() throws RecognitionException {
        AstPrinter.expr_return retval = new AstPrinter.expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PLUS157=null;
        CommonTree MINUS160=null;
        CommonTree STAR163=null;
        CommonTree DIV166=null;
        CommonTree PERCENT169=null;
        CommonTree CAST_EXPR172=null;
        CommonTree NEG177=null;
        CommonTree CAST_EXPR179=null;
        CommonTree EXPR_IN_PAREN182=null;
        AstPrinter.expr_return expr158 =null;

        AstPrinter.expr_return expr159 =null;

        AstPrinter.expr_return expr161 =null;

        AstPrinter.expr_return expr162 =null;

        AstPrinter.expr_return expr164 =null;

        AstPrinter.expr_return expr165 =null;

        AstPrinter.expr_return expr167 =null;

        AstPrinter.expr_return expr168 =null;

        AstPrinter.expr_return expr170 =null;

        AstPrinter.expr_return expr171 =null;

        AstPrinter.type_return type173 =null;

        AstPrinter.expr_return expr174 =null;

        AstPrinter.const_expr_return const_expr175 =null;

        AstPrinter.var_expr_return var_expr176 =null;

        AstPrinter.expr_return expr178 =null;

        AstPrinter.type_cast_return type_cast180 =null;

        AstPrinter.expr_return expr181 =null;

        AstPrinter.expr_return expr183 =null;


        CommonTree PLUS157_tree=null;
        CommonTree MINUS160_tree=null;
        CommonTree STAR163_tree=null;
        CommonTree DIV166_tree=null;
        CommonTree PERCENT169_tree=null;
        CommonTree CAST_EXPR172_tree=null;
        CommonTree NEG177_tree=null;
        CommonTree CAST_EXPR179_tree=null;
        CommonTree EXPR_IN_PAREN182_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:263:5: ( ^( PLUS expr expr ) | ^( MINUS expr expr ) | ^( STAR expr expr ) | ^( DIV expr expr ) | ^( PERCENT expr expr ) | ^( CAST_EXPR type expr ) | const_expr | var_expr | ^( NEG expr ) | ^( CAST_EXPR type_cast expr ) | ^( EXPR_IN_PAREN expr ) )
            int alt50=11;
            switch ( input.LA(1) ) {
            case PLUS:
                {
                alt50=1;
                }
                break;
            case MINUS:
                {
                int LA50_2 = input.LA(2);

                if ( (synpred87_AstPrinter()) ) {
                    alt50=2;
                }
                else if ( (synpred92_AstPrinter()) ) {
                    alt50=7;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 50, 2, input);

                    throw nvae;

                }
                }
                break;
            case STAR:
                {
                alt50=3;
                }
                break;
            case DIV:
                {
                alt50=4;
                }
                break;
            case PERCENT:
                {
                alt50=5;
                }
                break;
            case CAST_EXPR:
                {
                int LA50_6 = input.LA(2);

                if ( (synpred91_AstPrinter()) ) {
                    alt50=6;
                }
                else if ( (synpred95_AstPrinter()) ) {
                    alt50=10;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 50, 6, input);

                    throw nvae;

                }
                }
                break;
            case DOUBLENUMBER:
            case FALSE:
            case FLOATNUMBER:
            case INTEGER:
            case LONGINTEGER:
            case QUOTEDSTRING:
            case TRUE:
            case BAG_VAL:
            case MAP_VAL:
            case NULL:
            case TUPLE_VAL:
                {
                alt50=7;
                }
                break;
            case DOLLARVAR:
            case GROUP:
            case BIN_EXPR:
            case FUNC_EVAL:
            case IDENTIFIER:
                {
                alt50=8;
                }
                break;
            case NEG:
                {
                alt50=9;
                }
                break;
            case EXPR_IN_PAREN:
                {
                alt50=11;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;

            }

            switch (alt50) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:263:7: ^( PLUS expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    PLUS157=(CommonTree)match(input,PLUS,FOLLOW_PLUS_in_expr1786); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PLUS157_tree = (CommonTree)adaptor.dupNode(PLUS157);


                    root_1 = (CommonTree)adaptor.becomeRoot(PLUS157_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1788);
                    expr158=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr158.getTree());


                    if ( state.backtracking==0 ) { sb.append(" ").append((PLUS157!=null?PLUS157.getText():null)).append(" "); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1792);
                    expr159=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr159.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:264:7: ^( MINUS expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    MINUS160=(CommonTree)match(input,MINUS,FOLLOW_MINUS_in_expr1804); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MINUS160_tree = (CommonTree)adaptor.dupNode(MINUS160);


                    root_1 = (CommonTree)adaptor.becomeRoot(MINUS160_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1806);
                    expr161=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr161.getTree());


                    if ( state.backtracking==0 ) { sb.append(" ").append((MINUS160!=null?MINUS160.getText():null)).append(" "); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1810);
                    expr162=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr162.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:265:7: ^( STAR expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    STAR163=(CommonTree)match(input,STAR,FOLLOW_STAR_in_expr1822); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR163_tree = (CommonTree)adaptor.dupNode(STAR163);


                    root_1 = (CommonTree)adaptor.becomeRoot(STAR163_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1824);
                    expr164=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr164.getTree());


                    if ( state.backtracking==0 ) { sb.append(" ").append((STAR163!=null?STAR163.getText():null)).append(" "); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1828);
                    expr165=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr165.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:266:7: ^( DIV expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    DIV166=(CommonTree)match(input,DIV,FOLLOW_DIV_in_expr1840); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DIV166_tree = (CommonTree)adaptor.dupNode(DIV166);


                    root_1 = (CommonTree)adaptor.becomeRoot(DIV166_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1842);
                    expr167=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr167.getTree());


                    if ( state.backtracking==0 ) { sb.append(" ").append((DIV166!=null?DIV166.getText():null)).append(" "); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1846);
                    expr168=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr168.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:267:7: ^( PERCENT expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    PERCENT169=(CommonTree)match(input,PERCENT,FOLLOW_PERCENT_in_expr1858); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PERCENT169_tree = (CommonTree)adaptor.dupNode(PERCENT169);


                    root_1 = (CommonTree)adaptor.becomeRoot(PERCENT169_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1860);
                    expr170=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr170.getTree());


                    if ( state.backtracking==0 ) { sb.append(" ").append((PERCENT169!=null?PERCENT169.getText():null)).append(" "); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1864);
                    expr171=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr171.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:268:7: ^( CAST_EXPR type expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    CAST_EXPR172=(CommonTree)match(input,CAST_EXPR,FOLLOW_CAST_EXPR_in_expr1876); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CAST_EXPR172_tree = (CommonTree)adaptor.dupNode(CAST_EXPR172);


                    root_1 = (CommonTree)adaptor.becomeRoot(CAST_EXPR172_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { sb.append("("); }

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_type_in_expr1880);
                    type173=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, type173.getTree());


                    if ( state.backtracking==0 ) { sb.append(")"); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1884);
                    expr174=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr174.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:269:7: const_expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_const_expr_in_expr1894);
                    const_expr175=const_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, const_expr175.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:270:7: var_expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_var_expr_in_expr1902);
                    var_expr176=var_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, var_expr176.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:271:7: ^( NEG expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NEG177=(CommonTree)match(input,NEG,FOLLOW_NEG_in_expr1912); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NEG177_tree = (CommonTree)adaptor.dupNode(NEG177);


                    root_1 = (CommonTree)adaptor.becomeRoot(NEG177_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { sb.append((NEG177!=null?NEG177.getText():null)); }

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1916);
                    expr178=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr178.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:272:7: ^( CAST_EXPR type_cast expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    CAST_EXPR179=(CommonTree)match(input,CAST_EXPR,FOLLOW_CAST_EXPR_in_expr1928); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CAST_EXPR179_tree = (CommonTree)adaptor.dupNode(CAST_EXPR179);


                    root_1 = (CommonTree)adaptor.becomeRoot(CAST_EXPR179_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { sb.append("("); }

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_type_cast_in_expr1932);
                    type_cast180=type_cast();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, type_cast180.getTree());


                    if ( state.backtracking==0 ) { sb.append(")"); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1936);
                    expr181=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr181.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 11 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:273:7: ^( EXPR_IN_PAREN expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    EXPR_IN_PAREN182=(CommonTree)match(input,EXPR_IN_PAREN,FOLLOW_EXPR_IN_PAREN_in_expr1948); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EXPR_IN_PAREN182_tree = (CommonTree)adaptor.dupNode(EXPR_IN_PAREN182);


                    root_1 = (CommonTree)adaptor.becomeRoot(EXPR_IN_PAREN182_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { sb.append("("); }

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1952);
                    expr183=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr183.getTree());


                    if ( state.backtracking==0 ) { sb.append(")"); }

                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "expr"


    public static class type_cast_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "type_cast"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:276:1: type_cast : ( simple_type | map_type | tuple_type_cast | bag_type_cast );
    public final AstPrinter.type_cast_return type_cast() throws RecognitionException {
        AstPrinter.type_cast_return retval = new AstPrinter.type_cast_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.simple_type_return simple_type184 =null;

        AstPrinter.map_type_return map_type185 =null;

        AstPrinter.tuple_type_cast_return tuple_type_cast186 =null;

        AstPrinter.bag_type_cast_return bag_type_cast187 =null;



        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:277:5: ( simple_type | map_type | tuple_type_cast | bag_type_cast )
            int alt51=4;
            switch ( input.LA(1) ) {
            case BOOLEAN:
            case BYTEARRAY:
            case CHARARRAY:
            case DOUBLE:
            case FLOAT:
            case INT:
            case LONG:
                {
                alt51=1;
                }
                break;
            case MAP_TYPE:
                {
                alt51=2;
                }
                break;
            case TUPLE_TYPE_CAST:
                {
                alt51=3;
                }
                break;
            case BAG_TYPE_CAST:
                {
                alt51=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;

            }

            switch (alt51) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:277:7: simple_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_simple_type_in_type_cast1970);
                    simple_type184=simple_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, simple_type184.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:277:21: map_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_map_type_in_type_cast1974);
                    map_type185=map_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, map_type185.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:277:32: tuple_type_cast
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_tuple_type_cast_in_type_cast1978);
                    tuple_type_cast186=tuple_type_cast();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, tuple_type_cast186.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:277:50: bag_type_cast
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_bag_type_cast_in_type_cast1982);
                    bag_type_cast187=bag_type_cast();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, bag_type_cast187.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "type_cast"


    public static class tuple_type_cast_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "tuple_type_cast"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:280:1: tuple_type_cast : ( ^( TUPLE_TYPE_CAST type_cast ( type_cast )* ) | ^( TUPLE_TYPE_CAST ( type_cast )? ) );
    public final AstPrinter.tuple_type_cast_return tuple_type_cast() throws RecognitionException {
        AstPrinter.tuple_type_cast_return retval = new AstPrinter.tuple_type_cast_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree TUPLE_TYPE_CAST188=null;
        CommonTree TUPLE_TYPE_CAST191=null;
        AstPrinter.type_cast_return type_cast189 =null;

        AstPrinter.type_cast_return type_cast190 =null;

        AstPrinter.type_cast_return type_cast192 =null;


        CommonTree TUPLE_TYPE_CAST188_tree=null;
        CommonTree TUPLE_TYPE_CAST191_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:281:5: ( ^( TUPLE_TYPE_CAST type_cast ( type_cast )* ) | ^( TUPLE_TYPE_CAST ( type_cast )? ) )
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==TUPLE_TYPE_CAST) ) {
                int LA54_1 = input.LA(2);

                if ( (synpred100_AstPrinter()) ) {
                    alt54=1;
                }
                else if ( (true) ) {
                    alt54=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 54, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 54, 0, input);

                throw nvae;

            }
            switch (alt54) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:281:7: ^( TUPLE_TYPE_CAST type_cast ( type_cast )* )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    TUPLE_TYPE_CAST188=(CommonTree)match(input,TUPLE_TYPE_CAST,FOLLOW_TUPLE_TYPE_CAST_in_tuple_type_cast1998); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TUPLE_TYPE_CAST188_tree = (CommonTree)adaptor.dupNode(TUPLE_TYPE_CAST188);


                    root_1 = (CommonTree)adaptor.becomeRoot(TUPLE_TYPE_CAST188_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { sb.append("tuple("); }

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_type_cast_in_tuple_type_cast2002);
                    type_cast189=type_cast();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, type_cast189.getTree());


                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:281:61: ( type_cast )*
                    loop52:
                    do {
                        int alt52=2;
                        int LA52_0 = input.LA(1);

                        if ( (LA52_0==BOOLEAN||LA52_0==BYTEARRAY||LA52_0==CHARARRAY||LA52_0==DOUBLE||LA52_0==FLOAT||LA52_0==INT||LA52_0==LONG||LA52_0==BAG_TYPE_CAST||LA52_0==MAP_TYPE||LA52_0==TUPLE_TYPE_CAST) ) {
                            alt52=1;
                        }


                        switch (alt52) {
                    	case 1 :
                    	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:281:63: type_cast
                    	    {
                    	    if ( state.backtracking==0 ) {sb.append(", "); }

                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_type_cast_in_tuple_type_cast2008);
                    	    type_cast190=type_cast();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, type_cast190.getTree());


                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop52;
                        }
                    } while (true);


                    if ( state.backtracking==0 ) {sb.append(")"); }

                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:282:7: ^( TUPLE_TYPE_CAST ( type_cast )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    TUPLE_TYPE_CAST191=(CommonTree)match(input,TUPLE_TYPE_CAST,FOLLOW_TUPLE_TYPE_CAST_in_tuple_type_cast2024); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TUPLE_TYPE_CAST191_tree = (CommonTree)adaptor.dupNode(TUPLE_TYPE_CAST191);


                    root_1 = (CommonTree)adaptor.becomeRoot(TUPLE_TYPE_CAST191_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { sb.append("tuple("); }

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
                        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:282:51: ( type_cast )?
                        int alt53=2;
                        int LA53_0 = input.LA(1);

                        if ( (LA53_0==BOOLEAN||LA53_0==BYTEARRAY||LA53_0==CHARARRAY||LA53_0==DOUBLE||LA53_0==FLOAT||LA53_0==INT||LA53_0==LONG||LA53_0==BAG_TYPE_CAST||LA53_0==MAP_TYPE||LA53_0==TUPLE_TYPE_CAST) ) {
                            alt53=1;
                        }
                        switch (alt53) {
                            case 1 :
                                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:282:51: type_cast
                                {
                                _last = (CommonTree)input.LT(1);
                                pushFollow(FOLLOW_type_cast_in_tuple_type_cast2028);
                                type_cast192=type_cast();

                                state._fsp--;
                                if (state.failed) return retval;
                                if ( state.backtracking==0 ) 
                                adaptor.addChild(root_1, type_cast192.getTree());


                                if ( state.backtracking==0 ) {
                                }
                                }
                                break;

                        }


                        if ( state.backtracking==0 ) {sb.append(")"); }

                        match(input, Token.UP, null); if (state.failed) return retval;
                    }
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "tuple_type_cast"


    public static class bag_type_cast_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "bag_type_cast"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:285:1: bag_type_cast : ^( BAG_TYPE_CAST ( tuple_type_cast )? ) ;
    public final AstPrinter.bag_type_cast_return bag_type_cast() throws RecognitionException {
        AstPrinter.bag_type_cast_return retval = new AstPrinter.bag_type_cast_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BAG_TYPE_CAST193=null;
        AstPrinter.tuple_type_cast_return tuple_type_cast194 =null;


        CommonTree BAG_TYPE_CAST193_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:286:5: ( ^( BAG_TYPE_CAST ( tuple_type_cast )? ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:286:7: ^( BAG_TYPE_CAST ( tuple_type_cast )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BAG_TYPE_CAST193=(CommonTree)match(input,BAG_TYPE_CAST,FOLLOW_BAG_TYPE_CAST_in_bag_type_cast2049); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BAG_TYPE_CAST193_tree = (CommonTree)adaptor.dupNode(BAG_TYPE_CAST193);


            root_1 = (CommonTree)adaptor.becomeRoot(BAG_TYPE_CAST193_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append("bag{"); }

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:286:47: ( tuple_type_cast )?
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==TUPLE_TYPE_CAST) ) {
                    alt55=1;
                }
                switch (alt55) {
                    case 1 :
                        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:286:47: tuple_type_cast
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_tuple_type_cast_in_bag_type_cast2053);
                        tuple_type_cast194=tuple_type_cast();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, tuple_type_cast194.getTree());


                        if ( state.backtracking==0 ) {
                        }
                        }
                        break;

                }


                if ( state.backtracking==0 ) {sb.append("}"); }

                match(input, Token.UP, null); if (state.failed) return retval;
            }
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "bag_type_cast"


    public static class var_expr_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "var_expr"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:289:1: var_expr : projectable_expr ( dot_proj | pound_proj )* ;
    public final AstPrinter.var_expr_return var_expr() throws RecognitionException {
        AstPrinter.var_expr_return retval = new AstPrinter.var_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.projectable_expr_return projectable_expr195 =null;

        AstPrinter.dot_proj_return dot_proj196 =null;

        AstPrinter.pound_proj_return pound_proj197 =null;



        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:290:5: ( projectable_expr ( dot_proj | pound_proj )* )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:290:7: projectable_expr ( dot_proj | pound_proj )*
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_projectable_expr_in_var_expr2072);
            projectable_expr195=projectable_expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, projectable_expr195.getTree());


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:290:24: ( dot_proj | pound_proj )*
            loop56:
            do {
                int alt56=3;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==PERIOD) ) {
                    alt56=1;
                }
                else if ( (LA56_0==POUND) ) {
                    alt56=2;
                }


                switch (alt56) {
            	case 1 :
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:290:26: dot_proj
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_dot_proj_in_var_expr2076);
            	    dot_proj196=dot_proj();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, dot_proj196.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;
            	case 2 :
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:290:37: pound_proj
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_pound_proj_in_var_expr2080);
            	    pound_proj197=pound_proj();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, pound_proj197.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop56;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "var_expr"


    public static class projectable_expr_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "projectable_expr"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:293:1: projectable_expr : ( func_eval | col_ref | bin_expr );
    public final AstPrinter.projectable_expr_return projectable_expr() throws RecognitionException {
        AstPrinter.projectable_expr_return retval = new AstPrinter.projectable_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.func_eval_return func_eval198 =null;

        AstPrinter.col_ref_return col_ref199 =null;

        AstPrinter.bin_expr_return bin_expr200 =null;



        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:294:5: ( func_eval | col_ref | bin_expr )
            int alt57=3;
            switch ( input.LA(1) ) {
            case FUNC_EVAL:
                {
                alt57=1;
                }
                break;
            case DOLLARVAR:
            case GROUP:
            case IDENTIFIER:
                {
                alt57=2;
                }
                break;
            case BIN_EXPR:
                {
                alt57=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 57, 0, input);

                throw nvae;

            }

            switch (alt57) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:294:7: func_eval
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_eval_in_projectable_expr2096);
                    func_eval198=func_eval();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, func_eval198.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:294:19: col_ref
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_projectable_expr2100);
                    col_ref199=col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_ref199.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:294:29: bin_expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_bin_expr_in_projectable_expr2104);
                    bin_expr200=bin_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, bin_expr200.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "projectable_expr"


    public static class dot_proj_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "dot_proj"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:297:1: dot_proj : ^( PERIOD col_alias_or_index ( col_alias_or_index )* ) ;
    public final AstPrinter.dot_proj_return dot_proj() throws RecognitionException {
        AstPrinter.dot_proj_return retval = new AstPrinter.dot_proj_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PERIOD201=null;
        AstPrinter.col_alias_or_index_return col_alias_or_index202 =null;

        AstPrinter.col_alias_or_index_return col_alias_or_index203 =null;


        CommonTree PERIOD201_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:298:5: ( ^( PERIOD col_alias_or_index ( col_alias_or_index )* ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:298:7: ^( PERIOD col_alias_or_index ( col_alias_or_index )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            PERIOD201=(CommonTree)match(input,PERIOD,FOLLOW_PERIOD_in_dot_proj2120); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PERIOD201_tree = (CommonTree)adaptor.dupNode(PERIOD201);


            root_1 = (CommonTree)adaptor.becomeRoot(PERIOD201_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append(".("); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_col_alias_or_index_in_dot_proj2124);
            col_alias_or_index202=col_alias_or_index();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, col_alias_or_index202.getTree());


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:298:57: ( col_alias_or_index )*
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( (LA58_0==DOLLARVAR||LA58_0==GROUP||LA58_0==IDENTIFIER) ) {
                    alt58=1;
                }


                switch (alt58) {
            	case 1 :
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:298:59: col_alias_or_index
            	    {
            	    if ( state.backtracking==0 ) { sb.append(", "); }

            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_col_alias_or_index_in_dot_proj2130);
            	    col_alias_or_index203=col_alias_or_index();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, col_alias_or_index203.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop58;
                }
            } while (true);


            if ( state.backtracking==0 ) { sb.append(")"); }

            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "dot_proj"


    public static class col_alias_or_index_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "col_alias_or_index"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:301:1: col_alias_or_index : ( col_alias | col_index );
    public final AstPrinter.col_alias_or_index_return col_alias_or_index() throws RecognitionException {
        AstPrinter.col_alias_or_index_return retval = new AstPrinter.col_alias_or_index_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.col_alias_return col_alias204 =null;

        AstPrinter.col_index_return col_index205 =null;



        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:301:20: ( col_alias | col_index )
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==GROUP||LA59_0==IDENTIFIER) ) {
                alt59=1;
            }
            else if ( (LA59_0==DOLLARVAR) ) {
                alt59=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 59, 0, input);

                throw nvae;

            }
            switch (alt59) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:301:22: col_alias
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_alias_in_col_alias_or_index2146);
                    col_alias204=col_alias();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_alias204.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:301:34: col_index
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_index_in_col_alias_or_index2150);
                    col_index205=col_index();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_index205.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "col_alias_or_index"


    public static class col_alias_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "col_alias"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:304:1: col_alias : ( GROUP | IDENTIFIER );
    public final AstPrinter.col_alias_return col_alias() throws RecognitionException {
        AstPrinter.col_alias_return retval = new AstPrinter.col_alias_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree GROUP206=null;
        CommonTree IDENTIFIER207=null;

        CommonTree GROUP206_tree=null;
        CommonTree IDENTIFIER207_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:305:5: ( GROUP | IDENTIFIER )
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==GROUP) ) {
                alt60=1;
            }
            else if ( (LA60_0==IDENTIFIER) ) {
                alt60=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 60, 0, input);

                throw nvae;

            }
            switch (alt60) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:305:7: GROUP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    GROUP206=(CommonTree)match(input,GROUP,FOLLOW_GROUP_in_col_alias2164); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    GROUP206_tree = (CommonTree)adaptor.dupNode(GROUP206);


                    adaptor.addChild(root_0, GROUP206_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((GROUP206!=null?GROUP206.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:306:7: IDENTIFIER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER207=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_col_alias2174); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER207_tree = (CommonTree)adaptor.dupNode(IDENTIFIER207);


                    adaptor.addChild(root_0, IDENTIFIER207_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((IDENTIFIER207!=null?IDENTIFIER207.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "col_alias"


    public static class col_index_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "col_index"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:309:1: col_index : DOLLARVAR ;
    public final AstPrinter.col_index_return col_index() throws RecognitionException {
        AstPrinter.col_index_return retval = new AstPrinter.col_index_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DOLLARVAR208=null;

        CommonTree DOLLARVAR208_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:310:5: ( DOLLARVAR )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:310:7: DOLLARVAR
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            DOLLARVAR208=(CommonTree)match(input,DOLLARVAR,FOLLOW_DOLLARVAR_in_col_index2190); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DOLLARVAR208_tree = (CommonTree)adaptor.dupNode(DOLLARVAR208);


            adaptor.addChild(root_0, DOLLARVAR208_tree);
            }


            if ( state.backtracking==0 ) { sb.append((DOLLARVAR208!=null?DOLLARVAR208.getText():null)); }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "col_index"


    public static class col_range_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "col_range"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:313:1: col_range : ^( COL_RANGE ( col_ref )? DOUBLE_PERIOD ( col_ref )? ) ;
    public final AstPrinter.col_range_return col_range() throws RecognitionException {
        AstPrinter.col_range_return retval = new AstPrinter.col_range_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree COL_RANGE209=null;
        CommonTree DOUBLE_PERIOD211=null;
        AstPrinter.col_ref_return col_ref210 =null;

        AstPrinter.col_ref_return col_ref212 =null;


        CommonTree COL_RANGE209_tree=null;
        CommonTree DOUBLE_PERIOD211_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:313:11: ( ^( COL_RANGE ( col_ref )? DOUBLE_PERIOD ( col_ref )? ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:313:14: ^( COL_RANGE ( col_ref )? DOUBLE_PERIOD ( col_ref )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            COL_RANGE209=(CommonTree)match(input,COL_RANGE,FOLLOW_COL_RANGE_in_col_range2203); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            COL_RANGE209_tree = (CommonTree)adaptor.dupNode(COL_RANGE209);


            root_1 = (CommonTree)adaptor.becomeRoot(COL_RANGE209_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:313:26: ( col_ref )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==DOLLARVAR||LA61_0==GROUP||LA61_0==IDENTIFIER) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:313:26: col_ref
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_col_range2205);
                    col_ref210=col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, col_ref210.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            if ( state.backtracking==0 ) { sb.append(".."); }

            _last = (CommonTree)input.LT(1);
            DOUBLE_PERIOD211=(CommonTree)match(input,DOUBLE_PERIOD,FOLLOW_DOUBLE_PERIOD_in_col_range2210); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DOUBLE_PERIOD211_tree = (CommonTree)adaptor.dupNode(DOUBLE_PERIOD211);


            adaptor.addChild(root_1, DOUBLE_PERIOD211_tree);
            }


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:313:70: ( col_ref )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==DOLLARVAR||LA62_0==GROUP||LA62_0==IDENTIFIER) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:313:70: col_ref
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_col_range2212);
                    col_ref212=col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, col_ref212.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "col_range"


    public static class pound_proj_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "pound_proj"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:316:1: pound_proj : ^( POUND ( QUOTEDSTRING | NULL ) ) ;
    public final AstPrinter.pound_proj_return pound_proj() throws RecognitionException {
        AstPrinter.pound_proj_return retval = new AstPrinter.pound_proj_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree POUND213=null;
        CommonTree QUOTEDSTRING214=null;
        CommonTree NULL215=null;

        CommonTree POUND213_tree=null;
        CommonTree QUOTEDSTRING214_tree=null;
        CommonTree NULL215_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:317:5: ( ^( POUND ( QUOTEDSTRING | NULL ) ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:317:7: ^( POUND ( QUOTEDSTRING | NULL ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            POUND213=(CommonTree)match(input,POUND,FOLLOW_POUND_in_pound_proj2230); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            POUND213_tree = (CommonTree)adaptor.dupNode(POUND213);


            root_1 = (CommonTree)adaptor.becomeRoot(POUND213_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((POUND213!=null?POUND213.getText():null)); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:318:9: ( QUOTEDSTRING | NULL )
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==QUOTEDSTRING) ) {
                alt63=1;
            }
            else if ( (LA63_0==NULL) ) {
                alt63=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 63, 0, input);

                throw nvae;

            }
            switch (alt63) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:318:11: QUOTEDSTRING
                    {
                    _last = (CommonTree)input.LT(1);
                    QUOTEDSTRING214=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_pound_proj2244); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    QUOTEDSTRING214_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING214);


                    adaptor.addChild(root_1, QUOTEDSTRING214_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((QUOTEDSTRING214!=null?QUOTEDSTRING214.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:318:61: NULL
                    {
                    _last = (CommonTree)input.LT(1);
                    NULL215=(CommonTree)match(input,NULL,FOLLOW_NULL_in_pound_proj2250); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NULL215_tree = (CommonTree)adaptor.dupNode(NULL215);


                    adaptor.addChild(root_1, NULL215_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((NULL215!=null?NULL215.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "pound_proj"


    public static class bin_expr_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "bin_expr"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:321:1: bin_expr : ^( BIN_EXPR cond expr expr ) ;
    public final AstPrinter.bin_expr_return bin_expr() throws RecognitionException {
        AstPrinter.bin_expr_return retval = new AstPrinter.bin_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BIN_EXPR216=null;
        AstPrinter.cond_return cond217 =null;

        AstPrinter.expr_return expr218 =null;

        AstPrinter.expr_return expr219 =null;


        CommonTree BIN_EXPR216_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:322:5: ( ^( BIN_EXPR cond expr expr ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:322:7: ^( BIN_EXPR cond expr expr )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BIN_EXPR216=(CommonTree)match(input,BIN_EXPR,FOLLOW_BIN_EXPR_in_bin_expr2272); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BIN_EXPR216_tree = (CommonTree)adaptor.dupNode(BIN_EXPR216);


            root_1 = (CommonTree)adaptor.becomeRoot(BIN_EXPR216_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append(" ("); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_bin_expr2276);
            cond217=cond();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond217.getTree());


            if ( state.backtracking==0 ) { sb.append(" ? "); }

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expr_in_bin_expr2280);
            expr218=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, expr218.getTree());


            if ( state.backtracking==0 ) { sb.append(" : "); }

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expr_in_bin_expr2284);
            expr219=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, expr219.getTree());


            if ( state.backtracking==0 ) { sb.append(") "); }

            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "bin_expr"


    public static class limit_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "limit_clause"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:325:1: limit_clause : ^( LIMIT rel ( INTEGER | LONGINTEGER | expr ) ) ;
    public final AstPrinter.limit_clause_return limit_clause() throws RecognitionException {
        AstPrinter.limit_clause_return retval = new AstPrinter.limit_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree LIMIT220=null;
        CommonTree INTEGER222=null;
        CommonTree LONGINTEGER223=null;
        AstPrinter.rel_return rel221 =null;

        AstPrinter.expr_return expr224 =null;


        CommonTree LIMIT220_tree=null;
        CommonTree INTEGER222_tree=null;
        CommonTree LONGINTEGER223_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:326:5: ( ^( LIMIT rel ( INTEGER | LONGINTEGER | expr ) ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:326:7: ^( LIMIT rel ( INTEGER | LONGINTEGER | expr ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            LIMIT220=(CommonTree)match(input,LIMIT,FOLLOW_LIMIT_in_limit_clause2309); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LIMIT220_tree = (CommonTree)adaptor.dupNode(LIMIT220);


            root_1 = (CommonTree)adaptor.becomeRoot(LIMIT220_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((LIMIT220!=null?LIMIT220.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_limit_clause2313);
            rel221=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel221.getTree());


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:327:9: ( INTEGER | LONGINTEGER | expr )
            int alt64=3;
            switch ( input.LA(1) ) {
            case INTEGER:
                {
                int LA64_1 = input.LA(2);

                if ( (synpred113_AstPrinter()) ) {
                    alt64=1;
                }
                else if ( (true) ) {
                    alt64=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 64, 1, input);

                    throw nvae;

                }
                }
                break;
            case LONGINTEGER:
                {
                int LA64_2 = input.LA(2);

                if ( (synpred114_AstPrinter()) ) {
                    alt64=2;
                }
                else if ( (true) ) {
                    alt64=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 64, 2, input);

                    throw nvae;

                }
                }
                break;
            case DIV:
            case DOLLARVAR:
            case DOUBLENUMBER:
            case FALSE:
            case FLOATNUMBER:
            case GROUP:
            case MINUS:
            case PERCENT:
            case PLUS:
            case QUOTEDSTRING:
            case STAR:
            case TRUE:
            case BAG_VAL:
            case BIN_EXPR:
            case CAST_EXPR:
            case EXPR_IN_PAREN:
            case FUNC_EVAL:
            case IDENTIFIER:
            case MAP_VAL:
            case NEG:
            case NULL:
            case TUPLE_VAL:
                {
                alt64=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 64, 0, input);

                throw nvae;

            }

            switch (alt64) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:327:11: INTEGER
                    {
                    _last = (CommonTree)input.LT(1);
                    INTEGER222=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_limit_clause2326); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INTEGER222_tree = (CommonTree)adaptor.dupNode(INTEGER222);


                    adaptor.addChild(root_1, INTEGER222_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append(" ").append((INTEGER222!=null?INTEGER222.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:327:63: LONGINTEGER
                    {
                    _last = (CommonTree)input.LT(1);
                    LONGINTEGER223=(CommonTree)match(input,LONGINTEGER,FOLLOW_LONGINTEGER_in_limit_clause2332); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LONGINTEGER223_tree = (CommonTree)adaptor.dupNode(LONGINTEGER223);


                    adaptor.addChild(root_1, LONGINTEGER223_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append(" ").append((LONGINTEGER223!=null?LONGINTEGER223.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:327:123: expr
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_limit_clause2338);
                    expr224=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr224.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "limit_clause"


    public static class sample_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "sample_clause"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:330:1: sample_clause : ^( SAMPLE rel ( DOUBLENUMBER | expr ) ) ;
    public final AstPrinter.sample_clause_return sample_clause() throws RecognitionException {
        AstPrinter.sample_clause_return retval = new AstPrinter.sample_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SAMPLE225=null;
        CommonTree DOUBLENUMBER227=null;
        AstPrinter.rel_return rel226 =null;

        AstPrinter.expr_return expr228 =null;


        CommonTree SAMPLE225_tree=null;
        CommonTree DOUBLENUMBER227_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:331:5: ( ^( SAMPLE rel ( DOUBLENUMBER | expr ) ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:331:7: ^( SAMPLE rel ( DOUBLENUMBER | expr ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            SAMPLE225=(CommonTree)match(input,SAMPLE,FOLLOW_SAMPLE_in_sample_clause2358); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SAMPLE225_tree = (CommonTree)adaptor.dupNode(SAMPLE225);


            root_1 = (CommonTree)adaptor.becomeRoot(SAMPLE225_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((SAMPLE225!=null?SAMPLE225.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_sample_clause2362);
            rel226=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel226.getTree());


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:331:62: ( DOUBLENUMBER | expr )
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==DOUBLENUMBER) ) {
                int LA65_1 = input.LA(2);

                if ( (synpred115_AstPrinter()) ) {
                    alt65=1;
                }
                else if ( (true) ) {
                    alt65=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 65, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA65_0==DIV||LA65_0==DOLLARVAR||LA65_0==FALSE||LA65_0==FLOATNUMBER||LA65_0==GROUP||LA65_0==INTEGER||LA65_0==LONGINTEGER||LA65_0==MINUS||LA65_0==PERCENT||LA65_0==PLUS||LA65_0==QUOTEDSTRING||LA65_0==STAR||LA65_0==TRUE||(LA65_0 >= BAG_VAL && LA65_0 <= BIN_EXPR)||LA65_0==CAST_EXPR||LA65_0==EXPR_IN_PAREN||LA65_0==FUNC_EVAL||LA65_0==IDENTIFIER||(LA65_0 >= MAP_VAL && LA65_0 <= NEG)||LA65_0==NULL||LA65_0==TUPLE_VAL) ) {
                alt65=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 65, 0, input);

                throw nvae;

            }
            switch (alt65) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:331:64: DOUBLENUMBER
                    {
                    _last = (CommonTree)input.LT(1);
                    DOUBLENUMBER227=(CommonTree)match(input,DOUBLENUMBER,FOLLOW_DOUBLENUMBER_in_sample_clause2366); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DOUBLENUMBER227_tree = (CommonTree)adaptor.dupNode(DOUBLENUMBER227);


                    adaptor.addChild(root_1, DOUBLENUMBER227_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append(" ").append((DOUBLENUMBER227!=null?DOUBLENUMBER227.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:331:126: expr
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_sample_clause2372);
                    expr228=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr228.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "sample_clause"


    public static class order_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "order_clause"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:334:1: order_clause : ^( ORDER rel order_by_clause ( func_clause )? ) ;
    public final AstPrinter.order_clause_return order_clause() throws RecognitionException {
        AstPrinter.order_clause_return retval = new AstPrinter.order_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ORDER229=null;
        AstPrinter.rel_return rel230 =null;

        AstPrinter.order_by_clause_return order_by_clause231 =null;

        AstPrinter.func_clause_return func_clause232 =null;


        CommonTree ORDER229_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:335:5: ( ^( ORDER rel order_by_clause ( func_clause )? ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:335:7: ^( ORDER rel order_by_clause ( func_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            ORDER229=(CommonTree)match(input,ORDER,FOLLOW_ORDER_in_order_clause2396); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ORDER229_tree = (CommonTree)adaptor.dupNode(ORDER229);


            root_1 = (CommonTree)adaptor.becomeRoot(ORDER229_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((ORDER229!=null?ORDER229.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_order_clause2400);
            rel230=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel230.getTree());


            if ( state.backtracking==0 ) { sb.append(" BY "); }

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_order_by_clause_in_order_clause2412);
            order_by_clause231=order_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, order_by_clause231.getTree());


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:337:9: ( func_clause )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==FUNC||LA66_0==FUNC_REF) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:337:11: func_clause
                    {
                    if ( state.backtracking==0 ) { sb.append(" USING "); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_order_clause2426);
                    func_clause232=func_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause232.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "order_clause"


    public static class order_by_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "order_by_clause"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:340:1: order_by_clause : ( STAR ( ASC | DESC )? | order_col ( order_col )* );
    public final AstPrinter.order_by_clause_return order_by_clause() throws RecognitionException {
        AstPrinter.order_by_clause_return retval = new AstPrinter.order_by_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR233=null;
        CommonTree ASC234=null;
        CommonTree DESC235=null;
        AstPrinter.order_col_return order_col236 =null;

        AstPrinter.order_col_return order_col237 =null;


        CommonTree STAR233_tree=null;
        CommonTree ASC234_tree=null;
        CommonTree DESC235_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:341:5: ( STAR ( ASC | DESC )? | order_col ( order_col )* )
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==STAR) ) {
                alt69=1;
            }
            else if ( (LA69_0==DOLLARVAR||LA69_0==GROUP||LA69_0==COL_RANGE||LA69_0==IDENTIFIER) ) {
                alt69=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 69, 0, input);

                throw nvae;

            }
            switch (alt69) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:341:7: STAR ( ASC | DESC )?
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR233=(CommonTree)match(input,STAR,FOLLOW_STAR_in_order_by_clause2445); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR233_tree = (CommonTree)adaptor.dupNode(STAR233);


                    adaptor.addChild(root_0, STAR233_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((STAR233!=null?STAR233.getText():null)); }

                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:341:39: ( ASC | DESC )?
                    int alt67=3;
                    int LA67_0 = input.LA(1);

                    if ( (LA67_0==ASC) ) {
                        alt67=1;
                    }
                    else if ( (LA67_0==DESC) ) {
                        alt67=2;
                    }
                    switch (alt67) {
                        case 1 :
                            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:341:41: ASC
                            {
                            _last = (CommonTree)input.LT(1);
                            ASC234=(CommonTree)match(input,ASC,FOLLOW_ASC_in_order_by_clause2451); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            ASC234_tree = (CommonTree)adaptor.dupNode(ASC234);


                            adaptor.addChild(root_0, ASC234_tree);
                            }


                            if ( state.backtracking==0 ) { sb.append(" ").append((ASC234!=null?ASC234.getText():null)); }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;
                        case 2 :
                            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:341:85: DESC
                            {
                            _last = (CommonTree)input.LT(1);
                            DESC235=(CommonTree)match(input,DESC,FOLLOW_DESC_in_order_by_clause2457); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            DESC235_tree = (CommonTree)adaptor.dupNode(DESC235);


                            adaptor.addChild(root_0, DESC235_tree);
                            }


                            if ( state.backtracking==0 ) { sb.append(" ").append((DESC235!=null?DESC235.getText():null)); }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:342:7: order_col ( order_col )*
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_order_col_in_order_by_clause2470);
                    order_col236=order_col();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, order_col236.getTree());


                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:342:17: ( order_col )*
                    loop68:
                    do {
                        int alt68=2;
                        int LA68_0 = input.LA(1);

                        if ( (LA68_0==DOLLARVAR||LA68_0==GROUP||LA68_0==COL_RANGE||LA68_0==IDENTIFIER) ) {
                            alt68=1;
                        }


                        switch (alt68) {
                    	case 1 :
                    	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:342:19: order_col
                    	    {
                    	    if ( state.backtracking==0 ) { sb.append(", "); }

                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_order_col_in_order_by_clause2476);
                    	    order_col237=order_col();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, order_col237.getTree());


                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop68;
                        }
                    } while (true);


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "order_by_clause"


    public static class order_col_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "order_col"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:345:1: order_col : ( col_range | col_ref ) ( ASC | DESC )? ;
    public final AstPrinter.order_col_return order_col() throws RecognitionException {
        AstPrinter.order_col_return retval = new AstPrinter.order_col_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ASC240=null;
        CommonTree DESC241=null;
        AstPrinter.col_range_return col_range238 =null;

        AstPrinter.col_ref_return col_ref239 =null;


        CommonTree ASC240_tree=null;
        CommonTree DESC241_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:346:5: ( ( col_range | col_ref ) ( ASC | DESC )? )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:346:7: ( col_range | col_ref ) ( ASC | DESC )?
            {
            root_0 = (CommonTree)adaptor.nil();


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:346:7: ( col_range | col_ref )
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==COL_RANGE) ) {
                alt70=1;
            }
            else if ( (LA70_0==DOLLARVAR||LA70_0==GROUP||LA70_0==IDENTIFIER) ) {
                alt70=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 70, 0, input);

                throw nvae;

            }
            switch (alt70) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:346:8: col_range
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_order_col2493);
                    col_range238=col_range();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range238.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:346:20: col_ref
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_order_col2497);
                    col_ref239=col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_ref239.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:346:29: ( ASC | DESC )?
            int alt71=3;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==ASC) ) {
                alt71=1;
            }
            else if ( (LA71_0==DESC) ) {
                alt71=2;
            }
            switch (alt71) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:346:31: ASC
                    {
                    _last = (CommonTree)input.LT(1);
                    ASC240=(CommonTree)match(input,ASC,FOLLOW_ASC_in_order_col2502); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ASC240_tree = (CommonTree)adaptor.dupNode(ASC240);


                    adaptor.addChild(root_0, ASC240_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append(" ").append((ASC240!=null?ASC240.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:346:75: DESC
                    {
                    _last = (CommonTree)input.LT(1);
                    DESC241=(CommonTree)match(input,DESC,FOLLOW_DESC_in_order_col2508); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DESC241_tree = (CommonTree)adaptor.dupNode(DESC241);


                    adaptor.addChild(root_0, DESC241_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append(" ").append((DESC241!=null?DESC241.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "order_col"


    public static class distinct_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "distinct_clause"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:349:1: distinct_clause : ^( DISTINCT rel ( partition_clause )? ) ;
    public final AstPrinter.distinct_clause_return distinct_clause() throws RecognitionException {
        AstPrinter.distinct_clause_return retval = new AstPrinter.distinct_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DISTINCT242=null;
        AstPrinter.rel_return rel243 =null;

        AstPrinter.partition_clause_return partition_clause244 =null;


        CommonTree DISTINCT242_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:350:5: ( ^( DISTINCT rel ( partition_clause )? ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:350:7: ^( DISTINCT rel ( partition_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            DISTINCT242=(CommonTree)match(input,DISTINCT,FOLLOW_DISTINCT_in_distinct_clause2533); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DISTINCT242_tree = (CommonTree)adaptor.dupNode(DISTINCT242);


            root_1 = (CommonTree)adaptor.becomeRoot(DISTINCT242_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((DISTINCT242!=null?DISTINCT242.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_distinct_clause2537);
            rel243=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel243.getTree());


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:350:66: ( partition_clause )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==PARTITION) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:350:66: partition_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_partition_clause_in_distinct_clause2539);
                    partition_clause244=partition_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, partition_clause244.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "distinct_clause"


    public static class partition_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "partition_clause"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:353:1: partition_clause : ^( PARTITION func_name ) ;
    public final AstPrinter.partition_clause_return partition_clause() throws RecognitionException {
        AstPrinter.partition_clause_return retval = new AstPrinter.partition_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PARTITION245=null;
        AstPrinter.func_name_return func_name246 =null;


        CommonTree PARTITION245_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:354:5: ( ^( PARTITION func_name ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:354:7: ^( PARTITION func_name )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            PARTITION245=(CommonTree)match(input,PARTITION,FOLLOW_PARTITION_in_partition_clause2558); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PARTITION245_tree = (CommonTree)adaptor.dupNode(PARTITION245);


            root_1 = (CommonTree)adaptor.becomeRoot(PARTITION245_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append(" ").append((PARTITION245!=null?PARTITION245.getText():null)).append(" BY "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_func_name_in_partition_clause2562);
            func_name246=func_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, func_name246.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "partition_clause"


    public static class cross_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cross_clause"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:357:1: cross_clause : ^( CROSS rel_list ( partition_clause )? ) ;
    public final AstPrinter.cross_clause_return cross_clause() throws RecognitionException {
        AstPrinter.cross_clause_return retval = new AstPrinter.cross_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CROSS247=null;
        AstPrinter.rel_list_return rel_list248 =null;

        AstPrinter.partition_clause_return partition_clause249 =null;


        CommonTree CROSS247_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:358:5: ( ^( CROSS rel_list ( partition_clause )? ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:358:7: ^( CROSS rel_list ( partition_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CROSS247=(CommonTree)match(input,CROSS,FOLLOW_CROSS_in_cross_clause2584); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CROSS247_tree = (CommonTree)adaptor.dupNode(CROSS247);


            root_1 = (CommonTree)adaptor.becomeRoot(CROSS247_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((CROSS247!=null?CROSS247.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_list_in_cross_clause2588);
            rel_list248=rel_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel_list248.getTree());


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:358:65: ( partition_clause )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==PARTITION) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:358:65: partition_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_partition_clause_in_cross_clause2590);
                    partition_clause249=partition_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, partition_clause249.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "cross_clause"


    public static class rel_list_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_list"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:361:1: rel_list : rel ( rel )* ;
    public final AstPrinter.rel_list_return rel_list() throws RecognitionException {
        AstPrinter.rel_list_return retval = new AstPrinter.rel_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.rel_return rel250 =null;

        AstPrinter.rel_return rel251 =null;



        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:362:5: ( rel ( rel )* )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:362:7: rel ( rel )*
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_rel_list2611);
            rel250=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, rel250.getTree());


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:362:11: ( rel )*
            loop74:
            do {
                int alt74=2;
                int LA74_0 = input.LA(1);

                if ( (LA74_0==COGROUP||LA74_0==CROSS||LA74_0==DEFINE||LA74_0==DISTINCT||LA74_0==FILTER||LA74_0==FOREACH||LA74_0==GROUP||LA74_0==JOIN||(LA74_0 >= LIMIT && LA74_0 <= LOAD)||LA74_0==MAPREDUCE||LA74_0==ORDER||LA74_0==SAMPLE||LA74_0==SPLIT||(LA74_0 >= STORE && LA74_0 <= STREAM)||LA74_0==UNION||LA74_0==IDENTIFIER) ) {
                    alt74=1;
                }


                switch (alt74) {
            	case 1 :
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:362:13: rel
            	    {
            	    if ( state.backtracking==0 ) { sb.append(", "); }

            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_rel_in_rel_list2617);
            	    rel251=rel();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, rel251.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop74;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rel_list"


    public static class join_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "join_clause"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:365:1: join_clause : ^( JOIN join_sub_clause ( join_type )? ( partition_clause )? ) ;
    public final AstPrinter.join_clause_return join_clause() throws RecognitionException {
        AstPrinter.join_clause_return retval = new AstPrinter.join_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree JOIN252=null;
        AstPrinter.join_sub_clause_return join_sub_clause253 =null;

        AstPrinter.join_type_return join_type254 =null;

        AstPrinter.partition_clause_return partition_clause255 =null;


        CommonTree JOIN252_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:366:5: ( ^( JOIN join_sub_clause ( join_type )? ( partition_clause )? ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:366:7: ^( JOIN join_sub_clause ( join_type )? ( partition_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            JOIN252=(CommonTree)match(input,JOIN,FOLLOW_JOIN_in_join_clause2634); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            JOIN252_tree = (CommonTree)adaptor.dupNode(JOIN252);


            root_1 = (CommonTree)adaptor.becomeRoot(JOIN252_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((JOIN252!=null?JOIN252.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_join_sub_clause_in_join_clause2638);
            join_sub_clause253=join_sub_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, join_sub_clause253.getTree());


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:366:70: ( join_type )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==QUOTEDSTRING) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:366:72: join_type
                    {
                    if ( state.backtracking==0 ) { sb.append(" USING "); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_type_in_join_clause2644);
                    join_type254=join_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, join_type254.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:367:5: ( partition_clause )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==PARTITION) ) {
                alt76=1;
            }
            switch (alt76) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:367:7: partition_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_partition_clause_in_join_clause2656);
                    partition_clause255=partition_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, partition_clause255.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "join_clause"


    public static class join_type_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "join_type"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:370:1: join_type : QUOTEDSTRING ;
    public final AstPrinter.join_type_return join_type() throws RecognitionException {
        AstPrinter.join_type_return retval = new AstPrinter.join_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING256=null;

        CommonTree QUOTEDSTRING256_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:370:11: ( QUOTEDSTRING )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:370:13: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING256=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_join_type2670); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING256_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING256);


            adaptor.addChild(root_0, QUOTEDSTRING256_tree);
            }


            if ( state.backtracking==0 ) { sb.append((QUOTEDSTRING256!=null?QUOTEDSTRING256.getText():null)); }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "join_type"


    public static class join_sub_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "join_sub_clause"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:373:1: join_sub_clause : ( join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item | join_item ( join_item )* );
    public final AstPrinter.join_sub_clause_return join_sub_clause() throws RecognitionException {
        AstPrinter.join_sub_clause_return retval = new AstPrinter.join_sub_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree LEFT258=null;
        CommonTree RIGHT259=null;
        CommonTree FULL260=null;
        CommonTree OUTER261=null;
        AstPrinter.join_item_return join_item257 =null;

        AstPrinter.join_item_return join_item262 =null;

        AstPrinter.join_item_return join_item263 =null;

        AstPrinter.join_item_return join_item264 =null;


        CommonTree LEFT258_tree=null;
        CommonTree RIGHT259_tree=null;
        CommonTree FULL260_tree=null;
        CommonTree OUTER261_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:374:5: ( join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item | join_item ( join_item )* )
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==JOIN_ITEM) ) {
                int LA80_1 = input.LA(2);

                if ( (synpred132_AstPrinter()) ) {
                    alt80=1;
                }
                else if ( (true) ) {
                    alt80=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 80, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 80, 0, input);

                throw nvae;

            }
            switch (alt80) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:374:7: join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_item_in_join_sub_clause2685);
                    join_item257=join_item();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, join_item257.getTree());


                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:374:17: ( LEFT | RIGHT | FULL )
                    int alt77=3;
                    switch ( input.LA(1) ) {
                    case LEFT:
                        {
                        alt77=1;
                        }
                        break;
                    case RIGHT:
                        {
                        alt77=2;
                        }
                        break;
                    case FULL:
                        {
                        alt77=3;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 77, 0, input);

                        throw nvae;

                    }

                    switch (alt77) {
                        case 1 :
                            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:374:19: LEFT
                            {
                            _last = (CommonTree)input.LT(1);
                            LEFT258=(CommonTree)match(input,LEFT,FOLLOW_LEFT_in_join_sub_clause2689); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            LEFT258_tree = (CommonTree)adaptor.dupNode(LEFT258);


                            adaptor.addChild(root_0, LEFT258_tree);
                            }


                            if ( state.backtracking==0 ) { sb.append(" ").append((LEFT258!=null?LEFT258.getText():null)); }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;
                        case 2 :
                            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:375:16: RIGHT
                            {
                            _last = (CommonTree)input.LT(1);
                            RIGHT259=(CommonTree)match(input,RIGHT,FOLLOW_RIGHT_in_join_sub_clause2708); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            RIGHT259_tree = (CommonTree)adaptor.dupNode(RIGHT259);


                            adaptor.addChild(root_0, RIGHT259_tree);
                            }


                            if ( state.backtracking==0 ) { sb.append(" ").append((RIGHT259!=null?RIGHT259.getText():null)); }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;
                        case 3 :
                            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:376:16: FULL
                            {
                            _last = (CommonTree)input.LT(1);
                            FULL260=(CommonTree)match(input,FULL,FOLLOW_FULL_in_join_sub_clause2727); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            FULL260_tree = (CommonTree)adaptor.dupNode(FULL260);


                            adaptor.addChild(root_0, FULL260_tree);
                            }


                            if ( state.backtracking==0 ) { sb.append(" ").append((FULL260!=null?FULL260.getText():null)); }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:377:16: ( OUTER )?
                    int alt78=2;
                    int LA78_0 = input.LA(1);

                    if ( (LA78_0==OUTER) ) {
                        alt78=1;
                    }
                    switch (alt78) {
                        case 1 :
                            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:377:17: OUTER
                            {
                            _last = (CommonTree)input.LT(1);
                            OUTER261=(CommonTree)match(input,OUTER,FOLLOW_OUTER_in_join_sub_clause2747); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            OUTER261_tree = (CommonTree)adaptor.dupNode(OUTER261);


                            adaptor.addChild(root_0, OUTER261_tree);
                            }


                            if ( state.backtracking==0 ) { sb.append(" ").append((OUTER261!=null?OUTER261.getText():null)); }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    if ( state.backtracking==0 ) { sb.append(", "); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_item_in_join_sub_clause2756);
                    join_item262=join_item();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, join_item262.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:378:7: join_item ( join_item )*
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_item_in_join_sub_clause2764);
                    join_item263=join_item();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, join_item263.getTree());


                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:378:17: ( join_item )*
                    loop79:
                    do {
                        int alt79=2;
                        int LA79_0 = input.LA(1);

                        if ( (LA79_0==JOIN_ITEM) ) {
                            alt79=1;
                        }


                        switch (alt79) {
                    	case 1 :
                    	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:378:19: join_item
                    	    {
                    	    if ( state.backtracking==0 ) { sb.append(", "); }

                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_join_item_in_join_sub_clause2770);
                    	    join_item264=join_item();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, join_item264.getTree());


                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop79;
                        }
                    } while (true);


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "join_sub_clause"


    public static class join_item_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "join_item"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:381:1: join_item : ^( JOIN_ITEM rel join_group_by_clause ) ;
    public final AstPrinter.join_item_return join_item() throws RecognitionException {
        AstPrinter.join_item_return retval = new AstPrinter.join_item_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree JOIN_ITEM265=null;
        AstPrinter.rel_return rel266 =null;

        AstPrinter.join_group_by_clause_return join_group_by_clause267 =null;


        CommonTree JOIN_ITEM265_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:382:5: ( ^( JOIN_ITEM rel join_group_by_clause ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:382:7: ^( JOIN_ITEM rel join_group_by_clause )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            JOIN_ITEM265=(CommonTree)match(input,JOIN_ITEM,FOLLOW_JOIN_ITEM_in_join_item2788); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            JOIN_ITEM265_tree = (CommonTree)adaptor.dupNode(JOIN_ITEM265);


            root_1 = (CommonTree)adaptor.becomeRoot(JOIN_ITEM265_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_join_item2790);
            rel266=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel266.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_join_group_by_clause_in_join_item2792);
            join_group_by_clause267=join_group_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, join_group_by_clause267.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "join_item"


    public static class join_group_by_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "join_group_by_clause"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:385:1: join_group_by_clause : ^( BY join_group_by_expr ( join_group_by_expr )* ) ;
    public final AstPrinter.join_group_by_clause_return join_group_by_clause() throws RecognitionException {
        AstPrinter.join_group_by_clause_return retval = new AstPrinter.join_group_by_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BY268=null;
        AstPrinter.join_group_by_expr_return join_group_by_expr269 =null;

        AstPrinter.join_group_by_expr_return join_group_by_expr270 =null;


        CommonTree BY268_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:386:5: ( ^( BY join_group_by_expr ( join_group_by_expr )* ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:386:7: ^( BY join_group_by_expr ( join_group_by_expr )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BY268=(CommonTree)match(input,BY,FOLLOW_BY_in_join_group_by_clause2809); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BY268_tree = (CommonTree)adaptor.dupNode(BY268);


            root_1 = (CommonTree)adaptor.becomeRoot(BY268_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append(" ").append((BY268!=null?BY268.getText():null)).append(" ("); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_join_group_by_expr_in_join_group_by_clause2818);
            join_group_by_expr269=join_group_by_expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, join_group_by_expr269.getTree());


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:387:24: ( join_group_by_expr )*
            loop81:
            do {
                int alt81=2;
                int LA81_0 = input.LA(1);

                if ( (LA81_0==DIV||LA81_0==DOLLARVAR||LA81_0==DOUBLENUMBER||LA81_0==FALSE||LA81_0==FLOATNUMBER||LA81_0==GROUP||LA81_0==INTEGER||LA81_0==LONGINTEGER||LA81_0==MINUS||LA81_0==PERCENT||LA81_0==PLUS||LA81_0==QUOTEDSTRING||LA81_0==STAR||LA81_0==TRUE||(LA81_0 >= BAG_VAL && LA81_0 <= BIN_EXPR)||(LA81_0 >= CAST_EXPR && LA81_0 <= EXPR_IN_PAREN)||LA81_0==FUNC_EVAL||LA81_0==IDENTIFIER||(LA81_0 >= MAP_VAL && LA81_0 <= NEG)||LA81_0==NULL||LA81_0==TUPLE_VAL) ) {
                    alt81=1;
                }


                switch (alt81) {
            	case 1 :
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:387:26: join_group_by_expr
            	    {
            	    if ( state.backtracking==0 ) { sb.append(", "); }

            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_join_group_by_expr_in_join_group_by_clause2824);
            	    join_group_by_expr270=join_group_by_expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, join_group_by_expr270.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop81;
                }
            } while (true);


            if ( state.backtracking==0 ) { sb.append(")"); }

            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "join_group_by_clause"


    public static class join_group_by_expr_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "join_group_by_expr"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:390:1: join_group_by_expr : ( col_range | expr | STAR );
    public final AstPrinter.join_group_by_expr_return join_group_by_expr() throws RecognitionException {
        AstPrinter.join_group_by_expr_return retval = new AstPrinter.join_group_by_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR273=null;
        AstPrinter.col_range_return col_range271 =null;

        AstPrinter.expr_return expr272 =null;


        CommonTree STAR273_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:391:5: ( col_range | expr | STAR )
            int alt82=3;
            switch ( input.LA(1) ) {
            case COL_RANGE:
                {
                alt82=1;
                }
                break;
            case DIV:
            case DOLLARVAR:
            case DOUBLENUMBER:
            case FALSE:
            case FLOATNUMBER:
            case GROUP:
            case INTEGER:
            case LONGINTEGER:
            case MINUS:
            case PERCENT:
            case PLUS:
            case QUOTEDSTRING:
            case TRUE:
            case BAG_VAL:
            case BIN_EXPR:
            case CAST_EXPR:
            case EXPR_IN_PAREN:
            case FUNC_EVAL:
            case IDENTIFIER:
            case MAP_VAL:
            case NEG:
            case NULL:
            case TUPLE_VAL:
                {
                alt82=2;
                }
                break;
            case STAR:
                {
                int LA82_3 = input.LA(2);

                if ( (LA82_3==DOWN) ) {
                    alt82=2;
                }
                else if ( (LA82_3==EOF||LA82_3==UP||LA82_3==DIV||LA82_3==DOLLARVAR||LA82_3==DOUBLENUMBER||LA82_3==FALSE||LA82_3==FLOATNUMBER||LA82_3==GROUP||LA82_3==INTEGER||LA82_3==LONGINTEGER||LA82_3==MINUS||LA82_3==PERCENT||LA82_3==PLUS||LA82_3==QUOTEDSTRING||LA82_3==STAR||LA82_3==TRUE||(LA82_3 >= BAG_VAL && LA82_3 <= BIN_EXPR)||(LA82_3 >= CAST_EXPR && LA82_3 <= EXPR_IN_PAREN)||LA82_3==FUNC_EVAL||LA82_3==IDENTIFIER||(LA82_3 >= MAP_VAL && LA82_3 <= NEG)||LA82_3==NULL||LA82_3==TUPLE_VAL) ) {
                    alt82=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 82, 3, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 82, 0, input);

                throw nvae;

            }

            switch (alt82) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:391:7: col_range
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_join_group_by_expr2845);
                    col_range271=col_range();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range271.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:391:19: expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_join_group_by_expr2849);
                    expr272=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expr272.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:391:26: STAR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR273=(CommonTree)match(input,STAR,FOLLOW_STAR_in_join_group_by_expr2853); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR273_tree = (CommonTree)adaptor.dupNode(STAR273);


                    adaptor.addChild(root_0, STAR273_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((STAR273!=null?STAR273.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "join_group_by_expr"


    public static class union_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "union_clause"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:394:1: union_clause : ^( UNION ( ONSCHEMA )? rel_list ) ;
    public final AstPrinter.union_clause_return union_clause() throws RecognitionException {
        AstPrinter.union_clause_return retval = new AstPrinter.union_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree UNION274=null;
        CommonTree ONSCHEMA275=null;
        AstPrinter.rel_list_return rel_list276 =null;


        CommonTree UNION274_tree=null;
        CommonTree ONSCHEMA275_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:395:5: ( ^( UNION ( ONSCHEMA )? rel_list ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:395:7: ^( UNION ( ONSCHEMA )? rel_list )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            UNION274=(CommonTree)match(input,UNION,FOLLOW_UNION_in_union_clause2871); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            UNION274_tree = (CommonTree)adaptor.dupNode(UNION274);


            root_1 = (CommonTree)adaptor.becomeRoot(UNION274_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((UNION274!=null?UNION274.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:395:56: ( ONSCHEMA )?
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==ONSCHEMA) ) {
                alt83=1;
            }
            switch (alt83) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:395:57: ONSCHEMA
                    {
                    _last = (CommonTree)input.LT(1);
                    ONSCHEMA275=(CommonTree)match(input,ONSCHEMA,FOLLOW_ONSCHEMA_in_union_clause2876); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ONSCHEMA275_tree = (CommonTree)adaptor.dupNode(ONSCHEMA275);


                    adaptor.addChild(root_1, ONSCHEMA275_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((ONSCHEMA275!=null?ONSCHEMA275.getText():null)).append(" "); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_list_in_union_clause2883);
            rel_list276=rel_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel_list276.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "union_clause"


    public static class foreach_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "foreach_clause"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:398:1: foreach_clause : ^( FOREACH rel foreach_plan ) ;
    public final AstPrinter.foreach_clause_return foreach_clause() throws RecognitionException {
        AstPrinter.foreach_clause_return retval = new AstPrinter.foreach_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FOREACH277=null;
        AstPrinter.rel_return rel278 =null;

        AstPrinter.foreach_plan_return foreach_plan279 =null;


        CommonTree FOREACH277_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:399:5: ( ^( FOREACH rel foreach_plan ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:399:7: ^( FOREACH rel foreach_plan )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FOREACH277=(CommonTree)match(input,FOREACH,FOLLOW_FOREACH_in_foreach_clause2905); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FOREACH277_tree = (CommonTree)adaptor.dupNode(FOREACH277);


            root_1 = (CommonTree)adaptor.becomeRoot(FOREACH277_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((FOREACH277!=null?FOREACH277.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_foreach_clause2909);
            rel278=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel278.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_foreach_plan_in_foreach_clause2911);
            foreach_plan279=foreach_plan();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, foreach_plan279.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "foreach_clause"


    public static class foreach_plan_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "foreach_plan"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:402:1: foreach_plan : ( ^( FOREACH_PLAN_SIMPLE generate_clause ) | ^( FOREACH_PLAN_COMPLEX nested_blk ) );
    public final AstPrinter.foreach_plan_return foreach_plan() throws RecognitionException {
        AstPrinter.foreach_plan_return retval = new AstPrinter.foreach_plan_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FOREACH_PLAN_SIMPLE280=null;
        CommonTree FOREACH_PLAN_COMPLEX282=null;
        AstPrinter.generate_clause_return generate_clause281 =null;

        AstPrinter.nested_blk_return nested_blk283 =null;


        CommonTree FOREACH_PLAN_SIMPLE280_tree=null;
        CommonTree FOREACH_PLAN_COMPLEX282_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:403:5: ( ^( FOREACH_PLAN_SIMPLE generate_clause ) | ^( FOREACH_PLAN_COMPLEX nested_blk ) )
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==FOREACH_PLAN_SIMPLE) ) {
                alt84=1;
            }
            else if ( (LA84_0==FOREACH_PLAN_COMPLEX) ) {
                alt84=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 84, 0, input);

                throw nvae;

            }
            switch (alt84) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:403:7: ^( FOREACH_PLAN_SIMPLE generate_clause )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FOREACH_PLAN_SIMPLE280=(CommonTree)match(input,FOREACH_PLAN_SIMPLE,FOLLOW_FOREACH_PLAN_SIMPLE_in_foreach_plan2933); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FOREACH_PLAN_SIMPLE280_tree = (CommonTree)adaptor.dupNode(FOREACH_PLAN_SIMPLE280);


                    root_1 = (CommonTree)adaptor.becomeRoot(FOREACH_PLAN_SIMPLE280_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_generate_clause_in_foreach_plan2935);
                    generate_clause281=generate_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, generate_clause281.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:404:7: ^( FOREACH_PLAN_COMPLEX nested_blk )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FOREACH_PLAN_COMPLEX282=(CommonTree)match(input,FOREACH_PLAN_COMPLEX,FOLLOW_FOREACH_PLAN_COMPLEX_in_foreach_plan2947); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FOREACH_PLAN_COMPLEX282_tree = (CommonTree)adaptor.dupNode(FOREACH_PLAN_COMPLEX282);


                    root_1 = (CommonTree)adaptor.becomeRoot(FOREACH_PLAN_COMPLEX282_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_blk_in_foreach_plan2949);
                    nested_blk283=nested_blk();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, nested_blk283.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "foreach_plan"


    public static class nested_blk_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_blk"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:407:1: nested_blk : ( nested_command )* generate_clause ;
    public final AstPrinter.nested_blk_return nested_blk() throws RecognitionException {
        AstPrinter.nested_blk_return retval = new AstPrinter.nested_blk_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.nested_command_return nested_command284 =null;

        AstPrinter.generate_clause_return generate_clause285 =null;



        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:408:5: ( ( nested_command )* generate_clause )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:408:7: ( nested_command )* generate_clause
            {
            root_0 = (CommonTree)adaptor.nil();


            if ( state.backtracking==0 ) { sb.append(" { "); }

            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:408:29: ( nested_command )*
            loop85:
            do {
                int alt85=2;
                int LA85_0 = input.LA(1);

                if ( ((LA85_0 >= NESTED_CMD && LA85_0 <= NESTED_CMD_ASSI)) ) {
                    alt85=1;
                }


                switch (alt85) {
            	case 1 :
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:408:30: nested_command
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_nested_command_in_nested_blk2967);
            	    nested_command284=nested_command();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, nested_command284.getTree());


            	    if ( state.backtracking==0 ) { sb.append("; "); }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop85;
                }
            } while (true);


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_generate_clause_in_nested_blk2974);
            generate_clause285=generate_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, generate_clause285.getTree());


            if ( state.backtracking==0 ) { sb.append("; } "); }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "nested_blk"


    public static class generate_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "generate_clause"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:411:1: generate_clause : ^( GENERATE flatten_generated_item ( flatten_generated_item )* ) ;
    public final AstPrinter.generate_clause_return generate_clause() throws RecognitionException {
        AstPrinter.generate_clause_return retval = new AstPrinter.generate_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree GENERATE286=null;
        AstPrinter.flatten_generated_item_return flatten_generated_item287 =null;

        AstPrinter.flatten_generated_item_return flatten_generated_item288 =null;


        CommonTree GENERATE286_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:412:5: ( ^( GENERATE flatten_generated_item ( flatten_generated_item )* ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:412:7: ^( GENERATE flatten_generated_item ( flatten_generated_item )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            GENERATE286=(CommonTree)match(input,GENERATE,FOLLOW_GENERATE_in_generate_clause2992); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            GENERATE286_tree = (CommonTree)adaptor.dupNode(GENERATE286);


            root_1 = (CommonTree)adaptor.becomeRoot(GENERATE286_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append(" ").append((GENERATE286!=null?GENERATE286.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_flatten_generated_item_in_generate_clause3004);
            flatten_generated_item287=flatten_generated_item();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, flatten_generated_item287.getTree());


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:413:32: ( flatten_generated_item )*
            loop86:
            do {
                int alt86=2;
                int LA86_0 = input.LA(1);

                if ( (LA86_0==DIV||LA86_0==DOLLARVAR||LA86_0==DOUBLENUMBER||LA86_0==FALSE||LA86_0==FLATTEN||LA86_0==FLOATNUMBER||LA86_0==GROUP||LA86_0==INTEGER||LA86_0==LONGINTEGER||LA86_0==MINUS||LA86_0==PERCENT||LA86_0==PLUS||LA86_0==QUOTEDSTRING||LA86_0==STAR||LA86_0==TRUE||(LA86_0 >= BAG_VAL && LA86_0 <= BIN_EXPR)||(LA86_0 >= CAST_EXPR && LA86_0 <= EXPR_IN_PAREN)||LA86_0==FUNC_EVAL||LA86_0==IDENTIFIER||(LA86_0 >= MAP_VAL && LA86_0 <= NEG)||LA86_0==NULL||LA86_0==TUPLE_VAL) ) {
                    alt86=1;
                }


                switch (alt86) {
            	case 1 :
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:413:34: flatten_generated_item
            	    {
            	    if ( state.backtracking==0 ) { sb.append(", "); }

            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_flatten_generated_item_in_generate_clause3010);
            	    flatten_generated_item288=flatten_generated_item();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, flatten_generated_item288.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop86;
                }
            } while (true);


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "generate_clause"


    public static class nested_command_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_command"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:416:1: nested_command : ( ^( NESTED_CMD IDENTIFIER nested_op ) | ^( NESTED_CMD_ASSI IDENTIFIER expr ) );
    public final AstPrinter.nested_command_return nested_command() throws RecognitionException {
        AstPrinter.nested_command_return retval = new AstPrinter.nested_command_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree NESTED_CMD289=null;
        CommonTree IDENTIFIER290=null;
        CommonTree NESTED_CMD_ASSI292=null;
        CommonTree IDENTIFIER293=null;
        AstPrinter.nested_op_return nested_op291 =null;

        AstPrinter.expr_return expr294 =null;


        CommonTree NESTED_CMD289_tree=null;
        CommonTree IDENTIFIER290_tree=null;
        CommonTree NESTED_CMD_ASSI292_tree=null;
        CommonTree IDENTIFIER293_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:417:5: ( ^( NESTED_CMD IDENTIFIER nested_op ) | ^( NESTED_CMD_ASSI IDENTIFIER expr ) )
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==NESTED_CMD) ) {
                alt87=1;
            }
            else if ( (LA87_0==NESTED_CMD_ASSI) ) {
                alt87=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 87, 0, input);

                throw nvae;

            }
            switch (alt87) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:417:7: ^( NESTED_CMD IDENTIFIER nested_op )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NESTED_CMD289=(CommonTree)match(input,NESTED_CMD,FOLLOW_NESTED_CMD_in_nested_command3033); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NESTED_CMD289_tree = (CommonTree)adaptor.dupNode(NESTED_CMD289);


                    root_1 = (CommonTree)adaptor.becomeRoot(NESTED_CMD289_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER290=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_nested_command3035); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER290_tree = (CommonTree)adaptor.dupNode(IDENTIFIER290);


                    adaptor.addChild(root_1, IDENTIFIER290_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((IDENTIFIER290!=null?IDENTIFIER290.getText():null)).append(" = "); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_op_in_nested_command3039);
                    nested_op291=nested_op();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, nested_op291.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:418:7: ^( NESTED_CMD_ASSI IDENTIFIER expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NESTED_CMD_ASSI292=(CommonTree)match(input,NESTED_CMD_ASSI,FOLLOW_NESTED_CMD_ASSI_in_nested_command3051); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NESTED_CMD_ASSI292_tree = (CommonTree)adaptor.dupNode(NESTED_CMD_ASSI292);


                    root_1 = (CommonTree)adaptor.becomeRoot(NESTED_CMD_ASSI292_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER293=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_nested_command3053); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER293_tree = (CommonTree)adaptor.dupNode(IDENTIFIER293);


                    adaptor.addChild(root_1, IDENTIFIER293_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((IDENTIFIER293!=null?IDENTIFIER293.getText():null)).append(" = "); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_nested_command3057);
                    expr294=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr294.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "nested_command"


    public static class nested_op_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_op"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:421:1: nested_op : ( nested_proj | nested_filter | nested_sort | nested_distinct | nested_limit | nested_cross | nested_foreach );
    public final AstPrinter.nested_op_return nested_op() throws RecognitionException {
        AstPrinter.nested_op_return retval = new AstPrinter.nested_op_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.nested_proj_return nested_proj295 =null;

        AstPrinter.nested_filter_return nested_filter296 =null;

        AstPrinter.nested_sort_return nested_sort297 =null;

        AstPrinter.nested_distinct_return nested_distinct298 =null;

        AstPrinter.nested_limit_return nested_limit299 =null;

        AstPrinter.nested_cross_return nested_cross300 =null;

        AstPrinter.nested_foreach_return nested_foreach301 =null;



        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:421:11: ( nested_proj | nested_filter | nested_sort | nested_distinct | nested_limit | nested_cross | nested_foreach )
            int alt88=7;
            switch ( input.LA(1) ) {
            case NESTED_PROJ:
                {
                alt88=1;
                }
                break;
            case FILTER:
                {
                alt88=2;
                }
                break;
            case ORDER:
                {
                alt88=3;
                }
                break;
            case DISTINCT:
                {
                alt88=4;
                }
                break;
            case LIMIT:
                {
                alt88=5;
                }
                break;
            case CROSS:
                {
                alt88=6;
                }
                break;
            case FOREACH:
                {
                alt88=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 88, 0, input);

                throw nvae;

            }

            switch (alt88) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:421:13: nested_proj
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_proj_in_nested_op3068);
                    nested_proj295=nested_proj();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_proj295.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:422:13: nested_filter
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_filter_in_nested_op3082);
                    nested_filter296=nested_filter();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_filter296.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:423:13: nested_sort
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_sort_in_nested_op3096);
                    nested_sort297=nested_sort();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_sort297.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:424:13: nested_distinct
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_distinct_in_nested_op3110);
                    nested_distinct298=nested_distinct();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_distinct298.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:425:13: nested_limit
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_limit_in_nested_op3124);
                    nested_limit299=nested_limit();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_limit299.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:426:13: nested_cross
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_cross_in_nested_op3138);
                    nested_cross300=nested_cross();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_cross300.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:427:13: nested_foreach
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_foreach_in_nested_op3152);
                    nested_foreach301=nested_foreach();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_foreach301.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "nested_op"


    public static class nested_proj_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_proj"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:430:1: nested_proj : ^( NESTED_PROJ col_ref col_ref ( col_ref )* ) ;
    public final AstPrinter.nested_proj_return nested_proj() throws RecognitionException {
        AstPrinter.nested_proj_return retval = new AstPrinter.nested_proj_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree NESTED_PROJ302=null;
        AstPrinter.col_ref_return col_ref303 =null;

        AstPrinter.col_ref_return col_ref304 =null;

        AstPrinter.col_ref_return col_ref305 =null;


        CommonTree NESTED_PROJ302_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:431:5: ( ^( NESTED_PROJ col_ref col_ref ( col_ref )* ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:431:7: ^( NESTED_PROJ col_ref col_ref ( col_ref )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            NESTED_PROJ302=(CommonTree)match(input,NESTED_PROJ,FOLLOW_NESTED_PROJ_in_nested_proj3168); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NESTED_PROJ302_tree = (CommonTree)adaptor.dupNode(NESTED_PROJ302);


            root_1 = (CommonTree)adaptor.becomeRoot(NESTED_PROJ302_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_col_ref_in_nested_proj3170);
            col_ref303=col_ref();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, col_ref303.getTree());


            if ( state.backtracking==0 ) { sb.append(".("); }

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_col_ref_in_nested_proj3174);
            col_ref304=col_ref();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, col_ref304.getTree());


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:431:59: ( col_ref )*
            loop89:
            do {
                int alt89=2;
                int LA89_0 = input.LA(1);

                if ( (LA89_0==DOLLARVAR||LA89_0==GROUP||LA89_0==IDENTIFIER) ) {
                    alt89=1;
                }


                switch (alt89) {
            	case 1 :
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:431:61: col_ref
            	    {
            	    if ( state.backtracking==0 ) { sb.append(", "); }

            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_col_ref_in_nested_proj3180);
            	    col_ref305=col_ref();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, col_ref305.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop89;
                }
            } while (true);


            if ( state.backtracking==0 ) { sb.append(")"); }

            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "nested_proj"


    public static class nested_filter_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_filter"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:434:1: nested_filter : ^( FILTER nested_op_input cond ) ;
    public final AstPrinter.nested_filter_return nested_filter() throws RecognitionException {
        AstPrinter.nested_filter_return retval = new AstPrinter.nested_filter_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FILTER306=null;
        AstPrinter.nested_op_input_return nested_op_input307 =null;

        AstPrinter.cond_return cond308 =null;


        CommonTree FILTER306_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:435:5: ( ^( FILTER nested_op_input cond ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:435:7: ^( FILTER nested_op_input cond )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FILTER306=(CommonTree)match(input,FILTER,FOLLOW_FILTER_in_nested_filter3205); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FILTER306_tree = (CommonTree)adaptor.dupNode(FILTER306);


            root_1 = (CommonTree)adaptor.becomeRoot(FILTER306_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((FILTER306!=null?FILTER306.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_filter3209);
            nested_op_input307=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input307.getTree());


            if ( state.backtracking==0 ) { sb.append(" BY "); }

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_nested_filter3213);
            cond308=cond();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond308.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "nested_filter"


    public static class nested_sort_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_sort"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:438:1: nested_sort : ^( ORDER nested_op_input order_by_clause ( func_clause )? ) ;
    public final AstPrinter.nested_sort_return nested_sort() throws RecognitionException {
        AstPrinter.nested_sort_return retval = new AstPrinter.nested_sort_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ORDER309=null;
        AstPrinter.nested_op_input_return nested_op_input310 =null;

        AstPrinter.order_by_clause_return order_by_clause311 =null;

        AstPrinter.func_clause_return func_clause312 =null;


        CommonTree ORDER309_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:439:5: ( ^( ORDER nested_op_input order_by_clause ( func_clause )? ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:439:7: ^( ORDER nested_op_input order_by_clause ( func_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            ORDER309=(CommonTree)match(input,ORDER,FOLLOW_ORDER_in_nested_sort3235); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ORDER309_tree = (CommonTree)adaptor.dupNode(ORDER309);


            root_1 = (CommonTree)adaptor.becomeRoot(ORDER309_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((ORDER309!=null?ORDER309.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_sort3239);
            nested_op_input310=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input310.getTree());


            if ( state.backtracking==0 ) { sb.append(" BY "); }

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_order_by_clause_in_nested_sort3251);
            order_by_clause311=order_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, order_by_clause311.getTree());


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:440:48: ( func_clause )?
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==FUNC||LA90_0==FUNC_REF) ) {
                alt90=1;
            }
            switch (alt90) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:440:50: func_clause
                    {
                    if ( state.backtracking==0 ) { sb.append(" USING "); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_nested_sort3257);
                    func_clause312=func_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause312.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "nested_sort"


    public static class nested_distinct_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_distinct"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:443:1: nested_distinct : ^( DISTINCT nested_op_input ) ;
    public final AstPrinter.nested_distinct_return nested_distinct() throws RecognitionException {
        AstPrinter.nested_distinct_return retval = new AstPrinter.nested_distinct_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DISTINCT313=null;
        AstPrinter.nested_op_input_return nested_op_input314 =null;


        CommonTree DISTINCT313_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:444:5: ( ^( DISTINCT nested_op_input ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:444:7: ^( DISTINCT nested_op_input )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            DISTINCT313=(CommonTree)match(input,DISTINCT,FOLLOW_DISTINCT_in_nested_distinct3281); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DISTINCT313_tree = (CommonTree)adaptor.dupNode(DISTINCT313);


            root_1 = (CommonTree)adaptor.becomeRoot(DISTINCT313_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((DISTINCT313!=null?DISTINCT313.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_distinct3286);
            nested_op_input314=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input314.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "nested_distinct"


    public static class nested_limit_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_limit"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:447:1: nested_limit : ^( LIMIT nested_op_input ( INTEGER | expr ) ) ;
    public final AstPrinter.nested_limit_return nested_limit() throws RecognitionException {
        AstPrinter.nested_limit_return retval = new AstPrinter.nested_limit_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree LIMIT315=null;
        CommonTree INTEGER317=null;
        AstPrinter.nested_op_input_return nested_op_input316 =null;

        AstPrinter.expr_return expr318 =null;


        CommonTree LIMIT315_tree=null;
        CommonTree INTEGER317_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:448:5: ( ^( LIMIT nested_op_input ( INTEGER | expr ) ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:448:7: ^( LIMIT nested_op_input ( INTEGER | expr ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            LIMIT315=(CommonTree)match(input,LIMIT,FOLLOW_LIMIT_in_nested_limit3308); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LIMIT315_tree = (CommonTree)adaptor.dupNode(LIMIT315);


            root_1 = (CommonTree)adaptor.becomeRoot(LIMIT315_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((LIMIT315!=null?LIMIT315.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_limit3313);
            nested_op_input316=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input316.getTree());


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:448:73: ( INTEGER | expr )
            int alt91=2;
            int LA91_0 = input.LA(1);

            if ( (LA91_0==INTEGER) ) {
                int LA91_1 = input.LA(2);

                if ( (synpred150_AstPrinter()) ) {
                    alt91=1;
                }
                else if ( (true) ) {
                    alt91=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 91, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA91_0==DIV||LA91_0==DOLLARVAR||LA91_0==DOUBLENUMBER||LA91_0==FALSE||LA91_0==FLOATNUMBER||LA91_0==GROUP||LA91_0==LONGINTEGER||LA91_0==MINUS||LA91_0==PERCENT||LA91_0==PLUS||LA91_0==QUOTEDSTRING||LA91_0==STAR||LA91_0==TRUE||(LA91_0 >= BAG_VAL && LA91_0 <= BIN_EXPR)||LA91_0==CAST_EXPR||LA91_0==EXPR_IN_PAREN||LA91_0==FUNC_EVAL||LA91_0==IDENTIFIER||(LA91_0 >= MAP_VAL && LA91_0 <= NEG)||LA91_0==NULL||LA91_0==TUPLE_VAL) ) {
                alt91=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 91, 0, input);

                throw nvae;

            }
            switch (alt91) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:448:75: INTEGER
                    {
                    _last = (CommonTree)input.LT(1);
                    INTEGER317=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_nested_limit3317); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INTEGER317_tree = (CommonTree)adaptor.dupNode(INTEGER317);


                    adaptor.addChild(root_1, INTEGER317_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append(" ").append((INTEGER317!=null?INTEGER317.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:448:127: expr
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_nested_limit3323);
                    expr318=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr318.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "nested_limit"


    public static class nested_cross_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_cross"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:451:1: nested_cross : ^( CROSS nested_op_input_list ) ;
    public final AstPrinter.nested_cross_return nested_cross() throws RecognitionException {
        AstPrinter.nested_cross_return retval = new AstPrinter.nested_cross_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CROSS319=null;
        AstPrinter.nested_op_input_list_return nested_op_input_list320 =null;


        CommonTree CROSS319_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:452:5: ( ^( CROSS nested_op_input_list ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:452:7: ^( CROSS nested_op_input_list )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CROSS319=(CommonTree)match(input,CROSS,FOLLOW_CROSS_in_nested_cross3342); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CROSS319_tree = (CommonTree)adaptor.dupNode(CROSS319);


            root_1 = (CommonTree)adaptor.becomeRoot(CROSS319_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((CROSS319!=null?CROSS319.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_list_in_nested_cross3347);
            nested_op_input_list320=nested_op_input_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input_list320.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "nested_cross"


    public static class nested_foreach_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_foreach"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:455:1: nested_foreach : ^( FOREACH nested_op_input generate_clause ) ;
    public final AstPrinter.nested_foreach_return nested_foreach() throws RecognitionException {
        AstPrinter.nested_foreach_return retval = new AstPrinter.nested_foreach_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FOREACH321=null;
        AstPrinter.nested_op_input_return nested_op_input322 =null;

        AstPrinter.generate_clause_return generate_clause323 =null;


        CommonTree FOREACH321_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:456:2: ( ^( FOREACH nested_op_input generate_clause ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:456:4: ^( FOREACH nested_op_input generate_clause )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FOREACH321=(CommonTree)match(input,FOREACH,FOLLOW_FOREACH_in_nested_foreach3361); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FOREACH321_tree = (CommonTree)adaptor.dupNode(FOREACH321);


            root_1 = (CommonTree)adaptor.becomeRoot(FOREACH321_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((FOREACH321!=null?FOREACH321.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_foreach3366);
            nested_op_input322=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input322.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_generate_clause_in_nested_foreach3368);
            generate_clause323=generate_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, generate_clause323.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "nested_foreach"


    public static class nested_op_input_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_op_input"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:459:1: nested_op_input : ( col_ref | nested_proj );
    public final AstPrinter.nested_op_input_return nested_op_input() throws RecognitionException {
        AstPrinter.nested_op_input_return retval = new AstPrinter.nested_op_input_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.col_ref_return col_ref324 =null;

        AstPrinter.nested_proj_return nested_proj325 =null;



        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:459:17: ( col_ref | nested_proj )
            int alt92=2;
            int LA92_0 = input.LA(1);

            if ( (LA92_0==DOLLARVAR||LA92_0==GROUP||LA92_0==IDENTIFIER) ) {
                alt92=1;
            }
            else if ( (LA92_0==NESTED_PROJ) ) {
                alt92=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 92, 0, input);

                throw nvae;

            }
            switch (alt92) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:459:19: col_ref
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_nested_op_input3379);
                    col_ref324=col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_ref324.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:459:29: nested_proj
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_proj_in_nested_op_input3383);
                    nested_proj325=nested_proj();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_proj325.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "nested_op_input"


    public static class nested_op_input_list_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_op_input_list"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:462:1: nested_op_input_list : nested_op_input ( nested_op_input )* ;
    public final AstPrinter.nested_op_input_list_return nested_op_input_list() throws RecognitionException {
        AstPrinter.nested_op_input_list_return retval = new AstPrinter.nested_op_input_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.nested_op_input_return nested_op_input326 =null;

        AstPrinter.nested_op_input_return nested_op_input327 =null;



        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:463:5: ( nested_op_input ( nested_op_input )* )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:463:7: nested_op_input ( nested_op_input )*
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_op_input_list3397);
            nested_op_input326=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, nested_op_input326.getTree());


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:463:23: ( nested_op_input )*
            loop93:
            do {
                int alt93=2;
                int LA93_0 = input.LA(1);

                if ( (LA93_0==DOLLARVAR||LA93_0==GROUP||LA93_0==IDENTIFIER||LA93_0==NESTED_PROJ) ) {
                    alt93=1;
                }


                switch (alt93) {
            	case 1 :
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:463:25: nested_op_input
            	    {
            	    if ( state.backtracking==0 ) { sb.append(", "); }

            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_nested_op_input_in_nested_op_input_list3403);
            	    nested_op_input327=nested_op_input();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, nested_op_input327.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop93;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "nested_op_input_list"


    public static class stream_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "stream_clause"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:466:1: stream_clause : ^( STREAM rel ( EXECCOMMAND | IDENTIFIER ) ( as_clause )? ) ;
    public final AstPrinter.stream_clause_return stream_clause() throws RecognitionException {
        AstPrinter.stream_clause_return retval = new AstPrinter.stream_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STREAM328=null;
        CommonTree EXECCOMMAND330=null;
        CommonTree IDENTIFIER331=null;
        AstPrinter.rel_return rel329 =null;

        AstPrinter.as_clause_return as_clause332 =null;


        CommonTree STREAM328_tree=null;
        CommonTree EXECCOMMAND330_tree=null;
        CommonTree IDENTIFIER331_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:467:5: ( ^( STREAM rel ( EXECCOMMAND | IDENTIFIER ) ( as_clause )? ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:467:7: ^( STREAM rel ( EXECCOMMAND | IDENTIFIER ) ( as_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            STREAM328=(CommonTree)match(input,STREAM,FOLLOW_STREAM_in_stream_clause3421); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STREAM328_tree = (CommonTree)adaptor.dupNode(STREAM328);


            root_1 = (CommonTree)adaptor.becomeRoot(STREAM328_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((STREAM328!=null?STREAM328.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_stream_clause3425);
            rel329=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel329.getTree());


            if ( state.backtracking==0 ) { sb.append(" THROUGH "); }

            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:468:9: ( EXECCOMMAND | IDENTIFIER )
            int alt94=2;
            int LA94_0 = input.LA(1);

            if ( (LA94_0==EXECCOMMAND) ) {
                alt94=1;
            }
            else if ( (LA94_0==IDENTIFIER) ) {
                alt94=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 94, 0, input);

                throw nvae;

            }
            switch (alt94) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:468:11: EXECCOMMAND
                    {
                    _last = (CommonTree)input.LT(1);
                    EXECCOMMAND330=(CommonTree)match(input,EXECCOMMAND,FOLLOW_EXECCOMMAND_in_stream_clause3439); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EXECCOMMAND330_tree = (CommonTree)adaptor.dupNode(EXECCOMMAND330);


                    adaptor.addChild(root_1, EXECCOMMAND330_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((EXECCOMMAND330!=null?EXECCOMMAND330.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:469:11: IDENTIFIER
                    {
                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER331=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_stream_clause3453); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER331_tree = (CommonTree)adaptor.dupNode(IDENTIFIER331);


                    adaptor.addChild(root_1, IDENTIFIER331_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((IDENTIFIER331!=null?IDENTIFIER331.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:469:57: ( as_clause )?
            int alt95=2;
            int LA95_0 = input.LA(1);

            if ( (LA95_0==AS) ) {
                alt95=1;
            }
            switch (alt95) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:469:57: as_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_as_clause_in_stream_clause3459);
                    as_clause332=as_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, as_clause332.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "stream_clause"


    public static class mr_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "mr_clause"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:472:1: mr_clause : ^( MAPREDUCE QUOTEDSTRING ( path_list )? store_clause load_clause ( EXECCOMMAND )? ) ;
    public final AstPrinter.mr_clause_return mr_clause() throws RecognitionException {
        AstPrinter.mr_clause_return retval = new AstPrinter.mr_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MAPREDUCE333=null;
        CommonTree QUOTEDSTRING334=null;
        CommonTree EXECCOMMAND338=null;
        AstPrinter.path_list_return path_list335 =null;

        AstPrinter.store_clause_return store_clause336 =null;

        AstPrinter.load_clause_return load_clause337 =null;


        CommonTree MAPREDUCE333_tree=null;
        CommonTree QUOTEDSTRING334_tree=null;
        CommonTree EXECCOMMAND338_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:473:5: ( ^( MAPREDUCE QUOTEDSTRING ( path_list )? store_clause load_clause ( EXECCOMMAND )? ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:473:7: ^( MAPREDUCE QUOTEDSTRING ( path_list )? store_clause load_clause ( EXECCOMMAND )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            MAPREDUCE333=(CommonTree)match(input,MAPREDUCE,FOLLOW_MAPREDUCE_in_mr_clause3478); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            MAPREDUCE333_tree = (CommonTree)adaptor.dupNode(MAPREDUCE333);


            root_1 = (CommonTree)adaptor.becomeRoot(MAPREDUCE333_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING334=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_mr_clause3480); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING334_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING334);


            adaptor.addChild(root_1, QUOTEDSTRING334_tree);
            }


            if ( state.backtracking==0 ) { sb.append((MAPREDUCE333!=null?MAPREDUCE333.getText():null)).append(" ").append((QUOTEDSTRING334!=null?QUOTEDSTRING334.getText():null)).append(" "); }

            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:474:9: ( path_list )?
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==QUOTEDSTRING) ) {
                alt96=1;
            }
            switch (alt96) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:474:10: path_list
                    {
                    if ( state.backtracking==0 ) { sb.append(" ("); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_path_list_in_mr_clause3495);
                    path_list335=path_list();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, path_list335.getTree());


                    if ( state.backtracking==0 ) { sb.append(") "); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_store_clause_in_mr_clause3502);
            store_clause336=store_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, store_clause336.getTree());


            if ( state.backtracking==0 ) { sb.append(" "); }

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_load_clause_in_mr_clause3506);
            load_clause337=load_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, load_clause337.getTree());


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:475:9: ( EXECCOMMAND )?
            int alt97=2;
            int LA97_0 = input.LA(1);

            if ( (LA97_0==EXECCOMMAND) ) {
                alt97=1;
            }
            switch (alt97) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:475:10: EXECCOMMAND
                    {
                    _last = (CommonTree)input.LT(1);
                    EXECCOMMAND338=(CommonTree)match(input,EXECCOMMAND,FOLLOW_EXECCOMMAND_in_mr_clause3517); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EXECCOMMAND338_tree = (CommonTree)adaptor.dupNode(EXECCOMMAND338);


                    adaptor.addChild(root_1, EXECCOMMAND338_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append(" ").append((EXECCOMMAND338!=null?EXECCOMMAND338.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "mr_clause"


    public static class split_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "split_clause"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:478:1: split_clause : ^( SPLIT rel split_branch ( split_branch )* ( split_otherwise )? ) ;
    public final AstPrinter.split_clause_return split_clause() throws RecognitionException {
        AstPrinter.split_clause_return retval = new AstPrinter.split_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SPLIT339=null;
        AstPrinter.rel_return rel340 =null;

        AstPrinter.split_branch_return split_branch341 =null;

        AstPrinter.split_branch_return split_branch342 =null;

        AstPrinter.split_otherwise_return split_otherwise343 =null;


        CommonTree SPLIT339_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:479:5: ( ^( SPLIT rel split_branch ( split_branch )* ( split_otherwise )? ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:479:7: ^( SPLIT rel split_branch ( split_branch )* ( split_otherwise )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            SPLIT339=(CommonTree)match(input,SPLIT,FOLLOW_SPLIT_in_split_clause3540); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SPLIT339_tree = (CommonTree)adaptor.dupNode(SPLIT339);


            root_1 = (CommonTree)adaptor.becomeRoot(SPLIT339_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((SPLIT339!=null?SPLIT339.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_split_clause3553);
            rel340=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel340.getTree());


            if ( state.backtracking==0 ) { sb.append(" INTO "); }

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_split_branch_in_split_clause3557);
            split_branch341=split_branch();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, split_branch341.getTree());


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:480:51: ( split_branch )*
            loop98:
            do {
                int alt98=2;
                int LA98_0 = input.LA(1);

                if ( (LA98_0==SPLIT_BRANCH) ) {
                    alt98=1;
                }


                switch (alt98) {
            	case 1 :
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:480:53: split_branch
            	    {
            	    if ( state.backtracking==0 ) { sb.append(", "); }

            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_split_branch_in_split_clause3563);
            	    split_branch342=split_branch();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, split_branch342.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop98;
                }
            } while (true);


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:480:90: ( split_otherwise )?
            int alt99=2;
            int LA99_0 = input.LA(1);

            if ( (LA99_0==OTHERWISE) ) {
                alt99=1;
            }
            switch (alt99) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:480:90: split_otherwise
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_split_otherwise_in_split_clause3568);
                    split_otherwise343=split_otherwise();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, split_otherwise343.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "split_clause"


    public static class split_branch_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "split_branch"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:483:1: split_branch : ^( SPLIT_BRANCH alias cond ) ;
    public final AstPrinter.split_branch_return split_branch() throws RecognitionException {
        AstPrinter.split_branch_return retval = new AstPrinter.split_branch_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SPLIT_BRANCH344=null;
        AstPrinter.alias_return alias345 =null;

        AstPrinter.cond_return cond346 =null;


        CommonTree SPLIT_BRANCH344_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:484:5: ( ^( SPLIT_BRANCH alias cond ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:484:7: ^( SPLIT_BRANCH alias cond )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            SPLIT_BRANCH344=(CommonTree)match(input,SPLIT_BRANCH,FOLLOW_SPLIT_BRANCH_in_split_branch3586); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SPLIT_BRANCH344_tree = (CommonTree)adaptor.dupNode(SPLIT_BRANCH344);


            root_1 = (CommonTree)adaptor.becomeRoot(SPLIT_BRANCH344_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_alias_in_split_branch3588);
            alias345=alias();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, alias345.getTree());


            if ( state.backtracking==0 ) { sb.append(" IF "); }

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_split_branch3592);
            cond346=cond();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond346.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "split_branch"


    public static class split_otherwise_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "split_otherwise"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:487:1: split_otherwise : ^( OTHERWISE alias ) ;
    public final AstPrinter.split_otherwise_return split_otherwise() throws RecognitionException {
        AstPrinter.split_otherwise_return retval = new AstPrinter.split_otherwise_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree OTHERWISE347=null;
        AstPrinter.alias_return alias348 =null;


        CommonTree OTHERWISE347_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:488:5: ( ^( OTHERWISE alias ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:488:7: ^( OTHERWISE alias )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            OTHERWISE347=(CommonTree)match(input,OTHERWISE,FOLLOW_OTHERWISE_in_split_otherwise3614); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            OTHERWISE347_tree = (CommonTree)adaptor.dupNode(OTHERWISE347);


            root_1 = (CommonTree)adaptor.becomeRoot(OTHERWISE347_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((OTHERWISE347!=null?OTHERWISE347.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_alias_in_split_otherwise3618);
            alias348=alias();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, alias348.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "split_otherwise"


    public static class col_ref_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "col_ref"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:491:1: col_ref : ( alias_col_ref | dollar_col_ref );
    public final AstPrinter.col_ref_return col_ref() throws RecognitionException {
        AstPrinter.col_ref_return retval = new AstPrinter.col_ref_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.alias_col_ref_return alias_col_ref349 =null;

        AstPrinter.dollar_col_ref_return dollar_col_ref350 =null;



        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:491:9: ( alias_col_ref | dollar_col_ref )
            int alt100=2;
            int LA100_0 = input.LA(1);

            if ( (LA100_0==GROUP||LA100_0==IDENTIFIER) ) {
                alt100=1;
            }
            else if ( (LA100_0==DOLLARVAR) ) {
                alt100=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 100, 0, input);

                throw nvae;

            }
            switch (alt100) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:491:11: alias_col_ref
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_alias_col_ref_in_col_ref3630);
                    alias_col_ref349=alias_col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, alias_col_ref349.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:491:27: dollar_col_ref
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_dollar_col_ref_in_col_ref3634);
                    dollar_col_ref350=dollar_col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, dollar_col_ref350.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "col_ref"


    public static class alias_col_ref_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "alias_col_ref"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:494:1: alias_col_ref : ( GROUP | IDENTIFIER );
    public final AstPrinter.alias_col_ref_return alias_col_ref() throws RecognitionException {
        AstPrinter.alias_col_ref_return retval = new AstPrinter.alias_col_ref_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree GROUP351=null;
        CommonTree IDENTIFIER352=null;

        CommonTree GROUP351_tree=null;
        CommonTree IDENTIFIER352_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:495:5: ( GROUP | IDENTIFIER )
            int alt101=2;
            int LA101_0 = input.LA(1);

            if ( (LA101_0==GROUP) ) {
                alt101=1;
            }
            else if ( (LA101_0==IDENTIFIER) ) {
                alt101=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 101, 0, input);

                throw nvae;

            }
            switch (alt101) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:495:7: GROUP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    GROUP351=(CommonTree)match(input,GROUP,FOLLOW_GROUP_in_alias_col_ref3648); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    GROUP351_tree = (CommonTree)adaptor.dupNode(GROUP351);


                    adaptor.addChild(root_0, GROUP351_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((GROUP351!=null?GROUP351.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:496:7: IDENTIFIER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER352=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_alias_col_ref3658); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER352_tree = (CommonTree)adaptor.dupNode(IDENTIFIER352);


                    adaptor.addChild(root_0, IDENTIFIER352_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((IDENTIFIER352!=null?IDENTIFIER352.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "alias_col_ref"


    public static class dollar_col_ref_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "dollar_col_ref"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:499:1: dollar_col_ref : DOLLARVAR ;
    public final AstPrinter.dollar_col_ref_return dollar_col_ref() throws RecognitionException {
        AstPrinter.dollar_col_ref_return retval = new AstPrinter.dollar_col_ref_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DOLLARVAR353=null;

        CommonTree DOLLARVAR353_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:500:5: ( DOLLARVAR )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:500:7: DOLLARVAR
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            DOLLARVAR353=(CommonTree)match(input,DOLLARVAR,FOLLOW_DOLLARVAR_in_dollar_col_ref3674); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DOLLARVAR353_tree = (CommonTree)adaptor.dupNode(DOLLARVAR353);


            adaptor.addChild(root_0, DOLLARVAR353_tree);
            }


            if ( state.backtracking==0 ) { sb.append((DOLLARVAR353!=null?DOLLARVAR353.getText():null)); }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "dollar_col_ref"


    public static class const_expr_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "const_expr"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:503:1: const_expr : literal ;
    public final AstPrinter.const_expr_return const_expr() throws RecognitionException {
        AstPrinter.const_expr_return retval = new AstPrinter.const_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.literal_return literal354 =null;



        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:503:12: ( literal )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:503:14: literal
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_literal_in_const_expr3685);
            literal354=literal();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, literal354.getTree());


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "const_expr"


    public static class literal_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "literal"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:506:1: literal : ( scalar | map | bag | tuple );
    public final AstPrinter.literal_return literal() throws RecognitionException {
        AstPrinter.literal_return retval = new AstPrinter.literal_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.scalar_return scalar355 =null;

        AstPrinter.map_return map356 =null;

        AstPrinter.bag_return bag357 =null;

        AstPrinter.tuple_return tuple358 =null;



        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:506:9: ( scalar | map | bag | tuple )
            int alt102=4;
            switch ( input.LA(1) ) {
            case DOUBLENUMBER:
            case FALSE:
            case FLOATNUMBER:
            case INTEGER:
            case LONGINTEGER:
            case MINUS:
            case QUOTEDSTRING:
            case TRUE:
            case NULL:
                {
                alt102=1;
                }
                break;
            case MAP_VAL:
                {
                alt102=2;
                }
                break;
            case BAG_VAL:
                {
                alt102=3;
                }
                break;
            case TUPLE_VAL:
                {
                alt102=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 102, 0, input);

                throw nvae;

            }

            switch (alt102) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:506:11: scalar
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_scalar_in_literal3694);
                    scalar355=scalar();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, scalar355.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:506:20: map
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_map_in_literal3698);
                    map356=map();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, map356.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:506:26: bag
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_bag_in_literal3702);
                    bag357=bag();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, bag357.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:506:32: tuple
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_tuple_in_literal3706);
                    tuple358=tuple();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, tuple358.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "literal"


    public static class scalar_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "scalar"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:509:1: scalar : ( num_scalar | QUOTEDSTRING | NULL | TRUE | FALSE );
    public final AstPrinter.scalar_return scalar() throws RecognitionException {
        AstPrinter.scalar_return retval = new AstPrinter.scalar_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING360=null;
        CommonTree NULL361=null;
        CommonTree TRUE362=null;
        CommonTree FALSE363=null;
        AstPrinter.num_scalar_return num_scalar359 =null;


        CommonTree QUOTEDSTRING360_tree=null;
        CommonTree NULL361_tree=null;
        CommonTree TRUE362_tree=null;
        CommonTree FALSE363_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:509:8: ( num_scalar | QUOTEDSTRING | NULL | TRUE | FALSE )
            int alt103=5;
            switch ( input.LA(1) ) {
            case DOUBLENUMBER:
            case FLOATNUMBER:
            case INTEGER:
            case LONGINTEGER:
            case MINUS:
                {
                alt103=1;
                }
                break;
            case QUOTEDSTRING:
                {
                alt103=2;
                }
                break;
            case NULL:
                {
                alt103=3;
                }
                break;
            case TRUE:
                {
                alt103=4;
                }
                break;
            case FALSE:
                {
                alt103=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 103, 0, input);

                throw nvae;

            }

            switch (alt103) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:509:10: num_scalar
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_num_scalar_in_scalar3715);
                    num_scalar359=num_scalar();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, num_scalar359.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:510:10: QUOTEDSTRING
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    QUOTEDSTRING360=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_scalar3726); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    QUOTEDSTRING360_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING360);


                    adaptor.addChild(root_0, QUOTEDSTRING360_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((QUOTEDSTRING360!=null?QUOTEDSTRING360.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:511:10: NULL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    NULL361=(CommonTree)match(input,NULL,FOLLOW_NULL_in_scalar3739); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NULL361_tree = (CommonTree)adaptor.dupNode(NULL361);


                    adaptor.addChild(root_0, NULL361_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((NULL361!=null?NULL361.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:512:10: TRUE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TRUE362=(CommonTree)match(input,TRUE,FOLLOW_TRUE_in_scalar3753); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TRUE362_tree = (CommonTree)adaptor.dupNode(TRUE362);


                    adaptor.addChild(root_0, TRUE362_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((TRUE362!=null?TRUE362.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:513:10: FALSE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FALSE363=(CommonTree)match(input,FALSE,FOLLOW_FALSE_in_scalar3766); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FALSE363_tree = (CommonTree)adaptor.dupNode(FALSE363);


                    adaptor.addChild(root_0, FALSE363_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((FALSE363!=null?FALSE363.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "scalar"


    public static class num_scalar_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "num_scalar"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:516:1: num_scalar : ( MINUS )? ( INTEGER | LONGINTEGER | FLOATNUMBER | DOUBLENUMBER ) ;
    public final AstPrinter.num_scalar_return num_scalar() throws RecognitionException {
        AstPrinter.num_scalar_return retval = new AstPrinter.num_scalar_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MINUS364=null;
        CommonTree INTEGER365=null;
        CommonTree LONGINTEGER366=null;
        CommonTree FLOATNUMBER367=null;
        CommonTree DOUBLENUMBER368=null;

        CommonTree MINUS364_tree=null;
        CommonTree INTEGER365_tree=null;
        CommonTree LONGINTEGER366_tree=null;
        CommonTree FLOATNUMBER367_tree=null;
        CommonTree DOUBLENUMBER368_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:516:12: ( ( MINUS )? ( INTEGER | LONGINTEGER | FLOATNUMBER | DOUBLENUMBER ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:516:14: ( MINUS )? ( INTEGER | LONGINTEGER | FLOATNUMBER | DOUBLENUMBER )
            {
            root_0 = (CommonTree)adaptor.nil();


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:516:14: ( MINUS )?
            int alt104=2;
            int LA104_0 = input.LA(1);

            if ( (LA104_0==MINUS) ) {
                alt104=1;
            }
            switch (alt104) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:516:16: MINUS
                    {
                    _last = (CommonTree)input.LT(1);
                    MINUS364=(CommonTree)match(input,MINUS,FOLLOW_MINUS_in_num_scalar3782); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MINUS364_tree = (CommonTree)adaptor.dupNode(MINUS364);


                    adaptor.addChild(root_0, MINUS364_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append( "-" ); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:517:14: ( INTEGER | LONGINTEGER | FLOATNUMBER | DOUBLENUMBER )
            int alt105=4;
            switch ( input.LA(1) ) {
            case INTEGER:
                {
                alt105=1;
                }
                break;
            case LONGINTEGER:
                {
                alt105=2;
                }
                break;
            case FLOATNUMBER:
                {
                alt105=3;
                }
                break;
            case DOUBLENUMBER:
                {
                alt105=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 105, 0, input);

                throw nvae;

            }

            switch (alt105) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:517:16: INTEGER
                    {
                    _last = (CommonTree)input.LT(1);
                    INTEGER365=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_num_scalar3804); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INTEGER365_tree = (CommonTree)adaptor.dupNode(INTEGER365);


                    adaptor.addChild(root_0, INTEGER365_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((INTEGER365!=null?INTEGER365.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:518:16: LONGINTEGER
                    {
                    _last = (CommonTree)input.LT(1);
                    LONGINTEGER366=(CommonTree)match(input,LONGINTEGER,FOLLOW_LONGINTEGER_in_num_scalar3823); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LONGINTEGER366_tree = (CommonTree)adaptor.dupNode(LONGINTEGER366);


                    adaptor.addChild(root_0, LONGINTEGER366_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((LONGINTEGER366!=null?LONGINTEGER366.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:519:16: FLOATNUMBER
                    {
                    _last = (CommonTree)input.LT(1);
                    FLOATNUMBER367=(CommonTree)match(input,FLOATNUMBER,FOLLOW_FLOATNUMBER_in_num_scalar3842); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FLOATNUMBER367_tree = (CommonTree)adaptor.dupNode(FLOATNUMBER367);


                    adaptor.addChild(root_0, FLOATNUMBER367_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((FLOATNUMBER367!=null?FLOATNUMBER367.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:520:16: DOUBLENUMBER
                    {
                    _last = (CommonTree)input.LT(1);
                    DOUBLENUMBER368=(CommonTree)match(input,DOUBLENUMBER,FOLLOW_DOUBLENUMBER_in_num_scalar3861); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DOUBLENUMBER368_tree = (CommonTree)adaptor.dupNode(DOUBLENUMBER368);


                    adaptor.addChild(root_0, DOUBLENUMBER368_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((DOUBLENUMBER368!=null?DOUBLENUMBER368.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "num_scalar"


    public static class map_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "map"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:524:1: map : ( ^( MAP_VAL keyvalue ( keyvalue )* ) | ^( MAP_VAL ) );
    public final AstPrinter.map_return map() throws RecognitionException {
        AstPrinter.map_return retval = new AstPrinter.map_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MAP_VAL369=null;
        CommonTree MAP_VAL372=null;
        AstPrinter.keyvalue_return keyvalue370 =null;

        AstPrinter.keyvalue_return keyvalue371 =null;


        CommonTree MAP_VAL369_tree=null;
        CommonTree MAP_VAL372_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:525:5: ( ^( MAP_VAL keyvalue ( keyvalue )* ) | ^( MAP_VAL ) )
            int alt107=2;
            int LA107_0 = input.LA(1);

            if ( (LA107_0==MAP_VAL) ) {
                int LA107_1 = input.LA(2);

                if ( (LA107_1==DOWN) ) {
                    int LA107_2 = input.LA(3);

                    if ( (LA107_2==KEY_VAL_PAIR) ) {
                        alt107=1;
                    }
                    else if ( (LA107_2==UP) ) {
                        alt107=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 107, 2, input);

                        throw nvae;

                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 107, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 107, 0, input);

                throw nvae;

            }
            switch (alt107) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:525:7: ^( MAP_VAL keyvalue ( keyvalue )* )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    MAP_VAL369=(CommonTree)match(input,MAP_VAL,FOLLOW_MAP_VAL_in_map3894); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MAP_VAL369_tree = (CommonTree)adaptor.dupNode(MAP_VAL369);


                    root_1 = (CommonTree)adaptor.becomeRoot(MAP_VAL369_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { sb.append("["); }

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_keyvalue_in_map3898);
                    keyvalue370=keyvalue();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, keyvalue370.getTree());


                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:525:47: ( keyvalue )*
                    loop106:
                    do {
                        int alt106=2;
                        int LA106_0 = input.LA(1);

                        if ( (LA106_0==KEY_VAL_PAIR) ) {
                            alt106=1;
                        }


                        switch (alt106) {
                    	case 1 :
                    	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:525:49: keyvalue
                    	    {
                    	    if ( state.backtracking==0 ) { sb.append(", "); }

                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_keyvalue_in_map3904);
                    	    keyvalue371=keyvalue();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, keyvalue371.getTree());


                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop106;
                        }
                    } while (true);


                    if ( state.backtracking==0 ) { sb.append("]"); }

                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:526:7: ^( MAP_VAL )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    MAP_VAL372=(CommonTree)match(input,MAP_VAL,FOLLOW_MAP_VAL_in_map3920); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MAP_VAL372_tree = (CommonTree)adaptor.dupNode(MAP_VAL372);


                    root_1 = (CommonTree)adaptor.becomeRoot(MAP_VAL372_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { sb.append("[]"); }

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
                        match(input, Token.UP, null); if (state.failed) return retval;
                    }
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "map"


    public static class keyvalue_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "keyvalue"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:529:1: keyvalue : ^( KEY_VAL_PAIR map_key const_expr ) ;
    public final AstPrinter.keyvalue_return keyvalue() throws RecognitionException {
        AstPrinter.keyvalue_return retval = new AstPrinter.keyvalue_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree KEY_VAL_PAIR373=null;
        AstPrinter.map_key_return map_key374 =null;

        AstPrinter.const_expr_return const_expr375 =null;


        CommonTree KEY_VAL_PAIR373_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:530:5: ( ^( KEY_VAL_PAIR map_key const_expr ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:530:7: ^( KEY_VAL_PAIR map_key const_expr )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            KEY_VAL_PAIR373=(CommonTree)match(input,KEY_VAL_PAIR,FOLLOW_KEY_VAL_PAIR_in_keyvalue3940); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            KEY_VAL_PAIR373_tree = (CommonTree)adaptor.dupNode(KEY_VAL_PAIR373);


            root_1 = (CommonTree)adaptor.becomeRoot(KEY_VAL_PAIR373_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_map_key_in_keyvalue3942);
            map_key374=map_key();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, map_key374.getTree());


            if ( state.backtracking==0 ) { sb.append("#"); }

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_const_expr_in_keyvalue3946);
            const_expr375=const_expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, const_expr375.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "keyvalue"


    public static class map_key_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "map_key"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:533:1: map_key : QUOTEDSTRING ;
    public final AstPrinter.map_key_return map_key() throws RecognitionException {
        AstPrinter.map_key_return retval = new AstPrinter.map_key_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING376=null;

        CommonTree QUOTEDSTRING376_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:533:9: ( QUOTEDSTRING )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:533:11: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING376=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_map_key3961); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING376_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING376);


            adaptor.addChild(root_0, QUOTEDSTRING376_tree);
            }


            if ( state.backtracking==0 ) { sb.append((QUOTEDSTRING376!=null?QUOTEDSTRING376.getText():null)); }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "map_key"


    public static class bag_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "bag"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:536:1: bag : ( ^( BAG_VAL tuple ( tuple )* ) | ^( BAG_VAL ) );
    public final AstPrinter.bag_return bag() throws RecognitionException {
        AstPrinter.bag_return retval = new AstPrinter.bag_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BAG_VAL377=null;
        CommonTree BAG_VAL380=null;
        AstPrinter.tuple_return tuple378 =null;

        AstPrinter.tuple_return tuple379 =null;


        CommonTree BAG_VAL377_tree=null;
        CommonTree BAG_VAL380_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:537:5: ( ^( BAG_VAL tuple ( tuple )* ) | ^( BAG_VAL ) )
            int alt109=2;
            int LA109_0 = input.LA(1);

            if ( (LA109_0==BAG_VAL) ) {
                int LA109_1 = input.LA(2);

                if ( (LA109_1==DOWN) ) {
                    int LA109_2 = input.LA(3);

                    if ( (LA109_2==TUPLE_VAL) ) {
                        alt109=1;
                    }
                    else if ( (LA109_2==UP) ) {
                        alt109=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 109, 2, input);

                        throw nvae;

                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 109, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 109, 0, input);

                throw nvae;

            }
            switch (alt109) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:537:7: ^( BAG_VAL tuple ( tuple )* )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    BAG_VAL377=(CommonTree)match(input,BAG_VAL,FOLLOW_BAG_VAL_in_bag3979); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BAG_VAL377_tree = (CommonTree)adaptor.dupNode(BAG_VAL377);


                    root_1 = (CommonTree)adaptor.becomeRoot(BAG_VAL377_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { sb.append("{"); }

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_tuple_in_bag3983);
                    tuple378=tuple();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, tuple378.getTree());


                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:537:44: ( tuple )*
                    loop108:
                    do {
                        int alt108=2;
                        int LA108_0 = input.LA(1);

                        if ( (LA108_0==TUPLE_VAL) ) {
                            alt108=1;
                        }


                        switch (alt108) {
                    	case 1 :
                    	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:537:46: tuple
                    	    {
                    	    if ( state.backtracking==0 ) { sb.append(", "); }

                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_tuple_in_bag3989);
                    	    tuple379=tuple();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, tuple379.getTree());


                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop108;
                        }
                    } while (true);


                    if ( state.backtracking==0 ) { sb.append("}"); }

                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:538:7: ^( BAG_VAL )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    BAG_VAL380=(CommonTree)match(input,BAG_VAL,FOLLOW_BAG_VAL_in_bag4005); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BAG_VAL380_tree = (CommonTree)adaptor.dupNode(BAG_VAL380);


                    root_1 = (CommonTree)adaptor.becomeRoot(BAG_VAL380_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { sb.append("{}"); }

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
                        match(input, Token.UP, null); if (state.failed) return retval;
                    }
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "bag"


    public static class tuple_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "tuple"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:541:1: tuple : ( ^( TUPLE_VAL literal ( literal )* ) | ^( TUPLE_VAL ) );
    public final AstPrinter.tuple_return tuple() throws RecognitionException {
        AstPrinter.tuple_return retval = new AstPrinter.tuple_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree TUPLE_VAL381=null;
        CommonTree TUPLE_VAL384=null;
        AstPrinter.literal_return literal382 =null;

        AstPrinter.literal_return literal383 =null;


        CommonTree TUPLE_VAL381_tree=null;
        CommonTree TUPLE_VAL384_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:542:5: ( ^( TUPLE_VAL literal ( literal )* ) | ^( TUPLE_VAL ) )
            int alt111=2;
            int LA111_0 = input.LA(1);

            if ( (LA111_0==TUPLE_VAL) ) {
                int LA111_1 = input.LA(2);

                if ( (LA111_1==DOWN) ) {
                    int LA111_2 = input.LA(3);

                    if ( (LA111_2==DOUBLENUMBER||LA111_2==FALSE||LA111_2==FLOATNUMBER||LA111_2==INTEGER||LA111_2==LONGINTEGER||LA111_2==MINUS||LA111_2==QUOTEDSTRING||LA111_2==TRUE||LA111_2==BAG_VAL||LA111_2==MAP_VAL||LA111_2==NULL||LA111_2==TUPLE_VAL) ) {
                        alt111=1;
                    }
                    else if ( (LA111_2==UP) ) {
                        alt111=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 111, 2, input);

                        throw nvae;

                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 111, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 111, 0, input);

                throw nvae;

            }
            switch (alt111) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:542:7: ^( TUPLE_VAL literal ( literal )* )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    TUPLE_VAL381=(CommonTree)match(input,TUPLE_VAL,FOLLOW_TUPLE_VAL_in_tuple4025); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TUPLE_VAL381_tree = (CommonTree)adaptor.dupNode(TUPLE_VAL381);


                    root_1 = (CommonTree)adaptor.becomeRoot(TUPLE_VAL381_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { sb.append("("); }

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_literal_in_tuple4029);
                    literal382=literal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, literal382.getTree());


                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:542:48: ( literal )*
                    loop110:
                    do {
                        int alt110=2;
                        int LA110_0 = input.LA(1);

                        if ( (LA110_0==DOUBLENUMBER||LA110_0==FALSE||LA110_0==FLOATNUMBER||LA110_0==INTEGER||LA110_0==LONGINTEGER||LA110_0==MINUS||LA110_0==QUOTEDSTRING||LA110_0==TRUE||LA110_0==BAG_VAL||LA110_0==MAP_VAL||LA110_0==NULL||LA110_0==TUPLE_VAL) ) {
                            alt110=1;
                        }


                        switch (alt110) {
                    	case 1 :
                    	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:542:50: literal
                    	    {
                    	    if ( state.backtracking==0 ) { sb.append(", "); }

                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_literal_in_tuple4036);
                    	    literal383=literal();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, literal383.getTree());


                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop110;
                        }
                    } while (true);


                    if ( state.backtracking==0 ) { sb.append(")"); }

                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:543:7: ^( TUPLE_VAL )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    TUPLE_VAL384=(CommonTree)match(input,TUPLE_VAL,FOLLOW_TUPLE_VAL_in_tuple4052); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TUPLE_VAL384_tree = (CommonTree)adaptor.dupNode(TUPLE_VAL384);


                    root_1 = (CommonTree)adaptor.becomeRoot(TUPLE_VAL384_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { sb.append("()"); }

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
                        match(input, Token.UP, null); if (state.failed) return retval;
                    }
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "tuple"


    public static class eid_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "eid"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:547:1: eid : ( rel_str_op | IMPORT | RETURNS | DEFINE | LOAD | FILTER | FOREACH | MATCHES | ORDER | DISTINCT | COGROUP | JOIN | CROSS | UNION | SPLIT | INTO | IF | ALL | AS | BY | USING | INNER | OUTER | PARALLEL | PARTITION | GROUP | AND | OR | NOT | GENERATE | FLATTEN | EVAL | ASC | DESC | BOOLEAN | INT | LONG | FLOAT | DOUBLE | CHARARRAY | BYTEARRAY | BAG | TUPLE | MAP | IS | NULL | TRUE | FALSE | STREAM | THROUGH | STORE | MAPREDUCE | SHIP | CACHE | INPUT | OUTPUT | STDERROR | STDIN | STDOUT | LIMIT | SAMPLE | LEFT | RIGHT | FULL | IDENTIFIER | TOBAG | TOMAP | TOTUPLE );
    public final AstPrinter.eid_return eid() throws RecognitionException {
        AstPrinter.eid_return retval = new AstPrinter.eid_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IMPORT386=null;
        CommonTree RETURNS387=null;
        CommonTree DEFINE388=null;
        CommonTree LOAD389=null;
        CommonTree FILTER390=null;
        CommonTree FOREACH391=null;
        CommonTree MATCHES392=null;
        CommonTree ORDER393=null;
        CommonTree DISTINCT394=null;
        CommonTree COGROUP395=null;
        CommonTree JOIN396=null;
        CommonTree CROSS397=null;
        CommonTree UNION398=null;
        CommonTree SPLIT399=null;
        CommonTree INTO400=null;
        CommonTree IF401=null;
        CommonTree ALL402=null;
        CommonTree AS403=null;
        CommonTree BY404=null;
        CommonTree USING405=null;
        CommonTree INNER406=null;
        CommonTree OUTER407=null;
        CommonTree PARALLEL408=null;
        CommonTree PARTITION409=null;
        CommonTree GROUP410=null;
        CommonTree AND411=null;
        CommonTree OR412=null;
        CommonTree NOT413=null;
        CommonTree GENERATE414=null;
        CommonTree FLATTEN415=null;
        CommonTree EVAL416=null;
        CommonTree ASC417=null;
        CommonTree DESC418=null;
        CommonTree BOOLEAN419=null;
        CommonTree INT420=null;
        CommonTree LONG421=null;
        CommonTree FLOAT422=null;
        CommonTree DOUBLE423=null;
        CommonTree CHARARRAY424=null;
        CommonTree BYTEARRAY425=null;
        CommonTree BAG426=null;
        CommonTree TUPLE427=null;
        CommonTree MAP428=null;
        CommonTree IS429=null;
        CommonTree NULL430=null;
        CommonTree TRUE431=null;
        CommonTree FALSE432=null;
        CommonTree STREAM433=null;
        CommonTree THROUGH434=null;
        CommonTree STORE435=null;
        CommonTree MAPREDUCE436=null;
        CommonTree SHIP437=null;
        CommonTree CACHE438=null;
        CommonTree INPUT439=null;
        CommonTree OUTPUT440=null;
        CommonTree STDERROR441=null;
        CommonTree STDIN442=null;
        CommonTree STDOUT443=null;
        CommonTree LIMIT444=null;
        CommonTree SAMPLE445=null;
        CommonTree LEFT446=null;
        CommonTree RIGHT447=null;
        CommonTree FULL448=null;
        CommonTree IDENTIFIER449=null;
        CommonTree TOBAG450=null;
        CommonTree TOMAP451=null;
        CommonTree TOTUPLE452=null;
        AstPrinter.rel_str_op_return rel_str_op385 =null;


        CommonTree IMPORT386_tree=null;
        CommonTree RETURNS387_tree=null;
        CommonTree DEFINE388_tree=null;
        CommonTree LOAD389_tree=null;
        CommonTree FILTER390_tree=null;
        CommonTree FOREACH391_tree=null;
        CommonTree MATCHES392_tree=null;
        CommonTree ORDER393_tree=null;
        CommonTree DISTINCT394_tree=null;
        CommonTree COGROUP395_tree=null;
        CommonTree JOIN396_tree=null;
        CommonTree CROSS397_tree=null;
        CommonTree UNION398_tree=null;
        CommonTree SPLIT399_tree=null;
        CommonTree INTO400_tree=null;
        CommonTree IF401_tree=null;
        CommonTree ALL402_tree=null;
        CommonTree AS403_tree=null;
        CommonTree BY404_tree=null;
        CommonTree USING405_tree=null;
        CommonTree INNER406_tree=null;
        CommonTree OUTER407_tree=null;
        CommonTree PARALLEL408_tree=null;
        CommonTree PARTITION409_tree=null;
        CommonTree GROUP410_tree=null;
        CommonTree AND411_tree=null;
        CommonTree OR412_tree=null;
        CommonTree NOT413_tree=null;
        CommonTree GENERATE414_tree=null;
        CommonTree FLATTEN415_tree=null;
        CommonTree EVAL416_tree=null;
        CommonTree ASC417_tree=null;
        CommonTree DESC418_tree=null;
        CommonTree BOOLEAN419_tree=null;
        CommonTree INT420_tree=null;
        CommonTree LONG421_tree=null;
        CommonTree FLOAT422_tree=null;
        CommonTree DOUBLE423_tree=null;
        CommonTree CHARARRAY424_tree=null;
        CommonTree BYTEARRAY425_tree=null;
        CommonTree BAG426_tree=null;
        CommonTree TUPLE427_tree=null;
        CommonTree MAP428_tree=null;
        CommonTree IS429_tree=null;
        CommonTree NULL430_tree=null;
        CommonTree TRUE431_tree=null;
        CommonTree FALSE432_tree=null;
        CommonTree STREAM433_tree=null;
        CommonTree THROUGH434_tree=null;
        CommonTree STORE435_tree=null;
        CommonTree MAPREDUCE436_tree=null;
        CommonTree SHIP437_tree=null;
        CommonTree CACHE438_tree=null;
        CommonTree INPUT439_tree=null;
        CommonTree OUTPUT440_tree=null;
        CommonTree STDERROR441_tree=null;
        CommonTree STDIN442_tree=null;
        CommonTree STDOUT443_tree=null;
        CommonTree LIMIT444_tree=null;
        CommonTree SAMPLE445_tree=null;
        CommonTree LEFT446_tree=null;
        CommonTree RIGHT447_tree=null;
        CommonTree FULL448_tree=null;
        CommonTree IDENTIFIER449_tree=null;
        CommonTree TOBAG450_tree=null;
        CommonTree TOMAP451_tree=null;
        CommonTree TOTUPLE452_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:547:5: ( rel_str_op | IMPORT | RETURNS | DEFINE | LOAD | FILTER | FOREACH | MATCHES | ORDER | DISTINCT | COGROUP | JOIN | CROSS | UNION | SPLIT | INTO | IF | ALL | AS | BY | USING | INNER | OUTER | PARALLEL | PARTITION | GROUP | AND | OR | NOT | GENERATE | FLATTEN | EVAL | ASC | DESC | BOOLEAN | INT | LONG | FLOAT | DOUBLE | CHARARRAY | BYTEARRAY | BAG | TUPLE | MAP | IS | NULL | TRUE | FALSE | STREAM | THROUGH | STORE | MAPREDUCE | SHIP | CACHE | INPUT | OUTPUT | STDERROR | STDIN | STDOUT | LIMIT | SAMPLE | LEFT | RIGHT | FULL | IDENTIFIER | TOBAG | TOMAP | TOTUPLE )
            int alt112=68;
            switch ( input.LA(1) ) {
            case STR_OP_EQ:
            case STR_OP_GT:
            case STR_OP_GTE:
            case STR_OP_LT:
            case STR_OP_LTE:
            case STR_OP_MATCHES:
            case STR_OP_NE:
                {
                alt112=1;
                }
                break;
            case IMPORT:
                {
                alt112=2;
                }
                break;
            case RETURNS:
                {
                alt112=3;
                }
                break;
            case DEFINE:
                {
                alt112=4;
                }
                break;
            case LOAD:
                {
                alt112=5;
                }
                break;
            case FILTER:
                {
                alt112=6;
                }
                break;
            case FOREACH:
                {
                alt112=7;
                }
                break;
            case MATCHES:
                {
                alt112=8;
                }
                break;
            case ORDER:
                {
                alt112=9;
                }
                break;
            case DISTINCT:
                {
                alt112=10;
                }
                break;
            case COGROUP:
                {
                alt112=11;
                }
                break;
            case JOIN:
                {
                alt112=12;
                }
                break;
            case CROSS:
                {
                alt112=13;
                }
                break;
            case UNION:
                {
                alt112=14;
                }
                break;
            case SPLIT:
                {
                alt112=15;
                }
                break;
            case INTO:
                {
                alt112=16;
                }
                break;
            case IF:
                {
                alt112=17;
                }
                break;
            case ALL:
                {
                alt112=18;
                }
                break;
            case AS:
                {
                alt112=19;
                }
                break;
            case BY:
                {
                alt112=20;
                }
                break;
            case USING:
                {
                alt112=21;
                }
                break;
            case INNER:
                {
                alt112=22;
                }
                break;
            case OUTER:
                {
                alt112=23;
                }
                break;
            case PARALLEL:
                {
                alt112=24;
                }
                break;
            case PARTITION:
                {
                alt112=25;
                }
                break;
            case GROUP:
                {
                alt112=26;
                }
                break;
            case AND:
                {
                alt112=27;
                }
                break;
            case OR:
                {
                alt112=28;
                }
                break;
            case NOT:
                {
                alt112=29;
                }
                break;
            case GENERATE:
                {
                alt112=30;
                }
                break;
            case FLATTEN:
                {
                alt112=31;
                }
                break;
            case EVAL:
                {
                alt112=32;
                }
                break;
            case ASC:
                {
                alt112=33;
                }
                break;
            case DESC:
                {
                alt112=34;
                }
                break;
            case BOOLEAN:
                {
                alt112=35;
                }
                break;
            case INT:
                {
                alt112=36;
                }
                break;
            case LONG:
                {
                alt112=37;
                }
                break;
            case FLOAT:
                {
                alt112=38;
                }
                break;
            case DOUBLE:
                {
                alt112=39;
                }
                break;
            case CHARARRAY:
                {
                alt112=40;
                }
                break;
            case BYTEARRAY:
                {
                alt112=41;
                }
                break;
            case BAG:
                {
                alt112=42;
                }
                break;
            case TUPLE:
                {
                alt112=43;
                }
                break;
            case MAP:
                {
                alt112=44;
                }
                break;
            case IS:
                {
                alt112=45;
                }
                break;
            case NULL:
                {
                alt112=46;
                }
                break;
            case TRUE:
                {
                alt112=47;
                }
                break;
            case FALSE:
                {
                alt112=48;
                }
                break;
            case STREAM:
                {
                alt112=49;
                }
                break;
            case THROUGH:
                {
                alt112=50;
                }
                break;
            case STORE:
                {
                alt112=51;
                }
                break;
            case MAPREDUCE:
                {
                alt112=52;
                }
                break;
            case SHIP:
                {
                alt112=53;
                }
                break;
            case CACHE:
                {
                alt112=54;
                }
                break;
            case INPUT:
                {
                alt112=55;
                }
                break;
            case OUTPUT:
                {
                alt112=56;
                }
                break;
            case STDERROR:
                {
                alt112=57;
                }
                break;
            case STDIN:
                {
                alt112=58;
                }
                break;
            case STDOUT:
                {
                alt112=59;
                }
                break;
            case LIMIT:
                {
                alt112=60;
                }
                break;
            case SAMPLE:
                {
                alt112=61;
                }
                break;
            case LEFT:
                {
                alt112=62;
                }
                break;
            case RIGHT:
                {
                alt112=63;
                }
                break;
            case FULL:
                {
                alt112=64;
                }
                break;
            case IDENTIFIER:
                {
                alt112=65;
                }
                break;
            case TOBAG:
                {
                alt112=66;
                }
                break;
            case TOMAP:
                {
                alt112=67;
                }
                break;
            case TOTUPLE:
                {
                alt112=68;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 112, 0, input);

                throw nvae;

            }

            switch (alt112) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:547:7: rel_str_op
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_str_op_in_eid4066);
                    rel_str_op385=rel_str_op();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_str_op385.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:548:7: IMPORT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IMPORT386=(CommonTree)match(input,IMPORT,FOLLOW_IMPORT_in_eid4074); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IMPORT386_tree = (CommonTree)adaptor.dupNode(IMPORT386);


                    adaptor.addChild(root_0, IMPORT386_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((IMPORT386!=null?IMPORT386.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:549:7: RETURNS
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    RETURNS387=(CommonTree)match(input,RETURNS,FOLLOW_RETURNS_in_eid4087); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RETURNS387_tree = (CommonTree)adaptor.dupNode(RETURNS387);


                    adaptor.addChild(root_0, RETURNS387_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((RETURNS387!=null?RETURNS387.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:550:7: DEFINE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DEFINE388=(CommonTree)match(input,DEFINE,FOLLOW_DEFINE_in_eid4099); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DEFINE388_tree = (CommonTree)adaptor.dupNode(DEFINE388);


                    adaptor.addChild(root_0, DEFINE388_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((DEFINE388!=null?DEFINE388.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:551:7: LOAD
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LOAD389=(CommonTree)match(input,LOAD,FOLLOW_LOAD_in_eid4112); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LOAD389_tree = (CommonTree)adaptor.dupNode(LOAD389);


                    adaptor.addChild(root_0, LOAD389_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((LOAD389!=null?LOAD389.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:552:7: FILTER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FILTER390=(CommonTree)match(input,FILTER,FOLLOW_FILTER_in_eid4127); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FILTER390_tree = (CommonTree)adaptor.dupNode(FILTER390);


                    adaptor.addChild(root_0, FILTER390_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((FILTER390!=null?FILTER390.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:553:7: FOREACH
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FOREACH391=(CommonTree)match(input,FOREACH,FOLLOW_FOREACH_in_eid4140); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FOREACH391_tree = (CommonTree)adaptor.dupNode(FOREACH391);


                    adaptor.addChild(root_0, FOREACH391_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((FOREACH391!=null?FOREACH391.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:554:7: MATCHES
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    MATCHES392=(CommonTree)match(input,MATCHES,FOLLOW_MATCHES_in_eid4152); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MATCHES392_tree = (CommonTree)adaptor.dupNode(MATCHES392);


                    adaptor.addChild(root_0, MATCHES392_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((MATCHES392!=null?MATCHES392.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:555:7: ORDER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ORDER393=(CommonTree)match(input,ORDER,FOLLOW_ORDER_in_eid4164); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ORDER393_tree = (CommonTree)adaptor.dupNode(ORDER393);


                    adaptor.addChild(root_0, ORDER393_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((ORDER393!=null?ORDER393.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:556:7: DISTINCT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DISTINCT394=(CommonTree)match(input,DISTINCT,FOLLOW_DISTINCT_in_eid4178); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DISTINCT394_tree = (CommonTree)adaptor.dupNode(DISTINCT394);


                    adaptor.addChild(root_0, DISTINCT394_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((DISTINCT394!=null?DISTINCT394.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 11 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:557:7: COGROUP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    COGROUP395=(CommonTree)match(input,COGROUP,FOLLOW_COGROUP_in_eid4189); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    COGROUP395_tree = (CommonTree)adaptor.dupNode(COGROUP395);


                    adaptor.addChild(root_0, COGROUP395_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((COGROUP395!=null?COGROUP395.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 12 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:558:7: JOIN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    JOIN396=(CommonTree)match(input,JOIN,FOLLOW_JOIN_in_eid4201); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    JOIN396_tree = (CommonTree)adaptor.dupNode(JOIN396);


                    adaptor.addChild(root_0, JOIN396_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((JOIN396!=null?JOIN396.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 13 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:559:7: CROSS
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CROSS397=(CommonTree)match(input,CROSS,FOLLOW_CROSS_in_eid4216); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CROSS397_tree = (CommonTree)adaptor.dupNode(CROSS397);


                    adaptor.addChild(root_0, CROSS397_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((CROSS397!=null?CROSS397.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 14 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:560:7: UNION
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    UNION398=(CommonTree)match(input,UNION,FOLLOW_UNION_in_eid4230); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    UNION398_tree = (CommonTree)adaptor.dupNode(UNION398);


                    adaptor.addChild(root_0, UNION398_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((UNION398!=null?UNION398.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 15 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:561:7: SPLIT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    SPLIT399=(CommonTree)match(input,SPLIT,FOLLOW_SPLIT_in_eid4244); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SPLIT399_tree = (CommonTree)adaptor.dupNode(SPLIT399);


                    adaptor.addChild(root_0, SPLIT399_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((SPLIT399!=null?SPLIT399.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 16 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:562:7: INTO
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INTO400=(CommonTree)match(input,INTO,FOLLOW_INTO_in_eid4258); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INTO400_tree = (CommonTree)adaptor.dupNode(INTO400);


                    adaptor.addChild(root_0, INTO400_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((INTO400!=null?INTO400.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 17 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:563:7: IF
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IF401=(CommonTree)match(input,IF,FOLLOW_IF_in_eid4273); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IF401_tree = (CommonTree)adaptor.dupNode(IF401);


                    adaptor.addChild(root_0, IF401_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((IF401!=null?IF401.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 18 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:564:7: ALL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ALL402=(CommonTree)match(input,ALL,FOLLOW_ALL_in_eid4290); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ALL402_tree = (CommonTree)adaptor.dupNode(ALL402);


                    adaptor.addChild(root_0, ALL402_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((ALL402!=null?ALL402.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 19 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:565:7: AS
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    AS403=(CommonTree)match(input,AS,FOLLOW_AS_in_eid4306); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    AS403_tree = (CommonTree)adaptor.dupNode(AS403);


                    adaptor.addChild(root_0, AS403_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((AS403!=null?AS403.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 20 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:566:7: BY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BY404=(CommonTree)match(input,BY,FOLLOW_BY_in_eid4323); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BY404_tree = (CommonTree)adaptor.dupNode(BY404);


                    adaptor.addChild(root_0, BY404_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((BY404!=null?BY404.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 21 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:567:7: USING
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    USING405=(CommonTree)match(input,USING,FOLLOW_USING_in_eid4340); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    USING405_tree = (CommonTree)adaptor.dupNode(USING405);


                    adaptor.addChild(root_0, USING405_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((USING405!=null?USING405.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 22 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:568:7: INNER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INNER406=(CommonTree)match(input,INNER,FOLLOW_INNER_in_eid4354); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INNER406_tree = (CommonTree)adaptor.dupNode(INNER406);


                    adaptor.addChild(root_0, INNER406_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((INNER406!=null?INNER406.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 23 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:569:7: OUTER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    OUTER407=(CommonTree)match(input,OUTER,FOLLOW_OUTER_in_eid4368); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OUTER407_tree = (CommonTree)adaptor.dupNode(OUTER407);


                    adaptor.addChild(root_0, OUTER407_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((OUTER407!=null?OUTER407.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 24 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:570:7: PARALLEL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    PARALLEL408=(CommonTree)match(input,PARALLEL,FOLLOW_PARALLEL_in_eid4382); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PARALLEL408_tree = (CommonTree)adaptor.dupNode(PARALLEL408);


                    adaptor.addChild(root_0, PARALLEL408_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((PARALLEL408!=null?PARALLEL408.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 25 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:571:7: PARTITION
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    PARTITION409=(CommonTree)match(input,PARTITION,FOLLOW_PARTITION_in_eid4393); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PARTITION409_tree = (CommonTree)adaptor.dupNode(PARTITION409);


                    adaptor.addChild(root_0, PARTITION409_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((PARTITION409!=null?PARTITION409.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 26 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:572:7: GROUP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    GROUP410=(CommonTree)match(input,GROUP,FOLLOW_GROUP_in_eid4403); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    GROUP410_tree = (CommonTree)adaptor.dupNode(GROUP410);


                    adaptor.addChild(root_0, GROUP410_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((GROUP410!=null?GROUP410.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 27 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:573:7: AND
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    AND411=(CommonTree)match(input,AND,FOLLOW_AND_in_eid4417); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    AND411_tree = (CommonTree)adaptor.dupNode(AND411);


                    adaptor.addChild(root_0, AND411_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((AND411!=null?AND411.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 28 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:574:7: OR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    OR412=(CommonTree)match(input,OR,FOLLOW_OR_in_eid4433); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OR412_tree = (CommonTree)adaptor.dupNode(OR412);


                    adaptor.addChild(root_0, OR412_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((OR412!=null?OR412.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 29 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:575:7: NOT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    NOT413=(CommonTree)match(input,NOT,FOLLOW_NOT_in_eid4450); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NOT413_tree = (CommonTree)adaptor.dupNode(NOT413);


                    adaptor.addChild(root_0, NOT413_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((NOT413!=null?NOT413.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 30 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:576:7: GENERATE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    GENERATE414=(CommonTree)match(input,GENERATE,FOLLOW_GENERATE_in_eid4466); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    GENERATE414_tree = (CommonTree)adaptor.dupNode(GENERATE414);


                    adaptor.addChild(root_0, GENERATE414_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((GENERATE414!=null?GENERATE414.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 31 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:577:7: FLATTEN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FLATTEN415=(CommonTree)match(input,FLATTEN,FOLLOW_FLATTEN_in_eid4477); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FLATTEN415_tree = (CommonTree)adaptor.dupNode(FLATTEN415);


                    adaptor.addChild(root_0, FLATTEN415_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((FLATTEN415!=null?FLATTEN415.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 32 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:578:7: EVAL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    EVAL416=(CommonTree)match(input,EVAL,FOLLOW_EVAL_in_eid4489); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EVAL416_tree = (CommonTree)adaptor.dupNode(EVAL416);


                    adaptor.addChild(root_0, EVAL416_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((EVAL416!=null?EVAL416.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 33 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:579:7: ASC
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ASC417=(CommonTree)match(input,ASC,FOLLOW_ASC_in_eid4504); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ASC417_tree = (CommonTree)adaptor.dupNode(ASC417);


                    adaptor.addChild(root_0, ASC417_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((ASC417!=null?ASC417.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 34 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:580:7: DESC
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DESC418=(CommonTree)match(input,DESC,FOLLOW_DESC_in_eid4520); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DESC418_tree = (CommonTree)adaptor.dupNode(DESC418);


                    adaptor.addChild(root_0, DESC418_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((DESC418!=null?DESC418.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 35 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:581:7: BOOLEAN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BOOLEAN419=(CommonTree)match(input,BOOLEAN,FOLLOW_BOOLEAN_in_eid4535); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BOOLEAN419_tree = (CommonTree)adaptor.dupNode(BOOLEAN419);


                    adaptor.addChild(root_0, BOOLEAN419_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((BOOLEAN419!=null?BOOLEAN419.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 36 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:582:7: INT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INT420=(CommonTree)match(input,INT,FOLLOW_INT_in_eid4547); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INT420_tree = (CommonTree)adaptor.dupNode(INT420);


                    adaptor.addChild(root_0, INT420_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((INT420!=null?INT420.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 37 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:583:7: LONG
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LONG421=(CommonTree)match(input,LONG,FOLLOW_LONG_in_eid4563); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LONG421_tree = (CommonTree)adaptor.dupNode(LONG421);


                    adaptor.addChild(root_0, LONG421_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((LONG421!=null?LONG421.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 38 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:584:7: FLOAT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FLOAT422=(CommonTree)match(input,FLOAT,FOLLOW_FLOAT_in_eid4578); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FLOAT422_tree = (CommonTree)adaptor.dupNode(FLOAT422);


                    adaptor.addChild(root_0, FLOAT422_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((FLOAT422!=null?FLOAT422.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 39 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:585:7: DOUBLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DOUBLE423=(CommonTree)match(input,DOUBLE,FOLLOW_DOUBLE_in_eid4592); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DOUBLE423_tree = (CommonTree)adaptor.dupNode(DOUBLE423);


                    adaptor.addChild(root_0, DOUBLE423_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((DOUBLE423!=null?DOUBLE423.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 40 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:586:7: CHARARRAY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CHARARRAY424=(CommonTree)match(input,CHARARRAY,FOLLOW_CHARARRAY_in_eid4605); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CHARARRAY424_tree = (CommonTree)adaptor.dupNode(CHARARRAY424);


                    adaptor.addChild(root_0, CHARARRAY424_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((CHARARRAY424!=null?CHARARRAY424.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 41 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:587:7: BYTEARRAY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BYTEARRAY425=(CommonTree)match(input,BYTEARRAY,FOLLOW_BYTEARRAY_in_eid4615); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BYTEARRAY425_tree = (CommonTree)adaptor.dupNode(BYTEARRAY425);


                    adaptor.addChild(root_0, BYTEARRAY425_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((BYTEARRAY425!=null?BYTEARRAY425.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 42 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:588:7: BAG
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BAG426=(CommonTree)match(input,BAG,FOLLOW_BAG_in_eid4625); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BAG426_tree = (CommonTree)adaptor.dupNode(BAG426);


                    adaptor.addChild(root_0, BAG426_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((BAG426!=null?BAG426.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 43 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:589:7: TUPLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TUPLE427=(CommonTree)match(input,TUPLE,FOLLOW_TUPLE_in_eid4641); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TUPLE427_tree = (CommonTree)adaptor.dupNode(TUPLE427);


                    adaptor.addChild(root_0, TUPLE427_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((TUPLE427!=null?TUPLE427.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 44 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:590:7: MAP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    MAP428=(CommonTree)match(input,MAP,FOLLOW_MAP_in_eid4655); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MAP428_tree = (CommonTree)adaptor.dupNode(MAP428);


                    adaptor.addChild(root_0, MAP428_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((MAP428!=null?MAP428.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 45 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:591:7: IS
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IS429=(CommonTree)match(input,IS,FOLLOW_IS_in_eid4671); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IS429_tree = (CommonTree)adaptor.dupNode(IS429);


                    adaptor.addChild(root_0, IS429_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((IS429!=null?IS429.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 46 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:592:7: NULL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    NULL430=(CommonTree)match(input,NULL,FOLLOW_NULL_in_eid4688); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NULL430_tree = (CommonTree)adaptor.dupNode(NULL430);


                    adaptor.addChild(root_0, NULL430_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((NULL430!=null?NULL430.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 47 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:593:7: TRUE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TRUE431=(CommonTree)match(input,TRUE,FOLLOW_TRUE_in_eid4703); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TRUE431_tree = (CommonTree)adaptor.dupNode(TRUE431);


                    adaptor.addChild(root_0, TRUE431_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((TRUE431!=null?TRUE431.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 48 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:594:7: FALSE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FALSE432=(CommonTree)match(input,FALSE,FOLLOW_FALSE_in_eid4718); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FALSE432_tree = (CommonTree)adaptor.dupNode(FALSE432);


                    adaptor.addChild(root_0, FALSE432_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((FALSE432!=null?FALSE432.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 49 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:595:7: STREAM
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STREAM433=(CommonTree)match(input,STREAM,FOLLOW_STREAM_in_eid4732); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STREAM433_tree = (CommonTree)adaptor.dupNode(STREAM433);


                    adaptor.addChild(root_0, STREAM433_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((STREAM433!=null?STREAM433.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 50 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:596:7: THROUGH
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    THROUGH434=(CommonTree)match(input,THROUGH,FOLLOW_THROUGH_in_eid4745); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    THROUGH434_tree = (CommonTree)adaptor.dupNode(THROUGH434);


                    adaptor.addChild(root_0, THROUGH434_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((THROUGH434!=null?THROUGH434.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 51 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:597:7: STORE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STORE435=(CommonTree)match(input,STORE,FOLLOW_STORE_in_eid4757); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STORE435_tree = (CommonTree)adaptor.dupNode(STORE435);


                    adaptor.addChild(root_0, STORE435_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((STORE435!=null?STORE435.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 52 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:598:7: MAPREDUCE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    MAPREDUCE436=(CommonTree)match(input,MAPREDUCE,FOLLOW_MAPREDUCE_in_eid4771); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MAPREDUCE436_tree = (CommonTree)adaptor.dupNode(MAPREDUCE436);


                    adaptor.addChild(root_0, MAPREDUCE436_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((MAPREDUCE436!=null?MAPREDUCE436.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 53 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:599:7: SHIP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    SHIP437=(CommonTree)match(input,SHIP,FOLLOW_SHIP_in_eid4781); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SHIP437_tree = (CommonTree)adaptor.dupNode(SHIP437);


                    adaptor.addChild(root_0, SHIP437_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((SHIP437!=null?SHIP437.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 54 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:600:7: CACHE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CACHE438=(CommonTree)match(input,CACHE,FOLLOW_CACHE_in_eid4796); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CACHE438_tree = (CommonTree)adaptor.dupNode(CACHE438);


                    adaptor.addChild(root_0, CACHE438_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((CACHE438!=null?CACHE438.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 55 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:601:7: INPUT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INPUT439=(CommonTree)match(input,INPUT,FOLLOW_INPUT_in_eid4810); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INPUT439_tree = (CommonTree)adaptor.dupNode(INPUT439);


                    adaptor.addChild(root_0, INPUT439_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((INPUT439!=null?INPUT439.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 56 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:602:7: OUTPUT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    OUTPUT440=(CommonTree)match(input,OUTPUT,FOLLOW_OUTPUT_in_eid4824); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OUTPUT440_tree = (CommonTree)adaptor.dupNode(OUTPUT440);


                    adaptor.addChild(root_0, OUTPUT440_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((OUTPUT440!=null?OUTPUT440.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 57 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:603:7: STDERROR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STDERROR441=(CommonTree)match(input,STDERROR,FOLLOW_STDERROR_in_eid4837); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDERROR441_tree = (CommonTree)adaptor.dupNode(STDERROR441);


                    adaptor.addChild(root_0, STDERROR441_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((STDERROR441!=null?STDERROR441.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 58 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:604:7: STDIN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STDIN442=(CommonTree)match(input,STDIN,FOLLOW_STDIN_in_eid4848); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDIN442_tree = (CommonTree)adaptor.dupNode(STDIN442);


                    adaptor.addChild(root_0, STDIN442_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((STDIN442!=null?STDIN442.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 59 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:605:7: STDOUT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STDOUT443=(CommonTree)match(input,STDOUT,FOLLOW_STDOUT_in_eid4862); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDOUT443_tree = (CommonTree)adaptor.dupNode(STDOUT443);


                    adaptor.addChild(root_0, STDOUT443_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((STDOUT443!=null?STDOUT443.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 60 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:606:7: LIMIT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LIMIT444=(CommonTree)match(input,LIMIT,FOLLOW_LIMIT_in_eid4875); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LIMIT444_tree = (CommonTree)adaptor.dupNode(LIMIT444);


                    adaptor.addChild(root_0, LIMIT444_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((LIMIT444!=null?LIMIT444.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 61 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:607:7: SAMPLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    SAMPLE445=(CommonTree)match(input,SAMPLE,FOLLOW_SAMPLE_in_eid4889); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SAMPLE445_tree = (CommonTree)adaptor.dupNode(SAMPLE445);


                    adaptor.addChild(root_0, SAMPLE445_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((SAMPLE445!=null?SAMPLE445.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 62 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:608:7: LEFT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LEFT446=(CommonTree)match(input,LEFT,FOLLOW_LEFT_in_eid4902); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LEFT446_tree = (CommonTree)adaptor.dupNode(LEFT446);


                    adaptor.addChild(root_0, LEFT446_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((LEFT446!=null?LEFT446.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 63 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:609:7: RIGHT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    RIGHT447=(CommonTree)match(input,RIGHT,FOLLOW_RIGHT_in_eid4917); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RIGHT447_tree = (CommonTree)adaptor.dupNode(RIGHT447);


                    adaptor.addChild(root_0, RIGHT447_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((RIGHT447!=null?RIGHT447.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 64 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:610:7: FULL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FULL448=(CommonTree)match(input,FULL,FOLLOW_FULL_in_eid4931); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FULL448_tree = (CommonTree)adaptor.dupNode(FULL448);


                    adaptor.addChild(root_0, FULL448_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((FULL448!=null?FULL448.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 65 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:611:7: IDENTIFIER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER449=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_eid4946); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER449_tree = (CommonTree)adaptor.dupNode(IDENTIFIER449);


                    adaptor.addChild(root_0, IDENTIFIER449_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((IDENTIFIER449!=null?IDENTIFIER449.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 66 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:612:7: TOBAG
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TOBAG450=(CommonTree)match(input,TOBAG,FOLLOW_TOBAG_in_eid4959); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TOBAG450_tree = (CommonTree)adaptor.dupNode(TOBAG450);


                    adaptor.addChild(root_0, TOBAG450_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append("TOBAG"); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 67 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:613:7: TOMAP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TOMAP451=(CommonTree)match(input,TOMAP,FOLLOW_TOMAP_in_eid4972); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TOMAP451_tree = (CommonTree)adaptor.dupNode(TOMAP451);


                    adaptor.addChild(root_0, TOMAP451_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append("TOMAP"); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 68 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:614:7: TOTUPLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TOTUPLE452=(CommonTree)match(input,TOTUPLE,FOLLOW_TOTUPLE_in_eid4985); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TOTUPLE452_tree = (CommonTree)adaptor.dupNode(TOTUPLE452);


                    adaptor.addChild(root_0, TOTUPLE452_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append("TOTUPLE"); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "eid"


    public static class rel_op_return extends TreeRuleReturnScope {
        public String result;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_op"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:618:1: rel_op returns [String result] : ( rel_op_eq | rel_op_ne | rel_op_gt | rel_op_gte | rel_op_lt | rel_op_lte | STR_OP_MATCHES );
    public final AstPrinter.rel_op_return rel_op() throws RecognitionException {
        AstPrinter.rel_op_return retval = new AstPrinter.rel_op_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STR_OP_MATCHES459=null;
        AstPrinter.rel_op_eq_return rel_op_eq453 =null;

        AstPrinter.rel_op_ne_return rel_op_ne454 =null;

        AstPrinter.rel_op_gt_return rel_op_gt455 =null;

        AstPrinter.rel_op_gte_return rel_op_gte456 =null;

        AstPrinter.rel_op_lt_return rel_op_lt457 =null;

        AstPrinter.rel_op_lte_return rel_op_lte458 =null;


        CommonTree STR_OP_MATCHES459_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:619:5: ( rel_op_eq | rel_op_ne | rel_op_gt | rel_op_gte | rel_op_lt | rel_op_lte | STR_OP_MATCHES )
            int alt113=7;
            switch ( input.LA(1) ) {
            case NUM_OP_EQ:
            case STR_OP_EQ:
                {
                alt113=1;
                }
                break;
            case NUM_OP_NE:
            case STR_OP_NE:
                {
                alt113=2;
                }
                break;
            case NUM_OP_GT:
            case STR_OP_GT:
                {
                alt113=3;
                }
                break;
            case NUM_OP_GTE:
            case STR_OP_GTE:
                {
                alt113=4;
                }
                break;
            case NUM_OP_LT:
            case STR_OP_LT:
                {
                alt113=5;
                }
                break;
            case NUM_OP_LTE:
            case STR_OP_LTE:
                {
                alt113=6;
                }
                break;
            case STR_OP_MATCHES:
                {
                alt113=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 113, 0, input);

                throw nvae;

            }

            switch (alt113) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:619:7: rel_op_eq
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_eq_in_rel_op5007);
                    rel_op_eq453=rel_op_eq();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_eq453.getTree());


                    if ( state.backtracking==0 ) { retval.result = (rel_op_eq453!=null?rel_op_eq453.result:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:620:7: rel_op_ne
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_ne_in_rel_op5021);
                    rel_op_ne454=rel_op_ne();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_ne454.getTree());


                    if ( state.backtracking==0 ) { retval.result = (rel_op_ne454!=null?rel_op_ne454.result:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:621:7: rel_op_gt
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_gt_in_rel_op5035);
                    rel_op_gt455=rel_op_gt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_gt455.getTree());


                    if ( state.backtracking==0 ) { retval.result = (rel_op_gt455!=null?rel_op_gt455.result:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:622:7: rel_op_gte
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_gte_in_rel_op5049);
                    rel_op_gte456=rel_op_gte();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_gte456.getTree());


                    if ( state.backtracking==0 ) { retval.result = (rel_op_gte456!=null?rel_op_gte456.result:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:623:7: rel_op_lt
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_lt_in_rel_op5062);
                    rel_op_lt457=rel_op_lt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_lt457.getTree());


                    if ( state.backtracking==0 ) { retval.result = (rel_op_lt457!=null?rel_op_lt457.result:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:624:7: rel_op_lte
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_lte_in_rel_op5076);
                    rel_op_lte458=rel_op_lte();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_lte458.getTree());


                    if ( state.backtracking==0 ) { retval.result = (rel_op_lte458!=null?rel_op_lte458.result:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:625:7: STR_OP_MATCHES
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_MATCHES459=(CommonTree)match(input,STR_OP_MATCHES,FOLLOW_STR_OP_MATCHES_in_rel_op5089); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_MATCHES459_tree = (CommonTree)adaptor.dupNode(STR_OP_MATCHES459);


                    adaptor.addChild(root_0, STR_OP_MATCHES459_tree);
                    }


                    if ( state.backtracking==0 ) { retval.result = (STR_OP_MATCHES459!=null?STR_OP_MATCHES459.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rel_op"


    public static class rel_op_eq_return extends TreeRuleReturnScope {
        public String result;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_op_eq"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:628:1: rel_op_eq returns [String result] : ( STR_OP_EQ | NUM_OP_EQ );
    public final AstPrinter.rel_op_eq_return rel_op_eq() throws RecognitionException {
        AstPrinter.rel_op_eq_return retval = new AstPrinter.rel_op_eq_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STR_OP_EQ460=null;
        CommonTree NUM_OP_EQ461=null;

        CommonTree STR_OP_EQ460_tree=null;
        CommonTree NUM_OP_EQ461_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:629:5: ( STR_OP_EQ | NUM_OP_EQ )
            int alt114=2;
            int LA114_0 = input.LA(1);

            if ( (LA114_0==STR_OP_EQ) ) {
                alt114=1;
            }
            else if ( (LA114_0==NUM_OP_EQ) ) {
                alt114=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 114, 0, input);

                throw nvae;

            }
            switch (alt114) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:629:7: STR_OP_EQ
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_EQ460=(CommonTree)match(input,STR_OP_EQ,FOLLOW_STR_OP_EQ_in_rel_op_eq5108); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_EQ460_tree = (CommonTree)adaptor.dupNode(STR_OP_EQ460);


                    adaptor.addChild(root_0, STR_OP_EQ460_tree);
                    }


                    if ( state.backtracking==0 ) { retval.result = (STR_OP_EQ460!=null?STR_OP_EQ460.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:630:7: NUM_OP_EQ
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    NUM_OP_EQ461=(CommonTree)match(input,NUM_OP_EQ,FOLLOW_NUM_OP_EQ_in_rel_op_eq5118); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NUM_OP_EQ461_tree = (CommonTree)adaptor.dupNode(NUM_OP_EQ461);


                    adaptor.addChild(root_0, NUM_OP_EQ461_tree);
                    }


                    if ( state.backtracking==0 ) { retval.result = (NUM_OP_EQ461!=null?NUM_OP_EQ461.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rel_op_eq"


    public static class rel_op_ne_return extends TreeRuleReturnScope {
        public String result;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_op_ne"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:633:1: rel_op_ne returns [String result] : ( STR_OP_NE | NUM_OP_NE );
    public final AstPrinter.rel_op_ne_return rel_op_ne() throws RecognitionException {
        AstPrinter.rel_op_ne_return retval = new AstPrinter.rel_op_ne_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STR_OP_NE462=null;
        CommonTree NUM_OP_NE463=null;

        CommonTree STR_OP_NE462_tree=null;
        CommonTree NUM_OP_NE463_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:634:5: ( STR_OP_NE | NUM_OP_NE )
            int alt115=2;
            int LA115_0 = input.LA(1);

            if ( (LA115_0==STR_OP_NE) ) {
                alt115=1;
            }
            else if ( (LA115_0==NUM_OP_NE) ) {
                alt115=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 115, 0, input);

                throw nvae;

            }
            switch (alt115) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:634:7: STR_OP_NE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_NE462=(CommonTree)match(input,STR_OP_NE,FOLLOW_STR_OP_NE_in_rel_op_ne5136); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_NE462_tree = (CommonTree)adaptor.dupNode(STR_OP_NE462);


                    adaptor.addChild(root_0, STR_OP_NE462_tree);
                    }


                    if ( state.backtracking==0 ) { retval.result = (STR_OP_NE462!=null?STR_OP_NE462.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:635:7: NUM_OP_NE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    NUM_OP_NE463=(CommonTree)match(input,NUM_OP_NE,FOLLOW_NUM_OP_NE_in_rel_op_ne5146); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NUM_OP_NE463_tree = (CommonTree)adaptor.dupNode(NUM_OP_NE463);


                    adaptor.addChild(root_0, NUM_OP_NE463_tree);
                    }


                    if ( state.backtracking==0 ) { retval.result = (NUM_OP_NE463!=null?NUM_OP_NE463.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rel_op_ne"


    public static class rel_op_gt_return extends TreeRuleReturnScope {
        public String result;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_op_gt"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:638:1: rel_op_gt returns [String result] : ( STR_OP_GT | NUM_OP_GT );
    public final AstPrinter.rel_op_gt_return rel_op_gt() throws RecognitionException {
        AstPrinter.rel_op_gt_return retval = new AstPrinter.rel_op_gt_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STR_OP_GT464=null;
        CommonTree NUM_OP_GT465=null;

        CommonTree STR_OP_GT464_tree=null;
        CommonTree NUM_OP_GT465_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:639:5: ( STR_OP_GT | NUM_OP_GT )
            int alt116=2;
            int LA116_0 = input.LA(1);

            if ( (LA116_0==STR_OP_GT) ) {
                alt116=1;
            }
            else if ( (LA116_0==NUM_OP_GT) ) {
                alt116=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 116, 0, input);

                throw nvae;

            }
            switch (alt116) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:639:7: STR_OP_GT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_GT464=(CommonTree)match(input,STR_OP_GT,FOLLOW_STR_OP_GT_in_rel_op_gt5164); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_GT464_tree = (CommonTree)adaptor.dupNode(STR_OP_GT464);


                    adaptor.addChild(root_0, STR_OP_GT464_tree);
                    }


                    if ( state.backtracking==0 ) { retval.result = (STR_OP_GT464!=null?STR_OP_GT464.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:640:7: NUM_OP_GT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    NUM_OP_GT465=(CommonTree)match(input,NUM_OP_GT,FOLLOW_NUM_OP_GT_in_rel_op_gt5174); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NUM_OP_GT465_tree = (CommonTree)adaptor.dupNode(NUM_OP_GT465);


                    adaptor.addChild(root_0, NUM_OP_GT465_tree);
                    }


                    if ( state.backtracking==0 ) { retval.result = (NUM_OP_GT465!=null?NUM_OP_GT465.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rel_op_gt"


    public static class rel_op_gte_return extends TreeRuleReturnScope {
        public String result;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_op_gte"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:643:1: rel_op_gte returns [String result] : ( STR_OP_GTE | NUM_OP_GTE );
    public final AstPrinter.rel_op_gte_return rel_op_gte() throws RecognitionException {
        AstPrinter.rel_op_gte_return retval = new AstPrinter.rel_op_gte_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STR_OP_GTE466=null;
        CommonTree NUM_OP_GTE467=null;

        CommonTree STR_OP_GTE466_tree=null;
        CommonTree NUM_OP_GTE467_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:644:5: ( STR_OP_GTE | NUM_OP_GTE )
            int alt117=2;
            int LA117_0 = input.LA(1);

            if ( (LA117_0==STR_OP_GTE) ) {
                alt117=1;
            }
            else if ( (LA117_0==NUM_OP_GTE) ) {
                alt117=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 117, 0, input);

                throw nvae;

            }
            switch (alt117) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:644:7: STR_OP_GTE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_GTE466=(CommonTree)match(input,STR_OP_GTE,FOLLOW_STR_OP_GTE_in_rel_op_gte5192); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_GTE466_tree = (CommonTree)adaptor.dupNode(STR_OP_GTE466);


                    adaptor.addChild(root_0, STR_OP_GTE466_tree);
                    }


                    if ( state.backtracking==0 ) { retval.result = (STR_OP_GTE466!=null?STR_OP_GTE466.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:645:7: NUM_OP_GTE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    NUM_OP_GTE467=(CommonTree)match(input,NUM_OP_GTE,FOLLOW_NUM_OP_GTE_in_rel_op_gte5202); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NUM_OP_GTE467_tree = (CommonTree)adaptor.dupNode(NUM_OP_GTE467);


                    adaptor.addChild(root_0, NUM_OP_GTE467_tree);
                    }


                    if ( state.backtracking==0 ) { retval.result = (NUM_OP_GTE467!=null?NUM_OP_GTE467.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rel_op_gte"


    public static class rel_op_lt_return extends TreeRuleReturnScope {
        public String result;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_op_lt"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:648:1: rel_op_lt returns [String result] : ( STR_OP_LT | NUM_OP_LT );
    public final AstPrinter.rel_op_lt_return rel_op_lt() throws RecognitionException {
        AstPrinter.rel_op_lt_return retval = new AstPrinter.rel_op_lt_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STR_OP_LT468=null;
        CommonTree NUM_OP_LT469=null;

        CommonTree STR_OP_LT468_tree=null;
        CommonTree NUM_OP_LT469_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:649:5: ( STR_OP_LT | NUM_OP_LT )
            int alt118=2;
            int LA118_0 = input.LA(1);

            if ( (LA118_0==STR_OP_LT) ) {
                alt118=1;
            }
            else if ( (LA118_0==NUM_OP_LT) ) {
                alt118=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 118, 0, input);

                throw nvae;

            }
            switch (alt118) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:649:7: STR_OP_LT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_LT468=(CommonTree)match(input,STR_OP_LT,FOLLOW_STR_OP_LT_in_rel_op_lt5220); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_LT468_tree = (CommonTree)adaptor.dupNode(STR_OP_LT468);


                    adaptor.addChild(root_0, STR_OP_LT468_tree);
                    }


                    if ( state.backtracking==0 ) { retval.result = (STR_OP_LT468!=null?STR_OP_LT468.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:650:7: NUM_OP_LT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    NUM_OP_LT469=(CommonTree)match(input,NUM_OP_LT,FOLLOW_NUM_OP_LT_in_rel_op_lt5230); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NUM_OP_LT469_tree = (CommonTree)adaptor.dupNode(NUM_OP_LT469);


                    adaptor.addChild(root_0, NUM_OP_LT469_tree);
                    }


                    if ( state.backtracking==0 ) { retval.result = (NUM_OP_LT469!=null?NUM_OP_LT469.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rel_op_lt"


    public static class rel_op_lte_return extends TreeRuleReturnScope {
        public String result;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_op_lte"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:653:1: rel_op_lte returns [String result] : ( STR_OP_LTE | NUM_OP_LTE );
    public final AstPrinter.rel_op_lte_return rel_op_lte() throws RecognitionException {
        AstPrinter.rel_op_lte_return retval = new AstPrinter.rel_op_lte_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STR_OP_LTE470=null;
        CommonTree NUM_OP_LTE471=null;

        CommonTree STR_OP_LTE470_tree=null;
        CommonTree NUM_OP_LTE471_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:654:5: ( STR_OP_LTE | NUM_OP_LTE )
            int alt119=2;
            int LA119_0 = input.LA(1);

            if ( (LA119_0==STR_OP_LTE) ) {
                alt119=1;
            }
            else if ( (LA119_0==NUM_OP_LTE) ) {
                alt119=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 119, 0, input);

                throw nvae;

            }
            switch (alt119) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:654:7: STR_OP_LTE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_LTE470=(CommonTree)match(input,STR_OP_LTE,FOLLOW_STR_OP_LTE_in_rel_op_lte5248); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_LTE470_tree = (CommonTree)adaptor.dupNode(STR_OP_LTE470);


                    adaptor.addChild(root_0, STR_OP_LTE470_tree);
                    }


                    if ( state.backtracking==0 ) { retval.result = (STR_OP_LTE470!=null?STR_OP_LTE470.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:655:7: NUM_OP_LTE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    NUM_OP_LTE471=(CommonTree)match(input,NUM_OP_LTE,FOLLOW_NUM_OP_LTE_in_rel_op_lte5258); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NUM_OP_LTE471_tree = (CommonTree)adaptor.dupNode(NUM_OP_LTE471);


                    adaptor.addChild(root_0, NUM_OP_LTE471_tree);
                    }


                    if ( state.backtracking==0 ) { retval.result = (NUM_OP_LTE471!=null?NUM_OP_LTE471.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rel_op_lte"


    public static class rel_str_op_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_str_op"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:658:1: rel_str_op : ( STR_OP_EQ | STR_OP_NE | STR_OP_GT | STR_OP_LT | STR_OP_GTE | STR_OP_LTE | STR_OP_MATCHES );
    public final AstPrinter.rel_str_op_return rel_str_op() throws RecognitionException {
        AstPrinter.rel_str_op_return retval = new AstPrinter.rel_str_op_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STR_OP_EQ472=null;
        CommonTree STR_OP_NE473=null;
        CommonTree STR_OP_GT474=null;
        CommonTree STR_OP_LT475=null;
        CommonTree STR_OP_GTE476=null;
        CommonTree STR_OP_LTE477=null;
        CommonTree STR_OP_MATCHES478=null;

        CommonTree STR_OP_EQ472_tree=null;
        CommonTree STR_OP_NE473_tree=null;
        CommonTree STR_OP_GT474_tree=null;
        CommonTree STR_OP_LT475_tree=null;
        CommonTree STR_OP_GTE476_tree=null;
        CommonTree STR_OP_LTE477_tree=null;
        CommonTree STR_OP_MATCHES478_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:659:5: ( STR_OP_EQ | STR_OP_NE | STR_OP_GT | STR_OP_LT | STR_OP_GTE | STR_OP_LTE | STR_OP_MATCHES )
            int alt120=7;
            switch ( input.LA(1) ) {
            case STR_OP_EQ:
                {
                alt120=1;
                }
                break;
            case STR_OP_NE:
                {
                alt120=2;
                }
                break;
            case STR_OP_GT:
                {
                alt120=3;
                }
                break;
            case STR_OP_LT:
                {
                alt120=4;
                }
                break;
            case STR_OP_GTE:
                {
                alt120=5;
                }
                break;
            case STR_OP_LTE:
                {
                alt120=6;
                }
                break;
            case STR_OP_MATCHES:
                {
                alt120=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 120, 0, input);

                throw nvae;

            }

            switch (alt120) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:659:7: STR_OP_EQ
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_EQ472=(CommonTree)match(input,STR_OP_EQ,FOLLOW_STR_OP_EQ_in_rel_str_op5273); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_EQ472_tree = (CommonTree)adaptor.dupNode(STR_OP_EQ472);


                    adaptor.addChild(root_0, STR_OP_EQ472_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((STR_OP_EQ472!=null?STR_OP_EQ472.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:660:7: STR_OP_NE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_NE473=(CommonTree)match(input,STR_OP_NE,FOLLOW_STR_OP_NE_in_rel_str_op5283); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_NE473_tree = (CommonTree)adaptor.dupNode(STR_OP_NE473);


                    adaptor.addChild(root_0, STR_OP_NE473_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((STR_OP_NE473!=null?STR_OP_NE473.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:661:7: STR_OP_GT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_GT474=(CommonTree)match(input,STR_OP_GT,FOLLOW_STR_OP_GT_in_rel_str_op5293); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_GT474_tree = (CommonTree)adaptor.dupNode(STR_OP_GT474);


                    adaptor.addChild(root_0, STR_OP_GT474_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((STR_OP_GT474!=null?STR_OP_GT474.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:662:7: STR_OP_LT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_LT475=(CommonTree)match(input,STR_OP_LT,FOLLOW_STR_OP_LT_in_rel_str_op5303); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_LT475_tree = (CommonTree)adaptor.dupNode(STR_OP_LT475);


                    adaptor.addChild(root_0, STR_OP_LT475_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((STR_OP_LT475!=null?STR_OP_LT475.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:663:7: STR_OP_GTE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_GTE476=(CommonTree)match(input,STR_OP_GTE,FOLLOW_STR_OP_GTE_in_rel_str_op5313); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_GTE476_tree = (CommonTree)adaptor.dupNode(STR_OP_GTE476);


                    adaptor.addChild(root_0, STR_OP_GTE476_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((STR_OP_GTE476!=null?STR_OP_GTE476.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:664:7: STR_OP_LTE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_LTE477=(CommonTree)match(input,STR_OP_LTE,FOLLOW_STR_OP_LTE_in_rel_str_op5323); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_LTE477_tree = (CommonTree)adaptor.dupNode(STR_OP_LTE477);


                    adaptor.addChild(root_0, STR_OP_LTE477_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((STR_OP_LTE477!=null?STR_OP_LTE477.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:665:7: STR_OP_MATCHES
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_MATCHES478=(CommonTree)match(input,STR_OP_MATCHES,FOLLOW_STR_OP_MATCHES_in_rel_str_op5333); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_MATCHES478_tree = (CommonTree)adaptor.dupNode(STR_OP_MATCHES478);


                    adaptor.addChild(root_0, STR_OP_MATCHES478_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((STR_OP_MATCHES478!=null?STR_OP_MATCHES478.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rel_str_op"

    // $ANTLR start synpred42_AstPrinter
    public final void synpred42_AstPrinter_fragment() throws RecognitionException {
        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:164:7: ( field_def ( field_def )+ )
        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:164:7: field_def ( field_def )+
        {
        pushFollow(FOLLOW_field_def_in_synpred42_AstPrinter949);
        field_def();

        state._fsp--;
        if (state.failed) return ;

        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:164:37: ( field_def )+
        int cnt124=0;
        loop124:
        do {
            int alt124=2;
            int LA124_0 = input.LA(1);

            if ( (LA124_0==FIELD_DEF) ) {
                alt124=1;
            }


            switch (alt124) {
        	case 1 :
        	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:164:39: field_def
        	    {
        	    pushFollow(FOLLOW_field_def_in_synpred42_AstPrinter955);
        	    field_def();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    if ( cnt124 >= 1 ) break loop124;
        	    if (state.backtracking>0) {state.failed=true; return ;}
                    EarlyExitException eee =
                        new EarlyExitException(124, input);
                    throw eee;
            }
            cnt124++;
        } while (true);


        }

    }
    // $ANTLR end synpred42_AstPrinter

    // $ANTLR start synpred87_AstPrinter
    public final void synpred87_AstPrinter_fragment() throws RecognitionException {
        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:264:7: ( ^( MINUS expr expr ) )
        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:264:7: ^( MINUS expr expr )
        {
        match(input,MINUS,FOLLOW_MINUS_in_synpred87_AstPrinter1804); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        pushFollow(FOLLOW_expr_in_synpred87_AstPrinter1806);
        expr();

        state._fsp--;
        if (state.failed) return ;

        pushFollow(FOLLOW_expr_in_synpred87_AstPrinter1810);
        expr();

        state._fsp--;
        if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;


        }

    }
    // $ANTLR end synpred87_AstPrinter

    // $ANTLR start synpred91_AstPrinter
    public final void synpred91_AstPrinter_fragment() throws RecognitionException {
        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:268:7: ( ^( CAST_EXPR type expr ) )
        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:268:7: ^( CAST_EXPR type expr )
        {
        match(input,CAST_EXPR,FOLLOW_CAST_EXPR_in_synpred91_AstPrinter1876); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        pushFollow(FOLLOW_type_in_synpred91_AstPrinter1880);
        type();

        state._fsp--;
        if (state.failed) return ;

        pushFollow(FOLLOW_expr_in_synpred91_AstPrinter1884);
        expr();

        state._fsp--;
        if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;


        }

    }
    // $ANTLR end synpred91_AstPrinter

    // $ANTLR start synpred92_AstPrinter
    public final void synpred92_AstPrinter_fragment() throws RecognitionException {
        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:269:7: ( const_expr )
        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:269:7: const_expr
        {
        pushFollow(FOLLOW_const_expr_in_synpred92_AstPrinter1894);
        const_expr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred92_AstPrinter

    // $ANTLR start synpred95_AstPrinter
    public final void synpred95_AstPrinter_fragment() throws RecognitionException {
        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:272:7: ( ^( CAST_EXPR type_cast expr ) )
        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:272:7: ^( CAST_EXPR type_cast expr )
        {
        match(input,CAST_EXPR,FOLLOW_CAST_EXPR_in_synpred95_AstPrinter1928); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        pushFollow(FOLLOW_type_cast_in_synpred95_AstPrinter1932);
        type_cast();

        state._fsp--;
        if (state.failed) return ;

        pushFollow(FOLLOW_expr_in_synpred95_AstPrinter1936);
        expr();

        state._fsp--;
        if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;


        }

    }
    // $ANTLR end synpred95_AstPrinter

    // $ANTLR start synpred100_AstPrinter
    public final void synpred100_AstPrinter_fragment() throws RecognitionException {
        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:281:7: ( ^( TUPLE_TYPE_CAST type_cast ( type_cast )* ) )
        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:281:7: ^( TUPLE_TYPE_CAST type_cast ( type_cast )* )
        {
        match(input,TUPLE_TYPE_CAST,FOLLOW_TUPLE_TYPE_CAST_in_synpred100_AstPrinter1998); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        pushFollow(FOLLOW_type_cast_in_synpred100_AstPrinter2002);
        type_cast();

        state._fsp--;
        if (state.failed) return ;

        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:281:61: ( type_cast )*
        loop128:
        do {
            int alt128=2;
            int LA128_0 = input.LA(1);

            if ( (LA128_0==BOOLEAN||LA128_0==BYTEARRAY||LA128_0==CHARARRAY||LA128_0==DOUBLE||LA128_0==FLOAT||LA128_0==INT||LA128_0==LONG||LA128_0==BAG_TYPE_CAST||LA128_0==MAP_TYPE||LA128_0==TUPLE_TYPE_CAST) ) {
                alt128=1;
            }


            switch (alt128) {
        	case 1 :
        	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:281:63: type_cast
        	    {
        	    pushFollow(FOLLOW_type_cast_in_synpred100_AstPrinter2008);
        	    type_cast();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop128;
            }
        } while (true);


        match(input, Token.UP, null); if (state.failed) return ;


        }

    }
    // $ANTLR end synpred100_AstPrinter

    // $ANTLR start synpred113_AstPrinter
    public final void synpred113_AstPrinter_fragment() throws RecognitionException {
        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:327:11: ( INTEGER )
        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:327:11: INTEGER
        {
        match(input,INTEGER,FOLLOW_INTEGER_in_synpred113_AstPrinter2326); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred113_AstPrinter

    // $ANTLR start synpred114_AstPrinter
    public final void synpred114_AstPrinter_fragment() throws RecognitionException {
        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:327:63: ( LONGINTEGER )
        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:327:63: LONGINTEGER
        {
        match(input,LONGINTEGER,FOLLOW_LONGINTEGER_in_synpred114_AstPrinter2332); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred114_AstPrinter

    // $ANTLR start synpred115_AstPrinter
    public final void synpred115_AstPrinter_fragment() throws RecognitionException {
        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:331:64: ( DOUBLENUMBER )
        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:331:64: DOUBLENUMBER
        {
        match(input,DOUBLENUMBER,FOLLOW_DOUBLENUMBER_in_synpred115_AstPrinter2366); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred115_AstPrinter

    // $ANTLR start synpred132_AstPrinter
    public final void synpred132_AstPrinter_fragment() throws RecognitionException {
        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:374:7: ( join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item )
        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:374:7: join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item
        {
        pushFollow(FOLLOW_join_item_in_synpred132_AstPrinter2685);
        join_item();

        state._fsp--;
        if (state.failed) return ;

        if ( input.LA(1)==FULL||input.LA(1)==LEFT||input.LA(1)==RIGHT ) {
            input.consume();
            state.errorRecovery=false;
            state.failed=false;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            MismatchedSetException mse = new MismatchedSetException(null,input);
            throw mse;
        }


        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:377:16: ( OUTER )?
        int alt130=2;
        int LA130_0 = input.LA(1);

        if ( (LA130_0==OUTER) ) {
            alt130=1;
        }
        switch (alt130) {
            case 1 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:377:17: OUTER
                {
                match(input,OUTER,FOLLOW_OUTER_in_synpred132_AstPrinter2747); if (state.failed) return ;

                }
                break;

        }


        pushFollow(FOLLOW_join_item_in_synpred132_AstPrinter2756);
        join_item();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred132_AstPrinter

    // $ANTLR start synpred150_AstPrinter
    public final void synpred150_AstPrinter_fragment() throws RecognitionException {
        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:448:75: ( INTEGER )
        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstPrinter.g:448:75: INTEGER
        {
        match(input,INTEGER,FOLLOW_INTEGER_in_synpred150_AstPrinter3317); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred150_AstPrinter

    // Delegated rules

    public final boolean synpred87_AstPrinter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred87_AstPrinter_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred115_AstPrinter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred115_AstPrinter_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred113_AstPrinter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred113_AstPrinter_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred150_AstPrinter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred150_AstPrinter_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred95_AstPrinter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred95_AstPrinter_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred91_AstPrinter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred91_AstPrinter_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred132_AstPrinter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred132_AstPrinter_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred100_AstPrinter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred100_AstPrinter_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred92_AstPrinter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred92_AstPrinter_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred42_AstPrinter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred42_AstPrinter_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred114_AstPrinter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred114_AstPrinter_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA48 dfa48 = new DFA48(this);
    static final String DFA48_eotS =
        "\u009b\uffff";
    static final String DFA48_eofS =
        "\u009b\uffff";
    static final String DFA48_minS =
        "\1\u0083\1\2\1\4\112\3\2\4\2\uffff\112\3";
    static final String DFA48_maxS =
        "\1\u0083\1\2\1\u009f\112\u009d\2\u009f\2\uffff\112\u009d";
    static final String DFA48_acceptS =
        "\117\uffff\1\1\1\2\112\uffff";
    static final String DFA48_specialS =
        "\u009b\uffff}>";
    static final String[] DFA48_transitionS = {
            "\1\1",
            "\1\2",
            "\1\32\1\43\1\33\1\51\1\62\1\53\1\34\1\61\1\76\1\60\1\23\2\uffff"+
            "\1\25\1\uffff\1\14\1\52\1\uffff\1\22\3\uffff\1\57\4\uffff\1"+
            "\70\1\16\1\47\1\56\2\uffff\1\17\1\110\1\46\1\42\2\uffff\1\31"+
            "\1\12\1\36\1\77\1\54\1\uffff\1\30\1\65\1\24\1\106\4\uffff\1"+
            "\104\1\15\1\55\1\uffff\1\64\1\74\3\uffff\1\45\7\uffff\1\44\1"+
            "\21\1\uffff\1\37\1\100\1\40\1\41\6\uffff\1\13\1\107\3\uffff"+
            "\1\105\1\uffff\1\75\2\uffff\1\27\1\uffff\1\101\1\102\1\103\1"+
            "\73\1\71\1\3\1\5\1\7\1\6\1\10\1\11\1\4\1\72\1\67\1\63\1\26\1"+
            "\35\21\uffff\1\111\13\uffff\1\66\6\uffff\1\112\1\113\1\114\3"+
            "\uffff\1\50\1\20",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\150\1\161\1\151\1\167\1\u0080\1\171\1\152\1\177\1\u008c"+
            "\1\176\1\141\2\uffff\1\143\1\uffff\1\132\1\170\1\uffff\1\140"+
            "\3\uffff\1\175\4\uffff\1\u0086\1\134\1\165\1\174\2\uffff\1\135"+
            "\1\u0096\1\164\1\160\2\uffff\1\147\1\130\1\154\1\u008d\1\172"+
            "\1\uffff\1\146\1\u0083\1\142\1\u0094\4\uffff\1\u0092\1\133\1"+
            "\173\1\uffff\1\u0082\1\u008a\3\uffff\1\163\7\uffff\1\162\1\137"+
            "\1\uffff\1\155\1\u008e\1\156\1\157\6\uffff\1\131\1\u0095\3\uffff"+
            "\1\u0093\1\uffff\1\u008b\2\uffff\1\145\1\uffff\1\u008f\1\u0090"+
            "\1\u0091\1\u0089\1\u0087\1\121\1\123\1\125\1\124\1\126\1\127"+
            "\1\122\1\u0088\1\u0085\1\u0081\1\144\1\153\21\uffff\1\u0097"+
            "\13\uffff\1\u0084\6\uffff\1\u0098\1\u0099\1\u009a\3\uffff\1"+
            "\166\1\136",
            "\1\150\1\161\1\151\1\167\1\u0080\1\171\1\152\1\177\1\u008c"+
            "\1\176\1\141\2\uffff\1\143\1\uffff\1\132\1\170\1\uffff\1\140"+
            "\3\uffff\1\175\4\uffff\1\u0086\1\134\1\165\1\174\2\uffff\1\135"+
            "\1\u0096\1\164\1\160\2\uffff\1\147\1\130\1\154\1\u008d\1\172"+
            "\1\uffff\1\146\1\u0083\1\142\1\u0094\4\uffff\1\u0092\1\133\1"+
            "\173\1\uffff\1\u0082\1\u008a\3\uffff\1\163\7\uffff\1\162\1\137"+
            "\1\uffff\1\155\1\u008e\1\156\1\157\6\uffff\1\131\1\u0095\3\uffff"+
            "\1\u0093\1\uffff\1\u008b\2\uffff\1\145\1\uffff\1\u008f\1\u0090"+
            "\1\u0091\1\u0089\1\u0087\1\121\1\123\1\125\1\124\1\126\1\127"+
            "\1\122\1\u0088\1\u0085\1\u0081\1\144\1\153\21\uffff\1\u0097"+
            "\13\uffff\1\u0084\6\uffff\1\u0098\1\u0099\1\u009a\3\uffff\1"+
            "\166\1\136",
            "",
            "",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117",
            "\1\120\23\uffff\1\117\1\116\1\117\1\uffff\1\117\3\uffff\1\117"+
            "\4\uffff\1\117\3\uffff\1\117\7\uffff\1\117\13\uffff\1\117\2"+
            "\uffff\1\117\21\uffff\1\117\1\115\1\117\2\uffff\1\117\13\uffff"+
            "\1\117\15\uffff\1\117\10\uffff\2\117\1\uffff\3\117\4\uffff\1"+
            "\117\1\uffff\1\117\6\uffff\2\117\3\uffff\1\117\13\uffff\1\117"
    };

    static final short[] DFA48_eot = DFA.unpackEncodedString(DFA48_eotS);
    static final short[] DFA48_eof = DFA.unpackEncodedString(DFA48_eofS);
    static final char[] DFA48_min = DFA.unpackEncodedStringToUnsignedChars(DFA48_minS);
    static final char[] DFA48_max = DFA.unpackEncodedStringToUnsignedChars(DFA48_maxS);
    static final short[] DFA48_accept = DFA.unpackEncodedString(DFA48_acceptS);
    static final short[] DFA48_special = DFA.unpackEncodedString(DFA48_specialS);
    static final short[][] DFA48_transition;

    static {
        int numStates = DFA48_transitionS.length;
        DFA48_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA48_transition[i] = DFA.unpackEncodedString(DFA48_transitionS[i]);
        }
    }

    class DFA48 extends DFA {

        public DFA48(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 48;
            this.eot = DFA48_eot;
            this.eof = DFA48_eof;
            this.min = DFA48_min;
            this.max = DFA48_max;
            this.accept = DFA48_accept;
            this.special = DFA48_special;
            this.transition = DFA48_transition;
        }
        public String getDescription() {
            return "253:1: func_eval : ( ^( FUNC_EVAL func_name real_arg ( real_arg )* ) | ^( FUNC_EVAL func_name ) );";
        }
    }
 

    public static final BitSet FOLLOW_QUERY_in_query81 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_query83 = new BitSet(new long[]{0x0000000000000008L,0x0000000200000000L,0x0000000000900000L});
    public static final BitSet FOLLOW_general_statement_in_statement95 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_split_statement_in_statement109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_realias_statement_in_statement125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_split_clause_in_split_statement134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_realias_clause_in_realias_statement143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STATEMENT_in_general_statement160 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_general_statement164 = new BitSet(new long[]{0x46080121004A4000L,0x000400C210000800L});
    public static final BitSet FOLLOW_op_clause_in_general_statement180 = new BitSet(new long[]{0x0000000000000008L,0x0000000000008000L});
    public static final BitSet FOLLOW_parallel_clause_in_general_statement182 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_REALIAS_in_realias_clause197 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_realias_clause199 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_in_realias_clause201 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PARALLEL_in_parallel_clause218 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INTEGER_in_parallel_clause220 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IDENTIFIER_in_alias238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_define_clause_in_op_clause249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_load_clause_in_op_clause264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_group_clause_in_op_clause278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_store_clause_in_op_clause292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_filter_clause_in_op_clause306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_distinct_clause_in_op_clause320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_limit_clause_in_op_clause334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sample_clause_in_op_clause348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_order_clause_in_op_clause362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cross_clause_in_op_clause376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_join_clause_in_op_clause390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_union_clause_in_op_clause404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stream_clause_in_op_clause418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mr_clause_in_op_clause432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_split_clause_in_op_clause446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_foreach_clause_in_op_clause460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEFINE_in_define_clause476 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_define_clause478 = new BitSet(new long[]{0x0000000040000000L,0x0000000000000000L,0x0000000000000014L});
    public static final BitSet FOLLOW_cmd_in_define_clause493 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_func_clause_in_define_clause497 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXECCOMMAND_in_cmd517 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ship_clause_in_cmd531 = new BitSet(new long[]{0x0000400000001008L,0x0000000840004000L});
    public static final BitSet FOLLOW_cache_clause_in_cmd535 = new BitSet(new long[]{0x0000400000001008L,0x0000000840004000L});
    public static final BitSet FOLLOW_input_clause_in_cmd539 = new BitSet(new long[]{0x0000400000001008L,0x0000000840004000L});
    public static final BitSet FOLLOW_output_clause_in_cmd543 = new BitSet(new long[]{0x0000400000001008L,0x0000000840004000L});
    public static final BitSet FOLLOW_error_clause_in_cmd547 = new BitSet(new long[]{0x0000400000001008L,0x0000000840004000L});
    public static final BitSet FOLLOW_SHIP_in_ship_clause568 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_path_list_in_ship_clause572 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_path_list593 = new BitSet(new long[]{0x0000000000000002L,0x0000000000400000L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_path_list608 = new BitSet(new long[]{0x0000000000000002L,0x0000000000400000L});
    public static final BitSet FOLLOW_CACHE_in_cache_clause629 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_path_list_in_cache_clause633 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INPUT_in_input_clause653 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_stream_cmd_in_input_clause666 = new BitSet(new long[]{0x0000000000000008L,0x0000003000400000L});
    public static final BitSet FOLLOW_stream_cmd_in_input_clause672 = new BitSet(new long[]{0x0000000000000008L,0x0000003000400000L});
    public static final BitSet FOLLOW_STDIN_in_stream_cmd694 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_clause_in_stream_cmd698 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STDOUT_in_stream_cmd711 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_clause_in_stream_cmd715 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_stream_cmd728 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_clause_in_stream_cmd732 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OUTPUT_in_output_clause751 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_stream_cmd_in_output_clause765 = new BitSet(new long[]{0x0000000000000008L,0x0000003000400000L});
    public static final BitSet FOLLOW_stream_cmd_in_output_clause771 = new BitSet(new long[]{0x0000000000000008L,0x0000003000400000L});
    public static final BitSet FOLLOW_STDERROR_in_error_clause793 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_error_clause807 = new BitSet(new long[]{0x0001000000000008L});
    public static final BitSet FOLLOW_INTEGER_in_error_clause812 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LOAD_in_load_clause840 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_filename_in_load_clause844 = new BitSet(new long[]{0x0000000000000048L,0x0000000000000000L,0x0000000000000014L});
    public static final BitSet FOLLOW_func_clause_in_load_clause859 = new BitSet(new long[]{0x0000000000000048L});
    public static final BitSet FOLLOW_as_clause_in_load_clause863 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_filename880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AS_in_as_clause897 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_field_def_list_in_as_clause901 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FIELD_DEF_in_field_def918 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_field_def920 = new BitSet(new long[]{0x0800800404002A08L,0x0080000000000000L,0x0000000008000800L});
    public static final BitSet FOLLOW_type_in_field_def930 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_field_def_in_field_def_list949 = new BitSet(new long[]{0x0000000000000000L,0x8000000000000000L});
    public static final BitSet FOLLOW_field_def_in_field_def_list955 = new BitSet(new long[]{0x0000000000000002L,0x8000000000000000L});
    public static final BitSet FOLLOW_field_def_in_field_def_list968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_simple_type_in_type977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tuple_type_in_type981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bag_type_in_type985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_map_type_in_type989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOLEAN_in_simple_type1003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_simple_type1013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LONG_in_simple_type1023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_simple_type1033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLE_in_simple_type1043 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHARARRAY_in_simple_type1053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BYTEARRAY_in_simple_type1063 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TUPLE_TYPE_in_tuple_type1081 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_field_def_list_in_tuple_type1083 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BAG_TYPE_in_bag_type1102 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_bag_type1110 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_tuple_type_in_bag_type1113 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MAP_TYPE_in_map_type1132 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_in_map_type1136 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNC_REF_in_func_clause1157 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_func_clause1159 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNC_in_func_clause1171 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_func_clause1173 = new BitSet(new long[]{0x0000000000000008L,0x0000000000400000L});
    public static final BitSet FOLLOW_func_args_in_func_clause1177 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_eid_in_func_name1196 = new BitSet(new long[]{0x0000000001000002L,0x0000000000040000L});
    public static final BitSet FOLLOW_PERIOD_in_func_name1202 = new BitSet(new long[]{0x6E1EF9E7845A7FF0L,0x000FFFFA5181EC04L,0x00000000C7020020L});
    public static final BitSet FOLLOW_DOLLAR_in_func_name1208 = new BitSet(new long[]{0x6E1EF9E7845A7FF0L,0x000FFFFA5181EC04L,0x00000000C7020020L});
    public static final BitSet FOLLOW_eid_in_func_name1214 = new BitSet(new long[]{0x0000000001000002L,0x0000000000040000L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_func_args1233 = new BitSet(new long[]{0x0000000000000002L,0x0000000000400000L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_func_args1248 = new BitSet(new long[]{0x0000000000000002L,0x0000000000400000L});
    public static final BitSet FOLLOW_GROUP_in_group_clause1270 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_COGROUP_in_group_clause1276 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_group_item_in_group_clause1291 = new BitSet(new long[]{0x46080121004A4008L,0x000400C210410800L,0x0000000000000020L});
    public static final BitSet FOLLOW_group_item_in_group_clause1297 = new BitSet(new long[]{0x46080121004A4008L,0x000400C210410800L,0x0000000000000020L});
    public static final BitSet FOLLOW_group_type_in_group_clause1313 = new BitSet(new long[]{0x0000000000000008L,0x0000000000010000L});
    public static final BitSet FOLLOW_partition_clause_in_group_clause1325 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_group_type1341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_in_group_item1356 = new BitSet(new long[]{0x0000000000000410L,0x0040000000000000L});
    public static final BitSet FOLLOW_join_group_by_clause_in_group_item1360 = new BitSet(new long[]{0x0000200000000002L,0x0000000000002000L});
    public static final BitSet FOLLOW_ALL_in_group_item1377 = new BitSet(new long[]{0x0000200000000002L,0x0000000000002000L});
    public static final BitSet FOLLOW_ANY_in_group_item1383 = new BitSet(new long[]{0x0000200000000002L,0x0000000000002000L});
    public static final BitSet FOLLOW_INNER_in_group_item1404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OUTER_in_group_item1410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_alias_in_rel1429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_op_clause_in_rel1442 = new BitSet(new long[]{0x0000000000000002L,0x0000000000008000L});
    public static final BitSet FOLLOW_parallel_clause_in_rel1444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_flatten_clause_in_flatten_generated_item1465 = new BitSet(new long[]{0x0000000000000002L,0x8000000000000000L});
    public static final BitSet FOLLOW_col_range_in_flatten_generated_item1469 = new BitSet(new long[]{0x0000000000000002L,0x8000000000000000L});
    public static final BitSet FOLLOW_expr_in_flatten_generated_item1473 = new BitSet(new long[]{0x0000000000000002L,0x8000000000000000L});
    public static final BitSet FOLLOW_STAR_in_flatten_generated_item1477 = new BitSet(new long[]{0x0000000000000002L,0x8000000000000000L});
    public static final BitSet FOLLOW_field_def_list_in_flatten_generated_item1487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLATTEN_in_flatten_clause1505 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_flatten_clause1509 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STORE_in_store_clause1529 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_store_clause1533 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_filename_in_store_clause1537 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000000000014L});
    public static final BitSet FOLLOW_func_clause_in_store_clause1543 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FILTER_in_filter_clause1563 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_filter_clause1567 = new BitSet(new long[]{0x0000000000000020L,0x00007F00000005FCL,0x0000000000020008L});
    public static final BitSet FOLLOW_cond_in_filter_clause1571 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OR_in_cond1591 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_cond1595 = new BitSet(new long[]{0x0000000000000020L,0x00007F00000005FCL,0x0000000000020008L});
    public static final BitSet FOLLOW_cond_in_cond1599 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AND_in_cond1613 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_cond1617 = new BitSet(new long[]{0x0000000000000020L,0x00007F00000005FCL,0x0000000000020008L});
    public static final BitSet FOLLOW_cond_in_cond1621 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NOT_in_cond1635 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_cond1639 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NULL_in_cond1653 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond1655 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000004L});
    public static final BitSet FOLLOW_NOT_in_cond1660 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rel_op_in_cond1680 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond1682 = new BitSet(new long[]{0x900101108A800000L,0x56010004004A0000L,0x0000000020023028L});
    public static final BitSet FOLLOW_expr_in_cond1686 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_func_eval_in_cond1696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FUNC_EVAL_in_func_eval1711 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_func_eval1713 = new BitSet(new long[]{0x900101108A800000L,0x76010004004A0000L,0x0000000020023028L});
    public static final BitSet FOLLOW_real_arg_in_func_eval1717 = new BitSet(new long[]{0x900101108A800008L,0x76010004004A0000L,0x0000000020023028L});
    public static final BitSet FOLLOW_real_arg_in_func_eval1723 = new BitSet(new long[]{0x900101108A800008L,0x76010004004A0000L,0x0000000020023028L});
    public static final BitSet FOLLOW_FUNC_EVAL_in_func_eval1739 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_func_eval1741 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expr_in_real_arg1760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_real_arg1764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_col_range_in_real_arg1770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUS_in_expr1786 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1788 = new BitSet(new long[]{0x900101108A800000L,0x56010004004A0000L,0x0000000020023028L});
    public static final BitSet FOLLOW_expr_in_expr1792 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MINUS_in_expr1804 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1806 = new BitSet(new long[]{0x900101108A800000L,0x56010004004A0000L,0x0000000020023028L});
    public static final BitSet FOLLOW_expr_in_expr1810 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STAR_in_expr1822 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1824 = new BitSet(new long[]{0x900101108A800000L,0x56010004004A0000L,0x0000000020023028L});
    public static final BitSet FOLLOW_expr_in_expr1828 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DIV_in_expr1840 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1842 = new BitSet(new long[]{0x900101108A800000L,0x56010004004A0000L,0x0000000020023028L});
    public static final BitSet FOLLOW_expr_in_expr1846 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PERCENT_in_expr1858 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1860 = new BitSet(new long[]{0x900101108A800000L,0x56010004004A0000L,0x0000000020023028L});
    public static final BitSet FOLLOW_expr_in_expr1864 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CAST_EXPR_in_expr1876 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_in_expr1880 = new BitSet(new long[]{0x900101108A800000L,0x56010004004A0000L,0x0000000020023028L});
    public static final BitSet FOLLOW_expr_in_expr1884 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_const_expr_in_expr1894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_var_expr_in_expr1902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEG_in_expr1912 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1916 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CAST_EXPR_in_expr1928 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_cast_in_expr1932 = new BitSet(new long[]{0x900101108A800000L,0x56010004004A0000L,0x0000000020023028L});
    public static final BitSet FOLLOW_expr_in_expr1936 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXPR_IN_PAREN_in_expr1948 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1952 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_simple_type_in_type_cast1970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_map_type_in_type_cast1974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tuple_type_cast_in_type_cast1978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bag_type_cast_in_type_cast1982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TUPLE_TYPE_CAST_in_tuple_type_cast1998 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_cast_in_tuple_type_cast2002 = new BitSet(new long[]{0x0800800404002A08L,0x0100000000000000L,0x0000000010000800L});
    public static final BitSet FOLLOW_type_cast_in_tuple_type_cast2008 = new BitSet(new long[]{0x0800800404002A08L,0x0100000000000000L,0x0000000010000800L});
    public static final BitSet FOLLOW_TUPLE_TYPE_CAST_in_tuple_type_cast2024 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_cast_in_tuple_type_cast2028 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BAG_TYPE_CAST_in_bag_type_cast2049 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_tuple_type_cast_in_bag_type_cast2053 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_projectable_expr_in_var_expr2072 = new BitSet(new long[]{0x0000000000000002L,0x0000000000140000L});
    public static final BitSet FOLLOW_dot_proj_in_var_expr2076 = new BitSet(new long[]{0x0000000000000002L,0x0000000000140000L});
    public static final BitSet FOLLOW_pound_proj_in_var_expr2080 = new BitSet(new long[]{0x0000000000000002L,0x0000000000140000L});
    public static final BitSet FOLLOW_func_eval_in_projectable_expr2096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_col_ref_in_projectable_expr2100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bin_expr_in_projectable_expr2104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PERIOD_in_dot_proj2120 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_col_alias_or_index_in_dot_proj2124 = new BitSet(new long[]{0x0000010002000008L,0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_col_alias_or_index_in_dot_proj2130 = new BitSet(new long[]{0x0000010002000008L,0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_col_alias_in_col_alias_or_index2146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_col_index_in_col_alias_or_index2150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GROUP_in_col_alias2164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_col_alias2174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOLLARVAR_in_col_index2190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COL_RANGE_in_col_range2203 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_col_ref_in_col_range2205 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_DOUBLE_PERIOD_in_col_range2210 = new BitSet(new long[]{0x0000010002000008L,0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_col_ref_in_col_range2212 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_POUND_in_pound_proj2230 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_pound_proj2244 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NULL_in_pound_proj2250 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BIN_EXPR_in_bin_expr2272 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_bin_expr2276 = new BitSet(new long[]{0x900101108A800000L,0x56010004004A0000L,0x0000000020023028L});
    public static final BitSet FOLLOW_expr_in_bin_expr2280 = new BitSet(new long[]{0x900101108A800000L,0x56010004004A0000L,0x0000000020023028L});
    public static final BitSet FOLLOW_expr_in_bin_expr2284 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LIMIT_in_limit_clause2309 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_limit_clause2313 = new BitSet(new long[]{0x900101108A800000L,0x56010004004A0000L,0x0000000020023028L});
    public static final BitSet FOLLOW_INTEGER_in_limit_clause2326 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LONGINTEGER_in_limit_clause2332 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expr_in_limit_clause2338 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SAMPLE_in_sample_clause2358 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_sample_clause2362 = new BitSet(new long[]{0x900101108A800000L,0x56010004004A0000L,0x0000000020023028L});
    public static final BitSet FOLLOW_DOUBLENUMBER_in_sample_clause2366 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expr_in_sample_clause2372 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ORDER_in_order_clause2396 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_order_clause2400 = new BitSet(new long[]{0x0000010002000000L,0x2000000400000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_order_by_clause_in_order_clause2412 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000000000014L});
    public static final BitSet FOLLOW_func_clause_in_order_clause2426 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STAR_in_order_by_clause2445 = new BitSet(new long[]{0x0000000000100082L});
    public static final BitSet FOLLOW_ASC_in_order_by_clause2451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESC_in_order_by_clause2457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_order_col_in_order_by_clause2470 = new BitSet(new long[]{0x0000010002000002L,0x2000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_order_col_in_order_by_clause2476 = new BitSet(new long[]{0x0000010002000002L,0x2000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_col_range_in_order_col2493 = new BitSet(new long[]{0x0000000000100082L});
    public static final BitSet FOLLOW_col_ref_in_order_col2497 = new BitSet(new long[]{0x0000000000100082L});
    public static final BitSet FOLLOW_ASC_in_order_col2502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESC_in_order_col2508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DISTINCT_in_distinct_clause2533 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_distinct_clause2537 = new BitSet(new long[]{0x0000000000000008L,0x0000000000010000L});
    public static final BitSet FOLLOW_partition_clause_in_distinct_clause2539 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PARTITION_in_partition_clause2558 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_partition_clause2562 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CROSS_in_cross_clause2584 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_list_in_cross_clause2588 = new BitSet(new long[]{0x0000000000000008L,0x0000000000010000L});
    public static final BitSet FOLLOW_partition_clause_in_cross_clause2590 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rel_in_rel_list2611 = new BitSet(new long[]{0x46080121004A4002L,0x000400C210000800L,0x0000000000000020L});
    public static final BitSet FOLLOW_rel_in_rel_list2617 = new BitSet(new long[]{0x46080121004A4002L,0x000400C210000800L,0x0000000000000020L});
    public static final BitSet FOLLOW_JOIN_in_join_clause2634 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_join_sub_clause_in_join_clause2638 = new BitSet(new long[]{0x0000000000000008L,0x0000000000410000L});
    public static final BitSet FOLLOW_join_type_in_join_clause2644 = new BitSet(new long[]{0x0000000000000008L,0x0000000000010000L});
    public static final BitSet FOLLOW_partition_clause_in_join_clause2656 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_join_type2670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_join_item_in_join_sub_clause2685 = new BitSet(new long[]{0x0010004000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_LEFT_in_join_sub_clause2689 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L,0x0000000000000040L});
    public static final BitSet FOLLOW_RIGHT_in_join_sub_clause2708 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L,0x0000000000000040L});
    public static final BitSet FOLLOW_FULL_in_join_sub_clause2727 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L,0x0000000000000040L});
    public static final BitSet FOLLOW_OUTER_in_join_sub_clause2747 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_join_item_in_join_sub_clause2756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_join_item_in_join_sub_clause2764 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_join_item_in_join_sub_clause2770 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_JOIN_ITEM_in_join_item2788 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_join_item2790 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_join_group_by_clause_in_join_item2792 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BY_in_join_group_by_clause2809 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_join_group_by_expr_in_join_group_by_clause2818 = new BitSet(new long[]{0x900101108A800008L,0x76010004004A0000L,0x0000000020023028L});
    public static final BitSet FOLLOW_join_group_by_expr_in_join_group_by_clause2824 = new BitSet(new long[]{0x900101108A800008L,0x76010004004A0000L,0x0000000020023028L});
    public static final BitSet FOLLOW_col_range_in_join_group_by_expr2845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_join_group_by_expr2849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_join_group_by_expr2853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNION_in_union_clause2871 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ONSCHEMA_in_union_clause2876 = new BitSet(new long[]{0x46080121004A4000L,0x000400C210000800L,0x0000000000000020L});
    public static final BitSet FOLLOW_rel_list_in_union_clause2883 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_in_foreach_clause2905 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_foreach_clause2909 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000003L});
    public static final BitSet FOLLOW_foreach_plan_in_foreach_clause2911 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_PLAN_SIMPLE_in_foreach_plan2933 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_generate_clause_in_foreach_plan2935 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_PLAN_COMPLEX_in_foreach_plan2947 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_blk_in_foreach_plan2949 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_nested_command_in_nested_blk2967 = new BitSet(new long[]{0x0000008000000000L,0x0000000000000000L,0x000000000000C000L});
    public static final BitSet FOLLOW_generate_clause_in_nested_blk2974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GENERATE_in_generate_clause2992 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_flatten_generated_item_in_generate_clause3004 = new BitSet(new long[]{0x900101128A800008L,0x76010004004A0000L,0x0000000020023028L});
    public static final BitSet FOLLOW_flatten_generated_item_in_generate_clause3010 = new BitSet(new long[]{0x900101128A800008L,0x76010004004A0000L,0x0000000020023028L});
    public static final BitSet FOLLOW_NESTED_CMD_in_nested_command3033 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_nested_command3035 = new BitSet(new long[]{0x0200002100420000L,0x0000000000000800L,0x0000000000010000L});
    public static final BitSet FOLLOW_nested_op_in_nested_command3039 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NESTED_CMD_ASSI_in_nested_command3051 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_nested_command3053 = new BitSet(new long[]{0x900101108A800000L,0x56010004004A0000L,0x0000000020023028L});
    public static final BitSet FOLLOW_expr_in_nested_command3057 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_nested_proj_in_nested_op3068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_filter_in_nested_op3082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_sort_in_nested_op3096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_distinct_in_nested_op3110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_limit_in_nested_op3124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_cross_in_nested_op3138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_foreach_in_nested_op3152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NESTED_PROJ_in_nested_proj3168 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_col_ref_in_nested_proj3170 = new BitSet(new long[]{0x0000010002000000L,0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_col_ref_in_nested_proj3174 = new BitSet(new long[]{0x0000010002000008L,0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_col_ref_in_nested_proj3180 = new BitSet(new long[]{0x0000010002000008L,0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_FILTER_in_nested_filter3205 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_filter3209 = new BitSet(new long[]{0x0000000000000020L,0x00007F00000005FCL,0x0000000000020008L});
    public static final BitSet FOLLOW_cond_in_nested_filter3213 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ORDER_in_nested_sort3235 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_sort3239 = new BitSet(new long[]{0x0000010002000000L,0x2000000400000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_order_by_clause_in_nested_sort3251 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000000000014L});
    public static final BitSet FOLLOW_func_clause_in_nested_sort3257 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DISTINCT_in_nested_distinct3281 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_distinct3286 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LIMIT_in_nested_limit3308 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_limit3313 = new BitSet(new long[]{0x900101108A800000L,0x56010004004A0000L,0x0000000020023028L});
    public static final BitSet FOLLOW_INTEGER_in_nested_limit3317 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expr_in_nested_limit3323 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CROSS_in_nested_cross3342 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_list_in_nested_cross3347 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_in_nested_foreach3361 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_foreach3366 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_generate_clause_in_nested_foreach3368 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_col_ref_in_nested_op_input3379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_proj_in_nested_op_input3383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_op_input_list3397 = new BitSet(new long[]{0x0000010002000002L,0x0000000000000000L,0x0000000000010020L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_op_input_list3403 = new BitSet(new long[]{0x0000010002000002L,0x0000000000000000L,0x0000000000010020L});
    public static final BitSet FOLLOW_STREAM_in_stream_clause3421 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_stream_clause3425 = new BitSet(new long[]{0x0000000040000000L,0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_EXECCOMMAND_in_stream_clause3439 = new BitSet(new long[]{0x0000000000000048L});
    public static final BitSet FOLLOW_IDENTIFIER_in_stream_clause3453 = new BitSet(new long[]{0x0000000000000048L});
    public static final BitSet FOLLOW_as_clause_in_stream_clause3459 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MAPREDUCE_in_mr_clause3478 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_mr_clause3480 = new BitSet(new long[]{0x0000000000000000L,0x0000004000400000L});
    public static final BitSet FOLLOW_path_list_in_mr_clause3495 = new BitSet(new long[]{0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_store_clause_in_mr_clause3502 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_load_clause_in_mr_clause3506 = new BitSet(new long[]{0x0000000040000008L});
    public static final BitSet FOLLOW_EXECCOMMAND_in_mr_clause3517 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SPLIT_in_split_clause3540 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_split_clause3553 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_split_branch_in_split_clause3557 = new BitSet(new long[]{0x0000000000000008L,0x0000000000001000L,0x0000000000400000L});
    public static final BitSet FOLLOW_split_branch_in_split_clause3563 = new BitSet(new long[]{0x0000000000000008L,0x0000000000001000L,0x0000000000400000L});
    public static final BitSet FOLLOW_split_otherwise_in_split_clause3568 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SPLIT_BRANCH_in_split_branch3586 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_split_branch3588 = new BitSet(new long[]{0x0000000000000020L,0x00007F00000005FCL,0x0000000000020008L});
    public static final BitSet FOLLOW_cond_in_split_branch3592 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OTHERWISE_in_split_otherwise3614 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_split_otherwise3618 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_alias_col_ref_in_col_ref3630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dollar_col_ref_in_col_ref3634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GROUP_in_alias_col_ref3648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_alias_col_ref3658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOLLARVAR_in_dollar_col_ref3674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_const_expr3685 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_scalar_in_literal3694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_map_in_literal3698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bag_in_literal3702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tuple_in_literal3706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_num_scalar_in_scalar3715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_scalar3726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NULL_in_scalar3739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_scalar3753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_scalar3766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_num_scalar3782 = new BitSet(new long[]{0x1001001008000000L});
    public static final BitSet FOLLOW_INTEGER_in_num_scalar3804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LONGINTEGER_in_num_scalar3823 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOATNUMBER_in_num_scalar3842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLENUMBER_in_num_scalar3861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MAP_VAL_in_map3894 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_keyvalue_in_map3898 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_keyvalue_in_map3904 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_MAP_VAL_in_map3920 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_KEY_VAL_PAIR_in_keyvalue3940 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_map_key_in_keyvalue3942 = new BitSet(new long[]{0x9001001088000000L,0x0201000000400000L,0x0000000020021000L});
    public static final BitSet FOLLOW_const_expr_in_keyvalue3946 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_map_key3961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BAG_VAL_in_bag3979 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_tuple_in_bag3983 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_tuple_in_bag3989 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_BAG_VAL_in_bag4005 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_TUPLE_VAL_in_tuple4025 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_literal_in_tuple4029 = new BitSet(new long[]{0x9001001088000008L,0x0201000000400000L,0x0000000020021000L});
    public static final BitSet FOLLOW_literal_in_tuple4036 = new BitSet(new long[]{0x9001001088000008L,0x0201000000400000L,0x0000000020021000L});
    public static final BitSet FOLLOW_TUPLE_VAL_in_tuple4052 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_str_op_in_eid4066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IMPORT_in_eid4074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RETURNS_in_eid4087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEFINE_in_eid4099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LOAD_in_eid4112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FILTER_in_eid4127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOREACH_in_eid4140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MATCHES_in_eid4152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ORDER_in_eid4164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DISTINCT_in_eid4178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COGROUP_in_eid4189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_JOIN_in_eid4201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CROSS_in_eid4216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNION_in_eid4230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SPLIT_in_eid4244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTO_in_eid4258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_eid4273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ALL_in_eid4290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AS_in_eid4306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BY_in_eid4323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_USING_in_eid4340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INNER_in_eid4354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OUTER_in_eid4368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARALLEL_in_eid4382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARTITION_in_eid4393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GROUP_in_eid4403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AND_in_eid4417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OR_in_eid4433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_eid4450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GENERATE_in_eid4466 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLATTEN_in_eid4477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EVAL_in_eid4489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASC_in_eid4504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESC_in_eid4520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOLEAN_in_eid4535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_eid4547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LONG_in_eid4563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_eid4578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLE_in_eid4592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHARARRAY_in_eid4605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BYTEARRAY_in_eid4615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BAG_in_eid4625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TUPLE_in_eid4641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MAP_in_eid4655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IS_in_eid4671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NULL_in_eid4688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_eid4703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_eid4718 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STREAM_in_eid4732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_THROUGH_in_eid4745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STORE_in_eid4757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MAPREDUCE_in_eid4771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHIP_in_eid4781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CACHE_in_eid4796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INPUT_in_eid4810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OUTPUT_in_eid4824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STDERROR_in_eid4837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STDIN_in_eid4848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STDOUT_in_eid4862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LIMIT_in_eid4875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SAMPLE_in_eid4889 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFT_in_eid4902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RIGHT_in_eid4917 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FULL_in_eid4931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_eid4946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOBAG_in_eid4959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOMAP_in_eid4972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOTUPLE_in_eid4985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_eq_in_rel_op5007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_ne_in_rel_op5021 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_gt_in_rel_op5035 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_gte_in_rel_op5049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_lt_in_rel_op5062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_lte_in_rel_op5076 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_MATCHES_in_rel_op5089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_EQ_in_rel_op_eq5108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUM_OP_EQ_in_rel_op_eq5118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_NE_in_rel_op_ne5136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUM_OP_NE_in_rel_op_ne5146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_GT_in_rel_op_gt5164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUM_OP_GT_in_rel_op_gt5174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_GTE_in_rel_op_gte5192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUM_OP_GTE_in_rel_op_gte5202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_LT_in_rel_op_lt5220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUM_OP_LT_in_rel_op_lt5230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_LTE_in_rel_op_lte5248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUM_OP_LTE_in_rel_op_lte5258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_EQ_in_rel_str_op5273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_NE_in_rel_str_op5283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_GT_in_rel_str_op5293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_LT_in_rel_str_op5303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_GTE_in_rel_str_op5313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_LTE_in_rel_str_op5323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_MATCHES_in_rel_str_op5333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_field_def_in_synpred42_AstPrinter949 = new BitSet(new long[]{0x0000000000000000L,0x8000000000000000L});
    public static final BitSet FOLLOW_field_def_in_synpred42_AstPrinter955 = new BitSet(new long[]{0x0000000000000002L,0x8000000000000000L});
    public static final BitSet FOLLOW_MINUS_in_synpred87_AstPrinter1804 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_synpred87_AstPrinter1806 = new BitSet(new long[]{0x900101108A800000L,0x56010004004A0000L,0x0000000020023028L});
    public static final BitSet FOLLOW_expr_in_synpred87_AstPrinter1810 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CAST_EXPR_in_synpred91_AstPrinter1876 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_in_synpred91_AstPrinter1880 = new BitSet(new long[]{0x900101108A800000L,0x56010004004A0000L,0x0000000020023028L});
    public static final BitSet FOLLOW_expr_in_synpred91_AstPrinter1884 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_const_expr_in_synpred92_AstPrinter1894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CAST_EXPR_in_synpred95_AstPrinter1928 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_cast_in_synpred95_AstPrinter1932 = new BitSet(new long[]{0x900101108A800000L,0x56010004004A0000L,0x0000000020023028L});
    public static final BitSet FOLLOW_expr_in_synpred95_AstPrinter1936 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TUPLE_TYPE_CAST_in_synpred100_AstPrinter1998 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_cast_in_synpred100_AstPrinter2002 = new BitSet(new long[]{0x0800800404002A08L,0x0100000000000000L,0x0000000010000800L});
    public static final BitSet FOLLOW_type_cast_in_synpred100_AstPrinter2008 = new BitSet(new long[]{0x0800800404002A08L,0x0100000000000000L,0x0000000010000800L});
    public static final BitSet FOLLOW_INTEGER_in_synpred113_AstPrinter2326 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LONGINTEGER_in_synpred114_AstPrinter2332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLENUMBER_in_synpred115_AstPrinter2366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_join_item_in_synpred132_AstPrinter2685 = new BitSet(new long[]{0x0010004000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_set_in_synpred132_AstPrinter2687 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L,0x0000000000000040L});
    public static final BitSet FOLLOW_OUTER_in_synpred132_AstPrinter2747 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_join_item_in_synpred132_AstPrinter2756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_in_synpred150_AstPrinter3317 = new BitSet(new long[]{0x0000000000000002L});

}