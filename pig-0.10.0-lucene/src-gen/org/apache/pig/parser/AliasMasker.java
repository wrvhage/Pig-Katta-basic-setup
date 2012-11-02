// $ANTLR 3.4 /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g 2012-10-31 09:51:41

package org.apache.pig.parser;

import java.util.HashSet;
import java.util.Set;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;


/**
 * Grammar file for Pig tree parser (visitor for default data type insertion).
 *
 * NOTE: THIS FILE IS BASED ON QueryParser.g, SO IF YOU CHANGE THAT FILE, YOU WILL 
 *       PROBABLY NEED TO MAKE CORRESPONDING CHANGES TO THIS FILE AS WELL.
 */
@SuppressWarnings({"all", "warnings", "unchecked"})
public class AliasMasker extends TreeParser {
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


    public AliasMasker(TreeNodeStream input) {
        this(input, new RecognizerSharedState());
    }
    public AliasMasker(TreeNodeStream input, RecognizerSharedState state) {
        super(input, state);
    }

protected TreeAdaptor adaptor = new CommonTreeAdaptor();

public void setTreeAdaptor(TreeAdaptor adaptor) {
    this.adaptor = adaptor;
}
public TreeAdaptor getTreeAdaptor() {
    return adaptor;
}
    public String[] getTokenNames() { return AliasMasker.tokenNames; }
    public String getGrammarFileName() { return "/Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g"; }



    @Override
    public String getErrorMessage(RecognitionException e, String[] tokenNames) {
    	if (e instanceof ParserValidationException) {
    		return e.toString();
    	} 
    	return super.getErrorMessage(e, tokenNames);
    }

    public void setParams(Set ps, String macro, long idx) {
        params = ps; 
        macroName = macro;
        index = idx;
    }

    private String getMask(String alias) {
        return params.contains( alias ) 
            ? alias 
            : "macro_" + macroName + "_" + alias + "_" + index;
    }

    private Set<String> params = new HashSet<String>();

    private Set<String> aliasSeen = new HashSet<String>();

    private String macroName = "";

    private long index = 0;

    private boolean inAsOrGenClause = false;



    public static class query_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "query"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:82:1: query : ^( QUERY ( statement )* ) ;
    public final AliasMasker.query_return query() throws RecognitionException {
        AliasMasker.query_return retval = new AliasMasker.query_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUERY1=null;
        AliasMasker.statement_return statement2 =null;


        CommonTree QUERY1_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:82:7: ( ^( QUERY ( statement )* ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:82:9: ^( QUERY ( statement )* )
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
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:82:18: ( statement )*
                loop1:
                do {
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==SPLIT||LA1_0==REALIAS||LA1_0==STATEMENT) ) {
                        alt1=1;
                    }


                    switch (alt1) {
                	case 1 :
                	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:82:18: statement
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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:85:1: statement : ( general_statement | split_statement | realias_statement );
    public final AliasMasker.statement_return statement() throws RecognitionException {
        AliasMasker.statement_return retval = new AliasMasker.statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.general_statement_return general_statement3 =null;

        AliasMasker.split_statement_return split_statement4 =null;

        AliasMasker.realias_statement_return realias_statement5 =null;



        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:85:11: ( general_statement | split_statement | realias_statement )
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:85:13: general_statement
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:86:13: split_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_split_statement_in_statement109);
                    split_statement4=split_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, split_statement4.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:87:13: realias_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_realias_statement_in_statement123);
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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:90:1: split_statement : split_clause ;
    public final AliasMasker.split_statement_return split_statement() throws RecognitionException {
        AliasMasker.split_statement_return retval = new AliasMasker.split_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.split_clause_return split_clause6 =null;



        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:90:17: ( split_clause )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:90:19: split_clause
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_split_clause_in_split_statement132);
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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:93:1: realias_statement : realias_clause ;
    public final AliasMasker.realias_statement_return realias_statement() throws RecognitionException {
        AliasMasker.realias_statement_return retval = new AliasMasker.realias_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.realias_clause_return realias_clause7 =null;



        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:93:19: ( realias_clause )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:93:21: realias_clause
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_realias_clause_in_realias_statement141);
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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:97:1: general_statement : ^( STATEMENT ( alias )? op_clause ( parallel_clause )? ) ;
    public final AliasMasker.general_statement_return general_statement() throws RecognitionException {
        AliasMasker.general_statement_return retval = new AliasMasker.general_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STATEMENT8=null;
        AliasMasker.alias_return alias9 =null;

        AliasMasker.op_clause_return op_clause10 =null;

        AliasMasker.parallel_clause_return parallel_clause11 =null;


        CommonTree STATEMENT8_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:98:5: ( ^( STATEMENT ( alias )? op_clause ( parallel_clause )? ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:98:7: ^( STATEMENT ( alias )? op_clause ( parallel_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            STATEMENT8=(CommonTree)match(input,STATEMENT,FOLLOW_STATEMENT_in_general_statement158); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STATEMENT8_tree = (CommonTree)adaptor.dupNode(STATEMENT8);


            root_1 = (CommonTree)adaptor.becomeRoot(STATEMENT8_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:98:20: ( alias )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==IDENTIFIER) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:98:22: alias
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_alias_in_general_statement162);
                    alias9=alias();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, alias9.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_op_clause_in_general_statement176);
            op_clause10=op_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, op_clause10.getTree());


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:99:19: ( parallel_clause )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==PARALLEL) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:99:19: parallel_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_parallel_clause_in_general_statement178);
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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:102:1: realias_clause : ^( REALIAS alias IDENTIFIER ) ;
    public final AliasMasker.realias_clause_return realias_clause() throws RecognitionException {
        AliasMasker.realias_clause_return retval = new AliasMasker.realias_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree REALIAS12=null;
        CommonTree IDENTIFIER14=null;
        AliasMasker.alias_return alias13 =null;


        CommonTree REALIAS12_tree=null;
        CommonTree IDENTIFIER14_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:102:16: ( ^( REALIAS alias IDENTIFIER ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:102:18: ^( REALIAS alias IDENTIFIER )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            REALIAS12=(CommonTree)match(input,REALIAS,FOLLOW_REALIAS_in_realias_clause192); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            REALIAS12_tree = (CommonTree)adaptor.dupNode(REALIAS12);


            root_1 = (CommonTree)adaptor.becomeRoot(REALIAS12_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_alias_in_realias_clause194);
            alias13=alias();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, alias13.getTree());


            _last = (CommonTree)input.LT(1);
            IDENTIFIER14=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_realias_clause196); if (state.failed) return retval;
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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:105:1: parallel_clause : ^( PARALLEL INTEGER ) ;
    public final AliasMasker.parallel_clause_return parallel_clause() throws RecognitionException {
        AliasMasker.parallel_clause_return retval = new AliasMasker.parallel_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PARALLEL15=null;
        CommonTree INTEGER16=null;

        CommonTree PARALLEL15_tree=null;
        CommonTree INTEGER16_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:106:5: ( ^( PARALLEL INTEGER ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:106:7: ^( PARALLEL INTEGER )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            PARALLEL15=(CommonTree)match(input,PARALLEL,FOLLOW_PARALLEL_in_parallel_clause213); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PARALLEL15_tree = (CommonTree)adaptor.dupNode(PARALLEL15);


            root_1 = (CommonTree)adaptor.becomeRoot(PARALLEL15_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            INTEGER16=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_parallel_clause215); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            INTEGER16_tree = (CommonTree)adaptor.dupNode(INTEGER16);


            adaptor.addChild(root_1, INTEGER16_tree);
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
    // $ANTLR end "parallel_clause"


    public static class alias_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "alias"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:109:1: alias : IDENTIFIER ;
    public final AliasMasker.alias_return alias() throws RecognitionException {
        AliasMasker.alias_return retval = new AliasMasker.alias_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IDENTIFIER17=null;

        CommonTree IDENTIFIER17_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:110:5: ( IDENTIFIER )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:110:7: IDENTIFIER
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            IDENTIFIER17=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_alias232); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER17_tree = (CommonTree)adaptor.dupNode(IDENTIFIER17);


            adaptor.addChild(root_0, IDENTIFIER17_tree);
            }


            if ( state.backtracking==0 ) { 
                        aliasSeen.add((IDENTIFIER17!=null?IDENTIFIER17.getText():null)); 
                        IDENTIFIER17.getToken().setText(getMask((IDENTIFIER17!=null?IDENTIFIER17.getText():null))); 
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
    // $ANTLR end "alias"


    public static class op_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "op_clause"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:117:1: op_clause : ( define_clause | load_clause | group_clause | store_clause | filter_clause | distinct_clause | limit_clause | sample_clause | order_clause | cross_clause | join_clause | union_clause | stream_clause | mr_clause | split_clause | foreach_clause );
    public final AliasMasker.op_clause_return op_clause() throws RecognitionException {
        AliasMasker.op_clause_return retval = new AliasMasker.op_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.define_clause_return define_clause18 =null;

        AliasMasker.load_clause_return load_clause19 =null;

        AliasMasker.group_clause_return group_clause20 =null;

        AliasMasker.store_clause_return store_clause21 =null;

        AliasMasker.filter_clause_return filter_clause22 =null;

        AliasMasker.distinct_clause_return distinct_clause23 =null;

        AliasMasker.limit_clause_return limit_clause24 =null;

        AliasMasker.sample_clause_return sample_clause25 =null;

        AliasMasker.order_clause_return order_clause26 =null;

        AliasMasker.cross_clause_return cross_clause27 =null;

        AliasMasker.join_clause_return join_clause28 =null;

        AliasMasker.union_clause_return union_clause29 =null;

        AliasMasker.stream_clause_return stream_clause30 =null;

        AliasMasker.mr_clause_return mr_clause31 =null;

        AliasMasker.split_clause_return split_clause32 =null;

        AliasMasker.foreach_clause_return foreach_clause33 =null;



        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:117:11: ( define_clause | load_clause | group_clause | store_clause | filter_clause | distinct_clause | limit_clause | sample_clause | order_clause | cross_clause | join_clause | union_clause | stream_clause | mr_clause | split_clause | foreach_clause )
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:117:13: define_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_define_clause_in_op_clause252);
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:118:13: load_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_load_clause_in_op_clause267);
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:119:13: group_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_group_clause_in_op_clause281);
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:120:13: store_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_store_clause_in_op_clause295);
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:121:13: filter_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_filter_clause_in_op_clause309);
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:122:13: distinct_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_distinct_clause_in_op_clause323);
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:123:13: limit_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_limit_clause_in_op_clause337);
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:124:13: sample_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_sample_clause_in_op_clause351);
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:125:13: order_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_order_clause_in_op_clause365);
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:126:13: cross_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cross_clause_in_op_clause379);
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:127:13: join_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_clause_in_op_clause393);
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:128:13: union_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_union_clause_in_op_clause407);
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:129:13: stream_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_stream_clause_in_op_clause421);
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:130:13: mr_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_mr_clause_in_op_clause435);
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:131:13: split_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_split_clause_in_op_clause449);
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:132:13: foreach_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_foreach_clause_in_op_clause463);
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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:135:1: define_clause : ^( DEFINE IDENTIFIER ( cmd | func_clause ) ) ;
    public final AliasMasker.define_clause_return define_clause() throws RecognitionException {
        AliasMasker.define_clause_return retval = new AliasMasker.define_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DEFINE34=null;
        CommonTree IDENTIFIER35=null;
        AliasMasker.cmd_return cmd36 =null;

        AliasMasker.func_clause_return func_clause37 =null;


        CommonTree DEFINE34_tree=null;
        CommonTree IDENTIFIER35_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:136:5: ( ^( DEFINE IDENTIFIER ( cmd | func_clause ) ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:136:7: ^( DEFINE IDENTIFIER ( cmd | func_clause ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            DEFINE34=(CommonTree)match(input,DEFINE,FOLLOW_DEFINE_in_define_clause479); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DEFINE34_tree = (CommonTree)adaptor.dupNode(DEFINE34);


            root_1 = (CommonTree)adaptor.becomeRoot(DEFINE34_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            IDENTIFIER35=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_define_clause481); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER35_tree = (CommonTree)adaptor.dupNode(IDENTIFIER35);


            adaptor.addChild(root_1, IDENTIFIER35_tree);
            }


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:136:29: ( cmd | func_clause )
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:136:31: cmd
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cmd_in_define_clause486);
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:136:37: func_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_define_clause490);
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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:139:1: cmd : ^( EXECCOMMAND ( ship_clause | cache_clause | input_clause | output_clause | error_clause )* ) ;
    public final AliasMasker.cmd_return cmd() throws RecognitionException {
        AliasMasker.cmd_return retval = new AliasMasker.cmd_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree EXECCOMMAND38=null;
        AliasMasker.ship_clause_return ship_clause39 =null;

        AliasMasker.cache_clause_return cache_clause40 =null;

        AliasMasker.input_clause_return input_clause41 =null;

        AliasMasker.output_clause_return output_clause42 =null;

        AliasMasker.error_clause_return error_clause43 =null;


        CommonTree EXECCOMMAND38_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:140:5: ( ^( EXECCOMMAND ( ship_clause | cache_clause | input_clause | output_clause | error_clause )* ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:140:7: ^( EXECCOMMAND ( ship_clause | cache_clause | input_clause | output_clause | error_clause )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            EXECCOMMAND38=(CommonTree)match(input,EXECCOMMAND,FOLLOW_EXECCOMMAND_in_cmd510); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            EXECCOMMAND38_tree = (CommonTree)adaptor.dupNode(EXECCOMMAND38);


            root_1 = (CommonTree)adaptor.becomeRoot(EXECCOMMAND38_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:141:9: ( ship_clause | cache_clause | input_clause | output_clause | error_clause )*
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
                	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:141:11: ship_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_ship_clause_in_cmd523);
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
                	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:141:25: cache_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_cache_clause_in_cmd527);
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
                	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:141:40: input_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_input_clause_in_cmd531);
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
                	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:141:55: output_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_output_clause_in_cmd535);
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
                	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:141:71: error_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_error_clause_in_cmd539);
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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:144:1: ship_clause : ^( SHIP ( path_list )? ) ;
    public final AliasMasker.ship_clause_return ship_clause() throws RecognitionException {
        AliasMasker.ship_clause_return retval = new AliasMasker.ship_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SHIP44=null;
        AliasMasker.path_list_return path_list45 =null;


        CommonTree SHIP44_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:145:5: ( ^( SHIP ( path_list )? ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:145:7: ^( SHIP ( path_list )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            SHIP44=(CommonTree)match(input,SHIP,FOLLOW_SHIP_in_ship_clause560); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SHIP44_tree = (CommonTree)adaptor.dupNode(SHIP44);


            root_1 = (CommonTree)adaptor.becomeRoot(SHIP44_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:145:15: ( path_list )?
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==QUOTEDSTRING) ) {
                    alt8=1;
                }
                switch (alt8) {
                    case 1 :
                        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:145:15: path_list
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_path_list_in_ship_clause562);
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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:148:1: path_list : ( QUOTEDSTRING )+ ;
    public final AliasMasker.path_list_return path_list() throws RecognitionException {
        AliasMasker.path_list_return retval = new AliasMasker.path_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING46=null;

        CommonTree QUOTEDSTRING46_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:149:5: ( ( QUOTEDSTRING )+ )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:149:7: ( QUOTEDSTRING )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:149:7: ( QUOTEDSTRING )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==QUOTEDSTRING) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:149:7: QUOTEDSTRING
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    QUOTEDSTRING46=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_path_list579); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    QUOTEDSTRING46_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING46);


            	    adaptor.addChild(root_0, QUOTEDSTRING46_tree);
            	    }


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt9 >= 1 ) break loop9;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:152:1: cache_clause : ^( CACHE path_list ) ;
    public final AliasMasker.cache_clause_return cache_clause() throws RecognitionException {
        AliasMasker.cache_clause_return retval = new AliasMasker.cache_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CACHE47=null;
        AliasMasker.path_list_return path_list48 =null;


        CommonTree CACHE47_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:153:5: ( ^( CACHE path_list ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:153:7: ^( CACHE path_list )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CACHE47=(CommonTree)match(input,CACHE,FOLLOW_CACHE_in_cache_clause597); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CACHE47_tree = (CommonTree)adaptor.dupNode(CACHE47);


            root_1 = (CommonTree)adaptor.becomeRoot(CACHE47_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_path_list_in_cache_clause599);
            path_list48=path_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, path_list48.getTree());


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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:156:1: input_clause : ^( INPUT ( stream_cmd )+ ) ;
    public final AliasMasker.input_clause_return input_clause() throws RecognitionException {
        AliasMasker.input_clause_return retval = new AliasMasker.input_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree INPUT49=null;
        AliasMasker.stream_cmd_return stream_cmd50 =null;


        CommonTree INPUT49_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:157:5: ( ^( INPUT ( stream_cmd )+ ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:157:7: ^( INPUT ( stream_cmd )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            INPUT49=(CommonTree)match(input,INPUT,FOLLOW_INPUT_in_input_clause617); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            INPUT49_tree = (CommonTree)adaptor.dupNode(INPUT49);


            root_1 = (CommonTree)adaptor.becomeRoot(INPUT49_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:157:16: ( stream_cmd )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==QUOTEDSTRING||(LA10_0 >= STDIN && LA10_0 <= STDOUT)) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:157:16: stream_cmd
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_stream_cmd_in_input_clause619);
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
            	    if ( cnt10 >= 1 ) break loop10;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
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
    // $ANTLR end "input_clause"


    public static class stream_cmd_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "stream_cmd"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:160:1: stream_cmd : ( ^( STDIN ( func_clause )? ) | ^( STDOUT ( func_clause )? ) | ^( QUOTEDSTRING ( func_clause )? ) );
    public final AliasMasker.stream_cmd_return stream_cmd() throws RecognitionException {
        AliasMasker.stream_cmd_return retval = new AliasMasker.stream_cmd_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STDIN51=null;
        CommonTree STDOUT53=null;
        CommonTree QUOTEDSTRING55=null;
        AliasMasker.func_clause_return func_clause52 =null;

        AliasMasker.func_clause_return func_clause54 =null;

        AliasMasker.func_clause_return func_clause56 =null;


        CommonTree STDIN51_tree=null;
        CommonTree STDOUT53_tree=null;
        CommonTree QUOTEDSTRING55_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:161:5: ( ^( STDIN ( func_clause )? ) | ^( STDOUT ( func_clause )? ) | ^( QUOTEDSTRING ( func_clause )? ) )
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:161:7: ^( STDIN ( func_clause )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    STDIN51=(CommonTree)match(input,STDIN,FOLLOW_STDIN_in_stream_cmd638); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDIN51_tree = (CommonTree)adaptor.dupNode(STDIN51);


                    root_1 = (CommonTree)adaptor.becomeRoot(STDIN51_tree, root_1);
                    }


                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
                        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:161:16: ( func_clause )?
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==FUNC||LA11_0==FUNC_REF) ) {
                            alt11=1;
                        }
                        switch (alt11) {
                            case 1 :
                                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:161:16: func_clause
                                {
                                _last = (CommonTree)input.LT(1);
                                pushFollow(FOLLOW_func_clause_in_stream_cmd640);
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:162:7: ^( STDOUT ( func_clause )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    STDOUT53=(CommonTree)match(input,STDOUT,FOLLOW_STDOUT_in_stream_cmd653); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDOUT53_tree = (CommonTree)adaptor.dupNode(STDOUT53);


                    root_1 = (CommonTree)adaptor.becomeRoot(STDOUT53_tree, root_1);
                    }


                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
                        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:162:17: ( func_clause )?
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==FUNC||LA12_0==FUNC_REF) ) {
                            alt12=1;
                        }
                        switch (alt12) {
                            case 1 :
                                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:162:17: func_clause
                                {
                                _last = (CommonTree)input.LT(1);
                                pushFollow(FOLLOW_func_clause_in_stream_cmd655);
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:163:7: ^( QUOTEDSTRING ( func_clause )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    QUOTEDSTRING55=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_stream_cmd668); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    QUOTEDSTRING55_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING55);


                    root_1 = (CommonTree)adaptor.becomeRoot(QUOTEDSTRING55_tree, root_1);
                    }


                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
                        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:163:23: ( func_clause )?
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==FUNC||LA13_0==FUNC_REF) ) {
                            alt13=1;
                        }
                        switch (alt13) {
                            case 1 :
                                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:163:23: func_clause
                                {
                                _last = (CommonTree)input.LT(1);
                                pushFollow(FOLLOW_func_clause_in_stream_cmd670);
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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:166:1: output_clause : ^( OUTPUT ( stream_cmd )+ ) ;
    public final AliasMasker.output_clause_return output_clause() throws RecognitionException {
        AliasMasker.output_clause_return retval = new AliasMasker.output_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree OUTPUT57=null;
        AliasMasker.stream_cmd_return stream_cmd58 =null;


        CommonTree OUTPUT57_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:167:5: ( ^( OUTPUT ( stream_cmd )+ ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:167:7: ^( OUTPUT ( stream_cmd )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            OUTPUT57=(CommonTree)match(input,OUTPUT,FOLLOW_OUTPUT_in_output_clause689); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            OUTPUT57_tree = (CommonTree)adaptor.dupNode(OUTPUT57);


            root_1 = (CommonTree)adaptor.becomeRoot(OUTPUT57_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:167:17: ( stream_cmd )+
            int cnt15=0;
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==QUOTEDSTRING||(LA15_0 >= STDIN && LA15_0 <= STDOUT)) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:167:17: stream_cmd
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_stream_cmd_in_output_clause691);
            	    stream_cmd58=stream_cmd();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, stream_cmd58.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt15 >= 1 ) break loop15;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(15, input);
                        throw eee;
                }
                cnt15++;
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
    // $ANTLR end "output_clause"


    public static class error_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "error_clause"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:170:1: error_clause : ^( STDERROR ( QUOTEDSTRING ( INTEGER )? )? ) ;
    public final AliasMasker.error_clause_return error_clause() throws RecognitionException {
        AliasMasker.error_clause_return retval = new AliasMasker.error_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STDERROR59=null;
        CommonTree QUOTEDSTRING60=null;
        CommonTree INTEGER61=null;

        CommonTree STDERROR59_tree=null;
        CommonTree QUOTEDSTRING60_tree=null;
        CommonTree INTEGER61_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:171:5: ( ^( STDERROR ( QUOTEDSTRING ( INTEGER )? )? ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:171:7: ^( STDERROR ( QUOTEDSTRING ( INTEGER )? )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            STDERROR59=(CommonTree)match(input,STDERROR,FOLLOW_STDERROR_in_error_clause710); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STDERROR59_tree = (CommonTree)adaptor.dupNode(STDERROR59);


            root_1 = (CommonTree)adaptor.becomeRoot(STDERROR59_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:171:19: ( QUOTEDSTRING ( INTEGER )? )?
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==QUOTEDSTRING) ) {
                    alt17=1;
                }
                switch (alt17) {
                    case 1 :
                        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:171:21: QUOTEDSTRING ( INTEGER )?
                        {
                        _last = (CommonTree)input.LT(1);
                        QUOTEDSTRING60=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_error_clause714); if (state.failed) return retval;
                        if ( state.backtracking==0 ) {
                        QUOTEDSTRING60_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING60);


                        adaptor.addChild(root_1, QUOTEDSTRING60_tree);
                        }


                        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:171:34: ( INTEGER )?
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==INTEGER) ) {
                            alt16=1;
                        }
                        switch (alt16) {
                            case 1 :
                                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:171:34: INTEGER
                                {
                                _last = (CommonTree)input.LT(1);
                                INTEGER61=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_error_clause716); if (state.failed) return retval;
                                if ( state.backtracking==0 ) {
                                INTEGER61_tree = (CommonTree)adaptor.dupNode(INTEGER61);


                                adaptor.addChild(root_1, INTEGER61_tree);
                                }


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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:174:1: load_clause : ^( LOAD filename ( func_clause )? ( as_clause )? ) ;
    public final AliasMasker.load_clause_return load_clause() throws RecognitionException {
        AliasMasker.load_clause_return retval = new AliasMasker.load_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree LOAD62=null;
        AliasMasker.filename_return filename63 =null;

        AliasMasker.func_clause_return func_clause64 =null;

        AliasMasker.as_clause_return as_clause65 =null;


        CommonTree LOAD62_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:175:5: ( ^( LOAD filename ( func_clause )? ( as_clause )? ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:175:7: ^( LOAD filename ( func_clause )? ( as_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            LOAD62=(CommonTree)match(input,LOAD,FOLLOW_LOAD_in_load_clause738); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LOAD62_tree = (CommonTree)adaptor.dupNode(LOAD62);


            root_1 = (CommonTree)adaptor.becomeRoot(LOAD62_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_filename_in_load_clause740);
            filename63=filename();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, filename63.getTree());


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:175:24: ( func_clause )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==FUNC||LA18_0==FUNC_REF) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:175:24: func_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_load_clause742);
                    func_clause64=func_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause64.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:175:37: ( as_clause )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==AS) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:175:37: as_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_as_clause_in_load_clause745);
                    as_clause65=as_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, as_clause65.getTree());


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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:178:1: filename : QUOTEDSTRING ;
    public final AliasMasker.filename_return filename() throws RecognitionException {
        AliasMasker.filename_return retval = new AliasMasker.filename_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING66=null;

        CommonTree QUOTEDSTRING66_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:179:5: ( QUOTEDSTRING )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:179:7: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING66=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_filename762); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING66_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING66);


            adaptor.addChild(root_0, QUOTEDSTRING66_tree);
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
    // $ANTLR end "filename"


    public static class as_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "as_clause"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:182:1: as_clause : ^( AS field_def_list ) ;
    public final AliasMasker.as_clause_return as_clause() throws RecognitionException {
        AliasMasker.as_clause_return retval = new AliasMasker.as_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree AS67=null;
        AliasMasker.field_def_list_return field_def_list68 =null;


        CommonTree AS67_tree=null;

         
        	inAsOrGenClause = true;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:189:5: ( ^( AS field_def_list ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:189:7: ^( AS field_def_list )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            AS67=(CommonTree)match(input,AS,FOLLOW_AS_in_as_clause788); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            AS67_tree = (CommonTree)adaptor.dupNode(AS67);


            root_1 = (CommonTree)adaptor.becomeRoot(AS67_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_field_def_list_in_as_clause790);
            field_def_list68=field_def_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, field_def_list68.getTree());


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

            if ( state.backtracking==0 ) { 
            	inAsOrGenClause = false; 
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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:192:1: field_def : ^( FIELD_DEF IDENTIFIER ( type )? ) ;
    public final AliasMasker.field_def_return field_def() throws RecognitionException {
        AliasMasker.field_def_return retval = new AliasMasker.field_def_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FIELD_DEF69=null;
        CommonTree IDENTIFIER70=null;
        AliasMasker.type_return type71 =null;


        CommonTree FIELD_DEF69_tree=null;
        CommonTree IDENTIFIER70_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:193:5: ( ^( FIELD_DEF IDENTIFIER ( type )? ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:193:7: ^( FIELD_DEF IDENTIFIER ( type )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FIELD_DEF69=(CommonTree)match(input,FIELD_DEF,FOLLOW_FIELD_DEF_in_field_def807); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FIELD_DEF69_tree = (CommonTree)adaptor.dupNode(FIELD_DEF69);


            root_1 = (CommonTree)adaptor.becomeRoot(FIELD_DEF69_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            IDENTIFIER70=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_field_def809); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER70_tree = (CommonTree)adaptor.dupNode(IDENTIFIER70);


            adaptor.addChild(root_1, IDENTIFIER70_tree);
            }


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:193:31: ( type )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==BOOLEAN||LA20_0==BYTEARRAY||LA20_0==CHARARRAY||LA20_0==DOUBLE||LA20_0==FLOAT||LA20_0==INT||LA20_0==LONG||LA20_0==BAG_TYPE||LA20_0==MAP_TYPE||LA20_0==TUPLE_TYPE) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:193:31: type
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_type_in_field_def811);
                    type71=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, type71.getTree());


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
            	if (inAsOrGenClause) {
            		if (aliasSeen.contains((IDENTIFIER70!=null?IDENTIFIER70.getText():null))) {
            			throw new ParserValidationException(input, new SourceLocation((PigParserNode)((CommonTree)retval.start)), 
            				"Macro doesn't support user defined schema that contains name that conflicts with alias name: " + (IDENTIFIER70!=null?IDENTIFIER70.getText():null));
            		}
            	}
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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:203:1: field_def_list : ( field_def )+ ;
    public final AliasMasker.field_def_list_return field_def_list() throws RecognitionException {
        AliasMasker.field_def_list_return retval = new AliasMasker.field_def_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.field_def_return field_def72 =null;



        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:204:5: ( ( field_def )+ )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:204:7: ( field_def )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:204:7: ( field_def )+
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
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:204:7: field_def
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_field_def_in_field_def_list829);
            	    field_def72=field_def();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, field_def72.getTree());


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
    // $ANTLR end "field_def_list"


    public static class type_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "type"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:207:1: type : ( simple_type | tuple_type | bag_type | map_type );
    public final AliasMasker.type_return type() throws RecognitionException {
        AliasMasker.type_return retval = new AliasMasker.type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.simple_type_return simple_type73 =null;

        AliasMasker.tuple_type_return tuple_type74 =null;

        AliasMasker.bag_type_return bag_type75 =null;

        AliasMasker.map_type_return map_type76 =null;



        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:207:6: ( simple_type | tuple_type | bag_type | map_type )
            int alt22=4;
            switch ( input.LA(1) ) {
            case BOOLEAN:
            case BYTEARRAY:
            case CHARARRAY:
            case DOUBLE:
            case FLOAT:
            case INT:
            case LONG:
                {
                alt22=1;
                }
                break;
            case TUPLE_TYPE:
                {
                alt22=2;
                }
                break;
            case BAG_TYPE:
                {
                alt22=3;
                }
                break;
            case MAP_TYPE:
                {
                alt22=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;

            }

            switch (alt22) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:207:8: simple_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_simple_type_in_type840);
                    simple_type73=simple_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, simple_type73.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:207:22: tuple_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_tuple_type_in_type844);
                    tuple_type74=tuple_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, tuple_type74.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:207:35: bag_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_bag_type_in_type848);
                    bag_type75=bag_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, bag_type75.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:207:46: map_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_map_type_in_type852);
                    map_type76=map_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, map_type76.getTree());


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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:210:1: simple_type : ( BOOLEAN | INT | LONG | FLOAT | DOUBLE | CHARARRAY | BYTEARRAY );
    public final AliasMasker.simple_type_return simple_type() throws RecognitionException {
        AliasMasker.simple_type_return retval = new AliasMasker.simple_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set77=null;

        CommonTree set77_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:211:5: ( BOOLEAN | INT | LONG | FLOAT | DOUBLE | CHARARRAY | BYTEARRAY )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set77=(CommonTree)input.LT(1);

            if ( input.LA(1)==BOOLEAN||input.LA(1)==BYTEARRAY||input.LA(1)==CHARARRAY||input.LA(1)==DOUBLE||input.LA(1)==FLOAT||input.LA(1)==INT||input.LA(1)==LONG ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set77_tree = (CommonTree)adaptor.dupNode(set77);


                adaptor.addChild(root_0, set77_tree);
                }

                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
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
    // $ANTLR end "simple_type"


    public static class tuple_type_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "tuple_type"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:214:1: tuple_type : ^( TUPLE_TYPE ( field_def_list )? ) ;
    public final AliasMasker.tuple_type_return tuple_type() throws RecognitionException {
        AliasMasker.tuple_type_return retval = new AliasMasker.tuple_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree TUPLE_TYPE78=null;
        AliasMasker.field_def_list_return field_def_list79 =null;


        CommonTree TUPLE_TYPE78_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:215:5: ( ^( TUPLE_TYPE ( field_def_list )? ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:215:7: ^( TUPLE_TYPE ( field_def_list )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            TUPLE_TYPE78=(CommonTree)match(input,TUPLE_TYPE,FOLLOW_TUPLE_TYPE_in_tuple_type907); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            TUPLE_TYPE78_tree = (CommonTree)adaptor.dupNode(TUPLE_TYPE78);


            root_1 = (CommonTree)adaptor.becomeRoot(TUPLE_TYPE78_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:215:21: ( field_def_list )?
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==FIELD_DEF) ) {
                    alt23=1;
                }
                switch (alt23) {
                    case 1 :
                        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:215:21: field_def_list
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_field_def_list_in_tuple_type909);
                        field_def_list79=field_def_list();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, field_def_list79.getTree());


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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:218:1: bag_type : ^( BAG_TYPE ( IDENTIFIER )? ( tuple_type )? ) ;
    public final AliasMasker.bag_type_return bag_type() throws RecognitionException {
        AliasMasker.bag_type_return retval = new AliasMasker.bag_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BAG_TYPE80=null;
        CommonTree IDENTIFIER81=null;
        AliasMasker.tuple_type_return tuple_type82 =null;


        CommonTree BAG_TYPE80_tree=null;
        CommonTree IDENTIFIER81_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:219:5: ( ^( BAG_TYPE ( IDENTIFIER )? ( tuple_type )? ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:219:7: ^( BAG_TYPE ( IDENTIFIER )? ( tuple_type )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BAG_TYPE80=(CommonTree)match(input,BAG_TYPE,FOLLOW_BAG_TYPE_in_bag_type928); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BAG_TYPE80_tree = (CommonTree)adaptor.dupNode(BAG_TYPE80);


            root_1 = (CommonTree)adaptor.becomeRoot(BAG_TYPE80_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:219:19: ( IDENTIFIER )?
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==IDENTIFIER) ) {
                    alt24=1;
                }
                switch (alt24) {
                    case 1 :
                        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:219:19: IDENTIFIER
                        {
                        _last = (CommonTree)input.LT(1);
                        IDENTIFIER81=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_bag_type930); if (state.failed) return retval;
                        if ( state.backtracking==0 ) {
                        IDENTIFIER81_tree = (CommonTree)adaptor.dupNode(IDENTIFIER81);


                        adaptor.addChild(root_1, IDENTIFIER81_tree);
                        }


                        if ( state.backtracking==0 ) {
                        }
                        }
                        break;

                }


                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:219:31: ( tuple_type )?
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==TUPLE_TYPE) ) {
                    alt25=1;
                }
                switch (alt25) {
                    case 1 :
                        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:219:31: tuple_type
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_tuple_type_in_bag_type933);
                        tuple_type82=tuple_type();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, tuple_type82.getTree());


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
    // $ANTLR end "bag_type"


    public static class map_type_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "map_type"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:222:1: map_type : ^( MAP_TYPE ( type )? ) ;
    public final AliasMasker.map_type_return map_type() throws RecognitionException {
        AliasMasker.map_type_return retval = new AliasMasker.map_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MAP_TYPE83=null;
        AliasMasker.type_return type84 =null;


        CommonTree MAP_TYPE83_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:222:10: ( ^( MAP_TYPE ( type )? ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:222:12: ^( MAP_TYPE ( type )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            MAP_TYPE83=(CommonTree)match(input,MAP_TYPE,FOLLOW_MAP_TYPE_in_map_type947); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            MAP_TYPE83_tree = (CommonTree)adaptor.dupNode(MAP_TYPE83);


            root_1 = (CommonTree)adaptor.becomeRoot(MAP_TYPE83_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:222:24: ( type )?
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==BOOLEAN||LA26_0==BYTEARRAY||LA26_0==CHARARRAY||LA26_0==DOUBLE||LA26_0==FLOAT||LA26_0==INT||LA26_0==LONG||LA26_0==BAG_TYPE||LA26_0==MAP_TYPE||LA26_0==TUPLE_TYPE) ) {
                    alt26=1;
                }
                switch (alt26) {
                    case 1 :
                        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:222:24: type
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_type_in_map_type949);
                        type84=type();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, type84.getTree());


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
    // $ANTLR end "map_type"


    public static class func_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "func_clause"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:225:1: func_clause : ( ^( FUNC_REF func_name ) | ^( FUNC func_name ( func_args )? ) );
    public final AliasMasker.func_clause_return func_clause() throws RecognitionException {
        AliasMasker.func_clause_return retval = new AliasMasker.func_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FUNC_REF85=null;
        CommonTree FUNC87=null;
        AliasMasker.func_name_return func_name86 =null;

        AliasMasker.func_name_return func_name88 =null;

        AliasMasker.func_args_return func_args89 =null;


        CommonTree FUNC_REF85_tree=null;
        CommonTree FUNC87_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:226:5: ( ^( FUNC_REF func_name ) | ^( FUNC func_name ( func_args )? ) )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==FUNC_REF) ) {
                alt28=1;
            }
            else if ( (LA28_0==FUNC) ) {
                alt28=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;

            }
            switch (alt28) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:226:7: ^( FUNC_REF func_name )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FUNC_REF85=(CommonTree)match(input,FUNC_REF,FOLLOW_FUNC_REF_in_func_clause968); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FUNC_REF85_tree = (CommonTree)adaptor.dupNode(FUNC_REF85);


                    root_1 = (CommonTree)adaptor.becomeRoot(FUNC_REF85_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_name_in_func_clause970);
                    func_name86=func_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_name86.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:227:7: ^( FUNC func_name ( func_args )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FUNC87=(CommonTree)match(input,FUNC,FOLLOW_FUNC_in_func_clause982); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FUNC87_tree = (CommonTree)adaptor.dupNode(FUNC87);


                    root_1 = (CommonTree)adaptor.becomeRoot(FUNC87_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_name_in_func_clause984);
                    func_name88=func_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_name88.getTree());


                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:227:25: ( func_args )?
                    int alt27=2;
                    int LA27_0 = input.LA(1);

                    if ( (LA27_0==QUOTEDSTRING) ) {
                        alt27=1;
                    }
                    switch (alt27) {
                        case 1 :
                            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:227:25: func_args
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_func_args_in_func_clause986);
                            func_args89=func_args();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_1, func_args89.getTree());


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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:230:1: func_name : eid ( ( PERIOD | DOLLAR ) eid )* ;
    public final AliasMasker.func_name_return func_name() throws RecognitionException {
        AliasMasker.func_name_return retval = new AliasMasker.func_name_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set91=null;
        AliasMasker.eid_return eid90 =null;

        AliasMasker.eid_return eid92 =null;


        CommonTree set91_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:231:5: ( eid ( ( PERIOD | DOLLAR ) eid )* )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:231:7: eid ( ( PERIOD | DOLLAR ) eid )*
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_eid_in_func_name1003);
            eid90=eid();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, eid90.getTree());


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:231:11: ( ( PERIOD | DOLLAR ) eid )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==DOLLAR||LA29_0==PERIOD) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:231:13: ( PERIOD | DOLLAR ) eid
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    set91=(CommonTree)input.LT(1);

            	    if ( input.LA(1)==DOLLAR||input.LA(1)==PERIOD ) {
            	        input.consume();
            	        if ( state.backtracking==0 ) {
            	        set91_tree = (CommonTree)adaptor.dupNode(set91);


            	        adaptor.addChild(root_0, set91_tree);
            	        }

            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_eid_in_func_name1017);
            	    eid92=eid();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, eid92.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop29;
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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:234:1: func_args : ( QUOTEDSTRING )+ ;
    public final AliasMasker.func_args_return func_args() throws RecognitionException {
        AliasMasker.func_args_return retval = new AliasMasker.func_args_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING93=null;

        CommonTree QUOTEDSTRING93_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:235:5: ( ( QUOTEDSTRING )+ )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:235:7: ( QUOTEDSTRING )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:235:7: ( QUOTEDSTRING )+
            int cnt30=0;
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==QUOTEDSTRING) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:235:7: QUOTEDSTRING
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    QUOTEDSTRING93=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_func_args1034); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    QUOTEDSTRING93_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING93);


            	    adaptor.addChild(root_0, QUOTEDSTRING93_tree);
            	    }


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt30 >= 1 ) break loop30;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(30, input);
                        throw eee;
                }
                cnt30++;
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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:238:1: group_clause : ^( ( GROUP | COGROUP ) ( group_item )+ ( group_type )? ( partition_clause )? ) ;
    public final AliasMasker.group_clause_return group_clause() throws RecognitionException {
        AliasMasker.group_clause_return retval = new AliasMasker.group_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set94=null;
        AliasMasker.group_item_return group_item95 =null;

        AliasMasker.group_type_return group_type96 =null;

        AliasMasker.partition_clause_return partition_clause97 =null;


        CommonTree set94_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:239:5: ( ^( ( GROUP | COGROUP ) ( group_item )+ ( group_type )? ( partition_clause )? ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:239:7: ^( ( GROUP | COGROUP ) ( group_item )+ ( group_type )? ( partition_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            set94=(CommonTree)input.LT(1);

            if ( input.LA(1)==COGROUP||input.LA(1)==GROUP ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set94_tree = (CommonTree)adaptor.dupNode(set94);


                root_1 = (CommonTree)adaptor.becomeRoot(set94_tree, root_1);
                }

                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:239:30: ( group_item )+
            int cnt31=0;
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==COGROUP||LA31_0==CROSS||LA31_0==DEFINE||LA31_0==DISTINCT||LA31_0==FILTER||LA31_0==FOREACH||LA31_0==GROUP||LA31_0==JOIN||(LA31_0 >= LIMIT && LA31_0 <= LOAD)||LA31_0==MAPREDUCE||LA31_0==ORDER||LA31_0==SAMPLE||LA31_0==SPLIT||(LA31_0 >= STORE && LA31_0 <= STREAM)||LA31_0==UNION||LA31_0==IDENTIFIER) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:239:30: group_item
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_group_item_in_group_clause1061);
            	    group_item95=group_item();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, group_item95.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt31 >= 1 ) break loop31;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(31, input);
                        throw eee;
                }
                cnt31++;
            } while (true);


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:239:42: ( group_type )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==QUOTEDSTRING) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:239:42: group_type
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_group_type_in_group_clause1064);
                    group_type96=group_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, group_type96.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:239:54: ( partition_clause )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==PARTITION) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:239:54: partition_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_partition_clause_in_group_clause1067);
                    partition_clause97=partition_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, partition_clause97.getTree());


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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:242:1: group_type : QUOTEDSTRING ;
    public final AliasMasker.group_type_return group_type() throws RecognitionException {
        AliasMasker.group_type_return retval = new AliasMasker.group_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING98=null;

        CommonTree QUOTEDSTRING98_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:242:12: ( QUOTEDSTRING )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:242:14: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING98=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_group_type1079); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING98_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING98);


            adaptor.addChild(root_0, QUOTEDSTRING98_tree);
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
    // $ANTLR end "group_type"


    public static class group_item_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "group_item"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:245:1: group_item : rel ( join_group_by_clause | ALL | ANY ) ( INNER | OUTER )? ;
    public final AliasMasker.group_item_return group_item() throws RecognitionException {
        AliasMasker.group_item_return retval = new AliasMasker.group_item_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ALL101=null;
        CommonTree ANY102=null;
        CommonTree set103=null;
        AliasMasker.rel_return rel99 =null;

        AliasMasker.join_group_by_clause_return join_group_by_clause100 =null;


        CommonTree ALL101_tree=null;
        CommonTree ANY102_tree=null;
        CommonTree set103_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:246:5: ( rel ( join_group_by_clause | ALL | ANY ) ( INNER | OUTER )? )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:246:7: rel ( join_group_by_clause | ALL | ANY ) ( INNER | OUTER )?
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_group_item1093);
            rel99=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, rel99.getTree());


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:246:11: ( join_group_by_clause | ALL | ANY )
            int alt34=3;
            switch ( input.LA(1) ) {
            case BY:
                {
                alt34=1;
                }
                break;
            case ALL:
                {
                alt34=2;
                }
                break;
            case ANY:
                {
                alt34=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;

            }

            switch (alt34) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:246:13: join_group_by_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_group_by_clause_in_group_item1097);
                    join_group_by_clause100=join_group_by_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, join_group_by_clause100.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:246:36: ALL
                    {
                    _last = (CommonTree)input.LT(1);
                    ALL101=(CommonTree)match(input,ALL,FOLLOW_ALL_in_group_item1101); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ALL101_tree = (CommonTree)adaptor.dupNode(ALL101);


                    adaptor.addChild(root_0, ALL101_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:246:42: ANY
                    {
                    _last = (CommonTree)input.LT(1);
                    ANY102=(CommonTree)match(input,ANY,FOLLOW_ANY_in_group_item1105); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ANY102_tree = (CommonTree)adaptor.dupNode(ANY102);


                    adaptor.addChild(root_0, ANY102_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:246:48: ( INNER | OUTER )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==INNER||LA35_0==OUTER) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:
                    {
                    _last = (CommonTree)input.LT(1);
                    set103=(CommonTree)input.LT(1);

                    if ( input.LA(1)==INNER||input.LA(1)==OUTER ) {
                        input.consume();
                        if ( state.backtracking==0 ) {
                        set103_tree = (CommonTree)adaptor.dupNode(set103);


                        adaptor.addChild(root_0, set103_tree);
                        }

                        state.errorRecovery=false;
                        state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:249:1: rel : ( alias | ( op_clause ( parallel_clause )? ) );
    public final AliasMasker.rel_return rel() throws RecognitionException {
        AliasMasker.rel_return retval = new AliasMasker.rel_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.alias_return alias104 =null;

        AliasMasker.op_clause_return op_clause105 =null;

        AliasMasker.parallel_clause_return parallel_clause106 =null;



        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:250:5: ( alias | ( op_clause ( parallel_clause )? ) )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==IDENTIFIER) ) {
                alt37=1;
            }
            else if ( (LA37_0==COGROUP||LA37_0==CROSS||LA37_0==DEFINE||LA37_0==DISTINCT||LA37_0==FILTER||LA37_0==FOREACH||LA37_0==GROUP||LA37_0==JOIN||(LA37_0 >= LIMIT && LA37_0 <= LOAD)||LA37_0==MAPREDUCE||LA37_0==ORDER||LA37_0==SAMPLE||LA37_0==SPLIT||(LA37_0 >= STORE && LA37_0 <= STREAM)||LA37_0==UNION) ) {
                alt37=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;

            }
            switch (alt37) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:250:7: alias
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_alias_in_rel1132);
                    alias104=alias();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, alias104.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:250:15: ( op_clause ( parallel_clause )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:250:15: ( op_clause ( parallel_clause )? )
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:250:17: op_clause ( parallel_clause )?
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_op_clause_in_rel1138);
                    op_clause105=op_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, op_clause105.getTree());


                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:250:27: ( parallel_clause )?
                    int alt36=2;
                    int LA36_0 = input.LA(1);

                    if ( (LA36_0==PARALLEL) ) {
                        alt36=1;
                    }
                    switch (alt36) {
                        case 1 :
                            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:250:27: parallel_clause
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_parallel_clause_in_rel1140);
                            parallel_clause106=parallel_clause();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_0, parallel_clause106.getTree());


                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:253:1: flatten_generated_item : ( flatten_clause | col_range | expr | STAR ) ( field_def_list )? ;
    public final AliasMasker.flatten_generated_item_return flatten_generated_item() throws RecognitionException {
        AliasMasker.flatten_generated_item_return retval = new AliasMasker.flatten_generated_item_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR110=null;
        AliasMasker.flatten_clause_return flatten_clause107 =null;

        AliasMasker.col_range_return col_range108 =null;

        AliasMasker.expr_return expr109 =null;

        AliasMasker.field_def_list_return field_def_list111 =null;


        CommonTree STAR110_tree=null;


        	inAsOrGenClause = true;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:260:5: ( ( flatten_clause | col_range | expr | STAR ) ( field_def_list )? )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:260:7: ( flatten_clause | col_range | expr | STAR ) ( field_def_list )?
            {
            root_0 = (CommonTree)adaptor.nil();


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:260:7: ( flatten_clause | col_range | expr | STAR )
            int alt38=4;
            switch ( input.LA(1) ) {
            case FLATTEN:
                {
                alt38=1;
                }
                break;
            case COL_RANGE:
                {
                alt38=2;
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
                alt38=3;
                }
                break;
            case STAR:
                {
                int LA38_4 = input.LA(2);

                if ( (LA38_4==DOWN) ) {
                    alt38=3;
                }
                else if ( (LA38_4==EOF||LA38_4==UP||LA38_4==DIV||LA38_4==DOLLARVAR||LA38_4==DOUBLENUMBER||LA38_4==FALSE||LA38_4==FLATTEN||LA38_4==FLOATNUMBER||LA38_4==GROUP||LA38_4==INTEGER||LA38_4==LONGINTEGER||LA38_4==MINUS||LA38_4==PERCENT||LA38_4==PLUS||LA38_4==QUOTEDSTRING||LA38_4==STAR||LA38_4==TRUE||(LA38_4 >= BAG_VAL && LA38_4 <= BIN_EXPR)||(LA38_4 >= CAST_EXPR && LA38_4 <= FIELD_DEF)||LA38_4==FUNC_EVAL||LA38_4==IDENTIFIER||(LA38_4 >= MAP_VAL && LA38_4 <= NEG)||LA38_4==NULL||LA38_4==TUPLE_VAL) ) {
                    alt38=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 38, 4, input);

                    throw nvae;

                }
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:260:9: flatten_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_flatten_clause_in_flatten_generated_item1169);
                    flatten_clause107=flatten_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, flatten_clause107.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:260:26: col_range
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_flatten_generated_item1173);
                    col_range108=col_range();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range108.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:260:38: expr
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_flatten_generated_item1177);
                    expr109=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expr109.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:260:45: STAR
                    {
                    _last = (CommonTree)input.LT(1);
                    STAR110=(CommonTree)match(input,STAR,FOLLOW_STAR_in_flatten_generated_item1181); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR110_tree = (CommonTree)adaptor.dupNode(STAR110);


                    adaptor.addChild(root_0, STAR110_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:260:52: ( field_def_list )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==FIELD_DEF) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:260:52: field_def_list
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_field_def_list_in_flatten_generated_item1185);
                    field_def_list111=field_def_list();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, field_def_list111.getTree());


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

            if ( state.backtracking==0 ) {
            	inAsOrGenClause = false;
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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:263:1: flatten_clause : ^( FLATTEN expr ) ;
    public final AliasMasker.flatten_clause_return flatten_clause() throws RecognitionException {
        AliasMasker.flatten_clause_return retval = new AliasMasker.flatten_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FLATTEN112=null;
        AliasMasker.expr_return expr113 =null;


        CommonTree FLATTEN112_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:264:5: ( ^( FLATTEN expr ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:264:7: ^( FLATTEN expr )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FLATTEN112=(CommonTree)match(input,FLATTEN,FOLLOW_FLATTEN_in_flatten_clause1202); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FLATTEN112_tree = (CommonTree)adaptor.dupNode(FLATTEN112);


            root_1 = (CommonTree)adaptor.becomeRoot(FLATTEN112_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expr_in_flatten_clause1204);
            expr113=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, expr113.getTree());


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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:267:1: store_clause : ^( STORE alias filename ( func_clause )? ) ;
    public final AliasMasker.store_clause_return store_clause() throws RecognitionException {
        AliasMasker.store_clause_return retval = new AliasMasker.store_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STORE114=null;
        AliasMasker.alias_return alias115 =null;

        AliasMasker.filename_return filename116 =null;

        AliasMasker.func_clause_return func_clause117 =null;


        CommonTree STORE114_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:268:5: ( ^( STORE alias filename ( func_clause )? ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:268:7: ^( STORE alias filename ( func_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            STORE114=(CommonTree)match(input,STORE,FOLLOW_STORE_in_store_clause1222); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STORE114_tree = (CommonTree)adaptor.dupNode(STORE114);


            root_1 = (CommonTree)adaptor.becomeRoot(STORE114_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_alias_in_store_clause1224);
            alias115=alias();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, alias115.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_filename_in_store_clause1226);
            filename116=filename();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, filename116.getTree());


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:268:31: ( func_clause )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==FUNC||LA40_0==FUNC_REF) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:268:31: func_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_store_clause1228);
                    func_clause117=func_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause117.getTree());


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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:271:1: filter_clause : ^( FILTER rel cond ) ;
    public final AliasMasker.filter_clause_return filter_clause() throws RecognitionException {
        AliasMasker.filter_clause_return retval = new AliasMasker.filter_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FILTER118=null;
        AliasMasker.rel_return rel119 =null;

        AliasMasker.cond_return cond120 =null;


        CommonTree FILTER118_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:272:5: ( ^( FILTER rel cond ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:272:7: ^( FILTER rel cond )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FILTER118=(CommonTree)match(input,FILTER,FOLLOW_FILTER_in_filter_clause1247); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FILTER118_tree = (CommonTree)adaptor.dupNode(FILTER118);


            root_1 = (CommonTree)adaptor.becomeRoot(FILTER118_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_filter_clause1249);
            rel119=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel119.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_filter_clause1251);
            cond120=cond();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond120.getTree());


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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:275:1: cond : ( ^( OR cond cond ) | ^( AND cond cond ) | ^( NOT cond ) | ^( NULL expr ( NOT )? ) | ^( rel_op expr expr ) | func_eval );
    public final AliasMasker.cond_return cond() throws RecognitionException {
        AliasMasker.cond_return retval = new AliasMasker.cond_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree OR121=null;
        CommonTree AND124=null;
        CommonTree NOT127=null;
        CommonTree NULL129=null;
        CommonTree NOT131=null;
        AliasMasker.cond_return cond122 =null;

        AliasMasker.cond_return cond123 =null;

        AliasMasker.cond_return cond125 =null;

        AliasMasker.cond_return cond126 =null;

        AliasMasker.cond_return cond128 =null;

        AliasMasker.expr_return expr130 =null;

        AliasMasker.rel_op_return rel_op132 =null;

        AliasMasker.expr_return expr133 =null;

        AliasMasker.expr_return expr134 =null;

        AliasMasker.func_eval_return func_eval135 =null;


        CommonTree OR121_tree=null;
        CommonTree AND124_tree=null;
        CommonTree NOT127_tree=null;
        CommonTree NULL129_tree=null;
        CommonTree NOT131_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:276:5: ( ^( OR cond cond ) | ^( AND cond cond ) | ^( NOT cond ) | ^( NULL expr ( NOT )? ) | ^( rel_op expr expr ) | func_eval )
            int alt42=6;
            switch ( input.LA(1) ) {
            case OR:
                {
                alt42=1;
                }
                break;
            case AND:
                {
                alt42=2;
                }
                break;
            case NOT:
                {
                alt42=3;
                }
                break;
            case NULL:
                {
                alt42=4;
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
                alt42=5;
                }
                break;
            case FUNC_EVAL:
                {
                alt42=6;
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:276:7: ^( OR cond cond )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    OR121=(CommonTree)match(input,OR,FOLLOW_OR_in_cond1269); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OR121_tree = (CommonTree)adaptor.dupNode(OR121);


                    root_1 = (CommonTree)adaptor.becomeRoot(OR121_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond1271);
                    cond122=cond();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cond122.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond1273);
                    cond123=cond();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cond123.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:277:7: ^( AND cond cond )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    AND124=(CommonTree)match(input,AND,FOLLOW_AND_in_cond1285); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    AND124_tree = (CommonTree)adaptor.dupNode(AND124);


                    root_1 = (CommonTree)adaptor.becomeRoot(AND124_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond1287);
                    cond125=cond();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cond125.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond1289);
                    cond126=cond();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cond126.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:278:7: ^( NOT cond )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NOT127=(CommonTree)match(input,NOT,FOLLOW_NOT_in_cond1301); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NOT127_tree = (CommonTree)adaptor.dupNode(NOT127);


                    root_1 = (CommonTree)adaptor.becomeRoot(NOT127_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond1303);
                    cond128=cond();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cond128.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:279:7: ^( NULL expr ( NOT )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NULL129=(CommonTree)match(input,NULL,FOLLOW_NULL_in_cond1315); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NULL129_tree = (CommonTree)adaptor.dupNode(NULL129);


                    root_1 = (CommonTree)adaptor.becomeRoot(NULL129_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond1317);
                    expr130=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr130.getTree());


                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:279:20: ( NOT )?
                    int alt41=2;
                    int LA41_0 = input.LA(1);

                    if ( (LA41_0==NOT) ) {
                        alt41=1;
                    }
                    switch (alt41) {
                        case 1 :
                            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:279:20: NOT
                            {
                            _last = (CommonTree)input.LT(1);
                            NOT131=(CommonTree)match(input,NOT,FOLLOW_NOT_in_cond1319); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            NOT131_tree = (CommonTree)adaptor.dupNode(NOT131);


                            adaptor.addChild(root_1, NOT131_tree);
                            }


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
                    break;
                case 5 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:280:7: ^( rel_op expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_in_cond1332);
                    rel_op132=rel_op();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_1 = (CommonTree)adaptor.becomeRoot(rel_op132.getTree(), root_1);


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond1334);
                    expr133=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr133.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond1336);
                    expr134=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr134.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:281:7: func_eval
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_eval_in_cond1346);
                    func_eval135=func_eval();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, func_eval135.getTree());


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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:284:1: func_eval : ^( FUNC_EVAL func_name ( real_arg )* ) ;
    public final AliasMasker.func_eval_return func_eval() throws RecognitionException {
        AliasMasker.func_eval_return retval = new AliasMasker.func_eval_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FUNC_EVAL136=null;
        AliasMasker.func_name_return func_name137 =null;

        AliasMasker.real_arg_return real_arg138 =null;


        CommonTree FUNC_EVAL136_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:285:5: ( ^( FUNC_EVAL func_name ( real_arg )* ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:285:7: ^( FUNC_EVAL func_name ( real_arg )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FUNC_EVAL136=(CommonTree)match(input,FUNC_EVAL,FOLLOW_FUNC_EVAL_in_func_eval1361); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FUNC_EVAL136_tree = (CommonTree)adaptor.dupNode(FUNC_EVAL136);


            root_1 = (CommonTree)adaptor.becomeRoot(FUNC_EVAL136_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_func_name_in_func_eval1363);
            func_name137=func_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, func_name137.getTree());


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:285:30: ( real_arg )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==DIV||LA43_0==DOLLARVAR||LA43_0==DOUBLENUMBER||LA43_0==FALSE||LA43_0==FLOATNUMBER||LA43_0==GROUP||LA43_0==INTEGER||LA43_0==LONGINTEGER||LA43_0==MINUS||LA43_0==PERCENT||LA43_0==PLUS||LA43_0==QUOTEDSTRING||LA43_0==STAR||LA43_0==TRUE||(LA43_0 >= BAG_VAL && LA43_0 <= BIN_EXPR)||LA43_0==CAST_EXPR||LA43_0==EXPR_IN_PAREN||LA43_0==FUNC_EVAL||LA43_0==IDENTIFIER||(LA43_0 >= MAP_VAL && LA43_0 <= NEG)||LA43_0==NULL||LA43_0==TUPLE_VAL) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:285:30: real_arg
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_real_arg_in_func_eval1365);
            	    real_arg138=real_arg();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, real_arg138.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop43;
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
    // $ANTLR end "func_eval"


    public static class real_arg_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "real_arg"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:288:1: real_arg : ( expr | STAR );
    public final AliasMasker.real_arg_return real_arg() throws RecognitionException {
        AliasMasker.real_arg_return retval = new AliasMasker.real_arg_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR140=null;
        AliasMasker.expr_return expr139 =null;


        CommonTree STAR140_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:289:5: ( expr | STAR )
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==DIV||LA44_0==DOLLARVAR||LA44_0==DOUBLENUMBER||LA44_0==FALSE||LA44_0==FLOATNUMBER||LA44_0==GROUP||LA44_0==INTEGER||LA44_0==LONGINTEGER||LA44_0==MINUS||LA44_0==PERCENT||LA44_0==PLUS||LA44_0==QUOTEDSTRING||LA44_0==TRUE||(LA44_0 >= BAG_VAL && LA44_0 <= BIN_EXPR)||LA44_0==CAST_EXPR||LA44_0==EXPR_IN_PAREN||LA44_0==FUNC_EVAL||LA44_0==IDENTIFIER||(LA44_0 >= MAP_VAL && LA44_0 <= NEG)||LA44_0==NULL||LA44_0==TUPLE_VAL) ) {
                alt44=1;
            }
            else if ( (LA44_0==STAR) ) {
                int LA44_2 = input.LA(2);

                if ( (LA44_2==DOWN) ) {
                    alt44=1;
                }
                else if ( (LA44_2==EOF||LA44_2==UP||LA44_2==DIV||LA44_2==DOLLARVAR||LA44_2==DOUBLENUMBER||LA44_2==FALSE||LA44_2==FLOATNUMBER||LA44_2==GROUP||LA44_2==INTEGER||LA44_2==LONGINTEGER||LA44_2==MINUS||LA44_2==PERCENT||LA44_2==PLUS||LA44_2==QUOTEDSTRING||LA44_2==STAR||LA44_2==TRUE||(LA44_2 >= BAG_VAL && LA44_2 <= BIN_EXPR)||LA44_2==CAST_EXPR||LA44_2==EXPR_IN_PAREN||LA44_2==FUNC_EVAL||LA44_2==IDENTIFIER||(LA44_2 >= MAP_VAL && LA44_2 <= NEG)||LA44_2==NULL||LA44_2==TUPLE_VAL) ) {
                    alt44=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 44, 2, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;

            }
            switch (alt44) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:289:7: expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_real_arg1382);
                    expr139=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expr139.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:289:14: STAR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR140=(CommonTree)match(input,STAR,FOLLOW_STAR_in_real_arg1386); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR140_tree = (CommonTree)adaptor.dupNode(STAR140);


                    adaptor.addChild(root_0, STAR140_tree);
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
    // $ANTLR end "real_arg"


    public static class expr_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "expr"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:292:1: expr : ( ^( PLUS expr expr ) | ^( MINUS expr expr ) | ^( STAR expr expr ) | ^( DIV expr expr ) | ^( PERCENT expr expr ) | ^( CAST_EXPR type expr ) | const_expr | var_expr | ^( NEG expr ) | ^( CAST_EXPR type_cast expr ) | ^( EXPR_IN_PAREN expr ) );
    public final AliasMasker.expr_return expr() throws RecognitionException {
        AliasMasker.expr_return retval = new AliasMasker.expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PLUS141=null;
        CommonTree MINUS144=null;
        CommonTree STAR147=null;
        CommonTree DIV150=null;
        CommonTree PERCENT153=null;
        CommonTree CAST_EXPR156=null;
        CommonTree NEG161=null;
        CommonTree CAST_EXPR163=null;
        CommonTree EXPR_IN_PAREN166=null;
        AliasMasker.expr_return expr142 =null;

        AliasMasker.expr_return expr143 =null;

        AliasMasker.expr_return expr145 =null;

        AliasMasker.expr_return expr146 =null;

        AliasMasker.expr_return expr148 =null;

        AliasMasker.expr_return expr149 =null;

        AliasMasker.expr_return expr151 =null;

        AliasMasker.expr_return expr152 =null;

        AliasMasker.expr_return expr154 =null;

        AliasMasker.expr_return expr155 =null;

        AliasMasker.type_return type157 =null;

        AliasMasker.expr_return expr158 =null;

        AliasMasker.const_expr_return const_expr159 =null;

        AliasMasker.var_expr_return var_expr160 =null;

        AliasMasker.expr_return expr162 =null;

        AliasMasker.type_cast_return type_cast164 =null;

        AliasMasker.expr_return expr165 =null;

        AliasMasker.expr_return expr167 =null;


        CommonTree PLUS141_tree=null;
        CommonTree MINUS144_tree=null;
        CommonTree STAR147_tree=null;
        CommonTree DIV150_tree=null;
        CommonTree PERCENT153_tree=null;
        CommonTree CAST_EXPR156_tree=null;
        CommonTree NEG161_tree=null;
        CommonTree CAST_EXPR163_tree=null;
        CommonTree EXPR_IN_PAREN166_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:293:5: ( ^( PLUS expr expr ) | ^( MINUS expr expr ) | ^( STAR expr expr ) | ^( DIV expr expr ) | ^( PERCENT expr expr ) | ^( CAST_EXPR type expr ) | const_expr | var_expr | ^( NEG expr ) | ^( CAST_EXPR type_cast expr ) | ^( EXPR_IN_PAREN expr ) )
            int alt45=11;
            switch ( input.LA(1) ) {
            case PLUS:
                {
                alt45=1;
                }
                break;
            case MINUS:
                {
                alt45=2;
                }
                break;
            case STAR:
                {
                alt45=3;
                }
                break;
            case DIV:
                {
                alt45=4;
                }
                break;
            case PERCENT:
                {
                alt45=5;
                }
                break;
            case CAST_EXPR:
                {
                int LA45_6 = input.LA(2);

                if ( (synpred88_AliasMasker()) ) {
                    alt45=6;
                }
                else if ( (synpred92_AliasMasker()) ) {
                    alt45=10;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 45, 6, input);

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
                alt45=7;
                }
                break;
            case DOLLARVAR:
            case GROUP:
            case BIN_EXPR:
            case FUNC_EVAL:
            case IDENTIFIER:
                {
                alt45=8;
                }
                break;
            case NEG:
                {
                alt45=9;
                }
                break;
            case EXPR_IN_PAREN:
                {
                alt45=11;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;

            }

            switch (alt45) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:293:7: ^( PLUS expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    PLUS141=(CommonTree)match(input,PLUS,FOLLOW_PLUS_in_expr1402); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PLUS141_tree = (CommonTree)adaptor.dupNode(PLUS141);


                    root_1 = (CommonTree)adaptor.becomeRoot(PLUS141_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1404);
                    expr142=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr142.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1406);
                    expr143=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr143.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:294:7: ^( MINUS expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    MINUS144=(CommonTree)match(input,MINUS,FOLLOW_MINUS_in_expr1418); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MINUS144_tree = (CommonTree)adaptor.dupNode(MINUS144);


                    root_1 = (CommonTree)adaptor.becomeRoot(MINUS144_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1420);
                    expr145=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr145.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1422);
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
                case 3 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:295:7: ^( STAR expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    STAR147=(CommonTree)match(input,STAR,FOLLOW_STAR_in_expr1434); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR147_tree = (CommonTree)adaptor.dupNode(STAR147);


                    root_1 = (CommonTree)adaptor.becomeRoot(STAR147_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1436);
                    expr148=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr148.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1438);
                    expr149=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr149.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:296:7: ^( DIV expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    DIV150=(CommonTree)match(input,DIV,FOLLOW_DIV_in_expr1450); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DIV150_tree = (CommonTree)adaptor.dupNode(DIV150);


                    root_1 = (CommonTree)adaptor.becomeRoot(DIV150_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1452);
                    expr151=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr151.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1454);
                    expr152=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr152.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:297:7: ^( PERCENT expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    PERCENT153=(CommonTree)match(input,PERCENT,FOLLOW_PERCENT_in_expr1466); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PERCENT153_tree = (CommonTree)adaptor.dupNode(PERCENT153);


                    root_1 = (CommonTree)adaptor.becomeRoot(PERCENT153_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1468);
                    expr154=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr154.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1470);
                    expr155=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr155.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:298:7: ^( CAST_EXPR type expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    CAST_EXPR156=(CommonTree)match(input,CAST_EXPR,FOLLOW_CAST_EXPR_in_expr1482); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CAST_EXPR156_tree = (CommonTree)adaptor.dupNode(CAST_EXPR156);


                    root_1 = (CommonTree)adaptor.becomeRoot(CAST_EXPR156_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_type_in_expr1484);
                    type157=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, type157.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1486);
                    expr158=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr158.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:299:7: const_expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_const_expr_in_expr1496);
                    const_expr159=const_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, const_expr159.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:300:7: var_expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_var_expr_in_expr1504);
                    var_expr160=var_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, var_expr160.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:301:7: ^( NEG expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NEG161=(CommonTree)match(input,NEG,FOLLOW_NEG_in_expr1514); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NEG161_tree = (CommonTree)adaptor.dupNode(NEG161);


                    root_1 = (CommonTree)adaptor.becomeRoot(NEG161_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1516);
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
                case 10 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:302:7: ^( CAST_EXPR type_cast expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    CAST_EXPR163=(CommonTree)match(input,CAST_EXPR,FOLLOW_CAST_EXPR_in_expr1528); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CAST_EXPR163_tree = (CommonTree)adaptor.dupNode(CAST_EXPR163);


                    root_1 = (CommonTree)adaptor.becomeRoot(CAST_EXPR163_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_type_cast_in_expr1530);
                    type_cast164=type_cast();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, type_cast164.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1532);
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
                case 11 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:303:7: ^( EXPR_IN_PAREN expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    EXPR_IN_PAREN166=(CommonTree)match(input,EXPR_IN_PAREN,FOLLOW_EXPR_IN_PAREN_in_expr1544); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EXPR_IN_PAREN166_tree = (CommonTree)adaptor.dupNode(EXPR_IN_PAREN166);


                    root_1 = (CommonTree)adaptor.becomeRoot(EXPR_IN_PAREN166_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1546);
                    expr167=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr167.getTree());


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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:306:1: type_cast : ( simple_type | map_type | tuple_type_cast | bag_type_cast );
    public final AliasMasker.type_cast_return type_cast() throws RecognitionException {
        AliasMasker.type_cast_return retval = new AliasMasker.type_cast_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.simple_type_return simple_type168 =null;

        AliasMasker.map_type_return map_type169 =null;

        AliasMasker.tuple_type_cast_return tuple_type_cast170 =null;

        AliasMasker.bag_type_cast_return bag_type_cast171 =null;



        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:307:5: ( simple_type | map_type | tuple_type_cast | bag_type_cast )
            int alt46=4;
            switch ( input.LA(1) ) {
            case BOOLEAN:
            case BYTEARRAY:
            case CHARARRAY:
            case DOUBLE:
            case FLOAT:
            case INT:
            case LONG:
                {
                alt46=1;
                }
                break;
            case MAP_TYPE:
                {
                alt46=2;
                }
                break;
            case TUPLE_TYPE_CAST:
                {
                alt46=3;
                }
                break;
            case BAG_TYPE_CAST:
                {
                alt46=4;
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:307:7: simple_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_simple_type_in_type_cast1562);
                    simple_type168=simple_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, simple_type168.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:307:21: map_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_map_type_in_type_cast1566);
                    map_type169=map_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, map_type169.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:307:32: tuple_type_cast
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_tuple_type_cast_in_type_cast1570);
                    tuple_type_cast170=tuple_type_cast();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, tuple_type_cast170.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:307:50: bag_type_cast
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_bag_type_cast_in_type_cast1574);
                    bag_type_cast171=bag_type_cast();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, bag_type_cast171.getTree());


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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:310:1: tuple_type_cast : ^( TUPLE_TYPE_CAST ( type_cast )* ) ;
    public final AliasMasker.tuple_type_cast_return tuple_type_cast() throws RecognitionException {
        AliasMasker.tuple_type_cast_return retval = new AliasMasker.tuple_type_cast_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree TUPLE_TYPE_CAST172=null;
        AliasMasker.type_cast_return type_cast173 =null;


        CommonTree TUPLE_TYPE_CAST172_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:311:5: ( ^( TUPLE_TYPE_CAST ( type_cast )* ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:311:7: ^( TUPLE_TYPE_CAST ( type_cast )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            TUPLE_TYPE_CAST172=(CommonTree)match(input,TUPLE_TYPE_CAST,FOLLOW_TUPLE_TYPE_CAST_in_tuple_type_cast1590); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            TUPLE_TYPE_CAST172_tree = (CommonTree)adaptor.dupNode(TUPLE_TYPE_CAST172);


            root_1 = (CommonTree)adaptor.becomeRoot(TUPLE_TYPE_CAST172_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:311:26: ( type_cast )*
                loop47:
                do {
                    int alt47=2;
                    int LA47_0 = input.LA(1);

                    if ( (LA47_0==BOOLEAN||LA47_0==BYTEARRAY||LA47_0==CHARARRAY||LA47_0==DOUBLE||LA47_0==FLOAT||LA47_0==INT||LA47_0==LONG||LA47_0==BAG_TYPE_CAST||LA47_0==MAP_TYPE||LA47_0==TUPLE_TYPE_CAST) ) {
                        alt47=1;
                    }


                    switch (alt47) {
                	case 1 :
                	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:311:26: type_cast
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_type_cast_in_tuple_type_cast1592);
                	    type_cast173=type_cast();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, type_cast173.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop47;
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
    // $ANTLR end "tuple_type_cast"


    public static class bag_type_cast_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "bag_type_cast"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:314:1: bag_type_cast : ^( BAG_TYPE_CAST ( tuple_type_cast )? ) ;
    public final AliasMasker.bag_type_cast_return bag_type_cast() throws RecognitionException {
        AliasMasker.bag_type_cast_return retval = new AliasMasker.bag_type_cast_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BAG_TYPE_CAST174=null;
        AliasMasker.tuple_type_cast_return tuple_type_cast175 =null;


        CommonTree BAG_TYPE_CAST174_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:315:5: ( ^( BAG_TYPE_CAST ( tuple_type_cast )? ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:315:7: ^( BAG_TYPE_CAST ( tuple_type_cast )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BAG_TYPE_CAST174=(CommonTree)match(input,BAG_TYPE_CAST,FOLLOW_BAG_TYPE_CAST_in_bag_type_cast1611); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BAG_TYPE_CAST174_tree = (CommonTree)adaptor.dupNode(BAG_TYPE_CAST174);


            root_1 = (CommonTree)adaptor.becomeRoot(BAG_TYPE_CAST174_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:315:24: ( tuple_type_cast )?
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==TUPLE_TYPE_CAST) ) {
                    alt48=1;
                }
                switch (alt48) {
                    case 1 :
                        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:315:24: tuple_type_cast
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_tuple_type_cast_in_bag_type_cast1613);
                        tuple_type_cast175=tuple_type_cast();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, tuple_type_cast175.getTree());


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
    // $ANTLR end "bag_type_cast"


    public static class var_expr_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "var_expr"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:318:1: var_expr : projectable_expr ( dot_proj | pound_proj )* ;
    public final AliasMasker.var_expr_return var_expr() throws RecognitionException {
        AliasMasker.var_expr_return retval = new AliasMasker.var_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.projectable_expr_return projectable_expr176 =null;

        AliasMasker.dot_proj_return dot_proj177 =null;

        AliasMasker.pound_proj_return pound_proj178 =null;



        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:319:5: ( projectable_expr ( dot_proj | pound_proj )* )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:319:7: projectable_expr ( dot_proj | pound_proj )*
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_projectable_expr_in_var_expr1630);
            projectable_expr176=projectable_expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, projectable_expr176.getTree());


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:319:24: ( dot_proj | pound_proj )*
            loop49:
            do {
                int alt49=3;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==PERIOD) ) {
                    alt49=1;
                }
                else if ( (LA49_0==POUND) ) {
                    alt49=2;
                }


                switch (alt49) {
            	case 1 :
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:319:26: dot_proj
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_dot_proj_in_var_expr1634);
            	    dot_proj177=dot_proj();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, dot_proj177.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;
            	case 2 :
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:319:37: pound_proj
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_pound_proj_in_var_expr1638);
            	    pound_proj178=pound_proj();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, pound_proj178.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop49;
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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:322:1: projectable_expr : ( func_eval | col_ref | bin_expr );
    public final AliasMasker.projectable_expr_return projectable_expr() throws RecognitionException {
        AliasMasker.projectable_expr_return retval = new AliasMasker.projectable_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.func_eval_return func_eval179 =null;

        AliasMasker.col_ref_return col_ref180 =null;

        AliasMasker.bin_expr_return bin_expr181 =null;



        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:323:5: ( func_eval | col_ref | bin_expr )
            int alt50=3;
            switch ( input.LA(1) ) {
            case FUNC_EVAL:
                {
                alt50=1;
                }
                break;
            case DOLLARVAR:
            case GROUP:
            case IDENTIFIER:
                {
                alt50=2;
                }
                break;
            case BIN_EXPR:
                {
                alt50=3;
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:323:7: func_eval
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_eval_in_projectable_expr1654);
                    func_eval179=func_eval();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, func_eval179.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:323:19: col_ref
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_projectable_expr1658);
                    col_ref180=col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_ref180.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:323:29: bin_expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_bin_expr_in_projectable_expr1662);
                    bin_expr181=bin_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, bin_expr181.getTree());


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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:326:1: dot_proj : ^( PERIOD ( col_alias_or_index )+ ) ;
    public final AliasMasker.dot_proj_return dot_proj() throws RecognitionException {
        AliasMasker.dot_proj_return retval = new AliasMasker.dot_proj_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PERIOD182=null;
        AliasMasker.col_alias_or_index_return col_alias_or_index183 =null;


        CommonTree PERIOD182_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:327:5: ( ^( PERIOD ( col_alias_or_index )+ ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:327:7: ^( PERIOD ( col_alias_or_index )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            PERIOD182=(CommonTree)match(input,PERIOD,FOLLOW_PERIOD_in_dot_proj1678); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PERIOD182_tree = (CommonTree)adaptor.dupNode(PERIOD182);


            root_1 = (CommonTree)adaptor.becomeRoot(PERIOD182_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:327:17: ( col_alias_or_index )+
            int cnt51=0;
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==DOLLARVAR||LA51_0==GROUP||LA51_0==IDENTIFIER) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:327:17: col_alias_or_index
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_col_alias_or_index_in_dot_proj1680);
            	    col_alias_or_index183=col_alias_or_index();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, col_alias_or_index183.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt51 >= 1 ) break loop51;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(51, input);
                        throw eee;
                }
                cnt51++;
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
    // $ANTLR end "dot_proj"


    public static class col_alias_or_index_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "col_alias_or_index"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:330:1: col_alias_or_index : ( col_alias | col_index );
    public final AliasMasker.col_alias_or_index_return col_alias_or_index() throws RecognitionException {
        AliasMasker.col_alias_or_index_return retval = new AliasMasker.col_alias_or_index_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.col_alias_return col_alias184 =null;

        AliasMasker.col_index_return col_index185 =null;



        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:330:20: ( col_alias | col_index )
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==GROUP||LA52_0==IDENTIFIER) ) {
                alt52=1;
            }
            else if ( (LA52_0==DOLLARVAR) ) {
                alt52=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;

            }
            switch (alt52) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:330:22: col_alias
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_alias_in_col_alias_or_index1692);
                    col_alias184=col_alias();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_alias184.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:330:34: col_index
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_index_in_col_alias_or_index1696);
                    col_index185=col_index();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_index185.getTree());


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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:333:1: col_alias : ( GROUP | IDENTIFIER );
    public final AliasMasker.col_alias_return col_alias() throws RecognitionException {
        AliasMasker.col_alias_return retval = new AliasMasker.col_alias_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set186=null;

        CommonTree set186_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:334:5: ( GROUP | IDENTIFIER )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set186=(CommonTree)input.LT(1);

            if ( input.LA(1)==GROUP||input.LA(1)==IDENTIFIER ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set186_tree = (CommonTree)adaptor.dupNode(set186);


                adaptor.addChild(root_0, set186_tree);
                }

                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
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
    // $ANTLR end "col_alias"


    public static class col_index_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "col_index"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:338:1: col_index : DOLLARVAR ;
    public final AliasMasker.col_index_return col_index() throws RecognitionException {
        AliasMasker.col_index_return retval = new AliasMasker.col_index_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DOLLARVAR187=null;

        CommonTree DOLLARVAR187_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:339:5: ( DOLLARVAR )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:339:7: DOLLARVAR
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            DOLLARVAR187=(CommonTree)match(input,DOLLARVAR,FOLLOW_DOLLARVAR_in_col_index1733); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DOLLARVAR187_tree = (CommonTree)adaptor.dupNode(DOLLARVAR187);


            adaptor.addChild(root_0, DOLLARVAR187_tree);
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
    // $ANTLR end "col_index"


    public static class col_range_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "col_range"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:342:1: col_range : ^( COL_RANGE ( col_ref )? DOUBLE_PERIOD ( col_ref )? ) ;
    public final AliasMasker.col_range_return col_range() throws RecognitionException {
        AliasMasker.col_range_return retval = new AliasMasker.col_range_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree COL_RANGE188=null;
        CommonTree DOUBLE_PERIOD190=null;
        AliasMasker.col_ref_return col_ref189 =null;

        AliasMasker.col_ref_return col_ref191 =null;


        CommonTree COL_RANGE188_tree=null;
        CommonTree DOUBLE_PERIOD190_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:342:11: ( ^( COL_RANGE ( col_ref )? DOUBLE_PERIOD ( col_ref )? ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:342:14: ^( COL_RANGE ( col_ref )? DOUBLE_PERIOD ( col_ref )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            COL_RANGE188=(CommonTree)match(input,COL_RANGE,FOLLOW_COL_RANGE_in_col_range1744); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            COL_RANGE188_tree = (CommonTree)adaptor.dupNode(COL_RANGE188);


            root_1 = (CommonTree)adaptor.becomeRoot(COL_RANGE188_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:342:26: ( col_ref )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==DOLLARVAR||LA53_0==GROUP||LA53_0==IDENTIFIER) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:342:26: col_ref
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_col_range1746);
                    col_ref189=col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, col_ref189.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            DOUBLE_PERIOD190=(CommonTree)match(input,DOUBLE_PERIOD,FOLLOW_DOUBLE_PERIOD_in_col_range1749); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DOUBLE_PERIOD190_tree = (CommonTree)adaptor.dupNode(DOUBLE_PERIOD190);


            adaptor.addChild(root_1, DOUBLE_PERIOD190_tree);
            }


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:342:49: ( col_ref )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==DOLLARVAR||LA54_0==GROUP||LA54_0==IDENTIFIER) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:342:49: col_ref
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_col_range1751);
                    col_ref191=col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, col_ref191.getTree());


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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:345:1: pound_proj : ^( POUND ( QUOTEDSTRING | NULL ) ) ;
    public final AliasMasker.pound_proj_return pound_proj() throws RecognitionException {
        AliasMasker.pound_proj_return retval = new AliasMasker.pound_proj_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree POUND192=null;
        CommonTree set193=null;

        CommonTree POUND192_tree=null;
        CommonTree set193_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:346:5: ( ^( POUND ( QUOTEDSTRING | NULL ) ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:346:7: ^( POUND ( QUOTEDSTRING | NULL ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            POUND192=(CommonTree)match(input,POUND,FOLLOW_POUND_in_pound_proj1769); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            POUND192_tree = (CommonTree)adaptor.dupNode(POUND192);


            root_1 = (CommonTree)adaptor.becomeRoot(POUND192_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            set193=(CommonTree)input.LT(1);

            if ( input.LA(1)==QUOTEDSTRING||input.LA(1)==NULL ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set193_tree = (CommonTree)adaptor.dupNode(set193);


                adaptor.addChild(root_1, set193_tree);
                }

                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:349:1: bin_expr : ^( BIN_EXPR cond expr expr ) ;
    public final AliasMasker.bin_expr_return bin_expr() throws RecognitionException {
        AliasMasker.bin_expr_return retval = new AliasMasker.bin_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BIN_EXPR194=null;
        AliasMasker.cond_return cond195 =null;

        AliasMasker.expr_return expr196 =null;

        AliasMasker.expr_return expr197 =null;


        CommonTree BIN_EXPR194_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:350:5: ( ^( BIN_EXPR cond expr expr ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:350:7: ^( BIN_EXPR cond expr expr )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BIN_EXPR194=(CommonTree)match(input,BIN_EXPR,FOLLOW_BIN_EXPR_in_bin_expr1797); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BIN_EXPR194_tree = (CommonTree)adaptor.dupNode(BIN_EXPR194);


            root_1 = (CommonTree)adaptor.becomeRoot(BIN_EXPR194_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_bin_expr1799);
            cond195=cond();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond195.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expr_in_bin_expr1801);
            expr196=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, expr196.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expr_in_bin_expr1803);
            expr197=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, expr197.getTree());


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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:353:1: limit_clause : ^( LIMIT rel ( INTEGER | LONGINTEGER | expr ) ) ;
    public final AliasMasker.limit_clause_return limit_clause() throws RecognitionException {
        AliasMasker.limit_clause_return retval = new AliasMasker.limit_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree LIMIT198=null;
        CommonTree INTEGER200=null;
        CommonTree LONGINTEGER201=null;
        AliasMasker.rel_return rel199 =null;

        AliasMasker.expr_return expr202 =null;


        CommonTree LIMIT198_tree=null;
        CommonTree INTEGER200_tree=null;
        CommonTree LONGINTEGER201_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:354:5: ( ^( LIMIT rel ( INTEGER | LONGINTEGER | expr ) ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:354:7: ^( LIMIT rel ( INTEGER | LONGINTEGER | expr ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            LIMIT198=(CommonTree)match(input,LIMIT,FOLLOW_LIMIT_in_limit_clause1826); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LIMIT198_tree = (CommonTree)adaptor.dupNode(LIMIT198);


            root_1 = (CommonTree)adaptor.becomeRoot(LIMIT198_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_limit_clause1828);
            rel199=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel199.getTree());


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:354:20: ( INTEGER | LONGINTEGER | expr )
            int alt55=3;
            switch ( input.LA(1) ) {
            case INTEGER:
                {
                int LA55_1 = input.LA(2);

                if ( (synpred108_AliasMasker()) ) {
                    alt55=1;
                }
                else if ( (true) ) {
                    alt55=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 55, 1, input);

                    throw nvae;

                }
                }
                break;
            case LONGINTEGER:
                {
                int LA55_2 = input.LA(2);

                if ( (synpred109_AliasMasker()) ) {
                    alt55=2;
                }
                else if ( (true) ) {
                    alt55=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 55, 2, input);

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
                alt55=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 55, 0, input);

                throw nvae;

            }

            switch (alt55) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:354:22: INTEGER
                    {
                    _last = (CommonTree)input.LT(1);
                    INTEGER200=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_limit_clause1832); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INTEGER200_tree = (CommonTree)adaptor.dupNode(INTEGER200);


                    adaptor.addChild(root_1, INTEGER200_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:354:32: LONGINTEGER
                    {
                    _last = (CommonTree)input.LT(1);
                    LONGINTEGER201=(CommonTree)match(input,LONGINTEGER,FOLLOW_LONGINTEGER_in_limit_clause1836); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LONGINTEGER201_tree = (CommonTree)adaptor.dupNode(LONGINTEGER201);


                    adaptor.addChild(root_1, LONGINTEGER201_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:354:46: expr
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_limit_clause1840);
                    expr202=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr202.getTree());


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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:357:1: sample_clause : ^( SAMPLE rel ( DOUBLENUMBER | expr ) ) ;
    public final AliasMasker.sample_clause_return sample_clause() throws RecognitionException {
        AliasMasker.sample_clause_return retval = new AliasMasker.sample_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SAMPLE203=null;
        CommonTree DOUBLENUMBER205=null;
        AliasMasker.rel_return rel204 =null;

        AliasMasker.expr_return expr206 =null;


        CommonTree SAMPLE203_tree=null;
        CommonTree DOUBLENUMBER205_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:358:5: ( ^( SAMPLE rel ( DOUBLENUMBER | expr ) ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:358:8: ^( SAMPLE rel ( DOUBLENUMBER | expr ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            SAMPLE203=(CommonTree)match(input,SAMPLE,FOLLOW_SAMPLE_in_sample_clause1861); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SAMPLE203_tree = (CommonTree)adaptor.dupNode(SAMPLE203);


            root_1 = (CommonTree)adaptor.becomeRoot(SAMPLE203_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_sample_clause1863);
            rel204=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel204.getTree());


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:358:22: ( DOUBLENUMBER | expr )
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==DOUBLENUMBER) ) {
                int LA56_1 = input.LA(2);

                if ( (synpred110_AliasMasker()) ) {
                    alt56=1;
                }
                else if ( (true) ) {
                    alt56=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 56, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA56_0==DIV||LA56_0==DOLLARVAR||LA56_0==FALSE||LA56_0==FLOATNUMBER||LA56_0==GROUP||LA56_0==INTEGER||LA56_0==LONGINTEGER||LA56_0==MINUS||LA56_0==PERCENT||LA56_0==PLUS||LA56_0==QUOTEDSTRING||LA56_0==STAR||LA56_0==TRUE||(LA56_0 >= BAG_VAL && LA56_0 <= BIN_EXPR)||LA56_0==CAST_EXPR||LA56_0==EXPR_IN_PAREN||LA56_0==FUNC_EVAL||LA56_0==IDENTIFIER||(LA56_0 >= MAP_VAL && LA56_0 <= NEG)||LA56_0==NULL||LA56_0==TUPLE_VAL) ) {
                alt56=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                throw nvae;

            }
            switch (alt56) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:358:24: DOUBLENUMBER
                    {
                    _last = (CommonTree)input.LT(1);
                    DOUBLENUMBER205=(CommonTree)match(input,DOUBLENUMBER,FOLLOW_DOUBLENUMBER_in_sample_clause1867); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DOUBLENUMBER205_tree = (CommonTree)adaptor.dupNode(DOUBLENUMBER205);


                    adaptor.addChild(root_1, DOUBLENUMBER205_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:358:39: expr
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_sample_clause1871);
                    expr206=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr206.getTree());


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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:361:1: order_clause : ^( ORDER rel order_by_clause ( func_clause )? ) ;
    public final AliasMasker.order_clause_return order_clause() throws RecognitionException {
        AliasMasker.order_clause_return retval = new AliasMasker.order_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ORDER207=null;
        AliasMasker.rel_return rel208 =null;

        AliasMasker.order_by_clause_return order_by_clause209 =null;

        AliasMasker.func_clause_return func_clause210 =null;


        CommonTree ORDER207_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:362:5: ( ^( ORDER rel order_by_clause ( func_clause )? ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:362:7: ^( ORDER rel order_by_clause ( func_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            ORDER207=(CommonTree)match(input,ORDER,FOLLOW_ORDER_in_order_clause1891); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ORDER207_tree = (CommonTree)adaptor.dupNode(ORDER207);


            root_1 = (CommonTree)adaptor.becomeRoot(ORDER207_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_order_clause1893);
            rel208=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel208.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_order_by_clause_in_order_clause1895);
            order_by_clause209=order_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, order_by_clause209.getTree());


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:362:36: ( func_clause )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==FUNC||LA57_0==FUNC_REF) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:362:36: func_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_order_clause1897);
                    func_clause210=func_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause210.getTree());


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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:365:1: order_by_clause : ( STAR ( ASC | DESC )? | ( order_col )+ );
    public final AliasMasker.order_by_clause_return order_by_clause() throws RecognitionException {
        AliasMasker.order_by_clause_return retval = new AliasMasker.order_by_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR211=null;
        CommonTree set212=null;
        AliasMasker.order_col_return order_col213 =null;


        CommonTree STAR211_tree=null;
        CommonTree set212_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:366:5: ( STAR ( ASC | DESC )? | ( order_col )+ )
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==STAR) ) {
                alt60=1;
            }
            else if ( (LA60_0==DOLLARVAR||LA60_0==GROUP||LA60_0==COL_RANGE||LA60_0==IDENTIFIER) ) {
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:366:7: STAR ( ASC | DESC )?
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR211=(CommonTree)match(input,STAR,FOLLOW_STAR_in_order_by_clause1914); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR211_tree = (CommonTree)adaptor.dupNode(STAR211);


                    adaptor.addChild(root_0, STAR211_tree);
                    }


                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:366:12: ( ASC | DESC )?
                    int alt58=2;
                    int LA58_0 = input.LA(1);

                    if ( (LA58_0==ASC||LA58_0==DESC) ) {
                        alt58=1;
                    }
                    switch (alt58) {
                        case 1 :
                            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:
                            {
                            _last = (CommonTree)input.LT(1);
                            set212=(CommonTree)input.LT(1);

                            if ( input.LA(1)==ASC||input.LA(1)==DESC ) {
                                input.consume();
                                if ( state.backtracking==0 ) {
                                set212_tree = (CommonTree)adaptor.dupNode(set212);


                                adaptor.addChild(root_0, set212_tree);
                                }

                                state.errorRecovery=false;
                                state.failed=false;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                throw mse;
                            }


                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:367:7: ( order_col )+
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:367:7: ( order_col )+
                    int cnt59=0;
                    loop59:
                    do {
                        int alt59=2;
                        int LA59_0 = input.LA(1);

                        if ( (LA59_0==DOLLARVAR||LA59_0==GROUP||LA59_0==COL_RANGE||LA59_0==IDENTIFIER) ) {
                            alt59=1;
                        }


                        switch (alt59) {
                    	case 1 :
                    	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:367:7: order_col
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_order_col_in_order_by_clause1933);
                    	    order_col213=order_col();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, order_col213.getTree());


                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    if ( cnt59 >= 1 ) break loop59;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(59, input);
                                throw eee;
                        }
                        cnt59++;
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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:370:1: order_col : ( col_range | col_ref ) ( ASC | DESC )? ;
    public final AliasMasker.order_col_return order_col() throws RecognitionException {
        AliasMasker.order_col_return retval = new AliasMasker.order_col_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set216=null;
        AliasMasker.col_range_return col_range214 =null;

        AliasMasker.col_ref_return col_ref215 =null;


        CommonTree set216_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:371:5: ( ( col_range | col_ref ) ( ASC | DESC )? )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:371:7: ( col_range | col_ref ) ( ASC | DESC )?
            {
            root_0 = (CommonTree)adaptor.nil();


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:371:7: ( col_range | col_ref )
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==COL_RANGE) ) {
                alt61=1;
            }
            else if ( (LA61_0==DOLLARVAR||LA61_0==GROUP||LA61_0==IDENTIFIER) ) {
                alt61=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 61, 0, input);

                throw nvae;

            }
            switch (alt61) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:371:8: col_range
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_order_col1949);
                    col_range214=col_range();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range214.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:371:20: col_ref
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_order_col1953);
                    col_ref215=col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_ref215.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:371:29: ( ASC | DESC )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==ASC||LA62_0==DESC) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:
                    {
                    _last = (CommonTree)input.LT(1);
                    set216=(CommonTree)input.LT(1);

                    if ( input.LA(1)==ASC||input.LA(1)==DESC ) {
                        input.consume();
                        if ( state.backtracking==0 ) {
                        set216_tree = (CommonTree)adaptor.dupNode(set216);


                        adaptor.addChild(root_0, set216_tree);
                        }

                        state.errorRecovery=false;
                        state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:374:1: distinct_clause : ^( DISTINCT rel ( partition_clause )? ) ;
    public final AliasMasker.distinct_clause_return distinct_clause() throws RecognitionException {
        AliasMasker.distinct_clause_return retval = new AliasMasker.distinct_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DISTINCT217=null;
        AliasMasker.rel_return rel218 =null;

        AliasMasker.partition_clause_return partition_clause219 =null;


        CommonTree DISTINCT217_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:375:5: ( ^( DISTINCT rel ( partition_clause )? ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:375:7: ^( DISTINCT rel ( partition_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            DISTINCT217=(CommonTree)match(input,DISTINCT,FOLLOW_DISTINCT_in_distinct_clause1985); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DISTINCT217_tree = (CommonTree)adaptor.dupNode(DISTINCT217);


            root_1 = (CommonTree)adaptor.becomeRoot(DISTINCT217_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_distinct_clause1987);
            rel218=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel218.getTree());


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:375:23: ( partition_clause )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==PARTITION) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:375:23: partition_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_partition_clause_in_distinct_clause1989);
                    partition_clause219=partition_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, partition_clause219.getTree());


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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:378:1: partition_clause : ^( PARTITION func_name ) ;
    public final AliasMasker.partition_clause_return partition_clause() throws RecognitionException {
        AliasMasker.partition_clause_return retval = new AliasMasker.partition_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PARTITION220=null;
        AliasMasker.func_name_return func_name221 =null;


        CommonTree PARTITION220_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:379:5: ( ^( PARTITION func_name ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:379:7: ^( PARTITION func_name )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            PARTITION220=(CommonTree)match(input,PARTITION,FOLLOW_PARTITION_in_partition_clause2008); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PARTITION220_tree = (CommonTree)adaptor.dupNode(PARTITION220);


            root_1 = (CommonTree)adaptor.becomeRoot(PARTITION220_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_func_name_in_partition_clause2010);
            func_name221=func_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, func_name221.getTree());


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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:382:1: cross_clause : ^( CROSS rel_list ( partition_clause )? ) ;
    public final AliasMasker.cross_clause_return cross_clause() throws RecognitionException {
        AliasMasker.cross_clause_return retval = new AliasMasker.cross_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CROSS222=null;
        AliasMasker.rel_list_return rel_list223 =null;

        AliasMasker.partition_clause_return partition_clause224 =null;


        CommonTree CROSS222_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:383:5: ( ^( CROSS rel_list ( partition_clause )? ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:383:7: ^( CROSS rel_list ( partition_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CROSS222=(CommonTree)match(input,CROSS,FOLLOW_CROSS_in_cross_clause2032); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CROSS222_tree = (CommonTree)adaptor.dupNode(CROSS222);


            root_1 = (CommonTree)adaptor.becomeRoot(CROSS222_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_list_in_cross_clause2034);
            rel_list223=rel_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel_list223.getTree());


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:383:25: ( partition_clause )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==PARTITION) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:383:25: partition_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_partition_clause_in_cross_clause2036);
                    partition_clause224=partition_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, partition_clause224.getTree());


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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:386:1: rel_list : ( rel )+ ;
    public final AliasMasker.rel_list_return rel_list() throws RecognitionException {
        AliasMasker.rel_list_return retval = new AliasMasker.rel_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.rel_return rel225 =null;



        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:387:5: ( ( rel )+ )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:387:7: ( rel )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:387:7: ( rel )+
            int cnt65=0;
            loop65:
            do {
                int alt65=2;
                int LA65_0 = input.LA(1);

                if ( (LA65_0==COGROUP||LA65_0==CROSS||LA65_0==DEFINE||LA65_0==DISTINCT||LA65_0==FILTER||LA65_0==FOREACH||LA65_0==GROUP||LA65_0==JOIN||(LA65_0 >= LIMIT && LA65_0 <= LOAD)||LA65_0==MAPREDUCE||LA65_0==ORDER||LA65_0==SAMPLE||LA65_0==SPLIT||(LA65_0 >= STORE && LA65_0 <= STREAM)||LA65_0==UNION||LA65_0==IDENTIFIER) ) {
                    alt65=1;
                }


                switch (alt65) {
            	case 1 :
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:387:7: rel
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_rel_in_rel_list2057);
            	    rel225=rel();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, rel225.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt65 >= 1 ) break loop65;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(65, input);
                        throw eee;
                }
                cnt65++;
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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:390:1: join_clause : ^( JOIN join_sub_clause ( join_type )? ( partition_clause )? ) ;
    public final AliasMasker.join_clause_return join_clause() throws RecognitionException {
        AliasMasker.join_clause_return retval = new AliasMasker.join_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree JOIN226=null;
        AliasMasker.join_sub_clause_return join_sub_clause227 =null;

        AliasMasker.join_type_return join_type228 =null;

        AliasMasker.partition_clause_return partition_clause229 =null;


        CommonTree JOIN226_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:391:5: ( ^( JOIN join_sub_clause ( join_type )? ( partition_clause )? ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:391:7: ^( JOIN join_sub_clause ( join_type )? ( partition_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            JOIN226=(CommonTree)match(input,JOIN,FOLLOW_JOIN_in_join_clause2073); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            JOIN226_tree = (CommonTree)adaptor.dupNode(JOIN226);


            root_1 = (CommonTree)adaptor.becomeRoot(JOIN226_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_join_sub_clause_in_join_clause2075);
            join_sub_clause227=join_sub_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, join_sub_clause227.getTree());


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:391:31: ( join_type )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==QUOTEDSTRING) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:391:31: join_type
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_type_in_join_clause2077);
                    join_type228=join_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, join_type228.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:391:42: ( partition_clause )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==PARTITION) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:391:42: partition_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_partition_clause_in_join_clause2080);
                    partition_clause229=partition_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, partition_clause229.getTree());


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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:394:1: join_type : QUOTEDSTRING ;
    public final AliasMasker.join_type_return join_type() throws RecognitionException {
        AliasMasker.join_type_return retval = new AliasMasker.join_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING230=null;

        CommonTree QUOTEDSTRING230_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:394:11: ( QUOTEDSTRING )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:394:13: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING230=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_join_type2092); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING230_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING230);


            adaptor.addChild(root_0, QUOTEDSTRING230_tree);
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
    // $ANTLR end "join_type"


    public static class join_sub_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "join_sub_clause"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:397:1: join_sub_clause : ( join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item | ( join_item )+ );
    public final AliasMasker.join_sub_clause_return join_sub_clause() throws RecognitionException {
        AliasMasker.join_sub_clause_return retval = new AliasMasker.join_sub_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set232=null;
        CommonTree OUTER233=null;
        AliasMasker.join_item_return join_item231 =null;

        AliasMasker.join_item_return join_item234 =null;

        AliasMasker.join_item_return join_item235 =null;


        CommonTree set232_tree=null;
        CommonTree OUTER233_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:398:5: ( join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item | ( join_item )+ )
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==JOIN_ITEM) ) {
                int LA70_1 = input.LA(2);

                if ( (synpred127_AliasMasker()) ) {
                    alt70=1;
                }
                else if ( (true) ) {
                    alt70=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 70, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 70, 0, input);

                throw nvae;

            }
            switch (alt70) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:398:7: join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_item_in_join_sub_clause2105);
                    join_item231=join_item();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, join_item231.getTree());


                    _last = (CommonTree)input.LT(1);
                    set232=(CommonTree)input.LT(1);

                    if ( input.LA(1)==FULL||input.LA(1)==LEFT||input.LA(1)==RIGHT ) {
                        input.consume();
                        if ( state.backtracking==0 ) {
                        set232_tree = (CommonTree)adaptor.dupNode(set232);


                        adaptor.addChild(root_0, set232_tree);
                        }

                        state.errorRecovery=false;
                        state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }


                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:401:16: ( OUTER )?
                    int alt68=2;
                    int LA68_0 = input.LA(1);

                    if ( (LA68_0==OUTER) ) {
                        alt68=1;
                    }
                    switch (alt68) {
                        case 1 :
                            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:401:16: OUTER
                            {
                            _last = (CommonTree)input.LT(1);
                            OUTER233=(CommonTree)match(input,OUTER,FOLLOW_OUTER_in_join_sub_clause2163); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            OUTER233_tree = (CommonTree)adaptor.dupNode(OUTER233);


                            adaptor.addChild(root_0, OUTER233_tree);
                            }


                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_item_in_join_sub_clause2166);
                    join_item234=join_item();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, join_item234.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:402:7: ( join_item )+
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:402:7: ( join_item )+
                    int cnt69=0;
                    loop69:
                    do {
                        int alt69=2;
                        int LA69_0 = input.LA(1);

                        if ( (LA69_0==JOIN_ITEM) ) {
                            alt69=1;
                        }


                        switch (alt69) {
                    	case 1 :
                    	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:402:7: join_item
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_join_item_in_join_sub_clause2174);
                    	    join_item235=join_item();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, join_item235.getTree());


                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    if ( cnt69 >= 1 ) break loop69;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(69, input);
                                throw eee;
                        }
                        cnt69++;
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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:405:1: join_item : ^( JOIN_ITEM rel join_group_by_clause ) ;
    public final AliasMasker.join_item_return join_item() throws RecognitionException {
        AliasMasker.join_item_return retval = new AliasMasker.join_item_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree JOIN_ITEM236=null;
        AliasMasker.rel_return rel237 =null;

        AliasMasker.join_group_by_clause_return join_group_by_clause238 =null;


        CommonTree JOIN_ITEM236_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:406:2: ( ^( JOIN_ITEM rel join_group_by_clause ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:406:4: ^( JOIN_ITEM rel join_group_by_clause )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            JOIN_ITEM236=(CommonTree)match(input,JOIN_ITEM,FOLLOW_JOIN_ITEM_in_join_item2187); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            JOIN_ITEM236_tree = (CommonTree)adaptor.dupNode(JOIN_ITEM236);


            root_1 = (CommonTree)adaptor.becomeRoot(JOIN_ITEM236_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_join_item2189);
            rel237=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel237.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_join_group_by_clause_in_join_item2191);
            join_group_by_clause238=join_group_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, join_group_by_clause238.getTree());


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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:409:1: join_group_by_clause : ^( BY ( join_group_by_expr )+ ) ;
    public final AliasMasker.join_group_by_clause_return join_group_by_clause() throws RecognitionException {
        AliasMasker.join_group_by_clause_return retval = new AliasMasker.join_group_by_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BY239=null;
        AliasMasker.join_group_by_expr_return join_group_by_expr240 =null;


        CommonTree BY239_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:410:5: ( ^( BY ( join_group_by_expr )+ ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:410:7: ^( BY ( join_group_by_expr )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BY239=(CommonTree)match(input,BY,FOLLOW_BY_in_join_group_by_clause2208); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BY239_tree = (CommonTree)adaptor.dupNode(BY239);


            root_1 = (CommonTree)adaptor.becomeRoot(BY239_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:410:13: ( join_group_by_expr )+
            int cnt71=0;
            loop71:
            do {
                int alt71=2;
                int LA71_0 = input.LA(1);

                if ( (LA71_0==DIV||LA71_0==DOLLARVAR||LA71_0==DOUBLENUMBER||LA71_0==FALSE||LA71_0==FLOATNUMBER||LA71_0==GROUP||LA71_0==INTEGER||LA71_0==LONGINTEGER||LA71_0==MINUS||LA71_0==PERCENT||LA71_0==PLUS||LA71_0==QUOTEDSTRING||LA71_0==STAR||LA71_0==TRUE||(LA71_0 >= BAG_VAL && LA71_0 <= BIN_EXPR)||(LA71_0 >= CAST_EXPR && LA71_0 <= EXPR_IN_PAREN)||LA71_0==FUNC_EVAL||LA71_0==IDENTIFIER||(LA71_0 >= MAP_VAL && LA71_0 <= NEG)||LA71_0==NULL||LA71_0==TUPLE_VAL) ) {
                    alt71=1;
                }


                switch (alt71) {
            	case 1 :
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:410:13: join_group_by_expr
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_join_group_by_expr_in_join_group_by_clause2210);
            	    join_group_by_expr240=join_group_by_expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, join_group_by_expr240.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt71 >= 1 ) break loop71;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(71, input);
                        throw eee;
                }
                cnt71++;
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
    // $ANTLR end "join_group_by_clause"


    public static class join_group_by_expr_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "join_group_by_expr"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:413:1: join_group_by_expr : ( col_range | expr | STAR );
    public final AliasMasker.join_group_by_expr_return join_group_by_expr() throws RecognitionException {
        AliasMasker.join_group_by_expr_return retval = new AliasMasker.join_group_by_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR243=null;
        AliasMasker.col_range_return col_range241 =null;

        AliasMasker.expr_return expr242 =null;


        CommonTree STAR243_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:414:5: ( col_range | expr | STAR )
            int alt72=3;
            switch ( input.LA(1) ) {
            case COL_RANGE:
                {
                alt72=1;
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
                alt72=2;
                }
                break;
            case STAR:
                {
                int LA72_3 = input.LA(2);

                if ( (LA72_3==DOWN) ) {
                    alt72=2;
                }
                else if ( (LA72_3==EOF||LA72_3==UP||LA72_3==DIV||LA72_3==DOLLARVAR||LA72_3==DOUBLENUMBER||LA72_3==FALSE||LA72_3==FLOATNUMBER||LA72_3==GROUP||LA72_3==INTEGER||LA72_3==LONGINTEGER||LA72_3==MINUS||LA72_3==PERCENT||LA72_3==PLUS||LA72_3==QUOTEDSTRING||LA72_3==STAR||LA72_3==TRUE||(LA72_3 >= BAG_VAL && LA72_3 <= BIN_EXPR)||(LA72_3 >= CAST_EXPR && LA72_3 <= EXPR_IN_PAREN)||LA72_3==FUNC_EVAL||LA72_3==IDENTIFIER||(LA72_3 >= MAP_VAL && LA72_3 <= NEG)||LA72_3==NULL||LA72_3==TUPLE_VAL) ) {
                    alt72=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 72, 3, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 72, 0, input);

                throw nvae;

            }

            switch (alt72) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:414:7: col_range
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_join_group_by_expr2227);
                    col_range241=col_range();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range241.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:414:19: expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_join_group_by_expr2231);
                    expr242=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expr242.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:414:26: STAR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR243=(CommonTree)match(input,STAR,FOLLOW_STAR_in_join_group_by_expr2235); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR243_tree = (CommonTree)adaptor.dupNode(STAR243);


                    adaptor.addChild(root_0, STAR243_tree);
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
    // $ANTLR end "join_group_by_expr"


    public static class union_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "union_clause"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:417:1: union_clause : ^( UNION ( ONSCHEMA )? rel_list ) ;
    public final AliasMasker.union_clause_return union_clause() throws RecognitionException {
        AliasMasker.union_clause_return retval = new AliasMasker.union_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree UNION244=null;
        CommonTree ONSCHEMA245=null;
        AliasMasker.rel_list_return rel_list246 =null;


        CommonTree UNION244_tree=null;
        CommonTree ONSCHEMA245_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:418:5: ( ^( UNION ( ONSCHEMA )? rel_list ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:418:7: ^( UNION ( ONSCHEMA )? rel_list )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            UNION244=(CommonTree)match(input,UNION,FOLLOW_UNION_in_union_clause2252); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            UNION244_tree = (CommonTree)adaptor.dupNode(UNION244);


            root_1 = (CommonTree)adaptor.becomeRoot(UNION244_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:418:16: ( ONSCHEMA )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==ONSCHEMA) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:418:16: ONSCHEMA
                    {
                    _last = (CommonTree)input.LT(1);
                    ONSCHEMA245=(CommonTree)match(input,ONSCHEMA,FOLLOW_ONSCHEMA_in_union_clause2254); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ONSCHEMA245_tree = (CommonTree)adaptor.dupNode(ONSCHEMA245);


                    adaptor.addChild(root_1, ONSCHEMA245_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_list_in_union_clause2257);
            rel_list246=rel_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel_list246.getTree());


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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:421:1: foreach_clause : ^( FOREACH rel foreach_plan ) ;
    public final AliasMasker.foreach_clause_return foreach_clause() throws RecognitionException {
        AliasMasker.foreach_clause_return retval = new AliasMasker.foreach_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FOREACH247=null;
        AliasMasker.rel_return rel248 =null;

        AliasMasker.foreach_plan_return foreach_plan249 =null;


        CommonTree FOREACH247_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:422:5: ( ^( FOREACH rel foreach_plan ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:422:7: ^( FOREACH rel foreach_plan )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FOREACH247=(CommonTree)match(input,FOREACH,FOLLOW_FOREACH_in_foreach_clause2279); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FOREACH247_tree = (CommonTree)adaptor.dupNode(FOREACH247);


            root_1 = (CommonTree)adaptor.becomeRoot(FOREACH247_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_foreach_clause2281);
            rel248=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel248.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_foreach_plan_in_foreach_clause2283);
            foreach_plan249=foreach_plan();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, foreach_plan249.getTree());


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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:425:1: foreach_plan : ( ^( FOREACH_PLAN_SIMPLE generate_clause ) | ^( FOREACH_PLAN_COMPLEX nested_blk ) );
    public final AliasMasker.foreach_plan_return foreach_plan() throws RecognitionException {
        AliasMasker.foreach_plan_return retval = new AliasMasker.foreach_plan_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FOREACH_PLAN_SIMPLE250=null;
        CommonTree FOREACH_PLAN_COMPLEX252=null;
        AliasMasker.generate_clause_return generate_clause251 =null;

        AliasMasker.nested_blk_return nested_blk253 =null;


        CommonTree FOREACH_PLAN_SIMPLE250_tree=null;
        CommonTree FOREACH_PLAN_COMPLEX252_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:426:5: ( ^( FOREACH_PLAN_SIMPLE generate_clause ) | ^( FOREACH_PLAN_COMPLEX nested_blk ) )
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==FOREACH_PLAN_SIMPLE) ) {
                alt74=1;
            }
            else if ( (LA74_0==FOREACH_PLAN_COMPLEX) ) {
                alt74=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 74, 0, input);

                throw nvae;

            }
            switch (alt74) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:426:7: ^( FOREACH_PLAN_SIMPLE generate_clause )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FOREACH_PLAN_SIMPLE250=(CommonTree)match(input,FOREACH_PLAN_SIMPLE,FOLLOW_FOREACH_PLAN_SIMPLE_in_foreach_plan2305); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FOREACH_PLAN_SIMPLE250_tree = (CommonTree)adaptor.dupNode(FOREACH_PLAN_SIMPLE250);


                    root_1 = (CommonTree)adaptor.becomeRoot(FOREACH_PLAN_SIMPLE250_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_generate_clause_in_foreach_plan2307);
                    generate_clause251=generate_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, generate_clause251.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:427:7: ^( FOREACH_PLAN_COMPLEX nested_blk )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FOREACH_PLAN_COMPLEX252=(CommonTree)match(input,FOREACH_PLAN_COMPLEX,FOLLOW_FOREACH_PLAN_COMPLEX_in_foreach_plan2319); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FOREACH_PLAN_COMPLEX252_tree = (CommonTree)adaptor.dupNode(FOREACH_PLAN_COMPLEX252);


                    root_1 = (CommonTree)adaptor.becomeRoot(FOREACH_PLAN_COMPLEX252_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_blk_in_foreach_plan2321);
                    nested_blk253=nested_blk();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, nested_blk253.getTree());


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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:430:1: nested_blk : ( nested_command )* generate_clause ;
    public final AliasMasker.nested_blk_return nested_blk() throws RecognitionException {
        AliasMasker.nested_blk_return retval = new AliasMasker.nested_blk_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.nested_command_return nested_command254 =null;

        AliasMasker.generate_clause_return generate_clause255 =null;



        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:431:5: ( ( nested_command )* generate_clause )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:431:7: ( nested_command )* generate_clause
            {
            root_0 = (CommonTree)adaptor.nil();


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:431:7: ( nested_command )*
            loop75:
            do {
                int alt75=2;
                int LA75_0 = input.LA(1);

                if ( ((LA75_0 >= NESTED_CMD && LA75_0 <= NESTED_CMD_ASSI)) ) {
                    alt75=1;
                }


                switch (alt75) {
            	case 1 :
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:431:7: nested_command
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_nested_command_in_nested_blk2336);
            	    nested_command254=nested_command();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, nested_command254.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop75;
                }
            } while (true);


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_generate_clause_in_nested_blk2339);
            generate_clause255=generate_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, generate_clause255.getTree());


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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:434:1: generate_clause : ^( GENERATE ( flatten_generated_item )+ ) ;
    public final AliasMasker.generate_clause_return generate_clause() throws RecognitionException {
        AliasMasker.generate_clause_return retval = new AliasMasker.generate_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree GENERATE256=null;
        AliasMasker.flatten_generated_item_return flatten_generated_item257 =null;


        CommonTree GENERATE256_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:435:5: ( ^( GENERATE ( flatten_generated_item )+ ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:435:7: ^( GENERATE ( flatten_generated_item )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            GENERATE256=(CommonTree)match(input,GENERATE,FOLLOW_GENERATE_in_generate_clause2355); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            GENERATE256_tree = (CommonTree)adaptor.dupNode(GENERATE256);


            root_1 = (CommonTree)adaptor.becomeRoot(GENERATE256_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:435:19: ( flatten_generated_item )+
            int cnt76=0;
            loop76:
            do {
                int alt76=2;
                int LA76_0 = input.LA(1);

                if ( (LA76_0==DIV||LA76_0==DOLLARVAR||LA76_0==DOUBLENUMBER||LA76_0==FALSE||LA76_0==FLATTEN||LA76_0==FLOATNUMBER||LA76_0==GROUP||LA76_0==INTEGER||LA76_0==LONGINTEGER||LA76_0==MINUS||LA76_0==PERCENT||LA76_0==PLUS||LA76_0==QUOTEDSTRING||LA76_0==STAR||LA76_0==TRUE||(LA76_0 >= BAG_VAL && LA76_0 <= BIN_EXPR)||(LA76_0 >= CAST_EXPR && LA76_0 <= EXPR_IN_PAREN)||LA76_0==FUNC_EVAL||LA76_0==IDENTIFIER||(LA76_0 >= MAP_VAL && LA76_0 <= NEG)||LA76_0==NULL||LA76_0==TUPLE_VAL) ) {
                    alt76=1;
                }


                switch (alt76) {
            	case 1 :
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:435:19: flatten_generated_item
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_flatten_generated_item_in_generate_clause2357);
            	    flatten_generated_item257=flatten_generated_item();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, flatten_generated_item257.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt76 >= 1 ) break loop76;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(76, input);
                        throw eee;
                }
                cnt76++;
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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:438:1: nested_command : ( ^( NESTED_CMD IDENTIFIER nested_op ) | ^( NESTED_CMD_ASSI IDENTIFIER expr ) );
    public final AliasMasker.nested_command_return nested_command() throws RecognitionException {
        AliasMasker.nested_command_return retval = new AliasMasker.nested_command_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree NESTED_CMD258=null;
        CommonTree IDENTIFIER259=null;
        CommonTree NESTED_CMD_ASSI261=null;
        CommonTree IDENTIFIER262=null;
        AliasMasker.nested_op_return nested_op260 =null;

        AliasMasker.expr_return expr263 =null;


        CommonTree NESTED_CMD258_tree=null;
        CommonTree IDENTIFIER259_tree=null;
        CommonTree NESTED_CMD_ASSI261_tree=null;
        CommonTree IDENTIFIER262_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:439:5: ( ^( NESTED_CMD IDENTIFIER nested_op ) | ^( NESTED_CMD_ASSI IDENTIFIER expr ) )
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==NESTED_CMD) ) {
                alt77=1;
            }
            else if ( (LA77_0==NESTED_CMD_ASSI) ) {
                alt77=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 77, 0, input);

                throw nvae;

            }
            switch (alt77) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:439:7: ^( NESTED_CMD IDENTIFIER nested_op )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NESTED_CMD258=(CommonTree)match(input,NESTED_CMD,FOLLOW_NESTED_CMD_in_nested_command2379); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NESTED_CMD258_tree = (CommonTree)adaptor.dupNode(NESTED_CMD258);


                    root_1 = (CommonTree)adaptor.becomeRoot(NESTED_CMD258_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER259=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_nested_command2381); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER259_tree = (CommonTree)adaptor.dupNode(IDENTIFIER259);


                    adaptor.addChild(root_1, IDENTIFIER259_tree);
                    }


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_op_in_nested_command2383);
                    nested_op260=nested_op();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, nested_op260.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:440:7: ^( NESTED_CMD_ASSI IDENTIFIER expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NESTED_CMD_ASSI261=(CommonTree)match(input,NESTED_CMD_ASSI,FOLLOW_NESTED_CMD_ASSI_in_nested_command2395); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NESTED_CMD_ASSI261_tree = (CommonTree)adaptor.dupNode(NESTED_CMD_ASSI261);


                    root_1 = (CommonTree)adaptor.becomeRoot(NESTED_CMD_ASSI261_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER262=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_nested_command2397); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER262_tree = (CommonTree)adaptor.dupNode(IDENTIFIER262);


                    adaptor.addChild(root_1, IDENTIFIER262_tree);
                    }


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_nested_command2399);
                    expr263=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr263.getTree());


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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:443:1: nested_op : ( nested_proj | nested_filter | nested_sort | nested_distinct | nested_limit | nested_cross | nested_foreach );
    public final AliasMasker.nested_op_return nested_op() throws RecognitionException {
        AliasMasker.nested_op_return retval = new AliasMasker.nested_op_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.nested_proj_return nested_proj264 =null;

        AliasMasker.nested_filter_return nested_filter265 =null;

        AliasMasker.nested_sort_return nested_sort266 =null;

        AliasMasker.nested_distinct_return nested_distinct267 =null;

        AliasMasker.nested_limit_return nested_limit268 =null;

        AliasMasker.nested_cross_return nested_cross269 =null;

        AliasMasker.nested_foreach_return nested_foreach270 =null;



        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:443:11: ( nested_proj | nested_filter | nested_sort | nested_distinct | nested_limit | nested_cross | nested_foreach )
            int alt78=7;
            switch ( input.LA(1) ) {
            case NESTED_PROJ:
                {
                alt78=1;
                }
                break;
            case FILTER:
                {
                alt78=2;
                }
                break;
            case ORDER:
                {
                alt78=3;
                }
                break;
            case DISTINCT:
                {
                alt78=4;
                }
                break;
            case LIMIT:
                {
                alt78=5;
                }
                break;
            case CROSS:
                {
                alt78=6;
                }
                break;
            case FOREACH:
                {
                alt78=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 78, 0, input);

                throw nvae;

            }

            switch (alt78) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:443:13: nested_proj
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_proj_in_nested_op2410);
                    nested_proj264=nested_proj();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_proj264.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:444:13: nested_filter
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_filter_in_nested_op2424);
                    nested_filter265=nested_filter();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_filter265.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:445:13: nested_sort
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_sort_in_nested_op2438);
                    nested_sort266=nested_sort();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_sort266.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:446:13: nested_distinct
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_distinct_in_nested_op2452);
                    nested_distinct267=nested_distinct();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_distinct267.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:447:13: nested_limit
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_limit_in_nested_op2466);
                    nested_limit268=nested_limit();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_limit268.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:448:13: nested_cross
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_cross_in_nested_op2480);
                    nested_cross269=nested_cross();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_cross269.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:449:13: nested_foreach
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_foreach_in_nested_op2494);
                    nested_foreach270=nested_foreach();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_foreach270.getTree());


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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:452:1: nested_proj : ^( NESTED_PROJ col_ref ( col_ref )+ ) ;
    public final AliasMasker.nested_proj_return nested_proj() throws RecognitionException {
        AliasMasker.nested_proj_return retval = new AliasMasker.nested_proj_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree NESTED_PROJ271=null;
        AliasMasker.col_ref_return col_ref272 =null;

        AliasMasker.col_ref_return col_ref273 =null;


        CommonTree NESTED_PROJ271_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:453:5: ( ^( NESTED_PROJ col_ref ( col_ref )+ ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:453:7: ^( NESTED_PROJ col_ref ( col_ref )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            NESTED_PROJ271=(CommonTree)match(input,NESTED_PROJ,FOLLOW_NESTED_PROJ_in_nested_proj2510); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NESTED_PROJ271_tree = (CommonTree)adaptor.dupNode(NESTED_PROJ271);


            root_1 = (CommonTree)adaptor.becomeRoot(NESTED_PROJ271_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_col_ref_in_nested_proj2512);
            col_ref272=col_ref();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, col_ref272.getTree());


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:453:30: ( col_ref )+
            int cnt79=0;
            loop79:
            do {
                int alt79=2;
                int LA79_0 = input.LA(1);

                if ( (LA79_0==DOLLARVAR||LA79_0==GROUP||LA79_0==IDENTIFIER) ) {
                    alt79=1;
                }


                switch (alt79) {
            	case 1 :
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:453:30: col_ref
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_col_ref_in_nested_proj2514);
            	    col_ref273=col_ref();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, col_ref273.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt79 >= 1 ) break loop79;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(79, input);
                        throw eee;
                }
                cnt79++;
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
    // $ANTLR end "nested_proj"


    public static class nested_filter_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_filter"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:456:1: nested_filter : ^( FILTER nested_op_input cond ) ;
    public final AliasMasker.nested_filter_return nested_filter() throws RecognitionException {
        AliasMasker.nested_filter_return retval = new AliasMasker.nested_filter_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FILTER274=null;
        AliasMasker.nested_op_input_return nested_op_input275 =null;

        AliasMasker.cond_return cond276 =null;


        CommonTree FILTER274_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:457:5: ( ^( FILTER nested_op_input cond ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:457:7: ^( FILTER nested_op_input cond )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FILTER274=(CommonTree)match(input,FILTER,FOLLOW_FILTER_in_nested_filter2536); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FILTER274_tree = (CommonTree)adaptor.dupNode(FILTER274);


            root_1 = (CommonTree)adaptor.becomeRoot(FILTER274_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_filter2538);
            nested_op_input275=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input275.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_nested_filter2540);
            cond276=cond();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond276.getTree());


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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:460:1: nested_sort : ^( ORDER nested_op_input order_by_clause ( func_clause )? ) ;
    public final AliasMasker.nested_sort_return nested_sort() throws RecognitionException {
        AliasMasker.nested_sort_return retval = new AliasMasker.nested_sort_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ORDER277=null;
        AliasMasker.nested_op_input_return nested_op_input278 =null;

        AliasMasker.order_by_clause_return order_by_clause279 =null;

        AliasMasker.func_clause_return func_clause280 =null;


        CommonTree ORDER277_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:461:5: ( ^( ORDER nested_op_input order_by_clause ( func_clause )? ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:461:7: ^( ORDER nested_op_input order_by_clause ( func_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            ORDER277=(CommonTree)match(input,ORDER,FOLLOW_ORDER_in_nested_sort2562); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ORDER277_tree = (CommonTree)adaptor.dupNode(ORDER277);


            root_1 = (CommonTree)adaptor.becomeRoot(ORDER277_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_sort2564);
            nested_op_input278=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input278.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_order_by_clause_in_nested_sort2566);
            order_by_clause279=order_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, order_by_clause279.getTree());


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:461:48: ( func_clause )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==FUNC||LA80_0==FUNC_REF) ) {
                alt80=1;
            }
            switch (alt80) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:461:48: func_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_nested_sort2568);
                    func_clause280=func_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause280.getTree());


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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:464:1: nested_distinct : ^( DISTINCT nested_op_input ) ;
    public final AliasMasker.nested_distinct_return nested_distinct() throws RecognitionException {
        AliasMasker.nested_distinct_return retval = new AliasMasker.nested_distinct_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DISTINCT281=null;
        AliasMasker.nested_op_input_return nested_op_input282 =null;


        CommonTree DISTINCT281_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:465:5: ( ^( DISTINCT nested_op_input ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:465:7: ^( DISTINCT nested_op_input )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            DISTINCT281=(CommonTree)match(input,DISTINCT,FOLLOW_DISTINCT_in_nested_distinct2591); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DISTINCT281_tree = (CommonTree)adaptor.dupNode(DISTINCT281);


            root_1 = (CommonTree)adaptor.becomeRoot(DISTINCT281_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_distinct2593);
            nested_op_input282=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input282.getTree());


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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:468:1: nested_limit : ^( LIMIT nested_op_input ( INTEGER | expr ) ) ;
    public final AliasMasker.nested_limit_return nested_limit() throws RecognitionException {
        AliasMasker.nested_limit_return retval = new AliasMasker.nested_limit_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree LIMIT283=null;
        CommonTree INTEGER285=null;
        AliasMasker.nested_op_input_return nested_op_input284 =null;

        AliasMasker.expr_return expr286 =null;


        CommonTree LIMIT283_tree=null;
        CommonTree INTEGER285_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:469:5: ( ^( LIMIT nested_op_input ( INTEGER | expr ) ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:469:7: ^( LIMIT nested_op_input ( INTEGER | expr ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            LIMIT283=(CommonTree)match(input,LIMIT,FOLLOW_LIMIT_in_nested_limit2615); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LIMIT283_tree = (CommonTree)adaptor.dupNode(LIMIT283);


            root_1 = (CommonTree)adaptor.becomeRoot(LIMIT283_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_limit2617);
            nested_op_input284=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input284.getTree());


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:469:32: ( INTEGER | expr )
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==INTEGER) ) {
                int LA81_1 = input.LA(2);

                if ( (synpred145_AliasMasker()) ) {
                    alt81=1;
                }
                else if ( (true) ) {
                    alt81=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 81, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA81_0==DIV||LA81_0==DOLLARVAR||LA81_0==DOUBLENUMBER||LA81_0==FALSE||LA81_0==FLOATNUMBER||LA81_0==GROUP||LA81_0==LONGINTEGER||LA81_0==MINUS||LA81_0==PERCENT||LA81_0==PLUS||LA81_0==QUOTEDSTRING||LA81_0==STAR||LA81_0==TRUE||(LA81_0 >= BAG_VAL && LA81_0 <= BIN_EXPR)||LA81_0==CAST_EXPR||LA81_0==EXPR_IN_PAREN||LA81_0==FUNC_EVAL||LA81_0==IDENTIFIER||(LA81_0 >= MAP_VAL && LA81_0 <= NEG)||LA81_0==NULL||LA81_0==TUPLE_VAL) ) {
                alt81=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 81, 0, input);

                throw nvae;

            }
            switch (alt81) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:469:34: INTEGER
                    {
                    _last = (CommonTree)input.LT(1);
                    INTEGER285=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_nested_limit2621); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INTEGER285_tree = (CommonTree)adaptor.dupNode(INTEGER285);


                    adaptor.addChild(root_1, INTEGER285_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:469:44: expr
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_nested_limit2625);
                    expr286=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr286.getTree());


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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:472:1: nested_cross : ^( CROSS nested_op_input_list ) ;
    public final AliasMasker.nested_cross_return nested_cross() throws RecognitionException {
        AliasMasker.nested_cross_return retval = new AliasMasker.nested_cross_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CROSS287=null;
        AliasMasker.nested_op_input_list_return nested_op_input_list288 =null;


        CommonTree CROSS287_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:472:14: ( ^( CROSS nested_op_input_list ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:472:16: ^( CROSS nested_op_input_list )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CROSS287=(CommonTree)match(input,CROSS,FOLLOW_CROSS_in_nested_cross2640); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CROSS287_tree = (CommonTree)adaptor.dupNode(CROSS287);


            root_1 = (CommonTree)adaptor.becomeRoot(CROSS287_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_list_in_nested_cross2642);
            nested_op_input_list288=nested_op_input_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input_list288.getTree());


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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:475:1: nested_foreach : ^( FOREACH nested_op_input generate_clause ) ;
    public final AliasMasker.nested_foreach_return nested_foreach() throws RecognitionException {
        AliasMasker.nested_foreach_return retval = new AliasMasker.nested_foreach_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FOREACH289=null;
        AliasMasker.nested_op_input_return nested_op_input290 =null;

        AliasMasker.generate_clause_return generate_clause291 =null;


        CommonTree FOREACH289_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:475:16: ( ^( FOREACH nested_op_input generate_clause ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:475:18: ^( FOREACH nested_op_input generate_clause )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FOREACH289=(CommonTree)match(input,FOREACH,FOLLOW_FOREACH_in_nested_foreach2655); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FOREACH289_tree = (CommonTree)adaptor.dupNode(FOREACH289);


            root_1 = (CommonTree)adaptor.becomeRoot(FOREACH289_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_foreach2657);
            nested_op_input290=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input290.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_generate_clause_in_nested_foreach2659);
            generate_clause291=generate_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, generate_clause291.getTree());


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


    public static class nested_op_input_list_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_op_input_list"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:478:1: nested_op_input_list : ( nested_op_input )+ ;
    public final AliasMasker.nested_op_input_list_return nested_op_input_list() throws RecognitionException {
        AliasMasker.nested_op_input_list_return retval = new AliasMasker.nested_op_input_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.nested_op_input_return nested_op_input292 =null;



        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:478:22: ( ( nested_op_input )+ )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:478:24: ( nested_op_input )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:478:24: ( nested_op_input )+
            int cnt82=0;
            loop82:
            do {
                int alt82=2;
                int LA82_0 = input.LA(1);

                if ( (LA82_0==DOLLARVAR||LA82_0==GROUP||LA82_0==IDENTIFIER||LA82_0==NESTED_PROJ) ) {
                    alt82=1;
                }


                switch (alt82) {
            	case 1 :
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:478:24: nested_op_input
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_nested_op_input_in_nested_op_input_list2670);
            	    nested_op_input292=nested_op_input();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, nested_op_input292.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt82 >= 1 ) break loop82;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(82, input);
                        throw eee;
                }
                cnt82++;
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


    public static class nested_op_input_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_op_input"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:481:1: nested_op_input : ( col_ref | nested_proj );
    public final AliasMasker.nested_op_input_return nested_op_input() throws RecognitionException {
        AliasMasker.nested_op_input_return retval = new AliasMasker.nested_op_input_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.col_ref_return col_ref293 =null;

        AliasMasker.nested_proj_return nested_proj294 =null;



        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:481:17: ( col_ref | nested_proj )
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==DOLLARVAR||LA83_0==GROUP||LA83_0==IDENTIFIER) ) {
                alt83=1;
            }
            else if ( (LA83_0==NESTED_PROJ) ) {
                alt83=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 83, 0, input);

                throw nvae;

            }
            switch (alt83) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:481:19: col_ref
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_nested_op_input2680);
                    col_ref293=col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_ref293.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:481:29: nested_proj
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_proj_in_nested_op_input2684);
                    nested_proj294=nested_proj();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_proj294.getTree());


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


    public static class stream_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "stream_clause"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:484:1: stream_clause : ^( STREAM rel ( EXECCOMMAND | IDENTIFIER ) ( as_clause )? ) ;
    public final AliasMasker.stream_clause_return stream_clause() throws RecognitionException {
        AliasMasker.stream_clause_return retval = new AliasMasker.stream_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STREAM295=null;
        CommonTree set297=null;
        AliasMasker.rel_return rel296 =null;

        AliasMasker.as_clause_return as_clause298 =null;


        CommonTree STREAM295_tree=null;
        CommonTree set297_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:485:5: ( ^( STREAM rel ( EXECCOMMAND | IDENTIFIER ) ( as_clause )? ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:485:7: ^( STREAM rel ( EXECCOMMAND | IDENTIFIER ) ( as_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            STREAM295=(CommonTree)match(input,STREAM,FOLLOW_STREAM_in_stream_clause2700); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STREAM295_tree = (CommonTree)adaptor.dupNode(STREAM295);


            root_1 = (CommonTree)adaptor.becomeRoot(STREAM295_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_stream_clause2702);
            rel296=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel296.getTree());


            _last = (CommonTree)input.LT(1);
            set297=(CommonTree)input.LT(1);

            if ( input.LA(1)==EXECCOMMAND||input.LA(1)==IDENTIFIER ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set297_tree = (CommonTree)adaptor.dupNode(set297);


                adaptor.addChild(root_1, set297_tree);
                }

                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:485:50: ( as_clause )?
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==AS) ) {
                alt84=1;
            }
            switch (alt84) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:485:50: as_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_as_clause_in_stream_clause2714);
                    as_clause298=as_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, as_clause298.getTree());


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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:488:1: mr_clause : ^( MAPREDUCE QUOTEDSTRING ( path_list )? store_clause load_clause ( EXECCOMMAND )? ) ;
    public final AliasMasker.mr_clause_return mr_clause() throws RecognitionException {
        AliasMasker.mr_clause_return retval = new AliasMasker.mr_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MAPREDUCE299=null;
        CommonTree QUOTEDSTRING300=null;
        CommonTree EXECCOMMAND304=null;
        AliasMasker.path_list_return path_list301 =null;

        AliasMasker.store_clause_return store_clause302 =null;

        AliasMasker.load_clause_return load_clause303 =null;


        CommonTree MAPREDUCE299_tree=null;
        CommonTree QUOTEDSTRING300_tree=null;
        CommonTree EXECCOMMAND304_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:489:5: ( ^( MAPREDUCE QUOTEDSTRING ( path_list )? store_clause load_clause ( EXECCOMMAND )? ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:489:7: ^( MAPREDUCE QUOTEDSTRING ( path_list )? store_clause load_clause ( EXECCOMMAND )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            MAPREDUCE299=(CommonTree)match(input,MAPREDUCE,FOLLOW_MAPREDUCE_in_mr_clause2733); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            MAPREDUCE299_tree = (CommonTree)adaptor.dupNode(MAPREDUCE299);


            root_1 = (CommonTree)adaptor.becomeRoot(MAPREDUCE299_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING300=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_mr_clause2735); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING300_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING300);


            adaptor.addChild(root_1, QUOTEDSTRING300_tree);
            }


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:489:33: ( path_list )?
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==QUOTEDSTRING) ) {
                alt85=1;
            }
            switch (alt85) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:489:33: path_list
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_path_list_in_mr_clause2737);
                    path_list301=path_list();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, path_list301.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_store_clause_in_mr_clause2740);
            store_clause302=store_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, store_clause302.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_load_clause_in_mr_clause2742);
            load_clause303=load_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, load_clause303.getTree());


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:489:69: ( EXECCOMMAND )?
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==EXECCOMMAND) ) {
                alt86=1;
            }
            switch (alt86) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:489:69: EXECCOMMAND
                    {
                    _last = (CommonTree)input.LT(1);
                    EXECCOMMAND304=(CommonTree)match(input,EXECCOMMAND,FOLLOW_EXECCOMMAND_in_mr_clause2744); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EXECCOMMAND304_tree = (CommonTree)adaptor.dupNode(EXECCOMMAND304);


                    adaptor.addChild(root_1, EXECCOMMAND304_tree);
                    }


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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:492:1: split_clause : ^( SPLIT rel ( split_branch )+ ( split_otherwise )? ) ;
    public final AliasMasker.split_clause_return split_clause() throws RecognitionException {
        AliasMasker.split_clause_return retval = new AliasMasker.split_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SPLIT305=null;
        AliasMasker.rel_return rel306 =null;

        AliasMasker.split_branch_return split_branch307 =null;

        AliasMasker.split_otherwise_return split_otherwise308 =null;


        CommonTree SPLIT305_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:493:5: ( ^( SPLIT rel ( split_branch )+ ( split_otherwise )? ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:493:7: ^( SPLIT rel ( split_branch )+ ( split_otherwise )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            SPLIT305=(CommonTree)match(input,SPLIT,FOLLOW_SPLIT_in_split_clause2763); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SPLIT305_tree = (CommonTree)adaptor.dupNode(SPLIT305);


            root_1 = (CommonTree)adaptor.becomeRoot(SPLIT305_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_split_clause2765);
            rel306=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel306.getTree());


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:493:20: ( split_branch )+
            int cnt87=0;
            loop87:
            do {
                int alt87=2;
                int LA87_0 = input.LA(1);

                if ( (LA87_0==SPLIT_BRANCH) ) {
                    alt87=1;
                }


                switch (alt87) {
            	case 1 :
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:493:20: split_branch
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_split_branch_in_split_clause2767);
            	    split_branch307=split_branch();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, split_branch307.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt87 >= 1 ) break loop87;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(87, input);
                        throw eee;
                }
                cnt87++;
            } while (true);


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:493:34: ( split_otherwise )?
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==OTHERWISE) ) {
                alt88=1;
            }
            switch (alt88) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:493:34: split_otherwise
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_split_otherwise_in_split_clause2770);
                    split_otherwise308=split_otherwise();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, split_otherwise308.getTree());


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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:496:1: split_branch : ^( SPLIT_BRANCH alias cond ) ;
    public final AliasMasker.split_branch_return split_branch() throws RecognitionException {
        AliasMasker.split_branch_return retval = new AliasMasker.split_branch_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SPLIT_BRANCH309=null;
        AliasMasker.alias_return alias310 =null;

        AliasMasker.cond_return cond311 =null;


        CommonTree SPLIT_BRANCH309_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:497:5: ( ^( SPLIT_BRANCH alias cond ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:497:7: ^( SPLIT_BRANCH alias cond )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            SPLIT_BRANCH309=(CommonTree)match(input,SPLIT_BRANCH,FOLLOW_SPLIT_BRANCH_in_split_branch2788); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SPLIT_BRANCH309_tree = (CommonTree)adaptor.dupNode(SPLIT_BRANCH309);


            root_1 = (CommonTree)adaptor.becomeRoot(SPLIT_BRANCH309_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_alias_in_split_branch2790);
            alias310=alias();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, alias310.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_split_branch2792);
            cond311=cond();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond311.getTree());


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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:500:1: split_otherwise : ^( OTHERWISE alias ) ;
    public final AliasMasker.split_otherwise_return split_otherwise() throws RecognitionException {
        AliasMasker.split_otherwise_return retval = new AliasMasker.split_otherwise_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree OTHERWISE312=null;
        AliasMasker.alias_return alias313 =null;


        CommonTree OTHERWISE312_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:501:5: ( ^( OTHERWISE alias ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:501:7: ^( OTHERWISE alias )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            OTHERWISE312=(CommonTree)match(input,OTHERWISE,FOLLOW_OTHERWISE_in_split_otherwise2810); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            OTHERWISE312_tree = (CommonTree)adaptor.dupNode(OTHERWISE312);


            root_1 = (CommonTree)adaptor.becomeRoot(OTHERWISE312_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_alias_in_split_otherwise2812);
            alias313=alias();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, alias313.getTree());


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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:504:1: col_ref : ( alias_col_ref | dollar_col_ref );
    public final AliasMasker.col_ref_return col_ref() throws RecognitionException {
        AliasMasker.col_ref_return retval = new AliasMasker.col_ref_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.alias_col_ref_return alias_col_ref314 =null;

        AliasMasker.dollar_col_ref_return dollar_col_ref315 =null;



        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:504:9: ( alias_col_ref | dollar_col_ref )
            int alt89=2;
            int LA89_0 = input.LA(1);

            if ( (LA89_0==GROUP||LA89_0==IDENTIFIER) ) {
                alt89=1;
            }
            else if ( (LA89_0==DOLLARVAR) ) {
                alt89=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 89, 0, input);

                throw nvae;

            }
            switch (alt89) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:504:11: alias_col_ref
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_alias_col_ref_in_col_ref2824);
                    alias_col_ref314=alias_col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, alias_col_ref314.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:504:27: dollar_col_ref
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_dollar_col_ref_in_col_ref2828);
                    dollar_col_ref315=dollar_col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, dollar_col_ref315.getTree());


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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:507:1: alias_col_ref : ( GROUP | IDENTIFIER );
    public final AliasMasker.alias_col_ref_return alias_col_ref() throws RecognitionException {
        AliasMasker.alias_col_ref_return retval = new AliasMasker.alias_col_ref_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree GROUP316=null;
        CommonTree IDENTIFIER317=null;

        CommonTree GROUP316_tree=null;
        CommonTree IDENTIFIER317_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:508:5: ( GROUP | IDENTIFIER )
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==GROUP) ) {
                alt90=1;
            }
            else if ( (LA90_0==IDENTIFIER) ) {
                alt90=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 90, 0, input);

                throw nvae;

            }
            switch (alt90) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:508:7: GROUP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    GROUP316=(CommonTree)match(input,GROUP,FOLLOW_GROUP_in_alias_col_ref2842); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    GROUP316_tree = (CommonTree)adaptor.dupNode(GROUP316);


                    adaptor.addChild(root_0, GROUP316_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:509:7: IDENTIFIER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER317=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_alias_col_ref2851); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER317_tree = (CommonTree)adaptor.dupNode(IDENTIFIER317);


                    adaptor.addChild(root_0, IDENTIFIER317_tree);
                    }


                    if ( state.backtracking==0 ) {
                              String alias = (IDENTIFIER317!=null?IDENTIFIER317.getText():null);
                              String[] names = alias.split( "::" );
                              StringBuilder sb = new StringBuilder();
                              for( int i = 0; i < names.length; i++ ) {
                                  String name = names[i];
                                  sb.append( aliasSeen.contains( name ) ? getMask( name ) : name );
                                  if( i < names.length - 1 )
                                      sb.append( "::" );
                              }
                              IDENTIFIER317.token.setText( sb.toString() );
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
    // $ANTLR end "alias_col_ref"


    public static class dollar_col_ref_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "dollar_col_ref"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:524:1: dollar_col_ref : DOLLARVAR ;
    public final AliasMasker.dollar_col_ref_return dollar_col_ref() throws RecognitionException {
        AliasMasker.dollar_col_ref_return retval = new AliasMasker.dollar_col_ref_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DOLLARVAR318=null;

        CommonTree DOLLARVAR318_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:525:5: ( DOLLARVAR )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:525:7: DOLLARVAR
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            DOLLARVAR318=(CommonTree)match(input,DOLLARVAR,FOLLOW_DOLLARVAR_in_dollar_col_ref2873); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DOLLARVAR318_tree = (CommonTree)adaptor.dupNode(DOLLARVAR318);


            adaptor.addChild(root_0, DOLLARVAR318_tree);
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
    // $ANTLR end "dollar_col_ref"


    public static class const_expr_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "const_expr"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:528:1: const_expr : literal ;
    public final AliasMasker.const_expr_return const_expr() throws RecognitionException {
        AliasMasker.const_expr_return retval = new AliasMasker.const_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.literal_return literal319 =null;



        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:528:12: ( literal )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:528:14: literal
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_literal_in_const_expr2882);
            literal319=literal();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, literal319.getTree());


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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:531:1: literal : ( scalar | map | bag | tuple );
    public final AliasMasker.literal_return literal() throws RecognitionException {
        AliasMasker.literal_return retval = new AliasMasker.literal_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.scalar_return scalar320 =null;

        AliasMasker.map_return map321 =null;

        AliasMasker.bag_return bag322 =null;

        AliasMasker.tuple_return tuple323 =null;



        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:531:9: ( scalar | map | bag | tuple )
            int alt91=4;
            switch ( input.LA(1) ) {
            case DOUBLENUMBER:
            case FALSE:
            case FLOATNUMBER:
            case INTEGER:
            case LONGINTEGER:
            case QUOTEDSTRING:
            case TRUE:
            case NULL:
                {
                alt91=1;
                }
                break;
            case MAP_VAL:
                {
                alt91=2;
                }
                break;
            case BAG_VAL:
                {
                alt91=3;
                }
                break;
            case TUPLE_VAL:
                {
                alt91=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 91, 0, input);

                throw nvae;

            }

            switch (alt91) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:531:11: scalar
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_scalar_in_literal2891);
                    scalar320=scalar();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, scalar320.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:531:20: map
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_map_in_literal2895);
                    map321=map();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, map321.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:531:26: bag
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_bag_in_literal2899);
                    bag322=bag();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, bag322.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:531:32: tuple
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_tuple_in_literal2903);
                    tuple323=tuple();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, tuple323.getTree());


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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:534:1: scalar : ( INTEGER | LONGINTEGER | FLOATNUMBER | DOUBLENUMBER | QUOTEDSTRING | NULL | TRUE | FALSE );
    public final AliasMasker.scalar_return scalar() throws RecognitionException {
        AliasMasker.scalar_return retval = new AliasMasker.scalar_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set324=null;

        CommonTree set324_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:535:5: ( INTEGER | LONGINTEGER | FLOATNUMBER | DOUBLENUMBER | QUOTEDSTRING | NULL | TRUE | FALSE )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set324=(CommonTree)input.LT(1);

            if ( input.LA(1)==DOUBLENUMBER||input.LA(1)==FALSE||input.LA(1)==FLOATNUMBER||input.LA(1)==INTEGER||input.LA(1)==LONGINTEGER||input.LA(1)==QUOTEDSTRING||input.LA(1)==TRUE||input.LA(1)==NULL ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set324_tree = (CommonTree)adaptor.dupNode(set324);


                adaptor.addChild(root_0, set324_tree);
                }

                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
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
    // $ANTLR end "scalar"


    public static class map_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "map"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:545:1: map : ^( MAP_VAL ( keyvalue )* ) ;
    public final AliasMasker.map_return map() throws RecognitionException {
        AliasMasker.map_return retval = new AliasMasker.map_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MAP_VAL325=null;
        AliasMasker.keyvalue_return keyvalue326 =null;


        CommonTree MAP_VAL325_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:546:5: ( ^( MAP_VAL ( keyvalue )* ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:546:7: ^( MAP_VAL ( keyvalue )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            MAP_VAL325=(CommonTree)match(input,MAP_VAL,FOLLOW_MAP_VAL_in_map2989); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            MAP_VAL325_tree = (CommonTree)adaptor.dupNode(MAP_VAL325);


            root_1 = (CommonTree)adaptor.becomeRoot(MAP_VAL325_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:546:18: ( keyvalue )*
                loop92:
                do {
                    int alt92=2;
                    int LA92_0 = input.LA(1);

                    if ( (LA92_0==KEY_VAL_PAIR) ) {
                        alt92=1;
                    }


                    switch (alt92) {
                	case 1 :
                	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:546:18: keyvalue
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_keyvalue_in_map2991);
                	    keyvalue326=keyvalue();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, keyvalue326.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop92;
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
    // $ANTLR end "map"


    public static class keyvalue_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "keyvalue"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:549:1: keyvalue : ^( KEY_VAL_PAIR map_key const_expr ) ;
    public final AliasMasker.keyvalue_return keyvalue() throws RecognitionException {
        AliasMasker.keyvalue_return retval = new AliasMasker.keyvalue_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree KEY_VAL_PAIR327=null;
        AliasMasker.map_key_return map_key328 =null;

        AliasMasker.const_expr_return const_expr329 =null;


        CommonTree KEY_VAL_PAIR327_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:550:5: ( ^( KEY_VAL_PAIR map_key const_expr ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:550:7: ^( KEY_VAL_PAIR map_key const_expr )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            KEY_VAL_PAIR327=(CommonTree)match(input,KEY_VAL_PAIR,FOLLOW_KEY_VAL_PAIR_in_keyvalue3010); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            KEY_VAL_PAIR327_tree = (CommonTree)adaptor.dupNode(KEY_VAL_PAIR327);


            root_1 = (CommonTree)adaptor.becomeRoot(KEY_VAL_PAIR327_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_map_key_in_keyvalue3012);
            map_key328=map_key();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, map_key328.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_const_expr_in_keyvalue3014);
            const_expr329=const_expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, const_expr329.getTree());


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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:553:1: map_key : QUOTEDSTRING ;
    public final AliasMasker.map_key_return map_key() throws RecognitionException {
        AliasMasker.map_key_return retval = new AliasMasker.map_key_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING330=null;

        CommonTree QUOTEDSTRING330_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:553:9: ( QUOTEDSTRING )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:553:11: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING330=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_map_key3029); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING330_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING330);


            adaptor.addChild(root_0, QUOTEDSTRING330_tree);
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
    // $ANTLR end "map_key"


    public static class bag_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "bag"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:556:1: bag : ^( BAG_VAL ( tuple )* ) ;
    public final AliasMasker.bag_return bag() throws RecognitionException {
        AliasMasker.bag_return retval = new AliasMasker.bag_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BAG_VAL331=null;
        AliasMasker.tuple_return tuple332 =null;


        CommonTree BAG_VAL331_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:557:5: ( ^( BAG_VAL ( tuple )* ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:557:7: ^( BAG_VAL ( tuple )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BAG_VAL331=(CommonTree)match(input,BAG_VAL,FOLLOW_BAG_VAL_in_bag3045); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BAG_VAL331_tree = (CommonTree)adaptor.dupNode(BAG_VAL331);


            root_1 = (CommonTree)adaptor.becomeRoot(BAG_VAL331_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:557:18: ( tuple )*
                loop93:
                do {
                    int alt93=2;
                    int LA93_0 = input.LA(1);

                    if ( (LA93_0==TUPLE_VAL) ) {
                        alt93=1;
                    }


                    switch (alt93) {
                	case 1 :
                	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:557:18: tuple
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_tuple_in_bag3047);
                	    tuple332=tuple();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, tuple332.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop93;
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
    // $ANTLR end "bag"


    public static class tuple_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "tuple"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:560:1: tuple : ^( TUPLE_VAL ( literal )* ) ;
    public final AliasMasker.tuple_return tuple() throws RecognitionException {
        AliasMasker.tuple_return retval = new AliasMasker.tuple_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree TUPLE_VAL333=null;
        AliasMasker.literal_return literal334 =null;


        CommonTree TUPLE_VAL333_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:561:5: ( ^( TUPLE_VAL ( literal )* ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:561:7: ^( TUPLE_VAL ( literal )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            TUPLE_VAL333=(CommonTree)match(input,TUPLE_VAL,FOLLOW_TUPLE_VAL_in_tuple3066); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            TUPLE_VAL333_tree = (CommonTree)adaptor.dupNode(TUPLE_VAL333);


            root_1 = (CommonTree)adaptor.becomeRoot(TUPLE_VAL333_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:561:20: ( literal )*
                loop94:
                do {
                    int alt94=2;
                    int LA94_0 = input.LA(1);

                    if ( (LA94_0==DOUBLENUMBER||LA94_0==FALSE||LA94_0==FLOATNUMBER||LA94_0==INTEGER||LA94_0==LONGINTEGER||LA94_0==QUOTEDSTRING||LA94_0==TRUE||LA94_0==BAG_VAL||LA94_0==MAP_VAL||LA94_0==NULL||LA94_0==TUPLE_VAL) ) {
                        alt94=1;
                    }


                    switch (alt94) {
                	case 1 :
                	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:561:20: literal
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_literal_in_tuple3068);
                	    literal334=literal();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, literal334.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop94;
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
    // $ANTLR end "tuple"


    public static class eid_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "eid"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:565:1: eid : ( rel_str_op | IMPORT | RETURNS | DEFINE | LOAD | FILTER | FOREACH | MATCHES | ORDER | DISTINCT | COGROUP | JOIN | CROSS | UNION | SPLIT | INTO | IF | ALL | AS | BY | USING | INNER | OUTER | PARALLEL | PARTITION | GROUP | AND | OR | NOT | GENERATE | FLATTEN | EVAL | ASC | DESC | BOOLEAN | INT | LONG | FLOAT | DOUBLE | CHARARRAY | BYTEARRAY | BAG | TUPLE | MAP | IS | NULL | TRUE | FALSE | STREAM | THROUGH | STORE | MAPREDUCE | SHIP | CACHE | INPUT | OUTPUT | STDERROR | STDIN | STDOUT | LIMIT | SAMPLE | LEFT | RIGHT | FULL | IDENTIFIER | TOBAG | TOMAP | TOTUPLE );
    public final AliasMasker.eid_return eid() throws RecognitionException {
        AliasMasker.eid_return retval = new AliasMasker.eid_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IMPORT336=null;
        CommonTree RETURNS337=null;
        CommonTree DEFINE338=null;
        CommonTree LOAD339=null;
        CommonTree FILTER340=null;
        CommonTree FOREACH341=null;
        CommonTree MATCHES342=null;
        CommonTree ORDER343=null;
        CommonTree DISTINCT344=null;
        CommonTree COGROUP345=null;
        CommonTree JOIN346=null;
        CommonTree CROSS347=null;
        CommonTree UNION348=null;
        CommonTree SPLIT349=null;
        CommonTree INTO350=null;
        CommonTree IF351=null;
        CommonTree ALL352=null;
        CommonTree AS353=null;
        CommonTree BY354=null;
        CommonTree USING355=null;
        CommonTree INNER356=null;
        CommonTree OUTER357=null;
        CommonTree PARALLEL358=null;
        CommonTree PARTITION359=null;
        CommonTree GROUP360=null;
        CommonTree AND361=null;
        CommonTree OR362=null;
        CommonTree NOT363=null;
        CommonTree GENERATE364=null;
        CommonTree FLATTEN365=null;
        CommonTree EVAL366=null;
        CommonTree ASC367=null;
        CommonTree DESC368=null;
        CommonTree BOOLEAN369=null;
        CommonTree INT370=null;
        CommonTree LONG371=null;
        CommonTree FLOAT372=null;
        CommonTree DOUBLE373=null;
        CommonTree CHARARRAY374=null;
        CommonTree BYTEARRAY375=null;
        CommonTree BAG376=null;
        CommonTree TUPLE377=null;
        CommonTree MAP378=null;
        CommonTree IS379=null;
        CommonTree NULL380=null;
        CommonTree TRUE381=null;
        CommonTree FALSE382=null;
        CommonTree STREAM383=null;
        CommonTree THROUGH384=null;
        CommonTree STORE385=null;
        CommonTree MAPREDUCE386=null;
        CommonTree SHIP387=null;
        CommonTree CACHE388=null;
        CommonTree INPUT389=null;
        CommonTree OUTPUT390=null;
        CommonTree STDERROR391=null;
        CommonTree STDIN392=null;
        CommonTree STDOUT393=null;
        CommonTree LIMIT394=null;
        CommonTree SAMPLE395=null;
        CommonTree LEFT396=null;
        CommonTree RIGHT397=null;
        CommonTree FULL398=null;
        CommonTree IDENTIFIER399=null;
        CommonTree TOBAG400=null;
        CommonTree TOMAP401=null;
        CommonTree TOTUPLE402=null;
        AliasMasker.rel_str_op_return rel_str_op335 =null;


        CommonTree IMPORT336_tree=null;
        CommonTree RETURNS337_tree=null;
        CommonTree DEFINE338_tree=null;
        CommonTree LOAD339_tree=null;
        CommonTree FILTER340_tree=null;
        CommonTree FOREACH341_tree=null;
        CommonTree MATCHES342_tree=null;
        CommonTree ORDER343_tree=null;
        CommonTree DISTINCT344_tree=null;
        CommonTree COGROUP345_tree=null;
        CommonTree JOIN346_tree=null;
        CommonTree CROSS347_tree=null;
        CommonTree UNION348_tree=null;
        CommonTree SPLIT349_tree=null;
        CommonTree INTO350_tree=null;
        CommonTree IF351_tree=null;
        CommonTree ALL352_tree=null;
        CommonTree AS353_tree=null;
        CommonTree BY354_tree=null;
        CommonTree USING355_tree=null;
        CommonTree INNER356_tree=null;
        CommonTree OUTER357_tree=null;
        CommonTree PARALLEL358_tree=null;
        CommonTree PARTITION359_tree=null;
        CommonTree GROUP360_tree=null;
        CommonTree AND361_tree=null;
        CommonTree OR362_tree=null;
        CommonTree NOT363_tree=null;
        CommonTree GENERATE364_tree=null;
        CommonTree FLATTEN365_tree=null;
        CommonTree EVAL366_tree=null;
        CommonTree ASC367_tree=null;
        CommonTree DESC368_tree=null;
        CommonTree BOOLEAN369_tree=null;
        CommonTree INT370_tree=null;
        CommonTree LONG371_tree=null;
        CommonTree FLOAT372_tree=null;
        CommonTree DOUBLE373_tree=null;
        CommonTree CHARARRAY374_tree=null;
        CommonTree BYTEARRAY375_tree=null;
        CommonTree BAG376_tree=null;
        CommonTree TUPLE377_tree=null;
        CommonTree MAP378_tree=null;
        CommonTree IS379_tree=null;
        CommonTree NULL380_tree=null;
        CommonTree TRUE381_tree=null;
        CommonTree FALSE382_tree=null;
        CommonTree STREAM383_tree=null;
        CommonTree THROUGH384_tree=null;
        CommonTree STORE385_tree=null;
        CommonTree MAPREDUCE386_tree=null;
        CommonTree SHIP387_tree=null;
        CommonTree CACHE388_tree=null;
        CommonTree INPUT389_tree=null;
        CommonTree OUTPUT390_tree=null;
        CommonTree STDERROR391_tree=null;
        CommonTree STDIN392_tree=null;
        CommonTree STDOUT393_tree=null;
        CommonTree LIMIT394_tree=null;
        CommonTree SAMPLE395_tree=null;
        CommonTree LEFT396_tree=null;
        CommonTree RIGHT397_tree=null;
        CommonTree FULL398_tree=null;
        CommonTree IDENTIFIER399_tree=null;
        CommonTree TOBAG400_tree=null;
        CommonTree TOMAP401_tree=null;
        CommonTree TOTUPLE402_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:565:5: ( rel_str_op | IMPORT | RETURNS | DEFINE | LOAD | FILTER | FOREACH | MATCHES | ORDER | DISTINCT | COGROUP | JOIN | CROSS | UNION | SPLIT | INTO | IF | ALL | AS | BY | USING | INNER | OUTER | PARALLEL | PARTITION | GROUP | AND | OR | NOT | GENERATE | FLATTEN | EVAL | ASC | DESC | BOOLEAN | INT | LONG | FLOAT | DOUBLE | CHARARRAY | BYTEARRAY | BAG | TUPLE | MAP | IS | NULL | TRUE | FALSE | STREAM | THROUGH | STORE | MAPREDUCE | SHIP | CACHE | INPUT | OUTPUT | STDERROR | STDIN | STDOUT | LIMIT | SAMPLE | LEFT | RIGHT | FULL | IDENTIFIER | TOBAG | TOMAP | TOTUPLE )
            int alt95=68;
            switch ( input.LA(1) ) {
            case STR_OP_EQ:
            case STR_OP_GT:
            case STR_OP_GTE:
            case STR_OP_LT:
            case STR_OP_LTE:
            case STR_OP_MATCHES:
            case STR_OP_NE:
                {
                alt95=1;
                }
                break;
            case IMPORT:
                {
                alt95=2;
                }
                break;
            case RETURNS:
                {
                alt95=3;
                }
                break;
            case DEFINE:
                {
                alt95=4;
                }
                break;
            case LOAD:
                {
                alt95=5;
                }
                break;
            case FILTER:
                {
                alt95=6;
                }
                break;
            case FOREACH:
                {
                alt95=7;
                }
                break;
            case MATCHES:
                {
                alt95=8;
                }
                break;
            case ORDER:
                {
                alt95=9;
                }
                break;
            case DISTINCT:
                {
                alt95=10;
                }
                break;
            case COGROUP:
                {
                alt95=11;
                }
                break;
            case JOIN:
                {
                alt95=12;
                }
                break;
            case CROSS:
                {
                alt95=13;
                }
                break;
            case UNION:
                {
                alt95=14;
                }
                break;
            case SPLIT:
                {
                alt95=15;
                }
                break;
            case INTO:
                {
                alt95=16;
                }
                break;
            case IF:
                {
                alt95=17;
                }
                break;
            case ALL:
                {
                alt95=18;
                }
                break;
            case AS:
                {
                alt95=19;
                }
                break;
            case BY:
                {
                alt95=20;
                }
                break;
            case USING:
                {
                alt95=21;
                }
                break;
            case INNER:
                {
                alt95=22;
                }
                break;
            case OUTER:
                {
                alt95=23;
                }
                break;
            case PARALLEL:
                {
                alt95=24;
                }
                break;
            case PARTITION:
                {
                alt95=25;
                }
                break;
            case GROUP:
                {
                alt95=26;
                }
                break;
            case AND:
                {
                alt95=27;
                }
                break;
            case OR:
                {
                alt95=28;
                }
                break;
            case NOT:
                {
                alt95=29;
                }
                break;
            case GENERATE:
                {
                alt95=30;
                }
                break;
            case FLATTEN:
                {
                alt95=31;
                }
                break;
            case EVAL:
                {
                alt95=32;
                }
                break;
            case ASC:
                {
                alt95=33;
                }
                break;
            case DESC:
                {
                alt95=34;
                }
                break;
            case BOOLEAN:
                {
                alt95=35;
                }
                break;
            case INT:
                {
                alt95=36;
                }
                break;
            case LONG:
                {
                alt95=37;
                }
                break;
            case FLOAT:
                {
                alt95=38;
                }
                break;
            case DOUBLE:
                {
                alt95=39;
                }
                break;
            case CHARARRAY:
                {
                alt95=40;
                }
                break;
            case BYTEARRAY:
                {
                alt95=41;
                }
                break;
            case BAG:
                {
                alt95=42;
                }
                break;
            case TUPLE:
                {
                alt95=43;
                }
                break;
            case MAP:
                {
                alt95=44;
                }
                break;
            case IS:
                {
                alt95=45;
                }
                break;
            case NULL:
                {
                alt95=46;
                }
                break;
            case TRUE:
                {
                alt95=47;
                }
                break;
            case FALSE:
                {
                alt95=48;
                }
                break;
            case STREAM:
                {
                alt95=49;
                }
                break;
            case THROUGH:
                {
                alt95=50;
                }
                break;
            case STORE:
                {
                alt95=51;
                }
                break;
            case MAPREDUCE:
                {
                alt95=52;
                }
                break;
            case SHIP:
                {
                alt95=53;
                }
                break;
            case CACHE:
                {
                alt95=54;
                }
                break;
            case INPUT:
                {
                alt95=55;
                }
                break;
            case OUTPUT:
                {
                alt95=56;
                }
                break;
            case STDERROR:
                {
                alt95=57;
                }
                break;
            case STDIN:
                {
                alt95=58;
                }
                break;
            case STDOUT:
                {
                alt95=59;
                }
                break;
            case LIMIT:
                {
                alt95=60;
                }
                break;
            case SAMPLE:
                {
                alt95=61;
                }
                break;
            case LEFT:
                {
                alt95=62;
                }
                break;
            case RIGHT:
                {
                alt95=63;
                }
                break;
            case FULL:
                {
                alt95=64;
                }
                break;
            case IDENTIFIER:
                {
                alt95=65;
                }
                break;
            case TOBAG:
                {
                alt95=66;
                }
                break;
            case TOMAP:
                {
                alt95=67;
                }
                break;
            case TOTUPLE:
                {
                alt95=68;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 95, 0, input);

                throw nvae;

            }

            switch (alt95) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:565:7: rel_str_op
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_str_op_in_eid3081);
                    rel_str_op335=rel_str_op();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_str_op335.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:566:7: IMPORT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IMPORT336=(CommonTree)match(input,IMPORT,FOLLOW_IMPORT_in_eid3089); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IMPORT336_tree = (CommonTree)adaptor.dupNode(IMPORT336);


                    adaptor.addChild(root_0, IMPORT336_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:567:7: RETURNS
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    RETURNS337=(CommonTree)match(input,RETURNS,FOLLOW_RETURNS_in_eid3097); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RETURNS337_tree = (CommonTree)adaptor.dupNode(RETURNS337);


                    adaptor.addChild(root_0, RETURNS337_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:568:7: DEFINE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DEFINE338=(CommonTree)match(input,DEFINE,FOLLOW_DEFINE_in_eid3105); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DEFINE338_tree = (CommonTree)adaptor.dupNode(DEFINE338);


                    adaptor.addChild(root_0, DEFINE338_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:569:7: LOAD
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LOAD339=(CommonTree)match(input,LOAD,FOLLOW_LOAD_in_eid3113); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LOAD339_tree = (CommonTree)adaptor.dupNode(LOAD339);


                    adaptor.addChild(root_0, LOAD339_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:570:7: FILTER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FILTER340=(CommonTree)match(input,FILTER,FOLLOW_FILTER_in_eid3121); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FILTER340_tree = (CommonTree)adaptor.dupNode(FILTER340);


                    adaptor.addChild(root_0, FILTER340_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:571:7: FOREACH
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FOREACH341=(CommonTree)match(input,FOREACH,FOLLOW_FOREACH_in_eid3129); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FOREACH341_tree = (CommonTree)adaptor.dupNode(FOREACH341);


                    adaptor.addChild(root_0, FOREACH341_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:572:7: MATCHES
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    MATCHES342=(CommonTree)match(input,MATCHES,FOLLOW_MATCHES_in_eid3137); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MATCHES342_tree = (CommonTree)adaptor.dupNode(MATCHES342);


                    adaptor.addChild(root_0, MATCHES342_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:573:7: ORDER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ORDER343=(CommonTree)match(input,ORDER,FOLLOW_ORDER_in_eid3145); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ORDER343_tree = (CommonTree)adaptor.dupNode(ORDER343);


                    adaptor.addChild(root_0, ORDER343_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:574:7: DISTINCT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DISTINCT344=(CommonTree)match(input,DISTINCT,FOLLOW_DISTINCT_in_eid3153); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DISTINCT344_tree = (CommonTree)adaptor.dupNode(DISTINCT344);


                    adaptor.addChild(root_0, DISTINCT344_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 11 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:575:7: COGROUP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    COGROUP345=(CommonTree)match(input,COGROUP,FOLLOW_COGROUP_in_eid3161); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    COGROUP345_tree = (CommonTree)adaptor.dupNode(COGROUP345);


                    adaptor.addChild(root_0, COGROUP345_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 12 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:576:7: JOIN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    JOIN346=(CommonTree)match(input,JOIN,FOLLOW_JOIN_in_eid3169); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    JOIN346_tree = (CommonTree)adaptor.dupNode(JOIN346);


                    adaptor.addChild(root_0, JOIN346_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 13 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:577:7: CROSS
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CROSS347=(CommonTree)match(input,CROSS,FOLLOW_CROSS_in_eid3177); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CROSS347_tree = (CommonTree)adaptor.dupNode(CROSS347);


                    adaptor.addChild(root_0, CROSS347_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 14 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:578:7: UNION
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    UNION348=(CommonTree)match(input,UNION,FOLLOW_UNION_in_eid3185); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    UNION348_tree = (CommonTree)adaptor.dupNode(UNION348);


                    adaptor.addChild(root_0, UNION348_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 15 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:579:7: SPLIT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    SPLIT349=(CommonTree)match(input,SPLIT,FOLLOW_SPLIT_in_eid3193); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SPLIT349_tree = (CommonTree)adaptor.dupNode(SPLIT349);


                    adaptor.addChild(root_0, SPLIT349_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 16 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:580:7: INTO
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INTO350=(CommonTree)match(input,INTO,FOLLOW_INTO_in_eid3201); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INTO350_tree = (CommonTree)adaptor.dupNode(INTO350);


                    adaptor.addChild(root_0, INTO350_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 17 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:581:7: IF
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IF351=(CommonTree)match(input,IF,FOLLOW_IF_in_eid3209); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IF351_tree = (CommonTree)adaptor.dupNode(IF351);


                    adaptor.addChild(root_0, IF351_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 18 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:582:7: ALL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ALL352=(CommonTree)match(input,ALL,FOLLOW_ALL_in_eid3217); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ALL352_tree = (CommonTree)adaptor.dupNode(ALL352);


                    adaptor.addChild(root_0, ALL352_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 19 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:583:7: AS
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    AS353=(CommonTree)match(input,AS,FOLLOW_AS_in_eid3225); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    AS353_tree = (CommonTree)adaptor.dupNode(AS353);


                    adaptor.addChild(root_0, AS353_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 20 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:584:7: BY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BY354=(CommonTree)match(input,BY,FOLLOW_BY_in_eid3233); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BY354_tree = (CommonTree)adaptor.dupNode(BY354);


                    adaptor.addChild(root_0, BY354_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 21 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:585:7: USING
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    USING355=(CommonTree)match(input,USING,FOLLOW_USING_in_eid3241); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    USING355_tree = (CommonTree)adaptor.dupNode(USING355);


                    adaptor.addChild(root_0, USING355_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 22 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:586:7: INNER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INNER356=(CommonTree)match(input,INNER,FOLLOW_INNER_in_eid3249); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INNER356_tree = (CommonTree)adaptor.dupNode(INNER356);


                    adaptor.addChild(root_0, INNER356_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 23 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:587:7: OUTER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    OUTER357=(CommonTree)match(input,OUTER,FOLLOW_OUTER_in_eid3257); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OUTER357_tree = (CommonTree)adaptor.dupNode(OUTER357);


                    adaptor.addChild(root_0, OUTER357_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 24 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:588:7: PARALLEL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    PARALLEL358=(CommonTree)match(input,PARALLEL,FOLLOW_PARALLEL_in_eid3265); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PARALLEL358_tree = (CommonTree)adaptor.dupNode(PARALLEL358);


                    adaptor.addChild(root_0, PARALLEL358_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 25 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:589:7: PARTITION
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    PARTITION359=(CommonTree)match(input,PARTITION,FOLLOW_PARTITION_in_eid3273); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PARTITION359_tree = (CommonTree)adaptor.dupNode(PARTITION359);


                    adaptor.addChild(root_0, PARTITION359_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 26 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:590:7: GROUP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    GROUP360=(CommonTree)match(input,GROUP,FOLLOW_GROUP_in_eid3281); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    GROUP360_tree = (CommonTree)adaptor.dupNode(GROUP360);


                    adaptor.addChild(root_0, GROUP360_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 27 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:591:7: AND
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    AND361=(CommonTree)match(input,AND,FOLLOW_AND_in_eid3289); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    AND361_tree = (CommonTree)adaptor.dupNode(AND361);


                    adaptor.addChild(root_0, AND361_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 28 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:592:7: OR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    OR362=(CommonTree)match(input,OR,FOLLOW_OR_in_eid3297); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OR362_tree = (CommonTree)adaptor.dupNode(OR362);


                    adaptor.addChild(root_0, OR362_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 29 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:593:7: NOT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    NOT363=(CommonTree)match(input,NOT,FOLLOW_NOT_in_eid3305); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NOT363_tree = (CommonTree)adaptor.dupNode(NOT363);


                    adaptor.addChild(root_0, NOT363_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 30 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:594:7: GENERATE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    GENERATE364=(CommonTree)match(input,GENERATE,FOLLOW_GENERATE_in_eid3313); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    GENERATE364_tree = (CommonTree)adaptor.dupNode(GENERATE364);


                    adaptor.addChild(root_0, GENERATE364_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 31 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:595:7: FLATTEN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FLATTEN365=(CommonTree)match(input,FLATTEN,FOLLOW_FLATTEN_in_eid3321); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FLATTEN365_tree = (CommonTree)adaptor.dupNode(FLATTEN365);


                    adaptor.addChild(root_0, FLATTEN365_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 32 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:596:7: EVAL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    EVAL366=(CommonTree)match(input,EVAL,FOLLOW_EVAL_in_eid3329); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EVAL366_tree = (CommonTree)adaptor.dupNode(EVAL366);


                    adaptor.addChild(root_0, EVAL366_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 33 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:597:7: ASC
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ASC367=(CommonTree)match(input,ASC,FOLLOW_ASC_in_eid3337); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ASC367_tree = (CommonTree)adaptor.dupNode(ASC367);


                    adaptor.addChild(root_0, ASC367_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 34 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:598:7: DESC
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DESC368=(CommonTree)match(input,DESC,FOLLOW_DESC_in_eid3345); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DESC368_tree = (CommonTree)adaptor.dupNode(DESC368);


                    adaptor.addChild(root_0, DESC368_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 35 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:599:7: BOOLEAN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BOOLEAN369=(CommonTree)match(input,BOOLEAN,FOLLOW_BOOLEAN_in_eid3353); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BOOLEAN369_tree = (CommonTree)adaptor.dupNode(BOOLEAN369);


                    adaptor.addChild(root_0, BOOLEAN369_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 36 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:600:7: INT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INT370=(CommonTree)match(input,INT,FOLLOW_INT_in_eid3361); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INT370_tree = (CommonTree)adaptor.dupNode(INT370);


                    adaptor.addChild(root_0, INT370_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 37 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:601:7: LONG
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LONG371=(CommonTree)match(input,LONG,FOLLOW_LONG_in_eid3369); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LONG371_tree = (CommonTree)adaptor.dupNode(LONG371);


                    adaptor.addChild(root_0, LONG371_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 38 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:602:7: FLOAT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FLOAT372=(CommonTree)match(input,FLOAT,FOLLOW_FLOAT_in_eid3377); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FLOAT372_tree = (CommonTree)adaptor.dupNode(FLOAT372);


                    adaptor.addChild(root_0, FLOAT372_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 39 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:603:7: DOUBLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DOUBLE373=(CommonTree)match(input,DOUBLE,FOLLOW_DOUBLE_in_eid3385); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DOUBLE373_tree = (CommonTree)adaptor.dupNode(DOUBLE373);


                    adaptor.addChild(root_0, DOUBLE373_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 40 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:604:7: CHARARRAY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CHARARRAY374=(CommonTree)match(input,CHARARRAY,FOLLOW_CHARARRAY_in_eid3393); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CHARARRAY374_tree = (CommonTree)adaptor.dupNode(CHARARRAY374);


                    adaptor.addChild(root_0, CHARARRAY374_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 41 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:605:7: BYTEARRAY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BYTEARRAY375=(CommonTree)match(input,BYTEARRAY,FOLLOW_BYTEARRAY_in_eid3401); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BYTEARRAY375_tree = (CommonTree)adaptor.dupNode(BYTEARRAY375);


                    adaptor.addChild(root_0, BYTEARRAY375_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 42 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:606:7: BAG
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BAG376=(CommonTree)match(input,BAG,FOLLOW_BAG_in_eid3409); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BAG376_tree = (CommonTree)adaptor.dupNode(BAG376);


                    adaptor.addChild(root_0, BAG376_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 43 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:607:7: TUPLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TUPLE377=(CommonTree)match(input,TUPLE,FOLLOW_TUPLE_in_eid3417); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TUPLE377_tree = (CommonTree)adaptor.dupNode(TUPLE377);


                    adaptor.addChild(root_0, TUPLE377_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 44 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:608:7: MAP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    MAP378=(CommonTree)match(input,MAP,FOLLOW_MAP_in_eid3425); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MAP378_tree = (CommonTree)adaptor.dupNode(MAP378);


                    adaptor.addChild(root_0, MAP378_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 45 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:609:7: IS
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IS379=(CommonTree)match(input,IS,FOLLOW_IS_in_eid3433); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IS379_tree = (CommonTree)adaptor.dupNode(IS379);


                    adaptor.addChild(root_0, IS379_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 46 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:610:7: NULL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    NULL380=(CommonTree)match(input,NULL,FOLLOW_NULL_in_eid3441); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NULL380_tree = (CommonTree)adaptor.dupNode(NULL380);


                    adaptor.addChild(root_0, NULL380_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 47 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:611:7: TRUE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TRUE381=(CommonTree)match(input,TRUE,FOLLOW_TRUE_in_eid3449); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TRUE381_tree = (CommonTree)adaptor.dupNode(TRUE381);


                    adaptor.addChild(root_0, TRUE381_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 48 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:612:7: FALSE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FALSE382=(CommonTree)match(input,FALSE,FOLLOW_FALSE_in_eid3457); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FALSE382_tree = (CommonTree)adaptor.dupNode(FALSE382);


                    adaptor.addChild(root_0, FALSE382_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 49 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:613:7: STREAM
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STREAM383=(CommonTree)match(input,STREAM,FOLLOW_STREAM_in_eid3465); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STREAM383_tree = (CommonTree)adaptor.dupNode(STREAM383);


                    adaptor.addChild(root_0, STREAM383_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 50 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:614:7: THROUGH
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    THROUGH384=(CommonTree)match(input,THROUGH,FOLLOW_THROUGH_in_eid3473); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    THROUGH384_tree = (CommonTree)adaptor.dupNode(THROUGH384);


                    adaptor.addChild(root_0, THROUGH384_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 51 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:615:7: STORE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STORE385=(CommonTree)match(input,STORE,FOLLOW_STORE_in_eid3481); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STORE385_tree = (CommonTree)adaptor.dupNode(STORE385);


                    adaptor.addChild(root_0, STORE385_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 52 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:616:7: MAPREDUCE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    MAPREDUCE386=(CommonTree)match(input,MAPREDUCE,FOLLOW_MAPREDUCE_in_eid3489); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MAPREDUCE386_tree = (CommonTree)adaptor.dupNode(MAPREDUCE386);


                    adaptor.addChild(root_0, MAPREDUCE386_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 53 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:617:7: SHIP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    SHIP387=(CommonTree)match(input,SHIP,FOLLOW_SHIP_in_eid3497); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SHIP387_tree = (CommonTree)adaptor.dupNode(SHIP387);


                    adaptor.addChild(root_0, SHIP387_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 54 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:618:7: CACHE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CACHE388=(CommonTree)match(input,CACHE,FOLLOW_CACHE_in_eid3505); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CACHE388_tree = (CommonTree)adaptor.dupNode(CACHE388);


                    adaptor.addChild(root_0, CACHE388_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 55 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:619:7: INPUT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INPUT389=(CommonTree)match(input,INPUT,FOLLOW_INPUT_in_eid3513); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INPUT389_tree = (CommonTree)adaptor.dupNode(INPUT389);


                    adaptor.addChild(root_0, INPUT389_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 56 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:620:7: OUTPUT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    OUTPUT390=(CommonTree)match(input,OUTPUT,FOLLOW_OUTPUT_in_eid3521); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OUTPUT390_tree = (CommonTree)adaptor.dupNode(OUTPUT390);


                    adaptor.addChild(root_0, OUTPUT390_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 57 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:621:7: STDERROR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STDERROR391=(CommonTree)match(input,STDERROR,FOLLOW_STDERROR_in_eid3529); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDERROR391_tree = (CommonTree)adaptor.dupNode(STDERROR391);


                    adaptor.addChild(root_0, STDERROR391_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 58 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:622:7: STDIN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STDIN392=(CommonTree)match(input,STDIN,FOLLOW_STDIN_in_eid3537); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDIN392_tree = (CommonTree)adaptor.dupNode(STDIN392);


                    adaptor.addChild(root_0, STDIN392_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 59 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:623:7: STDOUT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STDOUT393=(CommonTree)match(input,STDOUT,FOLLOW_STDOUT_in_eid3545); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDOUT393_tree = (CommonTree)adaptor.dupNode(STDOUT393);


                    adaptor.addChild(root_0, STDOUT393_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 60 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:624:7: LIMIT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LIMIT394=(CommonTree)match(input,LIMIT,FOLLOW_LIMIT_in_eid3553); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LIMIT394_tree = (CommonTree)adaptor.dupNode(LIMIT394);


                    adaptor.addChild(root_0, LIMIT394_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 61 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:625:7: SAMPLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    SAMPLE395=(CommonTree)match(input,SAMPLE,FOLLOW_SAMPLE_in_eid3561); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SAMPLE395_tree = (CommonTree)adaptor.dupNode(SAMPLE395);


                    adaptor.addChild(root_0, SAMPLE395_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 62 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:626:7: LEFT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LEFT396=(CommonTree)match(input,LEFT,FOLLOW_LEFT_in_eid3569); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LEFT396_tree = (CommonTree)adaptor.dupNode(LEFT396);


                    adaptor.addChild(root_0, LEFT396_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 63 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:627:7: RIGHT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    RIGHT397=(CommonTree)match(input,RIGHT,FOLLOW_RIGHT_in_eid3577); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RIGHT397_tree = (CommonTree)adaptor.dupNode(RIGHT397);


                    adaptor.addChild(root_0, RIGHT397_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 64 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:628:7: FULL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FULL398=(CommonTree)match(input,FULL,FOLLOW_FULL_in_eid3585); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FULL398_tree = (CommonTree)adaptor.dupNode(FULL398);


                    adaptor.addChild(root_0, FULL398_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 65 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:629:7: IDENTIFIER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER399=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_eid3593); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER399_tree = (CommonTree)adaptor.dupNode(IDENTIFIER399);


                    adaptor.addChild(root_0, IDENTIFIER399_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 66 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:630:7: TOBAG
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TOBAG400=(CommonTree)match(input,TOBAG,FOLLOW_TOBAG_in_eid3601); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TOBAG400_tree = (CommonTree)adaptor.dupNode(TOBAG400);


                    adaptor.addChild(root_0, TOBAG400_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 67 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:631:7: TOMAP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TOMAP401=(CommonTree)match(input,TOMAP,FOLLOW_TOMAP_in_eid3609); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TOMAP401_tree = (CommonTree)adaptor.dupNode(TOMAP401);


                    adaptor.addChild(root_0, TOMAP401_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 68 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:632:7: TOTUPLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TOTUPLE402=(CommonTree)match(input,TOTUPLE,FOLLOW_TOTUPLE_in_eid3617); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TOTUPLE402_tree = (CommonTree)adaptor.dupNode(TOTUPLE402);


                    adaptor.addChild(root_0, TOTUPLE402_tree);
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
    // $ANTLR end "eid"


    public static class rel_op_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_op"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:636:1: rel_op : ( rel_op_eq | rel_op_ne | rel_op_gt | rel_op_gte | rel_op_lt | rel_op_lte | STR_OP_MATCHES );
    public final AliasMasker.rel_op_return rel_op() throws RecognitionException {
        AliasMasker.rel_op_return retval = new AliasMasker.rel_op_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STR_OP_MATCHES409=null;
        AliasMasker.rel_op_eq_return rel_op_eq403 =null;

        AliasMasker.rel_op_ne_return rel_op_ne404 =null;

        AliasMasker.rel_op_gt_return rel_op_gt405 =null;

        AliasMasker.rel_op_gte_return rel_op_gte406 =null;

        AliasMasker.rel_op_lt_return rel_op_lt407 =null;

        AliasMasker.rel_op_lte_return rel_op_lte408 =null;


        CommonTree STR_OP_MATCHES409_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:637:5: ( rel_op_eq | rel_op_ne | rel_op_gt | rel_op_gte | rel_op_lt | rel_op_lte | STR_OP_MATCHES )
            int alt96=7;
            switch ( input.LA(1) ) {
            case NUM_OP_EQ:
            case STR_OP_EQ:
                {
                alt96=1;
                }
                break;
            case NUM_OP_NE:
            case STR_OP_NE:
                {
                alt96=2;
                }
                break;
            case NUM_OP_GT:
            case STR_OP_GT:
                {
                alt96=3;
                }
                break;
            case NUM_OP_GTE:
            case STR_OP_GTE:
                {
                alt96=4;
                }
                break;
            case NUM_OP_LT:
            case STR_OP_LT:
                {
                alt96=5;
                }
                break;
            case NUM_OP_LTE:
            case STR_OP_LTE:
                {
                alt96=6;
                }
                break;
            case STR_OP_MATCHES:
                {
                alt96=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 96, 0, input);

                throw nvae;

            }

            switch (alt96) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:637:7: rel_op_eq
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_eq_in_rel_op3631);
                    rel_op_eq403=rel_op_eq();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_eq403.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:638:7: rel_op_ne
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_ne_in_rel_op3639);
                    rel_op_ne404=rel_op_ne();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_ne404.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:639:7: rel_op_gt
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_gt_in_rel_op3647);
                    rel_op_gt405=rel_op_gt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_gt405.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:640:7: rel_op_gte
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_gte_in_rel_op3655);
                    rel_op_gte406=rel_op_gte();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_gte406.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:641:7: rel_op_lt
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_lt_in_rel_op3663);
                    rel_op_lt407=rel_op_lt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_lt407.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:642:7: rel_op_lte
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_lte_in_rel_op3671);
                    rel_op_lte408=rel_op_lte();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_lte408.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:643:7: STR_OP_MATCHES
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_MATCHES409=(CommonTree)match(input,STR_OP_MATCHES,FOLLOW_STR_OP_MATCHES_in_rel_op3679); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_MATCHES409_tree = (CommonTree)adaptor.dupNode(STR_OP_MATCHES409);


                    adaptor.addChild(root_0, STR_OP_MATCHES409_tree);
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
    // $ANTLR end "rel_op"


    public static class rel_op_eq_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_op_eq"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:646:1: rel_op_eq : ( STR_OP_EQ | NUM_OP_EQ );
    public final AliasMasker.rel_op_eq_return rel_op_eq() throws RecognitionException {
        AliasMasker.rel_op_eq_return retval = new AliasMasker.rel_op_eq_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set410=null;

        CommonTree set410_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:647:5: ( STR_OP_EQ | NUM_OP_EQ )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set410=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_EQ||input.LA(1)==STR_OP_EQ ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set410_tree = (CommonTree)adaptor.dupNode(set410);


                adaptor.addChild(root_0, set410_tree);
                }

                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
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
    // $ANTLR end "rel_op_eq"


    public static class rel_op_ne_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_op_ne"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:651:1: rel_op_ne : ( STR_OP_NE | NUM_OP_NE );
    public final AliasMasker.rel_op_ne_return rel_op_ne() throws RecognitionException {
        AliasMasker.rel_op_ne_return retval = new AliasMasker.rel_op_ne_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set411=null;

        CommonTree set411_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:652:5: ( STR_OP_NE | NUM_OP_NE )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set411=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_NE||input.LA(1)==STR_OP_NE ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set411_tree = (CommonTree)adaptor.dupNode(set411);


                adaptor.addChild(root_0, set411_tree);
                }

                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
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
    // $ANTLR end "rel_op_ne"


    public static class rel_op_gt_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_op_gt"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:656:1: rel_op_gt : ( STR_OP_GT | NUM_OP_GT );
    public final AliasMasker.rel_op_gt_return rel_op_gt() throws RecognitionException {
        AliasMasker.rel_op_gt_return retval = new AliasMasker.rel_op_gt_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set412=null;

        CommonTree set412_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:657:5: ( STR_OP_GT | NUM_OP_GT )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set412=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_GT||input.LA(1)==STR_OP_GT ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set412_tree = (CommonTree)adaptor.dupNode(set412);


                adaptor.addChild(root_0, set412_tree);
                }

                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
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
    // $ANTLR end "rel_op_gt"


    public static class rel_op_gte_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_op_gte"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:661:1: rel_op_gte : ( STR_OP_GTE | NUM_OP_GTE );
    public final AliasMasker.rel_op_gte_return rel_op_gte() throws RecognitionException {
        AliasMasker.rel_op_gte_return retval = new AliasMasker.rel_op_gte_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set413=null;

        CommonTree set413_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:662:5: ( STR_OP_GTE | NUM_OP_GTE )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set413=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_GTE||input.LA(1)==STR_OP_GTE ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set413_tree = (CommonTree)adaptor.dupNode(set413);


                adaptor.addChild(root_0, set413_tree);
                }

                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
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
    // $ANTLR end "rel_op_gte"


    public static class rel_op_lt_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_op_lt"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:666:1: rel_op_lt : ( STR_OP_LT | NUM_OP_LT );
    public final AliasMasker.rel_op_lt_return rel_op_lt() throws RecognitionException {
        AliasMasker.rel_op_lt_return retval = new AliasMasker.rel_op_lt_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set414=null;

        CommonTree set414_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:667:5: ( STR_OP_LT | NUM_OP_LT )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set414=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_LT||input.LA(1)==STR_OP_LT ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set414_tree = (CommonTree)adaptor.dupNode(set414);


                adaptor.addChild(root_0, set414_tree);
                }

                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
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
    // $ANTLR end "rel_op_lt"


    public static class rel_op_lte_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_op_lte"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:671:1: rel_op_lte : ( STR_OP_LTE | NUM_OP_LTE );
    public final AliasMasker.rel_op_lte_return rel_op_lte() throws RecognitionException {
        AliasMasker.rel_op_lte_return retval = new AliasMasker.rel_op_lte_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set415=null;

        CommonTree set415_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:672:5: ( STR_OP_LTE | NUM_OP_LTE )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set415=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_LTE||input.LA(1)==STR_OP_LTE ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set415_tree = (CommonTree)adaptor.dupNode(set415);


                adaptor.addChild(root_0, set415_tree);
                }

                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
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
    // $ANTLR end "rel_op_lte"


    public static class rel_str_op_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_str_op"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:676:1: rel_str_op : ( STR_OP_EQ | STR_OP_NE | STR_OP_GT | STR_OP_LT | STR_OP_GTE | STR_OP_LTE | STR_OP_MATCHES );
    public final AliasMasker.rel_str_op_return rel_str_op() throws RecognitionException {
        AliasMasker.rel_str_op_return retval = new AliasMasker.rel_str_op_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set416=null;

        CommonTree set416_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:677:5: ( STR_OP_EQ | STR_OP_NE | STR_OP_GT | STR_OP_LT | STR_OP_GTE | STR_OP_LTE | STR_OP_MATCHES )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set416=(CommonTree)input.LT(1);

            if ( (input.LA(1) >= STR_OP_EQ && input.LA(1) <= STR_OP_NE) ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set416_tree = (CommonTree)adaptor.dupNode(set416);


                adaptor.addChild(root_0, set416_tree);
                }

                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
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
    // $ANTLR end "rel_str_op"

    // $ANTLR start synpred88_AliasMasker
    public final void synpred88_AliasMasker_fragment() throws RecognitionException {
        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:298:7: ( ^( CAST_EXPR type expr ) )
        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:298:7: ^( CAST_EXPR type expr )
        {
        match(input,CAST_EXPR,FOLLOW_CAST_EXPR_in_synpred88_AliasMasker1482); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        pushFollow(FOLLOW_type_in_synpred88_AliasMasker1484);
        type();

        state._fsp--;
        if (state.failed) return ;

        pushFollow(FOLLOW_expr_in_synpred88_AliasMasker1486);
        expr();

        state._fsp--;
        if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;


        }

    }
    // $ANTLR end synpred88_AliasMasker

    // $ANTLR start synpred92_AliasMasker
    public final void synpred92_AliasMasker_fragment() throws RecognitionException {
        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:302:7: ( ^( CAST_EXPR type_cast expr ) )
        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:302:7: ^( CAST_EXPR type_cast expr )
        {
        match(input,CAST_EXPR,FOLLOW_CAST_EXPR_in_synpred92_AliasMasker1528); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        pushFollow(FOLLOW_type_cast_in_synpred92_AliasMasker1530);
        type_cast();

        state._fsp--;
        if (state.failed) return ;

        pushFollow(FOLLOW_expr_in_synpred92_AliasMasker1532);
        expr();

        state._fsp--;
        if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;


        }

    }
    // $ANTLR end synpred92_AliasMasker

    // $ANTLR start synpred108_AliasMasker
    public final void synpred108_AliasMasker_fragment() throws RecognitionException {
        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:354:22: ( INTEGER )
        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:354:22: INTEGER
        {
        match(input,INTEGER,FOLLOW_INTEGER_in_synpred108_AliasMasker1832); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred108_AliasMasker

    // $ANTLR start synpred109_AliasMasker
    public final void synpred109_AliasMasker_fragment() throws RecognitionException {
        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:354:32: ( LONGINTEGER )
        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:354:32: LONGINTEGER
        {
        match(input,LONGINTEGER,FOLLOW_LONGINTEGER_in_synpred109_AliasMasker1836); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred109_AliasMasker

    // $ANTLR start synpred110_AliasMasker
    public final void synpred110_AliasMasker_fragment() throws RecognitionException {
        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:358:24: ( DOUBLENUMBER )
        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:358:24: DOUBLENUMBER
        {
        match(input,DOUBLENUMBER,FOLLOW_DOUBLENUMBER_in_synpred110_AliasMasker1867); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred110_AliasMasker

    // $ANTLR start synpred127_AliasMasker
    public final void synpred127_AliasMasker_fragment() throws RecognitionException {
        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:398:7: ( join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item )
        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:398:7: join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item
        {
        pushFollow(FOLLOW_join_item_in_synpred127_AliasMasker2105);
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


        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:401:16: ( OUTER )?
        int alt102=2;
        int LA102_0 = input.LA(1);

        if ( (LA102_0==OUTER) ) {
            alt102=1;
        }
        switch (alt102) {
            case 1 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:401:16: OUTER
                {
                match(input,OUTER,FOLLOW_OUTER_in_synpred127_AliasMasker2163); if (state.failed) return ;

                }
                break;

        }


        pushFollow(FOLLOW_join_item_in_synpred127_AliasMasker2166);
        join_item();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred127_AliasMasker

    // $ANTLR start synpred145_AliasMasker
    public final void synpred145_AliasMasker_fragment() throws RecognitionException {
        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:469:34: ( INTEGER )
        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AliasMasker.g:469:34: INTEGER
        {
        match(input,INTEGER,FOLLOW_INTEGER_in_synpred145_AliasMasker2621); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred145_AliasMasker

    // Delegated rules

    public final boolean synpred145_AliasMasker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred145_AliasMasker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred127_AliasMasker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred127_AliasMasker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred109_AliasMasker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred109_AliasMasker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred92_AliasMasker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred92_AliasMasker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred110_AliasMasker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred110_AliasMasker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred108_AliasMasker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred108_AliasMasker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred88_AliasMasker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred88_AliasMasker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_QUERY_in_query81 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_query83 = new BitSet(new long[]{0x0000000000000008L,0x0000000200000000L,0x0000000000900000L});
    public static final BitSet FOLLOW_general_statement_in_statement95 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_split_statement_in_statement109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_realias_statement_in_statement123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_split_clause_in_split_statement132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_realias_clause_in_realias_statement141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STATEMENT_in_general_statement158 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_general_statement162 = new BitSet(new long[]{0x46080121004A4000L,0x000400C210000800L});
    public static final BitSet FOLLOW_op_clause_in_general_statement176 = new BitSet(new long[]{0x0000000000000008L,0x0000000000008000L});
    public static final BitSet FOLLOW_parallel_clause_in_general_statement178 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_REALIAS_in_realias_clause192 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_realias_clause194 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_in_realias_clause196 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PARALLEL_in_parallel_clause213 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INTEGER_in_parallel_clause215 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IDENTIFIER_in_alias232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_define_clause_in_op_clause252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_load_clause_in_op_clause267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_group_clause_in_op_clause281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_store_clause_in_op_clause295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_filter_clause_in_op_clause309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_distinct_clause_in_op_clause323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_limit_clause_in_op_clause337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sample_clause_in_op_clause351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_order_clause_in_op_clause365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cross_clause_in_op_clause379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_join_clause_in_op_clause393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_union_clause_in_op_clause407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stream_clause_in_op_clause421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mr_clause_in_op_clause435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_split_clause_in_op_clause449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_foreach_clause_in_op_clause463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEFINE_in_define_clause479 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_define_clause481 = new BitSet(new long[]{0x0000000040000000L,0x0000000000000000L,0x0000000000000014L});
    public static final BitSet FOLLOW_cmd_in_define_clause486 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_func_clause_in_define_clause490 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXECCOMMAND_in_cmd510 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ship_clause_in_cmd523 = new BitSet(new long[]{0x0000400000001008L,0x0000000840004000L});
    public static final BitSet FOLLOW_cache_clause_in_cmd527 = new BitSet(new long[]{0x0000400000001008L,0x0000000840004000L});
    public static final BitSet FOLLOW_input_clause_in_cmd531 = new BitSet(new long[]{0x0000400000001008L,0x0000000840004000L});
    public static final BitSet FOLLOW_output_clause_in_cmd535 = new BitSet(new long[]{0x0000400000001008L,0x0000000840004000L});
    public static final BitSet FOLLOW_error_clause_in_cmd539 = new BitSet(new long[]{0x0000400000001008L,0x0000000840004000L});
    public static final BitSet FOLLOW_SHIP_in_ship_clause560 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_path_list_in_ship_clause562 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_path_list579 = new BitSet(new long[]{0x0000000000000002L,0x0000000000400000L});
    public static final BitSet FOLLOW_CACHE_in_cache_clause597 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_path_list_in_cache_clause599 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INPUT_in_input_clause617 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_stream_cmd_in_input_clause619 = new BitSet(new long[]{0x0000000000000008L,0x0000003000400000L});
    public static final BitSet FOLLOW_STDIN_in_stream_cmd638 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_clause_in_stream_cmd640 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STDOUT_in_stream_cmd653 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_clause_in_stream_cmd655 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_stream_cmd668 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_clause_in_stream_cmd670 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OUTPUT_in_output_clause689 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_stream_cmd_in_output_clause691 = new BitSet(new long[]{0x0000000000000008L,0x0000003000400000L});
    public static final BitSet FOLLOW_STDERROR_in_error_clause710 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_error_clause714 = new BitSet(new long[]{0x0001000000000008L});
    public static final BitSet FOLLOW_INTEGER_in_error_clause716 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LOAD_in_load_clause738 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_filename_in_load_clause740 = new BitSet(new long[]{0x0000000000000048L,0x0000000000000000L,0x0000000000000014L});
    public static final BitSet FOLLOW_func_clause_in_load_clause742 = new BitSet(new long[]{0x0000000000000048L});
    public static final BitSet FOLLOW_as_clause_in_load_clause745 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_filename762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AS_in_as_clause788 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_field_def_list_in_as_clause790 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FIELD_DEF_in_field_def807 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_field_def809 = new BitSet(new long[]{0x0800800404002A08L,0x0080000000000000L,0x0000000008000800L});
    public static final BitSet FOLLOW_type_in_field_def811 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_field_def_in_field_def_list829 = new BitSet(new long[]{0x0000000000000002L,0x8000000000000000L});
    public static final BitSet FOLLOW_simple_type_in_type840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tuple_type_in_type844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bag_type_in_type848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_map_type_in_type852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TUPLE_TYPE_in_tuple_type907 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_field_def_list_in_tuple_type909 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BAG_TYPE_in_bag_type928 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_bag_type930 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_tuple_type_in_bag_type933 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MAP_TYPE_in_map_type947 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_in_map_type949 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNC_REF_in_func_clause968 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_func_clause970 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNC_in_func_clause982 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_func_clause984 = new BitSet(new long[]{0x0000000000000008L,0x0000000000400000L});
    public static final BitSet FOLLOW_func_args_in_func_clause986 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_eid_in_func_name1003 = new BitSet(new long[]{0x0000000001000002L,0x0000000000040000L});
    public static final BitSet FOLLOW_set_in_func_name1007 = new BitSet(new long[]{0x6E1EF9E7845A7FF0L,0x000FFFFA5181EC04L,0x00000000C7020020L});
    public static final BitSet FOLLOW_eid_in_func_name1017 = new BitSet(new long[]{0x0000000001000002L,0x0000000000040000L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_func_args1034 = new BitSet(new long[]{0x0000000000000002L,0x0000000000400000L});
    public static final BitSet FOLLOW_set_in_group_clause1051 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_group_item_in_group_clause1061 = new BitSet(new long[]{0x46080121004A4008L,0x000400C210410800L,0x0000000000000020L});
    public static final BitSet FOLLOW_group_type_in_group_clause1064 = new BitSet(new long[]{0x0000000000000008L,0x0000000000010000L});
    public static final BitSet FOLLOW_partition_clause_in_group_clause1067 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_group_type1079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_in_group_item1093 = new BitSet(new long[]{0x0000000000000410L,0x0040000000000000L});
    public static final BitSet FOLLOW_join_group_by_clause_in_group_item1097 = new BitSet(new long[]{0x0000200000000002L,0x0000000000002000L});
    public static final BitSet FOLLOW_ALL_in_group_item1101 = new BitSet(new long[]{0x0000200000000002L,0x0000000000002000L});
    public static final BitSet FOLLOW_ANY_in_group_item1105 = new BitSet(new long[]{0x0000200000000002L,0x0000000000002000L});
    public static final BitSet FOLLOW_alias_in_rel1132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_op_clause_in_rel1138 = new BitSet(new long[]{0x0000000000000002L,0x0000000000008000L});
    public static final BitSet FOLLOW_parallel_clause_in_rel1140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_flatten_clause_in_flatten_generated_item1169 = new BitSet(new long[]{0x0000000000000002L,0x8000000000000000L});
    public static final BitSet FOLLOW_col_range_in_flatten_generated_item1173 = new BitSet(new long[]{0x0000000000000002L,0x8000000000000000L});
    public static final BitSet FOLLOW_expr_in_flatten_generated_item1177 = new BitSet(new long[]{0x0000000000000002L,0x8000000000000000L});
    public static final BitSet FOLLOW_STAR_in_flatten_generated_item1181 = new BitSet(new long[]{0x0000000000000002L,0x8000000000000000L});
    public static final BitSet FOLLOW_field_def_list_in_flatten_generated_item1185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLATTEN_in_flatten_clause1202 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_flatten_clause1204 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STORE_in_store_clause1222 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_store_clause1224 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_filename_in_store_clause1226 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000000000014L});
    public static final BitSet FOLLOW_func_clause_in_store_clause1228 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FILTER_in_filter_clause1247 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_filter_clause1249 = new BitSet(new long[]{0x0000000000000020L,0x00007F00000005FCL,0x0000000000020008L});
    public static final BitSet FOLLOW_cond_in_filter_clause1251 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OR_in_cond1269 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_cond1271 = new BitSet(new long[]{0x0000000000000020L,0x00007F00000005FCL,0x0000000000020008L});
    public static final BitSet FOLLOW_cond_in_cond1273 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AND_in_cond1285 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_cond1287 = new BitSet(new long[]{0x0000000000000020L,0x00007F00000005FCL,0x0000000000020008L});
    public static final BitSet FOLLOW_cond_in_cond1289 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NOT_in_cond1301 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_cond1303 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NULL_in_cond1315 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond1317 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000004L});
    public static final BitSet FOLLOW_NOT_in_cond1319 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rel_op_in_cond1332 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond1334 = new BitSet(new long[]{0x900101108A800000L,0x56010004004A0000L,0x0000000020023028L});
    public static final BitSet FOLLOW_expr_in_cond1336 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_func_eval_in_cond1346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FUNC_EVAL_in_func_eval1361 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_func_eval1363 = new BitSet(new long[]{0x900101108A800008L,0x56010004004A0000L,0x0000000020023028L});
    public static final BitSet FOLLOW_real_arg_in_func_eval1365 = new BitSet(new long[]{0x900101108A800008L,0x56010004004A0000L,0x0000000020023028L});
    public static final BitSet FOLLOW_expr_in_real_arg1382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_real_arg1386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUS_in_expr1402 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1404 = new BitSet(new long[]{0x900101108A800000L,0x56010004004A0000L,0x0000000020023028L});
    public static final BitSet FOLLOW_expr_in_expr1406 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MINUS_in_expr1418 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1420 = new BitSet(new long[]{0x900101108A800000L,0x56010004004A0000L,0x0000000020023028L});
    public static final BitSet FOLLOW_expr_in_expr1422 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STAR_in_expr1434 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1436 = new BitSet(new long[]{0x900101108A800000L,0x56010004004A0000L,0x0000000020023028L});
    public static final BitSet FOLLOW_expr_in_expr1438 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DIV_in_expr1450 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1452 = new BitSet(new long[]{0x900101108A800000L,0x56010004004A0000L,0x0000000020023028L});
    public static final BitSet FOLLOW_expr_in_expr1454 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PERCENT_in_expr1466 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1468 = new BitSet(new long[]{0x900101108A800000L,0x56010004004A0000L,0x0000000020023028L});
    public static final BitSet FOLLOW_expr_in_expr1470 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CAST_EXPR_in_expr1482 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_in_expr1484 = new BitSet(new long[]{0x900101108A800000L,0x56010004004A0000L,0x0000000020023028L});
    public static final BitSet FOLLOW_expr_in_expr1486 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_const_expr_in_expr1496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_var_expr_in_expr1504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEG_in_expr1514 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1516 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CAST_EXPR_in_expr1528 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_cast_in_expr1530 = new BitSet(new long[]{0x900101108A800000L,0x56010004004A0000L,0x0000000020023028L});
    public static final BitSet FOLLOW_expr_in_expr1532 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXPR_IN_PAREN_in_expr1544 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1546 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_simple_type_in_type_cast1562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_map_type_in_type_cast1566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tuple_type_cast_in_type_cast1570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bag_type_cast_in_type_cast1574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TUPLE_TYPE_CAST_in_tuple_type_cast1590 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_cast_in_tuple_type_cast1592 = new BitSet(new long[]{0x0800800404002A08L,0x0100000000000000L,0x0000000010000800L});
    public static final BitSet FOLLOW_BAG_TYPE_CAST_in_bag_type_cast1611 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_tuple_type_cast_in_bag_type_cast1613 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_projectable_expr_in_var_expr1630 = new BitSet(new long[]{0x0000000000000002L,0x0000000000140000L});
    public static final BitSet FOLLOW_dot_proj_in_var_expr1634 = new BitSet(new long[]{0x0000000000000002L,0x0000000000140000L});
    public static final BitSet FOLLOW_pound_proj_in_var_expr1638 = new BitSet(new long[]{0x0000000000000002L,0x0000000000140000L});
    public static final BitSet FOLLOW_func_eval_in_projectable_expr1654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_col_ref_in_projectable_expr1658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bin_expr_in_projectable_expr1662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PERIOD_in_dot_proj1678 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_col_alias_or_index_in_dot_proj1680 = new BitSet(new long[]{0x0000010002000008L,0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_col_alias_in_col_alias_or_index1692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_col_index_in_col_alias_or_index1696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOLLARVAR_in_col_index1733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COL_RANGE_in_col_range1744 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_col_ref_in_col_range1746 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_DOUBLE_PERIOD_in_col_range1749 = new BitSet(new long[]{0x0000010002000008L,0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_col_ref_in_col_range1751 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_POUND_in_pound_proj1769 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_set_in_pound_proj1771 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BIN_EXPR_in_bin_expr1797 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_bin_expr1799 = new BitSet(new long[]{0x900101108A800000L,0x56010004004A0000L,0x0000000020023028L});
    public static final BitSet FOLLOW_expr_in_bin_expr1801 = new BitSet(new long[]{0x900101108A800000L,0x56010004004A0000L,0x0000000020023028L});
    public static final BitSet FOLLOW_expr_in_bin_expr1803 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LIMIT_in_limit_clause1826 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_limit_clause1828 = new BitSet(new long[]{0x900101108A800000L,0x56010004004A0000L,0x0000000020023028L});
    public static final BitSet FOLLOW_INTEGER_in_limit_clause1832 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LONGINTEGER_in_limit_clause1836 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expr_in_limit_clause1840 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SAMPLE_in_sample_clause1861 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_sample_clause1863 = new BitSet(new long[]{0x900101108A800000L,0x56010004004A0000L,0x0000000020023028L});
    public static final BitSet FOLLOW_DOUBLENUMBER_in_sample_clause1867 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expr_in_sample_clause1871 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ORDER_in_order_clause1891 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_order_clause1893 = new BitSet(new long[]{0x0000010002000000L,0x2000000400000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_order_by_clause_in_order_clause1895 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000000000014L});
    public static final BitSet FOLLOW_func_clause_in_order_clause1897 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STAR_in_order_by_clause1914 = new BitSet(new long[]{0x0000000000100082L});
    public static final BitSet FOLLOW_order_col_in_order_by_clause1933 = new BitSet(new long[]{0x0000010002000002L,0x2000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_col_range_in_order_col1949 = new BitSet(new long[]{0x0000000000100082L});
    public static final BitSet FOLLOW_col_ref_in_order_col1953 = new BitSet(new long[]{0x0000000000100082L});
    public static final BitSet FOLLOW_DISTINCT_in_distinct_clause1985 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_distinct_clause1987 = new BitSet(new long[]{0x0000000000000008L,0x0000000000010000L});
    public static final BitSet FOLLOW_partition_clause_in_distinct_clause1989 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PARTITION_in_partition_clause2008 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_partition_clause2010 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CROSS_in_cross_clause2032 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_list_in_cross_clause2034 = new BitSet(new long[]{0x0000000000000008L,0x0000000000010000L});
    public static final BitSet FOLLOW_partition_clause_in_cross_clause2036 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rel_in_rel_list2057 = new BitSet(new long[]{0x46080121004A4002L,0x000400C210000800L,0x0000000000000020L});
    public static final BitSet FOLLOW_JOIN_in_join_clause2073 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_join_sub_clause_in_join_clause2075 = new BitSet(new long[]{0x0000000000000008L,0x0000000000410000L});
    public static final BitSet FOLLOW_join_type_in_join_clause2077 = new BitSet(new long[]{0x0000000000000008L,0x0000000000010000L});
    public static final BitSet FOLLOW_partition_clause_in_join_clause2080 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_join_type2092 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_join_item_in_join_sub_clause2105 = new BitSet(new long[]{0x0010004000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_set_in_join_sub_clause2107 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L,0x0000000000000040L});
    public static final BitSet FOLLOW_OUTER_in_join_sub_clause2163 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_join_item_in_join_sub_clause2166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_join_item_in_join_sub_clause2174 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_JOIN_ITEM_in_join_item2187 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_join_item2189 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_join_group_by_clause_in_join_item2191 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BY_in_join_group_by_clause2208 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_join_group_by_expr_in_join_group_by_clause2210 = new BitSet(new long[]{0x900101108A800008L,0x76010004004A0000L,0x0000000020023028L});
    public static final BitSet FOLLOW_col_range_in_join_group_by_expr2227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_join_group_by_expr2231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_join_group_by_expr2235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNION_in_union_clause2252 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ONSCHEMA_in_union_clause2254 = new BitSet(new long[]{0x46080121004A4000L,0x000400C210000800L,0x0000000000000020L});
    public static final BitSet FOLLOW_rel_list_in_union_clause2257 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_in_foreach_clause2279 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_foreach_clause2281 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000003L});
    public static final BitSet FOLLOW_foreach_plan_in_foreach_clause2283 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_PLAN_SIMPLE_in_foreach_plan2305 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_generate_clause_in_foreach_plan2307 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_PLAN_COMPLEX_in_foreach_plan2319 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_blk_in_foreach_plan2321 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_nested_command_in_nested_blk2336 = new BitSet(new long[]{0x0000008000000000L,0x0000000000000000L,0x000000000000C000L});
    public static final BitSet FOLLOW_generate_clause_in_nested_blk2339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GENERATE_in_generate_clause2355 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_flatten_generated_item_in_generate_clause2357 = new BitSet(new long[]{0x900101128A800008L,0x76010004004A0000L,0x0000000020023028L});
    public static final BitSet FOLLOW_NESTED_CMD_in_nested_command2379 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_nested_command2381 = new BitSet(new long[]{0x0200002100420000L,0x0000000000000800L,0x0000000000010000L});
    public static final BitSet FOLLOW_nested_op_in_nested_command2383 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NESTED_CMD_ASSI_in_nested_command2395 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_nested_command2397 = new BitSet(new long[]{0x900101108A800000L,0x56010004004A0000L,0x0000000020023028L});
    public static final BitSet FOLLOW_expr_in_nested_command2399 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_nested_proj_in_nested_op2410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_filter_in_nested_op2424 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_sort_in_nested_op2438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_distinct_in_nested_op2452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_limit_in_nested_op2466 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_cross_in_nested_op2480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_foreach_in_nested_op2494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NESTED_PROJ_in_nested_proj2510 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_col_ref_in_nested_proj2512 = new BitSet(new long[]{0x0000010002000000L,0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_col_ref_in_nested_proj2514 = new BitSet(new long[]{0x0000010002000008L,0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_FILTER_in_nested_filter2536 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_filter2538 = new BitSet(new long[]{0x0000000000000020L,0x00007F00000005FCL,0x0000000000020008L});
    public static final BitSet FOLLOW_cond_in_nested_filter2540 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ORDER_in_nested_sort2562 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_sort2564 = new BitSet(new long[]{0x0000010002000000L,0x2000000400000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_order_by_clause_in_nested_sort2566 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000000000014L});
    public static final BitSet FOLLOW_func_clause_in_nested_sort2568 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DISTINCT_in_nested_distinct2591 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_distinct2593 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LIMIT_in_nested_limit2615 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_limit2617 = new BitSet(new long[]{0x900101108A800000L,0x56010004004A0000L,0x0000000020023028L});
    public static final BitSet FOLLOW_INTEGER_in_nested_limit2621 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expr_in_nested_limit2625 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CROSS_in_nested_cross2640 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_list_in_nested_cross2642 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_in_nested_foreach2655 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_foreach2657 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_generate_clause_in_nested_foreach2659 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_op_input_list2670 = new BitSet(new long[]{0x0000010002000002L,0x0000000000000000L,0x0000000000010020L});
    public static final BitSet FOLLOW_col_ref_in_nested_op_input2680 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_proj_in_nested_op_input2684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STREAM_in_stream_clause2700 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_stream_clause2702 = new BitSet(new long[]{0x0000000040000000L,0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_set_in_stream_clause2704 = new BitSet(new long[]{0x0000000000000048L});
    public static final BitSet FOLLOW_as_clause_in_stream_clause2714 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MAPREDUCE_in_mr_clause2733 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_mr_clause2735 = new BitSet(new long[]{0x0000000000000000L,0x0000004000400000L});
    public static final BitSet FOLLOW_path_list_in_mr_clause2737 = new BitSet(new long[]{0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_store_clause_in_mr_clause2740 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_load_clause_in_mr_clause2742 = new BitSet(new long[]{0x0000000040000008L});
    public static final BitSet FOLLOW_EXECCOMMAND_in_mr_clause2744 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SPLIT_in_split_clause2763 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_split_clause2765 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_split_branch_in_split_clause2767 = new BitSet(new long[]{0x0000000000000008L,0x0000000000001000L,0x0000000000400000L});
    public static final BitSet FOLLOW_split_otherwise_in_split_clause2770 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SPLIT_BRANCH_in_split_branch2788 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_split_branch2790 = new BitSet(new long[]{0x0000000000000020L,0x00007F00000005FCL,0x0000000000020008L});
    public static final BitSet FOLLOW_cond_in_split_branch2792 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OTHERWISE_in_split_otherwise2810 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_split_otherwise2812 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_alias_col_ref_in_col_ref2824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dollar_col_ref_in_col_ref2828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GROUP_in_alias_col_ref2842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_alias_col_ref2851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOLLARVAR_in_dollar_col_ref2873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_const_expr2882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_scalar_in_literal2891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_map_in_literal2895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bag_in_literal2899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tuple_in_literal2903 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MAP_VAL_in_map2989 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_keyvalue_in_map2991 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_KEY_VAL_PAIR_in_keyvalue3010 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_map_key_in_keyvalue3012 = new BitSet(new long[]{0x1001001088000000L,0x0201000000400000L,0x0000000020021000L});
    public static final BitSet FOLLOW_const_expr_in_keyvalue3014 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_map_key3029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BAG_VAL_in_bag3045 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_tuple_in_bag3047 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_TUPLE_VAL_in_tuple3066 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_literal_in_tuple3068 = new BitSet(new long[]{0x1001001088000008L,0x0201000000400000L,0x0000000020021000L});
    public static final BitSet FOLLOW_rel_str_op_in_eid3081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IMPORT_in_eid3089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RETURNS_in_eid3097 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEFINE_in_eid3105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LOAD_in_eid3113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FILTER_in_eid3121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOREACH_in_eid3129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MATCHES_in_eid3137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ORDER_in_eid3145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DISTINCT_in_eid3153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COGROUP_in_eid3161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_JOIN_in_eid3169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CROSS_in_eid3177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNION_in_eid3185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SPLIT_in_eid3193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTO_in_eid3201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_eid3209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ALL_in_eid3217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AS_in_eid3225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BY_in_eid3233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_USING_in_eid3241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INNER_in_eid3249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OUTER_in_eid3257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARALLEL_in_eid3265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARTITION_in_eid3273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GROUP_in_eid3281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AND_in_eid3289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OR_in_eid3297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_eid3305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GENERATE_in_eid3313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLATTEN_in_eid3321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EVAL_in_eid3329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASC_in_eid3337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESC_in_eid3345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOLEAN_in_eid3353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_eid3361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LONG_in_eid3369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_eid3377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLE_in_eid3385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHARARRAY_in_eid3393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BYTEARRAY_in_eid3401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BAG_in_eid3409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TUPLE_in_eid3417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MAP_in_eid3425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IS_in_eid3433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NULL_in_eid3441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_eid3449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_eid3457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STREAM_in_eid3465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_THROUGH_in_eid3473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STORE_in_eid3481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MAPREDUCE_in_eid3489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHIP_in_eid3497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CACHE_in_eid3505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INPUT_in_eid3513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OUTPUT_in_eid3521 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STDERROR_in_eid3529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STDIN_in_eid3537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STDOUT_in_eid3545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LIMIT_in_eid3553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SAMPLE_in_eid3561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFT_in_eid3569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RIGHT_in_eid3577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FULL_in_eid3585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_eid3593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOBAG_in_eid3601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOMAP_in_eid3609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOTUPLE_in_eid3617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_eq_in_rel_op3631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_ne_in_rel_op3639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_gt_in_rel_op3647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_gte_in_rel_op3655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_lt_in_rel_op3663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_lte_in_rel_op3671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_MATCHES_in_rel_op3679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CAST_EXPR_in_synpred88_AliasMasker1482 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_in_synpred88_AliasMasker1484 = new BitSet(new long[]{0x900101108A800000L,0x56010004004A0000L,0x0000000020023028L});
    public static final BitSet FOLLOW_expr_in_synpred88_AliasMasker1486 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CAST_EXPR_in_synpred92_AliasMasker1528 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_cast_in_synpred92_AliasMasker1530 = new BitSet(new long[]{0x900101108A800000L,0x56010004004A0000L,0x0000000020023028L});
    public static final BitSet FOLLOW_expr_in_synpred92_AliasMasker1532 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INTEGER_in_synpred108_AliasMasker1832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LONGINTEGER_in_synpred109_AliasMasker1836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLENUMBER_in_synpred110_AliasMasker1867 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_join_item_in_synpred127_AliasMasker2105 = new BitSet(new long[]{0x0010004000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_set_in_synpred127_AliasMasker2107 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L,0x0000000000000040L});
    public static final BitSet FOLLOW_OUTER_in_synpred127_AliasMasker2163 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_join_item_in_synpred127_AliasMasker2166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_in_synpred145_AliasMasker2621 = new BitSet(new long[]{0x0000000000000002L});

}