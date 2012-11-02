// $ANTLR 3.4 /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g 2012-10-31 09:51:39

package org.apache.pig.parser;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


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
public class AstValidator extends TreeParser {
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


    public AstValidator(TreeNodeStream input) {
        this(input, new RecognizerSharedState());
    }
    public AstValidator(TreeNodeStream input, RecognizerSharedState state) {
        super(input, state);
    }

protected TreeAdaptor adaptor = new CommonTreeAdaptor();

public void setTreeAdaptor(TreeAdaptor adaptor) {
    this.adaptor = adaptor;
}
public TreeAdaptor getTreeAdaptor() {
    return adaptor;
}
    public String[] getTokenNames() { return AstValidator.tokenNames; }
    public String getGrammarFileName() { return "/Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g"; }



    private static Log log = LogFactory.getLog( AstValidator.class );

    @Override
    protected Object recoverFromMismatchedToken(IntStream input, int ttype, BitSet follow) 
    throws RecognitionException {
        throw new MismatchedTokenException( ttype, input );
    }

    @Override
    public Object recoverFromMismatchedSet(IntStream input, RecognitionException e, BitSet follow)
    throws RecognitionException {
        throw e;
    }

    private void validateSchemaAliasName(Set<String> fieldNames, CommonTree node, String name)
    throws DuplicatedSchemaAliasException {
        if( fieldNames.contains( name ) ) {
            throw new DuplicatedSchemaAliasException( input, 
                new SourceLocation( (PigParserNode)node ), name );
        } else {
            fieldNames.add( name );
        }
    }

    private void validateAliasRef(Set<String> aliases, CommonTree node, String alias)
    throws UndefinedAliasException {
        if( !aliases.contains( alias ) ) {
            throw new UndefinedAliasException( input, new SourceLocation( (PigParserNode)node ), alias );
        }
    }

    private void checkDuplication(int count, CommonTree node) throws ParserValidationException {
        if( count > 1 ) {
            throw new ParserValidationException( input, new SourceLocation( (PigParserNode)node ),
                "Duplicated command option" );
        }
    }

    private Set<String> aliases = new HashSet<String>();



    public static class query_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "query"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:95:1: query : ^( QUERY ( statement )* ) ;
    public final AstValidator.query_return query() throws RecognitionException {
        AstValidator.query_return retval = new AstValidator.query_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUERY1=null;
        AstValidator.statement_return statement2 =null;


        CommonTree QUERY1_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:95:7: ( ^( QUERY ( statement )* ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:95:9: ^( QUERY ( statement )* )
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
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:95:18: ( statement )*
                loop1:
                do {
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==SPLIT||LA1_0==REALIAS||LA1_0==STATEMENT) ) {
                        alt1=1;
                    }


                    switch (alt1) {
                	case 1 :
                	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:95:18: statement
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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:98:1: statement : ( general_statement | split_statement | realias_statement );
    public final AstValidator.statement_return statement() throws RecognitionException {
        AstValidator.statement_return retval = new AstValidator.statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.general_statement_return general_statement3 =null;

        AstValidator.split_statement_return split_statement4 =null;

        AstValidator.realias_statement_return realias_statement5 =null;



        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:98:11: ( general_statement | split_statement | realias_statement )
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:98:13: general_statement
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:99:13: split_statement
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:100:13: realias_statement
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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:103:1: split_statement : split_clause ;
    public final AstValidator.split_statement_return split_statement() throws RecognitionException {
        AstValidator.split_statement_return retval = new AstValidator.split_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.split_clause_return split_clause6 =null;



        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:103:17: ( split_clause )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:103:19: split_clause
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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:106:1: realias_statement : realias_clause ;
    public final AstValidator.realias_statement_return realias_statement() throws RecognitionException {
        AstValidator.realias_statement_return retval = new AstValidator.realias_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.realias_clause_return realias_clause7 =null;



        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:106:19: ( realias_clause )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:106:21: realias_clause
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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:109:1: general_statement : ^( STATEMENT ( alias )? op_clause ( parallel_clause )? ) ;
    public final AstValidator.general_statement_return general_statement() throws RecognitionException {
        AstValidator.general_statement_return retval = new AstValidator.general_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STATEMENT8=null;
        AstValidator.alias_return alias9 =null;

        AstValidator.op_clause_return op_clause10 =null;

        AstValidator.parallel_clause_return parallel_clause11 =null;


        CommonTree STATEMENT8_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:109:19: ( ^( STATEMENT ( alias )? op_clause ( parallel_clause )? ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:109:21: ^( STATEMENT ( alias )? op_clause ( parallel_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            STATEMENT8=(CommonTree)match(input,STATEMENT,FOLLOW_STATEMENT_in_general_statement152); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STATEMENT8_tree = (CommonTree)adaptor.dupNode(STATEMENT8);


            root_1 = (CommonTree)adaptor.becomeRoot(STATEMENT8_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:109:34: ( alias )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==IDENTIFIER) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:109:36: alias
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_alias_in_general_statement156);
                    alias9=alias();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, alias9.getTree());


                    if ( state.backtracking==0 ) { aliases.add( (alias9!=null?alias9.name:null) ); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_op_clause_in_general_statement163);
            op_clause10=op_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, op_clause10.getTree());


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:109:87: ( parallel_clause )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==PARALLEL) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:109:87: parallel_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_parallel_clause_in_general_statement165);
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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:112:1: realias_clause : ^( REALIAS alias IDENTIFIER ) ;
    public final AstValidator.realias_clause_return realias_clause() throws RecognitionException {
        AstValidator.realias_clause_return retval = new AstValidator.realias_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree REALIAS12=null;
        CommonTree IDENTIFIER14=null;
        AstValidator.alias_return alias13 =null;


        CommonTree REALIAS12_tree=null;
        CommonTree IDENTIFIER14_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:112:16: ( ^( REALIAS alias IDENTIFIER ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:112:18: ^( REALIAS alias IDENTIFIER )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            REALIAS12=(CommonTree)match(input,REALIAS,FOLLOW_REALIAS_in_realias_clause178); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            REALIAS12_tree = (CommonTree)adaptor.dupNode(REALIAS12);


            root_1 = (CommonTree)adaptor.becomeRoot(REALIAS12_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_alias_in_realias_clause180);
            alias13=alias();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, alias13.getTree());


            _last = (CommonTree)input.LT(1);
            IDENTIFIER14=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_realias_clause182); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER14_tree = (CommonTree)adaptor.dupNode(IDENTIFIER14);


            adaptor.addChild(root_1, IDENTIFIER14_tree);
            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   aliases.add( (alias13!=null?alias13.name:null) );
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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:118:1: parallel_clause : ^( PARALLEL INTEGER ) ;
    public final AstValidator.parallel_clause_return parallel_clause() throws RecognitionException {
        AstValidator.parallel_clause_return retval = new AstValidator.parallel_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PARALLEL15=null;
        CommonTree INTEGER16=null;

        CommonTree PARALLEL15_tree=null;
        CommonTree INTEGER16_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:118:17: ( ^( PARALLEL INTEGER ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:118:19: ^( PARALLEL INTEGER )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            PARALLEL15=(CommonTree)match(input,PARALLEL,FOLLOW_PARALLEL_in_parallel_clause199); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PARALLEL15_tree = (CommonTree)adaptor.dupNode(PARALLEL15);


            root_1 = (CommonTree)adaptor.becomeRoot(PARALLEL15_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            INTEGER16=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_parallel_clause201); if (state.failed) return retval;
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
        public String name;
        public CommonTree node;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "alias"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:121:1: alias returns [String name, CommonTree node] : IDENTIFIER ;
    public final AstValidator.alias_return alias() throws RecognitionException {
        AstValidator.alias_return retval = new AstValidator.alias_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IDENTIFIER17=null;

        CommonTree IDENTIFIER17_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:122:2: ( IDENTIFIER )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:122:4: IDENTIFIER
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            IDENTIFIER17=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_alias216); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER17_tree = (CommonTree)adaptor.dupNode(IDENTIFIER17);


            adaptor.addChild(root_0, IDENTIFIER17_tree);
            }


            if ( state.backtracking==0 ) { 
                   retval.name = (IDENTIFIER17!=null?IDENTIFIER17.getText():null);
                   retval.node = IDENTIFIER17;
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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:129:1: op_clause : ( define_clause | load_clause | group_clause | store_clause | filter_clause | distinct_clause | limit_clause | sample_clause | order_clause | cross_clause | join_clause | union_clause | stream_clause | mr_clause | split_clause | foreach_clause );
    public final AstValidator.op_clause_return op_clause() throws RecognitionException {
        AstValidator.op_clause_return retval = new AstValidator.op_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.define_clause_return define_clause18 =null;

        AstValidator.load_clause_return load_clause19 =null;

        AstValidator.group_clause_return group_clause20 =null;

        AstValidator.store_clause_return store_clause21 =null;

        AstValidator.filter_clause_return filter_clause22 =null;

        AstValidator.distinct_clause_return distinct_clause23 =null;

        AstValidator.limit_clause_return limit_clause24 =null;

        AstValidator.sample_clause_return sample_clause25 =null;

        AstValidator.order_clause_return order_clause26 =null;

        AstValidator.cross_clause_return cross_clause27 =null;

        AstValidator.join_clause_return join_clause28 =null;

        AstValidator.union_clause_return union_clause29 =null;

        AstValidator.stream_clause_return stream_clause30 =null;

        AstValidator.mr_clause_return mr_clause31 =null;

        AstValidator.split_clause_return split_clause32 =null;

        AstValidator.foreach_clause_return foreach_clause33 =null;



        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:129:11: ( define_clause | load_clause | group_clause | store_clause | filter_clause | distinct_clause | limit_clause | sample_clause | order_clause | cross_clause | join_clause | union_clause | stream_clause | mr_clause | split_clause | foreach_clause )
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:129:13: define_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_define_clause_in_op_clause230);
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:130:13: load_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_load_clause_in_op_clause245);
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:131:13: group_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_group_clause_in_op_clause259);
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:132:13: store_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_store_clause_in_op_clause273);
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:133:13: filter_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_filter_clause_in_op_clause287);
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:134:13: distinct_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_distinct_clause_in_op_clause301);
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:135:13: limit_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_limit_clause_in_op_clause315);
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:136:13: sample_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_sample_clause_in_op_clause329);
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:137:13: order_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_order_clause_in_op_clause343);
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:138:13: cross_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cross_clause_in_op_clause357);
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:139:13: join_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_clause_in_op_clause371);
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:140:13: union_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_union_clause_in_op_clause385);
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:141:13: stream_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_stream_clause_in_op_clause399);
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:142:13: mr_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_mr_clause_in_op_clause413);
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:143:13: split_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_split_clause_in_op_clause427);
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:144:13: foreach_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_foreach_clause_in_op_clause441);
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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:147:1: define_clause : ^( DEFINE alias ( cmd | func_clause ) ) ;
    public final AstValidator.define_clause_return define_clause() throws RecognitionException {
        AstValidator.define_clause_return retval = new AstValidator.define_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DEFINE34=null;
        AstValidator.alias_return alias35 =null;

        AstValidator.cmd_return cmd36 =null;

        AstValidator.func_clause_return func_clause37 =null;


        CommonTree DEFINE34_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:147:15: ( ^( DEFINE alias ( cmd | func_clause ) ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:147:17: ^( DEFINE alias ( cmd | func_clause ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            DEFINE34=(CommonTree)match(input,DEFINE,FOLLOW_DEFINE_in_define_clause452); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DEFINE34_tree = (CommonTree)adaptor.dupNode(DEFINE34);


            root_1 = (CommonTree)adaptor.becomeRoot(DEFINE34_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_alias_in_define_clause454);
            alias35=alias();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, alias35.getTree());


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:147:33: ( cmd | func_clause )
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:147:35: cmd
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cmd_in_define_clause458);
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:147:41: func_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_define_clause462);
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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:150:1: cmd : ^( EXECCOMMAND ( ship_clause | cache_clause | input_clause | output_clause | error_clause )* ) ;
    public final AstValidator.cmd_return cmd() throws RecognitionException {
        AstValidator.cmd_return retval = new AstValidator.cmd_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree EXECCOMMAND38=null;
        AstValidator.ship_clause_return ship_clause39 =null;

        AstValidator.cache_clause_return cache_clause40 =null;

        AstValidator.input_clause_return input_clause41 =null;

        AstValidator.output_clause_return output_clause42 =null;

        AstValidator.error_clause_return error_clause43 =null;


        CommonTree EXECCOMMAND38_tree=null;


            int ship = 0;
            int cache = 0;
            int in = 0;
            int out = 0;
            int error = 0;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:158:2: ( ^( EXECCOMMAND ( ship_clause | cache_clause | input_clause | output_clause | error_clause )* ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:158:4: ^( EXECCOMMAND ( ship_clause | cache_clause | input_clause | output_clause | error_clause )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            EXECCOMMAND38=(CommonTree)match(input,EXECCOMMAND,FOLLOW_EXECCOMMAND_in_cmd483); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            EXECCOMMAND38_tree = (CommonTree)adaptor.dupNode(EXECCOMMAND38);


            root_1 = (CommonTree)adaptor.becomeRoot(EXECCOMMAND38_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:158:19: ( ship_clause | cache_clause | input_clause | output_clause | error_clause )*
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
                	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:158:21: ship_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_ship_clause_in_cmd487);
                	    ship_clause39=ship_clause();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, ship_clause39.getTree());


                	    if ( state.backtracking==0 ) { checkDuplication( ++ship, (ship_clause39!=null?((CommonTree)ship_clause39.start):null) ); }

                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;
                	case 2 :
                	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:159:21: cache_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_cache_clause_in_cmd511);
                	    cache_clause40=cache_clause();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, cache_clause40.getTree());


                	    if ( state.backtracking==0 ) { checkDuplication( ++cache, (cache_clause40!=null?((CommonTree)cache_clause40.start):null) ); }

                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;
                	case 3 :
                	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:160:21: input_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_input_clause_in_cmd535);
                	    input_clause41=input_clause();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, input_clause41.getTree());


                	    if ( state.backtracking==0 ) { checkDuplication( ++in, (input_clause41!=null?((CommonTree)input_clause41.start):null) ); }

                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;
                	case 4 :
                	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:161:21: output_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_output_clause_in_cmd560);
                	    output_clause42=output_clause();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, output_clause42.getTree());


                	    if ( state.backtracking==0 ) { checkDuplication( ++out, (output_clause42!=null?((CommonTree)output_clause42.start):null) ); }

                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;
                	case 5 :
                	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:162:21: error_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_error_clause_in_cmd585);
                	    error_clause43=error_clause();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, error_clause43.getTree());


                	    if ( state.backtracking==0 ) { checkDuplication( ++error, (error_clause43!=null?((CommonTree)error_clause43.start):null) ); }

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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:167:1: ship_clause : ^( SHIP ( path_list )? ) ;
    public final AstValidator.ship_clause_return ship_clause() throws RecognitionException {
        AstValidator.ship_clause_return retval = new AstValidator.ship_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SHIP44=null;
        AstValidator.path_list_return path_list45 =null;


        CommonTree SHIP44_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:167:13: ( ^( SHIP ( path_list )? ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:167:15: ^( SHIP ( path_list )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            SHIP44=(CommonTree)match(input,SHIP,FOLLOW_SHIP_in_ship_clause624); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SHIP44_tree = (CommonTree)adaptor.dupNode(SHIP44);


            root_1 = (CommonTree)adaptor.becomeRoot(SHIP44_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:167:23: ( path_list )?
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==QUOTEDSTRING) ) {
                    alt8=1;
                }
                switch (alt8) {
                    case 1 :
                        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:167:23: path_list
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_path_list_in_ship_clause626);
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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:170:1: path_list : ( QUOTEDSTRING )+ ;
    public final AstValidator.path_list_return path_list() throws RecognitionException {
        AstValidator.path_list_return retval = new AstValidator.path_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING46=null;

        CommonTree QUOTEDSTRING46_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:170:11: ( ( QUOTEDSTRING )+ )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:170:13: ( QUOTEDSTRING )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:170:13: ( QUOTEDSTRING )+
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
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:170:13: QUOTEDSTRING
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    QUOTEDSTRING46=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_path_list638); if (state.failed) return retval;
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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:173:1: cache_clause : ^( CACHE path_list ) ;
    public final AstValidator.cache_clause_return cache_clause() throws RecognitionException {
        AstValidator.cache_clause_return retval = new AstValidator.cache_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CACHE47=null;
        AstValidator.path_list_return path_list48 =null;


        CommonTree CACHE47_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:173:14: ( ^( CACHE path_list ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:173:16: ^( CACHE path_list )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CACHE47=(CommonTree)match(input,CACHE,FOLLOW_CACHE_in_cache_clause650); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CACHE47_tree = (CommonTree)adaptor.dupNode(CACHE47);


            root_1 = (CommonTree)adaptor.becomeRoot(CACHE47_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_path_list_in_cache_clause652);
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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:176:1: input_clause : ^( INPUT ( stream_cmd )+ ) ;
    public final AstValidator.input_clause_return input_clause() throws RecognitionException {
        AstValidator.input_clause_return retval = new AstValidator.input_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree INPUT49=null;
        AstValidator.stream_cmd_return stream_cmd50 =null;


        CommonTree INPUT49_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:176:14: ( ^( INPUT ( stream_cmd )+ ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:176:16: ^( INPUT ( stream_cmd )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            INPUT49=(CommonTree)match(input,INPUT,FOLLOW_INPUT_in_input_clause665); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            INPUT49_tree = (CommonTree)adaptor.dupNode(INPUT49);


            root_1 = (CommonTree)adaptor.becomeRoot(INPUT49_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:176:25: ( stream_cmd )+
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
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:176:25: stream_cmd
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_stream_cmd_in_input_clause667);
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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:179:1: stream_cmd : ( ^( STDIN ( func_clause )? ) | ^( STDOUT ( func_clause )? ) | ^( QUOTEDSTRING ( func_clause )? ) );
    public final AstValidator.stream_cmd_return stream_cmd() throws RecognitionException {
        AstValidator.stream_cmd_return retval = new AstValidator.stream_cmd_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STDIN51=null;
        CommonTree STDOUT53=null;
        CommonTree QUOTEDSTRING55=null;
        AstValidator.func_clause_return func_clause52 =null;

        AstValidator.func_clause_return func_clause54 =null;

        AstValidator.func_clause_return func_clause56 =null;


        CommonTree STDIN51_tree=null;
        CommonTree STDOUT53_tree=null;
        CommonTree QUOTEDSTRING55_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:179:12: ( ^( STDIN ( func_clause )? ) | ^( STDOUT ( func_clause )? ) | ^( QUOTEDSTRING ( func_clause )? ) )
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:179:14: ^( STDIN ( func_clause )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    STDIN51=(CommonTree)match(input,STDIN,FOLLOW_STDIN_in_stream_cmd681); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDIN51_tree = (CommonTree)adaptor.dupNode(STDIN51);


                    root_1 = (CommonTree)adaptor.becomeRoot(STDIN51_tree, root_1);
                    }


                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
                        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:179:23: ( func_clause )?
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==FUNC||LA11_0==FUNC_REF) ) {
                            alt11=1;
                        }
                        switch (alt11) {
                            case 1 :
                                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:179:23: func_clause
                                {
                                _last = (CommonTree)input.LT(1);
                                pushFollow(FOLLOW_func_clause_in_stream_cmd683);
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:180:14: ^( STDOUT ( func_clause )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    STDOUT53=(CommonTree)match(input,STDOUT,FOLLOW_STDOUT_in_stream_cmd703); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDOUT53_tree = (CommonTree)adaptor.dupNode(STDOUT53);


                    root_1 = (CommonTree)adaptor.becomeRoot(STDOUT53_tree, root_1);
                    }


                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
                        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:180:24: ( func_clause )?
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==FUNC||LA12_0==FUNC_REF) ) {
                            alt12=1;
                        }
                        switch (alt12) {
                            case 1 :
                                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:180:24: func_clause
                                {
                                _last = (CommonTree)input.LT(1);
                                pushFollow(FOLLOW_func_clause_in_stream_cmd705);
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:181:14: ^( QUOTEDSTRING ( func_clause )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    QUOTEDSTRING55=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_stream_cmd725); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    QUOTEDSTRING55_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING55);


                    root_1 = (CommonTree)adaptor.becomeRoot(QUOTEDSTRING55_tree, root_1);
                    }


                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
                        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:181:30: ( func_clause )?
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==FUNC||LA13_0==FUNC_REF) ) {
                            alt13=1;
                        }
                        switch (alt13) {
                            case 1 :
                                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:181:30: func_clause
                                {
                                _last = (CommonTree)input.LT(1);
                                pushFollow(FOLLOW_func_clause_in_stream_cmd727);
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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:184:1: output_clause : ^( OUTPUT ( stream_cmd )+ ) ;
    public final AstValidator.output_clause_return output_clause() throws RecognitionException {
        AstValidator.output_clause_return retval = new AstValidator.output_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree OUTPUT57=null;
        AstValidator.stream_cmd_return stream_cmd58 =null;


        CommonTree OUTPUT57_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:184:15: ( ^( OUTPUT ( stream_cmd )+ ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:184:17: ^( OUTPUT ( stream_cmd )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            OUTPUT57=(CommonTree)match(input,OUTPUT,FOLLOW_OUTPUT_in_output_clause741); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            OUTPUT57_tree = (CommonTree)adaptor.dupNode(OUTPUT57);


            root_1 = (CommonTree)adaptor.becomeRoot(OUTPUT57_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:184:27: ( stream_cmd )+
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
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:184:27: stream_cmd
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_stream_cmd_in_output_clause743);
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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:187:1: error_clause : ^( STDERROR ( QUOTEDSTRING ( INTEGER )? )? ) ;
    public final AstValidator.error_clause_return error_clause() throws RecognitionException {
        AstValidator.error_clause_return retval = new AstValidator.error_clause_return();
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
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:187:14: ( ^( STDERROR ( QUOTEDSTRING ( INTEGER )? )? ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:187:16: ^( STDERROR ( QUOTEDSTRING ( INTEGER )? )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            STDERROR59=(CommonTree)match(input,STDERROR,FOLLOW_STDERROR_in_error_clause757); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STDERROR59_tree = (CommonTree)adaptor.dupNode(STDERROR59);


            root_1 = (CommonTree)adaptor.becomeRoot(STDERROR59_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:187:29: ( QUOTEDSTRING ( INTEGER )? )?
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==QUOTEDSTRING) ) {
                    alt17=1;
                }
                switch (alt17) {
                    case 1 :
                        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:187:31: QUOTEDSTRING ( INTEGER )?
                        {
                        _last = (CommonTree)input.LT(1);
                        QUOTEDSTRING60=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_error_clause762); if (state.failed) return retval;
                        if ( state.backtracking==0 ) {
                        QUOTEDSTRING60_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING60);


                        adaptor.addChild(root_1, QUOTEDSTRING60_tree);
                        }


                        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:187:44: ( INTEGER )?
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==INTEGER) ) {
                            alt16=1;
                        }
                        switch (alt16) {
                            case 1 :
                                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:187:44: INTEGER
                                {
                                _last = (CommonTree)input.LT(1);
                                INTEGER61=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_error_clause764); if (state.failed) return retval;
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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:190:1: load_clause : ^( LOAD filename ( func_clause )? ( as_clause )? ) ;
    public final AstValidator.load_clause_return load_clause() throws RecognitionException {
        AstValidator.load_clause_return retval = new AstValidator.load_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree LOAD62=null;
        AstValidator.filename_return filename63 =null;

        AstValidator.func_clause_return func_clause64 =null;

        AstValidator.as_clause_return as_clause65 =null;


        CommonTree LOAD62_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:190:13: ( ^( LOAD filename ( func_clause )? ( as_clause )? ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:190:15: ^( LOAD filename ( func_clause )? ( as_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            LOAD62=(CommonTree)match(input,LOAD,FOLLOW_LOAD_in_load_clause781); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LOAD62_tree = (CommonTree)adaptor.dupNode(LOAD62);


            root_1 = (CommonTree)adaptor.becomeRoot(LOAD62_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_filename_in_load_clause783);
            filename63=filename();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, filename63.getTree());


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:190:32: ( func_clause )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==FUNC||LA18_0==FUNC_REF) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:190:32: func_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_load_clause785);
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


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:190:45: ( as_clause )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==AS) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:190:45: as_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_as_clause_in_load_clause788);
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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:193:1: filename : QUOTEDSTRING ;
    public final AstValidator.filename_return filename() throws RecognitionException {
        AstValidator.filename_return retval = new AstValidator.filename_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING66=null;

        CommonTree QUOTEDSTRING66_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:193:10: ( QUOTEDSTRING )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:193:12: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING66=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_filename800); if (state.failed) return retval;
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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:196:1: as_clause : ^( AS field_def_list ) ;
    public final AstValidator.as_clause_return as_clause() throws RecognitionException {
        AstValidator.as_clause_return retval = new AstValidator.as_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree AS67=null;
        AstValidator.field_def_list_return field_def_list68 =null;


        CommonTree AS67_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:196:10: ( ^( AS field_def_list ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:196:12: ^( AS field_def_list )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            AS67=(CommonTree)match(input,AS,FOLLOW_AS_in_as_clause810); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            AS67_tree = (CommonTree)adaptor.dupNode(AS67);


            root_1 = (CommonTree)adaptor.becomeRoot(AS67_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_field_def_list_in_as_clause812);
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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:199:1: field_def[Set<String> fieldNames] : ^( FIELD_DEF IDENTIFIER ( type )? ) ;
    public final AstValidator.field_def_return field_def(Set<String> fieldNames) throws RecognitionException, DuplicatedSchemaAliasException {
        AstValidator.field_def_return retval = new AstValidator.field_def_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FIELD_DEF69=null;
        CommonTree IDENTIFIER70=null;
        AstValidator.type_return type71 =null;


        CommonTree FIELD_DEF69_tree=null;
        CommonTree IDENTIFIER70_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:200:2: ( ^( FIELD_DEF IDENTIFIER ( type )? ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:200:4: ^( FIELD_DEF IDENTIFIER ( type )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FIELD_DEF69=(CommonTree)match(input,FIELD_DEF,FOLLOW_FIELD_DEF_in_field_def831); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FIELD_DEF69_tree = (CommonTree)adaptor.dupNode(FIELD_DEF69);


            root_1 = (CommonTree)adaptor.becomeRoot(FIELD_DEF69_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            IDENTIFIER70=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_field_def833); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER70_tree = (CommonTree)adaptor.dupNode(IDENTIFIER70);


            adaptor.addChild(root_1, IDENTIFIER70_tree);
            }


            if ( state.backtracking==0 ) { validateSchemaAliasName( fieldNames, IDENTIFIER70, (IDENTIFIER70!=null?IDENTIFIER70.getText():null) ); }

            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:200:102: ( type )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==BOOLEAN||LA20_0==BYTEARRAY||LA20_0==CHARARRAY||LA20_0==DOUBLE||LA20_0==FLOAT||LA20_0==INT||LA20_0==LONG||LA20_0==BAG_TYPE||LA20_0==MAP_TYPE||LA20_0==TUPLE_TYPE) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:200:102: type
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_type_in_field_def837);
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


    protected static class field_def_list_scope {
        Set<String> fieldNames;
    }
    protected Stack field_def_list_stack = new Stack();


    public static class field_def_list_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "field_def_list"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:203:1: field_def_list : ( field_def[$field_def_list::fieldNames] )+ ;
    public final AstValidator.field_def_list_return field_def_list() throws RecognitionException, DuplicatedSchemaAliasException {
        field_def_list_stack.push(new field_def_list_scope());
        AstValidator.field_def_list_return retval = new AstValidator.field_def_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.field_def_return field_def72 =null;




            ((field_def_list_scope)field_def_list_stack.peek()).fieldNames = new HashSet<String>();

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:210:2: ( ( field_def[$field_def_list::fieldNames] )+ )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:210:4: ( field_def[$field_def_list::fieldNames] )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:210:4: ( field_def[$field_def_list::fieldNames] )+
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
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:210:6: field_def[$field_def_list::fieldNames]
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_field_def_in_field_def_list864);
            	    field_def72=field_def(((field_def_list_scope)field_def_list_stack.peek()).fieldNames);

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
            field_def_list_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "field_def_list"


    public static class type_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "type"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:213:1: type : ( simple_type | tuple_type | bag_type | map_type );
    public final AstValidator.type_return type() throws RecognitionException {
        AstValidator.type_return retval = new AstValidator.type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.simple_type_return simple_type73 =null;

        AstValidator.tuple_type_return tuple_type74 =null;

        AstValidator.bag_type_return bag_type75 =null;

        AstValidator.map_type_return map_type76 =null;



        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:213:6: ( simple_type | tuple_type | bag_type | map_type )
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:213:8: simple_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_simple_type_in_type877);
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:213:22: tuple_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_tuple_type_in_type881);
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:213:35: bag_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_bag_type_in_type885);
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:213:46: map_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_map_type_in_type889);
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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:216:1: simple_type : ( BOOLEAN | INT | LONG | FLOAT | DOUBLE | CHARARRAY | BYTEARRAY );
    public final AstValidator.simple_type_return simple_type() throws RecognitionException {
        AstValidator.simple_type_return retval = new AstValidator.simple_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set77=null;

        CommonTree set77_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:216:13: ( BOOLEAN | INT | LONG | FLOAT | DOUBLE | CHARARRAY | BYTEARRAY )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:
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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:219:1: tuple_type : ^( TUPLE_TYPE ( field_def_list )? ) ;
    public final AstValidator.tuple_type_return tuple_type() throws RecognitionException {
        AstValidator.tuple_type_return retval = new AstValidator.tuple_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree TUPLE_TYPE78=null;
        AstValidator.field_def_list_return field_def_list79 =null;


        CommonTree TUPLE_TYPE78_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:219:12: ( ^( TUPLE_TYPE ( field_def_list )? ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:219:14: ^( TUPLE_TYPE ( field_def_list )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            TUPLE_TYPE78=(CommonTree)match(input,TUPLE_TYPE,FOLLOW_TUPLE_TYPE_in_tuple_type933); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            TUPLE_TYPE78_tree = (CommonTree)adaptor.dupNode(TUPLE_TYPE78);


            root_1 = (CommonTree)adaptor.becomeRoot(TUPLE_TYPE78_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:219:28: ( field_def_list )?
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==FIELD_DEF) ) {
                    alt23=1;
                }
                switch (alt23) {
                    case 1 :
                        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:219:28: field_def_list
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_field_def_list_in_tuple_type935);
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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:222:1: bag_type : ^( BAG_TYPE ( IDENTIFIER )? ( tuple_type )? ) ;
    public final AstValidator.bag_type_return bag_type() throws RecognitionException {
        AstValidator.bag_type_return retval = new AstValidator.bag_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BAG_TYPE80=null;
        CommonTree IDENTIFIER81=null;
        AstValidator.tuple_type_return tuple_type82 =null;


        CommonTree BAG_TYPE80_tree=null;
        CommonTree IDENTIFIER81_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:222:10: ( ^( BAG_TYPE ( IDENTIFIER )? ( tuple_type )? ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:222:12: ^( BAG_TYPE ( IDENTIFIER )? ( tuple_type )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BAG_TYPE80=(CommonTree)match(input,BAG_TYPE,FOLLOW_BAG_TYPE_in_bag_type949); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BAG_TYPE80_tree = (CommonTree)adaptor.dupNode(BAG_TYPE80);


            root_1 = (CommonTree)adaptor.becomeRoot(BAG_TYPE80_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:222:24: ( IDENTIFIER )?
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==IDENTIFIER) ) {
                    alt24=1;
                }
                switch (alt24) {
                    case 1 :
                        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:222:24: IDENTIFIER
                        {
                        _last = (CommonTree)input.LT(1);
                        IDENTIFIER81=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_bag_type951); if (state.failed) return retval;
                        if ( state.backtracking==0 ) {
                        IDENTIFIER81_tree = (CommonTree)adaptor.dupNode(IDENTIFIER81);


                        adaptor.addChild(root_1, IDENTIFIER81_tree);
                        }


                        if ( state.backtracking==0 ) {
                        }
                        }
                        break;

                }


                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:222:36: ( tuple_type )?
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==TUPLE_TYPE) ) {
                    alt25=1;
                }
                switch (alt25) {
                    case 1 :
                        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:222:36: tuple_type
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_tuple_type_in_bag_type954);
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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:225:1: map_type : ^( MAP_TYPE ( type )? ) ;
    public final AstValidator.map_type_return map_type() throws RecognitionException {
        AstValidator.map_type_return retval = new AstValidator.map_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MAP_TYPE83=null;
        AstValidator.type_return type84 =null;


        CommonTree MAP_TYPE83_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:225:10: ( ^( MAP_TYPE ( type )? ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:225:12: ^( MAP_TYPE ( type )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            MAP_TYPE83=(CommonTree)match(input,MAP_TYPE,FOLLOW_MAP_TYPE_in_map_type968); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            MAP_TYPE83_tree = (CommonTree)adaptor.dupNode(MAP_TYPE83);


            root_1 = (CommonTree)adaptor.becomeRoot(MAP_TYPE83_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:225:24: ( type )?
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==BOOLEAN||LA26_0==BYTEARRAY||LA26_0==CHARARRAY||LA26_0==DOUBLE||LA26_0==FLOAT||LA26_0==INT||LA26_0==LONG||LA26_0==BAG_TYPE||LA26_0==MAP_TYPE||LA26_0==TUPLE_TYPE) ) {
                    alt26=1;
                }
                switch (alt26) {
                    case 1 :
                        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:225:24: type
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_type_in_map_type970);
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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:228:1: func_clause : ( ^( FUNC_REF func_name ) | ^( FUNC func_name ( func_args )? ) );
    public final AstValidator.func_clause_return func_clause() throws RecognitionException {
        AstValidator.func_clause_return retval = new AstValidator.func_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FUNC_REF85=null;
        CommonTree FUNC87=null;
        AstValidator.func_name_return func_name86 =null;

        AstValidator.func_name_return func_name88 =null;

        AstValidator.func_args_return func_args89 =null;


        CommonTree FUNC_REF85_tree=null;
        CommonTree FUNC87_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:228:13: ( ^( FUNC_REF func_name ) | ^( FUNC func_name ( func_args )? ) )
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:228:15: ^( FUNC_REF func_name )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FUNC_REF85=(CommonTree)match(input,FUNC_REF,FOLLOW_FUNC_REF_in_func_clause984); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FUNC_REF85_tree = (CommonTree)adaptor.dupNode(FUNC_REF85);


                    root_1 = (CommonTree)adaptor.becomeRoot(FUNC_REF85_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_name_in_func_clause986);
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:229:15: ^( FUNC func_name ( func_args )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FUNC87=(CommonTree)match(input,FUNC,FOLLOW_FUNC_in_func_clause1006); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FUNC87_tree = (CommonTree)adaptor.dupNode(FUNC87);


                    root_1 = (CommonTree)adaptor.becomeRoot(FUNC87_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_name_in_func_clause1008);
                    func_name88=func_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_name88.getTree());


                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:229:33: ( func_args )?
                    int alt27=2;
                    int LA27_0 = input.LA(1);

                    if ( (LA27_0==MULTILINE_QUOTEDSTRING||LA27_0==QUOTEDSTRING) ) {
                        alt27=1;
                    }
                    switch (alt27) {
                        case 1 :
                            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:229:33: func_args
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_func_args_in_func_clause1010);
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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:232:1: func_name : eid ( ( PERIOD | DOLLAR ) eid )* ;
    public final AstValidator.func_name_return func_name() throws RecognitionException {
        AstValidator.func_name_return retval = new AstValidator.func_name_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set91=null;
        AstValidator.eid_return eid90 =null;

        AstValidator.eid_return eid92 =null;


        CommonTree set91_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:232:11: ( eid ( ( PERIOD | DOLLAR ) eid )* )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:232:13: eid ( ( PERIOD | DOLLAR ) eid )*
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_eid_in_func_name1022);
            eid90=eid();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, eid90.getTree());


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:232:17: ( ( PERIOD | DOLLAR ) eid )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==DOLLAR||LA29_0==PERIOD) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:232:19: ( PERIOD | DOLLAR ) eid
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
            	    pushFollow(FOLLOW_eid_in_func_name1036);
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


    public static class func_args_string_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "func_args_string"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:235:1: func_args_string : ( QUOTEDSTRING | MULTILINE_QUOTEDSTRING );
    public final AstValidator.func_args_string_return func_args_string() throws RecognitionException {
        AstValidator.func_args_string_return retval = new AstValidator.func_args_string_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set93=null;

        CommonTree set93_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:235:18: ( QUOTEDSTRING | MULTILINE_QUOTEDSTRING )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set93=(CommonTree)input.LT(1);

            if ( input.LA(1)==MULTILINE_QUOTEDSTRING||input.LA(1)==QUOTEDSTRING ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set93_tree = (CommonTree)adaptor.dupNode(set93);


                adaptor.addChild(root_0, set93_tree);
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
    // $ANTLR end "func_args_string"


    public static class func_args_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "func_args"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:238:1: func_args : ( func_args_string )+ ;
    public final AstValidator.func_args_return func_args() throws RecognitionException {
        AstValidator.func_args_return retval = new AstValidator.func_args_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.func_args_string_return func_args_string94 =null;



        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:238:11: ( ( func_args_string )+ )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:238:13: ( func_args_string )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:238:13: ( func_args_string )+
            int cnt30=0;
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==MULTILINE_QUOTEDSTRING||LA30_0==QUOTEDSTRING) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:238:13: func_args_string
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_func_args_string_in_func_args1061);
            	    func_args_string94=func_args_string();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, func_args_string94.getTree());


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


    protected static class group_clause_scope {
        int arity;
    }
    protected Stack group_clause_stack = new Stack();


    public static class group_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "group_clause"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:241:1: group_clause : ^( ( GROUP | COGROUP ) ( group_item )+ ( group_type )? ( partition_clause )? ) ;
    public final AstValidator.group_clause_return group_clause() throws RecognitionException {
        group_clause_stack.push(new group_clause_scope());
        AstValidator.group_clause_return retval = new AstValidator.group_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set95=null;
        AstValidator.group_item_return group_item96 =null;

        AstValidator.group_type_return group_type97 =null;

        AstValidator.partition_clause_return partition_clause98 =null;


        CommonTree set95_tree=null;


            ((group_clause_scope)group_clause_stack.peek()).arity = 0;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:248:2: ( ^( ( GROUP | COGROUP ) ( group_item )+ ( group_type )? ( partition_clause )? ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:248:4: ^( ( GROUP | COGROUP ) ( group_item )+ ( group_type )? ( partition_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            set95=(CommonTree)input.LT(1);

            if ( input.LA(1)==COGROUP||input.LA(1)==GROUP ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set95_tree = (CommonTree)adaptor.dupNode(set95);


                root_1 = (CommonTree)adaptor.becomeRoot(set95_tree, root_1);
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
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:248:27: ( group_item )+
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
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:248:27: group_item
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_group_item_in_group_clause1093);
            	    group_item96=group_item();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, group_item96.getTree());


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


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:248:39: ( group_type )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==QUOTEDSTRING) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:248:39: group_type
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_group_type_in_group_clause1096);
                    group_type97=group_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, group_type97.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:248:51: ( partition_clause )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==PARTITION) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:248:51: partition_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_partition_clause_in_group_clause1099);
                    partition_clause98=partition_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, partition_clause98.getTree());


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
            group_clause_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "group_clause"


    public static class group_type_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "group_type"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:251:1: group_type : QUOTEDSTRING ;
    public final AstValidator.group_type_return group_type() throws RecognitionException {
        AstValidator.group_type_return retval = new AstValidator.group_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING99=null;

        CommonTree QUOTEDSTRING99_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:251:12: ( QUOTEDSTRING )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:251:14: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING99=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_group_type1111); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING99_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING99);


            adaptor.addChild(root_0, QUOTEDSTRING99_tree);
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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:254:1: group_item : rel ( join_group_by_clause | ALL | ANY ) ( INNER | OUTER )? ;
    public final AstValidator.group_item_return group_item() throws RecognitionException {
        AstValidator.group_item_return retval = new AstValidator.group_item_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ALL102=null;
        CommonTree ANY103=null;
        CommonTree set104=null;
        AstValidator.rel_return rel100 =null;

        AstValidator.join_group_by_clause_return join_group_by_clause101 =null;


        CommonTree ALL102_tree=null;
        CommonTree ANY103_tree=null;
        CommonTree set104_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:255:2: ( rel ( join_group_by_clause | ALL | ANY ) ( INNER | OUTER )? )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:255:4: rel ( join_group_by_clause | ALL | ANY ) ( INNER | OUTER )?
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_group_item1122);
            rel100=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, rel100.getTree());


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:255:8: ( join_group_by_clause | ALL | ANY )
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:255:10: join_group_by_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_group_by_clause_in_group_item1126);
                    join_group_by_clause101=join_group_by_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, join_group_by_clause101.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:255:33: ALL
                    {
                    _last = (CommonTree)input.LT(1);
                    ALL102=(CommonTree)match(input,ALL,FOLLOW_ALL_in_group_item1130); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ALL102_tree = (CommonTree)adaptor.dupNode(ALL102);


                    adaptor.addChild(root_0, ALL102_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:255:39: ANY
                    {
                    _last = (CommonTree)input.LT(1);
                    ANY103=(CommonTree)match(input,ANY,FOLLOW_ANY_in_group_item1134); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ANY103_tree = (CommonTree)adaptor.dupNode(ANY103);


                    adaptor.addChild(root_0, ANY103_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:255:45: ( INNER | OUTER )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==INNER||LA35_0==OUTER) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:
                    {
                    _last = (CommonTree)input.LT(1);
                    set104=(CommonTree)input.LT(1);

                    if ( input.LA(1)==INNER||input.LA(1)==OUTER ) {
                        input.consume();
                        if ( state.backtracking==0 ) {
                        set104_tree = (CommonTree)adaptor.dupNode(set104);


                        adaptor.addChild(root_0, set104_tree);
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
                   if( ((group_clause_scope)group_clause_stack.peek()).arity == 0 ) {
                       // For the first input
                       ((group_clause_scope)group_clause_stack.peek()).arity = (join_group_by_clause101!=null?join_group_by_clause101.exprCount:0);
                   } else if( (join_group_by_clause101!=null?join_group_by_clause101.exprCount:0) != ((group_clause_scope)group_clause_stack.peek()).arity ) {
                       throw new ParserValidationException( input, new SourceLocation( (PigParserNode)((CommonTree)retval.start) ),
                           "The arity of the group by columns do not match." );
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
    // $ANTLR end "group_item"


    public static class rel_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:267:1: rel : ( alias | op_clause ( parallel_clause )? );
    public final AstValidator.rel_return rel() throws RecognitionException {
        AstValidator.rel_return retval = new AstValidator.rel_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.alias_return alias105 =null;

        AstValidator.op_clause_return op_clause106 =null;

        AstValidator.parallel_clause_return parallel_clause107 =null;



        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:267:5: ( alias | op_clause ( parallel_clause )? )
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:267:7: alias
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_alias_in_rel1161);
                    alias105=alias();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, alias105.getTree());


                    if ( state.backtracking==0 ) {  validateAliasRef( aliases, (alias105!=null?alias105.node:null), (alias105!=null?alias105.name:null) ); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:268:7: op_clause ( parallel_clause )?
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_op_clause_in_rel1171);
                    op_clause106=op_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, op_clause106.getTree());


                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:268:17: ( parallel_clause )?
                    int alt36=2;
                    int LA36_0 = input.LA(1);

                    if ( (LA36_0==PARALLEL) ) {
                        alt36=1;
                    }
                    switch (alt36) {
                        case 1 :
                            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:268:17: parallel_clause
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_parallel_clause_in_rel1173);
                            parallel_clause107=parallel_clause();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_0, parallel_clause107.getTree());


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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:271:1: flatten_generated_item : ( flatten_clause | col_range | expr | STAR ) ( field_def_list )? ;
    public final AstValidator.flatten_generated_item_return flatten_generated_item() throws RecognitionException {
        AstValidator.flatten_generated_item_return retval = new AstValidator.flatten_generated_item_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR111=null;
        AstValidator.flatten_clause_return flatten_clause108 =null;

        AstValidator.col_range_return col_range109 =null;

        AstValidator.expr_return expr110 =null;

        AstValidator.field_def_list_return field_def_list112 =null;


        CommonTree STAR111_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:271:24: ( ( flatten_clause | col_range | expr | STAR ) ( field_def_list )? )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:271:26: ( flatten_clause | col_range | expr | STAR ) ( field_def_list )?
            {
            root_0 = (CommonTree)adaptor.nil();


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:271:26: ( flatten_clause | col_range | expr | STAR )
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:271:28: flatten_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_flatten_clause_in_flatten_generated_item1185);
                    flatten_clause108=flatten_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, flatten_clause108.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:271:45: col_range
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_flatten_generated_item1189);
                    col_range109=col_range();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range109.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:271:57: expr
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_flatten_generated_item1193);
                    expr110=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expr110.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:271:64: STAR
                    {
                    _last = (CommonTree)input.LT(1);
                    STAR111=(CommonTree)match(input,STAR,FOLLOW_STAR_in_flatten_generated_item1197); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR111_tree = (CommonTree)adaptor.dupNode(STAR111);


                    adaptor.addChild(root_0, STAR111_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:271:71: ( field_def_list )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==FIELD_DEF) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:271:71: field_def_list
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_field_def_list_in_flatten_generated_item1201);
                    field_def_list112=field_def_list();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, field_def_list112.getTree());


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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:274:1: flatten_clause : ^( FLATTEN expr ) ;
    public final AstValidator.flatten_clause_return flatten_clause() throws RecognitionException {
        AstValidator.flatten_clause_return retval = new AstValidator.flatten_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FLATTEN113=null;
        AstValidator.expr_return expr114 =null;


        CommonTree FLATTEN113_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:274:16: ( ^( FLATTEN expr ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:274:18: ^( FLATTEN expr )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FLATTEN113=(CommonTree)match(input,FLATTEN,FOLLOW_FLATTEN_in_flatten_clause1213); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FLATTEN113_tree = (CommonTree)adaptor.dupNode(FLATTEN113);


            root_1 = (CommonTree)adaptor.becomeRoot(FLATTEN113_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expr_in_flatten_clause1215);
            expr114=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, expr114.getTree());


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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:277:1: store_clause : ^( STORE rel filename ( func_clause )? ) ;
    public final AstValidator.store_clause_return store_clause() throws RecognitionException {
        AstValidator.store_clause_return retval = new AstValidator.store_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STORE115=null;
        AstValidator.rel_return rel116 =null;

        AstValidator.filename_return filename117 =null;

        AstValidator.func_clause_return func_clause118 =null;


        CommonTree STORE115_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:277:14: ( ^( STORE rel filename ( func_clause )? ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:277:16: ^( STORE rel filename ( func_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            STORE115=(CommonTree)match(input,STORE,FOLLOW_STORE_in_store_clause1228); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STORE115_tree = (CommonTree)adaptor.dupNode(STORE115);


            root_1 = (CommonTree)adaptor.becomeRoot(STORE115_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_store_clause1230);
            rel116=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel116.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_filename_in_store_clause1232);
            filename117=filename();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, filename117.getTree());


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:277:38: ( func_clause )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==FUNC||LA40_0==FUNC_REF) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:277:38: func_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_store_clause1234);
                    func_clause118=func_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause118.getTree());


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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:280:1: filter_clause : ^( FILTER rel cond ) ;
    public final AstValidator.filter_clause_return filter_clause() throws RecognitionException {
        AstValidator.filter_clause_return retval = new AstValidator.filter_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FILTER119=null;
        AstValidator.rel_return rel120 =null;

        AstValidator.cond_return cond121 =null;


        CommonTree FILTER119_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:280:15: ( ^( FILTER rel cond ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:280:17: ^( FILTER rel cond )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FILTER119=(CommonTree)match(input,FILTER,FOLLOW_FILTER_in_filter_clause1248); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FILTER119_tree = (CommonTree)adaptor.dupNode(FILTER119);


            root_1 = (CommonTree)adaptor.becomeRoot(FILTER119_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_filter_clause1250);
            rel120=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel120.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_filter_clause1252);
            cond121=cond();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond121.getTree());


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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:283:1: cond : ( ^( OR cond cond ) | ^( AND cond cond ) | ^( NOT cond ) | ^( NULL expr ( NOT )? ) | ^( rel_op expr expr ) | func_eval );
    public final AstValidator.cond_return cond() throws RecognitionException {
        AstValidator.cond_return retval = new AstValidator.cond_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree OR122=null;
        CommonTree AND125=null;
        CommonTree NOT128=null;
        CommonTree NULL130=null;
        CommonTree NOT132=null;
        AstValidator.cond_return cond123 =null;

        AstValidator.cond_return cond124 =null;

        AstValidator.cond_return cond126 =null;

        AstValidator.cond_return cond127 =null;

        AstValidator.cond_return cond129 =null;

        AstValidator.expr_return expr131 =null;

        AstValidator.rel_op_return rel_op133 =null;

        AstValidator.expr_return expr134 =null;

        AstValidator.expr_return expr135 =null;

        AstValidator.func_eval_return func_eval136 =null;


        CommonTree OR122_tree=null;
        CommonTree AND125_tree=null;
        CommonTree NOT128_tree=null;
        CommonTree NULL130_tree=null;
        CommonTree NOT132_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:283:6: ( ^( OR cond cond ) | ^( AND cond cond ) | ^( NOT cond ) | ^( NULL expr ( NOT )? ) | ^( rel_op expr expr ) | func_eval )
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:283:8: ^( OR cond cond )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    OR122=(CommonTree)match(input,OR,FOLLOW_OR_in_cond1265); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OR122_tree = (CommonTree)adaptor.dupNode(OR122);


                    root_1 = (CommonTree)adaptor.becomeRoot(OR122_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond1267);
                    cond123=cond();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cond123.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond1269);
                    cond124=cond();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cond124.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:284:8: ^( AND cond cond )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    AND125=(CommonTree)match(input,AND,FOLLOW_AND_in_cond1282); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    AND125_tree = (CommonTree)adaptor.dupNode(AND125);


                    root_1 = (CommonTree)adaptor.becomeRoot(AND125_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond1284);
                    cond126=cond();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cond126.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond1286);
                    cond127=cond();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cond127.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:285:8: ^( NOT cond )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NOT128=(CommonTree)match(input,NOT,FOLLOW_NOT_in_cond1299); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NOT128_tree = (CommonTree)adaptor.dupNode(NOT128);


                    root_1 = (CommonTree)adaptor.becomeRoot(NOT128_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond1301);
                    cond129=cond();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cond129.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:286:8: ^( NULL expr ( NOT )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NULL130=(CommonTree)match(input,NULL,FOLLOW_NULL_in_cond1314); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NULL130_tree = (CommonTree)adaptor.dupNode(NULL130);


                    root_1 = (CommonTree)adaptor.becomeRoot(NULL130_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond1316);
                    expr131=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr131.getTree());


                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:286:21: ( NOT )?
                    int alt41=2;
                    int LA41_0 = input.LA(1);

                    if ( (LA41_0==NOT) ) {
                        alt41=1;
                    }
                    switch (alt41) {
                        case 1 :
                            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:286:21: NOT
                            {
                            _last = (CommonTree)input.LT(1);
                            NOT132=(CommonTree)match(input,NOT,FOLLOW_NOT_in_cond1318); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            NOT132_tree = (CommonTree)adaptor.dupNode(NOT132);


                            adaptor.addChild(root_1, NOT132_tree);
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:287:8: ^( rel_op expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_in_cond1332);
                    rel_op133=rel_op();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_1 = (CommonTree)adaptor.becomeRoot(rel_op133.getTree(), root_1);


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond1334);
                    expr134=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr134.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond1336);
                    expr135=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr135.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:288:8: func_eval
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_eval_in_cond1347);
                    func_eval136=func_eval();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, func_eval136.getTree());


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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:291:1: func_eval : ^( FUNC_EVAL func_name ( real_arg )* ) ;
    public final AstValidator.func_eval_return func_eval() throws RecognitionException {
        AstValidator.func_eval_return retval = new AstValidator.func_eval_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FUNC_EVAL137=null;
        AstValidator.func_name_return func_name138 =null;

        AstValidator.real_arg_return real_arg139 =null;


        CommonTree FUNC_EVAL137_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:291:10: ( ^( FUNC_EVAL func_name ( real_arg )* ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:291:12: ^( FUNC_EVAL func_name ( real_arg )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FUNC_EVAL137=(CommonTree)match(input,FUNC_EVAL,FOLLOW_FUNC_EVAL_in_func_eval1357); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FUNC_EVAL137_tree = (CommonTree)adaptor.dupNode(FUNC_EVAL137);


            root_1 = (CommonTree)adaptor.becomeRoot(FUNC_EVAL137_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_func_name_in_func_eval1359);
            func_name138=func_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, func_name138.getTree());


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:291:35: ( real_arg )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==DIV||LA43_0==DOLLARVAR||LA43_0==DOUBLENUMBER||LA43_0==FALSE||LA43_0==FLOATNUMBER||LA43_0==GROUP||LA43_0==INTEGER||LA43_0==LONGINTEGER||LA43_0==MINUS||LA43_0==PERCENT||LA43_0==PLUS||LA43_0==QUOTEDSTRING||LA43_0==STAR||LA43_0==TRUE||(LA43_0 >= BAG_VAL && LA43_0 <= BIN_EXPR)||(LA43_0 >= CAST_EXPR && LA43_0 <= EXPR_IN_PAREN)||LA43_0==FUNC_EVAL||LA43_0==IDENTIFIER||(LA43_0 >= MAP_VAL && LA43_0 <= NEG)||LA43_0==NULL||LA43_0==TUPLE_VAL) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:291:35: real_arg
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_real_arg_in_func_eval1361);
            	    real_arg139=real_arg();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, real_arg139.getTree());


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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:294:1: real_arg : ( expr | STAR | col_range );
    public final AstValidator.real_arg_return real_arg() throws RecognitionException {
        AstValidator.real_arg_return retval = new AstValidator.real_arg_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR141=null;
        AstValidator.expr_return expr140 =null;

        AstValidator.col_range_return col_range142 =null;


        CommonTree STAR141_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:294:10: ( expr | STAR | col_range )
            int alt44=3;
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
                alt44=1;
                }
                break;
            case STAR:
                {
                int LA44_2 = input.LA(2);

                if ( (LA44_2==DOWN) ) {
                    alt44=1;
                }
                else if ( (LA44_2==EOF||LA44_2==UP||LA44_2==DIV||LA44_2==DOLLARVAR||LA44_2==DOUBLENUMBER||LA44_2==FALSE||LA44_2==FLOATNUMBER||LA44_2==GROUP||LA44_2==INTEGER||LA44_2==LONGINTEGER||LA44_2==MINUS||LA44_2==PERCENT||LA44_2==PLUS||LA44_2==QUOTEDSTRING||LA44_2==STAR||LA44_2==TRUE||(LA44_2 >= BAG_VAL && LA44_2 <= BIN_EXPR)||(LA44_2 >= CAST_EXPR && LA44_2 <= EXPR_IN_PAREN)||LA44_2==FUNC_EVAL||LA44_2==IDENTIFIER||(LA44_2 >= MAP_VAL && LA44_2 <= NEG)||LA44_2==NULL||LA44_2==TUPLE_VAL) ) {
                    alt44=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 44, 2, input);

                    throw nvae;

                }
                }
                break;
            case COL_RANGE:
                {
                alt44=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;

            }

            switch (alt44) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:294:12: expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_real_arg1373);
                    expr140=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expr140.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:294:19: STAR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR141=(CommonTree)match(input,STAR,FOLLOW_STAR_in_real_arg1377); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR141_tree = (CommonTree)adaptor.dupNode(STAR141);


                    adaptor.addChild(root_0, STAR141_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:294:26: col_range
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_real_arg1381);
                    col_range142=col_range();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range142.getTree());


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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:297:1: expr : ( ^( PLUS expr expr ) | ^( MINUS expr expr ) | ^( STAR expr expr ) | ^( DIV expr expr ) | ^( PERCENT expr expr ) | ^( CAST_EXPR type expr ) | const_expr | var_expr | ^( NEG expr ) | ^( CAST_EXPR type_cast expr ) | ^( EXPR_IN_PAREN expr ) );
    public final AstValidator.expr_return expr() throws RecognitionException {
        AstValidator.expr_return retval = new AstValidator.expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PLUS143=null;
        CommonTree MINUS146=null;
        CommonTree STAR149=null;
        CommonTree DIV152=null;
        CommonTree PERCENT155=null;
        CommonTree CAST_EXPR158=null;
        CommonTree NEG163=null;
        CommonTree CAST_EXPR165=null;
        CommonTree EXPR_IN_PAREN168=null;
        AstValidator.expr_return expr144 =null;

        AstValidator.expr_return expr145 =null;

        AstValidator.expr_return expr147 =null;

        AstValidator.expr_return expr148 =null;

        AstValidator.expr_return expr150 =null;

        AstValidator.expr_return expr151 =null;

        AstValidator.expr_return expr153 =null;

        AstValidator.expr_return expr154 =null;

        AstValidator.expr_return expr156 =null;

        AstValidator.expr_return expr157 =null;

        AstValidator.type_return type159 =null;

        AstValidator.expr_return expr160 =null;

        AstValidator.const_expr_return const_expr161 =null;

        AstValidator.var_expr_return var_expr162 =null;

        AstValidator.expr_return expr164 =null;

        AstValidator.type_cast_return type_cast166 =null;

        AstValidator.expr_return expr167 =null;

        AstValidator.expr_return expr169 =null;


        CommonTree PLUS143_tree=null;
        CommonTree MINUS146_tree=null;
        CommonTree STAR149_tree=null;
        CommonTree DIV152_tree=null;
        CommonTree PERCENT155_tree=null;
        CommonTree CAST_EXPR158_tree=null;
        CommonTree NEG163_tree=null;
        CommonTree CAST_EXPR165_tree=null;
        CommonTree EXPR_IN_PAREN168_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:297:6: ( ^( PLUS expr expr ) | ^( MINUS expr expr ) | ^( STAR expr expr ) | ^( DIV expr expr ) | ^( PERCENT expr expr ) | ^( CAST_EXPR type expr ) | const_expr | var_expr | ^( NEG expr ) | ^( CAST_EXPR type_cast expr ) | ^( EXPR_IN_PAREN expr ) )
            int alt45=11;
            switch ( input.LA(1) ) {
            case PLUS:
                {
                alt45=1;
                }
                break;
            case MINUS:
                {
                int LA45_2 = input.LA(2);

                if ( (synpred86_AstValidator()) ) {
                    alt45=2;
                }
                else if ( (synpred91_AstValidator()) ) {
                    alt45=7;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 45, 2, input);

                    throw nvae;

                }
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

                if ( (synpred90_AstValidator()) ) {
                    alt45=6;
                }
                else if ( (synpred94_AstValidator()) ) {
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:297:8: ^( PLUS expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    PLUS143=(CommonTree)match(input,PLUS,FOLLOW_PLUS_in_expr1392); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PLUS143_tree = (CommonTree)adaptor.dupNode(PLUS143);


                    root_1 = (CommonTree)adaptor.becomeRoot(PLUS143_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1394);
                    expr144=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr144.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1396);
                    expr145=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr145.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:298:8: ^( MINUS expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    MINUS146=(CommonTree)match(input,MINUS,FOLLOW_MINUS_in_expr1409); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MINUS146_tree = (CommonTree)adaptor.dupNode(MINUS146);


                    root_1 = (CommonTree)adaptor.becomeRoot(MINUS146_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1411);
                    expr147=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr147.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1413);
                    expr148=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr148.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:299:8: ^( STAR expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    STAR149=(CommonTree)match(input,STAR,FOLLOW_STAR_in_expr1426); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR149_tree = (CommonTree)adaptor.dupNode(STAR149);


                    root_1 = (CommonTree)adaptor.becomeRoot(STAR149_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1428);
                    expr150=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr150.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1430);
                    expr151=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr151.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:300:8: ^( DIV expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    DIV152=(CommonTree)match(input,DIV,FOLLOW_DIV_in_expr1443); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DIV152_tree = (CommonTree)adaptor.dupNode(DIV152);


                    root_1 = (CommonTree)adaptor.becomeRoot(DIV152_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1445);
                    expr153=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr153.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1447);
                    expr154=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr154.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:301:8: ^( PERCENT expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    PERCENT155=(CommonTree)match(input,PERCENT,FOLLOW_PERCENT_in_expr1460); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PERCENT155_tree = (CommonTree)adaptor.dupNode(PERCENT155);


                    root_1 = (CommonTree)adaptor.becomeRoot(PERCENT155_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1462);
                    expr156=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr156.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1464);
                    expr157=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr157.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:302:8: ^( CAST_EXPR type expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    CAST_EXPR158=(CommonTree)match(input,CAST_EXPR,FOLLOW_CAST_EXPR_in_expr1477); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CAST_EXPR158_tree = (CommonTree)adaptor.dupNode(CAST_EXPR158);


                    root_1 = (CommonTree)adaptor.becomeRoot(CAST_EXPR158_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_type_in_expr1479);
                    type159=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, type159.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1481);
                    expr160=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr160.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:303:8: const_expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_const_expr_in_expr1492);
                    const_expr161=const_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, const_expr161.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:304:8: var_expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_var_expr_in_expr1501);
                    var_expr162=var_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, var_expr162.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:305:8: ^( NEG expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NEG163=(CommonTree)match(input,NEG,FOLLOW_NEG_in_expr1512); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NEG163_tree = (CommonTree)adaptor.dupNode(NEG163);


                    root_1 = (CommonTree)adaptor.becomeRoot(NEG163_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1514);
                    expr164=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr164.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:306:8: ^( CAST_EXPR type_cast expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    CAST_EXPR165=(CommonTree)match(input,CAST_EXPR,FOLLOW_CAST_EXPR_in_expr1527); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CAST_EXPR165_tree = (CommonTree)adaptor.dupNode(CAST_EXPR165);


                    root_1 = (CommonTree)adaptor.becomeRoot(CAST_EXPR165_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_type_cast_in_expr1529);
                    type_cast166=type_cast();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, type_cast166.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1531);
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
                case 11 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:307:8: ^( EXPR_IN_PAREN expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    EXPR_IN_PAREN168=(CommonTree)match(input,EXPR_IN_PAREN,FOLLOW_EXPR_IN_PAREN_in_expr1544); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EXPR_IN_PAREN168_tree = (CommonTree)adaptor.dupNode(EXPR_IN_PAREN168);


                    root_1 = (CommonTree)adaptor.becomeRoot(EXPR_IN_PAREN168_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1546);
                    expr169=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr169.getTree());


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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:310:1: type_cast : ( simple_type | map_type | tuple_type_cast | bag_type_cast );
    public final AstValidator.type_cast_return type_cast() throws RecognitionException {
        AstValidator.type_cast_return retval = new AstValidator.type_cast_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.simple_type_return simple_type170 =null;

        AstValidator.map_type_return map_type171 =null;

        AstValidator.tuple_type_cast_return tuple_type_cast172 =null;

        AstValidator.bag_type_cast_return bag_type_cast173 =null;



        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:310:11: ( simple_type | map_type | tuple_type_cast | bag_type_cast )
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:310:13: simple_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_simple_type_in_type_cast1557);
                    simple_type170=simple_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, simple_type170.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:310:27: map_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_map_type_in_type_cast1561);
                    map_type171=map_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, map_type171.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:310:38: tuple_type_cast
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_tuple_type_cast_in_type_cast1565);
                    tuple_type_cast172=tuple_type_cast();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, tuple_type_cast172.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:310:56: bag_type_cast
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_bag_type_cast_in_type_cast1569);
                    bag_type_cast173=bag_type_cast();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, bag_type_cast173.getTree());


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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:313:1: tuple_type_cast : ^( TUPLE_TYPE_CAST ( type_cast )* ) ;
    public final AstValidator.tuple_type_cast_return tuple_type_cast() throws RecognitionException {
        AstValidator.tuple_type_cast_return retval = new AstValidator.tuple_type_cast_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree TUPLE_TYPE_CAST174=null;
        AstValidator.type_cast_return type_cast175 =null;


        CommonTree TUPLE_TYPE_CAST174_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:313:17: ( ^( TUPLE_TYPE_CAST ( type_cast )* ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:313:19: ^( TUPLE_TYPE_CAST ( type_cast )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            TUPLE_TYPE_CAST174=(CommonTree)match(input,TUPLE_TYPE_CAST,FOLLOW_TUPLE_TYPE_CAST_in_tuple_type_cast1580); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            TUPLE_TYPE_CAST174_tree = (CommonTree)adaptor.dupNode(TUPLE_TYPE_CAST174);


            root_1 = (CommonTree)adaptor.becomeRoot(TUPLE_TYPE_CAST174_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:313:38: ( type_cast )*
                loop47:
                do {
                    int alt47=2;
                    int LA47_0 = input.LA(1);

                    if ( (LA47_0==BOOLEAN||LA47_0==BYTEARRAY||LA47_0==CHARARRAY||LA47_0==DOUBLE||LA47_0==FLOAT||LA47_0==INT||LA47_0==LONG||LA47_0==BAG_TYPE_CAST||LA47_0==MAP_TYPE||LA47_0==TUPLE_TYPE_CAST) ) {
                        alt47=1;
                    }


                    switch (alt47) {
                	case 1 :
                	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:313:38: type_cast
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_type_cast_in_tuple_type_cast1582);
                	    type_cast175=type_cast();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, type_cast175.getTree());


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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:316:1: bag_type_cast : ^( BAG_TYPE_CAST ( tuple_type_cast )? ) ;
    public final AstValidator.bag_type_cast_return bag_type_cast() throws RecognitionException {
        AstValidator.bag_type_cast_return retval = new AstValidator.bag_type_cast_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BAG_TYPE_CAST176=null;
        AstValidator.tuple_type_cast_return tuple_type_cast177 =null;


        CommonTree BAG_TYPE_CAST176_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:316:15: ( ^( BAG_TYPE_CAST ( tuple_type_cast )? ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:316:17: ^( BAG_TYPE_CAST ( tuple_type_cast )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BAG_TYPE_CAST176=(CommonTree)match(input,BAG_TYPE_CAST,FOLLOW_BAG_TYPE_CAST_in_bag_type_cast1596); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BAG_TYPE_CAST176_tree = (CommonTree)adaptor.dupNode(BAG_TYPE_CAST176);


            root_1 = (CommonTree)adaptor.becomeRoot(BAG_TYPE_CAST176_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:316:34: ( tuple_type_cast )?
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==TUPLE_TYPE_CAST) ) {
                    alt48=1;
                }
                switch (alt48) {
                    case 1 :
                        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:316:34: tuple_type_cast
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_tuple_type_cast_in_bag_type_cast1598);
                        tuple_type_cast177=tuple_type_cast();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, tuple_type_cast177.getTree());


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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:319:1: var_expr : projectable_expr ( dot_proj | pound_proj )* ;
    public final AstValidator.var_expr_return var_expr() throws RecognitionException {
        AstValidator.var_expr_return retval = new AstValidator.var_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.projectable_expr_return projectable_expr178 =null;

        AstValidator.dot_proj_return dot_proj179 =null;

        AstValidator.pound_proj_return pound_proj180 =null;



        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:319:10: ( projectable_expr ( dot_proj | pound_proj )* )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:319:12: projectable_expr ( dot_proj | pound_proj )*
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_projectable_expr_in_var_expr1610);
            projectable_expr178=projectable_expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, projectable_expr178.getTree());


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:319:29: ( dot_proj | pound_proj )*
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
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:319:31: dot_proj
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_dot_proj_in_var_expr1614);
            	    dot_proj179=dot_proj();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, dot_proj179.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;
            	case 2 :
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:319:42: pound_proj
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_pound_proj_in_var_expr1618);
            	    pound_proj180=pound_proj();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, pound_proj180.getTree());


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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:322:1: projectable_expr : ( func_eval | col_ref | bin_expr );
    public final AstValidator.projectable_expr_return projectable_expr() throws RecognitionException {
        AstValidator.projectable_expr_return retval = new AstValidator.projectable_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.func_eval_return func_eval181 =null;

        AstValidator.col_ref_return col_ref182 =null;

        AstValidator.bin_expr_return bin_expr183 =null;



        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:322:17: ( func_eval | col_ref | bin_expr )
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:322:19: func_eval
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_eval_in_projectable_expr1629);
                    func_eval181=func_eval();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, func_eval181.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:322:31: col_ref
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_projectable_expr1633);
                    col_ref182=col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_ref182.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:322:41: bin_expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_bin_expr_in_projectable_expr1637);
                    bin_expr183=bin_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, bin_expr183.getTree());


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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:325:1: dot_proj : ^( PERIOD ( col_alias_or_index )+ ) ;
    public final AstValidator.dot_proj_return dot_proj() throws RecognitionException {
        AstValidator.dot_proj_return retval = new AstValidator.dot_proj_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PERIOD184=null;
        AstValidator.col_alias_or_index_return col_alias_or_index185 =null;


        CommonTree PERIOD184_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:325:10: ( ^( PERIOD ( col_alias_or_index )+ ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:325:12: ^( PERIOD ( col_alias_or_index )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            PERIOD184=(CommonTree)match(input,PERIOD,FOLLOW_PERIOD_in_dot_proj1648); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PERIOD184_tree = (CommonTree)adaptor.dupNode(PERIOD184);


            root_1 = (CommonTree)adaptor.becomeRoot(PERIOD184_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:325:22: ( col_alias_or_index )+
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
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:325:22: col_alias_or_index
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_col_alias_or_index_in_dot_proj1650);
            	    col_alias_or_index185=col_alias_or_index();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, col_alias_or_index185.getTree());


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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:328:1: col_alias_or_index : ( col_alias | col_index );
    public final AstValidator.col_alias_or_index_return col_alias_or_index() throws RecognitionException {
        AstValidator.col_alias_or_index_return retval = new AstValidator.col_alias_or_index_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.col_alias_return col_alias186 =null;

        AstValidator.col_index_return col_index187 =null;



        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:328:20: ( col_alias | col_index )
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:328:22: col_alias
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_alias_in_col_alias_or_index1662);
                    col_alias186=col_alias();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_alias186.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:328:34: col_index
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_index_in_col_alias_or_index1666);
                    col_index187=col_index();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_index187.getTree());


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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:331:1: col_alias : ( GROUP | IDENTIFIER );
    public final AstValidator.col_alias_return col_alias() throws RecognitionException {
        AstValidator.col_alias_return retval = new AstValidator.col_alias_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set188=null;

        CommonTree set188_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:331:11: ( GROUP | IDENTIFIER )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set188=(CommonTree)input.LT(1);

            if ( input.LA(1)==GROUP||input.LA(1)==IDENTIFIER ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set188_tree = (CommonTree)adaptor.dupNode(set188);


                adaptor.addChild(root_0, set188_tree);
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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:334:1: col_index : DOLLARVAR ;
    public final AstValidator.col_index_return col_index() throws RecognitionException {
        AstValidator.col_index_return retval = new AstValidator.col_index_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DOLLARVAR189=null;

        CommonTree DOLLARVAR189_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:334:11: ( DOLLARVAR )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:334:13: DOLLARVAR
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            DOLLARVAR189=(CommonTree)match(input,DOLLARVAR,FOLLOW_DOLLARVAR_in_col_index1688); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DOLLARVAR189_tree = (CommonTree)adaptor.dupNode(DOLLARVAR189);


            adaptor.addChild(root_0, DOLLARVAR189_tree);
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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:337:1: col_range : ^( COL_RANGE ( col_ref )? DOUBLE_PERIOD ( col_ref )? ) ;
    public final AstValidator.col_range_return col_range() throws RecognitionException {
        AstValidator.col_range_return retval = new AstValidator.col_range_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree COL_RANGE190=null;
        CommonTree DOUBLE_PERIOD192=null;
        AstValidator.col_ref_return col_ref191 =null;

        AstValidator.col_ref_return col_ref193 =null;


        CommonTree COL_RANGE190_tree=null;
        CommonTree DOUBLE_PERIOD192_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:337:11: ( ^( COL_RANGE ( col_ref )? DOUBLE_PERIOD ( col_ref )? ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:337:14: ^( COL_RANGE ( col_ref )? DOUBLE_PERIOD ( col_ref )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            COL_RANGE190=(CommonTree)match(input,COL_RANGE,FOLLOW_COL_RANGE_in_col_range1699); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            COL_RANGE190_tree = (CommonTree)adaptor.dupNode(COL_RANGE190);


            root_1 = (CommonTree)adaptor.becomeRoot(COL_RANGE190_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:337:26: ( col_ref )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==DOLLARVAR||LA53_0==GROUP||LA53_0==IDENTIFIER) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:337:26: col_ref
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_col_range1701);
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


            _last = (CommonTree)input.LT(1);
            DOUBLE_PERIOD192=(CommonTree)match(input,DOUBLE_PERIOD,FOLLOW_DOUBLE_PERIOD_in_col_range1704); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DOUBLE_PERIOD192_tree = (CommonTree)adaptor.dupNode(DOUBLE_PERIOD192);


            adaptor.addChild(root_1, DOUBLE_PERIOD192_tree);
            }


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:337:49: ( col_ref )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==DOLLARVAR||LA54_0==GROUP||LA54_0==IDENTIFIER) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:337:49: col_ref
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_col_range1706);
                    col_ref193=col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, col_ref193.getTree());


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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:341:1: pound_proj : ^( POUND ( QUOTEDSTRING | NULL ) ) ;
    public final AstValidator.pound_proj_return pound_proj() throws RecognitionException {
        AstValidator.pound_proj_return retval = new AstValidator.pound_proj_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree POUND194=null;
        CommonTree set195=null;

        CommonTree POUND194_tree=null;
        CommonTree set195_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:341:12: ( ^( POUND ( QUOTEDSTRING | NULL ) ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:341:14: ^( POUND ( QUOTEDSTRING | NULL ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            POUND194=(CommonTree)match(input,POUND,FOLLOW_POUND_in_pound_proj1720); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            POUND194_tree = (CommonTree)adaptor.dupNode(POUND194);


            root_1 = (CommonTree)adaptor.becomeRoot(POUND194_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            set195=(CommonTree)input.LT(1);

            if ( input.LA(1)==QUOTEDSTRING||input.LA(1)==NULL ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set195_tree = (CommonTree)adaptor.dupNode(set195);


                adaptor.addChild(root_1, set195_tree);
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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:344:1: bin_expr : ^( BIN_EXPR cond expr expr ) ;
    public final AstValidator.bin_expr_return bin_expr() throws RecognitionException {
        AstValidator.bin_expr_return retval = new AstValidator.bin_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BIN_EXPR196=null;
        AstValidator.cond_return cond197 =null;

        AstValidator.expr_return expr198 =null;

        AstValidator.expr_return expr199 =null;


        CommonTree BIN_EXPR196_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:344:10: ( ^( BIN_EXPR cond expr expr ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:344:12: ^( BIN_EXPR cond expr expr )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BIN_EXPR196=(CommonTree)match(input,BIN_EXPR,FOLLOW_BIN_EXPR_in_bin_expr1743); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BIN_EXPR196_tree = (CommonTree)adaptor.dupNode(BIN_EXPR196);


            root_1 = (CommonTree)adaptor.becomeRoot(BIN_EXPR196_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_bin_expr1745);
            cond197=cond();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond197.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expr_in_bin_expr1747);
            expr198=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, expr198.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expr_in_bin_expr1749);
            expr199=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, expr199.getTree());


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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:347:1: limit_clause : ^( LIMIT rel ( INTEGER | LONGINTEGER | expr ) ) ;
    public final AstValidator.limit_clause_return limit_clause() throws RecognitionException {
        AstValidator.limit_clause_return retval = new AstValidator.limit_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree LIMIT200=null;
        CommonTree INTEGER202=null;
        CommonTree LONGINTEGER203=null;
        AstValidator.rel_return rel201 =null;

        AstValidator.expr_return expr204 =null;


        CommonTree LIMIT200_tree=null;
        CommonTree INTEGER202_tree=null;
        CommonTree LONGINTEGER203_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:347:14: ( ^( LIMIT rel ( INTEGER | LONGINTEGER | expr ) ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:347:16: ^( LIMIT rel ( INTEGER | LONGINTEGER | expr ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            LIMIT200=(CommonTree)match(input,LIMIT,FOLLOW_LIMIT_in_limit_clause1762); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LIMIT200_tree = (CommonTree)adaptor.dupNode(LIMIT200);


            root_1 = (CommonTree)adaptor.becomeRoot(LIMIT200_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_limit_clause1764);
            rel201=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel201.getTree());


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:347:29: ( INTEGER | LONGINTEGER | expr )
            int alt55=3;
            switch ( input.LA(1) ) {
            case INTEGER:
                {
                int LA55_1 = input.LA(2);

                if ( (synpred110_AstValidator()) ) {
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

                if ( (synpred111_AstValidator()) ) {
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:347:31: INTEGER
                    {
                    _last = (CommonTree)input.LT(1);
                    INTEGER202=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_limit_clause1768); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INTEGER202_tree = (CommonTree)adaptor.dupNode(INTEGER202);


                    adaptor.addChild(root_1, INTEGER202_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:347:41: LONGINTEGER
                    {
                    _last = (CommonTree)input.LT(1);
                    LONGINTEGER203=(CommonTree)match(input,LONGINTEGER,FOLLOW_LONGINTEGER_in_limit_clause1772); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LONGINTEGER203_tree = (CommonTree)adaptor.dupNode(LONGINTEGER203);


                    adaptor.addChild(root_1, LONGINTEGER203_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:347:55: expr
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_limit_clause1776);
                    expr204=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr204.getTree());


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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:350:1: sample_clause : ^( SAMPLE rel ( DOUBLENUMBER | expr ) ) ;
    public final AstValidator.sample_clause_return sample_clause() throws RecognitionException {
        AstValidator.sample_clause_return retval = new AstValidator.sample_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SAMPLE205=null;
        CommonTree DOUBLENUMBER207=null;
        AstValidator.rel_return rel206 =null;

        AstValidator.expr_return expr208 =null;


        CommonTree SAMPLE205_tree=null;
        CommonTree DOUBLENUMBER207_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:350:15: ( ^( SAMPLE rel ( DOUBLENUMBER | expr ) ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:350:17: ^( SAMPLE rel ( DOUBLENUMBER | expr ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            SAMPLE205=(CommonTree)match(input,SAMPLE,FOLLOW_SAMPLE_in_sample_clause1791); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SAMPLE205_tree = (CommonTree)adaptor.dupNode(SAMPLE205);


            root_1 = (CommonTree)adaptor.becomeRoot(SAMPLE205_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_sample_clause1793);
            rel206=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel206.getTree());


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:350:31: ( DOUBLENUMBER | expr )
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==DOUBLENUMBER) ) {
                int LA56_1 = input.LA(2);

                if ( (synpred112_AstValidator()) ) {
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:350:33: DOUBLENUMBER
                    {
                    _last = (CommonTree)input.LT(1);
                    DOUBLENUMBER207=(CommonTree)match(input,DOUBLENUMBER,FOLLOW_DOUBLENUMBER_in_sample_clause1797); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DOUBLENUMBER207_tree = (CommonTree)adaptor.dupNode(DOUBLENUMBER207);


                    adaptor.addChild(root_1, DOUBLENUMBER207_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:350:48: expr
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_sample_clause1801);
                    expr208=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr208.getTree());


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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:353:1: order_clause : ^( ORDER rel order_by_clause ( func_clause )? ) ;
    public final AstValidator.order_clause_return order_clause() throws RecognitionException {
        AstValidator.order_clause_return retval = new AstValidator.order_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ORDER209=null;
        AstValidator.rel_return rel210 =null;

        AstValidator.order_by_clause_return order_by_clause211 =null;

        AstValidator.func_clause_return func_clause212 =null;


        CommonTree ORDER209_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:353:14: ( ^( ORDER rel order_by_clause ( func_clause )? ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:353:16: ^( ORDER rel order_by_clause ( func_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            ORDER209=(CommonTree)match(input,ORDER,FOLLOW_ORDER_in_order_clause1816); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ORDER209_tree = (CommonTree)adaptor.dupNode(ORDER209);


            root_1 = (CommonTree)adaptor.becomeRoot(ORDER209_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_order_clause1818);
            rel210=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel210.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_order_by_clause_in_order_clause1820);
            order_by_clause211=order_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, order_by_clause211.getTree());


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:353:45: ( func_clause )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==FUNC||LA57_0==FUNC_REF) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:353:45: func_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_order_clause1822);
                    func_clause212=func_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause212.getTree());


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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:356:1: order_by_clause : ( STAR ( ASC | DESC )? | ( order_col )+ );
    public final AstValidator.order_by_clause_return order_by_clause() throws RecognitionException {
        AstValidator.order_by_clause_return retval = new AstValidator.order_by_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR213=null;
        CommonTree set214=null;
        AstValidator.order_col_return order_col215 =null;


        CommonTree STAR213_tree=null;
        CommonTree set214_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:356:17: ( STAR ( ASC | DESC )? | ( order_col )+ )
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:356:19: STAR ( ASC | DESC )?
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR213=(CommonTree)match(input,STAR,FOLLOW_STAR_in_order_by_clause1834); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR213_tree = (CommonTree)adaptor.dupNode(STAR213);


                    adaptor.addChild(root_0, STAR213_tree);
                    }


                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:356:24: ( ASC | DESC )?
                    int alt58=2;
                    int LA58_0 = input.LA(1);

                    if ( (LA58_0==ASC||LA58_0==DESC) ) {
                        alt58=1;
                    }
                    switch (alt58) {
                        case 1 :
                            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:
                            {
                            _last = (CommonTree)input.LT(1);
                            set214=(CommonTree)input.LT(1);

                            if ( input.LA(1)==ASC||input.LA(1)==DESC ) {
                                input.consume();
                                if ( state.backtracking==0 ) {
                                set214_tree = (CommonTree)adaptor.dupNode(set214);


                                adaptor.addChild(root_0, set214_tree);
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:357:19: ( order_col )+
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:357:19: ( order_col )+
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
                    	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:357:19: order_col
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_order_col_in_order_by_clause1865);
                    	    order_col215=order_col();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, order_col215.getTree());


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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:360:1: order_col : ( col_range ( ASC | DESC )? | col_ref ( ASC | DESC )? );
    public final AstValidator.order_col_return order_col() throws RecognitionException {
        AstValidator.order_col_return retval = new AstValidator.order_col_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set217=null;
        CommonTree set219=null;
        AstValidator.col_range_return col_range216 =null;

        AstValidator.col_ref_return col_ref218 =null;


        CommonTree set217_tree=null;
        CommonTree set219_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:360:11: ( col_range ( ASC | DESC )? | col_ref ( ASC | DESC )? )
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==COL_RANGE) ) {
                alt63=1;
            }
            else if ( (LA63_0==DOLLARVAR||LA63_0==GROUP||LA63_0==IDENTIFIER) ) {
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:360:13: col_range ( ASC | DESC )?
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_order_col1875);
                    col_range216=col_range();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range216.getTree());


                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:360:23: ( ASC | DESC )?
                    int alt61=2;
                    int LA61_0 = input.LA(1);

                    if ( (LA61_0==ASC||LA61_0==DESC) ) {
                        alt61=1;
                    }
                    switch (alt61) {
                        case 1 :
                            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:
                            {
                            _last = (CommonTree)input.LT(1);
                            set217=(CommonTree)input.LT(1);

                            if ( input.LA(1)==ASC||input.LA(1)==DESC ) {
                                input.consume();
                                if ( state.backtracking==0 ) {
                                set217_tree = (CommonTree)adaptor.dupNode(set217);


                                adaptor.addChild(root_0, set217_tree);
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:361:13: col_ref ( ASC | DESC )?
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_order_col1898);
                    col_ref218=col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_ref218.getTree());


                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:361:21: ( ASC | DESC )?
                    int alt62=2;
                    int LA62_0 = input.LA(1);

                    if ( (LA62_0==ASC||LA62_0==DESC) ) {
                        alt62=1;
                    }
                    switch (alt62) {
                        case 1 :
                            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:
                            {
                            _last = (CommonTree)input.LT(1);
                            set219=(CommonTree)input.LT(1);

                            if ( input.LA(1)==ASC||input.LA(1)==DESC ) {
                                input.consume();
                                if ( state.backtracking==0 ) {
                                set219_tree = (CommonTree)adaptor.dupNode(set219);


                                adaptor.addChild(root_0, set219_tree);
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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:364:1: distinct_clause : ^( DISTINCT rel ( partition_clause )? ) ;
    public final AstValidator.distinct_clause_return distinct_clause() throws RecognitionException {
        AstValidator.distinct_clause_return retval = new AstValidator.distinct_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DISTINCT220=null;
        AstValidator.rel_return rel221 =null;

        AstValidator.partition_clause_return partition_clause222 =null;


        CommonTree DISTINCT220_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:364:17: ( ^( DISTINCT rel ( partition_clause )? ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:364:19: ^( DISTINCT rel ( partition_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            DISTINCT220=(CommonTree)match(input,DISTINCT,FOLLOW_DISTINCT_in_distinct_clause1920); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DISTINCT220_tree = (CommonTree)adaptor.dupNode(DISTINCT220);


            root_1 = (CommonTree)adaptor.becomeRoot(DISTINCT220_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_distinct_clause1922);
            rel221=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel221.getTree());


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:364:35: ( partition_clause )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==PARTITION) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:364:35: partition_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_partition_clause_in_distinct_clause1924);
                    partition_clause222=partition_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, partition_clause222.getTree());


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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:367:1: partition_clause : ^( PARTITION func_name ) ;
    public final AstValidator.partition_clause_return partition_clause() throws RecognitionException {
        AstValidator.partition_clause_return retval = new AstValidator.partition_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PARTITION223=null;
        AstValidator.func_name_return func_name224 =null;


        CommonTree PARTITION223_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:367:18: ( ^( PARTITION func_name ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:367:20: ^( PARTITION func_name )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            PARTITION223=(CommonTree)match(input,PARTITION,FOLLOW_PARTITION_in_partition_clause1938); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PARTITION223_tree = (CommonTree)adaptor.dupNode(PARTITION223);


            root_1 = (CommonTree)adaptor.becomeRoot(PARTITION223_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_func_name_in_partition_clause1940);
            func_name224=func_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, func_name224.getTree());


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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:370:1: cross_clause : ^( CROSS rel_list ( partition_clause )? ) ;
    public final AstValidator.cross_clause_return cross_clause() throws RecognitionException {
        AstValidator.cross_clause_return retval = new AstValidator.cross_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CROSS225=null;
        AstValidator.rel_list_return rel_list226 =null;

        AstValidator.partition_clause_return partition_clause227 =null;


        CommonTree CROSS225_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:370:14: ( ^( CROSS rel_list ( partition_clause )? ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:370:16: ^( CROSS rel_list ( partition_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CROSS225=(CommonTree)match(input,CROSS,FOLLOW_CROSS_in_cross_clause1953); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CROSS225_tree = (CommonTree)adaptor.dupNode(CROSS225);


            root_1 = (CommonTree)adaptor.becomeRoot(CROSS225_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_list_in_cross_clause1955);
            rel_list226=rel_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel_list226.getTree());


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:370:34: ( partition_clause )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==PARTITION) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:370:34: partition_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_partition_clause_in_cross_clause1957);
                    partition_clause227=partition_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, partition_clause227.getTree());


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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:373:1: rel_list : ( rel )+ ;
    public final AstValidator.rel_list_return rel_list() throws RecognitionException {
        AstValidator.rel_list_return retval = new AstValidator.rel_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.rel_return rel228 =null;



        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:373:10: ( ( rel )+ )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:373:12: ( rel )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:373:12: ( rel )+
            int cnt66=0;
            loop66:
            do {
                int alt66=2;
                int LA66_0 = input.LA(1);

                if ( (LA66_0==COGROUP||LA66_0==CROSS||LA66_0==DEFINE||LA66_0==DISTINCT||LA66_0==FILTER||LA66_0==FOREACH||LA66_0==GROUP||LA66_0==JOIN||(LA66_0 >= LIMIT && LA66_0 <= LOAD)||LA66_0==MAPREDUCE||LA66_0==ORDER||LA66_0==SAMPLE||LA66_0==SPLIT||(LA66_0 >= STORE && LA66_0 <= STREAM)||LA66_0==UNION||LA66_0==IDENTIFIER) ) {
                    alt66=1;
                }


                switch (alt66) {
            	case 1 :
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:373:12: rel
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_rel_in_rel_list1969);
            	    rel228=rel();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, rel228.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt66 >= 1 ) break loop66;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(66, input);
                        throw eee;
                }
                cnt66++;
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


    protected static class join_clause_scope {
        int arity;
    }
    protected Stack join_clause_stack = new Stack();


    public static class join_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "join_clause"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:376:1: join_clause : ^( JOIN join_sub_clause ( join_type )? ( partition_clause )? ) ;
    public final AstValidator.join_clause_return join_clause() throws RecognitionException {
        join_clause_stack.push(new join_clause_scope());
        AstValidator.join_clause_return retval = new AstValidator.join_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree JOIN229=null;
        AstValidator.join_sub_clause_return join_sub_clause230 =null;

        AstValidator.join_type_return join_type231 =null;

        AstValidator.partition_clause_return partition_clause232 =null;


        CommonTree JOIN229_tree=null;


            ((join_clause_scope)join_clause_stack.peek()).arity = 0;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:383:2: ( ^( JOIN join_sub_clause ( join_type )? ( partition_clause )? ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:383:4: ^( JOIN join_sub_clause ( join_type )? ( partition_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            JOIN229=(CommonTree)match(input,JOIN,FOLLOW_JOIN_in_join_clause1991); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            JOIN229_tree = (CommonTree)adaptor.dupNode(JOIN229);


            root_1 = (CommonTree)adaptor.becomeRoot(JOIN229_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_join_sub_clause_in_join_clause1993);
            join_sub_clause230=join_sub_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, join_sub_clause230.getTree());


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:383:28: ( join_type )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==QUOTEDSTRING) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:383:28: join_type
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_type_in_join_clause1995);
                    join_type231=join_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, join_type231.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:383:39: ( partition_clause )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==PARTITION) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:383:39: partition_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_partition_clause_in_join_clause1998);
                    partition_clause232=partition_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, partition_clause232.getTree());


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
            join_clause_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "join_clause"


    public static class join_type_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "join_type"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:386:1: join_type : QUOTEDSTRING ;
    public final AstValidator.join_type_return join_type() throws RecognitionException {
        AstValidator.join_type_return retval = new AstValidator.join_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING233=null;

        CommonTree QUOTEDSTRING233_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:386:11: ( QUOTEDSTRING )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:386:13: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING233=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_join_type2010); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING233_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING233);


            adaptor.addChild(root_0, QUOTEDSTRING233_tree);
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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:389:1: join_sub_clause : ( join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item | ( join_item )+ );
    public final AstValidator.join_sub_clause_return join_sub_clause() throws RecognitionException {
        AstValidator.join_sub_clause_return retval = new AstValidator.join_sub_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set235=null;
        CommonTree OUTER236=null;
        AstValidator.join_item_return join_item234 =null;

        AstValidator.join_item_return join_item237 =null;

        AstValidator.join_item_return join_item238 =null;


        CommonTree set235_tree=null;
        CommonTree OUTER236_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:390:2: ( join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item | ( join_item )+ )
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==JOIN_ITEM) ) {
                int LA71_1 = input.LA(2);

                if ( (synpred131_AstValidator()) ) {
                    alt71=1;
                }
                else if ( (true) ) {
                    alt71=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 71, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 71, 0, input);

                throw nvae;

            }
            switch (alt71) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:390:4: join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_item_in_join_sub_clause2020);
                    join_item234=join_item();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, join_item234.getTree());


                    _last = (CommonTree)input.LT(1);
                    set235=(CommonTree)input.LT(1);

                    if ( input.LA(1)==FULL||input.LA(1)==LEFT||input.LA(1)==RIGHT ) {
                        input.consume();
                        if ( state.backtracking==0 ) {
                        set235_tree = (CommonTree)adaptor.dupNode(set235);


                        adaptor.addChild(root_0, set235_tree);
                        }

                        state.errorRecovery=false;
                        state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }


                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:390:38: ( OUTER )?
                    int alt69=2;
                    int LA69_0 = input.LA(1);

                    if ( (LA69_0==OUTER) ) {
                        alt69=1;
                    }
                    switch (alt69) {
                        case 1 :
                            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:390:38: OUTER
                            {
                            _last = (CommonTree)input.LT(1);
                            OUTER236=(CommonTree)match(input,OUTER,FOLLOW_OUTER_in_join_sub_clause2036); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            OUTER236_tree = (CommonTree)adaptor.dupNode(OUTER236);


                            adaptor.addChild(root_0, OUTER236_tree);
                            }


                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_item_in_join_sub_clause2039);
                    join_item237=join_item();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, join_item237.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:391:4: ( join_item )+
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:391:4: ( join_item )+
                    int cnt70=0;
                    loop70:
                    do {
                        int alt70=2;
                        int LA70_0 = input.LA(1);

                        if ( (LA70_0==JOIN_ITEM) ) {
                            alt70=1;
                        }


                        switch (alt70) {
                    	case 1 :
                    	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:391:4: join_item
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_join_item_in_join_sub_clause2044);
                    	    join_item238=join_item();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, join_item238.getTree());


                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    if ( cnt70 >= 1 ) break loop70;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(70, input);
                                throw eee;
                        }
                        cnt70++;
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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:394:1: join_item : ^( JOIN_ITEM rel join_group_by_clause ) ;
    public final AstValidator.join_item_return join_item() throws RecognitionException {
        AstValidator.join_item_return retval = new AstValidator.join_item_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree JOIN_ITEM239=null;
        AstValidator.rel_return rel240 =null;

        AstValidator.join_group_by_clause_return join_group_by_clause241 =null;


        CommonTree JOIN_ITEM239_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:395:2: ( ^( JOIN_ITEM rel join_group_by_clause ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:395:4: ^( JOIN_ITEM rel join_group_by_clause )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            JOIN_ITEM239=(CommonTree)match(input,JOIN_ITEM,FOLLOW_JOIN_ITEM_in_join_item2057); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            JOIN_ITEM239_tree = (CommonTree)adaptor.dupNode(JOIN_ITEM239);


            root_1 = (CommonTree)adaptor.becomeRoot(JOIN_ITEM239_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_join_item2059);
            rel240=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel240.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_join_group_by_clause_in_join_item2061);
            join_group_by_clause241=join_group_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, join_group_by_clause241.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   if( ((join_clause_scope)join_clause_stack.peek()).arity == 0 ) {
                       // For the first input
                       ((join_clause_scope)join_clause_stack.peek()).arity = (join_group_by_clause241!=null?join_group_by_clause241.exprCount:0);
                   } else if( (join_group_by_clause241!=null?join_group_by_clause241.exprCount:0) != ((join_clause_scope)join_clause_stack.peek()).arity ) {
                       throw new ParserValidationException( input, new SourceLocation( (PigParserNode)((CommonTree)retval.start) ),
                           "The arity of the join columns do not match." );
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
    // $ANTLR end "join_item"


    public static class join_group_by_clause_return extends TreeRuleReturnScope {
        public int exprCount;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "join_group_by_clause"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:407:1: join_group_by_clause returns [int exprCount] : ^( BY ( join_group_by_expr )+ ) ;
    public final AstValidator.join_group_by_clause_return join_group_by_clause() throws RecognitionException {
        AstValidator.join_group_by_clause_return retval = new AstValidator.join_group_by_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BY242=null;
        AstValidator.join_group_by_expr_return join_group_by_expr243 =null;


        CommonTree BY242_tree=null;


            retval.exprCount = 0;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:411:2: ( ^( BY ( join_group_by_expr )+ ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:411:4: ^( BY ( join_group_by_expr )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BY242=(CommonTree)match(input,BY,FOLLOW_BY_in_join_group_by_clause2088); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BY242_tree = (CommonTree)adaptor.dupNode(BY242);


            root_1 = (CommonTree)adaptor.becomeRoot(BY242_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:411:10: ( join_group_by_expr )+
            int cnt72=0;
            loop72:
            do {
                int alt72=2;
                int LA72_0 = input.LA(1);

                if ( (LA72_0==DIV||LA72_0==DOLLARVAR||LA72_0==DOUBLENUMBER||LA72_0==FALSE||LA72_0==FLOATNUMBER||LA72_0==GROUP||LA72_0==INTEGER||LA72_0==LONGINTEGER||LA72_0==MINUS||LA72_0==PERCENT||LA72_0==PLUS||LA72_0==QUOTEDSTRING||LA72_0==STAR||LA72_0==TRUE||(LA72_0 >= BAG_VAL && LA72_0 <= BIN_EXPR)||(LA72_0 >= CAST_EXPR && LA72_0 <= EXPR_IN_PAREN)||LA72_0==FUNC_EVAL||LA72_0==IDENTIFIER||(LA72_0 >= MAP_VAL && LA72_0 <= NEG)||LA72_0==NULL||LA72_0==TUPLE_VAL) ) {
                    alt72=1;
                }


                switch (alt72) {
            	case 1 :
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:411:12: join_group_by_expr
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_join_group_by_expr_in_join_group_by_clause2092);
            	    join_group_by_expr243=join_group_by_expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, join_group_by_expr243.getTree());


            	    if ( state.backtracking==0 ) { retval.exprCount++; }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt72 >= 1 ) break loop72;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(72, input);
                        throw eee;
                }
                cnt72++;
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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:414:1: join_group_by_expr : ( col_range | expr | STAR );
    public final AstValidator.join_group_by_expr_return join_group_by_expr() throws RecognitionException {
        AstValidator.join_group_by_expr_return retval = new AstValidator.join_group_by_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR246=null;
        AstValidator.col_range_return col_range244 =null;

        AstValidator.expr_return expr245 =null;


        CommonTree STAR246_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:414:20: ( col_range | expr | STAR )
            int alt73=3;
            switch ( input.LA(1) ) {
            case COL_RANGE:
                {
                alt73=1;
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
                alt73=2;
                }
                break;
            case STAR:
                {
                int LA73_3 = input.LA(2);

                if ( (LA73_3==DOWN) ) {
                    alt73=2;
                }
                else if ( (LA73_3==EOF||LA73_3==UP||LA73_3==DIV||LA73_3==DOLLARVAR||LA73_3==DOUBLENUMBER||LA73_3==FALSE||LA73_3==FLOATNUMBER||LA73_3==GROUP||LA73_3==INTEGER||LA73_3==LONGINTEGER||LA73_3==MINUS||LA73_3==PERCENT||LA73_3==PLUS||LA73_3==QUOTEDSTRING||LA73_3==STAR||LA73_3==TRUE||(LA73_3 >= BAG_VAL && LA73_3 <= BIN_EXPR)||(LA73_3 >= CAST_EXPR && LA73_3 <= EXPR_IN_PAREN)||LA73_3==FUNC_EVAL||LA73_3==IDENTIFIER||(LA73_3 >= MAP_VAL && LA73_3 <= NEG)||LA73_3==NULL||LA73_3==TUPLE_VAL) ) {
                    alt73=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 73, 3, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 73, 0, input);

                throw nvae;

            }

            switch (alt73) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:414:22: col_range
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_join_group_by_expr2108);
                    col_range244=col_range();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range244.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:414:35: expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_join_group_by_expr2113);
                    expr245=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expr245.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:414:42: STAR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR246=(CommonTree)match(input,STAR,FOLLOW_STAR_in_join_group_by_expr2117); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR246_tree = (CommonTree)adaptor.dupNode(STAR246);


                    adaptor.addChild(root_0, STAR246_tree);
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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:417:1: union_clause : ^( UNION ( ONSCHEMA )? rel_list ) ;
    public final AstValidator.union_clause_return union_clause() throws RecognitionException {
        AstValidator.union_clause_return retval = new AstValidator.union_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree UNION247=null;
        CommonTree ONSCHEMA248=null;
        AstValidator.rel_list_return rel_list249 =null;


        CommonTree UNION247_tree=null;
        CommonTree ONSCHEMA248_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:417:14: ( ^( UNION ( ONSCHEMA )? rel_list ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:417:16: ^( UNION ( ONSCHEMA )? rel_list )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            UNION247=(CommonTree)match(input,UNION,FOLLOW_UNION_in_union_clause2128); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            UNION247_tree = (CommonTree)adaptor.dupNode(UNION247);


            root_1 = (CommonTree)adaptor.becomeRoot(UNION247_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:417:25: ( ONSCHEMA )?
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==ONSCHEMA) ) {
                alt74=1;
            }
            switch (alt74) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:417:25: ONSCHEMA
                    {
                    _last = (CommonTree)input.LT(1);
                    ONSCHEMA248=(CommonTree)match(input,ONSCHEMA,FOLLOW_ONSCHEMA_in_union_clause2130); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ONSCHEMA248_tree = (CommonTree)adaptor.dupNode(ONSCHEMA248);


                    adaptor.addChild(root_1, ONSCHEMA248_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_list_in_union_clause2133);
            rel_list249=rel_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel_list249.getTree());


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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:420:1: foreach_clause : ^( FOREACH rel foreach_plan ) ;
    public final AstValidator.foreach_clause_return foreach_clause() throws RecognitionException {
        AstValidator.foreach_clause_return retval = new AstValidator.foreach_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FOREACH250=null;
        AstValidator.rel_return rel251 =null;

        AstValidator.foreach_plan_return foreach_plan252 =null;


        CommonTree FOREACH250_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:420:16: ( ^( FOREACH rel foreach_plan ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:420:18: ^( FOREACH rel foreach_plan )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FOREACH250=(CommonTree)match(input,FOREACH,FOLLOW_FOREACH_in_foreach_clause2146); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FOREACH250_tree = (CommonTree)adaptor.dupNode(FOREACH250);


            root_1 = (CommonTree)adaptor.becomeRoot(FOREACH250_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_foreach_clause2148);
            rel251=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel251.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_foreach_plan_in_foreach_clause2150);
            foreach_plan252=foreach_plan();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, foreach_plan252.getTree());


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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:423:1: foreach_plan : ( ^( FOREACH_PLAN_SIMPLE generate_clause ) | ^( FOREACH_PLAN_COMPLEX nested_blk ) );
    public final AstValidator.foreach_plan_return foreach_plan() throws RecognitionException {
        AstValidator.foreach_plan_return retval = new AstValidator.foreach_plan_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FOREACH_PLAN_SIMPLE253=null;
        CommonTree FOREACH_PLAN_COMPLEX255=null;
        AstValidator.generate_clause_return generate_clause254 =null;

        AstValidator.nested_blk_return nested_blk256 =null;


        CommonTree FOREACH_PLAN_SIMPLE253_tree=null;
        CommonTree FOREACH_PLAN_COMPLEX255_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:423:14: ( ^( FOREACH_PLAN_SIMPLE generate_clause ) | ^( FOREACH_PLAN_COMPLEX nested_blk ) )
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==FOREACH_PLAN_SIMPLE) ) {
                alt75=1;
            }
            else if ( (LA75_0==FOREACH_PLAN_COMPLEX) ) {
                alt75=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 75, 0, input);

                throw nvae;

            }
            switch (alt75) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:423:16: ^( FOREACH_PLAN_SIMPLE generate_clause )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FOREACH_PLAN_SIMPLE253=(CommonTree)match(input,FOREACH_PLAN_SIMPLE,FOLLOW_FOREACH_PLAN_SIMPLE_in_foreach_plan2163); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FOREACH_PLAN_SIMPLE253_tree = (CommonTree)adaptor.dupNode(FOREACH_PLAN_SIMPLE253);


                    root_1 = (CommonTree)adaptor.becomeRoot(FOREACH_PLAN_SIMPLE253_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_generate_clause_in_foreach_plan2165);
                    generate_clause254=generate_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, generate_clause254.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:424:16: ^( FOREACH_PLAN_COMPLEX nested_blk )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FOREACH_PLAN_COMPLEX255=(CommonTree)match(input,FOREACH_PLAN_COMPLEX,FOLLOW_FOREACH_PLAN_COMPLEX_in_foreach_plan2186); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FOREACH_PLAN_COMPLEX255_tree = (CommonTree)adaptor.dupNode(FOREACH_PLAN_COMPLEX255);


                    root_1 = (CommonTree)adaptor.becomeRoot(FOREACH_PLAN_COMPLEX255_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_blk_in_foreach_plan2188);
                    nested_blk256=nested_blk();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, nested_blk256.getTree());


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


    protected static class nested_blk_scope {
        Set<String> ids;
    }
    protected Stack nested_blk_stack = new Stack();


    public static class nested_blk_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_blk"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:427:1: nested_blk : ( nested_command )* generate_clause ;
    public final AstValidator.nested_blk_return nested_blk() throws RecognitionException {
        nested_blk_stack.push(new nested_blk_scope());
        AstValidator.nested_blk_return retval = new AstValidator.nested_blk_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.nested_command_return nested_command257 =null;

        AstValidator.generate_clause_return generate_clause258 =null;



         ((nested_blk_scope)nested_blk_stack.peek()).ids = new HashSet<String>(); 
        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:430:2: ( ( nested_command )* generate_clause )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:430:4: ( nested_command )* generate_clause
            {
            root_0 = (CommonTree)adaptor.nil();


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:430:4: ( nested_command )*
            loop76:
            do {
                int alt76=2;
                int LA76_0 = input.LA(1);

                if ( ((LA76_0 >= NESTED_CMD && LA76_0 <= NESTED_CMD_ASSI)) ) {
                    alt76=1;
                }


                switch (alt76) {
            	case 1 :
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:430:4: nested_command
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_nested_command_in_nested_blk2208);
            	    nested_command257=nested_command();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, nested_command257.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop76;
                }
            } while (true);


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_generate_clause_in_nested_blk2211);
            generate_clause258=generate_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, generate_clause258.getTree());


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
            nested_blk_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "nested_blk"


    public static class generate_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "generate_clause"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:433:1: generate_clause : ^( GENERATE ( flatten_generated_item )+ ) ;
    public final AstValidator.generate_clause_return generate_clause() throws RecognitionException {
        AstValidator.generate_clause_return retval = new AstValidator.generate_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree GENERATE259=null;
        AstValidator.flatten_generated_item_return flatten_generated_item260 =null;


        CommonTree GENERATE259_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:433:17: ( ^( GENERATE ( flatten_generated_item )+ ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:433:19: ^( GENERATE ( flatten_generated_item )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            GENERATE259=(CommonTree)match(input,GENERATE,FOLLOW_GENERATE_in_generate_clause2222); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            GENERATE259_tree = (CommonTree)adaptor.dupNode(GENERATE259);


            root_1 = (CommonTree)adaptor.becomeRoot(GENERATE259_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:433:31: ( flatten_generated_item )+
            int cnt77=0;
            loop77:
            do {
                int alt77=2;
                int LA77_0 = input.LA(1);

                if ( (LA77_0==DIV||LA77_0==DOLLARVAR||LA77_0==DOUBLENUMBER||LA77_0==FALSE||LA77_0==FLATTEN||LA77_0==FLOATNUMBER||LA77_0==GROUP||LA77_0==INTEGER||LA77_0==LONGINTEGER||LA77_0==MINUS||LA77_0==PERCENT||LA77_0==PLUS||LA77_0==QUOTEDSTRING||LA77_0==STAR||LA77_0==TRUE||(LA77_0 >= BAG_VAL && LA77_0 <= BIN_EXPR)||(LA77_0 >= CAST_EXPR && LA77_0 <= EXPR_IN_PAREN)||LA77_0==FUNC_EVAL||LA77_0==IDENTIFIER||(LA77_0 >= MAP_VAL && LA77_0 <= NEG)||LA77_0==NULL||LA77_0==TUPLE_VAL) ) {
                    alt77=1;
                }


                switch (alt77) {
            	case 1 :
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:433:31: flatten_generated_item
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_flatten_generated_item_in_generate_clause2224);
            	    flatten_generated_item260=flatten_generated_item();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, flatten_generated_item260.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt77 >= 1 ) break loop77;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(77, input);
                        throw eee;
                }
                cnt77++;
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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:436:1: nested_command : ( ^( NESTED_CMD IDENTIFIER nested_op ) | ^( NESTED_CMD_ASSI IDENTIFIER expr ) );
    public final AstValidator.nested_command_return nested_command() throws RecognitionException {
        AstValidator.nested_command_return retval = new AstValidator.nested_command_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree NESTED_CMD261=null;
        CommonTree IDENTIFIER262=null;
        CommonTree NESTED_CMD_ASSI264=null;
        CommonTree IDENTIFIER265=null;
        AstValidator.nested_op_return nested_op263 =null;

        AstValidator.expr_return expr266 =null;


        CommonTree NESTED_CMD261_tree=null;
        CommonTree IDENTIFIER262_tree=null;
        CommonTree NESTED_CMD_ASSI264_tree=null;
        CommonTree IDENTIFIER265_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:437:2: ( ^( NESTED_CMD IDENTIFIER nested_op ) | ^( NESTED_CMD_ASSI IDENTIFIER expr ) )
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==NESTED_CMD) ) {
                alt78=1;
            }
            else if ( (LA78_0==NESTED_CMD_ASSI) ) {
                alt78=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 78, 0, input);

                throw nvae;

            }
            switch (alt78) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:437:4: ^( NESTED_CMD IDENTIFIER nested_op )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NESTED_CMD261=(CommonTree)match(input,NESTED_CMD,FOLLOW_NESTED_CMD_in_nested_command2239); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NESTED_CMD261_tree = (CommonTree)adaptor.dupNode(NESTED_CMD261);


                    root_1 = (CommonTree)adaptor.becomeRoot(NESTED_CMD261_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER262=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_nested_command2241); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER262_tree = (CommonTree)adaptor.dupNode(IDENTIFIER262);


                    adaptor.addChild(root_1, IDENTIFIER262_tree);
                    }


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_op_in_nested_command2243);
                    nested_op263=nested_op();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, nested_op263.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           ((nested_blk_scope)nested_blk_stack.peek()).ids.add( (IDENTIFIER262!=null?IDENTIFIER262.getText():null) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:441:4: ^( NESTED_CMD_ASSI IDENTIFIER expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NESTED_CMD_ASSI264=(CommonTree)match(input,NESTED_CMD_ASSI,FOLLOW_NESTED_CMD_ASSI_in_nested_command2257); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NESTED_CMD_ASSI264_tree = (CommonTree)adaptor.dupNode(NESTED_CMD_ASSI264);


                    root_1 = (CommonTree)adaptor.becomeRoot(NESTED_CMD_ASSI264_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER265=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_nested_command2259); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER265_tree = (CommonTree)adaptor.dupNode(IDENTIFIER265);


                    adaptor.addChild(root_1, IDENTIFIER265_tree);
                    }


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_nested_command2261);
                    expr266=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr266.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           ((nested_blk_scope)nested_blk_stack.peek()).ids.add( (IDENTIFIER265!=null?IDENTIFIER265.getText():null) );
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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:447:1: nested_op : ( nested_proj | nested_filter | nested_sort | nested_distinct | nested_limit | nested_cross | nested_foreach );
    public final AstValidator.nested_op_return nested_op() throws RecognitionException {
        AstValidator.nested_op_return retval = new AstValidator.nested_op_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.nested_proj_return nested_proj267 =null;

        AstValidator.nested_filter_return nested_filter268 =null;

        AstValidator.nested_sort_return nested_sort269 =null;

        AstValidator.nested_distinct_return nested_distinct270 =null;

        AstValidator.nested_limit_return nested_limit271 =null;

        AstValidator.nested_cross_return nested_cross272 =null;

        AstValidator.nested_foreach_return nested_foreach273 =null;



        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:447:11: ( nested_proj | nested_filter | nested_sort | nested_distinct | nested_limit | nested_cross | nested_foreach )
            int alt79=7;
            switch ( input.LA(1) ) {
            case NESTED_PROJ:
                {
                alt79=1;
                }
                break;
            case FILTER:
                {
                alt79=2;
                }
                break;
            case ORDER:
                {
                alt79=3;
                }
                break;
            case DISTINCT:
                {
                alt79=4;
                }
                break;
            case LIMIT:
                {
                alt79=5;
                }
                break;
            case CROSS:
                {
                alt79=6;
                }
                break;
            case FOREACH:
                {
                alt79=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 79, 0, input);

                throw nvae;

            }

            switch (alt79) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:447:13: nested_proj
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_proj_in_nested_op2277);
                    nested_proj267=nested_proj();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_proj267.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:448:13: nested_filter
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_filter_in_nested_op2291);
                    nested_filter268=nested_filter();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_filter268.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:449:13: nested_sort
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_sort_in_nested_op2305);
                    nested_sort269=nested_sort();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_sort269.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:450:13: nested_distinct
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_distinct_in_nested_op2319);
                    nested_distinct270=nested_distinct();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_distinct270.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:451:13: nested_limit
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_limit_in_nested_op2333);
                    nested_limit271=nested_limit();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_limit271.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:452:13: nested_cross
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_cross_in_nested_op2347);
                    nested_cross272=nested_cross();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_cross272.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:453:13: nested_foreach
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_foreach_in_nested_op2361);
                    nested_foreach273=nested_foreach();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_foreach273.getTree());


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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:456:1: nested_proj : ^( NESTED_PROJ col_ref ( col_ref )+ ) ;
    public final AstValidator.nested_proj_return nested_proj() throws RecognitionException {
        AstValidator.nested_proj_return retval = new AstValidator.nested_proj_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree NESTED_PROJ274=null;
        AstValidator.col_ref_return col_ref275 =null;

        AstValidator.col_ref_return col_ref276 =null;


        CommonTree NESTED_PROJ274_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:456:13: ( ^( NESTED_PROJ col_ref ( col_ref )+ ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:456:15: ^( NESTED_PROJ col_ref ( col_ref )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            NESTED_PROJ274=(CommonTree)match(input,NESTED_PROJ,FOLLOW_NESTED_PROJ_in_nested_proj2372); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NESTED_PROJ274_tree = (CommonTree)adaptor.dupNode(NESTED_PROJ274);


            root_1 = (CommonTree)adaptor.becomeRoot(NESTED_PROJ274_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_col_ref_in_nested_proj2374);
            col_ref275=col_ref();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, col_ref275.getTree());


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:456:38: ( col_ref )+
            int cnt80=0;
            loop80:
            do {
                int alt80=2;
                int LA80_0 = input.LA(1);

                if ( (LA80_0==DOLLARVAR||LA80_0==GROUP||LA80_0==IDENTIFIER) ) {
                    alt80=1;
                }


                switch (alt80) {
            	case 1 :
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:456:38: col_ref
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_col_ref_in_nested_proj2376);
            	    col_ref276=col_ref();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, col_ref276.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt80 >= 1 ) break loop80;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(80, input);
                        throw eee;
                }
                cnt80++;
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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:459:1: nested_filter : ^( FILTER nested_op_input cond ) ;
    public final AstValidator.nested_filter_return nested_filter() throws RecognitionException {
        AstValidator.nested_filter_return retval = new AstValidator.nested_filter_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FILTER277=null;
        AstValidator.nested_op_input_return nested_op_input278 =null;

        AstValidator.cond_return cond279 =null;


        CommonTree FILTER277_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:460:2: ( ^( FILTER nested_op_input cond ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:460:4: ^( FILTER nested_op_input cond )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FILTER277=(CommonTree)match(input,FILTER,FOLLOW_FILTER_in_nested_filter2391); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FILTER277_tree = (CommonTree)adaptor.dupNode(FILTER277);


            root_1 = (CommonTree)adaptor.becomeRoot(FILTER277_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_filter2393);
            nested_op_input278=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input278.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_nested_filter2395);
            cond279=cond();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond279.getTree());


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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:463:1: nested_sort : ^( ORDER nested_op_input order_by_clause ( func_clause )? ) ;
    public final AstValidator.nested_sort_return nested_sort() throws RecognitionException {
        AstValidator.nested_sort_return retval = new AstValidator.nested_sort_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ORDER280=null;
        AstValidator.nested_op_input_return nested_op_input281 =null;

        AstValidator.order_by_clause_return order_by_clause282 =null;

        AstValidator.func_clause_return func_clause283 =null;


        CommonTree ORDER280_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:463:13: ( ^( ORDER nested_op_input order_by_clause ( func_clause )? ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:463:15: ^( ORDER nested_op_input order_by_clause ( func_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            ORDER280=(CommonTree)match(input,ORDER,FOLLOW_ORDER_in_nested_sort2408); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ORDER280_tree = (CommonTree)adaptor.dupNode(ORDER280);


            root_1 = (CommonTree)adaptor.becomeRoot(ORDER280_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_sort2410);
            nested_op_input281=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input281.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_order_by_clause_in_nested_sort2413);
            order_by_clause282=order_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, order_by_clause282.getTree());


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:463:57: ( func_clause )?
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==FUNC||LA81_0==FUNC_REF) ) {
                alt81=1;
            }
            switch (alt81) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:463:57: func_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_nested_sort2415);
                    func_clause283=func_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause283.getTree());


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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:466:1: nested_distinct : ^( DISTINCT nested_op_input ) ;
    public final AstValidator.nested_distinct_return nested_distinct() throws RecognitionException {
        AstValidator.nested_distinct_return retval = new AstValidator.nested_distinct_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DISTINCT284=null;
        AstValidator.nested_op_input_return nested_op_input285 =null;


        CommonTree DISTINCT284_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:466:17: ( ^( DISTINCT nested_op_input ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:466:19: ^( DISTINCT nested_op_input )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            DISTINCT284=(CommonTree)match(input,DISTINCT,FOLLOW_DISTINCT_in_nested_distinct2429); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DISTINCT284_tree = (CommonTree)adaptor.dupNode(DISTINCT284);


            root_1 = (CommonTree)adaptor.becomeRoot(DISTINCT284_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_distinct2431);
            nested_op_input285=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input285.getTree());


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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:469:1: nested_limit : ^( LIMIT nested_op_input ( INTEGER | expr ) ) ;
    public final AstValidator.nested_limit_return nested_limit() throws RecognitionException {
        AstValidator.nested_limit_return retval = new AstValidator.nested_limit_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree LIMIT286=null;
        CommonTree INTEGER288=null;
        AstValidator.nested_op_input_return nested_op_input287 =null;

        AstValidator.expr_return expr289 =null;


        CommonTree LIMIT286_tree=null;
        CommonTree INTEGER288_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:469:14: ( ^( LIMIT nested_op_input ( INTEGER | expr ) ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:469:16: ^( LIMIT nested_op_input ( INTEGER | expr ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            LIMIT286=(CommonTree)match(input,LIMIT,FOLLOW_LIMIT_in_nested_limit2444); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LIMIT286_tree = (CommonTree)adaptor.dupNode(LIMIT286);


            root_1 = (CommonTree)adaptor.becomeRoot(LIMIT286_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_limit2446);
            nested_op_input287=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input287.getTree());


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:469:41: ( INTEGER | expr )
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==INTEGER) ) {
                int LA82_1 = input.LA(2);

                if ( (synpred149_AstValidator()) ) {
                    alt82=1;
                }
                else if ( (true) ) {
                    alt82=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 82, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA82_0==DIV||LA82_0==DOLLARVAR||LA82_0==DOUBLENUMBER||LA82_0==FALSE||LA82_0==FLOATNUMBER||LA82_0==GROUP||LA82_0==LONGINTEGER||LA82_0==MINUS||LA82_0==PERCENT||LA82_0==PLUS||LA82_0==QUOTEDSTRING||LA82_0==STAR||LA82_0==TRUE||(LA82_0 >= BAG_VAL && LA82_0 <= BIN_EXPR)||LA82_0==CAST_EXPR||LA82_0==EXPR_IN_PAREN||LA82_0==FUNC_EVAL||LA82_0==IDENTIFIER||(LA82_0 >= MAP_VAL && LA82_0 <= NEG)||LA82_0==NULL||LA82_0==TUPLE_VAL) ) {
                alt82=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 82, 0, input);

                throw nvae;

            }
            switch (alt82) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:469:43: INTEGER
                    {
                    _last = (CommonTree)input.LT(1);
                    INTEGER288=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_nested_limit2450); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INTEGER288_tree = (CommonTree)adaptor.dupNode(INTEGER288);


                    adaptor.addChild(root_1, INTEGER288_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:469:53: expr
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_nested_limit2454);
                    expr289=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr289.getTree());


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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:472:1: nested_cross : ^( CROSS nested_op_input_list ) ;
    public final AstValidator.nested_cross_return nested_cross() throws RecognitionException {
        AstValidator.nested_cross_return retval = new AstValidator.nested_cross_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CROSS290=null;
        AstValidator.nested_op_input_list_return nested_op_input_list291 =null;


        CommonTree CROSS290_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:472:14: ( ^( CROSS nested_op_input_list ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:472:16: ^( CROSS nested_op_input_list )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CROSS290=(CommonTree)match(input,CROSS,FOLLOW_CROSS_in_nested_cross2469); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CROSS290_tree = (CommonTree)adaptor.dupNode(CROSS290);


            root_1 = (CommonTree)adaptor.becomeRoot(CROSS290_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_list_in_nested_cross2471);
            nested_op_input_list291=nested_op_input_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input_list291.getTree());


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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:475:1: nested_foreach : ^( FOREACH nested_op_input generate_clause ) ;
    public final AstValidator.nested_foreach_return nested_foreach() throws RecognitionException {
        AstValidator.nested_foreach_return retval = new AstValidator.nested_foreach_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FOREACH292=null;
        AstValidator.nested_op_input_return nested_op_input293 =null;

        AstValidator.generate_clause_return generate_clause294 =null;


        CommonTree FOREACH292_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:475:16: ( ^( FOREACH nested_op_input generate_clause ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:475:18: ^( FOREACH nested_op_input generate_clause )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FOREACH292=(CommonTree)match(input,FOREACH,FOLLOW_FOREACH_in_nested_foreach2484); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FOREACH292_tree = (CommonTree)adaptor.dupNode(FOREACH292);


            root_1 = (CommonTree)adaptor.becomeRoot(FOREACH292_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_foreach2486);
            nested_op_input293=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input293.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_generate_clause_in_nested_foreach2488);
            generate_clause294=generate_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, generate_clause294.getTree());


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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:478:1: nested_op_input : ( col_ref | nested_proj );
    public final AstValidator.nested_op_input_return nested_op_input() throws RecognitionException {
        AstValidator.nested_op_input_return retval = new AstValidator.nested_op_input_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.col_ref_return col_ref295 =null;

        AstValidator.nested_proj_return nested_proj296 =null;



        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:478:17: ( col_ref | nested_proj )
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:478:19: col_ref
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_nested_op_input2499);
                    col_ref295=col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_ref295.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:478:29: nested_proj
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_proj_in_nested_op_input2503);
                    nested_proj296=nested_proj();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_proj296.getTree());


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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:481:1: nested_op_input_list : ( nested_op_input )+ ;
    public final AstValidator.nested_op_input_list_return nested_op_input_list() throws RecognitionException {
        AstValidator.nested_op_input_list_return retval = new AstValidator.nested_op_input_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.nested_op_input_return nested_op_input297 =null;



        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:481:22: ( ( nested_op_input )+ )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:481:24: ( nested_op_input )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:481:24: ( nested_op_input )+
            int cnt84=0;
            loop84:
            do {
                int alt84=2;
                int LA84_0 = input.LA(1);

                if ( (LA84_0==DOLLARVAR||LA84_0==GROUP||LA84_0==IDENTIFIER||LA84_0==NESTED_PROJ) ) {
                    alt84=1;
                }


                switch (alt84) {
            	case 1 :
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:481:24: nested_op_input
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_nested_op_input_in_nested_op_input_list2512);
            	    nested_op_input297=nested_op_input();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, nested_op_input297.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt84 >= 1 ) break loop84;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(84, input);
                        throw eee;
                }
                cnt84++;
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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:484:1: stream_clause : ^( STREAM rel ( EXECCOMMAND | IDENTIFIER ) ( as_clause )? ) ;
    public final AstValidator.stream_clause_return stream_clause() throws RecognitionException {
        AstValidator.stream_clause_return retval = new AstValidator.stream_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STREAM298=null;
        CommonTree set300=null;
        AstValidator.rel_return rel299 =null;

        AstValidator.as_clause_return as_clause301 =null;


        CommonTree STREAM298_tree=null;
        CommonTree set300_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:484:15: ( ^( STREAM rel ( EXECCOMMAND | IDENTIFIER ) ( as_clause )? ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:484:17: ^( STREAM rel ( EXECCOMMAND | IDENTIFIER ) ( as_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            STREAM298=(CommonTree)match(input,STREAM,FOLLOW_STREAM_in_stream_clause2524); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STREAM298_tree = (CommonTree)adaptor.dupNode(STREAM298);


            root_1 = (CommonTree)adaptor.becomeRoot(STREAM298_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_stream_clause2526);
            rel299=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel299.getTree());


            _last = (CommonTree)input.LT(1);
            set300=(CommonTree)input.LT(1);

            if ( input.LA(1)==EXECCOMMAND||input.LA(1)==IDENTIFIER ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set300_tree = (CommonTree)adaptor.dupNode(set300);


                adaptor.addChild(root_1, set300_tree);
                }

                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:484:60: ( as_clause )?
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==AS) ) {
                alt85=1;
            }
            switch (alt85) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:484:60: as_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_as_clause_in_stream_clause2538);
                    as_clause301=as_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, as_clause301.getTree());


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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:487:1: mr_clause : ^( MAPREDUCE QUOTEDSTRING ( path_list )? store_clause load_clause ( EXECCOMMAND )? ) ;
    public final AstValidator.mr_clause_return mr_clause() throws RecognitionException {
        AstValidator.mr_clause_return retval = new AstValidator.mr_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MAPREDUCE302=null;
        CommonTree QUOTEDSTRING303=null;
        CommonTree EXECCOMMAND307=null;
        AstValidator.path_list_return path_list304 =null;

        AstValidator.store_clause_return store_clause305 =null;

        AstValidator.load_clause_return load_clause306 =null;


        CommonTree MAPREDUCE302_tree=null;
        CommonTree QUOTEDSTRING303_tree=null;
        CommonTree EXECCOMMAND307_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:487:11: ( ^( MAPREDUCE QUOTEDSTRING ( path_list )? store_clause load_clause ( EXECCOMMAND )? ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:487:13: ^( MAPREDUCE QUOTEDSTRING ( path_list )? store_clause load_clause ( EXECCOMMAND )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            MAPREDUCE302=(CommonTree)match(input,MAPREDUCE,FOLLOW_MAPREDUCE_in_mr_clause2552); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            MAPREDUCE302_tree = (CommonTree)adaptor.dupNode(MAPREDUCE302);


            root_1 = (CommonTree)adaptor.becomeRoot(MAPREDUCE302_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING303=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_mr_clause2554); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING303_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING303);


            adaptor.addChild(root_1, QUOTEDSTRING303_tree);
            }


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:487:39: ( path_list )?
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==QUOTEDSTRING) ) {
                alt86=1;
            }
            switch (alt86) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:487:39: path_list
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_path_list_in_mr_clause2556);
                    path_list304=path_list();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, path_list304.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_store_clause_in_mr_clause2559);
            store_clause305=store_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, store_clause305.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_load_clause_in_mr_clause2561);
            load_clause306=load_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, load_clause306.getTree());


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:487:75: ( EXECCOMMAND )?
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==EXECCOMMAND) ) {
                alt87=1;
            }
            switch (alt87) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:487:75: EXECCOMMAND
                    {
                    _last = (CommonTree)input.LT(1);
                    EXECCOMMAND307=(CommonTree)match(input,EXECCOMMAND,FOLLOW_EXECCOMMAND_in_mr_clause2563); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EXECCOMMAND307_tree = (CommonTree)adaptor.dupNode(EXECCOMMAND307);


                    adaptor.addChild(root_1, EXECCOMMAND307_tree);
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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:490:1: split_clause : ^( SPLIT rel ( split_branch )+ ( split_otherwise )? ) ;
    public final AstValidator.split_clause_return split_clause() throws RecognitionException {
        AstValidator.split_clause_return retval = new AstValidator.split_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SPLIT308=null;
        AstValidator.rel_return rel309 =null;

        AstValidator.split_branch_return split_branch310 =null;

        AstValidator.split_otherwise_return split_otherwise311 =null;


        CommonTree SPLIT308_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:490:14: ( ^( SPLIT rel ( split_branch )+ ( split_otherwise )? ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:490:16: ^( SPLIT rel ( split_branch )+ ( split_otherwise )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            SPLIT308=(CommonTree)match(input,SPLIT,FOLLOW_SPLIT_in_split_clause2577); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SPLIT308_tree = (CommonTree)adaptor.dupNode(SPLIT308);


            root_1 = (CommonTree)adaptor.becomeRoot(SPLIT308_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_split_clause2579);
            rel309=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel309.getTree());


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:490:29: ( split_branch )+
            int cnt88=0;
            loop88:
            do {
                int alt88=2;
                int LA88_0 = input.LA(1);

                if ( (LA88_0==SPLIT_BRANCH) ) {
                    alt88=1;
                }


                switch (alt88) {
            	case 1 :
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:490:29: split_branch
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_split_branch_in_split_clause2581);
            	    split_branch310=split_branch();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, split_branch310.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt88 >= 1 ) break loop88;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(88, input);
                        throw eee;
                }
                cnt88++;
            } while (true);


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:490:43: ( split_otherwise )?
            int alt89=2;
            int LA89_0 = input.LA(1);

            if ( (LA89_0==OTHERWISE) ) {
                alt89=1;
            }
            switch (alt89) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:490:43: split_otherwise
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_split_otherwise_in_split_clause2584);
                    split_otherwise311=split_otherwise();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, split_otherwise311.getTree());


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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:493:1: split_branch : ^( SPLIT_BRANCH alias cond ) ;
    public final AstValidator.split_branch_return split_branch() throws RecognitionException {
        AstValidator.split_branch_return retval = new AstValidator.split_branch_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SPLIT_BRANCH312=null;
        AstValidator.alias_return alias313 =null;

        AstValidator.cond_return cond314 =null;


        CommonTree SPLIT_BRANCH312_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:494:2: ( ^( SPLIT_BRANCH alias cond ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:494:4: ^( SPLIT_BRANCH alias cond )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            SPLIT_BRANCH312=(CommonTree)match(input,SPLIT_BRANCH,FOLLOW_SPLIT_BRANCH_in_split_branch2599); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SPLIT_BRANCH312_tree = (CommonTree)adaptor.dupNode(SPLIT_BRANCH312);


            root_1 = (CommonTree)adaptor.becomeRoot(SPLIT_BRANCH312_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_alias_in_split_branch2601);
            alias313=alias();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, alias313.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_split_branch2603);
            cond314=cond();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond314.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   aliases.add( (alias313!=null?alias313.name:null) );
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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:500:1: split_otherwise : ^( OTHERWISE alias ) ;
    public final AstValidator.split_otherwise_return split_otherwise() throws RecognitionException {
        AstValidator.split_otherwise_return retval = new AstValidator.split_otherwise_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree OTHERWISE315=null;
        AstValidator.alias_return alias316 =null;


        CommonTree OTHERWISE315_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:500:18: ( ^( OTHERWISE alias ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:500:20: ^( OTHERWISE alias )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            OTHERWISE315=(CommonTree)match(input,OTHERWISE,FOLLOW_OTHERWISE_in_split_otherwise2622); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            OTHERWISE315_tree = (CommonTree)adaptor.dupNode(OTHERWISE315);


            root_1 = (CommonTree)adaptor.becomeRoot(OTHERWISE315_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_alias_in_split_otherwise2624);
            alias316=alias();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, alias316.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   aliases.add( (alias316!=null?alias316.name:null) );
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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:506:1: col_ref : ( alias_col_ref | dollar_col_ref );
    public final AstValidator.col_ref_return col_ref() throws RecognitionException {
        AstValidator.col_ref_return retval = new AstValidator.col_ref_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.alias_col_ref_return alias_col_ref317 =null;

        AstValidator.dollar_col_ref_return dollar_col_ref318 =null;



        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:506:9: ( alias_col_ref | dollar_col_ref )
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==GROUP||LA90_0==IDENTIFIER) ) {
                alt90=1;
            }
            else if ( (LA90_0==DOLLARVAR) ) {
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:506:11: alias_col_ref
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_alias_col_ref_in_col_ref2640);
                    alias_col_ref317=alias_col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, alias_col_ref317.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:506:27: dollar_col_ref
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_dollar_col_ref_in_col_ref2644);
                    dollar_col_ref318=dollar_col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, dollar_col_ref318.getTree());


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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:509:1: alias_col_ref : ( GROUP | IDENTIFIER );
    public final AstValidator.alias_col_ref_return alias_col_ref() throws RecognitionException {
        AstValidator.alias_col_ref_return retval = new AstValidator.alias_col_ref_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set319=null;

        CommonTree set319_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:509:15: ( GROUP | IDENTIFIER )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set319=(CommonTree)input.LT(1);

            if ( input.LA(1)==GROUP||input.LA(1)==IDENTIFIER ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set319_tree = (CommonTree)adaptor.dupNode(set319);


                adaptor.addChild(root_0, set319_tree);
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
    // $ANTLR end "alias_col_ref"


    public static class dollar_col_ref_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "dollar_col_ref"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:512:1: dollar_col_ref : DOLLARVAR ;
    public final AstValidator.dollar_col_ref_return dollar_col_ref() throws RecognitionException {
        AstValidator.dollar_col_ref_return retval = new AstValidator.dollar_col_ref_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DOLLARVAR320=null;

        CommonTree DOLLARVAR320_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:512:16: ( DOLLARVAR )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:512:18: DOLLARVAR
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            DOLLARVAR320=(CommonTree)match(input,DOLLARVAR,FOLLOW_DOLLARVAR_in_dollar_col_ref2666); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DOLLARVAR320_tree = (CommonTree)adaptor.dupNode(DOLLARVAR320);


            adaptor.addChild(root_0, DOLLARVAR320_tree);
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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:515:1: const_expr : literal ;
    public final AstValidator.const_expr_return const_expr() throws RecognitionException {
        AstValidator.const_expr_return retval = new AstValidator.const_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.literal_return literal321 =null;



        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:515:12: ( literal )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:515:14: literal
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_literal_in_const_expr2675);
            literal321=literal();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, literal321.getTree());


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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:518:1: literal : ( scalar | map | bag | tuple );
    public final AstValidator.literal_return literal() throws RecognitionException {
        AstValidator.literal_return retval = new AstValidator.literal_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.scalar_return scalar322 =null;

        AstValidator.map_return map323 =null;

        AstValidator.bag_return bag324 =null;

        AstValidator.tuple_return tuple325 =null;



        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:518:9: ( scalar | map | bag | tuple )
            int alt91=4;
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:518:11: scalar
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_scalar_in_literal2684);
                    scalar322=scalar();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, scalar322.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:518:20: map
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_map_in_literal2688);
                    map323=map();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, map323.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:518:26: bag
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_bag_in_literal2692);
                    bag324=bag();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, bag324.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:518:32: tuple
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_tuple_in_literal2696);
                    tuple325=tuple();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, tuple325.getTree());


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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:521:1: scalar : ( num_scalar | QUOTEDSTRING | NULL | TRUE | FALSE );
    public final AstValidator.scalar_return scalar() throws RecognitionException {
        AstValidator.scalar_return retval = new AstValidator.scalar_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING327=null;
        CommonTree NULL328=null;
        CommonTree TRUE329=null;
        CommonTree FALSE330=null;
        AstValidator.num_scalar_return num_scalar326 =null;


        CommonTree QUOTEDSTRING327_tree=null;
        CommonTree NULL328_tree=null;
        CommonTree TRUE329_tree=null;
        CommonTree FALSE330_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:521:8: ( num_scalar | QUOTEDSTRING | NULL | TRUE | FALSE )
            int alt92=5;
            switch ( input.LA(1) ) {
            case DOUBLENUMBER:
            case FLOATNUMBER:
            case INTEGER:
            case LONGINTEGER:
            case MINUS:
                {
                alt92=1;
                }
                break;
            case QUOTEDSTRING:
                {
                alt92=2;
                }
                break;
            case NULL:
                {
                alt92=3;
                }
                break;
            case TRUE:
                {
                alt92=4;
                }
                break;
            case FALSE:
                {
                alt92=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 92, 0, input);

                throw nvae;

            }

            switch (alt92) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:521:10: num_scalar
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_num_scalar_in_scalar2705);
                    num_scalar326=num_scalar();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, num_scalar326.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:521:23: QUOTEDSTRING
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    QUOTEDSTRING327=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_scalar2709); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    QUOTEDSTRING327_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING327);


                    adaptor.addChild(root_0, QUOTEDSTRING327_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:521:38: NULL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    NULL328=(CommonTree)match(input,NULL,FOLLOW_NULL_in_scalar2713); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NULL328_tree = (CommonTree)adaptor.dupNode(NULL328);


                    adaptor.addChild(root_0, NULL328_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:521:45: TRUE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TRUE329=(CommonTree)match(input,TRUE,FOLLOW_TRUE_in_scalar2717); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TRUE329_tree = (CommonTree)adaptor.dupNode(TRUE329);


                    adaptor.addChild(root_0, TRUE329_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:521:52: FALSE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FALSE330=(CommonTree)match(input,FALSE,FOLLOW_FALSE_in_scalar2721); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FALSE330_tree = (CommonTree)adaptor.dupNode(FALSE330);


                    adaptor.addChild(root_0, FALSE330_tree);
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
    // $ANTLR end "scalar"


    public static class num_scalar_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "num_scalar"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:524:1: num_scalar : ( MINUS )? ( INTEGER | LONGINTEGER | FLOATNUMBER | DOUBLENUMBER ) ;
    public final AstValidator.num_scalar_return num_scalar() throws RecognitionException {
        AstValidator.num_scalar_return retval = new AstValidator.num_scalar_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MINUS331=null;
        CommonTree set332=null;

        CommonTree MINUS331_tree=null;
        CommonTree set332_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:524:12: ( ( MINUS )? ( INTEGER | LONGINTEGER | FLOATNUMBER | DOUBLENUMBER ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:524:14: ( MINUS )? ( INTEGER | LONGINTEGER | FLOATNUMBER | DOUBLENUMBER )
            {
            root_0 = (CommonTree)adaptor.nil();


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:524:14: ( MINUS )?
            int alt93=2;
            int LA93_0 = input.LA(1);

            if ( (LA93_0==MINUS) ) {
                alt93=1;
            }
            switch (alt93) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:524:14: MINUS
                    {
                    _last = (CommonTree)input.LT(1);
                    MINUS331=(CommonTree)match(input,MINUS,FOLLOW_MINUS_in_num_scalar2730); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MINUS331_tree = (CommonTree)adaptor.dupNode(MINUS331);


                    adaptor.addChild(root_0, MINUS331_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            set332=(CommonTree)input.LT(1);

            if ( input.LA(1)==DOUBLENUMBER||input.LA(1)==FLOATNUMBER||input.LA(1)==INTEGER||input.LA(1)==LONGINTEGER ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set332_tree = (CommonTree)adaptor.dupNode(set332);


                adaptor.addChild(root_0, set332_tree);
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
    // $ANTLR end "num_scalar"


    public static class map_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "map"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:527:1: map : ^( MAP_VAL ( keyvalue )* ) ;
    public final AstValidator.map_return map() throws RecognitionException {
        AstValidator.map_return retval = new AstValidator.map_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MAP_VAL333=null;
        AstValidator.keyvalue_return keyvalue334 =null;


        CommonTree MAP_VAL333_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:527:5: ( ^( MAP_VAL ( keyvalue )* ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:527:7: ^( MAP_VAL ( keyvalue )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            MAP_VAL333=(CommonTree)match(input,MAP_VAL,FOLLOW_MAP_VAL_in_map2760); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            MAP_VAL333_tree = (CommonTree)adaptor.dupNode(MAP_VAL333);


            root_1 = (CommonTree)adaptor.becomeRoot(MAP_VAL333_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:527:18: ( keyvalue )*
                loop94:
                do {
                    int alt94=2;
                    int LA94_0 = input.LA(1);

                    if ( (LA94_0==KEY_VAL_PAIR) ) {
                        alt94=1;
                    }


                    switch (alt94) {
                	case 1 :
                	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:527:18: keyvalue
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_keyvalue_in_map2762);
                	    keyvalue334=keyvalue();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, keyvalue334.getTree());


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
    // $ANTLR end "map"


    public static class keyvalue_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "keyvalue"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:530:1: keyvalue : ^( KEY_VAL_PAIR map_key const_expr ) ;
    public final AstValidator.keyvalue_return keyvalue() throws RecognitionException {
        AstValidator.keyvalue_return retval = new AstValidator.keyvalue_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree KEY_VAL_PAIR335=null;
        AstValidator.map_key_return map_key336 =null;

        AstValidator.const_expr_return const_expr337 =null;


        CommonTree KEY_VAL_PAIR335_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:530:10: ( ^( KEY_VAL_PAIR map_key const_expr ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:530:12: ^( KEY_VAL_PAIR map_key const_expr )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            KEY_VAL_PAIR335=(CommonTree)match(input,KEY_VAL_PAIR,FOLLOW_KEY_VAL_PAIR_in_keyvalue2776); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            KEY_VAL_PAIR335_tree = (CommonTree)adaptor.dupNode(KEY_VAL_PAIR335);


            root_1 = (CommonTree)adaptor.becomeRoot(KEY_VAL_PAIR335_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_map_key_in_keyvalue2778);
            map_key336=map_key();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, map_key336.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_const_expr_in_keyvalue2780);
            const_expr337=const_expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, const_expr337.getTree());


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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:533:1: map_key : QUOTEDSTRING ;
    public final AstValidator.map_key_return map_key() throws RecognitionException {
        AstValidator.map_key_return retval = new AstValidator.map_key_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING338=null;

        CommonTree QUOTEDSTRING338_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:533:9: ( QUOTEDSTRING )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:533:11: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING338=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_map_key2791); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING338_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING338);


            adaptor.addChild(root_0, QUOTEDSTRING338_tree);
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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:536:1: bag : ^( BAG_VAL ( tuple )* ) ;
    public final AstValidator.bag_return bag() throws RecognitionException {
        AstValidator.bag_return retval = new AstValidator.bag_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BAG_VAL339=null;
        AstValidator.tuple_return tuple340 =null;


        CommonTree BAG_VAL339_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:536:5: ( ^( BAG_VAL ( tuple )* ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:536:7: ^( BAG_VAL ( tuple )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BAG_VAL339=(CommonTree)match(input,BAG_VAL,FOLLOW_BAG_VAL_in_bag2802); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BAG_VAL339_tree = (CommonTree)adaptor.dupNode(BAG_VAL339);


            root_1 = (CommonTree)adaptor.becomeRoot(BAG_VAL339_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:536:18: ( tuple )*
                loop95:
                do {
                    int alt95=2;
                    int LA95_0 = input.LA(1);

                    if ( (LA95_0==TUPLE_VAL) ) {
                        alt95=1;
                    }


                    switch (alt95) {
                	case 1 :
                	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:536:18: tuple
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_tuple_in_bag2804);
                	    tuple340=tuple();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, tuple340.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop95;
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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:539:1: tuple : ^( TUPLE_VAL ( literal )* ) ;
    public final AstValidator.tuple_return tuple() throws RecognitionException {
        AstValidator.tuple_return retval = new AstValidator.tuple_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree TUPLE_VAL341=null;
        AstValidator.literal_return literal342 =null;


        CommonTree TUPLE_VAL341_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:539:7: ( ^( TUPLE_VAL ( literal )* ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:539:9: ^( TUPLE_VAL ( literal )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            TUPLE_VAL341=(CommonTree)match(input,TUPLE_VAL,FOLLOW_TUPLE_VAL_in_tuple2818); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            TUPLE_VAL341_tree = (CommonTree)adaptor.dupNode(TUPLE_VAL341);


            root_1 = (CommonTree)adaptor.becomeRoot(TUPLE_VAL341_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:539:22: ( literal )*
                loop96:
                do {
                    int alt96=2;
                    int LA96_0 = input.LA(1);

                    if ( (LA96_0==DOUBLENUMBER||LA96_0==FALSE||LA96_0==FLOATNUMBER||LA96_0==INTEGER||LA96_0==LONGINTEGER||LA96_0==MINUS||LA96_0==QUOTEDSTRING||LA96_0==TRUE||LA96_0==BAG_VAL||LA96_0==MAP_VAL||LA96_0==NULL||LA96_0==TUPLE_VAL) ) {
                        alt96=1;
                    }


                    switch (alt96) {
                	case 1 :
                	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:539:22: literal
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_literal_in_tuple2820);
                	    literal342=literal();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, literal342.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop96;
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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:543:1: eid : ( rel_str_op | IMPORT | RETURNS | DEFINE | LOAD | FILTER | FOREACH | MATCHES | ORDER | DISTINCT | COGROUP | JOIN | CROSS | UNION | SPLIT | INTO | IF | ALL | AS | BY | USING | INNER | OUTER | PARALLEL | PARTITION | GROUP | AND | OR | NOT | GENERATE | FLATTEN | EVAL | ASC | DESC | BOOLEAN | INT | LONG | FLOAT | DOUBLE | CHARARRAY | BYTEARRAY | BAG | TUPLE | MAP | IS | NULL | TRUE | FALSE | STREAM | THROUGH | STORE | MAPREDUCE | SHIP | CACHE | INPUT | OUTPUT | STDERROR | STDIN | STDOUT | LIMIT | SAMPLE | LEFT | RIGHT | FULL | IDENTIFIER | TOBAG | TOMAP | TOTUPLE );
    public final AstValidator.eid_return eid() throws RecognitionException {
        AstValidator.eid_return retval = new AstValidator.eid_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IMPORT344=null;
        CommonTree RETURNS345=null;
        CommonTree DEFINE346=null;
        CommonTree LOAD347=null;
        CommonTree FILTER348=null;
        CommonTree FOREACH349=null;
        CommonTree MATCHES350=null;
        CommonTree ORDER351=null;
        CommonTree DISTINCT352=null;
        CommonTree COGROUP353=null;
        CommonTree JOIN354=null;
        CommonTree CROSS355=null;
        CommonTree UNION356=null;
        CommonTree SPLIT357=null;
        CommonTree INTO358=null;
        CommonTree IF359=null;
        CommonTree ALL360=null;
        CommonTree AS361=null;
        CommonTree BY362=null;
        CommonTree USING363=null;
        CommonTree INNER364=null;
        CommonTree OUTER365=null;
        CommonTree PARALLEL366=null;
        CommonTree PARTITION367=null;
        CommonTree GROUP368=null;
        CommonTree AND369=null;
        CommonTree OR370=null;
        CommonTree NOT371=null;
        CommonTree GENERATE372=null;
        CommonTree FLATTEN373=null;
        CommonTree EVAL374=null;
        CommonTree ASC375=null;
        CommonTree DESC376=null;
        CommonTree BOOLEAN377=null;
        CommonTree INT378=null;
        CommonTree LONG379=null;
        CommonTree FLOAT380=null;
        CommonTree DOUBLE381=null;
        CommonTree CHARARRAY382=null;
        CommonTree BYTEARRAY383=null;
        CommonTree BAG384=null;
        CommonTree TUPLE385=null;
        CommonTree MAP386=null;
        CommonTree IS387=null;
        CommonTree NULL388=null;
        CommonTree TRUE389=null;
        CommonTree FALSE390=null;
        CommonTree STREAM391=null;
        CommonTree THROUGH392=null;
        CommonTree STORE393=null;
        CommonTree MAPREDUCE394=null;
        CommonTree SHIP395=null;
        CommonTree CACHE396=null;
        CommonTree INPUT397=null;
        CommonTree OUTPUT398=null;
        CommonTree STDERROR399=null;
        CommonTree STDIN400=null;
        CommonTree STDOUT401=null;
        CommonTree LIMIT402=null;
        CommonTree SAMPLE403=null;
        CommonTree LEFT404=null;
        CommonTree RIGHT405=null;
        CommonTree FULL406=null;
        CommonTree IDENTIFIER407=null;
        CommonTree TOBAG408=null;
        CommonTree TOMAP409=null;
        CommonTree TOTUPLE410=null;
        AstValidator.rel_str_op_return rel_str_op343 =null;


        CommonTree IMPORT344_tree=null;
        CommonTree RETURNS345_tree=null;
        CommonTree DEFINE346_tree=null;
        CommonTree LOAD347_tree=null;
        CommonTree FILTER348_tree=null;
        CommonTree FOREACH349_tree=null;
        CommonTree MATCHES350_tree=null;
        CommonTree ORDER351_tree=null;
        CommonTree DISTINCT352_tree=null;
        CommonTree COGROUP353_tree=null;
        CommonTree JOIN354_tree=null;
        CommonTree CROSS355_tree=null;
        CommonTree UNION356_tree=null;
        CommonTree SPLIT357_tree=null;
        CommonTree INTO358_tree=null;
        CommonTree IF359_tree=null;
        CommonTree ALL360_tree=null;
        CommonTree AS361_tree=null;
        CommonTree BY362_tree=null;
        CommonTree USING363_tree=null;
        CommonTree INNER364_tree=null;
        CommonTree OUTER365_tree=null;
        CommonTree PARALLEL366_tree=null;
        CommonTree PARTITION367_tree=null;
        CommonTree GROUP368_tree=null;
        CommonTree AND369_tree=null;
        CommonTree OR370_tree=null;
        CommonTree NOT371_tree=null;
        CommonTree GENERATE372_tree=null;
        CommonTree FLATTEN373_tree=null;
        CommonTree EVAL374_tree=null;
        CommonTree ASC375_tree=null;
        CommonTree DESC376_tree=null;
        CommonTree BOOLEAN377_tree=null;
        CommonTree INT378_tree=null;
        CommonTree LONG379_tree=null;
        CommonTree FLOAT380_tree=null;
        CommonTree DOUBLE381_tree=null;
        CommonTree CHARARRAY382_tree=null;
        CommonTree BYTEARRAY383_tree=null;
        CommonTree BAG384_tree=null;
        CommonTree TUPLE385_tree=null;
        CommonTree MAP386_tree=null;
        CommonTree IS387_tree=null;
        CommonTree NULL388_tree=null;
        CommonTree TRUE389_tree=null;
        CommonTree FALSE390_tree=null;
        CommonTree STREAM391_tree=null;
        CommonTree THROUGH392_tree=null;
        CommonTree STORE393_tree=null;
        CommonTree MAPREDUCE394_tree=null;
        CommonTree SHIP395_tree=null;
        CommonTree CACHE396_tree=null;
        CommonTree INPUT397_tree=null;
        CommonTree OUTPUT398_tree=null;
        CommonTree STDERROR399_tree=null;
        CommonTree STDIN400_tree=null;
        CommonTree STDOUT401_tree=null;
        CommonTree LIMIT402_tree=null;
        CommonTree SAMPLE403_tree=null;
        CommonTree LEFT404_tree=null;
        CommonTree RIGHT405_tree=null;
        CommonTree FULL406_tree=null;
        CommonTree IDENTIFIER407_tree=null;
        CommonTree TOBAG408_tree=null;
        CommonTree TOMAP409_tree=null;
        CommonTree TOTUPLE410_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:543:5: ( rel_str_op | IMPORT | RETURNS | DEFINE | LOAD | FILTER | FOREACH | MATCHES | ORDER | DISTINCT | COGROUP | JOIN | CROSS | UNION | SPLIT | INTO | IF | ALL | AS | BY | USING | INNER | OUTER | PARALLEL | PARTITION | GROUP | AND | OR | NOT | GENERATE | FLATTEN | EVAL | ASC | DESC | BOOLEAN | INT | LONG | FLOAT | DOUBLE | CHARARRAY | BYTEARRAY | BAG | TUPLE | MAP | IS | NULL | TRUE | FALSE | STREAM | THROUGH | STORE | MAPREDUCE | SHIP | CACHE | INPUT | OUTPUT | STDERROR | STDIN | STDOUT | LIMIT | SAMPLE | LEFT | RIGHT | FULL | IDENTIFIER | TOBAG | TOMAP | TOTUPLE )
            int alt97=68;
            switch ( input.LA(1) ) {
            case STR_OP_EQ:
            case STR_OP_GT:
            case STR_OP_GTE:
            case STR_OP_LT:
            case STR_OP_LTE:
            case STR_OP_MATCHES:
            case STR_OP_NE:
                {
                alt97=1;
                }
                break;
            case IMPORT:
                {
                alt97=2;
                }
                break;
            case RETURNS:
                {
                alt97=3;
                }
                break;
            case DEFINE:
                {
                alt97=4;
                }
                break;
            case LOAD:
                {
                alt97=5;
                }
                break;
            case FILTER:
                {
                alt97=6;
                }
                break;
            case FOREACH:
                {
                alt97=7;
                }
                break;
            case MATCHES:
                {
                alt97=8;
                }
                break;
            case ORDER:
                {
                alt97=9;
                }
                break;
            case DISTINCT:
                {
                alt97=10;
                }
                break;
            case COGROUP:
                {
                alt97=11;
                }
                break;
            case JOIN:
                {
                alt97=12;
                }
                break;
            case CROSS:
                {
                alt97=13;
                }
                break;
            case UNION:
                {
                alt97=14;
                }
                break;
            case SPLIT:
                {
                alt97=15;
                }
                break;
            case INTO:
                {
                alt97=16;
                }
                break;
            case IF:
                {
                alt97=17;
                }
                break;
            case ALL:
                {
                alt97=18;
                }
                break;
            case AS:
                {
                alt97=19;
                }
                break;
            case BY:
                {
                alt97=20;
                }
                break;
            case USING:
                {
                alt97=21;
                }
                break;
            case INNER:
                {
                alt97=22;
                }
                break;
            case OUTER:
                {
                alt97=23;
                }
                break;
            case PARALLEL:
                {
                alt97=24;
                }
                break;
            case PARTITION:
                {
                alt97=25;
                }
                break;
            case GROUP:
                {
                alt97=26;
                }
                break;
            case AND:
                {
                alt97=27;
                }
                break;
            case OR:
                {
                alt97=28;
                }
                break;
            case NOT:
                {
                alt97=29;
                }
                break;
            case GENERATE:
                {
                alt97=30;
                }
                break;
            case FLATTEN:
                {
                alt97=31;
                }
                break;
            case EVAL:
                {
                alt97=32;
                }
                break;
            case ASC:
                {
                alt97=33;
                }
                break;
            case DESC:
                {
                alt97=34;
                }
                break;
            case BOOLEAN:
                {
                alt97=35;
                }
                break;
            case INT:
                {
                alt97=36;
                }
                break;
            case LONG:
                {
                alt97=37;
                }
                break;
            case FLOAT:
                {
                alt97=38;
                }
                break;
            case DOUBLE:
                {
                alt97=39;
                }
                break;
            case CHARARRAY:
                {
                alt97=40;
                }
                break;
            case BYTEARRAY:
                {
                alt97=41;
                }
                break;
            case BAG:
                {
                alt97=42;
                }
                break;
            case TUPLE:
                {
                alt97=43;
                }
                break;
            case MAP:
                {
                alt97=44;
                }
                break;
            case IS:
                {
                alt97=45;
                }
                break;
            case NULL:
                {
                alt97=46;
                }
                break;
            case TRUE:
                {
                alt97=47;
                }
                break;
            case FALSE:
                {
                alt97=48;
                }
                break;
            case STREAM:
                {
                alt97=49;
                }
                break;
            case THROUGH:
                {
                alt97=50;
                }
                break;
            case STORE:
                {
                alt97=51;
                }
                break;
            case MAPREDUCE:
                {
                alt97=52;
                }
                break;
            case SHIP:
                {
                alt97=53;
                }
                break;
            case CACHE:
                {
                alt97=54;
                }
                break;
            case INPUT:
                {
                alt97=55;
                }
                break;
            case OUTPUT:
                {
                alt97=56;
                }
                break;
            case STDERROR:
                {
                alt97=57;
                }
                break;
            case STDIN:
                {
                alt97=58;
                }
                break;
            case STDOUT:
                {
                alt97=59;
                }
                break;
            case LIMIT:
                {
                alt97=60;
                }
                break;
            case SAMPLE:
                {
                alt97=61;
                }
                break;
            case LEFT:
                {
                alt97=62;
                }
                break;
            case RIGHT:
                {
                alt97=63;
                }
                break;
            case FULL:
                {
                alt97=64;
                }
                break;
            case IDENTIFIER:
                {
                alt97=65;
                }
                break;
            case TOBAG:
                {
                alt97=66;
                }
                break;
            case TOMAP:
                {
                alt97=67;
                }
                break;
            case TOTUPLE:
                {
                alt97=68;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 97, 0, input);

                throw nvae;

            }

            switch (alt97) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:543:7: rel_str_op
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_str_op_in_eid2833);
                    rel_str_op343=rel_str_op();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_str_op343.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:544:7: IMPORT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IMPORT344=(CommonTree)match(input,IMPORT,FOLLOW_IMPORT_in_eid2841); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IMPORT344_tree = (CommonTree)adaptor.dupNode(IMPORT344);


                    adaptor.addChild(root_0, IMPORT344_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:545:7: RETURNS
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    RETURNS345=(CommonTree)match(input,RETURNS,FOLLOW_RETURNS_in_eid2849); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RETURNS345_tree = (CommonTree)adaptor.dupNode(RETURNS345);


                    adaptor.addChild(root_0, RETURNS345_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:546:7: DEFINE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DEFINE346=(CommonTree)match(input,DEFINE,FOLLOW_DEFINE_in_eid2857); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DEFINE346_tree = (CommonTree)adaptor.dupNode(DEFINE346);


                    adaptor.addChild(root_0, DEFINE346_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:547:7: LOAD
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LOAD347=(CommonTree)match(input,LOAD,FOLLOW_LOAD_in_eid2865); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LOAD347_tree = (CommonTree)adaptor.dupNode(LOAD347);


                    adaptor.addChild(root_0, LOAD347_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:548:7: FILTER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FILTER348=(CommonTree)match(input,FILTER,FOLLOW_FILTER_in_eid2873); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FILTER348_tree = (CommonTree)adaptor.dupNode(FILTER348);


                    adaptor.addChild(root_0, FILTER348_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:549:7: FOREACH
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FOREACH349=(CommonTree)match(input,FOREACH,FOLLOW_FOREACH_in_eid2881); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FOREACH349_tree = (CommonTree)adaptor.dupNode(FOREACH349);


                    adaptor.addChild(root_0, FOREACH349_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:550:7: MATCHES
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    MATCHES350=(CommonTree)match(input,MATCHES,FOLLOW_MATCHES_in_eid2889); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MATCHES350_tree = (CommonTree)adaptor.dupNode(MATCHES350);


                    adaptor.addChild(root_0, MATCHES350_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:551:7: ORDER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ORDER351=(CommonTree)match(input,ORDER,FOLLOW_ORDER_in_eid2897); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ORDER351_tree = (CommonTree)adaptor.dupNode(ORDER351);


                    adaptor.addChild(root_0, ORDER351_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:552:7: DISTINCT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DISTINCT352=(CommonTree)match(input,DISTINCT,FOLLOW_DISTINCT_in_eid2905); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DISTINCT352_tree = (CommonTree)adaptor.dupNode(DISTINCT352);


                    adaptor.addChild(root_0, DISTINCT352_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 11 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:553:7: COGROUP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    COGROUP353=(CommonTree)match(input,COGROUP,FOLLOW_COGROUP_in_eid2913); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    COGROUP353_tree = (CommonTree)adaptor.dupNode(COGROUP353);


                    adaptor.addChild(root_0, COGROUP353_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 12 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:554:7: JOIN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    JOIN354=(CommonTree)match(input,JOIN,FOLLOW_JOIN_in_eid2921); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    JOIN354_tree = (CommonTree)adaptor.dupNode(JOIN354);


                    adaptor.addChild(root_0, JOIN354_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 13 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:555:7: CROSS
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CROSS355=(CommonTree)match(input,CROSS,FOLLOW_CROSS_in_eid2929); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CROSS355_tree = (CommonTree)adaptor.dupNode(CROSS355);


                    adaptor.addChild(root_0, CROSS355_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 14 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:556:7: UNION
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    UNION356=(CommonTree)match(input,UNION,FOLLOW_UNION_in_eid2937); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    UNION356_tree = (CommonTree)adaptor.dupNode(UNION356);


                    adaptor.addChild(root_0, UNION356_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 15 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:557:7: SPLIT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    SPLIT357=(CommonTree)match(input,SPLIT,FOLLOW_SPLIT_in_eid2945); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SPLIT357_tree = (CommonTree)adaptor.dupNode(SPLIT357);


                    adaptor.addChild(root_0, SPLIT357_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 16 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:558:7: INTO
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INTO358=(CommonTree)match(input,INTO,FOLLOW_INTO_in_eid2953); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INTO358_tree = (CommonTree)adaptor.dupNode(INTO358);


                    adaptor.addChild(root_0, INTO358_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 17 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:559:7: IF
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IF359=(CommonTree)match(input,IF,FOLLOW_IF_in_eid2961); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IF359_tree = (CommonTree)adaptor.dupNode(IF359);


                    adaptor.addChild(root_0, IF359_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 18 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:560:7: ALL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ALL360=(CommonTree)match(input,ALL,FOLLOW_ALL_in_eid2969); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ALL360_tree = (CommonTree)adaptor.dupNode(ALL360);


                    adaptor.addChild(root_0, ALL360_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 19 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:561:7: AS
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    AS361=(CommonTree)match(input,AS,FOLLOW_AS_in_eid2977); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    AS361_tree = (CommonTree)adaptor.dupNode(AS361);


                    adaptor.addChild(root_0, AS361_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 20 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:562:7: BY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BY362=(CommonTree)match(input,BY,FOLLOW_BY_in_eid2985); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BY362_tree = (CommonTree)adaptor.dupNode(BY362);


                    adaptor.addChild(root_0, BY362_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 21 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:563:7: USING
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    USING363=(CommonTree)match(input,USING,FOLLOW_USING_in_eid2993); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    USING363_tree = (CommonTree)adaptor.dupNode(USING363);


                    adaptor.addChild(root_0, USING363_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 22 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:564:7: INNER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INNER364=(CommonTree)match(input,INNER,FOLLOW_INNER_in_eid3001); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INNER364_tree = (CommonTree)adaptor.dupNode(INNER364);


                    adaptor.addChild(root_0, INNER364_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 23 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:565:7: OUTER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    OUTER365=(CommonTree)match(input,OUTER,FOLLOW_OUTER_in_eid3009); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OUTER365_tree = (CommonTree)adaptor.dupNode(OUTER365);


                    adaptor.addChild(root_0, OUTER365_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 24 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:566:7: PARALLEL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    PARALLEL366=(CommonTree)match(input,PARALLEL,FOLLOW_PARALLEL_in_eid3017); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PARALLEL366_tree = (CommonTree)adaptor.dupNode(PARALLEL366);


                    adaptor.addChild(root_0, PARALLEL366_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 25 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:567:7: PARTITION
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    PARTITION367=(CommonTree)match(input,PARTITION,FOLLOW_PARTITION_in_eid3025); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PARTITION367_tree = (CommonTree)adaptor.dupNode(PARTITION367);


                    adaptor.addChild(root_0, PARTITION367_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 26 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:568:7: GROUP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    GROUP368=(CommonTree)match(input,GROUP,FOLLOW_GROUP_in_eid3033); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    GROUP368_tree = (CommonTree)adaptor.dupNode(GROUP368);


                    adaptor.addChild(root_0, GROUP368_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 27 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:569:7: AND
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    AND369=(CommonTree)match(input,AND,FOLLOW_AND_in_eid3041); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    AND369_tree = (CommonTree)adaptor.dupNode(AND369);


                    adaptor.addChild(root_0, AND369_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 28 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:570:7: OR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    OR370=(CommonTree)match(input,OR,FOLLOW_OR_in_eid3049); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OR370_tree = (CommonTree)adaptor.dupNode(OR370);


                    adaptor.addChild(root_0, OR370_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 29 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:571:7: NOT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    NOT371=(CommonTree)match(input,NOT,FOLLOW_NOT_in_eid3057); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NOT371_tree = (CommonTree)adaptor.dupNode(NOT371);


                    adaptor.addChild(root_0, NOT371_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 30 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:572:7: GENERATE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    GENERATE372=(CommonTree)match(input,GENERATE,FOLLOW_GENERATE_in_eid3065); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    GENERATE372_tree = (CommonTree)adaptor.dupNode(GENERATE372);


                    adaptor.addChild(root_0, GENERATE372_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 31 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:573:7: FLATTEN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FLATTEN373=(CommonTree)match(input,FLATTEN,FOLLOW_FLATTEN_in_eid3073); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FLATTEN373_tree = (CommonTree)adaptor.dupNode(FLATTEN373);


                    adaptor.addChild(root_0, FLATTEN373_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 32 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:574:7: EVAL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    EVAL374=(CommonTree)match(input,EVAL,FOLLOW_EVAL_in_eid3081); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EVAL374_tree = (CommonTree)adaptor.dupNode(EVAL374);


                    adaptor.addChild(root_0, EVAL374_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 33 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:575:7: ASC
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ASC375=(CommonTree)match(input,ASC,FOLLOW_ASC_in_eid3089); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ASC375_tree = (CommonTree)adaptor.dupNode(ASC375);


                    adaptor.addChild(root_0, ASC375_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 34 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:576:7: DESC
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DESC376=(CommonTree)match(input,DESC,FOLLOW_DESC_in_eid3097); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DESC376_tree = (CommonTree)adaptor.dupNode(DESC376);


                    adaptor.addChild(root_0, DESC376_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 35 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:577:7: BOOLEAN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BOOLEAN377=(CommonTree)match(input,BOOLEAN,FOLLOW_BOOLEAN_in_eid3105); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BOOLEAN377_tree = (CommonTree)adaptor.dupNode(BOOLEAN377);


                    adaptor.addChild(root_0, BOOLEAN377_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 36 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:578:7: INT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INT378=(CommonTree)match(input,INT,FOLLOW_INT_in_eid3113); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INT378_tree = (CommonTree)adaptor.dupNode(INT378);


                    adaptor.addChild(root_0, INT378_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 37 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:579:7: LONG
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LONG379=(CommonTree)match(input,LONG,FOLLOW_LONG_in_eid3121); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LONG379_tree = (CommonTree)adaptor.dupNode(LONG379);


                    adaptor.addChild(root_0, LONG379_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 38 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:580:7: FLOAT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FLOAT380=(CommonTree)match(input,FLOAT,FOLLOW_FLOAT_in_eid3129); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FLOAT380_tree = (CommonTree)adaptor.dupNode(FLOAT380);


                    adaptor.addChild(root_0, FLOAT380_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 39 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:581:7: DOUBLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DOUBLE381=(CommonTree)match(input,DOUBLE,FOLLOW_DOUBLE_in_eid3137); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DOUBLE381_tree = (CommonTree)adaptor.dupNode(DOUBLE381);


                    adaptor.addChild(root_0, DOUBLE381_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 40 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:582:7: CHARARRAY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CHARARRAY382=(CommonTree)match(input,CHARARRAY,FOLLOW_CHARARRAY_in_eid3145); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CHARARRAY382_tree = (CommonTree)adaptor.dupNode(CHARARRAY382);


                    adaptor.addChild(root_0, CHARARRAY382_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 41 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:583:7: BYTEARRAY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BYTEARRAY383=(CommonTree)match(input,BYTEARRAY,FOLLOW_BYTEARRAY_in_eid3153); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BYTEARRAY383_tree = (CommonTree)adaptor.dupNode(BYTEARRAY383);


                    adaptor.addChild(root_0, BYTEARRAY383_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 42 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:584:7: BAG
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BAG384=(CommonTree)match(input,BAG,FOLLOW_BAG_in_eid3161); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BAG384_tree = (CommonTree)adaptor.dupNode(BAG384);


                    adaptor.addChild(root_0, BAG384_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 43 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:585:7: TUPLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TUPLE385=(CommonTree)match(input,TUPLE,FOLLOW_TUPLE_in_eid3169); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TUPLE385_tree = (CommonTree)adaptor.dupNode(TUPLE385);


                    adaptor.addChild(root_0, TUPLE385_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 44 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:586:7: MAP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    MAP386=(CommonTree)match(input,MAP,FOLLOW_MAP_in_eid3177); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MAP386_tree = (CommonTree)adaptor.dupNode(MAP386);


                    adaptor.addChild(root_0, MAP386_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 45 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:587:7: IS
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IS387=(CommonTree)match(input,IS,FOLLOW_IS_in_eid3185); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IS387_tree = (CommonTree)adaptor.dupNode(IS387);


                    adaptor.addChild(root_0, IS387_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 46 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:588:7: NULL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    NULL388=(CommonTree)match(input,NULL,FOLLOW_NULL_in_eid3193); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NULL388_tree = (CommonTree)adaptor.dupNode(NULL388);


                    adaptor.addChild(root_0, NULL388_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 47 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:589:7: TRUE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TRUE389=(CommonTree)match(input,TRUE,FOLLOW_TRUE_in_eid3201); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TRUE389_tree = (CommonTree)adaptor.dupNode(TRUE389);


                    adaptor.addChild(root_0, TRUE389_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 48 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:590:7: FALSE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FALSE390=(CommonTree)match(input,FALSE,FOLLOW_FALSE_in_eid3209); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FALSE390_tree = (CommonTree)adaptor.dupNode(FALSE390);


                    adaptor.addChild(root_0, FALSE390_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 49 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:591:7: STREAM
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STREAM391=(CommonTree)match(input,STREAM,FOLLOW_STREAM_in_eid3217); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STREAM391_tree = (CommonTree)adaptor.dupNode(STREAM391);


                    adaptor.addChild(root_0, STREAM391_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 50 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:592:7: THROUGH
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    THROUGH392=(CommonTree)match(input,THROUGH,FOLLOW_THROUGH_in_eid3225); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    THROUGH392_tree = (CommonTree)adaptor.dupNode(THROUGH392);


                    adaptor.addChild(root_0, THROUGH392_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 51 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:593:7: STORE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STORE393=(CommonTree)match(input,STORE,FOLLOW_STORE_in_eid3233); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STORE393_tree = (CommonTree)adaptor.dupNode(STORE393);


                    adaptor.addChild(root_0, STORE393_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 52 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:594:7: MAPREDUCE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    MAPREDUCE394=(CommonTree)match(input,MAPREDUCE,FOLLOW_MAPREDUCE_in_eid3241); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MAPREDUCE394_tree = (CommonTree)adaptor.dupNode(MAPREDUCE394);


                    adaptor.addChild(root_0, MAPREDUCE394_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 53 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:595:7: SHIP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    SHIP395=(CommonTree)match(input,SHIP,FOLLOW_SHIP_in_eid3249); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SHIP395_tree = (CommonTree)adaptor.dupNode(SHIP395);


                    adaptor.addChild(root_0, SHIP395_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 54 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:596:7: CACHE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CACHE396=(CommonTree)match(input,CACHE,FOLLOW_CACHE_in_eid3257); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CACHE396_tree = (CommonTree)adaptor.dupNode(CACHE396);


                    adaptor.addChild(root_0, CACHE396_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 55 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:597:7: INPUT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INPUT397=(CommonTree)match(input,INPUT,FOLLOW_INPUT_in_eid3265); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INPUT397_tree = (CommonTree)adaptor.dupNode(INPUT397);


                    adaptor.addChild(root_0, INPUT397_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 56 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:598:7: OUTPUT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    OUTPUT398=(CommonTree)match(input,OUTPUT,FOLLOW_OUTPUT_in_eid3273); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OUTPUT398_tree = (CommonTree)adaptor.dupNode(OUTPUT398);


                    adaptor.addChild(root_0, OUTPUT398_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 57 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:599:7: STDERROR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STDERROR399=(CommonTree)match(input,STDERROR,FOLLOW_STDERROR_in_eid3281); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDERROR399_tree = (CommonTree)adaptor.dupNode(STDERROR399);


                    adaptor.addChild(root_0, STDERROR399_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 58 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:600:7: STDIN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STDIN400=(CommonTree)match(input,STDIN,FOLLOW_STDIN_in_eid3289); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDIN400_tree = (CommonTree)adaptor.dupNode(STDIN400);


                    adaptor.addChild(root_0, STDIN400_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 59 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:601:7: STDOUT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STDOUT401=(CommonTree)match(input,STDOUT,FOLLOW_STDOUT_in_eid3297); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDOUT401_tree = (CommonTree)adaptor.dupNode(STDOUT401);


                    adaptor.addChild(root_0, STDOUT401_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 60 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:602:7: LIMIT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LIMIT402=(CommonTree)match(input,LIMIT,FOLLOW_LIMIT_in_eid3305); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LIMIT402_tree = (CommonTree)adaptor.dupNode(LIMIT402);


                    adaptor.addChild(root_0, LIMIT402_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 61 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:603:7: SAMPLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    SAMPLE403=(CommonTree)match(input,SAMPLE,FOLLOW_SAMPLE_in_eid3313); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SAMPLE403_tree = (CommonTree)adaptor.dupNode(SAMPLE403);


                    adaptor.addChild(root_0, SAMPLE403_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 62 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:604:7: LEFT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LEFT404=(CommonTree)match(input,LEFT,FOLLOW_LEFT_in_eid3321); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LEFT404_tree = (CommonTree)adaptor.dupNode(LEFT404);


                    adaptor.addChild(root_0, LEFT404_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 63 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:605:7: RIGHT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    RIGHT405=(CommonTree)match(input,RIGHT,FOLLOW_RIGHT_in_eid3329); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RIGHT405_tree = (CommonTree)adaptor.dupNode(RIGHT405);


                    adaptor.addChild(root_0, RIGHT405_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 64 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:606:7: FULL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FULL406=(CommonTree)match(input,FULL,FOLLOW_FULL_in_eid3337); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FULL406_tree = (CommonTree)adaptor.dupNode(FULL406);


                    adaptor.addChild(root_0, FULL406_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 65 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:607:7: IDENTIFIER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER407=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_eid3345); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER407_tree = (CommonTree)adaptor.dupNode(IDENTIFIER407);


                    adaptor.addChild(root_0, IDENTIFIER407_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 66 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:608:7: TOBAG
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TOBAG408=(CommonTree)match(input,TOBAG,FOLLOW_TOBAG_in_eid3353); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TOBAG408_tree = (CommonTree)adaptor.dupNode(TOBAG408);


                    adaptor.addChild(root_0, TOBAG408_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 67 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:609:7: TOMAP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TOMAP409=(CommonTree)match(input,TOMAP,FOLLOW_TOMAP_in_eid3361); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TOMAP409_tree = (CommonTree)adaptor.dupNode(TOMAP409);


                    adaptor.addChild(root_0, TOMAP409_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 68 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:610:7: TOTUPLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TOTUPLE410=(CommonTree)match(input,TOTUPLE,FOLLOW_TOTUPLE_in_eid3369); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TOTUPLE410_tree = (CommonTree)adaptor.dupNode(TOTUPLE410);


                    adaptor.addChild(root_0, TOTUPLE410_tree);
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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:614:1: rel_op : ( rel_op_eq | rel_op_ne | rel_op_gt | rel_op_gte | rel_op_lt | rel_op_lte | STR_OP_MATCHES );
    public final AstValidator.rel_op_return rel_op() throws RecognitionException {
        AstValidator.rel_op_return retval = new AstValidator.rel_op_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STR_OP_MATCHES417=null;
        AstValidator.rel_op_eq_return rel_op_eq411 =null;

        AstValidator.rel_op_ne_return rel_op_ne412 =null;

        AstValidator.rel_op_gt_return rel_op_gt413 =null;

        AstValidator.rel_op_gte_return rel_op_gte414 =null;

        AstValidator.rel_op_lt_return rel_op_lt415 =null;

        AstValidator.rel_op_lte_return rel_op_lte416 =null;


        CommonTree STR_OP_MATCHES417_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:614:8: ( rel_op_eq | rel_op_ne | rel_op_gt | rel_op_gte | rel_op_lt | rel_op_lte | STR_OP_MATCHES )
            int alt98=7;
            switch ( input.LA(1) ) {
            case NUM_OP_EQ:
            case STR_OP_EQ:
                {
                alt98=1;
                }
                break;
            case NUM_OP_NE:
            case STR_OP_NE:
                {
                alt98=2;
                }
                break;
            case NUM_OP_GT:
            case STR_OP_GT:
                {
                alt98=3;
                }
                break;
            case NUM_OP_GTE:
            case STR_OP_GTE:
                {
                alt98=4;
                }
                break;
            case NUM_OP_LT:
            case STR_OP_LT:
                {
                alt98=5;
                }
                break;
            case NUM_OP_LTE:
            case STR_OP_LTE:
                {
                alt98=6;
                }
                break;
            case STR_OP_MATCHES:
                {
                alt98=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 98, 0, input);

                throw nvae;

            }

            switch (alt98) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:614:10: rel_op_eq
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_eq_in_rel_op3379);
                    rel_op_eq411=rel_op_eq();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_eq411.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:615:10: rel_op_ne
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_ne_in_rel_op3390);
                    rel_op_ne412=rel_op_ne();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_ne412.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:616:10: rel_op_gt
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_gt_in_rel_op3401);
                    rel_op_gt413=rel_op_gt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_gt413.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:617:10: rel_op_gte
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_gte_in_rel_op3412);
                    rel_op_gte414=rel_op_gte();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_gte414.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:618:10: rel_op_lt
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_lt_in_rel_op3423);
                    rel_op_lt415=rel_op_lt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_lt415.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:619:10: rel_op_lte
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_lte_in_rel_op3434);
                    rel_op_lte416=rel_op_lte();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_lte416.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:620:10: STR_OP_MATCHES
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_MATCHES417=(CommonTree)match(input,STR_OP_MATCHES,FOLLOW_STR_OP_MATCHES_in_rel_op3445); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_MATCHES417_tree = (CommonTree)adaptor.dupNode(STR_OP_MATCHES417);


                    adaptor.addChild(root_0, STR_OP_MATCHES417_tree);
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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:623:1: rel_op_eq : ( STR_OP_EQ | NUM_OP_EQ );
    public final AstValidator.rel_op_eq_return rel_op_eq() throws RecognitionException {
        AstValidator.rel_op_eq_return retval = new AstValidator.rel_op_eq_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set418=null;

        CommonTree set418_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:623:11: ( STR_OP_EQ | NUM_OP_EQ )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set418=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_EQ||input.LA(1)==STR_OP_EQ ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set418_tree = (CommonTree)adaptor.dupNode(set418);


                adaptor.addChild(root_0, set418_tree);
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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:626:1: rel_op_ne : ( STR_OP_NE | NUM_OP_NE );
    public final AstValidator.rel_op_ne_return rel_op_ne() throws RecognitionException {
        AstValidator.rel_op_ne_return retval = new AstValidator.rel_op_ne_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set419=null;

        CommonTree set419_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:626:11: ( STR_OP_NE | NUM_OP_NE )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set419=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_NE||input.LA(1)==STR_OP_NE ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set419_tree = (CommonTree)adaptor.dupNode(set419);


                adaptor.addChild(root_0, set419_tree);
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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:629:1: rel_op_gt : ( STR_OP_GT | NUM_OP_GT );
    public final AstValidator.rel_op_gt_return rel_op_gt() throws RecognitionException {
        AstValidator.rel_op_gt_return retval = new AstValidator.rel_op_gt_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set420=null;

        CommonTree set420_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:629:11: ( STR_OP_GT | NUM_OP_GT )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set420=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_GT||input.LA(1)==STR_OP_GT ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set420_tree = (CommonTree)adaptor.dupNode(set420);


                adaptor.addChild(root_0, set420_tree);
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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:632:1: rel_op_gte : ( STR_OP_GTE | NUM_OP_GTE );
    public final AstValidator.rel_op_gte_return rel_op_gte() throws RecognitionException {
        AstValidator.rel_op_gte_return retval = new AstValidator.rel_op_gte_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set421=null;

        CommonTree set421_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:632:12: ( STR_OP_GTE | NUM_OP_GTE )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set421=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_GTE||input.LA(1)==STR_OP_GTE ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set421_tree = (CommonTree)adaptor.dupNode(set421);


                adaptor.addChild(root_0, set421_tree);
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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:635:1: rel_op_lt : ( STR_OP_LT | NUM_OP_LT );
    public final AstValidator.rel_op_lt_return rel_op_lt() throws RecognitionException {
        AstValidator.rel_op_lt_return retval = new AstValidator.rel_op_lt_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set422=null;

        CommonTree set422_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:635:11: ( STR_OP_LT | NUM_OP_LT )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set422=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_LT||input.LA(1)==STR_OP_LT ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set422_tree = (CommonTree)adaptor.dupNode(set422);


                adaptor.addChild(root_0, set422_tree);
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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:638:1: rel_op_lte : ( STR_OP_LTE | NUM_OP_LTE );
    public final AstValidator.rel_op_lte_return rel_op_lte() throws RecognitionException {
        AstValidator.rel_op_lte_return retval = new AstValidator.rel_op_lte_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set423=null;

        CommonTree set423_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:638:12: ( STR_OP_LTE | NUM_OP_LTE )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set423=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_LTE||input.LA(1)==STR_OP_LTE ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set423_tree = (CommonTree)adaptor.dupNode(set423);


                adaptor.addChild(root_0, set423_tree);
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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:641:1: rel_str_op : ( STR_OP_EQ | STR_OP_NE | STR_OP_GT | STR_OP_LT | STR_OP_GTE | STR_OP_LTE | STR_OP_MATCHES );
    public final AstValidator.rel_str_op_return rel_str_op() throws RecognitionException {
        AstValidator.rel_str_op_return retval = new AstValidator.rel_str_op_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set424=null;

        CommonTree set424_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:641:12: ( STR_OP_EQ | STR_OP_NE | STR_OP_GT | STR_OP_LT | STR_OP_GTE | STR_OP_LTE | STR_OP_MATCHES )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set424=(CommonTree)input.LT(1);

            if ( (input.LA(1) >= STR_OP_EQ && input.LA(1) <= STR_OP_NE) ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set424_tree = (CommonTree)adaptor.dupNode(set424);


                adaptor.addChild(root_0, set424_tree);
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

    // $ANTLR start synpred86_AstValidator
    public final void synpred86_AstValidator_fragment() throws RecognitionException {
        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:298:8: ( ^( MINUS expr expr ) )
        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:298:8: ^( MINUS expr expr )
        {
        match(input,MINUS,FOLLOW_MINUS_in_synpred86_AstValidator1409); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        pushFollow(FOLLOW_expr_in_synpred86_AstValidator1411);
        expr();

        state._fsp--;
        if (state.failed) return ;

        pushFollow(FOLLOW_expr_in_synpred86_AstValidator1413);
        expr();

        state._fsp--;
        if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;


        }

    }
    // $ANTLR end synpred86_AstValidator

    // $ANTLR start synpred90_AstValidator
    public final void synpred90_AstValidator_fragment() throws RecognitionException {
        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:302:8: ( ^( CAST_EXPR type expr ) )
        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:302:8: ^( CAST_EXPR type expr )
        {
        match(input,CAST_EXPR,FOLLOW_CAST_EXPR_in_synpred90_AstValidator1477); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        pushFollow(FOLLOW_type_in_synpred90_AstValidator1479);
        type();

        state._fsp--;
        if (state.failed) return ;

        pushFollow(FOLLOW_expr_in_synpred90_AstValidator1481);
        expr();

        state._fsp--;
        if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;


        }

    }
    // $ANTLR end synpred90_AstValidator

    // $ANTLR start synpred91_AstValidator
    public final void synpred91_AstValidator_fragment() throws RecognitionException {
        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:303:8: ( const_expr )
        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:303:8: const_expr
        {
        pushFollow(FOLLOW_const_expr_in_synpred91_AstValidator1492);
        const_expr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred91_AstValidator

    // $ANTLR start synpred94_AstValidator
    public final void synpred94_AstValidator_fragment() throws RecognitionException {
        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:306:8: ( ^( CAST_EXPR type_cast expr ) )
        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:306:8: ^( CAST_EXPR type_cast expr )
        {
        match(input,CAST_EXPR,FOLLOW_CAST_EXPR_in_synpred94_AstValidator1527); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        pushFollow(FOLLOW_type_cast_in_synpred94_AstValidator1529);
        type_cast();

        state._fsp--;
        if (state.failed) return ;

        pushFollow(FOLLOW_expr_in_synpred94_AstValidator1531);
        expr();

        state._fsp--;
        if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;


        }

    }
    // $ANTLR end synpred94_AstValidator

    // $ANTLR start synpred110_AstValidator
    public final void synpred110_AstValidator_fragment() throws RecognitionException {
        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:347:31: ( INTEGER )
        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:347:31: INTEGER
        {
        match(input,INTEGER,FOLLOW_INTEGER_in_synpred110_AstValidator1768); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred110_AstValidator

    // $ANTLR start synpred111_AstValidator
    public final void synpred111_AstValidator_fragment() throws RecognitionException {
        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:347:41: ( LONGINTEGER )
        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:347:41: LONGINTEGER
        {
        match(input,LONGINTEGER,FOLLOW_LONGINTEGER_in_synpred111_AstValidator1772); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred111_AstValidator

    // $ANTLR start synpred112_AstValidator
    public final void synpred112_AstValidator_fragment() throws RecognitionException {
        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:350:33: ( DOUBLENUMBER )
        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:350:33: DOUBLENUMBER
        {
        match(input,DOUBLENUMBER,FOLLOW_DOUBLENUMBER_in_synpred112_AstValidator1797); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred112_AstValidator

    // $ANTLR start synpred131_AstValidator
    public final void synpred131_AstValidator_fragment() throws RecognitionException {
        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:390:4: ( join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item )
        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:390:4: join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item
        {
        pushFollow(FOLLOW_join_item_in_synpred131_AstValidator2020);
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


        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:390:38: ( OUTER )?
        int alt105=2;
        int LA105_0 = input.LA(1);

        if ( (LA105_0==OUTER) ) {
            alt105=1;
        }
        switch (alt105) {
            case 1 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:390:38: OUTER
                {
                match(input,OUTER,FOLLOW_OUTER_in_synpred131_AstValidator2036); if (state.failed) return ;

                }
                break;

        }


        pushFollow(FOLLOW_join_item_in_synpred131_AstValidator2039);
        join_item();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred131_AstValidator

    // $ANTLR start synpred149_AstValidator
    public final void synpred149_AstValidator_fragment() throws RecognitionException {
        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:469:43: ( INTEGER )
        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/AstValidator.g:469:43: INTEGER
        {
        match(input,INTEGER,FOLLOW_INTEGER_in_synpred149_AstValidator2450); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred149_AstValidator

    // Delegated rules

    public final boolean synpred149_AstValidator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred149_AstValidator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred94_AstValidator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred94_AstValidator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred131_AstValidator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred131_AstValidator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred86_AstValidator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred86_AstValidator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred111_AstValidator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred111_AstValidator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred110_AstValidator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred110_AstValidator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred112_AstValidator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred112_AstValidator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred91_AstValidator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred91_AstValidator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred90_AstValidator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred90_AstValidator_fragment(); // can never throw exception
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
    public static final BitSet FOLLOW_STATEMENT_in_general_statement152 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_general_statement156 = new BitSet(new long[]{0x46080121004A4000L,0x000400C210000800L});
    public static final BitSet FOLLOW_op_clause_in_general_statement163 = new BitSet(new long[]{0x0000000000000008L,0x0000000000008000L});
    public static final BitSet FOLLOW_parallel_clause_in_general_statement165 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_REALIAS_in_realias_clause178 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_realias_clause180 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_in_realias_clause182 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PARALLEL_in_parallel_clause199 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INTEGER_in_parallel_clause201 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IDENTIFIER_in_alias216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_define_clause_in_op_clause230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_load_clause_in_op_clause245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_group_clause_in_op_clause259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_store_clause_in_op_clause273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_filter_clause_in_op_clause287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_distinct_clause_in_op_clause301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_limit_clause_in_op_clause315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sample_clause_in_op_clause329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_order_clause_in_op_clause343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cross_clause_in_op_clause357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_join_clause_in_op_clause371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_union_clause_in_op_clause385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stream_clause_in_op_clause399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mr_clause_in_op_clause413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_split_clause_in_op_clause427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_foreach_clause_in_op_clause441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEFINE_in_define_clause452 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_define_clause454 = new BitSet(new long[]{0x0000000040000000L,0x0000000000000000L,0x0000000000000014L});
    public static final BitSet FOLLOW_cmd_in_define_clause458 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_func_clause_in_define_clause462 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXECCOMMAND_in_cmd483 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ship_clause_in_cmd487 = new BitSet(new long[]{0x0000400000001008L,0x0000000840004000L});
    public static final BitSet FOLLOW_cache_clause_in_cmd511 = new BitSet(new long[]{0x0000400000001008L,0x0000000840004000L});
    public static final BitSet FOLLOW_input_clause_in_cmd535 = new BitSet(new long[]{0x0000400000001008L,0x0000000840004000L});
    public static final BitSet FOLLOW_output_clause_in_cmd560 = new BitSet(new long[]{0x0000400000001008L,0x0000000840004000L});
    public static final BitSet FOLLOW_error_clause_in_cmd585 = new BitSet(new long[]{0x0000400000001008L,0x0000000840004000L});
    public static final BitSet FOLLOW_SHIP_in_ship_clause624 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_path_list_in_ship_clause626 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_path_list638 = new BitSet(new long[]{0x0000000000000002L,0x0000000000400000L});
    public static final BitSet FOLLOW_CACHE_in_cache_clause650 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_path_list_in_cache_clause652 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INPUT_in_input_clause665 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_stream_cmd_in_input_clause667 = new BitSet(new long[]{0x0000000000000008L,0x0000003000400000L});
    public static final BitSet FOLLOW_STDIN_in_stream_cmd681 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_clause_in_stream_cmd683 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STDOUT_in_stream_cmd703 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_clause_in_stream_cmd705 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_stream_cmd725 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_clause_in_stream_cmd727 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OUTPUT_in_output_clause741 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_stream_cmd_in_output_clause743 = new BitSet(new long[]{0x0000000000000008L,0x0000003000400000L});
    public static final BitSet FOLLOW_STDERROR_in_error_clause757 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_error_clause762 = new BitSet(new long[]{0x0001000000000008L});
    public static final BitSet FOLLOW_INTEGER_in_error_clause764 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LOAD_in_load_clause781 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_filename_in_load_clause783 = new BitSet(new long[]{0x0000000000000048L,0x0000000000000000L,0x0000000000000014L});
    public static final BitSet FOLLOW_func_clause_in_load_clause785 = new BitSet(new long[]{0x0000000000000048L});
    public static final BitSet FOLLOW_as_clause_in_load_clause788 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_filename800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AS_in_as_clause810 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_field_def_list_in_as_clause812 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FIELD_DEF_in_field_def831 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_field_def833 = new BitSet(new long[]{0x0800800404002A08L,0x0080000000000000L,0x0000000008000800L});
    public static final BitSet FOLLOW_type_in_field_def837 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_field_def_in_field_def_list864 = new BitSet(new long[]{0x0000000000000002L,0x8000000000000000L});
    public static final BitSet FOLLOW_simple_type_in_type877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tuple_type_in_type881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bag_type_in_type885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_map_type_in_type889 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TUPLE_TYPE_in_tuple_type933 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_field_def_list_in_tuple_type935 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BAG_TYPE_in_bag_type949 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_bag_type951 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_tuple_type_in_bag_type954 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MAP_TYPE_in_map_type968 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_in_map_type970 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNC_REF_in_func_clause984 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_func_clause986 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNC_in_func_clause1006 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_func_clause1008 = new BitSet(new long[]{0x0000000000000008L,0x0000000000400002L});
    public static final BitSet FOLLOW_func_args_in_func_clause1010 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_eid_in_func_name1022 = new BitSet(new long[]{0x0000000001000002L,0x0000000000040000L});
    public static final BitSet FOLLOW_set_in_func_name1026 = new BitSet(new long[]{0x6E1EF9E7845A7FF0L,0x000FFFFA5181EC04L,0x00000000C7020020L});
    public static final BitSet FOLLOW_eid_in_func_name1036 = new BitSet(new long[]{0x0000000001000002L,0x0000000000040000L});
    public static final BitSet FOLLOW_func_args_string_in_func_args1061 = new BitSet(new long[]{0x0000000000000002L,0x0000000000400002L});
    public static final BitSet FOLLOW_set_in_group_clause1083 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_group_item_in_group_clause1093 = new BitSet(new long[]{0x46080121004A4008L,0x000400C210410800L,0x0000000000000020L});
    public static final BitSet FOLLOW_group_type_in_group_clause1096 = new BitSet(new long[]{0x0000000000000008L,0x0000000000010000L});
    public static final BitSet FOLLOW_partition_clause_in_group_clause1099 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_group_type1111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_in_group_item1122 = new BitSet(new long[]{0x0000000000000410L,0x0040000000000000L});
    public static final BitSet FOLLOW_join_group_by_clause_in_group_item1126 = new BitSet(new long[]{0x0000200000000002L,0x0000000000002000L});
    public static final BitSet FOLLOW_ALL_in_group_item1130 = new BitSet(new long[]{0x0000200000000002L,0x0000000000002000L});
    public static final BitSet FOLLOW_ANY_in_group_item1134 = new BitSet(new long[]{0x0000200000000002L,0x0000000000002000L});
    public static final BitSet FOLLOW_alias_in_rel1161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_op_clause_in_rel1171 = new BitSet(new long[]{0x0000000000000002L,0x0000000000008000L});
    public static final BitSet FOLLOW_parallel_clause_in_rel1173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_flatten_clause_in_flatten_generated_item1185 = new BitSet(new long[]{0x0000000000000002L,0x8000000000000000L});
    public static final BitSet FOLLOW_col_range_in_flatten_generated_item1189 = new BitSet(new long[]{0x0000000000000002L,0x8000000000000000L});
    public static final BitSet FOLLOW_expr_in_flatten_generated_item1193 = new BitSet(new long[]{0x0000000000000002L,0x8000000000000000L});
    public static final BitSet FOLLOW_STAR_in_flatten_generated_item1197 = new BitSet(new long[]{0x0000000000000002L,0x8000000000000000L});
    public static final BitSet FOLLOW_field_def_list_in_flatten_generated_item1201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLATTEN_in_flatten_clause1213 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_flatten_clause1215 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STORE_in_store_clause1228 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_store_clause1230 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_filename_in_store_clause1232 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000000000014L});
    public static final BitSet FOLLOW_func_clause_in_store_clause1234 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FILTER_in_filter_clause1248 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_filter_clause1250 = new BitSet(new long[]{0x0000000000000020L,0x00007F00000005FCL,0x0000000000020008L});
    public static final BitSet FOLLOW_cond_in_filter_clause1252 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OR_in_cond1265 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_cond1267 = new BitSet(new long[]{0x0000000000000020L,0x00007F00000005FCL,0x0000000000020008L});
    public static final BitSet FOLLOW_cond_in_cond1269 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AND_in_cond1282 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_cond1284 = new BitSet(new long[]{0x0000000000000020L,0x00007F00000005FCL,0x0000000000020008L});
    public static final BitSet FOLLOW_cond_in_cond1286 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NOT_in_cond1299 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_cond1301 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NULL_in_cond1314 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond1316 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000004L});
    public static final BitSet FOLLOW_NOT_in_cond1318 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rel_op_in_cond1332 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond1334 = new BitSet(new long[]{0x900101108A800000L,0x56010004004A0000L,0x0000000020023028L});
    public static final BitSet FOLLOW_expr_in_cond1336 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_func_eval_in_cond1347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FUNC_EVAL_in_func_eval1357 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_func_eval1359 = new BitSet(new long[]{0x900101108A800008L,0x76010004004A0000L,0x0000000020023028L});
    public static final BitSet FOLLOW_real_arg_in_func_eval1361 = new BitSet(new long[]{0x900101108A800008L,0x76010004004A0000L,0x0000000020023028L});
    public static final BitSet FOLLOW_expr_in_real_arg1373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_real_arg1377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_col_range_in_real_arg1381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUS_in_expr1392 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1394 = new BitSet(new long[]{0x900101108A800000L,0x56010004004A0000L,0x0000000020023028L});
    public static final BitSet FOLLOW_expr_in_expr1396 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MINUS_in_expr1409 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1411 = new BitSet(new long[]{0x900101108A800000L,0x56010004004A0000L,0x0000000020023028L});
    public static final BitSet FOLLOW_expr_in_expr1413 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STAR_in_expr1426 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1428 = new BitSet(new long[]{0x900101108A800000L,0x56010004004A0000L,0x0000000020023028L});
    public static final BitSet FOLLOW_expr_in_expr1430 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DIV_in_expr1443 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1445 = new BitSet(new long[]{0x900101108A800000L,0x56010004004A0000L,0x0000000020023028L});
    public static final BitSet FOLLOW_expr_in_expr1447 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PERCENT_in_expr1460 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1462 = new BitSet(new long[]{0x900101108A800000L,0x56010004004A0000L,0x0000000020023028L});
    public static final BitSet FOLLOW_expr_in_expr1464 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CAST_EXPR_in_expr1477 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_in_expr1479 = new BitSet(new long[]{0x900101108A800000L,0x56010004004A0000L,0x0000000020023028L});
    public static final BitSet FOLLOW_expr_in_expr1481 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_const_expr_in_expr1492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_var_expr_in_expr1501 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEG_in_expr1512 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1514 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CAST_EXPR_in_expr1527 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_cast_in_expr1529 = new BitSet(new long[]{0x900101108A800000L,0x56010004004A0000L,0x0000000020023028L});
    public static final BitSet FOLLOW_expr_in_expr1531 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXPR_IN_PAREN_in_expr1544 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1546 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_simple_type_in_type_cast1557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_map_type_in_type_cast1561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tuple_type_cast_in_type_cast1565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bag_type_cast_in_type_cast1569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TUPLE_TYPE_CAST_in_tuple_type_cast1580 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_cast_in_tuple_type_cast1582 = new BitSet(new long[]{0x0800800404002A08L,0x0100000000000000L,0x0000000010000800L});
    public static final BitSet FOLLOW_BAG_TYPE_CAST_in_bag_type_cast1596 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_tuple_type_cast_in_bag_type_cast1598 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_projectable_expr_in_var_expr1610 = new BitSet(new long[]{0x0000000000000002L,0x0000000000140000L});
    public static final BitSet FOLLOW_dot_proj_in_var_expr1614 = new BitSet(new long[]{0x0000000000000002L,0x0000000000140000L});
    public static final BitSet FOLLOW_pound_proj_in_var_expr1618 = new BitSet(new long[]{0x0000000000000002L,0x0000000000140000L});
    public static final BitSet FOLLOW_func_eval_in_projectable_expr1629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_col_ref_in_projectable_expr1633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bin_expr_in_projectable_expr1637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PERIOD_in_dot_proj1648 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_col_alias_or_index_in_dot_proj1650 = new BitSet(new long[]{0x0000010002000008L,0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_col_alias_in_col_alias_or_index1662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_col_index_in_col_alias_or_index1666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOLLARVAR_in_col_index1688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COL_RANGE_in_col_range1699 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_col_ref_in_col_range1701 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_DOUBLE_PERIOD_in_col_range1704 = new BitSet(new long[]{0x0000010002000008L,0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_col_ref_in_col_range1706 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_POUND_in_pound_proj1720 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_set_in_pound_proj1722 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BIN_EXPR_in_bin_expr1743 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_bin_expr1745 = new BitSet(new long[]{0x900101108A800000L,0x56010004004A0000L,0x0000000020023028L});
    public static final BitSet FOLLOW_expr_in_bin_expr1747 = new BitSet(new long[]{0x900101108A800000L,0x56010004004A0000L,0x0000000020023028L});
    public static final BitSet FOLLOW_expr_in_bin_expr1749 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LIMIT_in_limit_clause1762 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_limit_clause1764 = new BitSet(new long[]{0x900101108A800000L,0x56010004004A0000L,0x0000000020023028L});
    public static final BitSet FOLLOW_INTEGER_in_limit_clause1768 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LONGINTEGER_in_limit_clause1772 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expr_in_limit_clause1776 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SAMPLE_in_sample_clause1791 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_sample_clause1793 = new BitSet(new long[]{0x900101108A800000L,0x56010004004A0000L,0x0000000020023028L});
    public static final BitSet FOLLOW_DOUBLENUMBER_in_sample_clause1797 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expr_in_sample_clause1801 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ORDER_in_order_clause1816 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_order_clause1818 = new BitSet(new long[]{0x0000010002000000L,0x2000000400000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_order_by_clause_in_order_clause1820 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000000000014L});
    public static final BitSet FOLLOW_func_clause_in_order_clause1822 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STAR_in_order_by_clause1834 = new BitSet(new long[]{0x0000000000100082L});
    public static final BitSet FOLLOW_order_col_in_order_by_clause1865 = new BitSet(new long[]{0x0000010002000002L,0x2000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_col_range_in_order_col1875 = new BitSet(new long[]{0x0000000000100082L});
    public static final BitSet FOLLOW_col_ref_in_order_col1898 = new BitSet(new long[]{0x0000000000100082L});
    public static final BitSet FOLLOW_DISTINCT_in_distinct_clause1920 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_distinct_clause1922 = new BitSet(new long[]{0x0000000000000008L,0x0000000000010000L});
    public static final BitSet FOLLOW_partition_clause_in_distinct_clause1924 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PARTITION_in_partition_clause1938 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_partition_clause1940 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CROSS_in_cross_clause1953 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_list_in_cross_clause1955 = new BitSet(new long[]{0x0000000000000008L,0x0000000000010000L});
    public static final BitSet FOLLOW_partition_clause_in_cross_clause1957 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rel_in_rel_list1969 = new BitSet(new long[]{0x46080121004A4002L,0x000400C210000800L,0x0000000000000020L});
    public static final BitSet FOLLOW_JOIN_in_join_clause1991 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_join_sub_clause_in_join_clause1993 = new BitSet(new long[]{0x0000000000000008L,0x0000000000410000L});
    public static final BitSet FOLLOW_join_type_in_join_clause1995 = new BitSet(new long[]{0x0000000000000008L,0x0000000000010000L});
    public static final BitSet FOLLOW_partition_clause_in_join_clause1998 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_join_type2010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_join_item_in_join_sub_clause2020 = new BitSet(new long[]{0x0010004000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_set_in_join_sub_clause2022 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L,0x0000000000000040L});
    public static final BitSet FOLLOW_OUTER_in_join_sub_clause2036 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_join_item_in_join_sub_clause2039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_join_item_in_join_sub_clause2044 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_JOIN_ITEM_in_join_item2057 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_join_item2059 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_join_group_by_clause_in_join_item2061 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BY_in_join_group_by_clause2088 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_join_group_by_expr_in_join_group_by_clause2092 = new BitSet(new long[]{0x900101108A800008L,0x76010004004A0000L,0x0000000020023028L});
    public static final BitSet FOLLOW_col_range_in_join_group_by_expr2108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_join_group_by_expr2113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_join_group_by_expr2117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNION_in_union_clause2128 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ONSCHEMA_in_union_clause2130 = new BitSet(new long[]{0x46080121004A4000L,0x000400C210000800L,0x0000000000000020L});
    public static final BitSet FOLLOW_rel_list_in_union_clause2133 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_in_foreach_clause2146 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_foreach_clause2148 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000003L});
    public static final BitSet FOLLOW_foreach_plan_in_foreach_clause2150 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_PLAN_SIMPLE_in_foreach_plan2163 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_generate_clause_in_foreach_plan2165 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_PLAN_COMPLEX_in_foreach_plan2186 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_blk_in_foreach_plan2188 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_nested_command_in_nested_blk2208 = new BitSet(new long[]{0x0000008000000000L,0x0000000000000000L,0x000000000000C000L});
    public static final BitSet FOLLOW_generate_clause_in_nested_blk2211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GENERATE_in_generate_clause2222 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_flatten_generated_item_in_generate_clause2224 = new BitSet(new long[]{0x900101128A800008L,0x76010004004A0000L,0x0000000020023028L});
    public static final BitSet FOLLOW_NESTED_CMD_in_nested_command2239 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_nested_command2241 = new BitSet(new long[]{0x0200002100420000L,0x0000000000000800L,0x0000000000010000L});
    public static final BitSet FOLLOW_nested_op_in_nested_command2243 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NESTED_CMD_ASSI_in_nested_command2257 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_nested_command2259 = new BitSet(new long[]{0x900101108A800000L,0x56010004004A0000L,0x0000000020023028L});
    public static final BitSet FOLLOW_expr_in_nested_command2261 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_nested_proj_in_nested_op2277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_filter_in_nested_op2291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_sort_in_nested_op2305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_distinct_in_nested_op2319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_limit_in_nested_op2333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_cross_in_nested_op2347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_foreach_in_nested_op2361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NESTED_PROJ_in_nested_proj2372 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_col_ref_in_nested_proj2374 = new BitSet(new long[]{0x0000010002000000L,0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_col_ref_in_nested_proj2376 = new BitSet(new long[]{0x0000010002000008L,0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_FILTER_in_nested_filter2391 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_filter2393 = new BitSet(new long[]{0x0000000000000020L,0x00007F00000005FCL,0x0000000000020008L});
    public static final BitSet FOLLOW_cond_in_nested_filter2395 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ORDER_in_nested_sort2408 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_sort2410 = new BitSet(new long[]{0x0000010002000000L,0x2000000400000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_order_by_clause_in_nested_sort2413 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000000000014L});
    public static final BitSet FOLLOW_func_clause_in_nested_sort2415 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DISTINCT_in_nested_distinct2429 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_distinct2431 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LIMIT_in_nested_limit2444 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_limit2446 = new BitSet(new long[]{0x900101108A800000L,0x56010004004A0000L,0x0000000020023028L});
    public static final BitSet FOLLOW_INTEGER_in_nested_limit2450 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expr_in_nested_limit2454 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CROSS_in_nested_cross2469 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_list_in_nested_cross2471 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_in_nested_foreach2484 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_foreach2486 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_generate_clause_in_nested_foreach2488 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_col_ref_in_nested_op_input2499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_proj_in_nested_op_input2503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_op_input_list2512 = new BitSet(new long[]{0x0000010002000002L,0x0000000000000000L,0x0000000000010020L});
    public static final BitSet FOLLOW_STREAM_in_stream_clause2524 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_stream_clause2526 = new BitSet(new long[]{0x0000000040000000L,0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_set_in_stream_clause2528 = new BitSet(new long[]{0x0000000000000048L});
    public static final BitSet FOLLOW_as_clause_in_stream_clause2538 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MAPREDUCE_in_mr_clause2552 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_mr_clause2554 = new BitSet(new long[]{0x0000000000000000L,0x0000004000400000L});
    public static final BitSet FOLLOW_path_list_in_mr_clause2556 = new BitSet(new long[]{0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_store_clause_in_mr_clause2559 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_load_clause_in_mr_clause2561 = new BitSet(new long[]{0x0000000040000008L});
    public static final BitSet FOLLOW_EXECCOMMAND_in_mr_clause2563 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SPLIT_in_split_clause2577 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_split_clause2579 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_split_branch_in_split_clause2581 = new BitSet(new long[]{0x0000000000000008L,0x0000000000001000L,0x0000000000400000L});
    public static final BitSet FOLLOW_split_otherwise_in_split_clause2584 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SPLIT_BRANCH_in_split_branch2599 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_split_branch2601 = new BitSet(new long[]{0x0000000000000020L,0x00007F00000005FCL,0x0000000000020008L});
    public static final BitSet FOLLOW_cond_in_split_branch2603 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OTHERWISE_in_split_otherwise2622 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_split_otherwise2624 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_alias_col_ref_in_col_ref2640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dollar_col_ref_in_col_ref2644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOLLARVAR_in_dollar_col_ref2666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_const_expr2675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_scalar_in_literal2684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_map_in_literal2688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bag_in_literal2692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tuple_in_literal2696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_num_scalar_in_scalar2705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_scalar2709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NULL_in_scalar2713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_scalar2717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_scalar2721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_num_scalar2730 = new BitSet(new long[]{0x1001001008000000L});
    public static final BitSet FOLLOW_set_in_num_scalar2733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MAP_VAL_in_map2760 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_keyvalue_in_map2762 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_KEY_VAL_PAIR_in_keyvalue2776 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_map_key_in_keyvalue2778 = new BitSet(new long[]{0x9001001088000000L,0x0201000000400000L,0x0000000020021000L});
    public static final BitSet FOLLOW_const_expr_in_keyvalue2780 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_map_key2791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BAG_VAL_in_bag2802 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_tuple_in_bag2804 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_TUPLE_VAL_in_tuple2818 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_literal_in_tuple2820 = new BitSet(new long[]{0x9001001088000008L,0x0201000000400000L,0x0000000020021000L});
    public static final BitSet FOLLOW_rel_str_op_in_eid2833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IMPORT_in_eid2841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RETURNS_in_eid2849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEFINE_in_eid2857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LOAD_in_eid2865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FILTER_in_eid2873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOREACH_in_eid2881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MATCHES_in_eid2889 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ORDER_in_eid2897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DISTINCT_in_eid2905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COGROUP_in_eid2913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_JOIN_in_eid2921 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CROSS_in_eid2929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNION_in_eid2937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SPLIT_in_eid2945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTO_in_eid2953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_eid2961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ALL_in_eid2969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AS_in_eid2977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BY_in_eid2985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_USING_in_eid2993 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INNER_in_eid3001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OUTER_in_eid3009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARALLEL_in_eid3017 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARTITION_in_eid3025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GROUP_in_eid3033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AND_in_eid3041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OR_in_eid3049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_eid3057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GENERATE_in_eid3065 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLATTEN_in_eid3073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EVAL_in_eid3081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASC_in_eid3089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESC_in_eid3097 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOLEAN_in_eid3105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_eid3113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LONG_in_eid3121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_eid3129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLE_in_eid3137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHARARRAY_in_eid3145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BYTEARRAY_in_eid3153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BAG_in_eid3161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TUPLE_in_eid3169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MAP_in_eid3177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IS_in_eid3185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NULL_in_eid3193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_eid3201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_eid3209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STREAM_in_eid3217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_THROUGH_in_eid3225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STORE_in_eid3233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MAPREDUCE_in_eid3241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHIP_in_eid3249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CACHE_in_eid3257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INPUT_in_eid3265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OUTPUT_in_eid3273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STDERROR_in_eid3281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STDIN_in_eid3289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STDOUT_in_eid3297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LIMIT_in_eid3305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SAMPLE_in_eid3313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFT_in_eid3321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RIGHT_in_eid3329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FULL_in_eid3337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_eid3345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOBAG_in_eid3353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOMAP_in_eid3361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOTUPLE_in_eid3369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_eq_in_rel_op3379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_ne_in_rel_op3390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_gt_in_rel_op3401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_gte_in_rel_op3412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_lt_in_rel_op3423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_lte_in_rel_op3434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_MATCHES_in_rel_op3445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_synpred86_AstValidator1409 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_synpred86_AstValidator1411 = new BitSet(new long[]{0x900101108A800000L,0x56010004004A0000L,0x0000000020023028L});
    public static final BitSet FOLLOW_expr_in_synpred86_AstValidator1413 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CAST_EXPR_in_synpred90_AstValidator1477 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_in_synpred90_AstValidator1479 = new BitSet(new long[]{0x900101108A800000L,0x56010004004A0000L,0x0000000020023028L});
    public static final BitSet FOLLOW_expr_in_synpred90_AstValidator1481 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_const_expr_in_synpred91_AstValidator1492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CAST_EXPR_in_synpred94_AstValidator1527 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_cast_in_synpred94_AstValidator1529 = new BitSet(new long[]{0x900101108A800000L,0x56010004004A0000L,0x0000000020023028L});
    public static final BitSet FOLLOW_expr_in_synpred94_AstValidator1531 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INTEGER_in_synpred110_AstValidator1768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LONGINTEGER_in_synpred111_AstValidator1772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLENUMBER_in_synpred112_AstValidator1797 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_join_item_in_synpred131_AstValidator2020 = new BitSet(new long[]{0x0010004000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_set_in_synpred131_AstValidator2022 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L,0x0000000000000040L});
    public static final BitSet FOLLOW_OUTER_in_synpred131_AstValidator2036 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_join_item_in_synpred131_AstValidator2039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_in_synpred149_AstValidator2450 = new BitSet(new long[]{0x0000000000000002L});

}