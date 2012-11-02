// $ANTLR 3.4 /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g 2012-10-31 09:51:40

package org.apache.pig.parser;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pig.impl.PigContext;
import org.apache.pig.impl.builtin.GFAny;
import org.apache.pig.impl.logicalLayer.FrontendException;
import org.apache.pig.impl.streaming.StreamingCommand;
import org.apache.pig.impl.streaming.StreamingCommand.HandleSpec;
import org.apache.pig.impl.util.MultiMap;
import org.apache.pig.impl.plan.PlanValidationException;
import org.apache.pig.newplan.Operator;
import org.apache.pig.newplan.logical.expression.AddExpression;
import org.apache.pig.newplan.logical.expression.AndExpression;
import org.apache.pig.newplan.logical.expression.BinCondExpression;
import org.apache.pig.newplan.logical.expression.CastExpression;
import org.apache.pig.newplan.logical.expression.ConstantExpression;
import org.apache.pig.newplan.logical.expression.DereferenceExpression;
import org.apache.pig.newplan.logical.expression.DivideExpression;
import org.apache.pig.newplan.logical.expression.EqualExpression;
import org.apache.pig.newplan.logical.expression.GreaterThanEqualExpression;
import org.apache.pig.newplan.logical.expression.GreaterThanExpression;
import org.apache.pig.newplan.logical.expression.IsNullExpression;
import org.apache.pig.newplan.logical.expression.LessThanEqualExpression;
import org.apache.pig.newplan.logical.expression.LessThanExpression;
import org.apache.pig.newplan.logical.expression.LogicalExpression;
import org.apache.pig.newplan.logical.expression.LogicalExpressionPlan;
import org.apache.pig.newplan.logical.expression.MapLookupExpression;
import org.apache.pig.newplan.logical.expression.ModExpression;
import org.apache.pig.newplan.logical.expression.MultiplyExpression;
import org.apache.pig.newplan.logical.expression.NegativeExpression;
import org.apache.pig.newplan.logical.expression.NotEqualExpression;
import org.apache.pig.newplan.logical.expression.NotExpression;
import org.apache.pig.newplan.logical.expression.OrExpression;
import org.apache.pig.newplan.logical.expression.ProjectExpression;
import org.apache.pig.newplan.logical.expression.RegexExpression;
import org.apache.pig.newplan.logical.expression.ScalarExpression;
import org.apache.pig.newplan.logical.expression.SubtractExpression;
import org.apache.pig.newplan.logical.expression.UserFuncExpression;
import org.apache.pig.newplan.logical.relational.LOCogroup;
import org.apache.pig.newplan.logical.relational.LOFilter;
import org.apache.pig.newplan.logical.relational.LOForEach;
import org.apache.pig.newplan.logical.relational.LOGenerate;
import org.apache.pig.newplan.logical.relational.LOLimit;
import org.apache.pig.newplan.logical.relational.LOJoin;
import org.apache.pig.newplan.logical.relational.LOSort;
import org.apache.pig.newplan.logical.relational.LOSplitOutput;
import org.apache.pig.newplan.logical.relational.LogicalPlan;
import org.apache.pig.newplan.logical.relational.LogicalRelationalOperator;
import org.apache.pig.newplan.logical.relational.LogicalSchema;
import org.apache.pig.newplan.logical.relational.LogicalSchema.LogicalFieldSchema;
import org.apache.pig.newplan.logical.relational.LOCogroup.GROUPTYPE;
import org.apache.pig.newplan.logical.relational.LOJoin.JOINTYPE;
import org.apache.pig.FuncSpec;
import org.apache.pig.builtin.PigStreaming;
import org.apache.pig.data.DataBag;
import org.apache.pig.data.DataType;
import org.apache.pig.data.Tuple;
import java.util.Arrays;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;


/**
 * Grammar file for Pig tree parser (for schema alias validation).
 *
 * NOTE: THIS FILE IS BASED ON QueryParser.g, SO IF YOU CHANGE THAT FILE, YOU WILL 
 *       PROBABLY NEED TO MAKE CORRESPONDING CHANGES TO THIS FILE AS WELL.
 */
@SuppressWarnings({"all", "warnings", "unchecked"})
public class LogicalPlanGenerator extends TreeParser {
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

    protected static class GScope_scope {
        LogicalRelationalOperator currentOp;
    }
    protected Stack GScope_stack = new Stack();



    public LogicalPlanGenerator(TreeNodeStream input) {
        this(input, new RecognizerSharedState());
    }
    public LogicalPlanGenerator(TreeNodeStream input, RecognizerSharedState state) {
        super(input, state);
    }

protected TreeAdaptor adaptor = new CommonTreeAdaptor();

public void setTreeAdaptor(TreeAdaptor adaptor) {
    this.adaptor = adaptor;
}
public TreeAdaptor getTreeAdaptor() {
    return adaptor;
}
    public String[] getTokenNames() { return LogicalPlanGenerator.tokenNames; }
    public String getGrammarFileName() { return "/Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g"; }


    private static Log log = LogFactory.getLog( LogicalPlanGenerator.class );

    private LogicalPlanBuilder builder = null;

    private boolean inForeachPlan = false;

    private boolean inNestedCommand = false;

    public LogicalPlan getLogicalPlan() {
        return builder.getPlan();
    }

    public Map<String, Operator> getOperators() {
        return builder.getOperators();
    }

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

    public LogicalPlanGenerator(TreeNodeStream input, LogicalPlanBuilder builder) {
        this(input, new RecognizerSharedState());
        this.builder = builder;
    }

    public LogicalPlanGenerator(TreeNodeStream input, PigContext pigContext, String scope,
        Map<String, String> fileNameMap) {
        this( input );
        builder = new LogicalPlanBuilder( pigContext, scope, fileNameMap, input );
    }



    public static class query_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "query"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:149:1: query : ^( QUERY ( statement )* ) ;
    public final LogicalPlanGenerator.query_return query() throws RecognitionException {
        LogicalPlanGenerator.query_return retval = new LogicalPlanGenerator.query_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUERY1=null;
        LogicalPlanGenerator.statement_return statement2 =null;


        CommonTree QUERY1_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:149:7: ( ^( QUERY ( statement )* ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:149:9: ^( QUERY ( statement )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            QUERY1=(CommonTree)match(input,QUERY,FOLLOW_QUERY_in_query88); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUERY1_tree = (CommonTree)adaptor.dupNode(QUERY1);


            root_1 = (CommonTree)adaptor.becomeRoot(QUERY1_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:149:18: ( statement )*
                loop1:
                do {
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==SPLIT||LA1_0==REALIAS||LA1_0==STATEMENT) ) {
                        alt1=1;
                    }


                    switch (alt1) {
                	case 1 :
                	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:149:18: statement
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_statement_in_query90);
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


    protected static class statement_scope {
        String alias;
        Integer parallel;
        String inputAlias;
        int inputIndex;
    }
    protected Stack statement_stack = new Stack();


    public static class statement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "statement"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:152:1: statement : ( general_statement | split_statement | realias_statement );
    public final LogicalPlanGenerator.statement_return statement() throws RecognitionException {
        statement_stack.push(new statement_scope());
        LogicalPlanGenerator.statement_return retval = new LogicalPlanGenerator.statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.general_statement_return general_statement3 =null;

        LogicalPlanGenerator.split_statement_return split_statement4 =null;

        LogicalPlanGenerator.realias_statement_return realias_statement5 =null;




            ((statement_scope)statement_stack.peek()).inputIndex = 0;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:163:2: ( general_statement | split_statement | realias_statement )
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:163:4: general_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_general_statement_in_statement112);
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:164:4: split_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_split_statement_in_statement117);
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:165:4: realias_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_realias_statement_in_statement122);
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
            statement_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "statement"


    public static class split_statement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "split_statement"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:168:1: split_statement : split_clause ;
    public final LogicalPlanGenerator.split_statement_return split_statement() throws RecognitionException {
        LogicalPlanGenerator.split_statement_return retval = new LogicalPlanGenerator.split_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.split_clause_return split_clause6 =null;



        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:168:17: ( split_clause )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:168:19: split_clause
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_split_clause_in_split_statement131);
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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:171:1: realias_statement : realias_clause ;
    public final LogicalPlanGenerator.realias_statement_return realias_statement() throws RecognitionException {
        LogicalPlanGenerator.realias_statement_return retval = new LogicalPlanGenerator.realias_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.realias_clause_return realias_clause7 =null;



        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:171:19: ( realias_clause )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:171:21: realias_clause
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_realias_clause_in_realias_statement140);
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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:174:1: general_statement : ^( STATEMENT ( alias )? oa= op_clause ( parallel_clause )? ) ;
    public final LogicalPlanGenerator.general_statement_return general_statement() throws RecognitionException {
        LogicalPlanGenerator.general_statement_return retval = new LogicalPlanGenerator.general_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STATEMENT8=null;
        LogicalPlanGenerator.op_clause_return oa =null;

        LogicalPlanGenerator.alias_return alias9 =null;

        LogicalPlanGenerator.parallel_clause_return parallel_clause10 =null;


        CommonTree STATEMENT8_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:175:3: ( ^( STATEMENT ( alias )? oa= op_clause ( parallel_clause )? ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:175:3: ^( STATEMENT ( alias )? oa= op_clause ( parallel_clause )? )
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
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:175:16: ( alias )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==IDENTIFIER) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:175:18: alias
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_alias_in_general_statement156);
                    alias9=alias();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, alias9.getTree());


                    if ( state.backtracking==0 ) { ((statement_scope)statement_stack.peek()).alias = (alias9!=null?alias9.name:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_op_clause_in_general_statement167);
            oa=op_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, oa.getTree());


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:175:79: ( parallel_clause )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==PARALLEL) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:175:79: parallel_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_parallel_clause_in_general_statement169);
                    parallel_clause10=parallel_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, parallel_clause10.getTree());


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
                  Operator op = builder.lookupOperator( (oa!=null?oa.alias:null) );
                  builder.setParallel( (LogicalRelationalOperator)op, ((statement_scope)statement_stack.peek()).parallel );
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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:182:1: realias_clause : ^( REALIAS alias IDENTIFIER ) ;
    public final LogicalPlanGenerator.realias_clause_return realias_clause() throws RecognitionException {
        LogicalPlanGenerator.realias_clause_return retval = new LogicalPlanGenerator.realias_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree REALIAS11=null;
        CommonTree IDENTIFIER13=null;
        LogicalPlanGenerator.alias_return alias12 =null;


        CommonTree REALIAS11_tree=null;
        CommonTree IDENTIFIER13_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:183:3: ( ^( REALIAS alias IDENTIFIER ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:183:3: ^( REALIAS alias IDENTIFIER )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            REALIAS11=(CommonTree)match(input,REALIAS,FOLLOW_REALIAS_in_realias_clause186); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            REALIAS11_tree = (CommonTree)adaptor.dupNode(REALIAS11);


            root_1 = (CommonTree)adaptor.becomeRoot(REALIAS11_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_alias_in_realias_clause188);
            alias12=alias();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, alias12.getTree());


            _last = (CommonTree)input.LT(1);
            IDENTIFIER13=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_realias_clause190); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER13_tree = (CommonTree)adaptor.dupNode(IDENTIFIER13);


            adaptor.addChild(root_1, IDENTIFIER13_tree);
            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            	    Operator op = builder.lookupOperator( (IDENTIFIER13!=null?IDENTIFIER13.getText():null) );
            	    if (op==null) {
            	        throw new UndefinedAliasException(input, 
            	            new SourceLocation( (PigParserNode)IDENTIFIER13 ), (IDENTIFIER13!=null?IDENTIFIER13.getText():null));
            	    }
            	    builder.putOperator( (alias12!=null?alias12.name:null), (LogicalRelationalOperator)op );
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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:194:1: parallel_clause : ^( PARALLEL INTEGER ) ;
    public final LogicalPlanGenerator.parallel_clause_return parallel_clause() throws RecognitionException {
        LogicalPlanGenerator.parallel_clause_return retval = new LogicalPlanGenerator.parallel_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PARALLEL14=null;
        CommonTree INTEGER15=null;

        CommonTree PARALLEL14_tree=null;
        CommonTree INTEGER15_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:195:2: ( ^( PARALLEL INTEGER ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:195:4: ^( PARALLEL INTEGER )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            PARALLEL14=(CommonTree)match(input,PARALLEL,FOLLOW_PARALLEL_in_parallel_clause209); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PARALLEL14_tree = (CommonTree)adaptor.dupNode(PARALLEL14);


            root_1 = (CommonTree)adaptor.becomeRoot(PARALLEL14_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            INTEGER15=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_parallel_clause211); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            INTEGER15_tree = (CommonTree)adaptor.dupNode(INTEGER15);


            adaptor.addChild(root_1, INTEGER15_tree);
            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   ((statement_scope)statement_stack.peek()).parallel = Integer.parseInt( (INTEGER15!=null?INTEGER15.getText():null) );
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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "alias"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:201:1: alias returns [String name] : IDENTIFIER ;
    public final LogicalPlanGenerator.alias_return alias() throws RecognitionException {
        LogicalPlanGenerator.alias_return retval = new LogicalPlanGenerator.alias_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IDENTIFIER16=null;

        CommonTree IDENTIFIER16_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:201:27: ( IDENTIFIER )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:201:29: IDENTIFIER
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            IDENTIFIER16=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_alias229); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER16_tree = (CommonTree)adaptor.dupNode(IDENTIFIER16);


            adaptor.addChild(root_0, IDENTIFIER16_tree);
            }


            if ( state.backtracking==0 ) { retval.name = (IDENTIFIER16!=null?IDENTIFIER16.getText():null); }

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
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "op_clause"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:204:1: op_clause returns [String alias] : ( define_clause | load_clause | group_clause | store_clause | filter_clause | distinct_clause | limit_clause | sample_clause | order_clause | cross_clause | join_clause | union_clause | stream_clause | mr_clause | foreach_clause );
    public final LogicalPlanGenerator.op_clause_return op_clause() throws RecognitionException {
        LogicalPlanGenerator.op_clause_return retval = new LogicalPlanGenerator.op_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.define_clause_return define_clause17 =null;

        LogicalPlanGenerator.load_clause_return load_clause18 =null;

        LogicalPlanGenerator.group_clause_return group_clause19 =null;

        LogicalPlanGenerator.store_clause_return store_clause20 =null;

        LogicalPlanGenerator.filter_clause_return filter_clause21 =null;

        LogicalPlanGenerator.distinct_clause_return distinct_clause22 =null;

        LogicalPlanGenerator.limit_clause_return limit_clause23 =null;

        LogicalPlanGenerator.sample_clause_return sample_clause24 =null;

        LogicalPlanGenerator.order_clause_return order_clause25 =null;

        LogicalPlanGenerator.cross_clause_return cross_clause26 =null;

        LogicalPlanGenerator.join_clause_return join_clause27 =null;

        LogicalPlanGenerator.union_clause_return union_clause28 =null;

        LogicalPlanGenerator.stream_clause_return stream_clause29 =null;

        LogicalPlanGenerator.mr_clause_return mr_clause30 =null;

        LogicalPlanGenerator.foreach_clause_return foreach_clause31 =null;



        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:204:33: ( define_clause | load_clause | group_clause | store_clause | filter_clause | distinct_clause | limit_clause | sample_clause | order_clause | cross_clause | join_clause | union_clause | stream_clause | mr_clause | foreach_clause )
            int alt5=15;
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
            case FOREACH:
                {
                alt5=15;
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:205:13: define_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_define_clause_in_op_clause256);
                    define_clause17=define_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, define_clause17.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:206:13: load_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_load_clause_in_op_clause271);
                    load_clause18=load_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, load_clause18.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (load_clause18!=null?load_clause18.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:207:13: group_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_group_clause_in_op_clause287);
                    group_clause19=group_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, group_clause19.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (group_clause19!=null?group_clause19.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:208:13: store_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_store_clause_in_op_clause303);
                    store_clause20=store_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, store_clause20.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (store_clause20!=null?store_clause20.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:209:13: filter_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_filter_clause_in_op_clause319);
                    filter_clause21=filter_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, filter_clause21.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (filter_clause21!=null?filter_clause21.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:210:13: distinct_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_distinct_clause_in_op_clause335);
                    distinct_clause22=distinct_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, distinct_clause22.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (distinct_clause22!=null?distinct_clause22.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:211:13: limit_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_limit_clause_in_op_clause351);
                    limit_clause23=limit_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, limit_clause23.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (limit_clause23!=null?limit_clause23.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:212:13: sample_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_sample_clause_in_op_clause367);
                    sample_clause24=sample_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, sample_clause24.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (sample_clause24!=null?sample_clause24.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:213:13: order_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_order_clause_in_op_clause383);
                    order_clause25=order_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, order_clause25.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (order_clause25!=null?order_clause25.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:214:13: cross_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cross_clause_in_op_clause399);
                    cross_clause26=cross_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, cross_clause26.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (cross_clause26!=null?cross_clause26.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 11 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:215:13: join_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_clause_in_op_clause415);
                    join_clause27=join_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, join_clause27.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (join_clause27!=null?join_clause27.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 12 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:216:13: union_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_union_clause_in_op_clause431);
                    union_clause28=union_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, union_clause28.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (union_clause28!=null?union_clause28.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 13 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:217:13: stream_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_stream_clause_in_op_clause447);
                    stream_clause29=stream_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, stream_clause29.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (stream_clause29!=null?stream_clause29.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 14 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:218:13: mr_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_mr_clause_in_op_clause463);
                    mr_clause30=mr_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, mr_clause30.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (mr_clause30!=null?mr_clause30.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 15 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:219:13: foreach_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_foreach_clause_in_op_clause479);
                    foreach_clause31=foreach_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, foreach_clause31.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (foreach_clause31!=null?foreach_clause31.alias:null); }

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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:222:1: define_clause : ( ^( DEFINE alias cmd[$alias.name] ) | ^( DEFINE alias func_clause[FunctionType.UNKNOWNFUNC] ) );
    public final LogicalPlanGenerator.define_clause_return define_clause() throws RecognitionException {
        LogicalPlanGenerator.define_clause_return retval = new LogicalPlanGenerator.define_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DEFINE32=null;
        CommonTree DEFINE35=null;
        LogicalPlanGenerator.alias_return alias33 =null;

        LogicalPlanGenerator.cmd_return cmd34 =null;

        LogicalPlanGenerator.alias_return alias36 =null;

        LogicalPlanGenerator.func_clause_return func_clause37 =null;


        CommonTree DEFINE32_tree=null;
        CommonTree DEFINE35_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:223:2: ( ^( DEFINE alias cmd[$alias.name] ) | ^( DEFINE alias func_clause[FunctionType.UNKNOWNFUNC] ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==DEFINE) ) {
                int LA6_1 = input.LA(2);

                if ( (LA6_1==DOWN) ) {
                    int LA6_2 = input.LA(3);

                    if ( (LA6_2==IDENTIFIER) ) {
                        int LA6_3 = input.LA(4);

                        if ( (LA6_3==EXECCOMMAND) ) {
                            alt6=1;
                        }
                        else if ( (LA6_3==FUNC||LA6_3==FUNC_REF) ) {
                            alt6=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 6, 3, input);

                            throw nvae;

                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 6, 2, input);

                        throw nvae;

                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;

            }
            switch (alt6) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:223:4: ^( DEFINE alias cmd[$alias.name] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    DEFINE32=(CommonTree)match(input,DEFINE,FOLLOW_DEFINE_in_define_clause494); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DEFINE32_tree = (CommonTree)adaptor.dupNode(DEFINE32);


                    root_1 = (CommonTree)adaptor.becomeRoot(DEFINE32_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_alias_in_define_clause496);
                    alias33=alias();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, alias33.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cmd_in_define_clause498);
                    cmd34=cmd((alias33!=null?alias33.name:null));

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cmd34.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           builder.defineCommand( (alias33!=null?alias33.name:null), (cmd34!=null?cmd34.command:null) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:227:4: ^( DEFINE alias func_clause[FunctionType.UNKNOWNFUNC] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    DEFINE35=(CommonTree)match(input,DEFINE,FOLLOW_DEFINE_in_define_clause514); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DEFINE35_tree = (CommonTree)adaptor.dupNode(DEFINE35);


                    root_1 = (CommonTree)adaptor.becomeRoot(DEFINE35_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_alias_in_define_clause516);
                    alias36=alias();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, alias36.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_define_clause518);
                    func_clause37=func_clause(FunctionType.UNKNOWNFUNC);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause37.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           builder.defineFunction( (alias36!=null?alias36.name:null), (func_clause37!=null?func_clause37.funcSpec:null) );
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
    // $ANTLR end "define_clause"


    public static class cmd_return extends TreeRuleReturnScope {
        public StreamingCommand command;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cmd"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:233:1: cmd[String alias] returns [StreamingCommand command] : ^( EXECCOMMAND ( ship_clause[shipPaths] | cache_clause[cachePaths] | input_clause | output_clause | error_clause )* ) ;
    public final LogicalPlanGenerator.cmd_return cmd(String alias) throws RecognitionException {
        LogicalPlanGenerator.cmd_return retval = new LogicalPlanGenerator.cmd_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree EXECCOMMAND38=null;
        LogicalPlanGenerator.ship_clause_return ship_clause39 =null;

        LogicalPlanGenerator.cache_clause_return cache_clause40 =null;

        LogicalPlanGenerator.input_clause_return input_clause41 =null;

        LogicalPlanGenerator.output_clause_return output_clause42 =null;

        LogicalPlanGenerator.error_clause_return error_clause43 =null;


        CommonTree EXECCOMMAND38_tree=null;


            List<String> shipPaths = new ArrayList<String>();
            List<String> cachePaths = new ArrayList<String>();
            SourceLocation loc = new SourceLocation( (PigParserNode)((CommonTree)retval.start) );

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:239:2: ( ^( EXECCOMMAND ( ship_clause[shipPaths] | cache_clause[cachePaths] | input_clause | output_clause | error_clause )* ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:239:4: ^( EXECCOMMAND ( ship_clause[shipPaths] | cache_clause[cachePaths] | input_clause | output_clause | error_clause )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            EXECCOMMAND38=(CommonTree)match(input,EXECCOMMAND,FOLLOW_EXECCOMMAND_in_cmd547); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            EXECCOMMAND38_tree = (CommonTree)adaptor.dupNode(EXECCOMMAND38);


            root_1 = (CommonTree)adaptor.becomeRoot(EXECCOMMAND38_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:239:19: ( ship_clause[shipPaths] | cache_clause[cachePaths] | input_clause | output_clause | error_clause )*
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
                	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:239:21: ship_clause[shipPaths]
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_ship_clause_in_cmd551);
                	    ship_clause39=ship_clause(shipPaths);

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, ship_clause39.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;
                	case 2 :
                	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:239:46: cache_clause[cachePaths]
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_cache_clause_in_cmd556);
                	    cache_clause40=cache_clause(cachePaths);

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, cache_clause40.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;
                	case 3 :
                	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:239:73: input_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_input_clause_in_cmd561);
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
                	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:239:88: output_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_output_clause_in_cmd565);
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
                	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:239:104: error_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_error_clause_in_cmd569);
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
                   retval.command = builder.buildCommand( loc, builder.unquote( (EXECCOMMAND38!=null?EXECCOMMAND38.getText():null) ), shipPaths,
                       cachePaths, (input_clause41!=null?input_clause41.inputHandleSpecs:null), (output_clause42!=null?output_clause42.outputHandleSpecs:null),
                       (error_clause43!=null?error_clause43.dir:null), (error_clause43!=null?error_clause43.limit:null) );
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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:247:1: ship_clause[List<String> paths] : ^( SHIP ( path_list[$paths] )? ) ;
    public final LogicalPlanGenerator.ship_clause_return ship_clause(List<String> paths) throws RecognitionException {
        LogicalPlanGenerator.ship_clause_return retval = new LogicalPlanGenerator.ship_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SHIP44=null;
        LogicalPlanGenerator.path_list_return path_list45 =null;


        CommonTree SHIP44_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:248:2: ( ^( SHIP ( path_list[$paths] )? ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:248:4: ^( SHIP ( path_list[$paths] )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            SHIP44=(CommonTree)match(input,SHIP,FOLLOW_SHIP_in_ship_clause592); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SHIP44_tree = (CommonTree)adaptor.dupNode(SHIP44);


            root_1 = (CommonTree)adaptor.becomeRoot(SHIP44_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:248:12: ( path_list[$paths] )?
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==QUOTEDSTRING) ) {
                    alt8=1;
                }
                switch (alt8) {
                    case 1 :
                        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:248:12: path_list[$paths]
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_path_list_in_ship_clause594);
                        path_list45=path_list(paths);

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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:251:1: path_list[List<String> paths] : ( QUOTEDSTRING )+ ;
    public final LogicalPlanGenerator.path_list_return path_list(List<String> paths) throws RecognitionException {
        LogicalPlanGenerator.path_list_return retval = new LogicalPlanGenerator.path_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING46=null;

        CommonTree QUOTEDSTRING46_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:252:2: ( ( QUOTEDSTRING )+ )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:252:4: ( QUOTEDSTRING )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:252:4: ( QUOTEDSTRING )+
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
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:252:6: QUOTEDSTRING
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    QUOTEDSTRING46=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_path_list611); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    QUOTEDSTRING46_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING46);


            	    adaptor.addChild(root_0, QUOTEDSTRING46_tree);
            	    }


            	    if ( state.backtracking==0 ) { paths.add( builder.unquote( (QUOTEDSTRING46!=null?QUOTEDSTRING46.getText():null) ) ); }

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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:255:1: cache_clause[List<String> paths] : ^( CACHE path_list[$paths] ) ;
    public final LogicalPlanGenerator.cache_clause_return cache_clause(List<String> paths) throws RecognitionException {
        LogicalPlanGenerator.cache_clause_return retval = new LogicalPlanGenerator.cache_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CACHE47=null;
        LogicalPlanGenerator.path_list_return path_list48 =null;


        CommonTree CACHE47_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:256:2: ( ^( CACHE path_list[$paths] ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:256:4: ^( CACHE path_list[$paths] )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CACHE47=(CommonTree)match(input,CACHE,FOLLOW_CACHE_in_cache_clause629); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CACHE47_tree = (CommonTree)adaptor.dupNode(CACHE47);


            root_1 = (CommonTree)adaptor.becomeRoot(CACHE47_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_path_list_in_cache_clause631);
            path_list48=path_list(paths);

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
        public List<HandleSpec> inputHandleSpecs;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "input_clause"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:259:1: input_clause returns [List<HandleSpec> inputHandleSpecs] : ^( INPUT ( stream_cmd[true] )+ ) ;
    public final LogicalPlanGenerator.input_clause_return input_clause() throws RecognitionException {
        LogicalPlanGenerator.input_clause_return retval = new LogicalPlanGenerator.input_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree INPUT49=null;
        LogicalPlanGenerator.stream_cmd_return stream_cmd50 =null;


        CommonTree INPUT49_tree=null;


            retval.inputHandleSpecs = new ArrayList<HandleSpec>();

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:263:2: ( ^( INPUT ( stream_cmd[true] )+ ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:263:4: ^( INPUT ( stream_cmd[true] )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            INPUT49=(CommonTree)match(input,INPUT,FOLLOW_INPUT_in_input_clause654); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            INPUT49_tree = (CommonTree)adaptor.dupNode(INPUT49);


            root_1 = (CommonTree)adaptor.becomeRoot(INPUT49_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:263:13: ( stream_cmd[true] )+
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
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:263:15: stream_cmd[true]
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_stream_cmd_in_input_clause658);
            	    stream_cmd50=stream_cmd(true);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, stream_cmd50.getTree());


            	    if ( state.backtracking==0 ) { retval.inputHandleSpecs.add( (stream_cmd50!=null?stream_cmd50.handleSpec:null) ); }

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
        public HandleSpec handleSpec;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "stream_cmd"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:266:1: stream_cmd[boolean in] returns [HandleSpec handleSpec] : ( ^( STDIN ( func_clause[ft] )? ) | ^( STDOUT ( func_clause[ft] )? ) | ^( QUOTEDSTRING ( func_clause[ft] )? ) );
    public final LogicalPlanGenerator.stream_cmd_return stream_cmd(boolean in) throws RecognitionException {
        LogicalPlanGenerator.stream_cmd_return retval = new LogicalPlanGenerator.stream_cmd_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STDIN51=null;
        CommonTree STDOUT53=null;
        CommonTree QUOTEDSTRING55=null;
        LogicalPlanGenerator.func_clause_return func_clause52 =null;

        LogicalPlanGenerator.func_clause_return func_clause54 =null;

        LogicalPlanGenerator.func_clause_return func_clause56 =null;


        CommonTree STDIN51_tree=null;
        CommonTree STDOUT53_tree=null;
        CommonTree QUOTEDSTRING55_tree=null;


            String handleName = null;
            FuncSpec fs = null;
            String deserializer = PigStreaming.class.getName() + "()";
            byte ft = in ? FunctionType.PIGTOSTREAMFUNC : FunctionType.STREAMTOPIGFUNC;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:278:2: ( ^( STDIN ( func_clause[ft] )? ) | ^( STDOUT ( func_clause[ft] )? ) | ^( QUOTEDSTRING ( func_clause[ft] )? ) )
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:278:4: ^( STDIN ( func_clause[ft] )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    STDIN51=(CommonTree)match(input,STDIN,FOLLOW_STDIN_in_stream_cmd692); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDIN51_tree = (CommonTree)adaptor.dupNode(STDIN51);


                    root_1 = (CommonTree)adaptor.becomeRoot(STDIN51_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { handleName = "stdin"; }

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
                        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:279:7: ( func_clause[ft] )?
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==FUNC||LA11_0==FUNC_REF) ) {
                            alt11=1;
                        }
                        switch (alt11) {
                            case 1 :
                                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:279:9: func_clause[ft]
                                {
                                _last = (CommonTree)input.LT(1);
                                pushFollow(FOLLOW_func_clause_in_stream_cmd704);
                                func_clause52=func_clause(ft);

                                state._fsp--;
                                if (state.failed) return retval;
                                if ( state.backtracking==0 ) 
                                adaptor.addChild(root_1, func_clause52.getTree());


                                if ( state.backtracking==0 ) { fs = (func_clause52!=null?func_clause52.funcSpec:null); }

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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:280:4: ^( STDOUT ( func_clause[ft] )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    STDOUT53=(CommonTree)match(input,STDOUT,FOLLOW_STDOUT_in_stream_cmd719); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDOUT53_tree = (CommonTree)adaptor.dupNode(STDOUT53);


                    root_1 = (CommonTree)adaptor.becomeRoot(STDOUT53_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { handleName = "stdout"; }

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
                        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:281:7: ( func_clause[ft] )?
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==FUNC||LA12_0==FUNC_REF) ) {
                            alt12=1;
                        }
                        switch (alt12) {
                            case 1 :
                                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:281:9: func_clause[ft]
                                {
                                _last = (CommonTree)input.LT(1);
                                pushFollow(FOLLOW_func_clause_in_stream_cmd731);
                                func_clause54=func_clause(ft);

                                state._fsp--;
                                if (state.failed) return retval;
                                if ( state.backtracking==0 ) 
                                adaptor.addChild(root_1, func_clause54.getTree());


                                if ( state.backtracking==0 ) { fs = (func_clause54!=null?func_clause54.funcSpec:null); }

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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:282:4: ^( QUOTEDSTRING ( func_clause[ft] )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    QUOTEDSTRING55=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_stream_cmd746); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    QUOTEDSTRING55_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING55);


                    root_1 = (CommonTree)adaptor.becomeRoot(QUOTEDSTRING55_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { handleName = builder.unquote( (QUOTEDSTRING55!=null?QUOTEDSTRING55.getText():null) ); }

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
                        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:283:7: ( func_clause[ft] )?
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==FUNC||LA13_0==FUNC_REF) ) {
                            alt13=1;
                        }
                        switch (alt13) {
                            case 1 :
                                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:283:9: func_clause[ft]
                                {
                                _last = (CommonTree)input.LT(1);
                                pushFollow(FOLLOW_func_clause_in_stream_cmd758);
                                func_clause56=func_clause(ft);

                                state._fsp--;
                                if (state.failed) return retval;
                                if ( state.backtracking==0 ) 
                                adaptor.addChild(root_1, func_clause56.getTree());


                                if ( state.backtracking==0 ) { fs = (func_clause56!=null?func_clause56.funcSpec:null); }

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

            if ( state.backtracking==0 ) {
                if( fs != null )
                    deserializer =  fs.toString();
                retval.handleSpec = new HandleSpec( handleName, deserializer );
            }
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
        public List<HandleSpec> outputHandleSpecs;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "output_clause"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:286:1: output_clause returns [List<HandleSpec> outputHandleSpecs] : ^( OUTPUT ( stream_cmd[false] )+ ) ;
    public final LogicalPlanGenerator.output_clause_return output_clause() throws RecognitionException {
        LogicalPlanGenerator.output_clause_return retval = new LogicalPlanGenerator.output_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree OUTPUT57=null;
        LogicalPlanGenerator.stream_cmd_return stream_cmd58 =null;


        CommonTree OUTPUT57_tree=null;


            retval.outputHandleSpecs = new ArrayList<HandleSpec>();

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:290:2: ( ^( OUTPUT ( stream_cmd[false] )+ ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:290:4: ^( OUTPUT ( stream_cmd[false] )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            OUTPUT57=(CommonTree)match(input,OUTPUT,FOLLOW_OUTPUT_in_output_clause786); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            OUTPUT57_tree = (CommonTree)adaptor.dupNode(OUTPUT57);


            root_1 = (CommonTree)adaptor.becomeRoot(OUTPUT57_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:290:14: ( stream_cmd[false] )+
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
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:290:16: stream_cmd[false]
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_stream_cmd_in_output_clause790);
            	    stream_cmd58=stream_cmd(false);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, stream_cmd58.getTree());


            	    if ( state.backtracking==0 ) { retval.outputHandleSpecs.add( (stream_cmd58!=null?stream_cmd58.handleSpec:null) ); }

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
        public String dir;
        public Integer limit;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "error_clause"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:293:1: error_clause returns [String dir, Integer limit] : ^( STDERROR ( QUOTEDSTRING ( INTEGER )? )? ) ;
    public final LogicalPlanGenerator.error_clause_return error_clause() throws RecognitionException {
        LogicalPlanGenerator.error_clause_return retval = new LogicalPlanGenerator.error_clause_return();
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


            retval.limit = StreamingCommand.MAX_TASKS;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:297:2: ( ^( STDERROR ( QUOTEDSTRING ( INTEGER )? )? ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:297:4: ^( STDERROR ( QUOTEDSTRING ( INTEGER )? )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            STDERROR59=(CommonTree)match(input,STDERROR,FOLLOW_STDERROR_in_error_clause818); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STDERROR59_tree = (CommonTree)adaptor.dupNode(STDERROR59);


            root_1 = (CommonTree)adaptor.becomeRoot(STDERROR59_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:298:7: ( QUOTEDSTRING ( INTEGER )? )?
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==QUOTEDSTRING) ) {
                    alt17=1;
                }
                switch (alt17) {
                    case 1 :
                        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:298:9: QUOTEDSTRING ( INTEGER )?
                        {
                        _last = (CommonTree)input.LT(1);
                        QUOTEDSTRING60=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_error_clause829); if (state.failed) return retval;
                        if ( state.backtracking==0 ) {
                        QUOTEDSTRING60_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING60);


                        adaptor.addChild(root_1, QUOTEDSTRING60_tree);
                        }


                        if ( state.backtracking==0 ) {
                                    retval.dir = builder.unquote( (QUOTEDSTRING60!=null?QUOTEDSTRING60.getText():null) );
                                }

                        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:302:9: ( INTEGER )?
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==INTEGER) ) {
                            alt16=1;
                        }
                        switch (alt16) {
                            case 1 :
                                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:302:11: INTEGER
                                {
                                _last = (CommonTree)input.LT(1);
                                INTEGER61=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_error_clause852); if (state.failed) return retval;
                                if ( state.backtracking==0 ) {
                                INTEGER61_tree = (CommonTree)adaptor.dupNode(INTEGER61);


                                adaptor.addChild(root_1, INTEGER61_tree);
                                }


                                if ( state.backtracking==0 ) { 
                                              retval.limit = Integer.parseInt( (INTEGER61!=null?INTEGER61.getText():null) );
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
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "load_clause"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:311:1: load_clause returns [String alias] : ^( LOAD filename ( func_clause[FunctionType.LOADFUNC] )? ( as_clause )? ) ;
    public final LogicalPlanGenerator.load_clause_return load_clause() throws RecognitionException {
        LogicalPlanGenerator.load_clause_return retval = new LogicalPlanGenerator.load_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree LOAD62=null;
        LogicalPlanGenerator.filename_return filename63 =null;

        LogicalPlanGenerator.func_clause_return func_clause64 =null;

        LogicalPlanGenerator.as_clause_return as_clause65 =null;


        CommonTree LOAD62_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:312:2: ( ^( LOAD filename ( func_clause[FunctionType.LOADFUNC] )? ( as_clause )? ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:312:4: ^( LOAD filename ( func_clause[FunctionType.LOADFUNC] )? ( as_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            LOAD62=(CommonTree)match(input,LOAD,FOLLOW_LOAD_in_load_clause906); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LOAD62_tree = (CommonTree)adaptor.dupNode(LOAD62);


            root_1 = (CommonTree)adaptor.becomeRoot(LOAD62_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_filename_in_load_clause908);
            filename63=filename();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, filename63.getTree());


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:312:21: ( func_clause[FunctionType.LOADFUNC] )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==FUNC||LA18_0==FUNC_REF) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:312:21: func_clause[FunctionType.LOADFUNC]
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_load_clause910);
                    func_clause64=func_clause(FunctionType.LOADFUNC);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause64.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:312:57: ( as_clause )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==AS) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:312:57: as_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_as_clause_in_load_clause914);
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
                  SourceLocation loc = new SourceLocation( (PigParserNode)((CommonTree)retval.start) );
                  retval.alias = builder.buildLoadOp( loc, ((statement_scope)statement_stack.peek()).alias,
                      (filename63!=null?filename63.filename:null), (func_clause64!=null?func_clause64.funcSpec:null), (as_clause65!=null?as_clause65.logicalSchema:null)  );
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
        public String filename;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "filename"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:320:1: filename returns [String filename] : QUOTEDSTRING ;
    public final LogicalPlanGenerator.filename_return filename() throws RecognitionException {
        LogicalPlanGenerator.filename_return retval = new LogicalPlanGenerator.filename_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING66=null;

        CommonTree QUOTEDSTRING66_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:321:2: ( QUOTEDSTRING )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:321:4: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING66=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_filename934); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING66_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING66);


            adaptor.addChild(root_0, QUOTEDSTRING66_tree);
            }


            if ( state.backtracking==0 ) { retval.filename = builder.unquote( (QUOTEDSTRING66!=null?QUOTEDSTRING66.getText():null) ); }

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
        public LogicalSchema logicalSchema;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "as_clause"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:324:1: as_clause returns [LogicalSchema logicalSchema] : ^( AS field_def_list ) ;
    public final LogicalPlanGenerator.as_clause_return as_clause() throws RecognitionException {
        LogicalPlanGenerator.as_clause_return retval = new LogicalPlanGenerator.as_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree AS67=null;
        LogicalPlanGenerator.field_def_list_return field_def_list68 =null;


        CommonTree AS67_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:325:2: ( ^( AS field_def_list ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:325:4: ^( AS field_def_list )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            AS67=(CommonTree)match(input,AS,FOLLOW_AS_in_as_clause951); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            AS67_tree = (CommonTree)adaptor.dupNode(AS67);


            root_1 = (CommonTree)adaptor.becomeRoot(AS67_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_field_def_list_in_as_clause953);
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
                    LogicalPlanBuilder.setBytearrayForNULLType((field_def_list68!=null?field_def_list68.schema:null));
                    retval.logicalSchema = (field_def_list68!=null?field_def_list68.schema:null); 
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
        public LogicalFieldSchema fieldSchema;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "field_def"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:332:1: field_def returns [LogicalFieldSchema fieldSchema] : ^( FIELD_DEF IDENTIFIER ( type )? ) ;
    public final LogicalPlanGenerator.field_def_return field_def() throws RecognitionException {
        LogicalPlanGenerator.field_def_return retval = new LogicalPlanGenerator.field_def_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FIELD_DEF69=null;
        CommonTree IDENTIFIER70=null;
        LogicalPlanGenerator.type_return type71 =null;


        CommonTree FIELD_DEF69_tree=null;
        CommonTree IDENTIFIER70_tree=null;


            byte datatype = DataType.NULL;          

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:336:2: ( ^( FIELD_DEF IDENTIFIER ( type )? ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:336:4: ^( FIELD_DEF IDENTIFIER ( type )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FIELD_DEF69=(CommonTree)match(input,FIELD_DEF,FOLLOW_FIELD_DEF_in_field_def981); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FIELD_DEF69_tree = (CommonTree)adaptor.dupNode(FIELD_DEF69);


            root_1 = (CommonTree)adaptor.becomeRoot(FIELD_DEF69_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            IDENTIFIER70=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_field_def983); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER70_tree = (CommonTree)adaptor.dupNode(IDENTIFIER70);


            adaptor.addChild(root_1, IDENTIFIER70_tree);
            }


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:336:28: ( type )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==BOOLEAN||LA20_0==BYTEARRAY||LA20_0==CHARARRAY||LA20_0==DOUBLE||LA20_0==FLOAT||LA20_0==INT||LA20_0==LONG||LA20_0==BAG_TYPE||LA20_0==MAP_TYPE||LA20_0==TUPLE_TYPE) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:336:30: type
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_type_in_field_def987);
                    type71=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, type71.getTree());


                    if ( state.backtracking==0 ) { datatype = (type71!=null?type71.datatype:null);}

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
                       retval.fieldSchema = new LogicalFieldSchema( (IDENTIFIER70!=null?IDENTIFIER70.getText():null), (type71!=null?type71.logicalSchema:null), datatype );
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
        public LogicalSchema schema;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "field_def_list"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:342:1: field_def_list returns [LogicalSchema schema] : ( field_def )+ ;
    public final LogicalPlanGenerator.field_def_list_return field_def_list() throws RecognitionException {
        LogicalPlanGenerator.field_def_list_return retval = new LogicalPlanGenerator.field_def_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.field_def_return field_def72 =null;




            retval.schema = new LogicalSchema();

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:346:2: ( ( field_def )+ )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:346:4: ( field_def )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:346:4: ( field_def )+
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
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:346:6: field_def
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_field_def_in_field_def_list1019);
            	    field_def72=field_def();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, field_def72.getTree());


            	    if ( state.backtracking==0 ) { retval.schema.addField( (field_def72!=null?field_def72.fieldSchema:null) ); }

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
        public Byte datatype;
        public LogicalSchema logicalSchema;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "type"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:350:1: type returns [Byte datatype, LogicalSchema logicalSchema] : ( simple_type | tuple_type | bag_type | map_type );
    public final LogicalPlanGenerator.type_return type() throws RecognitionException {
        LogicalPlanGenerator.type_return retval = new LogicalPlanGenerator.type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.simple_type_return simple_type73 =null;

        LogicalPlanGenerator.tuple_type_return tuple_type74 =null;

        LogicalPlanGenerator.bag_type_return bag_type75 =null;

        LogicalPlanGenerator.map_type_return map_type76 =null;



        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:351:2: ( simple_type | tuple_type | bag_type | map_type )
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:351:4: simple_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_simple_type_in_type1038);
                    simple_type73=simple_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, simple_type73.getTree());


                    if ( state.backtracking==0 ) {
                            retval.datatype = (simple_type73!=null?simple_type73.datatype:0);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:355:4: tuple_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_tuple_type_in_type1048);
                    tuple_type74=tuple_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, tuple_type74.getTree());


                    if ( state.backtracking==0 ) {
                           retval.datatype = DataType.TUPLE;
                           retval.logicalSchema = (tuple_type74!=null?tuple_type74.logicalSchema:null);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:360:4: bag_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_bag_type_in_type1058);
                    bag_type75=bag_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, bag_type75.getTree());


                    if ( state.backtracking==0 ) {
                           retval.datatype = DataType.BAG;
                           retval.logicalSchema = (bag_type75!=null?bag_type75.logicalSchema:null);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:365:4: map_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_map_type_in_type1068);
                    map_type76=map_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, map_type76.getTree());


                    if ( state.backtracking==0 ) {
                           retval.datatype = DataType.MAP;
                           retval.logicalSchema = (map_type76!=null?map_type76.logicalSchema:null);
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
    // $ANTLR end "type"


    public static class simple_type_return extends TreeRuleReturnScope {
        public byte datatype;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "simple_type"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:372:1: simple_type returns [byte datatype] : ( BOOLEAN | INT | LONG | FLOAT | DOUBLE | CHARARRAY | BYTEARRAY );
    public final LogicalPlanGenerator.simple_type_return simple_type() throws RecognitionException {
        LogicalPlanGenerator.simple_type_return retval = new LogicalPlanGenerator.simple_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BOOLEAN77=null;
        CommonTree INT78=null;
        CommonTree LONG79=null;
        CommonTree FLOAT80=null;
        CommonTree DOUBLE81=null;
        CommonTree CHARARRAY82=null;
        CommonTree BYTEARRAY83=null;

        CommonTree BOOLEAN77_tree=null;
        CommonTree INT78_tree=null;
        CommonTree LONG79_tree=null;
        CommonTree FLOAT80_tree=null;
        CommonTree DOUBLE81_tree=null;
        CommonTree CHARARRAY82_tree=null;
        CommonTree BYTEARRAY83_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:373:2: ( BOOLEAN | INT | LONG | FLOAT | DOUBLE | CHARARRAY | BYTEARRAY )
            int alt23=7;
            switch ( input.LA(1) ) {
            case BOOLEAN:
                {
                alt23=1;
                }
                break;
            case INT:
                {
                alt23=2;
                }
                break;
            case LONG:
                {
                alt23=3;
                }
                break;
            case FLOAT:
                {
                alt23=4;
                }
                break;
            case DOUBLE:
                {
                alt23=5;
                }
                break;
            case CHARARRAY:
                {
                alt23=6;
                }
                break;
            case BYTEARRAY:
                {
                alt23=7;
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:373:4: BOOLEAN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BOOLEAN77=(CommonTree)match(input,BOOLEAN,FOLLOW_BOOLEAN_in_simple_type1086); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BOOLEAN77_tree = (CommonTree)adaptor.dupNode(BOOLEAN77);


                    adaptor.addChild(root_0, BOOLEAN77_tree);
                    }


                    if ( state.backtracking==0 ) { retval.datatype = DataType.BOOLEAN; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:374:4: INT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INT78=(CommonTree)match(input,INT,FOLLOW_INT_in_simple_type1093); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INT78_tree = (CommonTree)adaptor.dupNode(INT78);


                    adaptor.addChild(root_0, INT78_tree);
                    }


                    if ( state.backtracking==0 ) { retval.datatype = DataType.INTEGER; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:375:4: LONG
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LONG79=(CommonTree)match(input,LONG,FOLLOW_LONG_in_simple_type1100); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LONG79_tree = (CommonTree)adaptor.dupNode(LONG79);


                    adaptor.addChild(root_0, LONG79_tree);
                    }


                    if ( state.backtracking==0 ) { retval.datatype = DataType.LONG; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:376:4: FLOAT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FLOAT80=(CommonTree)match(input,FLOAT,FOLLOW_FLOAT_in_simple_type1107); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FLOAT80_tree = (CommonTree)adaptor.dupNode(FLOAT80);


                    adaptor.addChild(root_0, FLOAT80_tree);
                    }


                    if ( state.backtracking==0 ) { retval.datatype = DataType.FLOAT; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:377:4: DOUBLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DOUBLE81=(CommonTree)match(input,DOUBLE,FOLLOW_DOUBLE_in_simple_type1114); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DOUBLE81_tree = (CommonTree)adaptor.dupNode(DOUBLE81);


                    adaptor.addChild(root_0, DOUBLE81_tree);
                    }


                    if ( state.backtracking==0 ) { retval.datatype = DataType.DOUBLE; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:378:4: CHARARRAY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CHARARRAY82=(CommonTree)match(input,CHARARRAY,FOLLOW_CHARARRAY_in_simple_type1121); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CHARARRAY82_tree = (CommonTree)adaptor.dupNode(CHARARRAY82);


                    adaptor.addChild(root_0, CHARARRAY82_tree);
                    }


                    if ( state.backtracking==0 ) { retval.datatype = DataType.CHARARRAY; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:379:4: BYTEARRAY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BYTEARRAY83=(CommonTree)match(input,BYTEARRAY,FOLLOW_BYTEARRAY_in_simple_type1128); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BYTEARRAY83_tree = (CommonTree)adaptor.dupNode(BYTEARRAY83);


                    adaptor.addChild(root_0, BYTEARRAY83_tree);
                    }


                    if ( state.backtracking==0 ) { retval.datatype = DataType.BYTEARRAY; }

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
        public LogicalSchema logicalSchema;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "tuple_type"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:382:1: tuple_type returns [LogicalSchema logicalSchema] : ^( TUPLE_TYPE ( field_def_list )? ) ;
    public final LogicalPlanGenerator.tuple_type_return tuple_type() throws RecognitionException {
        LogicalPlanGenerator.tuple_type_return retval = new LogicalPlanGenerator.tuple_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree TUPLE_TYPE84=null;
        LogicalPlanGenerator.field_def_list_return field_def_list85 =null;


        CommonTree TUPLE_TYPE84_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:383:2: ( ^( TUPLE_TYPE ( field_def_list )? ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:383:4: ^( TUPLE_TYPE ( field_def_list )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            TUPLE_TYPE84=(CommonTree)match(input,TUPLE_TYPE,FOLLOW_TUPLE_TYPE_in_tuple_type1145); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            TUPLE_TYPE84_tree = (CommonTree)adaptor.dupNode(TUPLE_TYPE84);


            root_1 = (CommonTree)adaptor.becomeRoot(TUPLE_TYPE84_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:384:7: ( field_def_list )?
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==FIELD_DEF) ) {
                    alt24=1;
                }
                switch (alt24) {
                    case 1 :
                        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:384:9: field_def_list
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_field_def_list_in_tuple_type1156);
                        field_def_list85=field_def_list();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, field_def_list85.getTree());


                        if ( state.backtracking==0 ) { 
                                    LogicalPlanBuilder.setBytearrayForNULLType((field_def_list85!=null?field_def_list85.schema:null));
                                    retval.logicalSchema = (field_def_list85!=null?field_def_list85.schema:null);
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
    // $ANTLR end "tuple_type"


    public static class bag_type_return extends TreeRuleReturnScope {
        public LogicalSchema logicalSchema;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "bag_type"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:393:1: bag_type returns [LogicalSchema logicalSchema] : ^( BAG_TYPE ( IDENTIFIER )? ( tuple_type )? ) ;
    public final LogicalPlanGenerator.bag_type_return bag_type() throws RecognitionException {
        LogicalPlanGenerator.bag_type_return retval = new LogicalPlanGenerator.bag_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BAG_TYPE86=null;
        CommonTree IDENTIFIER87=null;
        LogicalPlanGenerator.tuple_type_return tuple_type88 =null;


        CommonTree BAG_TYPE86_tree=null;
        CommonTree IDENTIFIER87_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:394:2: ( ^( BAG_TYPE ( IDENTIFIER )? ( tuple_type )? ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:394:4: ^( BAG_TYPE ( IDENTIFIER )? ( tuple_type )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BAG_TYPE86=(CommonTree)match(input,BAG_TYPE,FOLLOW_BAG_TYPE_in_bag_type1196); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BAG_TYPE86_tree = (CommonTree)adaptor.dupNode(BAG_TYPE86);


            root_1 = (CommonTree)adaptor.becomeRoot(BAG_TYPE86_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:394:16: ( IDENTIFIER )?
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==IDENTIFIER) ) {
                    alt25=1;
                }
                switch (alt25) {
                    case 1 :
                        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:394:16: IDENTIFIER
                        {
                        _last = (CommonTree)input.LT(1);
                        IDENTIFIER87=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_bag_type1198); if (state.failed) return retval;
                        if ( state.backtracking==0 ) {
                        IDENTIFIER87_tree = (CommonTree)adaptor.dupNode(IDENTIFIER87);


                        adaptor.addChild(root_1, IDENTIFIER87_tree);
                        }


                        if ( state.backtracking==0 ) {
                        }
                        }
                        break;

                }


                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:394:28: ( tuple_type )?
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==TUPLE_TYPE) ) {
                    alt26=1;
                }
                switch (alt26) {
                    case 1 :
                        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:394:28: tuple_type
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_tuple_type_in_bag_type1201);
                        tuple_type88=tuple_type();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, tuple_type88.getTree());


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
                   if ((tuple_type88!=null?tuple_type88.logicalSchema:null)!=null && (tuple_type88!=null?tuple_type88.logicalSchema:null).size()==1 && (tuple_type88!=null?tuple_type88.logicalSchema:null).getField(0).type==DataType.TUPLE) {
                       retval.logicalSchema = (tuple_type88!=null?tuple_type88.logicalSchema:null);
                   }
                   else {
                       LogicalSchema s = new LogicalSchema();
                       s.addField(new LogicalFieldSchema((IDENTIFIER87!=null?IDENTIFIER87.getText():null), (tuple_type88!=null?tuple_type88.logicalSchema:null), DataType.TUPLE));
                       retval.logicalSchema = s;
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
    // $ANTLR end "bag_type"


    public static class map_type_return extends TreeRuleReturnScope {
        public LogicalSchema logicalSchema;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "map_type"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:407:1: map_type returns [LogicalSchema logicalSchema] : ^( MAP_TYPE ( type )? ) ;
    public final LogicalPlanGenerator.map_type_return map_type() throws RecognitionException {
        LogicalPlanGenerator.map_type_return retval = new LogicalPlanGenerator.map_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MAP_TYPE89=null;
        LogicalPlanGenerator.type_return type90 =null;


        CommonTree MAP_TYPE89_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:408:2: ( ^( MAP_TYPE ( type )? ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:408:4: ^( MAP_TYPE ( type )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            MAP_TYPE89=(CommonTree)match(input,MAP_TYPE,FOLLOW_MAP_TYPE_in_map_type1224); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            MAP_TYPE89_tree = (CommonTree)adaptor.dupNode(MAP_TYPE89);


            root_1 = (CommonTree)adaptor.becomeRoot(MAP_TYPE89_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:408:16: ( type )?
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==BOOLEAN||LA27_0==BYTEARRAY||LA27_0==CHARARRAY||LA27_0==DOUBLE||LA27_0==FLOAT||LA27_0==INT||LA27_0==LONG||LA27_0==BAG_TYPE||LA27_0==MAP_TYPE||LA27_0==TUPLE_TYPE) ) {
                    alt27=1;
                }
                switch (alt27) {
                    case 1 :
                        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:408:16: type
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_type_in_map_type1226);
                        type90=type();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, type90.getTree());


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
                   LogicalSchema s = null;
                   if( (type90!=null?type90.datatype:null) != null ) {
                       s = new LogicalSchema();
                       s.addField( new LogicalFieldSchema( null, (type90!=null?type90.logicalSchema:null), (type90!=null?type90.datatype:null) ) );
                   }
                   retval.logicalSchema = s;
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
        public FuncSpec funcSpec;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "func_clause"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:419:1: func_clause[byte ft] returns [FuncSpec funcSpec] : ( ^( FUNC_REF func_name ) | ^( FUNC func_name ( func_args )? ) );
    public final LogicalPlanGenerator.func_clause_return func_clause(byte ft) throws RecognitionException {
        LogicalPlanGenerator.func_clause_return retval = new LogicalPlanGenerator.func_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FUNC_REF91=null;
        CommonTree FUNC93=null;
        LogicalPlanGenerator.func_name_return func_name92 =null;

        LogicalPlanGenerator.func_name_return func_name94 =null;

        LogicalPlanGenerator.func_args_return func_args95 =null;


        CommonTree FUNC_REF91_tree=null;
        CommonTree FUNC93_tree=null;


            SourceLocation loc = new SourceLocation( (PigParserNode)((CommonTree)retval.start) );

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:423:2: ( ^( FUNC_REF func_name ) | ^( FUNC func_name ( func_args )? ) )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==FUNC_REF) ) {
                alt29=1;
            }
            else if ( (LA29_0==FUNC) ) {
                alt29=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;

            }
            switch (alt29) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:423:4: ^( FUNC_REF func_name )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FUNC_REF91=(CommonTree)match(input,FUNC_REF,FOLLOW_FUNC_REF_in_func_clause1255); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FUNC_REF91_tree = (CommonTree)adaptor.dupNode(FUNC_REF91);


                    root_1 = (CommonTree)adaptor.becomeRoot(FUNC_REF91_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_name_in_func_clause1257);
                    func_name92=func_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_name92.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.funcSpec = builder.lookupFunction( (func_name92!=null?func_name92.funcName:null) );
                           if( retval.funcSpec == null )
                               retval.funcSpec = builder.buildFuncSpec( loc, (func_name92!=null?func_name92.funcName:null), new ArrayList<String>(), ft );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:429:4: ^( FUNC func_name ( func_args )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FUNC93=(CommonTree)match(input,FUNC,FOLLOW_FUNC_in_func_clause1271); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FUNC93_tree = (CommonTree)adaptor.dupNode(FUNC93);


                    root_1 = (CommonTree)adaptor.becomeRoot(FUNC93_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_name_in_func_clause1273);
                    func_name94=func_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_name94.getTree());


                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:429:22: ( func_args )?
                    int alt28=2;
                    int LA28_0 = input.LA(1);

                    if ( (LA28_0==MULTILINE_QUOTEDSTRING||LA28_0==QUOTEDSTRING) ) {
                        alt28=1;
                    }
                    switch (alt28) {
                        case 1 :
                            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:429:22: func_args
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_func_args_in_func_clause1275);
                            func_args95=func_args();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_1, func_args95.getTree());


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
                           retval.funcSpec = builder.lookupFunction( (func_name94!=null?func_name94.funcName:null) );
                           if( retval.funcSpec == null ) {
                               List<String> argList = new ArrayList<String>();
                               if( (func_args95!=null?func_args95.args:null) != null )
                                   argList = (func_args95!=null?func_args95.args:null);
                               retval.funcSpec = builder.buildFuncSpec( loc, (func_name94!=null?func_name94.funcName:null), argList, ft );
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
    // $ANTLR end "func_clause"


    public static class func_name_return extends TreeRuleReturnScope {
        public String funcName;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "func_name"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:441:1: func_name returns [String funcName] : p1= eid ( ( PERIOD | DOLLAR ) p2= eid )* ;
    public final LogicalPlanGenerator.func_name_return func_name() throws RecognitionException {
        LogicalPlanGenerator.func_name_return retval = new LogicalPlanGenerator.func_name_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PERIOD96=null;
        CommonTree DOLLAR97=null;
        LogicalPlanGenerator.eid_return p1 =null;

        LogicalPlanGenerator.eid_return p2 =null;


        CommonTree PERIOD96_tree=null;
        CommonTree DOLLAR97_tree=null;

         StringBuilder buf = new StringBuilder(); 
        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:443:2: (p1= eid ( ( PERIOD | DOLLAR ) p2= eid )* )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:443:4: p1= eid ( ( PERIOD | DOLLAR ) p2= eid )*
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_eid_in_func_name1306);
            p1=eid();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, p1.getTree());


            if ( state.backtracking==0 ) { buf.append( (p1!=null?p1.id:null) ); }

            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:444:7: ( ( PERIOD | DOLLAR ) p2= eid )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==DOLLAR||LA31_0==PERIOD) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:444:9: ( PERIOD | DOLLAR ) p2= eid
            	    {
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:444:9: ( PERIOD | DOLLAR )
            	    int alt30=2;
            	    int LA30_0 = input.LA(1);

            	    if ( (LA30_0==PERIOD) ) {
            	        alt30=1;
            	    }
            	    else if ( (LA30_0==DOLLAR) ) {
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
            	            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:444:11: PERIOD
            	            {
            	            _last = (CommonTree)input.LT(1);
            	            PERIOD96=(CommonTree)match(input,PERIOD,FOLLOW_PERIOD_in_func_name1320); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            PERIOD96_tree = (CommonTree)adaptor.dupNode(PERIOD96);


            	            adaptor.addChild(root_0, PERIOD96_tree);
            	            }


            	            if ( state.backtracking==0 ) { buf.append( (PERIOD96!=null?PERIOD96.getText():null) ); }

            	            if ( state.backtracking==0 ) {
            	            }
            	            }
            	            break;
            	        case 2 :
            	            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:444:52: DOLLAR
            	            {
            	            _last = (CommonTree)input.LT(1);
            	            DOLLAR97=(CommonTree)match(input,DOLLAR,FOLLOW_DOLLAR_in_func_name1326); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            DOLLAR97_tree = (CommonTree)adaptor.dupNode(DOLLAR97);


            	            adaptor.addChild(root_0, DOLLAR97_tree);
            	            }


            	            if ( state.backtracking==0 ) { buf.append( (DOLLAR97!=null?DOLLAR97.getText():null) ); }

            	            if ( state.backtracking==0 ) {
            	            }
            	            }
            	            break;

            	    }


            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_eid_in_func_name1342);
            	    p2=eid();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, p2.getTree());


            	    if ( state.backtracking==0 ) { buf.append( (p2!=null?p2.id:null) ); }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);


            if ( state.backtracking==0 ) {
                   retval.funcName = buf.toString();
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
    // $ANTLR end "func_name"


    public static class func_args_return extends TreeRuleReturnScope {
        public List<String> args;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "func_args"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:451:1: func_args returns [List<String> args] : ( QUOTEDSTRING | MULTILINE_QUOTEDSTRING )+ ;
    public final LogicalPlanGenerator.func_args_return func_args() throws RecognitionException {
        LogicalPlanGenerator.func_args_return retval = new LogicalPlanGenerator.func_args_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING98=null;
        CommonTree MULTILINE_QUOTEDSTRING99=null;

        CommonTree QUOTEDSTRING98_tree=null;
        CommonTree MULTILINE_QUOTEDSTRING99_tree=null;

         retval.args = new ArrayList<String>(); 
        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:453:3: ( ( QUOTEDSTRING | MULTILINE_QUOTEDSTRING )+ )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:453:3: ( QUOTEDSTRING | MULTILINE_QUOTEDSTRING )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:453:3: ( QUOTEDSTRING | MULTILINE_QUOTEDSTRING )+
            int cnt32=0;
            loop32:
            do {
                int alt32=3;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==QUOTEDSTRING) ) {
                    alt32=1;
                }
                else if ( (LA32_0==MULTILINE_QUOTEDSTRING) ) {
                    alt32=2;
                }


                switch (alt32) {
            	case 1 :
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:453:5: QUOTEDSTRING
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    QUOTEDSTRING98=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_func_args1371); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    QUOTEDSTRING98_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING98);


            	    adaptor.addChild(root_0, QUOTEDSTRING98_tree);
            	    }


            	    if ( state.backtracking==0 ) { retval.args.add( builder.unquote( (QUOTEDSTRING98!=null?QUOTEDSTRING98.getText():null) ) ); }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;
            	case 2 :
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:454:7: MULTILINE_QUOTEDSTRING
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    MULTILINE_QUOTEDSTRING99=(CommonTree)match(input,MULTILINE_QUOTEDSTRING,FOLLOW_MULTILINE_QUOTEDSTRING_in_func_args1382); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    MULTILINE_QUOTEDSTRING99_tree = (CommonTree)adaptor.dupNode(MULTILINE_QUOTEDSTRING99);


            	    adaptor.addChild(root_0, MULTILINE_QUOTEDSTRING99_tree);
            	    }


            	    if ( state.backtracking==0 ) { retval.args.add( builder.unquote( (MULTILINE_QUOTEDSTRING99!=null?MULTILINE_QUOTEDSTRING99.getText():null) ) ); }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt32 >= 1 ) break loop32;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(32, input);
                        throw eee;
                }
                cnt32++;
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
        MultiMap<Integer, LogicalExpressionPlan> groupPlans;
        int inputIndex;
        List<String> inputAliases;
        List<Boolean> innerFlags;
    }
    protected Stack group_clause_stack = new Stack();


    public static class group_clause_return extends TreeRuleReturnScope {
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "group_clause"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:458:1: group_clause returns [String alias] : ( ^( GROUP ( group_item )+ ( group_type )? ( partition_clause )? ) | ^( COGROUP ( group_item )+ ( group_type )? ( partition_clause )? ) );
    public final LogicalPlanGenerator.group_clause_return group_clause() throws RecognitionException {
        GScope_stack.push(new GScope_scope());
        group_clause_stack.push(new group_clause_scope());
        LogicalPlanGenerator.group_clause_return retval = new LogicalPlanGenerator.group_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree GROUP100=null;
        CommonTree COGROUP104=null;
        LogicalPlanGenerator.group_item_return group_item101 =null;

        LogicalPlanGenerator.group_type_return group_type102 =null;

        LogicalPlanGenerator.partition_clause_return partition_clause103 =null;

        LogicalPlanGenerator.group_item_return group_item105 =null;

        LogicalPlanGenerator.group_type_return group_type106 =null;

        LogicalPlanGenerator.partition_clause_return partition_clause107 =null;


        CommonTree GROUP100_tree=null;
        CommonTree COGROUP104_tree=null;


            ((GScope_scope)GScope_stack.peek()).currentOp = builder.createGroupOp(); 
            ((group_clause_scope)group_clause_stack.peek()).groupPlans = new MultiMap<Integer, LogicalExpressionPlan>();
            ((group_clause_scope)group_clause_stack.peek()).inputAliases = new ArrayList<String>();
            ((group_clause_scope)group_clause_stack.peek()).innerFlags = new ArrayList<Boolean>();
            GROUPTYPE groupType = GROUPTYPE.REGULAR;
            SourceLocation loc = new SourceLocation( (PigParserNode)((CommonTree)retval.start) );
            int oldStatementIndex = ((statement_scope)statement_stack.peek()).inputIndex;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:476:2: ( ^( GROUP ( group_item )+ ( group_type )? ( partition_clause )? ) | ^( COGROUP ( group_item )+ ( group_type )? ( partition_clause )? ) )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==GROUP) ) {
                alt39=1;
            }
            else if ( (LA39_0==COGROUP) ) {
                alt39=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;

            }
            switch (alt39) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:476:4: ^( GROUP ( group_item )+ ( group_type )? ( partition_clause )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    GROUP100=(CommonTree)match(input,GROUP,FOLLOW_GROUP_in_group_clause1423); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    GROUP100_tree = (CommonTree)adaptor.dupNode(GROUP100);


                    root_1 = (CommonTree)adaptor.becomeRoot(GROUP100_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:476:13: ( group_item )+
                    int cnt33=0;
                    loop33:
                    do {
                        int alt33=2;
                        int LA33_0 = input.LA(1);

                        if ( (LA33_0==COGROUP||LA33_0==CROSS||LA33_0==DEFINE||LA33_0==DISTINCT||LA33_0==FILTER||LA33_0==FOREACH||LA33_0==GROUP||LA33_0==JOIN||(LA33_0 >= LIMIT && LA33_0 <= LOAD)||LA33_0==MAPREDUCE||LA33_0==ORDER||LA33_0==SAMPLE||(LA33_0 >= STORE && LA33_0 <= STREAM)||LA33_0==UNION||LA33_0==IDENTIFIER) ) {
                            alt33=1;
                        }


                        switch (alt33) {
                    	case 1 :
                    	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:476:13: group_item
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_group_item_in_group_clause1425);
                    	    group_item101=group_item();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, group_item101.getTree());


                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    if ( cnt33 >= 1 ) break loop33;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(33, input);
                                throw eee;
                        }
                        cnt33++;
                    } while (true);


                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:476:25: ( group_type )?
                    int alt34=2;
                    int LA34_0 = input.LA(1);

                    if ( (LA34_0==QUOTEDSTRING) ) {
                        alt34=1;
                    }
                    switch (alt34) {
                        case 1 :
                            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:476:27: group_type
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_group_type_in_group_clause1430);
                            group_type102=group_type();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_1, group_type102.getTree());


                            if ( state.backtracking==0 ) { groupType = (group_type102!=null?group_type102.type:null); ((LOCogroup)((GScope_scope)GScope_stack.peek()).currentOp).pinOption(LOCogroup.OPTION_GROUPTYPE); }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:476:146: ( partition_clause )?
                    int alt35=2;
                    int LA35_0 = input.LA(1);

                    if ( (LA35_0==PARTITION) ) {
                        alt35=1;
                    }
                    switch (alt35) {
                        case 1 :
                            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:476:146: partition_clause
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_partition_clause_in_group_clause1437);
                            partition_clause103=partition_clause();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_1, partition_clause103.getTree());


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
                           retval.alias = builder.buildGroupOp( loc, (LOCogroup)((GScope_scope)GScope_stack.peek()).currentOp, ((statement_scope)statement_stack.peek()).alias, 
                               ((group_clause_scope)group_clause_stack.peek()).inputAliases, ((group_clause_scope)group_clause_stack.peek()).groupPlans, groupType, ((group_clause_scope)group_clause_stack.peek()).innerFlags,
                               (partition_clause103!=null?partition_clause103.partitioner:null) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:482:4: ^( COGROUP ( group_item )+ ( group_type )? ( partition_clause )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    COGROUP104=(CommonTree)match(input,COGROUP,FOLLOW_COGROUP_in_group_clause1452); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    COGROUP104_tree = (CommonTree)adaptor.dupNode(COGROUP104);


                    root_1 = (CommonTree)adaptor.becomeRoot(COGROUP104_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:482:15: ( group_item )+
                    int cnt36=0;
                    loop36:
                    do {
                        int alt36=2;
                        int LA36_0 = input.LA(1);

                        if ( (LA36_0==COGROUP||LA36_0==CROSS||LA36_0==DEFINE||LA36_0==DISTINCT||LA36_0==FILTER||LA36_0==FOREACH||LA36_0==GROUP||LA36_0==JOIN||(LA36_0 >= LIMIT && LA36_0 <= LOAD)||LA36_0==MAPREDUCE||LA36_0==ORDER||LA36_0==SAMPLE||(LA36_0 >= STORE && LA36_0 <= STREAM)||LA36_0==UNION||LA36_0==IDENTIFIER) ) {
                            alt36=1;
                        }


                        switch (alt36) {
                    	case 1 :
                    	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:482:15: group_item
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_group_item_in_group_clause1454);
                    	    group_item105=group_item();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, group_item105.getTree());


                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    if ( cnt36 >= 1 ) break loop36;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(36, input);
                                throw eee;
                        }
                        cnt36++;
                    } while (true);


                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:482:27: ( group_type )?
                    int alt37=2;
                    int LA37_0 = input.LA(1);

                    if ( (LA37_0==QUOTEDSTRING) ) {
                        alt37=1;
                    }
                    switch (alt37) {
                        case 1 :
                            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:482:29: group_type
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_group_type_in_group_clause1459);
                            group_type106=group_type();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_1, group_type106.getTree());


                            if ( state.backtracking==0 ) { groupType = (group_type106!=null?group_type106.type:null);((LOCogroup)((GScope_scope)GScope_stack.peek()).currentOp).pinOption(LOCogroup.OPTION_GROUPTYPE); }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:482:147: ( partition_clause )?
                    int alt38=2;
                    int LA38_0 = input.LA(1);

                    if ( (LA38_0==PARTITION) ) {
                        alt38=1;
                    }
                    switch (alt38) {
                        case 1 :
                            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:482:147: partition_clause
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_partition_clause_in_group_clause1466);
                            partition_clause107=partition_clause();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_1, partition_clause107.getTree());


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
                           retval.alias = builder.buildGroupOp( loc, (LOCogroup)((GScope_scope)GScope_stack.peek()).currentOp, ((statement_scope)statement_stack.peek()).alias, 
                               ((group_clause_scope)group_clause_stack.peek()).inputAliases, ((group_clause_scope)group_clause_stack.peek()).groupPlans, groupType, ((group_clause_scope)group_clause_stack.peek()).innerFlags,
                               (partition_clause107!=null?partition_clause107.partitioner:null) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

            if ( state.backtracking==0 ) { ((statement_scope)statement_stack.peek()).inputIndex = oldStatementIndex; }
        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
            GScope_stack.pop();
            group_clause_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "group_clause"


    public static class group_type_return extends TreeRuleReturnScope {
        public GROUPTYPE type;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "group_type"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:490:1: group_type returns [GROUPTYPE type] : QUOTEDSTRING ;
    public final LogicalPlanGenerator.group_type_return group_type() throws RecognitionException {
        LogicalPlanGenerator.group_type_return retval = new LogicalPlanGenerator.group_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING108=null;

        CommonTree QUOTEDSTRING108_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:491:2: ( QUOTEDSTRING )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:491:4: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING108=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_group_type1487); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING108_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING108);


            adaptor.addChild(root_0, QUOTEDSTRING108_tree);
            }


            if ( state.backtracking==0 ) {
                   retval.type =builder.parseGroupType( (QUOTEDSTRING108!=null?QUOTEDSTRING108.getText():null), new SourceLocation( (PigParserNode)QUOTEDSTRING108 ) );
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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:497:1: group_item : rel ( join_group_by_clause | ALL | ANY ) ( INNER | OUTER )? ;
    public final LogicalPlanGenerator.group_item_return group_item() throws RecognitionException {
        LogicalPlanGenerator.group_item_return retval = new LogicalPlanGenerator.group_item_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ALL111=null;
        CommonTree ANY112=null;
        CommonTree INNER113=null;
        CommonTree OUTER114=null;
        LogicalPlanGenerator.rel_return rel109 =null;

        LogicalPlanGenerator.join_group_by_clause_return join_group_by_clause110 =null;


        CommonTree ALL111_tree=null;
        CommonTree ANY112_tree=null;
        CommonTree INNER113_tree=null;
        CommonTree OUTER114_tree=null;

         boolean inner = false; 
        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:499:2: ( rel ( join_group_by_clause | ALL | ANY ) ( INNER | OUTER )? )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:499:4: rel ( join_group_by_clause | ALL | ANY ) ( INNER | OUTER )?
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_group_item1508);
            rel109=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, rel109.getTree());


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:499:8: ( join_group_by_clause | ALL | ANY )
            int alt40=3;
            switch ( input.LA(1) ) {
            case BY:
                {
                alt40=1;
                }
                break;
            case ALL:
                {
                alt40=2;
                }
                break;
            case ANY:
                {
                alt40=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;

            }

            switch (alt40) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:499:10: join_group_by_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_group_by_clause_in_group_item1512);
                    join_group_by_clause110=join_group_by_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, join_group_by_clause110.getTree());


                    if ( state.backtracking==0 ) { 
                                 ((group_clause_scope)group_clause_stack.peek()).groupPlans.put( ((group_clause_scope)group_clause_stack.peek()).inputIndex, (join_group_by_clause110!=null?join_group_by_clause110.plans:null) );
                             }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:503:12: ALL
                    {
                    _last = (CommonTree)input.LT(1);
                    ALL111=(CommonTree)match(input,ALL,FOLLOW_ALL_in_group_item1537); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ALL111_tree = (CommonTree)adaptor.dupNode(ALL111);


                    adaptor.addChild(root_0, ALL111_tree);
                    }


                    if ( state.backtracking==0 ) {
                                 LogicalExpressionPlan plan = new LogicalExpressionPlan();
                                 ConstantExpression ce = new ConstantExpression( plan, "all");
                                 ce.setLocation( new SourceLocation( (PigParserNode)ALL111 ) );
                                 List<LogicalExpressionPlan> plans = new ArrayList<LogicalExpressionPlan>( 1 );
                                 plans.add( plan );
                                 ((group_clause_scope)group_clause_stack.peek()).groupPlans.put( ((group_clause_scope)group_clause_stack.peek()).inputIndex, plans );
                             }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:512:12: ANY
                    {
                    _last = (CommonTree)input.LT(1);
                    ANY112=(CommonTree)match(input,ANY,FOLLOW_ANY_in_group_item1562); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ANY112_tree = (CommonTree)adaptor.dupNode(ANY112);


                    adaptor.addChild(root_0, ANY112_tree);
                    }


                    if ( state.backtracking==0 ) {
                                 LogicalExpressionPlan plan = new LogicalExpressionPlan();
                                 UserFuncExpression udf = new UserFuncExpression( plan, new FuncSpec( GFAny.class.getName() ) );
                                 udf.setLocation( new SourceLocation( (PigParserNode)ANY112 ) );
                                 List<LogicalExpressionPlan> plans = new ArrayList<LogicalExpressionPlan>( 1 );
                                 plans.add( plan );
                                 ((group_clause_scope)group_clause_stack.peek()).groupPlans.put( ((group_clause_scope)group_clause_stack.peek()).inputIndex, plans );
                             }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:521:11: ( INNER | OUTER )?
            int alt41=3;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==INNER) ) {
                alt41=1;
            }
            else if ( (LA41_0==OUTER) ) {
                alt41=2;
            }
            switch (alt41) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:521:13: INNER
                    {
                    _last = (CommonTree)input.LT(1);
                    INNER113=(CommonTree)match(input,INNER,FOLLOW_INNER_in_group_item1587); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INNER113_tree = (CommonTree)adaptor.dupNode(INNER113);


                    adaptor.addChild(root_0, INNER113_tree);
                    }


                    if ( state.backtracking==0 ) { inner =  true; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:521:40: OUTER
                    {
                    _last = (CommonTree)input.LT(1);
                    OUTER114=(CommonTree)match(input,OUTER,FOLLOW_OUTER_in_group_item1593); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OUTER114_tree = (CommonTree)adaptor.dupNode(OUTER114);


                    adaptor.addChild(root_0, OUTER114_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            if ( state.backtracking==0 ) {
                   ((group_clause_scope)group_clause_stack.peek()).inputAliases.add( ((statement_scope)statement_stack.peek()).inputAlias );
                   ((group_clause_scope)group_clause_stack.peek()).innerFlags.add( inner );
                   ((group_clause_scope)group_clause_stack.peek()).inputIndex++;
                   ((statement_scope)statement_stack.peek()).inputIndex++;
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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:530:1: rel : ( alias | inline_op );
    public final LogicalPlanGenerator.rel_return rel() throws RecognitionException {
        LogicalPlanGenerator.rel_return retval = new LogicalPlanGenerator.rel_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.alias_return alias115 =null;

        LogicalPlanGenerator.inline_op_return inline_op116 =null;



        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:531:2: ( alias | inline_op )
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==IDENTIFIER) ) {
                alt42=1;
            }
            else if ( (LA42_0==COGROUP||LA42_0==CROSS||LA42_0==DEFINE||LA42_0==DISTINCT||LA42_0==FILTER||LA42_0==FOREACH||LA42_0==GROUP||LA42_0==JOIN||(LA42_0 >= LIMIT && LA42_0 <= LOAD)||LA42_0==MAPREDUCE||LA42_0==ORDER||LA42_0==SAMPLE||(LA42_0 >= STORE && LA42_0 <= STREAM)||LA42_0==UNION) ) {
                alt42=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;

            }
            switch (alt42) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:531:4: alias
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_alias_in_rel1611);
                    alias115=alias();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, alias115.getTree());


                    if ( state.backtracking==0 ) {
                           ((statement_scope)statement_stack.peek()).inputAlias = (alias115!=null?alias115.name:null);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:535:4: inline_op
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_inline_op_in_rel1621);
                    inline_op116=inline_op();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, inline_op116.getTree());


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


    public static class inline_op_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "inline_op"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:538:1: inline_op : op_clause ( parallel_clause )? ;
    public final LogicalPlanGenerator.inline_op_return inline_op() throws RecognitionException {
        LogicalPlanGenerator.inline_op_return retval = new LogicalPlanGenerator.inline_op_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.op_clause_return op_clause117 =null;

        LogicalPlanGenerator.parallel_clause_return parallel_clause118 =null;




            String al = ((statement_scope)statement_stack.peek()).alias;
            ((statement_scope)statement_stack.peek()).alias = null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:546:2: ( op_clause ( parallel_clause )? )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:546:4: op_clause ( parallel_clause )?
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_op_clause_in_inline_op1641);
            op_clause117=op_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, op_clause117.getTree());


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:546:14: ( parallel_clause )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==PARALLEL) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:546:14: parallel_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_parallel_clause_in_inline_op1643);
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


            if ( state.backtracking==0 ) {
                   Operator op = builder.lookupOperator( (op_clause117!=null?op_clause117.alias:null) );
                   builder.setParallel( (LogicalRelationalOperator)op, ((statement_scope)statement_stack.peek()).parallel );
                   ((statement_scope)statement_stack.peek()).inputAlias = (op_clause117!=null?op_clause117.alias:null);
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

            if ( state.backtracking==0 ) {
                ((statement_scope)statement_stack.peek()).alias = al;
            }
        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "inline_op"


    public static class flatten_generated_item_return extends TreeRuleReturnScope {
        public LogicalExpressionPlan plan;
        public boolean flattenFlag;
        public LogicalSchema schema;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "flatten_generated_item"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:554:1: flatten_generated_item returns [LogicalExpressionPlan plan, boolean flattenFlag, LogicalSchema schema] : ( flatten_clause[$plan] | col_range[$plan] | expr[$plan] | STAR ) ( field_def_list )? ;
    public final LogicalPlanGenerator.flatten_generated_item_return flatten_generated_item() throws RecognitionException {
        LogicalPlanGenerator.flatten_generated_item_return retval = new LogicalPlanGenerator.flatten_generated_item_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR122=null;
        LogicalPlanGenerator.flatten_clause_return flatten_clause119 =null;

        LogicalPlanGenerator.col_range_return col_range120 =null;

        LogicalPlanGenerator.expr_return expr121 =null;

        LogicalPlanGenerator.field_def_list_return field_def_list123 =null;


        CommonTree STAR122_tree=null;


            retval.plan = new LogicalExpressionPlan();

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:558:2: ( ( flatten_clause[$plan] | col_range[$plan] | expr[$plan] | STAR ) ( field_def_list )? )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:558:4: ( flatten_clause[$plan] | col_range[$plan] | expr[$plan] | STAR ) ( field_def_list )?
            {
            root_0 = (CommonTree)adaptor.nil();


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:558:4: ( flatten_clause[$plan] | col_range[$plan] | expr[$plan] | STAR )
            int alt44=4;
            switch ( input.LA(1) ) {
            case FLATTEN:
                {
                alt44=1;
                }
                break;
            case COL_RANGE:
                {
                alt44=2;
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
                alt44=3;
                }
                break;
            case STAR:
                {
                int LA44_4 = input.LA(2);

                if ( (LA44_4==DOWN) ) {
                    alt44=3;
                }
                else if ( (LA44_4==EOF||LA44_4==UP||LA44_4==DIV||LA44_4==DOLLARVAR||LA44_4==DOUBLENUMBER||LA44_4==FALSE||LA44_4==FLATTEN||LA44_4==FLOATNUMBER||LA44_4==GROUP||LA44_4==INTEGER||LA44_4==LONGINTEGER||LA44_4==MINUS||LA44_4==PERCENT||LA44_4==PLUS||LA44_4==QUOTEDSTRING||LA44_4==STAR||LA44_4==TRUE||(LA44_4 >= BAG_VAL && LA44_4 <= BIN_EXPR)||(LA44_4 >= CAST_EXPR && LA44_4 <= FIELD_DEF)||LA44_4==FUNC_EVAL||LA44_4==IDENTIFIER||(LA44_4 >= MAP_VAL && LA44_4 <= NEG)||LA44_4==NULL||LA44_4==TUPLE_VAL) ) {
                    alt44=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 44, 4, input);

                    throw nvae;

                }
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:558:6: flatten_clause[$plan]
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_flatten_clause_in_flatten_generated_item1669);
                    flatten_clause119=flatten_clause(retval.plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, flatten_clause119.getTree());


                    if ( state.backtracking==0 ) { retval.flattenFlag = true; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:559:6: col_range[$plan]
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_flatten_generated_item1679);
                    col_range120=col_range(retval.plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range120.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:560:6: expr[$plan]
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_flatten_generated_item1687);
                    expr121=expr(retval.plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expr121.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:561:6: STAR
                    {
                    _last = (CommonTree)input.LT(1);
                    STAR122=(CommonTree)match(input,STAR,FOLLOW_STAR_in_flatten_generated_item1695); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR122_tree = (CommonTree)adaptor.dupNode(STAR122);


                    adaptor.addChild(root_0, STAR122_tree);
                    }


                    if ( state.backtracking==0 ) {
                             builder.buildProjectExpr( new SourceLocation( (PigParserNode)STAR122 ), retval.plan, ((GScope_scope)GScope_stack.peek()).currentOp,
                                 ((statement_scope)statement_stack.peek()).inputIndex, null, -1 );
                         }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:567:4: ( field_def_list )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==FIELD_DEF) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:567:6: field_def_list
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_field_def_list_in_flatten_generated_item1714);
                    field_def_list123=field_def_list();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, field_def_list123.getTree());


                    if ( state.backtracking==0 ) { retval.schema = (field_def_list123!=null?field_def_list123.schema:null); }

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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:570:1: flatten_clause[LogicalExpressionPlan plan] : ^( FLATTEN expr[$plan] ) ;
    public final LogicalPlanGenerator.flatten_clause_return flatten_clause(LogicalExpressionPlan plan) throws RecognitionException {
        LogicalPlanGenerator.flatten_clause_return retval = new LogicalPlanGenerator.flatten_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FLATTEN124=null;
        LogicalPlanGenerator.expr_return expr125 =null;


        CommonTree FLATTEN124_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:571:2: ( ^( FLATTEN expr[$plan] ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:571:4: ^( FLATTEN expr[$plan] )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FLATTEN124=(CommonTree)match(input,FLATTEN,FOLLOW_FLATTEN_in_flatten_clause1732); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FLATTEN124_tree = (CommonTree)adaptor.dupNode(FLATTEN124);


            root_1 = (CommonTree)adaptor.becomeRoot(FLATTEN124_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expr_in_flatten_clause1734);
            expr125=expr(plan);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, expr125.getTree());


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
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "store_clause"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:574:1: store_clause returns [String alias] : ^( STORE rel filename ( func_clause[FunctionType.STOREFUNC] )? ) ;
    public final LogicalPlanGenerator.store_clause_return store_clause() throws RecognitionException {
        LogicalPlanGenerator.store_clause_return retval = new LogicalPlanGenerator.store_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STORE126=null;
        LogicalPlanGenerator.rel_return rel127 =null;

        LogicalPlanGenerator.filename_return filename128 =null;

        LogicalPlanGenerator.func_clause_return func_clause129 =null;


        CommonTree STORE126_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:575:2: ( ^( STORE rel filename ( func_clause[FunctionType.STOREFUNC] )? ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:575:4: ^( STORE rel filename ( func_clause[FunctionType.STOREFUNC] )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            STORE126=(CommonTree)match(input,STORE,FOLLOW_STORE_in_store_clause1752); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STORE126_tree = (CommonTree)adaptor.dupNode(STORE126);


            root_1 = (CommonTree)adaptor.becomeRoot(STORE126_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_store_clause1754);
            rel127=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel127.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_filename_in_store_clause1756);
            filename128=filename();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, filename128.getTree());


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:575:26: ( func_clause[FunctionType.STOREFUNC] )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==FUNC||LA46_0==FUNC_REF) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:575:26: func_clause[FunctionType.STOREFUNC]
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_store_clause1758);
                    func_clause129=func_clause(FunctionType.STOREFUNC);

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
                   SourceLocation loc = new SourceLocation( (PigParserNode)STORE126 );
                   retval.alias = builder.buildStoreOp( loc, ((statement_scope)statement_stack.peek()).alias,
                      ((statement_scope)statement_stack.peek()).inputAlias, (filename128!=null?filename128.filename:null), (func_clause129!=null?func_clause129.funcSpec:null) );
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
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "filter_clause"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:583:1: filter_clause returns [String alias] : ^( FILTER rel cond[exprPlan] ) ;
    public final LogicalPlanGenerator.filter_clause_return filter_clause() throws RecognitionException {
        GScope_stack.push(new GScope_scope());

        LogicalPlanGenerator.filter_clause_return retval = new LogicalPlanGenerator.filter_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FILTER130=null;
        LogicalPlanGenerator.rel_return rel131 =null;

        LogicalPlanGenerator.cond_return cond132 =null;


        CommonTree FILTER130_tree=null;

         
            LogicalExpressionPlan exprPlan = new LogicalExpressionPlan();
            ((GScope_scope)GScope_stack.peek()).currentOp = builder.createFilterOp();

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:589:2: ( ^( FILTER rel cond[exprPlan] ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:589:4: ^( FILTER rel cond[exprPlan] )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FILTER130=(CommonTree)match(input,FILTER,FOLLOW_FILTER_in_filter_clause1792); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FILTER130_tree = (CommonTree)adaptor.dupNode(FILTER130);


            root_1 = (CommonTree)adaptor.becomeRoot(FILTER130_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_filter_clause1794);
            rel131=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel131.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_filter_clause1796);
            cond132=cond(exprPlan);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond132.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   retval.alias = builder.buildFilterOp( new SourceLocation( (PigParserNode)FILTER130 ),
                       (LOFilter)((GScope_scope)GScope_stack.peek()).currentOp, ((statement_scope)statement_stack.peek()).alias,
                       ((statement_scope)statement_stack.peek()).inputAlias, exprPlan );
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
            GScope_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "filter_clause"


    public static class cond_return extends TreeRuleReturnScope {
        public LogicalExpression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cond"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:597:1: cond[LogicalExpressionPlan exprPlan] returns [LogicalExpression expr] : ( ^( OR left= cond[exprPlan] right= cond[exprPlan] ) | ^( AND left= cond[exprPlan] right= cond[exprPlan] ) | ^( NOT c= cond[exprPlan] ) | ^( NULL expr[$exprPlan] ( NOT )? ) | ^( rel_op_eq e1= expr[$exprPlan] e2= expr[$exprPlan] ) | ^( rel_op_ne e1= expr[$exprPlan] e2= expr[$exprPlan] ) | ^( rel_op_lt e1= expr[$exprPlan] e2= expr[$exprPlan] ) | ^( rel_op_lte e1= expr[$exprPlan] e2= expr[$exprPlan] ) | ^( rel_op_gt e1= expr[$exprPlan] e2= expr[$exprPlan] ) | ^( rel_op_gte e1= expr[$exprPlan] e2= expr[$exprPlan] ) | ^( STR_OP_MATCHES e1= expr[$exprPlan] e2= expr[$exprPlan] ) | func_eval[$exprPlan] );
    public final LogicalPlanGenerator.cond_return cond(LogicalExpressionPlan exprPlan) throws RecognitionException {
        LogicalPlanGenerator.cond_return retval = new LogicalPlanGenerator.cond_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree OR133=null;
        CommonTree AND134=null;
        CommonTree NOT135=null;
        CommonTree NULL136=null;
        CommonTree NOT138=null;
        CommonTree STR_OP_MATCHES145=null;
        LogicalPlanGenerator.cond_return left =null;

        LogicalPlanGenerator.cond_return right =null;

        LogicalPlanGenerator.cond_return c =null;

        LogicalPlanGenerator.expr_return e1 =null;

        LogicalPlanGenerator.expr_return e2 =null;

        LogicalPlanGenerator.expr_return expr137 =null;

        LogicalPlanGenerator.rel_op_eq_return rel_op_eq139 =null;

        LogicalPlanGenerator.rel_op_ne_return rel_op_ne140 =null;

        LogicalPlanGenerator.rel_op_lt_return rel_op_lt141 =null;

        LogicalPlanGenerator.rel_op_lte_return rel_op_lte142 =null;

        LogicalPlanGenerator.rel_op_gt_return rel_op_gt143 =null;

        LogicalPlanGenerator.rel_op_gte_return rel_op_gte144 =null;

        LogicalPlanGenerator.func_eval_return func_eval146 =null;


        CommonTree OR133_tree=null;
        CommonTree AND134_tree=null;
        CommonTree NOT135_tree=null;
        CommonTree NULL136_tree=null;
        CommonTree NOT138_tree=null;
        CommonTree STR_OP_MATCHES145_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:598:2: ( ^( OR left= cond[exprPlan] right= cond[exprPlan] ) | ^( AND left= cond[exprPlan] right= cond[exprPlan] ) | ^( NOT c= cond[exprPlan] ) | ^( NULL expr[$exprPlan] ( NOT )? ) | ^( rel_op_eq e1= expr[$exprPlan] e2= expr[$exprPlan] ) | ^( rel_op_ne e1= expr[$exprPlan] e2= expr[$exprPlan] ) | ^( rel_op_lt e1= expr[$exprPlan] e2= expr[$exprPlan] ) | ^( rel_op_lte e1= expr[$exprPlan] e2= expr[$exprPlan] ) | ^( rel_op_gt e1= expr[$exprPlan] e2= expr[$exprPlan] ) | ^( rel_op_gte e1= expr[$exprPlan] e2= expr[$exprPlan] ) | ^( STR_OP_MATCHES e1= expr[$exprPlan] e2= expr[$exprPlan] ) | func_eval[$exprPlan] )
            int alt48=12;
            switch ( input.LA(1) ) {
            case OR:
                {
                alt48=1;
                }
                break;
            case AND:
                {
                alt48=2;
                }
                break;
            case NOT:
                {
                alt48=3;
                }
                break;
            case NULL:
                {
                alt48=4;
                }
                break;
            case NUM_OP_EQ:
            case STR_OP_EQ:
                {
                alt48=5;
                }
                break;
            case NUM_OP_NE:
            case STR_OP_NE:
                {
                alt48=6;
                }
                break;
            case NUM_OP_LT:
            case STR_OP_LT:
                {
                alt48=7;
                }
                break;
            case NUM_OP_LTE:
            case STR_OP_LTE:
                {
                alt48=8;
                }
                break;
            case NUM_OP_GT:
            case STR_OP_GT:
                {
                alt48=9;
                }
                break;
            case NUM_OP_GTE:
            case STR_OP_GTE:
                {
                alt48=10;
                }
                break;
            case STR_OP_MATCHES:
                {
                alt48=11;
                }
                break;
            case FUNC_EVAL:
                {
                alt48=12;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;

            }

            switch (alt48) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:598:4: ^( OR left= cond[exprPlan] right= cond[exprPlan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    OR133=(CommonTree)match(input,OR,FOLLOW_OR_in_cond1820); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OR133_tree = (CommonTree)adaptor.dupNode(OR133);


                    root_1 = (CommonTree)adaptor.becomeRoot(OR133_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond1826);
                    left=cond(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, left.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond1833);
                    right=cond(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, right.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new OrExpression( exprPlan, (left!=null?left.expr:null), (right!=null?right.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)OR133 ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:603:4: ^( AND left= cond[exprPlan] right= cond[exprPlan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    AND134=(CommonTree)match(input,AND,FOLLOW_AND_in_cond1848); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    AND134_tree = (CommonTree)adaptor.dupNode(AND134);


                    root_1 = (CommonTree)adaptor.becomeRoot(AND134_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond1854);
                    left=cond(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, left.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond1861);
                    right=cond(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, right.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new AndExpression( exprPlan, (left!=null?left.expr:null), (right!=null?right.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)AND134 ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:608:4: ^( NOT c= cond[exprPlan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NOT135=(CommonTree)match(input,NOT,FOLLOW_NOT_in_cond1876); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NOT135_tree = (CommonTree)adaptor.dupNode(NOT135);


                    root_1 = (CommonTree)adaptor.becomeRoot(NOT135_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond1882);
                    c=cond(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, c.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new NotExpression( exprPlan, (c!=null?c.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)NOT135 ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:613:4: ^( NULL expr[$exprPlan] ( NOT )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NULL136=(CommonTree)match(input,NULL,FOLLOW_NULL_in_cond1897); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NULL136_tree = (CommonTree)adaptor.dupNode(NULL136);


                    root_1 = (CommonTree)adaptor.becomeRoot(NULL136_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond1899);
                    expr137=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr137.getTree());


                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:613:28: ( NOT )?
                    int alt47=2;
                    int LA47_0 = input.LA(1);

                    if ( (LA47_0==NOT) ) {
                        alt47=1;
                    }
                    switch (alt47) {
                        case 1 :
                            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:613:28: NOT
                            {
                            _last = (CommonTree)input.LT(1);
                            NOT138=(CommonTree)match(input,NOT,FOLLOW_NOT_in_cond1902); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            NOT138_tree = (CommonTree)adaptor.dupNode(NOT138);


                            adaptor.addChild(root_1, NOT138_tree);
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
                           retval.expr = new IsNullExpression( exprPlan, (expr137!=null?expr137.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)NULL136 ) );
                           if( NOT138 != null ) {
                               retval.expr = new NotExpression( exprPlan, retval.expr );
                               retval.expr.setLocation( new SourceLocation( (PigParserNode)NOT138 ) );
                           }
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:622:4: ^( rel_op_eq e1= expr[$exprPlan] e2= expr[$exprPlan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_eq_in_cond1917);
                    rel_op_eq139=rel_op_eq();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_1 = (CommonTree)adaptor.becomeRoot(rel_op_eq139.getTree(), root_1);


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond1923);
                    e1=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e1.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond1930);
                    e2=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e2.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new EqualExpression( exprPlan, (e1!=null?e1.expr:null), (e2!=null?e2.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)(rel_op_eq139!=null?((CommonTree)rel_op_eq139.start):null) ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:627:4: ^( rel_op_ne e1= expr[$exprPlan] e2= expr[$exprPlan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_ne_in_cond1946);
                    rel_op_ne140=rel_op_ne();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_1 = (CommonTree)adaptor.becomeRoot(rel_op_ne140.getTree(), root_1);


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond1952);
                    e1=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e1.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond1959);
                    e2=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e2.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new NotEqualExpression( exprPlan, (e1!=null?e1.expr:null), (e2!=null?e2.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)(rel_op_ne140!=null?((CommonTree)rel_op_ne140.start):null) ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:632:4: ^( rel_op_lt e1= expr[$exprPlan] e2= expr[$exprPlan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_lt_in_cond1975);
                    rel_op_lt141=rel_op_lt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_1 = (CommonTree)adaptor.becomeRoot(rel_op_lt141.getTree(), root_1);


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond1981);
                    e1=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e1.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond1988);
                    e2=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e2.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new LessThanExpression( exprPlan, (e1!=null?e1.expr:null), (e2!=null?e2.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)(rel_op_lt141!=null?((CommonTree)rel_op_lt141.start):null) ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:637:4: ^( rel_op_lte e1= expr[$exprPlan] e2= expr[$exprPlan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_lte_in_cond2004);
                    rel_op_lte142=rel_op_lte();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_1 = (CommonTree)adaptor.becomeRoot(rel_op_lte142.getTree(), root_1);


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2010);
                    e1=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e1.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2017);
                    e2=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e2.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new LessThanEqualExpression( exprPlan, (e1!=null?e1.expr:null), (e2!=null?e2.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)(rel_op_lte142!=null?((CommonTree)rel_op_lte142.start):null) ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:642:4: ^( rel_op_gt e1= expr[$exprPlan] e2= expr[$exprPlan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_gt_in_cond2032);
                    rel_op_gt143=rel_op_gt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_1 = (CommonTree)adaptor.becomeRoot(rel_op_gt143.getTree(), root_1);


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2038);
                    e1=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e1.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2045);
                    e2=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e2.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new GreaterThanExpression( exprPlan, (e1!=null?e1.expr:null), (e2!=null?e2.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)(rel_op_gt143!=null?((CommonTree)rel_op_gt143.start):null) ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:647:4: ^( rel_op_gte e1= expr[$exprPlan] e2= expr[$exprPlan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_gte_in_cond2061);
                    rel_op_gte144=rel_op_gte();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_1 = (CommonTree)adaptor.becomeRoot(rel_op_gte144.getTree(), root_1);


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2067);
                    e1=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e1.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2074);
                    e2=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e2.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new GreaterThanEqualExpression( exprPlan, (e1!=null?e1.expr:null), (e2!=null?e2.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)(rel_op_gte144!=null?((CommonTree)rel_op_gte144.start):null) ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 11 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:652:4: ^( STR_OP_MATCHES e1= expr[$exprPlan] e2= expr[$exprPlan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    STR_OP_MATCHES145=(CommonTree)match(input,STR_OP_MATCHES,FOLLOW_STR_OP_MATCHES_in_cond2089); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_MATCHES145_tree = (CommonTree)adaptor.dupNode(STR_OP_MATCHES145);


                    root_1 = (CommonTree)adaptor.becomeRoot(STR_OP_MATCHES145_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2095);
                    e1=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e1.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2102);
                    e2=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e2.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new RegexExpression( exprPlan, (e1!=null?e1.expr:null), (e2!=null?e2.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)STR_OP_MATCHES145 ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 12 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:657:4: func_eval[$exprPlan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_eval_in_cond2115);
                    func_eval146=func_eval(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, func_eval146.getTree());


                    if ( state.backtracking==0 ) {
                           retval.expr = (func_eval146!=null?func_eval146.expr:null);
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
    // $ANTLR end "cond"


    public static class func_eval_return extends TreeRuleReturnScope {
        public LogicalExpression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "func_eval"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:663:1: func_eval[LogicalExpressionPlan plan] returns [LogicalExpression expr] : ^( FUNC_EVAL func_name ( real_arg[$plan] )* ) ;
    public final LogicalPlanGenerator.func_eval_return func_eval(LogicalExpressionPlan plan) throws RecognitionException {
        LogicalPlanGenerator.func_eval_return retval = new LogicalPlanGenerator.func_eval_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FUNC_EVAL147=null;
        LogicalPlanGenerator.func_name_return func_name148 =null;

        LogicalPlanGenerator.real_arg_return real_arg149 =null;


        CommonTree FUNC_EVAL147_tree=null;

         
            List<LogicalExpression> args = new ArrayList<LogicalExpression>();

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:667:2: ( ^( FUNC_EVAL func_name ( real_arg[$plan] )* ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:667:4: ^( FUNC_EVAL func_name ( real_arg[$plan] )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FUNC_EVAL147=(CommonTree)match(input,FUNC_EVAL,FOLLOW_FUNC_EVAL_in_func_eval2142); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FUNC_EVAL147_tree = (CommonTree)adaptor.dupNode(FUNC_EVAL147);


            root_1 = (CommonTree)adaptor.becomeRoot(FUNC_EVAL147_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_func_name_in_func_eval2144);
            func_name148=func_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, func_name148.getTree());


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:667:27: ( real_arg[$plan] )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==DIV||LA49_0==DOLLARVAR||LA49_0==DOUBLENUMBER||LA49_0==FALSE||LA49_0==FLOATNUMBER||LA49_0==GROUP||LA49_0==INTEGER||LA49_0==LONGINTEGER||LA49_0==MINUS||LA49_0==PERCENT||LA49_0==PLUS||LA49_0==QUOTEDSTRING||LA49_0==STAR||LA49_0==TRUE||(LA49_0 >= BAG_VAL && LA49_0 <= BIN_EXPR)||(LA49_0 >= CAST_EXPR && LA49_0 <= EXPR_IN_PAREN)||LA49_0==FUNC_EVAL||LA49_0==IDENTIFIER||(LA49_0 >= MAP_VAL && LA49_0 <= NEG)||LA49_0==NULL||LA49_0==TUPLE_VAL) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:667:29: real_arg[$plan]
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_real_arg_in_func_eval2148);
            	    real_arg149=real_arg(plan);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, real_arg149.getTree());


            	    if ( state.backtracking==0 ) { args.add( (real_arg149!=null?real_arg149.expr:null) ); }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop49;
                }
            } while (true);


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   SourceLocation loc = new SourceLocation( (PigParserNode)(func_name148!=null?((CommonTree)func_name148.start):null) );
                   retval.expr = builder.buildUDF( loc, plan, (func_name148!=null?func_name148.funcName:null), args );
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
        public LogicalExpression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "real_arg"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:674:1: real_arg[LogicalExpressionPlan plan] returns [LogicalExpression expr] : (e= expr[$plan] | STAR |cr= col_range[$plan] );
    public final LogicalPlanGenerator.real_arg_return real_arg(LogicalExpressionPlan plan) throws RecognitionException {
        LogicalPlanGenerator.real_arg_return retval = new LogicalPlanGenerator.real_arg_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR150=null;
        LogicalPlanGenerator.expr_return e =null;

        LogicalPlanGenerator.col_range_return cr =null;


        CommonTree STAR150_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:675:2: (e= expr[$plan] | STAR |cr= col_range[$plan] )
            int alt50=3;
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
                alt50=1;
                }
                break;
            case STAR:
                {
                int LA50_2 = input.LA(2);

                if ( (LA50_2==DOWN) ) {
                    alt50=1;
                }
                else if ( (LA50_2==EOF||LA50_2==UP||LA50_2==DIV||LA50_2==DOLLARVAR||LA50_2==DOUBLENUMBER||LA50_2==FALSE||LA50_2==FLOATNUMBER||LA50_2==GROUP||LA50_2==INTEGER||LA50_2==LONGINTEGER||LA50_2==MINUS||LA50_2==PERCENT||LA50_2==PLUS||LA50_2==QUOTEDSTRING||LA50_2==STAR||LA50_2==TRUE||(LA50_2 >= BAG_VAL && LA50_2 <= BIN_EXPR)||(LA50_2 >= CAST_EXPR && LA50_2 <= EXPR_IN_PAREN)||LA50_2==FUNC_EVAL||LA50_2==IDENTIFIER||(LA50_2 >= MAP_VAL && LA50_2 <= NEG)||LA50_2==NULL||LA50_2==TUPLE_VAL) ) {
                    alt50=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 50, 2, input);

                    throw nvae;

                }
                }
                break;
            case COL_RANGE:
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:675:4: e= expr[$plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_real_arg2180);
                    e=expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, e.getTree());


                    if ( state.backtracking==0 ) { retval.expr = (e!=null?e.expr:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:676:4: STAR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR150=(CommonTree)match(input,STAR,FOLLOW_STAR_in_real_arg2188); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR150_tree = (CommonTree)adaptor.dupNode(STAR150);


                    adaptor.addChild(root_0, STAR150_tree);
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = builder.buildProjectExpr( new SourceLocation( (PigParserNode)STAR150 ), plan, ((GScope_scope)GScope_stack.peek()).currentOp, 
                               ((statement_scope)statement_stack.peek()).inputIndex, null, -1 );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:681:4: cr= col_range[$plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_real_arg2202);
                    cr=col_range(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, cr.getTree());


                    if ( state.backtracking==0 ) { retval.expr = (cr!=null?cr.expr:null);}

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
        public LogicalExpression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "expr"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:684:1: expr[LogicalExpressionPlan plan] returns [LogicalExpression expr] : ( ^( PLUS left= expr[$plan] right= expr[$plan] ) | ^( MINUS left= expr[$plan] right= expr[$plan] ) | ^( STAR left= expr[$plan] right= expr[$plan] ) | ^( DIV left= expr[$plan] right= expr[$plan] ) | ^( PERCENT left= expr[$plan] right= expr[$plan] ) | const_expr[$plan] | var_expr[$plan] | ^( NEG e= expr[$plan] ) | ^( CAST_EXPR type_cast e= expr[$plan] ) | ^( EXPR_IN_PAREN e= expr[$plan] ) );
    public final LogicalPlanGenerator.expr_return expr(LogicalExpressionPlan plan) throws RecognitionException {
        LogicalPlanGenerator.expr_return retval = new LogicalPlanGenerator.expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PLUS151=null;
        CommonTree MINUS152=null;
        CommonTree STAR153=null;
        CommonTree DIV154=null;
        CommonTree PERCENT155=null;
        CommonTree NEG158=null;
        CommonTree CAST_EXPR159=null;
        CommonTree EXPR_IN_PAREN161=null;
        LogicalPlanGenerator.expr_return left =null;

        LogicalPlanGenerator.expr_return right =null;

        LogicalPlanGenerator.expr_return e =null;

        LogicalPlanGenerator.const_expr_return const_expr156 =null;

        LogicalPlanGenerator.var_expr_return var_expr157 =null;

        LogicalPlanGenerator.type_cast_return type_cast160 =null;


        CommonTree PLUS151_tree=null;
        CommonTree MINUS152_tree=null;
        CommonTree STAR153_tree=null;
        CommonTree DIV154_tree=null;
        CommonTree PERCENT155_tree=null;
        CommonTree NEG158_tree=null;
        CommonTree CAST_EXPR159_tree=null;
        CommonTree EXPR_IN_PAREN161_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:685:2: ( ^( PLUS left= expr[$plan] right= expr[$plan] ) | ^( MINUS left= expr[$plan] right= expr[$plan] ) | ^( STAR left= expr[$plan] right= expr[$plan] ) | ^( DIV left= expr[$plan] right= expr[$plan] ) | ^( PERCENT left= expr[$plan] right= expr[$plan] ) | const_expr[$plan] | var_expr[$plan] | ^( NEG e= expr[$plan] ) | ^( CAST_EXPR type_cast e= expr[$plan] ) | ^( EXPR_IN_PAREN e= expr[$plan] ) )
            int alt51=10;
            switch ( input.LA(1) ) {
            case PLUS:
                {
                alt51=1;
                }
                break;
            case MINUS:
                {
                int LA51_2 = input.LA(2);

                if ( (LA51_2==DOWN) ) {
                    alt51=2;
                }
                else if ( (LA51_2==DOUBLENUMBER||LA51_2==FLOATNUMBER||LA51_2==INTEGER||LA51_2==LONGINTEGER) ) {
                    alt51=6;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 51, 2, input);

                    throw nvae;

                }
                }
                break;
            case STAR:
                {
                alt51=3;
                }
                break;
            case DIV:
                {
                alt51=4;
                }
                break;
            case PERCENT:
                {
                alt51=5;
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
                alt51=6;
                }
                break;
            case DOLLARVAR:
            case GROUP:
            case BIN_EXPR:
            case FUNC_EVAL:
            case IDENTIFIER:
                {
                alt51=7;
                }
                break;
            case NEG:
                {
                alt51=8;
                }
                break;
            case CAST_EXPR:
                {
                alt51=9;
                }
                break;
            case EXPR_IN_PAREN:
                {
                alt51=10;
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:685:4: ^( PLUS left= expr[$plan] right= expr[$plan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    PLUS151=(CommonTree)match(input,PLUS,FOLLOW_PLUS_in_expr2221); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PLUS151_tree = (CommonTree)adaptor.dupNode(PLUS151);


                    root_1 = (CommonTree)adaptor.becomeRoot(PLUS151_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2227);
                    left=expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, left.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2234);
                    right=expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, right.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new AddExpression( plan, (left!=null?left.expr:null), (right!=null?right.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)PLUS151 ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:690:4: ^( MINUS left= expr[$plan] right= expr[$plan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    MINUS152=(CommonTree)match(input,MINUS,FOLLOW_MINUS_in_expr2249); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MINUS152_tree = (CommonTree)adaptor.dupNode(MINUS152);


                    root_1 = (CommonTree)adaptor.becomeRoot(MINUS152_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2255);
                    left=expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, left.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2262);
                    right=expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, right.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new SubtractExpression( plan, (left!=null?left.expr:null), (right!=null?right.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)MINUS152 ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:695:4: ^( STAR left= expr[$plan] right= expr[$plan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    STAR153=(CommonTree)match(input,STAR,FOLLOW_STAR_in_expr2277); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR153_tree = (CommonTree)adaptor.dupNode(STAR153);


                    root_1 = (CommonTree)adaptor.becomeRoot(STAR153_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2283);
                    left=expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, left.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2290);
                    right=expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, right.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new MultiplyExpression( plan, (left!=null?left.expr:null), (right!=null?right.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)STAR153 ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:700:4: ^( DIV left= expr[$plan] right= expr[$plan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    DIV154=(CommonTree)match(input,DIV,FOLLOW_DIV_in_expr2305); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DIV154_tree = (CommonTree)adaptor.dupNode(DIV154);


                    root_1 = (CommonTree)adaptor.becomeRoot(DIV154_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2311);
                    left=expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, left.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2318);
                    right=expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, right.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new DivideExpression( plan, (left!=null?left.expr:null), (right!=null?right.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)DIV154 ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:705:4: ^( PERCENT left= expr[$plan] right= expr[$plan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    PERCENT155=(CommonTree)match(input,PERCENT,FOLLOW_PERCENT_in_expr2333); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PERCENT155_tree = (CommonTree)adaptor.dupNode(PERCENT155);


                    root_1 = (CommonTree)adaptor.becomeRoot(PERCENT155_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2339);
                    left=expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, left.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2346);
                    right=expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, right.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new ModExpression( plan, (left!=null?left.expr:null), (right!=null?right.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)PERCENT155 ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:710:4: const_expr[$plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_const_expr_in_expr2359);
                    const_expr156=const_expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, const_expr156.getTree());


                    if ( state.backtracking==0 ) {
                           retval.expr = (const_expr156!=null?const_expr156.expr:null);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:714:4: var_expr[$plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_var_expr_in_expr2370);
                    var_expr157=var_expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, var_expr157.getTree());


                    if ( state.backtracking==0 ) {
                           retval.expr = (var_expr157!=null?var_expr157.expr:null); 
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:718:4: ^( NEG e= expr[$plan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NEG158=(CommonTree)match(input,NEG,FOLLOW_NEG_in_expr2383); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NEG158_tree = (CommonTree)adaptor.dupNode(NEG158);


                    root_1 = (CommonTree)adaptor.becomeRoot(NEG158_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2389);
                    e=expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new NegativeExpression( plan, (e!=null?e.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)(e!=null?((CommonTree)e.start):null) ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:723:4: ^( CAST_EXPR type_cast e= expr[$plan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    CAST_EXPR159=(CommonTree)match(input,CAST_EXPR,FOLLOW_CAST_EXPR_in_expr2404); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CAST_EXPR159_tree = (CommonTree)adaptor.dupNode(CAST_EXPR159);


                    root_1 = (CommonTree)adaptor.becomeRoot(CAST_EXPR159_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_type_cast_in_expr2406);
                    type_cast160=type_cast();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, type_cast160.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2412);
                    e=expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new CastExpression( plan, (e!=null?e.expr:null), (type_cast160!=null?type_cast160.fieldSchema:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)(type_cast160!=null?((CommonTree)type_cast160.start):null) ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:728:4: ^( EXPR_IN_PAREN e= expr[$plan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    EXPR_IN_PAREN161=(CommonTree)match(input,EXPR_IN_PAREN,FOLLOW_EXPR_IN_PAREN_in_expr2428); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EXPR_IN_PAREN161_tree = (CommonTree)adaptor.dupNode(EXPR_IN_PAREN161);


                    root_1 = (CommonTree)adaptor.becomeRoot(EXPR_IN_PAREN161_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2434);
                    e=expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = (e!=null?e.expr:null);
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
        public LogicalFieldSchema fieldSchema;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "type_cast"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:734:1: type_cast returns [LogicalFieldSchema fieldSchema] : ( simple_type | map_type | tuple_type_cast | bag_type_cast );
    public final LogicalPlanGenerator.type_cast_return type_cast() throws RecognitionException {
        LogicalPlanGenerator.type_cast_return retval = new LogicalPlanGenerator.type_cast_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.simple_type_return simple_type162 =null;

        LogicalPlanGenerator.map_type_return map_type163 =null;

        LogicalPlanGenerator.tuple_type_cast_return tuple_type_cast164 =null;

        LogicalPlanGenerator.bag_type_cast_return bag_type_cast165 =null;



        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:735:2: ( simple_type | map_type | tuple_type_cast | bag_type_cast )
            int alt52=4;
            switch ( input.LA(1) ) {
            case BOOLEAN:
            case BYTEARRAY:
            case CHARARRAY:
            case DOUBLE:
            case FLOAT:
            case INT:
            case LONG:
                {
                alt52=1;
                }
                break;
            case MAP_TYPE:
                {
                alt52=2;
                }
                break;
            case TUPLE_TYPE_CAST:
                {
                alt52=3;
                }
                break;
            case BAG_TYPE_CAST:
                {
                alt52=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;

            }

            switch (alt52) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:735:4: simple_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_simple_type_in_type_cast2456);
                    simple_type162=simple_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, simple_type162.getTree());


                    if ( state.backtracking==0 ) {
                            retval.fieldSchema = new LogicalFieldSchema( null, null, (simple_type162!=null?simple_type162.datatype:0) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:739:4: map_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_map_type_in_type_cast2466);
                    map_type163=map_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, map_type163.getTree());


                    if ( state.backtracking==0 ) {
                           retval.fieldSchema = new LogicalFieldSchema( null, (map_type163!=null?map_type163.logicalSchema:null), DataType.MAP );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:743:4: tuple_type_cast
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_tuple_type_cast_in_type_cast2476);
                    tuple_type_cast164=tuple_type_cast();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, tuple_type_cast164.getTree());


                    if ( state.backtracking==0 ) {
                           retval.fieldSchema = new LogicalFieldSchema( null, (tuple_type_cast164!=null?tuple_type_cast164.logicalSchema:null), DataType.TUPLE );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:747:4: bag_type_cast
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_bag_type_cast_in_type_cast2486);
                    bag_type_cast165=bag_type_cast();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, bag_type_cast165.getTree());


                    if ( state.backtracking==0 ) {
                           retval.fieldSchema = new LogicalFieldSchema( null, (bag_type_cast165!=null?bag_type_cast165.logicalSchema:null), DataType.BAG );
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
    // $ANTLR end "type_cast"


    public static class tuple_type_cast_return extends TreeRuleReturnScope {
        public LogicalSchema logicalSchema;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "tuple_type_cast"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:753:1: tuple_type_cast returns [LogicalSchema logicalSchema] : ^( TUPLE_TYPE_CAST ( type_cast )* ) ;
    public final LogicalPlanGenerator.tuple_type_cast_return tuple_type_cast() throws RecognitionException {
        LogicalPlanGenerator.tuple_type_cast_return retval = new LogicalPlanGenerator.tuple_type_cast_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree TUPLE_TYPE_CAST166=null;
        LogicalPlanGenerator.type_cast_return type_cast167 =null;


        CommonTree TUPLE_TYPE_CAST166_tree=null;


            retval.logicalSchema = new LogicalSchema();

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:757:2: ( ^( TUPLE_TYPE_CAST ( type_cast )* ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:757:4: ^( TUPLE_TYPE_CAST ( type_cast )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            TUPLE_TYPE_CAST166=(CommonTree)match(input,TUPLE_TYPE_CAST,FOLLOW_TUPLE_TYPE_CAST_in_tuple_type_cast2511); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            TUPLE_TYPE_CAST166_tree = (CommonTree)adaptor.dupNode(TUPLE_TYPE_CAST166);


            root_1 = (CommonTree)adaptor.becomeRoot(TUPLE_TYPE_CAST166_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:757:23: ( type_cast )*
                loop53:
                do {
                    int alt53=2;
                    int LA53_0 = input.LA(1);

                    if ( (LA53_0==BOOLEAN||LA53_0==BYTEARRAY||LA53_0==CHARARRAY||LA53_0==DOUBLE||LA53_0==FLOAT||LA53_0==INT||LA53_0==LONG||LA53_0==BAG_TYPE_CAST||LA53_0==MAP_TYPE||LA53_0==TUPLE_TYPE_CAST) ) {
                        alt53=1;
                    }


                    switch (alt53) {
                	case 1 :
                	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:757:25: type_cast
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_type_cast_in_tuple_type_cast2515);
                	    type_cast167=type_cast();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, type_cast167.getTree());


                	    if ( state.backtracking==0 ) { retval.logicalSchema.addField( (type_cast167!=null?type_cast167.fieldSchema:null) ); }

                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop53;
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
        public LogicalSchema logicalSchema;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "bag_type_cast"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:760:1: bag_type_cast returns [LogicalSchema logicalSchema] : ^( BAG_TYPE_CAST ( tuple_type_cast )? ) ;
    public final LogicalPlanGenerator.bag_type_cast_return bag_type_cast() throws RecognitionException {
        LogicalPlanGenerator.bag_type_cast_return retval = new LogicalPlanGenerator.bag_type_cast_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BAG_TYPE_CAST168=null;
        LogicalPlanGenerator.tuple_type_cast_return tuple_type_cast169 =null;


        CommonTree BAG_TYPE_CAST168_tree=null;


            retval.logicalSchema = new LogicalSchema();

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:764:2: ( ^( BAG_TYPE_CAST ( tuple_type_cast )? ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:764:4: ^( BAG_TYPE_CAST ( tuple_type_cast )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BAG_TYPE_CAST168=(CommonTree)match(input,BAG_TYPE_CAST,FOLLOW_BAG_TYPE_CAST_in_bag_type_cast2542); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BAG_TYPE_CAST168_tree = (CommonTree)adaptor.dupNode(BAG_TYPE_CAST168);


            root_1 = (CommonTree)adaptor.becomeRoot(BAG_TYPE_CAST168_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:764:21: ( tuple_type_cast )?
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==TUPLE_TYPE_CAST) ) {
                    alt54=1;
                }
                switch (alt54) {
                    case 1 :
                        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:764:21: tuple_type_cast
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_tuple_type_cast_in_bag_type_cast2544);
                        tuple_type_cast169=tuple_type_cast();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, tuple_type_cast169.getTree());


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
                   retval.logicalSchema.addField( new LogicalFieldSchema( null, (tuple_type_cast169!=null?tuple_type_cast169.logicalSchema:null), DataType.TUPLE ) );
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
        public LogicalExpression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "var_expr"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:770:1: var_expr[LogicalExpressionPlan plan] returns [LogicalExpression expr] : projectable_expr[$plan] ( dot_proj | pound_proj )* ;
    public final LogicalPlanGenerator.var_expr_return var_expr(LogicalExpressionPlan plan) throws RecognitionException {
        LogicalPlanGenerator.var_expr_return retval = new LogicalPlanGenerator.var_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.projectable_expr_return projectable_expr170 =null;

        LogicalPlanGenerator.dot_proj_return dot_proj171 =null;

        LogicalPlanGenerator.pound_proj_return pound_proj172 =null;




            List<Object> columns = null;
            SourceLocation loc = new SourceLocation( (PigParserNode)((CommonTree)retval.start) );

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:775:2: ( projectable_expr[$plan] ( dot_proj | pound_proj )* )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:775:4: projectable_expr[$plan] ( dot_proj | pound_proj )*
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_projectable_expr_in_var_expr2571);
            projectable_expr170=projectable_expr(plan);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, projectable_expr170.getTree());


            if ( state.backtracking==0 ) { retval.expr = (projectable_expr170!=null?projectable_expr170.expr:null); }

            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:776:4: ( dot_proj | pound_proj )*
            loop55:
            do {
                int alt55=3;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==PERIOD) ) {
                    alt55=1;
                }
                else if ( (LA55_0==POUND) ) {
                    alt55=2;
                }


                switch (alt55) {
            	case 1 :
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:776:6: dot_proj
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_dot_proj_in_var_expr2581);
            	    dot_proj171=dot_proj();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, dot_proj171.getTree());


            	    if ( state.backtracking==0 ) {
            	             columns = (dot_proj171!=null?dot_proj171.cols:null);
            	             boolean processScalar = false;
            	             if( retval.expr instanceof ScalarExpression ) {
            	                 List<Operator> succs = plan.getSuccessors( retval.expr );
            	                 if( succs == null || succs.size() == 0 ) {
            	                     // We haven't process this scalar projection yet. Set the flag so as to process it next.
            	                     // This will handle a projection such as A.u.x, where we need to build ScalarExpression
            	                     // for A.u, while for x, we need to treat it as a normal dereference (on the output of
            	                     // the ScalarExpression.
            	                     processScalar = true;
            	                 }
            	             }
            	             
            	             if( processScalar ) {
            	                 // This is a scalar projection.
            	                 ScalarExpression scalarExpr = (ScalarExpression)retval.expr;
            	                 
            	                 if( (dot_proj171!=null?dot_proj171.cols:null).size() > 1 ) {
            	                     throw new InvalidScalarProjectionException( input, loc, scalarExpr );
            	                 }
            	                 
            	                 Object val = (dot_proj171!=null?dot_proj171.cols:null).get( 0 );
            	                 int pos = -1;
            	                 LogicalRelationalOperator relOp = (LogicalRelationalOperator)scalarExpr.getImplicitReferencedOperator();
            	                 LogicalSchema schema = null;
            	                 try {
            	                     schema = relOp.getSchema();
            	                 } catch(FrontendException e) {
            	                     throw new PlanGenerationFailureException( input, loc, e );
            	                 }
            	                 if( val instanceof Integer ) {
            	                     pos = (Integer)val;
            	                     if( schema != null && pos >= schema.size() ) {
            	                         throw new InvalidScalarProjectionException( input, loc, scalarExpr );
            	                     }
            	                 } else {
            	                     String colAlias = (String)val;
            	                     pos = schema.getFieldPosition( colAlias );
            	                     if( schema == null || pos == -1 ) {
            	                         throw new InvalidScalarProjectionException( input, loc, scalarExpr );
            	                     }
            	                 }
            	                 
            	                 ConstantExpression constExpr = new ConstantExpression( plan, pos);
            	                 plan.connect( retval.expr, constExpr );
            	                 constExpr = new ConstantExpression( plan, "filename"); // place holder for file name.
            	                 plan.connect( retval.expr, constExpr );
            	             } else {
            	                 DereferenceExpression e = new DereferenceExpression( plan );
            	                 e.setRawColumns( (dot_proj171!=null?dot_proj171.cols:null) );
            	                 e.setLocation( new SourceLocation( (PigParserNode)(dot_proj171!=null?((CommonTree)dot_proj171.start):null) ) );
            	                 plan.connect( e, retval.expr );
            	                 retval.expr = e;
            	             }
            	         }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;
            	case 2 :
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:833:6: pound_proj
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_pound_proj_in_var_expr2596);
            	    pound_proj172=pound_proj();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, pound_proj172.getTree());


            	    if ( state.backtracking==0 ) {
            	             MapLookupExpression e = new MapLookupExpression( plan, (pound_proj172!=null?pound_proj172.key:null) );
            	             e.setLocation( new SourceLocation( (PigParserNode)(pound_proj172!=null?((CommonTree)pound_proj172.start):null) ) );
            	             plan.connect( e, retval.expr );
            	             retval.expr = e;
            	         }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop55;
                }
            } while (true);


            if ( state.backtracking==0 ) {
                  if( ( retval.expr instanceof ScalarExpression ) && columns == null ) {
                      throw new InvalidScalarProjectionException( input, loc, (ScalarExpression)retval.expr, " : A column needs to be projected from a relation for it to be used as a scalar" );
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
    // $ANTLR end "var_expr"


    public static class projectable_expr_return extends TreeRuleReturnScope {
        public LogicalExpression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "projectable_expr"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:848:1: projectable_expr[LogicalExpressionPlan plan] returns [LogicalExpression expr] : ( func_eval[$plan] | col_ref[$plan] | bin_expr[$plan] );
    public final LogicalPlanGenerator.projectable_expr_return projectable_expr(LogicalExpressionPlan plan) throws RecognitionException {
        LogicalPlanGenerator.projectable_expr_return retval = new LogicalPlanGenerator.projectable_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.func_eval_return func_eval173 =null;

        LogicalPlanGenerator.col_ref_return col_ref174 =null;

        LogicalPlanGenerator.bin_expr_return bin_expr175 =null;



        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:849:2: ( func_eval[$plan] | col_ref[$plan] | bin_expr[$plan] )
            int alt56=3;
            switch ( input.LA(1) ) {
            case FUNC_EVAL:
                {
                alt56=1;
                }
                break;
            case DOLLARVAR:
            case GROUP:
            case IDENTIFIER:
                {
                alt56=2;
                }
                break;
            case BIN_EXPR:
                {
                alt56=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                throw nvae;

            }

            switch (alt56) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:849:4: func_eval[$plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_eval_in_projectable_expr2626);
                    func_eval173=func_eval(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, func_eval173.getTree());


                    if ( state.backtracking==0 ) {
                           retval.expr = (func_eval173!=null?func_eval173.expr:null);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:853:4: col_ref[$plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_projectable_expr2637);
                    col_ref174=col_ref(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_ref174.getTree());


                    if ( state.backtracking==0 ) {
                           retval.expr = (col_ref174!=null?col_ref174.expr:null);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:857:4: bin_expr[$plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_bin_expr_in_projectable_expr2648);
                    bin_expr175=bin_expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, bin_expr175.getTree());


                    if ( state.backtracking==0 ) {
                           retval.expr = (bin_expr175!=null?bin_expr175.expr:null);
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
    // $ANTLR end "projectable_expr"


    public static class dot_proj_return extends TreeRuleReturnScope {
        public List<Object> cols;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "dot_proj"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:863:1: dot_proj returns [List<Object> cols] : ^( PERIOD ( col_alias_or_index )+ ) ;
    public final LogicalPlanGenerator.dot_proj_return dot_proj() throws RecognitionException {
        LogicalPlanGenerator.dot_proj_return retval = new LogicalPlanGenerator.dot_proj_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PERIOD176=null;
        LogicalPlanGenerator.col_alias_or_index_return col_alias_or_index177 =null;


        CommonTree PERIOD176_tree=null;


            retval.cols = new ArrayList<Object>();

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:867:2: ( ^( PERIOD ( col_alias_or_index )+ ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:867:4: ^( PERIOD ( col_alias_or_index )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            PERIOD176=(CommonTree)match(input,PERIOD,FOLLOW_PERIOD_in_dot_proj2674); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PERIOD176_tree = (CommonTree)adaptor.dupNode(PERIOD176);


            root_1 = (CommonTree)adaptor.becomeRoot(PERIOD176_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:867:14: ( col_alias_or_index )+
            int cnt57=0;
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==DOLLARVAR||LA57_0==GROUP||LA57_0==IDENTIFIER) ) {
                    alt57=1;
                }


                switch (alt57) {
            	case 1 :
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:867:16: col_alias_or_index
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_col_alias_or_index_in_dot_proj2678);
            	    col_alias_or_index177=col_alias_or_index();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, col_alias_or_index177.getTree());


            	    if ( state.backtracking==0 ) { retval.cols.add( (col_alias_or_index177!=null?col_alias_or_index177.col:null) ); }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt57 >= 1 ) break loop57;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(57, input);
                        throw eee;
                }
                cnt57++;
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
        public Object col;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "col_alias_or_index"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:870:1: col_alias_or_index returns [Object col] : ( col_alias | col_index );
    public final LogicalPlanGenerator.col_alias_or_index_return col_alias_or_index() throws RecognitionException {
        LogicalPlanGenerator.col_alias_or_index_return retval = new LogicalPlanGenerator.col_alias_or_index_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.col_alias_return col_alias178 =null;

        LogicalPlanGenerator.col_index_return col_index179 =null;



        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:871:2: ( col_alias | col_index )
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==GROUP||LA58_0==IDENTIFIER) ) {
                alt58=1;
            }
            else if ( (LA58_0==DOLLARVAR) ) {
                alt58=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 58, 0, input);

                throw nvae;

            }
            switch (alt58) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:871:4: col_alias
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_alias_in_col_alias_or_index2698);
                    col_alias178=col_alias();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_alias178.getTree());


                    if ( state.backtracking==0 ) { retval.col = (col_alias178!=null?col_alias178.col:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:871:43: col_index
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_index_in_col_alias_or_index2704);
                    col_index179=col_index();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_index179.getTree());


                    if ( state.backtracking==0 ) { retval.col = (col_index179!=null?col_index179.col:null); }

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
        public Object col;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "col_alias"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:874:1: col_alias returns [Object col] : ( GROUP | IDENTIFIER );
    public final LogicalPlanGenerator.col_alias_return col_alias() throws RecognitionException {
        LogicalPlanGenerator.col_alias_return retval = new LogicalPlanGenerator.col_alias_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree GROUP180=null;
        CommonTree IDENTIFIER181=null;

        CommonTree GROUP180_tree=null;
        CommonTree IDENTIFIER181_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:875:2: ( GROUP | IDENTIFIER )
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==GROUP) ) {
                alt59=1;
            }
            else if ( (LA59_0==IDENTIFIER) ) {
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:875:4: GROUP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    GROUP180=(CommonTree)match(input,GROUP,FOLLOW_GROUP_in_col_alias2719); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    GROUP180_tree = (CommonTree)adaptor.dupNode(GROUP180);


                    adaptor.addChild(root_0, GROUP180_tree);
                    }


                    if ( state.backtracking==0 ) { retval.col = (GROUP180!=null?GROUP180.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:876:4: IDENTIFIER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER181=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_col_alias2726); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER181_tree = (CommonTree)adaptor.dupNode(IDENTIFIER181);


                    adaptor.addChild(root_0, IDENTIFIER181_tree);
                    }


                    if ( state.backtracking==0 ) { retval.col = (IDENTIFIER181!=null?IDENTIFIER181.getText():null); }

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
        public Integer col;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "col_index"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:879:1: col_index returns [Integer col] : DOLLARVAR ;
    public final LogicalPlanGenerator.col_index_return col_index() throws RecognitionException {
        LogicalPlanGenerator.col_index_return retval = new LogicalPlanGenerator.col_index_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DOLLARVAR182=null;

        CommonTree DOLLARVAR182_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:880:2: ( DOLLARVAR )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:880:4: DOLLARVAR
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            DOLLARVAR182=(CommonTree)match(input,DOLLARVAR,FOLLOW_DOLLARVAR_in_col_index2741); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DOLLARVAR182_tree = (CommonTree)adaptor.dupNode(DOLLARVAR182);


            adaptor.addChild(root_0, DOLLARVAR182_tree);
            }


            if ( state.backtracking==0 ) { retval.col = builder.undollar( (DOLLARVAR182!=null?DOLLARVAR182.getText():null) ); }

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
        public LogicalExpression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "col_range"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:884:1: col_range[LogicalExpressionPlan plan] returns [LogicalExpression expr] : ^( COL_RANGE (startExpr= col_ref[$plan] )? DOUBLE_PERIOD (endExpr= col_ref[$plan] )? ) ;
    public final LogicalPlanGenerator.col_range_return col_range(LogicalExpressionPlan plan) throws RecognitionException {
        LogicalPlanGenerator.col_range_return retval = new LogicalPlanGenerator.col_range_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree COL_RANGE183=null;
        CommonTree DOUBLE_PERIOD184=null;
        LogicalPlanGenerator.col_ref_return startExpr =null;

        LogicalPlanGenerator.col_ref_return endExpr =null;


        CommonTree COL_RANGE183_tree=null;
        CommonTree DOUBLE_PERIOD184_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:885:2: ( ^( COL_RANGE (startExpr= col_ref[$plan] )? DOUBLE_PERIOD (endExpr= col_ref[$plan] )? ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:885:5: ^( COL_RANGE (startExpr= col_ref[$plan] )? DOUBLE_PERIOD (endExpr= col_ref[$plan] )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            COL_RANGE183=(CommonTree)match(input,COL_RANGE,FOLLOW_COL_RANGE_in_col_range2760); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            COL_RANGE183_tree = (CommonTree)adaptor.dupNode(COL_RANGE183);


            root_1 = (CommonTree)adaptor.becomeRoot(COL_RANGE183_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:885:17: (startExpr= col_ref[$plan] )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==DOLLARVAR||LA60_0==GROUP||LA60_0==IDENTIFIER) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:885:18: startExpr= col_ref[$plan]
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_col_range2767);
                    startExpr=col_ref(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, startExpr.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            DOUBLE_PERIOD184=(CommonTree)match(input,DOUBLE_PERIOD,FOLLOW_DOUBLE_PERIOD_in_col_range2772); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DOUBLE_PERIOD184_tree = (CommonTree)adaptor.dupNode(DOUBLE_PERIOD184);


            adaptor.addChild(root_1, DOUBLE_PERIOD184_tree);
            }


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:885:61: (endExpr= col_ref[$plan] )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==DOLLARVAR||LA61_0==GROUP||LA61_0==IDENTIFIER) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:885:62: endExpr= col_ref[$plan]
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_col_range2779);
                    endExpr=col_ref(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, endExpr.getTree());


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
                    SourceLocation loc = new SourceLocation( (PigParserNode)((CommonTree)retval.start) );
                    retval.expr = builder.buildRangeProjectExpr(
                                loc, plan, ((GScope_scope)GScope_stack.peek()).currentOp,
                                ((statement_scope)statement_stack.peek()).inputIndex, 
                                (startExpr!=null?startExpr.expr:null), 
                                (endExpr!=null?endExpr.expr:null)
                            );
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
        public String key;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "pound_proj"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:897:1: pound_proj returns [String key] : ^( POUND ( QUOTEDSTRING | NULL ) ) ;
    public final LogicalPlanGenerator.pound_proj_return pound_proj() throws RecognitionException {
        LogicalPlanGenerator.pound_proj_return retval = new LogicalPlanGenerator.pound_proj_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree POUND185=null;
        CommonTree QUOTEDSTRING186=null;
        CommonTree NULL187=null;

        CommonTree POUND185_tree=null;
        CommonTree QUOTEDSTRING186_tree=null;
        CommonTree NULL187_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:898:2: ( ^( POUND ( QUOTEDSTRING | NULL ) ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:898:4: ^( POUND ( QUOTEDSTRING | NULL ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            POUND185=(CommonTree)match(input,POUND,FOLLOW_POUND_in_pound_proj2807); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            POUND185_tree = (CommonTree)adaptor.dupNode(POUND185);


            root_1 = (CommonTree)adaptor.becomeRoot(POUND185_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:898:13: ( QUOTEDSTRING | NULL )
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==QUOTEDSTRING) ) {
                alt62=1;
            }
            else if ( (LA62_0==NULL) ) {
                alt62=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 62, 0, input);

                throw nvae;

            }
            switch (alt62) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:898:15: QUOTEDSTRING
                    {
                    _last = (CommonTree)input.LT(1);
                    QUOTEDSTRING186=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_pound_proj2811); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    QUOTEDSTRING186_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING186);


                    adaptor.addChild(root_1, QUOTEDSTRING186_tree);
                    }


                    if ( state.backtracking==0 ) { retval.key = builder.unquote( (QUOTEDSTRING186!=null?QUOTEDSTRING186.getText():null) ); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:898:80: NULL
                    {
                    _last = (CommonTree)input.LT(1);
                    NULL187=(CommonTree)match(input,NULL,FOLLOW_NULL_in_pound_proj2817); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NULL187_tree = (CommonTree)adaptor.dupNode(NULL187);


                    adaptor.addChild(root_1, NULL187_tree);
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
    // $ANTLR end "pound_proj"


    public static class bin_expr_return extends TreeRuleReturnScope {
        public LogicalExpression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "bin_expr"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:901:1: bin_expr[LogicalExpressionPlan plan] returns [LogicalExpression expr] : ^( BIN_EXPR cond[$plan] e1= expr[$plan] e2= expr[$plan] ) ;
    public final LogicalPlanGenerator.bin_expr_return bin_expr(LogicalExpressionPlan plan) throws RecognitionException {
        LogicalPlanGenerator.bin_expr_return retval = new LogicalPlanGenerator.bin_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BIN_EXPR188=null;
        LogicalPlanGenerator.expr_return e1 =null;

        LogicalPlanGenerator.expr_return e2 =null;

        LogicalPlanGenerator.cond_return cond189 =null;


        CommonTree BIN_EXPR188_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:902:2: ( ^( BIN_EXPR cond[$plan] e1= expr[$plan] e2= expr[$plan] ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:902:4: ^( BIN_EXPR cond[$plan] e1= expr[$plan] e2= expr[$plan] )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BIN_EXPR188=(CommonTree)match(input,BIN_EXPR,FOLLOW_BIN_EXPR_in_bin_expr2837); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BIN_EXPR188_tree = (CommonTree)adaptor.dupNode(BIN_EXPR188);


            root_1 = (CommonTree)adaptor.becomeRoot(BIN_EXPR188_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_bin_expr2839);
            cond189=cond(plan);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond189.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expr_in_bin_expr2846);
            e1=expr(plan);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, e1.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expr_in_bin_expr2853);
            e2=expr(plan);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, e2.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   retval.expr = new BinCondExpression( plan, (cond189!=null?cond189.expr:null), (e1!=null?e1.expr:null), (e2!=null?e2.expr:null) );
                   retval.expr.setLocation( new SourceLocation( (PigParserNode)((CommonTree)retval.start) ) );
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
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "limit_clause"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:909:1: limit_clause returns [String alias] : ^( LIMIT rel ( INTEGER | LONGINTEGER | expr[exprPlan] ) ) ;
    public final LogicalPlanGenerator.limit_clause_return limit_clause() throws RecognitionException {
        GScope_stack.push(new GScope_scope());

        LogicalPlanGenerator.limit_clause_return retval = new LogicalPlanGenerator.limit_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree LIMIT190=null;
        CommonTree INTEGER192=null;
        CommonTree LONGINTEGER193=null;
        LogicalPlanGenerator.rel_return rel191 =null;

        LogicalPlanGenerator.expr_return expr194 =null;


        CommonTree LIMIT190_tree=null;
        CommonTree INTEGER192_tree=null;
        CommonTree LONGINTEGER193_tree=null;

         
            ((GScope_scope)GScope_stack.peek()).currentOp = builder.createLimitOp();
            LogicalExpressionPlan exprPlan = new LogicalExpressionPlan();

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:915:2: ( ^( LIMIT rel ( INTEGER | LONGINTEGER | expr[exprPlan] ) ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:915:5: ^( LIMIT rel ( INTEGER | LONGINTEGER | expr[exprPlan] ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            LIMIT190=(CommonTree)match(input,LIMIT,FOLLOW_LIMIT_in_limit_clause2887); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LIMIT190_tree = (CommonTree)adaptor.dupNode(LIMIT190);


            root_1 = (CommonTree)adaptor.becomeRoot(LIMIT190_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_limit_clause2889);
            rel191=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel191.getTree());


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:915:18: ( INTEGER | LONGINTEGER | expr[exprPlan] )
            int alt63=3;
            switch ( input.LA(1) ) {
            case INTEGER:
                {
                int LA63_1 = input.LA(2);

                if ( (synpred117_LogicalPlanGenerator()) ) {
                    alt63=1;
                }
                else if ( (true) ) {
                    alt63=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 63, 1, input);

                    throw nvae;

                }
                }
                break;
            case LONGINTEGER:
                {
                int LA63_2 = input.LA(2);

                if ( (synpred118_LogicalPlanGenerator()) ) {
                    alt63=2;
                }
                else if ( (true) ) {
                    alt63=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 63, 2, input);

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
                alt63=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 63, 0, input);

                throw nvae;

            }

            switch (alt63) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:915:20: INTEGER
                    {
                    _last = (CommonTree)input.LT(1);
                    INTEGER192=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_limit_clause2893); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INTEGER192_tree = (CommonTree)adaptor.dupNode(INTEGER192);


                    adaptor.addChild(root_1, INTEGER192_tree);
                    }


                    if ( state.backtracking==0 ) {
                           retval.alias = builder.buildLimitOp( new SourceLocation( (PigParserNode)LIMIT190 ), 
                             ((statement_scope)statement_stack.peek()).alias, ((statement_scope)statement_stack.peek()).inputAlias, Long.valueOf( (INTEGER192!=null?INTEGER192.getText():null) ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:920:4: LONGINTEGER
                    {
                    _last = (CommonTree)input.LT(1);
                    LONGINTEGER193=(CommonTree)match(input,LONGINTEGER,FOLLOW_LONGINTEGER_in_limit_clause2903); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LONGINTEGER193_tree = (CommonTree)adaptor.dupNode(LONGINTEGER193);


                    adaptor.addChild(root_1, LONGINTEGER193_tree);
                    }


                    if ( state.backtracking==0 ) {
                           retval.alias = builder.buildLimitOp( new SourceLocation( (PigParserNode)LIMIT190 ),
                             ((statement_scope)statement_stack.peek()).alias, ((statement_scope)statement_stack.peek()).inputAlias, builder.parseLong( (LONGINTEGER193!=null?LONGINTEGER193.getText():null) ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:925:4: expr[exprPlan]
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_limit_clause2913);
                    expr194=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr194.getTree());


                    if ( state.backtracking==0 ) {
                           retval.alias = builder.buildLimitOp( new SourceLocation( (PigParserNode)LIMIT190 ),
                               (LOLimit)((GScope_scope)GScope_stack.peek()).currentOp, ((statement_scope)statement_stack.peek()).alias, ((statement_scope)statement_stack.peek()).inputAlias, exprPlan);
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
            GScope_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "limit_clause"


    public static class sample_clause_return extends TreeRuleReturnScope {
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "sample_clause"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:933:1: sample_clause returns [String alias] : ^( SAMPLE rel ( DOUBLENUMBER | expr[exprPlan] ) ) ;
    public final LogicalPlanGenerator.sample_clause_return sample_clause() throws RecognitionException {
        GScope_stack.push(new GScope_scope());

        LogicalPlanGenerator.sample_clause_return retval = new LogicalPlanGenerator.sample_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SAMPLE195=null;
        CommonTree DOUBLENUMBER197=null;
        LogicalPlanGenerator.rel_return rel196 =null;

        LogicalPlanGenerator.expr_return expr198 =null;


        CommonTree SAMPLE195_tree=null;
        CommonTree DOUBLENUMBER197_tree=null;

         
            ((GScope_scope)GScope_stack.peek()).currentOp = builder.createSampleOp();
            LogicalExpressionPlan exprPlan = new LogicalExpressionPlan();

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:939:2: ( ^( SAMPLE rel ( DOUBLENUMBER | expr[exprPlan] ) ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:939:4: ^( SAMPLE rel ( DOUBLENUMBER | expr[exprPlan] ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            SAMPLE195=(CommonTree)match(input,SAMPLE,FOLLOW_SAMPLE_in_sample_clause2949); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SAMPLE195_tree = (CommonTree)adaptor.dupNode(SAMPLE195);


            root_1 = (CommonTree)adaptor.becomeRoot(SAMPLE195_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_sample_clause2951);
            rel196=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel196.getTree());


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:939:18: ( DOUBLENUMBER | expr[exprPlan] )
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==DOUBLENUMBER) ) {
                int LA64_1 = input.LA(2);

                if ( (synpred119_LogicalPlanGenerator()) ) {
                    alt64=1;
                }
                else if ( (true) ) {
                    alt64=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 64, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA64_0==DIV||LA64_0==DOLLARVAR||LA64_0==FALSE||LA64_0==FLOATNUMBER||LA64_0==GROUP||LA64_0==INTEGER||LA64_0==LONGINTEGER||LA64_0==MINUS||LA64_0==PERCENT||LA64_0==PLUS||LA64_0==QUOTEDSTRING||LA64_0==STAR||LA64_0==TRUE||(LA64_0 >= BAG_VAL && LA64_0 <= BIN_EXPR)||LA64_0==CAST_EXPR||LA64_0==EXPR_IN_PAREN||LA64_0==FUNC_EVAL||LA64_0==IDENTIFIER||(LA64_0 >= MAP_VAL && LA64_0 <= NEG)||LA64_0==NULL||LA64_0==TUPLE_VAL) ) {
                alt64=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 64, 0, input);

                throw nvae;

            }
            switch (alt64) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:939:20: DOUBLENUMBER
                    {
                    _last = (CommonTree)input.LT(1);
                    DOUBLENUMBER197=(CommonTree)match(input,DOUBLENUMBER,FOLLOW_DOUBLENUMBER_in_sample_clause2955); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DOUBLENUMBER197_tree = (CommonTree)adaptor.dupNode(DOUBLENUMBER197);


                    adaptor.addChild(root_1, DOUBLENUMBER197_tree);
                    }


                    if ( state.backtracking==0 ) {
                           retval.alias = builder.buildSampleOp( new SourceLocation( (PigParserNode)SAMPLE195 ), ((statement_scope)statement_stack.peek()).alias,
                               ((statement_scope)statement_stack.peek()).inputAlias, Double.valueOf( (DOUBLENUMBER197!=null?DOUBLENUMBER197.getText():null) ),
                               new SourceLocation( (PigParserNode)DOUBLENUMBER197 ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:945:4: expr[exprPlan]
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_sample_clause2965);
                    expr198=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr198.getTree());


                    if ( state.backtracking==0 ) {
                           retval.alias = builder.buildSampleOp( new SourceLocation( (PigParserNode)SAMPLE195 ),
                               (LOFilter)((GScope_scope)GScope_stack.peek()).currentOp, ((statement_scope)statement_stack.peek()).alias, ((statement_scope)statement_stack.peek()).inputAlias, exprPlan, (expr198!=null?expr198.expr:null));
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
            GScope_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "sample_clause"


    public static class order_clause_return extends TreeRuleReturnScope {
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "order_clause"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:953:1: order_clause returns [String alias] : ^( ORDER rel order_by_clause ( func_clause[FunctionType.COMPARISONFUNC] )? ) ;
    public final LogicalPlanGenerator.order_clause_return order_clause() throws RecognitionException {
        GScope_stack.push(new GScope_scope());

        LogicalPlanGenerator.order_clause_return retval = new LogicalPlanGenerator.order_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ORDER199=null;
        LogicalPlanGenerator.rel_return rel200 =null;

        LogicalPlanGenerator.order_by_clause_return order_by_clause201 =null;

        LogicalPlanGenerator.func_clause_return func_clause202 =null;


        CommonTree ORDER199_tree=null;


            ((GScope_scope)GScope_stack.peek()).currentOp = builder.createSortOp();

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:958:2: ( ^( ORDER rel order_by_clause ( func_clause[FunctionType.COMPARISONFUNC] )? ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:958:4: ^( ORDER rel order_by_clause ( func_clause[FunctionType.COMPARISONFUNC] )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            ORDER199=(CommonTree)match(input,ORDER,FOLLOW_ORDER_in_order_clause3002); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ORDER199_tree = (CommonTree)adaptor.dupNode(ORDER199);


            root_1 = (CommonTree)adaptor.becomeRoot(ORDER199_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_order_clause3004);
            rel200=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel200.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_order_by_clause_in_order_clause3006);
            order_by_clause201=order_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, order_by_clause201.getTree());


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:958:33: ( func_clause[FunctionType.COMPARISONFUNC] )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==FUNC||LA65_0==FUNC_REF) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:958:33: func_clause[FunctionType.COMPARISONFUNC]
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_order_clause3008);
                    func_clause202=func_clause(FunctionType.COMPARISONFUNC);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause202.getTree());


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
                   SourceLocation loc = new SourceLocation( (PigParserNode)ORDER199 );
                   retval.alias = builder.buildSortOp( loc, (LOSort)((GScope_scope)GScope_stack.peek()).currentOp, ((statement_scope)statement_stack.peek()).alias,
                       ((statement_scope)statement_stack.peek()).inputAlias, (order_by_clause201!=null?order_by_clause201.plans:null), 
                       (order_by_clause201!=null?order_by_clause201.ascFlags:null), (func_clause202!=null?func_clause202.funcSpec:null) );
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
            GScope_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "order_clause"


    public static class order_by_clause_return extends TreeRuleReturnScope {
        public List<LogicalExpressionPlan> plans;
        public List<Boolean> ascFlags;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "order_by_clause"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:967:1: order_by_clause returns [List<LogicalExpressionPlan> plans, List<Boolean> ascFlags] : ( STAR ( ASC | DESC )? | ( order_col )+ );
    public final LogicalPlanGenerator.order_by_clause_return order_by_clause() throws RecognitionException {
        LogicalPlanGenerator.order_by_clause_return retval = new LogicalPlanGenerator.order_by_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR203=null;
        CommonTree ASC204=null;
        CommonTree DESC205=null;
        LogicalPlanGenerator.order_col_return order_col206 =null;


        CommonTree STAR203_tree=null;
        CommonTree ASC204_tree=null;
        CommonTree DESC205_tree=null;


            retval.plans = new ArrayList<LogicalExpressionPlan>();
            retval.ascFlags = new ArrayList<Boolean>();

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:972:2: ( STAR ( ASC | DESC )? | ( order_col )+ )
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==STAR) ) {
                alt68=1;
            }
            else if ( (LA68_0==DOLLARVAR||LA68_0==GROUP||LA68_0==COL_RANGE||LA68_0==IDENTIFIER) ) {
                alt68=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 68, 0, input);

                throw nvae;

            }
            switch (alt68) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:972:4: STAR ( ASC | DESC )?
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR203=(CommonTree)match(input,STAR,FOLLOW_STAR_in_order_by_clause3035); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR203_tree = (CommonTree)adaptor.dupNode(STAR203);


                    adaptor.addChild(root_0, STAR203_tree);
                    }


                    if ( state.backtracking==0 ) {
                           LogicalExpressionPlan plan = new LogicalExpressionPlan();
                           builder.buildProjectExpr( new SourceLocation( (PigParserNode)STAR203 ), plan, ((GScope_scope)GScope_stack.peek()).currentOp,
                               ((statement_scope)statement_stack.peek()).inputIndex, null, -1 );
                           retval.plans.add( plan );
                       }

                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:978:4: ( ASC | DESC )?
                    int alt66=3;
                    int LA66_0 = input.LA(1);

                    if ( (LA66_0==ASC) ) {
                        alt66=1;
                    }
                    else if ( (LA66_0==DESC) ) {
                        alt66=2;
                    }
                    switch (alt66) {
                        case 1 :
                            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:978:6: ASC
                            {
                            _last = (CommonTree)input.LT(1);
                            ASC204=(CommonTree)match(input,ASC,FOLLOW_ASC_in_order_by_clause3044); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            ASC204_tree = (CommonTree)adaptor.dupNode(ASC204);


                            adaptor.addChild(root_0, ASC204_tree);
                            }


                            if ( state.backtracking==0 ) { retval.ascFlags.add( true ); }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;
                        case 2 :
                            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:978:39: DESC
                            {
                            _last = (CommonTree)input.LT(1);
                            DESC205=(CommonTree)match(input,DESC,FOLLOW_DESC_in_order_by_clause3050); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            DESC205_tree = (CommonTree)adaptor.dupNode(DESC205);


                            adaptor.addChild(root_0, DESC205_tree);
                            }


                            if ( state.backtracking==0 ) { retval.ascFlags.add( false ); }

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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:979:4: ( order_col )+
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:979:4: ( order_col )+
                    int cnt67=0;
                    loop67:
                    do {
                        int alt67=2;
                        int LA67_0 = input.LA(1);

                        if ( (LA67_0==DOLLARVAR||LA67_0==GROUP||LA67_0==COL_RANGE||LA67_0==IDENTIFIER) ) {
                            alt67=1;
                        }


                        switch (alt67) {
                    	case 1 :
                    	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:979:6: order_col
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_order_col_in_order_by_clause3062);
                    	    order_col206=order_col();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, order_col206.getTree());


                    	    if ( state.backtracking==0 ) {
                    	           retval.plans.add( (order_col206!=null?order_col206.plan:null) );
                    	           retval.ascFlags.add( (order_col206!=null?order_col206.ascFlag:null) );
                    	       }

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    if ( cnt67 >= 1 ) break loop67;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(67, input);
                                throw eee;
                        }
                        cnt67++;
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
        public LogicalExpressionPlan plan;
        public Boolean ascFlag;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "order_col"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:986:1: order_col returns [LogicalExpressionPlan plan, Boolean ascFlag] : ( col_range[$plan] ( ASC | DESC )? | col_ref[$plan] ( ASC | DESC )? );
    public final LogicalPlanGenerator.order_col_return order_col() throws RecognitionException {
        LogicalPlanGenerator.order_col_return retval = new LogicalPlanGenerator.order_col_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ASC208=null;
        CommonTree DESC209=null;
        CommonTree ASC211=null;
        CommonTree DESC212=null;
        LogicalPlanGenerator.col_range_return col_range207 =null;

        LogicalPlanGenerator.col_ref_return col_ref210 =null;


        CommonTree ASC208_tree=null;
        CommonTree DESC209_tree=null;
        CommonTree ASC211_tree=null;
        CommonTree DESC212_tree=null;

         
            retval.plan = new LogicalExpressionPlan();
            retval.ascFlag = true;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:991:2: ( col_range[$plan] ( ASC | DESC )? | col_ref[$plan] ( ASC | DESC )? )
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==COL_RANGE) ) {
                alt71=1;
            }
            else if ( (LA71_0==DOLLARVAR||LA71_0==GROUP||LA71_0==IDENTIFIER) ) {
                alt71=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 71, 0, input);

                throw nvae;

            }
            switch (alt71) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:991:4: col_range[$plan] ( ASC | DESC )?
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_order_col3088);
                    col_range207=col_range(retval.plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range207.getTree());


                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:991:21: ( ASC | DESC )?
                    int alt69=3;
                    int LA69_0 = input.LA(1);

                    if ( (LA69_0==ASC) ) {
                        alt69=1;
                    }
                    else if ( (LA69_0==DESC) ) {
                        alt69=2;
                    }
                    switch (alt69) {
                        case 1 :
                            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:991:22: ASC
                            {
                            _last = (CommonTree)input.LT(1);
                            ASC208=(CommonTree)match(input,ASC,FOLLOW_ASC_in_order_col3092); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            ASC208_tree = (CommonTree)adaptor.dupNode(ASC208);


                            adaptor.addChild(root_0, ASC208_tree);
                            }


                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;
                        case 2 :
                            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:991:28: DESC
                            {
                            _last = (CommonTree)input.LT(1);
                            DESC209=(CommonTree)match(input,DESC,FOLLOW_DESC_in_order_col3096); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            DESC209_tree = (CommonTree)adaptor.dupNode(DESC209);


                            adaptor.addChild(root_0, DESC209_tree);
                            }


                            if ( state.backtracking==0 ) { retval.ascFlag = false; }

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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:992:4: col_ref[$plan] ( ASC | DESC )?
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_order_col3106);
                    col_ref210=col_ref(retval.plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_ref210.getTree());


                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:992:19: ( ASC | DESC )?
                    int alt70=3;
                    int LA70_0 = input.LA(1);

                    if ( (LA70_0==ASC) ) {
                        alt70=1;
                    }
                    else if ( (LA70_0==DESC) ) {
                        alt70=2;
                    }
                    switch (alt70) {
                        case 1 :
                            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:992:21: ASC
                            {
                            _last = (CommonTree)input.LT(1);
                            ASC211=(CommonTree)match(input,ASC,FOLLOW_ASC_in_order_col3111); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            ASC211_tree = (CommonTree)adaptor.dupNode(ASC211);


                            adaptor.addChild(root_0, ASC211_tree);
                            }


                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;
                        case 2 :
                            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:992:27: DESC
                            {
                            _last = (CommonTree)input.LT(1);
                            DESC212=(CommonTree)match(input,DESC,FOLLOW_DESC_in_order_col3115); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            DESC212_tree = (CommonTree)adaptor.dupNode(DESC212);


                            adaptor.addChild(root_0, DESC212_tree);
                            }


                            if ( state.backtracking==0 ) { retval.ascFlag = false; }

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
    // $ANTLR end "order_col"


    public static class distinct_clause_return extends TreeRuleReturnScope {
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "distinct_clause"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:995:1: distinct_clause returns [String alias] : ^( DISTINCT rel ( partition_clause )? ) ;
    public final LogicalPlanGenerator.distinct_clause_return distinct_clause() throws RecognitionException {
        LogicalPlanGenerator.distinct_clause_return retval = new LogicalPlanGenerator.distinct_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DISTINCT213=null;
        LogicalPlanGenerator.rel_return rel214 =null;

        LogicalPlanGenerator.partition_clause_return partition_clause215 =null;


        CommonTree DISTINCT213_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:996:2: ( ^( DISTINCT rel ( partition_clause )? ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:996:4: ^( DISTINCT rel ( partition_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            DISTINCT213=(CommonTree)match(input,DISTINCT,FOLLOW_DISTINCT_in_distinct_clause3143); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DISTINCT213_tree = (CommonTree)adaptor.dupNode(DISTINCT213);


            root_1 = (CommonTree)adaptor.becomeRoot(DISTINCT213_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_distinct_clause3145);
            rel214=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel214.getTree());


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:996:20: ( partition_clause )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==PARTITION) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:996:20: partition_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_partition_clause_in_distinct_clause3147);
                    partition_clause215=partition_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, partition_clause215.getTree());


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
                   retval.alias = builder.buildDistinctOp( new SourceLocation( (PigParserNode)DISTINCT213 ), ((statement_scope)statement_stack.peek()).alias,
                      ((statement_scope)statement_stack.peek()).inputAlias, (partition_clause215!=null?partition_clause215.partitioner:null) );
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
        public String partitioner;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "partition_clause"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1003:1: partition_clause returns [String partitioner] : ^( PARTITION func_name ) ;
    public final LogicalPlanGenerator.partition_clause_return partition_clause() throws RecognitionException {
        LogicalPlanGenerator.partition_clause_return retval = new LogicalPlanGenerator.partition_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PARTITION216=null;
        LogicalPlanGenerator.func_name_return func_name217 =null;


        CommonTree PARTITION216_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1004:2: ( ^( PARTITION func_name ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1004:4: ^( PARTITION func_name )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            PARTITION216=(CommonTree)match(input,PARTITION,FOLLOW_PARTITION_in_partition_clause3170); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PARTITION216_tree = (CommonTree)adaptor.dupNode(PARTITION216);


            root_1 = (CommonTree)adaptor.becomeRoot(PARTITION216_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_func_name_in_partition_clause3172);
            func_name217=func_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, func_name217.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   retval.partitioner = (func_name217!=null?func_name217.funcName:null);
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
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cross_clause"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1010:1: cross_clause returns [String alias] : ^( CROSS rel_list ( partition_clause )? ) ;
    public final LogicalPlanGenerator.cross_clause_return cross_clause() throws RecognitionException {
        LogicalPlanGenerator.cross_clause_return retval = new LogicalPlanGenerator.cross_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CROSS218=null;
        LogicalPlanGenerator.rel_list_return rel_list219 =null;

        LogicalPlanGenerator.partition_clause_return partition_clause220 =null;


        CommonTree CROSS218_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1011:2: ( ^( CROSS rel_list ( partition_clause )? ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1011:4: ^( CROSS rel_list ( partition_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CROSS218=(CommonTree)match(input,CROSS,FOLLOW_CROSS_in_cross_clause3194); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CROSS218_tree = (CommonTree)adaptor.dupNode(CROSS218);


            root_1 = (CommonTree)adaptor.becomeRoot(CROSS218_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_list_in_cross_clause3196);
            rel_list219=rel_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel_list219.getTree());


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1011:22: ( partition_clause )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==PARTITION) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1011:22: partition_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_partition_clause_in_cross_clause3198);
                    partition_clause220=partition_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, partition_clause220.getTree());


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
                   retval.alias = builder.buildCrossOp( new SourceLocation( (PigParserNode)CROSS218 ), ((statement_scope)statement_stack.peek()).alias,
                      (rel_list219!=null?rel_list219.aliasList:null), (partition_clause220!=null?partition_clause220.partitioner:null) );
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
        public List<String> aliasList;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_list"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1018:1: rel_list returns [List<String> aliasList] : ( rel )+ ;
    public final LogicalPlanGenerator.rel_list_return rel_list() throws RecognitionException {
        LogicalPlanGenerator.rel_list_return retval = new LogicalPlanGenerator.rel_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.rel_return rel221 =null;



         retval.aliasList = new ArrayList<String>(); 
        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1020:2: ( ( rel )+ )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1020:4: ( rel )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1020:4: ( rel )+
            int cnt74=0;
            loop74:
            do {
                int alt74=2;
                int LA74_0 = input.LA(1);

                if ( (LA74_0==COGROUP||LA74_0==CROSS||LA74_0==DEFINE||LA74_0==DISTINCT||LA74_0==FILTER||LA74_0==FOREACH||LA74_0==GROUP||LA74_0==JOIN||(LA74_0 >= LIMIT && LA74_0 <= LOAD)||LA74_0==MAPREDUCE||LA74_0==ORDER||LA74_0==SAMPLE||(LA74_0 >= STORE && LA74_0 <= STREAM)||LA74_0==UNION||LA74_0==IDENTIFIER) ) {
                    alt74=1;
                }


                switch (alt74) {
            	case 1 :
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1020:6: rel
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_rel_in_rel_list3226);
            	    rel221=rel();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, rel221.getTree());


            	    if ( state.backtracking==0 ) { retval.aliasList.add( ((statement_scope)statement_stack.peek()).inputAlias ); }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt74 >= 1 ) break loop74;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(74, input);
                        throw eee;
                }
                cnt74++;
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
        MultiMap<Integer, LogicalExpressionPlan> joinPlans;
        int inputIndex;
        List<String> inputAliases;
        List<Boolean> innerFlags;
    }
    protected Stack join_clause_stack = new Stack();


    public static class join_clause_return extends TreeRuleReturnScope {
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "join_clause"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1023:1: join_clause returns [String alias] : ^( JOIN join_sub_clause ( join_type )? ( partition_clause )? ) ;
    public final LogicalPlanGenerator.join_clause_return join_clause() throws RecognitionException {
        GScope_stack.push(new GScope_scope());
        join_clause_stack.push(new join_clause_scope());
        LogicalPlanGenerator.join_clause_return retval = new LogicalPlanGenerator.join_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree JOIN222=null;
        LogicalPlanGenerator.join_sub_clause_return join_sub_clause223 =null;

        LogicalPlanGenerator.join_type_return join_type224 =null;

        LogicalPlanGenerator.partition_clause_return partition_clause225 =null;


        CommonTree JOIN222_tree=null;


            ((GScope_scope)GScope_stack.peek()).currentOp = builder.createJoinOp();
            ((join_clause_scope)join_clause_stack.peek()).joinPlans = new MultiMap<Integer, LogicalExpressionPlan>();
            ((join_clause_scope)join_clause_stack.peek()).inputAliases = new ArrayList<String>();
            ((join_clause_scope)join_clause_stack.peek()).innerFlags = new ArrayList<Boolean>();
            int oldStatementIndex = ((statement_scope)statement_stack.peek()).inputIndex;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1041:2: ( ^( JOIN join_sub_clause ( join_type )? ( partition_clause )? ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1041:4: ^( JOIN join_sub_clause ( join_type )? ( partition_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            JOIN222=(CommonTree)match(input,JOIN,FOLLOW_JOIN_in_join_clause3265); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            JOIN222_tree = (CommonTree)adaptor.dupNode(JOIN222);


            root_1 = (CommonTree)adaptor.becomeRoot(JOIN222_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_join_sub_clause_in_join_clause3267);
            join_sub_clause223=join_sub_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, join_sub_clause223.getTree());


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1041:28: ( join_type )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==QUOTEDSTRING) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1041:28: join_type
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_type_in_join_clause3269);
                    join_type224=join_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, join_type224.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1041:39: ( partition_clause )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==PARTITION) ) {
                alt76=1;
            }
            switch (alt76) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1041:39: partition_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_partition_clause_in_join_clause3272);
                    partition_clause225=partition_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, partition_clause225.getTree());


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
                   SourceLocation loc = new SourceLocation( (PigParserNode)JOIN222 );
                   retval.alias = builder.buildJoinOp( loc, (LOJoin)((GScope_scope)GScope_stack.peek()).currentOp, ((statement_scope)statement_stack.peek()).alias,
                      ((join_clause_scope)join_clause_stack.peek()).inputAliases, ((join_clause_scope)join_clause_stack.peek()).joinPlans,
                      (join_type224!=null?join_type224.type:null), ((join_clause_scope)join_clause_stack.peek()).innerFlags, (partition_clause225!=null?partition_clause225.partitioner:null) );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

            if ( state.backtracking==0 ) {
               ((statement_scope)statement_stack.peek()).inputIndex =oldStatementIndex;
            }
        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
            GScope_stack.pop();
            join_clause_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "join_clause"


    public static class join_type_return extends TreeRuleReturnScope {
        public JOINTYPE type;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "join_type"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1050:1: join_type returns [JOINTYPE type] : QUOTEDSTRING ;
    public final LogicalPlanGenerator.join_type_return join_type() throws RecognitionException {
        LogicalPlanGenerator.join_type_return retval = new LogicalPlanGenerator.join_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING226=null;

        CommonTree QUOTEDSTRING226_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1051:2: ( QUOTEDSTRING )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1051:4: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING226=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_join_type3293); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING226_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING226);


            adaptor.addChild(root_0, QUOTEDSTRING226_tree);
            }


            if ( state.backtracking==0 ) {
                   retval.type = builder.parseJoinType( (QUOTEDSTRING226!=null?QUOTEDSTRING226.getText():null), new SourceLocation( (PigParserNode)QUOTEDSTRING226 ) );
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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1057:1: join_sub_clause : ( join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item | ( join_item )+ );
    public final LogicalPlanGenerator.join_sub_clause_return join_sub_clause() throws RecognitionException {
        LogicalPlanGenerator.join_sub_clause_return retval = new LogicalPlanGenerator.join_sub_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree LEFT228=null;
        CommonTree RIGHT229=null;
        CommonTree FULL230=null;
        CommonTree OUTER231=null;
        LogicalPlanGenerator.join_item_return join_item227 =null;

        LogicalPlanGenerator.join_item_return join_item232 =null;

        LogicalPlanGenerator.join_item_return join_item233 =null;


        CommonTree LEFT228_tree=null;
        CommonTree RIGHT229_tree=null;
        CommonTree FULL230_tree=null;
        CommonTree OUTER231_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1058:2: ( join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item | ( join_item )+ )
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==JOIN_ITEM) ) {
                int LA80_1 = input.LA(2);

                if ( (synpred138_LogicalPlanGenerator()) ) {
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1058:4: join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_item_in_join_sub_clause3308);
                    join_item227=join_item();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, join_item227.getTree());


                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1058:14: ( LEFT | RIGHT | FULL )
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
                            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1058:16: LEFT
                            {
                            _last = (CommonTree)input.LT(1);
                            LEFT228=(CommonTree)match(input,LEFT,FOLLOW_LEFT_in_join_sub_clause3312); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            LEFT228_tree = (CommonTree)adaptor.dupNode(LEFT228);


                            adaptor.addChild(root_0, LEFT228_tree);
                            }


                            if ( state.backtracking==0 ) { ((join_clause_scope)join_clause_stack.peek()).innerFlags.add( true ); 
                                                  ((join_clause_scope)join_clause_stack.peek()).innerFlags.add( false ); }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;
                        case 2 :
                            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1060:16: RIGHT
                            {
                            _last = (CommonTree)input.LT(1);
                            RIGHT229=(CommonTree)match(input,RIGHT,FOLLOW_RIGHT_in_join_sub_clause3332); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            RIGHT229_tree = (CommonTree)adaptor.dupNode(RIGHT229);


                            adaptor.addChild(root_0, RIGHT229_tree);
                            }


                            if ( state.backtracking==0 ) { ((join_clause_scope)join_clause_stack.peek()).innerFlags.add( false ); 
                                                   ((join_clause_scope)join_clause_stack.peek()).innerFlags.add( true ); }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;
                        case 3 :
                            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1062:16: FULL
                            {
                            _last = (CommonTree)input.LT(1);
                            FULL230=(CommonTree)match(input,FULL,FOLLOW_FULL_in_join_sub_clause3351); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            FULL230_tree = (CommonTree)adaptor.dupNode(FULL230);


                            adaptor.addChild(root_0, FULL230_tree);
                            }


                            if ( state.backtracking==0 ) { ((join_clause_scope)join_clause_stack.peek()).innerFlags.add( false ); 
                                                  ((join_clause_scope)join_clause_stack.peek()).innerFlags.add( false ); }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1063:66: ( OUTER )?
                    int alt78=2;
                    int LA78_0 = input.LA(1);

                    if ( (LA78_0==OUTER) ) {
                        alt78=1;
                    }
                    switch (alt78) {
                        case 1 :
                            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1063:66: OUTER
                            {
                            _last = (CommonTree)input.LT(1);
                            OUTER231=(CommonTree)match(input,OUTER,FOLLOW_OUTER_in_join_sub_clause3357); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            OUTER231_tree = (CommonTree)adaptor.dupNode(OUTER231);


                            adaptor.addChild(root_0, OUTER231_tree);
                            }


                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_item_in_join_sub_clause3360);
                    join_item232=join_item();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, join_item232.getTree());


                    if ( state.backtracking==0 ) {
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1066:4: ( join_item )+
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1066:4: ( join_item )+
                    int cnt79=0;
                    loop79:
                    do {
                        int alt79=2;
                        int LA79_0 = input.LA(1);

                        if ( (LA79_0==JOIN_ITEM) ) {
                            alt79=1;
                        }


                        switch (alt79) {
                    	case 1 :
                    	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1066:4: join_item
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_join_item_in_join_sub_clause3370);
                    	    join_item233=join_item();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, join_item233.getTree());


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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1069:1: join_item : ^( JOIN_ITEM rel join_group_by_clause ) ;
    public final LogicalPlanGenerator.join_item_return join_item() throws RecognitionException {
        LogicalPlanGenerator.join_item_return retval = new LogicalPlanGenerator.join_item_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree JOIN_ITEM234=null;
        LogicalPlanGenerator.rel_return rel235 =null;

        LogicalPlanGenerator.join_group_by_clause_return join_group_by_clause236 =null;


        CommonTree JOIN_ITEM234_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1070:2: ( ^( JOIN_ITEM rel join_group_by_clause ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1070:4: ^( JOIN_ITEM rel join_group_by_clause )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            JOIN_ITEM234=(CommonTree)match(input,JOIN_ITEM,FOLLOW_JOIN_ITEM_in_join_item3383); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            JOIN_ITEM234_tree = (CommonTree)adaptor.dupNode(JOIN_ITEM234);


            root_1 = (CommonTree)adaptor.becomeRoot(JOIN_ITEM234_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_join_item3385);
            rel235=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel235.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_join_group_by_clause_in_join_item3387);
            join_group_by_clause236=join_group_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, join_group_by_clause236.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   ((join_clause_scope)join_clause_stack.peek()).inputAliases.add( ((statement_scope)statement_stack.peek()).inputAlias );
                   ((join_clause_scope)join_clause_stack.peek()).joinPlans.put( ((join_clause_scope)join_clause_stack.peek()).inputIndex, (join_group_by_clause236!=null?join_group_by_clause236.plans:null) );
                   ((join_clause_scope)join_clause_stack.peek()).inputIndex++;
                   ((statement_scope)statement_stack.peek()).inputIndex++;
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
        public List<LogicalExpressionPlan> plans;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "join_group_by_clause"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1079:1: join_group_by_clause returns [List<LogicalExpressionPlan> plans] : ^( BY ( join_group_by_expr )+ ) ;
    public final LogicalPlanGenerator.join_group_by_clause_return join_group_by_clause() throws RecognitionException {
        LogicalPlanGenerator.join_group_by_clause_return retval = new LogicalPlanGenerator.join_group_by_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BY237=null;
        LogicalPlanGenerator.join_group_by_expr_return join_group_by_expr238 =null;


        CommonTree BY237_tree=null;


            retval.plans = new ArrayList<LogicalExpressionPlan>();

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1083:2: ( ^( BY ( join_group_by_expr )+ ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1083:4: ^( BY ( join_group_by_expr )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BY237=(CommonTree)match(input,BY,FOLLOW_BY_in_join_group_by_clause3414); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BY237_tree = (CommonTree)adaptor.dupNode(BY237);


            root_1 = (CommonTree)adaptor.becomeRoot(BY237_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1083:10: ( join_group_by_expr )+
            int cnt81=0;
            loop81:
            do {
                int alt81=2;
                int LA81_0 = input.LA(1);

                if ( (LA81_0==DIV||LA81_0==DOLLARVAR||LA81_0==DOUBLENUMBER||LA81_0==FALSE||LA81_0==FLOATNUMBER||LA81_0==GROUP||LA81_0==INTEGER||LA81_0==LONGINTEGER||LA81_0==MINUS||LA81_0==PERCENT||LA81_0==PLUS||LA81_0==QUOTEDSTRING||LA81_0==STAR||LA81_0==TRUE||(LA81_0 >= BAG_VAL && LA81_0 <= BIN_EXPR)||(LA81_0 >= CAST_EXPR && LA81_0 <= EXPR_IN_PAREN)||LA81_0==FUNC_EVAL||LA81_0==IDENTIFIER||(LA81_0 >= MAP_VAL && LA81_0 <= NEG)||LA81_0==NULL||LA81_0==TUPLE_VAL) ) {
                    alt81=1;
                }


                switch (alt81) {
            	case 1 :
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1083:12: join_group_by_expr
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_join_group_by_expr_in_join_group_by_clause3418);
            	    join_group_by_expr238=join_group_by_expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, join_group_by_expr238.getTree());


            	    if ( state.backtracking==0 ) { retval.plans.add( (join_group_by_expr238!=null?join_group_by_expr238.plan:null) ); }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt81 >= 1 ) break loop81;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(81, input);
                        throw eee;
                }
                cnt81++;
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
        public LogicalExpressionPlan plan;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "join_group_by_expr"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1086:1: join_group_by_expr returns [LogicalExpressionPlan plan] : ( col_range[$plan] | expr[$plan] | STAR );
    public final LogicalPlanGenerator.join_group_by_expr_return join_group_by_expr() throws RecognitionException {
        LogicalPlanGenerator.join_group_by_expr_return retval = new LogicalPlanGenerator.join_group_by_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR241=null;
        LogicalPlanGenerator.col_range_return col_range239 =null;

        LogicalPlanGenerator.expr_return expr240 =null;


        CommonTree STAR241_tree=null;


            retval.plan = new LogicalExpressionPlan();

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1090:2: ( col_range[$plan] | expr[$plan] | STAR )
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1090:4: col_range[$plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_join_group_by_expr3443);
                    col_range239=col_range(retval.plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range239.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1091:4: expr[$plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_join_group_by_expr3449);
                    expr240=expr(retval.plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expr240.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1092:4: STAR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR241=(CommonTree)match(input,STAR,FOLLOW_STAR_in_join_group_by_expr3455); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR241_tree = (CommonTree)adaptor.dupNode(STAR241);


                    adaptor.addChild(root_0, STAR241_tree);
                    }


                    if ( state.backtracking==0 ) {
                           builder.buildProjectExpr( new SourceLocation( (PigParserNode)STAR241 ), retval.plan, ((GScope_scope)GScope_stack.peek()).currentOp, 
                               ((statement_scope)statement_stack.peek()).inputIndex, null, -1 );
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
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "union_clause"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1099:1: union_clause returns [String alias] : ^( UNION ( ONSCHEMA )? rel_list ) ;
    public final LogicalPlanGenerator.union_clause_return union_clause() throws RecognitionException {
        LogicalPlanGenerator.union_clause_return retval = new LogicalPlanGenerator.union_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree UNION242=null;
        CommonTree ONSCHEMA243=null;
        LogicalPlanGenerator.rel_list_return rel_list244 =null;


        CommonTree UNION242_tree=null;
        CommonTree ONSCHEMA243_tree=null;


            boolean onSchema = false;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1103:2: ( ^( UNION ( ONSCHEMA )? rel_list ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1103:4: ^( UNION ( ONSCHEMA )? rel_list )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            UNION242=(CommonTree)match(input,UNION,FOLLOW_UNION_in_union_clause3481); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            UNION242_tree = (CommonTree)adaptor.dupNode(UNION242);


            root_1 = (CommonTree)adaptor.becomeRoot(UNION242_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1103:13: ( ONSCHEMA )?
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==ONSCHEMA) ) {
                alt83=1;
            }
            switch (alt83) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1103:15: ONSCHEMA
                    {
                    _last = (CommonTree)input.LT(1);
                    ONSCHEMA243=(CommonTree)match(input,ONSCHEMA,FOLLOW_ONSCHEMA_in_union_clause3485); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ONSCHEMA243_tree = (CommonTree)adaptor.dupNode(ONSCHEMA243);


                    adaptor.addChild(root_1, ONSCHEMA243_tree);
                    }


                    if ( state.backtracking==0 ) { onSchema = true; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_list_in_union_clause3492);
            rel_list244=rel_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel_list244.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                  retval.alias = builder.buildUnionOp( new SourceLocation( (PigParserNode)UNION242 ), ((statement_scope)statement_stack.peek()).alias, 
                      (rel_list244!=null?rel_list244.aliasList:null), onSchema );
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


    protected static class foreach_clause_scope {
        LOForEach foreachOp;
    }
    protected Stack foreach_clause_stack = new Stack();


    public static class foreach_clause_return extends TreeRuleReturnScope {
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "foreach_clause"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1110:1: foreach_clause returns [String alias] : ^( FOREACH rel foreach_plan ) ;
    public final LogicalPlanGenerator.foreach_clause_return foreach_clause() throws RecognitionException {
        GScope_stack.push(new GScope_scope());
        foreach_clause_stack.push(new foreach_clause_scope());
        LogicalPlanGenerator.foreach_clause_return retval = new LogicalPlanGenerator.foreach_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FOREACH245=null;
        LogicalPlanGenerator.rel_return rel246 =null;

        LogicalPlanGenerator.foreach_plan_return foreach_plan247 =null;


        CommonTree FOREACH245_tree=null;


             ((foreach_clause_scope)foreach_clause_stack.peek()).foreachOp = builder.createForeachOp();
             ((GScope_scope)GScope_stack.peek()).currentOp = ((foreach_clause_scope)foreach_clause_stack.peek()).foreachOp;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1119:2: ( ^( FOREACH rel foreach_plan ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1119:4: ^( FOREACH rel foreach_plan )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FOREACH245=(CommonTree)match(input,FOREACH,FOLLOW_FOREACH_in_foreach_clause3528); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FOREACH245_tree = (CommonTree)adaptor.dupNode(FOREACH245);


            root_1 = (CommonTree)adaptor.becomeRoot(FOREACH245_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_foreach_clause3530);
            rel246=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel246.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_foreach_plan_in_foreach_clause3532);
            foreach_plan247=foreach_plan();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, foreach_plan247.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   SourceLocation loc = new SourceLocation( (PigParserNode)FOREACH245 );
                   retval.alias = builder.buildForeachOp( loc, ((foreach_clause_scope)foreach_clause_stack.peek()).foreachOp, ((statement_scope)statement_stack.peek()).alias,
                      ((statement_scope)statement_stack.peek()).inputAlias, (foreach_plan247!=null?foreach_plan247.plan:null) );
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
            GScope_stack.pop();
            foreach_clause_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "foreach_clause"


    protected static class foreach_plan_scope {
        LogicalPlan innerPlan;
        Map<String, LogicalExpressionPlan> exprPlans;
        Map<String, Operator> operators;
    }
    protected Stack foreach_plan_stack = new Stack();


    public static class foreach_plan_return extends TreeRuleReturnScope {
        public LogicalPlan plan;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "foreach_plan"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1127:1: foreach_plan returns [LogicalPlan plan] : ( ^( FOREACH_PLAN_SIMPLE generate_clause ) | ^( FOREACH_PLAN_COMPLEX nested_blk ) );
    public final LogicalPlanGenerator.foreach_plan_return foreach_plan() throws RecognitionException {
        foreach_plan_stack.push(new foreach_plan_scope());
        LogicalPlanGenerator.foreach_plan_return retval = new LogicalPlanGenerator.foreach_plan_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FOREACH_PLAN_SIMPLE248=null;
        CommonTree FOREACH_PLAN_COMPLEX250=null;
        LogicalPlanGenerator.generate_clause_return generate_clause249 =null;

        LogicalPlanGenerator.nested_blk_return nested_blk251 =null;


        CommonTree FOREACH_PLAN_SIMPLE248_tree=null;
        CommonTree FOREACH_PLAN_COMPLEX250_tree=null;


            inForeachPlan = true;
            ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan = new LogicalPlan();
            ((foreach_plan_scope)foreach_plan_stack.peek()).exprPlans = new HashMap<String, LogicalExpressionPlan>();
            ((foreach_plan_scope)foreach_plan_stack.peek()).operators = new HashMap<String, Operator>();

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1143:2: ( ^( FOREACH_PLAN_SIMPLE generate_clause ) | ^( FOREACH_PLAN_COMPLEX nested_blk ) )
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1143:4: ^( FOREACH_PLAN_SIMPLE generate_clause )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FOREACH_PLAN_SIMPLE248=(CommonTree)match(input,FOREACH_PLAN_SIMPLE,FOLLOW_FOREACH_PLAN_SIMPLE_in_foreach_plan3568); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FOREACH_PLAN_SIMPLE248_tree = (CommonTree)adaptor.dupNode(FOREACH_PLAN_SIMPLE248);


                    root_1 = (CommonTree)adaptor.becomeRoot(FOREACH_PLAN_SIMPLE248_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_generate_clause_in_foreach_plan3570);
                    generate_clause249=generate_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, generate_clause249.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1144:4: ^( FOREACH_PLAN_COMPLEX nested_blk )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FOREACH_PLAN_COMPLEX250=(CommonTree)match(input,FOREACH_PLAN_COMPLEX,FOLLOW_FOREACH_PLAN_COMPLEX_in_foreach_plan3579); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FOREACH_PLAN_COMPLEX250_tree = (CommonTree)adaptor.dupNode(FOREACH_PLAN_COMPLEX250);


                    root_1 = (CommonTree)adaptor.becomeRoot(FOREACH_PLAN_COMPLEX250_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_blk_in_foreach_plan3581);
                    nested_blk251=nested_blk();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, nested_blk251.getTree());


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

            if ( state.backtracking==0 ) {
                retval.plan = ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan;
                inForeachPlan = false;
            }
        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
            foreach_plan_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "foreach_plan"


    public static class nested_blk_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_blk"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1147:1: nested_blk : ( nested_command )* generate_clause ;
    public final LogicalPlanGenerator.nested_blk_return nested_blk() throws RecognitionException {
        LogicalPlanGenerator.nested_blk_return retval = new LogicalPlanGenerator.nested_blk_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.nested_command_return nested_command252 =null;

        LogicalPlanGenerator.generate_clause_return generate_clause253 =null;



        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1147:12: ( ( nested_command )* generate_clause )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1147:14: ( nested_command )* generate_clause
            {
            root_0 = (CommonTree)adaptor.nil();


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1147:14: ( nested_command )*
            loop85:
            do {
                int alt85=2;
                int LA85_0 = input.LA(1);

                if ( ((LA85_0 >= NESTED_CMD && LA85_0 <= NESTED_CMD_ASSI)) ) {
                    alt85=1;
                }


                switch (alt85) {
            	case 1 :
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1147:14: nested_command
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_nested_command_in_nested_blk3592);
            	    nested_command252=nested_command();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, nested_command252.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop85;
                }
            } while (true);


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_generate_clause_in_nested_blk3595);
            generate_clause253=generate_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, generate_clause253.getTree());


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


    public static class nested_command_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_command"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1150:1: nested_command : ( ^( NESTED_CMD IDENTIFIER nested_op[$IDENTIFIER.text] ) | ^( NESTED_CMD_ASSI IDENTIFIER expr[exprPlan] ) );
    public final LogicalPlanGenerator.nested_command_return nested_command() throws RecognitionException {
        LogicalPlanGenerator.nested_command_return retval = new LogicalPlanGenerator.nested_command_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree NESTED_CMD254=null;
        CommonTree IDENTIFIER255=null;
        CommonTree NESTED_CMD_ASSI257=null;
        CommonTree IDENTIFIER258=null;
        LogicalPlanGenerator.nested_op_return nested_op256 =null;

        LogicalPlanGenerator.expr_return expr259 =null;


        CommonTree NESTED_CMD254_tree=null;
        CommonTree IDENTIFIER255_tree=null;
        CommonTree NESTED_CMD_ASSI257_tree=null;
        CommonTree IDENTIFIER258_tree=null;


            LogicalExpressionPlan exprPlan = new LogicalExpressionPlan();
            inNestedCommand = true;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1158:2: ( ^( NESTED_CMD IDENTIFIER nested_op[$IDENTIFIER.text] ) | ^( NESTED_CMD_ASSI IDENTIFIER expr[exprPlan] ) )
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==NESTED_CMD) ) {
                alt86=1;
            }
            else if ( (LA86_0==NESTED_CMD_ASSI) ) {
                alt86=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 86, 0, input);

                throw nvae;

            }
            switch (alt86) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1158:4: ^( NESTED_CMD IDENTIFIER nested_op[$IDENTIFIER.text] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NESTED_CMD254=(CommonTree)match(input,NESTED_CMD,FOLLOW_NESTED_CMD_in_nested_command3617); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NESTED_CMD254_tree = (CommonTree)adaptor.dupNode(NESTED_CMD254);


                    root_1 = (CommonTree)adaptor.becomeRoot(NESTED_CMD254_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER255=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_nested_command3619); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER255_tree = (CommonTree)adaptor.dupNode(IDENTIFIER255);


                    adaptor.addChild(root_1, IDENTIFIER255_tree);
                    }


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_op_in_nested_command3621);
                    nested_op256=nested_op((IDENTIFIER255!=null?IDENTIFIER255.getText():null));

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, nested_op256.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           ((foreach_plan_scope)foreach_plan_stack.peek()).operators.put( (IDENTIFIER255!=null?IDENTIFIER255.getText():null), (nested_op256!=null?nested_op256.op:null) );
                           ((foreach_plan_scope)foreach_plan_stack.peek()).exprPlans.remove( (IDENTIFIER255!=null?IDENTIFIER255.getText():null) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1164:4: ^( NESTED_CMD_ASSI IDENTIFIER expr[exprPlan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NESTED_CMD_ASSI257=(CommonTree)match(input,NESTED_CMD_ASSI,FOLLOW_NESTED_CMD_ASSI_in_nested_command3640); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NESTED_CMD_ASSI257_tree = (CommonTree)adaptor.dupNode(NESTED_CMD_ASSI257);


                    root_1 = (CommonTree)adaptor.becomeRoot(NESTED_CMD_ASSI257_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER258=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_nested_command3642); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER258_tree = (CommonTree)adaptor.dupNode(IDENTIFIER258);


                    adaptor.addChild(root_1, IDENTIFIER258_tree);
                    }


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_nested_command3644);
                    expr259=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr259.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                            ((foreach_plan_scope)foreach_plan_stack.peek()).exprPlans.put( (IDENTIFIER258!=null?IDENTIFIER258.getText():null), exprPlan );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

            if ( state.backtracking==0 ) {
            	inNestedCommand = false;
            }
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
        public Operator op;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_op"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1170:1: nested_op[String alias] returns [Operator op] : ( nested_proj[$alias] | nested_filter[$alias] | nested_sort[$alias] | nested_distinct[$alias] | nested_limit[$alias] | nested_cross[$alias] | nested_foreach[$alias] );
    public final LogicalPlanGenerator.nested_op_return nested_op(String alias) throws RecognitionException {
        LogicalPlanGenerator.nested_op_return retval = new LogicalPlanGenerator.nested_op_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.nested_proj_return nested_proj260 =null;

        LogicalPlanGenerator.nested_filter_return nested_filter261 =null;

        LogicalPlanGenerator.nested_sort_return nested_sort262 =null;

        LogicalPlanGenerator.nested_distinct_return nested_distinct263 =null;

        LogicalPlanGenerator.nested_limit_return nested_limit264 =null;

        LogicalPlanGenerator.nested_cross_return nested_cross265 =null;

        LogicalPlanGenerator.nested_foreach_return nested_foreach266 =null;



        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1171:2: ( nested_proj[$alias] | nested_filter[$alias] | nested_sort[$alias] | nested_distinct[$alias] | nested_limit[$alias] | nested_cross[$alias] | nested_foreach[$alias] )
            int alt87=7;
            switch ( input.LA(1) ) {
            case NESTED_PROJ:
                {
                alt87=1;
                }
                break;
            case FILTER:
                {
                alt87=2;
                }
                break;
            case ORDER:
                {
                alt87=3;
                }
                break;
            case DISTINCT:
                {
                alt87=4;
                }
                break;
            case LIMIT:
                {
                alt87=5;
                }
                break;
            case CROSS:
                {
                alt87=6;
                }
                break;
            case FOREACH:
                {
                alt87=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 87, 0, input);

                throw nvae;

            }

            switch (alt87) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1171:4: nested_proj[$alias]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_proj_in_nested_op3666);
                    nested_proj260=nested_proj(alias);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_proj260.getTree());


                    if ( state.backtracking==0 ) { retval.op = (nested_proj260!=null?nested_proj260.op:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1172:4: nested_filter[$alias]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_filter_in_nested_op3674);
                    nested_filter261=nested_filter(alias);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_filter261.getTree());


                    if ( state.backtracking==0 ) { retval.op = (nested_filter261!=null?nested_filter261.op:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1173:4: nested_sort[$alias]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_sort_in_nested_op3682);
                    nested_sort262=nested_sort(alias);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_sort262.getTree());


                    if ( state.backtracking==0 ) { retval.op = (nested_sort262!=null?nested_sort262.op:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1174:4: nested_distinct[$alias]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_distinct_in_nested_op3691);
                    nested_distinct263=nested_distinct(alias);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_distinct263.getTree());


                    if ( state.backtracking==0 ) { retval.op = (nested_distinct263!=null?nested_distinct263.op:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1175:4: nested_limit[$alias]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_limit_in_nested_op3699);
                    nested_limit264=nested_limit(alias);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_limit264.getTree());


                    if ( state.backtracking==0 ) { retval.op = (nested_limit264!=null?nested_limit264.op:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1176:4: nested_cross[$alias]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_cross_in_nested_op3707);
                    nested_cross265=nested_cross(alias);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_cross265.getTree());


                    if ( state.backtracking==0 ) { retval.op = (nested_cross265!=null?nested_cross265.op:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1177:4: nested_foreach[$alias]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_foreach_in_nested_op3715);
                    nested_foreach266=nested_foreach(alias);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_foreach266.getTree());


                    if ( state.backtracking==0 ) { retval.op = (nested_foreach266!=null?nested_foreach266.op:null); }

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
        public Operator op;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_proj"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1180:1: nested_proj[String alias] returns [Operator op] : ^( NESTED_PROJ cr0= col_ref[plan] (cr= col_ref[new LogicalExpressionPlan()] )+ ) ;
    public final LogicalPlanGenerator.nested_proj_return nested_proj(String alias) throws RecognitionException {
        LogicalPlanGenerator.nested_proj_return retval = new LogicalPlanGenerator.nested_proj_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree NESTED_PROJ267=null;
        LogicalPlanGenerator.col_ref_return cr0 =null;

        LogicalPlanGenerator.col_ref_return cr =null;


        CommonTree NESTED_PROJ267_tree=null;


            LogicalExpressionPlan plan = new LogicalExpressionPlan();
            List<LogicalExpressionPlan> plans = new ArrayList<LogicalExpressionPlan>();

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1185:2: ( ^( NESTED_PROJ cr0= col_ref[plan] (cr= col_ref[new LogicalExpressionPlan()] )+ ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1185:4: ^( NESTED_PROJ cr0= col_ref[plan] (cr= col_ref[new LogicalExpressionPlan()] )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            NESTED_PROJ267=(CommonTree)match(input,NESTED_PROJ,FOLLOW_NESTED_PROJ_in_nested_proj3739); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NESTED_PROJ267_tree = (CommonTree)adaptor.dupNode(NESTED_PROJ267);


            root_1 = (CommonTree)adaptor.becomeRoot(NESTED_PROJ267_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_col_ref_in_nested_proj3751);
            cr0=col_ref(plan);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cr0.getTree());


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1187:7: (cr= col_ref[new LogicalExpressionPlan()] )+
            int cnt88=0;
            loop88:
            do {
                int alt88=2;
                int LA88_0 = input.LA(1);

                if ( (LA88_0==DOLLARVAR||LA88_0==GROUP||LA88_0==IDENTIFIER) ) {
                    alt88=1;
                }


                switch (alt88) {
            	case 1 :
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1187:9: cr= col_ref[new LogicalExpressionPlan()]
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_col_ref_in_nested_proj3766);
            	    cr=col_ref(new LogicalExpressionPlan());

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, cr.getTree());


            	    if ( state.backtracking==0 ) {
            	                plans.add( (LogicalExpressionPlan)( (cr!=null?cr.expr:null).getPlan() ) );
            	            }

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


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   SourceLocation loc = new SourceLocation( (PigParserNode)(cr0!=null?((CommonTree)cr0.start):null) );
                   retval.op = builder.buildNestedProjectOp( loc, ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan, ((foreach_clause_scope)foreach_clause_stack.peek()).foreachOp, 
                       ((foreach_plan_scope)foreach_plan_stack.peek()).operators, alias, (ProjectExpression)(cr0!=null?cr0.expr:null), plans );
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
        public Operator op;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_filter"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1199:1: nested_filter[String alias] returns [Operator op] : ^( FILTER nested_op_input cond[plan] ) ;
    public final LogicalPlanGenerator.nested_filter_return nested_filter(String alias) throws RecognitionException {
        GScope_stack.push(new GScope_scope());

        LogicalPlanGenerator.nested_filter_return retval = new LogicalPlanGenerator.nested_filter_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FILTER268=null;
        LogicalPlanGenerator.nested_op_input_return nested_op_input269 =null;

        LogicalPlanGenerator.cond_return cond270 =null;


        CommonTree FILTER268_tree=null;


            LogicalExpressionPlan plan = new LogicalExpressionPlan();
            Operator inputOp = null;
            ((GScope_scope)GScope_stack.peek()).currentOp = builder.createNestedFilterOp( ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan );

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1206:2: ( ^( FILTER nested_op_input cond[plan] ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1206:4: ^( FILTER nested_op_input cond[plan] )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FILTER268=(CommonTree)match(input,FILTER,FOLLOW_FILTER_in_nested_filter3819); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FILTER268_tree = (CommonTree)adaptor.dupNode(FILTER268);


            root_1 = (CommonTree)adaptor.becomeRoot(FILTER268_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_filter3821);
            nested_op_input269=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input269.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_nested_filter3823);
            cond270=cond(plan);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond270.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   SourceLocation loc = new SourceLocation( (PigParserNode)FILTER268 );
                   retval.op = builder.buildNestedFilterOp( loc, (LOFilter)((GScope_scope)GScope_stack.peek()).currentOp, ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan, alias, 
                       (nested_op_input269!=null?nested_op_input269.op:null), plan );
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
            GScope_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "nested_filter"


    public static class nested_sort_return extends TreeRuleReturnScope {
        public Operator op;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_sort"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1214:1: nested_sort[String alias] returns [Operator op] : ^( ORDER nested_op_input order_by_clause ( func_clause[FunctionType.COMPARISONFUNC] )? ) ;
    public final LogicalPlanGenerator.nested_sort_return nested_sort(String alias) throws RecognitionException {
        GScope_stack.push(new GScope_scope());

        LogicalPlanGenerator.nested_sort_return retval = new LogicalPlanGenerator.nested_sort_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ORDER271=null;
        LogicalPlanGenerator.nested_op_input_return nested_op_input272 =null;

        LogicalPlanGenerator.order_by_clause_return order_by_clause273 =null;

        LogicalPlanGenerator.func_clause_return func_clause274 =null;


        CommonTree ORDER271_tree=null;


            Operator inputOp = null;
            ((GScope_scope)GScope_stack.peek()).currentOp = builder.createNestedSortOp( ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan );

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1220:2: ( ^( ORDER nested_op_input order_by_clause ( func_clause[FunctionType.COMPARISONFUNC] )? ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1220:4: ^( ORDER nested_op_input order_by_clause ( func_clause[FunctionType.COMPARISONFUNC] )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            ORDER271=(CommonTree)match(input,ORDER,FOLLOW_ORDER_in_nested_sort3857); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ORDER271_tree = (CommonTree)adaptor.dupNode(ORDER271);


            root_1 = (CommonTree)adaptor.becomeRoot(ORDER271_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_sort3859);
            nested_op_input272=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input272.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_order_by_clause_in_nested_sort3861);
            order_by_clause273=order_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, order_by_clause273.getTree());


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1220:45: ( func_clause[FunctionType.COMPARISONFUNC] )?
            int alt89=2;
            int LA89_0 = input.LA(1);

            if ( (LA89_0==FUNC||LA89_0==FUNC_REF) ) {
                alt89=1;
            }
            switch (alt89) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1220:45: func_clause[FunctionType.COMPARISONFUNC]
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_nested_sort3863);
                    func_clause274=func_clause(FunctionType.COMPARISONFUNC);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause274.getTree());


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
                   SourceLocation loc = new SourceLocation( (PigParserNode)ORDER271 );
                   retval.op = builder.buildNestedSortOp( loc, (LOSort)((GScope_scope)GScope_stack.peek()).currentOp, ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan, alias,
                       (nested_op_input272!=null?nested_op_input272.op:null), 
                       (order_by_clause273!=null?order_by_clause273.plans:null), (order_by_clause273!=null?order_by_clause273.ascFlags:null), (func_clause274!=null?func_clause274.funcSpec:null) );
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
            GScope_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "nested_sort"


    public static class nested_distinct_return extends TreeRuleReturnScope {
        public Operator op;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_distinct"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1229:1: nested_distinct[String alias] returns [Operator op] : ^( DISTINCT nested_op_input ) ;
    public final LogicalPlanGenerator.nested_distinct_return nested_distinct(String alias) throws RecognitionException {
        LogicalPlanGenerator.nested_distinct_return retval = new LogicalPlanGenerator.nested_distinct_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DISTINCT275=null;
        LogicalPlanGenerator.nested_op_input_return nested_op_input276 =null;


        CommonTree DISTINCT275_tree=null;


            Operator inputOp = null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1233:2: ( ^( DISTINCT nested_op_input ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1233:4: ^( DISTINCT nested_op_input )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            DISTINCT275=(CommonTree)match(input,DISTINCT,FOLLOW_DISTINCT_in_nested_distinct3893); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DISTINCT275_tree = (CommonTree)adaptor.dupNode(DISTINCT275);


            root_1 = (CommonTree)adaptor.becomeRoot(DISTINCT275_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_distinct3895);
            nested_op_input276=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input276.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   SourceLocation loc = new SourceLocation( (PigParserNode)DISTINCT275 );
                   retval.op = builder.buildNestedDistinctOp( loc, ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan, alias, (nested_op_input276!=null?nested_op_input276.op:null) );
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
        public Operator op;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_limit"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1240:1: nested_limit[String alias] returns [Operator op] : ^( LIMIT nested_op_input ( INTEGER | expr[exprPlan] ) ) ;
    public final LogicalPlanGenerator.nested_limit_return nested_limit(String alias) throws RecognitionException {
        GScope_stack.push(new GScope_scope());

        LogicalPlanGenerator.nested_limit_return retval = new LogicalPlanGenerator.nested_limit_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree LIMIT277=null;
        CommonTree INTEGER279=null;
        LogicalPlanGenerator.nested_op_input_return nested_op_input278 =null;

        LogicalPlanGenerator.expr_return expr280 =null;


        CommonTree LIMIT277_tree=null;
        CommonTree INTEGER279_tree=null;


            Operator inputOp = null;
            LogicalExpressionPlan exprPlan = new LogicalExpressionPlan();
            ((GScope_scope)GScope_stack.peek()).currentOp = builder.createNestedLimitOp( ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan );

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1247:2: ( ^( LIMIT nested_op_input ( INTEGER | expr[exprPlan] ) ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1247:4: ^( LIMIT nested_op_input ( INTEGER | expr[exprPlan] ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            LIMIT277=(CommonTree)match(input,LIMIT,FOLLOW_LIMIT_in_nested_limit3928); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LIMIT277_tree = (CommonTree)adaptor.dupNode(LIMIT277);


            root_1 = (CommonTree)adaptor.becomeRoot(LIMIT277_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_limit3930);
            nested_op_input278=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input278.getTree());


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1247:29: ( INTEGER | expr[exprPlan] )
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==INTEGER) ) {
                int LA90_1 = input.LA(2);

                if ( (synpred155_LogicalPlanGenerator()) ) {
                    alt90=1;
                }
                else if ( (true) ) {
                    alt90=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 90, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA90_0==DIV||LA90_0==DOLLARVAR||LA90_0==DOUBLENUMBER||LA90_0==FALSE||LA90_0==FLOATNUMBER||LA90_0==GROUP||LA90_0==LONGINTEGER||LA90_0==MINUS||LA90_0==PERCENT||LA90_0==PLUS||LA90_0==QUOTEDSTRING||LA90_0==STAR||LA90_0==TRUE||(LA90_0 >= BAG_VAL && LA90_0 <= BIN_EXPR)||LA90_0==CAST_EXPR||LA90_0==EXPR_IN_PAREN||LA90_0==FUNC_EVAL||LA90_0==IDENTIFIER||(LA90_0 >= MAP_VAL && LA90_0 <= NEG)||LA90_0==NULL||LA90_0==TUPLE_VAL) ) {
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1247:31: INTEGER
                    {
                    _last = (CommonTree)input.LT(1);
                    INTEGER279=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_nested_limit3934); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INTEGER279_tree = (CommonTree)adaptor.dupNode(INTEGER279);


                    adaptor.addChild(root_1, INTEGER279_tree);
                    }


                    if ( state.backtracking==0 ) {
                           SourceLocation loc = new SourceLocation( (PigParserNode)LIMIT277 );
                           retval.op = builder.buildNestedLimitOp( loc, ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan, alias, (nested_op_input278!=null?nested_op_input278.op:null), 
                               Integer.valueOf( (INTEGER279!=null?INTEGER279.getText():null) ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1253:4: expr[exprPlan]
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_nested_limit3945);
                    expr280=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr280.getTree());


                    if ( state.backtracking==0 ) {
                           SourceLocation loc = new SourceLocation( (PigParserNode)LIMIT277 );
                           retval.op = builder.buildNestedLimitOp( loc, (LOLimit)((GScope_scope)GScope_stack.peek()).currentOp, ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan, alias,
                               (nested_op_input278!=null?nested_op_input278.op:null), exprPlan);
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
            GScope_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "nested_limit"


    public static class nested_cross_return extends TreeRuleReturnScope {
        public Operator op;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_cross"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1262:1: nested_cross[String alias] returns [Operator op] : ^( CROSS nested_op_input_list ) ;
    public final LogicalPlanGenerator.nested_cross_return nested_cross(String alias) throws RecognitionException {
        LogicalPlanGenerator.nested_cross_return retval = new LogicalPlanGenerator.nested_cross_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CROSS281=null;
        LogicalPlanGenerator.nested_op_input_list_return nested_op_input_list282 =null;


        CommonTree CROSS281_tree=null;


            Operator inputOp = null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1266:2: ( ^( CROSS nested_op_input_list ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1266:4: ^( CROSS nested_op_input_list )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CROSS281=(CommonTree)match(input,CROSS,FOLLOW_CROSS_in_nested_cross3979); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CROSS281_tree = (CommonTree)adaptor.dupNode(CROSS281);


            root_1 = (CommonTree)adaptor.becomeRoot(CROSS281_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_list_in_nested_cross3981);
            nested_op_input_list282=nested_op_input_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input_list282.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   SourceLocation loc = new SourceLocation( (PigParserNode)CROSS281 );
                   retval.op = builder.buildNestedCrossOp( loc, ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan, alias, (nested_op_input_list282!=null?nested_op_input_list282.opList:null) );
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


    protected static class nested_foreach_scope {
        LogicalPlan innerPlan;
        LOForEach foreachOp;
    }
    protected Stack nested_foreach_stack = new Stack();


    public static class nested_foreach_return extends TreeRuleReturnScope {
        public Operator op;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_foreach"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1273:1: nested_foreach[String alias] returns [Operator op] : ^( FOREACH nested_op_input generate_clause ) ;
    public final LogicalPlanGenerator.nested_foreach_return nested_foreach(String alias) throws RecognitionException {
        nested_foreach_stack.push(new nested_foreach_scope());
        LogicalPlanGenerator.nested_foreach_return retval = new LogicalPlanGenerator.nested_foreach_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FOREACH283=null;
        LogicalPlanGenerator.nested_op_input_return nested_op_input284 =null;

        LogicalPlanGenerator.generate_clause_return generate_clause285 =null;


        CommonTree FOREACH283_tree=null;


        	Operator inputOp = null;
        	((nested_foreach_scope)nested_foreach_stack.peek()).innerPlan = new LogicalPlan();
        	((nested_foreach_scope)nested_foreach_stack.peek()).foreachOp = builder.createNestedForeachOp( ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan );

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1283:2: ( ^( FOREACH nested_op_input generate_clause ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1283:4: ^( FOREACH nested_op_input generate_clause )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FOREACH283=(CommonTree)match(input,FOREACH,FOLLOW_FOREACH_in_nested_foreach4013); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FOREACH283_tree = (CommonTree)adaptor.dupNode(FOREACH283);


            root_1 = (CommonTree)adaptor.becomeRoot(FOREACH283_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_foreach4015);
            nested_op_input284=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input284.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_generate_clause_in_nested_foreach4017);
            generate_clause285=generate_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, generate_clause285.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
               		SourceLocation loc = new SourceLocation( (PigParserNode)FOREACH283 );
               		retval.op = builder.buildNestedForeachOp( loc, (LOForEach)((nested_foreach_scope)nested_foreach_stack.peek()).foreachOp, ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan,
               							alias, (nested_op_input284!=null?nested_op_input284.op:null), ((nested_foreach_scope)nested_foreach_stack.peek()).innerPlan);
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
            nested_foreach_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "nested_foreach"


    public static class generate_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "generate_clause"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1291:1: generate_clause : ^( GENERATE ( flatten_generated_item )+ ) ;
    public final LogicalPlanGenerator.generate_clause_return generate_clause() throws RecognitionException {
        GScope_stack.push(new GScope_scope());

        LogicalPlanGenerator.generate_clause_return retval = new LogicalPlanGenerator.generate_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree GENERATE286=null;
        LogicalPlanGenerator.flatten_generated_item_return flatten_generated_item287 =null;


        CommonTree GENERATE286_tree=null;


        	((GScope_scope)GScope_stack.peek()).currentOp = builder.createGenerateOp(inNestedCommand ? ((nested_foreach_scope)nested_foreach_stack.peek()).innerPlan : ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan );
            List<LogicalExpressionPlan> plans = new ArrayList<LogicalExpressionPlan>();
            List<Boolean> flattenFlags = new ArrayList<Boolean>();
            List<LogicalSchema> schemas = new ArrayList<LogicalSchema>();

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1299:2: ( ^( GENERATE ( flatten_generated_item )+ ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1299:4: ^( GENERATE ( flatten_generated_item )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            GENERATE286=(CommonTree)match(input,GENERATE,FOLLOW_GENERATE_in_generate_clause4046); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            GENERATE286_tree = (CommonTree)adaptor.dupNode(GENERATE286);


            root_1 = (CommonTree)adaptor.becomeRoot(GENERATE286_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1299:16: ( flatten_generated_item )+
            int cnt91=0;
            loop91:
            do {
                int alt91=2;
                int LA91_0 = input.LA(1);

                if ( (LA91_0==DIV||LA91_0==DOLLARVAR||LA91_0==DOUBLENUMBER||LA91_0==FALSE||LA91_0==FLATTEN||LA91_0==FLOATNUMBER||LA91_0==GROUP||LA91_0==INTEGER||LA91_0==LONGINTEGER||LA91_0==MINUS||LA91_0==PERCENT||LA91_0==PLUS||LA91_0==QUOTEDSTRING||LA91_0==STAR||LA91_0==TRUE||(LA91_0 >= BAG_VAL && LA91_0 <= BIN_EXPR)||(LA91_0 >= CAST_EXPR && LA91_0 <= EXPR_IN_PAREN)||LA91_0==FUNC_EVAL||LA91_0==IDENTIFIER||(LA91_0 >= MAP_VAL && LA91_0 <= NEG)||LA91_0==NULL||LA91_0==TUPLE_VAL) ) {
                    alt91=1;
                }


                switch (alt91) {
            	case 1 :
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1299:18: flatten_generated_item
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_flatten_generated_item_in_generate_clause4050);
            	    flatten_generated_item287=flatten_generated_item();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, flatten_generated_item287.getTree());


            	    if ( state.backtracking==0 ) {
            	                         plans.add( (flatten_generated_item287!=null?flatten_generated_item287.plan:null) );
            	                         flattenFlags.add( (flatten_generated_item287!=null?flatten_generated_item287.flattenFlag:false) );
            	                         schemas.add( (flatten_generated_item287!=null?flatten_generated_item287.schema:null) );
            	                     }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt91 >= 1 ) break loop91;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(91, input);
                        throw eee;
                }
                cnt91++;
            } while (true);


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {   
                   builder.buildGenerateOp( new SourceLocation( (PigParserNode)GENERATE286 ), 
                   	   inNestedCommand ? ((nested_foreach_scope)nested_foreach_stack.peek()).foreachOp : ((foreach_clause_scope)foreach_clause_stack.peek()).foreachOp, 
                       (LOGenerate)((GScope_scope)GScope_stack.peek()).currentOp, ((foreach_plan_scope)foreach_plan_stack.peek()).operators,
                       plans, flattenFlags, schemas );
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
            GScope_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "generate_clause"


    public static class nested_op_input_return extends TreeRuleReturnScope {
        public Operator op;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_op_input"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1315:1: nested_op_input returns [Operator op] : ( col_ref[plan] | nested_proj[null] );
    public final LogicalPlanGenerator.nested_op_input_return nested_op_input() throws RecognitionException {
        LogicalPlanGenerator.nested_op_input_return retval = new LogicalPlanGenerator.nested_op_input_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.col_ref_return col_ref288 =null;

        LogicalPlanGenerator.nested_proj_return nested_proj289 =null;




            LogicalExpressionPlan plan = new LogicalExpressionPlan();

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1319:2: ( col_ref[plan] | nested_proj[null] )
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1319:4: col_ref[plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_nested_op_input4116);
                    col_ref288=col_ref(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_ref288.getTree());


                    if ( state.backtracking==0 ) {
                           SourceLocation loc = new SourceLocation( (PigParserNode)(col_ref288!=null?((CommonTree)col_ref288.start):null) );
                           retval.op = builder.buildNestedOperatorInput( loc, ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan,
                               ((foreach_clause_scope)foreach_clause_stack.peek()).foreachOp, ((foreach_plan_scope)foreach_plan_stack.peek()).operators, (col_ref288!=null?col_ref288.expr:null) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1325:4: nested_proj[null]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_proj_in_nested_op_input4127);
                    nested_proj289=nested_proj(null);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_proj289.getTree());


                    if ( state.backtracking==0 ) { 
                           retval.op = (nested_proj289!=null?nested_proj289.op:null);
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
    // $ANTLR end "nested_op_input"


    public static class nested_op_input_list_return extends TreeRuleReturnScope {
        public List<Operator> opList;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_op_input_list"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1331:1: nested_op_input_list returns [List<Operator> opList] : ( nested_op_input )+ ;
    public final LogicalPlanGenerator.nested_op_input_list_return nested_op_input_list() throws RecognitionException {
        LogicalPlanGenerator.nested_op_input_list_return retval = new LogicalPlanGenerator.nested_op_input_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.nested_op_input_return nested_op_input290 =null;



         retval.opList = new ArrayList<Operator>(); 
        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1333:2: ( ( nested_op_input )+ )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1333:4: ( nested_op_input )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1333:4: ( nested_op_input )+
            int cnt93=0;
            loop93:
            do {
                int alt93=2;
                int LA93_0 = input.LA(1);

                if ( (LA93_0==DOLLARVAR||LA93_0==GROUP||LA93_0==IDENTIFIER||LA93_0==NESTED_PROJ) ) {
                    alt93=1;
                }


                switch (alt93) {
            	case 1 :
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1333:6: nested_op_input
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_nested_op_input_in_nested_op_input_list4153);
            	    nested_op_input290=nested_op_input();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, nested_op_input290.getTree());


            	    if ( state.backtracking==0 ) { retval.opList.add( (nested_op_input290!=null?nested_op_input290.op:null) ); }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt93 >= 1 ) break loop93;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(93, input);
                        throw eee;
                }
                cnt93++;
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
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "stream_clause"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1336:1: stream_clause returns [String alias] : ^( STREAM rel ( EXECCOMMAND | IDENTIFIER ) ( as_clause )? ) ;
    public final LogicalPlanGenerator.stream_clause_return stream_clause() throws RecognitionException {
        LogicalPlanGenerator.stream_clause_return retval = new LogicalPlanGenerator.stream_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STREAM291=null;
        CommonTree EXECCOMMAND293=null;
        CommonTree IDENTIFIER294=null;
        LogicalPlanGenerator.rel_return rel292 =null;

        LogicalPlanGenerator.as_clause_return as_clause295 =null;


        CommonTree STREAM291_tree=null;
        CommonTree EXECCOMMAND293_tree=null;
        CommonTree IDENTIFIER294_tree=null;


            StreamingCommand cmd = null;
            SourceLocation loc = new SourceLocation( (PigParserNode)((CommonTree)retval.start) );

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1341:2: ( ^( STREAM rel ( EXECCOMMAND | IDENTIFIER ) ( as_clause )? ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1341:4: ^( STREAM rel ( EXECCOMMAND | IDENTIFIER ) ( as_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            STREAM291=(CommonTree)match(input,STREAM,FOLLOW_STREAM_in_stream_clause4178); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STREAM291_tree = (CommonTree)adaptor.dupNode(STREAM291);


            root_1 = (CommonTree)adaptor.becomeRoot(STREAM291_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_stream_clause4180);
            rel292=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel292.getTree());


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1341:18: ( EXECCOMMAND | IDENTIFIER )
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1341:20: EXECCOMMAND
                    {
                    _last = (CommonTree)input.LT(1);
                    EXECCOMMAND293=(CommonTree)match(input,EXECCOMMAND,FOLLOW_EXECCOMMAND_in_stream_clause4184); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EXECCOMMAND293_tree = (CommonTree)adaptor.dupNode(EXECCOMMAND293);


                    adaptor.addChild(root_1, EXECCOMMAND293_tree);
                    }


                    if ( state.backtracking==0 ) { cmd = builder.buildCommand( loc, builder.unquote( (EXECCOMMAND293!=null?EXECCOMMAND293.getText():null) ) ); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1342:20: IDENTIFIER
                    {
                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER294=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_stream_clause4208); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER294_tree = (CommonTree)adaptor.dupNode(IDENTIFIER294);


                    adaptor.addChild(root_1, IDENTIFIER294_tree);
                    }


                    if ( state.backtracking==0 ) { 
                                           cmd = builder.lookupCommand( (IDENTIFIER294!=null?IDENTIFIER294.getText():null) );
                                           if( cmd == null ) {
                                               String msg = "Undefined command-alias [" + (IDENTIFIER294!=null?IDENTIFIER294.getText():null) + "]";
                                               throw new ParserValidationException( input, 
                                                   new SourceLocation( (PigParserNode)IDENTIFIER294 ), msg );
                                           }
                                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1351:20: ( as_clause )?
            int alt95=2;
            int LA95_0 = input.LA(1);

            if ( (LA95_0==AS) ) {
                alt95=1;
            }
            switch (alt95) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1351:20: as_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_as_clause_in_stream_clause4251);
                    as_clause295=as_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, as_clause295.getTree());


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
                   retval.alias = builder.buildStreamOp( loc, ((statement_scope)statement_stack.peek()).alias,
                      ((statement_scope)statement_stack.peek()).inputAlias, cmd, (as_clause295!=null?as_clause295.logicalSchema:null), input );
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
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "mr_clause"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1358:1: mr_clause returns [String alias] : ^( MAPREDUCE QUOTEDSTRING ( path_list[paths] )? store_clause load_clause ( EXECCOMMAND )? ) ;
    public final LogicalPlanGenerator.mr_clause_return mr_clause() throws RecognitionException {
        LogicalPlanGenerator.mr_clause_return retval = new LogicalPlanGenerator.mr_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MAPREDUCE296=null;
        CommonTree QUOTEDSTRING297=null;
        CommonTree EXECCOMMAND301=null;
        LogicalPlanGenerator.path_list_return path_list298 =null;

        LogicalPlanGenerator.store_clause_return store_clause299 =null;

        LogicalPlanGenerator.load_clause_return load_clause300 =null;


        CommonTree MAPREDUCE296_tree=null;
        CommonTree QUOTEDSTRING297_tree=null;
        CommonTree EXECCOMMAND301_tree=null;


            List<String> paths = new ArrayList<String>();
            String alias = ((statement_scope)statement_stack.peek()).alias;
            SourceLocation loc = new SourceLocation( (PigParserNode)((CommonTree)retval.start) );

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1364:2: ( ^( MAPREDUCE QUOTEDSTRING ( path_list[paths] )? store_clause load_clause ( EXECCOMMAND )? ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1364:4: ^( MAPREDUCE QUOTEDSTRING ( path_list[paths] )? store_clause load_clause ( EXECCOMMAND )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            MAPREDUCE296=(CommonTree)match(input,MAPREDUCE,FOLLOW_MAPREDUCE_in_mr_clause4279); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            MAPREDUCE296_tree = (CommonTree)adaptor.dupNode(MAPREDUCE296);


            root_1 = (CommonTree)adaptor.becomeRoot(MAPREDUCE296_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING297=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_mr_clause4281); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING297_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING297);


            adaptor.addChild(root_1, QUOTEDSTRING297_tree);
            }


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1364:30: ( path_list[paths] )?
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==QUOTEDSTRING) ) {
                alt96=1;
            }
            switch (alt96) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1364:30: path_list[paths]
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_path_list_in_mr_clause4283);
                    path_list298=path_list(paths);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, path_list298.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            if ( state.backtracking==0 ) { ((statement_scope)statement_stack.peek()).alias = null; }

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_store_clause_in_mr_clause4295);
            store_clause299=store_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, store_clause299.getTree());


            if ( state.backtracking==0 ) { ((statement_scope)statement_stack.peek()).alias = alias; }

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_load_clause_in_mr_clause4305);
            load_clause300=load_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, load_clause300.getTree());


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1367:6: ( EXECCOMMAND )?
            int alt97=2;
            int LA97_0 = input.LA(1);

            if ( (LA97_0==EXECCOMMAND) ) {
                alt97=1;
            }
            switch (alt97) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1367:6: EXECCOMMAND
                    {
                    _last = (CommonTree)input.LT(1);
                    EXECCOMMAND301=(CommonTree)match(input,EXECCOMMAND,FOLLOW_EXECCOMMAND_in_mr_clause4312); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EXECCOMMAND301_tree = (CommonTree)adaptor.dupNode(EXECCOMMAND301);


                    adaptor.addChild(root_1, EXECCOMMAND301_tree);
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
                   retval.alias = builder.buildNativeOp( loc,
                       builder.unquote( (QUOTEDSTRING297!=null?QUOTEDSTRING297.getText():null) ), builder.unquote( (EXECCOMMAND301!=null?EXECCOMMAND301.getText():null) ), 
                       paths, (store_clause299!=null?store_clause299.alias:null), (load_clause300!=null?load_clause300.alias:null), input );
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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1375:1: split_clause : ^( SPLIT rel ( split_branch )+ ( split_otherwise )? ) ;
    public final LogicalPlanGenerator.split_clause_return split_clause() throws RecognitionException {
        LogicalPlanGenerator.split_clause_return retval = new LogicalPlanGenerator.split_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SPLIT302=null;
        LogicalPlanGenerator.rel_return rel303 =null;

        LogicalPlanGenerator.split_branch_return split_branch304 =null;

        LogicalPlanGenerator.split_otherwise_return split_otherwise305 =null;


        CommonTree SPLIT302_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1376:2: ( ^( SPLIT rel ( split_branch )+ ( split_otherwise )? ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1376:4: ^( SPLIT rel ( split_branch )+ ( split_otherwise )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            SPLIT302=(CommonTree)match(input,SPLIT,FOLLOW_SPLIT_in_split_clause4332); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SPLIT302_tree = (CommonTree)adaptor.dupNode(SPLIT302);


            root_1 = (CommonTree)adaptor.becomeRoot(SPLIT302_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_split_clause4340);
            rel303=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel303.getTree());


            if ( state.backtracking==0 ) { 
                      SourceLocation loc = new SourceLocation( (PigParserNode)SPLIT302 );
                      ((statement_scope)statement_stack.peek()).inputAlias = builder.buildSplitOp( loc, ((statement_scope)statement_stack.peek()).inputAlias );
                  }

            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1382:7: ( split_branch )+
            int cnt98=0;
            loop98:
            do {
                int alt98=2;
                int LA98_0 = input.LA(1);

                if ( (LA98_0==SPLIT_BRANCH) ) {
                    alt98=1;
                }


                switch (alt98) {
            	case 1 :
            	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1382:7: split_branch
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_split_branch_in_split_clause4358);
            	    split_branch304=split_branch();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, split_branch304.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt98 >= 1 ) break loop98;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(98, input);
                        throw eee;
                }
                cnt98++;
            } while (true);


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1382:21: ( split_otherwise )?
            int alt99=2;
            int LA99_0 = input.LA(1);

            if ( (LA99_0==OTHERWISE) ) {
                alt99=1;
            }
            switch (alt99) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1382:21: split_otherwise
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_split_otherwise_in_split_clause4361);
                    split_otherwise305=split_otherwise();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, split_otherwise305.getTree());


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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1386:1: split_branch : ^( SPLIT_BRANCH alias cond[splitPlan] ) ;
    public final LogicalPlanGenerator.split_branch_return split_branch() throws RecognitionException {
        GScope_stack.push(new GScope_scope());

        LogicalPlanGenerator.split_branch_return retval = new LogicalPlanGenerator.split_branch_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SPLIT_BRANCH306=null;
        LogicalPlanGenerator.alias_return alias307 =null;

        LogicalPlanGenerator.cond_return cond308 =null;


        CommonTree SPLIT_BRANCH306_tree=null;


            LogicalExpressionPlan splitPlan = new LogicalExpressionPlan();
            ((GScope_scope)GScope_stack.peek()).currentOp = builder.createSplitOutputOp();

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1392:2: ( ^( SPLIT_BRANCH alias cond[splitPlan] ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1392:4: ^( SPLIT_BRANCH alias cond[splitPlan] )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            SPLIT_BRANCH306=(CommonTree)match(input,SPLIT_BRANCH,FOLLOW_SPLIT_BRANCH_in_split_branch4390); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SPLIT_BRANCH306_tree = (CommonTree)adaptor.dupNode(SPLIT_BRANCH306);


            root_1 = (CommonTree)adaptor.becomeRoot(SPLIT_BRANCH306_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_alias_in_split_branch4392);
            alias307=alias();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, alias307.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_split_branch4394);
            cond308=cond(splitPlan);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond308.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   SourceLocation loc = new SourceLocation( (PigParserNode)(alias307!=null?((CommonTree)alias307.start):null) );
                   builder.buildSplitOutputOp( loc, (LOSplitOutput)((GScope_scope)GScope_stack.peek()).currentOp, (alias307!=null?alias307.name:null),
                       ((statement_scope)statement_stack.peek()).inputAlias, splitPlan );
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
            GScope_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "split_branch"


    public static class split_otherwise_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "split_otherwise"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1400:1: split_otherwise : ^( OTHERWISE alias ) ;
    public final LogicalPlanGenerator.split_otherwise_return split_otherwise() throws RecognitionException, PlanGenerationFailureException {
        GScope_stack.push(new GScope_scope());

        LogicalPlanGenerator.split_otherwise_return retval = new LogicalPlanGenerator.split_otherwise_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree OTHERWISE309=null;
        LogicalPlanGenerator.alias_return alias310 =null;


        CommonTree OTHERWISE309_tree=null;


            ((GScope_scope)GScope_stack.peek()).currentOp = builder.createSplitOutputOp();

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1405:2: ( ^( OTHERWISE alias ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1405:4: ^( OTHERWISE alias )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            OTHERWISE309=(CommonTree)match(input,OTHERWISE,FOLLOW_OTHERWISE_in_split_otherwise4428); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            OTHERWISE309_tree = (CommonTree)adaptor.dupNode(OTHERWISE309);


            root_1 = (CommonTree)adaptor.becomeRoot(OTHERWISE309_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_alias_in_split_otherwise4430);
            alias310=alias();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, alias310.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   SourceLocation loc = new SourceLocation( (PigParserNode)(alias310!=null?((CommonTree)alias310.start):null) );
                   builder.buildSplitOtherwiseOp( loc, (LOSplitOutput)((GScope_scope)GScope_stack.peek()).currentOp, (alias310!=null?alias310.name:null),
                       ((statement_scope)statement_stack.peek()).inputAlias);
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
            GScope_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "split_otherwise"


    public static class col_ref_return extends TreeRuleReturnScope {
        public LogicalExpression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "col_ref"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1413:1: col_ref[LogicalExpressionPlan plan] returns [LogicalExpression expr] : ( alias_col_ref[$plan] | dollar_col_ref[$plan] );
    public final LogicalPlanGenerator.col_ref_return col_ref(LogicalExpressionPlan plan) throws RecognitionException {
        LogicalPlanGenerator.col_ref_return retval = new LogicalPlanGenerator.col_ref_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.alias_col_ref_return alias_col_ref311 =null;

        LogicalPlanGenerator.dollar_col_ref_return dollar_col_ref312 =null;



        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1414:2: ( alias_col_ref[$plan] | dollar_col_ref[$plan] )
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1414:4: alias_col_ref[$plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_alias_col_ref_in_col_ref4451);
                    alias_col_ref311=alias_col_ref(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, alias_col_ref311.getTree());


                    if ( state.backtracking==0 ) { retval.expr = (alias_col_ref311!=null?alias_col_ref311.expr:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1415:4: dollar_col_ref[$plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_dollar_col_ref_in_col_ref4459);
                    dollar_col_ref312=dollar_col_ref(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, dollar_col_ref312.getTree());


                    if ( state.backtracking==0 ) { retval.expr = (dollar_col_ref312!=null?dollar_col_ref312.expr:null); }

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
        public LogicalExpression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "alias_col_ref"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1418:1: alias_col_ref[LogicalExpressionPlan plan] returns [LogicalExpression expr] : ( GROUP | IDENTIFIER );
    public final LogicalPlanGenerator.alias_col_ref_return alias_col_ref(LogicalExpressionPlan plan) throws RecognitionException {
        LogicalPlanGenerator.alias_col_ref_return retval = new LogicalPlanGenerator.alias_col_ref_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree GROUP313=null;
        CommonTree IDENTIFIER314=null;

        CommonTree GROUP313_tree=null;
        CommonTree IDENTIFIER314_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1419:2: ( GROUP | IDENTIFIER )
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1419:4: GROUP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    GROUP313=(CommonTree)match(input,GROUP,FOLLOW_GROUP_in_alias_col_ref4476); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    GROUP313_tree = (CommonTree)adaptor.dupNode(GROUP313);


                    adaptor.addChild(root_0, GROUP313_tree);
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = builder.buildProjectExpr( new SourceLocation( (PigParserNode)GROUP313 ), plan, ((GScope_scope)GScope_stack.peek()).currentOp, 
                               ((statement_scope)statement_stack.peek()).inputIndex, (GROUP313!=null?GROUP313.getText():null), 0 );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1424:4: IDENTIFIER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER314=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_alias_col_ref4487); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER314_tree = (CommonTree)adaptor.dupNode(IDENTIFIER314);


                    adaptor.addChild(root_0, IDENTIFIER314_tree);
                    }


                    if ( state.backtracking==0 ) {
                           SourceLocation loc = new SourceLocation( (PigParserNode)IDENTIFIER314 );
                           String alias = (IDENTIFIER314!=null?IDENTIFIER314.getText():null);
                           Operator inOp = builder.lookupOperator( ((statement_scope)statement_stack.peek()).inputAlias );
                           if(null == inOp)
                           {
                               throw new UndefinedAliasException (input,loc,((statement_scope)statement_stack.peek()).inputAlias);
                           }
                           LogicalSchema schema;
                           try {
                               schema = ((LogicalRelationalOperator)inOp).getSchema();
                           } catch (FrontendException e) {
                               throw new PlanGenerationFailureException( input, loc, e );
                           }
                           
                           Operator op = builder.lookupOperator( alias );
                           if( op != null && ( schema == null || schema.getFieldPosition( alias ) == -1 ) ) {
                               retval.expr = new ScalarExpression( plan, op,
                                   inForeachPlan ? ((foreach_clause_scope)foreach_clause_stack.peek()).foreachOp : ((GScope_scope)GScope_stack.peek()).currentOp );
                               retval.expr.setLocation( loc );
                           } else {
                               if( inForeachPlan ) {
                                   retval.expr = builder.buildProjectExpr( loc, plan, ((GScope_scope)GScope_stack.peek()).currentOp, 
                                       ((foreach_plan_scope)foreach_plan_stack.peek()).exprPlans, alias, 0 );
                               } else {
                                   retval.expr = builder.buildProjectExpr( loc, plan, ((GScope_scope)GScope_stack.peek()).currentOp, 
                                       ((statement_scope)statement_stack.peek()).inputIndex, alias, 0 );
                               }
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
    // $ANTLR end "alias_col_ref"


    public static class dollar_col_ref_return extends TreeRuleReturnScope {
        public LogicalExpression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "dollar_col_ref"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1457:1: dollar_col_ref[LogicalExpressionPlan plan] returns [LogicalExpression expr] : DOLLARVAR ;
    public final LogicalPlanGenerator.dollar_col_ref_return dollar_col_ref(LogicalExpressionPlan plan) throws RecognitionException {
        LogicalPlanGenerator.dollar_col_ref_return retval = new LogicalPlanGenerator.dollar_col_ref_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DOLLARVAR315=null;

        CommonTree DOLLARVAR315_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1458:2: ( DOLLARVAR )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1458:4: DOLLARVAR
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            DOLLARVAR315=(CommonTree)match(input,DOLLARVAR,FOLLOW_DOLLARVAR_in_dollar_col_ref4506); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DOLLARVAR315_tree = (CommonTree)adaptor.dupNode(DOLLARVAR315);


            adaptor.addChild(root_0, DOLLARVAR315_tree);
            }


            if ( state.backtracking==0 ) {
                   int col = builder.undollar( (DOLLARVAR315!=null?DOLLARVAR315.getText():null) );
                   retval.expr = builder.buildProjectExpr( new SourceLocation( (PigParserNode)DOLLARVAR315 ), plan, ((GScope_scope)GScope_stack.peek()).currentOp, 
                       ((statement_scope)statement_stack.peek()).inputIndex, null, col );
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
        public LogicalExpression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "const_expr"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1466:1: const_expr[LogicalExpressionPlan plan] returns [LogicalExpression expr] : literal ;
    public final LogicalPlanGenerator.const_expr_return const_expr(LogicalExpressionPlan plan) throws RecognitionException {
        LogicalPlanGenerator.const_expr_return retval = new LogicalPlanGenerator.const_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.literal_return literal316 =null;



        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1467:2: ( literal )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1467:4: literal
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_literal_in_const_expr4525);
            literal316=literal();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, literal316.getTree());


            if ( state.backtracking==0 ) {
                   retval.expr = new ConstantExpression( plan, (literal316!=null?literal316.value:null));
                   retval.expr.setLocation( new SourceLocation( (PigParserNode)((CommonTree)retval.start) ) );
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
    // $ANTLR end "const_expr"


    public static class literal_return extends TreeRuleReturnScope {
        public Object value;
        public byte type;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "literal"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1474:1: literal returns [Object value, byte type] : ( scalar | map | bag | tuple );
    public final LogicalPlanGenerator.literal_return literal() throws RecognitionException {
        LogicalPlanGenerator.literal_return retval = new LogicalPlanGenerator.literal_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.scalar_return scalar317 =null;

        LogicalPlanGenerator.map_return map318 =null;

        LogicalPlanGenerator.bag_return bag319 =null;

        LogicalPlanGenerator.tuple_return tuple320 =null;



        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1475:2: ( scalar | map | bag | tuple )
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1475:4: scalar
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_scalar_in_literal4543);
                    scalar317=scalar();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, scalar317.getTree());


                    if ( state.backtracking==0 ) {
                           retval.value = (scalar317!=null?scalar317.value:null);
                           retval.type = (scalar317!=null?scalar317.type:0);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1480:4: map
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_map_in_literal4553);
                    map318=map();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, map318.getTree());


                    if ( state.backtracking==0 ) {
                           retval.value = (map318!=null?map318.value:null);
                           retval.type = DataType.MAP;
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1485:4: bag
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_bag_in_literal4563);
                    bag319=bag();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, bag319.getTree());


                    if ( state.backtracking==0 ) {
                           retval.value = (bag319!=null?bag319.value:null);
                           retval.type = DataType.BAG;
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1490:4: tuple
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_tuple_in_literal4573);
                    tuple320=tuple();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, tuple320.getTree());


                    if ( state.backtracking==0 ) {
                           retval.value = (tuple320!=null?tuple320.value:null);
                           retval.type = DataType.TUPLE;
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
    // $ANTLR end "literal"


    public static class scalar_return extends TreeRuleReturnScope {
        public Object value;
        public byte type;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "scalar"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1497:1: scalar returns [Object value, byte type] : ( num_scalar | QUOTEDSTRING | NULL | TRUE | FALSE );
    public final LogicalPlanGenerator.scalar_return scalar() throws RecognitionException {
        LogicalPlanGenerator.scalar_return retval = new LogicalPlanGenerator.scalar_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING322=null;
        CommonTree NULL323=null;
        CommonTree TRUE324=null;
        CommonTree FALSE325=null;
        LogicalPlanGenerator.num_scalar_return num_scalar321 =null;


        CommonTree QUOTEDSTRING322_tree=null;
        CommonTree NULL323_tree=null;
        CommonTree TRUE324_tree=null;
        CommonTree FALSE325_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1498:2: ( num_scalar | QUOTEDSTRING | NULL | TRUE | FALSE )
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1498:4: num_scalar
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_num_scalar_in_scalar4591);
                    num_scalar321=num_scalar();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, num_scalar321.getTree());


                    if ( state.backtracking==0 ) {
                           retval.type = (num_scalar321!=null?num_scalar321.type:0);
                           retval.value = (num_scalar321!=null?num_scalar321.value:null);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1503:4: QUOTEDSTRING
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    QUOTEDSTRING322=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_scalar4601); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    QUOTEDSTRING322_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING322);


                    adaptor.addChild(root_0, QUOTEDSTRING322_tree);
                    }


                    if ( state.backtracking==0 ) { 
                           retval.type = DataType.CHARARRAY;
                           retval.value = builder.unquote( (QUOTEDSTRING322!=null?QUOTEDSTRING322.getText():null) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1508:4: NULL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    NULL323=(CommonTree)match(input,NULL,FOLLOW_NULL_in_scalar4612); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NULL323_tree = (CommonTree)adaptor.dupNode(NULL323);


                    adaptor.addChild(root_0, NULL323_tree);
                    }


                    if ( state.backtracking==0 ) { 
                           retval.type = DataType.NULL;
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1512:4: TRUE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TRUE324=(CommonTree)match(input,TRUE,FOLLOW_TRUE_in_scalar4622); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TRUE324_tree = (CommonTree)adaptor.dupNode(TRUE324);


                    adaptor.addChild(root_0, TRUE324_tree);
                    }


                    if ( state.backtracking==0 ) {
                           retval.type = DataType.BOOLEAN;
                           retval.value = Boolean.TRUE;
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1517:4: FALSE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FALSE325=(CommonTree)match(input,FALSE,FOLLOW_FALSE_in_scalar4632); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FALSE325_tree = (CommonTree)adaptor.dupNode(FALSE325);


                    adaptor.addChild(root_0, FALSE325_tree);
                    }


                    if ( state.backtracking==0 ) {
                           retval.type = DataType.BOOLEAN;
                           retval.value = Boolean.FALSE;
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
        public Object value;
        public byte type;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "num_scalar"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1524:1: num_scalar returns [Object value, byte type] : ( MINUS )? ( INTEGER | LONGINTEGER | FLOATNUMBER | DOUBLENUMBER ) ;
    public final LogicalPlanGenerator.num_scalar_return num_scalar() throws RecognitionException {
        LogicalPlanGenerator.num_scalar_return retval = new LogicalPlanGenerator.num_scalar_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MINUS326=null;
        CommonTree INTEGER327=null;
        CommonTree LONGINTEGER328=null;
        CommonTree FLOATNUMBER329=null;
        CommonTree DOUBLENUMBER330=null;

        CommonTree MINUS326_tree=null;
        CommonTree INTEGER327_tree=null;
        CommonTree LONGINTEGER328_tree=null;
        CommonTree FLOATNUMBER329_tree=null;
        CommonTree DOUBLENUMBER330_tree=null;


            int sign = 1;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1528:2: ( ( MINUS )? ( INTEGER | LONGINTEGER | FLOATNUMBER | DOUBLENUMBER ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1528:4: ( MINUS )? ( INTEGER | LONGINTEGER | FLOATNUMBER | DOUBLENUMBER )
            {
            root_0 = (CommonTree)adaptor.nil();


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1528:4: ( MINUS )?
            int alt104=2;
            int LA104_0 = input.LA(1);

            if ( (LA104_0==MINUS) ) {
                alt104=1;
            }
            switch (alt104) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1528:6: MINUS
                    {
                    _last = (CommonTree)input.LT(1);
                    MINUS326=(CommonTree)match(input,MINUS,FOLLOW_MINUS_in_num_scalar4657); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MINUS326_tree = (CommonTree)adaptor.dupNode(MINUS326);


                    adaptor.addChild(root_0, MINUS326_tree);
                    }


                    if ( state.backtracking==0 ) { sign = -1; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1529:4: ( INTEGER | LONGINTEGER | FLOATNUMBER | DOUBLENUMBER )
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
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1529:6: INTEGER
                    {
                    _last = (CommonTree)input.LT(1);
                    INTEGER327=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_num_scalar4670); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INTEGER327_tree = (CommonTree)adaptor.dupNode(INTEGER327);


                    adaptor.addChild(root_0, INTEGER327_tree);
                    }


                    if ( state.backtracking==0 ) { 
                             retval.type = DataType.INTEGER;
                             retval.value = sign * Integer.valueOf( (INTEGER327!=null?INTEGER327.getText():null) );
                         }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1534:6: LONGINTEGER
                    {
                    _last = (CommonTree)input.LT(1);
                    LONGINTEGER328=(CommonTree)match(input,LONGINTEGER,FOLLOW_LONGINTEGER_in_num_scalar4684); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LONGINTEGER328_tree = (CommonTree)adaptor.dupNode(LONGINTEGER328);


                    adaptor.addChild(root_0, LONGINTEGER328_tree);
                    }


                    if ( state.backtracking==0 ) { 
                             retval.type = DataType.LONG;
                             retval.value = sign * builder.parseLong( (LONGINTEGER328!=null?LONGINTEGER328.getText():null) );
                         }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1539:6: FLOATNUMBER
                    {
                    _last = (CommonTree)input.LT(1);
                    FLOATNUMBER329=(CommonTree)match(input,FLOATNUMBER,FOLLOW_FLOATNUMBER_in_num_scalar4699); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FLOATNUMBER329_tree = (CommonTree)adaptor.dupNode(FLOATNUMBER329);


                    adaptor.addChild(root_0, FLOATNUMBER329_tree);
                    }


                    if ( state.backtracking==0 ) { 
                             retval.type = DataType.FLOAT;
                             retval.value = sign * Float.valueOf( (FLOATNUMBER329!=null?FLOATNUMBER329.getText():null) );
                         }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1544:6: DOUBLENUMBER
                    {
                    _last = (CommonTree)input.LT(1);
                    DOUBLENUMBER330=(CommonTree)match(input,DOUBLENUMBER,FOLLOW_DOUBLENUMBER_in_num_scalar4714); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DOUBLENUMBER330_tree = (CommonTree)adaptor.dupNode(DOUBLENUMBER330);


                    adaptor.addChild(root_0, DOUBLENUMBER330_tree);
                    }


                    if ( state.backtracking==0 ) { 
                             retval.type = DataType.DOUBLE;
                             retval.value = sign * Double.valueOf( (DOUBLENUMBER330!=null?DOUBLENUMBER330.getText():null) );
                         }

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
        public Object value;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "map"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1552:1: map returns [Object value] : ^( MAP_VAL ( keyvalue )* ) ;
    public final LogicalPlanGenerator.map_return map() throws RecognitionException {
        LogicalPlanGenerator.map_return retval = new LogicalPlanGenerator.map_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MAP_VAL331=null;
        LogicalPlanGenerator.keyvalue_return keyvalue332 =null;


        CommonTree MAP_VAL331_tree=null;

         Map<String, Object> kvs = new HashMap<String, Object>(); 
        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1554:2: ( ^( MAP_VAL ( keyvalue )* ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1554:4: ^( MAP_VAL ( keyvalue )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            MAP_VAL331=(CommonTree)match(input,MAP_VAL,FOLLOW_MAP_VAL_in_map4747); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            MAP_VAL331_tree = (CommonTree)adaptor.dupNode(MAP_VAL331);


            root_1 = (CommonTree)adaptor.becomeRoot(MAP_VAL331_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1554:15: ( keyvalue )*
                loop106:
                do {
                    int alt106=2;
                    int LA106_0 = input.LA(1);

                    if ( (LA106_0==KEY_VAL_PAIR) ) {
                        alt106=1;
                    }


                    switch (alt106) {
                	case 1 :
                	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1554:17: keyvalue
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_keyvalue_in_map4751);
                	    keyvalue332=keyvalue();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, keyvalue332.getTree());


                	    if ( state.backtracking==0 ) { kvs.put( (keyvalue332!=null?keyvalue332.key:null), (keyvalue332!=null?keyvalue332.value:null) ); }

                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop106;
                    }
                } while (true);


                match(input, Token.UP, null); if (state.failed) return retval;
            }
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   retval.value = kvs;
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
        public String key;
        public Object value;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "keyvalue"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1560:1: keyvalue returns [String key, Object value] : ^( KEY_VAL_PAIR map_key literal ) ;
    public final LogicalPlanGenerator.keyvalue_return keyvalue() throws RecognitionException {
        LogicalPlanGenerator.keyvalue_return retval = new LogicalPlanGenerator.keyvalue_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree KEY_VAL_PAIR333=null;
        LogicalPlanGenerator.map_key_return map_key334 =null;

        LogicalPlanGenerator.literal_return literal335 =null;


        CommonTree KEY_VAL_PAIR333_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1561:2: ( ^( KEY_VAL_PAIR map_key literal ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1561:4: ^( KEY_VAL_PAIR map_key literal )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            KEY_VAL_PAIR333=(CommonTree)match(input,KEY_VAL_PAIR,FOLLOW_KEY_VAL_PAIR_in_keyvalue4778); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            KEY_VAL_PAIR333_tree = (CommonTree)adaptor.dupNode(KEY_VAL_PAIR333);


            root_1 = (CommonTree)adaptor.becomeRoot(KEY_VAL_PAIR333_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_map_key_in_keyvalue4780);
            map_key334=map_key();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, map_key334.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_literal_in_keyvalue4782);
            literal335=literal();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, literal335.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   retval.key = (map_key334!=null?map_key334.value:null);
                   retval.value = (literal335!=null?literal335.value:null);
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
        public String value;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "map_key"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1568:1: map_key returns [String value] : QUOTEDSTRING ;
    public final LogicalPlanGenerator.map_key_return map_key() throws RecognitionException {
        LogicalPlanGenerator.map_key_return retval = new LogicalPlanGenerator.map_key_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING336=null;

        CommonTree QUOTEDSTRING336_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1569:2: ( QUOTEDSTRING )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1569:4: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING336=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_map_key4802); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING336_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING336);


            adaptor.addChild(root_0, QUOTEDSTRING336_tree);
            }


            if ( state.backtracking==0 ) { retval.value = builder.unquote( (QUOTEDSTRING336!=null?QUOTEDSTRING336.getText():null) ); }

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
        public Object value;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "bag"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1572:1: bag returns [Object value] : ^( BAG_VAL ( tuple )* ) ;
    public final LogicalPlanGenerator.bag_return bag() throws RecognitionException {
        LogicalPlanGenerator.bag_return retval = new LogicalPlanGenerator.bag_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BAG_VAL337=null;
        LogicalPlanGenerator.tuple_return tuple338 =null;


        CommonTree BAG_VAL337_tree=null;

         DataBag dataBag = builder.createDataBag(); 
        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1574:2: ( ^( BAG_VAL ( tuple )* ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1574:4: ^( BAG_VAL ( tuple )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BAG_VAL337=(CommonTree)match(input,BAG_VAL,FOLLOW_BAG_VAL_in_bag4824); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BAG_VAL337_tree = (CommonTree)adaptor.dupNode(BAG_VAL337);


            root_1 = (CommonTree)adaptor.becomeRoot(BAG_VAL337_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1574:15: ( tuple )*
                loop107:
                do {
                    int alt107=2;
                    int LA107_0 = input.LA(1);

                    if ( (LA107_0==TUPLE_VAL) ) {
                        alt107=1;
                    }


                    switch (alt107) {
                	case 1 :
                	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1574:17: tuple
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_tuple_in_bag4828);
                	    tuple338=tuple();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, tuple338.getTree());


                	    if ( state.backtracking==0 ) { dataBag.add( (tuple338!=null?tuple338.value:null) ); }

                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop107;
                    }
                } while (true);


                match(input, Token.UP, null); if (state.failed) return retval;
            }
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   retval.value = dataBag;
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
        public Tuple value;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "tuple"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1580:1: tuple returns [Tuple value] : ^( TUPLE_VAL ( literal )* ) ;
    public final LogicalPlanGenerator.tuple_return tuple() throws RecognitionException {
        LogicalPlanGenerator.tuple_return retval = new LogicalPlanGenerator.tuple_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree TUPLE_VAL339=null;
        LogicalPlanGenerator.literal_return literal340 =null;


        CommonTree TUPLE_VAL339_tree=null;

         List<Object> objList = new ArrayList<Object>(); 
        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1582:2: ( ^( TUPLE_VAL ( literal )* ) )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1582:4: ^( TUPLE_VAL ( literal )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            TUPLE_VAL339=(CommonTree)match(input,TUPLE_VAL,FOLLOW_TUPLE_VAL_in_tuple4860); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            TUPLE_VAL339_tree = (CommonTree)adaptor.dupNode(TUPLE_VAL339);


            root_1 = (CommonTree)adaptor.becomeRoot(TUPLE_VAL339_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1582:17: ( literal )*
                loop108:
                do {
                    int alt108=2;
                    int LA108_0 = input.LA(1);

                    if ( (LA108_0==DOUBLENUMBER||LA108_0==FALSE||LA108_0==FLOATNUMBER||LA108_0==INTEGER||LA108_0==LONGINTEGER||LA108_0==MINUS||LA108_0==QUOTEDSTRING||LA108_0==TRUE||LA108_0==BAG_VAL||LA108_0==MAP_VAL||LA108_0==NULL||LA108_0==TUPLE_VAL) ) {
                        alt108=1;
                    }


                    switch (alt108) {
                	case 1 :
                	    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1582:19: literal
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_literal_in_tuple4864);
                	    literal340=literal();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, literal340.getTree());


                	    if ( state.backtracking==0 ) { objList.add( (literal340!=null?literal340.value:null) ); }

                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop108;
                    }
                } while (true);


                match(input, Token.UP, null); if (state.failed) return retval;
            }
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   retval.value = builder.buildTuple( objList );
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
        public String id;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "eid"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1589:1: eid returns [String id] : ( rel_str_op | IMPORT | RETURNS | DEFINE | LOAD | FILTER | FOREACH | MATCHES | ORDER | DISTINCT | COGROUP | JOIN | CROSS | UNION | SPLIT | INTO | IF | ALL | AS | BY | USING | INNER | OUTER | PARALLEL | PARTITION | GROUP | AND | OR | NOT | GENERATE | FLATTEN | EVAL | ASC | DESC | BOOLEAN | INT | LONG | FLOAT | DOUBLE | CHARARRAY | BYTEARRAY | BAG | TUPLE | MAP | IS | NULL | TRUE | FALSE | STREAM | THROUGH | STORE | MAPREDUCE | SHIP | CACHE | INPUT | OUTPUT | STDERROR | STDIN | STDOUT | LIMIT | SAMPLE | LEFT | RIGHT | FULL | IDENTIFIER | TOBAG | TOMAP | TOTUPLE );
    public final LogicalPlanGenerator.eid_return eid() throws RecognitionException {
        LogicalPlanGenerator.eid_return retval = new LogicalPlanGenerator.eid_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IMPORT342=null;
        CommonTree RETURNS343=null;
        CommonTree DEFINE344=null;
        CommonTree LOAD345=null;
        CommonTree FILTER346=null;
        CommonTree FOREACH347=null;
        CommonTree MATCHES348=null;
        CommonTree ORDER349=null;
        CommonTree DISTINCT350=null;
        CommonTree COGROUP351=null;
        CommonTree JOIN352=null;
        CommonTree CROSS353=null;
        CommonTree UNION354=null;
        CommonTree SPLIT355=null;
        CommonTree INTO356=null;
        CommonTree IF357=null;
        CommonTree ALL358=null;
        CommonTree AS359=null;
        CommonTree BY360=null;
        CommonTree USING361=null;
        CommonTree INNER362=null;
        CommonTree OUTER363=null;
        CommonTree PARALLEL364=null;
        CommonTree PARTITION365=null;
        CommonTree GROUP366=null;
        CommonTree AND367=null;
        CommonTree OR368=null;
        CommonTree NOT369=null;
        CommonTree GENERATE370=null;
        CommonTree FLATTEN371=null;
        CommonTree EVAL372=null;
        CommonTree ASC373=null;
        CommonTree DESC374=null;
        CommonTree BOOLEAN375=null;
        CommonTree INT376=null;
        CommonTree LONG377=null;
        CommonTree FLOAT378=null;
        CommonTree DOUBLE379=null;
        CommonTree CHARARRAY380=null;
        CommonTree BYTEARRAY381=null;
        CommonTree BAG382=null;
        CommonTree TUPLE383=null;
        CommonTree MAP384=null;
        CommonTree IS385=null;
        CommonTree NULL386=null;
        CommonTree TRUE387=null;
        CommonTree FALSE388=null;
        CommonTree STREAM389=null;
        CommonTree THROUGH390=null;
        CommonTree STORE391=null;
        CommonTree MAPREDUCE392=null;
        CommonTree SHIP393=null;
        CommonTree CACHE394=null;
        CommonTree INPUT395=null;
        CommonTree OUTPUT396=null;
        CommonTree STDERROR397=null;
        CommonTree STDIN398=null;
        CommonTree STDOUT399=null;
        CommonTree LIMIT400=null;
        CommonTree SAMPLE401=null;
        CommonTree LEFT402=null;
        CommonTree RIGHT403=null;
        CommonTree FULL404=null;
        CommonTree IDENTIFIER405=null;
        CommonTree TOBAG406=null;
        CommonTree TOMAP407=null;
        CommonTree TOTUPLE408=null;
        LogicalPlanGenerator.rel_str_op_return rel_str_op341 =null;


        CommonTree IMPORT342_tree=null;
        CommonTree RETURNS343_tree=null;
        CommonTree DEFINE344_tree=null;
        CommonTree LOAD345_tree=null;
        CommonTree FILTER346_tree=null;
        CommonTree FOREACH347_tree=null;
        CommonTree MATCHES348_tree=null;
        CommonTree ORDER349_tree=null;
        CommonTree DISTINCT350_tree=null;
        CommonTree COGROUP351_tree=null;
        CommonTree JOIN352_tree=null;
        CommonTree CROSS353_tree=null;
        CommonTree UNION354_tree=null;
        CommonTree SPLIT355_tree=null;
        CommonTree INTO356_tree=null;
        CommonTree IF357_tree=null;
        CommonTree ALL358_tree=null;
        CommonTree AS359_tree=null;
        CommonTree BY360_tree=null;
        CommonTree USING361_tree=null;
        CommonTree INNER362_tree=null;
        CommonTree OUTER363_tree=null;
        CommonTree PARALLEL364_tree=null;
        CommonTree PARTITION365_tree=null;
        CommonTree GROUP366_tree=null;
        CommonTree AND367_tree=null;
        CommonTree OR368_tree=null;
        CommonTree NOT369_tree=null;
        CommonTree GENERATE370_tree=null;
        CommonTree FLATTEN371_tree=null;
        CommonTree EVAL372_tree=null;
        CommonTree ASC373_tree=null;
        CommonTree DESC374_tree=null;
        CommonTree BOOLEAN375_tree=null;
        CommonTree INT376_tree=null;
        CommonTree LONG377_tree=null;
        CommonTree FLOAT378_tree=null;
        CommonTree DOUBLE379_tree=null;
        CommonTree CHARARRAY380_tree=null;
        CommonTree BYTEARRAY381_tree=null;
        CommonTree BAG382_tree=null;
        CommonTree TUPLE383_tree=null;
        CommonTree MAP384_tree=null;
        CommonTree IS385_tree=null;
        CommonTree NULL386_tree=null;
        CommonTree TRUE387_tree=null;
        CommonTree FALSE388_tree=null;
        CommonTree STREAM389_tree=null;
        CommonTree THROUGH390_tree=null;
        CommonTree STORE391_tree=null;
        CommonTree MAPREDUCE392_tree=null;
        CommonTree SHIP393_tree=null;
        CommonTree CACHE394_tree=null;
        CommonTree INPUT395_tree=null;
        CommonTree OUTPUT396_tree=null;
        CommonTree STDERROR397_tree=null;
        CommonTree STDIN398_tree=null;
        CommonTree STDOUT399_tree=null;
        CommonTree LIMIT400_tree=null;
        CommonTree SAMPLE401_tree=null;
        CommonTree LEFT402_tree=null;
        CommonTree RIGHT403_tree=null;
        CommonTree FULL404_tree=null;
        CommonTree IDENTIFIER405_tree=null;
        CommonTree TOBAG406_tree=null;
        CommonTree TOMAP407_tree=null;
        CommonTree TOTUPLE408_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1589:24: ( rel_str_op | IMPORT | RETURNS | DEFINE | LOAD | FILTER | FOREACH | MATCHES | ORDER | DISTINCT | COGROUP | JOIN | CROSS | UNION | SPLIT | INTO | IF | ALL | AS | BY | USING | INNER | OUTER | PARALLEL | PARTITION | GROUP | AND | OR | NOT | GENERATE | FLATTEN | EVAL | ASC | DESC | BOOLEAN | INT | LONG | FLOAT | DOUBLE | CHARARRAY | BYTEARRAY | BAG | TUPLE | MAP | IS | NULL | TRUE | FALSE | STREAM | THROUGH | STORE | MAPREDUCE | SHIP | CACHE | INPUT | OUTPUT | STDERROR | STDIN | STDOUT | LIMIT | SAMPLE | LEFT | RIGHT | FULL | IDENTIFIER | TOBAG | TOMAP | TOTUPLE )
            int alt109=68;
            switch ( input.LA(1) ) {
            case STR_OP_EQ:
            case STR_OP_GT:
            case STR_OP_GTE:
            case STR_OP_LT:
            case STR_OP_LTE:
            case STR_OP_MATCHES:
            case STR_OP_NE:
                {
                alt109=1;
                }
                break;
            case IMPORT:
                {
                alt109=2;
                }
                break;
            case RETURNS:
                {
                alt109=3;
                }
                break;
            case DEFINE:
                {
                alt109=4;
                }
                break;
            case LOAD:
                {
                alt109=5;
                }
                break;
            case FILTER:
                {
                alt109=6;
                }
                break;
            case FOREACH:
                {
                alt109=7;
                }
                break;
            case MATCHES:
                {
                alt109=8;
                }
                break;
            case ORDER:
                {
                alt109=9;
                }
                break;
            case DISTINCT:
                {
                alt109=10;
                }
                break;
            case COGROUP:
                {
                alt109=11;
                }
                break;
            case JOIN:
                {
                alt109=12;
                }
                break;
            case CROSS:
                {
                alt109=13;
                }
                break;
            case UNION:
                {
                alt109=14;
                }
                break;
            case SPLIT:
                {
                alt109=15;
                }
                break;
            case INTO:
                {
                alt109=16;
                }
                break;
            case IF:
                {
                alt109=17;
                }
                break;
            case ALL:
                {
                alt109=18;
                }
                break;
            case AS:
                {
                alt109=19;
                }
                break;
            case BY:
                {
                alt109=20;
                }
                break;
            case USING:
                {
                alt109=21;
                }
                break;
            case INNER:
                {
                alt109=22;
                }
                break;
            case OUTER:
                {
                alt109=23;
                }
                break;
            case PARALLEL:
                {
                alt109=24;
                }
                break;
            case PARTITION:
                {
                alt109=25;
                }
                break;
            case GROUP:
                {
                alt109=26;
                }
                break;
            case AND:
                {
                alt109=27;
                }
                break;
            case OR:
                {
                alt109=28;
                }
                break;
            case NOT:
                {
                alt109=29;
                }
                break;
            case GENERATE:
                {
                alt109=30;
                }
                break;
            case FLATTEN:
                {
                alt109=31;
                }
                break;
            case EVAL:
                {
                alt109=32;
                }
                break;
            case ASC:
                {
                alt109=33;
                }
                break;
            case DESC:
                {
                alt109=34;
                }
                break;
            case BOOLEAN:
                {
                alt109=35;
                }
                break;
            case INT:
                {
                alt109=36;
                }
                break;
            case LONG:
                {
                alt109=37;
                }
                break;
            case FLOAT:
                {
                alt109=38;
                }
                break;
            case DOUBLE:
                {
                alt109=39;
                }
                break;
            case CHARARRAY:
                {
                alt109=40;
                }
                break;
            case BYTEARRAY:
                {
                alt109=41;
                }
                break;
            case BAG:
                {
                alt109=42;
                }
                break;
            case TUPLE:
                {
                alt109=43;
                }
                break;
            case MAP:
                {
                alt109=44;
                }
                break;
            case IS:
                {
                alt109=45;
                }
                break;
            case NULL:
                {
                alt109=46;
                }
                break;
            case TRUE:
                {
                alt109=47;
                }
                break;
            case FALSE:
                {
                alt109=48;
                }
                break;
            case STREAM:
                {
                alt109=49;
                }
                break;
            case THROUGH:
                {
                alt109=50;
                }
                break;
            case STORE:
                {
                alt109=51;
                }
                break;
            case MAPREDUCE:
                {
                alt109=52;
                }
                break;
            case SHIP:
                {
                alt109=53;
                }
                break;
            case CACHE:
                {
                alt109=54;
                }
                break;
            case INPUT:
                {
                alt109=55;
                }
                break;
            case OUTPUT:
                {
                alt109=56;
                }
                break;
            case STDERROR:
                {
                alt109=57;
                }
                break;
            case STDIN:
                {
                alt109=58;
                }
                break;
            case STDOUT:
                {
                alt109=59;
                }
                break;
            case LIMIT:
                {
                alt109=60;
                }
                break;
            case SAMPLE:
                {
                alt109=61;
                }
                break;
            case LEFT:
                {
                alt109=62;
                }
                break;
            case RIGHT:
                {
                alt109=63;
                }
                break;
            case FULL:
                {
                alt109=64;
                }
                break;
            case IDENTIFIER:
                {
                alt109=65;
                }
                break;
            case TOBAG:
                {
                alt109=66;
                }
                break;
            case TOMAP:
                {
                alt109=67;
                }
                break;
            case TOTUPLE:
                {
                alt109=68;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 109, 0, input);

                throw nvae;

            }

            switch (alt109) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1589:26: rel_str_op
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_str_op_in_eid4889);
                    rel_str_op341=rel_str_op();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_str_op341.getTree());


                    if ( state.backtracking==0 ) { retval.id = (rel_str_op341!=null?rel_str_op341.id:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1590:7: IMPORT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IMPORT342=(CommonTree)match(input,IMPORT,FOLLOW_IMPORT_in_eid4899); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IMPORT342_tree = (CommonTree)adaptor.dupNode(IMPORT342);


                    adaptor.addChild(root_0, IMPORT342_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (IMPORT342!=null?IMPORT342.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1591:7: RETURNS
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    RETURNS343=(CommonTree)match(input,RETURNS,FOLLOW_RETURNS_in_eid4909); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RETURNS343_tree = (CommonTree)adaptor.dupNode(RETURNS343);


                    adaptor.addChild(root_0, RETURNS343_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (RETURNS343!=null?RETURNS343.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1592:7: DEFINE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DEFINE344=(CommonTree)match(input,DEFINE,FOLLOW_DEFINE_in_eid4919); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DEFINE344_tree = (CommonTree)adaptor.dupNode(DEFINE344);


                    adaptor.addChild(root_0, DEFINE344_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (DEFINE344!=null?DEFINE344.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1593:7: LOAD
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LOAD345=(CommonTree)match(input,LOAD,FOLLOW_LOAD_in_eid4929); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LOAD345_tree = (CommonTree)adaptor.dupNode(LOAD345);


                    adaptor.addChild(root_0, LOAD345_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (LOAD345!=null?LOAD345.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1594:7: FILTER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FILTER346=(CommonTree)match(input,FILTER,FOLLOW_FILTER_in_eid4939); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FILTER346_tree = (CommonTree)adaptor.dupNode(FILTER346);


                    adaptor.addChild(root_0, FILTER346_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (FILTER346!=null?FILTER346.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1595:7: FOREACH
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FOREACH347=(CommonTree)match(input,FOREACH,FOLLOW_FOREACH_in_eid4949); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FOREACH347_tree = (CommonTree)adaptor.dupNode(FOREACH347);


                    adaptor.addChild(root_0, FOREACH347_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (FOREACH347!=null?FOREACH347.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1596:7: MATCHES
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    MATCHES348=(CommonTree)match(input,MATCHES,FOLLOW_MATCHES_in_eid4959); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MATCHES348_tree = (CommonTree)adaptor.dupNode(MATCHES348);


                    adaptor.addChild(root_0, MATCHES348_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (MATCHES348!=null?MATCHES348.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1597:7: ORDER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ORDER349=(CommonTree)match(input,ORDER,FOLLOW_ORDER_in_eid4969); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ORDER349_tree = (CommonTree)adaptor.dupNode(ORDER349);


                    adaptor.addChild(root_0, ORDER349_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (ORDER349!=null?ORDER349.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1598:7: DISTINCT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DISTINCT350=(CommonTree)match(input,DISTINCT,FOLLOW_DISTINCT_in_eid4979); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DISTINCT350_tree = (CommonTree)adaptor.dupNode(DISTINCT350);


                    adaptor.addChild(root_0, DISTINCT350_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (DISTINCT350!=null?DISTINCT350.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 11 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1599:7: COGROUP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    COGROUP351=(CommonTree)match(input,COGROUP,FOLLOW_COGROUP_in_eid4989); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    COGROUP351_tree = (CommonTree)adaptor.dupNode(COGROUP351);


                    adaptor.addChild(root_0, COGROUP351_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (COGROUP351!=null?COGROUP351.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 12 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1600:7: JOIN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    JOIN352=(CommonTree)match(input,JOIN,FOLLOW_JOIN_in_eid4999); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    JOIN352_tree = (CommonTree)adaptor.dupNode(JOIN352);


                    adaptor.addChild(root_0, JOIN352_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (JOIN352!=null?JOIN352.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 13 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1601:7: CROSS
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CROSS353=(CommonTree)match(input,CROSS,FOLLOW_CROSS_in_eid5009); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CROSS353_tree = (CommonTree)adaptor.dupNode(CROSS353);


                    adaptor.addChild(root_0, CROSS353_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (CROSS353!=null?CROSS353.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 14 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1602:7: UNION
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    UNION354=(CommonTree)match(input,UNION,FOLLOW_UNION_in_eid5019); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    UNION354_tree = (CommonTree)adaptor.dupNode(UNION354);


                    adaptor.addChild(root_0, UNION354_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (UNION354!=null?UNION354.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 15 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1603:7: SPLIT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    SPLIT355=(CommonTree)match(input,SPLIT,FOLLOW_SPLIT_in_eid5029); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SPLIT355_tree = (CommonTree)adaptor.dupNode(SPLIT355);


                    adaptor.addChild(root_0, SPLIT355_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (SPLIT355!=null?SPLIT355.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 16 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1604:7: INTO
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INTO356=(CommonTree)match(input,INTO,FOLLOW_INTO_in_eid5039); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INTO356_tree = (CommonTree)adaptor.dupNode(INTO356);


                    adaptor.addChild(root_0, INTO356_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (INTO356!=null?INTO356.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 17 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1605:7: IF
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IF357=(CommonTree)match(input,IF,FOLLOW_IF_in_eid5049); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IF357_tree = (CommonTree)adaptor.dupNode(IF357);


                    adaptor.addChild(root_0, IF357_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (IF357!=null?IF357.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 18 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1606:7: ALL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ALL358=(CommonTree)match(input,ALL,FOLLOW_ALL_in_eid5059); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ALL358_tree = (CommonTree)adaptor.dupNode(ALL358);


                    adaptor.addChild(root_0, ALL358_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (ALL358!=null?ALL358.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 19 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1607:7: AS
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    AS359=(CommonTree)match(input,AS,FOLLOW_AS_in_eid5069); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    AS359_tree = (CommonTree)adaptor.dupNode(AS359);


                    adaptor.addChild(root_0, AS359_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (AS359!=null?AS359.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 20 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1608:7: BY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BY360=(CommonTree)match(input,BY,FOLLOW_BY_in_eid5079); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BY360_tree = (CommonTree)adaptor.dupNode(BY360);


                    adaptor.addChild(root_0, BY360_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (BY360!=null?BY360.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 21 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1609:7: USING
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    USING361=(CommonTree)match(input,USING,FOLLOW_USING_in_eid5089); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    USING361_tree = (CommonTree)adaptor.dupNode(USING361);


                    adaptor.addChild(root_0, USING361_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (USING361!=null?USING361.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 22 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1610:7: INNER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INNER362=(CommonTree)match(input,INNER,FOLLOW_INNER_in_eid5099); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INNER362_tree = (CommonTree)adaptor.dupNode(INNER362);


                    adaptor.addChild(root_0, INNER362_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (INNER362!=null?INNER362.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 23 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1611:7: OUTER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    OUTER363=(CommonTree)match(input,OUTER,FOLLOW_OUTER_in_eid5109); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OUTER363_tree = (CommonTree)adaptor.dupNode(OUTER363);


                    adaptor.addChild(root_0, OUTER363_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (OUTER363!=null?OUTER363.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 24 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1612:7: PARALLEL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    PARALLEL364=(CommonTree)match(input,PARALLEL,FOLLOW_PARALLEL_in_eid5119); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PARALLEL364_tree = (CommonTree)adaptor.dupNode(PARALLEL364);


                    adaptor.addChild(root_0, PARALLEL364_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (PARALLEL364!=null?PARALLEL364.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 25 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1613:7: PARTITION
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    PARTITION365=(CommonTree)match(input,PARTITION,FOLLOW_PARTITION_in_eid5129); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PARTITION365_tree = (CommonTree)adaptor.dupNode(PARTITION365);


                    adaptor.addChild(root_0, PARTITION365_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (PARTITION365!=null?PARTITION365.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 26 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1614:7: GROUP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    GROUP366=(CommonTree)match(input,GROUP,FOLLOW_GROUP_in_eid5139); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    GROUP366_tree = (CommonTree)adaptor.dupNode(GROUP366);


                    adaptor.addChild(root_0, GROUP366_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (GROUP366!=null?GROUP366.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 27 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1615:7: AND
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    AND367=(CommonTree)match(input,AND,FOLLOW_AND_in_eid5149); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    AND367_tree = (CommonTree)adaptor.dupNode(AND367);


                    adaptor.addChild(root_0, AND367_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (AND367!=null?AND367.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 28 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1616:7: OR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    OR368=(CommonTree)match(input,OR,FOLLOW_OR_in_eid5159); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OR368_tree = (CommonTree)adaptor.dupNode(OR368);


                    adaptor.addChild(root_0, OR368_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (OR368!=null?OR368.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 29 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1617:7: NOT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    NOT369=(CommonTree)match(input,NOT,FOLLOW_NOT_in_eid5169); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NOT369_tree = (CommonTree)adaptor.dupNode(NOT369);


                    adaptor.addChild(root_0, NOT369_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (NOT369!=null?NOT369.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 30 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1618:7: GENERATE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    GENERATE370=(CommonTree)match(input,GENERATE,FOLLOW_GENERATE_in_eid5179); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    GENERATE370_tree = (CommonTree)adaptor.dupNode(GENERATE370);


                    adaptor.addChild(root_0, GENERATE370_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (GENERATE370!=null?GENERATE370.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 31 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1619:7: FLATTEN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FLATTEN371=(CommonTree)match(input,FLATTEN,FOLLOW_FLATTEN_in_eid5189); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FLATTEN371_tree = (CommonTree)adaptor.dupNode(FLATTEN371);


                    adaptor.addChild(root_0, FLATTEN371_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (FLATTEN371!=null?FLATTEN371.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 32 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1620:7: EVAL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    EVAL372=(CommonTree)match(input,EVAL,FOLLOW_EVAL_in_eid5199); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EVAL372_tree = (CommonTree)adaptor.dupNode(EVAL372);


                    adaptor.addChild(root_0, EVAL372_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (EVAL372!=null?EVAL372.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 33 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1621:7: ASC
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ASC373=(CommonTree)match(input,ASC,FOLLOW_ASC_in_eid5209); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ASC373_tree = (CommonTree)adaptor.dupNode(ASC373);


                    adaptor.addChild(root_0, ASC373_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (ASC373!=null?ASC373.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 34 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1622:7: DESC
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DESC374=(CommonTree)match(input,DESC,FOLLOW_DESC_in_eid5219); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DESC374_tree = (CommonTree)adaptor.dupNode(DESC374);


                    adaptor.addChild(root_0, DESC374_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (DESC374!=null?DESC374.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 35 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1623:7: BOOLEAN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BOOLEAN375=(CommonTree)match(input,BOOLEAN,FOLLOW_BOOLEAN_in_eid5229); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BOOLEAN375_tree = (CommonTree)adaptor.dupNode(BOOLEAN375);


                    adaptor.addChild(root_0, BOOLEAN375_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (BOOLEAN375!=null?BOOLEAN375.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 36 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1624:7: INT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INT376=(CommonTree)match(input,INT,FOLLOW_INT_in_eid5239); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INT376_tree = (CommonTree)adaptor.dupNode(INT376);


                    adaptor.addChild(root_0, INT376_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (INT376!=null?INT376.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 37 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1625:7: LONG
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LONG377=(CommonTree)match(input,LONG,FOLLOW_LONG_in_eid5249); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LONG377_tree = (CommonTree)adaptor.dupNode(LONG377);


                    adaptor.addChild(root_0, LONG377_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (LONG377!=null?LONG377.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 38 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1626:7: FLOAT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FLOAT378=(CommonTree)match(input,FLOAT,FOLLOW_FLOAT_in_eid5259); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FLOAT378_tree = (CommonTree)adaptor.dupNode(FLOAT378);


                    adaptor.addChild(root_0, FLOAT378_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (FLOAT378!=null?FLOAT378.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 39 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1627:7: DOUBLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DOUBLE379=(CommonTree)match(input,DOUBLE,FOLLOW_DOUBLE_in_eid5269); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DOUBLE379_tree = (CommonTree)adaptor.dupNode(DOUBLE379);


                    adaptor.addChild(root_0, DOUBLE379_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (DOUBLE379!=null?DOUBLE379.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 40 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1628:7: CHARARRAY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CHARARRAY380=(CommonTree)match(input,CHARARRAY,FOLLOW_CHARARRAY_in_eid5279); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CHARARRAY380_tree = (CommonTree)adaptor.dupNode(CHARARRAY380);


                    adaptor.addChild(root_0, CHARARRAY380_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (CHARARRAY380!=null?CHARARRAY380.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 41 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1629:7: BYTEARRAY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BYTEARRAY381=(CommonTree)match(input,BYTEARRAY,FOLLOW_BYTEARRAY_in_eid5289); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BYTEARRAY381_tree = (CommonTree)adaptor.dupNode(BYTEARRAY381);


                    adaptor.addChild(root_0, BYTEARRAY381_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (BYTEARRAY381!=null?BYTEARRAY381.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 42 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1630:7: BAG
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BAG382=(CommonTree)match(input,BAG,FOLLOW_BAG_in_eid5299); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BAG382_tree = (CommonTree)adaptor.dupNode(BAG382);


                    adaptor.addChild(root_0, BAG382_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (BAG382!=null?BAG382.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 43 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1631:7: TUPLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TUPLE383=(CommonTree)match(input,TUPLE,FOLLOW_TUPLE_in_eid5309); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TUPLE383_tree = (CommonTree)adaptor.dupNode(TUPLE383);


                    adaptor.addChild(root_0, TUPLE383_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (TUPLE383!=null?TUPLE383.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 44 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1632:7: MAP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    MAP384=(CommonTree)match(input,MAP,FOLLOW_MAP_in_eid5319); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MAP384_tree = (CommonTree)adaptor.dupNode(MAP384);


                    adaptor.addChild(root_0, MAP384_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (MAP384!=null?MAP384.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 45 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1633:7: IS
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IS385=(CommonTree)match(input,IS,FOLLOW_IS_in_eid5329); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IS385_tree = (CommonTree)adaptor.dupNode(IS385);


                    adaptor.addChild(root_0, IS385_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (IS385!=null?IS385.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 46 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1634:7: NULL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    NULL386=(CommonTree)match(input,NULL,FOLLOW_NULL_in_eid5339); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NULL386_tree = (CommonTree)adaptor.dupNode(NULL386);


                    adaptor.addChild(root_0, NULL386_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (NULL386!=null?NULL386.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 47 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1635:7: TRUE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TRUE387=(CommonTree)match(input,TRUE,FOLLOW_TRUE_in_eid5349); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TRUE387_tree = (CommonTree)adaptor.dupNode(TRUE387);


                    adaptor.addChild(root_0, TRUE387_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (TRUE387!=null?TRUE387.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 48 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1636:7: FALSE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FALSE388=(CommonTree)match(input,FALSE,FOLLOW_FALSE_in_eid5359); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FALSE388_tree = (CommonTree)adaptor.dupNode(FALSE388);


                    adaptor.addChild(root_0, FALSE388_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (FALSE388!=null?FALSE388.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 49 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1637:7: STREAM
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STREAM389=(CommonTree)match(input,STREAM,FOLLOW_STREAM_in_eid5369); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STREAM389_tree = (CommonTree)adaptor.dupNode(STREAM389);


                    adaptor.addChild(root_0, STREAM389_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (STREAM389!=null?STREAM389.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 50 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1638:7: THROUGH
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    THROUGH390=(CommonTree)match(input,THROUGH,FOLLOW_THROUGH_in_eid5379); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    THROUGH390_tree = (CommonTree)adaptor.dupNode(THROUGH390);


                    adaptor.addChild(root_0, THROUGH390_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (THROUGH390!=null?THROUGH390.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 51 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1639:7: STORE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STORE391=(CommonTree)match(input,STORE,FOLLOW_STORE_in_eid5389); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STORE391_tree = (CommonTree)adaptor.dupNode(STORE391);


                    adaptor.addChild(root_0, STORE391_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (STORE391!=null?STORE391.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 52 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1640:7: MAPREDUCE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    MAPREDUCE392=(CommonTree)match(input,MAPREDUCE,FOLLOW_MAPREDUCE_in_eid5399); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MAPREDUCE392_tree = (CommonTree)adaptor.dupNode(MAPREDUCE392);


                    adaptor.addChild(root_0, MAPREDUCE392_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (MAPREDUCE392!=null?MAPREDUCE392.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 53 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1641:7: SHIP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    SHIP393=(CommonTree)match(input,SHIP,FOLLOW_SHIP_in_eid5409); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SHIP393_tree = (CommonTree)adaptor.dupNode(SHIP393);


                    adaptor.addChild(root_0, SHIP393_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (SHIP393!=null?SHIP393.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 54 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1642:7: CACHE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CACHE394=(CommonTree)match(input,CACHE,FOLLOW_CACHE_in_eid5419); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CACHE394_tree = (CommonTree)adaptor.dupNode(CACHE394);


                    adaptor.addChild(root_0, CACHE394_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (CACHE394!=null?CACHE394.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 55 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1643:7: INPUT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INPUT395=(CommonTree)match(input,INPUT,FOLLOW_INPUT_in_eid5429); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INPUT395_tree = (CommonTree)adaptor.dupNode(INPUT395);


                    adaptor.addChild(root_0, INPUT395_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (INPUT395!=null?INPUT395.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 56 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1644:7: OUTPUT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    OUTPUT396=(CommonTree)match(input,OUTPUT,FOLLOW_OUTPUT_in_eid5439); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OUTPUT396_tree = (CommonTree)adaptor.dupNode(OUTPUT396);


                    adaptor.addChild(root_0, OUTPUT396_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (OUTPUT396!=null?OUTPUT396.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 57 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1645:7: STDERROR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STDERROR397=(CommonTree)match(input,STDERROR,FOLLOW_STDERROR_in_eid5449); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDERROR397_tree = (CommonTree)adaptor.dupNode(STDERROR397);


                    adaptor.addChild(root_0, STDERROR397_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (STDERROR397!=null?STDERROR397.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 58 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1646:7: STDIN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STDIN398=(CommonTree)match(input,STDIN,FOLLOW_STDIN_in_eid5459); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDIN398_tree = (CommonTree)adaptor.dupNode(STDIN398);


                    adaptor.addChild(root_0, STDIN398_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (STDIN398!=null?STDIN398.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 59 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1647:7: STDOUT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STDOUT399=(CommonTree)match(input,STDOUT,FOLLOW_STDOUT_in_eid5469); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDOUT399_tree = (CommonTree)adaptor.dupNode(STDOUT399);


                    adaptor.addChild(root_0, STDOUT399_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (STDOUT399!=null?STDOUT399.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 60 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1648:7: LIMIT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LIMIT400=(CommonTree)match(input,LIMIT,FOLLOW_LIMIT_in_eid5479); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LIMIT400_tree = (CommonTree)adaptor.dupNode(LIMIT400);


                    adaptor.addChild(root_0, LIMIT400_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (LIMIT400!=null?LIMIT400.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 61 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1649:7: SAMPLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    SAMPLE401=(CommonTree)match(input,SAMPLE,FOLLOW_SAMPLE_in_eid5489); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SAMPLE401_tree = (CommonTree)adaptor.dupNode(SAMPLE401);


                    adaptor.addChild(root_0, SAMPLE401_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (SAMPLE401!=null?SAMPLE401.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 62 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1650:7: LEFT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LEFT402=(CommonTree)match(input,LEFT,FOLLOW_LEFT_in_eid5499); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LEFT402_tree = (CommonTree)adaptor.dupNode(LEFT402);


                    adaptor.addChild(root_0, LEFT402_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (LEFT402!=null?LEFT402.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 63 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1651:7: RIGHT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    RIGHT403=(CommonTree)match(input,RIGHT,FOLLOW_RIGHT_in_eid5509); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RIGHT403_tree = (CommonTree)adaptor.dupNode(RIGHT403);


                    adaptor.addChild(root_0, RIGHT403_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (RIGHT403!=null?RIGHT403.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 64 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1652:7: FULL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FULL404=(CommonTree)match(input,FULL,FOLLOW_FULL_in_eid5519); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FULL404_tree = (CommonTree)adaptor.dupNode(FULL404);


                    adaptor.addChild(root_0, FULL404_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (FULL404!=null?FULL404.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 65 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1653:7: IDENTIFIER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER405=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_eid5529); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER405_tree = (CommonTree)adaptor.dupNode(IDENTIFIER405);


                    adaptor.addChild(root_0, IDENTIFIER405_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (IDENTIFIER405!=null?IDENTIFIER405.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 66 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1654:7: TOBAG
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TOBAG406=(CommonTree)match(input,TOBAG,FOLLOW_TOBAG_in_eid5539); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TOBAG406_tree = (CommonTree)adaptor.dupNode(TOBAG406);


                    adaptor.addChild(root_0, TOBAG406_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = "TOBAG"; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 67 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1655:7: TOMAP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TOMAP407=(CommonTree)match(input,TOMAP,FOLLOW_TOMAP_in_eid5549); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TOMAP407_tree = (CommonTree)adaptor.dupNode(TOMAP407);


                    adaptor.addChild(root_0, TOMAP407_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = "TOMAP"; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 68 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1656:7: TOTUPLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TOTUPLE408=(CommonTree)match(input,TOTUPLE,FOLLOW_TOTUPLE_in_eid5559); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TOTUPLE408_tree = (CommonTree)adaptor.dupNode(TOTUPLE408);


                    adaptor.addChild(root_0, TOTUPLE408_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = "TOTUPLE"; }

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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1660:1: rel_op : ( rel_op_eq | rel_op_ne | rel_op_gt | rel_op_gte | rel_op_lt | rel_op_lte | STR_OP_MATCHES );
    public final LogicalPlanGenerator.rel_op_return rel_op() throws RecognitionException {
        LogicalPlanGenerator.rel_op_return retval = new LogicalPlanGenerator.rel_op_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STR_OP_MATCHES415=null;
        LogicalPlanGenerator.rel_op_eq_return rel_op_eq409 =null;

        LogicalPlanGenerator.rel_op_ne_return rel_op_ne410 =null;

        LogicalPlanGenerator.rel_op_gt_return rel_op_gt411 =null;

        LogicalPlanGenerator.rel_op_gte_return rel_op_gte412 =null;

        LogicalPlanGenerator.rel_op_lt_return rel_op_lt413 =null;

        LogicalPlanGenerator.rel_op_lte_return rel_op_lte414 =null;


        CommonTree STR_OP_MATCHES415_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1660:8: ( rel_op_eq | rel_op_ne | rel_op_gt | rel_op_gte | rel_op_lt | rel_op_lte | STR_OP_MATCHES )
            int alt110=7;
            switch ( input.LA(1) ) {
            case NUM_OP_EQ:
            case STR_OP_EQ:
                {
                alt110=1;
                }
                break;
            case NUM_OP_NE:
            case STR_OP_NE:
                {
                alt110=2;
                }
                break;
            case NUM_OP_GT:
            case STR_OP_GT:
                {
                alt110=3;
                }
                break;
            case NUM_OP_GTE:
            case STR_OP_GTE:
                {
                alt110=4;
                }
                break;
            case NUM_OP_LT:
            case STR_OP_LT:
                {
                alt110=5;
                }
                break;
            case NUM_OP_LTE:
            case STR_OP_LTE:
                {
                alt110=6;
                }
                break;
            case STR_OP_MATCHES:
                {
                alt110=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 110, 0, input);

                throw nvae;

            }

            switch (alt110) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1660:10: rel_op_eq
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_eq_in_rel_op5571);
                    rel_op_eq409=rel_op_eq();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_eq409.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1661:10: rel_op_ne
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_ne_in_rel_op5582);
                    rel_op_ne410=rel_op_ne();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_ne410.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1662:10: rel_op_gt
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_gt_in_rel_op5593);
                    rel_op_gt411=rel_op_gt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_gt411.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1663:10: rel_op_gte
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_gte_in_rel_op5604);
                    rel_op_gte412=rel_op_gte();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_gte412.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1664:10: rel_op_lt
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_lt_in_rel_op5615);
                    rel_op_lt413=rel_op_lt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_lt413.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1665:10: rel_op_lte
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_lte_in_rel_op5626);
                    rel_op_lte414=rel_op_lte();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_lte414.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1666:10: STR_OP_MATCHES
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_MATCHES415=(CommonTree)match(input,STR_OP_MATCHES,FOLLOW_STR_OP_MATCHES_in_rel_op5637); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_MATCHES415_tree = (CommonTree)adaptor.dupNode(STR_OP_MATCHES415);


                    adaptor.addChild(root_0, STR_OP_MATCHES415_tree);
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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1669:1: rel_op_eq : ( STR_OP_EQ | NUM_OP_EQ );
    public final LogicalPlanGenerator.rel_op_eq_return rel_op_eq() throws RecognitionException {
        LogicalPlanGenerator.rel_op_eq_return retval = new LogicalPlanGenerator.rel_op_eq_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set416=null;

        CommonTree set416_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1669:11: ( STR_OP_EQ | NUM_OP_EQ )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set416=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_EQ||input.LA(1)==STR_OP_EQ ) {
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
    // $ANTLR end "rel_op_eq"


    public static class rel_op_ne_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_op_ne"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1672:1: rel_op_ne : ( STR_OP_NE | NUM_OP_NE );
    public final LogicalPlanGenerator.rel_op_ne_return rel_op_ne() throws RecognitionException {
        LogicalPlanGenerator.rel_op_ne_return retval = new LogicalPlanGenerator.rel_op_ne_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set417=null;

        CommonTree set417_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1672:11: ( STR_OP_NE | NUM_OP_NE )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set417=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_NE||input.LA(1)==STR_OP_NE ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set417_tree = (CommonTree)adaptor.dupNode(set417);


                adaptor.addChild(root_0, set417_tree);
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
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1675:1: rel_op_gt : ( STR_OP_GT | NUM_OP_GT );
    public final LogicalPlanGenerator.rel_op_gt_return rel_op_gt() throws RecognitionException {
        LogicalPlanGenerator.rel_op_gt_return retval = new LogicalPlanGenerator.rel_op_gt_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set418=null;

        CommonTree set418_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1675:11: ( STR_OP_GT | NUM_OP_GT )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set418=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_GT||input.LA(1)==STR_OP_GT ) {
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
    // $ANTLR end "rel_op_gt"


    public static class rel_op_gte_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_op_gte"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1678:1: rel_op_gte : ( STR_OP_GTE | NUM_OP_GTE );
    public final LogicalPlanGenerator.rel_op_gte_return rel_op_gte() throws RecognitionException {
        LogicalPlanGenerator.rel_op_gte_return retval = new LogicalPlanGenerator.rel_op_gte_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set419=null;

        CommonTree set419_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1678:12: ( STR_OP_GTE | NUM_OP_GTE )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set419=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_GTE||input.LA(1)==STR_OP_GTE ) {
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
    // $ANTLR end "rel_op_gte"


    public static class rel_op_lt_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_op_lt"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1681:1: rel_op_lt : ( STR_OP_LT | NUM_OP_LT );
    public final LogicalPlanGenerator.rel_op_lt_return rel_op_lt() throws RecognitionException {
        LogicalPlanGenerator.rel_op_lt_return retval = new LogicalPlanGenerator.rel_op_lt_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set420=null;

        CommonTree set420_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1681:11: ( STR_OP_LT | NUM_OP_LT )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set420=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_LT||input.LA(1)==STR_OP_LT ) {
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
    // $ANTLR end "rel_op_lt"


    public static class rel_op_lte_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_op_lte"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1684:1: rel_op_lte : ( STR_OP_LTE | NUM_OP_LTE );
    public final LogicalPlanGenerator.rel_op_lte_return rel_op_lte() throws RecognitionException {
        LogicalPlanGenerator.rel_op_lte_return retval = new LogicalPlanGenerator.rel_op_lte_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set421=null;

        CommonTree set421_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1684:12: ( STR_OP_LTE | NUM_OP_LTE )
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set421=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_LTE||input.LA(1)==STR_OP_LTE ) {
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
    // $ANTLR end "rel_op_lte"


    public static class rel_str_op_return extends TreeRuleReturnScope {
        public String id;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_str_op"
    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1687:1: rel_str_op returns [String id] : ( STR_OP_EQ | STR_OP_NE | STR_OP_GT | STR_OP_LT | STR_OP_GTE | STR_OP_LTE | STR_OP_MATCHES );
    public final LogicalPlanGenerator.rel_str_op_return rel_str_op() throws RecognitionException {
        LogicalPlanGenerator.rel_str_op_return retval = new LogicalPlanGenerator.rel_str_op_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STR_OP_EQ422=null;
        CommonTree STR_OP_NE423=null;
        CommonTree STR_OP_GT424=null;
        CommonTree STR_OP_LT425=null;
        CommonTree STR_OP_GTE426=null;
        CommonTree STR_OP_LTE427=null;
        CommonTree STR_OP_MATCHES428=null;

        CommonTree STR_OP_EQ422_tree=null;
        CommonTree STR_OP_NE423_tree=null;
        CommonTree STR_OP_GT424_tree=null;
        CommonTree STR_OP_LT425_tree=null;
        CommonTree STR_OP_GTE426_tree=null;
        CommonTree STR_OP_LTE427_tree=null;
        CommonTree STR_OP_MATCHES428_tree=null;

        try {
            // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1688:2: ( STR_OP_EQ | STR_OP_NE | STR_OP_GT | STR_OP_LT | STR_OP_GTE | STR_OP_LTE | STR_OP_MATCHES )
            int alt111=7;
            switch ( input.LA(1) ) {
            case STR_OP_EQ:
                {
                alt111=1;
                }
                break;
            case STR_OP_NE:
                {
                alt111=2;
                }
                break;
            case STR_OP_GT:
                {
                alt111=3;
                }
                break;
            case STR_OP_LT:
                {
                alt111=4;
                }
                break;
            case STR_OP_GTE:
                {
                alt111=5;
                }
                break;
            case STR_OP_LTE:
                {
                alt111=6;
                }
                break;
            case STR_OP_MATCHES:
                {
                alt111=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 111, 0, input);

                throw nvae;

            }

            switch (alt111) {
                case 1 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1688:4: STR_OP_EQ
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_EQ422=(CommonTree)match(input,STR_OP_EQ,FOLLOW_STR_OP_EQ_in_rel_str_op5728); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_EQ422_tree = (CommonTree)adaptor.dupNode(STR_OP_EQ422);


                    adaptor.addChild(root_0, STR_OP_EQ422_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (STR_OP_EQ422!=null?STR_OP_EQ422.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1689:4: STR_OP_NE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_NE423=(CommonTree)match(input,STR_OP_NE,FOLLOW_STR_OP_NE_in_rel_str_op5735); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_NE423_tree = (CommonTree)adaptor.dupNode(STR_OP_NE423);


                    adaptor.addChild(root_0, STR_OP_NE423_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (STR_OP_NE423!=null?STR_OP_NE423.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1690:4: STR_OP_GT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_GT424=(CommonTree)match(input,STR_OP_GT,FOLLOW_STR_OP_GT_in_rel_str_op5742); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_GT424_tree = (CommonTree)adaptor.dupNode(STR_OP_GT424);


                    adaptor.addChild(root_0, STR_OP_GT424_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (STR_OP_GT424!=null?STR_OP_GT424.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1691:4: STR_OP_LT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_LT425=(CommonTree)match(input,STR_OP_LT,FOLLOW_STR_OP_LT_in_rel_str_op5749); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_LT425_tree = (CommonTree)adaptor.dupNode(STR_OP_LT425);


                    adaptor.addChild(root_0, STR_OP_LT425_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (STR_OP_LT425!=null?STR_OP_LT425.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1692:4: STR_OP_GTE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_GTE426=(CommonTree)match(input,STR_OP_GTE,FOLLOW_STR_OP_GTE_in_rel_str_op5756); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_GTE426_tree = (CommonTree)adaptor.dupNode(STR_OP_GTE426);


                    adaptor.addChild(root_0, STR_OP_GTE426_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (STR_OP_GTE426!=null?STR_OP_GTE426.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1693:4: STR_OP_LTE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_LTE427=(CommonTree)match(input,STR_OP_LTE,FOLLOW_STR_OP_LTE_in_rel_str_op5763); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_LTE427_tree = (CommonTree)adaptor.dupNode(STR_OP_LTE427);


                    adaptor.addChild(root_0, STR_OP_LTE427_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (STR_OP_LTE427!=null?STR_OP_LTE427.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1694:4: STR_OP_MATCHES
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_MATCHES428=(CommonTree)match(input,STR_OP_MATCHES,FOLLOW_STR_OP_MATCHES_in_rel_str_op5770); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_MATCHES428_tree = (CommonTree)adaptor.dupNode(STR_OP_MATCHES428);


                    adaptor.addChild(root_0, STR_OP_MATCHES428_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (STR_OP_MATCHES428!=null?STR_OP_MATCHES428.getText():null); }

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

    // $ANTLR start synpred117_LogicalPlanGenerator
    public final void synpred117_LogicalPlanGenerator_fragment() throws RecognitionException {
        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:915:20: ( INTEGER )
        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:915:20: INTEGER
        {
        match(input,INTEGER,FOLLOW_INTEGER_in_synpred117_LogicalPlanGenerator2893); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred117_LogicalPlanGenerator

    // $ANTLR start synpred118_LogicalPlanGenerator
    public final void synpred118_LogicalPlanGenerator_fragment() throws RecognitionException {
        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:920:4: ( LONGINTEGER )
        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:920:4: LONGINTEGER
        {
        match(input,LONGINTEGER,FOLLOW_LONGINTEGER_in_synpred118_LogicalPlanGenerator2903); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred118_LogicalPlanGenerator

    // $ANTLR start synpred119_LogicalPlanGenerator
    public final void synpred119_LogicalPlanGenerator_fragment() throws RecognitionException {
        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:939:20: ( DOUBLENUMBER )
        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:939:20: DOUBLENUMBER
        {
        match(input,DOUBLENUMBER,FOLLOW_DOUBLENUMBER_in_synpred119_LogicalPlanGenerator2955); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred119_LogicalPlanGenerator

    // $ANTLR start synpred138_LogicalPlanGenerator
    public final void synpred138_LogicalPlanGenerator_fragment() throws RecognitionException {
        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1058:4: ( join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item )
        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1058:4: join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item
        {
        pushFollow(FOLLOW_join_item_in_synpred138_LogicalPlanGenerator3308);
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


        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1063:66: ( OUTER )?
        int alt121=2;
        int LA121_0 = input.LA(1);

        if ( (LA121_0==OUTER) ) {
            alt121=1;
        }
        switch (alt121) {
            case 1 :
                // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1063:66: OUTER
                {
                match(input,OUTER,FOLLOW_OUTER_in_synpred138_LogicalPlanGenerator3357); if (state.failed) return ;

                }
                break;

        }


        pushFollow(FOLLOW_join_item_in_synpred138_LogicalPlanGenerator3360);
        join_item();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred138_LogicalPlanGenerator

    // $ANTLR start synpred155_LogicalPlanGenerator
    public final void synpred155_LogicalPlanGenerator_fragment() throws RecognitionException {
        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1247:31: ( INTEGER )
        // /Users/wrvhage/Dropbox/teaching/Information_Retrieval_2012_2013/Distributed/pig-0.10.0-lucene/src//org/apache/pig/parser/LogicalPlanGenerator.g:1247:31: INTEGER
        {
        match(input,INTEGER,FOLLOW_INTEGER_in_synpred155_LogicalPlanGenerator3934); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred155_LogicalPlanGenerator

    // Delegated rules

    public final boolean synpred117_LogicalPlanGenerator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred117_LogicalPlanGenerator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred138_LogicalPlanGenerator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred138_LogicalPlanGenerator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred155_LogicalPlanGenerator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred155_LogicalPlanGenerator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred119_LogicalPlanGenerator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred119_LogicalPlanGenerator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred118_LogicalPlanGenerator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred118_LogicalPlanGenerator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_QUERY_in_query88 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_query90 = new BitSet(new long[]{0x0000000000000008L,0x0000000200000000L,0x0000000000900000L});
    public static final BitSet FOLLOW_general_statement_in_statement112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_split_statement_in_statement117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_realias_statement_in_statement122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_split_clause_in_split_statement131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_realias_clause_in_realias_statement140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STATEMENT_in_general_statement152 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_general_statement156 = new BitSet(new long[]{0x46080121004A4000L,0x000400C010000800L});
    public static final BitSet FOLLOW_op_clause_in_general_statement167 = new BitSet(new long[]{0x0000000000000008L,0x0000000000008000L});
    public static final BitSet FOLLOW_parallel_clause_in_general_statement169 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_REALIAS_in_realias_clause186 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_realias_clause188 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_IDENTIFIER_in_realias_clause190 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PARALLEL_in_parallel_clause209 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INTEGER_in_parallel_clause211 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IDENTIFIER_in_alias229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_define_clause_in_op_clause256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_load_clause_in_op_clause271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_group_clause_in_op_clause287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_store_clause_in_op_clause303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_filter_clause_in_op_clause319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_distinct_clause_in_op_clause335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_limit_clause_in_op_clause351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sample_clause_in_op_clause367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_order_clause_in_op_clause383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cross_clause_in_op_clause399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_join_clause_in_op_clause415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_union_clause_in_op_clause431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stream_clause_in_op_clause447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mr_clause_in_op_clause463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_foreach_clause_in_op_clause479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEFINE_in_define_clause494 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_define_clause496 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_cmd_in_define_clause498 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DEFINE_in_define_clause514 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_define_clause516 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000014L});
    public static final BitSet FOLLOW_func_clause_in_define_clause518 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXECCOMMAND_in_cmd547 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ship_clause_in_cmd551 = new BitSet(new long[]{0x0000400000001008L,0x0000000840004000L});
    public static final BitSet FOLLOW_cache_clause_in_cmd556 = new BitSet(new long[]{0x0000400000001008L,0x0000000840004000L});
    public static final BitSet FOLLOW_input_clause_in_cmd561 = new BitSet(new long[]{0x0000400000001008L,0x0000000840004000L});
    public static final BitSet FOLLOW_output_clause_in_cmd565 = new BitSet(new long[]{0x0000400000001008L,0x0000000840004000L});
    public static final BitSet FOLLOW_error_clause_in_cmd569 = new BitSet(new long[]{0x0000400000001008L,0x0000000840004000L});
    public static final BitSet FOLLOW_SHIP_in_ship_clause592 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_path_list_in_ship_clause594 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_path_list611 = new BitSet(new long[]{0x0000000000000002L,0x0000000000400000L});
    public static final BitSet FOLLOW_CACHE_in_cache_clause629 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_path_list_in_cache_clause631 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INPUT_in_input_clause654 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_stream_cmd_in_input_clause658 = new BitSet(new long[]{0x0000000000000008L,0x0000003000400000L});
    public static final BitSet FOLLOW_STDIN_in_stream_cmd692 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_clause_in_stream_cmd704 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STDOUT_in_stream_cmd719 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_clause_in_stream_cmd731 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_stream_cmd746 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_clause_in_stream_cmd758 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OUTPUT_in_output_clause786 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_stream_cmd_in_output_clause790 = new BitSet(new long[]{0x0000000000000008L,0x0000003000400000L});
    public static final BitSet FOLLOW_STDERROR_in_error_clause818 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_error_clause829 = new BitSet(new long[]{0x0001000000000008L});
    public static final BitSet FOLLOW_INTEGER_in_error_clause852 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LOAD_in_load_clause906 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_filename_in_load_clause908 = new BitSet(new long[]{0x0000000000000048L,0x0000000000000000L,0x0000000000000014L});
    public static final BitSet FOLLOW_func_clause_in_load_clause910 = new BitSet(new long[]{0x0000000000000048L});
    public static final BitSet FOLLOW_as_clause_in_load_clause914 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_filename934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AS_in_as_clause951 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_field_def_list_in_as_clause953 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FIELD_DEF_in_field_def981 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_field_def983 = new BitSet(new long[]{0x0800800404002A08L,0x0080000000000000L,0x0000000008000800L});
    public static final BitSet FOLLOW_type_in_field_def987 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_field_def_in_field_def_list1019 = new BitSet(new long[]{0x0000000000000002L,0x8000000000000000L});
    public static final BitSet FOLLOW_simple_type_in_type1038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tuple_type_in_type1048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bag_type_in_type1058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_map_type_in_type1068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOLEAN_in_simple_type1086 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_simple_type1093 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LONG_in_simple_type1100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_simple_type1107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLE_in_simple_type1114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHARARRAY_in_simple_type1121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BYTEARRAY_in_simple_type1128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TUPLE_TYPE_in_tuple_type1145 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_field_def_list_in_tuple_type1156 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BAG_TYPE_in_bag_type1196 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_bag_type1198 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_tuple_type_in_bag_type1201 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MAP_TYPE_in_map_type1224 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_in_map_type1226 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNC_REF_in_func_clause1255 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_func_clause1257 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNC_in_func_clause1271 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_func_clause1273 = new BitSet(new long[]{0x0000000000000008L,0x0000000000400002L});
    public static final BitSet FOLLOW_func_args_in_func_clause1275 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_eid_in_func_name1306 = new BitSet(new long[]{0x0000000001000002L,0x0000000000040000L});
    public static final BitSet FOLLOW_PERIOD_in_func_name1320 = new BitSet(new long[]{0x6E1EF9E7845A7FF0L,0x000FFFFA5181EC04L,0x00000000C7020020L});
    public static final BitSet FOLLOW_DOLLAR_in_func_name1326 = new BitSet(new long[]{0x6E1EF9E7845A7FF0L,0x000FFFFA5181EC04L,0x00000000C7020020L});
    public static final BitSet FOLLOW_eid_in_func_name1342 = new BitSet(new long[]{0x0000000001000002L,0x0000000000040000L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_func_args1371 = new BitSet(new long[]{0x0000000000000002L,0x0000000000400002L});
    public static final BitSet FOLLOW_MULTILINE_QUOTEDSTRING_in_func_args1382 = new BitSet(new long[]{0x0000000000000002L,0x0000000000400002L});
    public static final BitSet FOLLOW_GROUP_in_group_clause1423 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_group_item_in_group_clause1425 = new BitSet(new long[]{0x46080121004A4008L,0x000400C010410800L,0x0000000000000020L});
    public static final BitSet FOLLOW_group_type_in_group_clause1430 = new BitSet(new long[]{0x0000000000000008L,0x0000000000010000L});
    public static final BitSet FOLLOW_partition_clause_in_group_clause1437 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_COGROUP_in_group_clause1452 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_group_item_in_group_clause1454 = new BitSet(new long[]{0x46080121004A4008L,0x000400C010410800L,0x0000000000000020L});
    public static final BitSet FOLLOW_group_type_in_group_clause1459 = new BitSet(new long[]{0x0000000000000008L,0x0000000000010000L});
    public static final BitSet FOLLOW_partition_clause_in_group_clause1466 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_group_type1487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_in_group_item1508 = new BitSet(new long[]{0x0000000000000410L,0x0040000000000000L});
    public static final BitSet FOLLOW_join_group_by_clause_in_group_item1512 = new BitSet(new long[]{0x0000200000000002L,0x0000000000002000L});
    public static final BitSet FOLLOW_ALL_in_group_item1537 = new BitSet(new long[]{0x0000200000000002L,0x0000000000002000L});
    public static final BitSet FOLLOW_ANY_in_group_item1562 = new BitSet(new long[]{0x0000200000000002L,0x0000000000002000L});
    public static final BitSet FOLLOW_INNER_in_group_item1587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OUTER_in_group_item1593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_alias_in_rel1611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_inline_op_in_rel1621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_op_clause_in_inline_op1641 = new BitSet(new long[]{0x0000000000000002L,0x0000000000008000L});
    public static final BitSet FOLLOW_parallel_clause_in_inline_op1643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_flatten_clause_in_flatten_generated_item1669 = new BitSet(new long[]{0x0000000000000002L,0x8000000000000000L});
    public static final BitSet FOLLOW_col_range_in_flatten_generated_item1679 = new BitSet(new long[]{0x0000000000000002L,0x8000000000000000L});
    public static final BitSet FOLLOW_expr_in_flatten_generated_item1687 = new BitSet(new long[]{0x0000000000000002L,0x8000000000000000L});
    public static final BitSet FOLLOW_STAR_in_flatten_generated_item1695 = new BitSet(new long[]{0x0000000000000002L,0x8000000000000000L});
    public static final BitSet FOLLOW_field_def_list_in_flatten_generated_item1714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLATTEN_in_flatten_clause1732 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_flatten_clause1734 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STORE_in_store_clause1752 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_store_clause1754 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_filename_in_store_clause1756 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000000000014L});
    public static final BitSet FOLLOW_func_clause_in_store_clause1758 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FILTER_in_filter_clause1792 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_filter_clause1794 = new BitSet(new long[]{0x0000000000000020L,0x00007F00000005FCL,0x0000000000020008L});
    public static final BitSet FOLLOW_cond_in_filter_clause1796 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OR_in_cond1820 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_cond1826 = new BitSet(new long[]{0x0000000000000020L,0x00007F00000005FCL,0x0000000000020008L});
    public static final BitSet FOLLOW_cond_in_cond1833 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AND_in_cond1848 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_cond1854 = new BitSet(new long[]{0x0000000000000020L,0x00007F00000005FCL,0x0000000000020008L});
    public static final BitSet FOLLOW_cond_in_cond1861 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NOT_in_cond1876 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_cond1882 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NULL_in_cond1897 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond1899 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000004L});
    public static final BitSet FOLLOW_NOT_in_cond1902 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rel_op_eq_in_cond1917 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond1923 = new BitSet(new long[]{0x900101108A800000L,0x56010004004A0000L,0x0000000020023028L});
    public static final BitSet FOLLOW_expr_in_cond1930 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rel_op_ne_in_cond1946 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond1952 = new BitSet(new long[]{0x900101108A800000L,0x56010004004A0000L,0x0000000020023028L});
    public static final BitSet FOLLOW_expr_in_cond1959 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rel_op_lt_in_cond1975 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond1981 = new BitSet(new long[]{0x900101108A800000L,0x56010004004A0000L,0x0000000020023028L});
    public static final BitSet FOLLOW_expr_in_cond1988 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rel_op_lte_in_cond2004 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond2010 = new BitSet(new long[]{0x900101108A800000L,0x56010004004A0000L,0x0000000020023028L});
    public static final BitSet FOLLOW_expr_in_cond2017 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rel_op_gt_in_cond2032 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond2038 = new BitSet(new long[]{0x900101108A800000L,0x56010004004A0000L,0x0000000020023028L});
    public static final BitSet FOLLOW_expr_in_cond2045 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rel_op_gte_in_cond2061 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond2067 = new BitSet(new long[]{0x900101108A800000L,0x56010004004A0000L,0x0000000020023028L});
    public static final BitSet FOLLOW_expr_in_cond2074 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STR_OP_MATCHES_in_cond2089 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond2095 = new BitSet(new long[]{0x900101108A800000L,0x56010004004A0000L,0x0000000020023028L});
    public static final BitSet FOLLOW_expr_in_cond2102 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_func_eval_in_cond2115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FUNC_EVAL_in_func_eval2142 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_func_eval2144 = new BitSet(new long[]{0x900101108A800008L,0x76010004004A0000L,0x0000000020023028L});
    public static final BitSet FOLLOW_real_arg_in_func_eval2148 = new BitSet(new long[]{0x900101108A800008L,0x76010004004A0000L,0x0000000020023028L});
    public static final BitSet FOLLOW_expr_in_real_arg2180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_real_arg2188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_col_range_in_real_arg2202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUS_in_expr2221 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr2227 = new BitSet(new long[]{0x900101108A800000L,0x56010004004A0000L,0x0000000020023028L});
    public static final BitSet FOLLOW_expr_in_expr2234 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MINUS_in_expr2249 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr2255 = new BitSet(new long[]{0x900101108A800000L,0x56010004004A0000L,0x0000000020023028L});
    public static final BitSet FOLLOW_expr_in_expr2262 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STAR_in_expr2277 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr2283 = new BitSet(new long[]{0x900101108A800000L,0x56010004004A0000L,0x0000000020023028L});
    public static final BitSet FOLLOW_expr_in_expr2290 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DIV_in_expr2305 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr2311 = new BitSet(new long[]{0x900101108A800000L,0x56010004004A0000L,0x0000000020023028L});
    public static final BitSet FOLLOW_expr_in_expr2318 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PERCENT_in_expr2333 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr2339 = new BitSet(new long[]{0x900101108A800000L,0x56010004004A0000L,0x0000000020023028L});
    public static final BitSet FOLLOW_expr_in_expr2346 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_const_expr_in_expr2359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_var_expr_in_expr2370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEG_in_expr2383 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr2389 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CAST_EXPR_in_expr2404 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_cast_in_expr2406 = new BitSet(new long[]{0x900101108A800000L,0x56010004004A0000L,0x0000000020023028L});
    public static final BitSet FOLLOW_expr_in_expr2412 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXPR_IN_PAREN_in_expr2428 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr2434 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_simple_type_in_type_cast2456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_map_type_in_type_cast2466 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tuple_type_cast_in_type_cast2476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bag_type_cast_in_type_cast2486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TUPLE_TYPE_CAST_in_tuple_type_cast2511 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_cast_in_tuple_type_cast2515 = new BitSet(new long[]{0x0800800404002A08L,0x0100000000000000L,0x0000000010000800L});
    public static final BitSet FOLLOW_BAG_TYPE_CAST_in_bag_type_cast2542 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_tuple_type_cast_in_bag_type_cast2544 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_projectable_expr_in_var_expr2571 = new BitSet(new long[]{0x0000000000000002L,0x0000000000140000L});
    public static final BitSet FOLLOW_dot_proj_in_var_expr2581 = new BitSet(new long[]{0x0000000000000002L,0x0000000000140000L});
    public static final BitSet FOLLOW_pound_proj_in_var_expr2596 = new BitSet(new long[]{0x0000000000000002L,0x0000000000140000L});
    public static final BitSet FOLLOW_func_eval_in_projectable_expr2626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_col_ref_in_projectable_expr2637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bin_expr_in_projectable_expr2648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PERIOD_in_dot_proj2674 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_col_alias_or_index_in_dot_proj2678 = new BitSet(new long[]{0x0000010002000008L,0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_col_alias_in_col_alias_or_index2698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_col_index_in_col_alias_or_index2704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GROUP_in_col_alias2719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_col_alias2726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOLLARVAR_in_col_index2741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COL_RANGE_in_col_range2760 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_col_ref_in_col_range2767 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_DOUBLE_PERIOD_in_col_range2772 = new BitSet(new long[]{0x0000010002000008L,0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_col_ref_in_col_range2779 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_POUND_in_pound_proj2807 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_pound_proj2811 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NULL_in_pound_proj2817 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BIN_EXPR_in_bin_expr2837 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_bin_expr2839 = new BitSet(new long[]{0x900101108A800000L,0x56010004004A0000L,0x0000000020023028L});
    public static final BitSet FOLLOW_expr_in_bin_expr2846 = new BitSet(new long[]{0x900101108A800000L,0x56010004004A0000L,0x0000000020023028L});
    public static final BitSet FOLLOW_expr_in_bin_expr2853 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LIMIT_in_limit_clause2887 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_limit_clause2889 = new BitSet(new long[]{0x900101108A800000L,0x56010004004A0000L,0x0000000020023028L});
    public static final BitSet FOLLOW_INTEGER_in_limit_clause2893 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LONGINTEGER_in_limit_clause2903 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expr_in_limit_clause2913 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SAMPLE_in_sample_clause2949 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_sample_clause2951 = new BitSet(new long[]{0x900101108A800000L,0x56010004004A0000L,0x0000000020023028L});
    public static final BitSet FOLLOW_DOUBLENUMBER_in_sample_clause2955 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expr_in_sample_clause2965 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ORDER_in_order_clause3002 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_order_clause3004 = new BitSet(new long[]{0x0000010002000000L,0x2000000400000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_order_by_clause_in_order_clause3006 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000000000014L});
    public static final BitSet FOLLOW_func_clause_in_order_clause3008 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STAR_in_order_by_clause3035 = new BitSet(new long[]{0x0000000000100082L});
    public static final BitSet FOLLOW_ASC_in_order_by_clause3044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESC_in_order_by_clause3050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_order_col_in_order_by_clause3062 = new BitSet(new long[]{0x0000010002000002L,0x2000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_col_range_in_order_col3088 = new BitSet(new long[]{0x0000000000100082L});
    public static final BitSet FOLLOW_ASC_in_order_col3092 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESC_in_order_col3096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_col_ref_in_order_col3106 = new BitSet(new long[]{0x0000000000100082L});
    public static final BitSet FOLLOW_ASC_in_order_col3111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESC_in_order_col3115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DISTINCT_in_distinct_clause3143 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_distinct_clause3145 = new BitSet(new long[]{0x0000000000000008L,0x0000000000010000L});
    public static final BitSet FOLLOW_partition_clause_in_distinct_clause3147 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PARTITION_in_partition_clause3170 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_partition_clause3172 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CROSS_in_cross_clause3194 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_list_in_cross_clause3196 = new BitSet(new long[]{0x0000000000000008L,0x0000000000010000L});
    public static final BitSet FOLLOW_partition_clause_in_cross_clause3198 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rel_in_rel_list3226 = new BitSet(new long[]{0x46080121004A4002L,0x000400C010000800L,0x0000000000000020L});
    public static final BitSet FOLLOW_JOIN_in_join_clause3265 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_join_sub_clause_in_join_clause3267 = new BitSet(new long[]{0x0000000000000008L,0x0000000000410000L});
    public static final BitSet FOLLOW_join_type_in_join_clause3269 = new BitSet(new long[]{0x0000000000000008L,0x0000000000010000L});
    public static final BitSet FOLLOW_partition_clause_in_join_clause3272 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_join_type3293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_join_item_in_join_sub_clause3308 = new BitSet(new long[]{0x0010004000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_LEFT_in_join_sub_clause3312 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L,0x0000000000000040L});
    public static final BitSet FOLLOW_RIGHT_in_join_sub_clause3332 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L,0x0000000000000040L});
    public static final BitSet FOLLOW_FULL_in_join_sub_clause3351 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L,0x0000000000000040L});
    public static final BitSet FOLLOW_OUTER_in_join_sub_clause3357 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_join_item_in_join_sub_clause3360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_join_item_in_join_sub_clause3370 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_JOIN_ITEM_in_join_item3383 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_join_item3385 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_join_group_by_clause_in_join_item3387 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BY_in_join_group_by_clause3414 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_join_group_by_expr_in_join_group_by_clause3418 = new BitSet(new long[]{0x900101108A800008L,0x76010004004A0000L,0x0000000020023028L});
    public static final BitSet FOLLOW_col_range_in_join_group_by_expr3443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_join_group_by_expr3449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_join_group_by_expr3455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNION_in_union_clause3481 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ONSCHEMA_in_union_clause3485 = new BitSet(new long[]{0x46080121004A4000L,0x000400C010000800L,0x0000000000000020L});
    public static final BitSet FOLLOW_rel_list_in_union_clause3492 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_in_foreach_clause3528 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_foreach_clause3530 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000003L});
    public static final BitSet FOLLOW_foreach_plan_in_foreach_clause3532 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_PLAN_SIMPLE_in_foreach_plan3568 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_generate_clause_in_foreach_plan3570 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_PLAN_COMPLEX_in_foreach_plan3579 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_blk_in_foreach_plan3581 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_nested_command_in_nested_blk3592 = new BitSet(new long[]{0x0000008000000000L,0x0000000000000000L,0x000000000000C000L});
    public static final BitSet FOLLOW_generate_clause_in_nested_blk3595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NESTED_CMD_in_nested_command3617 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_nested_command3619 = new BitSet(new long[]{0x0200002100420000L,0x0000000000000800L,0x0000000000010000L});
    public static final BitSet FOLLOW_nested_op_in_nested_command3621 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NESTED_CMD_ASSI_in_nested_command3640 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_nested_command3642 = new BitSet(new long[]{0x900101108A800000L,0x56010004004A0000L,0x0000000020023028L});
    public static final BitSet FOLLOW_expr_in_nested_command3644 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_nested_proj_in_nested_op3666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_filter_in_nested_op3674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_sort_in_nested_op3682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_distinct_in_nested_op3691 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_limit_in_nested_op3699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_cross_in_nested_op3707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_foreach_in_nested_op3715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NESTED_PROJ_in_nested_proj3739 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_col_ref_in_nested_proj3751 = new BitSet(new long[]{0x0000010002000000L,0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_col_ref_in_nested_proj3766 = new BitSet(new long[]{0x0000010002000008L,0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_FILTER_in_nested_filter3819 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_filter3821 = new BitSet(new long[]{0x0000000000000020L,0x00007F00000005FCL,0x0000000000020008L});
    public static final BitSet FOLLOW_cond_in_nested_filter3823 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ORDER_in_nested_sort3857 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_sort3859 = new BitSet(new long[]{0x0000010002000000L,0x2000000400000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_order_by_clause_in_nested_sort3861 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000000000014L});
    public static final BitSet FOLLOW_func_clause_in_nested_sort3863 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DISTINCT_in_nested_distinct3893 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_distinct3895 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LIMIT_in_nested_limit3928 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_limit3930 = new BitSet(new long[]{0x900101108A800000L,0x56010004004A0000L,0x0000000020023028L});
    public static final BitSet FOLLOW_INTEGER_in_nested_limit3934 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expr_in_nested_limit3945 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CROSS_in_nested_cross3979 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_list_in_nested_cross3981 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_in_nested_foreach4013 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_foreach4015 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_generate_clause_in_nested_foreach4017 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_GENERATE_in_generate_clause4046 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_flatten_generated_item_in_generate_clause4050 = new BitSet(new long[]{0x900101128A800008L,0x76010004004A0000L,0x0000000020023028L});
    public static final BitSet FOLLOW_col_ref_in_nested_op_input4116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_proj_in_nested_op_input4127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_op_input_list4153 = new BitSet(new long[]{0x0000010002000002L,0x0000000000000000L,0x0000000000010020L});
    public static final BitSet FOLLOW_STREAM_in_stream_clause4178 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_stream_clause4180 = new BitSet(new long[]{0x0000000040000000L,0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_EXECCOMMAND_in_stream_clause4184 = new BitSet(new long[]{0x0000000000000048L});
    public static final BitSet FOLLOW_IDENTIFIER_in_stream_clause4208 = new BitSet(new long[]{0x0000000000000048L});
    public static final BitSet FOLLOW_as_clause_in_stream_clause4251 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MAPREDUCE_in_mr_clause4279 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_mr_clause4281 = new BitSet(new long[]{0x0000000000000000L,0x0000004000400000L});
    public static final BitSet FOLLOW_path_list_in_mr_clause4283 = new BitSet(new long[]{0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_store_clause_in_mr_clause4295 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_load_clause_in_mr_clause4305 = new BitSet(new long[]{0x0000000040000008L});
    public static final BitSet FOLLOW_EXECCOMMAND_in_mr_clause4312 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SPLIT_in_split_clause4332 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_split_clause4340 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_split_branch_in_split_clause4358 = new BitSet(new long[]{0x0000000000000008L,0x0000000000001000L,0x0000000000400000L});
    public static final BitSet FOLLOW_split_otherwise_in_split_clause4361 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SPLIT_BRANCH_in_split_branch4390 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_split_branch4392 = new BitSet(new long[]{0x0000000000000020L,0x00007F00000005FCL,0x0000000000020008L});
    public static final BitSet FOLLOW_cond_in_split_branch4394 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OTHERWISE_in_split_otherwise4428 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_split_otherwise4430 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_alias_col_ref_in_col_ref4451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dollar_col_ref_in_col_ref4459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GROUP_in_alias_col_ref4476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_alias_col_ref4487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOLLARVAR_in_dollar_col_ref4506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_const_expr4525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_scalar_in_literal4543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_map_in_literal4553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bag_in_literal4563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tuple_in_literal4573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_num_scalar_in_scalar4591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_scalar4601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NULL_in_scalar4612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_scalar4622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_scalar4632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_num_scalar4657 = new BitSet(new long[]{0x1001001008000000L});
    public static final BitSet FOLLOW_INTEGER_in_num_scalar4670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LONGINTEGER_in_num_scalar4684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOATNUMBER_in_num_scalar4699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLENUMBER_in_num_scalar4714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MAP_VAL_in_map4747 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_keyvalue_in_map4751 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_KEY_VAL_PAIR_in_keyvalue4778 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_map_key_in_keyvalue4780 = new BitSet(new long[]{0x9001001088000000L,0x0201000000400000L,0x0000000020021000L});
    public static final BitSet FOLLOW_literal_in_keyvalue4782 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_map_key4802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BAG_VAL_in_bag4824 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_tuple_in_bag4828 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_TUPLE_VAL_in_tuple4860 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_literal_in_tuple4864 = new BitSet(new long[]{0x9001001088000008L,0x0201000000400000L,0x0000000020021000L});
    public static final BitSet FOLLOW_rel_str_op_in_eid4889 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IMPORT_in_eid4899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RETURNS_in_eid4909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEFINE_in_eid4919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LOAD_in_eid4929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FILTER_in_eid4939 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOREACH_in_eid4949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MATCHES_in_eid4959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ORDER_in_eid4969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DISTINCT_in_eid4979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COGROUP_in_eid4989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_JOIN_in_eid4999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CROSS_in_eid5009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNION_in_eid5019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SPLIT_in_eid5029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTO_in_eid5039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_eid5049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ALL_in_eid5059 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AS_in_eid5069 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BY_in_eid5079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_USING_in_eid5089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INNER_in_eid5099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OUTER_in_eid5109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARALLEL_in_eid5119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARTITION_in_eid5129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GROUP_in_eid5139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AND_in_eid5149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OR_in_eid5159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_eid5169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GENERATE_in_eid5179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLATTEN_in_eid5189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EVAL_in_eid5199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASC_in_eid5209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESC_in_eid5219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOLEAN_in_eid5229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_eid5239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LONG_in_eid5249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_eid5259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLE_in_eid5269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHARARRAY_in_eid5279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BYTEARRAY_in_eid5289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BAG_in_eid5299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TUPLE_in_eid5309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MAP_in_eid5319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IS_in_eid5329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NULL_in_eid5339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_eid5349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_eid5359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STREAM_in_eid5369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_THROUGH_in_eid5379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STORE_in_eid5389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MAPREDUCE_in_eid5399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHIP_in_eid5409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CACHE_in_eid5419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INPUT_in_eid5429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OUTPUT_in_eid5439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STDERROR_in_eid5449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STDIN_in_eid5459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STDOUT_in_eid5469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LIMIT_in_eid5479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SAMPLE_in_eid5489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFT_in_eid5499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RIGHT_in_eid5509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FULL_in_eid5519 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_eid5529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOBAG_in_eid5539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOMAP_in_eid5549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOTUPLE_in_eid5559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_eq_in_rel_op5571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_ne_in_rel_op5582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_gt_in_rel_op5593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_gte_in_rel_op5604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_lt_in_rel_op5615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_lte_in_rel_op5626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_MATCHES_in_rel_op5637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_EQ_in_rel_str_op5728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_NE_in_rel_str_op5735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_GT_in_rel_str_op5742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_LT_in_rel_str_op5749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_GTE_in_rel_str_op5756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_LTE_in_rel_str_op5763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_MATCHES_in_rel_str_op5770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_in_synpred117_LogicalPlanGenerator2893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LONGINTEGER_in_synpred118_LogicalPlanGenerator2903 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLENUMBER_in_synpred119_LogicalPlanGenerator2955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_join_item_in_synpred138_LogicalPlanGenerator3308 = new BitSet(new long[]{0x0010004000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_set_in_synpred138_LogicalPlanGenerator3310 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L,0x0000000000000040L});
    public static final BitSet FOLLOW_OUTER_in_synpred138_LogicalPlanGenerator3357 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_join_item_in_synpred138_LogicalPlanGenerator3360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_in_synpred155_LogicalPlanGenerator3934 = new BitSet(new long[]{0x0000000000000002L});

}